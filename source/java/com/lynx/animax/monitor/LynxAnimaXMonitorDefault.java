package com.lynx.animax.monitor;

import com.huawei.hms.android.SystemUtils;
import com.lynx.animax.listener.AnimaXErrorParam;
import com.lynx.animax.service.IAnimaXMonitorService;
import com.lynx.animax.util.AnimaXLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.eventreport.LynxEventReporter;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class LynxAnimaXMonitorDefault implements IAnimaXMonitorService {
    private static final String TAG = "LynxAnimaXMonitorDefault";
    private final WeakReference<LynxContext> mContext;
    private String mCurrentUrl = SystemUtils.UNKNOWN;

    public LynxAnimaXMonitorDefault(LynxContext lynxContext) {
        this.mContext = new WeakReference<>(lynxContext);
    }

    @Override // com.lynx.animax.service.IAnimaXMonitorService
    public void setCurrentUrl(String str) {
        this.mCurrentUrl = str;
    }

    @Override // com.lynx.animax.service.IAnimaXMonitorService
    public void reportError(AnimaXErrorParam animaXErrorParam) {
        LynxContext lynxContext = this.mContext.get();
        if (lynxContext == null || !lynxContext.enableEventReporter()) {
            return;
        }
        Map<String, Object> appendCommonParams = appendCommonParams(animaXErrorParam.getOriginParams());
        AnimaXLog.m2541i(TAG, "reportError: " + appendCommonParams);
        LynxEventReporter.onEvent(AnimaXMonitorUtil.ERROR_EVENT_NAME, appendCommonParams, lynxContext.getInstanceId());
    }

    @Override // com.lynx.animax.service.IAnimaXMonitorService
    public void reportPerformanceMetrics(MetricsAndEventStore metricsAndEventStore) {
        LynxContext lynxContext = this.mContext.get();
        if (lynxContext == null || metricsAndEventStore == null) {
            AnimaXLog.m2540e(TAG, "report failed, metrics is null:" + (metricsAndEventStore == null) + ", context is null:" + (lynxContext == null));
            return;
        }
        if (lynxContext.enableEventReporter()) {
            Map<String, Object> categoryAsMap = metricsAndEventStore.getCategoryAsMap();
            Map<String, Object> metricsAsMap = metricsAndEventStore.getMetricsAsMap();
            HashMap hashMap = new HashMap();
            hashMap.putAll(categoryAsMap);
            hashMap.putAll(metricsAsMap);
            Map<String, Object> appendCommonParams = appendCommonParams(hashMap);
            AnimaXLog.m2541i(TAG, "reportPerformanceMetrics: " + appendCommonParams);
            LynxEventReporter.onEvent(AnimaXMonitorUtil.PERFORMANCE_EVENT_NAME, appendCommonParams, lynxContext.getInstanceId());
        }
    }

    private Map<String, Object> appendCommonParams(Map<String, Object> map) {
        LynxContext lynxContext = this.mContext.get();
        if (lynxContext == null) {
            return map;
        }
        HashMap hashMap = new HashMap(map);
        hashMap.put(AnimaXMonitorUtil.KEY_SRC_URL, AnimaXMonitorUtil.clearUrlQuery(this.mCurrentUrl));
        hashMap.put(AnimaXMonitorUtil.KEY_PAGE_URL, AnimaXMonitorUtil.clearUrlQuery(lynxContext.getTemplateUrl()));
        return hashMap;
    }
}
