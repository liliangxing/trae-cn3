package io.noties.markwon.ext.onetex;

import io.noties.markwon.onetex.LatexMathBlock;
import org.commonmark.node.Block;
import org.commonmark.parser.block.AbstractBlockParser;
import org.commonmark.parser.block.AbstractBlockParserFactory;
import org.commonmark.parser.block.BlockContinue;
import org.commonmark.parser.block.BlockParser;
import org.commonmark.parser.block.BlockStart;
import org.commonmark.parser.block.MatchedBlockParser;
import org.commonmark.parser.block.ParserState;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class LatexMathBlockParserLegacy extends AbstractBlockParser {
    private final LatexMathBlock block = new LatexMathBlock();
    private final StringBuilder builder = new StringBuilder();
    private boolean isClosed;

    public Block getBlock() {
        return this.block;
    }

    public BlockContinue tryContinue(ParserState parserState) {
        if (this.isClosed) {
            return BlockContinue.finished();
        }
        return BlockContinue.atIndex(parserState.getIndex());
    }

    public void addLine(CharSequence charSequence) {
        if (this.builder.length() > 0) {
            this.builder.append('\n');
        }
        this.builder.append(charSequence);
        int length = this.builder.length();
        if (length > 1) {
            boolean z = '$' == this.builder.charAt(length + (-1)) && '$' == this.builder.charAt(length + (-2));
            this.isClosed = z;
            if (z) {
                this.builder.replace(length - 2, length, "");
            }
        }
    }

    public void closeBlock() {
        this.block.latex(this.builder.toString());
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class Factory extends AbstractBlockParserFactory {
        public BlockStart tryStart(ParserState parserState, MatchedBlockParser matchedBlockParser) {
            CharSequence line = parserState.getLine();
            if ((line != null ? line.length() : 0) > 1 && '$' == line.charAt(0) && '$' == line.charAt(1)) {
                return BlockStart.of(new BlockParser[]{new LatexMathBlockParserLegacy()}).atIndex(parserState.getIndex() + 2);
            }
            return BlockStart.none();
        }
    }
}
