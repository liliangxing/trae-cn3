package org.commonmark.internal;

import org.commonmark.internal.util.Parsing;
import org.commonmark.node.Block;
import org.commonmark.node.BlockQuote;
import org.commonmark.parser.block.AbstractBlockParser;
import org.commonmark.parser.block.AbstractBlockParserFactory;
import org.commonmark.parser.block.BlockContinue;
import org.commonmark.parser.block.BlockStart;
import org.commonmark.parser.block.MatchedBlockParser;
import org.commonmark.parser.block.ParserState;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public class BlockQuoteParser extends AbstractBlockParser {
    private final BlockQuote block = new BlockQuote();

    @Override // org.commonmark.parser.block.AbstractBlockParser, org.commonmark.parser.block.BlockParser
    public boolean canContain(Block block) {
        return true;
    }

    @Override // org.commonmark.parser.block.AbstractBlockParser, org.commonmark.parser.block.BlockParser
    public boolean isContainer() {
        return true;
    }

    @Override // org.commonmark.parser.block.BlockParser
    public BlockQuote getBlock() {
        return this.block;
    }

    @Override // org.commonmark.parser.block.BlockParser
    public BlockContinue tryContinue(ParserState parserState) {
        int nextNonSpaceIndex = parserState.getNextNonSpaceIndex();
        if (isMarker(parserState, nextNonSpaceIndex)) {
            int column = parserState.getColumn() + parserState.getIndent() + 1;
            if (Parsing.isSpaceOrTab(parserState.getLine(), nextNonSpaceIndex + 1)) {
                column++;
            }
            return BlockContinue.atColumn(column);
        }
        return BlockContinue.none();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isMarker(ParserState parserState, int i) {
        CharSequence line = parserState.getLine();
        return parserState.getIndent() < Parsing.CODE_BLOCK_INDENT && i < line.length() && line.charAt(i) == '>';
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
    public static class Factory extends AbstractBlockParserFactory {
        @Override // org.commonmark.parser.block.BlockParserFactory
        public BlockStart tryStart(ParserState parserState, MatchedBlockParser matchedBlockParser) {
            int nextNonSpaceIndex = parserState.getNextNonSpaceIndex();
            if (BlockQuoteParser.isMarker(parserState, nextNonSpaceIndex)) {
                int column = parserState.getColumn() + parserState.getIndent() + 1;
                if (Parsing.isSpaceOrTab(parserState.getLine(), nextNonSpaceIndex + 1)) {
                    column++;
                }
                return BlockStart.m360of(new BlockQuoteParser()).atColumn(column);
            }
            return BlockStart.none();
        }
    }
}
