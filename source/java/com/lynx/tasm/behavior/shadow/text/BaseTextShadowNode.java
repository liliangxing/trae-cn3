package com.lynx.tasm.behavior.shadow.text;

import android.graphics.PointF;
import android.os.Build;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import com.lynx.react.bridge.Dynamic;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableType;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.PropsConstants;
import com.lynx.tasm.behavior.p000ui.ShadowData;
import com.lynx.tasm.behavior.p000ui.background.BackgroundLinearGradientLayer;
import com.lynx.tasm.behavior.p000ui.background.BackgroundRadialGradientLayer;
import com.lynx.tasm.behavior.p000ui.text.AbsInlineImageSpan;
import com.lynx.tasm.behavior.shadow.AlignContext;
import com.lynx.tasm.behavior.shadow.AlignParam;
import com.lynx.tasm.behavior.shadow.MeasureContext;
import com.lynx.tasm.behavior.shadow.MeasureParam;
import com.lynx.tasm.behavior.shadow.MeasureResult;
import com.lynx.tasm.behavior.shadow.MeasureUtils;
import com.lynx.tasm.behavior.shadow.NativeLayoutNodeRef;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.utils.UnicodeFontUtils;
import com.lynx.tasm.featurecount.LynxFeatureCounter;
import com.lynx.tasm.utils.FloatUtils;
import com.lynx.tasm.utils.PixelUtils;
import com.ss.alive.monitor.services.interfaze.IAssociationStartMonitorEventService;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Set;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class BaseTextShadowNode extends ShadowNode {
    private static final String TAG = "lynx_BaseTextShadowNode";
    private static final int WORD_BREAK_STRATEGY_BALANCED = 2;
    private static final int WORD_BREAK_STRATEGY_HIGH_QUALITY = 1;
    private static final int WORD_BREAK_STRATEGY_SIMPLE = 0;
    protected static Object sEmojiCompatInst = null;
    protected static Method sEmojiProcess = null;
    private static boolean sSupportEmojiCompat = true;
    protected boolean mEnableEmojiCompat;
    protected boolean mNeedDrawStroke;
    private boolean mEnableFontScaling = false;
    private boolean mForceFakeBold = false;
    private boolean mUseWebLineHeight = false;
    private float mOriginLineHeight = 1.0E21f;
    private boolean mEnableTextRefactor = false;
    private boolean mEnableNewClipMode = false;
    private boolean mEnableTextBoringLayout = false;
    protected int mWordBreakStyle = 0;
    private boolean mEnableBitmapGradient = false;
    protected int mWordBreakStrategy = 0;
    protected String mText = null;
    private TextAttributes mTextAttributes = new TextAttributes();

    private int wordBreakStyleToDecodeProperty(int i) {
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (i != 2) {
                return 0;
            }
        }
        return i2;
    }

    protected boolean isParagraph() {
        return false;
    }

    @Override // com.lynx.tasm.behavior.shadow.ShadowNode
    public void setContext(LynxContext lynxContext) {
        super.setContext(lynxContext);
        this.mEnableTextRefactor = lynxContext.isTextRefactorEnabled();
        this.mEnableNewClipMode = lynxContext.isNewClipModeEnabled();
        this.mEnableTextBoringLayout = lynxContext.isTextBoringLayoutEnabled();
        this.mTextAttributes.setIncludePadding(lynxContext.getDefaultTextIncludePadding());
        this.mTextAttributes.setFontSize(Math.round(PixelUtils.dipToPx(14.0f, lynxContext.getScreenMetrics().density)));
    }

    public TextAttributes getTextAttributes() {
        return this.mTextAttributes;
    }

    public void setTextAttributes(TextAttributes textAttributes) {
        this.mTextAttributes = textAttributes;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isTextRefactorEnabled() {
        return this.mEnableTextRefactor;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isTextBoringLayoutEnabled() {
        return this.mEnableTextBoringLayout;
    }

    @LynxProp(defaultInt = 0, name = PropsConstants.WHITE_SPACE)
    public void setWhiteSpace(int i) {
        this.mTextAttributes.mWhiteSpace = i;
        markDirty();
    }

    @LynxProp(name = PropsConstants.INCLUDE_FONT_PADDING)
    public void setIncludeFontPadding(boolean z) {
        this.mTextAttributes.setIncludePadding(z);
        markDirty();
    }

    @LynxProp(defaultInt = 0, name = PropsConstants.TEXT_OVERFLOW)
    public void setTextOverflow(int i) {
        this.mTextAttributes.mTextOverflow = i;
        markDirty();
    }

    @LynxProp(defaultInt = 0, name = PropsConstants.FONT_WEIGHT)
    public void setFontWeight(int i) {
        if (i != this.mTextAttributes.mFontWeight) {
            this.mTextAttributes.mFontWeight = i;
            markDirty();
        }
    }

    @LynxProp(defaultInt = 0, name = PropsConstants.FONT_STYLE)
    public void setFontStyle(int i) {
        if (i == 0 && this.mTextAttributes.mFontStyle != 0) {
            this.mTextAttributes.mFontStyle = 0;
            markDirty();
        }
        if ((i == 1 || i == 2) && this.mTextAttributes.mFontStyle != 2) {
            this.mTextAttributes.mFontStyle = 2;
            markDirty();
        }
    }

    @LynxProp(name = PropsConstants.FONT_FAMILY)
    public void setFontFamily(String str) {
        if (str == null && !TextUtils.isEmpty(this.mTextAttributes.mFontFamily)) {
            this.mTextAttributes.mFontFamily = null;
            markDirty();
        } else {
            if (str == null || str.equals(this.mTextAttributes.mFontFamily)) {
                return;
            }
            this.mTextAttributes.mFontFamily = str;
            markDirty();
        }
    }

    @LynxProp(name = "use-web-line-height")
    public void setUseWebLineHeight(boolean z) {
        if (this.mUseWebLineHeight != z) {
            this.mUseWebLineHeight = z;
            float f = this.mOriginLineHeight;
            if (f != 1.0E21f) {
                setLineHeight(f);
            }
        }
    }

    @LynxProp(name = "custom-baseline-shift")
    public void setBaselineShift(String str) {
        try {
            try {
                if (str.contains("px")) {
                    float parseFloat = Float.parseFloat(str.substring(0, str.indexOf("px")).trim());
                    this.mTextAttributes.mBaselineShift = PixelUtils.dipToPx(parseFloat);
                    this.mTextAttributes.mTextVerticalAlign = 3;
                } else if (str.contains("%")) {
                    String trim = str.substring(0, str.indexOf("%")).trim();
                    this.mTextAttributes.mBaselineShift = Float.parseFloat(trim) * 0.01f * this.mTextAttributes.mFontSize;
                    this.mTextAttributes.mTextVerticalAlign = 3;
                } else {
                    float parseFloat2 = Float.parseFloat(str.trim());
                    TextAttributes textAttributes = this.mTextAttributes;
                    textAttributes.mBaselineShift = parseFloat2 * textAttributes.mFontSize;
                    this.mTextAttributes.mTextVerticalAlign = 3;
                }
            } catch (Exception e) {
                LLog.e("BaseTextShadowNode", e.toString());
                this.mTextAttributes.mBaselineShift = 0.0f;
                this.mTextAttributes.mTextVerticalAlign = -1;
            }
        } finally {
            markDirty();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setLineHeightInternal(float f) {
        this.mOriginLineHeight = f;
        if (this.mEnableFontScaling && this.mContext != null) {
            f *= this.mContext.getFontScale();
        }
        if (this.mTextAttributes.mLineHeight != f) {
            this.mTextAttributes.mLineHeight = f;
            markDirty();
        }
    }

    @LynxProp(defaultFloat = MeasureUtils.UNDEFINED, name = PropsConstants.LINE_HEIGHT)
    public void setLineHeight(float f) {
        if (isTextRefactorEnabled()) {
            return;
        }
        setLineHeightInternal(f);
    }

    @LynxProp(defaultFloat = MeasureUtils.UNDEFINED, name = PropsConstants.FONT_SIZE)
    public void setFontSize(float f) {
        if (this.mEnableFontScaling && this.mContext != null) {
            f *= this.mContext.getFontScale();
        }
        if (!FloatUtils.floatsEqual(this.mTextAttributes.mFontSize, f)) {
            this.mTextAttributes.mFontSize = f;
        }
        markDirty();
    }

    @LynxProp(name = PropsConstants.ENABLE_FONT_SCALING)
    public void setEnableFontScaling(String str) {
        if (this.mContext != null) {
            LynxFeatureCounter.count(80, this.mContext.getInstanceId());
        }
        setEnableFontScaling(Boolean.parseBoolean(str));
    }

    @Deprecated
    public void setColor(int i) {
        this.mTextAttributes.mFontColor = Integer.valueOf(i);
        markDirty();
    }

    @LynxProp(name = PropsConstants.COLOR)
    public void setColor(Dynamic dynamic) {
        ReadableType type = dynamic.getType();
        if (type == ReadableType.Array) {
            this.mTextAttributes.mFontColor = null;
            setGradientColor(dynamic.asArray());
        } else if (type == ReadableType.Int) {
            this.mTextAttributes.mFontColor = Integer.valueOf(dynamic.asInt());
            this.mTextAttributes.mTextGradient = null;
        } else if (type == ReadableType.Long) {
            this.mTextAttributes.mFontColor = Integer.valueOf((int) dynamic.asLong());
            this.mTextAttributes.mTextGradient = null;
        } else {
            this.mTextAttributes.mFontColor = null;
            this.mTextAttributes.mTextGradient = null;
        }
        markDirty();
    }

    private void setGradientColor(ReadableArray readableArray) {
        if (readableArray.size() < 2 || readableArray.getType(1) != ReadableType.Array) {
            this.mTextAttributes.mTextGradient = null;
            return;
        }
        long j = readableArray.getLong(0);
        if (j == 2) {
            this.mTextAttributes.mTextGradient = new BackgroundLinearGradientLayer(readableArray.getArray(1));
            if (this.mEnableBitmapGradient) {
                this.mTextAttributes.mTextGradient.setEnableBitmapGradient(true);
                return;
            }
            return;
        }
        if (j == 3) {
            this.mTextAttributes.mTextGradient = new BackgroundRadialGradientLayer(readableArray.getArray(1));
        } else {
            this.mTextAttributes.mTextGradient = null;
        }
    }

    @LynxProp(defaultFloat = MeasureUtils.UNDEFINED, name = PropsConstants.LETTER_SPACING)
    public void setLetterSpacing(float f) {
        this.mTextAttributes.mLetterSpacing = f;
        markDirty();
    }

    @LynxProp(defaultFloat = 0.0f, name = PropsConstants.LINE_SPACING)
    public void setLineSpacing(float f) {
        this.mTextAttributes.mLineSpacing = f;
        markDirty();
    }

    @LynxProp(name = PropsConstants.TEXT_SHADOW)
    public void setTextShadow(ReadableArray readableArray) {
        this.mTextAttributes.mTextShadow = null;
        if (readableArray == null) {
            return;
        }
        List<ShadowData> parseShadow = ShadowData.parseShadow(readableArray);
        if (parseShadow.size() == 0) {
            return;
        }
        this.mTextAttributes.mTextShadow = parseShadow.get(0);
    }

    @Deprecated
    public void setTextDecoration(int i) {
        this.mTextAttributes.mTextDecoration = i;
        this.mTextAttributes.mTextDecorationStyle = 4;
        this.mTextAttributes.mTextDecorationColor = -16777216;
        markDirty();
        LLog.w(PropsConstants.TEXT_DECORATION, "setTextDecoration(int) is deprecated");
    }

    @LynxProp(name = PropsConstants.TEXT_DECORATION)
    public void setTextDecoration(ReadableArray readableArray) {
        if (readableArray == null || readableArray.size() != 3) {
            this.mTextAttributes.mTextDecoration = 0;
            this.mTextAttributes.mTextDecorationStyle = 4;
            this.mTextAttributes.mTextDecorationColor = 0;
            markDirty();
            return;
        }
        int i = readableArray.getInt(0);
        int i2 = readableArray.getInt(1);
        int i3 = readableArray.getInt(2);
        this.mTextAttributes.mTextDecoration = i;
        this.mTextAttributes.mTextDecorationStyle = i2;
        this.mTextAttributes.mTextDecorationColor = i3;
        markDirty();
    }

    @LynxProp(defaultFloat = 0.0f, name = PropsConstants.TEXT_STROKE_WIDTH)
    public void setTextStrokeWidth(float f) {
        this.mTextAttributes.setTextStrokeWidth(f);
        markDirty();
    }

    @LynxProp(name = PropsConstants.TEXT_STROKE_COLOR)
    public void setTextStrokeColor(Dynamic dynamic) {
        ReadableType type = dynamic.getType();
        if (type == ReadableType.Int) {
            this.mTextAttributes.setTextStrokeColor(dynamic.asInt());
        } else if (type == ReadableType.Long) {
            this.mTextAttributes.setTextStrokeColor((int) dynamic.asLong());
        } else {
            this.mTextAttributes.setTextStrokeColor(0);
        }
        markDirty();
    }

    @LynxProp(defaultInt = 3, name = PropsConstants.TEXT_ALIGN)
    public void setTextAlign(int i) {
        this.mTextAttributes.mTextAlign = i;
        markDirty();
    }

    @LynxProp(defaultInt = 0, name = PropsConstants.DRIECTION)
    public void setDirection(int i) {
        this.mTextAttributes.mDirection = i;
        markDirty();
    }

    @LynxProp(name = "text-vertical-align")
    public void setTextVerticalAlign(String str) {
        if (PropsConstants.HIT_SLOP_TOP.equals(str)) {
            this.mTextAttributes.mTextVerticalAlign = 0;
        } else if ("center".equals(str)) {
            this.mTextAttributes.mTextVerticalAlign = 1;
        } else if (PropsConstants.HIT_SLOP_BOTTOM.equals(str)) {
            this.mTextAttributes.mTextVerticalAlign = 2;
        }
        markDirty();
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0034, code lost:
    
        if (r4.mTextAttributes.mMaxLineCount >= 0) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0037, code lost:
    
        return;
     */
    @LynxProp(name = PropsConstants.TEXT_MAXLINE)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setTextMaxLine(String str) {
        try {
            try {
                this.mTextAttributes.mMaxLineCount = Integer.parseInt(str);
            } finally {
                if (this.mTextAttributes.mMaxLineCount < 0) {
                    this.mTextAttributes.mMaxLineCount = -1;
                }
                markDirty();
            }
        } catch (Throwable unused) {
            this.mTextAttributes.mMaxLineCount = -1;
            LLog.e(TAG, "setTextMaxLine with invalid value:" + str);
        }
    }

    @LynxProp(name = PropsConstants.TEXT_MAXLENGTH)
    public void setTextMaxLength(String str) {
        try {
            try {
                this.mTextAttributes.mMaxTextLength = Integer.valueOf(str).intValue();
                markDirty();
            } finally {
                if (this.mTextAttributes.mMaxTextLength < 0) {
                    this.mTextAttributes.mMaxTextLength = -1;
                }
            }
        } catch (Throwable unused) {
            this.mTextAttributes.mMaxTextLength = -1;
            LLog.e(TAG, "setTextMaxLength with invalid value:" + str);
            if (this.mTextAttributes.mMaxTextLength >= 0) {
            }
        }
    }

    @LynxProp(name = PropsConstants.WORD_BREAK_STRATEGY)
    public void setWordBreakStrategy(int i) {
        if (i == 2 || i == 1) {
            if (this.mEnableNewClipMode) {
                this.mWordBreakStyle = i;
            } else {
                this.mWordBreakStrategy = 1;
            }
        } else if (i == 0) {
            this.mWordBreakStrategy = 2;
        } else {
            this.mWordBreakStrategy = 0;
        }
        markDirty();
    }

    @LynxProp(name = PropsConstants.TEXT_FAKE_BOLD)
    public void setTextFakeBold(boolean z) {
        this.mForceFakeBold = z;
        markDirty();
    }

    public int getTypefaceStyle() {
        return this.mTextAttributes.getTypefaceStyle();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void generateStyleSpan(SpannableStringBuilder spannableStringBuilder, List<SetSpanOperation> list) {
        String str;
        int length = spannableStringBuilder.length();
        if (getChildCount() == 0 && (str = this.mText) != null) {
            appendText(spannableStringBuilder, str, false);
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            ShadowNode childAt = getChildAt(i);
            if (childAt instanceof RawTextShadowNode) {
                RawTextShadowNode rawTextShadowNode = (RawTextShadowNode) childAt;
                if (rawTextShadowNode.getText() != null) {
                    appendText(spannableStringBuilder, rawTextShadowNode.getText(), rawTextShadowNode.isPseudo());
                }
            } else if (childAt instanceof AbsInlineImageShadowNode) {
                spannableStringBuilder.append(TextAttributes.INLINE_IMAGE_PLACEHOLDER);
                ((AbsInlineImageShadowNode) childAt).generateStyleSpan(spannableStringBuilder.length() - 1, spannableStringBuilder.length(), list);
                this.mTextAttributes.mHasImageSpan = true;
            } else if (childAt instanceof NativeLayoutNodeRef) {
                spannableStringBuilder.append(TextAttributes.INLINE_BLOCK_PLACEHOLDER);
                ((NativeLayoutNodeRef) childAt).generateStyleSpan(spannableStringBuilder.length() - 1, spannableStringBuilder.length(), list);
                this.mTextAttributes.mHasInlineViewSpan = true;
            } else if (childAt instanceof BaseTextShadowNode) {
                if (!(childAt instanceof InlineTruncationShadowNode)) {
                    BaseTextShadowNode baseTextShadowNode = (BaseTextShadowNode) childAt;
                    if (baseTextShadowNode.getTextAttributes().mFontColor == null && baseTextShadowNode.getTextAttributes().mTextStrokeWidth > 0.0f) {
                        if (getTextAttributes().mFontColor != null) {
                            baseTextShadowNode.getTextAttributes().setFontColor(getTextAttributes().getFontColor());
                        } else {
                            baseTextShadowNode.getTextAttributes().setFontColor(-16777216);
                        }
                    }
                    baseTextShadowNode.generateStyleSpan(spannableStringBuilder, list);
                    this.mTextAttributes.mHasImageSpan |= baseTextShadowNode.mTextAttributes.mHasImageSpan;
                    this.mTextAttributes.mHasInlineViewSpan |= baseTextShadowNode.mTextAttributes.mHasInlineViewSpan;
                    this.mNeedDrawStroke = baseTextShadowNode.mNeedDrawStroke | this.mNeedDrawStroke;
                }
            } else {
                throw new RuntimeException("Unexpected view type nested under text node: " + childAt.getClass());
            }
        }
        int length2 = spannableStringBuilder.length();
        if (length2 > length) {
            buildStyledSpan(length, length2, list);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void getNativeNodeTruncatedMap(CharSequence charSequence, Set set, int i) {
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            ShadowNode childAt = getChildAt(i2);
            if (childAt instanceof NativeLayoutNodeRef) {
                NativeLayoutNodeRef nativeLayoutNodeRef = (NativeLayoutNodeRef) childAt;
                if (nativeLayoutNodeRef.getSpanStart() >= charSequence.length() || nativeLayoutNodeRef.getSpanStart() >= i || charSequence.charAt(nativeLayoutNodeRef.getSpanStart()) != TextAttributes.INLINE_BLOCK_PLACEHOLDER.charAt(0)) {
                    set.add(Integer.valueOf(nativeLayoutNodeRef.getSignature()));
                }
            } else if ((childAt instanceof BaseTextShadowNode) && !(childAt instanceof InlineTruncationShadowNode)) {
                ((BaseTextShadowNode) childAt).getNativeNodeTruncatedMap(charSequence, set, i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void measureNativeNode(SpannableStringBuilder spannableStringBuilder, MeasureParam measureParam, MeasureContext measureContext) {
        for (int i = 0; i < getChildCount(); i++) {
            ShadowNode childAt = getChildAt(i);
            if (childAt instanceof NativeLayoutNodeRef) {
                NativeLayoutNodeRef nativeLayoutNodeRef = (NativeLayoutNodeRef) childAt;
                MeasureResult measureNativeNode = nativeLayoutNodeRef.measureNativeNode(measureContext, measureParam);
                for (NativeLayoutNodeSpan nativeLayoutNodeSpan : (NativeLayoutNodeSpan[]) spannableStringBuilder.getSpans(nativeLayoutNodeRef.getSpanStart(), nativeLayoutNodeRef.getSpanEnd(), NativeLayoutNodeSpan.class)) {
                    nativeLayoutNodeSpan.updateLayoutNodeSize((int) Math.ceil(measureNativeNode.getWidthResult()), (int) Math.ceil(measureNativeNode.getHeightResult()), (int) Math.ceil(measureNativeNode.getBaselineResult()));
                }
            } else if ((childAt instanceof BaseTextShadowNode) && !(childAt instanceof InlineTruncationShadowNode)) {
                ((BaseTextShadowNode) childAt).measureNativeNode(spannableStringBuilder, measureParam, measureContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void alignNativeNode(Layout layout, SpannableStringBuilder spannableStringBuilder, AlignParam alignParam, AlignContext alignContext, PointF pointF) {
        for (int i = 0; i < getChildCount(); i++) {
            ShadowNode childAt = getChildAt(i);
            if (childAt instanceof NativeLayoutNodeRef) {
                NativeLayoutNodeRef nativeLayoutNodeRef = (NativeLayoutNodeRef) childAt;
                AlignParam alignParam2 = new AlignParam();
                if (nativeLayoutNodeRef.getSpanStart() >= layout.getText().length()) {
                    nativeLayoutNodeRef.alignNativeNode(alignContext, alignParam2);
                } else {
                    NativeLayoutNodeSpan[] nativeLayoutNodeSpanArr = (NativeLayoutNodeSpan[]) spannableStringBuilder.getSpans(nativeLayoutNodeRef.getSpanStart(), nativeLayoutNodeRef.getSpanEnd(), NativeLayoutNodeSpan.class);
                    NativeLayoutNodeSpan nativeLayoutNodeSpan = nativeLayoutNodeSpanArr.length == 1 ? nativeLayoutNodeSpanArr[0] : null;
                    int lineForOffset = layout.getLineForOffset(nativeLayoutNodeRef.getSpanStart());
                    float primaryHorizontal = layout.getPrimaryHorizontal(nativeLayoutNodeRef.getSpanStart()) + pointF.x;
                    if (layout.isRtlCharAt(nativeLayoutNodeRef.getSpanStart())) {
                        primaryHorizontal -= nativeLayoutNodeSpan == null ? 0 : nativeLayoutNodeSpan.getWidth();
                    }
                    alignParam2.setLeftOffset(primaryHorizontal);
                    if (nativeLayoutNodeSpan != null) {
                        alignParam2.setTopOffset(nativeLayoutNodeSpan.getYOffset(layout.getLineTop(lineForOffset), layout.getLineBottom(lineForOffset), layout.getLineAscent(lineForOffset), layout.getLineDescent(lineForOffset)) + pointF.y);
                    }
                    nativeLayoutNodeRef.alignNativeNode(alignContext, alignParam2);
                }
            } else if ((childAt instanceof InlineTextShadowNode) || (childAt instanceof InlineTruncationShadowNode)) {
                ((BaseTextShadowNode) childAt).alignNativeNode(layout, spannableStringBuilder, alignParam, alignContext, pointF);
            }
        }
    }

    private CharSequence getDecodedCharSequence(String str, boolean z) {
        if (z) {
            return UnicodeFontUtils.decodeCSSContent(str, wordBreakStyleToDecodeProperty(this.mWordBreakStyle));
        }
        return UnicodeFontUtils.decode(str, wordBreakStyleToDecodeProperty(this.mWordBreakStyle));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public CharSequence getCharSequence(String str, boolean z) {
        if (!this.mEnableEmojiCompat || !sSupportEmojiCompat) {
            return getDecodedCharSequence(str, z);
        }
        try {
            return (CharSequence) sEmojiProcess.invoke(sEmojiCompatInst, getDecodedCharSequence(str, z));
        } catch (Exception e) {
            LLog.w(TAG, "process emoji: " + e);
            return getDecodedCharSequence(str, z);
        }
    }

    protected void appendText(SpannableStringBuilder spannableStringBuilder, String str, boolean z) {
        spannableStringBuilder.append(getCharSequence(str, z));
    }

    protected void configTextStroke(ForegroundColorSpan foregroundColorSpan) {
        if (this.mTextAttributes.getTextStrokeWidth() <= 0.0f || foregroundColorSpan == null || this.mTextAttributes.getTextStrokeColor() == 0) {
            return;
        }
        foregroundColorSpan.setStrokeColor(this.mTextAttributes.getTextStrokeColor());
        foregroundColorSpan.setStrokeWidth(this.mTextAttributes.getTextStrokeWidth());
        this.mNeedDrawStroke = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void buildStyledSpan(int i, int i2, List<SetSpanOperation> list) {
        if ((!isParagraph() && getTextAttributes().mFontColor != null) || getTextAttributes().mTextStrokeWidth > 0.0f) {
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(getTextAttributes().mFontColor == null ? -16777216 : getTextAttributes().mFontColor.intValue());
            configTextStroke(foregroundColorSpan);
            list.add(new SetSpanOperation(i, i2, foregroundColorSpan));
        }
        if (this.mTextAttributes.mTextDecorationStyle != 4 || this.mTextAttributes.mTextDecorationColor != 0) {
            boolean z = (this.mTextAttributes.mTextDecoration & 1) != 0;
            boolean z2 = (this.mTextAttributes.mTextDecoration & 2) != 0;
            if (z || z2) {
                list.add(new SetSpanOperation(i, i2, new TextDecorationSpan(z, z2, this.mTextAttributes.mTextDecorationStyle, this.mTextAttributes.mTextDecorationColor)));
            }
        } else {
            if ((this.mTextAttributes.mTextDecoration & 2) != 0) {
                list.add(new SetSpanOperation(i, i2, new LynxStrikethroughSpan()));
            }
            if ((this.mTextAttributes.mTextDecoration & 1) != 0) {
                list.add(new SetSpanOperation(i, i2, new LynxUnderlineSpan()));
            }
        }
        if (this.mTextAttributes.mTextVerticalAlign != -1 && Build.VERSION.SDK_INT > 28) {
            list.add(new SetSpanOperation(i, i2, new CustomBaselineShiftSpan(i, i2, this.mTextAttributes.mTextVerticalAlign, this.mTextAttributes.mBaselineShift)));
        }
        if (getShadowStyle() != null && getShadowStyle().verticalAlign != 0) {
            InlineTextBaselineShiftSpan inlineTextBaselineShiftSpan = new InlineTextBaselineShiftSpan();
            inlineTextBaselineShiftSpan.setVerticalAlign(getShadowStyle().verticalAlign, getShadowStyle().verticalAlignLength);
            list.add(new SetSpanOperation(i, i2, inlineTextBaselineShiftSpan));
        }
        if (isNeedSetLineHeightSpan()) {
            list.add(new SetSpanOperation(i, i2, new CustomLineHeightSpan(this.mTextAttributes.mLineHeight, isTextRefactorEnabled(), this.mTextAttributes.mTextSingleLineVerticalAlign, isSingLineAndOverflowClip())));
        }
        if (this.mTextAttributes.mTextShadow != null) {
            list.add(new SetSpanOperation(i, i2, new ShadowStyleSpan(this.mTextAttributes.mTextShadow)));
        }
        if (getTextAttributes().mLetterSpacing != 1.0E21f) {
            list.add(new SetSpanOperation(i, i2, new CustomLetterSpacingSpan(getTextAttributes().mLetterSpacing)));
        }
        if (Build.VERSION.SDK_INT >= 28 && !this.mForceFakeBold) {
            if (!isParagraph()) {
                list.add(new SetSpanOperation(i, i2, new CustomStyleSpan(getTextAttributes().mFontStyle, getTextAttributes().mFontWeight, getTextAttributes().mFontFamily, getTextAttributes().getFontVariationSettings(), getTextAttributes().getFontFeatureSettings(), getTextAttributes().mHasValidTypeface)));
            }
        } else if (getTextAttributes().mFontStyle == 1 || getTextAttributes().mFontStyle == 2 || getTypefaceStyle() == 1) {
            list.add(new SetSpanOperation(i, i2, new StyleSpan(getTypefaceStyle())));
        }
        if (getTextAttributes().mTextGradient != null) {
            list.add(new SetSpanOperation(i, i2, new LynxTextGradientSpan(getTextAttributes().mTextGradient)));
        }
    }

    private boolean isNeedSetLineHeightSpan() {
        return !(MeasureUtils.isUndefined(this.mTextAttributes.mLineHeight) || (isTextBoringLayoutEnabled() && isTextRefactorEnabled() && getTextAttributes().getWhiteSpace() == 1 && !getTextAttributes().hasImageSpan() && !getTextAttributes().hasInlineViewSpan())) || isEnableTextSingleLineVerticalAlignForSpan();
    }

    private boolean isSingLineAndOverflowClip() {
        return this.mTextAttributes.getTextOverflow() == 0 && (this.mTextAttributes.getMaxLineCount() == 1 || this.mTextAttributes.getWhiteSpace() == 1);
    }

    private boolean isEnableTextSingleLineVerticalAlignForSpan() {
        return (this.mTextAttributes.mTextSingleLineVerticalAlign == 0 || this.mTextAttributes.mHasInlineViewSpan || this.mTextAttributes.mHasImageSpan) ? false : true;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class SetSpanOperation {
        protected int end;
        protected int start;
        protected Object what;

        public SetSpanOperation(int i, int i2, Object obj) {
            this.start = i;
            this.end = i2;
            this.what = obj;
        }

        public void execute(SpannableStringBuilder spannableStringBuilder) {
            int i = this.start;
            int i2 = i == 0 ? 18 : 34;
            Object obj = this.what;
            if ((obj instanceof AbsInlineImageSpan) || (obj instanceof NativeLayoutNodeSpan)) {
                i2 = 33;
            }
            spannableStringBuilder.setSpan(obj, i, this.end, i2);
        }
    }

    private void setEnableFontScaling(boolean z) {
        this.mEnableFontScaling = z;
        setFontSize(this.mTextAttributes.mFontSize);
        for (int i = 0; i < getChildCount(); i++) {
            ShadowNode childAt = getChildAt(i);
            if (childAt instanceof BaseTextShadowNode) {
                ((BaseTextShadowNode) childAt).setEnableFontScaling(this.mEnableFontScaling);
            }
        }
    }

    @Override // com.lynx.tasm.behavior.shadow.ShadowNode
    public void addChildAt(ShadowNode shadowNode, int i) {
        super.addChildAt(shadowNode, i);
        if (shadowNode instanceof BaseTextShadowNode) {
            ((BaseTextShadowNode) shadowNode).setEnableFontScaling(this.mEnableFontScaling);
        }
    }

    @LynxProp(name = PropsConstants.BITMAP_GRADIENT)
    public void setEnableBitmapGradient(boolean z) {
        this.mEnableBitmapGradient = z;
        if (this.mTextAttributes.mTextGradient != null) {
            this.mTextAttributes.mTextGradient.setEnableBitmapGradient(z);
        }
    }

    @LynxProp(name = PropsConstants.TEXT_INDENT)
    public void setTextIndent(ReadableArray readableArray) {
        if (readableArray == null || readableArray.size() != 2) {
            this.mTextAttributes.mTextIndent = null;
        } else {
            this.mTextAttributes.mTextIndent = new TextIndent(readableArray);
        }
        markDirty();
    }

    @LynxProp(name = PropsConstants.ANDROID_EMOJI_COMPAT)
    public void setEnableEmojiCompat(boolean z) {
        this.mEnableEmojiCompat = z;
        if (z && sSupportEmojiCompat && sEmojiProcess == null) {
            try {
                Class<?> cls = Class.forName("androidx.emoji2.text.EmojiCompat");
                sEmojiCompatInst = cls.getDeclaredMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[0]).invoke(null, new Object[0]);
                sEmojiProcess = cls.getDeclaredMethod(IAssociationStartMonitorEventService.KEY_PROCESS, CharSequence.class);
                cls.getDeclaredMethod("setEmojiSpanIndicatorColor", Integer.TYPE).invoke(sEmojiCompatInst, 0);
            } catch (Exception e) {
                sSupportEmojiCompat = false;
                LLog.e(TAG, "enable emoji e: " + e);
            }
        }
        markDirty();
    }

    @LynxProp(name = PropsConstants.TEXT)
    public void setText(Dynamic dynamic) {
        this.mText = TextHelper.convertRawTextValue(dynamic);
        markDirty();
    }

    @LynxProp(name = PropsConstants.FONT_VARIATION_SETTINGS)
    public void setFontVariationSettings(ReadableArray readableArray) {
        if (readableArray == null || readableArray.size() == 0) {
            this.mTextAttributes.setFontVariationSettings(null);
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < readableArray.size() / 2; i++) {
                int i2 = i * 2;
                String string = readableArray.getString(i2);
                sb.append("'").append(string).append("' ").append(readableArray.getDouble(i2 + 1)).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            this.mTextAttributes.setFontVariationSettings(sb.toString());
        }
        markDirty();
    }

    @LynxProp(name = PropsConstants.FONT_FEATURE_SETTINGS)
    public void setFontFeatureSettings(ReadableArray readableArray) {
        if (readableArray == null || readableArray.size() == 0) {
            this.mTextAttributes.setFontFeatureSettings(null);
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < readableArray.size() / 2; i++) {
                int i2 = i * 2;
                String string = readableArray.getString(i2);
                sb.append("'").append(string).append("' ").append(readableArray.getInt(i2 + 1)).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            this.mTextAttributes.setFontFeatureSettings(sb.toString());
        }
        markDirty();
    }

    @LynxProp(name = PropsConstants.FONT_OPTICAL_SIZING)
    public void setFontFeatureSettings(int i) {
        this.mTextAttributes.setFontOpticalSizing(i == 1);
        markDirty();
    }
}
