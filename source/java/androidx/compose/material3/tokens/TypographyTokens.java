package androidx.compose.material3.tokens;

import androidx.compose.p002ui.graphics.Shadow;
import androidx.compose.p002ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import kotlin.Metadata;

/* compiled from: TypographyTokens.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001f\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0011\u0010\r\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0011\u0010\u000f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0011\u0010\u0011\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0011\u0010\u0013\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006R\u0011\u0010\u0015\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0006R\u0011\u0010\u0017\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0006R\u0011\u0010\u0019\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0006R\u0011\u0010\u001b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0006R\u0011\u0010\u001d\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0006R\u0011\u0010\u001f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0006R\u0011\u0010!\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0006¨\u0006#"}, d2 = {"Landroidx/compose/material3/tokens/TypographyTokens;", "", "()V", "BodyLarge", "Landroidx/compose/ui/text/TextStyle;", "getBodyLarge", "()Landroidx/compose/ui/text/TextStyle;", "BodyMedium", "getBodyMedium", "BodySmall", "getBodySmall", "DisplayLarge", "getDisplayLarge", "DisplayMedium", "getDisplayMedium", "DisplaySmall", "getDisplaySmall", "HeadlineLarge", "getHeadlineLarge", "HeadlineMedium", "getHeadlineMedium", "HeadlineSmall", "getHeadlineSmall", "LabelLarge", "getLabelLarge", "LabelMedium", "getLabelMedium", "LabelSmall", "getLabelSmall", "TitleLarge", "getTitleLarge", "TitleMedium", "getTitleMedium", "TitleSmall", "getTitleSmall", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class TypographyTokens {
    public static final int $stable = 0;
    private static final TextStyle BodyLarge;
    private static final TextStyle BodyMedium;
    private static final TextStyle BodySmall;
    private static final TextStyle DisplayLarge;
    private static final TextStyle DisplayMedium;
    private static final TextStyle DisplaySmall;
    private static final TextStyle HeadlineLarge;
    private static final TextStyle HeadlineMedium;
    private static final TextStyle HeadlineSmall;
    public static final TypographyTokens INSTANCE = new TypographyTokens();
    private static final TextStyle LabelLarge;
    private static final TextStyle LabelMedium;
    private static final TextStyle LabelSmall;
    private static final TextStyle TitleLarge;
    private static final TextStyle TitleMedium;
    private static final TextStyle TitleSmall;

    private TypographyTokens() {
    }

    public final TextStyle getBodyLarge() {
        return BodyLarge;
    }

    static {
        TextStyle defaultTextStyle = TypographyTokensKt.getDefaultTextStyle();
        FontFamily bodyLargeFont = TypeScaleTokens.INSTANCE.getBodyLargeFont();
        BodyLarge = TextStyle.copy-p1EtxEg$default(defaultTextStyle, 0L, TypeScaleTokens.INSTANCE.m3968getBodyLargeSizeXSAIIZE(), TypeScaleTokens.INSTANCE.getBodyLargeWeight(), (FontStyle) null, (FontSynthesis) null, bodyLargeFont, (String) null, TypeScaleTokens.INSTANCE.m3969getBodyLargeTrackingXSAIIZE(), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TypeScaleTokens.INSTANCE.m3967getBodyLargeLineHeightXSAIIZE(), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16645977, (Object) null);
        TextStyle defaultTextStyle2 = TypographyTokensKt.getDefaultTextStyle();
        FontFamily bodyMediumFont = TypeScaleTokens.INSTANCE.getBodyMediumFont();
        BodyMedium = TextStyle.copy-p1EtxEg$default(defaultTextStyle2, 0L, TypeScaleTokens.INSTANCE.m3971getBodyMediumSizeXSAIIZE(), TypeScaleTokens.INSTANCE.getBodyMediumWeight(), (FontStyle) null, (FontSynthesis) null, bodyMediumFont, (String) null, TypeScaleTokens.INSTANCE.m3972getBodyMediumTrackingXSAIIZE(), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TypeScaleTokens.INSTANCE.m3970getBodyMediumLineHeightXSAIIZE(), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16645977, (Object) null);
        TextStyle defaultTextStyle3 = TypographyTokensKt.getDefaultTextStyle();
        FontFamily bodySmallFont = TypeScaleTokens.INSTANCE.getBodySmallFont();
        BodySmall = TextStyle.copy-p1EtxEg$default(defaultTextStyle3, 0L, TypeScaleTokens.INSTANCE.m3974getBodySmallSizeXSAIIZE(), TypeScaleTokens.INSTANCE.getBodySmallWeight(), (FontStyle) null, (FontSynthesis) null, bodySmallFont, (String) null, TypeScaleTokens.INSTANCE.m3975getBodySmallTrackingXSAIIZE(), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TypeScaleTokens.INSTANCE.m3973getBodySmallLineHeightXSAIIZE(), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16645977, (Object) null);
        TextStyle defaultTextStyle4 = TypographyTokensKt.getDefaultTextStyle();
        FontFamily displayLargeFont = TypeScaleTokens.INSTANCE.getDisplayLargeFont();
        DisplayLarge = TextStyle.copy-p1EtxEg$default(defaultTextStyle4, 0L, TypeScaleTokens.INSTANCE.m3977getDisplayLargeSizeXSAIIZE(), TypeScaleTokens.INSTANCE.getDisplayLargeWeight(), (FontStyle) null, (FontSynthesis) null, displayLargeFont, (String) null, TypeScaleTokens.INSTANCE.m3978getDisplayLargeTrackingXSAIIZE(), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TypeScaleTokens.INSTANCE.m3976getDisplayLargeLineHeightXSAIIZE(), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16645977, (Object) null);
        TextStyle defaultTextStyle5 = TypographyTokensKt.getDefaultTextStyle();
        FontFamily displayMediumFont = TypeScaleTokens.INSTANCE.getDisplayMediumFont();
        DisplayMedium = TextStyle.copy-p1EtxEg$default(defaultTextStyle5, 0L, TypeScaleTokens.INSTANCE.m3980getDisplayMediumSizeXSAIIZE(), TypeScaleTokens.INSTANCE.getDisplayMediumWeight(), (FontStyle) null, (FontSynthesis) null, displayMediumFont, (String) null, TypeScaleTokens.INSTANCE.m3981getDisplayMediumTrackingXSAIIZE(), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TypeScaleTokens.INSTANCE.m3979getDisplayMediumLineHeightXSAIIZE(), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16645977, (Object) null);
        TextStyle defaultTextStyle6 = TypographyTokensKt.getDefaultTextStyle();
        FontFamily displaySmallFont = TypeScaleTokens.INSTANCE.getDisplaySmallFont();
        DisplaySmall = TextStyle.copy-p1EtxEg$default(defaultTextStyle6, 0L, TypeScaleTokens.INSTANCE.m3983getDisplaySmallSizeXSAIIZE(), TypeScaleTokens.INSTANCE.getDisplaySmallWeight(), (FontStyle) null, (FontSynthesis) null, displaySmallFont, (String) null, TypeScaleTokens.INSTANCE.m3984getDisplaySmallTrackingXSAIIZE(), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TypeScaleTokens.INSTANCE.m3982getDisplaySmallLineHeightXSAIIZE(), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16645977, (Object) null);
        TextStyle defaultTextStyle7 = TypographyTokensKt.getDefaultTextStyle();
        FontFamily headlineLargeFont = TypeScaleTokens.INSTANCE.getHeadlineLargeFont();
        HeadlineLarge = TextStyle.copy-p1EtxEg$default(defaultTextStyle7, 0L, TypeScaleTokens.INSTANCE.m3986getHeadlineLargeSizeXSAIIZE(), TypeScaleTokens.INSTANCE.getHeadlineLargeWeight(), (FontStyle) null, (FontSynthesis) null, headlineLargeFont, (String) null, TypeScaleTokens.INSTANCE.m3987getHeadlineLargeTrackingXSAIIZE(), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TypeScaleTokens.INSTANCE.m3985getHeadlineLargeLineHeightXSAIIZE(), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16645977, (Object) null);
        TextStyle defaultTextStyle8 = TypographyTokensKt.getDefaultTextStyle();
        FontFamily headlineMediumFont = TypeScaleTokens.INSTANCE.getHeadlineMediumFont();
        HeadlineMedium = TextStyle.copy-p1EtxEg$default(defaultTextStyle8, 0L, TypeScaleTokens.INSTANCE.m3989getHeadlineMediumSizeXSAIIZE(), TypeScaleTokens.INSTANCE.getHeadlineMediumWeight(), (FontStyle) null, (FontSynthesis) null, headlineMediumFont, (String) null, TypeScaleTokens.INSTANCE.m3990getHeadlineMediumTrackingXSAIIZE(), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TypeScaleTokens.INSTANCE.m3988getHeadlineMediumLineHeightXSAIIZE(), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16645977, (Object) null);
        TextStyle defaultTextStyle9 = TypographyTokensKt.getDefaultTextStyle();
        FontFamily headlineSmallFont = TypeScaleTokens.INSTANCE.getHeadlineSmallFont();
        HeadlineSmall = TextStyle.copy-p1EtxEg$default(defaultTextStyle9, 0L, TypeScaleTokens.INSTANCE.m3992getHeadlineSmallSizeXSAIIZE(), TypeScaleTokens.INSTANCE.getHeadlineSmallWeight(), (FontStyle) null, (FontSynthesis) null, headlineSmallFont, (String) null, TypeScaleTokens.INSTANCE.m3993getHeadlineSmallTrackingXSAIIZE(), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TypeScaleTokens.INSTANCE.m3991getHeadlineSmallLineHeightXSAIIZE(), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16645977, (Object) null);
        TextStyle defaultTextStyle10 = TypographyTokensKt.getDefaultTextStyle();
        FontFamily labelLargeFont = TypeScaleTokens.INSTANCE.getLabelLargeFont();
        LabelLarge = TextStyle.copy-p1EtxEg$default(defaultTextStyle10, 0L, TypeScaleTokens.INSTANCE.m3995getLabelLargeSizeXSAIIZE(), TypeScaleTokens.INSTANCE.getLabelLargeWeight(), (FontStyle) null, (FontSynthesis) null, labelLargeFont, (String) null, TypeScaleTokens.INSTANCE.m3996getLabelLargeTrackingXSAIIZE(), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TypeScaleTokens.INSTANCE.m3994getLabelLargeLineHeightXSAIIZE(), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16645977, (Object) null);
        TextStyle defaultTextStyle11 = TypographyTokensKt.getDefaultTextStyle();
        FontFamily labelMediumFont = TypeScaleTokens.INSTANCE.getLabelMediumFont();
        LabelMedium = TextStyle.copy-p1EtxEg$default(defaultTextStyle11, 0L, TypeScaleTokens.INSTANCE.m3998getLabelMediumSizeXSAIIZE(), TypeScaleTokens.INSTANCE.getLabelMediumWeight(), (FontStyle) null, (FontSynthesis) null, labelMediumFont, (String) null, TypeScaleTokens.INSTANCE.m3999getLabelMediumTrackingXSAIIZE(), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TypeScaleTokens.INSTANCE.m3997getLabelMediumLineHeightXSAIIZE(), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16645977, (Object) null);
        TextStyle defaultTextStyle12 = TypographyTokensKt.getDefaultTextStyle();
        FontFamily labelSmallFont = TypeScaleTokens.INSTANCE.getLabelSmallFont();
        LabelSmall = TextStyle.copy-p1EtxEg$default(defaultTextStyle12, 0L, TypeScaleTokens.INSTANCE.m4001getLabelSmallSizeXSAIIZE(), TypeScaleTokens.INSTANCE.getLabelSmallWeight(), (FontStyle) null, (FontSynthesis) null, labelSmallFont, (String) null, TypeScaleTokens.INSTANCE.m4002getLabelSmallTrackingXSAIIZE(), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TypeScaleTokens.INSTANCE.m4000getLabelSmallLineHeightXSAIIZE(), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16645977, (Object) null);
        TextStyle defaultTextStyle13 = TypographyTokensKt.getDefaultTextStyle();
        FontFamily titleLargeFont = TypeScaleTokens.INSTANCE.getTitleLargeFont();
        TitleLarge = TextStyle.copy-p1EtxEg$default(defaultTextStyle13, 0L, TypeScaleTokens.INSTANCE.m4004getTitleLargeSizeXSAIIZE(), TypeScaleTokens.INSTANCE.getTitleLargeWeight(), (FontStyle) null, (FontSynthesis) null, titleLargeFont, (String) null, TypeScaleTokens.INSTANCE.m4005getTitleLargeTrackingXSAIIZE(), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TypeScaleTokens.INSTANCE.m4003getTitleLargeLineHeightXSAIIZE(), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16645977, (Object) null);
        TextStyle defaultTextStyle14 = TypographyTokensKt.getDefaultTextStyle();
        FontFamily titleMediumFont = TypeScaleTokens.INSTANCE.getTitleMediumFont();
        TitleMedium = TextStyle.copy-p1EtxEg$default(defaultTextStyle14, 0L, TypeScaleTokens.INSTANCE.m4007getTitleMediumSizeXSAIIZE(), TypeScaleTokens.INSTANCE.getTitleMediumWeight(), (FontStyle) null, (FontSynthesis) null, titleMediumFont, (String) null, TypeScaleTokens.INSTANCE.m4008getTitleMediumTrackingXSAIIZE(), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TypeScaleTokens.INSTANCE.m4006getTitleMediumLineHeightXSAIIZE(), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16645977, (Object) null);
        TextStyle defaultTextStyle15 = TypographyTokensKt.getDefaultTextStyle();
        FontFamily titleSmallFont = TypeScaleTokens.INSTANCE.getTitleSmallFont();
        TitleSmall = TextStyle.copy-p1EtxEg$default(defaultTextStyle15, 0L, TypeScaleTokens.INSTANCE.m4010getTitleSmallSizeXSAIIZE(), TypeScaleTokens.INSTANCE.getTitleSmallWeight(), (FontStyle) null, (FontSynthesis) null, titleSmallFont, (String) null, TypeScaleTokens.INSTANCE.m4011getTitleSmallTrackingXSAIIZE(), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TypeScaleTokens.INSTANCE.m4009getTitleSmallLineHeightXSAIIZE(), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16645977, (Object) null);
    }

    public final TextStyle getBodyMedium() {
        return BodyMedium;
    }

    public final TextStyle getBodySmall() {
        return BodySmall;
    }

    public final TextStyle getDisplayLarge() {
        return DisplayLarge;
    }

    public final TextStyle getDisplayMedium() {
        return DisplayMedium;
    }

    public final TextStyle getDisplaySmall() {
        return DisplaySmall;
    }

    public final TextStyle getHeadlineLarge() {
        return HeadlineLarge;
    }

    public final TextStyle getHeadlineMedium() {
        return HeadlineMedium;
    }

    public final TextStyle getHeadlineSmall() {
        return HeadlineSmall;
    }

    public final TextStyle getLabelLarge() {
        return LabelLarge;
    }

    public final TextStyle getLabelMedium() {
        return LabelMedium;
    }

    public final TextStyle getLabelSmall() {
        return LabelSmall;
    }

    public final TextStyle getTitleLarge() {
        return TitleLarge;
    }

    public final TextStyle getTitleMedium() {
        return TitleMedium;
    }

    public final TextStyle getTitleSmall() {
        return TitleSmall;
    }
}
