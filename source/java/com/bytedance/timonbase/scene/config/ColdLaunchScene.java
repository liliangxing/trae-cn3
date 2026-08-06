package com.bytedance.timonbase.scene.config;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: SenseConfigManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/bytedance/timonbase/scene/config/ColdLaunchScene;", "", "enable", "", "coldLaunchDurationThreshold", "", "(ZI)V", "getColdLaunchDurationThreshold", "()I", "getEnable", "()Z", "component1", "component2", "copy", "equals", PreloadConfig.KEY_OTHER, "hashCode", "toString", "", "timonbase_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes5.dex */
public final /* data */ class ColdLaunchScene {

    @SerializedName("cold_launch_duration_threshold")
    private final int coldLaunchDurationThreshold;

    @SerializedName("enable")
    private final boolean enable;

    /* JADX WARN: Multi-variable type inference failed */
    public ColdLaunchScene() {
        this(false, 0 == true ? 1 : 0, 3, null);
    }

    public static /* synthetic */ ColdLaunchScene copy$default(ColdLaunchScene coldLaunchScene, boolean z, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = coldLaunchScene.enable;
        }
        if ((i2 & 2) != 0) {
            i = coldLaunchScene.coldLaunchDurationThreshold;
        }
        return coldLaunchScene.copy(z, i);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getEnable() {
        return this.enable;
    }

    /* renamed from: component2, reason: from getter */
    public final int getColdLaunchDurationThreshold() {
        return this.coldLaunchDurationThreshold;
    }

    public final ColdLaunchScene copy(boolean enable, int coldLaunchDurationThreshold) {
        return new ColdLaunchScene(enable, coldLaunchDurationThreshold);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ColdLaunchScene)) {
            return false;
        }
        ColdLaunchScene coldLaunchScene = (ColdLaunchScene) other;
        return this.enable == coldLaunchScene.enable && this.coldLaunchDurationThreshold == coldLaunchScene.coldLaunchDurationThreshold;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z = this.enable;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (r0 * 31) + Integer.hashCode(this.coldLaunchDurationThreshold);
    }

    public String toString() {
        return "ColdLaunchScene(enable=" + this.enable + ", coldLaunchDurationThreshold=" + this.coldLaunchDurationThreshold + ")";
    }

    public ColdLaunchScene(boolean z, int i) {
        this.enable = z;
        this.coldLaunchDurationThreshold = i;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public /* synthetic */ ColdLaunchScene(boolean z, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? 30000 : i);
    }

    public final int getColdLaunchDurationThreshold() {
        return this.coldLaunchDurationThreshold;
    }
}
