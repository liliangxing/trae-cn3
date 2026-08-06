package com.bytedance.ies.xbridge.model.params;

import com.bytedance.ies.xbridge.XCollectionsKt;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.XReadableType;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: XBaseParamModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\b&\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ies/xbridge/model/params/XBaseParamModel;", "", "()V", "provideParamList", "", "", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public abstract class XBaseParamModel {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    public List<String> provideParamList() {
        return CollectionsKt.emptyList();
    }

    /* compiled from: XBaseParamModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001d\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u001e\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bJ'\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\u000e¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ies/xbridge/model/params/XBaseParamModel$Companion;", "", "()V", "getBooleanValue", "", "params", "Lcom/bytedance/ies/xbridge/XReadableMap;", "name", "", "(Lcom/bytedance/ies/xbridge/XReadableMap;Ljava/lang/String;)Ljava/lang/Boolean;", "getIntValue", "", "defaultValue", "getLongValue", "", "(Lcom/bytedance/ies/xbridge/XReadableMap;Ljava/lang/String;J)Ljava/lang/Long;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {

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

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final int getIntValue(XReadableMap params, String name, int defaultValue) {
            Intrinsics.checkNotNullParameter(params, "params");
            Intrinsics.checkNotNullParameter(name, "name");
            if (!params.hasKey(name)) {
                return defaultValue;
            }
            if (params.get(name).getType() == XReadableType.Int) {
                return XCollectionsKt.optInt(params, name, defaultValue);
            }
            return params.get(name).getType() == XReadableType.Number ? (int) XCollectionsKt.optDouble(params, name, defaultValue) : defaultValue;
        }

        public static /* synthetic */ Long getLongValue$default(Companion companion, XReadableMap xReadableMap, String str, long j, int i, Object obj) {
            if ((i & 4) != 0) {
                j = 0;
            }
            return companion.getLongValue(xReadableMap, str, j);
        }

        public final Long getLongValue(XReadableMap params, String name, long defaultValue) {
            Intrinsics.checkNotNullParameter(params, "params");
            Intrinsics.checkNotNullParameter(name, "name");
            int i = WhenMappings.$EnumSwitchMapping$0[params.get(name).getType().ordinal()];
            if (i == 1) {
                return Long.valueOf(params.getInt(name));
            }
            if (i != 2) {
                return null;
            }
            return Long.valueOf((long) params.getDouble(name));
        }

        public final Boolean getBooleanValue(XReadableMap params, String name) {
            Intrinsics.checkNotNullParameter(params, "params");
            Intrinsics.checkNotNullParameter(name, "name");
            if (params.get(name).getType() == XReadableType.Boolean) {
                return Boolean.valueOf(params.getBoolean(name));
            }
            return null;
        }
    }
}
