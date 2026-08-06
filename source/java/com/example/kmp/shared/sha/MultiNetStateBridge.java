package com.example.kmp.shared.sha;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;

/* compiled from: TTNetworkUtilsBridge.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/example/kmp/shared/sha/MultiNetStateBridge;", "", "preState", "", "curState", "<init>", "(II)V", "getPreState", "()I", "getCurState", "component1", "component2", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "", "kmpNativeBridge_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes6.dex */
public final /* data */ class MultiNetStateBridge {
    private final int curState;
    private final int preState;

    public static /* synthetic */ MultiNetStateBridge copy$default(MultiNetStateBridge multiNetStateBridge, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = multiNetStateBridge.preState;
        }
        if ((i3 & 2) != 0) {
            i2 = multiNetStateBridge.curState;
        }
        return multiNetStateBridge.copy(i, i2);
    }

    /* renamed from: component1, reason: from getter */
    public final int getPreState() {
        return this.preState;
    }

    /* renamed from: component2, reason: from getter */
    public final int getCurState() {
        return this.curState;
    }

    public final MultiNetStateBridge copy(int preState, int curState) {
        return new MultiNetStateBridge(preState, curState);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MultiNetStateBridge)) {
            return false;
        }
        MultiNetStateBridge multiNetStateBridge = (MultiNetStateBridge) other;
        return this.preState == multiNetStateBridge.preState && this.curState == multiNetStateBridge.curState;
    }

    public int hashCode() {
        return (Integer.hashCode(this.preState) * 31) + Integer.hashCode(this.curState);
    }

    public String toString() {
        return "MultiNetStateBridge(preState=" + this.preState + ", curState=" + this.curState + ')';
    }

    public MultiNetStateBridge(int i, int i2) {
        this.preState = i;
        this.curState = i2;
    }

    public final int getPreState() {
        return this.preState;
    }

    public final int getCurState() {
        return this.curState;
    }
}
