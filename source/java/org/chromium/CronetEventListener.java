package org.chromium;

import android.os.Process;
import com.bytedance.common.utility.concurrent.TTExecutors;
import com.bytedance.frameworks.baselib.network.TTNetInitMetrics;
import com.bytedance.frameworks.baselib.network.http.NativeRequestInterceptor;
import com.bytedance.retrofit2.mime.TTRequestCompressManager;
import com.ttnet.org.chromium.net.TTEventListener;
import com.ttnet.org.chromium.net.impl.TTCronetInitTimingInfo;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class CronetEventListener extends TTEventListener {
    private static volatile CronetEventListener sInstance;
    private boolean isMainProcess = false;
    private boolean enableOptInit = false;

    public static CronetEventListener inst() {
        if (sInstance == null) {
            synchronized (CronetEventListener.class) {
                if (sInstance == null) {
                    sInstance = new CronetEventListener();
                }
            }
        }
        return sInstance;
    }

    private CronetEventListener() {
    }

    public void setIsMainProcess(boolean z) {
        this.isMainProcess = z;
    }

    public void enableOptInit(boolean z) {
        this.enableOptInit = z;
    }

    public void onServerConfigUpdated(String str, String str2, String str3) {
        if (this.isMainProcess) {
            CronetAppProviderManager.inst().onServerConfigUpdated(str, str2, str3);
        }
    }

    public void onTTNetDetectInfoChanged(String str) {
        if (this.isMainProcess) {
            CronetAppProviderManager.inst().onTTNetDetectInfoChanged(str);
        }
    }

    public void onTTDnsResolveResult(String str, String str2, int i, int i2, int i3, List<String> list, String str3) {
        CronetAppProviderManager.inst().onTTDnsResolveResult(str, str2, i, i2, i3, list, str3);
    }

    public void onMappingRequestStatus(String str, int i) {
        if (this.isMainProcess) {
            CronetAppProviderManager.inst().onMappingRequestStatus(str, i);
        }
    }

    public void onColdStartFinish() {
        if (this.isMainProcess) {
            CronetAppProviderManager.inst().onColdStartFinish();
        }
    }

    public void onEffectiveConnectionTypeChanged(int i) {
        CronetAppProviderManager.inst().onEffectiveConnectionTypeChanged(i);
    }

    public void onRTTOrThroughputEstimatesComputed(int i, int i2, int i3) {
        CronetAppProviderManager.inst().onRTTOrThroughputEstimatesComputed(i, i2, i3);
    }

    public void onPacketLossComputed(int i, double d, double d2, double d3, double d4) {
        CronetAppProviderManager.inst().onPacketLossComputed(i, d, d2, d3, d4);
    }

    public void onNetworkQualityTypeChangedV3(int i) {
        CronetAppProviderManager.inst().onNetworkQualityTypeChangedV3(i);
    }

    public void onClientIPChanged(String str) {
        if (this.isMainProcess) {
            CronetAppProviderManager.inst().onClientIPChanged(str);
        }
    }

    public void onTLBDecompressFail() {
        TTRequestCompressManager.setGlobalForbidenCompress();
    }

    public void onPublicIPsChanged(List<String> list, List<String> list2) {
        if (this.isMainProcess) {
            CronetAppProviderManager.inst().onPublicIPsChanged(list, list2);
        }
    }

    public void onStoreIdcChanged(String str, String str2, String str3, String str4, String str5, String str6) {
        if (this.isMainProcess) {
            CronetAppProviderManager.inst().onStoreIdcChanged(str, str2, str3, str4, str5, str6);
        }
    }

    public void onDropReasonChanged(boolean z, List<Integer> list) {
        if (this.isMainProcess) {
            CronetAppProviderManager.inst().onDropReasonChanged(z, list);
        }
    }

    public void onTNCUpdateFailed(String[] strArr, String str) {
        if (this.isMainProcess) {
            CronetAppProviderManager.inst().onTNCUpdateFailed(strArr, str);
        }
    }

    public Map<String, String> onCallToAddSecurityFactor(String str, Map<String, String> map) {
        return CronetAppProviderManager.inst().onCallToAddSecurityFactor(str, map);
    }

    public String onRequestInterceptorToStart(String str, Map<String, String> map, List<String> list) {
        return NativeRequestInterceptor.onCallRequestInterceptorToStart(str, map, list);
    }

    public String onResponseInterceptorToStart(String str, Map<String, List<String>> map, int i) {
        return NativeRequestInterceptor.onCallResponseInterceptorToStart(str, map, i);
    }

    public void onContextInitCompleted(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16) {
        if (this.enableOptInit) {
            TTNetInitMetrics.setCronetInitSuccess(true);
        }
        TTNetInitMetrics inst = TTNetInitMetrics.inst();
        inst.netThreadPriority = Process.getThreadPriority(0);
        inst.initThreadStart = TTCronetInitTimingInfo.sInitThreadStart;
        inst.initThreadEnd = TTCronetInitTimingInfo.sInitThreadEnd;
        inst.loadCronetSoStart = TTCronetInitTimingInfo.sLoadCronetSoStart;
        inst.loadCronetSoEnd = TTCronetInitTimingInfo.sLoadCronetSoEnd;
        inst.cronetInitTimingInfoJsonStr = TTCronetInitTimingInfo.sNativeInitTimingJson;
        inst.abTestStr = TTCronetInitTimingInfo.sABTest;
        inst.cronetInitEnd = System.nanoTime();
        inst.networkThreadStartTime = j;
        inst.networkThreadEndTime = j2;
        inst.executeWaitingTaskEndTime = j3;
        inst.preconnectStartTime = j4;
        inst.nqeInitDuration = j5;
        inst.prefsInitDuration = j6;
        inst.channelInitDuration = j7;
        inst.contextBuilderDuration = j8;
        inst.tncConfigDuration = j9;
        inst.updateAppinfoDuration = j10;
        inst.netlogInitDuration = j11;
        inst.nqeDetectDuration = j12;
        inst.preconnectDuration = j13;
        inst.sslSessionDuration = j14;
        inst.ttnetConfigDuration = j15;
        inst.installCertDuration = j16;
        final long appStartTime = CronetAppProviderManager.inst().getAppStartTime();
        if (!TTNetInitMetrics.inst().checkTTNetLayerInitComplete()) {
            TTExecutors.getScheduledThreadPool().schedule(new Runnable() { // from class: org.chromium.CronetEventListener.1
                @Override // java.lang.Runnable
                public void run() {
                    JSONObject constructTTNetInitTimingInfo = TTNetInitMetrics.inst().constructTTNetInitTimingInfo();
                    JSONObject constructTTNetInitTimingInfoV2 = TTNetInitMetrics.inst().constructTTNetInitTimingInfoV2(appStartTime);
                    CronetAppProviderManager.inst().sendAppMonitorEvent(constructTTNetInitTimingInfo.toString(), "ttnet_init");
                    CronetAppProviderManager.inst().sendAppMonitorEvent(constructTTNetInitTimingInfoV2.toString(), "ttnet_init_v2");
                }
            }, 5L, TimeUnit.SECONDS);
            if (this.enableOptInit) {
                return;
            }
            TTNetInitMetrics.setCronetInitSuccess(true);
            return;
        }
        JSONObject constructTTNetInitTimingInfo = TTNetInitMetrics.inst().constructTTNetInitTimingInfo();
        JSONObject constructTTNetInitTimingInfoV2 = TTNetInitMetrics.inst().constructTTNetInitTimingInfoV2(appStartTime);
        if (!this.enableOptInit) {
            TTNetInitMetrics.setCronetInitSuccess(true);
        }
        CronetAppProviderManager.inst().sendAppMonitorEvent(constructTTNetInitTimingInfo.toString(), "ttnet_init");
        CronetAppProviderManager.inst().sendAppMonitorEvent(constructTTNetInitTimingInfoV2.toString(), "ttnet_init_v2");
    }

    public void onCronetBootSucceed() {
        if (this.isMainProcess) {
            CronetAppProviderManager.inst().onCronetBootSucceed();
        }
    }

    public void onWiFiToCellStateChanged(int i, int i2) {
        CronetAppProviderManager.inst().onWiFiToCellStateChanged(i, i2);
    }

    public void onMultiNetworkStateChanged(int i, int i2) {
        CronetAppProviderManager.inst().onMultiNetworkStateChanged(i, i2);
    }

    public void onUserSpecifiedNetworkEnabled(boolean z) {
        CronetAppProviderManager.inst().onUserSpecifiedNetworkEnabled(z);
    }

    public void onNetworkQualityLevelChanged(int i) {
        CronetAppProviderManager.inst().onNetworkQualityLevelChanged(i);
    }

    public void onNetworkQualityRttAndThroughputNotified(int i, int i2, int i3) {
        CronetAppProviderManager.inst().onNetworkQualityRttAndThroughputNotified(i, i2, i3);
    }

    public void onTncRequestSucceeded(boolean z, boolean z2, int i) {
        CronetAppProviderManager.inst().onTncRequestSucceeded(z, z2, i);
    }
}
