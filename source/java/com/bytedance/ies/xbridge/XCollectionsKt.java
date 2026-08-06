package com.bytedance.ies.xbridge;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: XCollections.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0000\u001a \u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0001\u001a\u001c\u0010\u0006\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0007\u001a\u001c\u0010\b\u001a\u00020\t*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\t\u001a\u001c\u0010\n\u001a\u00020\u000b*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u000b\u001a \u0010\f\u001a\u0004\u0018\u00010\u0002*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u001a\u001c\u0010\r\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u001a \u0010\u000e\u001a\u0004\u0018\u00010\u0004*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u001a\u0010\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010*\u00020\u0001\u001a\u0016\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00110\u0013*\u00020\u0002¨\u0006\u0014"}, d2 = {"optArray", "Lcom/bytedance/ies/xbridge/XReadableArray;", "Lcom/bytedance/ies/xbridge/XReadableMap;", "name", "", "defaultValue", "optBoolean", "", "optDouble", "", "optInt", "", "optMap", "optString", "optStringOrNull", "toObjectList", "", "", "toObjectMap", "", "anniex_release"}, k = 2, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class XCollectionsKt {

    /* compiled from: XCollections.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[XReadableType.values().length];
            try {
                iArr[XReadableType.String.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[XReadableType.Number.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[XReadableType.Boolean.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[XReadableType.Int.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[XReadableType.Map.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[XReadableType.Array.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static /* synthetic */ String optStringOrNull$default(XReadableMap xReadableMap, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "";
        }
        return optStringOrNull(xReadableMap, str, str2);
    }

    public static final String optStringOrNull(XReadableMap xReadableMap, String str, String str2) {
        Intrinsics.checkNotNullParameter(xReadableMap, "<this>");
        Intrinsics.checkNotNullParameter(str, "name");
        if (!xReadableMap.hasKey(str)) {
            return str2;
        }
        XDynamic xDynamic = xReadableMap.get(str);
        return xDynamic.getType() == XReadableType.String ? xDynamic.asString() : str2;
    }

    public static /* synthetic */ String optString$default(XReadableMap xReadableMap, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "";
        }
        return optString(xReadableMap, str, str2);
    }

    public static final String optString(XReadableMap xReadableMap, String str, String str2) {
        Intrinsics.checkNotNullParameter(xReadableMap, "<this>");
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "defaultValue");
        if (!xReadableMap.hasKey(str)) {
            return str2;
        }
        XDynamic xDynamic = xReadableMap.get(str);
        return xDynamic.getType() == XReadableType.String ? xDynamic.asString() : str2;
    }

    public static /* synthetic */ boolean optBoolean$default(XReadableMap xReadableMap, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return optBoolean(xReadableMap, str, z);
    }

    public static final boolean optBoolean(XReadableMap xReadableMap, String str, boolean z) {
        Intrinsics.checkNotNullParameter(xReadableMap, "<this>");
        Intrinsics.checkNotNullParameter(str, "name");
        if (!xReadableMap.hasKey(str)) {
            return z;
        }
        XDynamic xDynamic = xReadableMap.get(str);
        return xDynamic.getType() == XReadableType.Boolean ? xDynamic.asBoolean() : z;
    }

    public static /* synthetic */ int optInt$default(XReadableMap xReadableMap, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return optInt(xReadableMap, str, i);
    }

    public static final int optInt(XReadableMap xReadableMap, String str, int i) {
        Intrinsics.checkNotNullParameter(xReadableMap, "<this>");
        Intrinsics.checkNotNullParameter(str, "name");
        if (!xReadableMap.hasKey(str)) {
            return i;
        }
        XDynamic xDynamic = xReadableMap.get(str);
        return xDynamic.getType() == XReadableType.Int ? xDynamic.asInt() : i;
    }

    public static /* synthetic */ double optDouble$default(XReadableMap xReadableMap, String str, double d, int i, Object obj) {
        if ((i & 2) != 0) {
            d = 0.0d;
        }
        return optDouble(xReadableMap, str, d);
    }

    public static final double optDouble(XReadableMap xReadableMap, String str, double d) {
        Intrinsics.checkNotNullParameter(xReadableMap, "<this>");
        Intrinsics.checkNotNullParameter(str, "name");
        if (!xReadableMap.hasKey(str)) {
            return d;
        }
        XDynamic xDynamic = xReadableMap.get(str);
        return xDynamic.getType() == XReadableType.Number ? xDynamic.asDouble() : d;
    }

    public static /* synthetic */ XReadableMap optMap$default(XReadableMap xReadableMap, String str, XReadableMap xReadableMap2, int i, Object obj) {
        if ((i & 2) != 0) {
            xReadableMap2 = null;
        }
        return optMap(xReadableMap, str, xReadableMap2);
    }

    public static final XReadableMap optMap(XReadableMap xReadableMap, String str, XReadableMap xReadableMap2) {
        Intrinsics.checkNotNullParameter(xReadableMap, "<this>");
        Intrinsics.checkNotNullParameter(str, "name");
        if (!xReadableMap.hasKey(str)) {
            return xReadableMap2;
        }
        XDynamic xDynamic = xReadableMap.get(str);
        return xDynamic.getType() == XReadableType.Map ? xDynamic.asMap() : xReadableMap2;
    }

    public static /* synthetic */ XReadableArray optArray$default(XReadableMap xReadableMap, String str, XReadableArray xReadableArray, int i, Object obj) {
        if ((i & 2) != 0) {
            xReadableArray = null;
        }
        return optArray(xReadableMap, str, xReadableArray);
    }

    public static final XReadableArray optArray(XReadableMap xReadableMap, String str, XReadableArray xReadableArray) {
        Intrinsics.checkNotNullParameter(xReadableMap, "<this>");
        Intrinsics.checkNotNullParameter(str, "name");
        if (!xReadableMap.hasKey(str)) {
            return xReadableArray;
        }
        XDynamic xDynamic = xReadableMap.get(str);
        return xDynamic.getType() == XReadableType.Array ? xDynamic.asArray() : xReadableArray;
    }

    public static final List<Object> toObjectList(XReadableArray xReadableArray) {
        Intrinsics.checkNotNullParameter(xReadableArray, "<this>");
        ArrayList arrayList = new ArrayList();
        int size = xReadableArray.size();
        for (int i = 0; i < size; i++) {
            switch (WhenMappings.$EnumSwitchMapping$0[xReadableArray.getType(i).ordinal()]) {
                case 1:
                    arrayList.add(xReadableArray.getString(i));
                    break;
                case 2:
                    arrayList.add(Double.valueOf(xReadableArray.getDouble(i)));
                    break;
                case 3:
                    arrayList.add(Boolean.valueOf(xReadableArray.getBoolean(i)));
                    break;
                case 4:
                    arrayList.add(Integer.valueOf(xReadableArray.getInt(i)));
                    break;
                case 5:
                    XReadableMap map = xReadableArray.getMap(i);
                    if (map != null) {
                        arrayList.add(toObjectMap(map));
                        break;
                    } else {
                        break;
                    }
                case 6:
                    XReadableArray array = xReadableArray.getArray(i);
                    if (array != null) {
                        arrayList.add(toObjectList(array));
                        break;
                    } else {
                        break;
                    }
            }
        }
        return arrayList;
    }

    public static final Map<String, Object> toObjectMap(XReadableMap xReadableMap) {
        Intrinsics.checkNotNullParameter(xReadableMap, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        XKeyIterator keyIterator = xReadableMap.keyIterator();
        while (keyIterator.hasNextKey()) {
            String nextKey = keyIterator.nextKey();
            switch (WhenMappings.$EnumSwitchMapping$0[xReadableMap.getType(nextKey).ordinal()]) {
                case 1:
                    linkedHashMap.put(nextKey, xReadableMap.getString(nextKey));
                    break;
                case 2:
                    linkedHashMap.put(nextKey, Double.valueOf(xReadableMap.getDouble(nextKey)));
                    break;
                case 3:
                    linkedHashMap.put(nextKey, Boolean.valueOf(xReadableMap.getBoolean(nextKey)));
                    break;
                case 4:
                    linkedHashMap.put(nextKey, Integer.valueOf(xReadableMap.getInt(nextKey)));
                    break;
                case 5:
                    XReadableMap map = xReadableMap.getMap(nextKey);
                    if (map == null) {
                        break;
                    } else {
                        linkedHashMap.put(nextKey, toObjectMap(map));
                        break;
                    }
                case 6:
                    XReadableArray array = xReadableMap.getArray(nextKey);
                    if (array == null) {
                        break;
                    } else {
                        linkedHashMap.put(nextKey, toObjectList(array));
                        break;
                    }
            }
        }
        return linkedHashMap;
    }
}
