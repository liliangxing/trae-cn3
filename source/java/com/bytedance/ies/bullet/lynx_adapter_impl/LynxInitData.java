package com.bytedance.ies.bullet.lynx_adapter_impl;

import android.os.Bundle;
import android.util.Log;
import com.lynx.tasm.TemplateData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: LynxInitData.kt */
@Deprecated(message = "deprecated", replaceWith = @ReplaceWith(expression = "use LynxInitDataWrapper", imports = {}))
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/bytedance/ies/bullet/lynx_adapter_impl/LynxInitData;", "", "()V", "mData", "Lcom/lynx/tasm/TemplateData;", "getTemplateData", "put", "", "key", "", "value", "Companion", "lynx-adapter-impl_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class LynxInitData {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "LynxInitData";
    private TemplateData mData;

    @JvmStatic
    public static final LynxInitData fromMap(Map<String, ? extends Object> map) {
        return INSTANCE.fromMap(map);
    }

    @Deprecated(message = "use LynxInitData.fromMap() instead", replaceWith = @ReplaceWith(expression = "LynxInitData.fromMap()", imports = {}))
    @JvmStatic
    public static final LynxInitData fromString(String str) {
        return INSTANCE.fromString(str);
    }

    @JvmStatic
    public static final Object tryTransformUnsupportedData(Object obj) {
        return INSTANCE.tryTransformUnsupportedData(obj);
    }

    public LynxInitData() {
        TemplateData empty = TemplateData.empty();
        Intrinsics.checkExpressionValueIsNotNull(empty, "TemplateData.empty()");
        this.mData = empty;
    }

    /* renamed from: getTemplateData, reason: from getter */
    public final TemplateData getMData() {
        return this.mData;
    }

    public final void put(String key, Object value) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        this.mData.put(key, INSTANCE.tryTransformUnsupportedData(value));
    }

    /* compiled from: LynxInitData.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0005\u001a\u00020\u00062\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\bH\u0007J\u0012\u0010\t\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0007J\u0014\u0010\u000b\u001a\u0004\u0018\u00010\u00012\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/bytedance/ies/bullet/lynx_adapter_impl/LynxInitData$Companion;", "", "()V", "TAG", "", "fromMap", "Lcom/bytedance/ies/bullet/lynx_adapter_impl/LynxInitData;", "data", "", "fromString", "json", "tryTransformUnsupportedData", "value", "lynx-adapter-impl_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final LynxInitData fromMap(Map<String, ? extends Object> data) {
            LynxInitData lynxInitData = new LynxInitData();
            Object tryTransformUnsupportedData = LynxInitData.INSTANCE.tryTransformUnsupportedData(data);
            if (!(tryTransformUnsupportedData instanceof Map)) {
                tryTransformUnsupportedData = null;
            }
            TemplateData fromMap = TemplateData.fromMap((Map) tryTransformUnsupportedData);
            Intrinsics.checkExpressionValueIsNotNull(fromMap, "TemplateData.fromMap(optValue)");
            lynxInitData.mData = fromMap;
            return lynxInitData;
        }

        @Deprecated(message = "use LynxInitData.fromMap() instead", replaceWith = @ReplaceWith(expression = "LynxInitData.fromMap()", imports = {}))
        @JvmStatic
        public final LynxInitData fromString(String json) {
            LynxInitData lynxInitData = new LynxInitData();
            TemplateData fromString = TemplateData.fromString(json);
            Intrinsics.checkExpressionValueIsNotNull(fromString, "TemplateData.fromString(json)");
            lynxInitData.mData = fromString;
            return lynxInitData;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v12, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r0v14, types: [java.util.Map] */
        /* JADX WARN: Type inference failed for: r0v16, types: [java.util.Map] */
        /* JADX WARN: Type inference failed for: r0v18, types: [java.util.Map] */
        /* JADX WARN: Type inference failed for: r0v20 */
        /* JADX WARN: Type inference failed for: r0v22, types: [java.util.List] */
        @JvmStatic
        public final Object tryTransformUnsupportedData(Object value) {
            Object arrayList;
            if (value == null) {
                return null;
            }
            Log.d(LynxInitData.TAG, "dealing with " + value + '[' + value.getClass() + ']');
            if (value instanceof List) {
                arrayList = new ArrayList();
                Iterator it = ((Iterable) value).iterator();
                while (it.hasNext()) {
                    arrayList.add(LynxInitData.INSTANCE.tryTransformUnsupportedData(it.next()));
                }
            } else if (value instanceof Map) {
                arrayList = new LinkedHashMap();
                for (Map.Entry entry : ((Map) value).entrySet()) {
                    if (entry.getKey() instanceof String) {
                        Object key = entry.getKey();
                        if (key == null) {
                            throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
                        }
                        arrayList.put((String) key, LynxInitData.INSTANCE.tryTransformUnsupportedData(entry.getValue()));
                    } else {
                        Log.e(LynxInitData.TAG, "unsupported value " + entry);
                    }
                }
            } else if (value instanceof Bundle) {
                arrayList = new LinkedHashMap();
                Bundle bundle = (Bundle) value;
                Set<String> keySet = bundle.keySet();
                Intrinsics.checkExpressionValueIsNotNull(keySet, "value.keySet()");
                for (String str : keySet) {
                    Intrinsics.checkExpressionValueIsNotNull(str, "it");
                    arrayList.put(str, LynxInitData.INSTANCE.tryTransformUnsupportedData(bundle.get(str)));
                }
            } else if (value instanceof JSONObject) {
                arrayList = new LinkedHashMap();
                JSONObject jSONObject = (JSONObject) value;
                Iterator<String> keys = jSONObject.keys();
                Intrinsics.checkExpressionValueIsNotNull(keys, "value.keys()");
                while (keys.hasNext()) {
                    String next = keys.next();
                    Intrinsics.checkExpressionValueIsNotNull(next, "it");
                    arrayList.put(next, LynxInitData.INSTANCE.tryTransformUnsupportedData(jSONObject.get(next)));
                }
            } else {
                if (!(value instanceof JSONArray)) {
                    return value;
                }
                arrayList = new ArrayList();
                JSONArray jSONArray = (JSONArray) value;
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    arrayList.add(LynxInitData.INSTANCE.tryTransformUnsupportedData(jSONArray.get(i)));
                }
            }
            return arrayList;
        }
    }
}
