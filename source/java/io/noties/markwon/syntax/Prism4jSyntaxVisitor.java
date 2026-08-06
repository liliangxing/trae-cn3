package io.noties.markwon.syntax;

import android.text.SpannableStringBuilder;
import io.noties.prism4j.AbsVisitor;
import io.noties.prism4j.Prism4j;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
class Prism4jSyntaxVisitor extends AbsVisitor {
    private final SpannableStringBuilder builder;
    private final String language;
    private final Prism4jTheme theme;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Prism4jSyntaxVisitor(String str, Prism4jTheme prism4jTheme, SpannableStringBuilder spannableStringBuilder) {
        this.language = str;
        this.theme = prism4jTheme;
        this.builder = spannableStringBuilder;
    }

    protected void visitText(Prism4j.Text text) {
        this.builder.append((CharSequence) text.literal());
    }

    protected void visitSyntax(Prism4j.Syntax syntax) {
        int length = this.builder.length();
        visit(syntax.children());
        int length2 = this.builder.length();
        if (length2 != length) {
            this.theme.apply(this.language, syntax, this.builder, length, length2);
        }
    }
}
