package com.bytedance.sdk.xbridge.cn.registry.core.utils;

import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.timonbase.pipeline.TimonPipeline;
import java.util.ArrayList;
import java.util.Iterator;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001H\u0002J\u0014\u0010\u0005\u001a\u00020\u00062\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bH\u0007J\u0018\u0010\t\u001a\u00020\n2\u000e\u0010\u0007\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000bH\u0007¨\u0006\f"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/registry/core/utils/IDLJSONUtils;", "", "()V", "deepDecode", "it", "toJSONArray", "Lorg/json/JSONArray;", TimonPipeline.KEY_SOURCE, "", "toJSONObject", "Lorg/json/JSONObject;", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class IDLJSONUtils {
    public static final IDLJSONUtils INSTANCE = new IDLJSONUtils();

    private IDLJSONUtils() {
    }

    @JvmStatic
    public static final JSONArray toJSONArray(List<?> source) {
        Intrinsics.checkNotNullParameter(source, TimonPipeline.KEY_SOURCE);
        JSONArray jSONArray = new JSONArray();
        List filterNotNull = CollectionsKt.filterNotNull(source);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(filterNotNull, 10));
        Iterator it = filterNotNull.iterator();
        while (it.hasNext()) {
            arrayList.add(INSTANCE.deepDecode(it.next()));
        }
        for (Object obj : arrayList) {
            if (obj != null) {
                jSONArray.put(obj);
            }
        }
        return jSONArray;
    }

    @JvmStatic
    public static final JSONObject toJSONObject(Map<?, ?> source) {
        Intrinsics.checkNotNullParameter(source, TimonPipeline.KEY_SOURCE);
        JSONObject jSONObject = new JSONObject();
        ArrayList<Pair> arrayList = new ArrayList(source.size());
        for (Map.Entry<?, ?> entry : source.entrySet()) {
            arrayList.add(TuplesKt.to(entry.getKey(), INSTANCE.deepDecode(entry.getValue())));
        }
        for (Pair pair : arrayList) {
            Object first = pair.getFirst();
            if (first != null && (first instanceof String)) {
                jSONObject.put((String) first, pair.getSecond());
            }
        }
        return jSONObject;
    }

    private final Object deepDecode(Object it) {
        if (it instanceof Number ? true : it instanceof String ? true : it instanceof Boolean) {
            return it;
        }
        if (it instanceof List) {
            return toJSONArray((List) it);
        }
        if (it instanceof Map) {
            return toJSONObject((Map) it);
        }
        if (it instanceof XBaseModel) {
            return ((XBaseModel) it).toJSON();
        }
        return null;
    }
}
