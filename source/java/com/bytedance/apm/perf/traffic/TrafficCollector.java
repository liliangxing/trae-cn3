package com.bytedance.apm.perf.traffic;

import android.app.Activity;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.MonitorCoreExceptionManager;
import com.bytedance.apm.constant.SlardarSettingsConsts;
import com.bytedance.apm.data.type.PerfData;
import com.bytedance.apm.doctor.DoctorDataUtil;
import com.bytedance.apm.entity.UploadInfo;
import com.bytedance.apm.listener.ITrafficCallback;
import com.bytedance.apm.logging.ApmAlogHelper;
import com.bytedance.apm.logging.Logger;
import com.bytedance.apm.perf.AbstractPerfCollector;
import com.bytedance.apm.perf.traffic.BizTrafficStats;
import com.bytedance.apm.samplers.SamplerHelper;
import com.bytedance.apm.thread.AsyncEventManager;
import com.bytedance.apm.util.JsonUtils;
import com.bytedance.apm.util.Pair;
import com.bytedance.apm.util.TopK;
import com.bytedance.apm6.commonevent.CommonEventDeliverer;
import com.bytedance.apm6.commonevent.model.GeneralLegacyEvent;
import com.bytedance.apm6.util.cache.LimitedQueue;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class TrafficCollector extends AbstractPerfCollector {
    private static int BACK_APP = 2;
    private static final int ERROR_RESULT = -1;
    private static final String EXCEPTION_TYPE = "TrafficException";
    private static int FRONT_APP = 1;
    private static int FRONT_UNKNOWN = 0;
    private static final int MAX_SIZE = 20;
    private static final String SPLIT = "$";
    private static final String TAG = "APM-Traffic-Detail ";
    private static final String TRAFFIC_HIGH_FREQ = "TrafficHighTreq";
    private static final String TRAFFIC_TOPK = "TrafficTopK";
    private static LimitedQueue<GeneralLegacyEvent> cache = new LimitedQueue<>(20);
    private static LimitedQueue<String> keys = new LimitedQueue<>(20);
    private static String sBgType = "bg_never_front";
    private static ITrafficCallback trafficCallback;
    private JSONObject config;
    private long mBizTotalBytes;
    private long mHighFreqCountThreshold;
    private long mInitTrafficBytes;
    private int mLastFront;
    private long mLastMobileBackBytes;
    private long mLastMobileFrontBytes;
    private long mLastTotalBytes;
    private long mLastTs;
    private long mLastWIFIBackBytes;
    private long mLastWIFIFrontBytes;
    private long mTraffic10minutesBackThresholdBytes;
    private long mTraffic10minutesThresholdBytes;
    private TrafficStatisticWrapper mTrafficStatisticWrapper;
    private Map<String, Pair<Long, Long>> metricMobileTrafficMap;
    private Map<String, Pair<Long, Long>> metricTrafficMap;
    private Map<String, Pair<Long, Long>> metricWifiTrafficMap;
    private long recordUsageThreshold;

    @Override // com.bytedance.apm.perf.AbstractPerfCollector
    protected boolean isTimerMonitor() {
        return true;
    }

    @Override // com.bytedance.apm.perf.AbstractPerfCollector
    protected long workInternalMs() {
        return UploadInfo.DEFAULT_SEND_DURATION;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static class Holder {
        private static final TrafficCollector sInstance = new TrafficCollector();

        private Holder() {
        }
    }

    public static TrafficCollector getInstance() {
        return Holder.sInstance;
    }

    private TrafficCollector() {
        this.mTraffic10minutesThresholdBytes = 500000000L;
        this.recordUsageThreshold = 0L;
        this.mTraffic10minutesBackThresholdBytes = 1L;
        this.mLastTotalBytes = -1L;
        this.mLastMobileBackBytes = 0L;
        this.mLastMobileFrontBytes = 0L;
        this.mLastWIFIBackBytes = 0L;
        this.mLastWIFIFrontBytes = 0L;
        this.mInitTrafficBytes = 0L;
        this.mLastFront = FRONT_UNKNOWN;
        this.mCollectorSettingKey = "traffic";
        TrafficStatisticWrapper trafficStatisticWrapper = TrafficStatisticWrapper.getInstance();
        this.mTrafficStatisticWrapper = trafficStatisticWrapper;
        trafficStatisticWrapper.onStatusChange(isBackground());
    }

    public static void setCallback(ITrafficCallback iTrafficCallback) {
        trafficCallback = iTrafficCallback;
    }

    public synchronized void startMetric(final String str, final boolean z) {
        AsyncEventManager.getInstance().post(new Runnable() { // from class: com.bytedance.apm.perf.traffic.TrafficCollector.1
            @Override // java.lang.Runnable
            public void run() {
                if (TrafficCollector.this.metricTrafficMap == null) {
                    TrafficCollector.this.metricTrafficMap = new HashMap();
                }
                long currentTimeMillis = System.currentTimeMillis();
                TrafficCollector.this.metricTrafficMap.put(str, new Pair(Long.valueOf(currentTimeMillis), Long.valueOf(TrafficCollector.this.mTrafficStatisticWrapper.getTotalBytes())));
                if (TrafficCollector.this.metricWifiTrafficMap == null) {
                    TrafficCollector.this.metricWifiTrafficMap = new HashMap();
                }
                TrafficCollector.this.metricWifiTrafficMap.put(str, new Pair(Long.valueOf(currentTimeMillis), Long.valueOf(TrafficCollector.this.mTrafficStatisticWrapper.getWifiBytes())));
                if (TrafficCollector.this.metricMobileTrafficMap == null) {
                    TrafficCollector.this.metricMobileTrafficMap = new HashMap();
                }
                TrafficCollector.this.metricMobileTrafficMap.put(str, new Pair(Long.valueOf(currentTimeMillis), Long.valueOf(TrafficCollector.this.mTrafficStatisticWrapper.getMobileBytes())));
                if (z) {
                    BizTrafficStats.getInstance().initCustomMetricBizTrafficStats(str);
                }
            }
        });
    }

    public synchronized void stopMetric(final String str) {
        AsyncEventManager.getInstance().post(new Runnable() { // from class: com.bytedance.apm.perf.traffic.TrafficCollector.2
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:44:0x01fb A[Catch: Exception -> 0x0228, TryCatch #1 {Exception -> 0x0228, blocks: (B:12:0x00ce, B:14:0x00e4, B:16:0x00ea, B:18:0x00f8, B:19:0x00fc, B:21:0x0102, B:23:0x011e, B:26:0x0129, B:29:0x01a2, B:31:0x01b8, B:34:0x01c3, B:36:0x01d1, B:39:0x01e0, B:41:0x01e6, B:42:0x01f5, B:44:0x01fb, B:46:0x020a, B:50:0x021a, B:53:0x01f2), top: B:11:0x00ce }] */
            /* JADX WARN: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                if (TrafficCollector.this.metricTrafficMap == null || !TrafficCollector.this.metricTrafficMap.containsKey(str)) {
                    return;
                }
                long longValue = ((Long) ((Pair) TrafficCollector.this.metricTrafficMap.get(str)).first).longValue();
                long totalBytes = TrafficCollector.this.mTrafficStatisticWrapper.getTotalBytes() - ((Long) ((Pair) TrafficCollector.this.metricTrafficMap.get(str)).second).longValue();
                long wifiBytes = TrafficCollector.this.mTrafficStatisticWrapper.getWifiBytes() - ((Long) ((Pair) TrafficCollector.this.metricWifiTrafficMap.get(str)).second).longValue();
                long mobileBytes = TrafficCollector.this.mTrafficStatisticWrapper.getMobileBytes() - ((Long) ((Pair) TrafficCollector.this.metricMobileTrafficMap.get(str)).second).longValue();
                TrafficCollector.this.metricTrafficMap.remove(str);
                TrafficCollector.this.metricWifiTrafficMap.remove(str);
                TrafficCollector.this.metricMobileTrafficMap.remove(str);
                if (totalBytes < 0) {
                    BizTrafficStats.getInstance().clearCustomMetricStats(str);
                    return;
                }
                Map<String, BizTrafficStats.BizData> customMetricBizStats = BizTrafficStats.getInstance().getCustomMetricBizStats(str);
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(ApmTrafficStats.SP_TRAFFIC_INIT_TIME, longValue);
                    jSONObject.put(ApmTrafficStats.SP_TRAFFIC_ACCU_TIME, System.currentTimeMillis());
                    if (customMetricBizStats != null && customMetricBizStats.size() > 0) {
                        JSONObject jSONObject2 = new JSONObject();
                        JSONArray jSONArray = new JSONArray();
                        try {
                            Iterator<Map.Entry<String, BizTrafficStats.BizData>> it = customMetricBizStats.entrySet().iterator();
                            while (it.hasNext()) {
                                JSONObject jSONObject3 = it.next().getValue().toJSONObject();
                                jSONObject3.put(ApmTrafficStats.KEY_TRAFFIC_CATEGORY, str);
                                jSONArray.put(jSONObject3);
                            }
                            jSONObject2.put("usage", jSONArray);
                            jSONObject.put("detail", jSONObject2);
                        } catch (JSONException unused) {
                        }
                    }
                    BizTrafficStats.getInstance().clearCustomMetricStats(str);
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put(str, totalBytes);
                    jSONObject4.put(str + TrafficCollector.SPLIT + "wifi", wifiBytes);
                    jSONObject4.put(str + TrafficCollector.SPLIT + "mobile", mobileBytes);
                    PerfData perfData = new PerfData();
                    perfData.serviceName(TrafficCollector.this.mCollectorSettingKey).extraValues(jSONObject4).extraLog(jSONObject);
                    GeneralLegacyEvent generalLegacyEvent = new GeneralLegacyEvent(perfData.getTypeLabel(), perfData.packLog());
                    if (TrafficCollector.this.config == null) {
                        TrafficCollector.cache.push(generalLegacyEvent);
                        TrafficCollector.keys.push(str);
                        if (ApmContext.isDebugMode()) {
                            Logger.m86d("Traffic", "config==null:");
                            return;
                        }
                        return;
                    }
                    boolean perfAllowSwitch = SamplerHelper.getPerfAllowSwitch(TrafficCollector.this.mCollectorSettingKey);
                    boolean z = true;
                    if (!perfAllowSwitch && TrafficCollector.this.config.optInt(str, 0) != 1) {
                        if (ApmContext.isDebugMode()) {
                            DoctorDataUtil.onReceivedEvent(generalLegacyEvent.getLogType(), generalLegacyEvent.getLogJson(), false);
                        }
                        if (ApmContext.isDebugMode()) {
                            return;
                        }
                        String[] strArr = new String[1];
                        StringBuilder append = new StringBuilder().append("isSample:");
                        if (!perfAllowSwitch && TrafficCollector.this.config.optInt(str, 0) != 1) {
                            z = false;
                        }
                        strArr[0] = append.append(z).toString();
                        Logger.m86d("Traffic", strArr);
                        return;
                    }
                    CommonEventDeliverer.monitorLegacyEvent(generalLegacyEvent);
                    if (ApmContext.isDebugMode()) {
                    }
                } catch (Exception e) {
                    MonitorCoreExceptionManager.getInstance().ensureNotReachHere(e, "apm_error");
                }
            }
        });
    }

    @Override // com.bytedance.apm.perf.AbstractPerfCollector
    protected void onInit() {
        TrafficCollector trafficCollector;
        String str;
        SharedPreferences sharedPreferences = ApmContext.getContext().getSharedPreferences(ApmTrafficStats.SP_TRAFFIC, 0);
        long j = sharedPreferences.getLong("init", -1L);
        long j2 = sharedPreferences.getLong(ApmTrafficStats.SP_TRAFFIC_INIT_TIME, 0L);
        if (j > -1) {
            long j3 = sharedPreferences.getLong("usage", 0L);
            long j4 = sharedPreferences.getLong(ApmTrafficStats.SP_TRAFFIC_ACCU_TIME, 0L);
            long j5 = j3 - j;
            if (j5 > 0) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(ApmTrafficStats.KEY_TRAFFIC_TOTAL, j5);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(ApmTrafficStats.KEY_TRAFFIC_TOTAL_DURATION, ((j4 - j2) / 1000) / 60);
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put(ApmTrafficStats.SP_TRAFFIC_INIT_TIME, j2);
                    jSONObject3.put(ApmTrafficStats.SP_TRAFFIC_ACCU_TIME, j4);
                    jSONObject3.put(ApmTrafficStats.KEY_BIZ_STATS, sharedPreferences.getLong(ApmTrafficStats.KEY_BIZ_STATS, 0L));
                    jSONObject3.put("init", j);
                    str = "usage";
                    try {
                        jSONObject3.put(str, j3);
                        String string = sharedPreferences.getString(ApmTrafficStats.KEY_TRAFFIC_BIZ_RECORD_JSON, "");
                        if (string != "") {
                            JSONObject jSONObject4 = new JSONObject();
                            jSONObject4.put(str, new JSONArray(string));
                            jSONObject3.put("detail", jSONObject4);
                        }
                        PerfData perfData = new PerfData();
                        trafficCollector = this;
                        try {
                            perfData.serviceName(trafficCollector.mCollectorSettingKey).extraValues(jSONObject).extraStatus(jSONObject2).extraLog(jSONObject3);
                            ApmAlogHelper.feedbackI(TAG, "Init");
                            if (ApmAlogHelper.isFeedbackALogEnabled()) {
                                ApmAlogHelper.feedbackI(TAG, JsonUtils.deepCopy(perfData.packLog()).toString());
                            }
                            trafficCollector.sendPerfLog(perfData);
                            ITrafficCallback iTrafficCallback = trafficCallback;
                            if (iTrafficCallback != null) {
                                iTrafficCallback.onResult(j5);
                            }
                        } catch (JSONException unused) {
                        }
                    } catch (JSONException unused2) {
                        trafficCollector = this;
                    }
                } catch (JSONException unused3) {
                }
            }
            trafficCollector = this;
            str = "usage";
        } else {
            trafficCollector = this;
            str = "usage";
        }
        trafficCollector.mInitTrafficBytes = trafficCollector.mTrafficStatisticWrapper.getTotalBytes();
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putLong("init", trafficCollector.mInitTrafficBytes);
        edit.putLong(ApmTrafficStats.SP_TRAFFIC_INIT_TIME, System.currentTimeMillis());
        edit.putLong(str, 0L);
        edit.apply();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:102:0x039f  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0357  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0370  */
    @Override // com.bytedance.apm.perf.AbstractPerfCollector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onStart() {
        TrafficCollector trafficCollector;
        String str;
        String str2;
        SharedPreferences.Editor edit;
        Map<String, BizTrafficStats.BizData> totalBizTraffic;
        Iterator<Map.Entry<String, BizTrafficStats.BizData>> it;
        JSONObject jSONObject;
        String str3;
        JSONObject jSONObject2;
        String str4;
        JSONObject jSONObject3;
        JSONObject jSONObject4;
        String str5;
        List<TrafficUsageModel> sortedList;
        super.onStart();
        if (!isBackground()) {
            sBgType = ApmTrafficStats.VALUE_TRAFFIC_STATUS_BG;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long totalBytes = this.mTrafficStatisticWrapper.getTotalBytes();
        long mobileBackBytes = this.mTrafficStatisticWrapper.getMobileBackBytes();
        long mobileFrontBytes = this.mTrafficStatisticWrapper.getMobileFrontBytes();
        long wifiBackBytes = this.mTrafficStatisticWrapper.getWifiBackBytes();
        TrafficStatisticWrapper trafficStatisticWrapper = this.mTrafficStatisticWrapper;
        String str6 = TAG;
        long wifiFrontBytes = trafficStatisticWrapper.getWifiFrontBytes();
        if (this.mLastTotalBytes == -1) {
            this.mLastTotalBytes = totalBytes;
            this.mLastMobileBackBytes = mobileBackBytes;
            this.mLastMobileFrontBytes = mobileFrontBytes;
            this.mLastWIFIBackBytes = wifiBackBytes;
            this.mLastWIFIFrontBytes = wifiFrontBytes;
            this.mLastTs = currentTimeMillis;
            return;
        }
        JSONArray jSONArray = new JSONArray();
        long j = totalBytes - this.mLastTotalBytes;
        long j2 = mobileBackBytes - this.mLastMobileBackBytes;
        long j3 = mobileFrontBytes - this.mLastMobileFrontBytes;
        long j4 = wifiBackBytes - this.mLastWIFIBackBytes;
        long j5 = wifiFrontBytes - this.mLastWIFIFrontBytes;
        long j6 = this.mTraffic10minutesThresholdBytes;
        if (j6 > 0 && j > j6) {
            jSONArray.put(ApmTrafficStats.EXCEPTION_TOTAL_USAGE);
        } else {
            long j7 = this.mTraffic10minutesBackThresholdBytes;
            if (j7 > 0 && j2 + j4 > j7) {
                if (TextUtils.equals(sBgType, ApmTrafficStats.VALUE_TRAFFIC_STATUS_BG_NEVER_FRONT)) {
                    jSONArray.put(ApmTrafficStats.EXCEPTION_NEVER_FRONT_TOTAL_USAGE);
                } else {
                    jSONArray.put(ApmTrafficStats.EXCEPTION_BG_TOTAL_USAGE);
                }
            }
        }
        TopK<TrafficUsageModel> topPathTraffic = BizTrafficStats.getInstance().getTopPathTraffic();
        if (topPathTraffic != null && topPathTraffic.size() > 0) {
            jSONArray.put(ApmTrafficStats.EXCEPTION_LARGE_REQUEST);
        }
        if (LruKhighFreqHelper.getInstance().getMaxFreq() > this.mHighFreqCountThreshold) {
            jSONArray.put(ApmTrafficStats.EXCEPTION_HIGH_FREQ);
        }
        this.mLastTotalBytes = totalBytes;
        this.mLastWIFIFrontBytes = wifiFrontBytes;
        this.mLastWIFIBackBytes = wifiBackBytes;
        this.mLastMobileBackBytes = mobileBackBytes;
        this.mLastMobileFrontBytes = mobileFrontBytes;
        JSONArray jSONArray2 = new JSONArray();
        SamplerHelper.getPerfAllowSwitch(this.mCollectorSettingKey);
        mapToJSONArray(BizTrafficStats.getInstance().getBizTraffic(), ApmTrafficStats.KEY_TRAFFIC_PERIOD, jSONArray2);
        mapToJSONArray(BizTrafficStats.getInstance().getBizWifiFrontTraffic(), "wifi_front", jSONArray2);
        mapToJSONArray(BizTrafficStats.getInstance().getBizWifiBackTraffic(), "wifi_back", jSONArray2);
        mapToJSONArray(BizTrafficStats.getInstance().getBizMobileFrontTraffic(), "mobile_front", jSONArray2);
        mapToJSONArray(BizTrafficStats.getInstance().getBizMobileBackTraffic(), "mobile_back", jSONArray2);
        JSONObject jSONObject5 = new JSONObject();
        if (jSONArray2.length() > 0) {
            try {
                jSONObject5.put("usage", jSONArray2);
            } catch (Exception unused) {
            }
        }
        try {
            jSONObject = new JSONObject();
            jSONObject.put(ApmTrafficStats.KEY_TRAFFIC_PERIOD, j);
            jSONObject.put("mobile_back", j2);
            jSONObject.put("mobile_front", j3);
            jSONObject.put("wifi_back", j4);
            str3 = "detail";
            try {
                jSONObject.put("wifi_front", j5);
                ITrafficCallback iTrafficCallback = trafficCallback;
                if (iTrafficCallback != null) {
                    iTrafficCallback.onResult(j, j4, j5, j2, j3);
                }
                jSONObject2 = new JSONObject();
                PerfData perfData = new PerfData();
                JSONObject jSONObject6 = new JSONObject();
                jSONObject6.put(str3, jSONObject5);
                long bizIntervalTotalBytes = BizTrafficStats.getInstance().getBizIntervalTotalBytes();
                str2 = ApmTrafficStats.KEY_BIZ_STATS;
                try {
                    jSONObject6.put(str2, bizIntervalTotalBytes);
                    trafficCollector = this;
                } catch (JSONException unused2) {
                    trafficCollector = this;
                }
                try {
                    jSONObject6.put(ApmTrafficStats.SP_TRAFFIC_INIT_TIME, trafficCollector.mLastTs);
                    str = ApmTrafficStats.SP_TRAFFIC_ACCU_TIME;
                    try {
                        jSONObject6.put(str, currentTimeMillis);
                        perfData.serviceName(trafficCollector.mCollectorSettingKey).extraStatus(jSONObject2).extraValues(jSONObject).extraLog(jSONObject6);
                        if (ApmAlogHelper.isFeedbackALogEnabled()) {
                            str4 = str6;
                            try {
                                ApmAlogHelper.feedbackI(str4, JsonUtils.deepCopy(perfData.packLog()).toString());
                            } catch (JSONException unused3) {
                            }
                        } else {
                            str4 = str6;
                        }
                        trafficCollector.sendPerfLog(perfData);
                        trafficCollector.mLastTs = currentTimeMillis;
                    } catch (JSONException unused4) {
                    }
                } catch (JSONException unused5) {
                    str = ApmTrafficStats.SP_TRAFFIC_ACCU_TIME;
                    edit = ApmContext.getContext().getSharedPreferences(ApmTrafficStats.SP_TRAFFIC, 0).edit();
                    edit.putLong("usage", totalBytes);
                    long bizIntervalTotalBytes2 = trafficCollector.mBizTotalBytes + BizTrafficStats.getInstance().getBizIntervalTotalBytes();
                    trafficCollector.mBizTotalBytes = bizIntervalTotalBytes2;
                    edit.putLong(str2, bizIntervalTotalBytes2);
                    edit.putLong(str, System.currentTimeMillis());
                    totalBizTraffic = BizTrafficStats.getInstance().getTotalBizTraffic();
                    if (totalBizTraffic != null) {
                    }
                    edit.apply();
                    if (ApmContext.isDebugMode()) {
                    }
                    BizTrafficStats.getInstance().clear();
                    LruKhighFreqHelper.getInstance().clear();
                }
            } catch (JSONException unused6) {
                trafficCollector = this;
                str = ApmTrafficStats.SP_TRAFFIC_ACCU_TIME;
                str2 = ApmTrafficStats.KEY_BIZ_STATS;
                edit = ApmContext.getContext().getSharedPreferences(ApmTrafficStats.SP_TRAFFIC, 0).edit();
                edit.putLong("usage", totalBytes);
                long bizIntervalTotalBytes22 = trafficCollector.mBizTotalBytes + BizTrafficStats.getInstance().getBizIntervalTotalBytes();
                trafficCollector.mBizTotalBytes = bizIntervalTotalBytes22;
                edit.putLong(str2, bizIntervalTotalBytes22);
                edit.putLong(str, System.currentTimeMillis());
                totalBizTraffic = BizTrafficStats.getInstance().getTotalBizTraffic();
                if (totalBizTraffic != null) {
                }
                edit.apply();
                if (ApmContext.isDebugMode()) {
                }
                BizTrafficStats.getInstance().clear();
                LruKhighFreqHelper.getInstance().clear();
            }
        } catch (JSONException unused7) {
            trafficCollector = this;
        }
        if (jSONArray.length() > 0) {
            JSONObject jSONObject7 = new JSONObject();
            jSONObject7.put("exception", true);
            jSONObject7.put(ApmTrafficStats.KEY_EXCEPTION_TYPE, jSONArray);
            Map<String, TrafficUsageModel> highFreqMap = LruKhighFreqHelper.getInstance().getHighFreqMap();
            if (highFreqMap != null) {
                JSONArray jSONArray3 = new JSONArray();
                for (Map.Entry<String, TrafficUsageModel> entry : highFreqMap.entrySet()) {
                    String str7 = str4;
                    String str8 = str3;
                    JSONObject jSONObject8 = jSONObject2;
                    JSONObject jSONObject9 = jSONObject7;
                    if (entry.getValue().requestCount > trafficCollector.mHighFreqCountThreshold) {
                        JSONObject jSONObject10 = new JSONObject();
                        jSONObject10.put("path", entry.getValue().path);
                        jSONObject10.put(ApmTrafficStats.KEY_FREQ, entry.getValue().requestCount);
                        jSONObject10.put("biz", entry.getValue().clientType);
                        jSONArray3.put(jSONObject10);
                    }
                    jSONObject2 = jSONObject8;
                    str3 = str8;
                    str4 = str7;
                    jSONObject7 = jSONObject9;
                }
                jSONObject3 = jSONObject2;
                jSONObject4 = jSONObject7;
                str6 = str4;
                str5 = str3;
                if (ApmAlogHelper.isFeedbackALogEnabled()) {
                    ApmAlogHelper.feedbackI(TRAFFIC_HIGH_FREQ, jSONArray3.toString());
                }
                jSONObject5.put(ApmTrafficStats.KEY_HIGH_FREQ, jSONArray3);
            } else {
                jSONObject3 = jSONObject2;
                jSONObject4 = jSONObject7;
                str6 = str4;
                str5 = str3;
            }
            if (topPathTraffic != null && (sortedList = topPathTraffic.sortedList()) != null && sortedList.size() > 0) {
                JSONArray jSONArray4 = new JSONArray();
                for (TrafficUsageModel trafficUsageModel : sortedList) {
                    JSONObject jSONObject11 = new JSONObject();
                    jSONObject11.put("path", trafficUsageModel.path);
                    jSONObject11.put("usage", trafficUsageModel.trafficBytes);
                    jSONObject11.put("biz", trafficUsageModel.clientType);
                    jSONArray4.put(jSONObject11);
                }
                jSONObject5.put(ApmTrafficStats.KEY_LARGE_USAGE, jSONArray4);
                if (ApmAlogHelper.isFeedbackALogEnabled()) {
                    ApmAlogHelper.feedbackI(TRAFFIC_TOPK, jSONArray4.toString());
                }
            }
            JSONObject jSONObject12 = jSONObject4;
            jSONObject12.put(str2, BizTrafficStats.getInstance().getBizIntervalTotalBytes());
            if (ApmAlogHelper.isFeedbackALogEnabled()) {
                ApmAlogHelper.feedbackI(EXCEPTION_TYPE, jSONObject12.toString());
            }
            jSONObject12.put(str5, jSONObject5);
            PerfData perfData2 = new PerfData();
            perfData2.serviceName(trafficCollector.mCollectorSettingKey).extraStatus(jSONObject3).extraValues(jSONObject).extraLog(jSONObject12);
            trafficCollector.sendPerfLog(perfData2);
            edit = ApmContext.getContext().getSharedPreferences(ApmTrafficStats.SP_TRAFFIC, 0).edit();
            edit.putLong("usage", totalBytes);
            long bizIntervalTotalBytes222 = trafficCollector.mBizTotalBytes + BizTrafficStats.getInstance().getBizIntervalTotalBytes();
            trafficCollector.mBizTotalBytes = bizIntervalTotalBytes222;
            edit.putLong(str2, bizIntervalTotalBytes222);
            edit.putLong(str, System.currentTimeMillis());
            totalBizTraffic = BizTrafficStats.getInstance().getTotalBizTraffic();
            if (totalBizTraffic != null && totalBizTraffic.size() > 0) {
                JSONArray jSONArray5 = new JSONArray();
                it = totalBizTraffic.entrySet().iterator();
                while (it.hasNext()) {
                    JSONObject jSONObject13 = it.next().getValue().toJSONObject();
                    try {
                        jSONObject13.put(ApmTrafficStats.KEY_TRAFFIC_CATEGORY, ApmTrafficStats.KEY_TRAFFIC_TOTAL);
                    } catch (Exception unused8) {
                    }
                    jSONArray5.put(jSONObject13);
                }
                edit.putString(ApmTrafficStats.KEY_TRAFFIC_BIZ_RECORD_JSON, jSONArray5.toString());
            }
            edit.apply();
            if (ApmContext.isDebugMode()) {
                String str9 = str6;
                Log.d(str9, "traffic since app boot: " + (totalBytes - trafficCollector.mInitTrafficBytes));
                Log.d(str9, "traffic stats from biz (include ttnet/ok/httpurl plus trafficStats): " + BizTrafficStats.getInstance().getBizIntervalTotalBytes());
            }
            BizTrafficStats.getInstance().clear();
            LruKhighFreqHelper.getInstance().clear();
        }
        str6 = str4;
        edit = ApmContext.getContext().getSharedPreferences(ApmTrafficStats.SP_TRAFFIC, 0).edit();
        edit.putLong("usage", totalBytes);
        long bizIntervalTotalBytes2222 = trafficCollector.mBizTotalBytes + BizTrafficStats.getInstance().getBizIntervalTotalBytes();
        trafficCollector.mBizTotalBytes = bizIntervalTotalBytes2222;
        edit.putLong(str2, bizIntervalTotalBytes2222);
        edit.putLong(str, System.currentTimeMillis());
        totalBizTraffic = BizTrafficStats.getInstance().getTotalBizTraffic();
        if (totalBizTraffic != null) {
            JSONArray jSONArray52 = new JSONArray();
            it = totalBizTraffic.entrySet().iterator();
            while (it.hasNext()) {
            }
            edit.putString(ApmTrafficStats.KEY_TRAFFIC_BIZ_RECORD_JSON, jSONArray52.toString());
        }
        edit.apply();
        if (ApmContext.isDebugMode()) {
        }
        BizTrafficStats.getInstance().clear();
        LruKhighFreqHelper.getInstance().clear();
    }

    private JSONArray mapToJSONArray(Map<String, BizTrafficStats.BizData> map, String str, JSONArray jSONArray) {
        if (map != null && map.size() != 0) {
            try {
                Iterator<Map.Entry<String, BizTrafficStats.BizData>> it = map.entrySet().iterator();
                while (it.hasNext()) {
                    JSONObject jSONObject = it.next().getValue().toJSONObject(this.recordUsageThreshold);
                    if (!TextUtils.isEmpty(str)) {
                        jSONObject.put(ApmTrafficStats.KEY_TRAFFIC_CATEGORY, str);
                    }
                    jSONArray.put(jSONObject);
                }
                return jSONArray;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.apm.perf.AbstractPerfCollector
    public void doConfig(JSONObject jSONObject) {
        super.doConfig(jSONObject);
        if (jSONObject.optInt(SlardarSettingsConsts.PERF_TRAFFIC_CAUSE_ANALYSIS_ENABLE, 0) == 1) {
            BizTrafficStats.getInstance().start();
            this.mTraffic10minutesThresholdBytes = jSONObject.optInt(SlardarSettingsConsts.PERF_TRAFFIC_EXCEPTION_THRESHOLD_10_MINUTES_MB, 500) * 1000 * 1000;
            this.mTraffic10minutesBackThresholdBytes = jSONObject.optInt(SlardarSettingsConsts.PERF_TRAFFIC_EXCEPTION_THRESHOLD_10_MINUTES_BG_MB, 500) * 1000 * 1000;
            this.mHighFreqCountThreshold = jSONObject.optInt(SlardarSettingsConsts.PERF_TRAFFIC_EXCEPTION_HIGH_FREQ_THRESHOLD, 200);
            BizTrafficStats.getInstance().setSingleRequestTrafficThresholdBytes(jSONObject.optDouble(SlardarSettingsConsts.PERF_TRAFFIC_EXCEPTION_LARGE_USAGE_THRESHOLD_MB, 10.0d) * 1000.0d * 1000.0d);
            BizTrafficStats.getInstance().setAlogRecordThreshold(jSONObject.optDouble(SlardarSettingsConsts.PERF_TRAFFIC_ALOG_RECORD_THRESHOLD_KB, 100.0d));
        }
        this.recordUsageThreshold = jSONObject.optLong(SlardarSettingsConsts.PERF_TRAFFIC_RECORD_USAGE_THRESHOLD_KB, 1L) * 1024;
        boolean perfAllowSwitch = SamplerHelper.getPerfAllowSwitch(this.mCollectorSettingKey);
        while (!cache.isEmpty()) {
            GeneralLegacyEvent pop = cache.pop();
            String pop2 = keys.pop();
            if (perfAllowSwitch || jSONObject.optInt(pop2, 0) == 1) {
                CommonEventDeliverer.monitorLegacyEvent(pop);
            } else if (ApmContext.isDebugMode()) {
                DoctorDataUtil.onReceivedEvent(pop.getLogType(), pop.getLogJson(), false);
            }
            if (ApmContext.isDebugMode()) {
                String[] strArr = new String[1];
                strArr[0] = "isSample:key:" + (perfAllowSwitch || jSONObject.optInt(pop2, 0) == 1);
                Logger.m86d("Traffic", strArr);
            }
        }
        this.config = jSONObject;
    }

    @Override // com.bytedance.apm.perf.AbstractPerfCollector
    public void onFront(Activity activity) {
        super.onFront(activity);
        sBgType = ApmTrafficStats.VALUE_TRAFFIC_STATUS_BG;
        this.mTrafficStatisticWrapper.onStatusChange(false);
    }

    @Override // com.bytedance.apm.perf.AbstractPerfCollector
    public void onBackground(Activity activity) {
        super.onBackground(activity);
        this.mTrafficStatisticWrapper.onStatusChange(true);
    }
}
