package com.bytedance.ies.bullet.core.kit.bridge;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BridgeRegistry.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ies/bullet/core/kit/bridge/BridgeMergeOperation;", "", "otherRegistry", "Lcom/bytedance/ies/bullet/core/kit/bridge/IBridgeRegistry;", "useOthersOnConflict", "", "(Lcom/bytedance/ies/bullet/core/kit/bridge/IBridgeRegistry;Z)V", "getOtherRegistry", "()Lcom/bytedance/ies/bullet/core/kit/bridge/IBridgeRegistry;", "getUseOthersOnConflict", "()Z", "component1", "component2", "copy", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class BridgeMergeOperation {
    private final IBridgeRegistry otherRegistry;
    private final boolean useOthersOnConflict;

    public static /* synthetic */ BridgeMergeOperation copy$default(BridgeMergeOperation bridgeMergeOperation, IBridgeRegistry iBridgeRegistry, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            iBridgeRegistry = bridgeMergeOperation.otherRegistry;
        }
        if ((i & 2) != 0) {
            z = bridgeMergeOperation.useOthersOnConflict;
        }
        return bridgeMergeOperation.copy(iBridgeRegistry, z);
    }

    /* renamed from: component1, reason: from getter */
    public final IBridgeRegistry getOtherRegistry() {
        return this.otherRegistry;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getUseOthersOnConflict() {
        return this.useOthersOnConflict;
    }

    public final BridgeMergeOperation copy(IBridgeRegistry otherRegistry, boolean useOthersOnConflict) {
        Intrinsics.checkNotNullParameter(otherRegistry, "otherRegistry");
        return new BridgeMergeOperation(otherRegistry, useOthersOnConflict);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BridgeMergeOperation)) {
            return false;
        }
        BridgeMergeOperation bridgeMergeOperation = (BridgeMergeOperation) other;
        return Intrinsics.areEqual(this.otherRegistry, bridgeMergeOperation.otherRegistry) && this.useOthersOnConflict == bridgeMergeOperation.useOthersOnConflict;
    }

    public int hashCode() {
        return (this.otherRegistry.hashCode() * 31) + Boolean.hashCode(this.useOthersOnConflict);
    }

    public String toString() {
        return "BridgeMergeOperation(otherRegistry=" + this.otherRegistry + ", useOthersOnConflict=" + this.useOthersOnConflict + ')';
    }

    public BridgeMergeOperation(IBridgeRegistry otherRegistry, boolean z) {
        Intrinsics.checkNotNullParameter(otherRegistry, "otherRegistry");
        this.otherRegistry = otherRegistry;
        this.useOthersOnConflict = z;
    }

    public final IBridgeRegistry getOtherRegistry() {
        return this.otherRegistry;
    }

    public final boolean getUseOthersOnConflict() {
        return this.useOthersOnConflict;
    }
}
