package io.noties.markwon.ext.onetex;

import com.larus.business.markdown.api.depend.IMarkdownLogger;
import com.larus.business.markdown.api.depend.IMarkdownLoggerKt;
import io.noties.markwon.inlineparser.InlineProcessor;
import io.noties.markwon.onetex.LatexMathNode;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.commonmark.node.Node;

/* compiled from: LatexMathInlineProcessor2.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\n\u0010\t\u001a\u0004\u0018\u00010\nH\u0014J\b\u0010\u000b\u001a\u00020\fH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lio/noties/markwon/ext/onetex/LatexMathInlineProcessor2;", "Lio/noties/markwon/inlineparser/InlineProcessor;", "supportSingleInline", "", "customizedLatexPattern", "", "(ZLjava/lang/String;)V", "recognize", "Ljava/util/regex/Pattern;", "parse", "Lorg/commonmark/node/Node;", "specialCharacter", "", "markdown-latex_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class LatexMathInlineProcessor2 extends InlineProcessor {
    private final String customizedLatexPattern;
    private final Pattern recognize;
    private final boolean supportSingleInline;

    public char specialCharacter() {
        return '$';
    }

    public /* synthetic */ LatexMathInlineProcessor2(boolean z, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, (i & 2) != 0 ? null : str);
    }

    public LatexMathInlineProcessor2(boolean z, String str) {
        Pattern compile;
        this.supportSingleInline = z;
        this.customizedLatexPattern = str;
        boolean z2 = false;
        if (str != null && (!StringsKt.isBlank(str))) {
            z2 = true;
        }
        if (z2) {
            compile = Pattern.compile(str);
            Intrinsics.checkNotNullExpressionValue(compile, "{\n            Pattern.co…edLatexPattern)\n        }");
        } else {
            if (z) {
                compile = Pattern.compile("^(\\${1,2})[^\\s\\$](([^\\r\\n\\$]*?)[^\\s\\$])?\\1(?!\\d)");
            } else {
                compile = Pattern.compile("^(\\${2})[^\\s\\$](([^\\r\\n\\$]*?)[^\\s\\$])?\\1(?!\\d)");
            }
            Intrinsics.checkNotNullExpressionValue(compile, "{\n            if (suppor…)\n            }\n        }");
        }
        this.recognize = compile;
    }

    protected Node parse() {
        int length;
        int i = ((InlineProcessor) this).index;
        String match = match(this.recognize);
        if (match == null) {
            IMarkdownLogger markdownLoggerDelegate = IMarkdownLoggerKt.getMarkdownLoggerDelegate();
            if (markdownLoggerDelegate != null) {
                markdownLoggerDelegate.e("md_parse", "error parse latex: raw: " + ((InlineProcessor) this).input + "; context: " + ((InlineProcessor) this).context + "; index: " + ((InlineProcessor) this).index + "; oldIndex: " + i);
            }
            return null;
        }
        Node latexMathNode = new LatexMathNode();
        int i2 = 2;
        if (this.supportSingleInline) {
            if (StringsKt.startsWith$default(match, "$$", false, 2, (Object) null) && StringsKt.endsWith$default(match, "$$", false, 2, (Object) null)) {
                length = match.length();
            } else {
                length = match.length();
                i2 = 1;
            }
        } else {
            length = match.length();
        }
        String substring = match.substring(i2, length - i2);
        Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        IMarkdownLogger markdownLoggerDelegate2 = IMarkdownLoggerKt.getMarkdownLoggerDelegate();
        if (markdownLoggerDelegate2 != null) {
            markdownLoggerDelegate2.i("md_parse", "latex: " + substring + "; index: " + ((InlineProcessor) this).index + "; oldIndex: " + i);
        }
        latexMathNode.latex(substring);
        return latexMathNode;
    }
}
