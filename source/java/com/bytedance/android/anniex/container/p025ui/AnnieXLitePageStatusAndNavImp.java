package com.bytedance.android.anniex.container.p025ui;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import com.bytedance.android.anniex.C0840R;
import com.bytedance.android.anniex.base.container.IContainer;
import com.bytedance.android.anniex.base.container.INavBarHost;
import com.bytedance.android.anniex.base.container.IStatusBarHost;
import com.bytedance.android.anniex.container.util.DigHoleScreenUtil;
import com.bytedance.android.anniex.container.util.ImmersedStatusBarUtils;
import com.bytedance.android.anniex.container.util.StatusBarUtils;
import com.bytedance.android.anniex.schema.AnnieXStatusAndNavModel;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.base.utils.logger.LoggerContext;
import com.bytedance.ies.bullet.service.sdk.param.SoftInputMode;
import com.bytedance.ies.bullet.ui.common.utils.StatusBarUtil;
import com.bytedance.ies.bullet.ui.common.view.AutoRTLImageView;
import com.gyf.barlibrary.FlymeOSStatusBarFontUtils;
import com.gyf.barlibrary.OSUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnnieXLitePageStatusAndNavImp.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\f\b\u0000\u0018\u0000 )2\u00020\u00012\u00020\u0002:\u0001)B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\u000bH\u0016J\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eJ\u0018\u0010\u000f\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eJ\u0010\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0014H\u0016J\u0018\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J?\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u00142\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u0019H\u0002¢\u0006\u0002\u0010!J\u0010\u0010\"\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\u0014H\u0016J\u0010\u0010$\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\u0014H\u0016J\u0010\u0010&\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020\u0014H\u0016J\b\u0010(\u001a\u00020\u000bH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/bytedance/android/anniex/container/ui/AnnieXLitePageStatusAndNavImp;", "Lcom/bytedance/android/anniex/base/container/IStatusBarHost;", "Lcom/bytedance/android/anniex/base/container/INavBarHost;", "window", "Landroid/view/Window;", "container", "Lcom/bytedance/android/anniex/base/container/IContainer;", "rootView", "Landroid/view/ViewGroup;", "(Landroid/view/Window;Lcom/bytedance/android/anniex/base/container/IContainer;Landroid/view/ViewGroup;)V", "hideNavBar", "", "initCommonTitleBar", "uiModel", "Lcom/bytedance/android/anniex/schema/AnnieXStatusAndNavModel;", "initKeyboard", "initNavBar", "initStatusBarAndSystemNavBar", "setNavBarColor", "navBarColor", "", "setStatusBarColor", "statusBarColor", "setStatusBarMode", "useDarkMode", "", "setStatusBarStyle", "isLight", "statusBarMode", "statusBarBgColor", "", "isHideStatusBar", "isTransStatusBar", "(Landroid/view/Window;ZLjava/lang/String;Ljava/lang/Integer;ZZ)V", "setStatusFontMode", "statusFontMode", "setTitle", "title", "setTitleColor", "titleColor", "showNavBar", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AnnieXLitePageStatusAndNavImp implements IStatusBarHost, INavBarHost {
    public static final String COLOR_DARK = "dark";
    public static final String COLOR_LIGHT = "light";
    public static final String COLOR_STRING_WHITE = "white";
    public static final String TAG = "StatusBarAndNavImp";
    private final IContainer container;
    private final ViewGroup rootView;
    private final Window window;

    public AnnieXLitePageStatusAndNavImp(Window window, IContainer iContainer, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(window, "window");
        Intrinsics.checkNotNullParameter(iContainer, "container");
        Intrinsics.checkNotNullParameter(viewGroup, "rootView");
        this.window = window;
        this.container = iContainer;
        this.rootView = viewGroup;
    }

    public final void initNavBar(AnnieXStatusAndNavModel uiModel) {
        Intrinsics.checkNotNullParameter(uiModel, "uiModel");
        HybridLogger.i$default(HybridLogger.INSTANCE, "StatusBarAndNavImp", "init navigation bar", (Map) null, (LoggerContext) null, 12, (Object) null);
        if (Intrinsics.areEqual(uiModel.getHideNavBar().getValue(), true)) {
            hideNavBar();
            return;
        }
        showNavBar();
        Integer num = (Integer) uiModel.getNavBarColor().getValue();
        if (num != null) {
            int intValue = num.intValue();
            View findViewById = this.rootView.findViewById(C0840R.id.annie_x_title_bar);
            if (findViewById != null) {
                findViewById.setBackgroundColor(intValue);
            }
        }
        String str = (String) uiModel.getTitle().getValue();
        if (str != null) {
            setTitle(str);
        }
        AutoRTLImageView findViewById2 = this.rootView.findViewById(C0840R.id.annie_x_title_btn_back);
        VectorDrawableCompat vectorDrawableCompat = null;
        if (findViewById2 != null) {
            findViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.android.anniex.container.ui.AnnieXLitePageStatusAndNavImp$initNavBar$backBtn$1$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    IContainer iContainer;
                    iContainer = AnnieXLitePageStatusAndNavImp.this.container;
                    iContainer.goBack();
                }
            });
        } else {
            findViewById2 = null;
        }
        Integer num2 = (Integer) uiModel.getTitleColor().getValue();
        if (num2 != null) {
            int intValue2 = num2.intValue();
            TextView textView = (TextView) this.rootView.findViewById(C0840R.id.annie_x_title_text);
            if (textView != null) {
                textView.setTextColor(intValue2);
            }
            if (findViewById2 != null) {
                VectorDrawableCompat create = VectorDrawableCompat.create(this.window.getContext().getResources(), C0840R.drawable.ic_title_bar_back_normal_vec, this.window.getContext().getTheme());
                if (create != null) {
                    create.setTint(intValue2);
                    vectorDrawableCompat = create;
                }
                findViewById2.setImageDrawable(vectorDrawableCompat);
            }
        }
    }

    @Override // com.bytedance.android.anniex.base.container.INavBarHost
    public void hideNavBar() {
        HybridLogger.i$default(HybridLogger.INSTANCE, "StatusBarAndNavImp", "hide navigation bar", (Map) null, (LoggerContext) null, 12, (Object) null);
        View findViewById = this.rootView.findViewById(C0840R.id.annie_x_title_bar);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
        View findViewById2 = this.rootView.findViewById(C0840R.id.annie_x_title_placeholder);
        if (findViewById2 == null) {
            return;
        }
        findViewById2.setVisibility(8);
    }

    @Override // com.bytedance.android.anniex.base.container.INavBarHost
    public void showNavBar() {
        HybridLogger.i$default(HybridLogger.INSTANCE, "StatusBarAndNavImp", "show navigation bar", (Map) null, (LoggerContext) null, 12, (Object) null);
        View findViewById = this.rootView.findViewById(C0840R.id.annie_x_title_bar);
        if (findViewById != null) {
            findViewById.setVisibility(0);
        }
        View findViewById2 = this.rootView.findViewById(C0840R.id.annie_x_title_placeholder);
        if (findViewById2 == null) {
            return;
        }
        findViewById2.setVisibility(0);
    }

    @Override // com.bytedance.android.anniex.base.container.INavBarHost
    public void setNavBarColor(String navBarColor) {
        Object obj;
        Unit unit;
        Intrinsics.checkNotNullParameter(navBarColor, "navBarColor");
        HybridLogger.i$default(HybridLogger.INSTANCE, "StatusBarAndNavImp", "set navigation bar color", (Map) null, (LoggerContext) null, 12, (Object) null);
        try {
            Result.Companion companion = Result.Companion;
            View findViewById = this.rootView.findViewById(C0840R.id.annie_x_title_bar);
            if (findViewById != null) {
                findViewById.setBackgroundColor(Color.parseColor(navBarColor));
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            obj = Result.constructor-impl(unit);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable th2 = Result.exceptionOrNull-impl(obj);
        if (th2 != null) {
            HybridLogger.e$default(HybridLogger.INSTANCE, "StatusBarAndNavImp", "setNavBarColor :" + th2.getMessage(), (Map) null, (LoggerContext) null, 12, (Object) null);
        }
    }

    public final void initCommonTitleBar(AnnieXStatusAndNavModel uiModel) {
        ImageView imageView;
        Boolean bool;
        Intrinsics.checkNotNullParameter(uiModel, "uiModel");
        ImageView imageView2 = (ImageView) this.rootView.findViewById(C0840R.id.annie_x_activity_back);
        ImageView imageView3 = (ImageView) this.rootView.findViewById(C0840R.id.annie_x_activity_share);
        if (Intrinsics.areEqual(uiModel.getClosePositionRight().getValue(), true)) {
            imageView = (ImageView) this.rootView.findViewById(C0840R.id.annie_x_activity_close);
        } else {
            imageView = (ImageView) this.rootView.findViewById(C0840R.id.annie_x_activity_close_left);
        }
        if (Intrinsics.areEqual(uiModel.getType().getValue(), "fullscreen") && (bool = (Boolean) uiModel.getShowBack().getValue()) != null) {
            if (!bool.booleanValue()) {
                bool = null;
            }
            if (bool != null) {
                bool.booleanValue();
                imageView2.setVisibility(0);
                imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.android.anniex.container.ui.AnnieXLitePageStatusAndNavImp$initCommonTitleBar$2$1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        IContainer iContainer;
                        iContainer = AnnieXLitePageStatusAndNavImp.this.container;
                        iContainer.goBack();
                    }
                });
            }
        }
        Integer num = (Integer) uiModel.getIconTheme().getValue();
        if (num != null && num.intValue() == 1) {
            imageView.setImageResource(C0840R.drawable.annie_x_title_bar_close_with_bg);
        }
        Boolean bool2 = (Boolean) uiModel.getShowCloseall().getValue();
        if (bool2 != null) {
            if (!bool2.booleanValue()) {
                bool2 = null;
            }
            if (bool2 != null) {
                bool2.booleanValue();
                if (imageView != null) {
                    imageView.setVisibility(0);
                }
                if (imageView != null) {
                    imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.android.anniex.container.ui.AnnieXLitePageStatusAndNavImp$initCommonTitleBar$4$1$1
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            IContainer iContainer;
                            iContainer = AnnieXLitePageStatusAndNavImp.this.container;
                            iContainer.close();
                        }
                    });
                }
            }
        }
        Boolean bool3 = (Boolean) uiModel.getEnableShare().getValue();
        if (bool3 != null) {
            Boolean bool4 = bool3.booleanValue() ? bool3 : null;
            if (bool4 != null) {
                bool4.booleanValue();
                imageView3.setVisibility(0);
            }
        }
    }

    @Override // com.bytedance.android.anniex.base.container.INavBarHost
    public void setTitle(String title) {
        Intrinsics.checkNotNullParameter(title, "title");
        HybridLogger.i$default(HybridLogger.INSTANCE, "StatusBarAndNavImp", "set title", (Map) null, (LoggerContext) null, 12, (Object) null);
        TextView textView = (TextView) this.rootView.findViewById(C0840R.id.annie_x_title_text);
        if (textView == null) {
            return;
        }
        textView.setText(title);
    }

    @Override // com.bytedance.android.anniex.base.container.INavBarHost
    public void setTitleColor(String titleColor) {
        Object obj;
        Unit unit;
        Intrinsics.checkNotNullParameter(titleColor, "titleColor");
        HybridLogger.i$default(HybridLogger.INSTANCE, "StatusBarAndNavImp", "set title color", (Map) null, (LoggerContext) null, 12, (Object) null);
        try {
            Result.Companion companion = Result.Companion;
            TextView textView = (TextView) this.rootView.findViewById(C0840R.id.annie_x_title_text);
            if (textView != null) {
                textView.setTextColor(Color.parseColor(titleColor));
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            obj = Result.constructor-impl(unit);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable th2 = Result.exceptionOrNull-impl(obj);
        if (th2 != null) {
            HybridLogger.e$default(HybridLogger.INSTANCE, "StatusBarAndNavImp", "setTitleColor :" + th2.getMessage(), (Map) null, (LoggerContext) null, 12, (Object) null);
        }
    }

    public final void initStatusBarAndSystemNavBar(AnnieXStatusAndNavModel uiModel) {
        Intrinsics.checkNotNullParameter(uiModel, "uiModel");
        HybridLogger.i$default(HybridLogger.INSTANCE, "StatusBarAndNavImp", "===init status bar===", (Map) null, (LoggerContext) null, 12, (Object) null);
        Boolean bool = (Boolean) uiModel.getHideStatusBar().getValue();
        boolean booleanValue = bool != null ? bool.booleanValue() : false;
        Boolean bool2 = (Boolean) uiModel.getTransStatusBar().getValue();
        boolean booleanValue2 = bool2 != null ? bool2.booleanValue() : false;
        String valueToString = uiModel.getStatusFontMode().valueToString();
        if (valueToString == null) {
            valueToString = "light";
        }
        String str = valueToString;
        Window window = this.window;
        Boolean bool3 = (Boolean) uiModel.isHostLight().getValue();
        setStatusBarStyle(window, bool3 != null ? bool3.booleanValue() : false, str, (Integer) uiModel.getStatusBarBgColor().getValue(), booleanValue, booleanValue2);
        if (booleanValue) {
            if (DigHoleScreenUtil.isNeedStatusBarAdapt(this.window.getContext(), false, false)) {
                StatusBarUtils.INSTANCE.setTransparencyBar(this.window, str);
            } else {
                StatusBarUtils.INSTANCE.hideStatusBar(this.window);
            }
        }
        if (booleanValue2) {
            StatusBarUtils.INSTANCE.setTransparencyBar(this.window, str);
        }
    }

    public final void initKeyboard(Window window, AnnieXStatusAndNavModel uiModel) {
        Intrinsics.checkNotNullParameter(uiModel, "uiModel");
        if (Intrinsics.areEqual(uiModel.getDisableInputScroll().getValue(), true)) {
            HybridLogger.i$default(HybridLogger.INSTANCE, "StatusBarAndNavImp", "disable input scroll", (Map) null, (LoggerContext) null, 12, (Object) null);
            if (window != null) {
                window.setSoftInputMode(48);
                return;
            }
            return;
        }
        HybridLogger.i$default(HybridLogger.INSTANCE, "StatusBarAndNavImp", "use soft input mode", (Map) null, (LoggerContext) null, 12, (Object) null);
        SoftInputMode softInputMode = (SoftInputMode) uiModel.getSoftInputMode().getValue();
        if (softInputMode == null || window == null) {
            return;
        }
        window.setSoftInputMode(softInputMode.getSystemValue());
    }

    @Override // com.bytedance.android.anniex.base.container.IStatusBarHost
    public void setStatusBarColor(String statusBarColor) {
        Object obj;
        Intrinsics.checkNotNullParameter(statusBarColor, "statusBarColor");
        HybridLogger.i$default(HybridLogger.INSTANCE, "StatusBarAndNavImp", "===set status bar color===", (Map) null, (LoggerContext) null, 12, (Object) null);
        try {
            Result.Companion companion = Result.Companion;
            StatusBarUtil.INSTANCE.setStatusBarColor$anniex_release(this.window, Color.parseColor(statusBarColor));
            obj = Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable th2 = Result.exceptionOrNull-impl(obj);
        if (th2 != null) {
            HybridLogger.e$default(HybridLogger.INSTANCE, "StatusBarAndNavImp", "setStatusBarColor :" + th2.getMessage(), (Map) null, (LoggerContext) null, 12, (Object) null);
        }
    }

    @Override // com.bytedance.android.anniex.base.container.IStatusBarHost
    public void setStatusFontMode(String statusFontMode) {
        Object obj;
        boolean z;
        Intrinsics.checkNotNullParameter(statusFontMode, "statusFontMode");
        HybridLogger.i$default(HybridLogger.INSTANCE, "StatusBarAndNavImp", "===set status font mode===", (Map) null, (LoggerContext) null, 12, (Object) null);
        try {
            Result.Companion companion = Result.Companion;
            if (Intrinsics.areEqual(statusFontMode, "dark")) {
                z = true;
            } else {
                Intrinsics.areEqual(statusFontMode, "light");
                z = false;
            }
            setStatusBarMode(this.window, z);
            obj = Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable th2 = Result.exceptionOrNull-impl(obj);
        if (th2 != null) {
            HybridLogger.e$default(HybridLogger.INSTANCE, "StatusBarAndNavImp", "setStatusFontMode :" + th2.getMessage(), (Map) null, (LoggerContext) null, 12, (Object) null);
        }
    }

    private final void setStatusBarMode(Window window, boolean useDarkMode) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            View decorView = window.getDecorView();
            Intrinsics.checkNotNullExpressionValue(decorView, "window.decorView");
            int systemUiVisibility = decorView.getSystemUiVisibility();
            if (!useDarkMode) {
                decorView.setSystemUiVisibility(systemUiVisibility & (-8193));
            } else {
                decorView.setSystemUiVisibility(systemUiVisibility | 8192);
            }
            window.clearFlags(AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL);
            window.addFlags(Integer.MIN_VALUE);
            if (OSUtils.isMIUI6Later()) {
                StatusBarUtil.INSTANCE.setMiuiStatusBarDarkMode(useDarkMode, window);
            }
            if (OSUtils.isFlymeOS4Later()) {
                FlymeOSStatusBarFontUtils.setStatusBarDarkIcon(window, useDarkMode);
            }
            obj = Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable th2 = Result.exceptionOrNull-impl(obj);
        if (th2 != null) {
            HybridLogger.e$default(HybridLogger.INSTANCE, "StatusBarAndNavImp", "setStatusBarMode:" + th2.getMessage(), (Map) null, (LoggerContext) null, 12, (Object) null);
        }
    }

    private final void setStatusBarStyle(Window window, boolean isLight, String statusBarMode, Integer statusBarBgColor, boolean isHideStatusBar, boolean isTransStatusBar) {
        if (isLight) {
            ImmersedStatusBarUtils.setStatusBarLightMode(window);
            ImmersedStatusBarUtils.disableLayoutFullscreen(window);
            StatusBarUtil.INSTANCE.setStatusBarBgColor(window, Integer.valueOf(Color.parseColor("white")));
            return;
        }
        if (Intrinsics.areEqual("light", statusBarMode)) {
            ImmersedStatusBarUtils.setStatusBarDarkMode(window);
            ImmersedStatusBarUtils.disableLayoutFullscreen(window);
        } else if (Intrinsics.areEqual("dark", statusBarMode)) {
            ImmersedStatusBarUtils.setStatusBarLightMode(window);
            if (!isHideStatusBar && !isTransStatusBar) {
                ImmersedStatusBarUtils.disableLayoutFullscreen(window);
            }
        }
        StatusBarUtil.INSTANCE.setStatusBarBgColor(window, statusBarBgColor);
    }
}
