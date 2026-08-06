package io.noties.markwon.maybe;

import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.commonmark.internal.FencedCodeBlockParser;
import org.commonmark.internal.util.Parsing;
import org.commonmark.node.FencedCodeBlock;
import org.commonmark.parser.block.AbstractBlockParserFactory;
import org.commonmark.parser.block.BlockContinue;
import org.commonmark.parser.block.BlockParser;
import org.commonmark.parser.block.BlockStart;
import org.commonmark.parser.block.MatchedBlockParser;
import org.commonmark.parser.block.ParserState;

/* compiled from: MaybeFencedCodeBlockParser.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00142\u00020\u0001:\u0002\u0014\u0015B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0005H\u0002J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lio/noties/markwon/maybe/MaybeFencedCodeBlockParser;", "Lorg/commonmark/internal/FencedCodeBlockParser;", "fenceChar", "", "fenceLength", "", "fenceIndent", "(CII)V", "lastMatchedLine", "", "addLine", "", "line", "isClosing", "", "index", "tryContinue", "Lorg/commonmark/parser/block/BlockContinue;", "state", "Lorg/commonmark/parser/block/ParserState;", "Companion", "Factory", "markwon-maybe_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class MaybeFencedCodeBlockParser extends FencedCodeBlockParser {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Pattern pattern;
    private CharSequence lastMatchedLine;

    public MaybeFencedCodeBlockParser(char c, int i, int i2) {
        super(c, i, i2);
    }

    /* compiled from: MaybeFencedCodeBlockParser.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/noties/markwon/maybe/MaybeFencedCodeBlockParser$Companion;", "", "()V", "pattern", "Ljava/util/regex/Pattern;", "pattern$annotations", "getPattern", "()Ljava/util/regex/Pattern;", "markwon-maybe_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static final class Companion {
        public static /* synthetic */ void pattern$annotations() {
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Pattern getPattern() {
            return MaybeFencedCodeBlockParser.pattern;
        }
    }

    static {
        Pattern compile = Pattern.compile("^`{1,2}$");
        Intrinsics.checkExpressionValueIsNotNull(compile, "Pattern.compile(\"^`{1,2}$\")");
        pattern = compile;
    }

    public void addLine(CharSequence line) {
        Intrinsics.checkParameterIsNotNull(line, "line");
        CharSequence charSequence = this.lastMatchedLine;
        if (!(charSequence == null || charSequence.length() == 0)) {
            super.addLine(this.lastMatchedLine);
            this.lastMatchedLine = null;
        }
        if (pattern.matcher(StringsKt.trim(line, new char[]{' '})).matches()) {
            this.lastMatchedLine = line;
        } else {
            super.addLine(line);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public BlockContinue tryContinue(ParserState state) {
        boolean z;
        Intrinsics.checkParameterIsNotNull(state, "state");
        CharSequence line = state.getLine();
        int nextNonSpaceIndex = state.getNextNonSpaceIndex();
        if (state.getIndent() < Parsing.CODE_BLOCK_INDENT) {
            Intrinsics.checkExpressionValueIsNotNull(line, "line");
            if (isClosing(line, nextNonSpaceIndex)) {
                z = true;
                if (!z) {
                    CharSequence charSequence = this.lastMatchedLine;
                    if (charSequence != null) {
                        if (charSequence.length() > 0) {
                            addLine(charSequence);
                            this.lastMatchedLine = null;
                        }
                    }
                    return BlockContinue.finished();
                }
                return super.tryContinue(state);
            }
        }
        z = false;
        if (!z) {
        }
    }

    private final boolean isClosing(CharSequence line, int index) {
        FencedCodeBlock block = getBlock();
        if (block == null) {
            throw new TypeCastException("null cannot be cast to non-null type org.commonmark.node.FencedCodeBlock");
        }
        char fenceChar = block.getFenceChar();
        FencedCodeBlock block2 = getBlock();
        if (block2 == null) {
            throw new TypeCastException("null cannot be cast to non-null type org.commonmark.node.FencedCodeBlock");
        }
        int fenceLength = block2.getFenceLength();
        int skip = Parsing.skip(fenceChar, line, index, line.length()) - index;
        return skip >= fenceLength && Parsing.skipSpaceTab(line, index + skip, line.length()) == line.length();
    }

    /* compiled from: MaybeFencedCodeBlockParser.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lio/noties/markwon/maybe/MaybeFencedCodeBlockParser$Factory;", "Lorg/commonmark/parser/block/AbstractBlockParserFactory;", "()V", "tryStart", "Lorg/commonmark/parser/block/BlockStart;", "state", "Lorg/commonmark/parser/block/ParserState;", "matchedBlockParser", "Lorg/commonmark/parser/block/MatchedBlockParser;", "markwon-maybe_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static final class Factory extends AbstractBlockParserFactory {
        public BlockStart tryStart(ParserState state, MatchedBlockParser matchedBlockParser) {
            BlockParser checkOpener;
            Intrinsics.checkParameterIsNotNull(state, "state");
            Intrinsics.checkParameterIsNotNull(matchedBlockParser, "matchedBlockParser");
            int indent = state.getIndent();
            if (indent >= Parsing.CODE_BLOCK_INDENT) {
                return BlockStart.none();
            }
            int nextNonSpaceIndex = state.getNextNonSpaceIndex();
            CharSequence line = state.getLine();
            Intrinsics.checkExpressionValueIsNotNull(line, "state.line");
            checkOpener = MaybeFencedCodeBlockParserKt.checkOpener(line, nextNonSpaceIndex, indent);
            if (checkOpener == null) {
                return BlockStart.none();
            }
            BlockStart of = BlockStart.of(new BlockParser[]{checkOpener});
            FencedCodeBlock block = checkOpener.getBlock();
            if (block != null) {
                return of.atIndex(nextNonSpaceIndex + block.getFenceLength());
            }
            throw new TypeCastException("null cannot be cast to non-null type org.commonmark.node.FencedCodeBlock");
        }
    }
}
