package com.bytedance.sdk.xbridge.cn.p003ui;

import android.view.View;
import com.bytedance.ies.bullet.kit.resourceloader.memory.MemoryManager;
import com.bytedance.ies.bullet.preloadv2.PreloadV2;
import com.bytedance.ies.bullet.ui.common.BulletCardView;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.MethodModelBean;
import com.bytedance.sdk.xbridge.cn.XBridgeDynamicModel;
import com.bytedance.sdk.xbridge.cn.p003ui.AbsXReloadViewMethodIDL;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeKTXKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: XReloadViewMethod.kt */
@XBridgeMethod(name = "x.reloadView")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/ui/XReloadViewMethod;", "Lcom/bytedance/sdk/xbridge/cn/ui/AbsXReloadViewMethodIDL;", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "params", "Lcom/bytedance/sdk/xbridge/cn/ui/AbsXReloadViewMethodIDL$XReloadViewParamModel;", "callback", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock;", "Lcom/bytedance/sdk/xbridge/cn/ui/AbsXReloadViewMethodIDL$XReloadViewResultModel;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class XReloadViewMethod extends AbsXReloadViewMethodIDL {
    /* JADX WARN: Multi-variable type inference failed */
    public XReloadViewMethod() {
        XBridgeDynamicModel.INSTANCE.addMethodModelMap(getClass(), new MethodModelBean(AbsXReloadViewMethodIDL.XReloadViewParamModel.class, AbsXReloadViewMethodIDL.XReloadViewResultModel.class));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public void handle(IBDXBridgeContext bridgeContext, AbsXReloadViewMethodIDL.XReloadViewParamModel params, CompletionBlock<AbsXReloadViewMethodIDL.XReloadViewResultModel> callback) {
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        View engineView = bridgeContext.getEngineView();
        if (engineView == null) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "can not get engine view", null, 4, null);
            return;
        }
        while (!(engineView instanceof BulletCardView) && engineView != null) {
            BulletCardView parent = engineView.getParent();
            engineView = parent instanceof View ? (View) parent : null;
        }
        if (engineView == null) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "can not get bullet view", null, 4, null);
            return;
        }
        PreloadV2.INSTANCE.clearCache(true, true, "x.reloadView");
        MemoryManager.Companion.getInstance().clearAllCache();
        ((BulletCardView) engineView).reLoadUri();
        callback.onSuccess((XBaseResultModel) XBridgeKTXKt.createXModel(Reflection.getOrCreateKotlinClass(AbsXReloadViewMethodIDL.XReloadViewResultModel.class)), "success");
    }
}
