package io.noties.markwon.syntax;

import io.noties.markwon.AbstractMarkwonPlugin;
import io.noties.markwon.MarkwonConfiguration;
import io.noties.markwon.core.MarkwonTheme;
import io.noties.prism4j.Prism4j;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public class SyntaxHighlightPlugin extends AbstractMarkwonPlugin {
    private final String fallbackLanguage;
    private final Prism4j prism4j;
    private final Prism4jTheme theme;

    public static SyntaxHighlightPlugin create(Prism4j prism4j, Prism4jTheme prism4jTheme) {
        return create(prism4j, prism4jTheme, null);
    }

    public static SyntaxHighlightPlugin create(Prism4j prism4j, Prism4jTheme prism4jTheme, String str) {
        return new SyntaxHighlightPlugin(prism4j, prism4jTheme, str);
    }

    public SyntaxHighlightPlugin(Prism4j prism4j, Prism4jTheme prism4jTheme, String str) {
        this.prism4j = prism4j;
        this.theme = prism4jTheme;
        this.fallbackLanguage = str;
    }

    public void configureTheme(MarkwonTheme.Builder builder) {
        builder.codeTextColor(this.theme.textColor()).codeBackgroundColor(this.theme.background());
    }

    public void configureConfiguration(MarkwonConfiguration.Builder builder) {
        builder.syntaxHighlight(Prism4jSyntaxHighlight.create(this.prism4j, this.theme, this.fallbackLanguage));
    }
}
