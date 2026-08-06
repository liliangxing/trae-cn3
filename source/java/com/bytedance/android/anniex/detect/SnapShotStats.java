package com.bytedance.android.anniex.detect;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: DetectorConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\t\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0004\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/anniex/detect/SnapShotStats;", "", "isPixelCopySuccess", "", "isPixelCopyCost", "", "(ZLjava/lang/Long;)V", "()Ljava/lang/Long;", "setPixelCopyCost", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "()Z", "setPixelCopySuccess", "(Z)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes2.dex */
public final class SnapShotStats {
    private Long isPixelCopyCost;
    private boolean isPixelCopySuccess;

    /* JADX WARN: Multi-variable type inference failed */
    public SnapShotStats() {
        this(false, null, 3, 0 == true ? 1 : 0);
    }

    public SnapShotStats(boolean z, Long l) {
        this.isPixelCopySuccess = z;
        this.isPixelCopyCost = l;
    }

    public /* synthetic */ SnapShotStats(boolean z, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? null : l);
    }

    /* renamed from: isPixelCopySuccess, reason: from getter */
    public final boolean getIsPixelCopySuccess() {
        return this.isPixelCopySuccess;
    }

    public final void setPixelCopySuccess(boolean z) {
        this.isPixelCopySuccess = z;
    }

    /* renamed from: isPixelCopyCost, reason: from getter */
    public final Long getIsPixelCopyCost() {
        return this.isPixelCopyCost;
    }

    public final void setPixelCopyCost(Long l) {
        this.isPixelCopyCost = l;
    }
}
