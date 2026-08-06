package com.bytedance.apm.perf.traffic;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.constant.TrafficConsts;
import com.bytedance.apm.data.pipeline.CommonDataPipeline;
import com.bytedance.apm.data.pipeline.ICommonDataInnerListener;
import com.bytedance.apm.data.pipeline.INetSlaInnerListener;
import com.bytedance.apm.data.pipeline.NetDataPipeline;
import com.bytedance.apm.logging.ApmAlogHelper;
import com.bytedance.apm.thread.AsyncEventManager;
import com.bytedance.apm.util.NetUtils;
import com.bytedance.apm.util.TopK;
import com.bytedance.apm6.service.ServiceManager;
import com.bytedance.apm6.service.lifecycle.ActivityLifecycleService;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class BizTrafficStats {
    private static final long DEFAULT_LARGE_USAGE_THRESHOLD_BYTES = 102400;
    private static final int LARGE_USAGE_LIMIT_COUNT = 30;
    private static final String TAG = "BizTrafficStats";
    private static final String TRAFFIC_IMAGE_BIZ = "image";
    private double mAlogRecordThreshold;
    private volatile long mBizIntervalTotalBytes;
    private Map<String, BizData> mBizMobileBackTraffic;
    private Map<String, BizData> mBizMobileFrontTraffic;
    private Map<String, BizData> mBizTraffic;
    private Map<String, BizData> mBizWifiBackTraffic;
    private Map<String, BizData> mBizWifiFrontTraffic;
    private Map<String, Map<String, BizData>> mCustomMetricBizTraffic;
    private boolean mEnable;
    private boolean mEnableAlogRecord;
    private double mSingleRequestTrafficThresholdBytes;
    private TopK<TrafficUsageModel> mTopPathTraffic;
    private Map<String, BizData> mTotalBizTraffic;

    @Deprecated
    public void httpImageApiTrafficStats(JSONObject jSONObject) {
    }

    public static BizTrafficStats getInstance() {
        return Holder.sInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static final class Holder {
        private static final BizTrafficStats sInstance = new BizTrafficStats();

        private Holder() {
        }
    }

    private BizTrafficStats() {
        this.mBizIntervalTotalBytes = 0L;
        this.mSingleRequestTrafficThresholdBytes = 102400.0d;
        this.mAlogRecordThreshold = 102400.0d;
    }

    public void start() {
        setEnable(true);
        setEnableAlogRecord(true);
        setSlaListener();
        setCommonDataInnerListener();
    }

    private void setEnable(boolean z) {
        this.mEnable = z;
    }

    private void setEnableAlogRecord(boolean z) {
        this.mEnableAlogRecord = z;
        ApmAlogHelper.setEnable(z);
    }

    private void setSlaListener() {
        NetDataPipeline.getInstance().setNetSlaListener(new INetSlaInnerListener() { // from class: com.bytedance.apm.perf.traffic.BizTrafficStats.1
            @Override // com.bytedance.apm.data.pipeline.INetSlaInnerListener
            public void deliver(String str, JSONObject jSONObject) {
                if (BizTrafficStats.this.mEnable) {
                    BizTrafficStats.this.httpApiTrafficStats(str, jSONObject);
                }
            }
        });
    }

    private void setCommonDataInnerListener() {
        CommonDataPipeline.getInstance().setCommonDataListener(new ICommonDataInnerListener() { // from class: com.bytedance.apm.perf.traffic.BizTrafficStats.2
            @Override // com.bytedance.apm.data.pipeline.ICommonDataInnerListener
            public void deliver(String str, String str2, JSONObject jSONObject) {
                if (BizTrafficStats.this.mEnable && "image_monitor_v2".equals(str2)) {
                    BizTrafficStats.this.httpImageApiTrafficStats(jSONObject);
                }
            }
        });
    }

    public void setSingleRequestTrafficThresholdBytes(double d) {
        this.mSingleRequestTrafficThresholdBytes = d;
    }

    public void setAlogRecordThreshold(double d) {
        this.mAlogRecordThreshold = d;
    }

    public void initCustomMetricBizTrafficStats(String str) {
        if (this.mCustomMetricBizTraffic == null) {
            this.mCustomMetricBizTraffic = new HashMap();
        }
        this.mCustomMetricBizTraffic.put(str, new HashMap());
    }

    public void clearCustomMetricStats(String str) {
        Map<String, Map<String, BizData>> map = this.mCustomMetricBizTraffic;
        if (map == null) {
            return;
        }
        map.remove(str);
    }

    public Map<String, BizData> getCustomMetricBizStats(String str) {
        if (this.mCustomMetricBizTraffic == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.mCustomMetricBizTraffic.get(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void appendBizTraffic(String str, long j, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        boolean isWifi = NetUtils.isWifi(ApmContext.getContext());
        ActivityLifecycleService activityLifecycleService = (ActivityLifecycleService) ServiceManager.getService(ActivityLifecycleService.class);
        boolean isForeground = activityLifecycleService != null ? activityLifecycleService.isForeground() : false;
        if (this.mBizTraffic == null) {
            this.mBizTraffic = new HashMap();
        }
        if (this.mBizWifiBackTraffic == null) {
            this.mBizWifiBackTraffic = new HashMap();
        }
        if (this.mBizWifiFrontTraffic == null) {
            this.mBizWifiFrontTraffic = new HashMap();
        }
        if (this.mBizMobileBackTraffic == null) {
            this.mBizMobileBackTraffic = new HashMap();
        }
        if (this.mBizMobileFrontTraffic == null) {
            this.mBizMobileFrontTraffic = new HashMap();
        }
        if (this.mBizTraffic.containsKey(str)) {
            this.mBizTraffic.get(str).appendBytesBySourceId(str2, j);
        } else {
            BizData bizData = new BizData(str);
            bizData.appendBytesBySourceId(str2, j);
            this.mBizTraffic.put(str, bizData);
        }
        if (isWifi && !isForeground) {
            if (this.mBizWifiBackTraffic.containsKey(str)) {
                this.mBizWifiBackTraffic.get(str).appendBytesBySourceId(str2, j);
            } else {
                BizData bizData2 = new BizData(str);
                bizData2.appendBytesBySourceId(str2, j);
                this.mBizWifiBackTraffic.put(str, bizData2);
            }
        }
        if (isWifi && isForeground) {
            if (this.mBizWifiFrontTraffic.containsKey(str)) {
                this.mBizWifiFrontTraffic.get(str).appendBytesBySourceId(str2, j);
            } else {
                BizData bizData3 = new BizData(str);
                bizData3.appendBytesBySourceId(str2, j);
                this.mBizWifiFrontTraffic.put(str, bizData3);
            }
        }
        if (!isWifi && !isForeground) {
            if (this.mBizMobileBackTraffic.containsKey(str)) {
                this.mBizMobileBackTraffic.get(str).appendBytesBySourceId(str2, j);
            } else {
                BizData bizData4 = new BizData(str);
                bizData4.appendBytesBySourceId(str2, j);
                this.mBizMobileBackTraffic.put(str, bizData4);
            }
        }
        if (!isWifi && isForeground) {
            if (this.mBizMobileFrontTraffic.containsKey(str)) {
                this.mBizMobileFrontTraffic.get(str).appendBytesBySourceId(str2, j);
            } else {
                BizData bizData5 = new BizData(str);
                bizData5.appendBytesBySourceId(str2, j);
                this.mBizMobileFrontTraffic.put(str, bizData5);
            }
        }
        if (this.mTotalBizTraffic == null) {
            this.mTotalBizTraffic = new HashMap();
        }
        if (this.mTotalBizTraffic.containsKey(str)) {
            this.mTotalBizTraffic.get(str).appendBytesBySourceId(str2, j);
        } else {
            BizData bizData6 = new BizData(str);
            bizData6.appendBytesBySourceId(str2, j);
            this.mTotalBizTraffic.put(str, bizData6);
        }
        Map<String, Map<String, BizData>> map = this.mCustomMetricBizTraffic;
        if (map != null) {
            Iterator<Map.Entry<String, Map<String, BizData>>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map<String, BizData> value = it.next().getValue();
                if (value.containsKey(str)) {
                    value.get(str).appendBytesBySourceId(str2, j);
                } else {
                    BizData bizData7 = new BizData(str);
                    bizData7.appendBytesBySourceId(str2, j);
                    value.put(str, bizData7);
                }
            }
        }
    }

    public Map<String, BizData> getTotalBizTraffic() {
        return this.mTotalBizTraffic;
    }

    public void trafficStats(final long j, final String str, final String str2, String str3, JSONObject jSONObject, JSONObject jSONObject2) {
        if (this.mEnable) {
            AsyncEventManager.getInstance().post(new Runnable() { // from class: com.bytedance.apm.perf.traffic.BizTrafficStats.3
                @Override // java.lang.Runnable
                public void run() {
                    BizTrafficStats.this.appendBizTraffic(str2, j, str);
                }
            });
            if (this.mEnableAlogRecord && j > this.mAlogRecordThreshold) {
                Object[] objArr = new Object[6];
                objArr[0] = Long.valueOf(j);
                objArr[1] = str;
                objArr[2] = str2;
                objArr[3] = str3 == null ? "" : str3;
                objArr[4] = jSONObject == null ? "" : jSONObject.toString();
                objArr[5] = jSONObject2 == null ? "" : jSONObject2.toString();
                ApmAlogHelper.m77i(TAG, String.format("trafficBytes: %d, sourceId: %s, business: %s, scene: %s, extraStatus: %s, extraLog: %s", objArr));
            }
            if (ApmContext.isDebugMode()) {
                Object[] objArr2 = new Object[6];
                objArr2[0] = Long.valueOf(j);
                objArr2[1] = str;
                objArr2[2] = str2;
                objArr2[3] = str3 == null ? "" : str3;
                objArr2[4] = jSONObject == null ? "" : jSONObject.toString();
                objArr2[5] = jSONObject2 != null ? jSONObject2.toString() : "";
                Log.d(TAG, String.format("trafficBytes: %d, sourceId: %s, business: %s, scene: %s, extraStatus: %s, extraLog: %s", objArr2));
            }
            this.mBizIntervalTotalBytes += j;
        }
    }

    public void httpApiTrafficStats(String str, JSONObject jSONObject) {
        if (this.mEnable && !TextUtils.isEmpty(str) && jSONObject != null && jSONObject.length() != 0) {
            try {
                String path = new URL(str).getPath();
                if (TextUtils.isEmpty(path)) {
                    return;
                }
                String optString = jSONObject.optString(TrafficConsts.KEY_NET_CONSUME_TYPE, "ttnet");
                JSONObject optJSONObject = jSONObject.optJSONObject(ApmTrafficStats.TTNET_REQUEST_LOG);
                if (optJSONObject == null) {
                    String optString2 = jSONObject.optString(ApmTrafficStats.TTNET_REQUEST_LOG);
                    if (!TextUtils.isEmpty(optString2)) {
                        optJSONObject = new JSONObject(optString2);
                    }
                }
                JSONObject optJSONObject2 = optJSONObject.optJSONObject(ApmTrafficStats.TTNET_RESPONSE);
                long optLong = optJSONObject2 != null ? optJSONObject2.optLong(ApmTrafficStats.TTNET_RECEIVED_BYTES) + optJSONObject2.optLong(ApmTrafficStats.TTNET_SENT_BYTES) : 0L;
                this.mBizIntervalTotalBytes += optLong;
                if (optLong > this.mSingleRequestTrafficThresholdBytes) {
                    if (this.mTopPathTraffic == null) {
                        this.mTopPathTraffic = new TopK<>(30);
                    }
                    this.mTopPathTraffic.add(new TrafficUsageModel(path, optLong, optString));
                }
                if (!TextUtils.isEmpty(str)) {
                    try {
                        str = Uri.parse(str).buildUpon().clearQuery().build().toString();
                    } catch (Exception unused) {
                    }
                }
                appendBizTraffic(optString, optLong, str);
                LruKhighFreqHelper.getInstance().add(optLong, path, optString);
            } catch (Throwable unused2) {
            }
        }
    }

    public TopK<TrafficUsageModel> getTopPathTraffic() {
        return this.mTopPathTraffic;
    }

    public Map<String, BizData> getBizTraffic() {
        return this.mBizTraffic;
    }

    public Map<String, BizData> getBizMobileBackTraffic() {
        return this.mBizMobileBackTraffic;
    }

    public Map<String, BizData> getBizMobileFrontTraffic() {
        return this.mBizMobileFrontTraffic;
    }

    public Map<String, BizData> getBizWifiFrontTraffic() {
        return this.mBizWifiFrontTraffic;
    }

    public Map<String, BizData> getBizWifiBackTraffic() {
        return this.mBizWifiBackTraffic;
    }

    public long getBizIntervalTotalBytes() {
        return this.mBizIntervalTotalBytes;
    }

    public void clear() {
        Map<String, BizData> map = this.mBizTraffic;
        if (map != null) {
            map.clear();
        }
        Map<String, BizData> map2 = this.mBizWifiBackTraffic;
        if (map2 != null) {
            map2.clear();
        }
        Map<String, BizData> map3 = this.mBizWifiFrontTraffic;
        if (map3 != null) {
            map3.clear();
        }
        Map<String, BizData> map4 = this.mBizMobileBackTraffic;
        if (map4 != null) {
            map4.clear();
        }
        Map<String, BizData> map5 = this.mBizMobileFrontTraffic;
        if (map5 != null) {
            map5.clear();
        }
        TopK<TrafficUsageModel> topK = this.mTopPathTraffic;
        if (topK != null) {
            topK.clear();
        }
        this.mBizIntervalTotalBytes = 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public class BizData {
        public String biz;
        public long totalUsage = 0;
        public Map<String, Long> sourceIdMap = new HashMap();

        public BizData(String str) {
            this.biz = str;
        }

        public void appendBytesBySourceId(String str, long j) {
            if (this.sourceIdMap.containsKey(str)) {
                Map<String, Long> map = this.sourceIdMap;
                map.put(str, Long.valueOf(map.get(str).longValue() + j));
            } else {
                this.sourceIdMap.put(str, Long.valueOf(j));
            }
            this.totalUsage += j;
        }

        public JSONObject toJSONObject() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("biz", this.biz);
                jSONObject.put("usage", this.totalUsage);
                JSONArray jSONArray = new JSONArray();
                Map<String, Long> map = this.sourceIdMap;
                if (map != null && map.size() > 0) {
                    for (Map.Entry<String, Long> entry : this.sourceIdMap.entrySet()) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put(ApmTrafficStats.KEY_SOURCE_ID, entry.getKey());
                        jSONObject2.put("usage", entry.getValue());
                        jSONArray.put(jSONObject2);
                    }
                }
                jSONObject.put("detail", jSONArray);
            } catch (JSONException unused) {
            }
            return jSONObject;
        }

        public JSONObject toJSONObject(long j) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("biz", this.biz);
                jSONObject.put("usage", this.totalUsage);
                JSONArray jSONArray = new JSONArray();
                Map<String, Long> map = this.sourceIdMap;
                if (map != null && map.size() > 0) {
                    for (Map.Entry<String, Long> entry : this.sourceIdMap.entrySet()) {
                        if (entry.getValue().longValue() >= j) {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put(ApmTrafficStats.KEY_SOURCE_ID, entry.getKey());
                            jSONObject2.put("usage", entry.getValue());
                            jSONArray.put(jSONObject2);
                        }
                    }
                }
                jSONObject.put("detail", jSONArray);
            } catch (JSONException unused) {
            }
            return jSONObject;
        }
    }
}
