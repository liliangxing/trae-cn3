package io.noties.markwon.html.customdata;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.commonmark.node.HtmlBlock;
import org.commonmark.parser.block.AbstractBlockParser;
import org.commonmark.parser.block.AbstractBlockParserFactory;
import org.commonmark.parser.block.BlockContinue;
import org.commonmark.parser.block.BlockParser;
import org.commonmark.parser.block.BlockStart;
import org.commonmark.parser.block.MatchedBlockParser;
import org.commonmark.parser.block.ParserState;

/* compiled from: CustomDataBlockParser.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0015B\u0011\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u000f\u001a\u00020\fH\u0016J\b\u0010\u0010\u001a\u00020\u0006H\u0016J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lio/noties/markwon/html/customdata/CustomDataBlockParser;", "Lorg/commonmark/parser/block/AbstractBlockParser;", "closingPattern", "Ljava/util/regex/Pattern;", "(Ljava/util/regex/Pattern;)V", "block", "Lorg/commonmark/node/HtmlBlock;", "content", "Lio/noties/markwon/html/customdata/BlockContent;", "finished", "", "addLine", "", "line", "", "closeBlock", "getBlock", "tryContinue", "Lorg/commonmark/parser/block/BlockContinue;", "state", "Lorg/commonmark/parser/block/ParserState;", "Factory", "markwon-html_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class CustomDataBlockParser extends AbstractBlockParser {
    private final HtmlBlock block;
    private final Pattern closingPattern;
    private BlockContent content;
    private boolean finished;

    public /* synthetic */ CustomDataBlockParser(Pattern pattern, DefaultConstructorMarker defaultConstructorMarker) {
        this(pattern);
    }

    private CustomDataBlockParser(Pattern pattern) {
        this.closingPattern = pattern;
        this.block = new HtmlBlock();
        this.content = new BlockContent();
    }

    public HtmlBlock getBlock() {
        return this.block;
    }

    public BlockContinue tryContinue(ParserState state) {
        Intrinsics.checkParameterIsNotNull(state, "state");
        if (this.finished) {
            return BlockContinue.none();
        }
        if (state.isBlank() && this.closingPattern == null) {
            return BlockContinue.none();
        }
        return BlockContinue.atIndex(state.getIndex());
    }

    public void addLine(CharSequence line) {
        this.content.add(line);
        Pattern pattern = this.closingPattern;
        if (pattern == null || !pattern.matcher(line).find()) {
            return;
        }
        this.finished = true;
    }

    public void closeBlock() {
        this.block.setLiteral(this.content.getString());
    }

    /* compiled from: CustomDataBlockParser.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, d2 = {"Lio/noties/markwon/html/customdata/CustomDataBlockParser$Factory;", "Lorg/commonmark/parser/block/AbstractBlockParserFactory;", "()V", "customBlockTags", "", "", "getCustomBlockTags", "()Ljava/util/Set;", "tryStart", "Lorg/commonmark/parser/block/BlockStart;", "state", "Lorg/commonmark/parser/block/ParserState;", "matchedBlockParser", "Lorg/commonmark/parser/block/MatchedBlockParser;", "markwon-html_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final class Factory extends AbstractBlockParserFactory {
        private final Set<String> customBlockTags = new LinkedHashSet();

        public final Set<String> getCustomBlockTags() {
            return this.customBlockTags;
        }

        public BlockStart tryStart(ParserState state, MatchedBlockParser matchedBlockParser) {
            Intrinsics.checkParameterIsNotNull(state, "state");
            int nextNonSpaceIndex = state.getNextNonSpaceIndex();
            CharSequence line = state.getLine();
            if (state.getIndent() < 4 && line.charAt(nextNonSpaceIndex) == '<') {
                for (String str : this.customBlockTags) {
                    Pattern compile = Pattern.compile("^<(?:" + str + ")(?:\\s|>|$)", 2);
                    Pattern compile2 = Pattern.compile("</(?:" + str + ")>", 2);
                    if (compile.matcher(line.subSequence(nextNonSpaceIndex, line.length())).find()) {
                        return BlockStart.of(new BlockParser[]{(BlockParser) new CustomDataBlockParser(compile2, null)}).atIndex(state.getIndex());
                    }
                }
            }
            return BlockStart.none();
        }
    }
}
