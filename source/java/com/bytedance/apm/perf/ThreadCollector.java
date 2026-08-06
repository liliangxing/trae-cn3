package com.bytedance.apm.perf;

import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.constant.SlardarSettingsConsts;
import com.bytedance.apm.data.pipeline.CommonDataPipeline;
import com.bytedance.apm.data.type.PerfData;
import com.bytedance.apm.entity.UploadInfo;
import com.bytedance.apm.thread.AsyncEventManager;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class ThreadCollector extends AbstractPerfCollector {
    private static final long DEFAULT_COLLECT_INTERVAL_MINUTE = 10;
    private static final long DEFAULT_DELAY_CHECK_MS = 1200000;
    public static final String KEY_CPU_COUNT = "cpu_count";
    public static final String KEY_JAVA_THREAD_COUNT = "java_thread_count";
    public static final String KEY_THREAD_DETAIL = "thread_detail";
    public static final String KEY_THREAD_SCENE = "scene";
    public static final String KEY_TOTAL_THREAD_COUNT = "total_thread_count";
    private long collectIntervalMs = UploadInfo.DEFAULT_SEND_DURATION;
    private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
    private static boolean isReady = false;
    private static final int PERF_THREAD_COUNT_DEFAULT_THRESHOLD = 300;
    private static int threadCountThreshold = PERF_THREAD_COUNT_DEFAULT_THRESHOLD;
    private static boolean isThreadHit = false;
    private static boolean isThreadUploadHit = false;

    @Override // com.bytedance.apm.perf.AbstractPerfCollector
    protected boolean isTimerMonitor() {
        return true;
    }

    public ThreadCollector() {
        this.mCollectorSettingKey = "thread";
    }

    @Override // com.bytedance.apm.perf.AbstractPerfCollector
    protected long workInternalMs() {
        return this.collectIntervalMs;
    }

    @Override // com.bytedance.apm.perf.AbstractPerfCollector
    public void onReady() {
        super.onReady();
        isReady = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.apm.perf.AbstractPerfCollector
    public void doConfig(JSONObject jSONObject) {
        super.doConfig(jSONObject);
        isThreadHit = jSONObject.optInt("enable_thread_collect", 0) == 1;
        isThreadUploadHit = jSONObject.optInt("enable_upload", 0) == 1;
        threadCountThreshold = jSONObject.optInt(SlardarSettingsConsts.PERF_KEY_THREAD_COUNT_INTERVAL, PERF_THREAD_COUNT_DEFAULT_THRESHOLD);
        this.collectIntervalMs = jSONObject.optLong("collect_interval", 10L) * 60000;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.apm.perf.AbstractPerfCollector
    public void onStart() {
        super.onStart();
        if (isThreadHit && isThreadUploadHit && System.currentTimeMillis() - ApmContext.getInitTimeStamp() > 1200000) {
            collect();
        }
    }

    private void collect() {
        reportThreadCount(null, false);
    }

    public static int reportThreadCount(final String str, final boolean z) {
        int i;
        try {
            i = new File("/proc/self/task/").list().length;
        } catch (Throwable unused) {
            i = 0;
        }
        if (i == 0) {
            return 0;
        }
        final ThreadGroup threadGroup = Looper.getMainLooper().getThread().getThreadGroup();
        while (threadGroup.getParent() != null) {
            threadGroup = threadGroup.getParent();
        }
        final int[] iArr = {threadGroup.activeCount()};
        final int i2 = i;
        AsyncEventManager.getInstance().post(new Runnable() { // from class: com.bytedance.apm.perf.ThreadCollector.1
            @Override // java.lang.Runnable
            public void run() {
                int i3;
                if (z || iArr[0] < ThreadCollector.threadCountThreshold || !ThreadCollector.isReady) {
                    try {
                        JSONObject buildJson = ThreadCollector.buildJson(str, i2, iArr[0], null);
                        if (buildJson != null) {
                            CommonDataPipeline.getInstance().handle(new PerfData("thread", null, null, buildJson));
                            return;
                        }
                        return;
                    } catch (Exception unused2) {
                        return;
                    }
                }
                int[] iArr2 = iArr;
                int i4 = iArr2[0];
                Thread[] threadArr = new Thread[i4 + (i4 / 2)];
                iArr2[0] = threadGroup.enumerate(threadArr);
                StringBuilder sb = new StringBuilder();
                int i5 = 0;
                while (true) {
                    i3 = iArr[0];
                    if (i5 >= i3) {
                        try {
                            break;
                        } catch (Throwable unused3) {
                            return;
                        }
                    }
                    String name = threadArr[i5].getName();
                    if (!TextUtils.isEmpty(name)) {
                        sb.append(name);
                        sb.append(",");
                    }
                    i5++;
                }
                JSONObject buildJson2 = ThreadCollector.buildJson(str, i2, i3, sb.toString());
                if (buildJson2 != null) {
                    CommonDataPipeline.getInstance().handle(new PerfData("thread", null, null, buildJson2));
                }
            }
        });
        return (i << 16) + iArr[0];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject buildJson(String str, int i, int i2, String str2) {
        JSONObject jSONObject = new JSONObject();
        if (i > 0) {
            try {
                jSONObject.put(KEY_TOTAL_THREAD_COUNT, i);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        jSONObject.put(KEY_JAVA_THREAD_COUNT, i2);
        if (!TextUtils.isEmpty(str)) {
            jSONObject.put("scene", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            jSONObject.put(KEY_THREAD_DETAIL, str2);
        }
        jSONObject.put("is_main_process", ApmContext.isMainProcess());
        jSONObject.put(KEY_CPU_COUNT, CPU_COUNT);
        jSONObject.put("process_name", ApmContext.getCurrentProcessName());
        return jSONObject;
    }
}
