package com.bytedance.trae.conversation.widget;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.bytedance.sdk.xbridge.cn.calendar.reducer.ReducerConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: LoadingDotsView.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u0007H\u0014J\u0010\u0010'\u001a\u00020$2\u0006\u0010(\u001a\u00020)H\u0014J\u0006\u0010*\u001a\u00020$J\u0006\u0010+\u001a\u00020$J\b\u0010,\u001a\u00020$H\u0014J\b\u0010-\u001a\u00020$H\u0014J\u0018\u0010.\u001a\u00020$2\u0006\u0010/\u001a\u00020\u00012\u0006\u00100\u001a\u00020\u0007H\u0014J\u0010\u00101\u001a\u00020\u00102\u0006\u00102\u001a\u00020\u0010H\u0002R$\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0010@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0016\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR$\u0010\u0019\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0010@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/bytedance/trae/conversation/widget/LoadingDotsView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "dotColor", "getDotColor", "()I", "setDotColor", "(I)V", "", "dotSizePx", "getDotSizePx", "()F", "setDotSizePx", "(F)V", "dotCount", "getDotCount", "setDotCount", "dotSpacingPx", "getDotSpacingPx", "setDotSpacingPx", "paint", "Landroid/graphics/Paint;", "dotAlphas", "", "dotScales", "animatorSet", "Landroid/animation/AnimatorSet;", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "onDraw", "canvas", "Landroid/graphics/Canvas;", "startAnimation", "stopAnimation", "onAttachedToWindow", "onDetachedFromWindow", "onVisibilityChanged", "changedView", "visibility", "dpToPx", "dp", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class LoadingDotsView extends View {
    private AnimatorSet animatorSet;
    private float[] dotAlphas;
    private int dotColor;
    private int dotCount;
    private float[] dotScales;
    private float dotSizePx;
    private float dotSpacingPx;
    private final Paint paint;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LoadingDotsView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LoadingDotsView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ LoadingDotsView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoadingDotsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.dotColor = Color.parseColor("#333333");
        this.dotSizePx = dpToPx(8.0f);
        this.dotCount = 2;
        this.dotSpacingPx = dpToPx(4.0f);
        Paint paint = new Paint(1);
        paint.setColor(this.dotColor);
        this.paint = paint;
        int i2 = this.dotCount;
        float[] fArr = new float[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            fArr[i3] = 1.0f;
        }
        this.dotAlphas = fArr;
        int i4 = this.dotCount;
        float[] fArr2 = new float[i4];
        for (int i5 = 0; i5 < i4; i5++) {
            fArr2[i5] = 1.0f;
        }
        this.dotScales = fArr2;
    }

    public final int getDotColor() {
        return this.dotColor;
    }

    public final void setDotColor(int i) {
        this.dotColor = i;
        this.paint.setColor(i);
        invalidate();
    }

    public final float getDotSizePx() {
        return this.dotSizePx;
    }

    public final void setDotSizePx(float f) {
        this.dotSizePx = f;
        requestLayout();
    }

    public final int getDotCount() {
        return this.dotCount;
    }

    public final void setDotCount(int i) {
        this.dotCount = i;
        float[] fArr = new float[i];
        for (int i2 = 0; i2 < i; i2++) {
            fArr[i2] = 1.0f;
        }
        this.dotAlphas = fArr;
        float[] fArr2 = new float[i];
        for (int i3 = 0; i3 < i; i3++) {
            fArr2[i3] = 1.0f;
        }
        this.dotScales = fArr2;
        requestLayout();
    }

    public final float getDotSpacingPx() {
        return this.dotSpacingPx;
    }

    public final void setDotSpacingPx(float f) {
        this.dotSpacingPx = f;
        requestLayout();
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(View.resolveSize(((int) ((this.dotSizePx * this.dotCount) + (this.dotSpacingPx * (r1 - 1)))) + getPaddingLeft() + getPaddingRight(), widthMeasureSpec), View.resolveSize(((int) this.dotSizePx) + getPaddingTop() + getPaddingBottom(), heightMeasureSpec));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        float f = this.dotSizePx / 2.0f;
        float paddingLeft = getPaddingLeft() + f;
        float paddingTop = getPaddingTop() + f;
        int i = this.dotCount;
        for (int i2 = 0; i2 < i; i2++) {
            float f2 = (i2 * (this.dotSizePx + this.dotSpacingPx)) + paddingLeft;
            this.paint.setAlpha((int) (this.dotAlphas[i2] * ReducerConstants.REQUEST_CODE));
            canvas.drawCircle(f2, paddingTop, this.dotScales[i2] * f, this.paint);
        }
    }

    public final void startAnimation() {
        stopAnimation();
        Iterable until = RangesKt.until(0, this.dotCount);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(until, 10));
        IntIterator it = until.iterator();
        while (it.hasNext()) {
            final int nextInt = it.nextInt();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "dotAlpha" + nextInt, 1.0f, 0.3f, 1.0f);
            ofFloat.setDuration(1400L);
            long j = nextInt * 200;
            ofFloat.setStartDelay(j);
            ofFloat.setRepeatCount(-1);
            ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.trae.conversation.widget.LoadingDotsView$$ExternalSyntheticLambda0
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    LoadingDotsView.startAnimation$lambda$5$lambda$2$lambda$1(LoadingDotsView.this, nextInt, valueAnimator);
                }
            });
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, "dotScale" + nextInt, 1.0f, 0.85f, 1.0f);
            ofFloat2.setDuration(1400L);
            ofFloat2.setStartDelay(j);
            ofFloat2.setRepeatCount(-1);
            ofFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
            ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.trae.conversation.widget.LoadingDotsView$$ExternalSyntheticLambda1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    LoadingDotsView.startAnimation$lambda$5$lambda$4$lambda$3(LoadingDotsView.this, nextInt, valueAnimator);
                }
            });
            arrayList.add(CollectionsKt.listOf(new ObjectAnimator[]{ofFloat, ofFloat2}));
        }
        List flatten = CollectionsKt.flatten(arrayList);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(flatten);
        animatorSet.start();
        this.animatorSet = animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startAnimation$lambda$5$lambda$2$lambda$1(LoadingDotsView loadingDotsView, int i, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(valueAnimator, "it");
        float[] fArr = loadingDotsView.dotAlphas;
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        fArr[i] = ((Float) animatedValue).floatValue();
        loadingDotsView.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startAnimation$lambda$5$lambda$4$lambda$3(LoadingDotsView loadingDotsView, int i, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(valueAnimator, "it");
        float[] fArr = loadingDotsView.dotScales;
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        fArr[i] = ((Float) animatedValue).floatValue();
    }

    public final void stopAnimation() {
        AnimatorSet animatorSet = this.animatorSet;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        this.animatorSet = null;
        ArraysKt.fill$default(this.dotAlphas, 1.0f, 0, 0, 6, (Object) null);
        ArraysKt.fill$default(this.dotScales, 1.0f, 0, 0, 6, (Object) null);
        invalidate();
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        startAnimation();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        stopAnimation();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View changedView, int visibility) {
        Intrinsics.checkNotNullParameter(changedView, "changedView");
        super.onVisibilityChanged(changedView, visibility);
        if (visibility == 0) {
            startAnimation();
        } else {
            stopAnimation();
        }
    }

    private final float dpToPx(float dp) {
        return dp * getContext().getResources().getDisplayMetrics().density;
    }
}
