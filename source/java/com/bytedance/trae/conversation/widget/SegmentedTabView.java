package com.bytedance.trae.conversation.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import androidx.core.content.ContextCompat;
import com.bytedance.sdk.xbridge.cn.calendar.reducer.ReducerConstants;
import com.bytedance.tracing.log.Fields;
import com.bytedance.trae.common_ui.C0591R;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: SegmentedTabView.kt */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 `2\u00020\u0001:\u0001`B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u00101\u001a\u00020,H\u0002J\u0014\u00102\u001a\u00020,2\f\u00103\u001a\b\u0012\u0004\u0012\u00020\f0\u000bJ\f\u00104\u001a\b\u0012\u0004\u0012\u00020\f0\u000bJ\u0018\u00105\u001a\u00020,2\u0006\u0010*\u001a\u00020\u00072\b\b\u0002\u00106\u001a\u000207J\u0006\u00108\u001a\u00020\u0007J\u0006\u00109\u001a\u00020\fJ\u0018\u0010:\u001a\u00020,2\u0006\u0010;\u001a\u00020\f2\b\b\u0002\u0010<\u001a\u00020\u000fJ\u000e\u0010=\u001a\u00020,2\u0006\u0010;\u001a\u00020\fJ\u0016\u0010>\u001a\u00020,2\u0006\u0010?\u001a\u00020\f2\u0006\u0010@\u001a\u00020\fJ\u000e\u0010A\u001a\u00020,2\u0006\u0010B\u001a\u00020\u000fJ\u0016\u0010C\u001a\u00020,2\u0006\u0010D\u001a\u00020\u000f2\u0006\u0010E\u001a\u00020\u000fJ\u0018\u0010F\u001a\u00020,2\u0006\u0010G\u001a\u00020\u00072\u0006\u0010H\u001a\u00020\u0007H\u0014J(\u0010I\u001a\u00020,2\u0006\u0010J\u001a\u00020\u00072\u0006\u0010K\u001a\u00020\u00072\u0006\u0010L\u001a\u00020\u00072\u0006\u0010M\u001a\u00020\u0007H\u0014J\u0010\u0010N\u001a\u00020,2\u0006\u0010O\u001a\u00020PH\u0014J\u0010\u0010Q\u001a\u0002072\u0006\u0010R\u001a\u00020SH\u0016J\b\u0010T\u001a\u000207H\u0016J\u0018\u0010U\u001a\u00020,2\u0006\u0010V\u001a\u00020\u00072\u0006\u0010W\u001a\u00020\u0007H\u0002J\b\u0010X\u001a\u00020\u000fH\u0002J\b\u0010Y\u001a\u00020\u000fH\u0002J\u0010\u0010Z\u001a\u00020\u000f2\u0006\u0010*\u001a\u00020\u0007H\u0002J\u0010\u0010[\u001a\u00020\u000f2\u0006\u0010\\\u001a\u00020\u000fH\u0002J\u0010\u0010]\u001a\u00020\u000f2\u0006\u0010\\\u001a\u00020\u000fH\u0002J\u0018\u0010^\u001a\u00020\u00072\u0006\u0010;\u001a\u00020\f2\u0006\u0010<\u001a\u00020\u000fH\u0002J\b\u0010_\u001a\u00020,H\u0014R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000RL\u0010&\u001a4\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(*\u0012\u0013\u0012\u00110\f¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020,\u0018\u00010'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100¨\u0006a"}, d2 = {"Lcom/bytedance/trae/conversation/widget/SegmentedTabView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "tabs", "", "", "selectedIndex", "animatedSelectionX", "", "outerCornerRadius", "innerCornerRadius", "innerPadding", "tabMinWidth", "preferredHeight", "outerBgColor", "selectedBgColor", "selectedTextColor", "unselectedTextColor", "shadowRadius", "shadowDy", "shadowColor", "outerBgPaint", "Landroid/graphics/Paint;", "selectedBgPaint", "selectedTextPaint", "unselectedTextPaint", "outerRect", "Landroid/graphics/RectF;", "selectedRect", "animator", "Landroid/animation/ValueAnimator;", "onTabSelected", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "index", "tab", "", "getOnTabSelected", "()Lkotlin/jvm/functions/Function2;", "setOnTabSelected", "(Lkotlin/jvm/functions/Function2;)V", "applyPaintProperties", "setTabs", "tabList", "getTabs", "setSelectedIndex", "animate", "", "getSelectedIndex", "getSelectedTab", "setOuterBackground", "colorHex", "alpha", "setSelectedBackground", "setTextColors", "selectedHex", "unselectedHex", "setTextSizeSp", "sizeSp", "setCornerRadius", "outerDp", "innerDp", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onSizeChanged", "w", "h", "oldw", "oldh", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onTouchEvent", Fields.EVENT, "Landroid/view/MotionEvent;", "performClick", "animateSelection", "fromIndex", "toIndex", "getTabWidth", "calculateTabWidthByContent", "getSelectionX", "dp", "value", "sp", "parseColorWithAlpha", "onDetachedFromWindow", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class SegmentedTabView extends View {
    private static final long ANIM_DURATION_MS = 250;
    private static final float DEFAULT_INNER_CORNER_RADIUS_DP = 18.0f;
    private static final float DEFAULT_OUTER_CORNER_RADIUS_DP = 22.0f;
    private static final float DEFAULT_OUTER_HEIGHT_DP = 44.0f;
    private static final float DEFAULT_PADDING_DP = 4.0f;
    private static final String DEFAULT_SHADOW_COLOR = "#08000000";
    private static final float DEFAULT_SHADOW_DY_DP = 4.0f;
    private static final float DEFAULT_SHADOW_RADIUS_DP = 15.0f;
    private static final float DEFAULT_TAB_MIN_WIDTH_DP = 80.0f;
    private static final float DEFAULT_TEXT_SIZE_SP = 14.0f;
    public static final int INDEX_CODE = 1;
    public static final int INDEX_MTC = 0;
    private float animatedSelectionX;
    private ValueAnimator animator;
    private float innerCornerRadius;
    private float innerPadding;
    private Function2<? super Integer, ? super String, Unit> onTabSelected;
    private int outerBgColor;
    private final Paint outerBgPaint;
    private float outerCornerRadius;
    private final RectF outerRect;
    private float preferredHeight;
    private int selectedBgColor;
    private final Paint selectedBgPaint;
    private int selectedIndex;
    private final RectF selectedRect;
    private int selectedTextColor;
    private final Paint selectedTextPaint;
    private int shadowColor;
    private float shadowDy;
    private float shadowRadius;
    private float tabMinWidth;
    private List<String> tabs;
    private int unselectedTextColor;
    private final Paint unselectedTextPaint;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SegmentedTabView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SegmentedTabView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ SegmentedTabView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SegmentedTabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.tabs = CollectionsKt.listOf(new String[]{"Work", "Code"});
        this.outerCornerRadius = m865dp(DEFAULT_OUTER_CORNER_RADIUS_DP);
        this.innerCornerRadius = m865dp(DEFAULT_INNER_CORNER_RADIUS_DP);
        this.innerPadding = m865dp(4.0f);
        this.tabMinWidth = m865dp(DEFAULT_TAB_MIN_WIDTH_DP);
        this.preferredHeight = m865dp(DEFAULT_OUTER_HEIGHT_DP);
        this.outerBgColor = ContextCompat.getColor(context, C0591R.color.trae_bg_bg_overlay_l3);
        this.selectedBgColor = ContextCompat.getColor(context, C0591R.color.trae_bg_bg_base_default);
        this.selectedTextColor = ContextCompat.getColor(context, C0591R.color.trae_text_text_default);
        this.unselectedTextColor = ContextCompat.getColor(context, C0591R.color.trae_text_text_default);
        this.shadowRadius = m865dp(DEFAULT_SHADOW_RADIUS_DP);
        this.shadowDy = m865dp(4.0f);
        this.shadowColor = Color.parseColor(DEFAULT_SHADOW_COLOR);
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.FILL);
        this.outerBgPaint = paint;
        Paint paint2 = new Paint(1);
        paint2.setStyle(Paint.Style.FILL);
        this.selectedBgPaint = paint2;
        Paint paint3 = new Paint(1);
        paint3.setTextAlign(Paint.Align.CENTER);
        this.selectedTextPaint = paint3;
        Paint paint4 = new Paint(1);
        paint4.setTextAlign(Paint.Align.CENTER);
        this.unselectedTextPaint = paint4;
        this.outerRect = new RectF();
        this.selectedRect = new RectF();
        setLayerType(1, null);
        applyPaintProperties();
    }

    public final Function2<Integer, String, Unit> getOnTabSelected() {
        return this.onTabSelected;
    }

    public final void setOnTabSelected(Function2<? super Integer, ? super String, Unit> function2) {
        this.onTabSelected = function2;
    }

    private final void applyPaintProperties() {
        this.outerBgPaint.setColor(this.outerBgColor);
        this.selectedBgPaint.setColor(this.selectedBgColor);
        this.selectedBgPaint.setShadowLayer(this.shadowRadius, 0.0f, this.shadowDy, this.shadowColor);
        this.selectedTextPaint.setColor(this.selectedTextColor);
        this.selectedTextPaint.setTextSize(m866sp(DEFAULT_TEXT_SIZE_SP));
        this.selectedTextPaint.setTypeface(Typeface.create("sans-serif-medium", 0));
        this.unselectedTextPaint.setColor(this.unselectedTextColor);
        this.unselectedTextPaint.setTextSize(m866sp(DEFAULT_TEXT_SIZE_SP));
        this.unselectedTextPaint.setTypeface(Typeface.create("sans-serif", 0));
    }

    public final void setTabs(List<String> tabList) {
        Intrinsics.checkNotNullParameter(tabList, "tabList");
        if (!(tabList.size() >= 2)) {
            throw new IllegalArgumentException("SegmentedTabView requires at least 2 tabs".toString());
        }
        this.tabs = tabList;
        this.selectedIndex = RangesKt.coerceIn(this.selectedIndex, 0, tabList.size() - 1);
        requestLayout();
        invalidate();
    }

    public final List<String> getTabs() {
        return CollectionsKt.toList(this.tabs);
    }

    public static /* synthetic */ void setSelectedIndex$default(SegmentedTabView segmentedTabView, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = true;
        }
        segmentedTabView.setSelectedIndex(i, z);
    }

    public final void setSelectedIndex(int index, boolean animate) {
        if (index < 0 || index >= this.tabs.size()) {
            return;
        }
        int i = this.selectedIndex;
        this.selectedIndex = index;
        if (animate && i != index && getWidth() > 0) {
            animateSelection(i, index);
        } else {
            this.animatedSelectionX = getSelectionX(index);
            invalidate();
        }
        Function2<? super Integer, ? super String, Unit> function2 = this.onTabSelected;
        if (function2 != null) {
            function2.invoke(Integer.valueOf(index), this.tabs.get(index));
        }
    }

    public final int getSelectedIndex() {
        return this.selectedIndex;
    }

    public final String getSelectedTab() {
        return this.tabs.get(this.selectedIndex);
    }

    public static /* synthetic */ void setOuterBackground$default(SegmentedTabView segmentedTabView, String str, float f, int i, Object obj) {
        if ((i & 2) != 0) {
            f = 0.14f;
        }
        segmentedTabView.setOuterBackground(str, f);
    }

    public final void setOuterBackground(String colorHex, float alpha) {
        Intrinsics.checkNotNullParameter(colorHex, "colorHex");
        int parseColorWithAlpha = parseColorWithAlpha(colorHex, alpha);
        this.outerBgColor = parseColorWithAlpha;
        this.outerBgPaint.setColor(parseColorWithAlpha);
        invalidate();
    }

    public final void setSelectedBackground(String colorHex) {
        Intrinsics.checkNotNullParameter(colorHex, "colorHex");
        int parseColor = Color.parseColor(colorHex);
        this.selectedBgColor = parseColor;
        this.selectedBgPaint.setColor(parseColor);
        invalidate();
    }

    public final void setTextColors(String selectedHex, String unselectedHex) {
        Intrinsics.checkNotNullParameter(selectedHex, "selectedHex");
        Intrinsics.checkNotNullParameter(unselectedHex, "unselectedHex");
        this.selectedTextColor = Color.parseColor(selectedHex);
        this.unselectedTextColor = Color.parseColor(unselectedHex);
        this.selectedTextPaint.setColor(this.selectedTextColor);
        this.unselectedTextPaint.setColor(this.unselectedTextColor);
        invalidate();
    }

    public final void setTextSizeSp(float sizeSp) {
        float m866sp = m866sp(sizeSp);
        this.selectedTextPaint.setTextSize(m866sp);
        this.unselectedTextPaint.setTextSize(m866sp);
        invalidate();
    }

    public final void setCornerRadius(float outerDp, float innerDp) {
        this.outerCornerRadius = m865dp(outerDp);
        this.innerCornerRadius = m865dp(innerDp);
        invalidate();
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(View.resolveSize((int) ((calculateTabWidthByContent() * this.tabs.size()) + (this.innerPadding * 2)), widthMeasureSpec), View.resolveSize((int) this.preferredHeight, heightMeasureSpec));
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.animatedSelectionX = getSelectionX(this.selectedIndex);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        float width = getWidth();
        float height = getHeight();
        this.outerRect.set(0.0f, 0.0f, width, height);
        RectF rectF = this.outerRect;
        float f = this.outerCornerRadius;
        canvas.drawRoundRect(rectF, f, f, this.outerBgPaint);
        float tabWidth = getTabWidth();
        float f2 = this.animatedSelectionX;
        float f3 = this.innerPadding;
        this.selectedRect.set(f2, f3, f2 + tabWidth, height - f3);
        RectF rectF2 = this.selectedRect;
        float f4 = this.innerCornerRadius;
        canvas.drawRoundRect(rectF2, f4, f4, this.selectedBgPaint);
        float ascent = (height / 2.0f) - ((this.selectedTextPaint.ascent() + this.selectedTextPaint.descent()) / 2.0f);
        int size = this.tabs.size();
        int i = 0;
        while (i < size) {
            canvas.drawText(this.tabs.get(i), this.innerPadding + (i * tabWidth) + (tabWidth / 2.0f), ascent, i == this.selectedIndex ? this.selectedTextPaint : this.unselectedTextPaint);
            i++;
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, Fields.EVENT);
        if (!isEnabled()) {
            return false;
        }
        int action = event.getAction();
        if (action != 0) {
            if (action == 1) {
                int coerceIn = RangesKt.coerceIn((int) ((event.getX() - this.innerPadding) / getTabWidth()), 0, this.tabs.size() - 1);
                if (coerceIn != this.selectedIndex) {
                    setSelectedIndex(coerceIn, true);
                }
                performClick();
            } else {
                return super.onTouchEvent(event);
            }
        }
        return true;
    }

    @Override // android.view.View
    public boolean performClick() {
        return super.performClick();
    }

    private final void animateSelection(int fromIndex, int toIndex) {
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(getSelectionX(fromIndex), getSelectionX(toIndex));
        ofFloat.setDuration(250L);
        ofFloat.setInterpolator(new DecelerateInterpolator(1.5f));
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.trae.conversation.widget.SegmentedTabView$$ExternalSyntheticLambda0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                SegmentedTabView.animateSelection$lambda$6$lambda$5(SegmentedTabView.this, valueAnimator2);
            }
        });
        ofFloat.start();
        this.animator = ofFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void animateSelection$lambda$6$lambda$5(SegmentedTabView segmentedTabView, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(valueAnimator, "anim");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        segmentedTabView.animatedSelectionX = ((Float) animatedValue).floatValue();
        segmentedTabView.invalidate();
    }

    private final float getTabWidth() {
        return (getWidth() - (this.innerPadding * 2)) / RangesKt.coerceAtLeast(this.tabs.size(), 1);
    }

    private final float calculateTabWidthByContent() {
        float m865dp = m865dp(48.0f);
        Iterator<String> it = this.tabs.iterator();
        float f = 0.0f;
        while (it.hasNext()) {
            f = Math.max(f, this.selectedTextPaint.measureText(it.next()));
        }
        return Math.max(f + m865dp, this.tabMinWidth);
    }

    private final float getSelectionX(int index) {
        return this.innerPadding + (getTabWidth() * index);
    }

    /* renamed from: dp */
    private final float m865dp(float value) {
        return TypedValue.applyDimension(1, value, getResources().getDisplayMetrics());
    }

    /* renamed from: sp */
    private final float m866sp(float value) {
        return TypedValue.applyDimension(2, value, getResources().getDisplayMetrics());
    }

    private final int parseColorWithAlpha(String colorHex, float alpha) {
        int parseColor = Color.parseColor(colorHex);
        return Color.argb(RangesKt.coerceIn((int) (alpha * ReducerConstants.REQUEST_CODE), 0, ReducerConstants.REQUEST_CODE), Color.red(parseColor), Color.green(parseColor), Color.blue(parseColor));
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
}
