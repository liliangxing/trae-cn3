package com.bytedance.ies.uikit.textview;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.TypedValue;

/* loaded from: classes4.dex */
public class TextDrawable extends Drawable {
    private static final int MONOSPACE = 3;
    private static final int SANS = 1;
    private static final int SERIF = 2;
    private Resources mResources;
    private ColorStateList mTextColors;
    private StaticLayout mTextLayout;
    private TextPaint mTextPaint;
    private Path mTextPath;
    private static final int[] themeAttributes = {R.attr.textAppearance};
    private static final int[] appearanceAttributes = {R.attr.textSize, R.attr.typeface, R.attr.textStyle, R.attr.textColor};
    private Layout.Alignment mTextAlignment = Layout.Alignment.ALIGN_NORMAL;
    private CharSequence mText = "";
    private Rect mTextBounds = new Rect();

    public TextDrawable(Context context) {
        this.mResources = context.getResources();
        TextPaint textPaint = new TextPaint(1);
        this.mTextPaint = textPaint;
        textPaint.density = this.mResources.getDisplayMetrics().density;
        this.mTextPaint.setDither(true);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(themeAttributes);
        int i = -1;
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        obtainStyledAttributes.recycle();
        Typeface typeface = null;
        TypedArray obtainStyledAttributes2 = resourceId != -1 ? context.obtainStyledAttributes(resourceId, appearanceAttributes) : null;
        ColorStateList colorStateList = null;
        int i2 = 15;
        int i3 = -1;
        if (obtainStyledAttributes2 != null) {
            for (int i4 = 0; i4 < obtainStyledAttributes2.getIndexCount(); i4++) {
                int index = obtainStyledAttributes2.getIndex(i4);
                if (index == 0) {
                    i2 = obtainStyledAttributes.getDimensionPixelSize(index, i2);
                } else if (index == 1) {
                    i = obtainStyledAttributes.getInt(index, i);
                } else if (index == 2) {
                    i3 = obtainStyledAttributes.getInt(index, i3);
                } else if (index == 3) {
                    colorStateList = obtainStyledAttributes.getColorStateList(index);
                }
            }
            obtainStyledAttributes2.recycle();
        }
        setTextColor(colorStateList == null ? ColorStateList.valueOf(-16777216) : colorStateList);
        setRawTextSize(i2);
        if (i == 1) {
            typeface = Typeface.SANS_SERIF;
        } else if (i == 2) {
            typeface = Typeface.SERIF;
        } else if (i == 3) {
            typeface = Typeface.MONOSPACE;
        }
        setTypeface(typeface, i3);
    }

    public void setText(CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = "";
        }
        this.mText = charSequence;
        measureContent();
    }

    public CharSequence getText() {
        return this.mText;
    }

    public float getTextSize() {
        return this.mTextPaint.getTextSize();
    }

    public void setTextSize(float f) {
        setTextSize(2, f);
    }

    public void setTextSize(int i, float f) {
        setRawTextSize(TypedValue.applyDimension(i, f, this.mResources.getDisplayMetrics()));
    }

    private void setRawTextSize(float f) {
        if (f != this.mTextPaint.getTextSize()) {
            this.mTextPaint.setTextSize(f);
            measureContent();
        }
    }

    public float getTextScaleX() {
        return this.mTextPaint.getTextScaleX();
    }

    public void setTextScaleX(float f) {
        if (f != this.mTextPaint.getTextScaleX()) {
            this.mTextPaint.setTextScaleX(f);
            measureContent();
        }
    }

    public Layout.Alignment getTextAlign() {
        return this.mTextAlignment;
    }

    public void setTextAlign(Layout.Alignment alignment) {
        if (this.mTextAlignment != alignment) {
            this.mTextAlignment = alignment;
            measureContent();
        }
    }

    public void setTypeface(Typeface typeface) {
        if (this.mTextPaint.getTypeface() != typeface) {
            this.mTextPaint.setTypeface(typeface);
            measureContent();
        }
    }

    public void setTypeface(Typeface typeface, int i) {
        Typeface create;
        if (i > 0) {
            if (typeface == null) {
                create = Typeface.defaultFromStyle(i);
            } else {
                create = Typeface.create(typeface, i);
            }
            setTypeface(create);
            int i2 = (~(create != null ? create.getStyle() : 0)) & i;
            this.mTextPaint.setFakeBoldText((i2 & 1) != 0);
            this.mTextPaint.setTextSkewX((i2 & 2) != 0 ? -0.25f : 0.0f);
            return;
        }
        this.mTextPaint.setFakeBoldText(false);
        this.mTextPaint.setTextSkewX(0.0f);
        setTypeface(typeface);
    }

    public Typeface getTypeface() {
        return this.mTextPaint.getTypeface();
    }

    public void setTextColor(int i) {
        setTextColor(ColorStateList.valueOf(i));
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.mTextColors = colorStateList;
        updateTextColors(getState());
    }

    public void setTextPath(Path path) {
        if (this.mTextPath != path) {
            this.mTextPath = path;
            measureContent();
        }
    }

    private void measureContent() {
        if (this.mTextPath != null) {
            this.mTextLayout = null;
            this.mTextBounds.setEmpty();
        } else {
            StaticLayout staticLayout = new StaticLayout(this.mText, this.mTextPaint, (int) Math.ceil(Layout.getDesiredWidth(this.mText, this.mTextPaint)), this.mTextAlignment, 1.0f, 0.0f, true);
            this.mTextLayout = staticLayout;
            this.mTextBounds.set(0, 0, staticLayout.getWidth(), this.mTextLayout.getHeight());
        }
        invalidateSelf();
    }

    private boolean updateTextColors(int[] iArr) {
        int colorForState = this.mTextColors.getColorForState(iArr, -1);
        if (this.mTextPaint.getColor() == colorForState) {
            return false;
        }
        this.mTextPaint.setColor(colorForState);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.mTextBounds.set(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.mTextColors.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        return updateTextColors(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.mTextBounds.isEmpty()) {
            return -1;
        }
        return this.mTextBounds.bottom - this.mTextBounds.top;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.mTextBounds.isEmpty()) {
            return -1;
        }
        return this.mTextBounds.right - this.mTextBounds.left;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        int save = canvas.save();
        canvas.translate(bounds.left, bounds.top);
        if (this.mTextPath == null) {
            this.mTextLayout.draw(canvas);
        } else {
            canvas.drawTextOnPath(this.mText.toString(), this.mTextPath, 0.0f, 0.0f, this.mTextPaint);
        }
        canvas.restoreToCount(save);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.mTextPaint.getAlpha() != i) {
            this.mTextPaint.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.mTextPaint.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.mTextPaint.getColorFilter() != colorFilter) {
            this.mTextPaint.setColorFilter(colorFilter);
        }
    }
}
