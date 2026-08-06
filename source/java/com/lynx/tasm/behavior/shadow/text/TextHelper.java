package com.lynx.tasm.behavior.shadow.text;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import com.lynx.react.bridge.Dynamic;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableType;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.shadow.text.TypefaceCache;
import com.lynx.tasm.event.LynxDetailEvent;
import com.lynx.tasm.fontface.FontFaceManager;
import com.lynx.tasm.fontface.FontSettingsKey;
import com.lynx.tasm.utils.DeviceUtils;
import com.lynx.tasm.utils.PixelUtils;
import com.lynx.tasm.utils.UIThreadUtils;
import com.lynx.tasm.utils.UnitUtils;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class TextHelper {
    static final String EVENT_LAYOUT = "layout";
    static final String TAG = "TextHelper";
    private static final DecimalFormat decimalFormat = new DecimalFormat("###################.###########");

    private static int getStyleWeight(int i) {
        if (i == 1) {
            return 700;
        }
        if (i == 0) {
            return 400;
        }
        return (i - 1) * 100;
    }

    public static TextPaint newTextPaint(LynxContext lynxContext, TextAttributes textAttributes, TypefaceCache.TypefaceListener typefaceListener) {
        return newTextPaint(textAttributes, getTypeFaceFromCache(lynxContext, textAttributes, typefaceListener));
    }

    public static TextPaint newTextPaint(TextAttributes textAttributes, Typeface typeface) {
        TextPaint textPaint = new TextPaint(1);
        textPaint.setTextSize(textAttributes.mFontSize);
        if (!TextUtils.isEmpty(textAttributes.mFontFamily) && typeface != null) {
            textPaint.setTypeface(typeface);
        } else {
            textPaint.setTypeface(DeviceUtils.getDefaultTypeface());
        }
        String fontVariationSettings = textAttributes.getFontVariationSettings();
        String fontFeatureSettings = textAttributes.getFontFeatureSettings();
        if (textAttributes.mFontStyle != 0 || textAttributes.mFontWeight != 0 || fontVariationSettings != null || fontFeatureSettings != null) {
            updateTextPaintTypeFace(textPaint, textAttributes.mFontFamily, textAttributes.mFontStyle, textAttributes.mFontWeight, fontVariationSettings, fontFeatureSettings, textAttributes.mHasValidTypeface);
        }
        if (textAttributes.mFontColor != null) {
            textPaint.setColor(textAttributes.mFontColor.intValue());
        }
        if (textAttributes.mLetterSpacing != 1.0E21f) {
            textPaint.setLetterSpacing(textAttributes.mLetterSpacing / textPaint.getTextSize());
        }
        if (textAttributes.mTextShadow != null) {
            textPaint.setShadowLayer(textAttributes.mTextShadow.blurRadius, textAttributes.mTextShadow.offsetX, textAttributes.mTextShadow.offsetY, textAttributes.mTextShadow.color);
        }
        return textPaint;
    }

    public static Typeface getTypeFaceFromCache(LynxContext lynxContext, TextAttributes textAttributes, TypefaceCache.TypefaceListener typefaceListener) {
        String str = textAttributes.mFontFamily;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return TypefaceCache.getTypeface(lynxContext, str, textAttributes.getTypefaceStyle());
    }

    public static void drawLine(Canvas canvas, Layout layout) {
        Spanned spanned = (Spanned) layout.getText();
        TextDecorationSpan[] textDecorationSpanArr = (TextDecorationSpan[]) spanned.getSpans(0, spanned.length(), TextDecorationSpan.class);
        if (textDecorationSpanArr == null || textDecorationSpanArr.length == 0) {
            return;
        }
        int spanStart = spanned.getSpanStart(textDecorationSpanArr[0]);
        int spanEnd = spanned.getSpanEnd(textDecorationSpanArr[0]);
        int textSize = (int) layout.getPaint().getTextSize();
        if (spanStart == 0) {
            for (int i = 1; i < textDecorationSpanArr.length; i++) {
                int spanStart2 = spanned.getSpanStart(textDecorationSpanArr[i]);
                int spanEnd2 = spanned.getSpanEnd(textDecorationSpanArr[i]);
                AbsoluteSizeSpan[] absoluteSizeSpanArr = (AbsoluteSizeSpan[]) spanned.getSpans(spanStart2, spanEnd2, AbsoluteSizeSpan.class);
                int size = absoluteSizeSpanArr.length != 0 ? absoluteSizeSpanArr[0].getSize() : textSize;
                draw(canvas, layout, textDecorationSpanArr[i].mTextDecorationStyle, textDecorationSpanArr[i].mTextDecorationColor, textDecorationSpanArr[i].mUnderline, textDecorationSpanArr[i].mLineThrough, spanStart2, spanEnd2, size);
                if (spanStart2 >= spanStart && spanEnd2 <= spanEnd) {
                    draw(canvas, layout, textDecorationSpanArr[0].mTextDecorationStyle, textDecorationSpanArr[0].mTextDecorationColor, textDecorationSpanArr[0].mUnderline, textDecorationSpanArr[0].mLineThrough, spanEnd2 + 1, spanEnd, textSize);
                    draw(canvas, layout, textDecorationSpanArr[0].mTextDecorationStyle, textDecorationSpanArr[0].mTextDecorationColor, textDecorationSpanArr[0].mUnderline && !textDecorationSpanArr[i].mUnderline, textDecorationSpanArr[0].mLineThrough && !textDecorationSpanArr[i].mLineThrough, spanStart2, spanEnd2, size);
                    spanEnd = spanStart2;
                }
            }
            draw(canvas, layout, textDecorationSpanArr[0].mTextDecorationStyle, textDecorationSpanArr[0].mTextDecorationColor, textDecorationSpanArr[0].mUnderline, textDecorationSpanArr[0].mLineThrough, spanStart, spanEnd, textSize);
            return;
        }
        for (int i2 = 0; i2 < textDecorationSpanArr.length; i2++) {
            int spanStart3 = spanned.getSpanStart(textDecorationSpanArr[i2]);
            int spanEnd3 = spanned.getSpanEnd(textDecorationSpanArr[i2]);
            AbsoluteSizeSpan[] absoluteSizeSpanArr2 = (AbsoluteSizeSpan[]) spanned.getSpans(spanStart3, spanEnd3, AbsoluteSizeSpan.class);
            draw(canvas, layout, textDecorationSpanArr[i2].mTextDecorationStyle, textDecorationSpanArr[i2].mTextDecorationColor, textDecorationSpanArr[i2].mUnderline, textDecorationSpanArr[i2].mLineThrough, spanStart3, spanEnd3, absoluteSizeSpanArr2.length != 0 ? absoluteSizeSpanArr2[0].getSize() : textSize);
        }
    }

    public static void draw(Canvas canvas, Layout layout, int i, int i2, boolean z, boolean z2, int i3, int i4, int i5) {
        if (i3 < i4) {
            if (z || z2) {
                if (i == 4) {
                    drawSolid(canvas, layout, i2, z, z2, i3, i4, i5);
                    return;
                }
                if (i == 8) {
                    drawDouble(canvas, layout, i2, z, z2, i3, i4, i5);
                    return;
                }
                if (i == 16) {
                    drawDotted(canvas, layout, i2, z, z2, i3, i4, i5);
                } else if (i == 32) {
                    drawDash(canvas, layout, i2, z, z2, i3, i4, i5);
                } else {
                    if (i != 64) {
                        return;
                    }
                    drawWavy(canvas, layout, i2, z, z2, i3, i4, i5);
                }
            }
        }
    }

    public static void drawSolid(Canvas canvas, Layout layout, int i, boolean z, boolean z2, int i2, int i3, float f) {
        Paint paint = new Paint();
        paint.setColor(i);
        float f2 = f / 3.0f;
        paint.setStrokeWidth(f2 / 5.0f);
        int lineForOffset = layout.getLineForOffset(i2);
        int lineForOffset2 = layout.getLineForOffset(i3);
        for (int i4 = lineForOffset; i4 <= lineForOffset2; i4++) {
            float lineLeft = layout.getLineLeft(i4);
            float lineBaseline = layout.getLineBaseline(i4);
            float lineMax = layout.getLineMax(i4);
            if (i4 == lineForOffset) {
                lineMax = (lineLeft + lineMax) - layout.getPrimaryHorizontal(i2);
                lineLeft = layout.getPrimaryHorizontal(i2);
            }
            float f3 = lineLeft;
            if (i4 == lineForOffset2) {
                lineMax = layout.getPrimaryHorizontal(i3) - f3;
            }
            float f4 = lineMax;
            if (z) {
                float f5 = lineBaseline + (f2 / 3.0f);
                canvas.drawLine(f3, f5, f3 + f4, f5, paint);
            }
            if (z2) {
                float f6 = lineBaseline - ((f / 15.0f) * 4.0f);
                canvas.drawLine(f3, f6, f3 + f4, f6, paint);
            }
        }
    }

    public static void drawDouble(Canvas canvas, Layout layout, int i, boolean z, boolean z2, int i2, int i3, float f) {
        float f2;
        Paint paint = new Paint();
        paint.setColor(i);
        float f3 = f / 3.0f;
        int lineForOffset = layout.getLineForOffset(i2);
        int lineForOffset2 = layout.getLineForOffset(i3);
        float f4 = f3 / 5.0f;
        paint.setStrokeWidth(f4);
        for (int i4 = lineForOffset; i4 <= lineForOffset2; i4++) {
            float lineLeft = layout.getLineLeft(i4);
            float lineBaseline = layout.getLineBaseline(i4);
            float lineMax = layout.getLineMax(i4);
            if (i4 == lineForOffset) {
                lineMax = (lineLeft + lineMax) - layout.getPrimaryHorizontal(i2);
                lineLeft = layout.getPrimaryHorizontal(i2);
            }
            float f5 = lineLeft;
            if (i4 == lineForOffset2) {
                lineMax = layout.getPrimaryHorizontal(i3) - f5;
            }
            float f6 = lineMax;
            if (z) {
                float f7 = lineBaseline + (f3 / 3.0f);
                float f8 = f5 + f6;
                f2 = lineBaseline;
                canvas.drawLine(f5, f7, f8, f7, paint);
                float f9 = f2 + (f4 * 3.0f);
                canvas.drawLine(f5, f9, f8, f9, paint);
            } else {
                f2 = lineBaseline;
            }
            if (z2) {
                float f10 = f2 - ((f / 15.0f) * 4.0f);
                float f11 = f5 + f6;
                canvas.drawLine(f5, f10, f11, f10, paint);
                float f12 = f10 + ((f3 / 15.0f) * 4.0f);
                canvas.drawLine(f5, f12, f11, f12, paint);
            }
        }
    }

    public static void drawDotted(Canvas canvas, Layout layout, int i, boolean z, boolean z2, int i2, int i3, float f) {
        Paint paint = new Paint();
        paint.setColor(i);
        float f2 = 3.0f;
        float f3 = f / 3.0f;
        float f4 = f / 4.0f;
        int lineForOffset = layout.getLineForOffset(i2);
        int lineForOffset2 = layout.getLineForOffset(i3);
        paint.setStrokeWidth(f3 / 5.0f);
        int i4 = lineForOffset;
        while (i4 <= lineForOffset2) {
            float lineLeft = layout.getLineLeft(i4);
            float lineBaseline = layout.getLineBaseline(i4);
            float lineMax = layout.getLineMax(i4);
            if (i4 == lineForOffset) {
                lineMax = (lineLeft + lineMax) - layout.getPrimaryHorizontal(i2);
                lineLeft = layout.getPrimaryHorizontal(i2);
            }
            if (i4 == lineForOffset2) {
                lineMax = layout.getPrimaryHorizontal(i3) - lineLeft;
            }
            int floor = (int) Math.floor(lineMax / f4);
            if (floor == 0) {
                return;
            }
            float f5 = 0.0f;
            if (z) {
                float f6 = 0.0f;
                int i5 = 0;
                while (i5 < floor + 1) {
                    canvas.drawPoint(lineLeft + f6, lineBaseline + (f3 / f2), paint);
                    f6 += f4;
                    i5++;
                    f2 = 3.0f;
                }
            }
            if (z2) {
                float f7 = lineBaseline - ((f / 15.0f) * 4.0f);
                for (int i6 = 0; i6 < floor + 1; i6++) {
                    canvas.drawPoint(lineLeft + f5, f7, paint);
                    f5 += f4;
                }
            }
            i4++;
            f2 = 3.0f;
        }
    }

    public static void drawDash(Canvas canvas, Layout layout, int i, boolean z, boolean z2, int i2, int i3, float f) {
        float f2;
        int lineForOffset = layout.getLineForOffset(i2);
        int lineForOffset2 = layout.getLineForOffset(i3);
        Paint paint = new Paint();
        paint.setColor(i);
        float f3 = f / 3.0f;
        paint.setStrokeWidth(f3 / 5.0f);
        paint.setPathEffect(new DashPathEffect(new float[]{f / 7.0f, f / 20.0f}, 0.0f));
        for (int i4 = lineForOffset; i4 <= lineForOffset2; i4++) {
            float lineLeft = layout.getLineLeft(i4);
            float lineBaseline = layout.getLineBaseline(i4);
            float lineMax = layout.getLineMax(i4);
            if (i4 == lineForOffset) {
                lineMax = (lineLeft + lineMax) - layout.getPrimaryHorizontal(i2);
                lineLeft = layout.getPrimaryHorizontal(i2);
            }
            if (i4 == lineForOffset2) {
                lineMax = layout.getPrimaryHorizontal(i3) - lineLeft;
            }
            float f4 = lineMax;
            if (z) {
                float f5 = lineBaseline + (f3 / 3.0f);
                f2 = lineBaseline;
                canvas.drawLine(lineLeft, f5, lineLeft + f4, f5, paint);
            } else {
                f2 = lineBaseline;
            }
            if (z2) {
                float f6 = f2 - ((f / 15.0f) * 4.0f);
                canvas.drawLine(lineLeft, f6, lineLeft + f4, f6, paint);
            }
        }
    }

    public static void drawWavy(Canvas canvas, Layout layout, int i, boolean z, boolean z2, int i2, int i3, float f) {
        float f2;
        char c;
        Layout layout2 = layout;
        int i4 = i2;
        int i5 = i3;
        float f3 = 2.0f;
        float f4 = f / 2.0f;
        float f5 = f / 3.0f;
        int lineForOffset = layout2.getLineForOffset(i4);
        int lineForOffset2 = layout2.getLineForOffset(i5);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(i);
        paint.setStrokeWidth(f5 / 5.0f);
        int i6 = lineForOffset;
        while (i6 <= lineForOffset2) {
            float lineLeft = layout2.getLineLeft(i6);
            float lineBaseline = layout2.getLineBaseline(i6);
            float lineMax = layout2.getLineMax(i6);
            if (i6 == lineForOffset) {
                lineMax = (lineLeft + lineMax) - layout2.getPrimaryHorizontal(i4);
                lineLeft = layout2.getPrimaryHorizontal(i4);
            }
            if (i6 == lineForOffset2) {
                lineMax = layout2.getPrimaryHorizontal(i5) - lineLeft;
            }
            int round = Math.round(lineMax / f4);
            float f6 = 0.0f;
            if (z) {
                Path path = new Path();
                float f7 = lineBaseline + (f5 / f3);
                path.moveTo(lineLeft, f7);
                float f8 = 0.0f;
                for (int i7 = 0; i7 < round; i7++) {
                    float f9 = f4 / 4.0f;
                    path.quadTo(lineLeft + f9 + f8, lineBaseline, lineLeft + (f4 / 2.0f) + f8, f7);
                    path.quadTo(lineLeft + (f9 * 3.0f) + f8, lineBaseline + f5, lineLeft + f4 + f8, f7);
                    f8 += f4;
                }
                canvas.drawPath(path, paint);
            }
            if (z2) {
                Path path2 = new Path();
                float f10 = lineBaseline - ((f / 15.0f) * 4.0f);
                path2.moveTo(lineLeft, f10);
                int i8 = 0;
                while (i8 < round) {
                    float f11 = f4 / 4.0f;
                    float f12 = f5 / 2.0f;
                    path2.quadTo(lineLeft + f11 + f6, f10 - f12, lineLeft + (f4 / 2.0f) + f6, f10);
                    path2.quadTo((f11 * 3.0f) + lineLeft + f6, f12 + f10, lineLeft + f4 + f6, f10);
                    f6 += f4;
                    i8++;
                    f5 = f5;
                }
                f2 = f5;
                c = 0;
                canvas.drawPath(path2, paint);
            } else {
                f2 = f5;
                c = 0;
            }
            i6++;
            layout2 = layout;
            i4 = i2;
            f5 = f2;
            f3 = 2.0f;
            i5 = i3;
        }
    }

    public static void drawTextStroke(Layout layout, Canvas canvas) {
        Spanned spanned = (Spanned) layout.getText();
        ForegroundColorSpan[] foregroundColorSpanArr = (ForegroundColorSpan[]) spanned.getSpans(0, spanned.length(), ForegroundColorSpan.class);
        if (foregroundColorSpanArr == null || foregroundColorSpanArr.length <= 0) {
            return;
        }
        for (ForegroundColorSpan foregroundColorSpan : foregroundColorSpanArr) {
            foregroundColorSpan.setDrawStroke(true);
        }
        layout.draw(canvas);
        for (ForegroundColorSpan foregroundColorSpan2 : foregroundColorSpanArr) {
            foregroundColorSpan2.setDrawStroke(false);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void drawText(Canvas canvas, Layout layout, float f) {
        boolean z;
        int lineCount = layout.getLineCount();
        ArrayList[] arrayListArr = new ArrayList[lineCount];
        ArrayList[] arrayListArr2 = new ArrayList[lineCount];
        int i = 1;
        try {
            CharSequence text = layout.getText();
            int i2 = 0;
            while (i2 < lineCount) {
                CharSequence subSequence = text.subSequence(layout.getLineStart(i2), layout.getLineEnd(i2));
                if (i2 != lineCount - 1) {
                    ArrayList<CharSequence> splitLineToWords = splitLineToWords(subSequence, layout.getParagraphDirection(i2) == -1 ? i : 0);
                    arrayListArr[i2] = splitLineToWords;
                    ArrayList arrayList = new ArrayList();
                    int size = splitLineToWords.size() - i;
                    float[] fArr = new float[splitLineToWords.size()];
                    float f2 = 0.0f;
                    for (int i3 = 0; i3 < splitLineToWords.size(); i3++) {
                        float desiredWidth = Layout.getDesiredWidth(splitLineToWords.get(i3), layout.getPaint());
                        fArr[i3] = desiredWidth;
                        f2 += desiredWidth;
                    }
                    float f3 = f - f2;
                    if (size != 0) {
                        f3 /= size;
                    }
                    if (size == 0 && layout.getParagraphDirection(i2) == -1) {
                        arrayList.add(Float.valueOf(f - f2));
                    } else {
                        arrayList.add(Float.valueOf(0.0f));
                    }
                    for (int i4 = 1; i4 < splitLineToWords.size(); i4++) {
                        r12 = r12 + fArr[i4 - 1] + f3;
                        arrayList.add(Float.valueOf(r12));
                    }
                    arrayListArr2[i2] = arrayList;
                } else {
                    float desiredWidth2 = Layout.getDesiredWidth(subSequence, layout.getPaint());
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(subSequence);
                    arrayListArr[i2] = arrayList2;
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.add(Float.valueOf(layout.getParagraphDirection(i2) == -1 ? f - desiredWidth2 : 0.0f));
                    arrayListArr2[i2] = arrayList3;
                }
                i2++;
                i = 1;
            }
            z = false;
        } catch (Exception e) {
            LLog.e(TAG, "draw justify text error:" + e.toString());
            layout.draw(canvas);
            z = true;
        }
        if (z) {
            return;
        }
        for (int i5 = 0; i5 < lineCount; i5++) {
            float lineBaseline = layout.getLineBaseline(i5);
            ArrayList arrayList4 = arrayListArr[i5];
            ArrayList arrayList5 = arrayListArr2[i5];
            for (int i6 = 0; i6 < arrayList4.size(); i6++) {
                canvas.drawText(((CharSequence) arrayList4.get(i6)).toString(), ((Float) arrayList5.get(i6)).floatValue(), lineBaseline, layout.getPaint());
            }
        }
    }

    public static ArrayList<CharSequence> splitLineToWords(CharSequence charSequence, boolean z) {
        Pattern compile;
        ArrayList<CharSequence> arrayList = new ArrayList<>();
        boolean z2 = false;
        int i = 0;
        int i2 = 0;
        while (i < charSequence.length()) {
            char charAt = charSequence.charAt(i);
            if (charAt >= 19968 && charAt <= 40869) {
                compile = Pattern.compile("[一-龥][\\u3002\\uff1f\\uff01\\uff0c\\u3001\\uff1b\\uff1a\\u2018\\u2019\\u201c\\u201d\\uff08\\uff09\\u3014\\u3015\\u3010\\u3011\\u2026\\u2014\\p{Punct}]*");
            } else if (Character.isLetter(charAt)) {
                compile = Pattern.compile("\\w+\\p{Punct}*");
            } else if (Character.isDigit(charAt)) {
                compile = Pattern.compile("\\d+\\.\\d+");
            } else {
                compile = Character.isSpaceChar(charAt) ? Pattern.compile("\\s*") : null;
            }
            if (compile != null) {
                Matcher matcher = compile.matcher(charSequence.subSequence(i, charSequence.length()));
                if (matcher.find()) {
                    int end = i + matcher.end();
                    arrayList.add(charSequence.subSequence(i2, end));
                    i2 = end;
                } else {
                    i2 = i + 1;
                    arrayList.add(charSequence.subSequence(i, i2));
                }
            } else if (Character.isHighSurrogate(charAt)) {
                i2 = i + 2;
                arrayList.add(charSequence.subSequence(i, i2));
            } else {
                i++;
            }
            i = i2;
        }
        if (i2 != i) {
            arrayList.add(charSequence.subSequence(i2, i));
        }
        int size = z ? 0 : arrayList.size() - 1;
        CharSequence charSequence2 = arrayList.get(size);
        int i3 = 0;
        while (true) {
            if (i3 >= charSequence2.length()) {
                z2 = true;
                break;
            }
            if (!Character.isWhitespace(charSequence2.charAt(i3))) {
                break;
            }
            i3++;
        }
        if (z2) {
            arrayList.remove(size);
        }
        return arrayList;
    }

    public static LynxDetailEvent getTextLayoutEvent(int i, Layout layout, int i2, int i3, int i4, int i5, float f, boolean z) {
        LynxDetailEvent lynxDetailEvent = new LynxDetailEvent(i, EVENT_LAYOUT);
        lynxDetailEvent.addDetail("lineCount", Integer.valueOf(i3));
        if (i3 > layout.getLineCount() || i3 == 0) {
            LLog.e(TAG, "getTextLayoutEvent: get lineCount error");
            lynxDetailEvent.addDetail("lineCount", 0);
            return lynxDetailEvent;
        }
        ArrayList arrayList = new ArrayList();
        for (int i6 = 0; i6 < i3; i6++) {
            HashMap hashMap = new HashMap();
            hashMap.put("start", Integer.valueOf(layout.getLineStart(i6)));
            hashMap.put("end", Integer.valueOf(layout.getLineEnd(i6)));
            hashMap.put("ellipsisCount", Integer.valueOf(layout.getEllipsisCount(i6)));
            arrayList.add(hashMap);
        }
        HashMap hashMap2 = (HashMap) arrayList.get(i3 - 1);
        int intValue = ((Integer) hashMap2.get("ellipsisCount")).intValue();
        int intValue2 = ((Integer) hashMap2.get("end")).intValue();
        if (i4 <= 0) {
            i4 = (i3 < layout.getLineCount() || i2 == 0) ? i5 - intValue2 : intValue;
        }
        hashMap2.put("ellipsisCount", Integer.valueOf(i4));
        hashMap2.put("end", Integer.valueOf(i5));
        lynxDetailEvent.addDetail("lines", arrayList);
        if (z) {
            HashMap hashMap3 = new HashMap();
            hashMap3.put("width", Float.valueOf(PixelUtils.pxToDip(f)));
            hashMap3.put("height", Float.valueOf(PixelUtils.pxToDip(layout.getLineBottom(r2))));
            lynxDetailEvent.addDetail(MonitorConstants.SIZE, hashMap3);
        }
        return lynxDetailEvent;
    }

    public static void dispatchLayoutEvent(final TextShadowNode textShadowNode) {
        if (!textShadowNode.isBindEvent(EVENT_LAYOUT) || textShadowNode.getTextRenderer() == null || textShadowNode.getTextRenderer().getTextLayout() == null) {
            return;
        }
        final LynxDetailEvent textLayoutEvent = getTextLayoutEvent(textShadowNode.getSignature(), textShadowNode.getTextRenderer().getTextLayout(), textShadowNode.getTextAttributes().getTextOverflow(), textShadowNode.getTextRenderer().getLineCount(), textShadowNode.getEllipsisCount(), textShadowNode.getSpannableStringLength(), textShadowNode.getTextRenderer().calculateMaxWidth(), textShadowNode.isLayoutEventContainTextSize());
        UIThreadUtils.runOnUiThread(new Runnable() { // from class: com.lynx.tasm.behavior.shadow.text.TextHelper.1
            @Override // java.lang.Runnable
            public void run() {
                TextShadowNode.this.getContext().getEventEmitter().sendCustomEvent(textLayoutEvent);
            }
        });
    }

    public static TextPaint newTextPaint(float f, String str) {
        TextPaint textPaint = new TextPaint(1);
        textPaint.setTextSize(f);
        Typeface cachedTypeface = !TextUtils.isEmpty(str) ? TypefaceCache.getCachedTypeface(str, 0) : null;
        if (cachedTypeface != null) {
            textPaint.setTypeface(cachedTypeface);
        } else {
            textPaint.setTypeface(DeviceUtils.getDefaultTypeface());
        }
        return textPaint;
    }

    public static double getTextWidth(String str, String str2, String str3) {
        if (UnitUtils.toPx(str2, 0.0f, 0.0f, 0.0f, 0.0f, PixelUtils.dipToPx(14.0f)) <= 0.0f) {
            return 0.0d;
        }
        return PixelUtils.pxToDip(newTextPaint(r7, str3).measureText(str));
    }

    public static String getFirstLineText(String str, String str2, String str3, String str4) {
        float px = UnitUtils.toPx(str2, 0.0f, 0.0f, 0.0f, 0.0f, PixelUtils.dipToPx(14.0f));
        float px2 = TextUtils.isEmpty(str4) ? 0.0f : UnitUtils.toPx(str4, 0.0f, 0.0f, 0.0f, 0.0f, PixelUtils.dipToPx(0.0f));
        if (px <= 0.0f || px2 < 1.0f) {
            return "";
        }
        StaticLayout.Builder obtain = StaticLayout.Builder.obtain(str, 0, str.length(), newTextPaint(px, str3), (int) Math.floor(px2));
        obtain.setMaxLines(1);
        StaticLayout build = obtain.build();
        return build.getLineCount() > 0 ? str.substring(build.getLineStart(0), build.getLineEnd(0)) : "";
    }

    private static float calculateMaxWidth(Layout layout) {
        float f = -1.0f;
        for (int i = 0; i < layout.getLineCount(); i++) {
            f = Math.max(f, layout.getLineMax(i));
        }
        return f;
    }

    public static JavaOnlyMap getTextInfo(String str, String str2, String str3, String str4, int i) {
        float px = UnitUtils.toPx(str2, 0.0f, 0.0f, 0.0f, 0.0f, PixelUtils.dipToPx(14.0f));
        float px2 = TextUtils.isEmpty(str4) ? 0.0f : UnitUtils.toPx(str4, 0.0f, 0.0f, 0.0f, 0.0f, PixelUtils.dipToPx(0.0f));
        JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
        if (str.isEmpty() || px <= 0.0f || (i > 1 && px2 < 1.0f)) {
            javaOnlyMap.putDouble("width", 0.0f);
            return javaOnlyMap;
        }
        if (i == 1 && px2 < 1.0f) {
            px2 = 32767.0f;
        }
        TextPaint newTextPaint = newTextPaint(px, str3);
        JavaOnlyArray javaOnlyArray = new JavaOnlyArray();
        StaticLayout.Builder obtain = StaticLayout.Builder.obtain(str, 0, str.length(), newTextPaint, (int) Math.floor(px2));
        obtain.setMaxLines(i);
        StaticLayout build = obtain.build();
        float pxToDip = PixelUtils.pxToDip(calculateMaxWidth(build));
        int lineCount = build.getLineCount();
        for (int i2 = 0; i2 < lineCount; i2++) {
            javaOnlyArray.add(str.substring(build.getLineStart(i2), build.getLineEnd(i2)));
        }
        javaOnlyMap.putDouble("width", pxToDip);
        javaOnlyMap.putArray("content", javaOnlyArray);
        return javaOnlyMap;
    }

    public static int calcTextTranslateTopOffsetAndAdjustFontMetric(int i, Paint.FontMetricsInt fontMetricsInt, boolean z) {
        int i2 = fontMetricsInt.top;
        int i3 = fontMetricsInt.ascent;
        int i4 = fontMetricsInt.descent - fontMetricsInt.ascent;
        int i5 = (i - i4) / 2;
        int i6 = (i - i5) - i4;
        int i7 = fontMetricsInt.bottom - fontMetricsInt.top;
        int i8 = (i - i7) / 2;
        fontMetricsInt.ascent -= i5;
        fontMetricsInt.descent += i6;
        fontMetricsInt.top -= i8;
        fontMetricsInt.bottom += (i - i8) - i7;
        if (fontMetricsInt.descent < 0) {
            fontMetricsInt.ascent -= fontMetricsInt.descent;
            fontMetricsInt.descent = 0;
        }
        if (fontMetricsInt.ascent > 0) {
            fontMetricsInt.descent -= fontMetricsInt.ascent;
            fontMetricsInt.ascent = 0;
        }
        if (fontMetricsInt.bottom < 0) {
            fontMetricsInt.top -= fontMetricsInt.bottom;
            fontMetricsInt.bottom = 0;
        }
        if (fontMetricsInt.top > 0) {
            fontMetricsInt.bottom -= fontMetricsInt.top;
            fontMetricsInt.top = 0;
        }
        if (z) {
            return i2 - fontMetricsInt.top;
        }
        return i3 - fontMetricsInt.ascent;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.lynx.tasm.behavior.shadow.text.TextHelper$2 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static /* synthetic */ class C00592 {
        static final /* synthetic */ int[] $SwitchMap$com$lynx$react$bridge$ReadableType;

        static {
            int[] iArr = new int[ReadableType.values().length];
            $SwitchMap$com$lynx$react$bridge$ReadableType = iArr;
            try {
                iArr[ReadableType.String.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$lynx$react$bridge$ReadableType[ReadableType.Int.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$lynx$react$bridge$ReadableType[ReadableType.Long.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$lynx$react$bridge$ReadableType[ReadableType.Number.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$lynx$react$bridge$ReadableType[ReadableType.Boolean.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$lynx$react$bridge$ReadableType[ReadableType.Null.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public static String convertRawTextValue(Dynamic dynamic) {
        if (dynamic == null) {
            return null;
        }
        switch (C00592.$SwitchMap$com$lynx$react$bridge$ReadableType[dynamic.getType().ordinal()]) {
            case 1:
                return dynamic.asString();
            case 2:
                return String.valueOf(dynamic.asInt());
            case 3:
                return String.valueOf(dynamic.asLong());
            case 4:
                return formatDoubleToStringManually(dynamic.asDouble());
            case 5:
                return String.valueOf(dynamic.asBoolean());
            case 6:
            default:
                return null;
        }
    }

    public static String formatDoubleToString(double d) {
        return decimalFormat.format(d);
    }

    public static String formatDoubleToStringManually(double d) {
        if (d < 9.223372036854776E18d && d > -9.223372036854776E18d) {
            long floor = (long) Math.floor(d);
            if (d == floor) {
                return String.valueOf(floor);
            }
        }
        return formatDoubleToString(d);
    }

    public static void updateTextPaintColor(TextPaint textPaint, boolean z, int i, int i2, float f) {
        if (z) {
            textPaint.setStyle(Paint.Style.STROKE);
            textPaint.setStrokeWidth(f);
            textPaint.setColor(i2);
            textPaint.bgColor = 0;
            return;
        }
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setColor(i);
    }

    public static void updateTextPaintTypeFace(TextPaint textPaint, String str, int i, int i2, String str2, String str3, boolean z) {
        Typeface create;
        Typeface typeface = textPaint.getTypeface();
        if (Build.VERSION.SDK_INT >= 28) {
            create = Typeface.create(typeface, getStyleWeight(i2), i == 2);
        } else {
            int style = (typeface == null ? 0 : typeface.getStyle()) | i;
            if (typeface == null) {
                create = Typeface.defaultFromStyle(style);
            } else {
                create = Typeface.create(typeface, style);
            }
        }
        textPaint.setTypeface(create);
        if (i > 0 && TextUtils.isEmpty(str)) {
            int i3 = i & (~(create != null ? create.getStyle() : 0));
            textPaint.setFakeBoldText((i3 & 1) != 0 && i2 == 1);
            if ((i3 & 2) != 0) {
                textPaint.setTextSkewX(-0.25f);
            }
        }
        if (str2 == null && str3 == null) {
            return;
        }
        FontSettingsKey fontSettingsKey = new FontSettingsKey(str2, textPaint.getTextSize(), str);
        Typeface fontWithSettings = FontFaceManager.getInstance().getFontWithSettings(fontSettingsKey);
        if (fontWithSettings != null) {
            textPaint.setTypeface(fontWithSettings);
        } else {
            if (str2 != null && enableSetFontVariation()) {
                textPaint.setFontVariationSettings(str2);
            }
            if (z) {
                FontFaceManager.getInstance().putFontWithSettings(fontSettingsKey, textPaint.getTypeface());
            }
        }
        if (str3 != null) {
            textPaint.setFontFeatureSettings(str3);
        }
    }

    private static boolean enableSetFontVariation() {
        if (Build.VERSION.SDK_INT < 26) {
            return false;
        }
        return (Build.VERSION.SDK_INT == 35 && !UIThreadUtils.isOnUiThread() && DeviceUtils.isHonor()) ? false : true;
    }
}
