package io.noties.markwon.inlineparser;

import java.util.regex.Pattern;
import org.commonmark.node.HardLineBreak;
import org.commonmark.node.Node;
import org.commonmark.node.Text;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class BackslashInlineProcessor extends InlineProcessor {
    private static final Pattern ESCAPABLE = MarkwonInlineParser.ESCAPABLE;

    @Override // io.noties.markwon.inlineparser.InlineProcessor
    public char specialCharacter() {
        return '\\';
    }

    @Override // io.noties.markwon.inlineparser.InlineProcessor
    protected Node parse() {
        this.index++;
        if (peek() == '\n') {
            HardLineBreak hardLineBreak = new HardLineBreak();
            this.index++;
            return hardLineBreak;
        }
        if (this.index < this.input.length() && ESCAPABLE.matcher(this.input.substring(this.index, this.index + 1)).matches()) {
            Text text = text(this.input, this.index, this.index + 1);
            this.index++;
            return text;
        }
        return text("\\");
    }
}
