package io.noties.markwon.inlineparser;

import org.commonmark.internal.Bracket;
import org.commonmark.node.Node;
import org.commonmark.node.Text;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class OpenBracketInlineProcessor extends InlineProcessor {
    @Override // io.noties.markwon.inlineparser.InlineProcessor
    public char specialCharacter() {
        return '[';
    }

    @Override // io.noties.markwon.inlineparser.InlineProcessor
    protected Node parse() {
        int i = this.index;
        this.index++;
        Text text = text("[");
        addBracket(Bracket.link(text, i, lastBracket(), lastDelimiter()));
        return text;
    }
}
