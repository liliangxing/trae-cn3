package com.bytedance.sdk.xbridge.cn.auth.bean;

import com.bytedance.forest.model.PreloadConfig;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BridgeCallRecord.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/auth/bean/SignSuiteV2;", "", "signAlgorithm", "Lcom/bytedance/sdk/xbridge/cn/auth/bean/SignAlgorithm;", "signature", "", "(Lcom/bytedance/sdk/xbridge/cn/auth/bean/SignAlgorithm;[B)V", "getSignAlgorithm", "()Lcom/bytedance/sdk/xbridge/cn/auth/bean/SignAlgorithm;", "getSignature", "()[B", "component1", "component2", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class SignSuiteV2 {
    private final SignAlgorithm signAlgorithm;
    private final byte[] signature;

    public static /* synthetic */ SignSuiteV2 copy$default(SignSuiteV2 signSuiteV2, SignAlgorithm signAlgorithm, byte[] bArr, int i, Object obj) {
        if ((i & 1) != 0) {
            signAlgorithm = signSuiteV2.signAlgorithm;
        }
        if ((i & 2) != 0) {
            bArr = signSuiteV2.signature;
        }
        return signSuiteV2.copy(signAlgorithm, bArr);
    }

    /* renamed from: component1, reason: from getter */
    public final SignAlgorithm getSignAlgorithm() {
        return this.signAlgorithm;
    }

    /* renamed from: component2, reason: from getter */
    public final byte[] getSignature() {
        return this.signature;
    }

    public final SignSuiteV2 copy(SignAlgorithm signAlgorithm, byte[] signature) {
        Intrinsics.checkNotNullParameter(signAlgorithm, "signAlgorithm");
        Intrinsics.checkNotNullParameter(signature, "signature");
        return new SignSuiteV2(signAlgorithm, signature);
    }

    public String toString() {
        return "SignSuiteV2(signAlgorithm=" + this.signAlgorithm + ", signature=" + Arrays.toString(this.signature) + ')';
    }

    public SignSuiteV2(SignAlgorithm signAlgorithm, byte[] signature) {
        Intrinsics.checkNotNullParameter(signAlgorithm, "signAlgorithm");
        Intrinsics.checkNotNullParameter(signature, "signature");
        this.signAlgorithm = signAlgorithm;
        this.signature = signature;
    }

    public final SignAlgorithm getSignAlgorithm() {
        return this.signAlgorithm;
    }

    public final byte[] getSignature() {
        return this.signature;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.bytedance.sdk.xbridge.cn.auth.bean.SignSuiteV2");
        SignSuiteV2 signSuiteV2 = (SignSuiteV2) other;
        return Intrinsics.areEqual(this.signAlgorithm, signSuiteV2.signAlgorithm) && Arrays.equals(this.signature, signSuiteV2.signature);
    }

    public int hashCode() {
        return (this.signAlgorithm.hashCode() * 31) + Arrays.hashCode(this.signature);
    }
}
