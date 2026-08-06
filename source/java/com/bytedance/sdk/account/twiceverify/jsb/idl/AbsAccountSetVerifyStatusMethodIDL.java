package com.bytedance.sdk.account.twiceverify.jsb.idl;

import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeMethodName;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamField;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgePermission;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.timonbase.scene.PageDataManager;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: AbsAccountSetVerifyStatusMethodIDL.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\r\u000eB\u0005¢\u0006\u0002\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00068\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\u00020\n8\u0016X\u0097D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/bytedance/sdk/account/twiceverify/jsb/idl/AbsAccountSetVerifyStatusMethodIDL;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/bridgeInterfaces/XCoreIDLBridgeMethod;", "Lcom/bytedance/sdk/account/twiceverify/jsb/idl/AbsAccountSetVerifyStatusMethodIDL$AccountSetVerifyStatusParamModel;", "Lcom/bytedance/sdk/account/twiceverify/jsb/idl/AbsAccountSetVerifyStatusMethodIDL$AccountSetVerifyStatusResultModel;", "()V", "access", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod$Access;", "getAccess", "()Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod$Access;", "name", "", "getName", "()Ljava/lang/String;", "AccountSetVerifyStatusParamModel", "AccountSetVerifyStatusResultModel", "uc_twice_verify_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public abstract class AbsAccountSetVerifyStatusMethodIDL extends XCoreIDLBridgeMethod<AccountSetVerifyStatusParamModel, AccountSetVerifyStatusResultModel> {

    @XBridgeMethodName(name = "account.setVerifyStatus", params = {PageDataManager.EXTRA_STATUS, "verifyWay", "verifyTicket", "verifyExtraParams", "extraBizParams"})
    private final String name = "account.setVerifyStatus";

    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    private final IDLXBridgeMethod.Access access = IDLXBridgeMethod.Access.PRIVATE;

    /* compiled from: AbsAccountSetVerifyStatusMethodIDL.kt */
    @XBridgeParamModel
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0004\n\u0002\b\n\bg\u0018\u00002\u00020\u0001R\"\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u0004\u0018\u00010\t8gX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\"\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0007R\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u00048gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u00048gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/bytedance/sdk/account/twiceverify/jsb/idl/AbsAccountSetVerifyStatusMethodIDL$AccountSetVerifyStatusParamModel;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseParamModel;", "extraBizParams", "", "", "", "getExtraBizParams", "()Ljava/util/Map;", PageDataManager.EXTRA_STATUS, "", "getStatus", "()Ljava/lang/Number;", "verifyExtraParams", "getVerifyExtraParams", "verifyTicket", "getVerifyTicket", "()Ljava/lang/String;", "verifyWay", "getVerifyWay", "uc_twice_verify_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface AccountSetVerifyStatusParamModel extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "extraBizParams", required = false)
        Map<String, Object> getExtraBizParams();

        @XBridgeParamField(isGetter = true, keyPath = PageDataManager.EXTRA_STATUS, required = false)
        Number getStatus();

        @XBridgeParamField(isGetter = true, keyPath = "verifyExtraParams", required = false)
        Map<String, Object> getVerifyExtraParams();

        @XBridgeParamField(isGetter = true, keyPath = "verifyTicket", required = false)
        String getVerifyTicket();

        @XBridgeParamField(isGetter = true, keyPath = "verifyWay", required = false)
        String getVerifyWay();
    }

    /* compiled from: AbsAccountSetVerifyStatusMethodIDL.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/sdk/account/twiceverify/jsb/idl/AbsAccountSetVerifyStatusMethodIDL$AccountSetVerifyStatusResultModel;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseResultModel;", "uc_twice_verify_release"}, k = 1, mv = {1, 1, 15})
    @XBridgeResultModel
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface AccountSetVerifyStatusResultModel extends XBaseResultModel {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public String getName() {
        return this.name;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public IDLXBridgeMethod.Access getAccess() {
        return this.access;
    }
}
