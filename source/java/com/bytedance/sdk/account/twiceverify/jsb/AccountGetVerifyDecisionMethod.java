package com.bytedance.sdk.account.twiceverify.jsb;

import com.bytedance.sdk.account.twiceverify.TwiceVerifyLogHelper;
import com.bytedance.sdk.account.twiceverify.TwiceVerifyManager;
import com.bytedance.sdk.account.twiceverify.jsb.idl.AbsAccountGetVerifyDecisionMethodIDL;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeResultModelArguments;
import com.bytedance.sdk.xbridge.cn.utils.ConvertUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: AccountGetVerifyDecisionMethod.kt */
@XBridgeMethod(name = "account.getVerifyDecision")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/sdk/account/twiceverify/jsb/AccountGetVerifyDecisionMethod;", "Lcom/bytedance/sdk/account/twiceverify/jsb/idl/AbsAccountGetVerifyDecisionMethodIDL;", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "params", "Lcom/bytedance/sdk/account/twiceverify/jsb/idl/AbsAccountGetVerifyDecisionMethodIDL$AccountGetVerifyDecisionParamModel;", "callback", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock;", "Lcom/bytedance/sdk/account/twiceverify/jsb/idl/AbsAccountGetVerifyDecisionMethodIDL$AccountGetVerifyDecisionResultModel;", "uc_twice_verify_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class AccountGetVerifyDecisionMethod extends AbsAccountGetVerifyDecisionMethodIDL {
    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public void handle(IBDXBridgeContext bridgeContext, AbsAccountGetVerifyDecisionMethodIDL.AccountGetVerifyDecisionParamModel params, CompletionBlock<AbsAccountGetVerifyDecisionMethodIDL.AccountGetVerifyDecisionResultModel> callback) {
        Intrinsics.checkParameterIsNotNull(bridgeContext, "bridgeContext");
        Intrinsics.checkParameterIsNotNull(params, "params");
        Intrinsics.checkParameterIsNotNull(callback, "callback");
        TwiceVerifyManager twiceVerifyManager = TwiceVerifyManager.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(twiceVerifyManager, "TwiceVerifyManager.getInstance()");
        JSONObject decision = twiceVerifyManager.getDecision();
        if (decision == null) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "decision is null, or not in twice verify flow", null, 4, null);
            return;
        }
        try {
            Map<String, Object> jsonToMap = ConvertUtils.INSTANCE.jsonToMap(decision);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<String, Object> entry : jsonToMap.entrySet()) {
                if (entry.getValue() != null) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            LinkedHashMap linkedHashMap2 = linkedHashMap;
            if (!(linkedHashMap2 instanceof Map)) {
                linkedHashMap2 = null;
            }
            XBaseModel createModel = XBridgeResultModelArguments.INSTANCE.createModel(AbsAccountGetVerifyDecisionMethodIDL.AccountGetVerifyDecisionResultModel.class);
            ((AbsAccountGetVerifyDecisionMethodIDL.AccountGetVerifyDecisionResultModel) createModel).setVerifyDecision(linkedHashMap2);
            CompletionBlock.DefaultImpls.onSuccess$default(callback, (AbsAccountGetVerifyDecisionMethodIDL.AccountGetVerifyDecisionResultModel) createModel, null, 2, null);
        } catch (Exception e) {
            TwiceVerifyLogHelper.m15w("AccountGetVerifyDecisionMethod", "", e);
            CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "crash while parsing decisions", null, 4, null);
        }
    }
}
