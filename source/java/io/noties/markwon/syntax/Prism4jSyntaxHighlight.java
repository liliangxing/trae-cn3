package io.noties.markwon.syntax;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import io.noties.prism4j.Prism4j;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public class Prism4jSyntaxHighlight implements SyntaxHighlight {
    private final String fallback;
    private final Prism4j prism4j;
    private final Prism4jTheme theme;

    protected CharSequence highlightNoLanguageInfo(String str) {
        return str;
    }

    public static Prism4jSyntaxHighlight create(Prism4j prism4j, Prism4jTheme prism4jTheme) {
        return new Prism4jSyntaxHighlight(prism4j, prism4jTheme, null);
    }

    public static Prism4jSyntaxHighlight create(Prism4j prism4j, Prism4jTheme prism4jTheme, String str) {
        return new Prism4jSyntaxHighlight(prism4j, prism4jTheme, str);
    }

    protected Prism4jSyntaxHighlight(Prism4j prism4j, Prism4jTheme prism4jTheme, String str) {
        this.prism4j = prism4j;
        this.theme = prism4jTheme;
        this.fallback = str;
    }

    @Override // io.noties.markwon.syntax.SyntaxHighlight
    public CharSequence highlight(String str, String str2) {
        if (str2.isEmpty()) {
            return str2;
        }
        if (str == null) {
            return highlightNoLanguageInfo(str2);
        }
        return highlightWithLanguageInfo(str, str2);
    }

    protected CharSequence highlightWithLanguageInfo(String str, String str2) {
        Prism4j.Grammar grammar = this.prism4j.grammar(str);
        if (grammar == null && !TextUtils.isEmpty(this.fallback)) {
            str = this.fallback;
            grammar = this.prism4j.grammar(str);
        }
        return grammar != null ? highlight(str, grammar, str2) : str2;
    }

    protected CharSequence highlight(String str, Prism4j.Grammar grammar, String str2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        new Prism4jSyntaxVisitor(str, this.theme, spannableStringBuilder).visit(this.prism4j.tokenize(str2, grammar));
        return spannableStringBuilder;
    }

    protected Prism4j prism4j() {
        return this.prism4j;
    }

    protected Prism4jTheme theme() {
        return this.theme;
    }

    protected String fallback() {
        return this.fallback;
    }
}
