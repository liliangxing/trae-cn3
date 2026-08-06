package io.noties.markwon.ext.onetex;

import io.noties.markwon.ext.onetex.LatexMathBlockParser;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.commonmark.internal.BlockStartImpl;
import org.commonmark.parser.block.BlockContinue;
import org.commonmark.parser.block.BlockParser;
import org.commonmark.parser.block.BlockStart;
import org.commonmark.parser.block.MatchedBlockParser;
import org.commonmark.parser.block.ParserState;

/* compiled from: LatexMathBlockParser2.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\tB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\n"}, d2 = {"Lio/noties/markwon/ext/onetex/LatexMathBlockParser2;", "Lio/noties/markwon/ext/onetex/LatexMathBlockParser;", "signs", "", "(I)V", "tryContinue", "Lorg/commonmark/parser/block/BlockContinue;", "parserState", "Lorg/commonmark/parser/block/ParserState;", "Factory", "markdown-latex_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class LatexMathBlockParser2 extends LatexMathBlockParser {
    public LatexMathBlockParser2(int i) {
        super(i);
    }

    @Override // io.noties.markwon.ext.onetex.LatexMathBlockParser
    public BlockContinue tryContinue(ParserState parserState) {
        Intrinsics.checkNotNullParameter(parserState, "parserState");
        CharSequence line = parserState.getLine();
        if (line == null || StringsKt.isBlank(line)) {
            BlockContinue finished = BlockContinue.finished();
            Intrinsics.checkNotNullExpressionValue(finished, "finished()");
            return finished;
        }
        BlockContinue tryContinue = super.tryContinue(parserState);
        Intrinsics.checkNotNullExpressionValue(tryContinue, "super.tryContinue(parserState)");
        return tryContinue;
    }

    /* compiled from: LatexMathBlockParser2.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\n"}, d2 = {"Lio/noties/markwon/ext/onetex/LatexMathBlockParser2$Factory;", "Lio/noties/markwon/ext/onetex/LatexMathBlockParser$Factory;", "()V", "tryStart", "Lorg/commonmark/parser/block/BlockStart;", "state", "Lorg/commonmark/parser/block/ParserState;", "matchedBlockParser", "Lorg/commonmark/parser/block/MatchedBlockParser;", "Companion", "markdown-latex_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static final class Factory extends LatexMathBlockParser.Factory {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final char DOLLAR = '$';
        private static final char SPACE = ' ';

        @Override // io.noties.markwon.ext.onetex.LatexMathBlockParser.Factory
        public BlockStart tryStart(ParserState state, MatchedBlockParser matchedBlockParser) {
            Intrinsics.checkNotNullParameter(state, "state");
            BlockStartImpl tryStart = super.tryStart(state, matchedBlockParser);
            if (!(tryStart instanceof BlockStartImpl)) {
                return tryStart;
            }
            int nextNonSpaceIndex = state.getNextNonSpaceIndex();
            CharSequence line = state.getLine();
            int length = line.length();
            Companion companion = INSTANCE;
            Intrinsics.checkNotNullExpressionValue(line, "line");
            BlockStartImpl blockStartImpl = tryStart;
            BlockStart atIndex = BlockStart.of(new BlockParser[]{(BlockParser) new LatexMathBlockParser2(companion.consume(DOLLAR, line, nextNonSpaceIndex, length))}).atColumn(blockStartImpl.getNewColumn()).atIndex(blockStartImpl.getNewIndex());
            if (blockStartImpl.isReplaceActiveBlockParser()) {
                atIndex.replaceActiveBlockParser();
            }
            return atIndex;
        }

        /* compiled from: LatexMathBlockParser2.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lio/noties/markwon/ext/onetex/LatexMathBlockParser2$Factory$Companion;", "", "()V", "DOLLAR", "", "SPACE", "consume", "", "c", "line", "", "start", "end", "markdown-latex_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final int consume(char c, CharSequence line, int start, int end) {
                for (int i = start; i < end; i++) {
                    if (c != line.charAt(i)) {
                        return i - start;
                    }
                }
                return end - start;
            }
        }
    }
}
