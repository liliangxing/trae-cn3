package com.bytedance.ies.xbridge.model.params;

import com.bytedance.ies.xbridge.XReadableMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: XDefaultParamModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/bytedance/ies/xbridge/model/params/XDefaultParamModel;", "Lcom/bytedance/ies/xbridge/model/params/XBaseParamModel;", "()V", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class XDefaultParamModel extends XBaseParamModel {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @JvmStatic
    public static final XDefaultParamModel convert(XReadableMap xReadableMap) {
        return INSTANCE.convert(xReadableMap);
    }

    /* compiled from: XDefaultParamModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ies/xbridge/model/params/XDefaultParamModel$Companion;", "", "()V", "convert", "Lcom/bytedance/ies/xbridge/model/params/XDefaultParamModel;", "params", "Lcom/bytedance/ies/xbridge/XReadableMap;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final XDefaultParamModel convert(XReadableMap params) {
            Intrinsics.checkNotNullParameter(params, "params");
            return new XDefaultParamModel();
        }
    }
}
