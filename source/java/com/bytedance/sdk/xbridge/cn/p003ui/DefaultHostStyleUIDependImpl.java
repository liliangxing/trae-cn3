package com.bytedance.sdk.xbridge.cn.p003ui;

import android.app.Activity;
import android.widget.Toast;
import com.bytedance.sdk.xbridge.base.runtime.model.XShowLoadingParams;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.runtime.depend.ActionSheetBuilder;
import com.bytedance.sdk.xbridge.cn.runtime.depend.DialogBuilder;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostStyleUIDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.PageTitleBar;
import com.bytedance.sdk.xbridge.cn.runtime.depend.ShowActionSheetListener;
import com.bytedance.sdk.xbridge.cn.runtime.depend.ToastBuilder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DefaultHostStyleUIDependImpl.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0017\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¢\u0006\u0002\u0010\u0007J\u0017\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/ui/DefaultHostStyleUIDependImpl;", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostStyleUIDepend;", "()V", "showDialog", "", "dialogBuilder", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/DialogBuilder;", "(Lcom/bytedance/sdk/xbridge/cn/runtime/depend/DialogBuilder;)Ljava/lang/Boolean;", "showToast", "toastBuilder", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/ToastBuilder;", "(Lcom/bytedance/sdk/xbridge/cn/runtime/depend/ToastBuilder;)Ljava/lang/Boolean;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class DefaultHostStyleUIDependImpl implements IHostStyleUIDepend {
    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostStyleUIDepend
    public Boolean hideLoading(IBDXBridgeContext iBDXBridgeContext) {
        return IHostStyleUIDepend.DefaultImpls.hideLoading(this, iBDXBridgeContext);
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostStyleUIDepend
    public void setPageNaviStyle(IBDXBridgeContext iBDXBridgeContext, Activity activity, PageTitleBar pageTitleBar) {
        IHostStyleUIDepend.DefaultImpls.setPageNaviStyle(this, iBDXBridgeContext, activity, pageTitleBar);
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostStyleUIDepend
    public Boolean showActionSheet(ActionSheetBuilder actionSheetBuilder, ShowActionSheetListener showActionSheetListener) {
        return IHostStyleUIDepend.DefaultImpls.showActionSheet(this, actionSheetBuilder, showActionSheetListener);
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostStyleUIDepend
    public Boolean showLoading(XShowLoadingParams xShowLoadingParams, IBDXBridgeContext iBDXBridgeContext) {
        return IHostStyleUIDepend.DefaultImpls.showLoading(this, xShowLoadingParams, iBDXBridgeContext);
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostStyleUIDepend
    public Boolean showLoading(IBDXBridgeContext iBDXBridgeContext) {
        return IHostStyleUIDepend.DefaultImpls.showLoading(this, iBDXBridgeContext);
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostStyleUIDepend
    public Boolean showDialog(DialogBuilder dialogBuilder) {
        Intrinsics.checkNotNullParameter(dialogBuilder, "dialogBuilder");
        return IHostStyleUIDepend.DefaultImpls.showDialog(this, dialogBuilder);
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostStyleUIDepend
    public Boolean showToast(ToastBuilder toastBuilder) {
        Intrinsics.checkNotNullParameter(toastBuilder, "toastBuilder");
        Toast.makeText(toastBuilder.getContext(), toastBuilder.getMessage(), 0).show();
        return true;
    }
}
