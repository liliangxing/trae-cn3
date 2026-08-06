package com.lynx.tasm.behavior.shadow.text;

import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.LeadingMarginSpan;
import android.text.style.MetricAffectingSpan;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.PropsConstants;
import com.lynx.tasm.behavior.shadow.AlignContext;
import com.lynx.tasm.behavior.shadow.AlignParam;
import com.lynx.tasm.behavior.shadow.CustomMeasureFunc;
import com.lynx.tasm.behavior.shadow.LayoutNode;
import com.lynx.tasm.behavior.shadow.MeasureContext;
import com.lynx.tasm.behavior.shadow.MeasureMode;
import com.lynx.tasm.behavior.shadow.MeasureOutput;
import com.lynx.tasm.behavior.shadow.MeasureParam;
import com.lynx.tasm.behavior.shadow.MeasureResult;
import com.lynx.tasm.behavior.shadow.MeasureUtils;
import com.lynx.tasm.behavior.shadow.NativeLayoutNodeRef;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.shadow.text.BaseTextShadowNode;
import com.lynx.tasm.behavior.shadow.text.TypefaceCache;
import com.lynx.tasm.fontface.FontFaceManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class TextShadowNode extends BaseTextShadowNode implements CustomMeasureFunc {
    private static final String TAG = "lynx_TextShadowNode";
    protected TextRenderer mRenderer;
    protected CharSequence mSpannableString;
    private CharSequence mTruncatedSpannableString;
    private InlineTruncationShadowNode mTruncationShadowNode;
    private CharSequence mTruncationSpannableString;
    private boolean mEnableTailColorConvert = false;
    private boolean mEnableFullJustify = false;
    private boolean mIsCalcXHeight = false;
    private boolean mIsCalcAscenderAndDescender = false;
    private float mMaxXHeight = Float.MIN_VALUE;
    private float mMinAscender = Float.MAX_VALUE;
    private float mMaxDescender = Float.MIN_VALUE;
    protected int mEllipsisCount = 0;
    private MeasureParam mMeasureParam = null;
    private MeasureContext mMeasureContext = null;

    private boolean isNeedCalcAscenderAndDescender(int i) {
        return i == 5 || i == 8 || i == 4 || i == 7 || i == 11;
    }

    private boolean isNeedCalcXHeight(int i) {
        return i == 6;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isLayoutEventContainTextSize() {
        return true;
    }

    @Override // com.lynx.tasm.behavior.shadow.text.BaseTextShadowNode
    protected boolean isParagraph() {
        return true;
    }

    public TextShadowNode() {
        initMeasureFunction();
    }

    private void initMeasureFunction() {
        if (isVirtual()) {
            return;
        }
        setCustomMeasureFunc(this);
    }

    @Override // com.lynx.tasm.behavior.shadow.LayoutNode
    public void onLayoutBefore() {
        if (isVirtual()) {
            return;
        }
        this.mRenderer = null;
        this.mTruncationSpannableString = null;
        prepareSpan();
    }

    protected boolean isBoringSpan() {
        return ((getChildCount() == 1 && (getChildAt(0) instanceof RawTextShadowNode)) || (getChildCount() == 0 && this.mText != null)) && MeasureUtils.isUndefined(getTextAttributes().mLineHeight);
    }

    protected void prepareSpan() {
        if (!isTextRefactorEnabled()) {
            setTextAlignFromInlineText();
        }
        boolean isBoringSpan = isBoringSpan();
        getTextAttributes().setIsBoringSpan(isBoringSpan);
        if (isBoringSpan) {
            if (getChildCount() == 0) {
                this.mSpannableString = getCharSequence(this.mText, false);
            } else {
                RawTextShadowNode rawTextShadowNode = (RawTextShadowNode) getChildAt(0);
                this.mSpannableString = getCharSequence(rawTextShadowNode.getText(), rawTextShadowNode.isPseudo());
            }
            if (this.mSpannableString == null) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append(this.mSpannableString);
            buildStyledSpan(0, this.mSpannableString.length(), arrayList);
            Iterator<BaseTextShadowNode.SetSpanOperation> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().execute(spannableStringBuilder);
            }
            this.mSpannableString = spannableStringBuilder;
            return;
        }
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
        this.mSpannableString = spannableStringBuilder2;
        buildSpannableString(spannableStringBuilder2, this);
        prepareTruncationSpan();
        setFontMetricForVerticalAlign();
    }

    private void setTextAlignFromInlineText() {
        ShadowNode shadowNode = this;
        int i = 3;
        while (shadowNode.getChildCount() > 0) {
            shadowNode = shadowNode.getChildAt(0);
            if (!(shadowNode instanceof InlineTextShadowNode)) {
                break;
            }
            int textAlign = ((InlineTextShadowNode) shadowNode).getTextAttributes().getTextAlign();
            if (textAlign != 3) {
                i = textAlign;
            }
        }
        if (i != 3) {
            getTextAttributes().setTextAlign(i);
        }
    }

    private void prepareTruncationSpan() {
        this.mTruncationShadowNode = null;
        int i = 0;
        while (true) {
            if (i >= getChildCount()) {
                break;
            }
            if (getChildAt(i) instanceof InlineTruncationShadowNode) {
                this.mTruncationShadowNode = (InlineTruncationShadowNode) getChildAt(i);
                break;
            }
            i++;
        }
        if (this.mTruncationShadowNode != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            this.mTruncationSpannableString = spannableStringBuilder;
            buildSpannableString(spannableStringBuilder, this.mTruncationShadowNode);
            getTextAttributes().setTextOverflow(0);
        }
    }

    private void buildSpannableString(SpannableStringBuilder spannableStringBuilder, BaseTextShadowNode baseTextShadowNode) {
        ArrayList arrayList = new ArrayList();
        baseTextShadowNode.generateStyleSpan(spannableStringBuilder, arrayList);
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            arrayList.get(size).execute(spannableStringBuilder);
        }
        setIsCalcMaxFontMetric(spannableStringBuilder);
    }

    protected void setIsCalcMaxFontMetric(SpannableStringBuilder spannableStringBuilder) {
        int verticalAlign;
        for (MetricAffectingSpan metricAffectingSpan : (MetricAffectingSpan[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), MetricAffectingSpan.class)) {
            if (metricAffectingSpan instanceof AbsBaselineShiftCalculatorSpan) {
                verticalAlign = ((AbsBaselineShiftCalculatorSpan) metricAffectingSpan).getVerticalAlign();
            } else {
                verticalAlign = metricAffectingSpan instanceof InlineTextBaselineShiftSpan ? ((InlineTextBaselineShiftSpan) metricAffectingSpan).getVerticalAlign() : 0;
            }
            boolean z = true;
            this.mIsCalcAscenderAndDescender = this.mIsCalcAscenderAndDescender || isNeedCalcAscenderAndDescender(verticalAlign);
            if (!this.mIsCalcXHeight && !isNeedCalcXHeight(verticalAlign)) {
                z = false;
            }
            this.mIsCalcXHeight = z;
        }
    }

    private void calcFontMetricForVerticalAlign(BaseTextShadowNode baseTextShadowNode) {
        TextPaint newTextPaint = TextHelper.newTextPaint(getContext(), baseTextShadowNode.getTextAttributes(), null);
        if (this.mIsCalcAscenderAndDescender) {
            this.mMinAscender = Math.min(newTextPaint.getFontMetrics().ascent, this.mMinAscender);
            this.mMaxDescender = Math.max(newTextPaint.getFontMetrics().descent, this.mMaxDescender);
        }
        if (this.mIsCalcXHeight) {
            newTextPaint.getTextBounds("x", 0, 1, new Rect());
            this.mMaxXHeight = Math.max(this.mMaxXHeight, r1.height());
        }
        for (int i = 0; i < baseTextShadowNode.getChildCount(); i++) {
            ShadowNode childAt = baseTextShadowNode.getChildAt(i);
            if ((childAt instanceof InlineTextShadowNode) || (childAt instanceof InlineTruncationShadowNode)) {
                calcFontMetricForVerticalAlign((BaseTextShadowNode) childAt);
            }
        }
    }

    protected void setFontMetricForVerticalAlign() {
        this.mMinAscender = Float.MAX_VALUE;
        this.mMaxDescender = Float.MIN_VALUE;
        this.mMaxXHeight = Float.MIN_VALUE;
        if (this.mIsCalcAscenderAndDescender || this.mIsCalcXHeight) {
            calcFontMetricForVerticalAlign(this);
        }
        BaselineShiftCalculator baselineShiftCalculator = new BaselineShiftCalculator(Arrays.asList(Float.valueOf(this.mMinAscender), Float.valueOf(this.mMaxDescender), Float.valueOf(this.mMaxXHeight), Float.valueOf(getTextAttributes().mLineHeight == 1.0E21f ? 0.0f : getTextAttributes().mLineHeight)));
        initBaselineShiftSpan(this.mSpannableString, baselineShiftCalculator);
        CharSequence charSequence = this.mTruncationSpannableString;
        if (charSequence != null) {
            initBaselineShiftSpan(charSequence, baselineShiftCalculator);
        }
    }

    private void initBaselineShiftSpan(CharSequence charSequence, BaselineShiftCalculator baselineShiftCalculator) {
        SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) charSequence;
        AbsBaselineShiftCalculatorSpan[] absBaselineShiftCalculatorSpanArr = (AbsBaselineShiftCalculatorSpan[]) spannableStringBuilder.getSpans(0, charSequence.length(), AbsBaselineShiftCalculatorSpan.class);
        for (int i = 0; i < absBaselineShiftCalculatorSpanArr.length; i++) {
            absBaselineShiftCalculatorSpanArr[i].setBaselineShiftCalculator(baselineShiftCalculator);
            absBaselineShiftCalculatorSpanArr[i].setEnableTextRefactor(getContext().isTextRefactorEnabled());
        }
        InlineTextBaselineShiftSpan[] inlineTextBaselineShiftSpanArr = (InlineTextBaselineShiftSpan[]) spannableStringBuilder.getSpans(0, charSequence.length(), InlineTextBaselineShiftSpan.class);
        for (int i2 = 0; i2 < inlineTextBaselineShiftSpanArr.length; i2++) {
            inlineTextBaselineShiftSpanArr[i2].setBaselineShiftCalculator(baselineShiftCalculator);
            inlineTextBaselineShiftSpanArr[i2].setLineHeight(getTextAttributes().getLineHeight());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.lynx.tasm.behavior.shadow.text.BaseTextShadowNode
    public void buildStyledSpan(int i, int i2, List<BaseTextShadowNode.SetSpanOperation> list) {
        if (getTextAttributes().mTextIndent != null) {
            list.add(new BaseTextShadowNode.SetSpanOperation(i, i2, new LeadingMarginSpan.Standard((int) getTextAttributes().mTextIndent.getValue(getStyle().getWidth()), 0)));
        }
        super.buildStyledSpan(i, i2, list);
        if (TextUtils.isEmpty(getTextAttributes().mFontFamily)) {
            return;
        }
        String str = getTextAttributes().mFontFamily;
        int typefaceStyle = getTypefaceStyle();
        if (TypefaceCache.getTypeface(getContext(), str, typefaceStyle) == null) {
            FontFaceManager.getInstance().getTypeface(getContext(), str, typefaceStyle, new WeakTypefaceListener(this));
        } else {
            getTextAttributes().setHasValidTypeface(true);
        }
    }

    public long measure(LayoutNode layoutNode, float f, MeasureMode measureMode, float f2, MeasureMode measureMode2) {
        MeasureParam measureParam;
        if (TraceEvent.isTracingStarted()) {
            HashMap hashMap = new HashMap();
            CharSequence charSequence = this.mSpannableString;
            String obj = charSequence != null ? charSequence.toString() : "";
            if (obj.length() > 50) {
                obj = obj.substring(0, 50);
            }
            hashMap.put("preview_text", obj);
            TraceEvent.beginSection("TextShadowNode.measure", hashMap);
        }
        this.mRenderer = null;
        this.mTruncatedSpannableString = null;
        if (measureMode != MeasureMode.UNDEFINED && measureMode2 != MeasureMode.UNDEFINED && f == 0.0f && f2 == 0.0f) {
            TraceEvent.endSection("TextShadowNode.measure");
            return MeasureOutput.make(0, 0);
        }
        CharSequence charSequence2 = this.mSpannableString;
        if (charSequence2 == null) {
            TraceEvent.endSection("TextShadowNode.measure");
            return MeasureOutput.make(0, 0);
        }
        MeasureContext measureContext = this.mMeasureContext;
        if (measureContext != null && (measureParam = this.mMeasureParam) != null) {
            measureNativeNode((SpannableStringBuilder) charSequence2, measureParam, measureContext);
        }
        this.mRenderer = TextRendererCache.cache().getRenderer(getContext(), new TextRendererKey(charSequence2, getTextAttributes().copy(), measureMode, measureMode2, f, f2, this.mWordBreakStrategy, this.mEnableTailColorConvert, isTextRefactorEnabled(), isTextBoringLayoutEnabled()));
        handleInlineTruncation(f, measureMode, f2, measureMode2);
        float textLayoutHeight = this.mRenderer.getTextLayoutHeight();
        float layoutWidth = this.mRenderer.getLayoutWidth();
        this.mBaseline = this.mRenderer.getTextLayout().getLineBaseline(0);
        TraceEvent.endSection("TextShadowNode.measure");
        return MeasureOutput.make(layoutWidth, textLayoutHeight);
    }

    private void handleInlineTruncation(float f, MeasureMode measureMode, float f2, MeasureMode measureMode2) {
        MeasureContext measureContext;
        MeasureParam measureParam;
        InlineTruncationShadowNode inlineTruncationShadowNode = this.mTruncationShadowNode;
        if (inlineTruncationShadowNode != null) {
            resetNativeNodeIndex(inlineTruncationShadowNode);
            CharSequence charSequence = this.mTruncationSpannableString;
            if (charSequence != null && (measureContext = this.mMeasureContext) != null && (measureParam = this.mMeasureParam) != null) {
                this.mTruncationShadowNode.measureNativeNode((SpannableStringBuilder) charSequence, measureParam, measureContext);
            }
        }
        if (this.mTruncationSpannableString == null || !this.mRenderer.isTextContentOverflow() || measureMode == MeasureMode.UNDEFINED) {
            return;
        }
        TextRenderer renderer = TextRendererCache.cache().getRenderer(getContext(), new TextRendererKey(this.mTruncationSpannableString, getTextAttributes().copy(), MeasureMode.AT_MOST, measureMode2, f, f2, this.mWordBreakStrategy, this.mEnableTailColorConvert, isTextRefactorEnabled(), isTextBoringLayoutEnabled()));
        if (isTruncationWidthSmallerThanConstraintWidth(renderer.getTextLayout())) {
            int truncatedLastLineIndex = getTruncatedLastLineIndex(this.mRenderer, f2, measureMode2);
            if (this.mRenderer.getTextLayout().getLineEnd(truncatedLastLineIndex) != this.mSpannableString.length() || this.mRenderer.getTextLayout().getWidth() > f) {
                float layoutWidth = renderer.getLayoutWidth();
                int lineStart = this.mRenderer.getTextLayout().getLineStart(truncatedLastLineIndex);
                int findTruncationPositionIndex = findTruncationPositionIndex(truncatedLastLineIndex, lineStart, f, layoutWidth);
                while (findTruncationPositionIndex >= lineStart) {
                    int i = findTruncationPositionIndex;
                    while (i > lineStart && Character.isWhitespace(this.mSpannableString.charAt(i - 1))) {
                        i--;
                    }
                    buildTextLayoutForTruncatedString(i, lineStart, f, measureMode, f2, measureMode2);
                    if (!isTextOverflowAfterTruncated(this.mTruncatedSpannableString, this.mRenderer.getTextLayout(), truncatedLastLineIndex) || i <= lineStart) {
                        findTruncationPositionIndex = i;
                        break;
                    } else {
                        findTruncationPositionIndex = i - 1;
                        resetNativeNodeIndex(this.mTruncationShadowNode);
                    }
                }
                this.mEllipsisCount = this.mSpannableString.length() - findTruncationPositionIndex;
            }
        }
    }

    private void buildTextLayoutForTruncatedString(int i, int i2, float f, MeasureMode measureMode, float f2, MeasureMode measureMode2) {
        CharSequence subSequence;
        if (i <= i2) {
            subSequence = new SpannableStringBuilder();
        } else {
            subSequence = this.mSpannableString.subSequence(i2, i);
        }
        int length = subSequence.length() + i2;
        updateNativeNodeIndex(length, this.mTruncationShadowNode);
        SpannableStringBuilder append = ((SpannableStringBuilder) this.mSpannableString.subSequence(0, i2)).append(subSequence).append(this.mTruncationSpannableString);
        this.mTruncatedSpannableString = append;
        updateInlineTextBackgroundSpanIndex(append, length);
        getTextAttributes().mHasImageSpan |= this.mTruncationShadowNode.getTextAttributes().mHasImageSpan;
        getTextAttributes().mHasInlineViewSpan |= this.mTruncationShadowNode.getTextAttributes().mHasInlineViewSpan;
        this.mRenderer = TextRendererCache.cache().getRenderer(getContext(), new TextRendererKey(this.mTruncatedSpannableString, getTextAttributes().copy(), measureMode, measureMode2, f, f2, this.mWordBreakStrategy, this.mEnableTailColorConvert, isTextRefactorEnabled(), isTextBoringLayoutEnabled()));
    }

    private boolean isTextOverflowAfterTruncated(CharSequence charSequence, Layout layout, int i) {
        return layout.getLineEnd(i) < charSequence.length();
    }

    private boolean isTruncationWidthSmallerThanConstraintWidth(Layout layout) {
        return layout.getLineCount() == 1 && layout.getLineEnd(0) == layout.getText().length();
    }

    private int getTruncatedLastLineIndex(TextRenderer textRenderer, float f, MeasureMode measureMode) {
        if (measureMode != MeasureMode.UNDEFINED && textRenderer.getTextLayoutHeight() > f) {
            int lineCount = textRenderer.getTextLayout().getLineCount() - 1;
            while (lineCount > 0 && r2.getLineBottom(lineCount) > f) {
                lineCount--;
            }
            return lineCount;
        }
        return textRenderer.getLineCount() - 1;
    }

    private void updateInlineTextBackgroundSpanIndex(Spanned spanned, int i) {
        LynxTextBackgroundSpan[] lynxTextBackgroundSpanArr = (LynxTextBackgroundSpan[]) spanned.getSpans(i, spanned.length(), LynxTextBackgroundSpan.class);
        for (int i2 = 0; i2 < lynxTextBackgroundSpanArr.length; i2++) {
            if (spanned.getSpanStart(lynxTextBackgroundSpanArr[i2]) >= i) {
                lynxTextBackgroundSpanArr[i2].updateBackgroundStartEndIndex(i);
            }
        }
        for (LynxTextBackgroundSpan lynxTextBackgroundSpan : (LynxTextBackgroundSpan[]) spanned.getSpans(0, i, LynxTextBackgroundSpan.class)) {
            lynxTextBackgroundSpan.updateBackgroundEndIndex(i);
        }
    }

    private int findTruncationPositionIndex(int i, int i2, float f, float f2) {
        int lineEnd = this.mRenderer.getTextLayout().getLineEnd(i);
        float f3 = f - f2;
        if (this.mRenderer.getTextLayout().getLineMax(i) - this.mRenderer.getTextLayout().getLineLeft(i) <= f3) {
            return lineEnd;
        }
        Map<Integer, Float> calculateLastLineGlyphWidth = calculateLastLineGlyphWidth(i, i2, lineEnd, this.mRenderer.getTextLayout());
        float f4 = 0.0f;
        while (i2 < lineEnd) {
            if (calculateLastLineGlyphWidth.containsKey(Integer.valueOf(i2))) {
                f4 += calculateLastLineGlyphWidth.get(Integer.valueOf(i2)).floatValue();
                if (f4 > f3) {
                    return i2;
                }
            }
            i2++;
        }
        return lineEnd;
    }

    private Map<Integer, Float> calculateLastLineGlyphWidth(int i, int i2, int i3, Layout layout) {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        arrayList.add(Float.valueOf(layout.getLineLeft(i)));
        arrayList.add(Float.valueOf(layout.getLineRight(i)));
        while (i2 < i3) {
            if (!Character.isHighSurrogate(layout.getText().charAt(i2))) {
                float secondaryHorizontal = layout.getSecondaryHorizontal(i2);
                arrayList.add(Float.valueOf(secondaryHorizontal));
                hashMap.put(Integer.valueOf(i2), Float.valueOf(secondaryHorizontal));
            }
            i2++;
        }
        Collections.sort(arrayList);
        for (Map.Entry entry : hashMap.entrySet()) {
            int intValue = ((Integer) entry.getKey()).intValue();
            float floatValue = ((Float) entry.getValue()).floatValue();
            int binarySearch = Collections.binarySearch(arrayList, Float.valueOf(floatValue));
            if (layout.isRtlCharAt(intValue)) {
                while (binarySearch >= 0 && ((Float) arrayList.get(binarySearch)).floatValue() >= floatValue) {
                    binarySearch--;
                }
            } else {
                while (binarySearch < arrayList.size() && ((Float) arrayList.get(binarySearch)).floatValue() <= floatValue) {
                    binarySearch++;
                }
            }
            if (binarySearch >= 0 && binarySearch < arrayList.size()) {
                hashMap.put(Integer.valueOf(intValue), Float.valueOf(Math.abs(floatValue - ((Float) arrayList.get(binarySearch)).floatValue())));
            } else {
                hashMap.put(Integer.valueOf(intValue), Float.valueOf(0.0f));
            }
        }
        return hashMap;
    }

    private void updateNativeNodeIndex(int i, BaseTextShadowNode baseTextShadowNode) {
        for (int i2 = 0; i2 < baseTextShadowNode.getChildCount(); i2++) {
            ShadowNode childAt = baseTextShadowNode.getChildAt(i2);
            if (childAt instanceof NativeLayoutNodeRef) {
                ((NativeLayoutNodeRef) childAt).updateNativeNodeIndex(i);
            } else if (childAt instanceof BaseTextShadowNode) {
                updateNativeNodeIndex(i, (BaseTextShadowNode) childAt);
            }
        }
    }

    private void resetNativeNodeIndex(BaseTextShadowNode baseTextShadowNode) {
        for (int i = 0; i < baseTextShadowNode.getChildCount(); i++) {
            ShadowNode childAt = baseTextShadowNode.getChildAt(i);
            if (childAt instanceof NativeLayoutNodeRef) {
                ((NativeLayoutNodeRef) childAt).resetNativeNodeIndex();
            } else if (childAt instanceof BaseTextShadowNode) {
                resetNativeNodeIndex((BaseTextShadowNode) childAt);
            }
        }
    }

    public int getEllipsisCount() {
        int i = this.mEllipsisCount;
        return i == 0 ? this.mRenderer.getEllipsisCount() : i;
    }

    public boolean isBindEvent(String str) {
        return this.mEvents != null && this.mEvents.containsKey(str);
    }

    @Override // com.lynx.tasm.behavior.shadow.CustomMeasureFunc
    public MeasureResult measure(MeasureParam measureParam, MeasureContext measureContext) {
        this.mMeasureParam = measureParam;
        this.mMeasureContext = measureContext;
        this.mEllipsisCount = 0;
        long measure = measure(this, measureParam.mWidth, measureParam.mWidthMode, measureParam.mHeight, measureParam.mHeightMode);
        return new MeasureResult(MeasureOutput.getWidth(measure), MeasureOutput.getHeight(measure), (float) this.mBaseline);
    }

    @Override // com.lynx.tasm.behavior.shadow.CustomMeasureFunc
    public void align(AlignParam alignParam, AlignContext alignContext) {
        TextRenderer textRenderer = this.mRenderer;
        if (textRenderer == null) {
            return;
        }
        alignNativeNode(textRenderer.getTextLayout(), getSpannableStringAfterMeasure(), alignParam, alignContext, this.mRenderer.getTextTranslateOffset());
    }

    private SpannableStringBuilder getSpannableStringAfterMeasure() {
        CharSequence charSequence = this.mTruncatedSpannableString;
        if (charSequence == null) {
            charSequence = this.mSpannableString;
        }
        return (SpannableStringBuilder) charSequence;
    }

    @Override // com.lynx.tasm.behavior.shadow.ShadowNode
    public Object getExtraBundle() {
        if (this.mRenderer == null) {
            return null;
        }
        TextHelper.dispatchLayoutEvent(this);
        TextUpdateBundle createNewUpdateBundle = createNewUpdateBundle();
        createNewUpdateBundle.setTextTranslateOffset(this.mRenderer.getTextTranslateOffset());
        createNewUpdateBundle.setNeedDrawStroke(this.mNeedDrawStroke);
        createNewUpdateBundle.setOriginText(this.mSpannableString);
        this.mRenderer = null;
        return createNewUpdateBundle;
    }

    protected TextUpdateBundle createNewUpdateBundle() {
        HashSet hashSet;
        if (getTextAttributes().hasInlineViewSpan() || this.mTruncationShadowNode != null) {
            hashSet = new HashSet();
            getNativeNodeTruncatedMap(this.mRenderer.getTextLayout().getText(), hashSet, this.mSpannableString.length() - this.mEllipsisCount);
            InlineTruncationShadowNode inlineTruncationShadowNode = this.mTruncationShadowNode;
            if (inlineTruncationShadowNode != null && this.mEllipsisCount == 0) {
                getTruncatedNativeNodeInTruncationShadowNode(inlineTruncationShadowNode, hashSet);
            }
        } else {
            hashSet = null;
        }
        return new TextUpdateBundle(this.mRenderer.getTextLayout(), getTextAttributes().mHasImageSpan, hashSet, this.mEnableFullJustify && getTextAttributes().getTextAlign() == 5);
    }

    private void getTruncatedNativeNodeInTruncationShadowNode(BaseTextShadowNode baseTextShadowNode, Set set) {
        for (int i = 0; i < baseTextShadowNode.getChildCount(); i++) {
            ShadowNode childAt = baseTextShadowNode.getChildAt(i);
            if (childAt instanceof NativeLayoutNodeRef) {
                set.add(Integer.valueOf(childAt.getSignature()));
            } else if (childAt instanceof BaseTextShadowNode) {
                getTruncatedNativeNodeInTruncationShadowNode((BaseTextShadowNode) childAt, set);
            }
        }
    }

    public int getSpannableStringLength() {
        CharSequence charSequence = this.mSpannableString;
        if (charSequence == null) {
            return 0;
        }
        return charSequence.length();
    }

    public TextRenderer getTextRenderer() {
        return this.mRenderer;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class WeakTypefaceListener implements TypefaceCache.TypefaceListener {
        private WeakReference<ShadowNode> mReference;

        /* JADX INFO: Access modifiers changed from: package-private */
        public WeakTypefaceListener(ShadowNode shadowNode) {
            this.mReference = new WeakReference<>(shadowNode);
        }

        @Override // com.lynx.tasm.behavior.shadow.text.TypefaceCache.TypefaceListener
        public void onTypefaceUpdate(Typeface typeface, int i) {
            ShadowNode shadowNode = this.mReference.get();
            if (shadowNode == null || shadowNode.isDestroyed()) {
                return;
            }
            if (shadowNode instanceof BaseTextShadowNode) {
                ((BaseTextShadowNode) shadowNode).getTextAttributes().setHasValidTypeface(true);
            }
            shadowNode.markDirty();
        }
    }

    @LynxProp(name = "tail-color-convert")
    public void setEnableTailColorConvert(boolean z) {
        this.mEnableTailColorConvert = z;
        markDirty();
    }

    @LynxProp(name = "enable-full-justify")
    public void setEnableFullJustify(boolean z) {
        if (this.mEnableFullJustify != z) {
            markDirty();
            this.mEnableFullJustify = z;
        }
    }

    @Override // com.lynx.tasm.behavior.shadow.text.BaseTextShadowNode
    @LynxProp(defaultFloat = MeasureUtils.UNDEFINED, name = PropsConstants.LINE_HEIGHT)
    public void setLineHeight(float f) {
        setLineHeightInternal(f);
    }

    @LynxProp(name = PropsConstants.X_AUTO_FONT_SIZE)
    public void setAutoFontSize(ReadableArray readableArray) {
        getTextAttributes().setAutoFontSize(readableArray);
        markDirty();
    }

    @LynxProp(name = PropsConstants.X_AUTO_FONT_SIZE_PRESET_SIZES)
    public void setAutoFontSizePresetSizes(ReadableArray readableArray) {
        getTextAttributes().setAutoFontSizePresetSizes(readableArray);
    }

    @LynxProp(defaultInt = 0, name = "text-single-line-vertical-align")
    public void setVerticalTextAlign(String str) {
        if ("center".equals(str)) {
            getTextAttributes().mTextSingleLineVerticalAlign = 11;
        } else if (PropsConstants.HIT_SLOP_TOP.equals(str)) {
            getTextAttributes().mTextSingleLineVerticalAlign = 4;
        } else if (PropsConstants.HIT_SLOP_BOTTOM.equals(str)) {
            getTextAttributes().mTextSingleLineVerticalAlign = 7;
        } else {
            getTextAttributes().mTextSingleLineVerticalAlign = 0;
        }
        markDirty();
    }

    @LynxProp(name = PropsConstants.HYPHENS)
    public void setHyphen(int i) {
        getTextAttributes().setHyphen(i == 2);
        markDirty();
    }
}
