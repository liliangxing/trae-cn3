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
import java.util.Map;
import kotlin.Metadata;

/* compiled from: AbsAccountVerifyMethodIDL.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\r\u000eB\u0005¢\u0006\u0002\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00068\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\u00020\n8\u0016X\u0097D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/bytedance/sdk/account/twiceverify/jsb/idl/AbsAccountVerifyMethodIDL;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/bridgeInterfaces/XCoreIDLBridgeMethod;", "Lcom/bytedance/sdk/account/twiceverify/jsb/idl/AbsAccountVerifyMethodIDL$AccountVerifyParamModel;", "Lcom/bytedance/sdk/account/twiceverify/jsb/idl/AbsAccountVerifyMethodIDL$AccountVerifyResultModel;", "()V", "access", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod$Access;", "getAccess", "()Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod$Access;", "name", "", "getName", "()Ljava/lang/String;", "AccountVerifyParamModel", "AccountVerifyResultModel", "uc_twice_verify_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public abstract class AbsAccountVerifyMethodIDL extends XCoreIDLBridgeMethod<AccountVerifyParamModel, AccountVerifyResultModel> {

    @XBridgeMethodName(name = "account.verify", params = {"verifyDecision"}, results = {"verifyWay", "verifyTicket", "verifyExtraParams", "bizParams"})
    private final String name = "account.verify";

    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    private final IDLXBridgeMethod.Access access = IDLXBridgeMethod.Access.PRIVATE;

    /* compiled from: AbsAccountVerifyMethodIDL.kt */
    @XBridgeParamModel
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001R \u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/sdk/account/twiceverify/jsb/idl/AbsAccountVerifyMethodIDL$AccountVerifyParamModel;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseParamModel;", "verifyDecision", "", "", "", "getVerifyDecision", "()Ljava/util/Map;", "uc_twice_verify_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface AccountVerifyParamModel extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "verifyDecision", required = true)
        Map<String, Object> getVerifyDecision();
    }

    /* compiled from: AbsAccountVerifyMethodIDL.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0011\bg\u0018\u00002\u00020\u0001R@\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00032\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00038g@gX¦\u000e¢\u0006\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR@\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00032\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00038g@gX¦\u000e¢\u0006\f\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR(\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\u0010\u0002\u001a\u0004\u0018\u00010\u00048g@gX¦\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R(\u0010\u0013\u001a\u0004\u0018\u00010\u00042\b\u0010\u0002\u001a\u0004\u0018\u00010\u00048g@gX¦\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/bytedance/sdk/account/twiceverify/jsb/idl/AbsAccountVerifyMethodIDL$AccountVerifyResultModel;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseResultModel;", "<set-?>", "", "", "", "bizParams", "getBizParams", "()Ljava/util/Map;", "setBizParams", "(Ljava/util/Map;)V", "verifyExtraParams", "getVerifyExtraParams", "setVerifyExtraParams", "verifyTicket", "getVerifyTicket", "()Ljava/lang/String;", "setVerifyTicket", "(Ljava/lang/String;)V", "verifyWay", "getVerifyWay", "setVerifyWay", "uc_twice_verify_release"}, k = 1, mv = {1, 1, 15})
    @XBridgeResultModel
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface AccountVerifyResultModel extends XBaseResultModel {
        @XBridgeParamField(isGetter = true, keyPath = "bizParams", required = false)
        Map<String, Object> getBizParams();

        @XBridgeParamField(isGetter = true, keyPath = "verifyExtraParams", required = false)
        Map<String, Object> getVerifyExtraParams();

        @XBridgeParamField(isGetter = true, keyPath = "verifyTicket", required = false)
        String getVerifyTicket();

        @XBridgeParamField(isGetter = true, keyPath = "verifyWay", required = false)
        String getVerifyWay();

        @XBridgeParamField(isGetter = false, keyPath = "bizParams", required = false)
        void setBizParams(Map<String, ? extends Object> map);

        @XBridgeParamField(isGetter = false, keyPath = "verifyExtraParams", required = false)
        void setVerifyExtraParams(Map<String, ? extends Object> map);

        @XBridgeParamField(isGetter = false, keyPath = "verifyTicket", required = false)
        void setVerifyTicket(String str);

        @XBridgeParamField(isGetter = false, keyPath = "verifyWay", required = false)
        void setVerifyWay(String str);
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
