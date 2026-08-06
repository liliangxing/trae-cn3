package com.bytedance.ies.argus.strategy;

import com.bytedance.ies.argus.base.ArgusLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: BaseStrategyParams.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\u0005H\u0016J\u0012\u0010\n\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\u0005H\u0016J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0006H\u0016R \u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ies/argus/strategy/BaseRewritePayload;", "Lcom/bytedance/ies/argus/strategy/BaseStrategyParams;", "()V", "innerData", "", "", "", "getInnerData$anniex_release", "()Ljava/util/Map;", "toString", "ttmGetValue", "key", "ttmSetValue", "", "value", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public abstract class BaseRewritePayload extends BaseStrategyParams {
    private final Map<String, Object> innerData = new LinkedHashMap();

    public final Map<String, Object> getInnerData$anniex_release() {
        return this.innerData;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x004e A[Catch: Exception -> 0x0054, TRY_LEAVE, TryCatch #0 {Exception -> 0x0054, blocks: (B:3:0x000c, B:5:0x0010, B:7:0x0018, B:9:0x004e, B:13:0x001d, B:15:0x0026, B:16:0x002b, B:18:0x0038), top: B:2:0x000c }] */
    @Override // com.bytedance.ies.argus.strategy.BaseStrategyParams
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean ttmSetValue(String key, Object value) {
        Object obj;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        try {
        } catch (Exception e) {
            ArgusLog.e$default(ArgusLog.INSTANCE, "ttmSetValue", "got error: " + e + ", k=" + key + ", v=" + value, null, null, 12, null);
        }
        if (value instanceof String) {
            if (Intrinsics.areEqual(value, "bool_true")) {
                obj = true;
            } else if (Intrinsics.areEqual(value, "bool_false")) {
                obj = false;
            } else if (StringsKt.startsWith$default((String) value, "int_", false, 2, (Object) null)) {
                obj = StringsKt.toIntOrNull(StringsKt.replace$default((String) value, "int_", "", false, 4, (Object) null));
            }
            if (obj != null) {
                this.innerData.put(key, obj);
            }
            return true;
        }
        obj = value;
        if (obj != null) {
        }
        return true;
    }

    @Override // com.bytedance.ies.argus.strategy.BaseStrategyParams
    public Object ttmGetValue(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.innerData.get(key);
    }

    public String toString() {
        return MapsKt.toMap(this.innerData).toString();
    }
}
