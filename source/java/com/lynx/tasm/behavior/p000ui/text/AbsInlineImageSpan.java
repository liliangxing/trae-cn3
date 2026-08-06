package com.lynx.tasm.behavior.p000ui.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import com.lynx.tasm.behavior.p000ui.utils.LynxBackground;
import com.lynx.tasm.behavior.shadow.text.AbsBaselineShiftCalculatorSpan;
import com.lynx.tasm.behavior.shadow.text.TextAttributes;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public abstract class AbsInlineImageSpan extends AbsBaselineShiftCalculatorSpan {
    private Drawable.Callback mCallback;
    private LynxBackground mComplexBackground;
    private int mHeight;
    private int mHorizontalMargin;
    private int mMarginLeft;
    private int mMarginTop;
    private int mVerticalMargin;
    private int mWidth;
    private int mBackgroundColor = 0;
    private float mVerticalShift = 0.0f;

    public abstract Drawable getDrawable();

    public void handleRequestResult() {
    }

    public abstract void onAttachedToWindow();

    public abstract void onDetachedFromWindow();

    public abstract void onFinishTemporaryDetach();

    public abstract void onStartTemporaryDetach();

    public AbsInlineImageSpan(int i, int i2, int[] iArr) {
        this.mWidth = i;
        this.mHeight = i2;
        int i3 = iArr[0];
        this.mMarginLeft = i3;
        int i4 = iArr[1];
        this.mMarginTop = i4;
        this.mHorizontalMargin = i3 + iArr[2];
        this.mVerticalMargin = i4 + iArr[3];
        this.mValign = 0;
        this.mValignLength = 0.0f;
    }

    public void setBackgroundColor(int i) {
        this.mBackgroundColor = i;
    }

    public void setComplexBackground(LynxBackground lynxBackground) {
        this.mComplexBackground = lynxBackground;
    }

    public void setVerticalShift(float f) {
        this.mVerticalShift = f;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        int i6;
        int caYOffset;
        if (isTruncated(charSequence, i, i2) || getDrawable() == null) {
            return;
        }
        Drawable drawable = getDrawable();
        canvas.save();
        Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
        int i7 = this.mValign;
        if (i7 == 4) {
            i6 = i3;
        } else if (i7 == 7) {
            i6 = (i5 - this.mHeight) - this.mVerticalMargin;
        } else if (i7 == 11) {
            i6 = (((i5 + i3) - this.mHeight) - this.mVerticalMargin) / 2;
        } else {
            if (this.mEnableTextRefactor) {
                caYOffset = this.mCalcAscent;
            } else if (this.mValign == 6) {
                i6 = (((i5 + i3) - this.mHeight) - this.mVerticalMargin) / 2;
            } else {
                caYOffset = caYOffset(fontMetricsInt);
            }
            i6 = i4 + caYOffset;
        }
        if (this.mBackgroundColor != 0) {
            Rect rect = new Rect(Math.round(f), Math.round(i3 + this.mVerticalShift), Math.round(drawable.getBounds().width() + f), Math.round(i5 + this.mVerticalShift));
            Paint paint2 = new Paint();
            paint2.setStyle(Paint.Style.FILL);
            paint2.setColor(this.mBackgroundColor);
            canvas.drawRect(rect, paint2);
        }
        canvas.translate(f + this.mMarginLeft, i6 + this.mMarginTop + this.mVerticalShift);
        LynxBackground lynxBackground = this.mComplexBackground;
        if (lynxBackground != null && lynxBackground.getDrawable() != null) {
            this.mComplexBackground.getDrawable().draw(canvas);
            if (this.mComplexBackground.getDrawable().getInnerClipPathForBorderRadius() != null) {
                canvas.clipPath(this.mComplexBackground.getDrawable().getInnerClipPathForBorderRadius());
            }
        }
        drawable.draw(canvas);
        canvas.restore();
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        if (isTruncated(charSequence, i, i2)) {
            return 0;
        }
        if (fontMetricsInt != null) {
            if (fontMetricsInt.descent == fontMetricsInt.ascent) {
                fontMetricsInt.ascent = paint.getFontMetricsInt().ascent;
                fontMetricsInt.descent = paint.getFontMetricsInt().descent;
            }
            if (this.mEnableTextRefactor) {
                this.mCalcAscent = (int) calcBaselineShiftAscender(-(this.mHeight + this.mVerticalMargin), 0.0f);
            } else {
                this.mCalcAscent = caYOffset(fontMetricsInt);
            }
            if (fontMetricsInt.ascent > this.mCalcAscent) {
                fontMetricsInt.ascent = this.mCalcAscent;
            }
            if (fontMetricsInt.descent < this.mCalcAscent + this.mHeight + this.mVerticalMargin) {
                fontMetricsInt.descent = this.mCalcAscent + this.mHeight + this.mVerticalMargin;
            }
            if (fontMetricsInt.top > fontMetricsInt.ascent) {
                fontMetricsInt.top = fontMetricsInt.ascent;
            }
            if (fontMetricsInt.bottom < fontMetricsInt.descent) {
                fontMetricsInt.bottom = fontMetricsInt.descent;
            }
        }
        return this.mWidth + this.mHorizontalMargin;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x000f. Please report as an issue. */
    private int caYOffset(Paint.FontMetricsInt fontMetricsInt) {
        int i;
        float f;
        int i2;
        int i3;
        int i4;
        int i5 = fontMetricsInt.descent - fontMetricsInt.ascent;
        int i6 = this.mHeight + this.mVerticalMargin;
        switch (this.mValign) {
            case 1:
                return -i6;
            case 2:
                i = fontMetricsInt.descent - i6;
                f = i5 * 0.1f;
                i4 = (int) f;
                return i - i4;
            case 3:
                i2 = fontMetricsInt.ascent;
                i3 = (int) (i5 * 0.1f);
                return i2 + i3;
            case 4:
            case 5:
                return fontMetricsInt.ascent;
            case 6:
            default:
                i2 = fontMetricsInt.ascent;
                i3 = (i5 - i6) / 2;
                return i2 + i3;
            case 7:
            case 8:
                return fontMetricsInt.descent - i6;
            case 9:
                i = -i6;
                f = this.mValignLength;
                i4 = (int) f;
                return i - i4;
            case 10:
                i = -i6;
                i4 = (int) ((this.mValignLength * i5) / 100.0f);
                return i - i4;
        }
    }

    @Override // com.lynx.tasm.behavior.shadow.text.AbsBaselineShiftCalculatorSpan
    protected int getIncludeMarginHeight() {
        return this.mHeight + this.mVerticalMargin;
    }

    public static void possiblyUpdateInlineImageSpans(Spanned spanned, Drawable.Callback callback) {
        for (AbsInlineImageSpan absInlineImageSpan : (AbsInlineImageSpan[]) spanned.getSpans(0, spanned.length(), AbsInlineImageSpan.class)) {
            absInlineImageSpan.onAttachedToWindow();
            absInlineImageSpan.setCallback(callback);
        }
    }

    public static void possiblyHandleInlineImageRequestResult(Spanned spanned) {
        if (spanned == null) {
            return;
        }
        for (AbsInlineImageSpan absInlineImageSpan : (AbsInlineImageSpan[]) spanned.getSpans(0, spanned.length(), AbsInlineImageSpan.class)) {
            absInlineImageSpan.handleRequestResult();
        }
    }

    public void setCallback(Drawable.Callback callback) {
        this.mCallback = callback;
    }

    public Drawable.Callback getCallback() {
        return this.mCallback;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int getHeight() {
        return this.mHeight;
    }

    private boolean isTruncated(CharSequence charSequence, int i, int i2) {
        return ((charSequence instanceof SpannableStringBuilder) || charSequence.charAt(i) == TextAttributes.INLINE_IMAGE_PLACEHOLDER.charAt(0)) ? false : true;
    }
}
