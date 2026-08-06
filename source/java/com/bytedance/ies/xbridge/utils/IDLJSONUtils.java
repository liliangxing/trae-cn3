package com.bytedance.ies.xbridge.utils;

import com.bytedance.ies.xbridge.model.idl.IDLXDynamic;
import com.bytedance.ies.xbridge.model.idl.IDLXDynamicKt;
import com.bytedance.ies.xbridge.model.idl.XBaseModel;
import com.bytedance.ug.sdk.deeplink.EventConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: IDLJSONUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u00020\u00042\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006H\u0007J\u0018\u0010\u0007\u001a\u00020\b2\u000e\u0010\u0005\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\tH\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/ies/xbridge/utils/IDLJSONUtils;", "", "()V", "toJSONArray", "Lorg/json/JSONArray;", EventConstants.PARAM_SOURCE, "", "toJSONObject", "Lorg/json/JSONObject;", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class IDLJSONUtils {
    public static final IDLJSONUtils INSTANCE = new IDLJSONUtils();

    private IDLJSONUtils() {
    }

    @JvmStatic
    public static final JSONArray toJSONArray(List<?> source) {
        Intrinsics.checkNotNullParameter(source, EventConstants.PARAM_SOURCE);
        JSONArray jSONArray = new JSONArray();
        List filterNotNull = CollectionsKt.filterNotNull(source);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(filterNotNull, 10));
        for (Object obj : filterNotNull) {
            if (!(obj instanceof Integer) && !(obj instanceof Long) && !(obj instanceof String) && !(obj instanceof Boolean) && !(obj instanceof Double)) {
                if (obj instanceof List) {
                    obj = toJSONArray((List) obj);
                } else if (obj instanceof Map) {
                    obj = toJSONObject((Map) obj);
                } else if (obj instanceof IDLXDynamic) {
                    obj = IDLXDynamicKt.toPrimitiveOrJSON((IDLXDynamic) obj);
                } else {
                    obj = obj instanceof XBaseModel ? ((XBaseModel) obj).toJSON() : null;
                }
            }
            arrayList.add(obj);
        }
        for (Object obj2 : arrayList) {
            if (obj2 != null) {
                jSONArray.put(obj2);
            }
        }
        return jSONArray;
    }

    @JvmStatic
    public static final JSONObject toJSONObject(Map<?, ?> source) {
        Intrinsics.checkNotNullParameter(source, EventConstants.PARAM_SOURCE);
        JSONObject jSONObject = new JSONObject();
        ArrayList<Pair> arrayList = new ArrayList(source.size());
        for (Map.Entry<?, ?> entry : source.entrySet()) {
            Object value = entry.getValue();
            Object key = entry.getKey();
            if (!(value instanceof Integer) && !(value instanceof Long) && !(value instanceof String) && !(value instanceof Boolean) && !(value instanceof Double)) {
                if (value instanceof List) {
                    value = toJSONArray((List) value);
                } else if (value instanceof Map) {
                    value = toJSONObject((Map) value);
                } else if (value instanceof IDLXDynamic) {
                    value = IDLXDynamicKt.toPrimitiveOrJSON((IDLXDynamic) value);
                } else {
                    value = value instanceof XBaseModel ? ((XBaseModel) value).toJSON() : null;
                }
            }
            arrayList.add(TuplesKt.to(key, value));
        }
        for (Pair pair : arrayList) {
            Object first = pair.getFirst();
            if (first != null && (first instanceof String)) {
                jSONObject.put((String) first, pair.getSecond());
            }
        }
        return jSONObject;
    }
}
