package com.bytedance.kmp.network.multinet;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

/* compiled from: MultiNetState.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/bytedance/kmp/network/multinet/MultiNetStateValue;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "STOPPED", "NO_NETWORK", "DEFAULT_CELLULAR_WITH_WIFI_DOWN", "DEFAULT_WIFI_WITH_CELLULAR_DOWN", "DEFAULT_WIFI_WITH_CELLULAR_UP", "DEFAULT_VPN", "Companion", "network_service_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes4.dex */
public enum MultiNetStateValue {
    STOPPED(-1),
    NO_NETWORK(0),
    DEFAULT_CELLULAR_WITH_WIFI_DOWN(1),
    DEFAULT_WIFI_WITH_CELLULAR_DOWN(2),
    DEFAULT_WIFI_WITH_CELLULAR_UP(3),
    DEFAULT_VPN(5);

    private final int value;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy<Map<Integer, MultiNetStateValue>> valueMap$delegate = LazyKt.lazy(new Function0<Map<Integer, ? extends MultiNetStateValue>>() { // from class: com.bytedance.kmp.network.multinet.MultiNetStateValue$Companion$valueMap$2
        @Override // kotlin.jvm.functions.Function0
        public final Map<Integer, ? extends MultiNetStateValue> invoke() {
            MultiNetStateValue[] values = MultiNetStateValue.values();
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(values.length), 16));
            for (MultiNetStateValue multiNetStateValue : values) {
                linkedHashMap.put(Integer.valueOf(multiNetStateValue.getValue()), multiNetStateValue);
            }
            return linkedHashMap;
        }
    });

    MultiNetStateValue(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }

    /* compiled from: MultiNetState.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0005R'\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lcom/bytedance/kmp/network/multinet/MultiNetStateValue$Companion;", "", "()V", "valueMap", "", "", "Lcom/bytedance/kmp/network/multinet/MultiNetStateValue;", "getValueMap", "()Ljava/util/Map;", "valueMap$delegate", "Lkotlin/Lazy;", "fromValue", "value", "network_service_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        private final Map<Integer, MultiNetStateValue> getValueMap() {
            return (Map) MultiNetStateValue.valueMap$delegate.getValue();
        }

        public final MultiNetStateValue fromValue(int value) {
            MultiNetStateValue multiNetStateValue = getValueMap().get(Integer.valueOf(value));
            return multiNetStateValue == null ? MultiNetStateValue.STOPPED : multiNetStateValue;
        }
    }
}
