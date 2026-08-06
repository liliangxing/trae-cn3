package com.bytedance.trae.common.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import androidx.core.content.ContextCompat;
import com.bytedance.tracing.log.Fields;
import com.bytedance.trae.common_ui.C0591R;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TraeTitleBar.kt */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010-\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u00072\b\b\u0002\u0010.\u001a\u00020/J\u0006\u00100\u001a\u00020\u0007J\u0006\u00101\u001a\u000202J\u0018\u00103\u001a\u00020\u00112\u0006\u00104\u001a\u00020\u00072\u0006\u00105\u001a\u00020\u0007H\u0014J(\u00106\u001a\u00020\u00112\u0006\u00107\u001a\u00020\u00072\u0006\u00108\u001a\u00020\u00072\u0006\u00109\u001a\u00020\u00072\u0006\u0010:\u001a\u00020\u0007H\u0014J\u0010\u0010;\u001a\u00020\u00112\u0006\u0010<\u001a\u00020=H\u0014J\u0010\u0010>\u001a\u00020/2\u0006\u0010?\u001a\u00020@H\u0016J\b\u0010A\u001a\u00020/H\u0016J\b\u0010B\u001a\u00020\u0011H\u0014J\u0018\u0010C\u001a\u00020\u00112\u0006\u0010D\u001a\u00020\u001c2\u0006\u0010E\u001a\u00020\u001cH\u0002J\u0010\u0010F\u001a\u00020\u001c2\u0006\u0010\u000e\u001a\u00020\u0007H\u0002RL\u0010\n\u001a4\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020'X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006G"}, d2 = {"Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "onTabSelected", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "index", "", "tab", "", "getOnTabSelected", "()Lkotlin/jvm/functions/Function2;", "setOnTabSelected", "(Lkotlin/jvm/functions/Function2;)V", "tabs", "", "segmentWidth", "segmentHeight", "slotWidth", "padding", "", "selectedWidth", "shadowRadius", "shadowDy", "outerRadius", "selectedRadius", "selectedIndex", "selectedLeft", "animator", "Landroid/animation/ValueAnimator;", "outerRect", "Landroid/graphics/RectF;", "selectedRect", "outerPaint", "Landroid/graphics/Paint;", "selectedPaint", "textPaint", "setSelectedIndex", "animate", "", "getSelectedIndex", "getSelectedTab", "", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onSizeChanged", "w", "h", "oldw", "oldh", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onTouchEvent", Fields.EVENT, "Landroid/view/MotionEvent;", "performClick", "onDetachedFromWindow", "animateSelection", "fromLeft", "toLeft", "selectionLeftFor", "common-ui_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TitleBarSegmentedControl extends View {
    private ValueAnimator animator;
    private Function2<? super Integer, ? super String, Unit> onTabSelected;
    private final Paint outerPaint;
    private final float outerRadius;
    private final RectF outerRect;
    private final float padding;
    private final int segmentHeight;
    private final int segmentWidth;
    private int selectedIndex;
    private float selectedLeft;
    private final Paint selectedPaint;
    private final float selectedRadius;
    private final RectF selectedRect;
    private final int selectedWidth;
    private final float shadowDy;
    private final float shadowRadius;
    private final int slotWidth;
    private final List<String> tabs;
    private final Paint textPaint;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TitleBarSegmentedControl(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TitleBarSegmentedControl(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ TitleBarSegmentedControl(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TitleBarSegmentedControl(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.tabs = CollectionsKt.listOf(new String[]{"Work", "Code"});
        this.segmentWidth = getResources().getDimensionPixelSize(C0591R.dimen.trae_title_bar_segment_width);
        int dimensionPixelSize = getResources().getDimensionPixelSize(C0591R.dimen.trae_title_bar_page_height);
        this.segmentHeight = dimensionPixelSize;
        this.slotWidth = getResources().getDimensionPixelSize(C0591R.dimen.trae_title_bar_segment_slot_width);
        float dimensionPixelSize2 = getResources().getDimensionPixelSize(C0591R.dimen.trae_title_bar_segment_padding);
        this.padding = dimensionPixelSize2;
        this.selectedWidth = getResources().getDimensionPixelSize(C0591R.dimen.trae_title_bar_segment_selected_width);
        float dimension = getResources().getDimension(C0591R.dimen.trae_title_bar_segment_shadow_blur_radius);
        this.shadowRadius = dimension;
        float dimension2 = getResources().getDimension(C0591R.dimen.trae_title_bar_shadow_offset_y);
        this.shadowDy = dimension2;
        this.outerRadius = dimensionPixelSize / 2.0f;
        this.selectedRadius = (dimensionPixelSize - (dimensionPixelSize2 * 2.0f)) / 2.0f;
        this.selectedLeft = selectionLeftFor(this.selectedIndex);
        this.outerRect = new RectF();
        this.selectedRect = new RectF();
        Paint paint = new Paint(1);
        paint.setColor(ContextCompat.getColor(context, C0591R.color.trae_bg_bg_overlay_l3));
        paint.setStyle(Paint.Style.FILL);
        this.outerPaint = paint;
        Paint paint2 = new Paint(1);
        paint2.setColor(ContextCompat.getColor(context, C0591R.color.trae_bg_bg_menu));
        paint2.setStyle(Paint.Style.FILL);
        paint2.setShadowLayer(dimension, 0.0f, dimension2, ContextCompat.getColor(context, C0591R.color.trae_title_bar_shadow));
        this.selectedPaint = paint2;
        Paint paint3 = new Paint(1);
        paint3.setColor(ContextCompat.getColor(context, C0591R.color.trae_text_text_default));
        paint3.setTextAlign(Paint.Align.CENTER);
        paint3.setTypeface(Typeface.create("sans-serif-medium", 0));
        paint3.setTextSize(getResources().getDimension(C0591R.dimen.trae_body_body_xs_font_size_sp));
        this.textPaint = paint3;
        setClickable(true);
        setFocusable(true);
        setLayerType(1, null);
    }

    public final Function2<Integer, String, Unit> getOnTabSelected() {
        return this.onTabSelected;
    }

    public final void setOnTabSelected(Function2<? super Integer, ? super String, Unit> function2) {
        this.onTabSelected = function2;
    }

    public static /* synthetic */ void setSelectedIndex$default(TitleBarSegmentedControl titleBarSegmentedControl, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = true;
        }
        titleBarSegmentedControl.setSelectedIndex(i, z);
    }

    public final void setSelectedIndex(int index, boolean animate) {
        boolean z = false;
        if (index >= 0 && index < this.tabs.size()) {
            z = true;
        }
        if (z) {
            int i = this.selectedIndex;
            this.selectedIndex = index;
            if (animate && i != index && getWidth() > 0) {
                animateSelection(selectionLeftFor(i), selectionLeftFor(index));
            } else {
                this.selectedLeft = selectionLeftFor(index);
                invalidate();
            }
            Function2<? super Integer, ? super String, Unit> function2 = this.onTabSelected;
            if (function2 != null) {
                function2.invoke(Integer.valueOf(index), this.tabs.get(index));
            }
        }
    }

    public final int getSelectedIndex() {
        return this.selectedIndex;
    }

    public final CharSequence getSelectedTab() {
        return this.tabs.get(this.selectedIndex);
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(View.resolveSize(this.segmentWidth, widthMeasureSpec), View.resolveSize(this.segmentHeight, heightMeasureSpec));
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.selectedLeft = selectionLeftFor(this.selectedIndex);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        this.outerRect.set(0.0f, 0.0f, getWidth(), getHeight());
        RectF rectF = this.outerRect;
        float f = this.outerRadius;
        canvas.drawRoundRect(rectF, f, f, this.outerPaint);
        RectF rectF2 = this.selectedRect;
        float f2 = this.selectedLeft;
        rectF2.set(f2, this.padding, this.selectedWidth + f2, getHeight() - this.padding);
        RectF rectF3 = this.selectedRect;
        float f3 = this.selectedRadius;
        canvas.drawRoundRect(rectF3, f3, f3, this.selectedPaint);
        float height = (getHeight() / 2.0f) - ((this.textPaint.ascent() + this.textPaint.descent()) / 2.0f);
        int i = 0;
        for (Object obj : this.tabs) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            canvas.drawText((String) obj, (i * r6) + (this.slotWidth / 2.0f), height, this.textPaint);
            i = i2;
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, Fields.EVENT);
        if (!isEnabled()) {
            return false;
        }
        int action = event.getAction();
        if (action == 0) {
            return true;
        }
        if (action == 1) {
            int coerceIn = RangesKt.coerceIn((int) (event.getX() / this.slotWidth), 0, CollectionsKt.getLastIndex(this.tabs));
            if (coerceIn != this.selectedIndex) {
                setSelectedIndex(coerceIn, true);
            }
            performClick();
            return true;
        }
        return super.onTouchEvent(event);
    }

    @Override // android.view.View
    public boolean performClick() {
        return super.performClick();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.animator = null;
    }

    private final void animateSelection(float fromLeft, float toLeft) {
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fromLeft, toLeft);
        ofFloat.setDuration(250L);
        ofFloat.setInterpolator(new DecelerateInterpolator(1.5f));
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.trae.common.widget.TitleBarSegmentedControl$$ExternalSyntheticLambda0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                TitleBarSegmentedControl.animateSelection$lambda$5$lambda$4(TitleBarSegmentedControl.this, valueAnimator2);
            }
        });
        ofFloat.start();
        this.animator = ofFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void animateSelection$lambda$5$lambda$4(TitleBarSegmentedControl titleBarSegmentedControl, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(valueAnimator, "animation");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        titleBarSegmentedControl.selectedLeft = ((Float) animatedValue).floatValue();
        titleBarSegmentedControl.invalidate();
    }

    private final float selectionLeftFor(int index) {
        int i = this.slotWidth;
        return (index * i) + ((i - this.selectedWidth) / 2.0f);
    }
}
