package com.bytedance.android.anniex.detect;

import com.bytedance.forest.model.PreloadConfig;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DetectorConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0007\b\t\nB\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0004\u000b\f\r\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/anniex/detect/BlankCheckResult;", "", "()V", HiAnalyticsConstant.HaKey.BI_KEY_RESULT, "", "getStatusCode", "()I", "Error", "PartialWhite", "PureWhite", "Success", "Lcom/bytedance/android/anniex/detect/BlankCheckResult$Error;", "Lcom/bytedance/android/anniex/detect/BlankCheckResult$PartialWhite;", "Lcom/bytedance/android/anniex/detect/BlankCheckResult$PureWhite;", "Lcom/bytedance/android/anniex/detect/BlankCheckResult$Success;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes2.dex */
public abstract class BlankCheckResult {
    public /* synthetic */ BlankCheckResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract int getStatusCode();

    private BlankCheckResult() {
    }

    /* compiled from: DetectorConfig.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/anniex/detect/BlankCheckResult$PureWhite;", "Lcom/bytedance/android/anniex/detect/BlankCheckResult;", HiAnalyticsConstant.HaKey.BI_KEY_RESULT, "", "probability", "", "(IF)V", "getProbability", "()F", "getStatusCode", "()I", "component1", "component2", "copy", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "toString", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class PureWhite extends BlankCheckResult {
        private final float probability;
        private final int statusCode;

        public static /* synthetic */ PureWhite copy$default(PureWhite pureWhite, int i, float f, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = pureWhite.statusCode;
            }
            if ((i2 & 2) != 0) {
                f = pureWhite.probability;
            }
            return pureWhite.copy(i, f);
        }

        /* renamed from: component1, reason: from getter */
        public final int getStatusCode() {
            return this.statusCode;
        }

        /* renamed from: component2, reason: from getter */
        public final float getProbability() {
            return this.probability;
        }

        public final PureWhite copy(int statusCode, float probability) {
            return new PureWhite(statusCode, probability);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PureWhite)) {
                return false;
            }
            PureWhite pureWhite = (PureWhite) other;
            return this.statusCode == pureWhite.statusCode && Float.compare(this.probability, pureWhite.probability) == 0;
        }

        public int hashCode() {
            return (Integer.hashCode(this.statusCode) * 31) + Float.hashCode(this.probability);
        }

        public String toString() {
            return "PureWhite(statusCode=" + this.statusCode + ", probability=" + this.probability + ')';
        }

        public PureWhite(int i, float f) {
            super(null);
            this.statusCode = i;
            this.probability = f;
        }

        public final float getProbability() {
            return this.probability;
        }

        @Override // com.bytedance.android.anniex.detect.BlankCheckResult
        public int getStatusCode() {
            return this.statusCode;
        }
    }

    /* compiled from: DetectorConfig.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/anniex/detect/BlankCheckResult$PartialWhite;", "Lcom/bytedance/android/anniex/detect/BlankCheckResult;", HiAnalyticsConstant.HaKey.BI_KEY_RESULT, "", "(I)V", "getStatusCode", "()I", "component1", "copy", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "toString", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class PartialWhite extends BlankCheckResult {
        private final int statusCode;

        public static /* synthetic */ PartialWhite copy$default(PartialWhite partialWhite, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = partialWhite.statusCode;
            }
            return partialWhite.copy(i);
        }

        /* renamed from: component1, reason: from getter */
        public final int getStatusCode() {
            return this.statusCode;
        }

        public final PartialWhite copy(int statusCode) {
            return new PartialWhite(statusCode);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof PartialWhite) && this.statusCode == ((PartialWhite) other).statusCode;
        }

        public int hashCode() {
            return Integer.hashCode(this.statusCode);
        }

        public String toString() {
            return "PartialWhite(statusCode=" + this.statusCode + ')';
        }

        public PartialWhite(int i) {
            super(null);
            this.statusCode = i;
        }

        @Override // com.bytedance.android.anniex.detect.BlankCheckResult
        public int getStatusCode() {
            return this.statusCode;
        }
    }

    /* compiled from: DetectorConfig.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/anniex/detect/BlankCheckResult$Success;", "Lcom/bytedance/android/anniex/detect/BlankCheckResult;", HiAnalyticsConstant.HaKey.BI_KEY_RESULT, "", "(I)V", "getStatusCode", "()I", "component1", "copy", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "toString", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class Success extends BlankCheckResult {
        private final int statusCode;

        public static /* synthetic */ Success copy$default(Success success, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = success.statusCode;
            }
            return success.copy(i);
        }

        /* renamed from: component1, reason: from getter */
        public final int getStatusCode() {
            return this.statusCode;
        }

        public final Success copy(int statusCode) {
            return new Success(statusCode);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Success) && this.statusCode == ((Success) other).statusCode;
        }

        public int hashCode() {
            return Integer.hashCode(this.statusCode);
        }

        public String toString() {
            return "Success(statusCode=" + this.statusCode + ')';
        }

        public Success(int i) {
            super(null);
            this.statusCode = i;
        }

        @Override // com.bytedance.android.anniex.detect.BlankCheckResult
        public int getStatusCode() {
            return this.statusCode;
        }
    }

    /* compiled from: DetectorConfig.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/anniex/detect/BlankCheckResult$Error;", "Lcom/bytedance/android/anniex/detect/BlankCheckResult;", HiAnalyticsConstant.HaKey.BI_KEY_RESULT, "", "errorMsg", "", "stage", "Lcom/bytedance/android/anniex/detect/FailureStage;", "(ILjava/lang/String;Lcom/bytedance/android/anniex/detect/FailureStage;)V", "getErrorMsg", "()Ljava/lang/String;", "getStage", "()Lcom/bytedance/android/anniex/detect/FailureStage;", "getStatusCode", "()I", "component1", "component2", "component3", "copy", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class Error extends BlankCheckResult {
        private final String errorMsg;
        private final FailureStage stage;
        private final int statusCode;

        public static /* synthetic */ Error copy$default(Error error, int i, String str, FailureStage failureStage, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = error.statusCode;
            }
            if ((i2 & 2) != 0) {
                str = error.errorMsg;
            }
            if ((i2 & 4) != 0) {
                failureStage = error.stage;
            }
            return error.copy(i, str, failureStage);
        }

        /* renamed from: component1, reason: from getter */
        public final int getStatusCode() {
            return this.statusCode;
        }

        /* renamed from: component2, reason: from getter */
        public final String getErrorMsg() {
            return this.errorMsg;
        }

        /* renamed from: component3, reason: from getter */
        public final FailureStage getStage() {
            return this.stage;
        }

        public final Error copy(int statusCode, String errorMsg, FailureStage stage) {
            Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
            Intrinsics.checkNotNullParameter(stage, "stage");
            return new Error(statusCode, errorMsg, stage);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Error)) {
                return false;
            }
            Error error = (Error) other;
            return this.statusCode == error.statusCode && Intrinsics.areEqual(this.errorMsg, error.errorMsg) && this.stage == error.stage;
        }

        public int hashCode() {
            return (((Integer.hashCode(this.statusCode) * 31) + this.errorMsg.hashCode()) * 31) + this.stage.hashCode();
        }

        public String toString() {
            return "Error(statusCode=" + this.statusCode + ", errorMsg=" + this.errorMsg + ", stage=" + this.stage + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Error(int i, String errorMsg, FailureStage stage) {
            super(null);
            Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
            Intrinsics.checkNotNullParameter(stage, "stage");
            this.statusCode = i;
            this.errorMsg = errorMsg;
            this.stage = stage;
        }

        public final String getErrorMsg() {
            return this.errorMsg;
        }

        public final FailureStage getStage() {
            return this.stage;
        }

        @Override // com.bytedance.android.anniex.detect.BlankCheckResult
        public int getStatusCode() {
            return this.statusCode;
        }
    }
}
