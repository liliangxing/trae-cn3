package com.bytedance.sdk.xbridge.cn.websocket.idl;

import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeIntEnum;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeMethodName;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeModelExtension;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamField;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgePermission;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeStringEnum;
import com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: AbsXSendSocketDataMethodIDL.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b&\u0018\u0000 \r2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\r\u000e\u000fB\u0005¢\u0006\u0002\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00068\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\u00020\n8\u0016X\u0097D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/websocket/idl/AbsXSendSocketDataMethodIDL;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/bridgeInterfaces/XCoreIDLBridgeMethod;", "Lcom/bytedance/sdk/xbridge/cn/websocket/idl/AbsXSendSocketDataMethodIDL$XSendSocketDataParamModel;", "Lcom/bytedance/sdk/xbridge/cn/websocket/idl/AbsXSendSocketDataMethodIDL$XSendSocketDataResultModel;", "()V", "access", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod$Access;", "getAccess", "()Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod$Access;", "name", "", "getName", "()Ljava/lang/String;", "Companion", "XSendSocketDataParamModel", "XSendSocketDataResultModel", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public abstract class AbsXSendSocketDataMethodIDL extends XCoreIDLBridgeMethod<XSendSocketDataParamModel, XSendSocketDataResultModel> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @XBridgeModelExtension
    private static final Map<String, Object> extensionMetaInfo = MapsKt.mapOf(new Pair[]{TuplesKt.to("IDLVersion", "1003"), TuplesKt.to("UID", "610b54bdc2d6f700463349c8"), TuplesKt.to("TicketID", "15700")});

    @XBridgeMethodName(name = "x.sendSocketData", params = {"socketTaskID", "data", "dataType"}, results = {"code"})
    private final String name = "x.sendSocketData";

    @XBridgePermission(permission = IDLXBridgeMethod.Access.PROTECT)
    private final IDLXBridgeMethod.Access access = IDLXBridgeMethod.Access.PROTECT;

    /* compiled from: AbsXSendSocketDataMethodIDL.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/websocket/idl/AbsXSendSocketDataMethodIDL$Companion;", "", "()V", "extensionMetaInfo", "", "", "getExtensionMetaInfo", "()Ljava/util/Map;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Map<String, Object> getExtensionMetaInfo() {
            return AbsXSendSocketDataMethodIDL.extensionMetaInfo;
        }
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public String getName() {
        return this.name;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public IDLXBridgeMethod.Access getAccess() {
        return this.access;
    }

    /* compiled from: AbsXSendSocketDataMethodIDL.kt */
    @XBridgeParamModel
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\bg\u0018\u0000 \f2\u00020\u0001:\u0001\fR\u0014\u0010\u0002\u001a\u00020\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00078gX¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\t¨\u0006\r"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/websocket/idl/AbsXSendSocketDataMethodIDL$XSendSocketDataParamModel;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseParamModel;", "data", "", "getData", "()Ljava/lang/Object;", "dataType", "", "getDataType", "()Ljava/lang/String;", "socketTaskID", "getSocketTaskID", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface XSendSocketDataParamModel extends XBaseParamModel {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = Companion.$$INSTANCE;
        public static final String XSendSocketDataDataTypeArraybuffer = "arraybuffer";
        public static final String XSendSocketDataDataTypeBase64 = "base64";
        public static final String XSendSocketDataDataTypeString = "string";

        @XBridgeParamField(isGetter = true, keyPath = "data", required = true)
        Object getData();

        @XBridgeStringEnum(option = {"arraybuffer", "base64", "string"})
        @XBridgeParamField(isEnum = true, isGetter = true, keyPath = "dataType", required = true)
        String getDataType();

        @XBridgeParamField(isGetter = true, keyPath = "socketTaskID", required = true)
        String getSocketTaskID();

        /* compiled from: AbsXSendSocketDataMethodIDL.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/websocket/idl/AbsXSendSocketDataMethodIDL$XSendSocketDataParamModel$Companion;", "", "()V", "XSendSocketDataDataTypeArraybuffer", "", "XSendSocketDataDataTypeBase64", "XSendSocketDataDataTypeString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final String XSendSocketDataDataTypeArraybuffer = "arraybuffer";
            public static final String XSendSocketDataDataTypeBase64 = "base64";
            public static final String XSendSocketDataDataTypeString = "string";

            private Companion() {
            }
        }
    }

    /* compiled from: AbsXSendSocketDataMethodIDL.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0007\bg\u0018\u0000 \t2\u00020\u0001:\u0001\tR(\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u00038g@gX¦\u000e¢\u0006\f\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/websocket/idl/AbsXSendSocketDataMethodIDL$XSendSocketDataResultModel;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseResultModel;", "<set-?>", "", "code", "getCode", "()Ljava/lang/Number;", "setCode", "(Ljava/lang/Number;)V", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    @XBridgeResultModel
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface XSendSocketDataResultModel extends XBaseResultModel {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = Companion.$$INSTANCE;
        public static final int Failed = 0;
        public static final int Success = 1;

        @XBridgeParamField(isEnum = true, isGetter = true, keyPath = "code", required = true)
        @XBridgeIntEnum(option = {0, 1})
        Number getCode();

        @XBridgeParamField(isEnum = true, isGetter = false, keyPath = "code", required = true)
        @XBridgeIntEnum(option = {0, 1})
        void setCode(Number number);

        /* compiled from: AbsXSendSocketDataMethodIDL.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/websocket/idl/AbsXSendSocketDataMethodIDL$XSendSocketDataResultModel$Companion;", "", "()V", "Failed", "", "Success", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final int Failed = 0;
            public static final int Success = 1;

            private Companion() {
            }
        }
    }
}
