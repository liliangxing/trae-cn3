package com.bytedance.ies.xbridge.model.idl;

import com.bytedance.ies.xbridge.utils.IDLJSONUtils;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: IDLXDynamic.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\f\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002\u001a\f\u0010\u0003\u001a\u0004\u0018\u00010\u0001*\u00020\u0002¨\u0006\u0004"}, d2 = {"getValue", "", "Lcom/bytedance/ies/xbridge/model/idl/IDLXDynamic;", "toPrimitiveOrJSON", "anniex_release"}, k = 2, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class IDLXDynamicKt {

    /* compiled from: IDLXDynamic.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[XDynamicType.values().length];
            try {
                iArr[XDynamicType.String.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[XDynamicType.Number.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[XDynamicType.Boolean.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[XDynamicType.Long.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[XDynamicType.Int.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[XDynamicType.Map.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[XDynamicType.Array.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[XDynamicType.ByteArray.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[XDynamicType.Null.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final Object getValue(IDLXDynamic iDLXDynamic) {
        Intrinsics.checkNotNullParameter(iDLXDynamic, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$0[iDLXDynamic.getType().ordinal()]) {
            case 1:
                return iDLXDynamic.asString();
            case 2:
                return Double.valueOf(iDLXDynamic.asDouble());
            case 3:
                return Boolean.valueOf(iDLXDynamic.asBoolean());
            case 4:
                return Long.valueOf(iDLXDynamic.asLong());
            case 5:
                return Integer.valueOf(iDLXDynamic.asInt());
            case 6:
                return iDLXDynamic.asMap();
            case 7:
                return iDLXDynamic.asArray();
            case 8:
                return iDLXDynamic.asByteArray();
            case 9:
                return null;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final Object toPrimitiveOrJSON(IDLXDynamic iDLXDynamic) {
        Intrinsics.checkNotNullParameter(iDLXDynamic, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$0[iDLXDynamic.getType().ordinal()]) {
            case 1:
                return iDLXDynamic.asString();
            case 2:
                return Double.valueOf(iDLXDynamic.asDouble());
            case 3:
                return Boolean.valueOf(iDLXDynamic.asBoolean());
            case 4:
                return Long.valueOf(iDLXDynamic.asLong());
            case 5:
                return Integer.valueOf(iDLXDynamic.asInt());
            case 6:
                return IDLJSONUtils.toJSONObject(iDLXDynamic.asMap());
            case 7:
                return IDLJSONUtils.toJSONArray(iDLXDynamic.asArray());
            case 8:
                return iDLXDynamic.asByteArray();
            case 9:
                return JSONObject.NULL;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
