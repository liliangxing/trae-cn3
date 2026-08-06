package com.bytedance.sdk.account.twiceverify.jsb;

import com.bytedance.sdk.account.twiceverify.TwiceVerifyLogHelper;
import com.bytedance.sdk.account.twiceverify.TwiceVerifyManager;
import com.bytedance.sdk.account.twiceverify.TwiceVerifyResultCallback;
import com.bytedance.sdk.account.twiceverify.jsb.idl.AbsAccountVerifyMethodIDL;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeResultModelArguments;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: AccountVerifyMethod.kt */
@XBridgeMethod(name = "account.verify")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/sdk/account/twiceverify/jsb/AccountVerifyMethod;", "Lcom/bytedance/sdk/account/twiceverify/jsb/idl/AbsAccountVerifyMethodIDL;", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "params", "Lcom/bytedance/sdk/account/twiceverify/jsb/idl/AbsAccountVerifyMethodIDL$AccountVerifyParamModel;", "callback", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock;", "Lcom/bytedance/sdk/account/twiceverify/jsb/idl/AbsAccountVerifyMethodIDL$AccountVerifyResultModel;", "uc_twice_verify_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class AccountVerifyMethod extends AbsAccountVerifyMethodIDL {
    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public void handle(IBDXBridgeContext bridgeContext, AbsAccountVerifyMethodIDL.AccountVerifyParamModel params, final CompletionBlock<AbsAccountVerifyMethodIDL.AccountVerifyResultModel> callback) {
        Intrinsics.checkParameterIsNotNull(bridgeContext, "bridgeContext");
        Intrinsics.checkParameterIsNotNull(params, "params");
        Intrinsics.checkParameterIsNotNull(callback, "callback");
        JSONObject jSONObject = null;
        try {
            jSONObject = new JSONObject(params.getVerifyDecision());
        } catch (Exception e) {
            TwiceVerifyLogHelper.m15w("AccountVerifyMethod", "", e);
        }
        if (jSONObject == null) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "decision is null or transform fail", null, 4, null);
        } else {
            if (TwiceVerifyManager.getInstance().startTwiceVerify(jSONObject, new TwiceVerifyResultCallback() { // from class: com.bytedance.sdk.account.twiceverify.jsb.AccountVerifyMethod$handle$result$1
                @Override // com.bytedance.sdk.account.twiceverify.TwiceVerifyResultCallback
                public void onSuccess(String verifyWay, String verifyTicket, Map<String, String> bizParams, Map<String, Object> verifyExtraParams) {
                    CompletionBlock completionBlock = CompletionBlock.this;
                    XBaseModel createModel = XBridgeResultModelArguments.INSTANCE.createModel(AbsAccountVerifyMethodIDL.AccountVerifyResultModel.class);
                    AbsAccountVerifyMethodIDL.AccountVerifyResultModel accountVerifyResultModel = (AbsAccountVerifyMethodIDL.AccountVerifyResultModel) createModel;
                    accountVerifyResultModel.setVerifyWay(verifyWay);
                    accountVerifyResultModel.setVerifyTicket(verifyTicket);
                    accountVerifyResultModel.setBizParams(bizParams);
                    accountVerifyResultModel.setVerifyExtraParams(verifyExtraParams);
                    CompletionBlock.DefaultImpls.onSuccess$default(completionBlock, (XBaseResultModel) createModel, null, 2, null);
                }

                @Override // com.bytedance.sdk.account.twiceverify.TwiceVerifyResultCallback
                public void onFail() {
                    CompletionBlock.DefaultImpls.onFailure$default(CompletionBlock.this, 0, "twice verify fail", null, 4, null);
                }
            })) {
                return;
            }
            CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "start twice verify fail", null, 4, null);
        }
    }
}
