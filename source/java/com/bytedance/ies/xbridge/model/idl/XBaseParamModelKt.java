package com.bytedance.ies.xbridge.model.idl;

import com.bytedance.ies.xbridge.XCollectionsKt;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.XReadableType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: XBaseParamModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\u001a!\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007\u001a\"\u0010\b\u001a\u00020\t*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t\u001a+\u0010\u000b\u001a\u0004\u0018\u00010\f*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\f¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"getBooleanValue", "", "Lcom/bytedance/ies/xbridge/model/idl/XBaseParamModel;", "params", "Lcom/bytedance/ies/xbridge/XReadableMap;", "name", "", "(Lcom/bytedance/ies/xbridge/model/idl/XBaseParamModel;Lcom/bytedance/ies/xbridge/XReadableMap;Ljava/lang/String;)Ljava/lang/Boolean;", "getIntValue", "", "defaultValue", "getLongValue", "", "(Lcom/bytedance/ies/xbridge/model/idl/XBaseParamModel;Lcom/bytedance/ies/xbridge/XReadableMap;Ljava/lang/String;J)Ljava/lang/Long;", "anniex_release"}, k = 2, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class XBaseParamModelKt {

    /* compiled from: XBaseParamModel.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[XReadableType.values().length];
            try {
                iArr[XReadableType.Int.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[XReadableType.Number.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final int getIntValue(XBaseParamModel xBaseParamModel, XReadableMap xReadableMap, String str, int i) {
        Intrinsics.checkNotNullParameter(xBaseParamModel, "<this>");
        Intrinsics.checkNotNullParameter(xReadableMap, "params");
        Intrinsics.checkNotNullParameter(str, "name");
        if (!xReadableMap.hasKey(str)) {
            return i;
        }
        if (xReadableMap.get(str).getType() == XReadableType.Int) {
            return XCollectionsKt.optInt(xReadableMap, str, i);
        }
        return xReadableMap.get(str).getType() == XReadableType.Number ? (int) XCollectionsKt.optDouble(xReadableMap, str, i) : i;
    }

    public static /* synthetic */ Long getLongValue$default(XBaseParamModel xBaseParamModel, XReadableMap xReadableMap, String str, long j, int i, Object obj) {
        if ((i & 4) != 0) {
            j = 0;
        }
        return getLongValue(xBaseParamModel, xReadableMap, str, j);
    }

    public static final Long getLongValue(XBaseParamModel xBaseParamModel, XReadableMap xReadableMap, String str, long j) {
        Intrinsics.checkNotNullParameter(xBaseParamModel, "<this>");
        Intrinsics.checkNotNullParameter(xReadableMap, "params");
        Intrinsics.checkNotNullParameter(str, "name");
        int i = WhenMappings.$EnumSwitchMapping$0[xReadableMap.get(str).getType().ordinal()];
        if (i == 1) {
            return Long.valueOf(xReadableMap.getInt(str));
        }
        if (i != 2) {
            return null;
        }
        return Long.valueOf((long) xReadableMap.getDouble(str));
    }

    public static final Boolean getBooleanValue(XBaseParamModel xBaseParamModel, XReadableMap xReadableMap, String str) {
        Intrinsics.checkNotNullParameter(xBaseParamModel, "<this>");
        Intrinsics.checkNotNullParameter(xReadableMap, "params");
        Intrinsics.checkNotNullParameter(str, "name");
        if (xReadableMap.get(str).getType() == XReadableType.Boolean) {
            return Boolean.valueOf(xReadableMap.getBoolean(str));
        }
        return null;
    }
}
