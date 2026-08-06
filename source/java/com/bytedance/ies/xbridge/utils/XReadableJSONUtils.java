package com.bytedance.ies.xbridge.utils;

import com.bytedance.ies.xbridge.XKeyIterator;
import com.bytedance.ies.xbridge.XReadableArray;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.XReadableType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: XReadableJSONUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\b2\u0006\u0010\u0005\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ies/xbridge/utils/XReadableJSONUtils;", "", "()V", "jsonArrayToArray", "", "value", "Lorg/json/JSONArray;", "jsonObjectToMap", "", "", "Lorg/json/JSONObject;", "xReadableArrayToJSONArray", "Lcom/bytedance/ies/xbridge/XReadableArray;", "xReadableMapToJSONObject", "Lcom/bytedance/ies/xbridge/XReadableMap;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class XReadableJSONUtils {
    public static final XReadableJSONUtils INSTANCE = new XReadableJSONUtils();

    /* compiled from: XReadableJSONUtils.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[XReadableType.values().length];
            try {
                iArr[XReadableType.Array.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[XReadableType.Map.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[XReadableType.String.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[XReadableType.Number.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[XReadableType.Int.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[XReadableType.Boolean.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private XReadableJSONUtils() {
    }

    public final JSONArray xReadableArrayToJSONArray(XReadableArray value) {
        Intrinsics.checkNotNullParameter(value, "value");
        JSONArray jSONArray = new JSONArray();
        Iterator<T> it = value.toList().iterator();
        int i = 0;
        while (it.hasNext()) {
            it.next();
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            switch (WhenMappings.$EnumSwitchMapping$0[value.getType(i).ordinal()]) {
                case 1:
                    XReadableArray array = value.getArray(i);
                    if (array == null) {
                        break;
                    } else {
                        jSONArray.put(INSTANCE.xReadableArrayToJSONArray(array));
                        break;
                    }
                case 2:
                    XReadableMap map = value.getMap(i);
                    if (map == null) {
                        break;
                    } else {
                        jSONArray.put(INSTANCE.xReadableMapToJSONObject(map));
                        break;
                    }
                case 3:
                    jSONArray.put(value.getString(i));
                    break;
                case 4:
                    jSONArray.put(value.getDouble(i));
                    break;
                case 5:
                    jSONArray.put(value.getInt(i));
                    break;
                case 6:
                    jSONArray.put(value.getBoolean(i));
                    break;
            }
            i = i2;
        }
        return jSONArray;
    }

    public final JSONObject xReadableMapToJSONObject(XReadableMap value) {
        Intrinsics.checkNotNullParameter(value, "value");
        JSONObject jSONObject = new JSONObject();
        XKeyIterator keyIterator = value.keyIterator();
        while (keyIterator.hasNextKey()) {
            String nextKey = keyIterator.nextKey();
            switch (WhenMappings.$EnumSwitchMapping$0[value.getType(nextKey).ordinal()]) {
                case 1:
                    XReadableArray array = value.getArray(nextKey);
                    if (array == null) {
                        break;
                    } else {
                        jSONObject.put(nextKey, INSTANCE.xReadableArrayToJSONArray(array));
                        break;
                    }
                case 2:
                    XReadableMap map = value.getMap(nextKey);
                    if (map == null) {
                        break;
                    } else {
                        jSONObject.put(nextKey, INSTANCE.xReadableMapToJSONObject(map));
                        break;
                    }
                case 3:
                    jSONObject.put(nextKey, value.getString(nextKey));
                    break;
                case 4:
                    jSONObject.put(nextKey, value.getDouble(nextKey));
                    break;
                case 5:
                    jSONObject.put(nextKey, value.getInt(nextKey));
                    break;
                case 6:
                    jSONObject.put(nextKey, value.getBoolean(nextKey));
                    break;
            }
        }
        return jSONObject;
    }

    public final List<Object> jsonArrayToArray(JSONArray value) {
        Intrinsics.checkNotNullParameter(value, "value");
        ArrayList arrayList = new ArrayList();
        int length = value.length();
        for (int i = 0; i < length; i++) {
            Object obj = value.get(i);
            Intrinsics.checkNotNullExpressionValue(obj, "value.get(idx)");
            arrayList.add(obj);
        }
        return CollectionsKt.toList(arrayList);
    }

    public final Map<String, Object> jsonObjectToMap(JSONObject value) {
        Intrinsics.checkNotNullParameter(value, "value");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<String> keys = value.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Intrinsics.checkNotNullExpressionValue(next, "key");
            Object obj = value.get(next);
            Intrinsics.checkNotNullExpressionValue(obj, "value.get(key)");
            linkedHashMap.put(next, obj);
        }
        return MapsKt.toMap(linkedHashMap);
    }
}
