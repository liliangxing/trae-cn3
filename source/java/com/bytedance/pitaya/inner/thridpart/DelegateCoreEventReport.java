package com.bytedance.pitaya.inner.thridpart;

import com.bytedance.pitaya.api.PitayaProxy;
import com.bytedance.pitaya.api.bean.PTYErrorCode;
import com.bytedance.pitaya.jniwrapper.ReflectionCall;
import com.bytedance.pitayacore.BuildConfig;
import com.bytedance.ug.sdk.deeplink.CommonConstants;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: DelegateCoreEventReport.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001d\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\u0012J\u0006\u0010\u0013\u001a\u00020\u000fJ\b\u0010\u0014\u001a\u00020\u000fH\u0002J\b\u0010\u0015\u001a\u00020\u000fH\u0002J\b\u0010\u0016\u001a\u00020\u000fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR&\u0010\u000b\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\r0\f0\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/bytedance/pitaya/inner/thridpart/DelegateCoreEventReport;", "Lcom/bytedance/pitaya/jniwrapper/ReflectionCall;", "()V", "appVer", "", "mMonitor", "Lcom/bytedance/pitaya/inner/thridpart/IEventReport;", "getMMonitor", "()Lcom/bytedance/pitaya/inner/thridpart/IEventReport;", "setMMonitor", "(Lcom/bytedance/pitaya/inner/thridpart/IEventReport;)V", "notReadyCallMap", "", "", "notReadyCall", "", CommonConstants.KEY_AID, "businessName", "notReadyCall$pitayacore_release", "onReady", "reportFeatureCache", "reportFirstInvokeTimeInterval", "reportRunTaskBeforeReady", "pitayacore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class DelegateCoreEventReport implements ReflectionCall {
    private static IEventReport mMonitor;
    public static final DelegateCoreEventReport INSTANCE = new DelegateCoreEventReport();
    private static String appVer = "No Version";
    private static final Map<String, Map<String, Long>> notReadyCallMap = new LinkedHashMap();

    private DelegateCoreEventReport() {
    }

    public final IEventReport getMMonitor() {
        return mMonitor;
    }

    public final void setMMonitor(IEventReport iEventReport) {
        mMonitor = iEventReport;
    }

    public final void notReadyCall$pitayacore_release(String aid, String businessName) {
        Intrinsics.checkNotNullParameter(aid, CommonConstants.KEY_AID);
        Intrinsics.checkNotNullParameter(businessName, "businessName");
        Map<String, Map<String, Long>> map = notReadyCallMap;
        synchronized (map) {
            LinkedHashMap linkedHashMap = map.get(aid);
            if (linkedHashMap == null) {
                linkedHashMap = new LinkedHashMap();
                map.put(aid, linkedHashMap);
            }
            if (!linkedHashMap.containsKey(businessName)) {
                linkedHashMap.put(businessName, Long.valueOf(System.currentTimeMillis()));
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void onReady() {
        reportRunTaskBeforeReady();
        reportFirstInvokeTimeInterval();
        reportFeatureCache();
    }

    private final void reportRunTaskBeforeReady() {
        Map<String, Map<String, Long>> map = notReadyCallMap;
        synchronized (map) {
            for (Map.Entry<String, Map<String, Long>> entry : map.entrySet()) {
                for (Map.Entry<String, Long> entry2 : entry.getValue().entrySet()) {
                    IEventReport iEventReport = mMonitor;
                    if (iEventReport != null) {
                        iEventReport.reportEvent("pitaya2_task", new JSONObject().put("app_ver", appVer).put("sdk_ver", "2.13.0").put("sdk_build_ver", BuildConfig.SDK_VERSION).put("nm", entry2.getKey()).put("call", "api").put(CommonConstants.KEY_AID, entry.getKey()).put("rst", PTYErrorCode.PITAYA_IMPL_NOT_READY.getCode()), null, new JSONObject().put("ts", entry2.getValue().longValue()));
                    }
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void reportFirstInvokeTimeInterval() {
        Map<String, Map<String, Long>> map = notReadyCallMap;
        synchronized (map) {
            for (Map.Entry<String, Map<String, Long>> entry : map.entrySet()) {
                for (Map.Entry<String, Long> entry2 : entry.getValue().entrySet()) {
                    int currentTimeMillis = (int) (System.currentTimeMillis() - entry2.getValue().longValue());
                    IEventReport iEventReport = mMonitor;
                    if (iEventReport != null) {
                        iEventReport.reportEvent("pitaya2_plugin_time", new JSONObject().put("app_ver", appVer).put(CommonConstants.KEY_AID, entry.getKey()).put("sdk_ver", "2.13.0").put("sdk_build_ver", BuildConfig.SDK_VERSION).put("nm", entry2.getKey()), new JSONObject().put("dur", currentTimeMillis / 1000.0d), null);
                    }
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void reportFeatureCache() {
        int applogCacheSize = PitayaProxy.applogCacheSize();
        IEventReport iEventReport = mMonitor;
        if (iEventReport != null) {
            iEventReport.reportEvent("pitaya2_fe_cold_start", new JSONObject().put("app_ver", appVer).put(CommonConstants.KEY_AID, 3691).put("sdk_ver", "2.13.0").put("sdk_build_ver", BuildConfig.SDK_VERSION), new JSONObject().put("applog_num", applogCacheSize).put("fe_store_num", 0), null);
        }
    }
}
