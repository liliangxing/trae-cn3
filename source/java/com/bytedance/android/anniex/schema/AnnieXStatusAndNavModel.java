package com.bytedance.android.anniex.schema;

import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.bytedance.ies.bullet.service.base.IConditionCallKt;
import com.bytedance.ies.bullet.service.schema.ISchemaData;
import com.bytedance.ies.bullet.service.schema.ISchemaModel;
import com.bytedance.ies.bullet.service.sdk.param.BooleanParam;
import com.bytedance.ies.bullet.service.sdk.param.IntegerParam;
import com.bytedance.ies.bullet.service.sdk.param.NavBtnParam;
import com.bytedance.ies.bullet.service.sdk.param.NavBtnType;
import com.bytedance.ies.bullet.service.sdk.param.SoftInputMode;
import com.bytedance.ies.bullet.service.sdk.param.SoftInputModeParam;
import com.bytedance.ies.bullet.service.sdk.param.StatusFontMode;
import com.bytedance.ies.bullet.service.sdk.param.StatusFontModeParam;
import com.bytedance.ies.bullet.service.sdk.param.StringParam;
import com.bytedance.ies.bullet.service.sdk.param.UIColorParam;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnnieXStatusAndNavModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010a\u001a\u00020b2\u0006\u0010c\u001a\u00020dH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001a\u0010\u0018\u001a\u00020\u0019X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0006\"\u0004\b\u001f\u0010\bR\u001a\u0010 \u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0006\"\u0004\b!\u0010\bR\u001a\u0010\"\u001a\u00020#X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020)X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001a\u0010.\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0006\"\u0004\b0\u0010\bR\u001a\u00101\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0006\"\u0004\b3\u0010\bR\u001a\u00104\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0006\"\u0004\b6\u0010\bR\u001a\u00107\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0006\"\u0004\b9\u0010\bR\u001a\u0010:\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u0006\"\u0004\b<\u0010\bR\u001a\u0010=\u001a\u00020>X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u001a\u0010C\u001a\u00020#X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010%\"\u0004\bE\u0010'R\u001a\u0010F\u001a\u00020GX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u001a\u0010L\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010\u0006\"\u0004\bN\u0010\bR\u001a\u0010O\u001a\u00020PX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\u001a\u0010U\u001a\u00020\u0019X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010\u001b\"\u0004\bW\u0010\u001dR\u001a\u0010X\u001a\u00020#X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010%\"\u0004\bZ\u0010'R\u001a\u0010[\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010\u0006\"\u0004\b]\u0010\bR\u001a\u0010^\u001a\u00020PX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010R\"\u0004\b`\u0010T¨\u0006e"}, d2 = {"Lcom/bytedance/android/anniex/schema/AnnieXStatusAndNavModel;", "Lcom/bytedance/ies/bullet/service/schema/ISchemaModel;", "()V", "closePositionRight", "Lcom/bytedance/ies/bullet/service/sdk/param/BooleanParam;", "getClosePositionRight", "()Lcom/bytedance/ies/bullet/service/sdk/param/BooleanParam;", "setClosePositionRight", "(Lcom/bytedance/ies/bullet/service/sdk/param/BooleanParam;)V", "disableInputScroll", "getDisableInputScroll", "setDisableInputScroll", "enableShare", "getEnableShare", "setEnableShare", "hideBack", "getHideBack", "setHideBack", "hideNavBar", "getHideNavBar", "setHideNavBar", "hideStatusBar", "getHideStatusBar", "setHideStatusBar", "iconTheme", "Lcom/bytedance/ies/bullet/service/sdk/param/IntegerParam;", "getIconTheme", "()Lcom/bytedance/ies/bullet/service/sdk/param/IntegerParam;", "setIconTheme", "(Lcom/bytedance/ies/bullet/service/sdk/param/IntegerParam;)V", "isAdjustPan", "setAdjustPan", "isHostLight", "setHostLight", "navBarColor", "Lcom/bytedance/ies/bullet/service/sdk/param/UIColorParam;", "getNavBarColor", "()Lcom/bytedance/ies/bullet/service/sdk/param/UIColorParam;", "setNavBarColor", "(Lcom/bytedance/ies/bullet/service/sdk/param/UIColorParam;)V", "navBtnType", "Lcom/bytedance/ies/bullet/service/sdk/param/NavBtnParam;", "getNavBtnType", "()Lcom/bytedance/ies/bullet/service/sdk/param/NavBtnParam;", "setNavBtnType", "(Lcom/bytedance/ies/bullet/service/sdk/param/NavBtnParam;)V", "shouldFullScreen", "getShouldFullScreen", "setShouldFullScreen", "showBack", "getShowBack", "setShowBack", "showCloseall", "getShowCloseall", "setShowCloseall", "showClosealways", "getShowClosealways", "setShowClosealways", "showMoreButton", "getShowMoreButton", "setShowMoreButton", "softInputMode", "Lcom/bytedance/ies/bullet/service/sdk/param/SoftInputModeParam;", "getSoftInputMode", "()Lcom/bytedance/ies/bullet/service/sdk/param/SoftInputModeParam;", "setSoftInputMode", "(Lcom/bytedance/ies/bullet/service/sdk/param/SoftInputModeParam;)V", "statusBarBgColor", "getStatusBarBgColor", "setStatusBarBgColor", "statusFontMode", "Lcom/bytedance/ies/bullet/service/sdk/param/StatusFontModeParam;", "getStatusFontMode", "()Lcom/bytedance/ies/bullet/service/sdk/param/StatusFontModeParam;", "setStatusFontMode", "(Lcom/bytedance/ies/bullet/service/sdk/param/StatusFontModeParam;)V", "supportExchangeTheme", "getSupportExchangeTheme", "setSupportExchangeTheme", "title", "Lcom/bytedance/ies/bullet/service/sdk/param/StringParam;", "getTitle", "()Lcom/bytedance/ies/bullet/service/sdk/param/StringParam;", "setTitle", "(Lcom/bytedance/ies/bullet/service/sdk/param/StringParam;)V", "titleBarStyle", "getTitleBarStyle", "setTitleBarStyle", "titleColor", "getTitleColor", "setTitleColor", "transStatusBar", "getTransStatusBar", "setTransStatusBar", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "getType", "setType", "initWithData", "", "schemaData", "Lcom/bytedance/ies/bullet/service/schema/ISchemaData;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AnnieXStatusAndNavModel implements ISchemaModel {
    public BooleanParam closePositionRight;
    public BooleanParam disableInputScroll;
    public BooleanParam enableShare;
    public BooleanParam hideBack;
    public BooleanParam hideNavBar;
    public BooleanParam hideStatusBar;
    public IntegerParam iconTheme;
    public BooleanParam isAdjustPan;
    public BooleanParam isHostLight;
    public UIColorParam navBarColor;
    public NavBtnParam navBtnType;
    public BooleanParam shouldFullScreen;
    public BooleanParam showBack;
    public BooleanParam showCloseall;
    public BooleanParam showClosealways;
    public BooleanParam showMoreButton;
    public SoftInputModeParam softInputMode;
    public UIColorParam statusBarBgColor;
    public StatusFontModeParam statusFontMode;
    public BooleanParam supportExchangeTheme;
    public StringParam title;
    public IntegerParam titleBarStyle;
    public UIColorParam titleColor;
    public BooleanParam transStatusBar;
    public StringParam type;

    public final BooleanParam getDisableInputScroll() {
        BooleanParam booleanParam = this.disableInputScroll;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("disableInputScroll");
        return null;
    }

    public final void setDisableInputScroll(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.disableInputScroll = booleanParam;
    }

    public final StringParam getType() {
        StringParam stringParam = this.type;
        if (stringParam != null) {
            return stringParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
        return null;
    }

    public final void setType(StringParam stringParam) {
        Intrinsics.checkNotNullParameter(stringParam, "<set-?>");
        this.type = stringParam;
    }

    public final BooleanParam getHideBack() {
        BooleanParam booleanParam = this.hideBack;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("hideBack");
        return null;
    }

    public final void setHideBack(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.hideBack = booleanParam;
    }

    public final BooleanParam getShowMoreButton() {
        BooleanParam booleanParam = this.showMoreButton;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("showMoreButton");
        return null;
    }

    public final void setShowMoreButton(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.showMoreButton = booleanParam;
    }

    public final IntegerParam getTitleBarStyle() {
        IntegerParam integerParam = this.titleBarStyle;
        if (integerParam != null) {
            return integerParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("titleBarStyle");
        return null;
    }

    public final void setTitleBarStyle(IntegerParam integerParam) {
        Intrinsics.checkNotNullParameter(integerParam, "<set-?>");
        this.titleBarStyle = integerParam;
    }

    public final BooleanParam getHideNavBar() {
        BooleanParam booleanParam = this.hideNavBar;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("hideNavBar");
        return null;
    }

    public final void setHideNavBar(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.hideNavBar = booleanParam;
    }

    public final BooleanParam getHideStatusBar() {
        BooleanParam booleanParam = this.hideStatusBar;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("hideStatusBar");
        return null;
    }

    public final void setHideStatusBar(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.hideStatusBar = booleanParam;
    }

    public final UIColorParam getNavBarColor() {
        UIColorParam uIColorParam = this.navBarColor;
        if (uIColorParam != null) {
            return uIColorParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("navBarColor");
        return null;
    }

    public final void setNavBarColor(UIColorParam uIColorParam) {
        Intrinsics.checkNotNullParameter(uIColorParam, "<set-?>");
        this.navBarColor = uIColorParam;
    }

    public final NavBtnParam getNavBtnType() {
        NavBtnParam navBtnParam = this.navBtnType;
        if (navBtnParam != null) {
            return navBtnParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("navBtnType");
        return null;
    }

    public final void setNavBtnType(NavBtnParam navBtnParam) {
        Intrinsics.checkNotNullParameter(navBtnParam, "<set-?>");
        this.navBtnType = navBtnParam;
    }

    public final BooleanParam getShowCloseall() {
        BooleanParam booleanParam = this.showCloseall;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("showCloseall");
        return null;
    }

    public final void setShowCloseall(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.showCloseall = booleanParam;
    }

    public final BooleanParam getShowClosealways() {
        BooleanParam booleanParam = this.showClosealways;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("showClosealways");
        return null;
    }

    public final void setShowClosealways(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.showClosealways = booleanParam;
    }

    public final SoftInputModeParam getSoftInputMode() {
        SoftInputModeParam softInputModeParam = this.softInputMode;
        if (softInputModeParam != null) {
            return softInputModeParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("softInputMode");
        return null;
    }

    public final void setSoftInputMode(SoftInputModeParam softInputModeParam) {
        Intrinsics.checkNotNullParameter(softInputModeParam, "<set-?>");
        this.softInputMode = softInputModeParam;
    }

    public final UIColorParam getStatusBarBgColor() {
        UIColorParam uIColorParam = this.statusBarBgColor;
        if (uIColorParam != null) {
            return uIColorParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("statusBarBgColor");
        return null;
    }

    public final void setStatusBarBgColor(UIColorParam uIColorParam) {
        Intrinsics.checkNotNullParameter(uIColorParam, "<set-?>");
        this.statusBarBgColor = uIColorParam;
    }

    public final StatusFontModeParam getStatusFontMode() {
        StatusFontModeParam statusFontModeParam = this.statusFontMode;
        if (statusFontModeParam != null) {
            return statusFontModeParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("statusFontMode");
        return null;
    }

    public final void setStatusFontMode(StatusFontModeParam statusFontModeParam) {
        Intrinsics.checkNotNullParameter(statusFontModeParam, "<set-?>");
        this.statusFontMode = statusFontModeParam;
    }

    public final StringParam getTitle() {
        StringParam stringParam = this.title;
        if (stringParam != null) {
            return stringParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("title");
        return null;
    }

    public final void setTitle(StringParam stringParam) {
        Intrinsics.checkNotNullParameter(stringParam, "<set-?>");
        this.title = stringParam;
    }

    public final UIColorParam getTitleColor() {
        UIColorParam uIColorParam = this.titleColor;
        if (uIColorParam != null) {
            return uIColorParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("titleColor");
        return null;
    }

    public final void setTitleColor(UIColorParam uIColorParam) {
        Intrinsics.checkNotNullParameter(uIColorParam, "<set-?>");
        this.titleColor = uIColorParam;
    }

    public final BooleanParam getTransStatusBar() {
        BooleanParam booleanParam = this.transStatusBar;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("transStatusBar");
        return null;
    }

    public final void setTransStatusBar(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.transStatusBar = booleanParam;
    }

    public final BooleanParam getShouldFullScreen() {
        BooleanParam booleanParam = this.shouldFullScreen;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("shouldFullScreen");
        return null;
    }

    public final void setShouldFullScreen(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.shouldFullScreen = booleanParam;
    }

    public final BooleanParam getSupportExchangeTheme() {
        BooleanParam booleanParam = this.supportExchangeTheme;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("supportExchangeTheme");
        return null;
    }

    public final void setSupportExchangeTheme(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.supportExchangeTheme = booleanParam;
    }

    public final BooleanParam isAdjustPan() {
        BooleanParam booleanParam = this.isAdjustPan;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("isAdjustPan");
        return null;
    }

    public final void setAdjustPan(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.isAdjustPan = booleanParam;
    }

    public final BooleanParam getShowBack() {
        BooleanParam booleanParam = this.showBack;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("showBack");
        return null;
    }

    public final void setShowBack(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.showBack = booleanParam;
    }

    public final BooleanParam getEnableShare() {
        BooleanParam booleanParam = this.enableShare;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("enableShare");
        return null;
    }

    public final void setEnableShare(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.enableShare = booleanParam;
    }

    public final IntegerParam getIconTheme() {
        IntegerParam integerParam = this.iconTheme;
        if (integerParam != null) {
            return integerParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("iconTheme");
        return null;
    }

    public final void setIconTheme(IntegerParam integerParam) {
        Intrinsics.checkNotNullParameter(integerParam, "<set-?>");
        this.iconTheme = integerParam;
    }

    public final BooleanParam getClosePositionRight() {
        BooleanParam booleanParam = this.closePositionRight;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("closePositionRight");
        return null;
    }

    public final void setClosePositionRight(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.closePositionRight = booleanParam;
    }

    public final BooleanParam isHostLight() {
        BooleanParam booleanParam = this.isHostLight;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("isHostLight");
        return null;
    }

    public final void setHostLight(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.isHostLight = booleanParam;
    }

    public void initWithData(ISchemaData schemaData) {
        Intrinsics.checkNotNullParameter(schemaData, "schemaData");
        setHostLight(new BooleanParam(schemaData, AnnieXSchemaField.IS_HOST_STATUS_BAR_LIGHT, false));
        setDisableInputScroll(new BooleanParam(schemaData, "disable_input_scroll", false));
        setType(new StringParam(schemaData, ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, ""));
        setHideBack(new BooleanParam(schemaData, "hide_back", false));
        setShowMoreButton(new BooleanParam(schemaData, "show_more_button", false));
        setTitleBarStyle(new IntegerParam(schemaData, "title_bar_style", 0));
        setHideStatusBar(new BooleanParam(schemaData, "hide_status_bar", false));
        setNavBarColor(new UIColorParam(schemaData, "nav_bar_color", (Integer) null));
        setNavBtnType(new NavBtnParam(schemaData, "nav_btn_type", NavBtnType.NONE));
        setShowCloseall(new BooleanParam(schemaData, "show_closeall", false));
        setShowClosealways(new BooleanParam(schemaData, "show_close_always", false));
        setSoftInputMode(new SoftInputModeParam(schemaData, "soft_input_mode", (SoftInputMode) null));
        setStatusBarBgColor(new UIColorParam(schemaData, "status_bar_bg_color", (Integer) null));
        setStatusFontMode(new StatusFontModeParam(schemaData, "status_font_mode", StatusFontMode.DEFAULT));
        setTitle(new StringParam(schemaData, "title", (String) null));
        setTitleColor(new UIColorParam(schemaData, "title_color", (Integer) null));
        setSupportExchangeTheme(new BooleanParam(schemaData, "support_exchange_theme", false));
        setAdjustPan(new BooleanParam(schemaData, "is_adjust_pan", true));
        if (IConditionCallKt.enableAnnieXLiveTypeSchemaFieldFix()) {
            setHideNavBar(new BooleanParam(schemaData, "hide_nav_bar", false));
            setTransStatusBar(new BooleanParam(schemaData, "trans_status_bar", false));
        } else if (Intrinsics.areEqual(getType().getValue(), "fullscreen")) {
            setHideNavBar(new BooleanParam(schemaData, "hide_nav_bar", false));
            setTransStatusBar(new BooleanParam(schemaData, "trans_status_bar", false));
        } else {
            setHideNavBar(new BooleanParam(schemaData, "hide_nav_bar", true));
            setTransStatusBar(new BooleanParam(schemaData, "trans_status_bar", false));
        }
        setShouldFullScreen(new BooleanParam(schemaData, "should_full_screen", false));
        setShowBack(new BooleanParam(schemaData, "show_back", false));
        setEnableShare(new BooleanParam(schemaData, "enable_share", false));
        setIconTheme(new IntegerParam(schemaData, "icon_theme", 0));
        setClosePositionRight(new BooleanParam(schemaData, "close_position_right", true));
    }
}
