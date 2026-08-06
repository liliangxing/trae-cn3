package com.larus.business.markdown.impl.markwon.parser;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.commonmark.internal.HeadingParser;
import org.commonmark.internal.util.Parsing;
import org.commonmark.parser.block.BlockStart;
import org.commonmark.parser.block.MatchedBlockParser;
import org.commonmark.parser.block.ParserState;

/* compiled from: HeadingParserFactory2.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"Lcom/larus/business/markdown/impl/markwon/parser/HeadingParserFactory2;", "Lorg/commonmark/internal/HeadingParser$Factory;", "()V", "tryStart", "Lorg/commonmark/parser/block/BlockStart;", "state", "Lorg/commonmark/parser/block/ParserState;", "matchedBlockParser", "Lorg/commonmark/parser/block/MatchedBlockParser;", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class HeadingParserFactory2 extends HeadingParser.Factory {
    public BlockStart tryStart(ParserState state, MatchedBlockParser matchedBlockParser) {
        Intrinsics.checkNotNull(state);
        if (state.getIndent() >= Parsing.CODE_BLOCK_INDENT) {
            return BlockStart.none();
        }
        CharSequence line = state.getLine();
        if (line == null) {
            return BlockStart.none();
        }
        if (StringsKt.trim(line).length() <= 1) {
            return BlockStart.none();
        }
        return super.tryStart(state, matchedBlockParser);
    }
}
