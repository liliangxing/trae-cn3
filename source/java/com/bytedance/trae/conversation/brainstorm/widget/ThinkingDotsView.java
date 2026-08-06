package com.bytedance.trae.conversation.brainstorm.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.bytedance.webx.core.webview.WebViewContainer;
import com.lynx.tasm.base.trace.TraceEventDef;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ThinkingDotsView.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 $2\u00020\u0001:\u0001$B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0018\u001a\u00020\u0019J\u0006\u0010\u001a\u001a\u00020\u0019J\b\u0010\u001b\u001a\u00020\u0019H\u0014J\b\u0010\u001c\u001a\u00020\u0019H\u0014J\u0018\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u0007H\u0014J\u0010\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u00020\"H\u0014J\b\u0010#\u001a\u00020\u0019H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/widget/ThinkingDotsView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "density", "", "dotDiameter", "dotRadius", "dotSpacing", "desiredWidth", "desiredHeight", "baseColor", "highlightColor", "paint", "Landroid/graphics/Paint;", "animator", "Landroid/animation/ValueAnimator;", "shimmerProgress", "startShimmer", "", "stopShimmer", WebViewContainer.EVENT_onAttachedToWindow, "onDetachedFromWindow", WebViewContainer.EVENT_onMeasure, TraceEventDef.WIDTH_MEASURE_SPEC, TraceEventDef.HEIGHT_MEASURE_SPEC, WebViewContainer.EVENT_onDraw, "canvas", "Landroid/graphics/Canvas;", "updateShader", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ThinkingDotsView extends View {
    private static final Companion Companion = new Companion(null);
    private static final int DOT_COUNT = 3;
    private static final long SHIMMER_DURATION_MS = 1500;
    private ValueAnimator animator;
    private final int baseColor;
    private final float density;
    private final int desiredHeight;
    private final int desiredWidth;
    private final float dotDiameter;
    private final float dotRadius;
    private final float dotSpacing;
    private final int highlightColor;
    private final Paint paint;
    private float shimmerProgress;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ThinkingDotsView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ThinkingDotsView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ ThinkingDotsView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThinkingDotsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        float f = getResources().getDisplayMetrics().density;
        this.density = f;
        float f2 = 8.0f * f;
        this.dotDiameter = f2;
        this.dotRadius = f2 / 2.0f;
        float f3 = f * 5.0f;
        this.dotSpacing = f3;
        this.desiredWidth = (int) ((3 * f2) + (f3 * 2));
        this.desiredHeight = (int) f2;
        this.baseColor = 863204211;
        this.highlightColor = -2760714;
        Paint paint = new Paint(1);
        paint.setColor(863204211);
        paint.setStyle(Paint.Style.FILL);
        this.paint = paint;
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
        ofFloat.setDuration(1500L);
        ofFloat.setRepeatCount(-1);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.trae.conversation.brainstorm.widget.ThinkingDotsView$$ExternalSyntheticLambda0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                ThinkingDotsView.startShimmer$lambda$2$lambda$1(ThinkingDotsView.this, valueAnimator2);
            }
        });
        ofFloat.start();
        this.animator = ofFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startShimmer$lambda$2$lambda$1(ThinkingDotsView thinkingDotsView, ValueAnimator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        thinkingDotsView.shimmerProgress = ((Float) animatedValue).floatValue();
        thinkingDotsView.invalidate();
    }

    public final void stopShimmer() {
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.animator = null;
        this.paint.setShader(null);
        this.paint.setColor(this.baseColor);
        invalidate();
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        startShimmer();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        stopShimmer();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(View.resolveSize(this.desiredWidth, widthMeasureSpec), View.resolveSize(this.desiredHeight, heightMeasureSpec));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        updateShader();
        float width = ((getWidth() - ((this.dotDiameter * 3) + (this.dotSpacing * 2))) / 2.0f) + this.dotRadius;
        float height = getHeight() / 2.0f;
        for (int i = 0; i < 3; i++) {
            canvas.drawCircle((i * (this.dotDiameter + this.dotSpacing)) + width, height, this.dotRadius, this.paint);
        }
    }

    private final void updateShader() {
        ValueAnimator valueAnimator = this.animator;
        if (!(valueAnimator != null && valueAnimator.isRunning()) || getWidth() <= 0) {
            this.paint.setShader(null);
            this.paint.setColor(this.baseColor);
            return;
        }
        float width = getWidth() * 0.8f;
        float width2 = (-width) + ((getWidth() + (2 * width)) * this.shimmerProgress);
        Paint paint = this.paint;
        float f = width2 - width;
        float f2 = width2 + width;
        int i = this.baseColor;
        paint.setShader(new LinearGradient(f, 0.0f, f2, 0.0f, new int[]{i, this.highlightColor, i}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
    }

    /* compiled from: ThinkingDotsView.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/widget/ThinkingDotsView$Companion;", "", "<init>", "()V", "DOT_COUNT", "", "SHIMMER_DURATION_MS", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
