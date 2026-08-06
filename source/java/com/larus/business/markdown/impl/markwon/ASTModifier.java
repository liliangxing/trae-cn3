package com.larus.business.markdown.impl.markwon;

import com.larus.business.markdown.api.depend.IMarkdownLogger;
import com.larus.business.markdown.api.depend.IMarkdownLoggerKt;
import com.larus.business.markdown.api.extplugin.latex.ILatexPlugin;
import com.larus.business.markdown.api.extplugin.latex.ILatexPluginKt;
import com.larus.business.markdown.impl.markwon.customdata.CustomDataTagHandler;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import org.commonmark.node.Node;
import org.commonmark.node.Paragraph;
import org.commonmark.node.Text;

/* compiled from: ASTModifier.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\b\u0005\u0018\u0000 $2\u00020\u0001:\u0001$B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\r\u001a\u00020\u00042\n\u0010\u000e\u001a\u00060\u000fj\u0002`\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u0010\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0014\u0010\u001b\u001a\u00020\u00042\n\u0010\u000e\u001a\u00060\u000fj\u0002`\u0010H\u0002J2\u0010\u001c\u001a\u00020\u00042\n\u0010\u000e\u001a\u00060\u000fj\u0002`\u00102\b\b\u0002\u0010\u001d\u001a\u00020\u00122\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00040\u001fH\u0002J&\u0010!\u001a\u00020\u00042\n\u0010\u000e\u001a\u00060\u000fj\u0002`\u00102\u0006\u0010\"\u001a\u00020 2\b\b\u0002\u0010\u001d\u001a\u00020\u0012H\u0002J\f\u0010#\u001a\u00020\u0004*\u00020 H\u0002R$\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006%"}, d2 = {"Lcom/larus/business/markdown/impl/markwon/ASTModifier;", "", "()V", CustomDataTagHandler.VALUE_ATTRIBUTE, "", "enable", "getEnable", "()Z", "setEnable", "(Z)V", "latexOptEnable", "getLatexOptEnable", "setLatexOptEnable", "checkDigit", "builder", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "startIndex", "", "endIndex", "modifyLastNode", "", "node", "Lorg/commonmark/node/Node;", "modifyLastTextNode", "text", "Lorg/commonmark/node/Text;", "tryDeleteListToken", "tryDeleteTailToken", "maxCount", "predicate", "Lkotlin/Function1;", "", "tryDeleteToken", "token", "isEmoji", "Companion", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class ASTModifier {
    private static final String TAG = "ASTModifier";
    private boolean enable;
    private boolean latexOptEnable;

    public final boolean getEnable() {
        return this.enable;
    }

    public final void setEnable(boolean z) {
        IMarkdownLogger markdownLoggerDelegate = IMarkdownLoggerKt.getMarkdownLoggerDelegate();
        if (markdownLoggerDelegate != null) {
            markdownLoggerDelegate.mo2528d(TAG, "==>optimized=" + z);
        }
        this.enable = z;
    }

    public final boolean getLatexOptEnable() {
        return this.latexOptEnable;
    }

    public final void setLatexOptEnable(boolean z) {
        IMarkdownLogger markdownLoggerDelegate = IMarkdownLoggerKt.getMarkdownLoggerDelegate();
        if (markdownLoggerDelegate != null) {
            markdownLoggerDelegate.mo2528d(TAG, "==>latex optimized=" + z);
        }
        this.latexOptEnable = z;
    }

    public final void modifyLastNode(Node node) {
        ILatexPlugin latexPluginDelegate;
        Intrinsics.checkNotNullParameter(node, "node");
        if (this.enable) {
            while (node.lastChild != null) {
                node = node.lastChild;
                Intrinsics.checkNotNullExpressionValue(node, "currNode.lastChild");
            }
            if ((node instanceof Text) && (node.parent instanceof Paragraph)) {
                modifyLastTextNode((Text) node);
            }
            if (!this.latexOptEnable || (latexPluginDelegate = ILatexPluginKt.getLatexPluginDelegate()) == null) {
                return;
            }
            latexPluginDelegate.modifyLatexMathBlockContent(node, "");
        }
    }

    private final void modifyLastTextNode(Text text) {
        String literal = text.getLiteral();
        String str = literal;
        if (str == null || str.length() == 0) {
            return;
        }
        StringBuilder sb = new StringBuilder(literal);
        boolean tryDeleteTailToken$default = tryDeleteTailToken$default(this, sb, 0, new Function1<Character, Boolean>() { // from class: com.larus.business.markdown.impl.markwon.ASTModifier$modifyLastTextNode$changed$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Character) obj).charValue());
            }

            public final Boolean invoke(char c) {
                boolean z;
                boolean isEmoji;
                if (!CharsKt.isWhitespace(c) && c != 65532) {
                    isEmoji = ASTModifier.this.isEmoji(c);
                    if (!isEmoji) {
                        z = false;
                        return Boolean.valueOf(z);
                    }
                }
                z = true;
                return Boolean.valueOf(z);
            }
        }, 2, null) | tryDeleteListToken(sb) | tryDeleteToken(sb, '*', 3) | tryDeleteToken(sb, '_', 3);
        text.setLiteral(sb.toString());
        if (tryDeleteTailToken$default) {
            IMarkdownLogger markdownLoggerDelegate = IMarkdownLoggerKt.getMarkdownLoggerDelegate();
            if (markdownLoggerDelegate != null) {
                markdownLoggerDelegate.mo2528d(TAG, "==>literal_1=" + literal);
            }
            IMarkdownLogger markdownLoggerDelegate2 = IMarkdownLoggerKt.getMarkdownLoggerDelegate();
            if (markdownLoggerDelegate2 != null) {
                markdownLoggerDelegate2.mo2528d(TAG, "==>literal_2=" + text.getLiteral());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isEmoji(char c) {
        if (9728 <= c && c < 9984) {
            return true;
        }
        if (62208 <= c && c < 62976) {
            return true;
        }
        if (62976 <= c && c < 63056) {
            return true;
        }
        if (63104 <= c && c < 63232) {
            return true;
        }
        return (63744 <= c && c < 64000) || Character.isHighSurrogate(c) || Character.isLowSurrogate(c) || c == 8205;
    }

    static /* synthetic */ boolean tryDeleteTailToken$default(ASTModifier aSTModifier, StringBuilder sb, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = Integer.MAX_VALUE;
        }
        return aSTModifier.tryDeleteTailToken(sb, i, function1);
    }

    private final boolean tryDeleteTailToken(StringBuilder builder, int maxCount, Function1<? super Character, Boolean> predicate) {
        int i = 0;
        boolean z = false;
        while (true) {
            if (!(builder.length() > 0) || i >= maxCount || !((Boolean) predicate.invoke(Character.valueOf(builder.charAt(builder.length() - 1)))).booleanValue()) {
                break;
            }
            builder.delete(builder.length() - 1, builder.length());
            i++;
            z = true;
        }
        return z;
    }

    static /* synthetic */ boolean tryDeleteToken$default(ASTModifier aSTModifier, StringBuilder sb, char c, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 3;
        }
        return aSTModifier.tryDeleteToken(sb, c, i);
    }

    private final boolean tryDeleteToken(StringBuilder builder, char token, int maxCount) {
        int indexOf$default;
        StringBuilder sb = builder;
        if ((sb.length() == 0) || (indexOf$default = StringsKt.indexOf$default(sb, token, 0, false, 6, (Object) null)) < 0) {
            return false;
        }
        int i = indexOf$default + 1;
        while (i < builder.length() && i < indexOf$default + maxCount && builder.charAt(i) == token) {
            i++;
        }
        builder.delete(indexOf$default, i);
        return true;
    }

    private final boolean tryDeleteListToken(StringBuilder builder) {
        if (builder.length() == 0) {
            return false;
        }
        char charAt = builder.charAt(builder.length() - 1);
        if (builder.length() == 1) {
            if (charAt != '-' && charAt != '*' && charAt != '+' && !Character.isDigit(charAt)) {
                return false;
            }
            StringsKt.clear(builder);
            return true;
        }
        if (builder.length() <= 3 && checkDigit(builder, 0, builder.length() - 1)) {
            StringsKt.clear(builder);
            return true;
        }
        if ((charAt != '.' && charAt != ')') || !checkDigit(builder, 0, builder.length() - 2)) {
            return false;
        }
        StringsKt.clear(builder);
        return true;
    }

    private final boolean checkDigit(StringBuilder builder, int startIndex, int endIndex) {
        if (startIndex < 0 || endIndex >= builder.length() || startIndex > endIndex) {
            return false;
        }
        if (startIndex > endIndex) {
            return true;
        }
        while (Character.isDigit(builder.charAt(startIndex))) {
            if (startIndex == endIndex) {
                return true;
            }
            startIndex++;
        }
        return false;
    }
}
