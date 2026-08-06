package io.noties.markwon.ext.onetex;

import io.noties.markwon.inlineparser.InlineProcessor;
import io.noties.markwon.onetex.LatexMathNode;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.commonmark.node.Node;

/* compiled from: LatexMathInlineProcessor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\u0018\u0000 \f2\u00020\u0001:\u0001\fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\n\u0010\b\u001a\u0004\u0018\u00010\tH\u0014J\b\u0010\n\u001a\u00020\u000bH\u0016R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lio/noties/markwon/ext/onetex/LatexMathInlineProcessor;", "Lio/noties/markwon/inlineparser/InlineProcessor;", "supportSingleDollarInline", "", "(Z)V", "recognizeDollar", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "parse", "Lorg/commonmark/node/Node;", "specialCharacter", "", "Companion", "markwon-ext-onetex_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class LatexMathInlineProcessor extends InlineProcessor {
    public static final String doubleDollar = "(\\${2})[^\\s$](([^\\r\\n$]*?)[^\\s$])?\\1(?!\\d)";
    public static final String singleDollar = "(\\${1,2})[^\\s$](([^\\r\\n$]*?)[^\\s$])?\\1(?!\\d)";
    private final Pattern recognizeDollar;
    private final boolean supportSingleDollarInline;

    public char specialCharacter() {
        return '$';
    }

    public LatexMathInlineProcessor(boolean z) {
        Pattern compile;
        this.supportSingleDollarInline = z;
        if (z) {
            compile = Pattern.compile("^(\\${1,2})[^\\s$](([^\\r\\n$]*?)[^\\s$])?\\1(?!\\d)");
        } else {
            compile = Pattern.compile("^(\\${2})[^\\s$](([^\\r\\n$]*?)[^\\s$])?\\1(?!\\d)");
        }
        this.recognizeDollar = compile;
    }

    protected Node parse() {
        String substring;
        String match = match(this.recognizeDollar);
        if (match == null) {
            return null;
        }
        Intrinsics.checkExpressionValueIsNotNull(match, "match(recognizeDollar) ?: return null");
        Node latexMathNode = new LatexMathNode();
        try {
            if (this.supportSingleDollarInline) {
                if (StringsKt.startsWith$default(match, "$$", false, 2, (Object) null) && match.length() > 2) {
                    int length = match.length() - 2;
                    if (match == null) {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                    substring = match.substring(2, length);
                    Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                } else {
                    int length2 = match.length() - 1;
                    if (match == null) {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                    substring = match.substring(1, length2);
                    Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                }
                latexMathNode.latex(substring);
            } else {
                int length3 = match.length() - 2;
                if (match == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                String substring2 = match.substring(2, length3);
                Intrinsics.checkNotNullExpressionValue(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                latexMathNode.latex(substring2);
            }
        } catch (Exception unused) {
            latexMathNode.latex(match);
        }
        return latexMathNode;
    }
}
