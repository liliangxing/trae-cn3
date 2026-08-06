package com.bytedance.trae.anniex;

import android.app.Activity;
import android.content.Intent;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeKTXKt;
import com.bytedance.trae.anniex.AbsGoToSoloConversationMethodIDL;
import com.bytedance.trae.utils.TrustedDomainUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GoToSoloConversationBridgeMethod.kt */
@XBridgeMethod(name = "goToSoloConversation")
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J&\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016¨\u0006\u000f"}, d2 = {"Lcom/bytedance/trae/anniex/GoToSoloConversationBridgeMethod;", "Lcom/bytedance/trae/anniex/AbsGoToSoloConversationMethodIDL;", "<init>", "()V", "canRunInBackground", "", "handle", "", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "params", "Lcom/bytedance/trae/anniex/AbsGoToSoloConversationMethodIDL$GoToSoloConversationParamModel;", "callback", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock;", "Lcom/bytedance/trae/anniex/AbsGoToSoloConversationMethodIDL$GoToSoloConversationResultModel;", "app_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class GoToSoloConversationBridgeMethod extends AbsGoToSoloConversationMethodIDL {
    public static final int $stable = 0;

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public boolean canRunInBackground() {
        return false;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public void handle(IBDXBridgeContext bridgeContext, AbsGoToSoloConversationMethodIDL.GoToSoloConversationParamModel params, CompletionBlock<AbsGoToSoloConversationMethodIDL.GoToSoloConversationResultModel> callback) {
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!TrustedDomainUtils.INSTANCE.isTrustedUrl(bridgeContext.getBridgeCall().getUrl())) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "untrusted domain", null, 4, null);
            return;
        }
        try {
            Activity ownerActivity = bridgeContext.getOwnerActivity();
            if (ownerActivity == null) {
                CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "no activity context", null, 4, null);
                return;
            }
            ownerActivity.startActivity(new Intent(ownerActivity, Class.forName("com.bytedance.trae.conversation.ConversationActivity")));
            CompletionBlock.DefaultImpls.onSuccess$default(callback, (XBaseResultModel) XBridgeKTXKt.createXModel(AbsGoToSoloConversationMethodIDL.GoToSoloConversationResultModel.class), null, 2, null);
        } catch (Exception e) {
            String message = e.getMessage();
            if (message == null) {
                message = "failed to navigate";
            }
            CompletionBlock.DefaultImpls.onFailure$default(callback, 0, message, null, 4, null);
        }
    }
}
