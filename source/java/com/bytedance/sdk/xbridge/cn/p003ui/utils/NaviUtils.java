package com.bytedance.sdk.xbridge.cn.p003ui.utils;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.anniex.base.container.IContainer;
import com.bytedance.android.anniex.base.container.INavBarHost;
import com.bytedance.android.anniex.base.container.IStatusBarHost;
import com.bytedance.android.anniex.container.AnnieXPopupContainer;
import com.bytedance.android.anniex.container.util.AnnieXUtilsKt;
import com.bytedance.android.anniex.container.util.StatusBarUtils;
import com.bytedance.android.anniex.lite.container.AnnieXLiteContainer;
import com.bytedance.ies.bullet.container.popup.ui.draggable.DraggableDialog;
import com.bytedance.ies.bullet.service.popup.ui.AbsPopupDialog;
import com.bytedance.ies.bullet.service.popup.ui.AbsPopupFragment;
import com.bytedance.ies.bullet.ui.common.AbsBulletContainerActivity;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.runtime.depend.BackPressConfig;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostStyleUIDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.PageTitleBar;
import com.bytedance.sdk.xbridge.cn.runtime.depend.PopupConfig;
import com.bytedance.sdk.xbridge.cn.utils.RuntimeHelper;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NaviUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ$\u0010\u0003\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\u0007\u001a\u0004\u0018\u00010\bJE\u0010\r\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0002\u0010\u0015J$\u0010\u0016\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018J+\u0010\u0019\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0002\u0010\u001aJ\u001c\u0010\u001b\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002¨\u0006\u001c"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/ui/utils/NaviUtils;", "", "()V", "configBackPress", "", "iContainer", "Lcom/bytedance/android/anniex/base/container/IContainer;", "backPressConfig", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/BackPressConfig;", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "activity", "Landroid/app/Activity;", "configNavBarAndStatusBar", "titleBar", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/PageTitleBar;", "pageStatusFontMode", "", "pageStatusBarBgColor", "shouldFullScreen", "", "(Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;Landroid/app/Activity;Lcom/bytedance/sdk/xbridge/cn/runtime/depend/PageTitleBar;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "configPopup", "config", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/PopupConfig;", "setFullScreen", "(Landroid/app/Activity;Ljava/lang/Integer;Ljava/lang/String;)V", "setStatusBarFont", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class NaviUtils {
    public static final NaviUtils INSTANCE = new NaviUtils();

    private NaviUtils() {
    }

    public final void configPopup(IBDXBridgeContext bridgeContext, Activity activity, PopupConfig config) {
        final Integer disableMaskClickClose;
        if (config == null) {
            return;
        }
        AnnieXPopupContainer isAnnieXPopup = AnnieXUtilsKt.isAnnieXPopup(bridgeContext);
        if (isAnnieXPopup != null) {
            AnnieXPopupContainer annieXPopupContainer = isAnnieXPopup;
            Integer enablePullDownClose = config.getEnablePullDownClose();
            annieXPopupContainer.setPullDownClose(enablePullDownClose != null && enablePullDownClose.intValue() == 1);
            Integer disableMaskClickClose2 = config.getDisableMaskClickClose();
            annieXPopupContainer.setCancelable$anniex_release(disableMaskClickClose2 == null || disableMaskClickClose2.intValue() != 1);
            return;
        }
        if (activity instanceof FragmentActivity) {
            AbsPopupFragment findFragmentByTag = ((FragmentActivity) activity).getSupportFragmentManager().findFragmentByTag("BulletPopUp");
            AbsPopupFragment absPopupFragment = findFragmentByTag instanceof AbsPopupFragment ? findFragmentByTag : null;
            if (absPopupFragment == null) {
                return;
            }
            if (absPopupFragment.getDialog() instanceof DraggableDialog) {
                Integer enablePullDownClose2 = config.getEnablePullDownClose();
                boolean z = enablePullDownClose2 != null && enablePullDownClose2.intValue() == 1;
                Integer disableMaskClickClose3 = config.getDisableMaskClickClose();
                boolean z2 = disableMaskClickClose3 == null || disableMaskClickClose3.intValue() != 1;
                DraggableDialog dialog = absPopupFragment.getDialog();
                Intrinsics.checkNotNull(dialog, "null cannot be cast to non-null type com.bytedance.ies.bullet.container.popup.ui.draggable.DraggableDialog");
                DraggableDialog draggableDialog = dialog;
                draggableDialog.setCanceledOnTouchOutside(z2);
                if (z) {
                    draggableDialog.setCancelable(false);
                    draggableDialog.setCancelable(z);
                } else {
                    draggableDialog.setCancelable(true);
                    draggableDialog.setCancelable(z);
                }
            }
            if (!(absPopupFragment.getDialog() instanceof AbsPopupDialog) || (disableMaskClickClose = config.getDisableMaskClickClose()) == null) {
                return;
            }
            AbsPopupDialog dialog2 = absPopupFragment.getDialog();
            Intrinsics.checkNotNull(dialog2, "null cannot be cast to non-null type com.bytedance.ies.bullet.service.popup.ui.AbsPopupDialog");
            dialog2.setCallbackIfMaskCancel(new Function0<Boolean>() { // from class: com.bytedance.sdk.xbridge.cn.ui.utils.NaviUtils$configPopup$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                public final Boolean m916invoke() {
                    Integer num = disableMaskClickClose;
                    return Boolean.valueOf(num != null && num.intValue() == 0);
                }
            });
        }
    }

    public final void configBackPress(IBDXBridgeContext bridgeContext, Activity activity, BackPressConfig backPressConfig) {
        Integer disableBackPress;
        if (backPressConfig == null || (disableBackPress = backPressConfig.getDisableBackPress()) == null) {
            return;
        }
        int intValue = disableBackPress.intValue();
        IContainer isAnnieXPage = AnnieXUtilsKt.isAnnieXPage(bridgeContext);
        if (isAnnieXPage != null) {
            isAnnieXPage.interceptBackPress(intValue == 1);
        } else if (activity instanceof AbsBulletContainerActivity) {
            ((AbsBulletContainerActivity) activity).setCanBack(intValue != 1);
        }
    }

    public final void configBackPress(IContainer iContainer, BackPressConfig backPressConfig) {
        Integer disableBackPress;
        if (iContainer instanceof AnnieXLiteContainer) {
            boolean z = false;
            if (backPressConfig != null && (disableBackPress = backPressConfig.getDisableBackPress()) != null && disableBackPress.intValue() == 1) {
                z = true;
            }
            iContainer.interceptBackPress(z);
        }
    }

    public final void configNavBarAndStatusBar(IBDXBridgeContext bridgeContext, Activity activity, PageTitleBar titleBar, String pageStatusFontMode, String pageStatusBarBgColor, Integer shouldFullScreen) {
        Intrinsics.checkNotNullParameter(titleBar, "titleBar");
        INavBarHost isAnnieXPage = AnnieXUtilsKt.isAnnieXPage(bridgeContext);
        if (isAnnieXPage != null) {
            if (isAnnieXPage instanceof INavBarHost) {
                INavBarHost iNavBarHost = isAnnieXPage;
                String title = titleBar.getTitle();
                if (title != null) {
                    iNavBarHost.setTitle(title);
                }
                String titleColor = titleBar.getTitleColor();
                if (titleColor != null) {
                    iNavBarHost.setTitleColor(titleColor);
                }
                String navBarColor = titleBar.getNavBarColor();
                if (navBarColor != null) {
                    iNavBarHost.setNavBarColor(navBarColor);
                }
            }
            if (isAnnieXPage instanceof IStatusBarHost) {
                IStatusBarHost iStatusBarHost = (IStatusBarHost) isAnnieXPage;
                if (pageStatusFontMode != null) {
                    iStatusBarHost.setStatusFontMode(pageStatusFontMode);
                }
                if (pageStatusBarBgColor != null) {
                    iStatusBarHost.setStatusBarColor(pageStatusBarBgColor);
                }
            }
            INSTANCE.setFullScreen(activity, shouldFullScreen, pageStatusFontMode);
            return;
        }
        IStatusBarHost isAnnieXPopup = AnnieXUtilsKt.isAnnieXPopup(bridgeContext);
        if (isAnnieXPopup != null) {
            if (isAnnieXPopup instanceof IStatusBarHost) {
                IStatusBarHost iStatusBarHost2 = isAnnieXPopup;
                if (pageStatusFontMode != null) {
                    iStatusBarHost2.setStatusFontMode(pageStatusFontMode);
                }
                if (pageStatusBarBgColor != null) {
                    iStatusBarHost2.setStatusBarColor(pageStatusBarBgColor);
                    return;
                }
                return;
            }
            return;
        }
        setStatusBarFont(activity, pageStatusFontMode);
        StatusBarUtils.INSTANCE.setStatusBarBgColor(activity, pageStatusBarBgColor);
        IHostStyleUIDepend uIDependInstance = bridgeContext != null ? RuntimeHelper.INSTANCE.getUIDependInstance(bridgeContext) : null;
        if (uIDependInstance != null) {
            uIDependInstance.setPageNaviStyle(bridgeContext, activity, titleBar);
        }
        setFullScreen(activity, shouldFullScreen, pageStatusFontMode);
    }

    private final void setFullScreen(Activity activity, Integer shouldFullScreen, String pageStatusFontMode) {
        if (activity != null) {
            if (shouldFullScreen != null && shouldFullScreen.intValue() == 1) {
                StatusBarUtils.INSTANCE.setTransparencyBar(activity, pageStatusFontMode);
            } else if (shouldFullScreen != null && shouldFullScreen.intValue() == 0) {
                StatusBarUtils.INSTANCE.quitTransparencyBar(activity, pageStatusFontMode);
            }
        }
    }

    private final void setStatusBarFont(Activity activity, String pageStatusFontMode) {
        if (pageStatusFontMode != null) {
            StatusBarUtils.INSTANCE.trySetStatusBar(activity, activity != null ? activity.getWindow() : null, Intrinsics.areEqual("dark", pageStatusFontMode));
        }
    }
}
