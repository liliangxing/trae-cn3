package com.bytedance.timonbase.scene.config;

import com.bytedance.sdk.xbridge.cn.p003ui.utils.StatusBarUtils;
import com.bytedance.timonbase.TMEnv;
import com.bytedance.timonbase.TMInjection;
import com.bytedance.timonbase.config.TMConfigService;
import com.bytedance.timonbase.report.TMDataCollector;
import com.bytedance.timonkit.TimonConstant;
import kotlin.Metadata;
import kotlin.collections.MapsKt;

/* compiled from: SenseConfigManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\fJ\u0006\u0010\u000e\u001a\u00020\nJ\u0006\u0010\u000f\u001a\u00020\nJ\u0006\u0010\u0010\u001a\u00020\fJ\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0012J\u0006\u0010\u0014\u001a\u00020\nJ\n\u0010\u0015\u001a\u0004\u0018\u00010\u0006H\u0002J\u0006\u0010\u0016\u001a\u00020\fJ\u0006\u0010\u0017\u001a\u00020\nJ\u0006\u0010\u0018\u001a\u00020\nJ\u0006\u0010\u0019\u001a\u00020\bJ\u0006\u0010\u001a\u001a\u00020\nJ\u0006\u0010\u001b\u001a\u00020\u0012R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/bytedance/timonbase/scene/config/SenseConfigManager;", "", "()V", "TAG", "", "senseConfig", "Lcom/bytedance/timonbase/scene/config/SenseConfig;", "backgroundTolerableDuration", "", "canUseRunningAppProcesses", "", "coldLaunchDurationThreshold", "", "coldLaunchSceneDurationThreshold", "coldLaunchSceneEnable", "enableStrictBackgroundScene", "enterBackgroundDurationThreshold", "fetchConfig", "", "forbidSilence", "foregroundUseBroadcast", "getSenseConfig", "hotLaunchSceneDurationThreshold", "hotLaunchSceneEnable", "multiProcessEnable", "silenceThreshold", "silentSceneEnable", "updateConfig", "timonbase_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class SenseConfigManager {
    public static final SenseConfigManager INSTANCE = new SenseConfigManager();
    private static final String TAG = "SenseConfigManager";
    private static SenseConfig senseConfig;

    private SenseConfigManager() {
    }

    public final void fetchConfig() {
        SenseConfig senseConfig2 = getSenseConfig();
        if (senseConfig2 != null) {
            senseConfig = senseConfig2;
        }
    }

    public final boolean silentSceneEnable() {
        SenseConfig senseConfig2 = senseConfig;
        if (senseConfig2 != null) {
            return senseConfig2.getSilenceEnable();
        }
        return false;
    }

    public final boolean multiProcessEnable() {
        SenseConfig senseConfig2 = senseConfig;
        if (senseConfig2 != null) {
            return senseConfig2.getMultiProcessEnable();
        }
        return false;
    }

    public final boolean foregroundUseBroadcast() {
        SenseConfig senseConfig2 = senseConfig;
        if (senseConfig2 != null) {
            return senseConfig2.getForegroundUseBroadcast();
        }
        return false;
    }

    public final long silenceThreshold() {
        SenseConfig senseConfig2 = senseConfig;
        if (senseConfig2 != null) {
            return senseConfig2.getSilenceThreshold();
        }
        return 600000L;
    }

    public final long backgroundTolerableDuration() {
        SenseConfig senseConfig2 = senseConfig;
        if (senseConfig2 != null) {
            return senseConfig2.getBackgroundTolerableDuration();
        }
        return 0L;
    }

    public final boolean canUseRunningAppProcesses() {
        SenseConfig senseConfig2 = senseConfig;
        if (senseConfig2 != null) {
            return senseConfig2.getCanUseRunningAppProcesses();
        }
        return false;
    }

    public final boolean enableStrictBackgroundScene() {
        StrictBackgroundScene strictBackgroundScene;
        SenseConfig senseConfig2 = senseConfig;
        if (senseConfig2 == null || (strictBackgroundScene = senseConfig2.getStrictBackgroundScene()) == null) {
            return false;
        }
        return strictBackgroundScene.getEnable();
    }

    public final int coldLaunchDurationThreshold() {
        StrictBackgroundScene strictBackgroundScene;
        SenseConfig senseConfig2 = senseConfig;
        if (senseConfig2 == null || (strictBackgroundScene = senseConfig2.getStrictBackgroundScene()) == null) {
            return Integer.MAX_VALUE;
        }
        return strictBackgroundScene.getColdLaunchDurationThreshold();
    }

    public final int enterBackgroundDurationThreshold() {
        StrictBackgroundScene strictBackgroundScene;
        SenseConfig senseConfig2 = senseConfig;
        if (senseConfig2 == null || (strictBackgroundScene = senseConfig2.getStrictBackgroundScene()) == null) {
            return Integer.MAX_VALUE;
        }
        return strictBackgroundScene.getEnterBackgroundDurationThreshold();
    }

    public final boolean coldLaunchSceneEnable() {
        ColdLaunchScene coldLaunchScene;
        SenseConfig senseConfig2 = senseConfig;
        if (senseConfig2 == null || (coldLaunchScene = senseConfig2.getColdLaunchScene()) == null) {
            return false;
        }
        return coldLaunchScene.getEnable();
    }

    public final int coldLaunchSceneDurationThreshold() {
        ColdLaunchScene coldLaunchScene;
        SenseConfig senseConfig2 = senseConfig;
        if (senseConfig2 == null || (coldLaunchScene = senseConfig2.getColdLaunchScene()) == null) {
            return -1;
        }
        return coldLaunchScene.getColdLaunchDurationThreshold();
    }

    public final boolean hotLaunchSceneEnable() {
        HotLaunchScene hotLaunchScene;
        SenseConfig senseConfig2 = senseConfig;
        if (senseConfig2 == null || (hotLaunchScene = senseConfig2.getHotLaunchScene()) == null) {
            return false;
        }
        return hotLaunchScene.getEnable();
    }

    public final int hotLaunchSceneDurationThreshold() {
        HotLaunchScene hotLaunchScene;
        SenseConfig senseConfig2 = senseConfig;
        if (senseConfig2 == null || (hotLaunchScene = senseConfig2.getHotLaunchScene()) == null) {
            return -1;
        }
        return hotLaunchScene.getHotLaunchDurationThreshold();
    }

    public final void updateConfig() {
        SenseConfig copy;
        if (TMEnv.INSTANCE.isInitOpt()) {
            getSenseConfig();
            return;
        }
        SenseConfig senseConfig2 = getSenseConfig();
        if (senseConfig2 != null) {
            SenseConfig senseConfig3 = senseConfig;
            if (senseConfig3 == null) {
                senseConfig3 = senseConfig2;
            }
            copy = senseConfig2.copy((r24 & 1) != 0 ? senseConfig2.silenceEnable : senseConfig3.getSilenceEnable(), (r24 & 2) != 0 ? senseConfig2.silenceThreshold : 0L, (r24 & 4) != 0 ? senseConfig2.multiProcessEnable : false, (r24 & 8) != 0 ? senseConfig2.foregroundUseBroadcast : false, (r24 & 16) != 0 ? senseConfig2.canUseRunningAppProcesses : false, (r24 & 32) != 0 ? senseConfig2.backgroundTolerableDuration : 0L, (r24 & 64) != 0 ? senseConfig2.strictBackgroundScene : null, (r24 & 128) != 0 ? senseConfig2.coldLaunchScene : null, (r24 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? senseConfig2.hotLaunchScene : null);
            senseConfig = copy;
        }
    }

    private final SenseConfig getSenseConfig() {
        try {
            return (SenseConfig) TMInjection.INSTANCE.getGson().fromJson(TMConfigService.INSTANCE.getConfigJson(TimonConstant.CONFIG_KEY_SCENE_CONFIG), SenseConfig.class);
        } catch (Exception e) {
            TMDataCollector.INSTANCE.reportException("", e, "getSenseConfig failed", MapsKt.emptyMap(), false);
            return null;
        }
    }

    public final void forbidSilence() {
        SenseConfig senseConfig2 = senseConfig;
        senseConfig = senseConfig2 != null ? senseConfig2.copy((r24 & 1) != 0 ? senseConfig2.silenceEnable : false, (r24 & 2) != 0 ? senseConfig2.silenceThreshold : 0L, (r24 & 4) != 0 ? senseConfig2.multiProcessEnable : false, (r24 & 8) != 0 ? senseConfig2.foregroundUseBroadcast : false, (r24 & 16) != 0 ? senseConfig2.canUseRunningAppProcesses : false, (r24 & 32) != 0 ? senseConfig2.backgroundTolerableDuration : 0L, (r24 & 64) != 0 ? senseConfig2.strictBackgroundScene : null, (r24 & 128) != 0 ? senseConfig2.coldLaunchScene : null, (r24 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? senseConfig2.hotLaunchScene : null) : null;
    }
}
