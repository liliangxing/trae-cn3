package com.bytedance.webx.pia.snapshot;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: SnapShotConfig.kt */
@Deprecated(message = "legacy usage")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/bytedance/webx/pia/snapshot/SnapShotConfig;", "", "isEnableSnapshot", "", "isEnableTTNetResponse", "(ZZ)V", "()Z", "component1", "component2", "copy", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes6.dex */
public final /* data */ class SnapShotConfig {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static final SnapShotConfig DefaultInstance;
    private final boolean isEnableSnapshot;
    private final boolean isEnableTTNetResponse;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SnapShotConfig() {
        this(r2, r2, 3, null);
        boolean z = false;
    }

    public static /* synthetic */ SnapShotConfig copy$default(SnapShotConfig snapShotConfig, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = snapShotConfig.isEnableSnapshot;
        }
        if ((i & 2) != 0) {
            z2 = snapShotConfig.isEnableTTNetResponse;
        }
        return snapShotConfig.copy(z, z2);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getIsEnableSnapshot() {
        return this.isEnableSnapshot;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getIsEnableTTNetResponse() {
        return this.isEnableTTNetResponse;
    }

    public final SnapShotConfig copy(boolean isEnableSnapshot, boolean isEnableTTNetResponse) {
        return new SnapShotConfig(isEnableSnapshot, isEnableTTNetResponse);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SnapShotConfig)) {
            return false;
        }
        SnapShotConfig snapShotConfig = (SnapShotConfig) other;
        return this.isEnableSnapshot == snapShotConfig.isEnableSnapshot && this.isEnableTTNetResponse == snapShotConfig.isEnableTTNetResponse;
    }

    public int hashCode() {
        return (Boolean.hashCode(this.isEnableSnapshot) * 31) + Boolean.hashCode(this.isEnableTTNetResponse);
    }

    public String toString() {
        return "SnapShotConfig(isEnableSnapshot=" + this.isEnableSnapshot + ", isEnableTTNetResponse=" + this.isEnableTTNetResponse + ')';
    }

    public SnapShotConfig(boolean z, boolean z2) {
        this.isEnableSnapshot = z;
        this.isEnableTTNetResponse = z2;
    }

    public /* synthetic */ SnapShotConfig(boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z, (i & 2) != 0 ? true : z2);
    }

    public final boolean isEnableSnapshot() {
        return this.isEnableSnapshot;
    }

    public final boolean isEnableTTNetResponse() {
        return this.isEnableTTNetResponse;
    }

    /* compiled from: SnapShotConfig.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/webx/pia/snapshot/SnapShotConfig$Companion;", "", "()V", "DefaultInstance", "Lcom/bytedance/webx/pia/snapshot/SnapShotConfig;", "getDefaultInstance", "()Lcom/bytedance/webx/pia/snapshot/SnapShotConfig;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SnapShotConfig getDefaultInstance() {
            return SnapShotConfig.DefaultInstance;
        }
    }

    static {
        DefaultConstructorMarker defaultConstructorMarker = null;
        INSTANCE = new Companion(defaultConstructorMarker);
        boolean z = false;
        DefaultInstance = new SnapShotConfig(z, z, 3, defaultConstructorMarker);
    }
}
