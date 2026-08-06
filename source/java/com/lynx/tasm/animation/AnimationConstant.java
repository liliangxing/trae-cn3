package com.lynx.tasm.animation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes6.dex */
public final class AnimationConstant {
    public static final int[] ALL_PLATFORM_TRANSITION_PROPS_ARR = {1, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096};
    public static final String C_DELAY = "layout-animation-create-delay";
    public static final String C_DURATION = "layout-animation-create-duration";
    public static final String C_PROPERTY = "layout-animation-create-property";
    public static final String C_TIMING_FUNCTION = "layout-animation-create-timing-function";
    public static final String D_DELAY = "layout-animation-delete-delay";
    public static final String D_DURATION = "layout-animation-delete-duration";
    public static final String D_PROPERTY = "layout-animation-delete-property";
    public static final String D_TIMING_FUNCTION = "layout-animation-delete-timing-function";
    public static final int INTERCEPTOR_CUBIC_BEZIER = 5;
    public static final int INTERCEPTOR_EASE_IN = 1;
    public static final int INTERCEPTOR_EASE_IN_OUT = 3;
    public static final int INTERCEPTOR_EASE_OUT = 2;
    public static final int INTERCEPTOR_LINEAR = 0;
    public static final int INTERCEPTOR_SQUARE_BEZIER = 4;
    public static final int INTERCEPTOR_STEPS = 6;
    public static final int LAYOUT_ANIMATION_TYPE_CREATE = 0;
    public static final int LAYOUT_ANIMATION_TYPE_DELETE = 2;
    public static final int LAYOUT_ANIMATION_TYPE_UPDATE = 1;
    public static final int PROP_BACKGROUND_COLOR = 64;
    public static final int PROP_BOTTOM = 2048;
    public static final int PROP_COLOR = 8192;
    public static final int PROP_HEIGHT = 32;
    public static final int PROP_LEFT = 256;
    public static final int PROP_MAX_HEIGHT = 65536;
    public static final int PROP_MAX_WIDTH = 16384;
    public static final int PROP_MIN_HEIGHT = 131072;
    public static final int PROP_MIN_WIDTH = 32768;
    public static final int PROP_NONE = 0;
    public static final int PROP_OF_LAYOUT = 3888;
    public static final int PROP_OPACITY = 1;
    public static final int PROP_RIGHT = 1024;
    public static final int PROP_SCALE_X = 2;
    public static final int PROP_SCALE_X_Y = 8;
    public static final int PROP_SCALE_Y = 4;
    public static final String PROP_STR_BACKGROUND_COLOR = "background-color";
    public static final String PROP_STR_BOTTOM = "bottom";
    public static final String PROP_STR_HEIGHT = "height";
    public static final String PROP_STR_LEFT = "left";
    public static final String PROP_STR_NONE = "none";
    public static final String PROP_STR_OPACITY = "opacity";
    public static final String PROP_STR_RIGHT = "right";
    public static final String PROP_STR_SCALE_X = "scaleX";
    public static final String PROP_STR_SCALE_X_Y = "scaleXY";
    public static final String PROP_STR_SCALE_Y = "scaleY";
    public static final String PROP_STR_TOP = "top";
    public static final String PROP_STR_TRANSFORM = "transform";
    public static final String PROP_STR_VISIBILITY = "visibility";
    public static final String PROP_STR_WIDTH = "width";
    public static final int PROP_TOP = 512;
    public static final int PROP_TRANSFORM = 4096;
    public static final int PROP_VISIBILITY = 128;
    public static final int PROP_WIDTH = 16;
    public static final String TRANSITION = "transition";
    public static final int TRAN_PROP_ALL = 262144;
    public static final int TRAN_PROP_LEGACY_ALL_1 = 8177;
    public static final int TRAN_PROP_LEGACY_ALL_2 = 16369;
    public static final int TRAN_PROP_LEGACY_ALL_3 = 262129;
    public static final String U_DELAY = "layout-animation-update-delay";
    public static final String U_DURATION = "layout-animation-update-duration";
    public static final String U_PROPERTY = "layout-animation-update-property";
    public static final String U_TIMING_FUNCTION = "layout-animation-update-timing-function";

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes6.dex */
    public @interface LayoutAnimationType {
    }
}
