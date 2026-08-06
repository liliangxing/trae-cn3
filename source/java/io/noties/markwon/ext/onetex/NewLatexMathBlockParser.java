package io.noties.markwon.ext.onetex;

import android.text.TextUtils;
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
public class NewLatexMathBlockParser extends AbstractBlockParser {
    private static final char SPACE = ' ';
    private static final String SYMBOL_END_NORMAL_BRACKET = "\\)";
    private static final String SYMBOL_END_SQUARE_BRACKET = "\\]";
    private static final String SYMBOL_START_NORMAL_BRACKET = "\\(";
    private static final String SYMBOL_START_SQUARE_BRACKET = "\\[";
    private final LatexMathBlock block = new LatexMathBlock();
    private final StringBuilder builder = new StringBuilder();
    private final String startSymbol;

    public NewLatexMathBlockParser(String str) {
        this.startSymbol = str;
    }

    public Block getBlock() {
        return this.block;
    }

    public BlockContinue tryContinue(ParserState parserState) {
        CharSequence line = parserState.getLine();
        if (TextUtils.isEmpty(line)) {
            return BlockContinue.finished();
        }
        int nextNonSpaceIndex = parserState.getNextNonSpaceIndex();
        int length = line.length();
        if (parserState.getIndent() < Parsing.CODE_BLOCK_INDENT && checkBlockEnd(line.subSequence(nextNonSpaceIndex, length).toString()) && Parsing.skip(SPACE, line, nextNonSpaceIndex + 2, length) == length) {
            return BlockContinue.finished();
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
            String obj = line.subSequence(nextNonSpaceIndex, length).toString();
            String str = NewLatexMathBlockParser.SYMBOL_START_SQUARE_BRACKET;
            if (!obj.startsWith(NewLatexMathBlockParser.SYMBOL_START_SQUARE_BRACKET)) {
                str = NewLatexMathBlockParser.SYMBOL_START_NORMAL_BRACKET;
                if (!obj.startsWith(NewLatexMathBlockParser.SYMBOL_START_NORMAL_BRACKET)) {
                    str = "";
                }
            }
            if (TextUtils.isEmpty(str)) {
                return BlockStart.none();
            }
            if (Parsing.skip(NewLatexMathBlockParser.SPACE, line, nextNonSpaceIndex + 2, length) != length) {
                return BlockStart.none();
            }
            return BlockStart.of(new BlockParser[]{new NewLatexMathBlockParser(str)}).atIndex(length + 1);
        }
    }

    private boolean checkBlockEnd(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        if (SYMBOL_START_NORMAL_BRACKET.equals(this.startSymbol) && str.startsWith(SYMBOL_END_NORMAL_BRACKET)) {
            return true;
        }
        return SYMBOL_START_SQUARE_BRACKET.equals(this.startSymbol) && str.startsWith(SYMBOL_END_SQUARE_BRACKET);
    }
}
