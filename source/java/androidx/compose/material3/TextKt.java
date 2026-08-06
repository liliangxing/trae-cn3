package androidx.compose.material3;

import androidx.compose.foundation.text.BasicTextKt;
import androidx.compose.foundation.text.InlineTextContent;
import androidx.compose.material3.tokens.TypographyTokensKt;
import androidx.compose.p002ui.Modifier;
import androidx.compose.p002ui.graphics.Color;
import androidx.compose.p002ui.graphics.ColorProducer;
import androidx.compose.p002ui.graphics.Fields;
import androidx.compose.p002ui.graphics.Shadow;
import androidx.compose.p002ui.graphics.drawscope.DrawStyle;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.TextUnit;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: Text.kt */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u001a(\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00060\t¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010\u000b\u001aæ\u0001\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00142\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020\u00142\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020&2\u0014\b\u0002\u0010(\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020+0)2\u0014\b\u0002\u0010,\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u00060-2\b\b\u0002\u0010/\u001a\u00020\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b0\u00101\u001aÜ\u0001\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00142\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020\u00142\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\u0014\b\u0002\u0010(\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020+0)2\u0014\b\u0002\u0010,\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u00060-2\b\b\u0002\u0010/\u001a\u00020\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b2\u00103\u001aÆ\u0001\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020*2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00142\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020\u00142\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\u0014\b\u0002\u0010,\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u00060-2\b\b\u0002\u0010/\u001a\u00020\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b4\u00105\u001aÒ\u0001\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020*2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00142\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020\u00142\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020&2\u0016\b\u0002\u0010,\u001a\u0010\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u0006\u0018\u00010-2\b\b\u0002\u0010/\u001a\u00020\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b2\u00106\"\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00067"}, d2 = {"LocalTextStyle", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/ui/text/TextStyle;", "getLocalTextStyle", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "ProvideTextStyle", "", "value", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "Text", "text", "Landroidx/compose/ui/text/AnnotatedString;", "modifier", "Landroidx/compose/ui/Modifier;", "color", "Landroidx/compose/ui/graphics/Color;", "fontSize", "Landroidx/compose/ui/unit/TextUnit;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "letterSpacing", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "textAlign", "Landroidx/compose/ui/text/style/TextAlign;", "lineHeight", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "", "minLines", "inlineContent", "", "", "Landroidx/compose/foundation/text/InlineTextContent;", "onTextLayout", "Lkotlin/Function1;", "Landroidx/compose/ui/text/TextLayoutResult;", "style", "Text-IbK3jfQ", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZIILjava/util/Map;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "Text--4IGK_g", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZILjava/util/Map;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "Text-fLXpl1I", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZILkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZIILkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class TextKt {
    private static final ProvidableCompositionLocal<TextStyle> LocalTextStyle = CompositionLocalKt.compositionLocalOf(SnapshotStateKt.structuralEqualityPolicy(), new Function0<TextStyle>() { // from class: androidx.compose.material3.TextKt$LocalTextStyle$1
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final TextStyle m3202invoke() {
            return TypographyTokensKt.getDefaultTextStyle();
        }
    });

    /* JADX WARN: Removed duplicated region for block: B:100:0x03b9  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x036a  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0362  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x028d  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0296  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x02a1  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x02ae  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x02b5  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x02bc  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x02c3  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x02ce  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x02d5  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x02dc  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x02e7  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x02f2  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x02f8  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0300  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0308  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x030e  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0334  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0303  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x02fc  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x02f4  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x02ee  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x02e3  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x02d8  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x02d1  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x02ca  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x02bf  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x02b8  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x02b1  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x02a8  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x029d  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0292  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0256  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0343  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0360  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0365  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x03b4  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0439  */
    /* renamed from: Text--4IGK_g, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m3199Text4IGK_g(final String str, Modifier modifier, long j, long j2, FontStyle fontStyle, FontWeight fontWeight, FontFamily fontFamily, long j3, TextDecoration textDecoration, TextAlign textAlign, long j4, int i, boolean z, int i2, int i3, Function1<? super TextLayoutResult, Unit> function1, TextStyle textStyle, Composer composer, final int i4, final int i5, final int i6) {
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        Modifier.Companion companion;
        long m4875getUnspecified0d7_KjU;
        long j5;
        FontStyle fontStyle2;
        FontWeight fontWeight2;
        FontFamily fontFamily2;
        long j6;
        TextDecoration textDecoration2;
        TextAlign textAlign2;
        long j7;
        int i24;
        boolean z2;
        int i25;
        int i26;
        Function1<? super TextLayoutResult, Unit> function12;
        int i27;
        TextStyle textStyle2;
        long j8;
        long j9;
        final TextAlign textAlign3;
        final long j10;
        final Modifier modifier2;
        final int i28;
        final long j11;
        final long j12;
        final long j13;
        final TextDecoration textDecoration3;
        final int i29;
        final Function1<? super TextLayoutResult, Unit> function13;
        final int i30;
        final boolean z3;
        final FontStyle fontStyle3;
        final FontFamily fontFamily3;
        final TextStyle textStyle3;
        final FontWeight fontWeight3;
        Composer startRestartGroup = composer.startRestartGroup(-2055108902);
        ComposerKt.sourceInformation(startRestartGroup, "C(Text)P(14,9,0:c#ui.graphics.Color,2:c#ui.unit.TextUnit,3:c#ui.text.font.FontStyle,4!1,5:c#ui.unit.TextUnit,16,15:c#ui.text.style.TextAlign,6:c#ui.unit.TextUnit,11:c#ui.text.style.TextOverflow,12)108@5588L7,117@5732L530:Text.kt#uh7d8r");
        if ((i6 & 1) != 0) {
            i7 = i4 | 6;
        } else if ((i4 & 6) == 0) {
            i7 = (startRestartGroup.changed(str) ? 4 : 2) | i4;
        } else {
            i7 = i4;
        }
        int i31 = i6 & 2;
        if (i31 != 0) {
            i7 |= 48;
        } else if ((i4 & 48) == 0) {
            i7 |= startRestartGroup.changed(modifier) ? 32 : 16;
            i8 = i6 & 4;
            if (i8 == 0) {
                i7 |= 384;
            } else if ((i4 & 384) == 0) {
                i7 |= startRestartGroup.changed(j) ? Fields.RotationX : Fields.SpotShadowColor;
            }
            i9 = i6 & 8;
            int i32 = Fields.CameraDistance;
            if (i9 == 0) {
                i7 |= 3072;
            } else if ((i4 & 3072) == 0) {
                i7 |= startRestartGroup.changed(j2) ? 2048 : 1024;
            }
            i10 = i6 & 16;
            int i33 = Fields.Clip;
            if (i10 == 0) {
                i7 |= 24576;
            } else if ((i4 & 24576) == 0) {
                i7 |= startRestartGroup.changed(fontStyle) ? 16384 : 8192;
                i11 = i6 & 32;
                int i34 = Fields.RenderEffect;
                if (i11 != 0) {
                    i7 |= 196608;
                } else if ((i4 & 196608) == 0) {
                    i7 |= startRestartGroup.changed(fontWeight) ? 131072 : 65536;
                }
                i12 = i6 & 64;
                if (i12 != 0) {
                    i7 |= 1572864;
                } else if ((i4 & 1572864) == 0) {
                    i7 |= startRestartGroup.changed(fontFamily) ? 1048576 : Fields.BlendMode;
                }
                i13 = i6 & Fields.SpotShadowColor;
                if (i13 != 0) {
                    i7 |= 12582912;
                } else if ((i4 & 12582912) == 0) {
                    i7 |= startRestartGroup.changed(j3) ? 8388608 : 4194304;
                }
                i14 = i6 & Fields.RotationX;
                if (i14 != 0) {
                    i7 |= 100663296;
                } else if ((100663296 & i4) == 0) {
                    i7 |= startRestartGroup.changed(textDecoration) ? 67108864 : 33554432;
                    i15 = i6 & Fields.RotationY;
                    if (i15 == 0) {
                        i7 |= 805306368;
                    } else if ((i4 & 805306368) == 0) {
                        i7 |= startRestartGroup.changed(textAlign) ? 536870912 : 268435456;
                    }
                    i16 = i6 & Fields.RotationZ;
                    if (i16 == 0) {
                        i17 = i5 | 6;
                    } else if ((i5 & 6) == 0) {
                        i17 = i5 | (startRestartGroup.changed(j4) ? 4 : 2);
                    } else {
                        i17 = i5;
                    }
                    i18 = i6 & Fields.CameraDistance;
                    if (i18 == 0) {
                        i17 |= 48;
                    } else if ((i5 & 48) == 0) {
                        i17 |= startRestartGroup.changed(i) ? 32 : 16;
                    }
                    int i35 = i17;
                    i19 = i6 & Fields.TransformOrigin;
                    if (i19 == 0) {
                        i35 |= 384;
                    } else if ((i5 & 384) == 0) {
                        i35 |= startRestartGroup.changed(z) ? Fields.RotationX : Fields.SpotShadowColor;
                        i20 = i6 & Fields.Shape;
                        if (i20 != 0) {
                            i35 |= 3072;
                        } else if ((i5 & 3072) == 0) {
                            if (!startRestartGroup.changed(i2)) {
                                i32 = 1024;
                            }
                            i35 |= i32;
                            i21 = i6 & Fields.Clip;
                            if (i21 == 0) {
                                i35 |= 24576;
                                i22 = i21;
                            } else {
                                i22 = i21;
                                if ((i5 & 24576) == 0) {
                                    if (!startRestartGroup.changed(i3)) {
                                        i33 = 8192;
                                    }
                                    i35 |= i33;
                                    i23 = i6 & Fields.CompositingStrategy;
                                    if (i23 != 0) {
                                        i35 |= 196608;
                                    } else if ((i5 & 196608) == 0) {
                                        if (!startRestartGroup.changedInstance(function1)) {
                                            i34 = 65536;
                                        }
                                        i35 |= i34;
                                    }
                                    if ((i5 & 1572864) == 0) {
                                        i35 |= ((i6 & 65536) == 0 && startRestartGroup.changed(textStyle)) ? 1048576 : Fields.BlendMode;
                                    }
                                    if ((i7 & 306783379) == 306783378 || (599187 & i35) != 599186 || !startRestartGroup.getSkipping()) {
                                        startRestartGroup.startDefaults();
                                        if ((i4 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                            companion = i31 != 0 ? Modifier.INSTANCE : modifier;
                                            m4875getUnspecified0d7_KjU = i8 != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j;
                                            j5 = i9 != 0 ? TextUnit.Companion.getUnspecified-XSAIIZE() : j2;
                                            fontStyle2 = i10 != 0 ? null : fontStyle;
                                            fontWeight2 = i11 != 0 ? null : fontWeight;
                                            fontFamily2 = i12 != 0 ? null : fontFamily;
                                            j6 = i13 != 0 ? TextUnit.Companion.getUnspecified-XSAIIZE() : j3;
                                            textDecoration2 = i14 != 0 ? null : textDecoration;
                                            textAlign2 = i15 != 0 ? null : textAlign;
                                            j7 = i16 != 0 ? TextUnit.Companion.getUnspecified-XSAIIZE() : j4;
                                            i24 = i18 != 0 ? TextOverflow.Companion.getClip-gIe3tQ8() : i;
                                            z2 = i19 != 0 ? true : z;
                                            i25 = i20 != 0 ? Integer.MAX_VALUE : i2;
                                            i26 = i22 != 0 ? 1 : i3;
                                            function12 = i23 == 0 ? function1 : null;
                                            if ((i6 & 65536) != 0) {
                                                ProvidableCompositionLocal<TextStyle> providableCompositionLocal = LocalTextStyle;
                                                TextDecoration textDecoration4 = textDecoration2;
                                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                                Object consume = startRestartGroup.consume(providableCompositionLocal);
                                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                textAlign2 = textAlign2;
                                                i27 = i35 & (-3670017);
                                                textStyle2 = (TextStyle) consume;
                                                textDecoration2 = textDecoration4;
                                                startRestartGroup.endDefaults();
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-2055108902, i7, i27, "androidx.compose.material3.Text (Text.kt:109)");
                                                }
                                                startRestartGroup.startReplaceableGroup(79582827);
                                                ComposerKt.sourceInformation(startRestartGroup, "");
                                                if (m4875getUnspecified0d7_KjU == Color.INSTANCE.m4875getUnspecified0d7_KjU()) {
                                                    startRestartGroup.startReplaceableGroup(79582860);
                                                    ComposerKt.sourceInformation(startRestartGroup, "*113@5703L7");
                                                    long j14 = textStyle2.getColor-0d7_KjU();
                                                    if (j14 != Color.INSTANCE.m4875getUnspecified0d7_KjU()) {
                                                        j8 = m4875getUnspecified0d7_KjU;
                                                    } else {
                                                        ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
                                                        j8 = m4875getUnspecified0d7_KjU;
                                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                                        Object consume2 = startRestartGroup.consume(localContentColor);
                                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                        j14 = ((Color) consume2).m4849unboximpl();
                                                    }
                                                    startRestartGroup.endReplaceableGroup();
                                                    j9 = j14;
                                                } else {
                                                    j8 = m4875getUnspecified0d7_KjU;
                                                    j9 = j8;
                                                }
                                                startRestartGroup.endReplaceableGroup();
                                                int i36 = i27 << 9;
                                                BasicTextKt.m1518BasicTextVhcvRP8(str, companion, TextStyle.merge-dA7vx0o$default(textStyle2, j9, j5, fontWeight2, fontStyle2, (FontSynthesis) null, fontFamily2, (String) null, j6, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, textDecoration2, (Shadow) null, (DrawStyle) null, textAlign2 == null ? textAlign2.unbox-impl() : TextAlign.Companion.getUnspecified-e0LSkKk(), 0, j7, (TextIndent) null, (LineHeightStyle) null, 0, 0, (PlatformTextStyle) null, (TextMotion) null, 16609104, (Object) null), function12, i24, z2, i25, i26, (ColorProducer) null, startRestartGroup, (i7 & 112) | (i7 & 14) | ((i27 >> 6) & 7168) | (57344 & i36) | (458752 & i36) | (3670016 & i36) | (i36 & 29360128), Fields.RotationX);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                                textAlign3 = textAlign2;
                                                j10 = j7;
                                                modifier2 = companion;
                                                i28 = i25;
                                                j11 = j5;
                                                j12 = j6;
                                                j13 = j8;
                                                textDecoration3 = textDecoration2;
                                                i29 = i26;
                                                function13 = function12;
                                                i30 = i24;
                                                z3 = z2;
                                                fontStyle3 = fontStyle2;
                                                fontFamily3 = fontFamily2;
                                                textStyle3 = textStyle2;
                                                fontWeight3 = fontWeight2;
                                            }
                                        } else {
                                            startRestartGroup.skipToGroupEnd();
                                            if ((i6 & 65536) != 0) {
                                                i35 &= -3670017;
                                            }
                                            companion = modifier;
                                            m4875getUnspecified0d7_KjU = j;
                                            j5 = j2;
                                            fontStyle2 = fontStyle;
                                            fontWeight2 = fontWeight;
                                            fontFamily2 = fontFamily;
                                            j6 = j3;
                                            textDecoration2 = textDecoration;
                                            textAlign2 = textAlign;
                                            j7 = j4;
                                            i24 = i;
                                            z2 = z;
                                            i25 = i2;
                                            i26 = i3;
                                            function12 = function1;
                                        }
                                        i27 = i35;
                                        textStyle2 = textStyle;
                                        startRestartGroup.endDefaults();
                                        if (ComposerKt.isTraceInProgress()) {
                                        }
                                        startRestartGroup.startReplaceableGroup(79582827);
                                        ComposerKt.sourceInformation(startRestartGroup, "");
                                        if (m4875getUnspecified0d7_KjU == Color.INSTANCE.m4875getUnspecified0d7_KjU()) {
                                        }
                                        startRestartGroup.endReplaceableGroup();
                                        int i362 = i27 << 9;
                                        BasicTextKt.m1518BasicTextVhcvRP8(str, companion, TextStyle.merge-dA7vx0o$default(textStyle2, j9, j5, fontWeight2, fontStyle2, (FontSynthesis) null, fontFamily2, (String) null, j6, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, textDecoration2, (Shadow) null, (DrawStyle) null, textAlign2 == null ? textAlign2.unbox-impl() : TextAlign.Companion.getUnspecified-e0LSkKk(), 0, j7, (TextIndent) null, (LineHeightStyle) null, 0, 0, (PlatformTextStyle) null, (TextMotion) null, 16609104, (Object) null), function12, i24, z2, i25, i26, (ColorProducer) null, startRestartGroup, (i7 & 112) | (i7 & 14) | ((i27 >> 6) & 7168) | (57344 & i362) | (458752 & i362) | (3670016 & i362) | (i362 & 29360128), Fields.RotationX);
                                        if (ComposerKt.isTraceInProgress()) {
                                        }
                                        textAlign3 = textAlign2;
                                        j10 = j7;
                                        modifier2 = companion;
                                        i28 = i25;
                                        j11 = j5;
                                        j12 = j6;
                                        j13 = j8;
                                        textDecoration3 = textDecoration2;
                                        i29 = i26;
                                        function13 = function12;
                                        i30 = i24;
                                        z3 = z2;
                                        fontStyle3 = fontStyle2;
                                        fontFamily3 = fontFamily2;
                                        textStyle3 = textStyle2;
                                        fontWeight3 = fontWeight2;
                                    } else {
                                        startRestartGroup.skipToGroupEnd();
                                        modifier2 = modifier;
                                        j13 = j;
                                        j11 = j2;
                                        fontStyle3 = fontStyle;
                                        fontWeight3 = fontWeight;
                                        fontFamily3 = fontFamily;
                                        j12 = j3;
                                        textDecoration3 = textDecoration;
                                        textAlign3 = textAlign;
                                        j10 = j4;
                                        i30 = i;
                                        z3 = z;
                                        i28 = i2;
                                        i29 = i3;
                                        function13 = function1;
                                        textStyle3 = textStyle;
                                    }
                                    ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
                                    if (endRestartGroup != null) {
                                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextKt$Text$1
                                            /* JADX INFO: Access modifiers changed from: package-private */
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(2);
                                            }

                                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                                invoke((Composer) obj, ((Number) obj2).intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer composer2, int i37) {
                                                TextKt.m3199Text4IGK_g(str, modifier2, j13, j11, fontStyle3, fontWeight3, fontFamily3, j12, textDecoration3, textAlign3, j10, i30, z3, i28, i29, (Function1<? super TextLayoutResult, Unit>) function13, textStyle3, composer2, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), RecomposeScopeImplKt.updateChangedFlags(i5), i6);
                                            }
                                        });
                                        return;
                                    }
                                    return;
                                }
                            }
                            i23 = i6 & Fields.CompositingStrategy;
                            if (i23 != 0) {
                            }
                            if ((i5 & 1572864) == 0) {
                            }
                            if ((i7 & 306783379) == 306783378) {
                            }
                            startRestartGroup.startDefaults();
                            if ((i4 & 1) != 0) {
                            }
                            if (i31 != 0) {
                            }
                            if (i8 != 0) {
                            }
                            if (i9 != 0) {
                            }
                            if (i10 != 0) {
                            }
                            if (i11 != 0) {
                            }
                            if (i12 != 0) {
                            }
                            if (i13 != 0) {
                            }
                            if (i14 != 0) {
                            }
                            if (i15 != 0) {
                            }
                            if (i16 != 0) {
                            }
                            if (i18 != 0) {
                            }
                            if (i19 != 0) {
                            }
                            if (i20 != 0) {
                            }
                            if (i22 != 0) {
                            }
                            if (i23 == 0) {
                            }
                            if ((i6 & 65536) != 0) {
                            }
                        }
                        i21 = i6 & Fields.Clip;
                        if (i21 == 0) {
                        }
                        i23 = i6 & Fields.CompositingStrategy;
                        if (i23 != 0) {
                        }
                        if ((i5 & 1572864) == 0) {
                        }
                        if ((i7 & 306783379) == 306783378) {
                        }
                        startRestartGroup.startDefaults();
                        if ((i4 & 1) != 0) {
                        }
                        if (i31 != 0) {
                        }
                        if (i8 != 0) {
                        }
                        if (i9 != 0) {
                        }
                        if (i10 != 0) {
                        }
                        if (i11 != 0) {
                        }
                        if (i12 != 0) {
                        }
                        if (i13 != 0) {
                        }
                        if (i14 != 0) {
                        }
                        if (i15 != 0) {
                        }
                        if (i16 != 0) {
                        }
                        if (i18 != 0) {
                        }
                        if (i19 != 0) {
                        }
                        if (i20 != 0) {
                        }
                        if (i22 != 0) {
                        }
                        if (i23 == 0) {
                        }
                        if ((i6 & 65536) != 0) {
                        }
                    }
                    i20 = i6 & Fields.Shape;
                    if (i20 != 0) {
                    }
                    i21 = i6 & Fields.Clip;
                    if (i21 == 0) {
                    }
                    i23 = i6 & Fields.CompositingStrategy;
                    if (i23 != 0) {
                    }
                    if ((i5 & 1572864) == 0) {
                    }
                    if ((i7 & 306783379) == 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i4 & 1) != 0) {
                    }
                    if (i31 != 0) {
                    }
                    if (i8 != 0) {
                    }
                    if (i9 != 0) {
                    }
                    if (i10 != 0) {
                    }
                    if (i11 != 0) {
                    }
                    if (i12 != 0) {
                    }
                    if (i13 != 0) {
                    }
                    if (i14 != 0) {
                    }
                    if (i15 != 0) {
                    }
                    if (i16 != 0) {
                    }
                    if (i18 != 0) {
                    }
                    if (i19 != 0) {
                    }
                    if (i20 != 0) {
                    }
                    if (i22 != 0) {
                    }
                    if (i23 == 0) {
                    }
                    if ((i6 & 65536) != 0) {
                    }
                }
                i15 = i6 & Fields.RotationY;
                if (i15 == 0) {
                }
                i16 = i6 & Fields.RotationZ;
                if (i16 == 0) {
                }
                i18 = i6 & Fields.CameraDistance;
                if (i18 == 0) {
                }
                int i352 = i17;
                i19 = i6 & Fields.TransformOrigin;
                if (i19 == 0) {
                }
                i20 = i6 & Fields.Shape;
                if (i20 != 0) {
                }
                i21 = i6 & Fields.Clip;
                if (i21 == 0) {
                }
                i23 = i6 & Fields.CompositingStrategy;
                if (i23 != 0) {
                }
                if ((i5 & 1572864) == 0) {
                }
                if ((i7 & 306783379) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i4 & 1) != 0) {
                }
                if (i31 != 0) {
                }
                if (i8 != 0) {
                }
                if (i9 != 0) {
                }
                if (i10 != 0) {
                }
                if (i11 != 0) {
                }
                if (i12 != 0) {
                }
                if (i13 != 0) {
                }
                if (i14 != 0) {
                }
                if (i15 != 0) {
                }
                if (i16 != 0) {
                }
                if (i18 != 0) {
                }
                if (i19 != 0) {
                }
                if (i20 != 0) {
                }
                if (i22 != 0) {
                }
                if (i23 == 0) {
                }
                if ((i6 & 65536) != 0) {
                }
            }
            i11 = i6 & 32;
            int i342 = Fields.RenderEffect;
            if (i11 != 0) {
            }
            i12 = i6 & 64;
            if (i12 != 0) {
            }
            i13 = i6 & Fields.SpotShadowColor;
            if (i13 != 0) {
            }
            i14 = i6 & Fields.RotationX;
            if (i14 != 0) {
            }
            i15 = i6 & Fields.RotationY;
            if (i15 == 0) {
            }
            i16 = i6 & Fields.RotationZ;
            if (i16 == 0) {
            }
            i18 = i6 & Fields.CameraDistance;
            if (i18 == 0) {
            }
            int i3522 = i17;
            i19 = i6 & Fields.TransformOrigin;
            if (i19 == 0) {
            }
            i20 = i6 & Fields.Shape;
            if (i20 != 0) {
            }
            i21 = i6 & Fields.Clip;
            if (i21 == 0) {
            }
            i23 = i6 & Fields.CompositingStrategy;
            if (i23 != 0) {
            }
            if ((i5 & 1572864) == 0) {
            }
            if ((i7 & 306783379) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i4 & 1) != 0) {
            }
            if (i31 != 0) {
            }
            if (i8 != 0) {
            }
            if (i9 != 0) {
            }
            if (i10 != 0) {
            }
            if (i11 != 0) {
            }
            if (i12 != 0) {
            }
            if (i13 != 0) {
            }
            if (i14 != 0) {
            }
            if (i15 != 0) {
            }
            if (i16 != 0) {
            }
            if (i18 != 0) {
            }
            if (i19 != 0) {
            }
            if (i20 != 0) {
            }
            if (i22 != 0) {
            }
            if (i23 == 0) {
            }
            if ((i6 & 65536) != 0) {
            }
        }
        i8 = i6 & 4;
        if (i8 == 0) {
        }
        i9 = i6 & 8;
        int i322 = Fields.CameraDistance;
        if (i9 == 0) {
        }
        i10 = i6 & 16;
        int i332 = Fields.Clip;
        if (i10 == 0) {
        }
        i11 = i6 & 32;
        int i3422 = Fields.RenderEffect;
        if (i11 != 0) {
        }
        i12 = i6 & 64;
        if (i12 != 0) {
        }
        i13 = i6 & Fields.SpotShadowColor;
        if (i13 != 0) {
        }
        i14 = i6 & Fields.RotationX;
        if (i14 != 0) {
        }
        i15 = i6 & Fields.RotationY;
        if (i15 == 0) {
        }
        i16 = i6 & Fields.RotationZ;
        if (i16 == 0) {
        }
        i18 = i6 & Fields.CameraDistance;
        if (i18 == 0) {
        }
        int i35222 = i17;
        i19 = i6 & Fields.TransformOrigin;
        if (i19 == 0) {
        }
        i20 = i6 & Fields.Shape;
        if (i20 != 0) {
        }
        i21 = i6 & Fields.Clip;
        if (i21 == 0) {
        }
        i23 = i6 & Fields.CompositingStrategy;
        if (i23 != 0) {
        }
        if ((i5 & 1572864) == 0) {
        }
        if ((i7 & 306783379) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i4 & 1) != 0) {
        }
        if (i31 != 0) {
        }
        if (i8 != 0) {
        }
        if (i9 != 0) {
        }
        if (i10 != 0) {
        }
        if (i11 != 0) {
        }
        if (i12 != 0) {
        }
        if (i13 != 0) {
        }
        if (i14 != 0) {
        }
        if (i15 != 0) {
        }
        if (i16 != 0) {
        }
        if (i18 != 0) {
        }
        if (i19 != 0) {
        }
        if (i20 != 0) {
        }
        if (i22 != 0) {
        }
        if (i23 == 0) {
        }
        if ((i6 & 65536) != 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x02a1  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x02ac  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x02b3  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x02b7  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x02c2  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x02cd  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x02d3  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x02db  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x02e6  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x030a  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x02e0  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x02d7  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x02c9  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x02be  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x02ae  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x02a8  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x029d  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0296  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x028f  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0271  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x03cf  */
    /* JADX WARN: Removed duplicated region for block: B:72:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0330  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x03a9  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x033b  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0293  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with minLines instead")
    /* renamed from: Text-fLXpl1I, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void m3201TextfLXpl1I(final String str, Modifier modifier, long j, long j2, FontStyle fontStyle, FontWeight fontWeight, FontFamily fontFamily, long j3, TextDecoration textDecoration, TextAlign textAlign, long j4, int i, boolean z, int i2, Function1 function1, TextStyle textStyle, Composer composer, final int i3, final int i4, final int i5) {
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        Modifier.Companion companion;
        long m4875getUnspecified0d7_KjU;
        TextAlign textAlign2;
        TextDecoration textDecoration2;
        long j5;
        TextStyle textStyle2;
        int i22;
        boolean z2;
        int i23;
        int i24;
        Function1 function12;
        long j6;
        FontStyle fontStyle2;
        FontWeight fontWeight2;
        FontFamily fontFamily2;
        long j7;
        final TextDecoration textDecoration3;
        Composer composer2;
        final TextAlign textAlign3;
        final long j8;
        final int i25;
        final boolean z3;
        final int i26;
        final Function1 function13;
        final TextStyle textStyle3;
        final FontStyle fontStyle3;
        final FontWeight fontWeight3;
        final FontFamily fontFamily3;
        final Modifier modifier2;
        final long j9;
        final long j10;
        final long j11;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(1968784669);
        ComposerKt.sourceInformation(startRestartGroup, "C(Text)P(13,8,0:c#ui.graphics.Color,2:c#ui.unit.TextUnit,3:c#ui.text.font.FontStyle,4!1,5:c#ui.unit.TextUnit,15,14:c#ui.text.style.TextAlign,6:c#ui.unit.TextUnit,10:c#ui.text.style.TextOverflow,11)160@7042L7,162@7058L322:Text.kt#uh7d8r");
        if ((i5 & 1) != 0) {
            i6 = i3 | 6;
        } else if ((i3 & 6) == 0) {
            i6 = (startRestartGroup.changed(str) ? 4 : 2) | i3;
        } else {
            i6 = i3;
        }
        int i27 = i5 & 2;
        if (i27 != 0) {
            i6 |= 48;
        } else if ((i3 & 48) == 0) {
            i6 |= startRestartGroup.changed(modifier) ? 32 : 16;
            i7 = i5 & 4;
            if (i7 == 0) {
                i6 |= 384;
            } else if ((i3 & 384) == 0) {
                i6 |= startRestartGroup.changed(j) ? Fields.RotationX : Fields.SpotShadowColor;
            }
            i8 = i5 & 8;
            int i28 = Fields.CameraDistance;
            if (i8 == 0) {
                i6 |= 3072;
            } else if ((i3 & 3072) == 0) {
                i6 |= startRestartGroup.changed(j2) ? 2048 : 1024;
            }
            i9 = i5 & 16;
            int i29 = Fields.Clip;
            if (i9 == 0) {
                i6 |= 24576;
            } else if ((i3 & 24576) == 0) {
                i6 |= startRestartGroup.changed(fontStyle) ? 16384 : 8192;
                i10 = i5 & 32;
                int i30 = 65536;
                if (i10 != 0) {
                    i6 |= 196608;
                } else if ((i3 & 196608) == 0) {
                    i6 |= startRestartGroup.changed(fontWeight) ? Fields.RenderEffect : 65536;
                }
                i11 = i5 & 64;
                if (i11 != 0) {
                    i6 |= 1572864;
                } else if ((i3 & 1572864) == 0) {
                    i6 |= startRestartGroup.changed(fontFamily) ? 1048576 : Fields.BlendMode;
                }
                i12 = i5 & Fields.SpotShadowColor;
                if (i12 != 0) {
                    i6 |= 12582912;
                } else if ((i3 & 12582912) == 0) {
                    i6 |= startRestartGroup.changed(j3) ? 8388608 : 4194304;
                }
                i13 = i5 & Fields.RotationX;
                if (i13 != 0) {
                    i6 |= 100663296;
                } else if ((100663296 & i3) == 0) {
                    i6 |= startRestartGroup.changed(textDecoration) ? 67108864 : 33554432;
                    i14 = i5 & Fields.RotationY;
                    if (i14 == 0) {
                        i6 |= 805306368;
                    } else if ((i3 & 805306368) == 0) {
                        i6 |= startRestartGroup.changed(textAlign) ? 536870912 : 268435456;
                    }
                    i15 = i5 & Fields.RotationZ;
                    if (i15 == 0) {
                        i16 = i4 | 6;
                    } else if ((i4 & 6) == 0) {
                        i16 = i4 | (startRestartGroup.changed(j4) ? 4 : 2);
                    } else {
                        i16 = i4;
                    }
                    i17 = i5 & Fields.CameraDistance;
                    if (i17 == 0) {
                        i16 |= 48;
                    } else if ((i4 & 48) == 0) {
                        i16 |= startRestartGroup.changed(i) ? 32 : 16;
                    }
                    int i31 = i16;
                    i18 = i5 & Fields.TransformOrigin;
                    if (i18 == 0) {
                        i31 |= 384;
                    } else if ((i4 & 384) == 0) {
                        i31 |= startRestartGroup.changed(z) ? Fields.RotationX : Fields.SpotShadowColor;
                        i19 = i5 & Fields.Shape;
                        if (i19 != 0) {
                            i31 |= 3072;
                        } else if ((i4 & 3072) == 0) {
                            if (!startRestartGroup.changed(i2)) {
                                i28 = 1024;
                            }
                            i31 |= i28;
                            i20 = i5 & Fields.Clip;
                            if (i20 == 0) {
                                i31 |= 24576;
                                i21 = i20;
                            } else {
                                i21 = i20;
                                if ((i4 & 24576) == 0) {
                                    if (!startRestartGroup.changedInstance(function1)) {
                                        i29 = 8192;
                                    }
                                    i31 |= i29;
                                    if ((i4 & 196608) == 0) {
                                        if ((i5 & Fields.CompositingStrategy) == 0 && startRestartGroup.changed(textStyle)) {
                                            i30 = Fields.RenderEffect;
                                        }
                                        i31 |= i30;
                                    }
                                    if ((i6 & 306783379) == 306783378 || (74899 & i31) != 74898 || !startRestartGroup.getSkipping()) {
                                        startRestartGroup.startDefaults();
                                        if ((i3 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                            companion = i27 != 0 ? Modifier.INSTANCE : modifier;
                                            m4875getUnspecified0d7_KjU = i7 != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j;
                                            long j12 = i8 != 0 ? TextUnit.Companion.getUnspecified-XSAIIZE() : j2;
                                            FontStyle fontStyle4 = i9 != 0 ? null : fontStyle;
                                            FontWeight fontWeight4 = i10 != 0 ? null : fontWeight;
                                            FontFamily fontFamily4 = i11 != 0 ? null : fontFamily;
                                            long j13 = i12 != 0 ? TextUnit.Companion.getUnspecified-XSAIIZE() : j3;
                                            TextDecoration textDecoration4 = i13 != 0 ? null : textDecoration;
                                            textAlign2 = i14 == 0 ? textAlign : null;
                                            long j14 = i15 != 0 ? TextUnit.Companion.getUnspecified-XSAIIZE() : j4;
                                            int i32 = i17 != 0 ? TextOverflow.Companion.getClip-gIe3tQ8() : i;
                                            boolean z4 = i18 != 0 ? true : z;
                                            int i33 = i19 != 0 ? Integer.MAX_VALUE : i2;
                                            TextKt$Text$2 textKt$Text$2 = i21 != 0 ? new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material3.TextKt$Text$2
                                                public final void invoke(TextLayoutResult textLayoutResult) {
                                                }

                                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                                    invoke((TextLayoutResult) obj);
                                                    return Unit.INSTANCE;
                                                }
                                            } : function1;
                                            if ((i5 & Fields.CompositingStrategy) != 0) {
                                                textDecoration2 = textDecoration4;
                                                ProvidableCompositionLocal<TextStyle> providableCompositionLocal = LocalTextStyle;
                                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                                Object consume = startRestartGroup.consume(providableCompositionLocal);
                                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                i31 &= -458753;
                                                j5 = j14;
                                                textStyle2 = (TextStyle) consume;
                                            } else {
                                                textDecoration2 = textDecoration4;
                                                j5 = j14;
                                                textStyle2 = textStyle;
                                            }
                                            i22 = i32;
                                            z2 = z4;
                                            i23 = i31;
                                            i24 = i33;
                                            function12 = textKt$Text$2;
                                            j6 = j12;
                                            fontStyle2 = fontStyle4;
                                            fontWeight2 = fontWeight4;
                                            fontFamily2 = fontFamily4;
                                            j7 = j13;
                                            textDecoration3 = textDecoration2;
                                        } else {
                                            startRestartGroup.skipToGroupEnd();
                                            if ((i5 & Fields.CompositingStrategy) != 0) {
                                                i31 &= -458753;
                                            }
                                            companion = modifier;
                                            m4875getUnspecified0d7_KjU = j;
                                            j6 = j2;
                                            fontStyle2 = fontStyle;
                                            fontWeight2 = fontWeight;
                                            fontFamily2 = fontFamily;
                                            textDecoration3 = textDecoration;
                                            textAlign2 = textAlign;
                                            j5 = j4;
                                            i22 = i;
                                            z2 = z;
                                            i24 = i2;
                                            function12 = function1;
                                            textStyle2 = textStyle;
                                            i23 = i31;
                                            j7 = j3;
                                        }
                                        startRestartGroup.endDefaults();
                                        if (ComposerKt.isTraceInProgress()) {
                                            composer2 = startRestartGroup;
                                            ComposerKt.traceEventStart(1968784669, i6, i23, "androidx.compose.material3.Text (Text.kt:161)");
                                        } else {
                                            composer2 = startRestartGroup;
                                        }
                                        int i34 = i23 << 3;
                                        m3199Text4IGK_g(str, companion, m4875getUnspecified0d7_KjU, j6, fontStyle2, fontWeight2, fontFamily2, j7, textDecoration3, textAlign2, j5, i22, z2, i24, 1, (Function1<? super TextLayoutResult, Unit>) function12, textStyle2, composer2, (i6 & 14) | (i6 & 112) | (i6 & 896) | (i6 & 7168) | (57344 & i6) | (458752 & i6) | (3670016 & i6) | (29360128 & i6) | (234881024 & i6) | (i6 & 1879048192), (i23 & 14) | 24576 | (i23 & 112) | (i23 & 896) | (i23 & 7168) | (458752 & i34) | (i34 & 3670016), 0);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                        textAlign3 = textAlign2;
                                        j8 = j5;
                                        i25 = i22;
                                        z3 = z2;
                                        i26 = i24;
                                        function13 = function12;
                                        textStyle3 = textStyle2;
                                        FontFamily fontFamily5 = fontFamily2;
                                        fontStyle3 = fontStyle2;
                                        long j15 = j7;
                                        fontWeight3 = fontWeight2;
                                        fontFamily3 = fontFamily5;
                                        long j16 = j6;
                                        modifier2 = companion;
                                        j9 = j16;
                                        j10 = m4875getUnspecified0d7_KjU;
                                        j11 = j15;
                                    } else {
                                        startRestartGroup.skipToGroupEnd();
                                        modifier2 = modifier;
                                        j10 = j;
                                        j9 = j2;
                                        fontStyle3 = fontStyle;
                                        fontWeight3 = fontWeight;
                                        fontFamily3 = fontFamily;
                                        j11 = j3;
                                        textDecoration3 = textDecoration;
                                        textAlign3 = textAlign;
                                        j8 = j4;
                                        i25 = i;
                                        z3 = z;
                                        i26 = i2;
                                        function13 = function1;
                                        textStyle3 = textStyle;
                                        composer2 = startRestartGroup;
                                    }
                                    endRestartGroup = composer2.endRestartGroup();
                                    if (endRestartGroup != null) {
                                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextKt$Text$3
                                            /* JADX INFO: Access modifiers changed from: package-private */
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(2);
                                            }

                                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                                invoke((Composer) obj, ((Number) obj2).intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer composer3, int i35) {
                                                TextKt.m3201TextfLXpl1I(str, modifier2, j10, j9, fontStyle3, fontWeight3, fontFamily3, j11, textDecoration3, textAlign3, j8, i25, z3, i26, function13, textStyle3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                                            }
                                        });
                                        return;
                                    }
                                    return;
                                }
                            }
                            if ((i4 & 196608) == 0) {
                            }
                            if ((i6 & 306783379) == 306783378) {
                            }
                            startRestartGroup.startDefaults();
                            if ((i3 & 1) != 0) {
                            }
                            if (i27 != 0) {
                            }
                            if (i7 != 0) {
                            }
                            if (i8 != 0) {
                            }
                            if (i9 != 0) {
                            }
                            if (i10 != 0) {
                            }
                            if (i11 != 0) {
                            }
                            if (i12 != 0) {
                            }
                            if (i13 != 0) {
                            }
                            if (i14 == 0) {
                            }
                            if (i15 != 0) {
                            }
                            if (i17 != 0) {
                            }
                            if (i18 != 0) {
                            }
                            if (i19 != 0) {
                            }
                            if (i21 != 0) {
                            }
                            if ((i5 & Fields.CompositingStrategy) != 0) {
                            }
                            i22 = i32;
                            z2 = z4;
                            i23 = i31;
                            i24 = i33;
                            function12 = textKt$Text$2;
                            j6 = j12;
                            fontStyle2 = fontStyle4;
                            fontWeight2 = fontWeight4;
                            fontFamily2 = fontFamily4;
                            j7 = j13;
                            textDecoration3 = textDecoration2;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            int i342 = i23 << 3;
                            m3199Text4IGK_g(str, companion, m4875getUnspecified0d7_KjU, j6, fontStyle2, fontWeight2, fontFamily2, j7, textDecoration3, textAlign2, j5, i22, z2, i24, 1, (Function1<? super TextLayoutResult, Unit>) function12, textStyle2, composer2, (i6 & 14) | (i6 & 112) | (i6 & 896) | (i6 & 7168) | (57344 & i6) | (458752 & i6) | (3670016 & i6) | (29360128 & i6) | (234881024 & i6) | (i6 & 1879048192), (i23 & 14) | 24576 | (i23 & 112) | (i23 & 896) | (i23 & 7168) | (458752 & i342) | (i342 & 3670016), 0);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            textAlign3 = textAlign2;
                            j8 = j5;
                            i25 = i22;
                            z3 = z2;
                            i26 = i24;
                            function13 = function12;
                            textStyle3 = textStyle2;
                            FontFamily fontFamily52 = fontFamily2;
                            fontStyle3 = fontStyle2;
                            long j152 = j7;
                            fontWeight3 = fontWeight2;
                            fontFamily3 = fontFamily52;
                            long j162 = j6;
                            modifier2 = companion;
                            j9 = j162;
                            j10 = m4875getUnspecified0d7_KjU;
                            j11 = j152;
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup != null) {
                            }
                        }
                        i20 = i5 & Fields.Clip;
                        if (i20 == 0) {
                        }
                        if ((i4 & 196608) == 0) {
                        }
                        if ((i6 & 306783379) == 306783378) {
                        }
                        startRestartGroup.startDefaults();
                        if ((i3 & 1) != 0) {
                        }
                        if (i27 != 0) {
                        }
                        if (i7 != 0) {
                        }
                        if (i8 != 0) {
                        }
                        if (i9 != 0) {
                        }
                        if (i10 != 0) {
                        }
                        if (i11 != 0) {
                        }
                        if (i12 != 0) {
                        }
                        if (i13 != 0) {
                        }
                        if (i14 == 0) {
                        }
                        if (i15 != 0) {
                        }
                        if (i17 != 0) {
                        }
                        if (i18 != 0) {
                        }
                        if (i19 != 0) {
                        }
                        if (i21 != 0) {
                        }
                        if ((i5 & Fields.CompositingStrategy) != 0) {
                        }
                        i22 = i32;
                        z2 = z4;
                        i23 = i31;
                        i24 = i33;
                        function12 = textKt$Text$2;
                        j6 = j12;
                        fontStyle2 = fontStyle4;
                        fontWeight2 = fontWeight4;
                        fontFamily2 = fontFamily4;
                        j7 = j13;
                        textDecoration3 = textDecoration2;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        int i3422 = i23 << 3;
                        m3199Text4IGK_g(str, companion, m4875getUnspecified0d7_KjU, j6, fontStyle2, fontWeight2, fontFamily2, j7, textDecoration3, textAlign2, j5, i22, z2, i24, 1, (Function1<? super TextLayoutResult, Unit>) function12, textStyle2, composer2, (i6 & 14) | (i6 & 112) | (i6 & 896) | (i6 & 7168) | (57344 & i6) | (458752 & i6) | (3670016 & i6) | (29360128 & i6) | (234881024 & i6) | (i6 & 1879048192), (i23 & 14) | 24576 | (i23 & 112) | (i23 & 896) | (i23 & 7168) | (458752 & i3422) | (i3422 & 3670016), 0);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        textAlign3 = textAlign2;
                        j8 = j5;
                        i25 = i22;
                        z3 = z2;
                        i26 = i24;
                        function13 = function12;
                        textStyle3 = textStyle2;
                        FontFamily fontFamily522 = fontFamily2;
                        fontStyle3 = fontStyle2;
                        long j1522 = j7;
                        fontWeight3 = fontWeight2;
                        fontFamily3 = fontFamily522;
                        long j1622 = j6;
                        modifier2 = companion;
                        j9 = j1622;
                        j10 = m4875getUnspecified0d7_KjU;
                        j11 = j1522;
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                        }
                    }
                    i19 = i5 & Fields.Shape;
                    if (i19 != 0) {
                    }
                    i20 = i5 & Fields.Clip;
                    if (i20 == 0) {
                    }
                    if ((i4 & 196608) == 0) {
                    }
                    if ((i6 & 306783379) == 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i3 & 1) != 0) {
                    }
                    if (i27 != 0) {
                    }
                    if (i7 != 0) {
                    }
                    if (i8 != 0) {
                    }
                    if (i9 != 0) {
                    }
                    if (i10 != 0) {
                    }
                    if (i11 != 0) {
                    }
                    if (i12 != 0) {
                    }
                    if (i13 != 0) {
                    }
                    if (i14 == 0) {
                    }
                    if (i15 != 0) {
                    }
                    if (i17 != 0) {
                    }
                    if (i18 != 0) {
                    }
                    if (i19 != 0) {
                    }
                    if (i21 != 0) {
                    }
                    if ((i5 & Fields.CompositingStrategy) != 0) {
                    }
                    i22 = i32;
                    z2 = z4;
                    i23 = i31;
                    i24 = i33;
                    function12 = textKt$Text$2;
                    j6 = j12;
                    fontStyle2 = fontStyle4;
                    fontWeight2 = fontWeight4;
                    fontFamily2 = fontFamily4;
                    j7 = j13;
                    textDecoration3 = textDecoration2;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    int i34222 = i23 << 3;
                    m3199Text4IGK_g(str, companion, m4875getUnspecified0d7_KjU, j6, fontStyle2, fontWeight2, fontFamily2, j7, textDecoration3, textAlign2, j5, i22, z2, i24, 1, (Function1<? super TextLayoutResult, Unit>) function12, textStyle2, composer2, (i6 & 14) | (i6 & 112) | (i6 & 896) | (i6 & 7168) | (57344 & i6) | (458752 & i6) | (3670016 & i6) | (29360128 & i6) | (234881024 & i6) | (i6 & 1879048192), (i23 & 14) | 24576 | (i23 & 112) | (i23 & 896) | (i23 & 7168) | (458752 & i34222) | (i34222 & 3670016), 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    textAlign3 = textAlign2;
                    j8 = j5;
                    i25 = i22;
                    z3 = z2;
                    i26 = i24;
                    function13 = function12;
                    textStyle3 = textStyle2;
                    FontFamily fontFamily5222 = fontFamily2;
                    fontStyle3 = fontStyle2;
                    long j15222 = j7;
                    fontWeight3 = fontWeight2;
                    fontFamily3 = fontFamily5222;
                    long j16222 = j6;
                    modifier2 = companion;
                    j9 = j16222;
                    j10 = m4875getUnspecified0d7_KjU;
                    j11 = j15222;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                i14 = i5 & Fields.RotationY;
                if (i14 == 0) {
                }
                i15 = i5 & Fields.RotationZ;
                if (i15 == 0) {
                }
                i17 = i5 & Fields.CameraDistance;
                if (i17 == 0) {
                }
                int i312 = i16;
                i18 = i5 & Fields.TransformOrigin;
                if (i18 == 0) {
                }
                i19 = i5 & Fields.Shape;
                if (i19 != 0) {
                }
                i20 = i5 & Fields.Clip;
                if (i20 == 0) {
                }
                if ((i4 & 196608) == 0) {
                }
                if ((i6 & 306783379) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i3 & 1) != 0) {
                }
                if (i27 != 0) {
                }
                if (i7 != 0) {
                }
                if (i8 != 0) {
                }
                if (i9 != 0) {
                }
                if (i10 != 0) {
                }
                if (i11 != 0) {
                }
                if (i12 != 0) {
                }
                if (i13 != 0) {
                }
                if (i14 == 0) {
                }
                if (i15 != 0) {
                }
                if (i17 != 0) {
                }
                if (i18 != 0) {
                }
                if (i19 != 0) {
                }
                if (i21 != 0) {
                }
                if ((i5 & Fields.CompositingStrategy) != 0) {
                }
                i22 = i32;
                z2 = z4;
                i23 = i312;
                i24 = i33;
                function12 = textKt$Text$2;
                j6 = j12;
                fontStyle2 = fontStyle4;
                fontWeight2 = fontWeight4;
                fontFamily2 = fontFamily4;
                j7 = j13;
                textDecoration3 = textDecoration2;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                int i342222 = i23 << 3;
                m3199Text4IGK_g(str, companion, m4875getUnspecified0d7_KjU, j6, fontStyle2, fontWeight2, fontFamily2, j7, textDecoration3, textAlign2, j5, i22, z2, i24, 1, (Function1<? super TextLayoutResult, Unit>) function12, textStyle2, composer2, (i6 & 14) | (i6 & 112) | (i6 & 896) | (i6 & 7168) | (57344 & i6) | (458752 & i6) | (3670016 & i6) | (29360128 & i6) | (234881024 & i6) | (i6 & 1879048192), (i23 & 14) | 24576 | (i23 & 112) | (i23 & 896) | (i23 & 7168) | (458752 & i342222) | (i342222 & 3670016), 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                textAlign3 = textAlign2;
                j8 = j5;
                i25 = i22;
                z3 = z2;
                i26 = i24;
                function13 = function12;
                textStyle3 = textStyle2;
                FontFamily fontFamily52222 = fontFamily2;
                fontStyle3 = fontStyle2;
                long j152222 = j7;
                fontWeight3 = fontWeight2;
                fontFamily3 = fontFamily52222;
                long j162222 = j6;
                modifier2 = companion;
                j9 = j162222;
                j10 = m4875getUnspecified0d7_KjU;
                j11 = j152222;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            i10 = i5 & 32;
            int i302 = 65536;
            if (i10 != 0) {
            }
            i11 = i5 & 64;
            if (i11 != 0) {
            }
            i12 = i5 & Fields.SpotShadowColor;
            if (i12 != 0) {
            }
            i13 = i5 & Fields.RotationX;
            if (i13 != 0) {
            }
            i14 = i5 & Fields.RotationY;
            if (i14 == 0) {
            }
            i15 = i5 & Fields.RotationZ;
            if (i15 == 0) {
            }
            i17 = i5 & Fields.CameraDistance;
            if (i17 == 0) {
            }
            int i3122 = i16;
            i18 = i5 & Fields.TransformOrigin;
            if (i18 == 0) {
            }
            i19 = i5 & Fields.Shape;
            if (i19 != 0) {
            }
            i20 = i5 & Fields.Clip;
            if (i20 == 0) {
            }
            if ((i4 & 196608) == 0) {
            }
            if ((i6 & 306783379) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i3 & 1) != 0) {
            }
            if (i27 != 0) {
            }
            if (i7 != 0) {
            }
            if (i8 != 0) {
            }
            if (i9 != 0) {
            }
            if (i10 != 0) {
            }
            if (i11 != 0) {
            }
            if (i12 != 0) {
            }
            if (i13 != 0) {
            }
            if (i14 == 0) {
            }
            if (i15 != 0) {
            }
            if (i17 != 0) {
            }
            if (i18 != 0) {
            }
            if (i19 != 0) {
            }
            if (i21 != 0) {
            }
            if ((i5 & Fields.CompositingStrategy) != 0) {
            }
            i22 = i32;
            z2 = z4;
            i23 = i3122;
            i24 = i33;
            function12 = textKt$Text$2;
            j6 = j12;
            fontStyle2 = fontStyle4;
            fontWeight2 = fontWeight4;
            fontFamily2 = fontFamily4;
            j7 = j13;
            textDecoration3 = textDecoration2;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            int i3422222 = i23 << 3;
            m3199Text4IGK_g(str, companion, m4875getUnspecified0d7_KjU, j6, fontStyle2, fontWeight2, fontFamily2, j7, textDecoration3, textAlign2, j5, i22, z2, i24, 1, (Function1<? super TextLayoutResult, Unit>) function12, textStyle2, composer2, (i6 & 14) | (i6 & 112) | (i6 & 896) | (i6 & 7168) | (57344 & i6) | (458752 & i6) | (3670016 & i6) | (29360128 & i6) | (234881024 & i6) | (i6 & 1879048192), (i23 & 14) | 24576 | (i23 & 112) | (i23 & 896) | (i23 & 7168) | (458752 & i3422222) | (i3422222 & 3670016), 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            textAlign3 = textAlign2;
            j8 = j5;
            i25 = i22;
            z3 = z2;
            i26 = i24;
            function13 = function12;
            textStyle3 = textStyle2;
            FontFamily fontFamily522222 = fontFamily2;
            fontStyle3 = fontStyle2;
            long j1522222 = j7;
            fontWeight3 = fontWeight2;
            fontFamily3 = fontFamily522222;
            long j1622222 = j6;
            modifier2 = companion;
            j9 = j1622222;
            j10 = m4875getUnspecified0d7_KjU;
            j11 = j1522222;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        i7 = i5 & 4;
        if (i7 == 0) {
        }
        i8 = i5 & 8;
        int i282 = Fields.CameraDistance;
        if (i8 == 0) {
        }
        i9 = i5 & 16;
        int i292 = Fields.Clip;
        if (i9 == 0) {
        }
        i10 = i5 & 32;
        int i3022 = 65536;
        if (i10 != 0) {
        }
        i11 = i5 & 64;
        if (i11 != 0) {
        }
        i12 = i5 & Fields.SpotShadowColor;
        if (i12 != 0) {
        }
        i13 = i5 & Fields.RotationX;
        if (i13 != 0) {
        }
        i14 = i5 & Fields.RotationY;
        if (i14 == 0) {
        }
        i15 = i5 & Fields.RotationZ;
        if (i15 == 0) {
        }
        i17 = i5 & Fields.CameraDistance;
        if (i17 == 0) {
        }
        int i31222 = i16;
        i18 = i5 & Fields.TransformOrigin;
        if (i18 == 0) {
        }
        i19 = i5 & Fields.Shape;
        if (i19 != 0) {
        }
        i20 = i5 & Fields.Clip;
        if (i20 == 0) {
        }
        if ((i4 & 196608) == 0) {
        }
        if ((i6 & 306783379) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i3 & 1) != 0) {
        }
        if (i27 != 0) {
        }
        if (i7 != 0) {
        }
        if (i8 != 0) {
        }
        if (i9 != 0) {
        }
        if (i10 != 0) {
        }
        if (i11 != 0) {
        }
        if (i12 != 0) {
        }
        if (i13 != 0) {
        }
        if (i14 == 0) {
        }
        if (i15 != 0) {
        }
        if (i17 != 0) {
        }
        if (i18 != 0) {
        }
        if (i19 != 0) {
        }
        if (i21 != 0) {
        }
        if ((i5 & Fields.CompositingStrategy) != 0) {
        }
        i22 = i32;
        z2 = z4;
        i23 = i31222;
        i24 = i33;
        function12 = textKt$Text$2;
        j6 = j12;
        fontStyle2 = fontStyle4;
        fontWeight2 = fontWeight4;
        fontFamily2 = fontFamily4;
        j7 = j13;
        textDecoration3 = textDecoration2;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        int i34222222 = i23 << 3;
        m3199Text4IGK_g(str, companion, m4875getUnspecified0d7_KjU, j6, fontStyle2, fontWeight2, fontFamily2, j7, textDecoration3, textAlign2, j5, i22, z2, i24, 1, (Function1<? super TextLayoutResult, Unit>) function12, textStyle2, composer2, (i6 & 14) | (i6 & 112) | (i6 & 896) | (i6 & 7168) | (57344 & i6) | (458752 & i6) | (3670016 & i6) | (29360128 & i6) | (234881024 & i6) | (i6 & 1879048192), (i23 & 14) | 24576 | (i23 & 112) | (i23 & 896) | (i23 & 7168) | (458752 & i34222222) | (i34222222 & 3670016), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        textAlign3 = textAlign2;
        j8 = j5;
        i25 = i22;
        z3 = z2;
        i26 = i24;
        function13 = function12;
        textStyle3 = textStyle2;
        FontFamily fontFamily5222222 = fontFamily2;
        fontStyle3 = fontStyle2;
        long j15222222 = j7;
        fontWeight3 = fontWeight2;
        fontFamily3 = fontFamily5222222;
        long j16222222 = j6;
        modifier2 = companion;
        j9 = j16222222;
        j10 = m4875getUnspecified0d7_KjU;
        j11 = j15222222;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x03eb  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x039c  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0394  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x037b  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x02ad  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x02b6  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x02c1  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x02cd  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x02d3  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x02da  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x02e1  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x02ec  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x02f3  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x02f7  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0302  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x030d  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0313  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x031b  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0321  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x032a  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0335  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0355  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x032f  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0326  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x031d  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0317  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x030f  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0309  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x02fe  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x02ee  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x02e8  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x02dd  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x02d6  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x02c8  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x02bd  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x02b2  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0236  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x049e  */
    /* JADX WARN: Removed duplicated region for block: B:77:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0370  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0392  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0397  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x03e6  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0471  */
    /* renamed from: Text-IbK3jfQ, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m3200TextIbK3jfQ(final AnnotatedString annotatedString, Modifier modifier, long j, long j2, FontStyle fontStyle, FontWeight fontWeight, FontFamily fontFamily, long j3, TextDecoration textDecoration, TextAlign textAlign, long j4, int i, boolean z, int i2, int i3, Map<String, InlineTextContent> map, Function1<? super TextLayoutResult, Unit> function1, TextStyle textStyle, Composer composer, final int i4, final int i5, final int i6) {
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        Modifier.Companion companion;
        long m4875getUnspecified0d7_KjU;
        FontStyle fontStyle2;
        FontWeight fontWeight2;
        FontFamily fontFamily2;
        TextDecoration textDecoration2;
        TextAlign textAlign2;
        int i25;
        long j5;
        TextStyle textStyle2;
        int i26;
        int i27;
        Map<String, InlineTextContent> map2;
        Function1<? super TextLayoutResult, Unit> function12;
        long j6;
        long j7;
        int i28;
        boolean z2;
        long j8;
        int i29;
        int i30;
        long j9;
        final TextDecoration textDecoration3;
        final TextAlign textAlign3;
        final long j10;
        final FontFamily fontFamily3;
        final long j11;
        final Function1<? super TextLayoutResult, Unit> function13;
        final TextStyle textStyle3;
        final int i31;
        final boolean z3;
        final Map<String, InlineTextContent> map3;
        final int i32;
        final Modifier modifier2;
        final int i33;
        final FontWeight fontWeight3;
        final FontStyle fontStyle3;
        final long j12;
        final long j13;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(2027001676);
        ComposerKt.sourceInformation(startRestartGroup, "C(Text)P(15,10,0:c#ui.graphics.Color,2:c#ui.unit.TextUnit,3:c#ui.text.font.FontStyle,4!1,6:c#ui.unit.TextUnit,17,16:c#ui.text.style.TextAlign,7:c#ui.unit.TextUnit,12:c#ui.text.style.TextOverflow,13,8,9)254@11532L7,262@11675L654:Text.kt#uh7d8r");
        if ((i6 & 1) != 0) {
            i7 = i4 | 6;
        } else if ((i4 & 6) == 0) {
            i7 = (startRestartGroup.changed(annotatedString) ? 4 : 2) | i4;
        } else {
            i7 = i4;
        }
        int i34 = i6 & 2;
        if (i34 != 0) {
            i7 |= 48;
        } else if ((i4 & 48) == 0) {
            i7 |= startRestartGroup.changed(modifier) ? 32 : 16;
            i8 = i6 & 4;
            if (i8 == 0) {
                i7 |= 384;
            } else if ((i4 & 384) == 0) {
                i7 |= startRestartGroup.changed(j) ? Fields.RotationX : Fields.SpotShadowColor;
            }
            i9 = i6 & 8;
            int i35 = Fields.CameraDistance;
            if (i9 == 0) {
                i7 |= 3072;
            } else if ((i4 & 3072) == 0) {
                i7 |= startRestartGroup.changed(j2) ? 2048 : 1024;
            }
            i10 = i6 & 16;
            int i36 = Fields.Clip;
            if (i10 == 0) {
                i7 |= 24576;
            } else if ((i4 & 24576) == 0) {
                i7 |= startRestartGroup.changed(fontStyle) ? 16384 : 8192;
                i11 = i6 & 32;
                if (i11 != 0) {
                    i7 |= 196608;
                } else if ((i4 & 196608) == 0) {
                    i7 |= startRestartGroup.changed(fontWeight) ? 131072 : 65536;
                }
                i12 = i6 & 64;
                if (i12 != 0) {
                    i7 |= 1572864;
                } else if ((i4 & 1572864) == 0) {
                    i7 |= startRestartGroup.changed(fontFamily) ? 1048576 : Fields.BlendMode;
                }
                i13 = i6 & Fields.SpotShadowColor;
                if (i13 != 0) {
                    i7 |= 12582912;
                } else if ((i4 & 12582912) == 0) {
                    i7 |= startRestartGroup.changed(j3) ? 8388608 : 4194304;
                }
                i14 = i6 & Fields.RotationX;
                if (i14 != 0) {
                    i7 |= 100663296;
                } else if ((i4 & 100663296) == 0) {
                    i7 |= startRestartGroup.changed(textDecoration) ? 67108864 : 33554432;
                }
                i15 = i6 & Fields.RotationY;
                if (i15 != 0) {
                    i7 |= 805306368;
                } else if ((i4 & 805306368) == 0) {
                    i7 |= startRestartGroup.changed(textAlign) ? 536870912 : 268435456;
                }
                i16 = i6 & Fields.RotationZ;
                if (i16 != 0) {
                    i17 = i5 | 6;
                } else if ((i5 & 6) == 0) {
                    i17 = i5 | (startRestartGroup.changed(j4) ? 4 : 2);
                } else {
                    i17 = i5;
                }
                i18 = i6 & Fields.CameraDistance;
                if (i18 != 0) {
                    i17 |= 48;
                } else if ((i5 & 48) == 0) {
                    i17 |= startRestartGroup.changed(i) ? 32 : 16;
                }
                int i37 = i17;
                i19 = i6 & Fields.TransformOrigin;
                if (i19 != 0) {
                    i37 |= 384;
                } else if ((i5 & 384) == 0) {
                    i37 |= startRestartGroup.changed(z) ? Fields.RotationX : Fields.SpotShadowColor;
                    i20 = i6 & Fields.Shape;
                    if (i20 == 0) {
                        i37 |= 3072;
                    } else if ((i5 & 3072) == 0) {
                        if (!startRestartGroup.changed(i2)) {
                            i35 = 1024;
                        }
                        i37 |= i35;
                        i21 = i6 & Fields.Clip;
                        if (i21 != 0) {
                            i37 |= 24576;
                            i22 = i21;
                        } else {
                            i22 = i21;
                            if ((i5 & 24576) == 0) {
                                if (!startRestartGroup.changed(i3)) {
                                    i36 = 8192;
                                }
                                i37 |= i36;
                                i23 = i6 & Fields.CompositingStrategy;
                                if (i23 == 0) {
                                    i37 |= 196608;
                                } else if ((i5 & 196608) == 0) {
                                    i37 |= startRestartGroup.changedInstance(map) ? 131072 : 65536;
                                }
                                i24 = i6 & 65536;
                                if (i24 == 0) {
                                    i37 |= 1572864;
                                } else if ((i5 & 1572864) == 0) {
                                    i37 |= startRestartGroup.changedInstance(function1) ? 1048576 : Fields.BlendMode;
                                }
                                if ((i5 & 12582912) == 0) {
                                    i37 |= ((i6 & Fields.RenderEffect) == 0 && startRestartGroup.changed(textStyle)) ? 8388608 : 4194304;
                                }
                                if ((i7 & 306783379) == 306783378 || (4793491 & i37) != 4793490 || !startRestartGroup.getSkipping()) {
                                    startRestartGroup.startDefaults();
                                    if ((i4 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                        companion = i34 == 0 ? Modifier.INSTANCE : modifier;
                                        m4875getUnspecified0d7_KjU = i8 == 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j;
                                        long j14 = i9 == 0 ? TextUnit.Companion.getUnspecified-XSAIIZE() : j2;
                                        fontStyle2 = i10 == 0 ? null : fontStyle;
                                        fontWeight2 = i11 == 0 ? null : fontWeight;
                                        fontFamily2 = i12 == 0 ? null : fontFamily;
                                        long j15 = i13 == 0 ? TextUnit.Companion.getUnspecified-XSAIIZE() : j3;
                                        textDecoration2 = i14 == 0 ? null : textDecoration;
                                        textAlign2 = i15 == 0 ? textAlign : null;
                                        long j16 = i16 == 0 ? TextUnit.Companion.getUnspecified-XSAIIZE() : j4;
                                        i25 = i18 == 0 ? TextOverflow.Companion.getClip-gIe3tQ8() : i;
                                        boolean z4 = i19 == 0 ? true : z;
                                        int i38 = i20 == 0 ? Integer.MAX_VALUE : i2;
                                        int i39 = i22 == 0 ? 1 : i3;
                                        Map<String, InlineTextContent> emptyMap = i23 == 0 ? MapsKt.emptyMap() : map;
                                        TextKt$Text$4 textKt$Text$4 = i24 == 0 ? new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material3.TextKt$Text$4
                                            public final void invoke(TextLayoutResult textLayoutResult) {
                                            }

                                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                                invoke((TextLayoutResult) obj);
                                                return Unit.INSTANCE;
                                            }
                                        } : function1;
                                        if ((i6 & Fields.RenderEffect) == 0) {
                                            ProvidableCompositionLocal<TextStyle> providableCompositionLocal = LocalTextStyle;
                                            j5 = j16;
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                            Object consume = startRestartGroup.consume(providableCompositionLocal);
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                            i37 &= -29360129;
                                            textStyle2 = (TextStyle) consume;
                                        } else {
                                            j5 = j16;
                                            textStyle2 = textStyle;
                                        }
                                        i26 = i37;
                                        i27 = i39;
                                        map2 = emptyMap;
                                        function12 = textKt$Text$4;
                                        j6 = j14;
                                        j7 = j5;
                                        i28 = i38;
                                        z2 = z4;
                                        j8 = j15;
                                    } else {
                                        startRestartGroup.skipToGroupEnd();
                                        if ((i6 & Fields.RenderEffect) != 0) {
                                            i37 &= -29360129;
                                        }
                                        companion = modifier;
                                        m4875getUnspecified0d7_KjU = j;
                                        j6 = j2;
                                        fontStyle2 = fontStyle;
                                        fontWeight2 = fontWeight;
                                        fontFamily2 = fontFamily;
                                        textDecoration2 = textDecoration;
                                        textAlign2 = textAlign;
                                        j7 = j4;
                                        i25 = i;
                                        z2 = z;
                                        i28 = i2;
                                        i27 = i3;
                                        map2 = map;
                                        function12 = function1;
                                        textStyle2 = textStyle;
                                        i26 = i37;
                                        j8 = j3;
                                    }
                                    startRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        i29 = i27;
                                    } else {
                                        i29 = i27;
                                        ComposerKt.traceEventStart(2027001676, i7, i26, "androidx.compose.material3.Text (Text.kt:255)");
                                    }
                                    startRestartGroup.startReplaceableGroup(79588770);
                                    ComposerKt.sourceInformation(startRestartGroup, "");
                                    if (m4875getUnspecified0d7_KjU == Color.INSTANCE.m4875getUnspecified0d7_KjU()) {
                                        startRestartGroup.startReplaceableGroup(79588803);
                                        ComposerKt.sourceInformation(startRestartGroup, "*258@11646L7");
                                        long j17 = textStyle2.getColor-0d7_KjU();
                                        if (j17 != Color.INSTANCE.m4875getUnspecified0d7_KjU()) {
                                            i30 = i28;
                                        } else {
                                            ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
                                            i30 = i28;
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                            Object consume2 = startRestartGroup.consume(localContentColor);
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                            j17 = ((Color) consume2).m4849unboximpl();
                                        }
                                        startRestartGroup.endReplaceableGroup();
                                        j9 = j17;
                                    } else {
                                        i30 = i28;
                                        j9 = m4875getUnspecified0d7_KjU;
                                    }
                                    startRestartGroup.endReplaceableGroup();
                                    int i40 = (i7 & 112) | (i7 & 14) | ((i26 >> 9) & 7168);
                                    int i41 = i26 << 9;
                                    BasicTextKt.m1515BasicTextRWo7tUw(annotatedString, companion, TextStyle.merge-dA7vx0o$default(textStyle2, j9, j6, fontWeight2, fontStyle2, (FontSynthesis) null, fontFamily2, (String) null, j8, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, textDecoration2, (Shadow) null, (DrawStyle) null, textAlign2 == null ? textAlign2.unbox-impl() : TextAlign.Companion.getUnspecified-e0LSkKk(), 0, j7, (TextIndent) null, (LineHeightStyle) null, 0, 0, (PlatformTextStyle) null, (TextMotion) null, 16609104, (Object) null), function12, i25, z2, i30, i29, map2, (ColorProducer) null, startRestartGroup, i40 | (57344 & i41) | (458752 & i41) | (3670016 & i41) | (29360128 & i41) | (i41 & 234881024), Fields.RotationY);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    textDecoration3 = textDecoration2;
                                    textAlign3 = textAlign2;
                                    j10 = j7;
                                    fontFamily3 = fontFamily2;
                                    j11 = m4875getUnspecified0d7_KjU;
                                    function13 = function12;
                                    textStyle3 = textStyle2;
                                    i31 = i30;
                                    z3 = z2;
                                    map3 = map2;
                                    i32 = i29;
                                    modifier2 = companion;
                                    FontWeight fontWeight4 = fontWeight2;
                                    i33 = i25;
                                    fontWeight3 = fontWeight4;
                                    fontStyle3 = fontStyle2;
                                    j12 = j6;
                                    j13 = j8;
                                } else {
                                    startRestartGroup.skipToGroupEnd();
                                    modifier2 = modifier;
                                    j11 = j;
                                    j12 = j2;
                                    fontStyle3 = fontStyle;
                                    fontWeight3 = fontWeight;
                                    fontFamily3 = fontFamily;
                                    j13 = j3;
                                    textDecoration3 = textDecoration;
                                    textAlign3 = textAlign;
                                    j10 = j4;
                                    i33 = i;
                                    z3 = z;
                                    i31 = i2;
                                    i32 = i3;
                                    map3 = map;
                                    function13 = function1;
                                    textStyle3 = textStyle;
                                }
                                endRestartGroup = startRestartGroup.endRestartGroup();
                                if (endRestartGroup == null) {
                                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextKt$Text$5
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(2);
                                        }

                                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                            invoke((Composer) obj, ((Number) obj2).intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer2, int i42) {
                                            TextKt.m3200TextIbK3jfQ(annotatedString, modifier2, j11, j12, fontStyle3, fontWeight3, fontFamily3, j13, textDecoration3, textAlign3, j10, i33, z3, i31, i32, map3, function13, textStyle3, composer2, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), RecomposeScopeImplKt.updateChangedFlags(i5), i6);
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                        }
                        i23 = i6 & Fields.CompositingStrategy;
                        if (i23 == 0) {
                        }
                        i24 = i6 & 65536;
                        if (i24 == 0) {
                        }
                        if ((i5 & 12582912) == 0) {
                        }
                        if ((i7 & 306783379) == 306783378) {
                        }
                        startRestartGroup.startDefaults();
                        if ((i4 & 1) != 0) {
                        }
                        if (i34 == 0) {
                        }
                        if (i8 == 0) {
                        }
                        if (i9 == 0) {
                        }
                        if (i10 == 0) {
                        }
                        if (i11 == 0) {
                        }
                        if (i12 == 0) {
                        }
                        if (i13 == 0) {
                        }
                        if (i14 == 0) {
                        }
                        if (i15 == 0) {
                        }
                        if (i16 == 0) {
                        }
                        if (i18 == 0) {
                        }
                        if (i19 == 0) {
                        }
                        if (i20 == 0) {
                        }
                        if (i22 == 0) {
                        }
                        if (i23 == 0) {
                        }
                        if (i24 == 0) {
                        }
                        if ((i6 & Fields.RenderEffect) == 0) {
                        }
                        i26 = i37;
                        i27 = i39;
                        map2 = emptyMap;
                        function12 = textKt$Text$4;
                        j6 = j14;
                        j7 = j5;
                        i28 = i38;
                        z2 = z4;
                        j8 = j15;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        startRestartGroup.startReplaceableGroup(79588770);
                        ComposerKt.sourceInformation(startRestartGroup, "");
                        if (m4875getUnspecified0d7_KjU == Color.INSTANCE.m4875getUnspecified0d7_KjU()) {
                        }
                        startRestartGroup.endReplaceableGroup();
                        int i402 = (i7 & 112) | (i7 & 14) | ((i26 >> 9) & 7168);
                        int i412 = i26 << 9;
                        BasicTextKt.m1515BasicTextRWo7tUw(annotatedString, companion, TextStyle.merge-dA7vx0o$default(textStyle2, j9, j6, fontWeight2, fontStyle2, (FontSynthesis) null, fontFamily2, (String) null, j8, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, textDecoration2, (Shadow) null, (DrawStyle) null, textAlign2 == null ? textAlign2.unbox-impl() : TextAlign.Companion.getUnspecified-e0LSkKk(), 0, j7, (TextIndent) null, (LineHeightStyle) null, 0, 0, (PlatformTextStyle) null, (TextMotion) null, 16609104, (Object) null), function12, i25, z2, i30, i29, map2, (ColorProducer) null, startRestartGroup, i402 | (57344 & i412) | (458752 & i412) | (3670016 & i412) | (29360128 & i412) | (i412 & 234881024), Fields.RotationY);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        textDecoration3 = textDecoration2;
                        textAlign3 = textAlign2;
                        j10 = j7;
                        fontFamily3 = fontFamily2;
                        j11 = m4875getUnspecified0d7_KjU;
                        function13 = function12;
                        textStyle3 = textStyle2;
                        i31 = i30;
                        z3 = z2;
                        map3 = map2;
                        i32 = i29;
                        modifier2 = companion;
                        FontWeight fontWeight42 = fontWeight2;
                        i33 = i25;
                        fontWeight3 = fontWeight42;
                        fontStyle3 = fontStyle2;
                        j12 = j6;
                        j13 = j8;
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    i21 = i6 & Fields.Clip;
                    if (i21 != 0) {
                    }
                    i23 = i6 & Fields.CompositingStrategy;
                    if (i23 == 0) {
                    }
                    i24 = i6 & 65536;
                    if (i24 == 0) {
                    }
                    if ((i5 & 12582912) == 0) {
                    }
                    if ((i7 & 306783379) == 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i4 & 1) != 0) {
                    }
                    if (i34 == 0) {
                    }
                    if (i8 == 0) {
                    }
                    if (i9 == 0) {
                    }
                    if (i10 == 0) {
                    }
                    if (i11 == 0) {
                    }
                    if (i12 == 0) {
                    }
                    if (i13 == 0) {
                    }
                    if (i14 == 0) {
                    }
                    if (i15 == 0) {
                    }
                    if (i16 == 0) {
                    }
                    if (i18 == 0) {
                    }
                    if (i19 == 0) {
                    }
                    if (i20 == 0) {
                    }
                    if (i22 == 0) {
                    }
                    if (i23 == 0) {
                    }
                    if (i24 == 0) {
                    }
                    if ((i6 & Fields.RenderEffect) == 0) {
                    }
                    i26 = i37;
                    i27 = i39;
                    map2 = emptyMap;
                    function12 = textKt$Text$4;
                    j6 = j14;
                    j7 = j5;
                    i28 = i38;
                    z2 = z4;
                    j8 = j15;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    startRestartGroup.startReplaceableGroup(79588770);
                    ComposerKt.sourceInformation(startRestartGroup, "");
                    if (m4875getUnspecified0d7_KjU == Color.INSTANCE.m4875getUnspecified0d7_KjU()) {
                    }
                    startRestartGroup.endReplaceableGroup();
                    int i4022 = (i7 & 112) | (i7 & 14) | ((i26 >> 9) & 7168);
                    int i4122 = i26 << 9;
                    BasicTextKt.m1515BasicTextRWo7tUw(annotatedString, companion, TextStyle.merge-dA7vx0o$default(textStyle2, j9, j6, fontWeight2, fontStyle2, (FontSynthesis) null, fontFamily2, (String) null, j8, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, textDecoration2, (Shadow) null, (DrawStyle) null, textAlign2 == null ? textAlign2.unbox-impl() : TextAlign.Companion.getUnspecified-e0LSkKk(), 0, j7, (TextIndent) null, (LineHeightStyle) null, 0, 0, (PlatformTextStyle) null, (TextMotion) null, 16609104, (Object) null), function12, i25, z2, i30, i29, map2, (ColorProducer) null, startRestartGroup, i4022 | (57344 & i4122) | (458752 & i4122) | (3670016 & i4122) | (29360128 & i4122) | (i4122 & 234881024), Fields.RotationY);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    textDecoration3 = textDecoration2;
                    textAlign3 = textAlign2;
                    j10 = j7;
                    fontFamily3 = fontFamily2;
                    j11 = m4875getUnspecified0d7_KjU;
                    function13 = function12;
                    textStyle3 = textStyle2;
                    i31 = i30;
                    z3 = z2;
                    map3 = map2;
                    i32 = i29;
                    modifier2 = companion;
                    FontWeight fontWeight422 = fontWeight2;
                    i33 = i25;
                    fontWeight3 = fontWeight422;
                    fontStyle3 = fontStyle2;
                    j12 = j6;
                    j13 = j8;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                i20 = i6 & Fields.Shape;
                if (i20 == 0) {
                }
                i21 = i6 & Fields.Clip;
                if (i21 != 0) {
                }
                i23 = i6 & Fields.CompositingStrategy;
                if (i23 == 0) {
                }
                i24 = i6 & 65536;
                if (i24 == 0) {
                }
                if ((i5 & 12582912) == 0) {
                }
                if ((i7 & 306783379) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i4 & 1) != 0) {
                }
                if (i34 == 0) {
                }
                if (i8 == 0) {
                }
                if (i9 == 0) {
                }
                if (i10 == 0) {
                }
                if (i11 == 0) {
                }
                if (i12 == 0) {
                }
                if (i13 == 0) {
                }
                if (i14 == 0) {
                }
                if (i15 == 0) {
                }
                if (i16 == 0) {
                }
                if (i18 == 0) {
                }
                if (i19 == 0) {
                }
                if (i20 == 0) {
                }
                if (i22 == 0) {
                }
                if (i23 == 0) {
                }
                if (i24 == 0) {
                }
                if ((i6 & Fields.RenderEffect) == 0) {
                }
                i26 = i37;
                i27 = i39;
                map2 = emptyMap;
                function12 = textKt$Text$4;
                j6 = j14;
                j7 = j5;
                i28 = i38;
                z2 = z4;
                j8 = j15;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                startRestartGroup.startReplaceableGroup(79588770);
                ComposerKt.sourceInformation(startRestartGroup, "");
                if (m4875getUnspecified0d7_KjU == Color.INSTANCE.m4875getUnspecified0d7_KjU()) {
                }
                startRestartGroup.endReplaceableGroup();
                int i40222 = (i7 & 112) | (i7 & 14) | ((i26 >> 9) & 7168);
                int i41222 = i26 << 9;
                BasicTextKt.m1515BasicTextRWo7tUw(annotatedString, companion, TextStyle.merge-dA7vx0o$default(textStyle2, j9, j6, fontWeight2, fontStyle2, (FontSynthesis) null, fontFamily2, (String) null, j8, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, textDecoration2, (Shadow) null, (DrawStyle) null, textAlign2 == null ? textAlign2.unbox-impl() : TextAlign.Companion.getUnspecified-e0LSkKk(), 0, j7, (TextIndent) null, (LineHeightStyle) null, 0, 0, (PlatformTextStyle) null, (TextMotion) null, 16609104, (Object) null), function12, i25, z2, i30, i29, map2, (ColorProducer) null, startRestartGroup, i40222 | (57344 & i41222) | (458752 & i41222) | (3670016 & i41222) | (29360128 & i41222) | (i41222 & 234881024), Fields.RotationY);
                if (ComposerKt.isTraceInProgress()) {
                }
                textDecoration3 = textDecoration2;
                textAlign3 = textAlign2;
                j10 = j7;
                fontFamily3 = fontFamily2;
                j11 = m4875getUnspecified0d7_KjU;
                function13 = function12;
                textStyle3 = textStyle2;
                i31 = i30;
                z3 = z2;
                map3 = map2;
                i32 = i29;
                modifier2 = companion;
                FontWeight fontWeight4222 = fontWeight2;
                i33 = i25;
                fontWeight3 = fontWeight4222;
                fontStyle3 = fontStyle2;
                j12 = j6;
                j13 = j8;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            i11 = i6 & 32;
            if (i11 != 0) {
            }
            i12 = i6 & 64;
            if (i12 != 0) {
            }
            i13 = i6 & Fields.SpotShadowColor;
            if (i13 != 0) {
            }
            i14 = i6 & Fields.RotationX;
            if (i14 != 0) {
            }
            i15 = i6 & Fields.RotationY;
            if (i15 != 0) {
            }
            i16 = i6 & Fields.RotationZ;
            if (i16 != 0) {
            }
            i18 = i6 & Fields.CameraDistance;
            if (i18 != 0) {
            }
            int i372 = i17;
            i19 = i6 & Fields.TransformOrigin;
            if (i19 != 0) {
            }
            i20 = i6 & Fields.Shape;
            if (i20 == 0) {
            }
            i21 = i6 & Fields.Clip;
            if (i21 != 0) {
            }
            i23 = i6 & Fields.CompositingStrategy;
            if (i23 == 0) {
            }
            i24 = i6 & 65536;
            if (i24 == 0) {
            }
            if ((i5 & 12582912) == 0) {
            }
            if ((i7 & 306783379) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i4 & 1) != 0) {
            }
            if (i34 == 0) {
            }
            if (i8 == 0) {
            }
            if (i9 == 0) {
            }
            if (i10 == 0) {
            }
            if (i11 == 0) {
            }
            if (i12 == 0) {
            }
            if (i13 == 0) {
            }
            if (i14 == 0) {
            }
            if (i15 == 0) {
            }
            if (i16 == 0) {
            }
            if (i18 == 0) {
            }
            if (i19 == 0) {
            }
            if (i20 == 0) {
            }
            if (i22 == 0) {
            }
            if (i23 == 0) {
            }
            if (i24 == 0) {
            }
            if ((i6 & Fields.RenderEffect) == 0) {
            }
            i26 = i372;
            i27 = i39;
            map2 = emptyMap;
            function12 = textKt$Text$4;
            j6 = j14;
            j7 = j5;
            i28 = i38;
            z2 = z4;
            j8 = j15;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.startReplaceableGroup(79588770);
            ComposerKt.sourceInformation(startRestartGroup, "");
            if (m4875getUnspecified0d7_KjU == Color.INSTANCE.m4875getUnspecified0d7_KjU()) {
            }
            startRestartGroup.endReplaceableGroup();
            int i402222 = (i7 & 112) | (i7 & 14) | ((i26 >> 9) & 7168);
            int i412222 = i26 << 9;
            BasicTextKt.m1515BasicTextRWo7tUw(annotatedString, companion, TextStyle.merge-dA7vx0o$default(textStyle2, j9, j6, fontWeight2, fontStyle2, (FontSynthesis) null, fontFamily2, (String) null, j8, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, textDecoration2, (Shadow) null, (DrawStyle) null, textAlign2 == null ? textAlign2.unbox-impl() : TextAlign.Companion.getUnspecified-e0LSkKk(), 0, j7, (TextIndent) null, (LineHeightStyle) null, 0, 0, (PlatformTextStyle) null, (TextMotion) null, 16609104, (Object) null), function12, i25, z2, i30, i29, map2, (ColorProducer) null, startRestartGroup, i402222 | (57344 & i412222) | (458752 & i412222) | (3670016 & i412222) | (29360128 & i412222) | (i412222 & 234881024), Fields.RotationY);
            if (ComposerKt.isTraceInProgress()) {
            }
            textDecoration3 = textDecoration2;
            textAlign3 = textAlign2;
            j10 = j7;
            fontFamily3 = fontFamily2;
            j11 = m4875getUnspecified0d7_KjU;
            function13 = function12;
            textStyle3 = textStyle2;
            i31 = i30;
            z3 = z2;
            map3 = map2;
            i32 = i29;
            modifier2 = companion;
            FontWeight fontWeight42222 = fontWeight2;
            i33 = i25;
            fontWeight3 = fontWeight42222;
            fontStyle3 = fontStyle2;
            j12 = j6;
            j13 = j8;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        i8 = i6 & 4;
        if (i8 == 0) {
        }
        i9 = i6 & 8;
        int i352 = Fields.CameraDistance;
        if (i9 == 0) {
        }
        i10 = i6 & 16;
        int i362 = Fields.Clip;
        if (i10 == 0) {
        }
        i11 = i6 & 32;
        if (i11 != 0) {
        }
        i12 = i6 & 64;
        if (i12 != 0) {
        }
        i13 = i6 & Fields.SpotShadowColor;
        if (i13 != 0) {
        }
        i14 = i6 & Fields.RotationX;
        if (i14 != 0) {
        }
        i15 = i6 & Fields.RotationY;
        if (i15 != 0) {
        }
        i16 = i6 & Fields.RotationZ;
        if (i16 != 0) {
        }
        i18 = i6 & Fields.CameraDistance;
        if (i18 != 0) {
        }
        int i3722 = i17;
        i19 = i6 & Fields.TransformOrigin;
        if (i19 != 0) {
        }
        i20 = i6 & Fields.Shape;
        if (i20 == 0) {
        }
        i21 = i6 & Fields.Clip;
        if (i21 != 0) {
        }
        i23 = i6 & Fields.CompositingStrategy;
        if (i23 == 0) {
        }
        i24 = i6 & 65536;
        if (i24 == 0) {
        }
        if ((i5 & 12582912) == 0) {
        }
        if ((i7 & 306783379) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i4 & 1) != 0) {
        }
        if (i34 == 0) {
        }
        if (i8 == 0) {
        }
        if (i9 == 0) {
        }
        if (i10 == 0) {
        }
        if (i11 == 0) {
        }
        if (i12 == 0) {
        }
        if (i13 == 0) {
        }
        if (i14 == 0) {
        }
        if (i15 == 0) {
        }
        if (i16 == 0) {
        }
        if (i18 == 0) {
        }
        if (i19 == 0) {
        }
        if (i20 == 0) {
        }
        if (i22 == 0) {
        }
        if (i23 == 0) {
        }
        if (i24 == 0) {
        }
        if ((i6 & Fields.RenderEffect) == 0) {
        }
        i26 = i3722;
        i27 = i39;
        map2 = emptyMap;
        function12 = textKt$Text$4;
        j6 = j14;
        j7 = j5;
        i28 = i38;
        z2 = z4;
        j8 = j15;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        startRestartGroup.startReplaceableGroup(79588770);
        ComposerKt.sourceInformation(startRestartGroup, "");
        if (m4875getUnspecified0d7_KjU == Color.INSTANCE.m4875getUnspecified0d7_KjU()) {
        }
        startRestartGroup.endReplaceableGroup();
        int i4022222 = (i7 & 112) | (i7 & 14) | ((i26 >> 9) & 7168);
        int i4122222 = i26 << 9;
        BasicTextKt.m1515BasicTextRWo7tUw(annotatedString, companion, TextStyle.merge-dA7vx0o$default(textStyle2, j9, j6, fontWeight2, fontStyle2, (FontSynthesis) null, fontFamily2, (String) null, j8, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, textDecoration2, (Shadow) null, (DrawStyle) null, textAlign2 == null ? textAlign2.unbox-impl() : TextAlign.Companion.getUnspecified-e0LSkKk(), 0, j7, (TextIndent) null, (LineHeightStyle) null, 0, 0, (PlatformTextStyle) null, (TextMotion) null, 16609104, (Object) null), function12, i25, z2, i30, i29, map2, (ColorProducer) null, startRestartGroup, i4022222 | (57344 & i4122222) | (458752 & i4122222) | (3670016 & i4122222) | (29360128 & i4122222) | (i4122222 & 234881024), Fields.RotationY);
        if (ComposerKt.isTraceInProgress()) {
        }
        textDecoration3 = textDecoration2;
        textAlign3 = textAlign2;
        j10 = j7;
        fontFamily3 = fontFamily2;
        j11 = m4875getUnspecified0d7_KjU;
        function13 = function12;
        textStyle3 = textStyle2;
        i31 = i30;
        z3 = z2;
        map3 = map2;
        i32 = i29;
        modifier2 = companion;
        FontWeight fontWeight422222 = fontWeight2;
        i33 = i25;
        fontWeight3 = fontWeight422222;
        fontStyle3 = fontStyle2;
        j12 = j6;
        j13 = j8;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x02af  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x02b6  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x02bd  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x02c4  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x02d6  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x02da  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x02e5  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x02f0  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x02f6  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x02fe  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0307  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0312  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0336  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x030c  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0303  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x02fa  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x02f2  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x02ec  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x02e1  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x02d1  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x02cb  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x02c0  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x02b9  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x02b2  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x02aa  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x029f  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0294  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0405  */
    /* JADX WARN: Removed duplicated region for block: B:75:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0258  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x035e  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x03dd  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0369  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x028f  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0298  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x02a3  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with minLines instead")
    /* renamed from: Text--4IGK_g, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void m3198Text4IGK_g(final AnnotatedString annotatedString, Modifier modifier, long j, long j2, FontStyle fontStyle, FontWeight fontWeight, FontFamily fontFamily, long j3, TextDecoration textDecoration, TextAlign textAlign, long j4, int i, boolean z, int i2, Map map, Function1 function1, TextStyle textStyle, Composer composer, final int i3, final int i4, final int i5) {
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        Modifier.Companion companion;
        long m4875getUnspecified0d7_KjU;
        TextAlign textAlign2;
        TextDecoration textDecoration2;
        long j5;
        TextStyle textStyle2;
        int i23;
        boolean z2;
        int i24;
        int i25;
        Map map2;
        Function1 function12;
        FontStyle fontStyle2;
        long j6;
        FontWeight fontWeight2;
        FontFamily fontFamily2;
        long j7;
        final TextDecoration textDecoration3;
        Composer composer2;
        final TextAlign textAlign3;
        final long j8;
        final int i26;
        final boolean z3;
        final int i27;
        final Map map3;
        final Function1 function13;
        final TextStyle textStyle3;
        final FontStyle fontStyle3;
        final FontWeight fontWeight3;
        final FontFamily fontFamily3;
        final Modifier modifier2;
        final long j9;
        final long j10;
        final long j11;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(224529679);
        ComposerKt.sourceInformation(startRestartGroup, "C(Text)P(14,9,0:c#ui.graphics.Color,2:c#ui.unit.TextUnit,3:c#ui.text.font.FontStyle,4!1,6:c#ui.unit.TextUnit,16,15:c#ui.text.style.TextAlign,7:c#ui.unit.TextUnit,11:c#ui.text.style.TextOverflow,12,8)307@13179L7,309@13195L345:Text.kt#uh7d8r");
        if ((i5 & 1) != 0) {
            i6 = i3 | 6;
        } else if ((i3 & 6) == 0) {
            i6 = (startRestartGroup.changed(annotatedString) ? 4 : 2) | i3;
        } else {
            i6 = i3;
        }
        int i28 = i5 & 2;
        if (i28 != 0) {
            i6 |= 48;
        } else if ((i3 & 48) == 0) {
            i6 |= startRestartGroup.changed(modifier) ? 32 : 16;
            i7 = i5 & 4;
            if (i7 == 0) {
                i6 |= 384;
            } else if ((i3 & 384) == 0) {
                i6 |= startRestartGroup.changed(j) ? Fields.RotationX : Fields.SpotShadowColor;
            }
            i8 = i5 & 8;
            int i29 = Fields.CameraDistance;
            if (i8 == 0) {
                i6 |= 3072;
            } else if ((i3 & 3072) == 0) {
                i6 |= startRestartGroup.changed(j2) ? 2048 : 1024;
            }
            i9 = i5 & 16;
            int i30 = Fields.Clip;
            if (i9 == 0) {
                i6 |= 24576;
            } else if ((i3 & 24576) == 0) {
                i6 |= startRestartGroup.changed(fontStyle) ? 16384 : 8192;
                i10 = i5 & 32;
                int i31 = Fields.RenderEffect;
                if (i10 != 0) {
                    i6 |= 196608;
                } else if ((i3 & 196608) == 0) {
                    i6 |= startRestartGroup.changed(fontWeight) ? 131072 : 65536;
                }
                i11 = i5 & 64;
                if (i11 != 0) {
                    i6 |= 1572864;
                } else if ((i3 & 1572864) == 0) {
                    i6 |= startRestartGroup.changed(fontFamily) ? 1048576 : Fields.BlendMode;
                }
                i12 = i5 & Fields.SpotShadowColor;
                if (i12 != 0) {
                    i6 |= 12582912;
                } else if ((i3 & 12582912) == 0) {
                    i6 |= startRestartGroup.changed(j3) ? 8388608 : 4194304;
                }
                i13 = i5 & Fields.RotationX;
                if (i13 != 0) {
                    i6 |= 100663296;
                } else if ((100663296 & i3) == 0) {
                    i6 |= startRestartGroup.changed(textDecoration) ? 67108864 : 33554432;
                    i14 = i5 & Fields.RotationY;
                    if (i14 == 0) {
                        i6 |= 805306368;
                    } else if ((i3 & 805306368) == 0) {
                        i6 |= startRestartGroup.changed(textAlign) ? 536870912 : 268435456;
                    }
                    i15 = i5 & Fields.RotationZ;
                    if (i15 == 0) {
                        i16 = i4 | 6;
                    } else if ((i4 & 6) == 0) {
                        i16 = i4 | (startRestartGroup.changed(j4) ? 4 : 2);
                    } else {
                        i16 = i4;
                    }
                    i17 = i5 & Fields.CameraDistance;
                    if (i17 == 0) {
                        i16 |= 48;
                    } else if ((i4 & 48) == 0) {
                        i16 |= startRestartGroup.changed(i) ? 32 : 16;
                    }
                    int i32 = i16;
                    i18 = i5 & Fields.TransformOrigin;
                    if (i18 == 0) {
                        i32 |= 384;
                    } else if ((i4 & 384) == 0) {
                        i32 |= startRestartGroup.changed(z) ? Fields.RotationX : Fields.SpotShadowColor;
                        i19 = i5 & Fields.Shape;
                        if (i19 != 0) {
                            i32 |= 3072;
                        } else if ((i4 & 3072) == 0) {
                            if (!startRestartGroup.changed(i2)) {
                                i29 = 1024;
                            }
                            i32 |= i29;
                            i20 = i5 & Fields.Clip;
                            if (i20 == 0) {
                                i32 |= 24576;
                                i21 = i20;
                            } else {
                                i21 = i20;
                                if ((i4 & 24576) == 0) {
                                    if (!startRestartGroup.changedInstance(map)) {
                                        i30 = 8192;
                                    }
                                    i32 |= i30;
                                    i22 = i5 & Fields.CompositingStrategy;
                                    if (i22 != 0) {
                                        i32 |= 196608;
                                    } else if ((i4 & 196608) == 0) {
                                        if (!startRestartGroup.changedInstance(function1)) {
                                            i31 = 65536;
                                        }
                                        i32 |= i31;
                                    }
                                    if ((i4 & 1572864) == 0) {
                                        i32 |= ((i5 & 65536) == 0 && startRestartGroup.changed(textStyle)) ? 1048576 : Fields.BlendMode;
                                    }
                                    if ((i6 & 306783379) == 306783378 || (599187 & i32) != 599186 || !startRestartGroup.getSkipping()) {
                                        startRestartGroup.startDefaults();
                                        if ((i3 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                            companion = i28 != 0 ? Modifier.INSTANCE : modifier;
                                            m4875getUnspecified0d7_KjU = i7 != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j;
                                            long j12 = i8 != 0 ? TextUnit.Companion.getUnspecified-XSAIIZE() : j2;
                                            FontStyle fontStyle4 = i9 != 0 ? null : fontStyle;
                                            FontWeight fontWeight4 = i10 != 0 ? null : fontWeight;
                                            FontFamily fontFamily4 = i11 != 0 ? null : fontFamily;
                                            long j13 = i12 != 0 ? TextUnit.Companion.getUnspecified-XSAIIZE() : j3;
                                            TextDecoration textDecoration4 = i13 != 0 ? null : textDecoration;
                                            textAlign2 = i14 == 0 ? textAlign : null;
                                            long j14 = i15 != 0 ? TextUnit.Companion.getUnspecified-XSAIIZE() : j4;
                                            int i33 = i17 != 0 ? TextOverflow.Companion.getClip-gIe3tQ8() : i;
                                            boolean z4 = i18 != 0 ? true : z;
                                            int i34 = i19 != 0 ? Integer.MAX_VALUE : i2;
                                            Map emptyMap = i21 != 0 ? MapsKt.emptyMap() : map;
                                            TextKt$Text$6 textKt$Text$6 = i22 != 0 ? new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material3.TextKt$Text$6
                                                public final void invoke(TextLayoutResult textLayoutResult) {
                                                }

                                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                                    invoke((TextLayoutResult) obj);
                                                    return Unit.INSTANCE;
                                                }
                                            } : function1;
                                            if ((i5 & 65536) != 0) {
                                                textDecoration2 = textDecoration4;
                                                ProvidableCompositionLocal<TextStyle> providableCompositionLocal = LocalTextStyle;
                                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                                Object consume = startRestartGroup.consume(providableCompositionLocal);
                                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                i32 &= -3670017;
                                                j5 = j14;
                                                textStyle2 = (TextStyle) consume;
                                            } else {
                                                textDecoration2 = textDecoration4;
                                                j5 = j14;
                                                textStyle2 = textStyle;
                                            }
                                            i23 = i33;
                                            z2 = z4;
                                            i24 = i32;
                                            i25 = i34;
                                            map2 = emptyMap;
                                            function12 = textKt$Text$6;
                                            fontStyle2 = fontStyle4;
                                            j6 = j12;
                                            fontWeight2 = fontWeight4;
                                            fontFamily2 = fontFamily4;
                                            j7 = j13;
                                            textDecoration3 = textDecoration2;
                                        } else {
                                            startRestartGroup.skipToGroupEnd();
                                            if ((i5 & 65536) != 0) {
                                                i32 &= -3670017;
                                            }
                                            companion = modifier;
                                            m4875getUnspecified0d7_KjU = j;
                                            j6 = j2;
                                            fontStyle2 = fontStyle;
                                            fontWeight2 = fontWeight;
                                            fontFamily2 = fontFamily;
                                            textDecoration3 = textDecoration;
                                            textAlign2 = textAlign;
                                            j5 = j4;
                                            i23 = i;
                                            z2 = z;
                                            i25 = i2;
                                            map2 = map;
                                            function12 = function1;
                                            textStyle2 = textStyle;
                                            i24 = i32;
                                            j7 = j3;
                                        }
                                        startRestartGroup.endDefaults();
                                        if (ComposerKt.isTraceInProgress()) {
                                            composer2 = startRestartGroup;
                                            ComposerKt.traceEventStart(224529679, i6, i24, "androidx.compose.material3.Text (Text.kt:308)");
                                        } else {
                                            composer2 = startRestartGroup;
                                        }
                                        int i35 = i24 << 3;
                                        m3200TextIbK3jfQ(annotatedString, companion, m4875getUnspecified0d7_KjU, j6, fontStyle2, fontWeight2, fontFamily2, j7, textDecoration3, textAlign2, j5, i23, z2, i25, 1, map2, function12, textStyle2, composer2, (i6 & 14) | (i6 & 112) | (i6 & 896) | (i6 & 7168) | (57344 & i6) | (458752 & i6) | (3670016 & i6) | (29360128 & i6) | (234881024 & i6) | (i6 & 1879048192), (i24 & 14) | 24576 | (i24 & 112) | (i24 & 896) | (i24 & 7168) | (458752 & i35) | (3670016 & i35) | (i35 & 29360128), 0);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                        textAlign3 = textAlign2;
                                        j8 = j5;
                                        i26 = i23;
                                        z3 = z2;
                                        i27 = i25;
                                        map3 = map2;
                                        function13 = function12;
                                        textStyle3 = textStyle2;
                                        FontFamily fontFamily5 = fontFamily2;
                                        fontStyle3 = fontStyle2;
                                        long j15 = j7;
                                        fontWeight3 = fontWeight2;
                                        fontFamily3 = fontFamily5;
                                        long j16 = j6;
                                        modifier2 = companion;
                                        j9 = j16;
                                        j10 = m4875getUnspecified0d7_KjU;
                                        j11 = j15;
                                    } else {
                                        startRestartGroup.skipToGroupEnd();
                                        modifier2 = modifier;
                                        j10 = j;
                                        j9 = j2;
                                        fontStyle3 = fontStyle;
                                        fontWeight3 = fontWeight;
                                        fontFamily3 = fontFamily;
                                        j11 = j3;
                                        textDecoration3 = textDecoration;
                                        textAlign3 = textAlign;
                                        j8 = j4;
                                        i26 = i;
                                        z3 = z;
                                        i27 = i2;
                                        map3 = map;
                                        function13 = function1;
                                        textStyle3 = textStyle;
                                        composer2 = startRestartGroup;
                                    }
                                    endRestartGroup = composer2.endRestartGroup();
                                    if (endRestartGroup != null) {
                                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextKt$Text$7
                                            /* JADX INFO: Access modifiers changed from: package-private */
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(2);
                                            }

                                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                                invoke((Composer) obj, ((Number) obj2).intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer composer3, int i36) {
                                                TextKt.m3198Text4IGK_g(annotatedString, modifier2, j10, j9, fontStyle3, fontWeight3, fontFamily3, j11, textDecoration3, textAlign3, j8, i26, z3, i27, map3, function13, textStyle3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                                            }
                                        });
                                        return;
                                    }
                                    return;
                                }
                            }
                            i22 = i5 & Fields.CompositingStrategy;
                            if (i22 != 0) {
                            }
                            if ((i4 & 1572864) == 0) {
                            }
                            if ((i6 & 306783379) == 306783378) {
                            }
                            startRestartGroup.startDefaults();
                            if ((i3 & 1) != 0) {
                            }
                            if (i28 != 0) {
                            }
                            if (i7 != 0) {
                            }
                            if (i8 != 0) {
                            }
                            if (i9 != 0) {
                            }
                            if (i10 != 0) {
                            }
                            if (i11 != 0) {
                            }
                            if (i12 != 0) {
                            }
                            if (i13 != 0) {
                            }
                            if (i14 == 0) {
                            }
                            if (i15 != 0) {
                            }
                            if (i17 != 0) {
                            }
                            if (i18 != 0) {
                            }
                            if (i19 != 0) {
                            }
                            if (i21 != 0) {
                            }
                            if (i22 != 0) {
                            }
                            if ((i5 & 65536) != 0) {
                            }
                            i23 = i33;
                            z2 = z4;
                            i24 = i32;
                            i25 = i34;
                            map2 = emptyMap;
                            function12 = textKt$Text$6;
                            fontStyle2 = fontStyle4;
                            j6 = j12;
                            fontWeight2 = fontWeight4;
                            fontFamily2 = fontFamily4;
                            j7 = j13;
                            textDecoration3 = textDecoration2;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            int i352 = i24 << 3;
                            m3200TextIbK3jfQ(annotatedString, companion, m4875getUnspecified0d7_KjU, j6, fontStyle2, fontWeight2, fontFamily2, j7, textDecoration3, textAlign2, j5, i23, z2, i25, 1, map2, function12, textStyle2, composer2, (i6 & 14) | (i6 & 112) | (i6 & 896) | (i6 & 7168) | (57344 & i6) | (458752 & i6) | (3670016 & i6) | (29360128 & i6) | (234881024 & i6) | (i6 & 1879048192), (i24 & 14) | 24576 | (i24 & 112) | (i24 & 896) | (i24 & 7168) | (458752 & i352) | (3670016 & i352) | (i352 & 29360128), 0);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            textAlign3 = textAlign2;
                            j8 = j5;
                            i26 = i23;
                            z3 = z2;
                            i27 = i25;
                            map3 = map2;
                            function13 = function12;
                            textStyle3 = textStyle2;
                            FontFamily fontFamily52 = fontFamily2;
                            fontStyle3 = fontStyle2;
                            long j152 = j7;
                            fontWeight3 = fontWeight2;
                            fontFamily3 = fontFamily52;
                            long j162 = j6;
                            modifier2 = companion;
                            j9 = j162;
                            j10 = m4875getUnspecified0d7_KjU;
                            j11 = j152;
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup != null) {
                            }
                        }
                        i20 = i5 & Fields.Clip;
                        if (i20 == 0) {
                        }
                        i22 = i5 & Fields.CompositingStrategy;
                        if (i22 != 0) {
                        }
                        if ((i4 & 1572864) == 0) {
                        }
                        if ((i6 & 306783379) == 306783378) {
                        }
                        startRestartGroup.startDefaults();
                        if ((i3 & 1) != 0) {
                        }
                        if (i28 != 0) {
                        }
                        if (i7 != 0) {
                        }
                        if (i8 != 0) {
                        }
                        if (i9 != 0) {
                        }
                        if (i10 != 0) {
                        }
                        if (i11 != 0) {
                        }
                        if (i12 != 0) {
                        }
                        if (i13 != 0) {
                        }
                        if (i14 == 0) {
                        }
                        if (i15 != 0) {
                        }
                        if (i17 != 0) {
                        }
                        if (i18 != 0) {
                        }
                        if (i19 != 0) {
                        }
                        if (i21 != 0) {
                        }
                        if (i22 != 0) {
                        }
                        if ((i5 & 65536) != 0) {
                        }
                        i23 = i33;
                        z2 = z4;
                        i24 = i32;
                        i25 = i34;
                        map2 = emptyMap;
                        function12 = textKt$Text$6;
                        fontStyle2 = fontStyle4;
                        j6 = j12;
                        fontWeight2 = fontWeight4;
                        fontFamily2 = fontFamily4;
                        j7 = j13;
                        textDecoration3 = textDecoration2;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        int i3522 = i24 << 3;
                        m3200TextIbK3jfQ(annotatedString, companion, m4875getUnspecified0d7_KjU, j6, fontStyle2, fontWeight2, fontFamily2, j7, textDecoration3, textAlign2, j5, i23, z2, i25, 1, map2, function12, textStyle2, composer2, (i6 & 14) | (i6 & 112) | (i6 & 896) | (i6 & 7168) | (57344 & i6) | (458752 & i6) | (3670016 & i6) | (29360128 & i6) | (234881024 & i6) | (i6 & 1879048192), (i24 & 14) | 24576 | (i24 & 112) | (i24 & 896) | (i24 & 7168) | (458752 & i3522) | (3670016 & i3522) | (i3522 & 29360128), 0);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        textAlign3 = textAlign2;
                        j8 = j5;
                        i26 = i23;
                        z3 = z2;
                        i27 = i25;
                        map3 = map2;
                        function13 = function12;
                        textStyle3 = textStyle2;
                        FontFamily fontFamily522 = fontFamily2;
                        fontStyle3 = fontStyle2;
                        long j1522 = j7;
                        fontWeight3 = fontWeight2;
                        fontFamily3 = fontFamily522;
                        long j1622 = j6;
                        modifier2 = companion;
                        j9 = j1622;
                        j10 = m4875getUnspecified0d7_KjU;
                        j11 = j1522;
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                        }
                    }
                    i19 = i5 & Fields.Shape;
                    if (i19 != 0) {
                    }
                    i20 = i5 & Fields.Clip;
                    if (i20 == 0) {
                    }
                    i22 = i5 & Fields.CompositingStrategy;
                    if (i22 != 0) {
                    }
                    if ((i4 & 1572864) == 0) {
                    }
                    if ((i6 & 306783379) == 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i3 & 1) != 0) {
                    }
                    if (i28 != 0) {
                    }
                    if (i7 != 0) {
                    }
                    if (i8 != 0) {
                    }
                    if (i9 != 0) {
                    }
                    if (i10 != 0) {
                    }
                    if (i11 != 0) {
                    }
                    if (i12 != 0) {
                    }
                    if (i13 != 0) {
                    }
                    if (i14 == 0) {
                    }
                    if (i15 != 0) {
                    }
                    if (i17 != 0) {
                    }
                    if (i18 != 0) {
                    }
                    if (i19 != 0) {
                    }
                    if (i21 != 0) {
                    }
                    if (i22 != 0) {
                    }
                    if ((i5 & 65536) != 0) {
                    }
                    i23 = i33;
                    z2 = z4;
                    i24 = i32;
                    i25 = i34;
                    map2 = emptyMap;
                    function12 = textKt$Text$6;
                    fontStyle2 = fontStyle4;
                    j6 = j12;
                    fontWeight2 = fontWeight4;
                    fontFamily2 = fontFamily4;
                    j7 = j13;
                    textDecoration3 = textDecoration2;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    int i35222 = i24 << 3;
                    m3200TextIbK3jfQ(annotatedString, companion, m4875getUnspecified0d7_KjU, j6, fontStyle2, fontWeight2, fontFamily2, j7, textDecoration3, textAlign2, j5, i23, z2, i25, 1, map2, function12, textStyle2, composer2, (i6 & 14) | (i6 & 112) | (i6 & 896) | (i6 & 7168) | (57344 & i6) | (458752 & i6) | (3670016 & i6) | (29360128 & i6) | (234881024 & i6) | (i6 & 1879048192), (i24 & 14) | 24576 | (i24 & 112) | (i24 & 896) | (i24 & 7168) | (458752 & i35222) | (3670016 & i35222) | (i35222 & 29360128), 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    textAlign3 = textAlign2;
                    j8 = j5;
                    i26 = i23;
                    z3 = z2;
                    i27 = i25;
                    map3 = map2;
                    function13 = function12;
                    textStyle3 = textStyle2;
                    FontFamily fontFamily5222 = fontFamily2;
                    fontStyle3 = fontStyle2;
                    long j15222 = j7;
                    fontWeight3 = fontWeight2;
                    fontFamily3 = fontFamily5222;
                    long j16222 = j6;
                    modifier2 = companion;
                    j9 = j16222;
                    j10 = m4875getUnspecified0d7_KjU;
                    j11 = j15222;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                i14 = i5 & Fields.RotationY;
                if (i14 == 0) {
                }
                i15 = i5 & Fields.RotationZ;
                if (i15 == 0) {
                }
                i17 = i5 & Fields.CameraDistance;
                if (i17 == 0) {
                }
                int i322 = i16;
                i18 = i5 & Fields.TransformOrigin;
                if (i18 == 0) {
                }
                i19 = i5 & Fields.Shape;
                if (i19 != 0) {
                }
                i20 = i5 & Fields.Clip;
                if (i20 == 0) {
                }
                i22 = i5 & Fields.CompositingStrategy;
                if (i22 != 0) {
                }
                if ((i4 & 1572864) == 0) {
                }
                if ((i6 & 306783379) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i3 & 1) != 0) {
                }
                if (i28 != 0) {
                }
                if (i7 != 0) {
                }
                if (i8 != 0) {
                }
                if (i9 != 0) {
                }
                if (i10 != 0) {
                }
                if (i11 != 0) {
                }
                if (i12 != 0) {
                }
                if (i13 != 0) {
                }
                if (i14 == 0) {
                }
                if (i15 != 0) {
                }
                if (i17 != 0) {
                }
                if (i18 != 0) {
                }
                if (i19 != 0) {
                }
                if (i21 != 0) {
                }
                if (i22 != 0) {
                }
                if ((i5 & 65536) != 0) {
                }
                i23 = i33;
                z2 = z4;
                i24 = i322;
                i25 = i34;
                map2 = emptyMap;
                function12 = textKt$Text$6;
                fontStyle2 = fontStyle4;
                j6 = j12;
                fontWeight2 = fontWeight4;
                fontFamily2 = fontFamily4;
                j7 = j13;
                textDecoration3 = textDecoration2;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                int i352222 = i24 << 3;
                m3200TextIbK3jfQ(annotatedString, companion, m4875getUnspecified0d7_KjU, j6, fontStyle2, fontWeight2, fontFamily2, j7, textDecoration3, textAlign2, j5, i23, z2, i25, 1, map2, function12, textStyle2, composer2, (i6 & 14) | (i6 & 112) | (i6 & 896) | (i6 & 7168) | (57344 & i6) | (458752 & i6) | (3670016 & i6) | (29360128 & i6) | (234881024 & i6) | (i6 & 1879048192), (i24 & 14) | 24576 | (i24 & 112) | (i24 & 896) | (i24 & 7168) | (458752 & i352222) | (3670016 & i352222) | (i352222 & 29360128), 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                textAlign3 = textAlign2;
                j8 = j5;
                i26 = i23;
                z3 = z2;
                i27 = i25;
                map3 = map2;
                function13 = function12;
                textStyle3 = textStyle2;
                FontFamily fontFamily52222 = fontFamily2;
                fontStyle3 = fontStyle2;
                long j152222 = j7;
                fontWeight3 = fontWeight2;
                fontFamily3 = fontFamily52222;
                long j162222 = j6;
                modifier2 = companion;
                j9 = j162222;
                j10 = m4875getUnspecified0d7_KjU;
                j11 = j152222;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            i10 = i5 & 32;
            int i312 = Fields.RenderEffect;
            if (i10 != 0) {
            }
            i11 = i5 & 64;
            if (i11 != 0) {
            }
            i12 = i5 & Fields.SpotShadowColor;
            if (i12 != 0) {
            }
            i13 = i5 & Fields.RotationX;
            if (i13 != 0) {
            }
            i14 = i5 & Fields.RotationY;
            if (i14 == 0) {
            }
            i15 = i5 & Fields.RotationZ;
            if (i15 == 0) {
            }
            i17 = i5 & Fields.CameraDistance;
            if (i17 == 0) {
            }
            int i3222 = i16;
            i18 = i5 & Fields.TransformOrigin;
            if (i18 == 0) {
            }
            i19 = i5 & Fields.Shape;
            if (i19 != 0) {
            }
            i20 = i5 & Fields.Clip;
            if (i20 == 0) {
            }
            i22 = i5 & Fields.CompositingStrategy;
            if (i22 != 0) {
            }
            if ((i4 & 1572864) == 0) {
            }
            if ((i6 & 306783379) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i3 & 1) != 0) {
            }
            if (i28 != 0) {
            }
            if (i7 != 0) {
            }
            if (i8 != 0) {
            }
            if (i9 != 0) {
            }
            if (i10 != 0) {
            }
            if (i11 != 0) {
            }
            if (i12 != 0) {
            }
            if (i13 != 0) {
            }
            if (i14 == 0) {
            }
            if (i15 != 0) {
            }
            if (i17 != 0) {
            }
            if (i18 != 0) {
            }
            if (i19 != 0) {
            }
            if (i21 != 0) {
            }
            if (i22 != 0) {
            }
            if ((i5 & 65536) != 0) {
            }
            i23 = i33;
            z2 = z4;
            i24 = i3222;
            i25 = i34;
            map2 = emptyMap;
            function12 = textKt$Text$6;
            fontStyle2 = fontStyle4;
            j6 = j12;
            fontWeight2 = fontWeight4;
            fontFamily2 = fontFamily4;
            j7 = j13;
            textDecoration3 = textDecoration2;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            int i3522222 = i24 << 3;
            m3200TextIbK3jfQ(annotatedString, companion, m4875getUnspecified0d7_KjU, j6, fontStyle2, fontWeight2, fontFamily2, j7, textDecoration3, textAlign2, j5, i23, z2, i25, 1, map2, function12, textStyle2, composer2, (i6 & 14) | (i6 & 112) | (i6 & 896) | (i6 & 7168) | (57344 & i6) | (458752 & i6) | (3670016 & i6) | (29360128 & i6) | (234881024 & i6) | (i6 & 1879048192), (i24 & 14) | 24576 | (i24 & 112) | (i24 & 896) | (i24 & 7168) | (458752 & i3522222) | (3670016 & i3522222) | (i3522222 & 29360128), 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            textAlign3 = textAlign2;
            j8 = j5;
            i26 = i23;
            z3 = z2;
            i27 = i25;
            map3 = map2;
            function13 = function12;
            textStyle3 = textStyle2;
            FontFamily fontFamily522222 = fontFamily2;
            fontStyle3 = fontStyle2;
            long j1522222 = j7;
            fontWeight3 = fontWeight2;
            fontFamily3 = fontFamily522222;
            long j1622222 = j6;
            modifier2 = companion;
            j9 = j1622222;
            j10 = m4875getUnspecified0d7_KjU;
            j11 = j1522222;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        i7 = i5 & 4;
        if (i7 == 0) {
        }
        i8 = i5 & 8;
        int i292 = Fields.CameraDistance;
        if (i8 == 0) {
        }
        i9 = i5 & 16;
        int i302 = Fields.Clip;
        if (i9 == 0) {
        }
        i10 = i5 & 32;
        int i3122 = Fields.RenderEffect;
        if (i10 != 0) {
        }
        i11 = i5 & 64;
        if (i11 != 0) {
        }
        i12 = i5 & Fields.SpotShadowColor;
        if (i12 != 0) {
        }
        i13 = i5 & Fields.RotationX;
        if (i13 != 0) {
        }
        i14 = i5 & Fields.RotationY;
        if (i14 == 0) {
        }
        i15 = i5 & Fields.RotationZ;
        if (i15 == 0) {
        }
        i17 = i5 & Fields.CameraDistance;
        if (i17 == 0) {
        }
        int i32222 = i16;
        i18 = i5 & Fields.TransformOrigin;
        if (i18 == 0) {
        }
        i19 = i5 & Fields.Shape;
        if (i19 != 0) {
        }
        i20 = i5 & Fields.Clip;
        if (i20 == 0) {
        }
        i22 = i5 & Fields.CompositingStrategy;
        if (i22 != 0) {
        }
        if ((i4 & 1572864) == 0) {
        }
        if ((i6 & 306783379) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i3 & 1) != 0) {
        }
        if (i28 != 0) {
        }
        if (i7 != 0) {
        }
        if (i8 != 0) {
        }
        if (i9 != 0) {
        }
        if (i10 != 0) {
        }
        if (i11 != 0) {
        }
        if (i12 != 0) {
        }
        if (i13 != 0) {
        }
        if (i14 == 0) {
        }
        if (i15 != 0) {
        }
        if (i17 != 0) {
        }
        if (i18 != 0) {
        }
        if (i19 != 0) {
        }
        if (i21 != 0) {
        }
        if (i22 != 0) {
        }
        if ((i5 & 65536) != 0) {
        }
        i23 = i33;
        z2 = z4;
        i24 = i32222;
        i25 = i34;
        map2 = emptyMap;
        function12 = textKt$Text$6;
        fontStyle2 = fontStyle4;
        j6 = j12;
        fontWeight2 = fontWeight4;
        fontFamily2 = fontFamily4;
        j7 = j13;
        textDecoration3 = textDecoration2;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        int i35222222 = i24 << 3;
        m3200TextIbK3jfQ(annotatedString, companion, m4875getUnspecified0d7_KjU, j6, fontStyle2, fontWeight2, fontFamily2, j7, textDecoration3, textAlign2, j5, i23, z2, i25, 1, map2, function12, textStyle2, composer2, (i6 & 14) | (i6 & 112) | (i6 & 896) | (i6 & 7168) | (57344 & i6) | (458752 & i6) | (3670016 & i6) | (29360128 & i6) | (234881024 & i6) | (i6 & 1879048192), (i24 & 14) | 24576 | (i24 & 112) | (i24 & 896) | (i24 & 7168) | (458752 & i35222222) | (3670016 & i35222222) | (i35222222 & 29360128), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        textAlign3 = textAlign2;
        j8 = j5;
        i26 = i23;
        z3 = z2;
        i27 = i25;
        map3 = map2;
        function13 = function12;
        textStyle3 = textStyle2;
        FontFamily fontFamily5222222 = fontFamily2;
        fontStyle3 = fontStyle2;
        long j15222222 = j7;
        fontWeight3 = fontWeight2;
        fontFamily3 = fontFamily5222222;
        long j16222222 = j6;
        modifier2 = companion;
        j9 = j16222222;
        j10 = m4875getUnspecified0d7_KjU;
        j11 = j15222222;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    public static final ProvidableCompositionLocal<TextStyle> getLocalTextStyle() {
        return LocalTextStyle;
    }

    public static final void ProvideTextStyle(final TextStyle textStyle, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(-460300127);
        ComposerKt.sourceInformation(startRestartGroup, "C(ProvideTextStyle)P(1)350@14496L7,351@14521L80:Text.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(textStyle) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if ((i2 & 19) != 18 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-460300127, i2, -1, "androidx.compose.material3.ProvideTextStyle (Text.kt:349)");
            }
            ProvidableCompositionLocal<TextStyle> providableCompositionLocal = LocalTextStyle;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(providableCompositionLocal);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>) providableCompositionLocal.provides(((TextStyle) consume).merge(textStyle)), function2, startRestartGroup, (i2 & 112) | ProvidedValue.$stable | 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextKt$ProvideTextStyle$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    TextKt.ProvideTextStyle(textStyle, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }
}
