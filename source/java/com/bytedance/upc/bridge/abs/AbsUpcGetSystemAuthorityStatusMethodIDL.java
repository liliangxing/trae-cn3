package com.bytedance.upc.bridge.abs;

import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeMethodName;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeModelExtension;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamField;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgePermission;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: AbsUpcGetSystemAuthorityStatusMethodIDL.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\b&\u0018\u0000 \r2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0005\r\u000e\u000f\u0010\u0011B\u0005¢\u0006\u0002\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00068\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\u00020\n8\u0016X\u0097D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/upc/bridge/abs/AbsUpcGetSystemAuthorityStatusMethodIDL;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/bridgeInterfaces/XCoreIDLBridgeMethod;", "Lcom/bytedance/upc/bridge/abs/AbsUpcGetSystemAuthorityStatusMethodIDL$UpcGetSystemAuthorityStatusParamModel;", "Lcom/bytedance/upc/bridge/abs/AbsUpcGetSystemAuthorityStatusMethodIDL$UpcGetSystemAuthorityStatusResultModel;", "()V", "access", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod$Access;", "getAccess", "()Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod$Access;", StrategyConstants.NAME, "", "getName", "()Ljava/lang/String;", "Companion", "UpcGetSystemAuthorityStatusParamModel", "UpcGetSystemAuthorityStatusResultModel", "XBridgeBeanUpcGetSystemAuthorityStatusAuthorityList", "XBridgeBeanUpcGetSystemAuthorityStatusAuthorityResultList", "com.bytedance.upc"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public abstract class AbsUpcGetSystemAuthorityStatusMethodIDL extends XCoreIDLBridgeMethod<UpcGetSystemAuthorityStatusParamModel, UpcGetSystemAuthorityStatusResultModel> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @XBridgeModelExtension
    private static final Map<String, Object> extensionMetaInfo = MapsKt.mapOf(TuplesKt.to("TicketID", "21578"));

    @XBridgeMethodName(name = "upc.getSystemAuthorityStatus", params = {"authorityList"}, results = {"authorityResultList"})
    private final String name = "upc.getSystemAuthorityStatus";

    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    private final IDLXBridgeMethod.Access access = IDLXBridgeMethod.Access.PRIVATE;

    /* compiled from: AbsUpcGetSystemAuthorityStatusMethodIDL.kt */
    @XBridgeParamModel
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001R\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/upc/bridge/abs/AbsUpcGetSystemAuthorityStatusMethodIDL$UpcGetSystemAuthorityStatusParamModel;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseParamModel;", "authorityList", "", "Lcom/bytedance/upc/bridge/abs/AbsUpcGetSystemAuthorityStatusMethodIDL$XBridgeBeanUpcGetSystemAuthorityStatusAuthorityList;", "getAuthorityList", "()Ljava/util/List;", "com.bytedance.upc"}, k = 1, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public interface UpcGetSystemAuthorityStatusParamModel extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "authorityList", nestedClassType = XBridgeBeanUpcGetSystemAuthorityStatusAuthorityList.class, required = true)
        List<XBridgeBeanUpcGetSystemAuthorityStatusAuthorityList> getAuthorityList();
    }

    /* compiled from: AbsUpcGetSystemAuthorityStatusMethodIDL.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001R4\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038g@gX¦\u000e¢\u0006\f\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/upc/bridge/abs/AbsUpcGetSystemAuthorityStatusMethodIDL$UpcGetSystemAuthorityStatusResultModel;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseResultModel;", "<set-?>", "", "Lcom/bytedance/upc/bridge/abs/AbsUpcGetSystemAuthorityStatusMethodIDL$XBridgeBeanUpcGetSystemAuthorityStatusAuthorityResultList;", "authorityResultList", "getAuthorityResultList", "()Ljava/util/List;", "setAuthorityResultList", "(Ljava/util/List;)V", "com.bytedance.upc"}, k = 1, mv = {1, 1, 16})
    @XBridgeResultModel
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public interface UpcGetSystemAuthorityStatusResultModel extends XBaseResultModel {
        @XBridgeParamField(isGetter = true, keyPath = "authorityResultList", nestedClassType = XBridgeBeanUpcGetSystemAuthorityStatusAuthorityResultList.class, required = true)
        List<XBridgeBeanUpcGetSystemAuthorityStatusAuthorityResultList> getAuthorityResultList();

        @XBridgeParamField(isGetter = false, keyPath = "authorityResultList", nestedClassType = XBridgeBeanUpcGetSystemAuthorityStatusAuthorityResultList.class, required = true)
        void setAuthorityResultList(List<? extends XBridgeBeanUpcGetSystemAuthorityStatusAuthorityResultList> list);
    }

    /* compiled from: AbsUpcGetSystemAuthorityStatusMethodIDL.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/upc/bridge/abs/AbsUpcGetSystemAuthorityStatusMethodIDL$XBridgeBeanUpcGetSystemAuthorityStatusAuthorityList;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseModel;", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "", "getType", "()Ljava/lang/String;", "com.bytedance.upc"}, k = 1, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public interface XBridgeBeanUpcGetSystemAuthorityStatusAuthorityList extends XBaseModel {
        @XBridgeParamField(isGetter = true, keyPath = ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, required = true)
        String getType();
    }

    /* compiled from: AbsUpcGetSystemAuthorityStatusMethodIDL.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0004\n\u0002\b\t\bf\u0018\u00002\u00020\u0001R(\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u00038g@gX¦\u000e¢\u0006\f\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR(\u0010\t\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u00038g@gX¦\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR(\u0010\f\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u00038g@gX¦\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR(\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0002\u001a\u0004\u0018\u00010\u000f8g@gX¦\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R(\u0010\u0015\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u00038g@gX¦\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\b¨\u0006\u0018"}, d2 = {"Lcom/bytedance/upc/bridge/abs/AbsUpcGetSystemAuthorityStatusMethodIDL$XBridgeBeanUpcGetSystemAuthorityStatusAuthorityResultList;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseModel;", "<set-?>", "", "authorityType", "getAuthorityType", "()Ljava/lang/String;", "setAuthorityType", "(Ljava/lang/String;)V", "privacyType", "getPrivacyType", "setPrivacyType", StrategyConstants.SCHEMA, "getSchema", "setSchema", "", "status", "getStatus", "()Ljava/lang/Number;", "setStatus", "(Ljava/lang/Number;)V", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "getType", "setType", "com.bytedance.upc"}, k = 1, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public interface XBridgeBeanUpcGetSystemAuthorityStatusAuthorityResultList extends XBaseModel {
        @XBridgeParamField(isGetter = true, keyPath = "authorityType", required = false)
        String getAuthorityType();

        @XBridgeParamField(isGetter = true, keyPath = "privacyType", required = false)
        String getPrivacyType();

        @XBridgeParamField(isGetter = true, keyPath = StrategyConstants.SCHEMA, required = true)
        String getSchema();

        @XBridgeParamField(isGetter = true, keyPath = "status", required = true)
        Number getStatus();

        @XBridgeParamField(isGetter = true, keyPath = ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, required = true)
        String getType();

        @XBridgeParamField(isGetter = false, keyPath = "authorityType", required = false)
        void setAuthorityType(String str);

        @XBridgeParamField(isGetter = false, keyPath = "privacyType", required = false)
        void setPrivacyType(String str);

        @XBridgeParamField(isGetter = false, keyPath = StrategyConstants.SCHEMA, required = true)
        void setSchema(String str);

        @XBridgeParamField(isGetter = false, keyPath = "status", required = true)
        void setStatus(Number number);

        @XBridgeParamField(isGetter = false, keyPath = ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, required = true)
        void setType(String str);
    }

    /* compiled from: AbsUpcGetSystemAuthorityStatusMethodIDL.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/upc/bridge/abs/AbsUpcGetSystemAuthorityStatusMethodIDL$Companion;", "", "()V", "extensionMetaInfo", "", "", "getExtensionMetaInfo", "()Ljava/util/Map;", "com.bytedance.upc"}, k = 1, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Map<String, Object> getExtensionMetaInfo() {
            return AbsUpcGetSystemAuthorityStatusMethodIDL.extensionMetaInfo;
        }
    }

    public String getName() {
        return this.name;
    }

    public IDLXBridgeMethod.Access getAccess() {
        return this.access;
    }
}
