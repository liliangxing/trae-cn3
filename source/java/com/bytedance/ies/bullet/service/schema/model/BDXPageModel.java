package com.bytedance.ies.bullet.service.schema.model;

import com.bytedance.ies.bullet.service.schema.ISchemaData;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.ies.bullet.service.sdk.model.BDPageModel;
import com.bytedance.ies.bullet.service.sdk.param.BooleanParam;
import com.bytedance.ies.bullet.service.sdk.param.IntegerParam;
import com.bytedance.ies.bullet.service.sdk.param.OutAnimation;
import com.bytedance.ies.bullet.service.sdk.param.OutAnimationParam;
import com.bytedance.ies.bullet.service.sdk.param.SoftInputModeParam;
import com.bytedance.ies.bullet.service.sdk.param.StatusFontModeParam;
import com.bytedance.ies.bullet.service.sdk.param.StringParam;
import com.bytedance.ies.bullet.service.sdk.param.UIColorParam;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BDXPageModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 E2\u00020\u0001:\u0001EB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020DH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0006\"\u0004\b\u0010\u0010\bR\u001a\u0010\u0011\u001a\u00020\u0012X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0006\"\u0004\b\u001f\u0010\bR\u001a\u0010 \u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0006\"\u0004\b\"\u0010\bR\u001a\u0010#\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0006\"\u0004\b%\u0010\bR\u001a\u0010&\u001a\u00020'X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001a\u0010,\u001a\u00020-X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001a\u00102\u001a\u000203X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001a\u00108\u001a\u000209X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001a\u0010>\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u0006\"\u0004\b@\u0010\b¨\u0006F"}, d2 = {"Lcom/bytedance/ies/bullet/service/schema/model/BDXPageModel;", "Lcom/bytedance/ies/bullet/service/sdk/model/BDPageModel;", "()V", "enableImmersionKeyboardControl", "Lcom/bytedance/ies/bullet/service/sdk/param/BooleanParam;", "getEnableImmersionKeyboardControl", "()Lcom/bytedance/ies/bullet/service/sdk/param/BooleanParam;", "setEnableImmersionKeyboardControl", "(Lcom/bytedance/ies/bullet/service/sdk/param/BooleanParam;)V", "enablePullToRefresh", "getEnablePullToRefresh", "setEnablePullToRefresh", "hideBack", "getHideBack", "setHideBack", "isAdjustPan", "setAdjustPan", "nativeTriggerShowHideEvent", "Lcom/bytedance/ies/bullet/service/sdk/param/StringParam;", "getNativeTriggerShowHideEvent", "()Lcom/bytedance/ies/bullet/service/sdk/param/StringParam;", "setNativeTriggerShowHideEvent", "(Lcom/bytedance/ies/bullet/service/sdk/param/StringParam;)V", "needOutAnimation", "Lcom/bytedance/ies/bullet/service/sdk/param/OutAnimationParam;", "getNeedOutAnimation", "()Lcom/bytedance/ies/bullet/service/sdk/param/OutAnimationParam;", "setNeedOutAnimation", "(Lcom/bytedance/ies/bullet/service/sdk/param/OutAnimationParam;)V", "shouldFullScreen", "getShouldFullScreen", "setShouldFullScreen", "showKeyboard", "getShowKeyboard", "setShowKeyboard", "showMoreButton", "getShowMoreButton", "setShowMoreButton", "softInputMode", "Lcom/bytedance/ies/bullet/service/sdk/param/SoftInputModeParam;", "getSoftInputMode", "()Lcom/bytedance/ies/bullet/service/sdk/param/SoftInputModeParam;", "setSoftInputMode", "(Lcom/bytedance/ies/bullet/service/sdk/param/SoftInputModeParam;)V", "statusBarColor", "Lcom/bytedance/ies/bullet/service/sdk/param/UIColorParam;", "getStatusBarColor", "()Lcom/bytedance/ies/bullet/service/sdk/param/UIColorParam;", "setStatusBarColor", "(Lcom/bytedance/ies/bullet/service/sdk/param/UIColorParam;)V", "statusFontDark", "Lcom/bytedance/ies/bullet/service/sdk/param/StatusFontModeParam;", "getStatusFontDark", "()Lcom/bytedance/ies/bullet/service/sdk/param/StatusFontModeParam;", "setStatusFontDark", "(Lcom/bytedance/ies/bullet/service/sdk/param/StatusFontModeParam;)V", "titleBarStyle", "Lcom/bytedance/ies/bullet/service/sdk/param/IntegerParam;", "getTitleBarStyle", "()Lcom/bytedance/ies/bullet/service/sdk/param/IntegerParam;", "setTitleBarStyle", "(Lcom/bytedance/ies/bullet/service/sdk/param/IntegerParam;)V", "useWebviewTitle", "getUseWebviewTitle", "setUseWebviewTitle", "initWithData", "", "schemaData", "Lcom/bytedance/ies/bullet/service/schema/ISchemaData;", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class BDXPageModel extends BDPageModel {
    public static final String NATIVE_TRIGGER_SHOW_HIDE_EVENT_NONE = "none";
    public BooleanParam enableImmersionKeyboardControl;
    public BooleanParam enablePullToRefresh;
    public BooleanParam hideBack;
    public BooleanParam isAdjustPan;
    public StringParam nativeTriggerShowHideEvent;
    public OutAnimationParam needOutAnimation;
    public BooleanParam shouldFullScreen;
    public BooleanParam showKeyboard;
    public BooleanParam showMoreButton;
    public SoftInputModeParam softInputMode;
    public UIColorParam statusBarColor;
    public StatusFontModeParam statusFontDark;
    public IntegerParam titleBarStyle;
    public BooleanParam useWebviewTitle;

    public final BooleanParam getEnableImmersionKeyboardControl() {
        BooleanParam booleanParam = this.enableImmersionKeyboardControl;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("enableImmersionKeyboardControl");
        return null;
    }

    public final void setEnableImmersionKeyboardControl(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.enableImmersionKeyboardControl = booleanParam;
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

    public final OutAnimationParam getNeedOutAnimation() {
        OutAnimationParam outAnimationParam = this.needOutAnimation;
        if (outAnimationParam != null) {
            return outAnimationParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("needOutAnimation");
        return null;
    }

    public final void setNeedOutAnimation(OutAnimationParam outAnimationParam) {
        Intrinsics.checkNotNullParameter(outAnimationParam, "<set-?>");
        this.needOutAnimation = outAnimationParam;
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

    public final BooleanParam getShowKeyboard() {
        BooleanParam booleanParam = this.showKeyboard;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("showKeyboard");
        return null;
    }

    public final void setShowKeyboard(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.showKeyboard = booleanParam;
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

    public final UIColorParam getStatusBarColor() {
        UIColorParam uIColorParam = this.statusBarColor;
        if (uIColorParam != null) {
            return uIColorParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("statusBarColor");
        return null;
    }

    public final void setStatusBarColor(UIColorParam uIColorParam) {
        Intrinsics.checkNotNullParameter(uIColorParam, "<set-?>");
        this.statusBarColor = uIColorParam;
    }

    public final StatusFontModeParam getStatusFontDark() {
        StatusFontModeParam statusFontModeParam = this.statusFontDark;
        if (statusFontModeParam != null) {
            return statusFontModeParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("statusFontDark");
        return null;
    }

    public final void setStatusFontDark(StatusFontModeParam statusFontModeParam) {
        Intrinsics.checkNotNullParameter(statusFontModeParam, "<set-?>");
        this.statusFontDark = statusFontModeParam;
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

    public final StringParam getNativeTriggerShowHideEvent() {
        StringParam stringParam = this.nativeTriggerShowHideEvent;
        if (stringParam != null) {
            return stringParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("nativeTriggerShowHideEvent");
        return null;
    }

    public final void setNativeTriggerShowHideEvent(StringParam stringParam) {
        Intrinsics.checkNotNullParameter(stringParam, "<set-?>");
        this.nativeTriggerShowHideEvent = stringParam;
    }

    public final BooleanParam getUseWebviewTitle() {
        BooleanParam booleanParam = this.useWebviewTitle;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("useWebviewTitle");
        return null;
    }

    public final void setUseWebviewTitle(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.useWebviewTitle = booleanParam;
    }

    public final BooleanParam getEnablePullToRefresh() {
        BooleanParam booleanParam = this.enablePullToRefresh;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("enablePullToRefresh");
        return null;
    }

    public final void setEnablePullToRefresh(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.enablePullToRefresh = booleanParam;
    }

    @Override // com.bytedance.ies.bullet.service.sdk.model.BDPageModel, com.bytedance.ies.bullet.service.schema.ISchemaModel
    public void initWithData(ISchemaData schemaData) {
        Intrinsics.checkNotNullParameter(schemaData, "schemaData");
        super.initWithData(schemaData);
        setEnableImmersionKeyboardControl(new BooleanParam(schemaData, "enable_immersion_keyboard_control", true));
        setHideBack(new BooleanParam(schemaData, SchemaConstants.QUERY_KEY_HIDE_BACK, false));
        setAdjustPan(new BooleanParam(schemaData, SchemaConstants.QUERY_KEY_IS_ADJUST_PAN, true));
        setNeedOutAnimation(new OutAnimationParam(schemaData, SchemaConstants.QUERY_KEY_NEED_OUT_ANIMATION, OutAnimation.AUTO));
        setShouldFullScreen(new BooleanParam(schemaData, SchemaConstants.QUERY_KEY_SHOULD_FULL_SCREEN, false));
        setShowKeyboard(new BooleanParam(schemaData, "show_keyboard", false));
        setShowMoreButton(new BooleanParam(schemaData, SchemaConstants.QUERY_KEY_SHOW_MORE_BUTTON, false));
        setSoftInputMode(new SoftInputModeParam(schemaData, SchemaConstants.QUERY_KEY_SOFT_INPUT_MODE, null));
        setStatusBarColor(new UIColorParam(schemaData, "status_bar_color", null));
        setStatusFontDark(new StatusFontModeParam(schemaData, "status_font_dark", null));
        setTitleBarStyle(new IntegerParam(schemaData, "title_bar_style", 0));
        setUseWebviewTitle(new BooleanParam(schemaData, SchemaConstants.QUERY_KEY_USE_WEBVIEW_TITLE, true));
        setNativeTriggerShowHideEvent(new StringParam(schemaData, "native_trigger_show_hide_event", "none"));
        setEnablePullToRefresh(new BooleanParam(schemaData, "enable_pull_down_refresh", false));
    }
}
