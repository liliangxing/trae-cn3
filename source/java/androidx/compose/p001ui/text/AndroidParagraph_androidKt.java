package androidx.compose.p001ui.text;

import android.os.Build;
import android.text.Spannable;
import android.text.SpannableString;
import androidx.compose.p001ui.text.android.SpannedExtensions_androidKt;
import androidx.compose.p001ui.text.android.TextLayout;
import androidx.compose.p001ui.text.android.style.IndentationFixSpan;
import androidx.compose.p001ui.text.platform.extensions.SpannableExtensions_androidKt;
import androidx.compose.p001ui.text.style.Hyphens;
import androidx.compose.p001ui.text.style.LineBreak;
import androidx.compose.p001ui.text.style.TextAlign;
import androidx.compose.p001ui.unit.TextUnit;
import androidx.compose.p001ui.unit.TextUnitKt;
import kotlin.Metadata;

/* compiled from: AndroidParagraph.android.kt */
@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0017\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0017\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\u0005\u001a\u0017\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u0005\u001a\u0017\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0011\u0010\u0005\u001a\u0017\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0015\u0010\u0005\u001a\u0014\u0010\u0016\u001a\u00020\u0001*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0001H\u0002\u001a\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001aH\u0002\u001a\f\u0010\u001e\u001a\u00020\u001f*\u00020\u001fH\u0002\u001a\u0013\u0010 \u001a\u00020\u0001*\u00020!H\u0002¢\u0006\u0004\b\"\u0010\u0005¨\u0006#"}, d2 = {"toLayoutAlign", "", "align", "Landroidx/compose/ui/text/style/TextAlign;", "toLayoutAlign-aXe7zB0", "(I)I", "toLayoutHyphenationFrequency", "hyphens", "Landroidx/compose/ui/text/style/Hyphens;", "toLayoutHyphenationFrequency--3fSNIE", "toLayoutBreakStrategy", "breakStrategy", "Landroidx/compose/ui/text/style/LineBreak$Strategy;", "toLayoutBreakStrategy-xImikfE", "toLayoutLineBreakStyle", "lineBreakStrictness", "Landroidx/compose/ui/text/style/LineBreak$Strictness;", "toLayoutLineBreakStyle-hpcqdu8", "toLayoutLineBreakWordStyle", "lineBreakWordStyle", "Landroidx/compose/ui/text/style/LineBreak$WordBreak;", "toLayoutLineBreakWordStyle-wPN0Rpw", "numberOfLinesThatFitMaxHeight", "Landroidx/compose/ui/text/android/TextLayout;", "maxHeight", "shouldAttachIndentationFixSpan", "", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "ellipsis", "attachIndentationFixSpan", "", "toLayoutTextGranularity", "Landroidx/compose/ui/text/TextGranularity;", "toLayoutTextGranularity-duNsdkg", "ui-text"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AndroidParagraph_androidKt {
    public static final /* synthetic */ CharSequence access$attachIndentationFixSpan(CharSequence charSequence) {
        return attachIndentationFixSpan(charSequence);
    }

    public static final /* synthetic */ int access$numberOfLinesThatFitMaxHeight(TextLayout textLayout, int i) {
        return numberOfLinesThatFitMaxHeight(textLayout, i);
    }

    public static final /* synthetic */ boolean access$shouldAttachIndentationFixSpan(TextStyle textStyle, boolean z) {
        return shouldAttachIndentationFixSpan(textStyle, z);
    }

    /* renamed from: access$toLayoutAlign-aXe7zB0, reason: not valid java name */
    public static final /* synthetic */ int m1918access$toLayoutAlignaXe7zB0(int i) {
        return m1924toLayoutAlignaXe7zB0(i);
    }

    /* renamed from: access$toLayoutBreakStrategy-xImikfE, reason: not valid java name */
    public static final /* synthetic */ int m1919access$toLayoutBreakStrategyxImikfE(int i) {
        return m1925toLayoutBreakStrategyxImikfE(i);
    }

    /* renamed from: access$toLayoutHyphenationFrequency--3fSNIE, reason: not valid java name */
    public static final /* synthetic */ int m1920access$toLayoutHyphenationFrequency3fSNIE(int i) {
        return m1926toLayoutHyphenationFrequency3fSNIE(i);
    }

    /* renamed from: access$toLayoutLineBreakStyle-hpcqdu8, reason: not valid java name */
    public static final /* synthetic */ int m1921access$toLayoutLineBreakStylehpcqdu8(int i) {
        return m1927toLayoutLineBreakStylehpcqdu8(i);
    }

    /* renamed from: access$toLayoutLineBreakWordStyle-wPN0Rpw, reason: not valid java name */
    public static final /* synthetic */ int m1922access$toLayoutLineBreakWordStylewPN0Rpw(int i) {
        return m1928toLayoutLineBreakWordStylewPN0Rpw(i);
    }

    /* renamed from: access$toLayoutTextGranularity-duNsdkg, reason: not valid java name */
    public static final /* synthetic */ int m1923access$toLayoutTextGranularityduNsdkg(int i) {
        return m1929toLayoutTextGranularityduNsdkg(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: toLayoutAlign-aXe7zB0, reason: not valid java name */
    public static final int m1924toLayoutAlignaXe7zB0(int i) {
        if (TextAlign.m2545equalsimpl0(i, TextAlign.INSTANCE.m2552getLefte0LSkKk())) {
            return 3;
        }
        if (TextAlign.m2545equalsimpl0(i, TextAlign.INSTANCE.m2553getRighte0LSkKk())) {
            return 4;
        }
        if (TextAlign.m2545equalsimpl0(i, TextAlign.INSTANCE.m2549getCentere0LSkKk())) {
            return 2;
        }
        return (!TextAlign.m2545equalsimpl0(i, TextAlign.INSTANCE.m2554getStarte0LSkKk()) && TextAlign.m2545equalsimpl0(i, TextAlign.INSTANCE.m2550getEnde0LSkKk())) ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: toLayoutHyphenationFrequency--3fSNIE, reason: not valid java name */
    public static final int m1926toLayoutHyphenationFrequency3fSNIE(int i) {
        if (Hyphens.m2443equalsimpl0(i, Hyphens.INSTANCE.m2447getAutovmbZdU8())) {
            return Build.VERSION.SDK_INT <= 32 ? 2 : 4;
        }
        Hyphens.m2443equalsimpl0(i, Hyphens.INSTANCE.m2448getNonevmbZdU8());
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: toLayoutBreakStrategy-xImikfE, reason: not valid java name */
    public static final int m1925toLayoutBreakStrategyxImikfE(int i) {
        if (LineBreak.Strategy.m2474equalsimpl0(i, LineBreak.Strategy.INSTANCE.m2480getSimplefcGXIks())) {
            return 0;
        }
        if (LineBreak.Strategy.m2474equalsimpl0(i, LineBreak.Strategy.INSTANCE.m2479getHighQualityfcGXIks())) {
            return 1;
        }
        return LineBreak.Strategy.m2474equalsimpl0(i, LineBreak.Strategy.INSTANCE.m2478getBalancedfcGXIks()) ? 2 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: toLayoutLineBreakStyle-hpcqdu8, reason: not valid java name */
    public static final int m1927toLayoutLineBreakStylehpcqdu8(int i) {
        if (LineBreak.Strictness.m2485equalsimpl0(i, LineBreak.Strictness.INSTANCE.m2489getDefaultusljTpc())) {
            return 0;
        }
        if (LineBreak.Strictness.m2485equalsimpl0(i, LineBreak.Strictness.INSTANCE.m2490getLooseusljTpc())) {
            return 1;
        }
        if (LineBreak.Strictness.m2485equalsimpl0(i, LineBreak.Strictness.INSTANCE.m2491getNormalusljTpc())) {
            return 2;
        }
        return LineBreak.Strictness.m2485equalsimpl0(i, LineBreak.Strictness.INSTANCE.m2492getStrictusljTpc()) ? 3 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: toLayoutLineBreakWordStyle-wPN0Rpw, reason: not valid java name */
    public static final int m1928toLayoutLineBreakWordStylewPN0Rpw(int i) {
        return (!LineBreak.WordBreak.m2497equalsimpl0(i, LineBreak.WordBreak.INSTANCE.m2501getDefaultjp8hJ3c()) && LineBreak.WordBreak.m2497equalsimpl0(i, LineBreak.WordBreak.INSTANCE.m2502getPhrasejp8hJ3c())) ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int numberOfLinesThatFitMaxHeight(TextLayout textLayout, int i) {
        int lineCount = textLayout.getLineCount();
        for (int i2 = 0; i2 < lineCount; i2++) {
            if (textLayout.getLineBottom(i2) > i) {
                return i2;
            }
        }
        return textLayout.getLineCount();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean shouldAttachIndentationFixSpan(TextStyle textStyle, boolean z) {
        return (!z || TextUnit.m2871equalsimpl0(textStyle.m2158getLetterSpacingXSAIIZE(), TextUnitKt.getSp(0)) || TextUnit.m2871equalsimpl0(textStyle.m2158getLetterSpacingXSAIIZE(), TextUnit.INSTANCE.m2885getUnspecifiedXSAIIZE()) || TextAlign.m2545equalsimpl0(textStyle.m2163getTextAligne0LSkKk(), TextAlign.INSTANCE.m2555getUnspecifiede0LSkKk()) || TextAlign.m2545equalsimpl0(textStyle.m2163getTextAligne0LSkKk(), TextAlign.INSTANCE.m2554getStarte0LSkKk()) || TextAlign.m2545equalsimpl0(textStyle.m2163getTextAligne0LSkKk(), TextAlign.INSTANCE.m2551getJustifye0LSkKk())) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence attachIndentationFixSpan(CharSequence charSequence) {
        if (charSequence.length() == 0) {
            return charSequence;
        }
        SpannableString spannableString = charSequence instanceof Spannable ? (Spannable) charSequence : null;
        if (spannableString == null) {
            spannableString = new SpannableString(charSequence);
        }
        if (!SpannedExtensions_androidKt.hasSpan(spannableString, IndentationFixSpan.class)) {
            SpannableExtensions_androidKt.setSpan(spannableString, new IndentationFixSpan(), spannableString.length() - 1, spannableString.length() - 1);
        }
        return spannableString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: toLayoutTextGranularity-duNsdkg, reason: not valid java name */
    public static final int m1929toLayoutTextGranularityduNsdkg(int i) {
        return (!TextGranularity.m2080equalsimpl0(i, TextGranularity.INSTANCE.m2084getCharacterDRrd7Zo()) && TextGranularity.m2080equalsimpl0(i, TextGranularity.INSTANCE.m2085getWordDRrd7Zo())) ? 1 : 0;
    }
}
