package com.bytedance.trae.network.ttnet;

import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import androidx.core.os.BundleKt;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.apm.ApmAgent;
import com.bytedance.iesgurd.exception.BytePatchException;
import com.bytedance.lynx.service.reporter.performance.LynxTimingPerformanceReportProcessor;
import com.bytedance.trae.applog.api.IApplog;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.network.ConnectionTypeListener;
import com.bytedance.trae.network.HttpConst;
import com.bytedance.trae.network.TraeTTNet;
import com.bytedance.trae.platform.service.ApplogService;
import com.bytedance.trae.utils.AppLocaleUtils;
import com.bytedance.ttnet.TTWiFiCellSwitcher;
import com.bytedance.ttnet.cronet.AbsCronetDependAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: TTNetExt.kt */
@Metadata(d1 = {"\u0000I\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003*\u0001\u0010\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0005H\u0016J\u0018\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0005H\u0016J\u0010\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u000bH\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u0005H\u0016J\b\u0010\u001f\u001a\u00020\u0005H\u0016J\b\u0010 \u001a\u00020\u0005H\u0016J\b\u0010!\u001a\u00020\u0005H\u0016J\b\u0010\"\u001a\u00020\u0005H\u0016J\b\u0010#\u001a\u00020\u0005H\u0016J\b\u0010$\u001a\u00020\u0005H\u0016J\b\u0010%\u001a\u00020\u0005H\u0016J\b\u0010&\u001a\u00020\u0005H\u0016J\b\u0010'\u001a\u00020\u0005H\u0016J\b\u0010(\u001a\u00020\u0005H\u0016J\b\u0010)\u001a\u00020\u0005H\u0016J\b\u0010*\u001a\u00020\u0005H\u0016J\b\u0010+\u001a\u00020\u0005H\u0016J\b\u0010,\u001a\u00020\u0005H\u0016J\b\u0010-\u001a\u00020\u0005H\u0016J\b\u0010.\u001a\u00020\u0005H\u0016J\u0010\u0010/\u001a\n\u0012\u0004\u0012\u000201\u0018\u000100H\u0016J\n\u00102\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u00103\u001a\u00020\u0007H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001f\u0010\t\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011¨\u00064"}, d2 = {"Lcom/bytedance/trae/network/ttnet/CronetDependAdapter;", "Lcom/bytedance/ttnet/cronet/AbsCronetDependAdapter;", "<init>", "()V", "TAG", "", "auto4GStartTime", "", "trafficBytesStart", "multiNetworkState", "Landroidx/lifecycle/MutableLiveData;", "", "kotlin.jvm.PlatformType", "getMultiNetworkState", "()Landroidx/lifecycle/MutableLiveData;", "ttSwitcherObserver", "com/bytedance/trae/network/ttnet/CronetDependAdapter$ttSwitcherObserver$1", "Lcom/bytedance/trae/network/ttnet/CronetDependAdapter$ttSwitcherObserver$1;", "onServerConfigUpdated", "", "config", "doLoadLibrary", "s", "sendAppMonitorEvent", "logContent", "logType", "onEffectiveConnectionTypeChanged", "type", "loggerDebug", "", "getIId", "getDeviceId", "getUserId", "getAppId", "getAppName", "getSdkAppId", "getSdkVersion", "getChannel", "getVersionCode", "getVersionName", "getUpdateVersionCode", "getManifestVersionCode", "getRegion", "getSysRegion", "getCarrierRegion", "getLanguage", "getGetDomainDefaultJSON", "getOpaqueData", "Ljava/util/ArrayList;", "", "getStoreIdcRuleJSON", "nowBytes", "ttnet_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class CronetDependAdapter extends AbsCronetDependAdapter {
    private static final String TAG = "CronetDependAdapter";
    private static long auto4GStartTime;
    private static long trafficBytesStart;
    private static final CronetDependAdapter$ttSwitcherObserver$1 ttSwitcherObserver;
    public static final CronetDependAdapter INSTANCE = new CronetDependAdapter();
    private static final MutableLiveData<Integer> multiNetworkState = new MutableLiveData<>(Integer.valueOf(TTWiFiCellSwitcher.State.STOPPED.code()));

    @Override // com.bytedance.ttnet.cronet.AbsCronetDependAdapter
    public void doLoadLibrary(String s) {
        Intrinsics.checkNotNullParameter(s, "s");
    }

    private CronetDependAdapter() {
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.trae.network.ttnet.CronetDependAdapter$ttSwitcherObserver$1] */
    static {
        ?? r0 = new TTWiFiCellSwitcher.Observer() { // from class: com.bytedance.trae.network.ttnet.CronetDependAdapter$ttSwitcherObserver$1
            @Override // com.bytedance.ttnet.TTWiFiCellSwitcher.Observer
            public void onStateChanged(TTWiFiCellSwitcher.State previousState, TTWiFiCellSwitcher.State currentState) {
                long nowBytes;
                long j;
                long nowBytes2;
                long j2;
                Intrinsics.checkNotNullParameter(previousState, "previousState");
                Intrinsics.checkNotNullParameter(currentState, "currentState");
                CronetDependAdapter.INSTANCE.getMultiNetworkState().postValue(Integer.valueOf(currentState.code()));
                if (previousState == TTWiFiCellSwitcher.State.WIFI_WITH_CELLULAR_TRANS_DATA) {
                    ApplogService applogService = ApplogService.INSTANCE;
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    j = CronetDependAdapter.auto4GStartTime;
                    nowBytes2 = CronetDependAdapter.INSTANCE.nowBytes();
                    j2 = CronetDependAdapter.trafficBytesStart;
                    applogService.reportEvent("flow_network_auto_4g_end", BundleKt.bundleOf(new Pair[]{TuplesKt.to(LynxTimingPerformanceReportProcessor.KEY_DURATION, Long.valueOf((elapsedRealtime - j) / BytePatchException.ErrorCode.paramsError)), TuplesKt.to("data_size", Long.valueOf((nowBytes2 - j2) / 1024))}));
                }
                if (currentState == TTWiFiCellSwitcher.State.WAIT_USER_ALLOW_TO_CELLULAR || currentState != TTWiFiCellSwitcher.State.WIFI_WITH_CELLULAR_TRANS_DATA) {
                    return;
                }
                CronetDependAdapter cronetDependAdapter = CronetDependAdapter.INSTANCE;
                CronetDependAdapter.auto4GStartTime = SystemClock.elapsedRealtime();
                CronetDependAdapter cronetDependAdapter2 = CronetDependAdapter.INSTANCE;
                nowBytes = CronetDependAdapter.INSTANCE.nowBytes();
                CronetDependAdapter.trafficBytesStart = nowBytes;
                ApplogService.INSTANCE.reportEvent("flow_network_auto_4g_start", BundleKt.bundleOf());
            }
        };
        ttSwitcherObserver = r0;
        try {
            Result.Companion companion = Result.Companion;
            TTWiFiCellSwitcher.inst().registerObserver((TTWiFiCellSwitcher.Observer) r0, null);
            Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
    }

    public final MutableLiveData<Integer> getMultiNetworkState() {
        return multiNetworkState;
    }

    @Override // com.bytedance.ttnet.cronet.AbsCronetDependAdapter
    public void onServerConfigUpdated(String config) {
        super.onServerConfigUpdated(config);
    }

    @Override // com.bytedance.ttnet.cronet.AbsCronetDependAdapter
    public void sendAppMonitorEvent(String logContent, String logType) {
        Intrinsics.checkNotNullParameter(logContent, "logContent");
        Intrinsics.checkNotNullParameter(logType, "logType");
        try {
            ApmAgent.monitorCommonLog(logType, new JSONObject(logContent));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.bytedance.ttnet.cronet.AbsCronetDependAdapter
    public void onEffectiveConnectionTypeChanged(int type) {
        Iterator<T> it = TTNetExt.INSTANCE.getConnectionTypeListeners().iterator();
        while (it.hasNext()) {
            ((ConnectionTypeListener) it.next()).onEffectiveConnectionTypeChanged(type);
        }
    }

    @Override // com.bytedance.ttnet.cronet.AbsCronetDependAdapter
    public boolean loggerDebug() {
        return AppHost.Companion.isDebug() || StringsKt.equals("local_test", AppHost.Companion.getBuildChannel(), true);
    }

    @Override // com.bytedance.ttnet.cronet.AbsCronetDependAdapter
    public String getIId() {
        return IApplog.Companion.getInstallId();
    }

    @Override // com.bytedance.ttnet.cronet.AbsCronetDependAdapter
    public String getDeviceId() {
        return IApplog.Companion.getDeviceId();
    }

    @Override // com.bytedance.ttnet.cronet.AbsCronetDependAdapter
    public String getUserId() {
        return IApplog.Companion.getUserID();
    }

    @Override // com.bytedance.ttnet.cronet.AbsCronetDependAdapter
    public String getAppId() {
        return String.valueOf(AppHost.Companion.getAppId());
    }

    @Override // com.bytedance.ttnet.cronet.AbsCronetDependAdapter
    public String getAppName() {
        return AppHost.Companion.getAppName();
    }

    @Override // com.bytedance.ttnet.cronet.AbsCronetDependAdapter
    public String getSdkAppId() {
        return String.valueOf(AppHost.Companion.getAppId());
    }

    @Override // com.bytedance.ttnet.cronet.AbsCronetDependAdapter
    public String getSdkVersion() {
        return AppHost.Companion.getVersionName();
    }

    @Override // com.bytedance.ttnet.cronet.AbsCronetDependAdapter
    public String getChannel() {
        return AppHost.Companion.getBuildChannel();
    }

    @Override // com.bytedance.ttnet.cronet.AbsCronetDependAdapter
    public String getVersionCode() {
        return String.valueOf(AppHost.Companion.getVersionCode());
    }

    @Override // com.bytedance.ttnet.cronet.AbsCronetDependAdapter
    public String getVersionName() {
        return AppHost.Companion.getVersionName();
    }

    @Override // com.bytedance.ttnet.cronet.AbsCronetDependAdapter
    public String getUpdateVersionCode() {
        return String.valueOf(AppHost.Companion.getUpdateVersionCode());
    }

    @Override // com.bytedance.ttnet.cronet.AbsCronetDependAdapter
    public String getManifestVersionCode() {
        return String.valueOf(AppHost.Companion.getManifestVersionCode());
    }

    @Override // com.bytedance.ttnet.cronet.AbsCronetDependAdapter
    public String getRegion() {
        String country = AppLocaleUtils.INSTANCE.getAppLocale().getCountry();
        Intrinsics.checkNotNullExpressionValue(country, "getCountry(...)");
        return country;
    }

    @Override // com.bytedance.ttnet.cronet.AbsCronetDependAdapter
    public String getSysRegion() {
        String country = AppLocaleUtils.INSTANCE.getSysLocale().getCountry();
        Intrinsics.checkNotNullExpressionValue(country, "getCountry(...)");
        return country;
    }

    @Override // com.bytedance.ttnet.cronet.AbsCronetDependAdapter
    public String getCarrierRegion() {
        String carrierRegion = AppLocaleUtils.INSTANCE.getCarrierRegion();
        return carrierRegion == null ? "" : carrierRegion;
    }

    @Override // com.bytedance.ttnet.cronet.AbsCronetDependAdapter
    public String getLanguage() {
        String language = AppLocaleUtils.INSTANCE.getAppLocale().getLanguage();
        Intrinsics.checkNotNullExpressionValue(language, "getLanguage(...)");
        return language;
    }

    @Override // com.bytedance.ttnet.cronet.AbsCronetDependAdapter
    public String getGetDomainDefaultJSON() {
        return AppHost.Companion.isOversea() ? "{\"data\":{\"tnc_update_interval\":300,\"chromium_open\":1,\"http_dns_enabled\":1,\"ttnet_http_dns_enabled\":1,\"ttnet_tt_http_dns\":1,\"ttnet_http_dns_timeout\":5,\"opaque_data_enabled\":0,\"wpad_enabled\":0,\"pac_enabled\":1,\"clear_pool_enabled\":1,\"get_domain_default_json\":1,\"md5_check\":0},\"message\":\"success\"}" : "{}";
    }

    @Override // com.bytedance.ttnet.cronet.AbsCronetDependAdapter
    public ArrayList<byte[]> getOpaqueData() {
        if ((AppHost.Companion.isDebug() || AppHost.Companion.isTestChannel() || !TTNetExt.INSTANCE.getEnableAntiSniffing()) && !TraeTTNet.INSTANCE.getOpaqueDataEnable()) {
            return super.getOpaqueData();
        }
        return OpaqueData.INSTANCE.getOpaqueDataList();
    }

    @Override // com.bytedance.ttnet.cronet.AbsCronetDependAdapter
    public String getStoreIdcRuleJSON() {
        if (AppHost.Companion.isOversea()) {
            return "{\"update_store_idc_path_list\": [\"/service/*/device_register/\", \"/service/*/device_register_only/\", \"/passport/*\"],\"add_store_idc_host_list\": [\"*." + HttpConst.INSTANCE.getONLINE_BASE_HOST_API() + "\"]}";
        }
        return super.getStoreIdcRuleJSON();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long nowBytes() {
        return TrafficStats.getUidRxBytes(Process.myUid()) + TrafficStats.getUidTxBytes(Process.myUid());
    }
}
