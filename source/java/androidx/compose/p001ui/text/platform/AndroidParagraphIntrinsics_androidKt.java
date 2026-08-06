package androidx.compose.p001ui.text.platform;

import androidx.compose.p001ui.text.AnnotatedString;
import androidx.compose.p001ui.text.EmojiSupportMatch;
import androidx.compose.p001ui.text.ParagraphIntrinsics;
import androidx.compose.p001ui.text.Placeholder;
import androidx.compose.p001ui.text.PlatformParagraphStyle;
import androidx.compose.p001ui.text.PlatformTextStyle;
import androidx.compose.p001ui.text.TextStyle;
import androidx.compose.p001ui.text.font.FontFamily;
import androidx.compose.p001ui.text.intl.LocaleList;
import androidx.compose.p001ui.text.style.TextDirection;
import androidx.compose.p001ui.unit.Density;
import androidx.core.text.TextUtilsCompat;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;

/* compiled from: AndroidParagraphIntrinsics.android.kt */
@Metadata(d1 = {"\u0000P\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a#\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001aR\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0014\u0010\u000e\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00110\u00100\u000f2\u0012\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00100\u000f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0000\"\u0018\u0010\u0018\u001a\u00020\u0019*\u00020\r8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"resolveTextDirectionHeuristics", "", "textDirection", "Landroidx/compose/ui/text/style/TextDirection;", "localeList", "Landroidx/compose/ui/text/intl/LocaleList;", "resolveTextDirectionHeuristics-HklW4sA", "(ILandroidx/compose/ui/text/intl/LocaleList;)I", "ActualParagraphIntrinsics", "Landroidx/compose/ui/text/ParagraphIntrinsics;", StrategyConstants.TEXT, "", "style", "Landroidx/compose/ui/text/TextStyle;", "annotations", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/AnnotatedString$Annotation;", "placeholders", "Landroidx/compose/ui/text/Placeholder;", "density", "Landroidx/compose/ui/unit/Density;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "hasEmojiCompat", "", "getHasEmojiCompat", "(Landroidx/compose/ui/text/TextStyle;)Z", "ui-text"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AndroidParagraphIntrinsics_androidKt {
    /* renamed from: resolveTextDirectionHeuristics-HklW4sA$default, reason: not valid java name */
    public static /* synthetic */ int m2387resolveTextDirectionHeuristicsHklW4sA$default(int i, LocaleList localeList, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            localeList = null;
        }
        return m2386resolveTextDirectionHeuristicsHklW4sA(i, localeList);
    }

    /* renamed from: resolveTextDirectionHeuristics-HklW4sA, reason: not valid java name */
    public static final int m2386resolveTextDirectionHeuristicsHklW4sA(int i, LocaleList localeList) {
        Locale locale;
        if (TextDirection.m2559equalsimpl0(i, TextDirection.INSTANCE.m2564getContentOrLtrs_7Xco())) {
            return 2;
        }
        if (!TextDirection.m2559equalsimpl0(i, TextDirection.INSTANCE.m2565getContentOrRtls_7Xco())) {
            if (TextDirection.m2559equalsimpl0(i, TextDirection.INSTANCE.m2566getLtrs_7Xco())) {
                return 0;
            }
            if (TextDirection.m2559equalsimpl0(i, TextDirection.INSTANCE.m2567getRtls_7Xco())) {
                return 1;
            }
            if (TextDirection.m2559equalsimpl0(i, TextDirection.INSTANCE.m2563getContents_7Xco()) || TextDirection.m2559equalsimpl0(i, TextDirection.INSTANCE.m2568getUnspecifieds_7Xco())) {
                if (localeList == null || (locale = localeList.get(0).getPlatformLocale()) == null) {
                    locale = Locale.getDefault();
                }
                int layoutDirectionFromLocale = TextUtilsCompat.getLayoutDirectionFromLocale(locale);
                if (layoutDirectionFromLocale == 0 || layoutDirectionFromLocale != 1) {
                    return 2;
                }
            } else {
                throw new IllegalStateException("Invalid TextDirection.".toString());
            }
        }
        return 3;
    }

    public static final ParagraphIntrinsics ActualParagraphIntrinsics(String str, TextStyle textStyle, List<? extends AnnotatedString.Range<? extends AnnotatedString.Annotation>> list, List<AnnotatedString.Range<Placeholder>> list2, Density density, FontFamily.Resolver resolver) {
        return new AndroidParagraphIntrinsics(str, textStyle, list, list2, resolver, density);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getHasEmojiCompat(TextStyle textStyle) {
        PlatformParagraphStyle paragraphStyle;
        PlatformTextStyle platformStyle = textStyle.getPlatformStyle();
        return !(((platformStyle == null || (paragraphStyle = platformStyle.getParagraphStyle()) == null) ? null : EmojiSupportMatch.m1944boximpl(paragraphStyle.getEmojiSupportMatch())) == null ? false : EmojiSupportMatch.m1947equalsimpl0(r1.getValue(), EmojiSupportMatch.INSTANCE.m1953getNone_3YsG6Y()));
    }
}
