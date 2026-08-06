package com.bytedance.trae.conversation.widget;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: SpeakerInterpolator.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0016\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u0007X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/bytedance/trae/conversation/widget/EaseCubicInterpolator;", "Landroid/view/animation/Interpolator;", "<init>", "()V", "mLastI", "", "mControlPoint1", "Landroid/graphics/PointF;", "getMControlPoint1", "()Landroid/graphics/PointF;", "mControlPoint2", "getMControlPoint2", "getInterpolation", "", "input", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public class EaseCubicInterpolator implements Interpolator {
    private static final int ACCURACY = 4096;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final PointF mControlPoint1 = new PointF();
    private final PointF mControlPoint2 = new PointF();
    private int mLastI;

    /* JADX INFO: Access modifiers changed from: protected */
    public final PointF getMControlPoint1() {
        return this.mControlPoint1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final PointF getMControlPoint2() {
        return this.mControlPoint2;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float input) {
        int i = this.mLastI;
        float f = input;
        while (true) {
            if (i >= 4096) {
                break;
            }
            f = (i * 1.0f) / 4096;
            if (INSTANCE.cubicCurves(f, 0.0d, this.mControlPoint1.x, this.mControlPoint2.x, 1.0d) >= input) {
                this.mLastI = i;
                break;
            }
            i++;
        }
        double cubicCurves = INSTANCE.cubicCurves(f, 0.0d, this.mControlPoint1.y, this.mControlPoint2.y, 1.0d);
        if (cubicCurves > 0.999d) {
            this.mLastI = 0;
            cubicCurves = 1.0d;
        }
        return (float) cubicCurves;
    }

    /* compiled from: SpeakerInterpolator.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/bytedance/trae/conversation/widget/EaseCubicInterpolator$Companion;", "", "<init>", "()V", "ACCURACY", "", "cubicCurves", "", "t", "value0", "value1", "value2", "value3", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final double cubicCurves(double t, double value0, double value1, double value2, double value3) {
            double d = 1 - t;
            double d2 = t * t;
            double d3 = d * d;
            double d4 = 3;
            return (d3 * d * value0) + (d3 * d4 * t * value1) + (d4 * d * d2 * value2) + (d2 * t * value3);
        }

        private Companion() {
        }
    }
}
