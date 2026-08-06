package com.bytedance.ies.bullet.service.sdk.model;

import com.bytedance.ies.bullet.service.schema.ISchemaData;
import com.bytedance.ies.bullet.service.schema.ISchemaModel;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.ies.bullet.service.sdk.param.BooleanParam;
import com.bytedance.ies.bullet.service.sdk.param.DoubleParam;
import com.bytedance.ies.bullet.service.sdk.param.IntegerParam;
import com.bytedance.ies.bullet.service.sdk.param.PopupType;
import com.bytedance.ies.bullet.service.sdk.param.PopupTypeParam;
import com.bytedance.ies.bullet.service.sdk.param.UIColorParam;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BDPopupModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u00100\u001a\u0002012\u0006\u00102\u001a\u000203H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\rX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u0013X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0015\"\u0004\b \u0010\u0017R\u001a\u0010!\u001a\u00020\u0013X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0015\"\u0004\b#\u0010\u0017R\u001a\u0010$\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\bR\u001a\u0010'\u001a\u00020(X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010-\u001a\u00020\u0013X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0015\"\u0004\b/\u0010\u0017¨\u00064"}, d2 = {"Lcom/bytedance/ies/bullet/service/sdk/model/BDPopupModel;", "Lcom/bytedance/ies/bullet/service/schema/ISchemaModel;", "()V", "disableOutsideClickClose", "Lcom/bytedance/ies/bullet/service/sdk/param/BooleanParam;", "getDisableOutsideClickClose", "()Lcom/bytedance/ies/bullet/service/sdk/param/BooleanParam;", "setDisableOutsideClickClose", "(Lcom/bytedance/ies/bullet/service/sdk/param/BooleanParam;)V", "enablePullDownClose", "getEnablePullDownClose", "setEnablePullDownClose", SchemaConstants.QUERY_KEY_GRAVITY, "Lcom/bytedance/ies/bullet/service/sdk/param/PopupTypeParam;", "getGravity", "()Lcom/bytedance/ies/bullet/service/sdk/param/PopupTypeParam;", "setGravity", "(Lcom/bytedance/ies/bullet/service/sdk/param/PopupTypeParam;)V", "height", "Lcom/bytedance/ies/bullet/service/sdk/param/DoubleParam;", "getHeight", "()Lcom/bytedance/ies/bullet/service/sdk/param/DoubleParam;", "setHeight", "(Lcom/bytedance/ies/bullet/service/sdk/param/DoubleParam;)V", "maskBgColor", "Lcom/bytedance/ies/bullet/service/sdk/param/UIColorParam;", "getMaskBgColor", "()Lcom/bytedance/ies/bullet/service/sdk/param/UIColorParam;", "setMaskBgColor", "(Lcom/bytedance/ies/bullet/service/sdk/param/UIColorParam;)V", "radius", "getRadius", "setRadius", "schemaRadius", "getSchemaRadius", "setSchemaRadius", "showMask", "getShowMask", "setShowMask", "transitionAnimation", "Lcom/bytedance/ies/bullet/service/sdk/param/IntegerParam;", "getTransitionAnimation", "()Lcom/bytedance/ies/bullet/service/sdk/param/IntegerParam;", "setTransitionAnimation", "(Lcom/bytedance/ies/bullet/service/sdk/param/IntegerParam;)V", "width", "getWidth", "setWidth", "initWithData", "", "schemaData", "Lcom/bytedance/ies/bullet/service/schema/ISchemaData;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class BDPopupModel implements ISchemaModel {
    public BooleanParam disableOutsideClickClose;
    public BooleanParam enablePullDownClose;
    public PopupTypeParam gravity;
    public DoubleParam height;
    public UIColorParam maskBgColor;
    public DoubleParam radius;
    public DoubleParam schemaRadius;
    public BooleanParam showMask;
    public IntegerParam transitionAnimation;
    public DoubleParam width;

    public final BooleanParam getDisableOutsideClickClose() {
        BooleanParam booleanParam = this.disableOutsideClickClose;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("disableOutsideClickClose");
        return null;
    }

    public final void setDisableOutsideClickClose(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.disableOutsideClickClose = booleanParam;
    }

    public final BooleanParam getEnablePullDownClose() {
        BooleanParam booleanParam = this.enablePullDownClose;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("enablePullDownClose");
        return null;
    }

    public final void setEnablePullDownClose(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.enablePullDownClose = booleanParam;
    }

    public final PopupTypeParam getGravity() {
        PopupTypeParam popupTypeParam = this.gravity;
        if (popupTypeParam != null) {
            return popupTypeParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException(SchemaConstants.QUERY_KEY_GRAVITY);
        return null;
    }

    public final void setGravity(PopupTypeParam popupTypeParam) {
        Intrinsics.checkNotNullParameter(popupTypeParam, "<set-?>");
        this.gravity = popupTypeParam;
    }

    public final DoubleParam getHeight() {
        DoubleParam doubleParam = this.height;
        if (doubleParam != null) {
            return doubleParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("height");
        return null;
    }

    public final void setHeight(DoubleParam doubleParam) {
        Intrinsics.checkNotNullParameter(doubleParam, "<set-?>");
        this.height = doubleParam;
    }

    public final UIColorParam getMaskBgColor() {
        UIColorParam uIColorParam = this.maskBgColor;
        if (uIColorParam != null) {
            return uIColorParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("maskBgColor");
        return null;
    }

    public final void setMaskBgColor(UIColorParam uIColorParam) {
        Intrinsics.checkNotNullParameter(uIColorParam, "<set-?>");
        this.maskBgColor = uIColorParam;
    }

    public final DoubleParam getRadius() {
        DoubleParam doubleParam = this.radius;
        if (doubleParam != null) {
            return doubleParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("radius");
        return null;
    }

    public final void setRadius(DoubleParam doubleParam) {
        Intrinsics.checkNotNullParameter(doubleParam, "<set-?>");
        this.radius = doubleParam;
    }

    public final DoubleParam getSchemaRadius() {
        DoubleParam doubleParam = this.schemaRadius;
        if (doubleParam != null) {
            return doubleParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("schemaRadius");
        return null;
    }

    public final void setSchemaRadius(DoubleParam doubleParam) {
        Intrinsics.checkNotNullParameter(doubleParam, "<set-?>");
        this.schemaRadius = doubleParam;
    }

    public final BooleanParam getShowMask() {
        BooleanParam booleanParam = this.showMask;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("showMask");
        return null;
    }

    public final void setShowMask(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.showMask = booleanParam;
    }

    public final IntegerParam getTransitionAnimation() {
        IntegerParam integerParam = this.transitionAnimation;
        if (integerParam != null) {
            return integerParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("transitionAnimation");
        return null;
    }

    public final void setTransitionAnimation(IntegerParam integerParam) {
        Intrinsics.checkNotNullParameter(integerParam, "<set-?>");
        this.transitionAnimation = integerParam;
    }

    public final DoubleParam getWidth() {
        DoubleParam doubleParam = this.width;
        if (doubleParam != null) {
            return doubleParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("width");
        return null;
    }

    public final void setWidth(DoubleParam doubleParam) {
        Intrinsics.checkNotNullParameter(doubleParam, "<set-?>");
        this.width = doubleParam;
    }

    @Override // com.bytedance.ies.bullet.service.schema.ISchemaModel
    public void initWithData(ISchemaData schemaData) {
        Intrinsics.checkNotNullParameter(schemaData, "schemaData");
        setDisableOutsideClickClose(new BooleanParam(schemaData, "disable_outside_click_close", false));
        setEnablePullDownClose(new BooleanParam(schemaData, "enable_pull_down_close", false));
        setGravity(new PopupTypeParam(schemaData, SchemaConstants.QUERY_KEY_GRAVITY, PopupType.BOTTOM));
        setHeight(new DoubleParam(schemaData, "height", null));
        setMaskBgColor(new UIColorParam(schemaData, "mask_bg_color", null));
        setRadius(new DoubleParam(schemaData, "radius", Double.valueOf(8.0d)));
        setSchemaRadius(new DoubleParam(schemaData, "radius", null));
        setShowMask(new BooleanParam(schemaData, "show_mask", false));
        setTransitionAnimation(new IntegerParam(schemaData, "transition_animation", 0));
        setWidth(new DoubleParam(schemaData, "width", null));
    }
}
