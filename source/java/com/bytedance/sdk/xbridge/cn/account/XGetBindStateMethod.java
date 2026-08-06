package com.bytedance.sdk.xbridge.cn.account;

import com.bytedance.android.anniex.ability.service.AccountAuthType;
import com.bytedance.android.anniex.ability.service.IAnnieXAccountService;
import com.bytedance.android.anniex.base.service.AnnieXServiceCenter;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.BidConstants;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeKTXKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* compiled from: XGetBindStateMethod.kt */
@XBridgeMethod(name = "x.getBindState")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/account/XGetBindStateMethod;", "LAbsXGetBindStateMethodIDL;", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "params", "LAbsXGetBindStateMethodIDL$XGetBindStateParamModel;", "callback", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock;", "LAbsXGetBindStateMethodIDL$XGetBindStateResultModel;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class XGetBindStateMethod extends AbsXGetBindStateMethodIDL {
    public /* bridge */ /* synthetic */ void handle(IBDXBridgeContext iBDXBridgeContext, XBaseParamModel xBaseParamModel, CompletionBlock completionBlock) {
        handle(iBDXBridgeContext, (XGetBindStateParamModel) xBaseParamModel, (CompletionBlock<XGetBindStateResultModel>) completionBlock);
    }

    public void handle(IBDXBridgeContext bridgeContext, XGetBindStateParamModel params, CompletionBlock<XGetBindStateResultModel> callback) {
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (params.getAccountAuthType().intValue() != 11) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "only support douyin", null, 4, null);
            return;
        }
        IAnnieXAccountService service = AnnieXServiceCenter.INSTANCE.getService(BidConstants.DEFAULT, IAnnieXAccountService.class);
        Unit unit = null;
        if (service != null) {
            boolean bindState = service.getBindState(AccountAuthType.Douyin);
            XGetBindStateResultModel createXModel = XBridgeKTXKt.createXModel((KClass<XGetBindStateResultModel>) Reflection.getOrCreateKotlinClass(XGetBindStateResultModel.class));
            createXModel.setBind(Boolean.valueOf(bindState));
            CompletionBlock.DefaultImpls.onSuccess$default(callback, (XBaseResultModel) createXModel, null, 2, null);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "the function getBindState in IAnnieXAccountService is not implemented", null, 4, null);
        }
    }
}
