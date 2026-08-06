package com.bytedance.timonbase.scene.config;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: SenseConfigManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/bytedance/timonbase/scene/config/StrictBackgroundScene;", "", "enable", "", "enterBackgroundDurationThreshold", "", "coldLaunchDurationThreshold", "(ZII)V", "getColdLaunchDurationThreshold", "()I", "getEnable", "()Z", "getEnterBackgroundDurationThreshold", "component1", "component2", "component3", "copy", "equals", PreloadConfig.KEY_OTHER, "hashCode", "toString", "", "timonbase_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes5.dex */
public final /* data */ class StrictBackgroundScene {

    @SerializedName("cold_launch_duration_threshold")
    private final int coldLaunchDurationThreshold;

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("enter_background_duration_threshold")
    private final int enterBackgroundDurationThreshold;

    public StrictBackgroundScene() {
        this(false, 0, 0, 7, null);
    }

    public static /* synthetic */ StrictBackgroundScene copy$default(StrictBackgroundScene strictBackgroundScene, boolean z, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z = strictBackgroundScene.enable;
        }
        if ((i3 & 2) != 0) {
            i = strictBackgroundScene.enterBackgroundDurationThreshold;
        }
        if ((i3 & 4) != 0) {
            i2 = strictBackgroundScene.coldLaunchDurationThreshold;
        }
        return strictBackgroundScene.copy(z, i, i2);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getEnable() {
        return this.enable;
    }

    /* renamed from: component2, reason: from getter */
    public final int getEnterBackgroundDurationThreshold() {
        return this.enterBackgroundDurationThreshold;
    }

    /* renamed from: component3, reason: from getter */
    public final int getColdLaunchDurationThreshold() {
        return this.coldLaunchDurationThreshold;
    }

    public final StrictBackgroundScene copy(boolean enable, int enterBackgroundDurationThreshold, int coldLaunchDurationThreshold) {
        return new StrictBackgroundScene(enable, enterBackgroundDurationThreshold, coldLaunchDurationThreshold);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StrictBackgroundScene)) {
            return false;
        }
        StrictBackgroundScene strictBackgroundScene = (StrictBackgroundScene) other;
        return this.enable == strictBackgroundScene.enable && this.enterBackgroundDurationThreshold == strictBackgroundScene.enterBackgroundDurationThreshold && this.coldLaunchDurationThreshold == strictBackgroundScene.coldLaunchDurationThreshold;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean z = this.enable;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (((r0 * 31) + Integer.hashCode(this.enterBackgroundDurationThreshold)) * 31) + Integer.hashCode(this.coldLaunchDurationThreshold);
    }

    public String toString() {
        return "StrictBackgroundScene(enable=" + this.enable + ", enterBackgroundDurationThreshold=" + this.enterBackgroundDurationThreshold + ", coldLaunchDurationThreshold=" + this.coldLaunchDurationThreshold + ")";
    }

    public StrictBackgroundScene(boolean z, int i, int i2) {
        this.enable = z;
        this.enterBackgroundDurationThreshold = i;
        this.coldLaunchDurationThreshold = i2;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final int getEnterBackgroundDurationThreshold() {
        return this.enterBackgroundDurationThreshold;
    }

    public /* synthetic */ StrictBackgroundScene(boolean z, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z, (i3 & 2) != 0 ? 15000 : i, (i3 & 4) != 0 ? 20000 : i2);
    }

    public final int getColdLaunchDurationThreshold() {
        return this.coldLaunchDurationThreshold;
    }
}
