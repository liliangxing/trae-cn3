package com.bytedance.sdk.account.twiceverify.jsb;

import com.bytedance.sdk.account.twiceverify.TwiceVerifyManager;
import com.bytedance.sdk.account.twiceverify.jsb.idl.AbsAccountSetVerifyStatusMethodIDL;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeResultModelArguments;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AccountSetVerifyStatusMethod.kt */
@XBridgeMethod(name = "account.setVerifyStatus")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/sdk/account/twiceverify/jsb/AccountSetVerifyStatusMethod;", "Lcom/bytedance/sdk/account/twiceverify/jsb/idl/AbsAccountSetVerifyStatusMethodIDL;", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "params", "Lcom/bytedance/sdk/account/twiceverify/jsb/idl/AbsAccountSetVerifyStatusMethodIDL$AccountSetVerifyStatusParamModel;", "callback", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock;", "Lcom/bytedance/sdk/account/twiceverify/jsb/idl/AbsAccountSetVerifyStatusMethodIDL$AccountSetVerifyStatusResultModel;", "uc_twice_verify_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class AccountSetVerifyStatusMethod extends AbsAccountSetVerifyStatusMethodIDL {
    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public void handle(IBDXBridgeContext bridgeContext, AbsAccountSetVerifyStatusMethodIDL.AccountSetVerifyStatusParamModel params, CompletionBlock<AbsAccountSetVerifyStatusMethodIDL.AccountSetVerifyStatusResultModel> callback) {
        Intrinsics.checkParameterIsNotNull(bridgeContext, "bridgeContext");
        Intrinsics.checkParameterIsNotNull(params, "params");
        Intrinsics.checkParameterIsNotNull(callback, "callback");
        Number status = params.getStatus();
        if (Intrinsics.areEqual(status, 0)) {
            CompletionBlock.DefaultImpls.onSuccess$default(callback, (XBaseResultModel) XBridgeResultModelArguments.INSTANCE.createModel(AbsAccountSetVerifyStatusMethodIDL.AccountSetVerifyStatusResultModel.class), null, 2, null);
            TwiceVerifyManager.getInstance().onTwiceVerifySuccess(params.getVerifyWay(), params.getVerifyTicket(), params.getVerifyExtraParams(), params.getExtraBizParams());
        } else if (Intrinsics.areEqual(status, 1)) {
            CompletionBlock.DefaultImpls.onSuccess$default(callback, (XBaseResultModel) XBridgeResultModelArguments.INSTANCE.createModel(AbsAccountSetVerifyStatusMethodIDL.AccountSetVerifyStatusResultModel.class), null, 2, null);
            TwiceVerifyManager.getInstance().onTwiceVerifyError();
        } else {
            CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "status error", null, 4, null);
            TwiceVerifyManager.getInstance().onTwiceVerifyError();
        }
    }
}
