package com.bytedance.ies.bullet.service.sdk.model;

import com.bytedance.ies.bullet.service.schema.ISchemaData;
import com.bytedance.ies.bullet.service.schema.ISchemaModel;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.ies.bullet.service.sdk.param.BooleanParam;
import com.bytedance.ies.bullet.service.sdk.param.NavBtnParam;
import com.bytedance.ies.bullet.service.sdk.param.NavBtnType;
import com.bytedance.ies.bullet.service.sdk.param.StatusFontModeParam;
import com.bytedance.ies.bullet.service.sdk.param.StringParam;
import com.bytedance.ies.bullet.service.sdk.param.UIColorParam;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BDPageModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u00103\u001a\u0002042\u0006\u00105\u001a\u000206H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\rX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001a\u0010\u001b\u001a\u00020\rX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u000f\"\u0004\b\u001d\u0010\u0011R\u001a\u0010\u001e\u001a\u00020\u001fX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\bR\u001a\u0010'\u001a\u00020(X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010-\u001a\u00020\rX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u000f\"\u0004\b/\u0010\u0011R\u001a\u00100\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0006\"\u0004\b2\u0010\b¨\u00067"}, d2 = {"Lcom/bytedance/ies/bullet/service/sdk/model/BDPageModel;", "Lcom/bytedance/ies/bullet/service/schema/ISchemaModel;", "()V", "hideNavBar", "Lcom/bytedance/ies/bullet/service/sdk/param/BooleanParam;", "getHideNavBar", "()Lcom/bytedance/ies/bullet/service/sdk/param/BooleanParam;", "setHideNavBar", "(Lcom/bytedance/ies/bullet/service/sdk/param/BooleanParam;)V", "hideStatusBar", "getHideStatusBar", "setHideStatusBar", "navBarColor", "Lcom/bytedance/ies/bullet/service/sdk/param/UIColorParam;", "getNavBarColor", "()Lcom/bytedance/ies/bullet/service/sdk/param/UIColorParam;", "setNavBarColor", "(Lcom/bytedance/ies/bullet/service/sdk/param/UIColorParam;)V", "navBtnType", "Lcom/bytedance/ies/bullet/service/sdk/param/NavBtnParam;", "getNavBtnType", "()Lcom/bytedance/ies/bullet/service/sdk/param/NavBtnParam;", "setNavBtnType", "(Lcom/bytedance/ies/bullet/service/sdk/param/NavBtnParam;)V", "showCloseall", "getShowCloseall", "setShowCloseall", "statusBarBgColor", "getStatusBarBgColor", "setStatusBarBgColor", "statusFontMode", "Lcom/bytedance/ies/bullet/service/sdk/param/StatusFontModeParam;", "getStatusFontMode", "()Lcom/bytedance/ies/bullet/service/sdk/param/StatusFontModeParam;", "setStatusFontMode", "(Lcom/bytedance/ies/bullet/service/sdk/param/StatusFontModeParam;)V", "supportExchangeTheme", "getSupportExchangeTheme", "setSupportExchangeTheme", SchemaConstants.QUERY_KEY_TITLE, "Lcom/bytedance/ies/bullet/service/sdk/param/StringParam;", "getTitle", "()Lcom/bytedance/ies/bullet/service/sdk/param/StringParam;", "setTitle", "(Lcom/bytedance/ies/bullet/service/sdk/param/StringParam;)V", "titleColor", "getTitleColor", "setTitleColor", "transStatusBar", "getTransStatusBar", "setTransStatusBar", "initWithData", "", "schemaData", "Lcom/bytedance/ies/bullet/service/schema/ISchemaData;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class BDPageModel implements ISchemaModel {
    public BooleanParam hideNavBar;
    public BooleanParam hideStatusBar;
    public UIColorParam navBarColor;
    public NavBtnParam navBtnType;
    public BooleanParam showCloseall;
    public UIColorParam statusBarBgColor;
    public StatusFontModeParam statusFontMode;
    public BooleanParam supportExchangeTheme;
    public StringParam title;
    public UIColorParam titleColor;
    public BooleanParam transStatusBar;

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
        Intrinsics.throwUninitializedPropertyAccessException(SchemaConstants.QUERY_KEY_TITLE);
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

    @Override // com.bytedance.ies.bullet.service.schema.ISchemaModel
    public void initWithData(ISchemaData schemaData) {
        Intrinsics.checkNotNullParameter(schemaData, "schemaData");
        setHideNavBar(new BooleanParam(schemaData, SchemaConstants.QUERY_KEY_HIDE_NAV_BAR, false));
        setHideStatusBar(new BooleanParam(schemaData, SchemaConstants.QUERY_KEY_HIDE_STATUS_BAR, false));
        setNavBarColor(new UIColorParam(schemaData, SchemaConstants.QUERY_KEY_NAV_BAR_COLOR, null));
        setNavBtnType(new NavBtnParam(schemaData, "nav_btn_type", NavBtnType.NONE));
        setShowCloseall(new BooleanParam(schemaData, SchemaConstants.QUERY_KEY_SHOW_CLOSE_ALL, false));
        setStatusBarBgColor(new UIColorParam(schemaData, "status_bar_bg_color", null));
        setStatusFontMode(new StatusFontModeParam(schemaData, "status_font_mode", null));
        setTitle(new StringParam(schemaData, SchemaConstants.QUERY_KEY_TITLE, null));
        setTitleColor(new UIColorParam(schemaData, SchemaConstants.QUERY_KEY_TITLE_COLOR, null));
        setTransStatusBar(new BooleanParam(schemaData, SchemaConstants.QUERY_KEY_TRANS_STATUS_BAR, false));
        setSupportExchangeTheme(new BooleanParam(schemaData, "support_exchange_theme", false));
    }
}
