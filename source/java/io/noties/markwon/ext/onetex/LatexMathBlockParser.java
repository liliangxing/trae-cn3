package io.noties.markwon.ext.onetex;

import io.noties.markwon.onetex.LatexMathBlock;
import org.commonmark.internal.util.Parsing;
import org.commonmark.node.Block;
import org.commonmark.parser.block.AbstractBlockParser;
import org.commonmark.parser.block.AbstractBlockParserFactory;
import org.commonmark.parser.block.BlockContinue;
import org.commonmark.parser.block.BlockParser;
import org.commonmark.parser.block.BlockStart;
import org.commonmark.parser.block.MatchedBlockParser;
import org.commonmark.parser.block.ParserState;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class LatexMathBlockParser extends AbstractBlockParser {
    private static final char DOLLAR = '$';
    private static final char SPACE = ' ';
    private final LatexMathBlock block = new LatexMathBlock();
    private final StringBuilder builder = new StringBuilder();
    private final int signs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LatexMathBlockParser(int i) {
        this.signs = i;
    }

    public Block getBlock() {
        return this.block;
    }

    public BlockContinue tryContinue(ParserState parserState) {
        int nextNonSpaceIndex = parserState.getNextNonSpaceIndex();
        CharSequence line = parserState.getLine();
        int length = line.length();
        if (parserState.getIndent() < Parsing.CODE_BLOCK_INDENT) {
            int consume = consume(DOLLAR, line, nextNonSpaceIndex, length);
            int i = this.signs;
            if (consume == i && Parsing.skip(SPACE, line, nextNonSpaceIndex + i, length) == length) {
                return BlockContinue.finished();
            }
        }
        return BlockContinue.atIndex(parserState.getIndex());
    }

    public void addLine(CharSequence charSequence) {
        this.builder.append(charSequence);
        this.builder.append('\n');
    }

    public void closeBlock() {
        this.block.latex(this.builder.toString());
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class Factory extends AbstractBlockParserFactory {
        public BlockStart tryStart(ParserState parserState, MatchedBlockParser matchedBlockParser) {
            if (parserState.getIndent() >= Parsing.CODE_BLOCK_INDENT) {
                return BlockStart.none();
            }
            int nextNonSpaceIndex = parserState.getNextNonSpaceIndex();
            CharSequence line = parserState.getLine();
            int length = line.length();
            int consume = LatexMathBlockParser.consume(LatexMathBlockParser.DOLLAR, line, nextNonSpaceIndex, length);
            if (consume < 1) {
                return BlockStart.none();
            }
            if (Parsing.skip(LatexMathBlockParser.SPACE, line, nextNonSpaceIndex + consume, length) != length) {
                return BlockStart.none();
            }
            return BlockStart.of(new BlockParser[]{new LatexMathBlockParser(consume)}).atIndex(length + 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int consume(char c, CharSequence charSequence, int i, int i2) {
        for (int i3 = i; i3 < i2; i3++) {
            if (c != charSequence.charAt(i3)) {
                return i3 - i;
            }
        }
        return i2 - i;
    }
}
