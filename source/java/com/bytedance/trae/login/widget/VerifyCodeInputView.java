package com.bytedance.trae.login.widget;

import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.LinearInterpolator;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.content.ContextCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: VerifyCodeInputView.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 E2\u00020\u0001:\u0001EB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010.\u001a\u00020\u0010H\u0002J\u0010\u00101\u001a\u00020\u00172\u0006\u00102\u001a\u000203H\u0014J\u0018\u00105\u001a\u00020\u00172\u0006\u00106\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u0007H\u0014J\b\u00108\u001a\u00020\u0010H\u0016J\"\u00109\u001a\u00020\u00172\u0006\u0010:\u001a\u00020\u00102\u0006\u0010;\u001a\u00020\u00072\b\u0010<\u001a\u0004\u0018\u00010=H\u0014J\b\u0010>\u001a\u00020\u0017H\u0014J\b\u0010?\u001a\u00020\u0017H\u0014R$\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0010@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010#\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0010@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0013\"\u0004\b$\u0010\u0015R\u000e\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010*\u001a\n ,*\u0004\u0018\u00010+0+X\u0082\u0004¢\u0006\u0004\n\u0002\u0010-R\u000e\u0010/\u001a\u000200X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010@\u001a\u00020\u0019*\u00020\u00198BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bA\u0010BR\u0018\u0010C\u001a\u00020\u0019*\u00020\u00198BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bD\u0010B¨\u0006F"}, d2 = {"Lcom/bytedance/trae/login/widget/VerifyCodeInputView;", "Landroidx/appcompat/widget/AppCompatEditText;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "boxCount", "getBoxCount", "()I", "setBoxCount", "(I)V", "", "alphanumeric", "getAlphanumeric", "()Z", "setAlphanumeric", "(Z)V", "applyFilters", "", "boxRadius", "", "boxSpace", "boxStrokeWidth", "boxFixedSize", "boxFillColor", "boxStrokeColor", "boxFilledStrokeColor", "boxErrorStrokeColor", "textDisplayColor", "cursorDrawColor", "isError", "setError", "boxPaint", "Landroid/graphics/Paint;", "charPaint", "cursorPaint", "cursorVisible", "cursorAnimator", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "Landroid/animation/ValueAnimator;", "shouldDrawCursor", "boxRect", "Landroid/graphics/RectF;", "onDraw", "canvas", "Landroid/graphics/Canvas;", "suppressSelectionReset", "onSelectionChanged", "selStart", "selEnd", "performLongClick", "onFocusChanged", "focused", "direction", "previouslyFocusedRect", "Landroid/graphics/Rect;", "onAttachedToWindow", "onDetachedFromWindow", "dp", "getDp", "(F)F", "sp", "getSp", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class VerifyCodeInputView extends AppCompatEditText {
    private static final long CURSOR_BLINK_INTERVAL = 500;
    public static final int DEFAULT_BOX_COUNT = 6;
    private boolean alphanumeric;
    private int boxCount;
    private final int boxErrorStrokeColor;
    private final int boxFillColor;
    private final int boxFilledStrokeColor;
    private final float boxFixedSize;
    private final Paint boxPaint;
    private final float boxRadius;
    private final RectF boxRect;
    private final float boxSpace;
    private final int boxStrokeColor;
    private final float boxStrokeWidth;
    private final Paint charPaint;
    private final ValueAnimator cursorAnimator;
    private final int cursorDrawColor;
    private final Paint cursorPaint;
    private boolean cursorVisible;
    private boolean isError;
    private boolean suppressSelectionReset;
    private final int textDisplayColor;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VerifyCodeInputView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VerifyCodeInputView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ VerifyCodeInputView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? R.attr.editTextStyle : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VerifyCodeInputView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.boxCount = 6;
        this.boxRadius = getDp(12.0f);
        this.boxSpace = getDp(8.0f);
        float dp = getDp(1.5f);
        this.boxStrokeWidth = dp;
        this.boxFixedSize = getDp(48.0f);
        this.boxFillColor = ContextCompat.getColor(context, com.bytedance.trae.common_ui.R.color.trae_bg_bg_base_default);
        this.boxStrokeColor = ContextCompat.getColor(context, com.bytedance.trae.common_ui.R.color.trae_border_border_neutral_l2);
        this.boxFilledStrokeColor = ContextCompat.getColor(context, com.bytedance.trae.common_ui.R.color.trae_border_border_neutral_l3);
        this.boxErrorStrokeColor = ContextCompat.getColor(context, com.bytedance.trae.common_ui.R.color.trae_status_error_default);
        int color = ContextCompat.getColor(context, com.bytedance.trae.common_ui.R.color.trae_text_text_default);
        this.textDisplayColor = color;
        int color2 = ContextCompat.getColor(context, com.bytedance.trae.common_ui.R.color.trae_border_border_neutral_l3);
        this.cursorDrawColor = color2;
        this.boxPaint = new Paint(1);
        Paint paint = new Paint(1);
        paint.setTextSize(getSp(16.0f));
        paint.setFakeBoldText(true);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setColor(color);
        this.charPaint = paint;
        Paint paint2 = new Paint(1);
        paint2.setColor(color2);
        paint2.setStrokeWidth(getDp(2.0f));
        paint2.setStrokeCap(Paint.Cap.ROUND);
        this.cursorPaint = paint2;
        this.cursorVisible = true;
        ValueAnimator ofInt = ValueAnimator.ofInt(0, 1);
        ofInt.setDuration(1000L);
        ofInt.setRepeatCount(-1);
        ofInt.setRepeatMode(1);
        ofInt.setInterpolator(new LinearInterpolator());
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.trae.login.widget.VerifyCodeInputView$$ExternalSyntheticLambda3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                VerifyCodeInputView.cursorAnimator$lambda$5$lambda$4(VerifyCodeInputView.this, valueAnimator);
            }
        });
        this.cursorAnimator = ofInt;
        this.boxRect = new RectF();
        applyFilters();
        setInputType(2);
        int i2 = (int) ((dp / 2) + 0.5f);
        setPadding(i2, i2, i2, i2);
        setBackgroundColor(0);
        setTextColor(0);
        setCursorVisible(true);
        setHighlightColor(0);
        setLongClickable(true);
        ActionMode.Callback callback = new ActionMode.Callback() { // from class: com.bytedance.trae.login.widget.VerifyCodeInputView$pasteOnlyCallback$1
            @Override // android.view.ActionMode.Callback
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                return false;
            }

            @Override // android.view.ActionMode.Callback
            public void onDestroyActionMode(ActionMode mode) {
            }

            @Override // android.view.ActionMode.Callback
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            @Override // android.view.ActionMode.Callback
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                if (menu == null) {
                    return true;
                }
                menu.removeItem(R.id.selectAll);
                menu.removeItem(R.id.copy);
                menu.removeItem(R.id.cut);
                return true;
            }
        };
        setCustomSelectionActionModeCallback(callback);
        setCustomInsertionActionModeCallback(callback);
    }

    public final int getBoxCount() {
        return this.boxCount;
    }

    public final void setBoxCount(int i) {
        if (this.boxCount != i) {
            this.boxCount = i;
            applyFilters();
            invalidate();
        }
    }

    public final boolean getAlphanumeric() {
        return this.alphanumeric;
    }

    public final void setAlphanumeric(boolean z) {
        if (this.alphanumeric != z) {
            this.alphanumeric = z;
            applyFilters();
            setInputType(z ? 145 : 2);
        }
    }

    private final void applyFilters() {
        setFilters(new InputFilter[]{new InputFilter() { // from class: com.bytedance.trae.login.widget.VerifyCodeInputView$$ExternalSyntheticLambda0
            @Override // android.text.InputFilter
            public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                CharSequence applyFilters$lambda$1;
                applyFilters$lambda$1 = VerifyCodeInputView.applyFilters$lambda$1(VerifyCodeInputView.this, charSequence, i, i2, spanned, i3, i4);
                return applyFilters$lambda$1;
            }
        }, new InputFilter.LengthFilter(this.boxCount)});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence applyFilters$lambda$1(VerifyCodeInputView verifyCodeInputView, CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        CharSequence subSequence = charSequence.subSequence(i, i2);
        StringBuilder sb = new StringBuilder();
        int length = subSequence.length();
        for (int i5 = 0; i5 < length; i5++) {
            char charAt = subSequence.charAt(i5);
            if (verifyCodeInputView.alphanumeric ? Character.isLetterOrDigit(charAt) : Character.isDigit(charAt)) {
                sb.append(charAt);
            }
        }
        StringBuilder sb2 = sb;
        if (sb2.length() == subSequence.length()) {
            return null;
        }
        return sb2;
    }

    /* renamed from: isError, reason: from getter */
    public final boolean getIsError() {
        return this.isError;
    }

    public final void setError(boolean z) {
        if (this.isError != z) {
            this.isError = z;
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void cursorAnimator$lambda$5$lambda$4(VerifyCodeInputView verifyCodeInputView, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(valueAnimator, "it");
        boolean z = valueAnimator.getAnimatedFraction() < 0.5f;
        if (z != verifyCodeInputView.cursorVisible) {
            verifyCodeInputView.cursorVisible = z;
            verifyCodeInputView.invalidate();
        }
    }

    private final boolean shouldDrawCursor() {
        return isFocused() && this.cursorVisible;
    }

    protected void onDraw(Canvas canvas) {
        int i;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Editable text = getText();
        String obj = text != null ? text.toString() : null;
        if (obj == null) {
            obj = "";
        }
        int width = (getWidth() - getPaddingStart()) - getPaddingEnd();
        float f = this.boxFixedSize;
        float f2 = width;
        float f3 = this.boxSpace;
        float coerceAtMost = RangesKt.coerceAtMost(f, (f2 - (f3 * (r4 - 1))) / this.boxCount);
        float f4 = 2;
        float paddingStart = getPaddingStart() + ((f2 - ((this.boxCount * coerceAtMost) + (this.boxSpace * (r3 - 1)))) / f4);
        int length = obj.length() < this.boxCount ? obj.length() : -1;
        int i2 = this.boxCount;
        int i3 = 0;
        while (i3 < i2) {
            float f5 = (i3 * (this.boxSpace + coerceAtMost)) + paddingStart;
            float paddingTop = getPaddingTop() + ((((getHeight() - getPaddingTop()) - getPaddingBottom()) - coerceAtMost) / f4);
            this.boxRect.set(f5, paddingTop, f5 + coerceAtMost, paddingTop + coerceAtMost);
            this.boxPaint.setStyle(Paint.Style.FILL);
            this.boxPaint.setColor(this.boxFillColor);
            RectF rectF = this.boxRect;
            float f6 = this.boxRadius;
            canvas.drawRoundRect(rectF, f6, f6, this.boxPaint);
            this.boxPaint.setStyle(Paint.Style.STROKE);
            this.boxPaint.setStrokeWidth(this.boxStrokeWidth);
            Paint paint = this.boxPaint;
            if (this.isError) {
                i = this.boxErrorStrokeColor;
            } else {
                i = i3 < obj.length() ? this.boxFilledStrokeColor : this.boxStrokeColor;
            }
            paint.setColor(i);
            RectF rectF2 = this.boxRect;
            float f7 = this.boxRadius;
            canvas.drawRoundRect(rectF2, f7, f7, this.boxPaint);
            if (i3 < obj.length()) {
                canvas.drawText(String.valueOf(obj.charAt(i3)), this.boxRect.centerX(), this.boxRect.centerY() - ((this.charPaint.descent() + this.charPaint.ascent()) / f4), this.charPaint);
            }
            if (i3 == length && shouldDrawCursor()) {
                float centerX = this.boxRect.centerX();
                float f8 = 0.3f * coerceAtMost;
                canvas.drawLine(centerX, this.boxRect.centerY() - f8, centerX, this.boxRect.centerY() + f8, this.cursorPaint);
            }
            i3++;
        }
    }

    protected void onSelectionChanged(int selStart, int selEnd) {
        super.onSelectionChanged(selStart, selEnd);
        if (this.suppressSelectionReset) {
            return;
        }
        Editable text = getText();
        int length = text != null ? text.length() : 0;
        if (selStart == length && selEnd == length) {
            return;
        }
        post(new Runnable() { // from class: com.bytedance.trae.login.widget.VerifyCodeInputView$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                VerifyCodeInputView.onSelectionChanged$lambda$6(VerifyCodeInputView.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onSelectionChanged$lambda$6(VerifyCodeInputView verifyCodeInputView) {
        Editable text = verifyCodeInputView.getText();
        verifyCodeInputView.setSelection(text != null ? text.length() : 0);
    }

    public boolean performLongClick() {
        this.suppressSelectionReset = true;
        boolean performLongClick = super.performLongClick();
        postDelayed(new Runnable() { // from class: com.bytedance.trae.login.widget.VerifyCodeInputView$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                VerifyCodeInputView.this.suppressSelectionReset = false;
            }
        }, 300L);
        return performLongClick;
    }

    protected void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
        super.onFocusChanged(focused, direction, previouslyFocusedRect);
        if (focused) {
            this.cursorVisible = true;
            this.cursorAnimator.start();
        } else {
            this.cursorAnimator.cancel();
        }
        invalidate();
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isFocused()) {
            this.cursorAnimator.start();
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.cursorAnimator.cancel();
    }

    private final float getDp(float f) {
        return f * getContext().getResources().getDisplayMetrics().density;
    }

    private final float getSp(float f) {
        return f * getContext().getResources().getDisplayMetrics().scaledDensity;
    }
}
