package com.lynx.animax.property;

/* loaded from: classes6.dex */
public interface AnimaXValueCallback {
    AnimaXValueParam getValue(AnimaXFrameInfo animaXFrameInfo);

    default Object getValueInternal(float f, float f2, AnimaXValueParam animaXValueParam, AnimaXValueParam animaXValueParam2, float f3, float f4, float f5) {
        return getValue(new AnimaXFrameInfo(f, f2, animaXValueParam, animaXValueParam2, f3, f4, f5));
    }
}
