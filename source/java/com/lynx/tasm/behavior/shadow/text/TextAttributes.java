package com.lynx.tasm.behavior.shadow.text;

import android.text.Layout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextUtils;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.tasm.behavior.ui.ShadowData;
import com.lynx.tasm.behavior.ui.background.BackgroundGradientLayer;
import com.lynx.tasm.utils.FloatUtils;
import java.util.Arrays;
import java.util.Objects;

/* loaded from: classes7.dex */
public class TextAttributes {
    public static final int FIRST_CHAR_RTL_STATE_LTR = 2;
    public static final int FIRST_CHAR_RTL_STATE_NONE_CHECK = 0;
    public static final int FIRST_CHAR_RTL_STATE_RTL = 1;
    public static final String FONT_OPTICAL_SIZING_TAG = "opsz";
    public static final String INLINE_BLOCK_PLACEHOLDER = "B";
    public static final String INLINE_IMAGE_PLACEHOLDER = "I";
    public static final int NOT_SET = -1;
    public static final int TEXT_VERTICAL_ALIGN_BOTTOM = 2;
    public static final int TEXT_VERTICAL_ALIGN_CENTER = 1;
    public static final int TEXT_VERTICAL_ALIGN_CUSTOM = 3;
    public static final int TEXT_VERTICAL_ALIGN_TOP = 0;
    private float[] mAutoFontSizePresetSizes;
    public int mTextDecoration;
    public ShadowData mTextShadow;
    public int mMaxLineCount = -1;
    public int mMaxTextLength = -1;
    public Integer mFontColor = null;
    public int mTextAlign = 3;
    public int mDirection = 0;
    public int mTextVerticalAlign = -1;
    public int mFontWeight = 0;
    public int mFontStyle = 0;
    public int mWhiteSpace = 0;
    public int mTextOverflow = 0;
    public float mLineHeight = 1.0E21f;
    public float mLetterSpacing = 1.0E21f;
    public float mLineSpacing = 0.0f;
    public float mFontSize = 0.0f;
    public TextIndent mTextIndent = null;
    public float mBaselineShift = 0.0f;
    public boolean mHasImageSpan = false;
    public boolean mHasInlineViewSpan = false;
    public boolean mIsBoringSpan = false;
    public boolean mIncludePadding = false;
    public String mFontFamily = null;
    private boolean mIsAutoFontSize = false;
    private float mAutoFontSizeMaxSize = 0.0f;
    private float mAutoFontSizeMinSize = 0.0f;
    private float mAutoFontSizeStepGranularity = 1.0f;
    public boolean mHasValidTypeface = false;
    private boolean mHyphen = false;
    private String mFontVariationSettings = null;
    private String mFontFeatureSettings = null;
    private boolean mFontOpticalSizing = false;
    public int mTextSingleLineVerticalAlign = 0;
    public int mFirstCharacterRTLState = 0;
    public int mTextDecorationStyle = 4;
    public int mTextDecorationColor = 0;
    public int mTextStrokeColor = 0;
    public float mTextStrokeWidth = 0.0f;
    public BackgroundGradientLayer mTextGradient = null;

    public int getTypefaceStyle() {
        if (isFontWeightBOLD() && this.mFontStyle == 2) {
            return 3;
        }
        if (isFontWeightBOLD()) {
            return 1;
        }
        int i = this.mFontStyle;
        if (i == 2) {
            return i;
        }
        return 0;
    }

    public boolean isFontWeightBOLD() {
        int i = this.mFontWeight;
        if (i != 1) {
            return i >= 6 && i <= 10;
        }
        return true;
    }

    public TextAttributes copy() {
        TextAttributes textAttributes = new TextAttributes();
        textAttributes.mMaxLineCount = this.mMaxLineCount;
        textAttributes.mMaxTextLength = this.mMaxTextLength;
        textAttributes.mFontColor = this.mFontColor;
        textAttributes.mTextAlign = this.mTextAlign;
        textAttributes.mTextVerticalAlign = this.mTextVerticalAlign;
        textAttributes.mFontWeight = this.mFontWeight;
        textAttributes.mFontStyle = this.mFontStyle;
        textAttributes.mWhiteSpace = this.mWhiteSpace;
        textAttributes.mTextOverflow = this.mTextOverflow;
        textAttributes.mLineHeight = this.mLineHeight;
        textAttributes.mLetterSpacing = this.mLetterSpacing;
        textAttributes.mLineSpacing = this.mLineSpacing;
        textAttributes.mFontSize = this.mFontSize;
        textAttributes.mTextIndent = this.mTextIndent;
        textAttributes.mBaselineShift = this.mBaselineShift;
        textAttributes.mHasImageSpan = this.mHasImageSpan;
        textAttributes.mHasInlineViewSpan = this.mHasInlineViewSpan;
        textAttributes.mIsBoringSpan = this.mIsBoringSpan;
        textAttributes.mIncludePadding = this.mIncludePadding;
        textAttributes.mFontFamily = this.mFontFamily;
        textAttributes.mTextShadow = this.mTextShadow;
        textAttributes.mTextDecoration = this.mTextDecoration;
        textAttributes.mTextDecorationStyle = this.mTextDecorationStyle;
        textAttributes.mTextDecorationColor = this.mTextDecorationColor;
        textAttributes.mTextStrokeWidth = this.mTextStrokeWidth;
        textAttributes.mTextStrokeColor = this.mTextStrokeColor;
        textAttributes.mDirection = this.mDirection;
        textAttributes.mFirstCharacterRTLState = this.mFirstCharacterRTLState;
        textAttributes.mIsAutoFontSize = this.mIsAutoFontSize;
        textAttributes.mAutoFontSizeMinSize = this.mAutoFontSizeMinSize;
        textAttributes.mAutoFontSizeMaxSize = this.mAutoFontSizeMaxSize;
        textAttributes.mAutoFontSizeStepGranularity = this.mAutoFontSizeStepGranularity;
        textAttributes.mAutoFontSizePresetSizes = this.mAutoFontSizePresetSizes;
        textAttributes.mTextSingleLineVerticalAlign = this.mTextSingleLineVerticalAlign;
        textAttributes.mHasValidTypeface = this.mHasValidTypeface;
        textAttributes.mHyphen = this.mHyphen;
        textAttributes.mFontVariationSettings = this.mFontVariationSettings;
        textAttributes.mFontFeatureSettings = this.mFontFeatureSettings;
        textAttributes.mFontOpticalSizing = this.mFontOpticalSizing;
        return textAttributes;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof TextAttributes)) {
            return false;
        }
        TextAttributes textAttributes = (TextAttributes) obj;
        return this.mMaxLineCount == textAttributes.mMaxLineCount && this.mMaxTextLength == textAttributes.mMaxTextLength && fontColorEquals(textAttributes.mFontColor) && this.mTextAlign == textAttributes.mTextAlign && this.mTextVerticalAlign == textAttributes.mTextVerticalAlign && this.mFontWeight == textAttributes.mFontWeight && this.mFontStyle == textAttributes.mFontStyle && this.mWhiteSpace == textAttributes.mWhiteSpace && this.mTextOverflow == textAttributes.mTextOverflow && FloatUtils.floatsEqual(this.mLineHeight, textAttributes.mLineHeight) && FloatUtils.floatsEqual(this.mLetterSpacing, textAttributes.mLetterSpacing) && FloatUtils.floatsEqual(this.mLineSpacing, textAttributes.mLineSpacing) && FloatUtils.floatsEqual(this.mFontSize, textAttributes.mFontSize) && Objects.equals(this.mTextIndent, textAttributes.mTextIndent) && this.mBaselineShift == textAttributes.mBaselineShift && this.mHasImageSpan == textAttributes.mHasImageSpan && this.mIsBoringSpan == textAttributes.mIsBoringSpan && this.mHasInlineViewSpan == textAttributes.mHasInlineViewSpan && this.mIncludePadding == textAttributes.mIncludePadding && TextUtils.equals(this.mFontFamily, textAttributes.mFontFamily) && Objects.equals(this.mTextShadow, textAttributes.mTextShadow) && this.mTextDecoration == textAttributes.mTextDecoration && this.mDirection == textAttributes.mDirection && this.mTextDecorationColor == textAttributes.mTextDecorationColor && this.mTextDecorationStyle == textAttributes.mTextDecorationStyle && this.mTextStrokeColor == textAttributes.mTextStrokeColor && FloatUtils.floatsEqual(this.mTextStrokeWidth, textAttributes.mTextStrokeWidth) && this.mFirstCharacterRTLState == textAttributes.mFirstCharacterRTLState && this.mIsAutoFontSize == textAttributes.mIsAutoFontSize && FloatUtils.floatsEqual(this.mAutoFontSizeMinSize, textAttributes.mAutoFontSizeMinSize) && FloatUtils.floatsEqual(this.mAutoFontSizeMaxSize, textAttributes.mAutoFontSizeMaxSize) && FloatUtils.floatsEqual(this.mAutoFontSizeStepGranularity, textAttributes.mAutoFontSizeStepGranularity) && Arrays.equals(this.mAutoFontSizePresetSizes, textAttributes.mAutoFontSizePresetSizes) && this.mTextSingleLineVerticalAlign == textAttributes.mTextSingleLineVerticalAlign && this.mHasValidTypeface == textAttributes.mHasValidTypeface && this.mHyphen == textAttributes.mHyphen && this.mFontOpticalSizing == textAttributes.mFontOpticalSizing && TextUtils.equals(this.mFontVariationSettings, textAttributes.mFontVariationSettings) && TextUtils.equals(this.mFontFeatureSettings, textAttributes.mFontFeatureSettings);
    }

    public int hashCode() {
        int i = ((this.mMaxLineCount * 31) + this.mMaxTextLength) * 31;
        Integer num = this.mFontColor;
        int intValue = (((((((((((((((((((i + (num != null ? num.intValue() : -16777216)) * 31) + this.mTextAlign) * 31) + this.mTextVerticalAlign) * 31) + this.mFontWeight) * 31) + this.mWhiteSpace) * 31) + this.mTextOverflow) * 31) + Float.floatToIntBits(this.mLineHeight)) * 31) + Float.floatToIntBits(this.mLetterSpacing)) * 31) + Float.floatToIntBits(this.mLineSpacing)) * 31) + Float.floatToIntBits(this.mFontSize)) * 31;
        TextIndent textIndent = this.mTextIndent;
        int hashCode = (((((((((((intValue + (textIndent == null ? 0 : textIndent.hashCode())) * 31) + Float.floatToIntBits(this.mBaselineShift)) * 31) + (this.mHasImageSpan ? 1 : 0)) * 31) + (this.mIsBoringSpan ? 1 : 0)) * 31) + (this.mHasInlineViewSpan ? 1 : 0)) * 31) + (this.mIncludePadding ? 1 : 0)) * 31;
        String str = this.mFontFamily;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        ShadowData shadowData = this.mTextShadow;
        int hashCode3 = (((((((((((((hashCode2 + (shadowData == null ? 0 : shadowData.hashCode())) * 31) + this.mTextDecoration) * 31) + this.mTextDecorationStyle) * 31) + this.mTextDecorationColor) * 31) + Float.floatToIntBits(this.mTextStrokeWidth)) * 31) + this.mTextStrokeColor) * 31) + this.mDirection) * 31;
        BackgroundGradientLayer backgroundGradientLayer = this.mTextGradient;
        int hashCode4 = (((((((((((hashCode3 + (backgroundGradientLayer == null ? 0 : backgroundGradientLayer.hashCode())) * 31) + this.mFirstCharacterRTLState) * 31) + (this.mIsAutoFontSize ? 1 : 0)) * 31) + Float.floatToIntBits(this.mAutoFontSizeMinSize)) * 31) + Float.floatToIntBits(this.mAutoFontSizeMaxSize)) * 31) + Float.floatToIntBits(this.mAutoFontSizeStepGranularity)) * 31;
        float[] fArr = this.mAutoFontSizePresetSizes;
        int hashCode5 = (((((((hashCode4 + (fArr == null ? 0 : fArr.hashCode())) * 31) + this.mTextSingleLineVerticalAlign) * 31) + (this.mHasValidTypeface ? 1 : 0)) * 31) + (this.mHyphen ? 1 : 0)) * 31;
        String str2 = this.mFontVariationSettings;
        int hashCode6 = (hashCode5 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.mFontFeatureSettings;
        return ((hashCode6 + (str3 != null ? str3.hashCode() : 0)) * 31) + (this.mFontOpticalSizing ? 1 : 0);
    }

    public int getMaxLineCount() {
        return this.mMaxLineCount;
    }

    public void setMaxLineCount(int i) {
        this.mMaxLineCount = i;
    }

    public int getMaxTextLength() {
        return this.mMaxTextLength;
    }

    public void setMaxTextLength(int i) {
        this.mMaxTextLength = i;
    }

    public int getFontColor() {
        return this.mFontColor.intValue();
    }

    public void setFontColor(int i) {
        this.mFontColor = Integer.valueOf(i);
    }

    public int getTextAlign() {
        return this.mTextAlign;
    }

    public Layout.Alignment getLayoutAlignment(boolean z) {
        int i = this.mTextAlign;
        if (i == 0) {
            int i2 = this.mDirection;
            if (i2 == 0) {
                return z ? Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_NORMAL;
            }
            if (i2 == 3) {
                return Layout.Alignment.ALIGN_NORMAL;
            }
            return Layout.Alignment.ALIGN_OPPOSITE;
        }
        if (i != 2) {
            if (i == 1) {
                return Layout.Alignment.ALIGN_CENTER;
            }
            return Layout.Alignment.ALIGN_NORMAL;
        }
        int i3 = this.mDirection;
        if (i3 == 0) {
            return z ? Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_OPPOSITE;
        }
        if (i3 == 3) {
            return Layout.Alignment.ALIGN_OPPOSITE;
        }
        return Layout.Alignment.ALIGN_NORMAL;
    }

    public Layout.Alignment getLayoutAlignment() {
        return getLayoutAlignment(false);
    }

    public void setTextAlign(int i) {
        this.mTextAlign = i;
    }

    public int getFontWeight() {
        return this.mFontWeight;
    }

    public void setFontWeight(int i) {
        this.mFontWeight = i;
    }

    public int getFontStyle() {
        return this.mFontStyle;
    }

    public void setFontStyle(int i) {
        this.mFontStyle = i;
    }

    public int getWhiteSpace() {
        return this.mWhiteSpace;
    }

    public void setWhiteSpace(int i) {
        this.mWhiteSpace = i;
    }

    public int getTextOverflow() {
        return this.mTextOverflow;
    }

    public void setTextOverflow(int i) {
        this.mTextOverflow = i;
    }

    public float getLineHeight() {
        return this.mLineHeight;
    }

    public void setLineHeight(float f) {
        this.mLineHeight = f;
    }

    public float getLetterSpacing() {
        return this.mLetterSpacing;
    }

    public void setLetterSpacing(float f) {
        this.mLetterSpacing = f;
    }

    public float getLineSpacing() {
        return this.mLineSpacing;
    }

    public void setLineSpacing(float f) {
        this.mLineSpacing = f;
    }

    public float getFontSize() {
        return this.mFontSize;
    }

    public void setFontSize(float f) {
        this.mFontSize = f;
    }

    public boolean hasImageSpan() {
        return this.mHasImageSpan;
    }

    public void setHasImageSpan(boolean z) {
        this.mHasImageSpan = z;
    }

    public boolean isBoringSpan() {
        return this.mIsBoringSpan;
    }

    public void setIsBoringSpan(boolean z) {
        this.mIsBoringSpan = z;
    }

    public boolean hasInlineViewSpan() {
        return this.mHasInlineViewSpan;
    }

    public void setHasInlineViewSpan(boolean z) {
        this.mHasInlineViewSpan = z;
    }

    public boolean isIncludePadding() {
        return this.mIncludePadding;
    }

    public void setIncludePadding(boolean z) {
        this.mIncludePadding = z;
    }

    public void setTextStrokeColor(int i) {
        this.mTextStrokeColor = i;
    }

    public int getTextStrokeColor() {
        return this.mTextStrokeColor;
    }

    public float getTextStrokeWidth() {
        return this.mTextStrokeWidth;
    }

    public void setTextStrokeWidth(float f) {
        this.mTextStrokeWidth = f;
    }

    public String getFontFamily() {
        return this.mFontFamily;
    }

    public void setFontFamily(String str) {
        this.mFontFamily = str;
    }

    public ShadowData getTextShadow() {
        if (this.mTextShadow == null) {
            this.mTextShadow = new ShadowData();
        }
        return this.mTextShadow;
    }

    public void setTextShadow(ShadowData shadowData) {
        this.mTextShadow = shadowData;
    }

    public void ensureTextShadow() {
        if (this.mTextShadow == null) {
            this.mTextShadow = new ShadowData();
        }
    }

    public TextDirectionHeuristic getDirectionHeuristic() {
        int i = this.mDirection;
        if (i == 0) {
            return TextDirectionHeuristics.FIRSTSTRONG_LTR;
        }
        if (i == 3) {
            return TextDirectionHeuristics.LTR;
        }
        return TextDirectionHeuristics.RTL;
    }

    private boolean fontColorEquals(Integer num) {
        Integer num2 = this.mFontColor;
        if (num2 == null || num == null) {
            return num2 == null && num == null;
        }
        return num2.equals(num);
    }

    public boolean getIsAutoFontSize() {
        return this.mIsAutoFontSize;
    }

    public void setAutoFontSize(ReadableArray readableArray) {
        if (readableArray == null || readableArray.size() != 4) {
            this.mIsAutoFontSize = false;
            return;
        }
        this.mIsAutoFontSize = readableArray.getBoolean(0);
        this.mAutoFontSizeMinSize = (float) readableArray.getDouble(1);
        this.mAutoFontSizeMaxSize = (float) readableArray.getDouble(2);
        this.mAutoFontSizeStepGranularity = (float) readableArray.getDouble(3);
    }

    public float getAutoFontSizeMaxSize() {
        return this.mAutoFontSizeMaxSize;
    }

    public float getAutoFontSizeMinSize() {
        return this.mAutoFontSizeMinSize;
    }

    public float getAutoFontSizeStepGranularity() {
        float f = this.mAutoFontSizeStepGranularity;
        if (f > 0.0f) {
            return f;
        }
        return 1.0f;
    }

    public void setAutoFontSizePresetSizes(ReadableArray readableArray) {
        if (readableArray == null || readableArray.size() == 0) {
            this.mAutoFontSizePresetSizes = null;
            return;
        }
        this.mAutoFontSizePresetSizes = new float[readableArray.size()];
        for (int i = 0; i < readableArray.size(); i++) {
            this.mAutoFontSizePresetSizes[i] = (float) readableArray.getDouble(i);
        }
    }

    public float[] getAutoFontSizePresetSizes() {
        return this.mAutoFontSizePresetSizes;
    }

    public void setHasValidTypeface(boolean z) {
        this.mHasValidTypeface = z;
    }

    public boolean getHyphen() {
        return this.mHyphen;
    }

    public void setHyphen(boolean z) {
        this.mHyphen = z;
    }

    public void setFontVariationSettings(String str) {
        this.mFontVariationSettings = str;
    }

    public String getFontVariationSettings() {
        if (!this.mFontOpticalSizing) {
            return this.mFontVariationSettings;
        }
        String str = this.mFontVariationSettings;
        if (str == null) {
            str = "";
        }
        return str + "'opsz' " + this.mFontSize;
    }

    public void setFontFeatureSettings(String str) {
        this.mFontFeatureSettings = str;
    }

    public String getFontFeatureSettings() {
        return this.mFontFeatureSettings;
    }

    public void setFontOpticalSizing(boolean z) {
        this.mFontOpticalSizing = z;
    }
}
