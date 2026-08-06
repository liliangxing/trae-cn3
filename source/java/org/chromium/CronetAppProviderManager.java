package org.chromium;

import android.util.Pair;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetDepend;
import com.bytedance.frameworks.baselib.network.utils.ReflectWrap;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.sdk.account.platform.onekey.bpea.BpeaManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class CronetAppProviderManager {
    private static final String ADAPTER_CLASS_NAME = "com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider";
    private static volatile CronetAppProviderManager sCronetAppProviderManager;
    private ICronetAppProvider mCronetAppProvider;
    private Object mCronetAppProviderAdapter;
    private ICronetDepend mCronetDepend;

    private CronetAppProviderManager() {
    }

    public static CronetAppProviderManager inst() {
        if (sCronetAppProviderManager == null) {
            synchronized (CronetAppProviderManager.class) {
                if (sCronetAppProviderManager == null) {
                    sCronetAppProviderManager = new CronetAppProviderManager();
                }
            }
        }
        return sCronetAppProviderManager;
    }

    public void setAdapter(Object obj) {
        List allInterfaces;
        if (obj != null) {
            try {
                Class<?> cls = obj.getClass();
                if (cls != null && (allInterfaces = Utils.getAllInterfaces(cls)) != null && !allInterfaces.isEmpty()) {
                    Iterator it = allInterfaces.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        if (ADAPTER_CLASS_NAME.equals(((Class) it.next()).getName())) {
                            if (CronetDependManager.inst().loggerDebug()) {
                                CronetDependManager.inst().loggerD("CronetAppProviderManager", "inject CronetAppProviderManager success");
                            }
                            this.mCronetAppProviderAdapter = obj;
                        }
                    }
                }
                return;
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        if (obj instanceof ICronetAppProvider) {
            this.mCronetAppProvider = (ICronetAppProvider) obj;
        }
        if (obj instanceof ICronetDepend) {
            this.mCronetDepend = (ICronetDepend) obj;
        }
    }

    public void sendAppMonitorEvent(String str, String str2) {
        if (CronetDependManager.inst().loggerDebug()) {
            CronetDependManager.inst().loggerD("CronetAppProviderManager", "Send monitor json = " + str + ", log type =" + str2);
        }
        try {
            if (NetworkParams.getOptReflection()) {
                ICronetAppProvider iCronetAppProvider = this.mCronetAppProvider;
                if (iCronetAppProvider == null) {
                    return;
                }
                iCronetAppProvider.sendAppMonitorEvent(str, str2);
                return;
            }
            Object obj = this.mCronetAppProviderAdapter;
            if (obj == null) {
                return;
            }
            ReflectWrap.on(obj).call("sendAppMonitorEvent", new Class[]{String.class, String.class}, str, str2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void onServerConfigUpdated(String str, String str2, String str3) {
        if (CronetDependManager.inst().loggerDebug()) {
            CronetDependManager.inst().loggerD("CronetAppProviderManager", "onServerConfigUpdated json = " + str);
        }
        try {
            if (NetworkParams.getOptReflection()) {
                ICronetAppProvider iCronetAppProvider = this.mCronetAppProvider;
                if (iCronetAppProvider == null) {
                    return;
                }
                iCronetAppProvider.onServerConfigEtagChanged(str2);
                this.mCronetAppProvider.onServerConfigABTestChanged(str3);
                this.mCronetAppProvider.onServerConfigUpdated(str);
                return;
            }
            Object obj = this.mCronetAppProviderAdapter;
            if (obj == null) {
                return;
            }
            ReflectWrap.on(obj).call("onServerConfigEtagChanged", new Class[]{String.class}, str2);
            ReflectWrap.on(this.mCronetAppProviderAdapter).call("onServerConfigABTestChanged", new Class[]{String.class}, str3);
            ReflectWrap.on(this.mCronetAppProviderAdapter).call("onServerConfigUpdated", new Class[]{String.class}, str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void onTTNetDetectInfoChanged(String str) {
        if (CronetDependManager.inst().loggerDebug()) {
            CronetDependManager.inst().loggerD("CronetAppProviderManager", "onTTNetDetectInfoChanged info str = " + str);
        }
        try {
            if (NetworkParams.getOptReflection()) {
                ICronetAppProvider iCronetAppProvider = this.mCronetAppProvider;
                if (iCronetAppProvider == null) {
                    return;
                }
                iCronetAppProvider.onTTNetDetectInfoChanged(str);
                return;
            }
            Object obj = this.mCronetAppProviderAdapter;
            if (obj == null) {
                return;
            }
            ReflectWrap.on(obj).call("onTTNetDetectInfoChanged", new Class[]{String.class}, str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void onTTDnsResolveResult(String str, String str2, int i, int i2, int i3, List<String> list, String str3) {
        if (CronetDependManager.inst().loggerDebug()) {
            CronetDependManager.inst().loggerD("CronetAppProviderManager", "onTTDnsResolveResult info uuid = " + str + " host: " + str2);
        }
        try {
            if (NetworkParams.getOptReflection()) {
                ICronetAppProvider iCronetAppProvider = this.mCronetAppProvider;
                if (iCronetAppProvider == null) {
                    return;
                }
                iCronetAppProvider.onTTDnsResolveResult(str, str2, i, i2, i3, list, str3);
                return;
            }
            Object obj = this.mCronetAppProviderAdapter;
            if (obj == null) {
                return;
            }
            ReflectWrap.on(obj).call("onTTDnsResolveResult", new Class[]{String.class, String.class, Integer.TYPE, Integer.TYPE, Integer.TYPE, List.class, String.class}, str, str2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), list, str3);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void onMappingRequestStatus(String str, int i) {
        if (CronetDependManager.inst().loggerDebug()) {
            CronetDependManager.inst().loggerD("CronetAppProviderManager", "onMappingRequestStatus key = " + str + " status = " + i);
        }
        try {
            if (NetworkParams.getOptReflection()) {
                ICronetAppProvider iCronetAppProvider = this.mCronetAppProvider;
                if (iCronetAppProvider == null) {
                    return;
                }
                iCronetAppProvider.onMappingRequestStatus(str, i);
                return;
            }
            Object obj = this.mCronetAppProviderAdapter;
            if (obj == null) {
                return;
            }
            ReflectWrap.on(obj).call("onMappingRequestStatus", new Class[]{String.class, Integer.TYPE}, str, Integer.valueOf(i));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void onEffectiveConnectionTypeChanged(int i) {
        if (CronetDependManager.inst().loggerDebug()) {
            CronetDependManager.inst().loggerD("CronetAppProviderManager", "onEffectiveConnectionTypeChanged type = " + i);
        }
        try {
            if (NetworkParams.getOptReflection()) {
                ICronetAppProvider iCronetAppProvider = this.mCronetAppProvider;
                if (iCronetAppProvider == null) {
                    return;
                }
                iCronetAppProvider.onEffectiveConnectionTypeChangedOnIOThread(i);
                return;
            }
            Object obj = this.mCronetAppProviderAdapter;
            if (obj == null) {
                return;
            }
            ReflectWrap.on(obj).call("onEffectiveConnectionTypeChangedOnIOThread", new Class[]{Integer.TYPE}, Integer.valueOf(i));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void onRTTOrThroughputEstimatesComputed(int i, int i2, int i3) {
        if (CronetDependManager.inst().loggerDebug()) {
            CronetDependManager.inst().loggerD("CronetAppProviderManager", "onRTTOrThroughputEstimatesComputed httpRtt = " + i + ", transportRttMs = " + i2 + ",downstreamThroughputKbps = " + i3);
        }
        try {
            if (NetworkParams.getOptReflection()) {
                ICronetAppProvider iCronetAppProvider = this.mCronetAppProvider;
                if (iCronetAppProvider == null) {
                    return;
                }
                iCronetAppProvider.onRTTOrThroughputEstimatesComputedOnIOThread(i, i2, i3);
                return;
            }
            Object obj = this.mCronetAppProviderAdapter;
            if (obj == null) {
                return;
            }
            ReflectWrap.on(obj).call("onRTTOrThroughputEstimatesComputedOnIOThread", new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE}, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void onPacketLossComputed(int i, double d, double d2, double d3, double d4) {
        if (CronetDependManager.inst().loggerDebug()) {
            CronetDependManager.inst().loggerD("CronetAppProviderManager", "onPacketLossComputed protocol = " + i + ", upstreamLossRate = " + d + ", upstreamLossRateVariance = " + d2 + ", downstreamLossRate = " + d3 + ", downstreamLossRateVariance = " + d4);
        }
        try {
            if (NetworkParams.getOptReflection()) {
                ICronetAppProvider iCronetAppProvider = this.mCronetAppProvider;
                if (iCronetAppProvider == null) {
                    return;
                }
                iCronetAppProvider.onPacketLossComputedOnIOThread(i, d, d2, d3, d4);
                return;
            }
            Object obj = this.mCronetAppProviderAdapter;
            if (obj == null) {
                return;
            }
            ReflectWrap.on(obj).call("onPacketLossComputedOnIOThread", new Class[]{Integer.TYPE, Double.TYPE, Double.TYPE, Double.TYPE, Double.TYPE}, Integer.valueOf(i), Double.valueOf(d), Double.valueOf(d2), Double.valueOf(d3), Double.valueOf(d4));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void onNetworkQualityTypeChangedV3(int i) {
        if (CronetDependManager.inst().loggerDebug()) {
            CronetDependManager.inst().loggerD("CronetAppProviderManager", "onNetworkQualityTypeChangedV3, network_quality_type = " + i);
        }
        try {
            if (NetworkParams.getOptReflection()) {
                ICronetAppProvider iCronetAppProvider = this.mCronetAppProvider;
                if (iCronetAppProvider == null) {
                    return;
                }
                iCronetAppProvider.onEffectiveConnectionTypeChangedOnIOThread(i);
                ReflectWrap.on("com.bytedance.ttnet.NQEManager", (RetrofitMetrics) null).call("notifyNQTChanged", new Class[]{Integer.TYPE}, Integer.valueOf(i));
                return;
            }
            Object obj = this.mCronetAppProviderAdapter;
            if (obj == null) {
                return;
            }
            ReflectWrap.on(obj).call("onEffectiveConnectionTypeChangedOnIOThread", new Class[]{Integer.TYPE}, Integer.valueOf(i));
            ReflectWrap.on("com.bytedance.ttnet.NQEManager").call("notifyNQTChanged", new Class[]{Integer.TYPE}, Integer.valueOf(i));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void onColdStartFinish() {
        if (CronetDependManager.inst().loggerDebug()) {
            CronetDependManager.inst().loggerD("CronetAppProviderManager", "onColdStartFinish ");
        }
        try {
            if (NetworkParams.getOptReflection()) {
                ICronetAppProvider iCronetAppProvider = this.mCronetAppProvider;
                if (iCronetAppProvider == null) {
                    return;
                }
                iCronetAppProvider.onColdStartFinish();
                return;
            }
            Object obj = this.mCronetAppProviderAdapter;
            if (obj == null) {
                return;
            }
            ReflectWrap.on(obj).call("onColdStartFinish");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void onClientIPChanged(String str) {
        if (CronetDependManager.inst().loggerDebug()) {
            CronetDependManager.inst().loggerD("CronetAppProviderManager", "onClientIPChanged ");
        }
        try {
            if (NetworkParams.getOptReflection()) {
                ICronetAppProvider iCronetAppProvider = this.mCronetAppProvider;
                if (iCronetAppProvider == null) {
                    return;
                }
                iCronetAppProvider.onClientIPChanged(str);
                return;
            }
            Object obj = this.mCronetAppProviderAdapter;
            if (obj == null) {
                return;
            }
            ReflectWrap.on(obj).call("onClientIPChanged", new Class[]{String.class}, str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void onPublicIPsChanged(List<String> list, List<String> list2) {
        if (CronetDependManager.inst().loggerDebug()) {
            CronetDependManager.inst().loggerD("CronetAppProviderManager", "onPublicIPsChanged ");
        }
        try {
            if (NetworkParams.getOptReflection()) {
                ICronetAppProvider iCronetAppProvider = this.mCronetAppProvider;
                if (iCronetAppProvider == null) {
                    return;
                }
                iCronetAppProvider.onPublicIPsChanged(list, list2);
                return;
            }
            Object obj = this.mCronetAppProviderAdapter;
            if (obj == null) {
                return;
            }
            ReflectWrap.on(obj).call("onPublicIPsChanged", new Class[]{List.class, List.class}, list, list2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void onStoreIdcChanged(String str, String str2, String str3, String str4, String str5, String str6) {
        if (CronetDependManager.inst().loggerDebug()) {
            CronetDependManager.inst().loggerD("CronetAppProviderManager", "onStoreIdcChanged ");
        }
        try {
            if (NetworkParams.getOptReflection()) {
                ICronetAppProvider iCronetAppProvider = this.mCronetAppProvider;
                if (iCronetAppProvider == null) {
                    return;
                }
                iCronetAppProvider.onStoreIdcChanged(str, str2, str3, str4, str5, str6);
                return;
            }
            Object obj = this.mCronetAppProviderAdapter;
            if (obj == null) {
                return;
            }
            ReflectWrap.on(obj).call("onStoreIdcChanged", new Class[]{String.class, String.class, String.class, String.class, String.class, String.class}, str, str2, str3, str4, str5, str6);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void onDropReasonChanged(boolean z, List<Integer> list) {
        if (CronetDependManager.inst().loggerDebug()) {
            CronetDependManager.inst().loggerD("CronetAppProviderManager", "onDropReasonChanged " + z + ", Drop Reason List " + list);
        }
        try {
            if (NetworkParams.getOptReflection()) {
                ICronetAppProvider iCronetAppProvider = this.mCronetAppProvider;
                if (iCronetAppProvider == null) {
                    return;
                }
                iCronetAppProvider.onDropReasonChanged(z, list);
                return;
            }
            Object obj = this.mCronetAppProviderAdapter;
            if (obj == null) {
                return;
            }
            ReflectWrap.on(obj).call("onDropReasonChanged", new Class[]{Boolean.TYPE, List.class}, Boolean.valueOf(z), list);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void onCronetBootSucceed() {
        if (CronetDependManager.inst().loggerDebug()) {
            CronetDependManager.inst().loggerD("CronetAppProviderManager", "onCronetBootSucceed ");
        }
        try {
            if (NetworkParams.getOptReflection()) {
                ICronetAppProvider iCronetAppProvider = this.mCronetAppProvider;
                if (iCronetAppProvider == null) {
                    return;
                }
                iCronetAppProvider.onCronetBootSucceed();
                return;
            }
            Object obj = this.mCronetAppProviderAdapter;
            if (obj == null) {
                return;
            }
            ReflectWrap.on(obj).call("onCronetBootSucceed");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void onTNCUpdateFailed(String[] strArr, String str) {
        if (CronetDependManager.inst().loggerDebug()) {
            CronetDependManager.inst().loggerD("CronetAppProviderManager", "onTNCUpdateFailed ");
        }
        if (strArr != null) {
            try {
                if (strArr.length > 0) {
                    ArrayList<String> arrayList = new ArrayList<>();
                    Collections.addAll(arrayList, strArr);
                    if (NetworkParams.getOptReflection()) {
                        ICronetAppProvider iCronetAppProvider = this.mCronetAppProvider;
                        if (iCronetAppProvider == null) {
                        } else {
                            iCronetAppProvider.onTNCUpdateFailed(arrayList, str);
                        }
                    } else {
                        Object obj = this.mCronetAppProviderAdapter;
                        if (obj == null) {
                        } else {
                            ReflectWrap.on(obj).call("onTNCUpdateFailed", new Class[]{ArrayList.class, String.class}, arrayList, str);
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public Map<String, String> onCallToAddSecurityFactor(String str, Map<String, String> map) {
        if (CronetDependManager.inst().loggerDebug()) {
            CronetDependManager.inst().loggerD("CronetAppProviderManager", "onCallToAddSecurityFactor info url = " + str);
        }
        try {
            if (NetworkParams.getOptReflection()) {
                ICronetAppProvider iCronetAppProvider = this.mCronetAppProvider;
                if (iCronetAppProvider == null) {
                    return null;
                }
                return iCronetAppProvider.onCallToAddSecurityFactor(str, map);
            }
            Object obj = this.mCronetAppProviderAdapter;
            if (obj == null) {
                return null;
            }
            return (Map) ReflectWrap.on(obj).call("onCallToAddSecurityFactor", new Class[]{String.class, Map.class}, str, map).get();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public void onWiFiToCellStateChanged(int i, int i2) {
        if (CronetDependManager.inst().loggerDebug()) {
            CronetDependManager.inst().loggerD("CronetAppProviderManager", "onWiFiToCellStateChanged, prev state = " + i + ", curr state = " + i2);
        }
        try {
            if (NetworkParams.getOptReflection()) {
                ICronetAppProvider iCronetAppProvider = this.mCronetAppProvider;
                if (iCronetAppProvider == null) {
                    return;
                }
                iCronetAppProvider.onWiFiToCellStateChanged(i, i2);
                return;
            }
            Object obj = this.mCronetAppProviderAdapter;
            if (obj == null) {
                return;
            }
            ReflectWrap.on(obj).call("onWiFiToCellStateChanged", new Class[]{Integer.TYPE, Integer.TYPE}, Integer.valueOf(i), Integer.valueOf(i2)).get();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void onMultiNetworkStateChanged(int i, int i2) {
        if (CronetDependManager.inst().loggerDebug()) {
            CronetDependManager.inst().loggerD("CronetAppProviderManager", "onMultiNetworkStateChanged, prev state = " + i + ", curr state = " + i2);
        }
        try {
            if (NetworkParams.getOptReflection()) {
                ICronetAppProvider iCronetAppProvider = this.mCronetAppProvider;
                if (iCronetAppProvider == null) {
                    return;
                }
                iCronetAppProvider.onMultiNetworkStateChanged(i, i2);
                return;
            }
            Object obj = this.mCronetAppProviderAdapter;
            if (obj == null) {
                return;
            }
            ReflectWrap.on(obj).call("onMultiNetworkStateChanged", new Class[]{Integer.TYPE, Integer.TYPE}, Integer.valueOf(i), Integer.valueOf(i2)).get();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void onUserSpecifiedNetworkEnabled(boolean z) {
        if (CronetDependManager.inst().loggerDebug()) {
            CronetDependManager.inst().loggerD("CronetAppProviderManager", "onUserSpecifiedNetworkEnabled, enable = " + z);
        }
        try {
            if (NetworkParams.getOptReflection()) {
                ICronetAppProvider iCronetAppProvider = this.mCronetAppProvider;
                if (iCronetAppProvider == null) {
                    return;
                }
                iCronetAppProvider.onUserSpecifiedNetworkEnabled(z);
                return;
            }
            Object obj = this.mCronetAppProviderAdapter;
            if (obj == null) {
                return;
            }
            ReflectWrap.on(obj).call("onUserSpecifiedNetworkEnabled", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void onNetworkQualityLevelChanged(int i) {
        if (CronetDependManager.inst().loggerDebug()) {
            CronetDependManager.inst().loggerD("CronetAppProviderManager", "onNetworkQualityLevelChanged, nql: " + i);
        }
        try {
            if (NetworkParams.getOptReflection()) {
                ICronetAppProvider iCronetAppProvider = this.mCronetAppProvider;
                if (iCronetAppProvider == null) {
                    return;
                }
                iCronetAppProvider.onNetworkQualityLevelChangedOnIOThread(i);
                return;
            }
            Object obj = this.mCronetAppProviderAdapter;
            if (obj == null) {
                return;
            }
            ReflectWrap.on(obj).call("onNetworkQualityLevelChangedOnIOThread", new Class[]{Integer.TYPE}, Integer.valueOf(i)).get();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void onNetworkQualityRttAndThroughputNotified(int i, int i2, int i3) {
        if (CronetDependManager.inst().loggerDebug()) {
            CronetDependManager.inst().loggerD("CronetAppProviderManager", "onNetworkQualityRttAndThroughputNotified, effectiveHrttMs: " + i + ", effectiveTrttMs: " + i2 + ", effectiveRxThroughputKbps: " + i3);
        }
        try {
            if (NetworkParams.getOptReflection()) {
                ICronetAppProvider iCronetAppProvider = this.mCronetAppProvider;
                if (iCronetAppProvider == null) {
                    return;
                }
                iCronetAppProvider.onNetworkQualityRttAndThroughputNotifiedOnIOThread(i, i2, i3);
                return;
            }
            Object obj = this.mCronetAppProviderAdapter;
            if (obj == null) {
                return;
            }
            ReflectWrap.on(obj).call("onNetworkQualityRttAndThroughputNotifiedOnIOThread", new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE}, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)).get();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public String getUserId() {
        if (NetworkParams.getOptReflection()) {
            ICronetAppProvider iCronetAppProvider = this.mCronetAppProvider;
            return iCronetAppProvider == null ? "" : iCronetAppProvider.getUserId();
        }
        return getStringAttribute("getUserId");
    }

    public String getAppId() {
        if (NetworkParams.getOptReflection()) {
            ICronetAppProvider iCronetAppProvider = this.mCronetAppProvider;
            return iCronetAppProvider == null ? "" : iCronetAppProvider.getAppId();
        }
        return getStringAttribute("getAppId");
    }

    public String getOSApi() {
        if (NetworkParams.getOptReflection()) {
            ICronetAppProvider iCronetAppProvider = this.mCronetAppProvider;
            return iCronetAppProvider == null ? "" : iCronetAppProvider.getOSApi();
        }
        return getStringAttribute("getOSApi");
    }

    public String getDeviceId() {
        if (NetworkParams.getOptReflection()) {
            ICronetAppProvider iCronetAppProvider = this.mCronetAppProvider;
            return iCronetAppProvider == null ? "" : iCronetAppProvider.getDeviceId();
        }
        return getStringAttribute("getDeviceId");
    }

    public String getNetAccessType() {
        if (NetworkParams.getOptReflection()) {
            ICronetAppProvider iCronetAppProvider = this.mCronetAppProvider;
            return iCronetAppProvider == null ? "" : iCronetAppProvider.getNetAccessType();
        }
        return getStringAttribute("getNetAccessType");
    }

    public String getVersionCode() {
        if (NetworkParams.getOptReflection()) {
            ICronetAppProvider iCronetAppProvider = this.mCronetAppProvider;
            return iCronetAppProvider == null ? "" : iCronetAppProvider.getVersionCode();
        }
        return getStringAttribute("getVersionCode");
    }

    public String getDeviceType() {
        if (NetworkParams.getOptReflection()) {
            ICronetAppProvider iCronetAppProvider = this.mCronetAppProvider;
            return iCronetAppProvider == null ? "" : iCronetAppProvider.getDeviceType();
        }
        return getStringAttribute("getDeviceType");
    }

    public String getAppName() {
        if (NetworkParams.getOptReflection()) {
            ICronetAppProvider iCronetAppProvider = this.mCronetAppProvider;
            return iCronetAppProvider == null ? "" : iCronetAppProvider.getAppName();
        }
        return getStringAttribute("getAppName");
    }

    public String getSdkAppId() {
        if (NetworkParams.getOptReflection()) {
            ICronetAppProvider iCronetAppProvider = this.mCronetAppProvider;
            return iCronetAppProvider == null ? "" : iCronetAppProvider.getSdkAppId();
        }
        return getStringAttribute("getSdkAppId");
    }

    public String getSdkVersion() {
        if (NetworkParams.getOptReflection()) {
            ICronetAppProvider iCronetAppProvider = this.mCronetAppProvider;
            return iCronetAppProvider == null ? "" : iCronetAppProvider.getSdkVersion();
        }
        return getStringAttribute("getSdkVersion");
    }

    public String getChannel() {
        if (NetworkParams.getOptReflection()) {
            ICronetAppProvider iCronetAppProvider = this.mCronetAppProvider;
            return iCronetAppProvider == null ? "" : iCronetAppProvider.getChannel();
        }
        return getStringAttribute("getChannel");
    }

    public String getOSVersion() {
        if (NetworkParams.getOptReflection()) {
            ICronetAppProvider iCronetAppProvider = this.mCronetAppProvider;
            return iCronetAppProvider == null ? "" : iCronetAppProvider.getOSVersion();
        }
        return getStringAttribute("getOSVersion");
    }

    public String getAbi() {
        if (NetworkParams.getOptReflection()) {
            ICronetAppProvider iCronetAppProvider = this.mCronetAppProvider;
            return iCronetAppProvider == null ? "" : iCronetAppProvider.getAbi();
        }
        return getStringAttribute("getAbi");
    }

    public String getDevicePlatform() {
        if (NetworkParams.getOptReflection()) {
            ICronetAppProvider iCronetAppProvider = this.mCronetAppProvider;
            return iCronetAppProvider == null ? "" : iCronetAppProvider.getDevicePlatform();
        }
        return getStringAttribute("getDevicePlatform");
    }

    public String getDeviceBrand() {
        if (NetworkParams.getOptReflection()) {
            ICronetAppProvider iCronetAppProvider = this.mCronetAppProvider;
            return iCronetAppProvider == null ? "" : iCronetAppProvider.getDeviceBrand();
        }
        return getStringAttribute("getDeviceBrand");
    }

    public String getDeviceModel() {
        if (NetworkParams.getOptReflection()) {
            ICronetAppProvider iCronetAppProvider = this.mCronetAppProvider;
            return iCronetAppProvider == null ? "" : iCronetAppProvider.getDeviceModel();
        }
        return getStringAttribute("getDeviceModel");
    }

    public String getVersionName() {
        if (NetworkParams.getOptReflection()) {
            ICronetAppProvider iCronetAppProvider = this.mCronetAppProvider;
            return iCronetAppProvider == null ? "" : iCronetAppProvider.getVersionName();
        }
        return getStringAttribute("getVersionName");
    }

    public String getUpdateVersionCode() {
        if (NetworkParams.getOptReflection()) {
            ICronetAppProvider iCronetAppProvider = this.mCronetAppProvider;
            return iCronetAppProvider == null ? "" : iCronetAppProvider.getUpdateVersionCode();
        }
        return getStringAttribute("getUpdateVersionCode");
    }

    public String getManifestVersionCode() {
        if (NetworkParams.getOptReflection()) {
            ICronetAppProvider iCronetAppProvider = this.mCronetAppProvider;
            return iCronetAppProvider == null ? "" : iCronetAppProvider.getManifestVersionCode();
        }
        return getStringAttribute("getManifestVersionCode");
    }

    public String getStoreIdc() {
        if (NetworkParams.getOptReflection()) {
            ICronetAppProvider iCronetAppProvider = this.mCronetAppProvider;
            return iCronetAppProvider == null ? "" : iCronetAppProvider.getStoreIdc();
        }
        return getStringAttribute("getStoreIdc");
    }

    public String getRegion() {
        if (NetworkParams.getOptReflection()) {
            ICronetAppProvider iCronetAppProvider = this.mCronetAppProvider;
            return iCronetAppProvider == null ? "" : iCronetAppProvider.getRegion();
        }
        return getStringAttribute("getRegion");
    }

    public String getSysRegion() {
        if (NetworkParams.getOptReflection()) {
            ICronetAppProvider iCronetAppProvider = this.mCronetAppProvider;
            return iCronetAppProvider == null ? "" : iCronetAppProvider.getSysRegion();
        }
        return getStringAttribute("getSysRegion");
    }

    public String getCarrierRegion() {
        if (NetworkParams.getOptReflection()) {
            ICronetAppProvider iCronetAppProvider = this.mCronetAppProvider;
            return iCronetAppProvider == null ? "" : iCronetAppProvider.getCarrierRegion();
        }
        return getStringAttribute("getCarrierRegion");
    }

    public String getInitRegion() {
        if (NetworkParams.getOptReflection()) {
            ICronetAppProvider iCronetAppProvider = this.mCronetAppProvider;
            return iCronetAppProvider == null ? "" : iCronetAppProvider.getAppInitialRegionInfo();
        }
        return getStringAttribute("getAppInitialRegionInfo");
    }

    public String getTNCRequestFlags() {
        if (NetworkParams.getOptReflection()) {
            ICronetAppProvider iCronetAppProvider = this.mCronetAppProvider;
            return iCronetAppProvider == null ? "" : iCronetAppProvider.getTNCRequestFlags();
        }
        return getStringAttribute("getTNCRequestFlags");
    }

    public String getHttpDnsRequestFlags() {
        if (NetworkParams.getOptReflection()) {
            ICronetAppProvider iCronetAppProvider = this.mCronetAppProvider;
            return iCronetAppProvider == null ? "" : iCronetAppProvider.getHttpDnsRequestFlags();
        }
        return getStringAttribute("getHttpDnsRequestFlags");
    }

    private String getStringAttribute(String str) {
        try {
            Object obj = this.mCronetAppProviderAdapter;
            return obj == null ? "" : (String) ReflectWrap.on(obj).call(str).get();
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public Map<String, String> getGetDomainDependHostMap() {
        try {
            if (NetworkParams.getOptReflection()) {
                ICronetAppProvider iCronetAppProvider = this.mCronetAppProvider;
                if (iCronetAppProvider == null) {
                    return Collections.emptyMap();
                }
                return iCronetAppProvider.getGetDomainDependHostMap();
            }
            Object obj = this.mCronetAppProviderAdapter;
            if (obj == null) {
                return Collections.emptyMap();
            }
            return (Map) ReflectWrap.on(obj).call("getGetDomainDependHostMap").get();
        } catch (Throwable th) {
            th.printStackTrace();
            return Collections.emptyMap();
        }
    }

    public boolean getOptInit() {
        try {
            if (NetworkParams.getOptReflection()) {
                ICronetAppProvider iCronetAppProvider = this.mCronetAppProvider;
                if (iCronetAppProvider == null) {
                    return false;
                }
                return iCronetAppProvider.getOptInit();
            }
            Object obj = this.mCronetAppProviderAdapter;
            if (obj == null) {
                return false;
            }
            return ((Boolean) ReflectWrap.on(obj).call("getOptInit").get()).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public long getAppStartTime() {
        try {
            if (NetworkParams.getOptReflection()) {
                ICronetAppProvider iCronetAppProvider = this.mCronetAppProvider;
                if (iCronetAppProvider == null) {
                    return -1L;
                }
                return iCronetAppProvider.getAppStartTime();
            }
            Object obj = this.mCronetAppProviderAdapter;
            if (obj == null) {
                return -1L;
            }
            return ((Long) ReflectWrap.on(obj).call("getAppStartTime").get()).longValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return -1L;
        }
    }

    public String getGetDomainDefaultJSON() {
        try {
            if (NetworkParams.getOptReflection()) {
                ICronetAppProvider iCronetAppProvider = this.mCronetAppProvider;
                if (iCronetAppProvider == null) {
                    return null;
                }
                return iCronetAppProvider.getGetDomainDefaultJSON();
            }
            Object obj = this.mCronetAppProviderAdapter;
            if (obj == null) {
                return null;
            }
            return (String) ReflectWrap.on(obj).call("getGetDomainDefaultJSON").get();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public ArrayList<byte[]> getOpaqueData() {
        try {
            if (NetworkParams.getOptReflection()) {
                ICronetAppProvider iCronetAppProvider = this.mCronetAppProvider;
                if (iCronetAppProvider == null) {
                    return null;
                }
                return iCronetAppProvider.getOpaqueData();
            }
            Object obj = this.mCronetAppProviderAdapter;
            if (obj == null) {
                return null;
            }
            return (ArrayList) ReflectWrap.on(obj).call("getOpaqueData").get();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public Map<String[], Pair<byte[], byte[]>> getClientOpaqueData() {
        try {
            if (NetworkParams.getOptReflection()) {
                ICronetAppProvider iCronetAppProvider = this.mCronetAppProvider;
                if (iCronetAppProvider == null) {
                    return null;
                }
                return iCronetAppProvider.getClientOpaqueData();
            }
            Object obj = this.mCronetAppProviderAdapter;
            if (obj == null) {
                return null;
            }
            return (Map) ReflectWrap.on(obj).call("getClientOpaqueData").get();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public Map<String, String> getTNCRequestHeader() {
        try {
            if (NetworkParams.getOptReflection()) {
                ICronetAppProvider iCronetAppProvider = this.mCronetAppProvider;
                if (iCronetAppProvider == null) {
                    return null;
                }
                return iCronetAppProvider.getTNCRequestHeader();
            }
            Object obj = this.mCronetAppProviderAdapter;
            if (obj == null) {
                return null;
            }
            return (Map) ReflectWrap.on(obj).call("getTNCRequestHeader").get();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public Map<String, String> getTNCRequestQuery() {
        try {
            if (NetworkParams.getOptReflection()) {
                ICronetAppProvider iCronetAppProvider = this.mCronetAppProvider;
                if (iCronetAppProvider == null) {
                    return null;
                }
                return iCronetAppProvider.getTNCRequestQuery();
            }
            Object obj = this.mCronetAppProviderAdapter;
            if (obj == null) {
                return null;
            }
            return (Map) ReflectWrap.on(obj).call("getTNCRequestQuery").get();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public boolean isEnableQuic() {
        try {
            if (NetworkParams.getOptReflection()) {
                ICronetAppProvider iCronetAppProvider = this.mCronetAppProvider;
                if (iCronetAppProvider == null) {
                    return false;
                }
                return iCronetAppProvider.isEnableQuic();
            }
            Object obj = this.mCronetAppProviderAdapter;
            if (obj == null) {
                return false;
            }
            return ((Boolean) ReflectWrap.on(obj).call("isEnableQuic").get()).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean isEnableHttp2() {
        try {
            if (NetworkParams.getOptReflection()) {
                ICronetAppProvider iCronetAppProvider = this.mCronetAppProvider;
                if (iCronetAppProvider == null) {
                    return false;
                }
                return iCronetAppProvider.isEnableHttp2();
            }
            Object obj = this.mCronetAppProviderAdapter;
            if (obj == null) {
                return false;
            }
            return ((Boolean) ReflectWrap.on(obj).call("isEnableHttp2").get()).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean isEnableBrotli() {
        try {
            if (NetworkParams.getOptReflection()) {
                ICronetAppProvider iCronetAppProvider = this.mCronetAppProvider;
                if (iCronetAppProvider == null) {
                    return false;
                }
                return iCronetAppProvider.isEnableBrotli();
            }
            Object obj = this.mCronetAppProviderAdapter;
            if (obj == null) {
                return false;
            }
            return ((Boolean) ReflectWrap.on(obj).call("isEnableBrotli").get()).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public Map<String, Pair<Integer, Integer>> getQuicHint() {
        try {
            if (NetworkParams.getOptReflection()) {
                ICronetAppProvider iCronetAppProvider = this.mCronetAppProvider;
                if (iCronetAppProvider == null) {
                    return null;
                }
                return iCronetAppProvider.getQuicHint();
            }
            Object obj = this.mCronetAppProviderAdapter;
            if (obj == null) {
                return null;
            }
            return (Map) ReflectWrap.on(obj).call("getQuicHint").get();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public boolean isBOEProxyEnabled() {
        try {
            if (NetworkParams.getOptReflection()) {
                ICronetAppProvider iCronetAppProvider = this.mCronetAppProvider;
                if (iCronetAppProvider == null) {
                    return false;
                }
                return iCronetAppProvider.isBOEProxyEnabled();
            }
            Object obj = this.mCronetAppProviderAdapter;
            if (obj == null) {
                return false;
            }
            return ((Boolean) ReflectWrap.on(obj).call("isBOEProxyEnabled").get()).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public String getBypassBOEJSON() {
        try {
            if (NetworkParams.getOptReflection()) {
                ICronetAppProvider iCronetAppProvider = this.mCronetAppProvider;
                if (iCronetAppProvider == null) {
                    return null;
                }
                return iCronetAppProvider.getBypassBOEJSON();
            }
            Object obj = this.mCronetAppProviderAdapter;
            if (obj == null) {
                return null;
            }
            return (String) ReflectWrap.on(obj).call("getBypassBOEJSON").get();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public String getStoreIdcRuleJSON() {
        try {
            if (NetworkParams.getOptReflection()) {
                ICronetAppProvider iCronetAppProvider = this.mCronetAppProvider;
                if (iCronetAppProvider == null) {
                    return null;
                }
                return iCronetAppProvider.getStoreIdcRuleJSON();
            }
            Object obj = this.mCronetAppProviderAdapter;
            if (obj == null) {
                return null;
            }
            return (String) ReflectWrap.on(obj).call("getStoreIdcRuleJSON").get();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public String getIsDropFirstTnc() {
        try {
            if (NetworkParams.getOptReflection()) {
                ICronetAppProvider iCronetAppProvider = this.mCronetAppProvider;
                if (iCronetAppProvider == null) {
                    return null;
                }
                return iCronetAppProvider.getIsDropFirstTnc();
            }
            Object obj = this.mCronetAppProviderAdapter;
            if (obj == null) {
                return null;
            }
            return (String) ReflectWrap.on(obj).call("getIsDropFirstTnc").get();
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public void doLoadLibrary(String str) {
        try {
            if (NetworkParams.getOptReflection()) {
                ICronetAppProvider iCronetAppProvider = this.mCronetAppProvider;
                if (iCronetAppProvider == null) {
                } else {
                    iCronetAppProvider.doLoadLibrary(str);
                }
            } else {
                Object obj = this.mCronetAppProviderAdapter;
                if (obj == null) {
                } else {
                    ReflectWrap.on(obj).call("doLoadLibrary", new Class[]{String.class}, str);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean needCustomLoadLibrary() {
        try {
            if (NetworkParams.getOptReflection()) {
                ICronetAppProvider iCronetAppProvider = this.mCronetAppProvider;
                if (iCronetAppProvider == null) {
                    return false;
                }
                return iCronetAppProvider.needCustomLoadLibrary();
            }
            Object obj = this.mCronetAppProviderAdapter;
            if (obj == null) {
                return false;
            }
            return ((Boolean) ReflectWrap.on(obj).call("needCustomLoadLibrary").get()).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public String getCronetSoPath() {
        try {
            if (NetworkParams.getOptReflection()) {
                ICronetAppProvider iCronetAppProvider = this.mCronetAppProvider;
                if (iCronetAppProvider == null) {
                    return null;
                }
                return iCronetAppProvider.getCronetSoPath();
            }
            Object obj = this.mCronetAppProviderAdapter;
            if (obj == null) {
                return null;
            }
            return (String) ReflectWrap.on(obj).call("getCronetSoPath").get();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public int getProcessFlag() {
        try {
            if (NetworkParams.getOptReflection()) {
                ICronetAppProvider iCronetAppProvider = this.mCronetAppProvider;
                if (iCronetAppProvider == null) {
                    return 0;
                }
                return iCronetAppProvider.getProcessFlag();
            }
            Object obj = this.mCronetAppProviderAdapter;
            if (obj == null) {
                return 0;
            }
            return ((Integer) ReflectWrap.on(obj).call("getProcessFlag").get()).intValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public int getWifiFrequency() {
        try {
            if (NetworkParams.getOptReflection()) {
                ICronetAppProvider iCronetAppProvider = this.mCronetAppProvider;
                if (iCronetAppProvider == null) {
                    return 0;
                }
                return iCronetAppProvider.getWifiFrequency();
            }
            Object obj = this.mCronetAppProviderAdapter;
            if (obj == null) {
                return 0;
            }
            return ((Integer) ReflectWrap.on(obj).call("getWifiFrequency").get()).intValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public int getWifiRssi() {
        try {
            if (NetworkParams.getOptReflection()) {
                ICronetAppProvider iCronetAppProvider = this.mCronetAppProvider;
                if (iCronetAppProvider == null) {
                    return 0;
                }
                return iCronetAppProvider.getWifiRssi();
            }
            Object obj = this.mCronetAppProviderAdapter;
            if (obj == null) {
                return 0;
            }
            return ((Integer) ReflectWrap.on(obj).call("getWifiRssi").get()).intValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public String getNetworkOperator() {
        try {
            if (NetworkParams.getOptReflection()) {
                ICronetAppProvider iCronetAppProvider = this.mCronetAppProvider;
                return iCronetAppProvider == null ? "" : iCronetAppProvider.getNetworkOperator();
            }
            Object obj = this.mCronetAppProviderAdapter;
            return obj == null ? "" : (String) ReflectWrap.on(obj).call("getNetworkOperator").get();
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public String getSimOperator() {
        try {
            if (NetworkParams.getOptReflection()) {
                ICronetAppProvider iCronetAppProvider = this.mCronetAppProvider;
                return iCronetAppProvider == null ? "" : iCronetAppProvider.getSimOperator();
            }
            Object obj = this.mCronetAppProviderAdapter;
            return obj == null ? "" : (String) ReflectWrap.on(obj).call(BpeaManager.getSimOperator).get();
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public List<String> getAbSdkVersion() {
        try {
            if (NetworkParams.getOptReflection()) {
                ICronetAppProvider iCronetAppProvider = this.mCronetAppProvider;
                if (iCronetAppProvider == null) {
                    return null;
                }
                return iCronetAppProvider.getAbSdkVersion();
            }
            Object obj = this.mCronetAppProviderAdapter;
            if (obj == null) {
                return null;
            }
            return (List) ReflectWrap.on(obj).call("getAbSdkVersion").get();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public void onTncRequestSucceeded(boolean z, boolean z2, int i) {
        try {
            if (NetworkParams.getOptReflection()) {
                ICronetAppProvider iCronetAppProvider = this.mCronetAppProvider;
                if (iCronetAppProvider == null) {
                } else {
                    iCronetAppProvider.onTncRequestSucceeded(z, z2, i);
                }
            } else {
                Object obj = this.mCronetAppProviderAdapter;
                if (obj == null) {
                } else {
                    ReflectWrap.on(obj).call("onTncRequestSucceeded", new Class[]{Boolean.TYPE, Boolean.TYPE, Integer.TYPE}, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i)).get();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
