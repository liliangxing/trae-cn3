package io.noties.markwon.ext.onetex;

import com.larus.business.markdown.api.depend.IMarkdownLogger;
import com.larus.business.markdown.api.depend.IMarkdownLoggerKt;
import io.noties.markwon.inlineparser.InlineProcessor;
import io.noties.markwon.onetex.LatexMathNode;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.commonmark.node.Node;

/* compiled from: NewLatexMathInlineProcessor.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0002J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0014J\b\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lio/noties/markwon/ext/onetex/NewLatexMathInlineProcessor;", "Lio/noties/markwon/inlineparser/InlineProcessor;", "()V", "recognize", "Ljava/util/regex/Pattern;", "checkStartCharacter", "", "parse", "Lorg/commonmark/node/Node;", "specialCharacter", "", "Companion", "markdown-latex_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class NewLatexMathInlineProcessor extends InlineProcessor {
    private static final int LATEX_PATTERN_NUM = 2;
    private final Pattern recognize;

    public char specialCharacter() {
        return '\\';
    }

    public NewLatexMathInlineProcessor() {
        Pattern compile = Pattern.compile("^\\\\\\(([\\s\\S]*?)\\\\\\)|\\\\\\[([\\s\\S]*?)\\\\\\]");
        Intrinsics.checkNotNullExpressionValue(compile, "compile(\"^\\\\\\\\\\\\(([\\\\s\\\\…\\\\\\[([\\\\s\\\\S]*?)\\\\\\\\\\\\]\")");
        this.recognize = compile;
    }

    protected Node parse() {
        if (!checkStartCharacter()) {
            return null;
        }
        int i = ((InlineProcessor) this).index;
        String match = match(this.recognize);
        if (match == null) {
            IMarkdownLogger markdownLoggerDelegate = IMarkdownLoggerKt.getMarkdownLoggerDelegate();
            if (markdownLoggerDelegate != null) {
                markdownLoggerDelegate.e("md_parse", "NewLatexMathInlineProcessor error parse latex: raw: " + ((InlineProcessor) this).input + "; context: " + ((InlineProcessor) this).context + "; index: " + ((InlineProcessor) this).index + "; oldIndex: " + i);
            }
            return null;
        }
        Node latexMathNode = new LatexMathNode();
        IMarkdownLogger markdownLoggerDelegate2 = IMarkdownLoggerKt.getMarkdownLoggerDelegate();
        if (markdownLoggerDelegate2 != null) {
            markdownLoggerDelegate2.i("md_parse", "NewLatexMathInlineProcessor latex: " + match + "; index: " + ((InlineProcessor) this).index + "; oldIndex: " + i);
        }
        String substring = match.substring(2, match.length() - 2);
        Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        latexMathNode.latex(substring);
        return latexMathNode;
    }

    private final boolean checkStartCharacter() {
        if (((InlineProcessor) this).index + 1 >= ((InlineProcessor) this).input.length()) {
            return false;
        }
        return ((InlineProcessor) this).input.charAt(((InlineProcessor) this).index + 1) == '(' || ((InlineProcessor) this).input.charAt(((InlineProcessor) this).index + 1) == '[';
    }
}
