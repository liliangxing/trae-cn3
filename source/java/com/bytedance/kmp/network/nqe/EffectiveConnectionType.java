package com.bytedance.kmp.network.nqe;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: NQEListener.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\u0001\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0011B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0012"}, d2 = {"Lcom/bytedance/kmp/network/nqe/EffectiveConnectionType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "FAKE_NETWORK", "UNKNOWN", "OFFLINE", "SLOW_2G", "GOOD_2G", "TYPE_3G", "POOR_4G", "FAIR_4G", "GOOD_4G", "EXCELLENT_4G", "Companion", "network_service_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes4.dex */
public enum EffectiveConnectionType {
    FAKE_NETWORK(-1),
    UNKNOWN(0),
    OFFLINE(1),
    SLOW_2G(2),
    GOOD_2G(3),
    TYPE_3G(4),
    POOR_4G(5),
    FAIR_4G(6),
    GOOD_4G(7),
    EXCELLENT_4G(8);


    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int value;

    EffectiveConnectionType(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }

    /* compiled from: NQEListener.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/kmp/network/nqe/EffectiveConnectionType$Companion;", "", "()V", "fromInt", "Lcom/bytedance/kmp/network/nqe/EffectiveConnectionType;", "value", "", "network_service_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final EffectiveConnectionType fromInt(int value) {
            EffectiveConnectionType effectiveConnectionType;
            EffectiveConnectionType[] values = EffectiveConnectionType.values();
            int length = values.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    effectiveConnectionType = null;
                    break;
                }
                effectiveConnectionType = values[i];
                if (effectiveConnectionType.getValue() == value) {
                    break;
                }
                i++;
            }
            return effectiveConnectionType == null ? EffectiveConnectionType.UNKNOWN : effectiveConnectionType;
        }
    }
}
