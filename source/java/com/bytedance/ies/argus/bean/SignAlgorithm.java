package com.bytedance.ies.argus.bean;

import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.ies.bullet.kit.resourceloader.monitor.RLMonitorReporter;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: SignAuthBean.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ies/argus/bean/SignAlgorithm;", "", "encryptAlgorithm", "Lcom/bytedance/ies/argus/bean/EncryptAlgorithm;", "digestAlgorithm", "Lcom/bytedance/ies/argus/bean/DigestAlgorithm;", "(Lcom/bytedance/ies/argus/bean/EncryptAlgorithm;Lcom/bytedance/ies/argus/bean/DigestAlgorithm;)V", "getDigestAlgorithm", "()Lcom/bytedance/ies/argus/bean/DigestAlgorithm;", "getEncryptAlgorithm", "()Lcom/bytedance/ies/argus/bean/EncryptAlgorithm;", "component1", "component2", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class SignAlgorithm {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final DigestAlgorithm digestAlgorithm;
    private final EncryptAlgorithm encryptAlgorithm;

    public static /* synthetic */ SignAlgorithm copy$default(SignAlgorithm signAlgorithm, EncryptAlgorithm encryptAlgorithm, DigestAlgorithm digestAlgorithm, int i, Object obj) {
        if ((i & 1) != 0) {
            encryptAlgorithm = signAlgorithm.encryptAlgorithm;
        }
        if ((i & 2) != 0) {
            digestAlgorithm = signAlgorithm.digestAlgorithm;
        }
        return signAlgorithm.copy(encryptAlgorithm, digestAlgorithm);
    }

    @JvmStatic
    public static final SignAlgorithm parse(byte b) {
        return INSTANCE.parse(b);
    }

    /* renamed from: component1, reason: from getter */
    public final EncryptAlgorithm getEncryptAlgorithm() {
        return this.encryptAlgorithm;
    }

    /* renamed from: component2, reason: from getter */
    public final DigestAlgorithm getDigestAlgorithm() {
        return this.digestAlgorithm;
    }

    public final SignAlgorithm copy(EncryptAlgorithm encryptAlgorithm, DigestAlgorithm digestAlgorithm) {
        return new SignAlgorithm(encryptAlgorithm, digestAlgorithm);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SignAlgorithm)) {
            return false;
        }
        SignAlgorithm signAlgorithm = (SignAlgorithm) other;
        return this.encryptAlgorithm == signAlgorithm.encryptAlgorithm && this.digestAlgorithm == signAlgorithm.digestAlgorithm;
    }

    public int hashCode() {
        EncryptAlgorithm encryptAlgorithm = this.encryptAlgorithm;
        int hashCode = (encryptAlgorithm == null ? 0 : encryptAlgorithm.hashCode()) * 31;
        DigestAlgorithm digestAlgorithm = this.digestAlgorithm;
        return hashCode + (digestAlgorithm != null ? digestAlgorithm.hashCode() : 0);
    }

    public String toString() {
        return "SignAlgorithm(encryptAlgorithm=" + this.encryptAlgorithm + ", digestAlgorithm=" + this.digestAlgorithm + ')';
    }

    /* compiled from: SignAuthBean.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ies/argus/bean/SignAlgorithm$Companion;", "", "()V", RLMonitorReporter.PARSE, "Lcom/bytedance/ies/argus/bean/SignAlgorithm;", "type", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final SignAlgorithm parse(byte type) {
            return new SignAlgorithm(EncryptAlgorithm.INSTANCE.getEncryptAlgorithm((byte) (((byte) 240) & type)), DigestAlgorithm.INSTANCE.getDigestAlgorithm((byte) (type & 15)));
        }
    }

    public SignAlgorithm(EncryptAlgorithm encryptAlgorithm, DigestAlgorithm digestAlgorithm) {
        this.encryptAlgorithm = encryptAlgorithm;
        this.digestAlgorithm = digestAlgorithm;
    }

    public final DigestAlgorithm getDigestAlgorithm() {
        return this.digestAlgorithm;
    }

    public final EncryptAlgorithm getEncryptAlgorithm() {
        return this.encryptAlgorithm;
    }
}
