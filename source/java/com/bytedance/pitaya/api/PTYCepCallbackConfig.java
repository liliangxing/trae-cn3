package com.bytedance.pitaya.api;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;

/* compiled from: PTYCepCallbackConfig.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/bytedance/pitaya/api/PTYCepCallbackConfig;", "", "passAllInfo", "", "concurrencySafe", "(ZZ)V", "getConcurrencySafe", "()Z", "getPassAllInfo", "component1", "component2", "copy", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "", "pitayacore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class PTYCepCallbackConfig {
    private final boolean concurrencySafe;
    private final boolean passAllInfo;

    public static /* synthetic */ PTYCepCallbackConfig copy$default(PTYCepCallbackConfig pTYCepCallbackConfig, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = pTYCepCallbackConfig.passAllInfo;
        }
        if ((i & 2) != 0) {
            z2 = pTYCepCallbackConfig.concurrencySafe;
        }
        return pTYCepCallbackConfig.copy(z, z2);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getPassAllInfo() {
        return this.passAllInfo;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getConcurrencySafe() {
        return this.concurrencySafe;
    }

    public final PTYCepCallbackConfig copy(boolean passAllInfo, boolean concurrencySafe) {
        return new PTYCepCallbackConfig(passAllInfo, concurrencySafe);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PTYCepCallbackConfig)) {
            return false;
        }
        PTYCepCallbackConfig pTYCepCallbackConfig = (PTYCepCallbackConfig) other;
        return this.passAllInfo == pTYCepCallbackConfig.passAllInfo && this.concurrencySafe == pTYCepCallbackConfig.concurrencySafe;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z = this.passAllInfo;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = r0 * 31;
        boolean z2 = this.concurrencySafe;
        return i + (z2 ? 1 : z2 ? 1 : 0);
    }

    public String toString() {
        return "PTYCepCallbackConfig(passAllInfo=" + this.passAllInfo + ", concurrencySafe=" + this.concurrencySafe + ')';
    }

    public PTYCepCallbackConfig(boolean z, boolean z2) {
        this.passAllInfo = z;
        this.concurrencySafe = z2;
    }

    public final boolean getConcurrencySafe() {
        return this.concurrencySafe;
    }

    public final boolean getPassAllInfo() {
        return this.passAllInfo;
    }
}
