package com.bytedance.trae.conversation.brainstorm;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HolderTypes.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/MinimizeResult;", "", "<init>", "()V", "Success", "Refused", "Lcom/bytedance/trae/conversation/brainstorm/MinimizeResult$Refused;", "Lcom/bytedance/trae/conversation/brainstorm/MinimizeResult$Success;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class MinimizeResult {
    public /* synthetic */ MinimizeResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* compiled from: HolderTypes.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/MinimizeResult$Success;", "Lcom/bytedance/trae/conversation/brainstorm/MinimizeResult;", "<init>", "()V", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Success extends MinimizeResult {
        public static final Success INSTANCE = new Success();

        private Success() {
            super(null);
        }
    }

    private MinimizeResult() {
    }

    /* compiled from: HolderTypes.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/MinimizeResult$Refused;", "Lcom/bytedance/trae/conversation/brainstorm/MinimizeResult;", "reason", "", "<init>", "(Ljava/lang/String;)V", "getReason", "()Ljava/lang/String;", "component1", "copy", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class Refused extends MinimizeResult {
        private final String reason;

        public static /* synthetic */ Refused copy$default(Refused refused, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = refused.reason;
            }
            return refused.copy(str);
        }

        /* renamed from: component1, reason: from getter */
        public final String getReason() {
            return this.reason;
        }

        public final Refused copy(String reason) {
            Intrinsics.checkNotNullParameter(reason, "reason");
            return new Refused(reason);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Refused) && Intrinsics.areEqual(this.reason, ((Refused) other).reason);
        }

        public int hashCode() {
            return this.reason.hashCode();
        }

        public String toString() {
            return "Refused(reason=" + this.reason + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Refused(String reason) {
            super(null);
            Intrinsics.checkNotNullParameter(reason, "reason");
            this.reason = reason;
        }

        public final String getReason() {
            return this.reason;
        }
    }
}
