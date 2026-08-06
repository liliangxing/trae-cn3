package io.noties.markwon.inlineparser;

import java.util.regex.Pattern;
import org.commonmark.internal.Bracket;
import org.commonmark.internal.util.Escaping;
import org.commonmark.node.Image;
import org.commonmark.node.Link;
import org.commonmark.node.LinkReferenceDefinition;
import org.commonmark.node.Node;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class CloseBracketInlineProcessor extends InlineProcessor {
    private static final Pattern WHITESPACE = MarkwonInlineParser.WHITESPACE;

    @Override // io.noties.markwon.inlineparser.InlineProcessor
    public char specialCharacter() {
        return ']';
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00f4  */
    @Override // io.noties.markwon.inlineparser.InlineProcessor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected Node parse() {
        boolean z;
        String str;
        String str2;
        boolean z2 = true;
        this.index++;
        int i = this.index;
        Bracket lastBracket = lastBracket();
        if (lastBracket == null) {
            return text("]");
        }
        if (!lastBracket.allowed) {
            removeLastBracket();
            return text("]");
        }
        String str3 = null;
        if (peek() == '(') {
            this.index++;
            spnl();
            str = parseLinkDestination();
            if (str != null) {
                spnl();
                if (WHITESPACE.matcher(this.input.substring(this.index - 1, this.index)).matches()) {
                    str2 = parseLinkTitle();
                    spnl();
                } else {
                    str2 = null;
                }
                if (peek() == ')') {
                    this.index++;
                    z = true;
                } else {
                    this.index = i;
                    z = false;
                }
            } else {
                z = false;
                str2 = null;
            }
        } else {
            z = false;
            str = null;
            str2 = null;
        }
        if (!z) {
            int i2 = this.index;
            parseLinkLabel();
            int i3 = this.index - i2;
            if (i3 > 2) {
                str3 = this.input.substring(i2, i3 + i2);
            } else if (!lastBracket.bracketAfter) {
                str3 = this.input.substring(lastBracket.index, i);
            }
            if (str3 != null) {
                LinkReferenceDefinition linkReferenceDefinition = this.context.getLinkReferenceDefinition(Escaping.normalizeReference(str3));
                if (linkReferenceDefinition != null) {
                    str = linkReferenceDefinition.getDestination();
                    str2 = linkReferenceDefinition.getTitle();
                    if (!z2) {
                        Image image = lastBracket.image ? new Image(str, str2) : new Link(str, str2);
                        Node next = lastBracket.node.getNext();
                        while (next != null) {
                            Node next2 = next.getNext();
                            image.appendChild(next);
                            next = next2;
                        }
                        processDelimiters(lastBracket.previousDelimiter);
                        InlineParserUtils.mergeChildTextNodes(image);
                        lastBracket.node.unlink();
                        removeLastBracket();
                        if (!lastBracket.image) {
                            for (Bracket lastBracket2 = lastBracket(); lastBracket2 != null; lastBracket2 = lastBracket2.previous) {
                                if (!lastBracket2.image) {
                                    lastBracket2.allowed = false;
                                }
                            }
                        }
                        return image;
                    }
                    this.index = i;
                    removeLastBracket();
                    return text("]");
                }
            }
        }
        z2 = z;
        if (!z2) {
        }
    }
}
