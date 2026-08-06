package com.bytedance.sdk.xbridge.cn.system;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeKTXKt;
import com.bytedance.sdk.xbridge.cn.system.idl.AbsXMakePhoneCallMethodIDL;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: XMakePhoneCallMethod.kt */
@XBridgeMethod(name = "x.makePhoneCall")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/system/XMakePhoneCallMethod;", "Lcom/bytedance/sdk/xbridge/cn/system/idl/AbsXMakePhoneCallMethodIDL;", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "params", "Lcom/bytedance/sdk/xbridge/cn/system/idl/AbsXMakePhoneCallMethodIDL$XMakePhoneCallParamModel;", "callback", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock;", "Lcom/bytedance/sdk/xbridge/cn/system/idl/AbsXMakePhoneCallMethodIDL$XMakePhoneCallResultModel;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class XMakePhoneCallMethod extends AbsXMakePhoneCallMethodIDL {
    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public void handle(IBDXBridgeContext bridgeContext, AbsXMakePhoneCallMethodIDL.XMakePhoneCallParamModel params, CompletionBlock<AbsXMakePhoneCallMethodIDL.XMakePhoneCallResultModel> callback) {
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        String phoneNumber = params.getPhoneNumber();
        if (phoneNumber.length() == 0) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "phoneNumber can not be empty", null, 4, null);
            return;
        }
        Intent intent = new Intent("android.intent.action.DIAL", Uri.fromParts("tel", phoneNumber, null));
        Activity ownerActivity = bridgeContext.getOwnerActivity();
        if (ownerActivity == null) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "Context not provided in host", null, 4, null);
        } else {
            CompletionBlock.DefaultImpls.onSuccess$default(callback, (XBaseResultModel) XBridgeKTXKt.createXModel(Reflection.getOrCreateKotlinClass(AbsXMakePhoneCallMethodIDL.XMakePhoneCallResultModel.class)), null, 2, null);
            ownerActivity.startActivity(intent);
        }
    }
}
