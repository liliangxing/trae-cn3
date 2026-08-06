package com.bytedance.apm6.java_alloc;

import com.bytedance.apm.constant.ExceptionConsts;
import com.bytedance.apm.constant.ExceptionTypeName;
import com.bytedance.apm.data.pipeline.CommonDataPipeline;
import com.bytedance.apm.data.type.ExceptionLogData;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.java_alloc.model.ReportData;
import com.bytedance.apm6.java_alloc.model.ReportInfo;
import com.bytedance.apm6.perf.base.PerfFilterManager;
import com.bytedance.apm6.service.ServiceManager;
import com.bytedance.apm6.util.log.Logger;
import com.bytedance.applog.throttle.CongestionController;
import com.bytedance.monitor.collector.MonitorJni;
import com.bytedance.monitor.collector.PerfMonitorManager;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class JavaAllocCollector {
    private static final int MAGIC_NUM = 123457;
    public static final int MAX_BYTE_LEN = 4096;
    private static final int MEM_INIT_FAILED = 0;
    private static final int MEM_INIT_SUCC = 1;
    private static final int MEM_UNINIT = -1;
    private static final String TAG = "APM-JavaAlloc";
    public static final long UNKNOWN_VALUE = -1;
    private static int sJavaMemState = -1;
    private static int sJavaMonitorState = -1;
    private JavaAllocConfig config;
    public JavaAllocConfig forcedConfig;
    private volatile boolean initialized;

    private JavaAllocCollector() {
    }

    public static JavaAllocCollector getInstance() {
        return InnerHolder.instance;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    private static class InnerHolder {
        private static final JavaAllocCollector instance = new JavaAllocCollector();

        private InnerHolder() {
        }
    }

    public void init() {
        if (this.initialized) {
            return;
        }
        JavaAllocConfigService javaAllocConfigService = (JavaAllocConfigService) ServiceManager.getService(JavaAllocConfigService.class);
        if (javaAllocConfigService != null) {
            updateConfig(javaAllocConfigService.getConfig());
        }
        isInitJavaMem();
        this.initialized = true;
    }

    public void updateConfig(JavaAllocConfig javaAllocConfig) {
        if (javaAllocConfig == null) {
            return;
        }
        this.config = javaAllocConfig;
    }

    public JavaAllocConfig getConfig() {
        JavaAllocConfig javaAllocConfig = this.forcedConfig;
        return javaAllocConfig != null ? javaAllocConfig : this.config;
    }

    public boolean enableAllocateMonitor(String str) {
        if (getConfig() == null || !isInitJavaMonitor()) {
            return false;
        }
        if (str == null) {
            str = "unknown";
        }
        return MonitorJni.startOrStopAllocatedMonitor(true, str);
    }

    public boolean disableAllocateMonitor() {
        if (isInitJavaMonitor()) {
            return MonitorJni.startOrStopAllocatedMonitor(false, (String) null);
        }
        return false;
    }

    public boolean initAllocateMonitor() {
        return isInitJavaMonitor();
    }

    public boolean deinitAllocateMonitor() {
        if (1 == sJavaMonitorState && isInitJavaMem() && MonitorJni.setEnableAllocatedMonitor(false, 0, 0, CongestionController.MAX_REQUEST_FREQUENCY_REALTIME, 2147483647L, MonitorJni.class.getClassLoader())) {
            sJavaMonitorState = -1;
        }
        return sJavaMonitorState == -1;
    }

    private boolean isInitJavaMem() {
        JavaAllocConfig config = getConfig();
        if (config == null || !config.enable_collect) {
            return false;
        }
        if (-1 == sJavaMemState && PerfMonitorManager.isSoLoaded()) {
            sJavaMemState = MonitorJni.initJavaMem() ? 1 : 0;
        }
        return sJavaMemState == 1;
    }

    private boolean isInitJavaMonitor() {
        JavaAllocConfig config = getConfig();
        if (config == null || !config.enable_collect) {
            return false;
        }
        if (-1 == sJavaMonitorState && isInitJavaMem()) {
            sJavaMonitorState = MonitorJni.setEnableAllocatedMonitor(true, config.collect_per_thousand_alloc, config.dump_per_thousand_collect, config.threshold_alloc_frequency, config.threshold_alloc_size, MonitorJni.class.getClassLoader()) ? 1 : 0;
        }
        return sJavaMonitorState == 1;
    }

    public long getBytesAllocatedEver() {
        if (isInitJavaMem()) {
            return MonitorJni.getBytesAllocatedEver();
        }
        return -1L;
    }

    public long getObjectsAllocatedEver() {
        if (isInitJavaMem()) {
            return MonitorJni.getObjectsAllocatedEver();
        }
        return -1L;
    }

    public long getGcCount() {
        if (isInitJavaMem()) {
            return MonitorJni.getGCCount();
        }
        return -1L;
    }

    public long getGcTime() {
        if (isInitJavaMem()) {
            return MonitorJni.getGCTime();
        }
        return -1L;
    }

    public long getBlockingGcCount() {
        if (isInitJavaMem()) {
            return MonitorJni.getBlockGCCount();
        }
        return -1L;
    }

    public long getBlockingGcTime() {
        if (isInitJavaMem()) {
            return MonitorJni.getBlockGCTime();
        }
        return -1L;
    }

    private ByteBuffer getReportInfoInner() {
        if (isInitJavaMem()) {
            return MonitorJni.getAllocReportInfo();
        }
        return null;
    }

    public void clearAllocateInfo() {
        if (isInitJavaMem()) {
            MonitorJni.clearAllocateInfo();
        }
    }

    public long getMinorFaults() {
        if (PerfMonitorManager.isSoLoaded()) {
            return MonitorJni.getMinorFaults();
        }
        return -1L;
    }

    public long getMajorFaults() {
        if (PerfMonitorManager.isSoLoaded()) {
            return MonitorJni.getMajorFaults();
        }
        return -1L;
    }

    private static String getString(ByteBuffer byteBuffer, byte[] bArr) {
        return new String(bArr, 0, fillStringBytes(byteBuffer, bArr), StandardCharsets.US_ASCII);
    }

    public static int fillStringBytes(ByteBuffer byteBuffer, byte[] bArr) {
        int i = byteBuffer.getInt();
        if (i > bArr.length) {
            byteBuffer.position((byteBuffer.position() + i) - bArr.length);
            byteBuffer.get(bArr, 0, bArr.length);
            return bArr.length;
        }
        byteBuffer.get(bArr, 0, i);
        return i;
    }

    public void getReportInfo(IRecordReader iRecordReader) {
        ByteBuffer reportInfoInner;
        if (!PerfMonitorManager.isSoLoaded() || iRecordReader == null || (reportInfoInner = getReportInfoInner()) == null) {
            return;
        }
        reportInfoInner.order(ByteOrder.LITTLE_ENDIAN);
        reportInfoInner.position(0);
        if (reportInfoInner.getInt() != MAGIC_NUM) {
            return;
        }
        byte[] bArr = new byte[4096];
        Trace trace = new Trace();
        long j = reportInfoInner.getLong();
        String string = getString(reportInfoInner, bArr);
        int i = reportInfoInner.getInt();
        int i2 = reportInfoInner.getInt();
        int i3 = reportInfoInner.getInt();
        int i4 = reportInfoInner.getInt();
        long j2 = reportInfoInner.getLong();
        long j3 = reportInfoInner.getLong();
        long j4 = reportInfoInner.getLong();
        long j5 = reportInfoInner.getLong();
        int i5 = reportInfoInner.getInt();
        byte[] bArr2 = bArr;
        iRecordReader.onHeadInfo(string, j4, j5, i5, new JavaAllocConfig(true, true, i, i2, i3, i4), j2, j3);
        int i6 = 0;
        while (i6 < i5) {
            byte[] bArr3 = bArr2;
            String string2 = getString(reportInfoInner, bArr3);
            int i7 = reportInfoInner.getInt();
            int i8 = reportInfoInner.getInt();
            int i9 = reportInfoInner.getInt();
            trace.setStream(reportInfoInner);
            if (!iRecordReader.onItem(string2, i8, i9, trace, i7)) {
                break;
            }
            i6++;
            bArr2 = bArr3;
        }
        MonitorJni.releaseByteBuffer(j);
    }

    public ReportData getReportData() {
        DefaultRecordReader defaultRecordReader = new DefaultRecordReader();
        getReportInfo(defaultRecordReader);
        return new ReportData(defaultRecordReader.result, defaultRecordReader.getDuration(), defaultRecordReader.getConfig());
    }

    public void collectAndReport() {
        if (getConfig().enable_upload && getConfig().enable_collect) {
            ReportData reportData = getReportData();
            if (reportData == null || reportData.infoList == null || reportData.infoList.size() == 0) {
                if (ApmContext.isDebugMode()) {
                    Logger.m122i(TAG, "empty report info");
                    return;
                }
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            for (ReportInfo reportInfo : reportData.infoList) {
                try {
                    JSONObject perfFiltersJson = PerfFilterManager.getInstance().getPerfFiltersJson();
                    perfFiltersJson.put("is_main_process", ApmContext.isMainProcess());
                    perfFiltersJson.put("process_name", ApmContext.getCurrentProcessName());
                    JSONObject packJson = reportInfo.packJson(perfFiltersJson);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("alloc_duration", reportData.duration);
                    if (reportData.config != null) {
                        Iterator<String> keys = reportData.config.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            jSONObject.put(next, reportData.config.opt(next));
                        }
                    }
                    packJson.put("custom", jSONObject);
                    packJson.put("event_type", reportInfo.exceptionType == 1 ? ExceptionTypeName.EXCEPTION_EVENT_TYPE_FREQUENT_OBJECT : ExceptionTypeName.EXCEPTION_EVENT_TYPE_LARGE_OBJECT);
                    ExceptionLogData exceptionLogData = new ExceptionLogData(ExceptionConsts.MONITOR_TYPE_ALLOC, packJson, currentTimeMillis);
                    exceptionLogData.forceSample();
                    CommonDataPipeline.getInstance().handle(exceptionLogData);
                } catch (JSONException unused) {
                }
            }
        }
    }
}
