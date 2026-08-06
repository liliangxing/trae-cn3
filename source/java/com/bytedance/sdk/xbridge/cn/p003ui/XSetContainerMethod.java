package com.bytedance.sdk.xbridge.cn.p003ui;

import android.app.Activity;
import android.app.Dialog;
import android.view.Window;
import androidx.fragment.app.DialogFragment;
import com.bytedance.android.anniex.base.container.IContainer;
import com.bytedance.android.anniex.lite.utils.AnnieXLiteUtilsKt;
import com.bytedance.ies.bullet.core.model.context.ContextProviderFactory;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.p003ui.base.AbsXSetContainerMethodIDL;
import com.bytedance.sdk.xbridge.cn.p003ui.utils.NaviUtils;
import com.bytedance.sdk.xbridge.cn.p003ui.utils.StatusBarUtils;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeKTXKt;
import com.bytedance.sdk.xbridge.cn.runtime.depend.BackPressConfig;
import com.bytedance.sdk.xbridge.cn.runtime.depend.PageTitleBar;
import com.bytedance.sdk.xbridge.cn.runtime.depend.PopupConfig;
import com.bytedance.sdk.xbridge.cn.utils.XBridgeMethodHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: XSetContainerMethod.kt */
@XBridgeMethod(name = "x.setContainer")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J&\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/ui/XSetContainerMethod;", "Lcom/bytedance/sdk/xbridge/cn/ui/base/AbsXSetContainerMethodIDL;", "()V", "canRunInBackground", "", "handle", "", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "params", "Lcom/bytedance/sdk/xbridge/cn/ui/base/AbsXSetContainerMethodIDL$XSetContainerParamModel;", "callback", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock;", "Lcom/bytedance/sdk/xbridge/cn/ui/base/AbsXSetContainerMethodIDL$XSetContainerResultModel;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class XSetContainerMethod extends AbsXSetContainerMethodIDL {
    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public boolean canRunInBackground() {
        return false;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public void handle(IBDXBridgeContext bridgeContext, AbsXSetContainerMethodIDL.XSetContainerParamModel params, CompletionBlock<AbsXSetContainerMethodIDL.XSetContainerResultModel> callback) {
        Dialog dialog;
        Window window;
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Activity ownerActivity = bridgeContext.getOwnerActivity();
        if (ownerActivity == null) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "Context not provided in host", null, 4, null);
            return;
        }
        Activity activity = ownerActivity;
        Activity activity2 = XBridgeMethodHelper.INSTANCE.getActivity(activity);
        DialogFragment isLitePage = AnnieXLiteUtilsKt.isLitePage(bridgeContext);
        if (isLitePage != null && (dialog = isLitePage.getDialog()) != null && (window = dialog.getWindow()) != null) {
            AbsXSetContainerMethodIDL.XBridgeBeanXSetContainerPageUI pageUI = params.getPageUI();
            String statusBarBgColor = pageUI != null ? pageUI.getStatusBarBgColor() : null;
            AbsXSetContainerMethodIDL.XBridgeBeanXSetContainerPageUI pageUI2 = params.getPageUI();
            String statusFontMode = pageUI2 != null ? pageUI2.getStatusFontMode() : null;
            AbsXSetContainerMethodIDL.XBridgeBeanXSetContainerCommonInteraction commonInteraction = params.getCommonInteraction();
            Number disableBackPress = commonInteraction != null ? commonInteraction.getDisableBackPress() : null;
            if (statusBarBgColor != null) {
                StatusBarUtils.INSTANCE.setStatusBarBgColor(window, activity, statusBarBgColor);
            }
            if (statusFontMode != null) {
                StatusBarUtils.INSTANCE.trySetStatusBar(null, window, Intrinsics.areEqual("dark", statusFontMode));
            }
            NaviUtils naviUtils = NaviUtils.INSTANCE;
            ContextProviderFactory contextProviderFactory = (ContextProviderFactory) bridgeContext.getService(ContextProviderFactory.class);
            naviUtils.configBackPress(contextProviderFactory != null ? (IContainer) contextProviderFactory.provideInstance(IContainer.class) : null, new BackPressConfig(disableBackPress != null ? Integer.valueOf(disableBackPress.intValue()) : null));
            CompletionBlock.DefaultImpls.onSuccess$default(callback, (XBaseResultModel) XBridgeKTXKt.createXModel(Reflection.getOrCreateKotlinClass(AbsXSetContainerMethodIDL.XSetContainerResultModel.class)), null, 2, null);
            return;
        }
        AbsXSetContainerMethodIDL.XBridgeBeanXSetContainerPageUI pageUI3 = params.getPageUI();
        String title = pageUI3 != null ? pageUI3.getTitle() : null;
        AbsXSetContainerMethodIDL.XBridgeBeanXSetContainerPageUI pageUI4 = params.getPageUI();
        String titleColor = pageUI4 != null ? pageUI4.getTitleColor() : null;
        AbsXSetContainerMethodIDL.XBridgeBeanXSetContainerPageUI pageUI5 = params.getPageUI();
        String navBarColor = pageUI5 != null ? pageUI5.getNavBarColor() : null;
        AbsXSetContainerMethodIDL.XBridgeBeanXSetContainerPageUI pageUI6 = params.getPageUI();
        String statusBarBgColor2 = pageUI6 != null ? pageUI6.getStatusBarBgColor() : null;
        AbsXSetContainerMethodIDL.XBridgeBeanXSetContainerPageUI pageUI7 = params.getPageUI();
        String statusFontMode2 = pageUI7 != null ? pageUI7.getStatusFontMode() : null;
        AbsXSetContainerMethodIDL.XBridgeBeanXSetContainerPageInteraction pageInteraction = params.getPageInteraction();
        String navBtnType = pageInteraction != null ? pageInteraction.getNavBtnType() : null;
        AbsXSetContainerMethodIDL.XBridgeBeanXSetContainerPageInteraction pageInteraction2 = params.getPageInteraction();
        Number shouldFullScreen = pageInteraction2 != null ? pageInteraction2.getShouldFullScreen() : null;
        AbsXSetContainerMethodIDL.XBridgeBeanXSetContainerPopupInteraction popupInteraction = params.getPopupInteraction();
        Number disableMaskClickClose = popupInteraction != null ? popupInteraction.getDisableMaskClickClose() : null;
        AbsXSetContainerMethodIDL.XBridgeBeanXSetContainerPopupInteraction popupInteraction2 = params.getPopupInteraction();
        Number enablePullDownClose = popupInteraction2 != null ? popupInteraction2.getEnablePullDownClose() : null;
        AbsXSetContainerMethodIDL.XBridgeBeanXSetContainerCommonInteraction commonInteraction2 = params.getCommonInteraction();
        Number disableBackPress2 = commonInteraction2 != null ? commonInteraction2.getDisableBackPress() : null;
        NaviUtils.INSTANCE.configNavBarAndStatusBar(bridgeContext, activity2, new PageTitleBar(title, StatusBarUtils.INSTANCE.parseColor(titleColor), StatusBarUtils.INSTANCE.parseColor(navBarColor), navBtnType), statusFontMode2, statusBarBgColor2, shouldFullScreen != null ? Integer.valueOf(shouldFullScreen.intValue()) : null);
        NaviUtils.INSTANCE.configPopup(bridgeContext, activity2, new PopupConfig(disableMaskClickClose != null ? Integer.valueOf(disableMaskClickClose.intValue()) : null, enablePullDownClose != null ? Integer.valueOf(enablePullDownClose.intValue()) : null));
        NaviUtils.INSTANCE.configBackPress(bridgeContext, activity2, new BackPressConfig(disableBackPress2 != null ? Integer.valueOf(disableBackPress2.intValue()) : null));
        CompletionBlock.DefaultImpls.onSuccess$default(callback, (XBaseResultModel) XBridgeKTXKt.createXModel(Reflection.getOrCreateKotlinClass(AbsXSetContainerMethodIDL.XSetContainerResultModel.class)), null, 2, null);
    }
}
