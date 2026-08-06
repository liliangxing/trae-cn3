package com.bytedance.ies.xbridge.event.idl;

import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.ies.xbridge.IDLXBridgeMethod;
import com.bytedance.ies.xbridge.annotation.XBridgeMethodName;
import com.bytedance.ies.xbridge.annotation.XBridgeModelExtension;
import com.bytedance.ies.xbridge.annotation.XBridgeParamField;
import com.bytedance.ies.xbridge.annotation.XBridgeParamModel;
import com.bytedance.ies.xbridge.annotation.XBridgePermission;
import com.bytedance.ies.xbridge.annotation.XBridgeResultModel;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreIDLBridgeMethod;
import com.bytedance.ies.xbridge.model.idl.XBaseParamModel;
import com.bytedance.ies.xbridge.model.idl.XBaseResultModel;
import com.bytedance.perf.monitor.ReportConst;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: AbsXSubscribeEventMethodIDL.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b&\u0018\u0000 \r2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\r\u000e\u000fB\u0005¢\u0006\u0002\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00068\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\u00020\n8\u0016X\u0097D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ies/xbridge/event/idl/AbsXSubscribeEventMethodIDL;", "Lcom/bytedance/ies/xbridge/bridgeInterfaces/XCoreIDLBridgeMethod;", "Lcom/bytedance/ies/xbridge/event/idl/AbsXSubscribeEventMethodIDL$XSubscribeEventParamModel;", "Lcom/bytedance/ies/xbridge/event/idl/AbsXSubscribeEventMethodIDL$XSubscribeEventResultModel;", "()V", "access", "Lcom/bytedance/ies/xbridge/IDLXBridgeMethod$Access;", "getAccess", "()Lcom/bytedance/ies/xbridge/IDLXBridgeMethod$Access;", "name", "", "getName", "()Ljava/lang/String;", "Companion", "XSubscribeEventParamModel", "XSubscribeEventResultModel", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public abstract class AbsXSubscribeEventMethodIDL extends XCoreIDLBridgeMethod<XSubscribeEventParamModel, XSubscribeEventResultModel> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @XBridgeModelExtension
    private static final Map<String, Object> extensionMetaInfo = MapsKt.mapOf(new Pair[]{TuplesKt.to("IDLVersion", "1002"), TuplesKt.to("UID", "610bec30c2d6f700463349f5"), TuplesKt.to("TicketID", "15666")});

    @XBridgeMethodName(name = "x.subscribeEvent", params = {SchemaConstants.INNER_PARAM_EVENT_NAME, ReportConst.KEY_TIMESTAMP})
    private final String name = "x.subscribeEvent";

    @XBridgePermission(permission = IDLXBridgeMethod.Access.PUBLIC)
    private final IDLXBridgeMethod.Access access = IDLXBridgeMethod.Access.PUBLIC;

    /* compiled from: AbsXSubscribeEventMethodIDL.kt */
    @XBridgeParamModel
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0004\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00078gX¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ies/xbridge/event/idl/AbsXSubscribeEventMethodIDL$XSubscribeEventParamModel;", "Lcom/bytedance/ies/xbridge/model/idl/XBaseParamModel;", SchemaConstants.INNER_PARAM_EVENT_NAME, "", "getEventName", "()Ljava/lang/String;", ReportConst.KEY_TIMESTAMP, "", "getTimestamp", "()Ljava/lang/Number;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public interface XSubscribeEventParamModel extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = SchemaConstants.INNER_PARAM_EVENT_NAME, required = true)
        String getEventName();

        @XBridgeParamField(isGetter = true, keyPath = ReportConst.KEY_TIMESTAMP, required = true)
        Number getTimestamp();
    }

    /* compiled from: AbsXSubscribeEventMethodIDL.kt */
    @XBridgeResultModel
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ies/xbridge/event/idl/AbsXSubscribeEventMethodIDL$XSubscribeEventResultModel;", "Lcom/bytedance/ies/xbridge/model/idl/XBaseResultModel;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public interface XSubscribeEventResultModel extends XBaseResultModel {
    }

    /* compiled from: AbsXSubscribeEventMethodIDL.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ies/xbridge/event/idl/AbsXSubscribeEventMethodIDL$Companion;", "", "()V", "extensionMetaInfo", "", "", "getExtensionMetaInfo", "()Ljava/util/Map;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Map<String, Object> getExtensionMetaInfo() {
            return AbsXSubscribeEventMethodIDL.extensionMetaInfo;
        }
    }

    @Override // com.bytedance.ies.xbridge.IDLXBridgeMethod
    public String getName() {
        return this.name;
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.ies.xbridge.IDLXBridgeMethod
    public IDLXBridgeMethod.Access getAccess() {
        return this.access;
    }
}
