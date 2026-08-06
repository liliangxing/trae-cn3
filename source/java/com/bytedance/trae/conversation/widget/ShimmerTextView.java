package com.bytedance.trae.conversation.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import com.bytedance.trae.common_ui.C0591R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ShimmerTextView.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 ,2\u00020\u0001:\u0001,B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\rJ\b\u0010\u001f\u001a\u00020\u001dH\u0002J\b\u0010 \u001a\u00020\u001dH\u0002J(\u0010!\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0007H\u0014J\b\u0010&\u001a\u00020\u001dH\u0014J\b\u0010'\u001a\u00020\u001dH\u0014J\u0018\u0010(\u001a\u00020\u001d2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u0007H\u0014R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006-"}, d2 = {"Lcom/bytedance/trae/conversation/widget/ShimmerTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "shimmerAnimator", "Landroid/animation/ValueAnimator;", "shimmerEnabled", "", "gradient", "Landroid/graphics/LinearGradient;", "gradientMatrix", "Landroid/graphics/Matrix;", "shimmerBaseColor", "shimmerHighlightColor", "timeoutRunnable", "Ljava/lang/Runnable;", "shimmerTimeoutMs", "", "getShimmerTimeoutMs", "()J", "setShimmerTimeoutMs", "(J)V", "setShimmerEnabled", "", "enabled", "startShimmer", "stopShimmer", "onSizeChanged", "w", "h", "oldw", "oldh", "onAttachedToWindow", "onDetachedFromWindow", "onVisibilityChanged", "changedView", "Landroid/view/View;", "visibility", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ShimmerTextView extends AppCompatTextView {
    public static final long NO_TIMEOUT = 0;
    private LinearGradient gradient;
    private final Matrix gradientMatrix;
    private ValueAnimator shimmerAnimator;
    private final int shimmerBaseColor;
    private boolean shimmerEnabled;
    private final int shimmerHighlightColor;
    private long shimmerTimeoutMs;
    private Runnable timeoutRunnable;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ShimmerTextView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ShimmerTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ ShimmerTextView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShimmerTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.gradientMatrix = new Matrix();
        this.shimmerBaseColor = ContextCompat.getColor(context, C0591R.color.trae_brand_brand_grey_600);
        this.shimmerHighlightColor = ContextCompat.getColor(context, C0591R.color.trae_brand_brand_grey_300);
    }

    public final long getShimmerTimeoutMs() {
        return this.shimmerTimeoutMs;
    }

    public final void setShimmerTimeoutMs(long j) {
        this.shimmerTimeoutMs = j;
    }

    public final void setShimmerEnabled(boolean enabled) {
        if (this.shimmerEnabled == enabled) {
            return;
        }
        this.shimmerEnabled = enabled;
        if (enabled) {
            startShimmer();
        } else {
            stopShimmer();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startShimmer() {
        ValueAnimator valueAnimator = this.shimmerAnimator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            return;
        }
        if (getWidth() == 0) {
            post(new Runnable() { // from class: com.bytedance.trae.conversation.widget.ShimmerTextView$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    ShimmerTextView.this.startShimmer();
                }
            });
            return;
        }
        float width = getWidth();
        int i = this.shimmerBaseColor;
        this.gradient = new LinearGradient(0.0f, 0.0f, width, 0.0f, new int[]{i, this.shimmerHighlightColor, i}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP);
        getPaint().setShader(this.gradient);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(-width, width);
        ofFloat.setDuration(1500L);
        ofFloat.setRepeatCount(-1);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.trae.conversation.widget.ShimmerTextView$$ExternalSyntheticLambda1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                ShimmerTextView.startShimmer$lambda$2$lambda$1(ShimmerTextView.this, valueAnimator2);
            }
        });
        ofFloat.start();
        this.shimmerAnimator = ofFloat;
        if (this.shimmerTimeoutMs > 0) {
            Runnable runnable = new Runnable() { // from class: com.bytedance.trae.conversation.widget.ShimmerTextView$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    ShimmerTextView.startShimmer$lambda$3(ShimmerTextView.this);
                }
            };
            this.timeoutRunnable = runnable;
            postDelayed(runnable, this.shimmerTimeoutMs);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startShimmer$lambda$2$lambda$1(ShimmerTextView shimmerTextView, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(valueAnimator, "animation");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        shimmerTextView.gradientMatrix.reset();
        shimmerTextView.gradientMatrix.setTranslate(floatValue, 0.0f);
        LinearGradient linearGradient = shimmerTextView.gradient;
        if (linearGradient != null) {
            linearGradient.setLocalMatrix(shimmerTextView.gradientMatrix);
        }
        shimmerTextView.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startShimmer$lambda$3(ShimmerTextView shimmerTextView) {
        if (shimmerTextView.shimmerEnabled) {
            shimmerTextView.setShimmerEnabled(false);
        }
    }

    private final void stopShimmer() {
        Runnable runnable = this.timeoutRunnable;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        this.timeoutRunnable = null;
        ValueAnimator valueAnimator = this.shimmerAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.shimmerAnimator = null;
        this.gradient = null;
        getPaint().setShader(null);
        invalidate();
    }

    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (!this.shimmerEnabled || w <= 0) {
            return;
        }
        stopShimmer();
        startShimmer();
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.shimmerEnabled) {
            startShimmer();
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopShimmer();
    }

    protected void onVisibilityChanged(View changedView, int visibility) {
        Intrinsics.checkNotNullParameter(changedView, "changedView");
        super.onVisibilityChanged(changedView, visibility);
        if (visibility != 0) {
            stopShimmer();
        } else if (this.shimmerEnabled) {
            startShimmer();
        }
    }
}
