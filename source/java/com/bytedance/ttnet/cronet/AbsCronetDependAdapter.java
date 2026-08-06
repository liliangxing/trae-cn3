package com.bytedance.ttnet.cronet;

import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.common.utility.concurrent.ThreadPlus;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetDepend;
import com.bytedance.frameworks.baselib.network.http.cronet.TTNetAppInfoSubset;
import com.bytedance.frameworks.baselib.network.http.storeregion.StoreRegionManager;
import com.bytedance.frameworks.baselib.network.http.util.ProcessUtils;
import com.bytedance.frameworks.baselib.network.utils.ReflectWrap;
import com.bytedance.ies.bullet.service.base.standard.visiblestate.ViewVisibleBridge;
import com.bytedance.ttnet.AbsOptionalTTNetDepend;
import com.bytedance.ttnet.HttpClient;
import com.bytedance.ttnet.TTMultiNetwork;
import com.bytedance.ttnet.TTNetInit;
import com.bytedance.ttnet.TTWiFiCellSwitcher;
import com.bytedance.ttnet.clientkey.ClientKeyManager;
import com.bytedance.ttnet.config.AppConfig;
import com.bytedance.ttnet.config.CronetRetryEventHandler;
import com.bytedance.ttnet.config.ExperimentalSwitches;
import com.bytedance.ttnet.config.JsonOptConfig;
import com.bytedance.ttnet.config.MultiProcStackOptConfig;
import com.bytedance.ttnet.httpdns.TTDnsOuterService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public abstract class AbsCronetDependAdapter implements ICronetDepend, ICronetAppProvider {
    private static final int MAX_ABSDK_VERSION_LENGTH = 5;
    private static final String TAG = "AbsCronetDependAdapter";

    public void doLoadLibrary(String str) {
    }

    public String getAbClient() {
        return "";
    }

    public String getAbFeature() {
        return "";
    }

    public String getAbFlag() {
        return "-1";
    }

    public List<String> getAbSdkVersion() {
        return null;
    }

    public String getAbVersion() {
        return "";
    }

    public String getAppId() {
        return "-1";
    }

    public String getAppInitialRegionInfo() {
        return "";
    }

    public String getAppName() {
        return "";
    }

    public long getAppStartTime() {
        return -1L;
    }

    public String getBypassBOEJSON() {
        return null;
    }

    public String getCarrierRegion() {
        return "";
    }

    public String getChannel() {
        return "";
    }

    public String getCityName() {
        return "";
    }

    public Map<String[], Pair<byte[], byte[]>> getClientOpaqueData() {
        return null;
    }

    public String getDeviceId() {
        return "";
    }

    public String getDevicePlatform() {
        return "android";
    }

    public String getGetDomainDefaultJSON() {
        return null;
    }

    public String getHttpDnsRequestFlags() {
        return ViewVisibleBridge.INVISIBLE;
    }

    public String getIId() {
        return "";
    }

    public String getIsDropFirstTnc() {
        return "";
    }

    public String getLanguage() {
        return "";
    }

    public boolean getLazyInitCronetIPC() {
        return false;
    }

    public String getManifestVersionCode() {
        return "-1";
    }

    public ArrayList<byte[]> getOpaqueData() {
        return null;
    }

    public String getOpenUdid() {
        return "";
    }

    public boolean getOptInit() {
        return false;
    }

    public boolean getOptNqeDefault() {
        return false;
    }

    public boolean getOptNqePersist() {
        return false;
    }

    public Map<String, Pair<Integer, Integer>> getQuicHint() {
        return null;
    }

    public String getRegion() {
        return "";
    }

    public String getSdkAppId() {
        return "";
    }

    public String getSdkVersion() {
        return "";
    }

    public String getSsCookieKey() {
        return "X-SS-Cookie";
    }

    public String getSsmix() {
        return "a";
    }

    public String getStoreIdc() {
        return "";
    }

    public String getStoreIdcRuleJSON() {
        return null;
    }

    public String getSysRegion() {
        return "";
    }

    public String getTNCRequestFlags() {
        return ViewVisibleBridge.INVISIBLE;
    }

    public Map<String, String> getTNCRequestHeader() {
        return null;
    }

    public String getUUID() {
        return "";
    }

    public String getUpdateVersionCode() {
        return "-1";
    }

    public String getUserId() {
        return "";
    }

    public String getVersionCode() {
        return "-1";
    }

    public String getVersionName() {
        return "";
    }

    public boolean isBOEProxyEnabled() {
        return false;
    }

    public boolean isEnableBrotli() {
        return false;
    }

    public boolean isEnableHttp2() {
        return true;
    }

    public boolean isEnableQuic() {
        return false;
    }

    public boolean needCustomLoadLibrary() {
        return false;
    }

    public void onCronetMappingRequestStatus(String str, int i) {
    }

    public void onEffectiveConnectionTypeChanged(int i) {
    }

    public void onNQEEffectiveConnectionTypeChanged(int i) {
    }

    public void onNQEPacketLossComputed(int i, double d, double d2, double d3, double d4) {
    }

    public void onNQERTTOrThroughputComputed(int i, int i2, int i3) {
    }

    public void onNetworkQualityLevelChanged(int i) {
    }

    public void onNetworkQualityRttAndThroughputNotified(int i, int i2, int i3) {
    }

    public void onPacketLossComputed(int i, double d, double d2, double d3, double d4) {
    }

    public void onRTTOrThroughputEstimatesComputed(int i, int i2, int i3) {
    }

    public void onTTNetDetectResult(String str) {
    }

    public void onTTNetworkStateChanged(int i) {
    }

    protected void onWiFiToCellStateChangedForApp(int i, int i2) {
    }

    public void sendAppMonitorEvent(String str, String str2) {
    }

    public void setAdapter(ICronetDepend iCronetDepend) {
    }

    public final void tryStartTTNetDetect(List<String> list, int i, int i2) {
    }

    public boolean loggerDebug() {
        return Logger.debug();
    }

    public void loggerD(String str, String str2) {
        Logger.d(str, str2);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.bytedance.ttnet.cronet.AbsCronetDependAdapter$1] */
    public void onServerConfigEtagChanged(final String str) {
        try {
            new ThreadPlus() { // from class: com.bytedance.ttnet.cronet.AbsCronetDependAdapter.1
                public void run() {
                    try {
                        AppConfig.getInstance(TTNetInit.getTTNetDepend().getContext()).setTncEtag(str);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }.start();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.bytedance.ttnet.cronet.AbsCronetDependAdapter$2] */
    public void onServerConfigABTestChanged(final String str) {
        try {
            new ThreadPlus() { // from class: com.bytedance.ttnet.cronet.AbsCronetDependAdapter.2
                public void run() {
                    try {
                        AppConfig.getInstance(TTNetInit.getTTNetDepend().getContext()).setTncABTest(str);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }.start();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.ttnet.cronet.AbsCronetDependAdapter$3] */
    public void onServerConfigUpdated(final String str) {
        try {
            if (Logger.debug()) {
                Logger.d(TAG, "config = " + str);
            }
            new ThreadPlus() { // from class: com.bytedance.ttnet.cronet.AbsCronetDependAdapter.3
                public void run() {
                    JsonOptConfig.JsonWrapper jsonWrapper;
                    try {
                        boolean z = false;
                        if (JsonOptConfig.isJsonOptEnable()) {
                            jsonWrapper = new JsonOptConfig.JsonWrapper(str, new JSONObject(str));
                            ExperimentalSwitches.onServerConfigChanged(jsonWrapper);
                            if (ExperimentalSwitches.isEnableJsonWrapperRefine()) {
                                z = true;
                            }
                        } else {
                            jsonWrapper = null;
                        }
                        if (z) {
                            AppConfig.getInstance(TTNetInit.getTTNetDepend().getContext()).handleConfigUpdate(str, jsonWrapper);
                            ClientKeyManager.inst().OnNetConfigChanged(jsonWrapper);
                        } else {
                            AppConfig appConfig = AppConfig.getInstance(TTNetInit.getTTNetDepend().getContext());
                            String str2 = str;
                            appConfig.handleConfigUpdate(str2, str2);
                            ClientKeyManager.inst().OnNetConfigChanged(str);
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }.start();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.ttnet.cronet.AbsCronetDependAdapter$4] */
    public final void onTTDnsResolveResult(final String str, final String str2, final int i, final int i2, final int i3, final List<String> list, final String str3) {
        if (Logger.debug()) {
            Logger.d(TAG, "onTTDnsResolveResult uuid = " + str + " host = " + str2);
        }
        new ThreadPlus() { // from class: com.bytedance.ttnet.cronet.AbsCronetDependAdapter.4
            public void run() {
                TTDnsOuterService.getInstance().HandleHttpdnsResult(str, str2, i, i2, i3, list, str3);
            }
        }.start();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.ttnet.cronet.AbsCronetDependAdapter$5] */
    public final void onTTNetDetectInfoChanged(final String str) {
        if (Logger.debug()) {
            Logger.d(TAG, "onTTNetDetectInfoChanged result = " + str);
        }
        new ThreadPlus() { // from class: com.bytedance.ttnet.cronet.AbsCronetDependAdapter.5
            public void run() {
                try {
                    AbsCronetDependAdapter.this.onTTNetDetectResult(str);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }.start();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.ttnet.cronet.AbsCronetDependAdapter$6] */
    public final void onMappingRequestStatus(final String str, final int i) {
        if (Logger.debug()) {
            Logger.d(TAG, "onMappingRequestStatus key = " + str + " status: " + i);
        }
        new ThreadPlus() { // from class: com.bytedance.ttnet.cronet.AbsCronetDependAdapter.6
            public void run() {
                AbsCronetDependAdapter.this.onCronetMappingRequestStatus(str, i);
            }
        }.start();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.ttnet.cronet.AbsCronetDependAdapter$7] */
    public final void onEffectiveConnectionTypeChangedOnIOThread(final int i) {
        if (Logger.debug()) {
            Logger.d(TAG, "onEffectiveConnectionTypeChangedOnIOThread type = " + i);
        }
        new ThreadPlus() { // from class: com.bytedance.ttnet.cronet.AbsCronetDependAdapter.7
            public void run() {
                AbsCronetDependAdapter.this.onEffectiveConnectionTypeChanged(i);
                AbsCronetDependAdapter.this.onNQEEffectiveConnectionTypeChanged(i);
            }
        }.start();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.ttnet.cronet.AbsCronetDependAdapter$8] */
    public final void onRTTOrThroughputEstimatesComputedOnIOThread(final int i, final int i2, final int i3) {
        if (Logger.debug()) {
            Logger.d(TAG, "onRTTOrThroughputEstimatesComputedOnIOThread httpRtt = " + i + ", transportRttMs = " + i2 + ",downstreamThroughputKbps = " + i3);
        }
        new ThreadPlus() { // from class: com.bytedance.ttnet.cronet.AbsCronetDependAdapter.8
            public void run() {
                AbsCronetDependAdapter.this.onRTTOrThroughputEstimatesComputed(i, i2, i3);
                AbsCronetDependAdapter.this.onNQERTTOrThroughputComputed(i, i2, i3);
            }
        }.start();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.ttnet.cronet.AbsCronetDependAdapter$9] */
    public final void onPacketLossComputedOnIOThread(final int i, final double d, final double d2, final double d3, final double d4) {
        if (Logger.debug()) {
            Logger.d(TAG, "onPacketLossComputed protocol = " + i + ", upstreamLossRate = " + d + ", upstreamLossRateVariance = " + d2 + ", downstreamLossRate = " + d3 + ", downstreamLossRateVariance = " + d4);
        }
        new ThreadPlus() { // from class: com.bytedance.ttnet.cronet.AbsCronetDependAdapter.9
            public void run() {
                AbsCronetDependAdapter.this.onPacketLossComputed(i, d, d2, d3, d4);
                AbsCronetDependAdapter.this.onNQEPacketLossComputed(i, d, d2, d3, d4);
            }
        }.start();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.ttnet.cronet.AbsCronetDependAdapter$10] */
    public final void onWiFiToCellStateChanged(final int i, final int i2) {
        if (Logger.debug()) {
            Logger.d(TAG, "onWiFiToCellStateChanged prev state = " + i + ", curr state = " + i2);
        }
        new ThreadPlus() { // from class: com.bytedance.ttnet.cronet.AbsCronetDependAdapter.10
            public void run() {
                try {
                    ReflectWrap.on(TTWiFiCellSwitcher.class).call("notifyWiFiToCellState", new Class[]{Integer.TYPE, Integer.TYPE}, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    AbsCronetDependAdapter.this.onWiFiToCellStateChangedForApp(i, i2);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }.start();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.ttnet.cronet.AbsCronetDependAdapter$11] */
    public final void onMultiNetworkStateChanged(final int i, final int i2) {
        if (Logger.debug()) {
            Logger.d(TAG, "onMultiNetStateChanged prev state = " + i + ", curr state = " + i2);
        }
        new ThreadPlus() { // from class: com.bytedance.ttnet.cronet.AbsCronetDependAdapter.11
            public void run() {
                try {
                    ReflectWrap.on(TTMultiNetwork.class).call("notifyMultiNetworkState", new Class[]{Integer.TYPE, Integer.TYPE}, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }.start();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.ttnet.cronet.AbsCronetDependAdapter$12] */
    public final void onUserSpecifiedNetworkEnabled(final boolean z) {
        if (Logger.debug()) {
            Logger.d(TAG, "onUserSpecifiedNetworkEnabled enable = " + z);
        }
        new ThreadPlus() { // from class: com.bytedance.ttnet.cronet.AbsCronetDependAdapter.12
            public void run() {
                try {
                    ReflectWrap.on(TTMultiNetwork.class).call("notifyUserSpecifiedNetworkEnabled", new Class[]{Boolean.TYPE}, new Object[]{Boolean.valueOf(z)});
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }.start();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.ttnet.cronet.AbsCronetDependAdapter$13] */
    public final void onNetworkQualityLevelChangedOnIOThread(final int i) {
        if (Logger.debug()) {
            Logger.d(TAG, "onNetworkQualityLevelChangedOnIOThread nql: " + i);
        }
        new ThreadPlus() { // from class: com.bytedance.ttnet.cronet.AbsCronetDependAdapter.13
            public void run() {
                AbsCronetDependAdapter.this.onNetworkQualityLevelChanged(i);
            }
        }.start();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.ttnet.cronet.AbsCronetDependAdapter$14] */
    public void onNetworkQualityRttAndThroughputNotifiedOnIOThread(final int i, final int i2, final int i3) {
        if (Logger.debug()) {
            Logger.d(TAG, "onNetworkQualityRttAndThroughputNotifiedOnIOThread, effectiveHrttMs: " + i + ", effectiveTrttMs: " + i2 + ", effectiveRxThroughputKbps: " + i3);
        }
        new ThreadPlus() { // from class: com.bytedance.ttnet.cronet.AbsCronetDependAdapter.14
            public void run() {
                AbsCronetDependAdapter.this.onNetworkQualityRttAndThroughputNotified(i, i2, i3);
            }
        }.start();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.ttnet.cronet.AbsCronetDependAdapter$15] */
    public final void onColdStartFinish() {
        if (Logger.debug()) {
            Logger.d(TAG, "onColdStartFinish");
        }
        new ThreadPlus() { // from class: com.bytedance.ttnet.cronet.AbsCronetDependAdapter.15
            public void run() {
                TTNetInit.notifyColdStartFinish();
            }
        }.start();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.ttnet.cronet.AbsCronetDependAdapter$16] */
    public final void onClientIPChanged(final String str) {
        if (Logger.debug()) {
            Logger.d(TAG, "onClientIPChanged");
        }
        new ThreadPlus() { // from class: com.bytedance.ttnet.cronet.AbsCronetDependAdapter.16
            public void run() {
                TTNetInit.onClientIPChanged(str);
            }
        }.start();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.ttnet.cronet.AbsCronetDependAdapter$17] */
    public void onPublicIPsChanged(final List<String> list, final List<String> list2) {
        if (Logger.debug()) {
            Logger.d(TAG, "onPublicIPsChanged");
        }
        new ThreadPlus() { // from class: com.bytedance.ttnet.cronet.AbsCronetDependAdapter.17
            public void run() {
                TTNetInit.onPublicIPsChanged(list, list2);
            }
        }.start();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.ttnet.cronet.AbsCronetDependAdapter$18] */
    public final void onStoreIdcChanged(final String str, final String str2, final String str3, final String str4, final String str5, final String str6) {
        if (Logger.debug()) {
            Logger.d(TAG, "onStoreIdcChanged");
        }
        new ThreadPlus() { // from class: com.bytedance.ttnet.cronet.AbsCronetDependAdapter.18
            public void run() {
                CronetDataStorageAccess.inst().onStoreIdcChanged(str, str2, str3, str4, str5, str6);
                StoreRegionManager.inst().saveStoreRegionForCronet(str, str2, str3, str4, str5, str6);
            }
        }.start();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.ttnet.cronet.AbsCronetDependAdapter$19] */
    public void onDropReasonChanged(final boolean z, final List<Integer> list) {
        if (Logger.debug()) {
            Logger.d(TAG, "onDropReasonChanged");
        }
        new ThreadPlus() { // from class: com.bytedance.ttnet.cronet.AbsCronetDependAdapter.19
            public void run() {
                CronetDropReasonAccess.inst().onDropReasonChanged(z, list);
            }
        }.start();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.ttnet.cronet.AbsCronetDependAdapter$20] */
    public final void onTNCUpdateFailed(final ArrayList<String> arrayList, final String str) {
        if (Logger.debug()) {
            Logger.d(TAG, "onTNCUpdateFailed");
        }
        new ThreadPlus() { // from class: com.bytedance.ttnet.cronet.AbsCronetDependAdapter.20
            public void run() {
                CronetRetryEventHandler.inst().updateConfigOnCronetFailed(arrayList, str);
            }
        }.start();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.ttnet.cronet.AbsCronetDependAdapter$21] */
    public void onCronetBootSucceed() {
        if (Logger.debug()) {
            Logger.d(TAG, "onCronetBootSucceed... ");
        }
        new ThreadPlus() { // from class: com.bytedance.ttnet.cronet.AbsCronetDependAdapter.21
            public void run() {
                AppConfig.getInstance(TTNetInit.getTTNetDepend().getContext()).resetCronetBootSucceed();
                HttpClient.setCronetBootSucceed(true);
            }
        }.start();
    }

    public String getRticket() {
        return String.valueOf(System.currentTimeMillis());
    }

    public String getNetAccessType() {
        return NetworkUtils.getNetworkAccessType(TTNetInit.getTTNetDepend().getContext());
    }

    public String getDeviceType() {
        return Build.MODEL;
    }

    public String getDeviceBrand() {
        return Build.BRAND;
    }

    public String getDeviceModel() {
        return Build.MODEL;
    }

    public String getAbi() {
        return Build.SUPPORTED_ABIS[0];
    }

    public String getOSApi() {
        return String.valueOf(Build.VERSION.SDK_INT);
    }

    public String getOSVersion() {
        try {
            String str = Build.VERSION.RELEASE;
            return (str == null || str.length() <= 10) ? str : str.substring(0, 10);
        } catch (Exception unused) {
            return "";
        }
    }

    public String getDPI() {
        int dpi = UIUtils.getDpi(TTNetInit.getTTNetDepend().getContext());
        return dpi > 0 ? String.valueOf(dpi) : "";
    }

    public String getResolution() {
        String screenResolution = UIUtils.getScreenResolution(TTNetInit.getTTNetDepend().getContext());
        return !StringUtils.isEmpty(screenResolution) ? screenResolution : "";
    }

    public Map<String, String> getGetDomainDependHostMap() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String[] configServers = TTNetInit.getTTNetDepend().getConfigServers();
        boolean z = false;
        if (configServers != null) {
            if (configServers.length > 0) {
                linkedHashMap.put("first", configServers[0]);
            }
            if (configServers.length > 1) {
                linkedHashMap.put("second", configServers[1]);
            }
            if (configServers.length > 2) {
                linkedHashMap.put("third", configServers[2]);
            }
        }
        Map<String, String> tTNetServiceDomainMap = TTNetInit.getTTNetDepend().getTTNetServiceDomainMap();
        if (TextUtils.isEmpty(tTNetServiceDomainMap.get(TTNetInit.DOMAIN_HTTPDNS_KEY)) || (TextUtils.isEmpty(tTNetServiceDomainMap.get(TTNetInit.DOMAIN_BOE_KEY)) && TextUtils.isEmpty(tTNetServiceDomainMap.get(TTNetInit.DOMAIN_BOE_HTTPS_KEY)))) {
            z = true;
        }
        if (z) {
            throw new IllegalArgumentException("You must set HttpDns, NetLog and BOE service domain, please refer to TTNet access documents.");
        }
        linkedHashMap.putAll(tTNetServiceDomainMap);
        return linkedHashMap;
    }

    public Map<String, String> getTNCRequestQuery() {
        Object tTNetDepend = TTNetInit.getTTNetDepend();
        if (tTNetDepend == null || !(tTNetDepend instanceof AbsOptionalTTNetDepend)) {
            return null;
        }
        return ((AbsOptionalTTNetDepend) tTNetDepend).getTNCExtraParam();
    }

    public Map<String, String> onCallToAddSecurityFactor(String str, Map<String, String> map) {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(entry.getValue());
            hashMap.put(entry.getKey(), arrayList);
        }
        return NetworkParams.tryAddSecurityFactor(str, hashMap);
    }

    public String getCronetSoPath() {
        return AppConfig.getInstance(TTNetInit.getTTNetDepend().getContext()).getCronetSoPath();
    }

    public final int getProcessFlag() {
        return ProcessUtils.getProcessFlag();
    }

    public int getWifiFrequency() {
        if (TTNetInit.getSystemApiSandbox() == null) {
            return 0;
        }
        return TTNetInit.getSystemApiSandbox().getWifiFrequency();
    }

    public int getWifiRssi() {
        if (TTNetInit.getSystemApiSandbox() == null) {
            return 0;
        }
        return TTNetInit.getSystemApiSandbox().getWifiRssi();
    }

    public String getNetworkOperator() {
        return TTNetInit.getSystemApiSandbox() == null ? "" : TTNetInit.getSystemApiSandbox().getNetworkOperator();
    }

    public String getSimOperator() {
        return TTNetInit.getSystemApiSandbox() == null ? "" : TTNetInit.getSystemApiSandbox().getSimOperator();
    }

    public TTNetAppInfoSubset getAppInfoSubset() {
        TTNetAppInfoSubset tTNetAppInfoSubset = new TTNetAppInfoSubset();
        List<String> abSdkVersion = getAbSdkVersion();
        String str = "";
        if (abSdkVersion != null) {
            int i = 0;
            for (String str2 : abSdkVersion) {
                i++;
                if (i > 5) {
                    break;
                }
                if (!TextUtils.isEmpty(str2)) {
                    str = str + str2 + ",";
                }
            }
        }
        tTNetAppInfoSubset.mAbSdkVersion = str;
        String[] configServers = TTNetInit.getTTNetDepend().getConfigServers();
        if (configServers != null) {
            if (configServers.length > 0) {
                tTNetAppInfoSubset.mHostFirst = configServers[0];
            }
            if (configServers.length > 1) {
                tTNetAppInfoSubset.mHostSecond = configServers[1];
            }
            if (configServers.length > 2) {
                tTNetAppInfoSubset.mHostThird = configServers[2];
            }
        }
        Map<String, String> tTNetServiceDomainMap = TTNetInit.getTTNetDepend().getTTNetServiceDomainMap();
        String str3 = tTNetServiceDomainMap.get(TTNetInit.DOMAIN_HTTPDNS_KEY);
        if (str3 != null && !TextUtils.isEmpty(str3)) {
            tTNetAppInfoSubset.mDomainHttpDns = str3;
        }
        String str4 = tTNetServiceDomainMap.get(TTNetInit.DOMAIN_BOE_KEY);
        if (str4 != null && !TextUtils.isEmpty(str4)) {
            tTNetAppInfoSubset.mDomainBoe = str4;
        }
        String str5 = tTNetServiceDomainMap.get(TTNetInit.DOMAIN_BOE_HTTPS_KEY);
        if (str5 != null && !TextUtils.isEmpty(str5)) {
            tTNetAppInfoSubset.mDomainBoeHttps = str5;
        }
        tTNetAppInfoSubset.mInitRegion = getAppInitialRegionInfo();
        return tTNetAppInfoSubset;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.ttnet.cronet.AbsCronetDependAdapter$22] */
    public void onTncRequestSucceeded(final boolean z, final boolean z2, final int i) {
        try {
            if (Logger.debug()) {
                Logger.d(TAG, "stackOptEnabled = " + z);
            }
            new ThreadPlus() { // from class: com.bytedance.ttnet.cronet.AbsCronetDependAdapter.22
                public void run() {
                    try {
                        MultiProcStackOptConfig.inst(TTNetInit.getTTNetDepend().getContext()).onTncRequestSucceeded(z, z2, i);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }.start();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
