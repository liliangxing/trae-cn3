package com.bytedance.sdk.xbridge.cn.p003ui;

import android.app.Activity;
import android.app.Dialog;
import android.view.Window;
import androidx.fragment.app.DialogFragment;
import com.bytedance.android.anniex.base.container.IStatusBarHost;
import com.bytedance.android.anniex.container.util.AnnieXUtilsKt;
import com.bytedance.android.anniex.lite.utils.AnnieXLiteUtilsKt;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.XBridge;
import com.bytedance.sdk.xbridge.cn.p003ui.AbsXConfigureStatusBarMethodIDL;
import com.bytedance.sdk.xbridge.cn.p003ui.utils.StatusBarUtils;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeKTXKt;
import com.bytedance.sdk.xbridge.cn.utils.XBridgeMethodHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: XConfigureStatusBarMethod.kt */
@XBridgeMethod(name = "x.configureStatusBar")
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0016J&\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/ui/XConfigureStatusBarMethod;", "Lcom/bytedance/sdk/xbridge/cn/ui/AbsXConfigureStatusBarMethodIDL;", "()V", "TAG", "", "canRunInBackground", "", "handle", "", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "params", "Lcom/bytedance/sdk/xbridge/cn/ui/AbsXConfigureStatusBarMethodIDL$XConfigureStatusBarParamModel;", "callback", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock;", "Lcom/bytedance/sdk/xbridge/cn/ui/AbsXConfigureStatusBarMethodIDL$XConfigureStatusBarResultModel;", "StatusBarStyle", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class XConfigureStatusBarMethod extends AbsXConfigureStatusBarMethodIDL {
    private final String TAG = "XConfigureStatusBarMethod";

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public boolean canRunInBackground() {
        return false;
    }

    /* compiled from: XConfigureStatusBarMethod.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/ui/XConfigureStatusBarMethod$StatusBarStyle;", "", "style", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getStyle", "()Ljava/lang/String;", "DARK", "LIGHT", "UNKNOWN", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public enum StatusBarStyle {
        DARK("dark"),
        LIGHT("light"),
        UNKNOWN(null);


        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String style;

        StatusBarStyle(String str) {
            this.style = str;
        }

        public final String getStyle() {
            return this.style;
        }

        /* compiled from: XConfigureStatusBarMethod.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/ui/XConfigureStatusBarMethod$StatusBarStyle$Companion;", "", "()V", "getStyleByName", "Lcom/bytedance/sdk/xbridge/cn/ui/XConfigureStatusBarMethod$StatusBarStyle;", "name", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final StatusBarStyle getStyleByName(String name) {
                if (name != null) {
                    try {
                        String upperCase = name.toUpperCase();
                        Intrinsics.checkNotNullExpressionValue(upperCase, "(this as java.lang.String).toUpperCase()");
                        return StatusBarStyle.valueOf(upperCase);
                    } catch (Throwable unused) {
                        return StatusBarStyle.UNKNOWN;
                    }
                }
                return StatusBarStyle.UNKNOWN;
            }
        }
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public void handle(IBDXBridgeContext bridgeContext, AbsXConfigureStatusBarMethodIDL.XConfigureStatusBarParamModel params, CompletionBlock<AbsXConfigureStatusBarMethodIDL.XConfigureStatusBarResultModel> callback) {
        Window window;
        Window window2;
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
        String style = params.getStyle();
        Boolean visible = params.getVisible();
        DialogFragment isLitePage = AnnieXLiteUtilsKt.isLitePage(bridgeContext);
        boolean z = true;
        if (isLitePage != null) {
            if (style != null) {
                try {
                    StatusBarStyle styleByName = StatusBarStyle.INSTANCE.getStyleByName(style);
                    if (styleByName == StatusBarStyle.UNKNOWN) {
                        CompletionBlock.DefaultImpls.onFailure$default(callback, -3, "StatusBar style can only be dark or light", null, 4, null);
                        return;
                    }
                    XBridge.log("handle: style = " + style);
                    Dialog dialog = isLitePage.getDialog();
                    Window window3 = dialog != null ? dialog.getWindow() : null;
                    StatusBarUtils statusBarUtils = StatusBarUtils.INSTANCE;
                    if (styleByName != StatusBarStyle.DARK) {
                        z = false;
                    }
                    statusBarUtils.trySetStatusBar(window3, z);
                } catch (Exception e) {
                    XBridge.log("handle: " + e.getMessage());
                }
            }
            if (visible != null) {
                if (visible.booleanValue()) {
                    StatusBarUtils statusBarUtils2 = StatusBarUtils.INSTANCE;
                    Dialog dialog2 = isLitePage.getDialog();
                    statusBarUtils2.showStatusBar(dialog2 != null ? dialog2.getWindow() : null);
                } else {
                    Dialog dialog3 = isLitePage.getDialog();
                    if (dialog3 != null && (window2 = dialog3.getWindow()) != null) {
                        com.bytedance.android.anniex.container.util.StatusBarUtils statusBarUtils3 = com.bytedance.android.anniex.container.util.StatusBarUtils.INSTANCE;
                        Intrinsics.checkNotNullExpressionValue(window2, "it");
                        statusBarUtils3.hideStatusBar(window2);
                    }
                }
            }
            String backgroundColor = params.getBackgroundColor();
            Dialog dialog4 = isLitePage.getDialog();
            if (dialog4 != null && (window = dialog4.getWindow()) != null) {
                StatusBarUtils.INSTANCE.setStatusBarBgColor(window, ownerActivity, backgroundColor);
            }
            CompletionBlock.DefaultImpls.onSuccess$default(callback, (XBaseResultModel) XBridgeKTXKt.createXModel(Reflection.getOrCreateKotlinClass(AbsXConfigureStatusBarMethodIDL.XConfigureStatusBarResultModel.class)), null, 2, null);
            return;
        }
        IStatusBarHost isAnnieXPage = AnnieXUtilsKt.isAnnieXPage(bridgeContext);
        if (isAnnieXPage != null) {
            String backgroundColor2 = params.getBackgroundColor();
            if (backgroundColor2 != null) {
                StatusBarUtils.INSTANCE.setStatusBarBgColor(activity2 != null ? activity2.getWindow() : null, activity, backgroundColor2);
            }
            if (style != null) {
                if (StatusBarStyle.INSTANCE.getStyleByName(style) == StatusBarStyle.UNKNOWN) {
                    CompletionBlock.DefaultImpls.onFailure$default(callback, -3, "StatusBar style can only be dark or light", null, 4, null);
                    return;
                }
                isAnnieXPage.setStatusFontMode(style);
            }
            if (visible != null) {
                if (visible.booleanValue()) {
                    StatusBarUtils.INSTANCE.showStatusBar(activity2);
                } else {
                    StatusBarUtils.INSTANCE.hideStatusBar(activity2);
                }
            }
            CompletionBlock.DefaultImpls.onSuccess$default(callback, (XBaseResultModel) XBridgeKTXKt.createXModel(Reflection.getOrCreateKotlinClass(AbsXConfigureStatusBarMethodIDL.XConfigureStatusBarResultModel.class)), null, 2, null);
            return;
        }
        IStatusBarHost isAnnieXPopup = AnnieXUtilsKt.isAnnieXPopup(bridgeContext);
        if (isAnnieXPopup != null) {
            String backgroundColor3 = params.getBackgroundColor();
            if (backgroundColor3 != null) {
                StatusBarUtils.INSTANCE.setStatusBarBgColor(activity2 != null ? activity2.getWindow() : null, activity, backgroundColor3);
            }
            if (style != null) {
                if (StatusBarStyle.INSTANCE.getStyleByName(style) == StatusBarStyle.UNKNOWN) {
                    CompletionBlock.DefaultImpls.onFailure$default(callback, -3, "StatusBar style can only be dark or light", null, 4, null);
                    return;
                }
                isAnnieXPopup.setStatusFontMode(style);
            }
            if (visible != null) {
                if (visible.booleanValue()) {
                    StatusBarUtils.INSTANCE.showStatusBar(activity2);
                } else {
                    StatusBarUtils.INSTANCE.hideStatusBar(activity2);
                }
            }
            CompletionBlock.DefaultImpls.onSuccess$default(callback, (XBaseResultModel) XBridgeKTXKt.createXModel(Reflection.getOrCreateKotlinClass(AbsXConfigureStatusBarMethodIDL.XConfigureStatusBarResultModel.class)), null, 2, null);
            return;
        }
        if (style != null) {
            try {
                StatusBarStyle styleByName2 = StatusBarStyle.INSTANCE.getStyleByName(style);
                if (styleByName2 == StatusBarStyle.UNKNOWN) {
                    CompletionBlock.DefaultImpls.onFailure$default(callback, -3, "StatusBar style can only be dark or light", null, 4, null);
                    return;
                }
                XBridge.log("handle: style = " + style);
                Window window4 = activity2 != null ? activity2.getWindow() : null;
                StatusBarUtils statusBarUtils4 = StatusBarUtils.INSTANCE;
                if (styleByName2 != StatusBarStyle.DARK) {
                    z = false;
                }
                statusBarUtils4.trySetStatusBar(activity2, window4, z);
            } catch (Exception e2) {
                XBridge.log("handle: " + e2.getMessage());
            }
        }
        if (visible != null) {
            if (visible.booleanValue()) {
                StatusBarUtils.INSTANCE.showStatusBar(activity2);
            } else {
                StatusBarUtils.INSTANCE.hideStatusBar(activity2);
            }
        }
        StatusBarUtils.INSTANCE.setStatusBarBgColor(activity2, params.getBackgroundColor());
        CompletionBlock.DefaultImpls.onSuccess$default(callback, (XBaseResultModel) XBridgeKTXKt.createXModel(Reflection.getOrCreateKotlinClass(AbsXConfigureStatusBarMethodIDL.XConfigureStatusBarResultModel.class)), null, 2, null);
    }
}
