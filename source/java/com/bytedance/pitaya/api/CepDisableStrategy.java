package com.bytedance.pitaya.api;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: CepDisableStrategy.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/pitaya/api/CepDisableStrategy;", "", "code", "", "(Ljava/lang/String;II)V", "getCode", "()I", "PREVENT_INPUT", "STOP", "CLEAN", "Companion", "pitayacore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public enum CepDisableStrategy {
    PREVENT_INPUT(0),
    STOP(1),
    CLEAN(2);


    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int code;

    CepDisableStrategy(int i) {
        this.code = i;
    }

    public final int getCode() {
        return this.code;
    }

    /* compiled from: CepDisableStrategy.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/pitaya/api/CepDisableStrategy$Companion;", "", "()V", "fromInt", "Lcom/bytedance/pitaya/api/CepDisableStrategy;", "code", "", "pitayacore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CepDisableStrategy fromInt(int code) {
            for (CepDisableStrategy cepDisableStrategy : CepDisableStrategy.values()) {
                if (cepDisableStrategy.getCode() == code) {
                    return cepDisableStrategy;
                }
            }
            return null;
        }
    }
}
