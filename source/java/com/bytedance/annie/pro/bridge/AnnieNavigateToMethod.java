package com.bytedance.annie.pro.bridge;

import androidx.fragment.app.Fragment;
import com.bytedance.android.anniex.R;
import com.bytedance.annie.pro.bridge.AbsAnnieNavigateToMethodIDL;
import com.bytedance.annie.pro.p002ui.AnnieProActivity;
import com.bytedance.annie.pro.p002ui.AnnieProFragment;
import com.bytedance.bdturing.methods.JsCallParser;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeKTXKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnnieNavigateToMethod.kt */
@XBridgeMethod(name = "annie.navigateTo", owner = "hsu.wang")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/annie/pro/bridge/AnnieNavigateToMethod;", "Lcom/bytedance/annie/pro/bridge/AbsAnnieNavigateToMethodIDL;", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "params", "Lcom/bytedance/annie/pro/bridge/AbsAnnieNavigateToMethodIDL$AnnieNavigateToParamModel;", JsCallParser.VALUE_CALLBACK, "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock;", "Lcom/bytedance/annie/pro/bridge/AbsAnnieNavigateToMethodIDL$AnnieNavigateToResultModel;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class AnnieNavigateToMethod extends AbsAnnieNavigateToMethodIDL {
    public /* bridge */ /* synthetic */ void handle(IBDXBridgeContext iBDXBridgeContext, XBaseParamModel xBaseParamModel, CompletionBlock completionBlock) {
        handle(iBDXBridgeContext, (AbsAnnieNavigateToMethodIDL.AnnieNavigateToParamModel) xBaseParamModel, (CompletionBlock<AbsAnnieNavigateToMethodIDL.AnnieNavigateToResultModel>) completionBlock);
    }

    public void handle(IBDXBridgeContext bridgeContext, AbsAnnieNavigateToMethodIDL.AnnieNavigateToParamModel params, CompletionBlock<AbsAnnieNavigateToMethodIDL.AnnieNavigateToResultModel> callback) {
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, JsCallParser.VALUE_CALLBACK);
        Object ownerActivity = bridgeContext.getOwnerActivity();
        Intrinsics.checkNotNull(ownerActivity, "null cannot be cast to non-null type com.bytedance.annie.pro.ui.AnnieProActivity");
        Fragment findFragmentById = ((AnnieProActivity) ownerActivity).getSupportFragmentManager().findFragmentById(R.id.annie_pro_fragment_container);
        AnnieProFragment annieProFragment = findFragmentById instanceof AnnieProFragment ? (AnnieProFragment) findFragmentById : null;
        String url = params.getUrl();
        if (url != null && annieProFragment != null) {
            annieProFragment.navigateTo(url);
        }
        CompletionBlock.DefaultImpls.onSuccess$default(callback, XBridgeKTXKt.createXModel(AbsAnnieNavigateToMethodIDL.AnnieNavigateToResultModel.class), (String) null, 2, (Object) null);
    }
}
