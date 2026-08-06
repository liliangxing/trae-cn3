package com.bytedance.sdk.xbridge.cn.p003ui;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.p003ui.AbsXShowActionSheetMethodIDL;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeKTXKt;
import com.bytedance.sdk.xbridge.cn.runtime.depend.ActionSheetBuilder;
import com.bytedance.sdk.xbridge.cn.runtime.depend.ActionSheetBuilderAction;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostStyleUIDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.ShowActionSheetListener;
import com.bytedance.sdk.xbridge.cn.utils.RuntimeHelper;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* compiled from: XShowActionSheetMethod.kt */
@XBridgeMethod(name = "x.showActionSheet")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J&\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/ui/XShowActionSheetMethod;", "Lcom/bytedance/sdk/xbridge/cn/ui/AbsXShowActionSheetMethodIDL;", "()V", "canRunInBackground", "", "handle", "", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "params", "Lcom/bytedance/sdk/xbridge/cn/ui/AbsXShowActionSheetMethodIDL$XShowActionSheetParamModel;", "callback", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock;", "Lcom/bytedance/sdk/xbridge/cn/ui/AbsXShowActionSheetMethodIDL$XShowActionSheetResultModel;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class XShowActionSheetMethod extends AbsXShowActionSheetMethodIDL {
    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public boolean canRunInBackground() {
        return false;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public void handle(IBDXBridgeContext bridgeContext, AbsXShowActionSheetMethodIDL.XShowActionSheetParamModel params, final CompletionBlock<AbsXShowActionSheetMethodIDL.XShowActionSheetResultModel> callback) {
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Activity ownerActivity = bridgeContext.getOwnerActivity();
        if (ownerActivity == null || !(ownerActivity instanceof FragmentActivity)) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "Context not provided in host", null, 4, null);
            return;
        }
        String title = params.getTitle();
        String subtitle = params.getSubtitle();
        ArrayList arrayList = new ArrayList();
        for (AbsXShowActionSheetMethodIDL.XBridgeBeanXShowActionSheetActionsBDXBridgeActionSheetActions xBridgeBeanXShowActionSheetActionsBDXBridgeActionSheetActions : params.getActions()) {
            arrayList.add(new ActionSheetBuilderAction(xBridgeBeanXShowActionSheetActionsBDXBridgeActionSheetActions.getTitle(), xBridgeBeanXShowActionSheetActionsBDXBridgeActionSheetActions.getSubtitle(), xBridgeBeanXShowActionSheetActionsBDXBridgeActionSheetActions.getType()));
        }
        ShowActionSheetListener showActionSheetListener = new ShowActionSheetListener() { // from class: com.bytedance.sdk.xbridge.cn.ui.XShowActionSheetMethod$handle$showActionSheetListener$1
            @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.ShowActionSheetListener
            public void onSelect(int index) {
                CompletionBlock<AbsXShowActionSheetMethodIDL.XShowActionSheetResultModel> completionBlock = callback;
                XBaseModel createXModel = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXShowActionSheetMethodIDL.XShowActionSheetResultModel.class));
                AbsXShowActionSheetMethodIDL.XShowActionSheetResultModel xShowActionSheetResultModel = (AbsXShowActionSheetMethodIDL.XShowActionSheetResultModel) createXModel;
                xShowActionSheetResultModel.setAction("select");
                AbsXShowActionSheetMethodIDL.XBridgeBeanXShowActionSheetDetail xBridgeBeanXShowActionSheetDetail = (AbsXShowActionSheetMethodIDL.XBridgeBeanXShowActionSheetDetail) XBridgeKTXKt.createXModel(Reflection.getOrCreateKotlinClass(AbsXShowActionSheetMethodIDL.XBridgeBeanXShowActionSheetDetail.class));
                xBridgeBeanXShowActionSheetDetail.setIndex(Integer.valueOf(index));
                xShowActionSheetResultModel.setDetail(xBridgeBeanXShowActionSheetDetail);
                CompletionBlock.DefaultImpls.onSuccess$default(completionBlock, (XBaseResultModel) createXModel, null, 2, null);
            }

            @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.ShowActionSheetListener
            public void onDismiss() {
                CompletionBlock<AbsXShowActionSheetMethodIDL.XShowActionSheetResultModel> completionBlock = callback;
                XBaseModel createXModel = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXShowActionSheetMethodIDL.XShowActionSheetResultModel.class));
                ((AbsXShowActionSheetMethodIDL.XShowActionSheetResultModel) createXModel).setAction("dismiss");
                CompletionBlock.DefaultImpls.onSuccess$default(completionBlock, (XBaseResultModel) createXModel, null, 2, null);
            }
        };
        IHostStyleUIDepend uIDependInstance = RuntimeHelper.INSTANCE.getUIDependInstance(bridgeContext);
        if (Intrinsics.areEqual(uIDependInstance != null ? uIDependInstance.showActionSheet(new ActionSheetBuilder(ownerActivity, title, subtitle, arrayList), showActionSheetListener) : null, true)) {
            return;
        }
        CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "Failed to show actionSheet in host", null, 4, null);
    }
}
