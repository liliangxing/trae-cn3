package com.bytedance.ies.bullet.service.schema.model;

import com.bytedance.ies.bullet.service.schema.ISchemaData;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.ies.bullet.service.sdk.model.BDPopupModel;
import com.bytedance.ies.bullet.service.sdk.param.BooleanParam;
import com.bytedance.ies.bullet.service.sdk.param.DoubleParam;
import com.bytedance.ies.bullet.service.sdk.param.IntegerParam;
import com.bytedance.ies.bullet.service.sdk.param.PercentParam;
import com.bytedance.ies.bullet.service.sdk.param.PopupTriggerParam;
import com.bytedance.ies.bullet.service.sdk.param.PopupTriggerType;
import com.bytedance.ies.bullet.service.sdk.param.PopupType;
import com.bytedance.ies.bullet.service.sdk.param.PopupTypeParam;
import com.bytedance.ies.bullet.service.sdk.param.StringParam;
import com.bytedance.ies.bullet.service.sdk.param.UIColorParam;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BDXPopupModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b)\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0098\u0001\u001a\u00030\u0099\u00012\b\u0010\u009a\u0001\u001a\u00030\u009b\u0001H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001a\u0010\u0018\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001a\u0010\u001b\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001a\u0010\u001e\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\u001a\u0010!\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR\u001a\u0010$\u001a\u00020\nX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\f\"\u0004\b&\u0010\u000eR\u001a\u0010'\u001a\u00020\nX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\f\"\u0004\b)\u0010\u000eR\u001a\u0010*\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0006\"\u0004\b,\u0010\bR\u001a\u0010-\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0006\"\u0004\b/\u0010\bR\u001a\u00100\u001a\u00020\nX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\f\"\u0004\b2\u0010\u000eR\u001a\u00103\u001a\u000204X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001a\u00109\u001a\u00020\nX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\f\"\u0004\b;\u0010\u000eR\u001a\u0010<\u001a\u00020\nX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\f\"\u0004\b>\u0010\u000eR\u001a\u0010?\u001a\u000204X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b@\u00106\"\u0004\bA\u00108R\u001a\u0010B\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u0006\"\u0004\bD\u0010\bR\u001a\u0010E\u001a\u000204X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bF\u00106\"\u0004\bG\u00108R\u001a\u0010H\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\u0006\"\u0004\bJ\u0010\bR\u001a\u0010K\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\u0006\"\u0004\bM\u0010\bR\u001a\u0010N\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010\u0006\"\u0004\bP\u0010\bR\u001a\u0010Q\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010\u0006\"\u0004\bR\u0010\bR\u001a\u0010S\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010\u0006\"\u0004\bU\u0010\bR\u001a\u0010V\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010\u0006\"\u0004\bX\u0010\bR\u001a\u0010Y\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010\u0006\"\u0004\b[\u0010\bR\u001a\u0010\\\u001a\u00020]X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR\u001a\u0010b\u001a\u00020]X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010_\"\u0004\bd\u0010aR\u001a\u0010e\u001a\u00020fX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bg\u0010h\"\u0004\bi\u0010jR\u001a\u0010k\u001a\u00020lX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bm\u0010n\"\u0004\bo\u0010pR\u001a\u0010q\u001a\u00020rX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bs\u0010t\"\u0004\bu\u0010vR\u001a\u0010w\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bx\u0010\u0006\"\u0004\by\u0010\bR\u001a\u0010z\u001a\u00020\nX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b{\u0010\f\"\u0004\b|\u0010\u000eR\u001a\u0010}\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b~\u0010\u0006\"\u0004\b\u007f\u0010\bR\u001d\u0010\u0080\u0001\u001a\u00020fX\u0086.¢\u0006\u0010\n\u0000\u001a\u0005\b\u0081\u0001\u0010h\"\u0005\b\u0082\u0001\u0010jR\u001d\u0010\u0083\u0001\u001a\u00020]X\u0086.¢\u0006\u0010\n\u0000\u001a\u0005\b\u0084\u0001\u0010_\"\u0005\b\u0085\u0001\u0010aR\u001d\u0010\u0086\u0001\u001a\u00020lX\u0086.¢\u0006\u0010\n\u0000\u001a\u0005\b\u0087\u0001\u0010n\"\u0005\b\u0088\u0001\u0010pR \u0010\u0089\u0001\u001a\u00030\u008a\u0001X\u0086.¢\u0006\u0012\n\u0000\u001a\u0006\b\u008b\u0001\u0010\u008c\u0001\"\u0006\b\u008d\u0001\u0010\u008e\u0001R\u001d\u0010\u008f\u0001\u001a\u00020rX\u0086.¢\u0006\u0010\n\u0000\u001a\u0005\b\u0090\u0001\u0010t\"\u0005\b\u0091\u0001\u0010vR\u001d\u0010\u0092\u0001\u001a\u00020\u0004X\u0086.¢\u0006\u0010\n\u0000\u001a\u0005\b\u0093\u0001\u0010\u0006\"\u0005\b\u0094\u0001\u0010\bR\u001d\u0010\u0095\u0001\u001a\u000204X\u0086.¢\u0006\u0010\n\u0000\u001a\u0005\b\u0096\u0001\u00106\"\u0005\b\u0097\u0001\u00108¨\u0006\u009c\u0001"}, d2 = {"Lcom/bytedance/ies/bullet/service/schema/model/BDXPopupModel;", "Lcom/bytedance/ies/bullet/service/sdk/model/BDPopupModel;", "()V", "allowClosed", "Lcom/bytedance/ies/bullet/service/sdk/param/BooleanParam;", "getAllowClosed", "()Lcom/bytedance/ies/bullet/service/sdk/param/BooleanParam;", "setAllowClosed", "(Lcom/bytedance/ies/bullet/service/sdk/param/BooleanParam;)V", "aspectRatio", "Lcom/bytedance/ies/bullet/service/sdk/param/DoubleParam;", "getAspectRatio", "()Lcom/bytedance/ies/bullet/service/sdk/param/DoubleParam;", "setAspectRatio", "(Lcom/bytedance/ies/bullet/service/sdk/param/DoubleParam;)V", "clickThroughMask", "getClickThroughMask", "setClickThroughMask", "closeByGesture", "getCloseByGesture", "setCloseByGesture", "closeByMask", "getCloseByMask", "setCloseByMask", "compatCoordinateLayoutScrollView", "getCompatCoordinateLayoutScrollView", "setCompatCoordinateLayoutScrollView", "disableImmersive", "getDisableImmersive", "setDisableImmersive", "dragBack", "getDragBack", "setDragBack", "dragByGesture", "getDragByGesture", "setDragByGesture", "dragDownCloseThreshold", "getDragDownCloseThreshold", "setDragDownCloseThreshold", "dragDownThreshold", "getDragDownThreshold", "setDragDownThreshold", "dragExceptStatusBar", "getDragExceptStatusBar", "setDragExceptStatusBar", "dragFollowGesture", "getDragFollowGesture", "setDragFollowGesture", "dragHeight", "getDragHeight", "setDragHeight", "dragHeightPercent", "Lcom/bytedance/ies/bullet/service/sdk/param/PercentParam;", "getDragHeightPercent", "()Lcom/bytedance/ies/bullet/service/sdk/param/PercentParam;", "setDragHeightPercent", "(Lcom/bytedance/ies/bullet/service/sdk/param/PercentParam;)V", "dragUpThreshold", "getDragUpThreshold", "setDragUpThreshold", "dragUppingSpace", "getDragUppingSpace", "setDragUppingSpace", "dragUppingSpacePercent", "getDragUppingSpacePercent", "setDragUppingSpacePercent", "dragUppingSpaceWithStatusBar", "getDragUppingSpaceWithStatusBar", "setDragUppingSpaceWithStatusBar", "heightPercent", "getHeightPercent", "setHeightPercent", "hideNavBar", "getHideNavBar", "setHideNavBar", "hideStatusBar", "getHideStatusBar", "setHideStatusBar", "ignoreKeyboardPadding", "getIgnoreKeyboardPadding", "setIgnoreKeyboardPadding", "isAdjustPan", "setAdjustPan", "keyboardAdjust", "getKeyboardAdjust", "setKeyboardAdjust", "listenKeyboard", "getListenKeyboard", "setListenKeyboard", "maskCloseUntilLoaded", "getMaskCloseUntilLoaded", "setMaskCloseUntilLoaded", "maskColor", "Lcom/bytedance/ies/bullet/service/sdk/param/UIColorParam;", "getMaskColor", "()Lcom/bytedance/ies/bullet/service/sdk/param/UIColorParam;", "setMaskColor", "(Lcom/bytedance/ies/bullet/service/sdk/param/UIColorParam;)V", "navBarColor", "getNavBarColor", "setNavBarColor", "originContainerId", "Lcom/bytedance/ies/bullet/service/sdk/param/StringParam;", "getOriginContainerId", "()Lcom/bytedance/ies/bullet/service/sdk/param/StringParam;", "setOriginContainerId", "(Lcom/bytedance/ies/bullet/service/sdk/param/StringParam;)V", "peakDownCloseThreshold", "Lcom/bytedance/ies/bullet/service/sdk/param/IntegerParam;", "getPeakDownCloseThreshold", "()Lcom/bytedance/ies/bullet/service/sdk/param/IntegerParam;", "setPeakDownCloseThreshold", "(Lcom/bytedance/ies/bullet/service/sdk/param/IntegerParam;)V", "popupEnterType", "Lcom/bytedance/ies/bullet/service/sdk/param/PopupTypeParam;", "getPopupEnterType", "()Lcom/bytedance/ies/bullet/service/sdk/param/PopupTypeParam;", "setPopupEnterType", "(Lcom/bytedance/ies/bullet/service/sdk/param/PopupTypeParam;)V", "radiusUseDp", "getRadiusUseDp", "setRadiusUseDp", "resizeDuration", "getResizeDuration", "setResizeDuration", "showOnSuccess", "getShowOnSuccess", "setShowOnSuccess", SchemaConstants.QUERY_KEY_TITLE, "getTitle", "setTitle", "titleColor", "getTitleColor", "setTitleColor", "touchLimit", "getTouchLimit", "setTouchLimit", "triggerOrigin", "Lcom/bytedance/ies/bullet/service/sdk/param/PopupTriggerParam;", "getTriggerOrigin", "()Lcom/bytedance/ies/bullet/service/sdk/param/PopupTriggerParam;", "setTriggerOrigin", "(Lcom/bytedance/ies/bullet/service/sdk/param/PopupTriggerParam;)V", "type", "getType", "setType", "useScreenHeight", "getUseScreenHeight", "setUseScreenHeight", "widthPercent", "getWidthPercent", "setWidthPercent", "initWithData", "", "schemaData", "Lcom/bytedance/ies/bullet/service/schema/ISchemaData;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class BDXPopupModel extends BDPopupModel {
    public BooleanParam allowClosed;
    public DoubleParam aspectRatio;
    public BooleanParam clickThroughMask;
    public BooleanParam closeByGesture;
    public BooleanParam closeByMask;
    public BooleanParam compatCoordinateLayoutScrollView;
    public BooleanParam disableImmersive;
    public BooleanParam dragBack;
    public BooleanParam dragByGesture;
    public DoubleParam dragDownCloseThreshold;
    public DoubleParam dragDownThreshold;
    public BooleanParam dragExceptStatusBar;
    public BooleanParam dragFollowGesture;
    public DoubleParam dragHeight;
    public PercentParam dragHeightPercent;
    public DoubleParam dragUpThreshold;
    public DoubleParam dragUppingSpace;
    public PercentParam dragUppingSpacePercent;
    public BooleanParam dragUppingSpaceWithStatusBar;
    public PercentParam heightPercent;
    public BooleanParam hideNavBar;
    public BooleanParam hideStatusBar;
    public BooleanParam ignoreKeyboardPadding;
    public BooleanParam isAdjustPan;
    public BooleanParam keyboardAdjust;
    public BooleanParam listenKeyboard;
    public BooleanParam maskCloseUntilLoaded;
    public UIColorParam maskColor;
    public UIColorParam navBarColor;
    public StringParam originContainerId;
    public IntegerParam peakDownCloseThreshold;
    public PopupTypeParam popupEnterType;
    public BooleanParam radiusUseDp;
    public DoubleParam resizeDuration;
    public BooleanParam showOnSuccess;
    public StringParam title;
    public UIColorParam titleColor;
    public IntegerParam touchLimit;
    public PopupTriggerParam triggerOrigin;
    public PopupTypeParam type;
    public BooleanParam useScreenHeight;
    public PercentParam widthPercent;

    public final BooleanParam getAllowClosed() {
        BooleanParam booleanParam = this.allowClosed;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("allowClosed");
        return null;
    }

    public final void setAllowClosed(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.allowClosed = booleanParam;
    }

    public final DoubleParam getAspectRatio() {
        DoubleParam doubleParam = this.aspectRatio;
        if (doubleParam != null) {
            return doubleParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("aspectRatio");
        return null;
    }

    public final void setAspectRatio(DoubleParam doubleParam) {
        Intrinsics.checkNotNullParameter(doubleParam, "<set-?>");
        this.aspectRatio = doubleParam;
    }

    public final BooleanParam getClickThroughMask() {
        BooleanParam booleanParam = this.clickThroughMask;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("clickThroughMask");
        return null;
    }

    public final void setClickThroughMask(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.clickThroughMask = booleanParam;
    }

    public final BooleanParam getCloseByGesture() {
        BooleanParam booleanParam = this.closeByGesture;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("closeByGesture");
        return null;
    }

    public final void setCloseByGesture(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.closeByGesture = booleanParam;
    }

    public final BooleanParam getCloseByMask() {
        BooleanParam booleanParam = this.closeByMask;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("closeByMask");
        return null;
    }

    public final void setCloseByMask(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.closeByMask = booleanParam;
    }

    public final BooleanParam getDisableImmersive() {
        BooleanParam booleanParam = this.disableImmersive;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("disableImmersive");
        return null;
    }

    public final void setDisableImmersive(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.disableImmersive = booleanParam;
    }

    public final BooleanParam getDragBack() {
        BooleanParam booleanParam = this.dragBack;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("dragBack");
        return null;
    }

    public final void setDragBack(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.dragBack = booleanParam;
    }

    public final BooleanParam getDragByGesture() {
        BooleanParam booleanParam = this.dragByGesture;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("dragByGesture");
        return null;
    }

    public final void setDragByGesture(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.dragByGesture = booleanParam;
    }

    public final DoubleParam getDragDownCloseThreshold() {
        DoubleParam doubleParam = this.dragDownCloseThreshold;
        if (doubleParam != null) {
            return doubleParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("dragDownCloseThreshold");
        return null;
    }

    public final void setDragDownCloseThreshold(DoubleParam doubleParam) {
        Intrinsics.checkNotNullParameter(doubleParam, "<set-?>");
        this.dragDownCloseThreshold = doubleParam;
    }

    public final DoubleParam getDragDownThreshold() {
        DoubleParam doubleParam = this.dragDownThreshold;
        if (doubleParam != null) {
            return doubleParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("dragDownThreshold");
        return null;
    }

    public final void setDragDownThreshold(DoubleParam doubleParam) {
        Intrinsics.checkNotNullParameter(doubleParam, "<set-?>");
        this.dragDownThreshold = doubleParam;
    }

    public final BooleanParam getDragExceptStatusBar() {
        BooleanParam booleanParam = this.dragExceptStatusBar;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("dragExceptStatusBar");
        return null;
    }

    public final void setDragExceptStatusBar(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.dragExceptStatusBar = booleanParam;
    }

    public final BooleanParam getDragFollowGesture() {
        BooleanParam booleanParam = this.dragFollowGesture;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("dragFollowGesture");
        return null;
    }

    public final void setDragFollowGesture(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.dragFollowGesture = booleanParam;
    }

    public final DoubleParam getDragHeight() {
        DoubleParam doubleParam = this.dragHeight;
        if (doubleParam != null) {
            return doubleParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("dragHeight");
        return null;
    }

    public final void setDragHeight(DoubleParam doubleParam) {
        Intrinsics.checkNotNullParameter(doubleParam, "<set-?>");
        this.dragHeight = doubleParam;
    }

    public final PercentParam getDragHeightPercent() {
        PercentParam percentParam = this.dragHeightPercent;
        if (percentParam != null) {
            return percentParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("dragHeightPercent");
        return null;
    }

    public final void setDragHeightPercent(PercentParam percentParam) {
        Intrinsics.checkNotNullParameter(percentParam, "<set-?>");
        this.dragHeightPercent = percentParam;
    }

    public final DoubleParam getDragUpThreshold() {
        DoubleParam doubleParam = this.dragUpThreshold;
        if (doubleParam != null) {
            return doubleParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("dragUpThreshold");
        return null;
    }

    public final void setDragUpThreshold(DoubleParam doubleParam) {
        Intrinsics.checkNotNullParameter(doubleParam, "<set-?>");
        this.dragUpThreshold = doubleParam;
    }

    public final PercentParam getHeightPercent() {
        PercentParam percentParam = this.heightPercent;
        if (percentParam != null) {
            return percentParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("heightPercent");
        return null;
    }

    public final void setHeightPercent(PercentParam percentParam) {
        Intrinsics.checkNotNullParameter(percentParam, "<set-?>");
        this.heightPercent = percentParam;
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

    public final BooleanParam getKeyboardAdjust() {
        BooleanParam booleanParam = this.keyboardAdjust;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("keyboardAdjust");
        return null;
    }

    public final void setKeyboardAdjust(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.keyboardAdjust = booleanParam;
    }

    public final BooleanParam getListenKeyboard() {
        BooleanParam booleanParam = this.listenKeyboard;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("listenKeyboard");
        return null;
    }

    public final void setListenKeyboard(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.listenKeyboard = booleanParam;
    }

    public final BooleanParam getMaskCloseUntilLoaded() {
        BooleanParam booleanParam = this.maskCloseUntilLoaded;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("maskCloseUntilLoaded");
        return null;
    }

    public final void setMaskCloseUntilLoaded(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.maskCloseUntilLoaded = booleanParam;
    }

    public final UIColorParam getMaskColor() {
        UIColorParam uIColorParam = this.maskColor;
        if (uIColorParam != null) {
            return uIColorParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("maskColor");
        return null;
    }

    public final void setMaskColor(UIColorParam uIColorParam) {
        Intrinsics.checkNotNullParameter(uIColorParam, "<set-?>");
        this.maskColor = uIColorParam;
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

    public final StringParam getOriginContainerId() {
        StringParam stringParam = this.originContainerId;
        if (stringParam != null) {
            return stringParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("originContainerId");
        return null;
    }

    public final void setOriginContainerId(StringParam stringParam) {
        Intrinsics.checkNotNullParameter(stringParam, "<set-?>");
        this.originContainerId = stringParam;
    }

    public final IntegerParam getPeakDownCloseThreshold() {
        IntegerParam integerParam = this.peakDownCloseThreshold;
        if (integerParam != null) {
            return integerParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("peakDownCloseThreshold");
        return null;
    }

    public final void setPeakDownCloseThreshold(IntegerParam integerParam) {
        Intrinsics.checkNotNullParameter(integerParam, "<set-?>");
        this.peakDownCloseThreshold = integerParam;
    }

    public final PopupTypeParam getPopupEnterType() {
        PopupTypeParam popupTypeParam = this.popupEnterType;
        if (popupTypeParam != null) {
            return popupTypeParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("popupEnterType");
        return null;
    }

    public final void setPopupEnterType(PopupTypeParam popupTypeParam) {
        Intrinsics.checkNotNullParameter(popupTypeParam, "<set-?>");
        this.popupEnterType = popupTypeParam;
    }

    public final DoubleParam getResizeDuration() {
        DoubleParam doubleParam = this.resizeDuration;
        if (doubleParam != null) {
            return doubleParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("resizeDuration");
        return null;
    }

    public final void setResizeDuration(DoubleParam doubleParam) {
        Intrinsics.checkNotNullParameter(doubleParam, "<set-?>");
        this.resizeDuration = doubleParam;
    }

    public final BooleanParam getShowOnSuccess() {
        BooleanParam booleanParam = this.showOnSuccess;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("showOnSuccess");
        return null;
    }

    public final void setShowOnSuccess(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.showOnSuccess = booleanParam;
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

    public final IntegerParam getTouchLimit() {
        IntegerParam integerParam = this.touchLimit;
        if (integerParam != null) {
            return integerParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("touchLimit");
        return null;
    }

    public final void setTouchLimit(IntegerParam integerParam) {
        Intrinsics.checkNotNullParameter(integerParam, "<set-?>");
        this.touchLimit = integerParam;
    }

    public final PopupTriggerParam getTriggerOrigin() {
        PopupTriggerParam popupTriggerParam = this.triggerOrigin;
        if (popupTriggerParam != null) {
            return popupTriggerParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("triggerOrigin");
        return null;
    }

    public final void setTriggerOrigin(PopupTriggerParam popupTriggerParam) {
        Intrinsics.checkNotNullParameter(popupTriggerParam, "<set-?>");
        this.triggerOrigin = popupTriggerParam;
    }

    public final PopupTypeParam getType() {
        PopupTypeParam popupTypeParam = this.type;
        if (popupTypeParam != null) {
            return popupTypeParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("type");
        return null;
    }

    public final void setType(PopupTypeParam popupTypeParam) {
        Intrinsics.checkNotNullParameter(popupTypeParam, "<set-?>");
        this.type = popupTypeParam;
    }

    public final BooleanParam getUseScreenHeight() {
        BooleanParam booleanParam = this.useScreenHeight;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("useScreenHeight");
        return null;
    }

    public final void setUseScreenHeight(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.useScreenHeight = booleanParam;
    }

    public final PercentParam getWidthPercent() {
        PercentParam percentParam = this.widthPercent;
        if (percentParam != null) {
            return percentParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("widthPercent");
        return null;
    }

    public final void setWidthPercent(PercentParam percentParam) {
        Intrinsics.checkNotNullParameter(percentParam, "<set-?>");
        this.widthPercent = percentParam;
    }

    public final BooleanParam getIgnoreKeyboardPadding() {
        BooleanParam booleanParam = this.ignoreKeyboardPadding;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("ignoreKeyboardPadding");
        return null;
    }

    public final void setIgnoreKeyboardPadding(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.ignoreKeyboardPadding = booleanParam;
    }

    public final DoubleParam getDragUppingSpace() {
        DoubleParam doubleParam = this.dragUppingSpace;
        if (doubleParam != null) {
            return doubleParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("dragUppingSpace");
        return null;
    }

    public final void setDragUppingSpace(DoubleParam doubleParam) {
        Intrinsics.checkNotNullParameter(doubleParam, "<set-?>");
        this.dragUppingSpace = doubleParam;
    }

    public final PercentParam getDragUppingSpacePercent() {
        PercentParam percentParam = this.dragUppingSpacePercent;
        if (percentParam != null) {
            return percentParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("dragUppingSpacePercent");
        return null;
    }

    public final void setDragUppingSpacePercent(PercentParam percentParam) {
        Intrinsics.checkNotNullParameter(percentParam, "<set-?>");
        this.dragUppingSpacePercent = percentParam;
    }

    public final BooleanParam getDragUppingSpaceWithStatusBar() {
        BooleanParam booleanParam = this.dragUppingSpaceWithStatusBar;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("dragUppingSpaceWithStatusBar");
        return null;
    }

    public final void setDragUppingSpaceWithStatusBar(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.dragUppingSpaceWithStatusBar = booleanParam;
    }

    public final BooleanParam getCompatCoordinateLayoutScrollView() {
        BooleanParam booleanParam = this.compatCoordinateLayoutScrollView;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("compatCoordinateLayoutScrollView");
        return null;
    }

    public final void setCompatCoordinateLayoutScrollView(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.compatCoordinateLayoutScrollView = booleanParam;
    }

    public final BooleanParam getRadiusUseDp() {
        BooleanParam booleanParam = this.radiusUseDp;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("radiusUseDp");
        return null;
    }

    public final void setRadiusUseDp(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.radiusUseDp = booleanParam;
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

    @Override // com.bytedance.ies.bullet.service.sdk.model.BDPopupModel, com.bytedance.ies.bullet.service.schema.ISchemaModel
    public void initWithData(ISchemaData schemaData) {
        Intrinsics.checkNotNullParameter(schemaData, "schemaData");
        super.initWithData(schemaData);
        setAllowClosed(new BooleanParam(schemaData, "allowClosed", true));
        setAspectRatio(new DoubleParam(schemaData, "aspect_ratio", null));
        setClickThroughMask(new BooleanParam(schemaData, "click_through_mask", false));
        setCloseByGesture(new BooleanParam(schemaData, "close_by_gesture", null));
        setCloseByMask(new BooleanParam(schemaData, "close_by_mask", null));
        setDisableImmersive(new BooleanParam(schemaData, "disable_immersive", null));
        setDragBack(new BooleanParam(schemaData, "drag_back", null));
        setDragByGesture(new BooleanParam(schemaData, "drag_by_gesture", null));
        Double valueOf = Double.valueOf(0.0d);
        setDragDownCloseThreshold(new DoubleParam(schemaData, "drag_down_close_threshold", valueOf));
        setDragDownThreshold(new DoubleParam(schemaData, "drag_down_threshold", valueOf));
        setDragExceptStatusBar(new BooleanParam(schemaData, "drag_except_statusbar", null));
        setDragFollowGesture(new BooleanParam(schemaData, "drag_follow_gesture", true));
        setDragHeight(new DoubleParam(schemaData, "drag_height", null));
        setDragHeightPercent(new PercentParam(schemaData, "drag_height_percent", null));
        setDragUpThreshold(new DoubleParam(schemaData, "drag_up_threshold", valueOf));
        setHeightPercent(new PercentParam(schemaData, "height_percent", null));
        setHideNavBar(new BooleanParam(schemaData, SchemaConstants.QUERY_KEY_HIDE_NAV_BAR, true));
        setAdjustPan(new BooleanParam(schemaData, SchemaConstants.QUERY_KEY_IS_ADJUST_PAN, true));
        setKeyboardAdjust(new BooleanParam(schemaData, "keyboard_adjust", false));
        setListenKeyboard(new BooleanParam(schemaData, "listen_keyboard", false));
        setMaskCloseUntilLoaded(new BooleanParam(schemaData, "mask_close_until_loaded", false));
        setMaskColor(new UIColorParam(schemaData, "mask_color", null));
        setNavBarColor(new UIColorParam(schemaData, SchemaConstants.QUERY_KEY_NAV_BAR_COLOR, null));
        setOriginContainerId(new StringParam(schemaData, "origin_container_id", null));
        setPeakDownCloseThreshold(new IntegerParam(schemaData, "peek_down_close_threshold", null));
        setPopupEnterType(new PopupTypeParam(schemaData, "popup_enter_type", PopupType.CENTER));
        setResizeDuration(new DoubleParam(schemaData, "resize_duration", Double.valueOf(0.3d)));
        setShowOnSuccess(new BooleanParam(schemaData, SchemaConstants.QUERY_KEY_SHOW_ON_SUCCESS, false));
        setTitle(new StringParam(schemaData, SchemaConstants.QUERY_KEY_TITLE, null));
        setTitleColor(new UIColorParam(schemaData, SchemaConstants.QUERY_KEY_TITLE_COLOR, null));
        setTouchLimit(new IntegerParam(schemaData, "touch_limit", 0));
        setTriggerOrigin(new PopupTriggerParam(schemaData, "trigger_origin", PopupTriggerType.FINISH));
        setType(new PopupTypeParam(schemaData, "type", PopupType.CENTER));
        setUseScreenHeight(new BooleanParam(schemaData, "use_screen_height", false));
        setWidthPercent(new PercentParam(schemaData, "width_percent", null));
        setIgnoreKeyboardPadding(new BooleanParam(schemaData, "ignore_keyboard_padding", false));
        setDragUppingSpace(new DoubleParam(schemaData, "drag_upping_space", null));
        setDragUppingSpacePercent(new PercentParam(schemaData, "drag_upping_space_percent", null));
        setDragUppingSpaceWithStatusBar(new BooleanParam(schemaData, "drag_upping_with_statusbar", false));
        setCompatCoordinateLayoutScrollView(new BooleanParam(schemaData, "compat_lynx_foldview", false));
        setRadiusUseDp(new BooleanParam(schemaData, "radius_use_dp", false));
        setHideStatusBar(new BooleanParam(schemaData, SchemaConstants.QUERY_KEY_HIDE_STATUS_BAR, false));
    }
}
