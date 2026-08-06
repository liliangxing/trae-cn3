package com.bytedance.trae.conversation.brainstorm.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.bytedance.trae.conversation.R;
import com.bytedance.webx.core.webview.WebViewContainer;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ShimmerTextView.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0007J\u0006\u0010\u0016\u001a\u00020\u0013J\u0006\u0010\u0017\u001a\u00020\u0013J(\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0007H\u0014J\b\u0010\u001d\u001a\u00020\u0013H\u0014J\b\u0010\u001e\u001a\u00020\u0013H\u0002R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/widget/ShimmerTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "baseColor", "highlightColor", "shimmerDuration", "", "animator", "Landroid/animation/ValueAnimator;", "shimmerProgress", "", "setShimmerColors", "", TraceStatsConsts.STATS_BASE_MODULE, "highlight", "startShimmer", "stopShimmer", WebViewContainer.EVENT_onSizeChanged, "w", RXScreenCaptureService.KEY_HEIGHT, "oldw", "oldh", "onDetachedFromWindow", "updateShader", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ShimmerTextView extends AppCompatTextView {
    private ValueAnimator animator;
    private int baseColor;
    private int highlightColor;
    private long shimmerDuration;
    private float shimmerProgress;

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
        this.baseColor = ContextCompat.getColor(context, R.color.trae_shimmer_text_base);
        this.highlightColor = ContextCompat.getColor(context, R.color.trae_shimmer_text_highlight);
        this.shimmerDuration = 1500L;
    }

    public final void setShimmerColors(int base, int highlight) {
        this.baseColor = base;
        this.highlightColor = highlight;
        updateShader();
    }

    public final void startShimmer() {
        ValueAnimator valueAnimator = this.animator;
        boolean z = false;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            z = true;
        }
        if (z) {
            return;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(this.shimmerDuration);
        ofFloat.setRepeatCount(-1);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.trae.conversation.brainstorm.widget.ShimmerTextView$$ExternalSyntheticLambda0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                ShimmerTextView.startShimmer$lambda$1$lambda$0(ShimmerTextView.this, valueAnimator2);
            }
        });
        ofFloat.start();
        this.animator = ofFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startShimmer$lambda$1$lambda$0(ShimmerTextView shimmerTextView, ValueAnimator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        shimmerTextView.shimmerProgress = ((Float) animatedValue).floatValue();
        shimmerTextView.updateShader();
    }

    public final void stopShimmer() {
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.animator = null;
        getPaint().setShader(null);
        setTextColor(this.baseColor);
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        ValueAnimator valueAnimator = this.animator;
        boolean z = false;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            z = true;
        }
        if (z) {
            updateShader();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.AppCompatTextView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.animator = null;
    }

    private final void updateShader() {
        float measureText = getPaint().measureText(getText().toString());
        if (measureText <= 0.0f) {
            return;
        }
        float f = 0.4f * measureText;
        float f2 = (-f) + ((measureText + (2 * f)) * this.shimmerProgress);
        float f3 = f2 - f;
        float f4 = f2 + f;
        int i = this.baseColor;
        getPaint().setShader(new LinearGradient(f3, 0.0f, f4, 0.0f, new int[]{i, this.highlightColor, i}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
        invalidate();
    }
}
