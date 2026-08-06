package com.bytedance.kmp.network.multinet;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MultiNetState.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/bytedance/kmp/network/multinet/MultiNetState;", "", "preState", "Lcom/bytedance/kmp/network/multinet/MultiNetStateValue;", "curState", "(Lcom/bytedance/kmp/network/multinet/MultiNetStateValue;Lcom/bytedance/kmp/network/multinet/MultiNetStateValue;)V", "getCurState", "()Lcom/bytedance/kmp/network/multinet/MultiNetStateValue;", "getPreState", "component1", "component2", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "", "network_service_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class MultiNetState {
    private final MultiNetStateValue curState;
    private final MultiNetStateValue preState;

    public static /* synthetic */ MultiNetState copy$default(MultiNetState multiNetState, MultiNetStateValue multiNetStateValue, MultiNetStateValue multiNetStateValue2, int i, Object obj) {
        if ((i & 1) != 0) {
            multiNetStateValue = multiNetState.preState;
        }
        if ((i & 2) != 0) {
            multiNetStateValue2 = multiNetState.curState;
        }
        return multiNetState.copy(multiNetStateValue, multiNetStateValue2);
    }

    /* renamed from: component1, reason: from getter */
    public final MultiNetStateValue getPreState() {
        return this.preState;
    }

    /* renamed from: component2, reason: from getter */
    public final MultiNetStateValue getCurState() {
        return this.curState;
    }

    public final MultiNetState copy(MultiNetStateValue preState, MultiNetStateValue curState) {
        Intrinsics.checkNotNullParameter(preState, "preState");
        Intrinsics.checkNotNullParameter(curState, "curState");
        return new MultiNetState(preState, curState);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MultiNetState)) {
            return false;
        }
        MultiNetState multiNetState = (MultiNetState) other;
        return this.preState == multiNetState.preState && this.curState == multiNetState.curState;
    }

    public int hashCode() {
        return (this.preState.hashCode() * 31) + this.curState.hashCode();
    }

    public String toString() {
        return "MultiNetState(preState=" + this.preState + ", curState=" + this.curState + ')';
    }

    public MultiNetState(MultiNetStateValue preState, MultiNetStateValue curState) {
        Intrinsics.checkNotNullParameter(preState, "preState");
        Intrinsics.checkNotNullParameter(curState, "curState");
        this.preState = preState;
        this.curState = curState;
    }

    public final MultiNetStateValue getPreState() {
        return this.preState;
    }

    public final MultiNetStateValue getCurState() {
        return this.curState;
    }
}
