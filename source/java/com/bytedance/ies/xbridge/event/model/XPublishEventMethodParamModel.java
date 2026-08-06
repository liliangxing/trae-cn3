package com.bytedance.ies.xbridge.event.model;

import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.ies.xbridge.XCollectionsKt;
import com.bytedance.ies.xbridge.XDynamic;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.XReadableType;
import com.bytedance.ies.xbridge.model.params.XBaseParamModel;
import com.bytedance.perf.monitor.ReportConst;
import com.bytedance.ug.sdk.deeplink.EventConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: XPublishEventMethodParamModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u0016H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ies/xbridge/event/model/XPublishEventMethodParamModel;", "Lcom/bytedance/ies/xbridge/model/params/XBaseParamModel;", "()V", SchemaConstants.INNER_PARAM_EVENT_NAME, "", "getEventName", "()Ljava/lang/String;", "setEventName", "(Ljava/lang/String;)V", "params", "Lcom/bytedance/ies/xbridge/XReadableMap;", "getParams", "()Lcom/bytedance/ies/xbridge/XReadableMap;", "setParams", "(Lcom/bytedance/ies/xbridge/XReadableMap;)V", ReportConst.KEY_TIMESTAMP, "", "getTimestamp", "()J", "setTimestamp", "(J)V", "provideParamList", "", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class XPublishEventMethodParamModel extends XBaseParamModel {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public String eventName;
    private XReadableMap params;
    private long timestamp;

    @JvmStatic
    public static final XPublishEventMethodParamModel convert(XReadableMap xReadableMap) {
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

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final void setTimestamp(long j) {
        this.timestamp = j;
    }

    public final XReadableMap getParams() {
        return this.params;
    }

    public final void setParams(XReadableMap xReadableMap) {
        this.params = xReadableMap;
    }

    @Override // com.bytedance.ies.xbridge.model.params.XBaseParamModel
    public List<String> provideParamList() {
        return CollectionsKt.listOf(new String[]{SchemaConstants.INNER_PARAM_EVENT_NAME, ReportConst.KEY_TIMESTAMP, "params"});
    }

    /* compiled from: XPublishEventMethodParamModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ies/xbridge/event/model/XPublishEventMethodParamModel$Companion;", "", "()V", "convert", "Lcom/bytedance/ies/xbridge/event/model/XPublishEventMethodParamModel;", EventConstants.PARAM_SOURCE, "Lcom/bytedance/ies/xbridge/XReadableMap;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {

        /* compiled from: XPublishEventMethodParamModel.kt */
        @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[XReadableType.values().length];
                try {
                    iArr[XReadableType.Number.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[XReadableType.Int.ordinal()] = 2;
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

        @JvmStatic
        public final XPublishEventMethodParamModel convert(XReadableMap source) {
            double asDouble;
            Intrinsics.checkNotNullParameter(source, EventConstants.PARAM_SOURCE);
            String optString$default = XCollectionsKt.optString$default(source, SchemaConstants.INNER_PARAM_EVENT_NAME, null, 2, null);
            if ((optString$default.length() == 0) || !source.hasKey(ReportConst.KEY_TIMESTAMP)) {
                return null;
            }
            XDynamic xDynamic = source.get(ReportConst.KEY_TIMESTAMP);
            int i = WhenMappings.$EnumSwitchMapping$0[xDynamic.getType().ordinal()];
            if (i == 1) {
                asDouble = xDynamic.asDouble();
            } else {
                if (i != 2) {
                    return null;
                }
                asDouble = xDynamic.asDouble();
            }
            XReadableMap optMap$default = XCollectionsKt.optMap$default(source, "params", null, 2, null);
            XPublishEventMethodParamModel xPublishEventMethodParamModel = new XPublishEventMethodParamModel();
            xPublishEventMethodParamModel.setEventName(optString$default);
            xPublishEventMethodParamModel.setTimestamp((long) asDouble);
            xPublishEventMethodParamModel.setParams(optMap$default);
            return xPublishEventMethodParamModel;
        }
    }
}
