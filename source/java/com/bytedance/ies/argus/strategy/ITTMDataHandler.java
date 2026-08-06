package com.bytedance.ies.argus.strategy;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BaseStrategyParams.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0001H\u0016¨\u0006\b"}, d2 = {"Lcom/bytedance/ies/argus/strategy/ITTMDataHandler;", "", "getValue", "key", "", "setValue", "", "value", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public interface ITTMDataHandler {

    /* compiled from: BaseStrategyParams.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
        public static Object getValue(ITTMDataHandler iTTMDataHandler, String key) {
            Intrinsics.checkNotNullParameter(key, "key");
            return null;
        }

        public static boolean setValue(ITTMDataHandler iTTMDataHandler, String key, Object value) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            return false;
        }
    }

    Object getValue(String key);

    boolean setValue(String key, Object value);
}
