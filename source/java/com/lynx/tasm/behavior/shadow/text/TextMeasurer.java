package com.lynx.tasm.behavior.shadow.text;

import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AlignmentSpan;
import android.text.style.StyleSpan;
import android.util.Log;
import android.util.SparseArray;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.mapbuffer.CompactArrayBuffer;
import com.lynx.react.bridge.mapbuffer.ReadableCompactArrayBuffer;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.p000ui.image.InlineImageSpan;
import com.lynx.tasm.behavior.p000ui.image.LynxImageManager;
import com.lynx.tasm.behavior.p000ui.utils.LynxBackground;
import com.lynx.tasm.behavior.shadow.MeasureMode;
import com.lynx.tasm.behavior.shadow.MeasureUtils;
import com.lynx.tasm.behavior.shadow.ShadowStyle;
import com.lynx.tasm.behavior.shadow.text.BaseTextShadowNode;
import com.lynx.tasm.behavior.shadow.text.TypefaceCache;
import com.lynx.tasm.behavior.utils.UnicodeFontUtils;
import com.lynx.tasm.fontface.FontFaceManager;
import com.lynx.tasm.utils.DeviceUtils;
import com.lynx.tasm.utils.PixelUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class TextMeasurer {
    private static final int kPropBorderRadius = 105;
    private static final int kPropImageSrc = 101;
    private static final int kPropInlineEnd = 1;
    private static final int kPropInlineStart = 0;
    private static final int kPropInlineViewSign = 102;
    private static final int kPropMargin = 104;
    private static final int kPropRectSize = 103;
    private static final int kPropTextString = 2;
    private static final int kTextPropBackGroundColor = 100;
    private static final int kTextPropColor = 4;
    private static final int kTextPropEnd = 255;
    private static final int kTextPropFontFamily = 9;
    private static final int kTextPropFontSize = 3;
    private static final int kTextPropFontStyle = 8;
    private static final int kTextPropFontWeight = 7;
    private static final int kTextPropLetterSpacing = 11;
    private static final int kTextPropLineHeight = 10;
    private static final int kTextPropLineSpacing = 12;
    private static final int kTextPropTextAlign = 15;
    private static final int kTextPropTextDecoration = 14;
    private static final int kTextPropTextMaxLine = 99;
    private static final int kTextPropTextOverflow = 6;
    private static final int kTextPropTextShadow = 13;
    private static final int kTextPropVerticalAlign = 16;
    private static final int kTextPropWhiteSpace = 5;
    private LynxContext mContext;
    private SparseArray<Object> mExtraDatas = new SparseArray<>();
    private SparseArray<Object> mAttributedTextBundles = new SparseArray<>();
    private long mNativePtr = 0;

    public TextMeasurer(LynxContext lynxContext) {
        this.mContext = lynxContext;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x0056. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x0059. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:8:0x005c. Please report as an issue. */
    public void dispatchLayoutBefore(int i, ReadableCompactArrayBuffer readableCompactArrayBuffer) {
        boolean z;
        TextAttributes textAttributes;
        ArrayList arrayList;
        SpannableStringBuilder spannableStringBuilder;
        Iterator it;
        HashMap<Integer, NativeLayoutNodeSpan> hashMap;
        ArrayList<AbsBaselineShiftCalculatorSpan> arrayList2;
        int i2;
        InlineImageProps inlineImageProps;
        int i3;
        float f;
        int i4;
        InlineImageProps inlineImageProps2;
        boolean z2;
        int i5;
        SpannableStringBuilder spannableStringBuilder2;
        boolean z3;
        Object obj;
        TextAttributes ensureTextAttributes;
        boolean z4;
        int i6;
        float f2;
        boolean z5;
        Object obj2;
        TextAttributes ensureTextAttributes2;
        boolean z6;
        int i7;
        SpannableStringBuilder spannableStringBuilder3;
        Object obj3;
        boolean z7;
        int i8;
        float f3;
        Object obj4;
        TextAttributes ensureTextAttributes3;
        SpannableStringBuilder spannableStringBuilder4;
        boolean z8;
        int i9;
        TextAttributes textAttributes2;
        float f4;
        int i10 = i;
        ArrayList arrayList3 = new ArrayList();
        SpannableStringBuilder spannableStringBuilder5 = new SpannableStringBuilder();
        Iterator it2 = readableCompactArrayBuffer.iterator();
        HashMap<Integer, NativeLayoutNodeSpan> hashMap2 = new HashMap<>();
        ArrayList<AbsBaselineShiftCalculatorSpan> arrayList4 = new ArrayList<>();
        float round = Math.round(PixelUtils.dipToPx(14.0f, this.mContext.getScreenMetrics().density));
        boolean z9 = false;
        int i11 = -1;
        InlineImageProps inlineImageProps3 = null;
        TextAttributes textAttributes3 = null;
        int i12 = 0;
        int i13 = 0;
        boolean z10 = true;
        ShadowStyle shadowStyle = null;
        boolean z11 = false;
        while (it2.hasNext()) {
            int i14 = ((CompactArrayBuffer.Entry) it2.next()).getInt();
            if (i14 != 99) {
                switch (i14) {
                    case 0:
                        arrayList = arrayList3;
                        spannableStringBuilder = spannableStringBuilder5;
                        it = it2;
                        hashMap = hashMap2;
                        arrayList2 = arrayList4;
                        i3 = i10;
                        i12 = ((CompactArrayBuffer.Entry) it.next()).getInt();
                        z9 = z9;
                        shadowStyle = null;
                        z10 = false;
                        i10 = i3;
                        break;
                    case 1:
                        boolean z12 = z9;
                        arrayList = arrayList3;
                        spannableStringBuilder = spannableStringBuilder5;
                        it = it2;
                        hashMap = hashMap2;
                        arrayList2 = arrayList4;
                        int i15 = i11;
                        InlineImageProps inlineImageProps4 = inlineImageProps3;
                        i3 = i10;
                        float f5 = round;
                        int i16 = ((CompactArrayBuffer.Entry) it.next()).getInt();
                        if (i15 != -1) {
                            i4 = -1;
                            inlineImageProps2 = null;
                            buildNativeNodeSpan(i12, i16, arrayList, shadowStyle, arrayList2, hashMap, i15);
                        } else {
                            i4 = -1;
                            inlineImageProps2 = null;
                            if (inlineImageProps4 != null) {
                                buildImageStyledSpan(i12, i16, arrayList, inlineImageProps4, textAttributes3, shadowStyle, arrayList2);
                            } else {
                                buildStyledSpanIfNeeded(i12, i16, arrayList, textAttributes3, new TypefaceListener(i3, this), false);
                            }
                        }
                        round = f5;
                        i13 = i16;
                        z9 = z12;
                        z10 = true;
                        inlineImageProps3 = inlineImageProps2;
                        textAttributes3 = inlineImageProps3;
                        i11 = i4;
                        i12 = 0;
                        i10 = i3;
                        break;
                    case 2:
                        boolean z13 = z9;
                        arrayList = arrayList3;
                        it = it2;
                        hashMap = hashMap2;
                        arrayList2 = arrayList4;
                        String string = ((CompactArrayBuffer.Entry) it.next()).getString();
                        TextAttributes ensureTextAttributes4 = ensureTextAttributes(textAttributes3);
                        spannableStringBuilder = spannableStringBuilder5;
                        spannableStringBuilder.append((CharSequence) UnicodeFontUtils.decode(string, 0));
                        i3 = i;
                        buildStyledSpanIfNeeded(0, string.length(), arrayList, ensureTextAttributes4, new TypefaceListener(i3, this), true);
                        textAttributes3 = ensureTextAttributes4;
                        round = round;
                        i11 = i11;
                        inlineImageProps3 = inlineImageProps3;
                        z9 = z13;
                        i10 = i3;
                        break;
                    case 3:
                        z2 = z9;
                        i5 = i11;
                        arrayList = arrayList3;
                        spannableStringBuilder2 = spannableStringBuilder5;
                        it = it2;
                        hashMap = hashMap2;
                        arrayList2 = arrayList4;
                        z3 = true;
                        obj = null;
                        TextAttributes ensureTextAttributes5 = ensureTextAttributes(textAttributes3);
                        ensureTextAttributes5.setFontSize((float) ((CompactArrayBuffer.Entry) it.next()).getDouble());
                        i3 = i;
                        textAttributes3 = ensureTextAttributes5;
                        round = Math.max(round, ensureTextAttributes5.mFontSize);
                        i11 = i5;
                        z9 = z2;
                        spannableStringBuilder = spannableStringBuilder2;
                        i10 = i3;
                        break;
                    case 4:
                        z2 = z9;
                        i5 = i11;
                        arrayList = arrayList3;
                        spannableStringBuilder2 = spannableStringBuilder5;
                        it = it2;
                        hashMap = hashMap2;
                        arrayList2 = arrayList4;
                        z3 = true;
                        obj = null;
                        ensureTextAttributes = ensureTextAttributes(textAttributes3);
                        ensureTextAttributes.setFontColor(((CompactArrayBuffer.Entry) it.next()).getInt());
                        i3 = i;
                        textAttributes3 = ensureTextAttributes;
                        i11 = i5;
                        z9 = z2;
                        spannableStringBuilder = spannableStringBuilder2;
                        i10 = i3;
                        break;
                    case 5:
                        z4 = z9;
                        i6 = i11;
                        f2 = round;
                        arrayList = arrayList3;
                        spannableStringBuilder2 = spannableStringBuilder5;
                        it = it2;
                        hashMap = hashMap2;
                        arrayList2 = arrayList4;
                        z5 = true;
                        obj2 = null;
                        int i17 = ((CompactArrayBuffer.Entry) it.next()).getInt();
                        if (!z10) {
                            Log.w("TextMeasurer", "white-space should be set to paragraph");
                            i3 = i;
                            inlineImageProps = inlineImageProps3;
                            textAttributes = textAttributes3;
                            i2 = i6;
                            z = z4;
                            f = f2;
                            spannableStringBuilder = spannableStringBuilder2;
                            textAttributes3 = textAttributes;
                            round = f;
                            i10 = i3;
                            i11 = i2;
                            inlineImageProps3 = inlineImageProps;
                            z9 = z;
                            break;
                        } else {
                            ensureTextAttributes2 = ensureTextAttributes(textAttributes3);
                            ensureTextAttributes2.mWhiteSpace = i17;
                            i3 = i;
                            textAttributes3 = ensureTextAttributes2;
                            i11 = i6;
                            z9 = z4;
                            round = f2;
                            spannableStringBuilder = spannableStringBuilder2;
                            i10 = i3;
                            break;
                        }
                    case 6:
                        z4 = z9;
                        i6 = i11;
                        f2 = round;
                        arrayList = arrayList3;
                        spannableStringBuilder2 = spannableStringBuilder5;
                        it = it2;
                        hashMap = hashMap2;
                        arrayList2 = arrayList4;
                        z5 = true;
                        obj2 = null;
                        int i18 = ((CompactArrayBuffer.Entry) it.next()).getInt();
                        if (!z10) {
                            Log.w("TextMeasurer", "text-overflow should be set to paragraph");
                            i3 = i;
                            inlineImageProps = inlineImageProps3;
                            textAttributes = textAttributes3;
                            i2 = i6;
                            z = z4;
                            f = f2;
                            spannableStringBuilder = spannableStringBuilder2;
                            textAttributes3 = textAttributes;
                            round = f;
                            i10 = i3;
                            i11 = i2;
                            inlineImageProps3 = inlineImageProps;
                            z9 = z;
                            break;
                        } else {
                            ensureTextAttributes2 = ensureTextAttributes(textAttributes3);
                            ensureTextAttributes2.mTextOverflow = i18;
                            i3 = i;
                            textAttributes3 = ensureTextAttributes2;
                            i11 = i6;
                            z9 = z4;
                            round = f2;
                            spannableStringBuilder = spannableStringBuilder2;
                            i10 = i3;
                            break;
                        }
                    case 7:
                        z2 = z9;
                        i5 = i11;
                        arrayList = arrayList3;
                        spannableStringBuilder2 = spannableStringBuilder5;
                        it = it2;
                        hashMap = hashMap2;
                        arrayList2 = arrayList4;
                        z3 = true;
                        obj = null;
                        ensureTextAttributes = ensureTextAttributes(textAttributes3);
                        ensureTextAttributes.setFontWeight(((CompactArrayBuffer.Entry) it.next()).getInt());
                        i3 = i;
                        textAttributes3 = ensureTextAttributes;
                        i11 = i5;
                        z9 = z2;
                        spannableStringBuilder = spannableStringBuilder2;
                        i10 = i3;
                        break;
                    case 8:
                        z4 = z9;
                        i6 = i11;
                        f2 = round;
                        arrayList = arrayList3;
                        spannableStringBuilder2 = spannableStringBuilder5;
                        it = it2;
                        hashMap = hashMap2;
                        arrayList2 = arrayList4;
                        obj2 = null;
                        int i19 = ((CompactArrayBuffer.Entry) it.next()).getInt();
                        z5 = true;
                        int i20 = (i19 == 1 || i19 == 2) ? 2 : 0;
                        TextAttributes ensureTextAttributes6 = ensureTextAttributes(textAttributes3);
                        ensureTextAttributes6.setFontStyle(i20);
                        i3 = i;
                        textAttributes3 = ensureTextAttributes6;
                        i11 = i6;
                        z9 = z4;
                        round = f2;
                        spannableStringBuilder = spannableStringBuilder2;
                        i10 = i3;
                        break;
                    case 9:
                        z6 = z9;
                        i7 = i11;
                        arrayList = arrayList3;
                        spannableStringBuilder3 = spannableStringBuilder5;
                        it = it2;
                        hashMap = hashMap2;
                        arrayList2 = arrayList4;
                        obj3 = null;
                        TextAttributes ensureTextAttributes7 = ensureTextAttributes(textAttributes3);
                        ensureTextAttributes7.setFontFamily(((CompactArrayBuffer.Entry) it.next()).getString());
                        i3 = i;
                        textAttributes3 = ensureTextAttributes7;
                        i11 = i7;
                        z9 = z6;
                        spannableStringBuilder = spannableStringBuilder3;
                        i10 = i3;
                        break;
                    case 10:
                        z7 = z9;
                        i8 = i11;
                        f3 = round;
                        arrayList = arrayList3;
                        spannableStringBuilder3 = spannableStringBuilder5;
                        it = it2;
                        hashMap = hashMap2;
                        arrayList2 = arrayList4;
                        obj4 = null;
                        float f6 = (float) ((CompactArrayBuffer.Entry) it.next()).getDouble();
                        if (!z10) {
                            Log.w("TextMeasurer", "line-height should be set to paragraph");
                            i3 = i;
                            inlineImageProps = inlineImageProps3;
                            textAttributes = textAttributes3;
                            i2 = i8;
                            z = z7;
                            f = f3;
                            spannableStringBuilder = spannableStringBuilder3;
                            textAttributes3 = textAttributes;
                            round = f;
                            i10 = i3;
                            i11 = i2;
                            inlineImageProps3 = inlineImageProps;
                            z9 = z;
                            break;
                        } else {
                            ensureTextAttributes3 = ensureTextAttributes(textAttributes3);
                            ensureTextAttributes3.setLineHeight(f6);
                            i3 = i;
                            textAttributes3 = ensureTextAttributes3;
                            i11 = i8;
                            z9 = z7;
                            round = f3;
                            spannableStringBuilder = spannableStringBuilder3;
                            i10 = i3;
                            break;
                        }
                    case 11:
                        z6 = z9;
                        i7 = i11;
                        arrayList = arrayList3;
                        spannableStringBuilder3 = spannableStringBuilder5;
                        it = it2;
                        hashMap = hashMap2;
                        arrayList2 = arrayList4;
                        obj3 = null;
                        double d = ((CompactArrayBuffer.Entry) it.next()).getDouble();
                        textAttributes3 = ensureTextAttributes(textAttributes3);
                        textAttributes3.mLetterSpacing = (float) d;
                        i3 = i;
                        i11 = i7;
                        z9 = z6;
                        spannableStringBuilder = spannableStringBuilder3;
                        i10 = i3;
                        break;
                    default:
                        switch (i14) {
                            case 14:
                                z7 = z9;
                                i8 = i11;
                                f3 = round;
                                arrayList = arrayList3;
                                spannableStringBuilder3 = spannableStringBuilder5;
                                it = it2;
                                hashMap = hashMap2;
                                arrayList2 = arrayList4;
                                obj4 = null;
                                int i21 = ((CompactArrayBuffer.Entry) it.next()).getInt();
                                int i22 = ((CompactArrayBuffer.Entry) it.next()).getInt();
                                int i23 = ((CompactArrayBuffer.Entry) it.next()).getInt();
                                textAttributes3 = ensureTextAttributes(textAttributes3);
                                textAttributes3.mTextDecoration = i21;
                                textAttributes3.mTextDecorationStyle = i22;
                                textAttributes3.mTextDecorationColor = i23;
                                i3 = i;
                                i11 = i8;
                                z9 = z7;
                                round = f3;
                                spannableStringBuilder = spannableStringBuilder3;
                                i10 = i3;
                                break;
                            case 15:
                                z7 = z9;
                                i8 = i11;
                                TextAttributes textAttributes4 = textAttributes3;
                                f3 = round;
                                arrayList = arrayList3;
                                spannableStringBuilder3 = spannableStringBuilder5;
                                it = it2;
                                hashMap = hashMap2;
                                arrayList2 = arrayList4;
                                obj4 = null;
                                int i24 = ((CompactArrayBuffer.Entry) it.next()).getInt();
                                if (!z10) {
                                    Log.w("TextMeasurer", "text-align should be set to paragraph");
                                    i3 = i;
                                    inlineImageProps = inlineImageProps3;
                                    i2 = i8;
                                    z = z7;
                                    f = f3;
                                    textAttributes = textAttributes4;
                                    spannableStringBuilder = spannableStringBuilder3;
                                    textAttributes3 = textAttributes;
                                    round = f;
                                    i10 = i3;
                                    i11 = i2;
                                    inlineImageProps3 = inlineImageProps;
                                    z9 = z;
                                    break;
                                } else {
                                    ensureTextAttributes3 = ensureTextAttributes(textAttributes4);
                                    ensureTextAttributes3.mTextAlign = i24;
                                    i3 = i;
                                    textAttributes3 = ensureTextAttributes3;
                                    i11 = i8;
                                    z9 = z7;
                                    round = f3;
                                    spannableStringBuilder = spannableStringBuilder3;
                                    i10 = i3;
                                    break;
                                }
                            case 16:
                                boolean z14 = z9;
                                arrayList = arrayList3;
                                SpannableStringBuilder spannableStringBuilder6 = spannableStringBuilder5;
                                it = it2;
                                hashMap = hashMap2;
                                arrayList2 = arrayList4;
                                ShadowStyle shadowStyle2 = new ShadowStyle();
                                shadowStyle2.verticalAlign = ((CompactArrayBuffer.Entry) it.next()).getInt();
                                shadowStyle2.verticalAlignLength = (float) ((CompactArrayBuffer.Entry) it.next()).getDouble();
                                i3 = i;
                                shadowStyle = shadowStyle2;
                                i11 = i11;
                                z9 = z14;
                                round = round;
                                textAttributes3 = textAttributes3;
                                spannableStringBuilder = spannableStringBuilder6;
                                z11 = true;
                                i10 = i3;
                                break;
                            default:
                                switch (i14) {
                                    case 101:
                                        arrayList = arrayList3;
                                        SpannableStringBuilder spannableStringBuilder7 = spannableStringBuilder5;
                                        it = it2;
                                        hashMap = hashMap2;
                                        arrayList2 = arrayList4;
                                        InlineImageProps inlineImageProps5 = new InlineImageProps();
                                        inlineImageProps5.mSrc = ((CompactArrayBuffer.Entry) it.next()).getString();
                                        i3 = i;
                                        inlineImageProps3 = inlineImageProps5;
                                        i11 = i11;
                                        spannableStringBuilder = spannableStringBuilder7;
                                        z9 = true;
                                        i10 = i3;
                                        break;
                                    case 102:
                                        arrayList = arrayList3;
                                        spannableStringBuilder4 = spannableStringBuilder5;
                                        it = it2;
                                        hashMap = hashMap2;
                                        arrayList2 = arrayList4;
                                        i3 = i;
                                        i11 = ((CompactArrayBuffer.Entry) it.next()).getInt();
                                        z9 = z9;
                                        spannableStringBuilder = spannableStringBuilder4;
                                        i10 = i3;
                                        break;
                                    case 103:
                                        z8 = z9;
                                        i9 = i11;
                                        textAttributes2 = textAttributes3;
                                        f4 = round;
                                        arrayList = arrayList3;
                                        spannableStringBuilder4 = spannableStringBuilder5;
                                        it = it2;
                                        hashMap = hashMap2;
                                        arrayList2 = arrayList4;
                                        int i25 = ((CompactArrayBuffer.Entry) it.next()).getInt();
                                        int i26 = ((CompactArrayBuffer.Entry) it.next()).getInt();
                                        if (inlineImageProps3 != null) {
                                            inlineImageProps3.mWidth = i25;
                                            inlineImageProps3.mHeight = i26;
                                        }
                                        i3 = i;
                                        i11 = i9;
                                        z9 = z8;
                                        round = f4;
                                        textAttributes3 = textAttributes2;
                                        spannableStringBuilder = spannableStringBuilder4;
                                        i10 = i3;
                                        break;
                                    case 104:
                                        z8 = z9;
                                        i9 = i11;
                                        textAttributes2 = textAttributes3;
                                        f4 = round;
                                        arrayList = arrayList3;
                                        spannableStringBuilder4 = spannableStringBuilder5;
                                        it = it2;
                                        hashMap = hashMap2;
                                        arrayList2 = arrayList4;
                                        int[] iArr = {((CompactArrayBuffer.Entry) it.next()).getInt(), ((CompactArrayBuffer.Entry) it.next()).getInt(), ((CompactArrayBuffer.Entry) it.next()).getInt(), ((CompactArrayBuffer.Entry) it.next()).getInt()};
                                        if (inlineImageProps3 != null) {
                                            inlineImageProps3.mMargins = iArr;
                                        }
                                        i3 = i;
                                        i11 = i9;
                                        z9 = z8;
                                        round = f4;
                                        textAttributes3 = textAttributes2;
                                        spannableStringBuilder = spannableStringBuilder4;
                                        i10 = i3;
                                        break;
                                    case 105:
                                        double d2 = ((CompactArrayBuffer.Entry) it2.next()).getDouble();
                                        int i27 = ((CompactArrayBuffer.Entry) it2.next()).getInt();
                                        z8 = z9;
                                        i9 = i11;
                                        double d3 = ((CompactArrayBuffer.Entry) it2.next()).getDouble();
                                        hashMap = hashMap2;
                                        int i28 = ((CompactArrayBuffer.Entry) it2.next()).getInt();
                                        arrayList = arrayList3;
                                        double d4 = ((CompactArrayBuffer.Entry) it2.next()).getDouble();
                                        arrayList2 = arrayList4;
                                        int i29 = ((CompactArrayBuffer.Entry) it2.next()).getInt();
                                        textAttributes2 = textAttributes3;
                                        f4 = round;
                                        double d5 = ((CompactArrayBuffer.Entry) it2.next()).getDouble();
                                        spannableStringBuilder4 = spannableStringBuilder5;
                                        int i30 = ((CompactArrayBuffer.Entry) it2.next()).getInt();
                                        if (inlineImageProps3 == null) {
                                            Log.w("TextMeasurer", "border-radius should be processed for inline image");
                                            i3 = i;
                                            inlineImageProps = inlineImageProps3;
                                            it = it2;
                                            i2 = i9;
                                            z = z8;
                                            f = f4;
                                            textAttributes = textAttributes2;
                                            spannableStringBuilder = spannableStringBuilder4;
                                            textAttributes3 = textAttributes;
                                            round = f;
                                            i10 = i3;
                                            i11 = i2;
                                            inlineImageProps3 = inlineImageProps;
                                            z9 = z;
                                            break;
                                        } else {
                                            it = it2;
                                            LynxBackground lynxBackground = new LynxBackground(this.mContext);
                                            JavaOnlyArray javaOnlyArray = new JavaOnlyArray();
                                            javaOnlyArray.pushDouble(d2);
                                            javaOnlyArray.pushInt(i27);
                                            javaOnlyArray.pushDouble(d2);
                                            javaOnlyArray.pushInt(i27);
                                            javaOnlyArray.pushDouble(d3);
                                            javaOnlyArray.pushInt(i28);
                                            javaOnlyArray.pushDouble(d3);
                                            javaOnlyArray.pushInt(i28);
                                            javaOnlyArray.pushDouble(d4);
                                            javaOnlyArray.pushInt(i29);
                                            javaOnlyArray.pushDouble(d4);
                                            javaOnlyArray.pushInt(i29);
                                            javaOnlyArray.pushDouble(d5);
                                            javaOnlyArray.pushInt(i30);
                                            javaOnlyArray.pushDouble(d5);
                                            javaOnlyArray.pushInt(i30);
                                            lynxBackground.setBorderRadius(0, javaOnlyArray);
                                            inlineImageProps3.mComplexBackground = lynxBackground;
                                            i3 = i;
                                            i11 = i9;
                                            z9 = z8;
                                            round = f4;
                                            textAttributes3 = textAttributes2;
                                            spannableStringBuilder = spannableStringBuilder4;
                                            i10 = i3;
                                            break;
                                        }
                                    default:
                                        z8 = z9;
                                        i9 = i11;
                                        textAttributes2 = textAttributes3;
                                        f4 = round;
                                        arrayList = arrayList3;
                                        spannableStringBuilder4 = spannableStringBuilder5;
                                        it = it2;
                                        hashMap = hashMap2;
                                        arrayList2 = arrayList4;
                                        i3 = i;
                                        i11 = i9;
                                        z9 = z8;
                                        round = f4;
                                        textAttributes3 = textAttributes2;
                                        spannableStringBuilder = spannableStringBuilder4;
                                        i10 = i3;
                                        break;
                                }
                        }
                }
            } else {
                z = z9;
                textAttributes = textAttributes3;
                arrayList = arrayList3;
                spannableStringBuilder = spannableStringBuilder5;
                it = it2;
                hashMap = hashMap2;
                arrayList2 = arrayList4;
                i2 = i11;
                inlineImageProps = inlineImageProps3;
                i3 = i10;
                f = round;
                int i31 = ((CompactArrayBuffer.Entry) it.next()).getInt();
                if (!z10) {
                    Log.w("TextMeasurer", "text-maxline should be set to paragraph");
                    textAttributes3 = textAttributes;
                    round = f;
                    i10 = i3;
                    i11 = i2;
                    inlineImageProps3 = inlineImageProps;
                    z9 = z;
                } else {
                    TextAttributes ensureTextAttributes8 = ensureTextAttributes(textAttributes);
                    ensureTextAttributes8.mMaxLineCount = i31;
                    textAttributes3 = ensureTextAttributes8;
                    round = f;
                    i11 = i2;
                    inlineImageProps3 = inlineImageProps;
                    z9 = z;
                    i10 = i3;
                }
            }
            hashMap2 = hashMap;
            arrayList4 = arrayList2;
            it2 = it;
            spannableStringBuilder5 = spannableStringBuilder;
            arrayList3 = arrayList;
        }
        boolean z15 = z9;
        TextAttributes textAttributes5 = textAttributes3;
        ArrayList arrayList5 = arrayList3;
        SpannableStringBuilder spannableStringBuilder8 = spannableStringBuilder5;
        HashMap<Integer, NativeLayoutNodeSpan> hashMap3 = hashMap2;
        ArrayList<AbsBaselineShiftCalculatorSpan> arrayList6 = arrayList4;
        int i32 = i10;
        float f7 = round;
        if (spannableStringBuilder8.length() == 0 && i13 > 0) {
            Log.e("TextMeasurer", "decode buffer error:" + readableCompactArrayBuffer.getString(readableCompactArrayBuffer.count() - 1));
        }
        for (int size = arrayList5.size() - 1; size >= 0; size--) {
            arrayList5.get(size).execute(spannableStringBuilder8);
        }
        if (textAttributes5 == null) {
            return;
        }
        if (z11) {
            float f8 = f7 * 1.2f;
            BaselineShiftCalculator baselineShiftCalculator = new BaselineShiftCalculator(Arrays.asList(Float.valueOf((-f7) * 1.2f * 0.78f), Float.valueOf(0.22f * f8), Float.valueOf(f8 * 0.5f), Float.valueOf(textAttributes5.mLineHeight == 1.0E21f ? 0.0f : textAttributes5.mLineHeight)));
            for (int i33 = 0; i33 < arrayList6.size(); i33++) {
                arrayList6.get(i33).setBaselineShiftCalculator(baselineShiftCalculator);
            }
        }
        textAttributes5.setHasImageSpan(z15);
        textAttributes5.setHasInlineViewSpan(!hashMap3.isEmpty());
        AttributedTextBundle attributedTextBundle = new AttributedTextBundle(spannableStringBuilder8, textAttributes5);
        if (!hashMap3.isEmpty()) {
            attributedTextBundle.setInlineViewMap(hashMap3);
        }
        this.mAttributedTextBundles.put(i32, attributedTextBundle);
    }

    public float[] measureText(int i, float f, int i2, float f2, int i3, float[] fArr) {
        AttributedTextBundle attributedTextBundle = (AttributedTextBundle) this.mAttributedTextBundles.get(i);
        if (attributedTextBundle != null) {
            for (int i4 = 0; i4 < fArr.length / 4; i4++) {
                NativeLayoutNodeSpan nativeLayoutNodeSpan = attributedTextBundle.getNativeLayoutNodeSpan((int) fArr[i4 * 4]);
                if (nativeLayoutNodeSpan != null) {
                    nativeLayoutNodeSpan.updateLayoutNodeSize((int) Math.ceil(fArr[r2 + 1]), (int) Math.ceil(fArr[r2 + 2]), (int) Math.ceil(fArr[r2 + 3]));
                }
            }
        }
        return measureTextInternal(i, f, MeasureMode.fromInt(i2), f2, MeasureMode.fromInt(i3), new TypefaceListener(i, this));
    }

    TextAttributes ensureTextAttributes(TextAttributes textAttributes) {
        return textAttributes == null ? buildTextAttributes() : textAttributes;
    }

    private float[] measureTextInternal(int i, float f, MeasureMode measureMode, float f2, MeasureMode measureMode2, TypefaceListener typefaceListener) {
        float[] fArr = new float[3];
        AttributedTextBundle attributedTextBundle = (AttributedTextBundle) this.mAttributedTextBundles.get(i);
        if (attributedTextBundle == null) {
            return fArr;
        }
        TextRenderer textRenderer = new TextRenderer(this.mContext, new TextRendererKey(attributedTextBundle.getSpan(), attributedTextBundle.getTextAttributes(), measureMode, measureMode2, f, f2, 0, false, true, true));
        float textLayoutHeight = textRenderer.getTextLayoutHeight();
        float layoutWidth = textRenderer.getLayoutWidth();
        int lineBaseline = textRenderer.getTextLayout().getLineBaseline(0);
        fArr[0] = layoutWidth;
        fArr[1] = textLayoutHeight;
        fArr[2] = lineBaseline;
        TextUpdateBundle textUpdateBundle = new TextUpdateBundle(textRenderer.getTextLayout(), attributedTextBundle.getTextAttributes().hasImageSpan(), null, false);
        textUpdateBundle.setTextTranslateOffset(textRenderer.getTextTranslateOffset());
        textUpdateBundle.setOriginText(attributedTextBundle.getSpan());
        this.mExtraDatas.put(i, textUpdateBundle);
        return fArr;
    }

    private boolean needSetLineHeightSpan(TextAttributes textAttributes) {
        return !MeasureUtils.isUndefined(textAttributes.mLineHeight) && (textAttributes.getWhiteSpace() != 1 || textAttributes.hasImageSpan() || textAttributes.hasInlineViewSpan());
    }

    private void buildStyledSpanIfNeeded(int i, int i2, List<BaseTextShadowNode.SetSpanOperation> list, TextAttributes textAttributes, TypefaceListener typefaceListener, boolean z) {
        if (textAttributes == null) {
            return;
        }
        if (z && needSetLineHeightSpan(textAttributes)) {
            list.add(new BaseTextShadowNode.SetSpanOperation(i, i2, new CustomLineHeightSpan(textAttributes.mLineHeight, true, 0, false)));
        }
        if (textAttributes.mLetterSpacing != 1.0E21f) {
            list.add(new BaseTextShadowNode.SetSpanOperation(i, i2, new CustomLetterSpacingSpan(textAttributes.mLetterSpacing)));
        }
        if (textAttributes.mTextDecorationStyle != 4 || textAttributes.mTextDecorationColor != 0) {
            boolean z2 = (textAttributes.mTextDecoration & 1) != 0;
            boolean z3 = (textAttributes.mTextDecoration & 2) != 0;
            if (z2 || z3) {
                list.add(new BaseTextShadowNode.SetSpanOperation(i, i2, new TextDecorationSpan(z2, z3, textAttributes.mTextDecorationStyle, textAttributes.mTextDecorationColor)));
            }
        } else {
            if ((textAttributes.mTextDecoration & 2) != 0) {
                list.add(new BaseTextShadowNode.SetSpanOperation(i, i2, new LynxStrikethroughSpan()));
            }
            if ((textAttributes.mTextDecoration & 1) != 0) {
                list.add(new BaseTextShadowNode.SetSpanOperation(i, i2, new LynxUnderlineSpan()));
            }
        }
        if (z) {
            return;
        }
        list.add(new BaseTextShadowNode.SetSpanOperation(i, i2, new AbsoluteSizeSpan(Math.round(textAttributes.mFontSize))));
        if (textAttributes.mFontColor != null) {
            list.add(new BaseTextShadowNode.SetSpanOperation(i, i2, new ForegroundColorSpan(textAttributes.mFontColor.intValue())));
        }
        if (!TextUtils.isEmpty(textAttributes.mFontFamily)) {
            Typeface typeface = TypefaceCache.getTypeface(this.mContext, textAttributes.mFontFamily, 0);
            if (typeface == null) {
                FontFaceManager.getInstance().getTypeface(this.mContext, textAttributes.mFontFamily, 0, typefaceListener);
                typeface = DeviceUtils.getDefaultTypeface();
            }
            list.add(new BaseTextShadowNode.SetSpanOperation(i, i2, new FontFamilySpan(typeface)));
        }
        if (textAttributes.isFontWeightBOLD() || textAttributes.mFontStyle > 0) {
            if (Build.VERSION.SDK_INT >= 28) {
                list.add(new BaseTextShadowNode.SetSpanOperation(i, i2, new CustomStyleSpan(textAttributes.mFontStyle, textAttributes.mFontWeight, textAttributes.mFontFamily, textAttributes.getFontVariationSettings(), textAttributes.getFontFeatureSettings(), textAttributes.mHasValidTypeface)));
            } else {
                list.add(new BaseTextShadowNode.SetSpanOperation(i, i2, new StyleSpan(textAttributes.getTypefaceStyle())));
            }
        }
        if (textAttributes.mTextAlign == 2) {
            list.add(new BaseTextShadowNode.SetSpanOperation(i, i2, new AlignmentSpan.Standard(Layout.Alignment.ALIGN_OPPOSITE)));
        } else if (textAttributes.mTextAlign == 1) {
            list.add(new BaseTextShadowNode.SetSpanOperation(i, i2, new AlignmentSpan.Standard(Layout.Alignment.ALIGN_CENTER)));
        }
    }

    private void buildNativeNodeSpan(int i, int i2, List<BaseTextShadowNode.SetSpanOperation> list, ShadowStyle shadowStyle, ArrayList<AbsBaselineShiftCalculatorSpan> arrayList, HashMap<Integer, NativeLayoutNodeSpan> hashMap, int i3) {
        NativeLayoutNodeSpan nativeLayoutNodeSpan = new NativeLayoutNodeSpan();
        nativeLayoutNodeSpan.setEnableTextRefactor(true);
        if (shadowStyle != null) {
            nativeLayoutNodeSpan.setVerticalAlign(shadowStyle.verticalAlign, shadowStyle.verticalAlignLength);
        }
        arrayList.add(nativeLayoutNodeSpan);
        nativeLayoutNodeSpan.setSpanIndex(i);
        list.add(new BaseTextShadowNode.SetSpanOperation(i, i2, nativeLayoutNodeSpan));
        hashMap.put(Integer.valueOf(i3), nativeLayoutNodeSpan);
    }

    private void buildImageStyledSpan(int i, int i2, List<BaseTextShadowNode.SetSpanOperation> list, InlineImageProps inlineImageProps, TextAttributes textAttributes, ShadowStyle shadowStyle, ArrayList<AbsBaselineShiftCalculatorSpan> arrayList) {
        if (inlineImageProps.mSrc == null) {
            return;
        }
        final InlineImageSpan inlineImageSpan = new InlineImageSpan(inlineImageProps.mWidth, inlineImageProps.mHeight, inlineImageProps.mMargins);
        inlineImageSpan.setEnableTextRefactor(true);
        if (arrayList != null) {
            arrayList.add(inlineImageSpan);
        }
        LynxImageManager lynxImageManager = new LynxImageManager(this.mContext) { // from class: com.lynx.tasm.behavior.shadow.text.TextMeasurer.1
            @Override // com.lynx.tasm.behavior.p000ui.image.LynxImageManager
            protected void onImageLoadError(LynxError lynxError, int i3, int i4) {
            }

            @Override // com.lynx.tasm.behavior.p000ui.image.LynxImageManager
            protected void onImageLoadSuccess(int i3, int i4) {
            }

            @Override // com.lynx.tasm.behavior.p000ui.image.LynxImageManager
            public void invalidate() {
                if (inlineImageSpan.getCallback() != null) {
                    inlineImageSpan.getCallback().invalidateDrawable(getSrcImageDrawable());
                }
            }
        };
        inlineImageSpan.setImageManager(lynxImageManager);
        lynxImageManager.setSrc(inlineImageProps.mSrc);
        if (inlineImageProps.mMode != null) {
            lynxImageManager.setMode(inlineImageProps.mMode);
        }
        if (shadowStyle != null) {
            inlineImageSpan.setVerticalAlign(shadowStyle.verticalAlign, shadowStyle.verticalAlignLength);
        }
        if (inlineImageProps.mComplexBackground != null && inlineImageProps.mComplexBackground.getDrawable() != null) {
            inlineImageProps.mComplexBackground.getDrawable().setBounds(0, 0, inlineImageProps.mWidth, inlineImageProps.mHeight);
            inlineImageSpan.setComplexBackground(inlineImageProps.mComplexBackground);
        }
        lynxImageManager.updateNodeProps();
        if (textAttributes != null) {
            inlineImageSpan.setVerticalShift(textAttributes.mBaselineShift);
        }
        list.add(new BaseTextShadowNode.SetSpanOperation(i, i2, inlineImageSpan));
    }

    private TextAttributes buildTextAttributes() {
        TextAttributes textAttributes = new TextAttributes();
        textAttributes.setFontSize(Math.round(PixelUtils.dipToPx(14.0f, this.mContext.getScreenMetrics().density)));
        return textAttributes;
    }

    public Object takeTextLayout(int i) {
        return this.mExtraDatas.get(i);
    }

    public void releaseLayoutObject(int i) {
        this.mExtraDatas.remove(i);
        this.mAttributedTextBundles.remove(i);
    }

    public void removeLayoutObjects() {
        this.mExtraDatas.clear();
        this.mAttributedTextBundles.clear();
    }

    public float[] align(int i) {
        float f;
        float f2;
        AttributedTextBundle attributedTextBundle = (AttributedTextBundle) this.mAttributedTextBundles.get(i);
        TextUpdateBundle textUpdateBundle = (TextUpdateBundle) this.mExtraDatas.get(i);
        if (attributedTextBundle == null || textUpdateBundle == null) {
            return new float[0];
        }
        ArrayList arrayList = new ArrayList();
        Set<Map.Entry<Integer, NativeLayoutNodeSpan>> nativeLayoutNodeSpans = attributedTextBundle.getNativeLayoutNodeSpans();
        if (nativeLayoutNodeSpans == null) {
            return new float[0];
        }
        Layout textLayout = textUpdateBundle.getTextLayout();
        HashSet hashSet = new HashSet();
        for (Map.Entry<Integer, NativeLayoutNodeSpan> entry : nativeLayoutNodeSpans) {
            NativeLayoutNodeSpan value = entry.getValue();
            if (value.getSpanIndex() < textLayout.getText().length()) {
                int lineForOffset = textLayout.getLineForOffset(value.getSpanIndex());
                f = textLayout.getPrimaryHorizontal(value.getSpanIndex()) + textUpdateBundle.getTextTranslateOffset().x;
                if (textLayout.isRtlCharAt(value.getSpanIndex())) {
                    f -= value.getWidth();
                }
                f2 = value.getYOffset(textLayout.getLineTop(lineForOffset), textLayout.getLineBottom(lineForOffset), textLayout.getLineAscent(lineForOffset), textLayout.getLineDescent(lineForOffset)) + textUpdateBundle.getTextTranslateOffset().y;
            } else {
                f = 0.0f;
                f2 = 0.0f;
            }
            if (value.getSpanIndex() >= textLayout.getText().length() || textLayout.getText().charAt(value.getSpanIndex()) != TextAttributes.INLINE_IMAGE_PLACEHOLDER.charAt(0)) {
                hashSet.add(entry.getKey());
            }
            arrayList.add(Float.valueOf(entry.getKey().intValue()));
            arrayList.add(Float.valueOf(f2));
            arrayList.add(Float.valueOf(f));
        }
        textUpdateBundle.setViewTruncatedSet(hashSet);
        float[] fArr = new float[arrayList.size()];
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            fArr[i2] = ((Float) arrayList.get(i2)).floatValue();
        }
        return fArr;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public class TypefaceListener implements TypefaceCache.TypefaceListener {
        private WeakReference<TextMeasurer> mReference;
        private int mSign;

        TypefaceListener(int i, TextMeasurer textMeasurer) {
            this.mSign = i;
            this.mReference = new WeakReference<>(textMeasurer);
        }

        @Override // com.lynx.tasm.behavior.shadow.text.TypefaceCache.TypefaceListener
        public void onTypefaceUpdate(Typeface typeface, int i) {
            this.mReference.get();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public class InlineImageProps {
        public LynxBackground mComplexBackground;
        public int mHeight;
        public int[] mMargins;
        public String mMode;
        public String mSrc;
        public int mWidth;

        private InlineImageProps() {
            this.mMargins = new int[4];
        }
    }
}
