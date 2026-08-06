package androidx.compose.p001ui.text;

import androidx.compose.p001ui.text.font.FontFamily;
import androidx.compose.p001ui.text.font.FontStyle;
import androidx.compose.p001ui.text.font.FontSynthesis;
import androidx.compose.p001ui.text.font.FontWeight;
import androidx.compose.p001ui.text.font.FontWeightKt;
import androidx.compose.p001ui.text.font.SystemFontFamily;
import androidx.compose.p001ui.text.intl.LocaleList;
import androidx.compose.p001ui.text.style.BaselineShift;
import androidx.compose.p001ui.text.style.BaselineShiftKt;
import androidx.compose.p001ui.text.style.TextDecoration;
import androidx.compose.p001ui.text.style.TextDrawStyleKt;
import androidx.compose.p001ui.text.style.TextForegroundStyle;
import androidx.compose.p001ui.text.style.TextGeometricTransform;
import androidx.compose.p001ui.text.style.TextGeometricTransformKt;
import androidx.compose.p001ui.unit.TextUnit;
import androidx.compose.p001ui.unit.TextUnitKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.ShadowKt;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SpanStyle.kt */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a'\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\rH\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a+\u0010\u0010\u001a\u0002H\u0011\"\u0004\b\u0000\u0010\u00112\u0006\u0010\n\u001a\u0002H\u00112\u0006\u0010\u000b\u001a\u0002H\u00112\u0006\u0010\u0012\u001a\u00020\rH\u0000¢\u0006\u0002\u0010\u0013\u001a\u001e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\r\u001a&\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u0016\u001a\u0004\u0018\u00010\u00192\b\u0010\u0017\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0012\u001a\u00020\rH\u0002\u001a\u0010\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u0015H\u0000\u001a½\u0001\u0010\u001c\u001a\u00020\u0015*\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\u00012\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020\u00012\b\u0010-\u001a\u0004\u0018\u00010.2\b\u0010/\u001a\u0004\u0018\u0001002\b\u00101\u001a\u0004\u0018\u0001022\u0006\u00103\u001a\u00020\u00052\b\u00104\u001a\u0004\u0018\u0001052\b\u00106\u001a\u0004\u0018\u0001072\b\u00108\u001a\u0004\u0018\u00010\u00192\b\u00109\u001a\u0004\u0018\u00010:H\u0000¢\u0006\u0004\b;\u0010<\u001a\u0018\u0010=\u001a\u0004\u0018\u00010\u0019*\u00020\u00152\b\u0010>\u001a\u0004\u0018\u00010\u0019H\u0002\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"DefaultFontSize", "Landroidx/compose/ui/unit/TextUnit;", "J", "DefaultLetterSpacing", "DefaultBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "DefaultColor", "DefaultColorForegroundStyle", "Landroidx/compose/ui/text/style/TextForegroundStyle;", "lerpTextUnitInheritable", "a", "b", "t", "", "lerpTextUnitInheritable-C3pnCVY", "(JJF)J", "lerpDiscrete", ExifInterface.GPS_DIRECTION_TRUE, "fraction", "(Ljava/lang/Object;Ljava/lang/Object;F)Ljava/lang/Object;", "lerp", "Landroidx/compose/ui/text/SpanStyle;", "start", "stop", "lerpPlatformStyle", "Landroidx/compose/ui/text/PlatformSpanStyle;", "resolveSpanStyleDefaults", "style", "fastMerge", "color", "brush", "Landroidx/compose/ui/graphics/Brush;", "alpha", "fontSize", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "fontSynthesis", "Landroidx/compose/ui/text/font/FontSynthesis;", "fontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "fontFeatureSettings", "", "letterSpacing", "baselineShift", "Landroidx/compose/ui/text/style/BaselineShift;", "textGeometricTransform", "Landroidx/compose/ui/text/style/TextGeometricTransform;", "localeList", "Landroidx/compose/ui/text/intl/LocaleList;", "background", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "shadow", "Landroidx/compose/ui/graphics/Shadow;", "platformStyle", "drawStyle", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "fastMerge-dSHsh3o", "(Landroidx/compose/ui/text/SpanStyle;JLandroidx/compose/ui/graphics/Brush;FJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/PlatformSpanStyle;Landroidx/compose/ui/graphics/drawscope/DrawStyle;)Landroidx/compose/ui/text/SpanStyle;", "mergePlatformStyle", "other", "ui-text"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class SpanStyleKt {
    private static final long DefaultColor;
    private static final TextForegroundStyle DefaultColorForegroundStyle;
    private static final long DefaultFontSize = TextUnitKt.getSp(14);
    private static final long DefaultLetterSpacing = TextUnitKt.getSp(0);
    private static final long DefaultBackgroundColor = Color.Companion.getTransparent-0d7_KjU();

    public static final <T> T lerpDiscrete(T t, T t2, float f) {
        return ((double) f) < 0.5d ? t : t2;
    }

    static {
        long j = Color.Companion.getBlack-0d7_KjU();
        DefaultColor = j;
        DefaultColorForegroundStyle = TextForegroundStyle.INSTANCE.m2572from8_81llA(j);
    }

    public static final SpanStyle lerp(SpanStyle spanStyle, SpanStyle spanStyle2, float f) {
        TextForegroundStyle lerp = TextDrawStyleKt.lerp(spanStyle.getTextForegroundStyle(), spanStyle2.getTextForegroundStyle(), f);
        FontFamily fontFamily = (FontFamily) lerpDiscrete(spanStyle.getFontFamily(), spanStyle2.getFontFamily(), f);
        long m2069lerpTextUnitInheritableC3pnCVY = m2069lerpTextUnitInheritableC3pnCVY(spanStyle.getFontSize(), spanStyle2.getFontSize(), f);
        FontWeight fontWeight = spanStyle.getFontWeight();
        if (fontWeight == null) {
            fontWeight = FontWeight.INSTANCE.getNormal();
        }
        FontWeight fontWeight2 = spanStyle2.getFontWeight();
        if (fontWeight2 == null) {
            fontWeight2 = FontWeight.INSTANCE.getNormal();
        }
        FontWeight lerp2 = FontWeightKt.lerp(fontWeight, fontWeight2, f);
        FontStyle fontStyle = (FontStyle) lerpDiscrete(spanStyle.getFontStyle(), spanStyle2.getFontStyle(), f);
        FontSynthesis fontSynthesis = (FontSynthesis) lerpDiscrete(spanStyle.getFontSynthesis(), spanStyle2.getFontSynthesis(), f);
        String str = (String) lerpDiscrete(spanStyle.getFontFeatureSettings(), spanStyle2.getFontFeatureSettings(), f);
        long m2069lerpTextUnitInheritableC3pnCVY2 = m2069lerpTextUnitInheritableC3pnCVY(spanStyle.getLetterSpacing(), spanStyle2.getLetterSpacing(), f);
        BaselineShift baselineShift = spanStyle.getBaselineShift();
        float m2427unboximpl = baselineShift != null ? baselineShift.m2427unboximpl() : BaselineShift.m2422constructorimpl(0.0f);
        BaselineShift baselineShift2 = spanStyle2.getBaselineShift();
        float m2434lerpjWV1Mfo = BaselineShiftKt.m2434lerpjWV1Mfo(m2427unboximpl, baselineShift2 != null ? baselineShift2.m2427unboximpl() : BaselineShift.m2422constructorimpl(0.0f), f);
        TextGeometricTransform textGeometricTransform = spanStyle.getTextGeometricTransform();
        if (textGeometricTransform == null) {
            textGeometricTransform = TextGeometricTransform.INSTANCE.getNone$ui_text();
        }
        TextGeometricTransform textGeometricTransform2 = spanStyle2.getTextGeometricTransform();
        if (textGeometricTransform2 == null) {
            textGeometricTransform2 = TextGeometricTransform.INSTANCE.getNone$ui_text();
        }
        TextGeometricTransform lerp3 = TextGeometricTransformKt.lerp(textGeometricTransform, textGeometricTransform2, f);
        LocaleList localeList = (LocaleList) lerpDiscrete(spanStyle.getLocaleList(), spanStyle2.getLocaleList(), f);
        long j = ColorKt.lerp-jxsXWHM(spanStyle.getBackground(), spanStyle2.getBackground(), f);
        TextDecoration textDecoration = (TextDecoration) lerpDiscrete(spanStyle.getTextDecoration(), spanStyle2.getTextDecoration(), f);
        Shadow shadow = spanStyle.getShadow();
        if (shadow == null) {
            shadow = new Shadow(0L, 0L, 0.0f, 7, (DefaultConstructorMarker) null);
        }
        Shadow shadow2 = spanStyle2.getShadow();
        if (shadow2 == null) {
            shadow2 = new Shadow(0L, 0L, 0.0f, 7, (DefaultConstructorMarker) null);
        }
        return new SpanStyle(lerp, m2069lerpTextUnitInheritableC3pnCVY, lerp2, fontStyle, fontSynthesis, fontFamily, str, m2069lerpTextUnitInheritableC3pnCVY2, BaselineShift.m2421boximpl(m2434lerpjWV1Mfo), lerp3, localeList, j, textDecoration, ShadowKt.lerp(shadow, shadow2, f), lerpPlatformStyle(spanStyle.getPlatformStyle(), spanStyle2.getPlatformStyle(), f), (DrawStyle) lerpDiscrete(spanStyle.getDrawStyle(), spanStyle2.getDrawStyle(), f), (DefaultConstructorMarker) null);
    }

    private static final PlatformSpanStyle lerpPlatformStyle(PlatformSpanStyle platformSpanStyle, PlatformSpanStyle platformSpanStyle2, float f) {
        if (platformSpanStyle == null && platformSpanStyle2 == null) {
            return null;
        }
        if (platformSpanStyle == null) {
            platformSpanStyle = PlatformSpanStyle.INSTANCE.getDefault();
        }
        if (platformSpanStyle2 == null) {
            platformSpanStyle2 = PlatformSpanStyle.INSTANCE.getDefault();
        }
        return AndroidTextStyle_androidKt.lerp(platformSpanStyle, platformSpanStyle2, f);
    }

    public static final SpanStyle resolveSpanStyleDefaults(SpanStyle spanStyle) {
        long letterSpacing;
        TextForegroundStyle takeOrElse = spanStyle.getTextForegroundStyle().takeOrElse(new Function0() { // from class: androidx.compose.ui.text.SpanStyleKt$$ExternalSyntheticLambda0
            public final Object invoke() {
                TextForegroundStyle textForegroundStyle;
                textForegroundStyle = SpanStyleKt.DefaultColorForegroundStyle;
                return textForegroundStyle;
            }
        });
        long fontSize = (TextUnit.m2872getRawTypeimpl(spanStyle.getFontSize()) > 0L ? 1 : (TextUnit.m2872getRawTypeimpl(spanStyle.getFontSize()) == 0L ? 0 : -1)) == 0 ? DefaultFontSize : spanStyle.getFontSize();
        FontWeight fontWeight = spanStyle.getFontWeight();
        if (fontWeight == null) {
            fontWeight = FontWeight.INSTANCE.getNormal();
        }
        FontStyle fontStyle = spanStyle.getFontStyle();
        FontStyle m2234boximpl = FontStyle.m2234boximpl(fontStyle != null ? fontStyle.m2240unboximpl() : FontStyle.INSTANCE.m2244getNormal_LCdwA());
        FontSynthesis fontSynthesis = spanStyle.getFontSynthesis();
        FontSynthesis m2245boximpl = FontSynthesis.m2245boximpl(fontSynthesis != null ? fontSynthesis.getValue() : FontSynthesis.INSTANCE.m2254getAllGVVA2EU());
        SystemFontFamily fontFamily = spanStyle.getFontFamily();
        if (fontFamily == null) {
            fontFamily = FontFamily.INSTANCE.getDefault();
        }
        String fontFeatureSettings = spanStyle.getFontFeatureSettings();
        if (fontFeatureSettings == null) {
            fontFeatureSettings = "";
        }
        if (TextUnit.m2872getRawTypeimpl(spanStyle.getLetterSpacing()) == 0) {
            letterSpacing = DefaultLetterSpacing;
        } else {
            letterSpacing = spanStyle.getLetterSpacing();
        }
        long j = letterSpacing;
        BaselineShift baselineShift = spanStyle.getBaselineShift();
        BaselineShift m2421boximpl = BaselineShift.m2421boximpl(baselineShift != null ? baselineShift.m2427unboximpl() : BaselineShift.INSTANCE.m2431getNoney9eOQZs());
        TextGeometricTransform textGeometricTransform = spanStyle.getTextGeometricTransform();
        if (textGeometricTransform == null) {
            textGeometricTransform = TextGeometricTransform.INSTANCE.getNone$ui_text();
        }
        TextGeometricTransform textGeometricTransform2 = textGeometricTransform;
        LocaleList localeList = spanStyle.getLocaleList();
        if (localeList == null) {
            localeList = LocaleList.INSTANCE.getCurrent();
        }
        LocaleList localeList2 = localeList;
        long background = spanStyle.getBackground();
        long j2 = background != 16 ? background : DefaultBackgroundColor;
        TextDecoration textDecoration = spanStyle.getTextDecoration();
        if (textDecoration == null) {
            textDecoration = TextDecoration.INSTANCE.getNone();
        }
        Shadow shadow = spanStyle.getShadow();
        if (shadow == null) {
            shadow = Shadow.Companion.getNone();
        }
        Shadow shadow2 = shadow;
        PlatformSpanStyle platformStyle = spanStyle.getPlatformStyle();
        DrawStyle drawStyle = spanStyle.getDrawStyle();
        if (drawStyle == null) {
            drawStyle = (DrawStyle) Fill.INSTANCE;
        }
        return new SpanStyle(takeOrElse, fontSize, fontWeight, m2234boximpl, m2245boximpl, fontFamily, fontFeatureSettings, j, m2421boximpl, textGeometricTransform2, localeList2, j2, textDecoration, shadow2, platformStyle, drawStyle, (DefaultConstructorMarker) null);
    }

    private static final PlatformSpanStyle mergePlatformStyle(SpanStyle spanStyle, PlatformSpanStyle platformSpanStyle) {
        if (spanStyle.getPlatformStyle() == null) {
            return platformSpanStyle;
        }
        if (platformSpanStyle == null) {
            return spanStyle.getPlatformStyle();
        }
        return spanStyle.getPlatformStyle().merge(platformSpanStyle);
    }

    /* renamed from: lerpTextUnitInheritable-C3pnCVY, reason: not valid java name */
    public static final long m2069lerpTextUnitInheritableC3pnCVY(long j, long j2, float f) {
        if (!(TextUnit.m2872getRawTypeimpl(j) == 0)) {
            if (!(TextUnit.m2872getRawTypeimpl(j2) == 0)) {
                return TextUnitKt.m2894lerpC3pnCVY(j, j2, f);
            }
        }
        return ((TextUnit) lerpDiscrete(TextUnit.m2864boximpl(j), TextUnit.m2864boximpl(j2), f)).getPackedValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:103:0x00d8, code lost:
    
        if ((r29 == r25.getTextForegroundStyle().getAlpha()) != false) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0069, code lost:
    
        if (androidx.compose.ui.graphics.Color.equals-impl0(r26, r25.getTextForegroundStyle().mo2435getColor0d7_KjU()) == false) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0041, code lost:
    
        if (androidx.compose.p001ui.unit.TextUnit.m2871equalsimpl0(r30, r25.getFontSize()) == false) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x00a6, code lost:
    
        if (androidx.compose.p001ui.unit.TextUnit.m2871equalsimpl0(r37, r25.getLetterSpacing()) == false) goto L11;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0164  */
    /* renamed from: fastMerge-dSHsh3o, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final SpanStyle m2068fastMergedSHsh3o(SpanStyle spanStyle, long j, Brush brush, float f, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j4, TextDecoration textDecoration, Shadow shadow, PlatformSpanStyle platformSpanStyle, DrawStyle drawStyle) {
        TextGeometricTransform textGeometricTransform2;
        long j5;
        PlatformSpanStyle platformSpanStyle2;
        DrawStyle drawStyle2;
        boolean z;
        TextForegroundStyle m2572from8_81llA;
        FontWeight fontWeight2 = fontWeight;
        FontStyle fontStyle2 = fontStyle;
        FontSynthesis fontSynthesis2 = fontSynthesis;
        String str2 = str;
        BaselineShift baselineShift2 = baselineShift;
        if (!(!(TextUnit.m2872getRawTypeimpl(j2) == 0))) {
        }
        if (brush == null) {
            if (j != 16) {
            }
        }
        if ((fontStyle2 == null || Intrinsics.areEqual(fontStyle2, spanStyle.getFontStyle())) && ((fontWeight2 == null || Intrinsics.areEqual(fontWeight2, spanStyle.getFontWeight())) && (fontFamily == null || fontFamily == spanStyle.getFontFamily()))) {
            if (!(!(TextUnit.m2872getRawTypeimpl(j3) == 0))) {
            }
            if ((textDecoration == null || Intrinsics.areEqual(textDecoration, spanStyle.getTextDecoration())) && Intrinsics.areEqual(brush, spanStyle.getTextForegroundStyle().getBrush())) {
                if (brush != null) {
                }
                if ((fontSynthesis2 == null || Intrinsics.areEqual(fontSynthesis2, spanStyle.getFontSynthesis())) && ((str2 == null || Intrinsics.areEqual(str2, spanStyle.getFontFeatureSettings())) && (baselineShift2 == null || Intrinsics.areEqual(baselineShift2, spanStyle.getBaselineShift())))) {
                    textGeometricTransform2 = textGeometricTransform;
                    if ((textGeometricTransform2 == null || Intrinsics.areEqual(textGeometricTransform2, spanStyle.getTextGeometricTransform())) && (localeList == null || Intrinsics.areEqual(localeList, spanStyle.getLocaleList()))) {
                        j5 = j4;
                        if ((!(j5 != 16) || Color.equals-impl0(j5, spanStyle.getBackground())) && (shadow == null || Intrinsics.areEqual(shadow, spanStyle.getShadow()))) {
                            platformSpanStyle2 = platformSpanStyle;
                            if (platformSpanStyle2 == null || Intrinsics.areEqual(platformSpanStyle2, spanStyle.getPlatformStyle())) {
                                drawStyle2 = drawStyle;
                                if (drawStyle2 == null || Intrinsics.areEqual(drawStyle2, spanStyle.getDrawStyle())) {
                                    z = false;
                                    if (z) {
                                        return spanStyle;
                                    }
                                    if (brush != null) {
                                        m2572from8_81llA = TextForegroundStyle.INSTANCE.from(brush, f);
                                    } else {
                                        m2572from8_81llA = TextForegroundStyle.INSTANCE.m2572from8_81llA(j);
                                    }
                                    TextForegroundStyle merge = spanStyle.getTextForegroundStyle().merge(m2572from8_81llA);
                                    FontFamily fontFamily2 = fontFamily == null ? spanStyle.getFontFamily() : fontFamily;
                                    long fontSize = !((TextUnit.m2872getRawTypeimpl(j2) > 0L ? 1 : (TextUnit.m2872getRawTypeimpl(j2) == 0L ? 0 : -1)) == 0) ? j2 : spanStyle.getFontSize();
                                    if (fontWeight2 == null) {
                                        fontWeight2 = spanStyle.getFontWeight();
                                    }
                                    if (fontStyle2 == null) {
                                        fontStyle2 = spanStyle.getFontStyle();
                                    }
                                    if (fontSynthesis2 == null) {
                                        fontSynthesis2 = spanStyle.getFontSynthesis();
                                    }
                                    if (str2 == null) {
                                        str2 = spanStyle.getFontFeatureSettings();
                                    }
                                    long letterSpacing = !((TextUnit.m2872getRawTypeimpl(j3) > 0L ? 1 : (TextUnit.m2872getRawTypeimpl(j3) == 0L ? 0 : -1)) == 0) ? j3 : spanStyle.getLetterSpacing();
                                    if (baselineShift2 == null) {
                                        baselineShift2 = spanStyle.getBaselineShift();
                                    }
                                    if (textGeometricTransform2 == null) {
                                        textGeometricTransform2 = spanStyle.getTextGeometricTransform();
                                    }
                                    LocaleList localeList2 = localeList == null ? spanStyle.getLocaleList() : localeList;
                                    if (!(j5 != 16)) {
                                        j5 = spanStyle.getBackground();
                                    }
                                    TextDecoration textDecoration2 = textDecoration == null ? spanStyle.getTextDecoration() : textDecoration;
                                    Shadow shadow2 = shadow == null ? spanStyle.getShadow() : shadow;
                                    PlatformSpanStyle mergePlatformStyle = mergePlatformStyle(spanStyle, platformSpanStyle2);
                                    if (drawStyle2 == null) {
                                        drawStyle2 = spanStyle.getDrawStyle();
                                    }
                                    return new SpanStyle(merge, fontSize, fontWeight2, fontStyle2, fontSynthesis2, fontFamily2, str2, letterSpacing, baselineShift2, textGeometricTransform2, localeList2, j5, textDecoration2, shadow2, mergePlatformStyle, drawStyle2, (DefaultConstructorMarker) null);
                                }
                                z = true;
                                if (z) {
                                }
                            }
                            drawStyle2 = drawStyle;
                            z = true;
                            if (z) {
                            }
                        }
                        platformSpanStyle2 = platformSpanStyle;
                        drawStyle2 = drawStyle;
                        z = true;
                        if (z) {
                        }
                    }
                    j5 = j4;
                    platformSpanStyle2 = platformSpanStyle;
                    drawStyle2 = drawStyle;
                    z = true;
                    if (z) {
                    }
                }
            }
        }
        textGeometricTransform2 = textGeometricTransform;
        j5 = j4;
        platformSpanStyle2 = platformSpanStyle;
        drawStyle2 = drawStyle;
        z = true;
        if (z) {
        }
    }
}
