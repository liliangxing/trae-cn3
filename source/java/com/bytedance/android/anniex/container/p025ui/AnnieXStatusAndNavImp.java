package com.bytedance.android.anniex.container.p025ui;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsetsController;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import com.bytedance.android.anniex.C0840R;
import com.bytedance.android.anniex.assemble.AnnieX;
import com.bytedance.android.anniex.base.container.IContainer;
import com.bytedance.android.anniex.base.container.INavBarHost;
import com.bytedance.android.anniex.base.container.IPageContainer;
import com.bytedance.android.anniex.base.container.IStatusBarHost;
import com.bytedance.android.anniex.container.util.DigHoleScreenUtil;
import com.bytedance.android.anniex.container.util.ImmersedStatusBarUtils;
import com.bytedance.android.anniex.container.util.StatusBarUtils;
import com.bytedance.android.anniex.schema.AnnieXStatusAndNavModel;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.base.utils.logger.LoggerContext;
import com.bytedance.ies.bullet.service.base.IConditionCallKt;
import com.bytedance.ies.bullet.service.sdk.param.SoftInputMode;
import com.bytedance.ies.bullet.service.sdk.param.StringParam;
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

/* compiled from: AnnieXStatusAndNavImp.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0000\u0018\u0000 32\u00020\u00012\u00020\u0002:\u00013B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\r\u001a\u00020\u000eH\u0016J\u000e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011J\u0018\u0010\u0012\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011J\u0010\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0018\u0010\u001a\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u001b\u001a\u00020\u001cJ!\u0010\u001d\u001a\u00020\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u001cH\u0002¢\u0006\u0002\u0010\u001fJ\u0010\u0010 \u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u0019H\u0016J$\u0010\"\u001a\u00020\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010#\u001a\u00020$H\u0002JA\u0010%\u001a\u00020\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010&\u001a\u00020$2\u0006\u0010'\u001a\u00020\u00192\b\u0010(\u001a\u0004\u0018\u00010\u001c2\u0006\u0010)\u001a\u00020$2\u0006\u0010*\u001a\u00020$H\u0002¢\u0006\u0002\u0010+J\u0010\u0010,\u001a\u00020\u000e2\u0006\u0010-\u001a\u00020\u0019H\u0016J\u0010\u0010.\u001a\u00020\u000e2\u0006\u0010/\u001a\u00020\u0019H\u0016J\u0010\u00100\u001a\u00020\u000e2\u0006\u00101\u001a\u00020\u0019H\u0016J\b\u00102\u001a\u00020\u000eH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/bytedance/android/anniex/container/ui/AnnieXStatusAndNavImp;", "Lcom/bytedance/android/anniex/base/container/IStatusBarHost;", "Lcom/bytedance/android/anniex/base/container/INavBarHost;", "activity", "Landroid/app/Activity;", "container", "Lcom/bytedance/android/anniex/base/container/IContainer;", "rootView", "Landroid/view/ViewGroup;", "(Landroid/app/Activity;Lcom/bytedance/android/anniex/base/container/IContainer;Landroid/view/ViewGroup;)V", "barBackView", "Landroid/view/View;", "barCloseView", "hideNavBar", "", "initCommonTitleBar", "uiModel", "Lcom/bytedance/android/anniex/schema/AnnieXStatusAndNavModel;", "initKeyboard", "window", "Landroid/view/Window;", "initNavBar", "initStatusBarAndSystemNavBar", "setNavBarColor", "navBarColor", "", "setPopupBackViewVisibility", "visibility", "", "setStatusBarBgColor", "color", "(Landroid/app/Activity;Ljava/lang/Integer;)V", "setStatusBarColor", "statusBarColor", "setStatusBarMode", "useDarkMode", "", "setStatusBarStyle", "isLight", "statusBarMode", "statusBarBgColor", "isHideStatusBar", "isTransStatusBar", "(Landroid/app/Activity;ZLjava/lang/String;Ljava/lang/Integer;ZZ)V", "setStatusFontMode", "statusFontMode", "setTitle", "title", "setTitleColor", "titleColor", "showNavBar", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AnnieXStatusAndNavImp implements IStatusBarHost, INavBarHost {
    public static final String COLOR_DARK = "dark";
    public static final String COLOR_LIGHT = "light";
    public static final String COLOR_STRING_WHITE = "white";
    public static final String TAG = "StatusBarAndNavImp";
    private final Activity activity;
    private View barBackView;
    private View barCloseView;
    private final IContainer container;
    private final ViewGroup rootView;

    public AnnieXStatusAndNavImp(Activity activity, IContainer iContainer, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(iContainer, "container");
        Intrinsics.checkNotNullParameter(viewGroup, "rootView");
        this.activity = activity;
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
            findViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.android.anniex.container.ui.AnnieXStatusAndNavImp$initNavBar$backBtn$1$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    IContainer iContainer;
                    iContainer = AnnieXStatusAndNavImp.this.container;
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
                VectorDrawableCompat create = VectorDrawableCompat.create(this.activity.getResources(), C0840R.drawable.ic_title_bar_back_normal_vec, this.activity.getTheme());
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
        View findViewById;
        Boolean bool;
        Intrinsics.checkNotNullParameter(uiModel, "uiModel");
        this.barBackView = this.rootView.findViewById(C0840R.id.annie_x_activity_back);
        ImageView imageView = (ImageView) this.rootView.findViewById(C0840R.id.annie_x_activity_share);
        if (Intrinsics.areEqual(uiModel.getClosePositionRight().getValue(), true)) {
            findViewById = this.rootView.findViewById(C0840R.id.annie_x_activity_close);
        } else {
            findViewById = this.rootView.findViewById(C0840R.id.annie_x_activity_close_left);
        }
        this.barCloseView = findViewById;
        if (Intrinsics.areEqual(uiModel.getType().getValue(), "fullscreen") && (bool = (Boolean) uiModel.getShowBack().getValue()) != null) {
            if (!bool.booleanValue()) {
                bool = null;
            }
            if (bool != null) {
                bool.booleanValue();
                View view = this.barBackView;
                if (view != null) {
                    view.setVisibility(0);
                }
                View view2 = this.barBackView;
                if (view2 != null) {
                    view2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.android.anniex.container.ui.AnnieXStatusAndNavImp$initCommonTitleBar$2$1
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view3) {
                            IContainer iContainer;
                            iContainer = AnnieXStatusAndNavImp.this.container;
                            iContainer.goBack();
                        }
                    });
                }
            }
        }
        Integer num = (Integer) uiModel.getIconTheme().getValue();
        if (num != null && num.intValue() == 1) {
            View view3 = this.barCloseView;
            ImageView imageView2 = view3 instanceof ImageView ? (ImageView) view3 : null;
            if (imageView2 != null) {
                imageView2.setImageResource(C0840R.drawable.annie_x_title_bar_close_with_bg);
            }
        }
        Boolean bool2 = (Boolean) uiModel.getShowCloseall().getValue();
        if (bool2 != null) {
            if (!bool2.booleanValue()) {
                bool2 = null;
            }
            if (bool2 != null) {
                bool2.booleanValue();
                View view4 = this.barCloseView;
                if (view4 != null) {
                    view4.setVisibility(0);
                }
                if (view4 != null) {
                    view4.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.android.anniex.container.ui.AnnieXStatusAndNavImp$initCommonTitleBar$4$1$1
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view5) {
                            IContainer iContainer;
                            iContainer = AnnieXStatusAndNavImp.this.container;
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
                imageView.setVisibility(0);
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

    public final void setPopupBackViewVisibility(AnnieXStatusAndNavModel uiModel, int visibility) {
        StringParam type;
        if (Intrinsics.areEqual((uiModel == null || (type = uiModel.getType()) == null) ? null : (String) type.getValue(), AnnieX.CONTAINER_VIEW_TYPE_POPUP)) {
            int i = 0;
            if (!Intrinsics.areEqual(uiModel.getShowBack().getValue(), false)) {
                if (!(Intrinsics.areEqual(uiModel.getClosePositionRight().getValue(), true) ? Intrinsics.areEqual(uiModel.getShowCloseall().getValue(), true) : false) && visibility == 0) {
                    i = 8;
                }
            }
            Boolean bool = (Boolean) uiModel.getShowCloseall().getValue();
            if (bool != null) {
                if (!bool.booleanValue()) {
                    bool = null;
                }
                if (bool != null) {
                    bool.booleanValue();
                    View view = this.barCloseView;
                    if (view != null) {
                        view.setVisibility(i);
                    }
                }
            }
            Boolean bool2 = (Boolean) uiModel.getShowBack().getValue();
            if (bool2 != null) {
                Boolean bool3 = bool2.booleanValue() ? bool2 : null;
                if (bool3 != null) {
                    bool3.booleanValue();
                    View view2 = this.barBackView;
                    if (view2 != null) {
                        view2.setVisibility(visibility);
                    }
                    View view3 = this.barBackView;
                    if (view3 != null) {
                        view3.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.android.anniex.container.ui.AnnieXStatusAndNavImp$setPopupBackViewVisibility$4$1
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view4) {
                                IContainer iContainer;
                                iContainer = AnnieXStatusAndNavImp.this.container;
                                iContainer.goBack();
                            }
                        });
                    }
                }
            }
        }
    }

    public final void initStatusBarAndSystemNavBar(AnnieXStatusAndNavModel uiModel) {
        Intrinsics.checkNotNullParameter(uiModel, "uiModel");
        HybridLogger.i$default(HybridLogger.INSTANCE, "StatusBarAndNavImp", "===init status bar===", (Map) null, (LoggerContext) null, 12, (Object) null);
        Boolean bool = (Boolean) uiModel.getHideStatusBar().getValue();
        boolean booleanValue = bool != null ? bool.booleanValue() : false;
        boolean z = Intrinsics.areEqual(uiModel.getTransStatusBar().getValue(), true) || Intrinsics.areEqual(uiModel.getShouldFullScreen().getValue(), true);
        String valueToString = uiModel.getStatusFontMode().valueToString();
        if (valueToString == null) {
            valueToString = "light";
        }
        String str = valueToString;
        Activity activity = this.activity;
        Boolean bool2 = (Boolean) uiModel.isHostLight().getValue();
        setStatusBarStyle(activity, bool2 != null ? bool2.booleanValue() : false, str, (Integer) uiModel.getStatusBarBgColor().getValue(), booleanValue, z);
        if (booleanValue) {
            if (DigHoleScreenUtil.isNeedStatusBarAdapt(this.activity, false, false)) {
                StatusBarUtils.INSTANCE.setTransparencyBar(this.activity, str);
            } else {
                StatusBarUtils.INSTANCE.hideStatusBar(this.activity);
            }
        }
        if (z) {
            StatusBarUtils.INSTANCE.setTransparencyBar(this.activity, str);
        }
    }

    public final void initKeyboard(Window window, AnnieXStatusAndNavModel uiModel) {
        Intrinsics.checkNotNullParameter(uiModel, "uiModel");
        if (Intrinsics.areEqual(uiModel.getDisableInputScroll().getValue(), true)) {
            HybridLogger.i$default(HybridLogger.INSTANCE, "StatusBarAndNavImp", "disable input scroll", (Map) null, (LoggerContext) null, 12, (Object) null);
            if (window != null) {
                window.setSoftInputMode(48);
            }
        } else {
            HybridLogger.i$default(HybridLogger.INSTANCE, "StatusBarAndNavImp", "use soft input mode", (Map) null, (LoggerContext) null, 12, (Object) null);
            SoftInputMode softInputMode = (SoftInputMode) uiModel.getSoftInputMode().getValue();
            if (softInputMode != null && window != null) {
                window.setSoftInputMode(softInputMode.getSystemValue());
            }
        }
        if ((this.container instanceof IPageContainer) && IConditionCallKt.enableAnnieXPageSoftInputModeDefault() && !Intrinsics.areEqual(uiModel.getDisableInputScroll().getValue(), true) && uiModel.getSoftInputMode().getValue() == null && window != null) {
            window.setSoftInputMode(16);
        }
    }

    @Override // com.bytedance.android.anniex.base.container.IStatusBarHost
    public void setStatusBarColor(String statusBarColor) {
        Object obj;
        Intrinsics.checkNotNullParameter(statusBarColor, "statusBarColor");
        HybridLogger.i$default(HybridLogger.INSTANCE, "StatusBarAndNavImp", "===set status bar color===", (Map) null, (LoggerContext) null, 12, (Object) null);
        try {
            Result.Companion companion = Result.Companion;
            StatusBarUtil.INSTANCE.setStatusBarColor$anniex_release(this.activity, Color.parseColor(statusBarColor));
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
            Activity activity = this.activity;
            setStatusBarMode(activity, activity.getWindow(), z);
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

    private final void setStatusBarMode(Activity activity, Window window, boolean useDarkMode) {
        Object obj;
        WindowInsetsController insetsController;
        try {
            Result.Companion companion = Result.Companion;
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (activity != null && window != null) {
            if (Build.VERSION.SDK_INT >= 30 && (insetsController = window.getInsetsController()) != null) {
                if (!useDarkMode) {
                    insetsController.setSystemBarsAppearance(0, 8);
                } else {
                    insetsController.setSystemBarsAppearance(8, 8);
                }
            }
            if (OSUtils.isMIUI6Later()) {
                StatusBarUtil.INSTANCE.setMiuiStatusBarDarkMode(useDarkMode, window);
            }
            if (OSUtils.isFlymeOS4Later()) {
                FlymeOSStatusBarFontUtils.setStatusBarDarkIcon(activity, useDarkMode);
            }
            obj = Result.constructor-impl(Unit.INSTANCE);
            Throwable th2 = Result.exceptionOrNull-impl(obj);
            if (th2 != null) {
                HybridLogger.e$default(HybridLogger.INSTANCE, "StatusBarAndNavImp", "setStatusBarMode:" + th2.getMessage(), (Map) null, (LoggerContext) null, 12, (Object) null);
            }
        }
    }

    private final void setStatusBarStyle(Activity activity, boolean isLight, String statusBarMode, Integer statusBarBgColor, boolean isHideStatusBar, boolean isTransStatusBar) {
        if (activity == null) {
            HybridLogger.e$default(HybridLogger.INSTANCE, "StatusBarAndNavImp", "setStatusBarStyle: activity is null", (Map) null, (LoggerContext) null, 12, (Object) null);
            return;
        }
        if (isLight) {
            ImmersedStatusBarUtils.setStatusBarLightMode(activity);
            ImmersedStatusBarUtils.disableLayoutFullscreen(activity);
            StatusBarUtil.INSTANCE.setStatusBarColor$anniex_release(activity, Color.parseColor("white"));
            return;
        }
        if (Intrinsics.areEqual("light", statusBarMode)) {
            ImmersedStatusBarUtils.setStatusBarDarkMode(activity);
            ImmersedStatusBarUtils.disableLayoutFullscreen(activity);
        } else if (Intrinsics.areEqual("dark", statusBarMode)) {
            ImmersedStatusBarUtils.setStatusBarLightMode(activity);
            if (!isHideStatusBar && !isTransStatusBar) {
                ImmersedStatusBarUtils.disableLayoutFullscreen(activity);
            }
        }
        if (statusBarBgColor != null) {
            StatusBarUtil.INSTANCE.setStatusBarColor$anniex_release(activity, statusBarBgColor.intValue());
        }
    }

    private final void setStatusBarBgColor(Activity activity, Integer color) {
        Object obj;
        Unit unit;
        if (activity == null) {
            return;
        }
        try {
            Result.Companion companion = Result.Companion;
            if (color != null) {
                color.intValue();
                ImmersedStatusBarUtils.enableTransparentStatusBar(activity.getWindow());
                ImmersedStatusBarUtils.disableLayoutFullscreen(activity);
                ImmersedStatusBarUtils.setStatusBarColor(activity.getWindow(), color.intValue());
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
            HybridLogger.e$default(HybridLogger.INSTANCE, "StatusBarAndNavImp", "setStatusBarBgColor: " + th2.getMessage(), (Map) null, (LoggerContext) null, 12, (Object) null);
        }
    }
}
