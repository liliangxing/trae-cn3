package com.bytedance.sdk.xbridge.cn.auth.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: BridgeCallRecord.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0006\b\u0086\u0001\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/auth/bean/DigestAlgorithm;", "", "value", "", "(Ljava/lang/String;IB)V", "getValue", "()B", "SHA256", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public enum DigestAlgorithm {
    SHA256((byte) 1);


    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final byte value;

    DigestAlgorithm(byte b) {
        this.value = b;
    }

    public final byte getValue() {
        return this.value;
    }

    /* compiled from: BridgeCallRecord.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/auth/bean/DigestAlgorithm$Companion;", "", "()V", "getDigestAlgorithm", "Lcom/bytedance/sdk/xbridge/cn/auth/bean/DigestAlgorithm;", "value", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DigestAlgorithm getDigestAlgorithm(byte value) {
            if (value == ((byte) 1)) {
                return DigestAlgorithm.SHA256;
            }
            return null;
        }
    }
}
