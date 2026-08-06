package com.bytedance.ies.xbridge.event.model;

import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.ies.xbridge.XCollectionsKt;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.model.params.XBaseParamModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: XUnsubscribeEventMethodParamModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\nH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/bytedance/ies/xbridge/event/model/XUnsubscribeEventMethodParamModel;", "Lcom/bytedance/ies/xbridge/model/params/XBaseParamModel;", "()V", SchemaConstants.INNER_PARAM_EVENT_NAME, "", "getEventName", "()Ljava/lang/String;", "setEventName", "(Ljava/lang/String;)V", "provideParamList", "", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class XUnsubscribeEventMethodParamModel extends XBaseParamModel {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public String eventName;

    @JvmStatic
    public static final XUnsubscribeEventMethodParamModel convert(XReadableMap xReadableMap) {
        return INSTANCE.convert(xReadableMap);
    }

    public final String getEventName() {
        String str = this.eventName;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException(SchemaConstants.INNER_PARAM_EVENT_NAME);
        return null;
    }

    public final void setEventName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.eventName = str;
    }

    @Override // com.bytedance.ies.xbridge.model.params.XBaseParamModel
    public List<String> provideParamList() {
        return CollectionsKt.listOf(SchemaConstants.INNER_PARAM_EVENT_NAME);
    }

    /* compiled from: XUnsubscribeEventMethodParamModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ies/xbridge/event/model/XUnsubscribeEventMethodParamModel$Companion;", "", "()V", "convert", "Lcom/bytedance/ies/xbridge/event/model/XUnsubscribeEventMethodParamModel;", "params", "Lcom/bytedance/ies/xbridge/XReadableMap;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final XUnsubscribeEventMethodParamModel convert(XReadableMap params) {
            Intrinsics.checkNotNullParameter(params, "params");
            String optString$default = XCollectionsKt.optString$default(params, SchemaConstants.INNER_PARAM_EVENT_NAME, null, 2, null);
            if (optString$default.length() == 0) {
                return null;
            }
            XUnsubscribeEventMethodParamModel xUnsubscribeEventMethodParamModel = new XUnsubscribeEventMethodParamModel();
            xUnsubscribeEventMethodParamModel.setEventName(optString$default);
            return xUnsubscribeEventMethodParamModel;
        }
    }
}
