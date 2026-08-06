package com.bytedance.trae.anniex;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeKTXKt;
import com.bytedance.trae.anniex.AbsToastMethodIDL;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ToastBridgeMethod.kt */
@XBridgeMethod(name = "view.toast")
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J&\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016¨\u0006\u000f"}, d2 = {"Lcom/bytedance/trae/anniex/ToastBridgeMethod;", "Lcom/bytedance/trae/anniex/AbsToastMethodIDL;", "<init>", "()V", "canRunInBackground", "", "handle", "", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "params", "Lcom/bytedance/trae/anniex/AbsToastMethodIDL$ToastParamModel;", "callback", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock;", "Lcom/bytedance/trae/anniex/AbsToastMethodIDL$ToastResultModel;", "app_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ToastBridgeMethod extends AbsToastMethodIDL {
    public static final int $stable = 0;

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public boolean canRunInBackground() {
        return false;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public void handle(IBDXBridgeContext bridgeContext, AbsToastMethodIDL.ToastParamModel params, CompletionBlock<AbsToastMethodIDL.ToastResultModel> callback) {
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        try {
            final Activity ownerActivity = bridgeContext.getOwnerActivity();
            if (ownerActivity == null) {
                CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "no context", null, 4, null);
                return;
            }
            final String text = params.getText();
            Number duration = params.getDuration();
            final int i = (duration != null ? duration.intValue() : 0) > 2000 ? 1 : 0;
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.trae.anniex.ToastBridgeMethod$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    ToastBridgeMethod.handle$lambda$0(ownerActivity, text, i);
                }
            });
            AbsToastMethodIDL.ToastResultModel toastResultModel = (AbsToastMethodIDL.ToastResultModel) XBridgeKTXKt.createXModel(AbsToastMethodIDL.ToastResultModel.class);
            toastResultModel.setCode((Number) 1);
            toastResultModel.setData(MapsKt.emptyMap());
            CompletionBlock.DefaultImpls.onSuccess$default(callback, toastResultModel, null, 2, null);
        } catch (Exception e) {
            String message = e.getMessage();
            if (message == null) {
                message = "failed to show toast";
            }
            CompletionBlock.DefaultImpls.onFailure$default(callback, 0, message, null, 4, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handle$lambda$0(Activity activity, String str, int i) {
        Toast.makeText(activity, str, i).show();
    }
}
