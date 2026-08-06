package com.bytedance.trae.conversation.brainstorm.widget;

import android.view.animation.Interpolator;
import kotlin.Metadata;

/* compiled from: StepInterpolator.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/widget/StepInterpolator;", "Landroid/view/animation/Interpolator;", "steps", "", "<init>", "(I)V", "getInterpolation", "", "input", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class StepInterpolator implements Interpolator {
    private final int steps;

    public StepInterpolator(int i) {
        this.steps = i;
        if (!(i > 0)) {
            throw new IllegalArgumentException(("steps must be > 0, got " + i).toString());
        }
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float input) {
        if (input >= 1.0f) {
            return 1.0f;
        }
        if (input <= 0.0f) {
            return 0.0f;
        }
        return ((float) Math.floor(input * this.steps)) / this.steps;
    }
}
