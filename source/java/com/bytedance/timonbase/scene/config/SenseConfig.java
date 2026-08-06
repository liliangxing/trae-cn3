package com.bytedance.timonbase.scene.config;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SenseConfigManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001Be\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u000fHÆ\u0003Ji\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÆ\u0001J\u0013\u0010)\u001a\u00020\u00032\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020,HÖ\u0001J\t\u0010-\u001a\u00020.HÖ\u0001R\u0016\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012R\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006/"}, d2 = {"Lcom/bytedance/timonbase/scene/config/SenseConfig;", "", "silenceEnable", "", "silenceThreshold", "", "multiProcessEnable", "foregroundUseBroadcast", "canUseRunningAppProcesses", "backgroundTolerableDuration", "strictBackgroundScene", "Lcom/bytedance/timonbase/scene/config/StrictBackgroundScene;", "coldLaunchScene", "Lcom/bytedance/timonbase/scene/config/ColdLaunchScene;", "hotLaunchScene", "Lcom/bytedance/timonbase/scene/config/HotLaunchScene;", "(ZJZZZJLcom/bytedance/timonbase/scene/config/StrictBackgroundScene;Lcom/bytedance/timonbase/scene/config/ColdLaunchScene;Lcom/bytedance/timonbase/scene/config/HotLaunchScene;)V", "getBackgroundTolerableDuration", "()J", "getCanUseRunningAppProcesses", "()Z", "getColdLaunchScene", "()Lcom/bytedance/timonbase/scene/config/ColdLaunchScene;", "getForegroundUseBroadcast", "getHotLaunchScene", "()Lcom/bytedance/timonbase/scene/config/HotLaunchScene;", "getMultiProcessEnable", "getSilenceEnable", "getSilenceThreshold", "getStrictBackgroundScene", "()Lcom/bytedance/timonbase/scene/config/StrictBackgroundScene;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "", "timonbase_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes5.dex */
public final /* data */ class SenseConfig {

    @SerializedName("background_tolerable_duration")
    private final long backgroundTolerableDuration;

    @SerializedName("use_running_app_processes")
    private final boolean canUseRunningAppProcesses;

    @SerializedName("cold_launch_scene")
    private final ColdLaunchScene coldLaunchScene;

    @SerializedName("foreground_use_broadcast")
    private final boolean foregroundUseBroadcast;

    @SerializedName("hot_launch_scene")
    private final HotLaunchScene hotLaunchScene;

    @SerializedName("multi_process_enable")
    private final boolean multiProcessEnable;

    @SerializedName("silent_scene_enable")
    private final boolean silenceEnable;

    @SerializedName("silent_scene_threshold")
    private final long silenceThreshold;

    @SerializedName("strict_background_scene")
    private final StrictBackgroundScene strictBackgroundScene;

    public SenseConfig() {
        this(false, 0L, false, false, false, 0L, null, null, null, 511, null);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getSilenceEnable() {
        return this.silenceEnable;
    }

    /* renamed from: component2, reason: from getter */
    public final long getSilenceThreshold() {
        return this.silenceThreshold;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getMultiProcessEnable() {
        return this.multiProcessEnable;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getForegroundUseBroadcast() {
        return this.foregroundUseBroadcast;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getCanUseRunningAppProcesses() {
        return this.canUseRunningAppProcesses;
    }

    /* renamed from: component6, reason: from getter */
    public final long getBackgroundTolerableDuration() {
        return this.backgroundTolerableDuration;
    }

    /* renamed from: component7, reason: from getter */
    public final StrictBackgroundScene getStrictBackgroundScene() {
        return this.strictBackgroundScene;
    }

    /* renamed from: component8, reason: from getter */
    public final ColdLaunchScene getColdLaunchScene() {
        return this.coldLaunchScene;
    }

    /* renamed from: component9, reason: from getter */
    public final HotLaunchScene getHotLaunchScene() {
        return this.hotLaunchScene;
    }

    public final SenseConfig copy(boolean silenceEnable, long silenceThreshold, boolean multiProcessEnable, boolean foregroundUseBroadcast, boolean canUseRunningAppProcesses, long backgroundTolerableDuration, StrictBackgroundScene strictBackgroundScene, ColdLaunchScene coldLaunchScene, HotLaunchScene hotLaunchScene) {
        return new SenseConfig(silenceEnable, silenceThreshold, multiProcessEnable, foregroundUseBroadcast, canUseRunningAppProcesses, backgroundTolerableDuration, strictBackgroundScene, coldLaunchScene, hotLaunchScene);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SenseConfig)) {
            return false;
        }
        SenseConfig senseConfig = (SenseConfig) other;
        return this.silenceEnable == senseConfig.silenceEnable && this.silenceThreshold == senseConfig.silenceThreshold && this.multiProcessEnable == senseConfig.multiProcessEnable && this.foregroundUseBroadcast == senseConfig.foregroundUseBroadcast && this.canUseRunningAppProcesses == senseConfig.canUseRunningAppProcesses && this.backgroundTolerableDuration == senseConfig.backgroundTolerableDuration && Intrinsics.areEqual(this.strictBackgroundScene, senseConfig.strictBackgroundScene) && Intrinsics.areEqual(this.coldLaunchScene, senseConfig.coldLaunchScene) && Intrinsics.areEqual(this.hotLaunchScene, senseConfig.hotLaunchScene);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r2v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v4, types: [boolean] */
    public int hashCode() {
        boolean z = this.silenceEnable;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int hashCode = ((r0 * 31) + Long.hashCode(this.silenceThreshold)) * 31;
        ?? r2 = this.multiProcessEnable;
        int i = r2;
        if (r2 != 0) {
            i = 1;
        }
        int i2 = (hashCode + i) * 31;
        ?? r22 = this.foregroundUseBroadcast;
        int i3 = r22;
        if (r22 != 0) {
            i3 = 1;
        }
        int i4 = (i2 + i3) * 31;
        boolean z2 = this.canUseRunningAppProcesses;
        int hashCode2 = (((i4 + (z2 ? 1 : z2 ? 1 : 0)) * 31) + Long.hashCode(this.backgroundTolerableDuration)) * 31;
        StrictBackgroundScene strictBackgroundScene = this.strictBackgroundScene;
        int hashCode3 = (hashCode2 + (strictBackgroundScene != null ? strictBackgroundScene.hashCode() : 0)) * 31;
        ColdLaunchScene coldLaunchScene = this.coldLaunchScene;
        int hashCode4 = (hashCode3 + (coldLaunchScene != null ? coldLaunchScene.hashCode() : 0)) * 31;
        HotLaunchScene hotLaunchScene = this.hotLaunchScene;
        return hashCode4 + (hotLaunchScene != null ? hotLaunchScene.hashCode() : 0);
    }

    public String toString() {
        return "SenseConfig(silenceEnable=" + this.silenceEnable + ", silenceThreshold=" + this.silenceThreshold + ", multiProcessEnable=" + this.multiProcessEnable + ", foregroundUseBroadcast=" + this.foregroundUseBroadcast + ", canUseRunningAppProcesses=" + this.canUseRunningAppProcesses + ", backgroundTolerableDuration=" + this.backgroundTolerableDuration + ", strictBackgroundScene=" + this.strictBackgroundScene + ", coldLaunchScene=" + this.coldLaunchScene + ", hotLaunchScene=" + this.hotLaunchScene + ")";
    }

    public SenseConfig(boolean z, long j, boolean z2, boolean z3, boolean z4, long j2, StrictBackgroundScene strictBackgroundScene, ColdLaunchScene coldLaunchScene, HotLaunchScene hotLaunchScene) {
        this.silenceEnable = z;
        this.silenceThreshold = j;
        this.multiProcessEnable = z2;
        this.foregroundUseBroadcast = z3;
        this.canUseRunningAppProcesses = z4;
        this.backgroundTolerableDuration = j2;
        this.strictBackgroundScene = strictBackgroundScene;
        this.coldLaunchScene = coldLaunchScene;
        this.hotLaunchScene = hotLaunchScene;
    }

    public final boolean getSilenceEnable() {
        return this.silenceEnable;
    }

    public final long getSilenceThreshold() {
        return this.silenceThreshold;
    }

    public final boolean getMultiProcessEnable() {
        return this.multiProcessEnable;
    }

    public final boolean getForegroundUseBroadcast() {
        return this.foregroundUseBroadcast;
    }

    public final boolean getCanUseRunningAppProcesses() {
        return this.canUseRunningAppProcesses;
    }

    public final long getBackgroundTolerableDuration() {
        return this.backgroundTolerableDuration;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ SenseConfig(boolean z, long j, boolean z2, boolean z3, boolean z4, long j2, StrictBackgroundScene strictBackgroundScene, ColdLaunchScene coldLaunchScene, HotLaunchScene hotLaunchScene, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(r1, r3, r5, r2, r6, r7, r9, r11, r10);
        StrictBackgroundScene strictBackgroundScene2;
        ColdLaunchScene coldLaunchScene2;
        boolean z5 = (i & 1) != 0 ? false : z;
        long j3 = (i & 2) != 0 ? 600000L : j;
        boolean z6 = (i & 4) != 0 ? false : z2;
        boolean z7 = (i & 8) == 0 ? z3 : false;
        boolean z8 = (i & 16) != 0 ? true : z4;
        long j4 = (i & 32) != 0 ? 0L : j2;
        HotLaunchScene hotLaunchScene2 = null;
        if ((i & 64) != 0) {
            strictBackgroundScene2 = null;
        } else {
            strictBackgroundScene2 = strictBackgroundScene;
        }
        if ((i & 128) != 0) {
            coldLaunchScene2 = null;
        } else {
            coldLaunchScene2 = coldLaunchScene;
        }
        if ((i & 256) != 0) {
        } else {
            hotLaunchScene2 = hotLaunchScene;
        }
    }

    public final StrictBackgroundScene getStrictBackgroundScene() {
        return this.strictBackgroundScene;
    }

    public final ColdLaunchScene getColdLaunchScene() {
        return this.coldLaunchScene;
    }

    public final HotLaunchScene getHotLaunchScene() {
        return this.hotLaunchScene;
    }
}
