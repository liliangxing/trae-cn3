package com.bytedance.ies.argus.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.bouncycastle.math.ec.Tnaf;

/* compiled from: SignAuthBean.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0006\b\u0086\u0001\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/ies/argus/bean/EncryptAlgorithm;", "", "value", "", "(Ljava/lang/String;IB)V", "getValue", "()B", "RSA", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public enum EncryptAlgorithm {
    RSA(Tnaf.POW_2_WIDTH);


    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final byte value;

    EncryptAlgorithm(byte b) {
        this.value = b;
    }

    public final byte getValue() {
        return this.value;
    }

    /* compiled from: SignAuthBean.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ies/argus/bean/EncryptAlgorithm$Companion;", "", "()V", "getEncryptAlgorithm", "Lcom/bytedance/ies/argus/bean/EncryptAlgorithm;", "value", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final EncryptAlgorithm getEncryptAlgorithm(byte value) {
            if (value == ((byte) 16)) {
                return EncryptAlgorithm.RSA;
            }
            return null;
        }
    }
}
