package com.bytedance.android.monitorV2.lynx.impl.blank;

import com.bytedance.android.monitorV2.lynx.impl.blank.BlankViewRegionChecker;
import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BlankCheckCallbacks.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0007\bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bytedance/android/monitorV2/lynx/impl/blank/BlankCheckCallbacks;", "", "()V", "MARK_DEFAULT", "", "MARK_INVALIDATE", "MARK_VALIDATE", "BlankCheck", "OnCheckListener", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public final class BlankCheckCallbacks {
    public static final BlankCheckCallbacks INSTANCE = new BlankCheckCallbacks();
    public static final int MARK_DEFAULT = 0;
    public static final int MARK_INVALIDATE = 2;
    public static final int MARK_VALIDATE = 1;

    /* compiled from: BlankCheckCallbacks.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/monitorV2/lynx/impl/blank/BlankCheckCallbacks$OnCheckListener;", "", "()V", "onChecked", "", "check", "Lcom/bytedance/android/monitorV2/lynx/impl/blank/BlankCheckCallbacks$BlankCheck;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes3.dex */
    public static abstract class OnCheckListener {
        public abstract void onChecked(BlankCheck check);
    }

    private BlankCheckCallbacks() {
    }

    /* compiled from: BlankCheckCallbacks.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/monitorV2/lynx/impl/blank/BlankCheckCallbacks$BlankCheck;", "", "detectElapse", "", "checkElapse", "checkResult", "Lcom/bytedance/android/monitorV2/lynx/impl/blank/BlankViewRegionChecker$CheckResult;", "(JJLcom/bytedance/android/monitorV2/lynx/impl/blank/BlankViewRegionChecker$CheckResult;)V", "getCheckElapse", "()J", "getCheckResult", "()Lcom/bytedance/android/monitorV2/lynx/impl/blank/BlankViewRegionChecker$CheckResult;", "getDetectElapse", "component1", "component2", "component3", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes3.dex */
    public static final /* data */ class BlankCheck {
        private final long checkElapse;
        private final BlankViewRegionChecker.CheckResult checkResult;
        private final long detectElapse;

        public BlankCheck() {
            this(0L, 0L, null, 7, null);
        }

        public static /* synthetic */ BlankCheck copy$default(BlankCheck blankCheck, long j, long j2, BlankViewRegionChecker.CheckResult checkResult, int i, Object obj) {
            if ((i & 1) != 0) {
                j = blankCheck.detectElapse;
            }
            long j3 = j;
            if ((i & 2) != 0) {
                j2 = blankCheck.checkElapse;
            }
            long j4 = j2;
            if ((i & 4) != 0) {
                checkResult = blankCheck.checkResult;
            }
            return blankCheck.copy(j3, j4, checkResult);
        }

        /* renamed from: component1, reason: from getter */
        public final long getDetectElapse() {
            return this.detectElapse;
        }

        /* renamed from: component2, reason: from getter */
        public final long getCheckElapse() {
            return this.checkElapse;
        }

        /* renamed from: component3, reason: from getter */
        public final BlankViewRegionChecker.CheckResult getCheckResult() {
            return this.checkResult;
        }

        public final BlankCheck copy(long detectElapse, long checkElapse, BlankViewRegionChecker.CheckResult checkResult) {
            Intrinsics.checkNotNullParameter(checkResult, "checkResult");
            return new BlankCheck(detectElapse, checkElapse, checkResult);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof BlankCheck)) {
                return false;
            }
            BlankCheck blankCheck = (BlankCheck) other;
            return this.detectElapse == blankCheck.detectElapse && this.checkElapse == blankCheck.checkElapse && Intrinsics.areEqual(this.checkResult, blankCheck.checkResult);
        }

        public int hashCode() {
            return (((Long.hashCode(this.detectElapse) * 31) + Long.hashCode(this.checkElapse)) * 31) + this.checkResult.hashCode();
        }

        public String toString() {
            return "BlankCheck(detectElapse=" + this.detectElapse + ", checkElapse=" + this.checkElapse + ", checkResult=" + this.checkResult + ')';
        }

        public BlankCheck(long j, long j2, BlankViewRegionChecker.CheckResult checkResult) {
            Intrinsics.checkNotNullParameter(checkResult, "checkResult");
            this.detectElapse = j;
            this.checkElapse = j2;
            this.checkResult = checkResult;
        }

        public final long getDetectElapse() {
            return this.detectElapse;
        }

        public final long getCheckElapse() {
            return this.checkElapse;
        }

        public /* synthetic */ BlankCheck(long j, long j2, BlankViewRegionChecker.CheckResult checkResult, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? 0L : j, (i & 2) == 0 ? j2 : 0L, (i & 4) != 0 ? new BlankViewRegionChecker.CheckResult(0.0f, 0.0f, null, 0, 0, 0, null, null, false, 511, null) : checkResult);
        }

        public final BlankViewRegionChecker.CheckResult getCheckResult() {
            return this.checkResult;
        }
    }
}
