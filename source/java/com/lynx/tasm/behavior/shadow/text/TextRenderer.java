package com.lynx.tasm.behavior.shadow.text;

import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Build;
import android.text.BoringLayout;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.p000ui.text.AbsInlineImageSpan;
import com.lynx.tasm.behavior.shadow.MeasureMode;
import com.lynx.tasm.behavior.shadow.MeasureUtils;
import java.text.Bidi;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class TextRenderer {
    private static final String ELLIPSIS = "…";
    private static final String LTR_MARK = "\u200e";
    private static final int MODE_LINES = 0;
    private static final int MODE_NONE = -1;
    private static final int MODE_PIXELS = 1;
    private static final String RTL_MARK = "\u200f";
    private static final float SPACING_MULT = 1.0f;
    private static final float TEXT_LAYOUT_MAX_WIDTH = 32767.0f;
    private static final BoringLayout.Metrics UNKNOWN_BORING = new BoringLayout.Metrics();
    boolean mHasEllipsis;
    final TextRendererKey mKey;
    private Layout mTextLayout;
    private Typeface mTypeface;
    private int mEllipsisCount = 0;
    private float mTextTranslateOffset = 0.0f;
    private float mTextTranslateTopOffset = 0.0f;
    private float mCacheMaxWidth = -1.0f;

    public TextRenderer(LynxContext lynxContext, TextRendererKey textRendererKey) {
        this.mKey = textRendererKey;
        measure(lynxContext);
        if (textRendererKey.enableTailColorConvert && !textRendererKey.mEnabledTextRefactor) {
            overrideTruncatedSpan(lynxContext);
        }
        updateSpanRectIfNeed();
    }

    public Layout getTextLayout() {
        return this.mTextLayout;
    }

    public int getEllipsisCount() {
        return this.mEllipsisCount;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getLayoutWidth() {
        double ceil;
        if (this.mKey.widthMode == MeasureMode.EXACTLY && getTextLayoutWidth() <= this.mKey.width) {
            ceil = Math.ceil(this.mKey.width);
        } else {
            ceil = Math.ceil(calculateMaxWidth());
        }
        return (int) ceil;
    }

    public PointF getTextTranslateOffset() {
        return new PointF(this.mTextTranslateOffset, this.mTextTranslateTopOffset);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class TextContextDescriptor {
        private float mDesiredWidth;
        private int mEllipsizedLines;
        private int mEllipsizedMode;
        private boolean mShouldBeSingleLine;
        private CharSequence mSpan;
        private TextPaint mTextPaint;

        TextContextDescriptor() {
        }
    }

    private TextContextDescriptor constructTextConstraints(LynxContext lynxContext) {
        TextContextDescriptor textContextDescriptor = new TextContextDescriptor();
        textContextDescriptor.mTextPaint = newTextPaint(lynxContext);
        textContextDescriptor.mShouldBeSingleLine = shouldBeSingleLine();
        textContextDescriptor.mEllipsizedMode = getEllipsizedMode();
        textContextDescriptor.mSpan = getUsedSpanClippedWithMaxLength();
        textContextDescriptor.mDesiredWidth = getDesiredWidth();
        textContextDescriptor.mEllipsizedLines = textContextDescriptor.mShouldBeSingleLine ? 1 : this.mKey.getAttributes().mMaxLineCount;
        return textContextDescriptor;
    }

    private CharSequence getUsedSpanClippedWithMaxLength() {
        CharSequence span = this.mKey.getSpan();
        int i = this.mKey.getAttributes().mMaxTextLength;
        return (i == -1 || i >= span.length()) ? span : getEllipsizedSpan((SpannableStringBuilder) span, i);
    }

    private void insertDirectionMark(SpannableStringBuilder spannableStringBuilder, int i) {
        if (i < 0 || i > spannableStringBuilder.length()) {
            return;
        }
        if (this.mKey.getAttributes().getDirectionHeuristic() == TextDirectionHeuristics.LTR) {
            spannableStringBuilder.insert(i, LTR_MARK);
        } else if (this.mKey.getAttributes().getDirectionHeuristic() == TextDirectionHeuristics.RTL) {
            spannableStringBuilder.insert(i, RTL_MARK);
        }
    }

    protected CharSequence getEllipsizedSpan(SpannableStringBuilder spannableStringBuilder, int i) {
        SpannableStringBuilder spannableStringBuilder2 = (SpannableStringBuilder) spannableStringBuilder.subSequence(0, Math.min(spannableStringBuilder.length(), Math.max(0, i)));
        if (this.mKey.getAttributes().getDirectionHeuristic() == TextDirectionHeuristics.LTR) {
            spannableStringBuilder2.append((CharSequence) LTR_MARK);
        } else if (this.mKey.getAttributes().getDirectionHeuristic() == TextDirectionHeuristics.RTL) {
            spannableStringBuilder2.append((CharSequence) RTL_MARK);
        }
        spannableStringBuilder2.append((CharSequence) ELLIPSIS);
        return spannableStringBuilder2;
    }

    private boolean convertTailColor(SpannableStringBuilder spannableStringBuilder, int i) {
        ForegroundColorSpan[] foregroundColorSpanArr = (ForegroundColorSpan[]) spannableStringBuilder.getSpans(0, 1, ForegroundColorSpan.class);
        if (foregroundColorSpanArr == null || foregroundColorSpanArr.length == 0) {
            return false;
        }
        spannableStringBuilder.setSpan(new ForegroundColorSpan(foregroundColorSpanArr[0].getForegroundColor()), i, spannableStringBuilder.length(), 17);
        return true;
    }

    private float getDesiredWidth() {
        return (this.mKey.widthMode == MeasureMode.EXACTLY || this.mKey.widthMode == MeasureMode.AT_MOST) ? this.mKey.width : TEXT_LAYOUT_MAX_WIDTH;
    }

    private boolean shouldBeSingleLine() {
        return this.mKey.getAttributes().mWhiteSpace == 1 || this.mKey.getAttributes().mMaxLineCount == 1;
    }

    private int getEllipsizedMode() {
        boolean z = this.mKey.getAttributes().mTextOverflow == 1;
        int i = this.mKey.getAttributes().mWhiteSpace == 1 ? 1 : this.mKey.getAttributes().mMaxLineCount;
        if (z) {
            return i != -1 ? 0 : 1;
        }
        return -1;
    }

    private void buildTextLayout(TextContextDescriptor textContextDescriptor, LynxContext lynxContext) {
        Layout.Alignment layoutAlignment;
        BoringLayout.Metrics metrics;
        if ((this.mKey.getAttributes().mTextAlign == 0 || this.mKey.getAttributes().mTextAlign == 2) && this.mKey.getAttributes().mDirection == 0) {
            if (this.mKey.getAttributes().mFirstCharacterRTLState != 0) {
                layoutAlignment = this.mKey.getAttributes().getLayoutAlignment(this.mKey.getAttributes().mFirstCharacterRTLState == 1);
            } else {
                layoutAlignment = this.mKey.getAttributes().getLayoutAlignment(!new Bidi(textContextDescriptor.mSpan.toString(), -2).baseIsLeftToRight());
            }
        } else {
            layoutAlignment = this.mKey.getAttributes().getLayoutAlignment();
        }
        if (canUseBoringLayout((SpannableStringBuilder) textContextDescriptor.mSpan)) {
            metrics = BoringLayout.isBoring(textContextDescriptor.mSpan, textContextDescriptor.mTextPaint);
            if (metrics != null) {
                this.mTextLayout = generateBoringLayout(textContextDescriptor, layoutAlignment, metrics);
            }
        } else {
            metrics = null;
        }
        if (metrics == null) {
            StaticLayout.Builder generateLayoutBuilder = generateLayoutBuilder(textContextDescriptor.mSpan, layoutAlignment, textContextDescriptor.mTextPaint, textContextDescriptor.mDesiredWidth);
            if (textContextDescriptor.mEllipsizedMode == 0) {
                generateLayoutBuilder.setEllipsize(TextUtils.TruncateAt.END).setEllipsizedWidth((int) Math.floor(textContextDescriptor.mDesiredWidth)).setMaxLines(textContextDescriptor.mEllipsizedLines);
            }
            if (textContextDescriptor.mEllipsizedLines > 0) {
                generateLayoutBuilder.setMaxLines(textContextDescriptor.mEllipsizedLines);
            }
            if (textContextDescriptor.mShouldBeSingleLine) {
                generateLayoutBuilder.setMaxLines(1);
            }
            if (this.mKey.getAttributes().mTextAlign == 5 && !this.mKey.getAttributes().hasInlineViewSpan() && Build.VERSION.SDK_INT >= 26) {
                generateLayoutBuilder.setJustificationMode(1);
            }
            if (this.mKey.getAttributes().getHyphen()) {
                generateLayoutBuilder.setHyphenationFrequency(2);
                generateLayoutBuilder.setBreakStrategy(1);
            }
            this.mTextLayout = generateLayoutBuilder.build();
            if (textContextDescriptor.mEllipsizedMode == 0) {
                int lineCount = this.mTextLayout.getLineCount() - 1;
                if (Build.VERSION.SDK_INT <= 28 && ((this.mKey.getAttributes().hasImageSpan() || this.mKey.getAttributes().hasInlineViewSpan()) && this.mTextLayout.getEllipsisCount(lineCount) > 0)) {
                    int lineStart = (this.mTextLayout.getLineStart(lineCount) + this.mTextLayout.getEllipsisStart(lineCount)) - 1;
                    if (isInlineElementAtChar(lineStart, (SpannableStringBuilder) textContextDescriptor.mSpan)) {
                        textContextDescriptor.mSpan = getEllipsizedSpan((SpannableStringBuilder) textContextDescriptor.mSpan, lineStart + 1);
                        this.mTextLayout = generateLayoutBuilder(textContextDescriptor.mSpan, layoutAlignment, textContextDescriptor.mTextPaint, textContextDescriptor.mDesiredWidth).build();
                    }
                }
                Layout layout = this.mTextLayout;
                if (layout.getLineWidth(layout.getLineCount() - 1) > textContextDescriptor.mDesiredWidth) {
                    Layout layout2 = this.mTextLayout;
                    if (layout2.getEllipsisCount(layout2.getLineCount() - 1) > 0) {
                        StaticLayout.Builder generateLayoutBuilder2 = generateLayoutBuilder(textContextDescriptor.mSpan, layoutAlignment, textContextDescriptor.mTextPaint, textContextDescriptor.mDesiredWidth);
                        generateLayoutBuilder2.setMaxLines(textContextDescriptor.mEllipsizedLines);
                        generateLayoutBuilder2.setEllipsize(TextUtils.TruncateAt.END);
                        double floor = Math.floor(textContextDescriptor.mDesiredWidth) * 2.0d;
                        Layout layout3 = this.mTextLayout;
                        generateLayoutBuilder2.setEllipsizedWidth((int) (floor - layout3.getLineWidth(layout3.getLineCount() - 1)));
                        this.mTextLayout = generateLayoutBuilder2.build();
                    }
                }
            }
        }
        this.mCacheMaxWidth = -1.0f;
    }

    private boolean canUseBoringLayout(SpannableStringBuilder spannableStringBuilder) {
        if (!this.mKey.mEnableTextBoringLayout || this.mKey.getAttributes().hasInlineViewSpan() || this.mKey.getAttributes().hasImageSpan() || this.mKey.getAttributes().mDirection == 2 || this.mKey.getAttributes().mFirstCharacterRTLState == 1) {
            return false;
        }
        if (this.mKey.getAttributes().mWhiteSpace == 1 || ((this.mKey.getAttributes().getMaxLineCount() == 1 && this.mKey.getAttributes().getTextOverflow() == 1) || this.mKey.widthMode == MeasureMode.UNDEFINED)) {
            return spannableStringBuilder.length() == 0 || (((CustomBaselineShiftSpan[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), CustomBaselineShiftSpan.class)).length == 0 && ((InlineTextBaselineShiftSpan[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), InlineTextBaselineShiftSpan.class)).length == 0);
        }
        return false;
    }

    private boolean isInlineElementAtChar(int i, SpannableStringBuilder spannableStringBuilder) {
        if (i >= spannableStringBuilder.length()) {
            return false;
        }
        int i2 = i + 1;
        return ((AbsInlineImageSpan[]) spannableStringBuilder.getSpans(i, i2, AbsInlineImageSpan.class)).length > 0 || ((NativeLayoutNodeSpan[]) spannableStringBuilder.getSpans(i, i2, NativeLayoutNodeSpan.class)).length > 0;
    }

    private void handleEllipsisBidiAndColorConvert(TextContextDescriptor textContextDescriptor, LynxContext lynxContext) {
        if (textContextDescriptor.mEllipsizedMode != -1) {
            if (this.mKey.getAttributes().getDirectionHeuristic() != TextDirectionHeuristics.FIRSTSTRONG_LTR || this.mKey.enableTailColorConvert) {
                boolean z = true;
                int lineCount = this.mTextLayout.getLineCount() - 1;
                int ellipsisCount = this.mTextLayout.getEllipsisCount(lineCount);
                this.mEllipsisCount = ellipsisCount;
                if (ellipsisCount > 0) {
                    int lineStart = this.mTextLayout.getLineStart(lineCount) + this.mTextLayout.getEllipsisStart(lineCount);
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.mTextLayout.getText().subSequence(0, lineStart + 1));
                    boolean convertTailColor = this.mKey.enableTailColorConvert ? convertTailColor(spannableStringBuilder, lineStart) : false;
                    if (this.mKey.getAttributes().getDirectionHeuristic() != TextDirectionHeuristics.FIRSTSTRONG_LTR) {
                        insertDirectionMark(spannableStringBuilder, lineStart);
                    } else {
                        z = convertTailColor;
                    }
                    if (z) {
                        textContextDescriptor.mSpan = spannableStringBuilder;
                        textContextDescriptor.mEllipsizedMode = -1;
                        int lineCount2 = this.mTextLayout.getLineCount();
                        buildTextLayout(textContextDescriptor, lynxContext);
                        ensureSameLineCount(textContextDescriptor, lynxContext, lineCount2);
                    }
                }
            }
        }
    }

    private void ensureSameLineCount(TextContextDescriptor textContextDescriptor, LynxContext lynxContext, int i) {
        if (this.mTextLayout.getLineCount() <= i) {
            return;
        }
        while (this.mTextLayout.getLineCount() > i) {
            int i2 = 2;
            if (textContextDescriptor.mSpan.length() < 2) {
                return;
            }
            if (!Character.isLowSurrogate(textContextDescriptor.mSpan.charAt(textContextDescriptor.mSpan.length() - 2)) || textContextDescriptor.mSpan.length() <= 2) {
                i2 = 1;
            }
            textContextDescriptor.mSpan = ((SpannableStringBuilder) textContextDescriptor.mSpan).delete((textContextDescriptor.mSpan.length() - 1) - i2, textContextDescriptor.mSpan.length() - 1);
            buildTextLayout(textContextDescriptor, lynxContext);
        }
    }

    private void handleHeightOverflowByLineCount(TextContextDescriptor textContextDescriptor, LynxContext lynxContext) {
        double ceil;
        if (textContextDescriptor.mEllipsizedMode == -1) {
            return;
        }
        float lineHeight = this.mKey.getAttributes().getLineHeight();
        int lineCount = this.mTextLayout.getLineCount();
        int height = this.mTextLayout.getHeight();
        if (MeasureUtils.isUndefined(lineHeight)) {
            ceil = 0.0d;
        } else {
            double d = lineHeight;
            ceil = (Math.ceil(d) - d) * lineCount;
        }
        int ceil2 = (int) Math.ceil(this.mKey.height + Math.max(ceil, 0.0d));
        if (this.mKey.heightMode == MeasureMode.UNDEFINED || height <= ceil2 || textContextDescriptor.mShouldBeSingleLine) {
            return;
        }
        int i = lineCount - 1;
        while (i > 0 && this.mTextLayout.getLineBottom(i) > this.mKey.height) {
            i--;
        }
        textContextDescriptor.mEllipsizedLines = i + 1;
        textContextDescriptor.mEllipsizedMode = 0;
        buildTextLayout(textContextDescriptor, lynxContext);
    }

    private void measure(LynxContext lynxContext) {
        if (this.mKey.mBaseKey.mText == null) {
            throw new RuntimeException("prepareSpan() should be called!");
        }
        TextContextDescriptor constructTextConstraints = constructTextConstraints(lynxContext);
        handleWhiteSpaceWrap(constructTextConstraints);
        buildTextLayout(constructTextConstraints, lynxContext);
        handleAutoSize(constructTextConstraints, lynxContext);
        handleHeightOverflowByLineCount(constructTextConstraints, lynxContext);
        handleEllipsisBidiAndColorConvert(constructTextConstraints, lynxContext);
        handleMaxWidthMode();
        calcTextTranslateTopOffset();
    }

    private void calcTextTranslateTopOffset() {
        this.mTextTranslateTopOffset = 0.0f;
        if (isNeedCalcOffsetForLineHeight()) {
            this.mTextTranslateTopOffset = TextHelper.calcTextTranslateTopOffsetAndAdjustFontMetric((int) Math.ceil(this.mKey.getAttributes().getLineHeight()), this.mTextLayout.getPaint().getFontMetricsInt(), this.mKey.getAttributes().isIncludePadding());
        }
    }

    public boolean isNeedCalcOffsetForLineHeight() {
        return !MeasureUtils.isUndefined(this.mKey.getAttributes().getLineHeight()) && this.mKey.mEnableTextBoringLayout && this.mKey.mEnabledTextRefactor && this.mKey.getAttributes().getWhiteSpace() == 1 && !this.mKey.getAttributes().hasImageSpan() && !this.mKey.getAttributes().hasInlineViewSpan();
    }

    private void handleAutoSize(TextContextDescriptor textContextDescriptor, LynxContext lynxContext) {
        if (!this.mKey.getAttributes().getIsAutoFontSize() || this.mKey.widthMode == MeasureMode.UNDEFINED) {
            return;
        }
        boolean isTextContentOverflow = isTextContentOverflow();
        int currentFontSize = getCurrentFontSize();
        if (isTextContentOverflow) {
            if (MeasureUtils.isUndefined(this.mKey.getAttributes().getLineHeight()) || this.mKey.heightMode == MeasureMode.UNDEFINED || this.mKey.getAttributes().getLineHeight() <= this.mKey.height || isTextTruncated()) {
                do {
                    currentFontSize = findSmallerFontSize(currentFontSize);
                    if (currentFontSize < 0) {
                        return;
                    } else {
                        buildTextLayoutForAutoSize(currentFontSize, textContextDescriptor, lynxContext);
                    }
                } while (isTextContentOverflow());
                return;
            }
            return;
        }
        while (true) {
            int findLargerFontSize = findLargerFontSize(currentFontSize);
            if (findLargerFontSize < 0) {
                return;
            }
            buildTextLayoutForAutoSize(findLargerFontSize, textContextDescriptor, lynxContext);
            if (isTextContentOverflow()) {
                buildTextLayoutForAutoSize(currentFontSize, textContextDescriptor, lynxContext);
                return;
            }
            currentFontSize = findLargerFontSize;
        }
    }

    private int getCurrentFontSize() {
        int fontSize = (int) this.mKey.getAttributes().getFontSize();
        AbsoluteSizeSpan[] absoluteSizeSpanArr = (AbsoluteSizeSpan[]) ((Spanned) this.mKey.getSpan()).getSpans(0, this.mKey.getSpan().length(), AbsoluteSizeSpan.class);
        for (int i = 0; i < absoluteSizeSpanArr.length; i++) {
            if (fontSize < absoluteSizeSpanArr[i].getSize()) {
                fontSize = absoluteSizeSpanArr[i].getSize();
            }
        }
        return fontSize;
    }

    private void removeAbsoluteSizeSpan(SpannableStringBuilder spannableStringBuilder) {
        for (AbsoluteSizeSpan absoluteSizeSpan : (AbsoluteSizeSpan[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), AbsoluteSizeSpan.class)) {
            spannableStringBuilder.removeSpan(absoluteSizeSpan);
        }
    }

    private void buildTextLayoutForAutoSize(int i, TextContextDescriptor textContextDescriptor, LynxContext lynxContext) {
        removeAbsoluteSizeSpan((SpannableStringBuilder) textContextDescriptor.mSpan);
        textContextDescriptor.mTextPaint.setTextSize(i);
        buildTextLayout(textContextDescriptor, lynxContext);
    }

    private int findSmallerFontSize(int i) {
        float[] autoFontSizePresetSizes = this.mKey.getAttributes().getAutoFontSizePresetSizes();
        if (autoFontSizePresetSizes != null) {
            for (int length = autoFontSizePresetSizes.length - 1; length >= 0; length--) {
                float f = autoFontSizePresetSizes[length];
                if (f < i) {
                    return (int) f;
                }
            }
        } else {
            int autoFontSizeStepGranularity = (int) (i - this.mKey.getAttributes().getAutoFontSizeStepGranularity());
            if (autoFontSizeStepGranularity != i && autoFontSizeStepGranularity >= this.mKey.getAttributes().getAutoFontSizeMinSize()) {
                return autoFontSizeStepGranularity;
            }
        }
        return -1;
    }

    private int findLargerFontSize(int i) {
        float[] autoFontSizePresetSizes = this.mKey.getAttributes().getAutoFontSizePresetSizes();
        if (autoFontSizePresetSizes != null) {
            for (float f : autoFontSizePresetSizes) {
                if (f > i) {
                    return (int) f;
                }
            }
        } else {
            int autoFontSizeStepGranularity = (int) (i + this.mKey.getAttributes().getAutoFontSizeStepGranularity());
            if (autoFontSizeStepGranularity != i && autoFontSizeStepGranularity <= this.mKey.getAttributes().getAutoFontSizeMaxSize()) {
                return autoFontSizeStepGranularity;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isTextContentOverflow() {
        return (this.mKey.heightMode != MeasureMode.UNDEFINED && ((float) this.mTextLayout.getHeight()) > this.mKey.height) || calculateMaxWidth() > this.mKey.width || isTextTruncated();
    }

    private boolean isTextTruncated() {
        if (this.mTextLayout.getLineCount() > getLineCount()) {
            return true;
        }
        Layout layout = this.mTextLayout;
        if (layout.getEllipsisCount(layout.getLineCount() - 1) > 0) {
            return true;
        }
        Layout layout2 = this.mTextLayout;
        return layout2.getLineEnd(layout2.getLineCount() - 1) < this.mTextLayout.getText().length();
    }

    private StaticLayout.Builder generateLayoutBuilder(CharSequence charSequence, Layout.Alignment alignment, TextPaint textPaint, float f) {
        StaticLayout.Builder obtain = StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), textPaint, (int) Math.floor(f));
        obtain.setAlignment(alignment);
        obtain.setLineSpacing(this.mKey.getAttributes().mLineSpacing, 1.0f);
        obtain.setIncludePad(this.mKey.getAttributes().mIncludePadding);
        obtain.setTextDirection(this.mKey.getAttributes().getDirectionHeuristic());
        obtain.setBreakStrategy(this.mKey.wordBreakStrategy);
        if (Build.VERSION.SDK_INT >= 28) {
            obtain.setUseLineSpacingFromFallbacks(true);
        }
        return obtain;
    }

    private Layout generateBoringLayout(TextContextDescriptor textContextDescriptor, Layout.Alignment alignment, BoringLayout.Metrics metrics) {
        if (textContextDescriptor.mEllipsizedMode == 0) {
            return BoringLayout.make(textContextDescriptor.mSpan, textContextDescriptor.mTextPaint, (int) Math.floor(textContextDescriptor.mDesiredWidth), alignment, 1.0f, this.mKey.getAttributes().mLineSpacing, metrics, this.mKey.getAttributes().isIncludePadding(), TextUtils.TruncateAt.END, (int) Math.floor(textContextDescriptor.mDesiredWidth));
        }
        return BoringLayout.make(textContextDescriptor.mSpan, textContextDescriptor.mTextPaint, (int) Math.floor(textContextDescriptor.mDesiredWidth), alignment, 1.0f, this.mKey.getAttributes().mLineSpacing, metrics, this.mKey.getAttributes().isIncludePadding());
    }

    public int getTextLayoutWidth() {
        return this.mTextLayout.getWidth();
    }

    public int getTextLayoutHeight() {
        if (isNeedCalcOffsetForLineHeight()) {
            return (int) Math.ceil(this.mKey.getAttributes().getLineHeight());
        }
        int maxLineCount = this.mKey.getAttributes().getMaxLineCount();
        if (shouldBeSingleLine()) {
            maxLineCount = 1;
        }
        if (maxLineCount == -1 || maxLineCount > this.mTextLayout.getLineCount()) {
            return this.mTextLayout.getHeight();
        }
        return this.mTextLayout.getLineBottom(maxLineCount - 1);
    }

    public int getLineCount() {
        int maxLineCount = this.mKey.getAttributes().getMaxLineCount();
        return (maxLineCount == -1 || maxLineCount > this.mTextLayout.getLineCount()) ? this.mTextLayout.getLineCount() : maxLineCount;
    }

    private TextPaint newTextPaint(LynxContext lynxContext) {
        this.mTypeface = TextHelper.getTypeFaceFromCache(lynxContext, this.mKey.getAttributes(), null);
        return TextHelper.newTextPaint(this.mKey.getAttributes(), this.mTypeface);
    }

    private void overrideTruncatedSpan(LynxContext lynxContext) {
        ForegroundColorSpan[] foregroundColorSpanArr;
        Layout layout = this.mTextLayout;
        if (layout.getEllipsisCount(layout.getLineCount() - 1) != 0 && (this.mKey.getSpan() instanceof SpannableStringBuilder)) {
            int lineCount = this.mTextLayout.getLineCount() - 1;
            int lineStart = this.mTextLayout.getLineStart(lineCount) + this.mTextLayout.getEllipsisStart(lineCount);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.mKey.getSpan());
            ForegroundColorSpan[] foregroundColorSpanArr2 = (ForegroundColorSpan[]) spannableStringBuilder.getSpans(0, 1, ForegroundColorSpan.class);
            if (foregroundColorSpanArr2 == null || foregroundColorSpanArr2.length == 0 || (foregroundColorSpanArr = (ForegroundColorSpan[]) spannableStringBuilder.getSpans(lineStart, lineStart + 1, ForegroundColorSpan.class)) == null || foregroundColorSpanArr.length == 0) {
                return;
            }
            ForegroundColorSpan foregroundColorSpan = foregroundColorSpanArr[foregroundColorSpanArr.length - 1];
            int spanStart = spannableStringBuilder.getSpanStart(foregroundColorSpan);
            int spanEnd = spannableStringBuilder.getSpanEnd(foregroundColorSpan);
            spannableStringBuilder.removeSpan(foregroundColorSpan);
            if (spanStart < lineStart) {
                spannableStringBuilder.setSpan(foregroundColorSpan, spanStart, lineStart, 33);
            }
            spannableStringBuilder.setSpan(new ForegroundColorSpan(foregroundColorSpanArr2[0].getForegroundColor()), lineStart, spanEnd, 34);
            this.mKey.setSpan(spannableStringBuilder);
            this.mTextLayout = null;
            measure(lynxContext);
        }
    }

    private void updateSpanRectIfNeed() {
        if (this.mTextLayout.getWidth() == 0 || this.mTextLayout.getHeight() == 0) {
            return;
        }
        Spanned spanned = (Spanned) this.mTextLayout.getText();
        for (LynxTextGradientSpan lynxTextGradientSpan : (LynxTextGradientSpan[]) spanned.getSpans(0, spanned.length(), LynxTextGradientSpan.class)) {
            int spanStart = spanned.getSpanStart(lynxTextGradientSpan);
            int spanEnd = spanned.getSpanEnd(lynxTextGradientSpan);
            if (spanStart == 0 && spanEnd == spanned.length()) {
                float calculateMaxWidth = calculateMaxWidth();
                float f = this.mTextTranslateOffset;
                lynxTextGradientSpan.updateBounds(new Rect((int) (-f), 0, (int) ((-f) + calculateMaxWidth), this.mTextLayout.getHeight()));
            } else {
                int lineForOffset = this.mTextLayout.getLineForOffset(spanStart);
                int lineForOffset2 = this.mTextLayout.getLineForOffset(spanEnd);
                Rect rect = new Rect();
                for (int i = lineForOffset; i <= lineForOffset2; i++) {
                    Rect rect2 = new Rect();
                    this.mTextLayout.getLineBounds(i, rect2);
                    if (i == lineForOffset) {
                        rect2.left = Math.max(rect2.left, (int) this.mTextLayout.getPrimaryHorizontal(spanStart));
                    }
                    if (i == lineForOffset2) {
                        rect2.right = Math.min(rect2.right, (int) this.mTextLayout.getPrimaryHorizontal(spanEnd));
                    }
                    if (rect2.right != 0) {
                        rect.union(rect2);
                    }
                }
                lynxTextGradientSpan.updateBounds(rect);
            }
        }
        for (LynxTextBackgroundSpan lynxTextBackgroundSpan : (LynxTextBackgroundSpan[]) spanned.getSpans(0, spanned.length(), LynxTextBackgroundSpan.class)) {
            lynxTextBackgroundSpan.updateSpanPosition(this.mTextLayout);
        }
    }

    public boolean isEnableCache() {
        if (this.mKey.mBaseKey.mAttributes.mHasImageSpan || this.mKey.mBaseKey.mAttributes.mHasInlineViewSpan) {
            return false;
        }
        Spanned spanned = (Spanned) this.mTextLayout.getText();
        EventTargetSpan[] eventTargetSpanArr = (EventTargetSpan[]) spanned.getSpans(0, spanned.length(), EventTargetSpan.class);
        LynxTextBackgroundSpan[] lynxTextBackgroundSpanArr = (LynxTextBackgroundSpan[]) spanned.getSpans(0, spanned.length(), LynxTextBackgroundSpan.class);
        if (eventTargetSpanArr == null || eventTargetSpanArr.length == 0) {
            return lynxTextBackgroundSpanArr == null || lynxTextBackgroundSpanArr.length == 0;
        }
        return false;
    }

    private void handleWhiteSpaceWrap(TextContextDescriptor textContextDescriptor) {
        if (this.mKey.getAttributes().mWhiteSpace != 1) {
            return;
        }
        String obj = textContextDescriptor.mSpan.toString();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(textContextDescriptor.mSpan);
        int indexOf = obj.indexOf(10);
        if (indexOf > 0) {
            spannableStringBuilder.delete(indexOf, spannableStringBuilder.length());
        }
        textContextDescriptor.mSpan = spannableStringBuilder;
        if (this.mKey.getAttributes().getTextOverflow() != 1) {
            textContextDescriptor.mDesiredWidth = TEXT_LAYOUT_MAX_WIDTH;
        }
    }

    private void handleMaxWidthMode() {
        if (this.mKey.widthMode != MeasureMode.EXACTLY || this.mKey.getAttributes().getWhiteSpace() == 1) {
            float calculateMaxWidth = calculateMaxWidth();
            if (this.mKey.getAttributes().getWhiteSpace() == 1 && this.mKey.widthMode == MeasureMode.EXACTLY && this.mKey.width > calculateMaxWidth) {
                if (this.mKey.getAttributes().getTextOverflow() != 1) {
                    this.mTextTranslateOffset = calcTextTranslateOffset(this.mKey.width);
                    return;
                }
                return;
            }
            this.mTextTranslateOffset = calcTextTranslateOffset(calculateMaxWidth);
        }
    }

    private float calcTextTranslateOffset(float f) {
        if (this.mTextLayout.getLineLeft(0) == 0.0f) {
            return 0.0f;
        }
        if (this.mTextLayout.getAlignment() == Layout.Alignment.ALIGN_CENTER) {
            return (-(this.mTextLayout.getWidth() - f)) / 2.0f;
        }
        if (this.mTextLayout.getAlignment() == Layout.Alignment.ALIGN_OPPOSITE || this.mTextLayout.getParagraphDirection(0) == -1 || this.mTextLayout.getParagraphAlignment(0) == Layout.Alignment.ALIGN_OPPOSITE) {
            return -(this.mTextLayout.getWidth() - f);
        }
        return 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float calculateMaxWidth() {
        float f = this.mCacheMaxWidth;
        if (f >= 0.0f) {
            return f;
        }
        this.mCacheMaxWidth = -1.0f;
        for (int i = 0; i < getLineCount(); i++) {
            this.mCacheMaxWidth = Math.max(this.mCacheMaxWidth, calculateLineWidth(i));
        }
        if (isContainItalicFont()) {
            this.mCacheMaxWidth = (float) (this.mCacheMaxWidth + ((-this.mTextLayout.getLineAscent(0)) * 0.2d));
        }
        return this.mCacheMaxWidth;
    }

    private float calculateLineWidth(int i) {
        if (this.mKey.getAttributes().getLayoutAlignment() == Layout.Alignment.ALIGN_NORMAL) {
            return this.mTextLayout.getLineMax(i);
        }
        return this.mTextLayout.getLineMax(i) - this.mTextLayout.getParagraphLeft(i);
    }

    private boolean isContainItalicFont() {
        if (this.mKey.getSpan().length() == 0) {
            return false;
        }
        if (this.mKey.getAttributes().getFontStyle() == 2) {
            return true;
        }
        int lineEnd = this.mTextLayout.getLineEnd(getLineCount() - 1);
        if (Build.VERSION.SDK_INT >= 28) {
            for (CustomStyleSpan customStyleSpan : (CustomStyleSpan[]) ((SpannableStringBuilder) this.mKey.getSpan()).getSpans(0, lineEnd, CustomStyleSpan.class)) {
                if (customStyleSpan.getStyle() == 2) {
                    return true;
                }
            }
        } else {
            for (StyleSpan styleSpan : (StyleSpan[]) ((SpannableStringBuilder) this.mKey.getSpan()).getSpans(0, lineEnd, StyleSpan.class)) {
                if (styleSpan.getStyle() == 2) {
                    return true;
                }
            }
        }
        return false;
    }
}
