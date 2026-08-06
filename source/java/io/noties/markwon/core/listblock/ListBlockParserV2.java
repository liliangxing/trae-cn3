package io.noties.markwon.core.listblock;

import io.noties.markwon.html.tag.ImageGridHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.commonmark.internal.ListBlockParser;
import org.commonmark.internal.ListItemParser;
import org.commonmark.internal.util.Parsing;
import org.commonmark.node.BulletList;
import org.commonmark.node.ListBlock;
import org.commonmark.node.OrderedList;
import org.commonmark.parser.block.AbstractBlockParserFactory;
import org.commonmark.parser.block.BlockContinue;
import org.commonmark.parser.block.BlockParser;
import org.commonmark.parser.block.BlockStart;
import org.commonmark.parser.block.MatchedBlockParser;
import org.commonmark.parser.block.ParserState;

/* compiled from: ListBlockParserV2.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \t2\u00020\u0001:\u0004\t\n\u000b\fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lio/noties/markwon/core/listblock/ListBlockParserV2;", "Lorg/commonmark/internal/ListBlockParser;", "block", "Lorg/commonmark/node/ListBlock;", "(Lorg/commonmark/node/ListBlock;)V", "tryContinue", "Lorg/commonmark/parser/block/BlockContinue;", "state", "Lorg/commonmark/parser/block/ParserState;", "Companion", "Factory", "ListData", "ListMarkerData", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class ListBlockParserV2 extends ListBlockParser {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final ListBlock block;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ListBlockParserV2(ListBlock listBlock) {
        super(listBlock);
        Intrinsics.checkNotNullParameter(listBlock, "block");
        this.block = listBlock;
    }

    public BlockContinue tryContinue(ParserState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state.getIndent() < ListBlockExtKt.getIndent(this.block)) {
            BlockContinue.none();
        }
        return super.tryContinue(state);
    }

    /* compiled from: ListBlockParserV2.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lio/noties/markwon/core/listblock/ListBlockParserV2$Factory;", "Lorg/commonmark/parser/block/AbstractBlockParserFactory;", "()V", "tryStart", "Lorg/commonmark/parser/block/BlockStart;", "state", "Lorg/commonmark/parser/block/ParserState;", "matchedBlockParser", "Lorg/commonmark/parser/block/MatchedBlockParser;", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final class Factory extends AbstractBlockParserFactory {
        public BlockStart tryStart(ParserState state, MatchedBlockParser matchedBlockParser) {
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(matchedBlockParser, "matchedBlockParser");
            BlockParser matchedBlockParser2 = matchedBlockParser.getMatchedBlockParser();
            int nextNonSpaceIndex = state.getNextNonSpaceIndex();
            int column = state.getColumn() + state.getIndent();
            boolean z = matchedBlockParser.getParagraphContent() != null;
            Companion companion = ListBlockParserV2.INSTANCE;
            CharSequence line = state.getLine();
            Intrinsics.checkNotNullExpressionValue(line, "state.line");
            ListData parseList = companion.parseList(line, nextNonSpaceIndex, column, z, state.getIndent());
            if (parseList == null) {
                return BlockStart.none();
            }
            int contentColumn = parseList.getContentColumn();
            BlockParser listItemParser = new ListItemParser(contentColumn - state.getColumn());
            if (matchedBlockParser2 instanceof ListBlockParserV2) {
                Companion companion2 = ListBlockParserV2.INSTANCE;
                ListBlock block = matchedBlockParser2.getBlock();
                Intrinsics.checkNotNull(block, "null cannot be cast to non-null type org.commonmark.node.ListBlock");
                if (companion2.listsMatch(block, parseList.getListBlock())) {
                    return BlockStart.of(new BlockParser[]{listItemParser}).atColumn(contentColumn);
                }
            }
            BlockParser listBlockParserV2 = new ListBlockParserV2(parseList.getListBlock());
            parseList.getListBlock().setTight(true);
            return BlockStart.of(new BlockParser[]{listBlockParserV2, listItemParser}).atColumn(contentColumn);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ListBlockParserV2.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lio/noties/markwon/core/listblock/ListBlockParserV2$ListData;", "", "listBlock", "Lorg/commonmark/node/ListBlock;", "contentColumn", "", "(Lorg/commonmark/node/ListBlock;I)V", "getContentColumn", "()I", "getListBlock", "()Lorg/commonmark/node/ListBlock;", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final class ListData {
        private final int contentColumn;
        private final ListBlock listBlock;

        public ListData(ListBlock listBlock, int i) {
            Intrinsics.checkNotNullParameter(listBlock, "listBlock");
            this.listBlock = listBlock;
            this.contentColumn = i;
        }

        public final int getContentColumn() {
            return this.contentColumn;
        }

        public final ListBlock getListBlock() {
            return this.listBlock;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ListBlockParserV2.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lio/noties/markwon/core/listblock/ListBlockParserV2$ListMarkerData;", "", "listBlock", "Lorg/commonmark/node/ListBlock;", "indexAfterMarker", "", "(Lorg/commonmark/node/ListBlock;I)V", "getIndexAfterMarker", "()I", "getListBlock", "()Lorg/commonmark/node/ListBlock;", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final class ListMarkerData {
        private final int indexAfterMarker;
        private final ListBlock listBlock;

        public ListMarkerData(ListBlock listBlock, int i) {
            Intrinsics.checkNotNullParameter(listBlock, "listBlock");
            this.listBlock = listBlock;
            this.indexAfterMarker = i;
        }

        public final ListBlock getListBlock() {
            return this.listBlock;
        }

        public final int getIndexAfterMarker() {
            return this.indexAfterMarker;
        }
    }

    /* compiled from: ListBlockParserV2.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u0002J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\rH\u0002J2\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u000bH\u0002J\"\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000bH\u0002J\"\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000bH\u0002¨\u0006\u0017"}, d2 = {"Lio/noties/markwon/core/listblock/ListBlockParserV2$Companion;", "", "()V", "equals", "", "a", "b", "isSpaceTabOrEnd", "line", "", ImageGridHandler.Index, "", "listsMatch", "Lorg/commonmark/node/ListBlock;", "parseList", "Lio/noties/markwon/core/listblock/ListBlockParserV2$ListData;", "markerIndex", "markerColumn", "inParagraph", "indent", "parseListMarker", "Lio/noties/markwon/core/listblock/ListBlockParserV2$ListMarkerData;", "parseOrderedList", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final ListData parseList(CharSequence line, int markerIndex, int markerColumn, boolean inParagraph, int indent) {
            boolean z;
            ListMarkerData parseListMarker = parseListMarker(line, markerIndex, indent);
            if (parseListMarker == null) {
                return null;
            }
            ListBlock listBlock = parseListMarker.getListBlock();
            int indexAfterMarker = parseListMarker.getIndexAfterMarker();
            int i = markerColumn + (indexAfterMarker - markerIndex);
            int length = line.length();
            int i2 = i;
            while (true) {
                if (indexAfterMarker >= length) {
                    z = false;
                    break;
                }
                char charAt = line.charAt(indexAfterMarker);
                if (charAt != '\t') {
                    if (charAt != ' ') {
                        z = true;
                        break;
                    }
                    i2++;
                } else {
                    i2 += Parsing.columnsToNextTabStop(i2);
                }
                indexAfterMarker++;
            }
            if (inParagraph && !z) {
                return null;
            }
            if (!z || i2 - i > Parsing.CODE_BLOCK_INDENT) {
                i2 = i + 1;
            }
            return new ListData(listBlock, i2);
        }

        private final ListMarkerData parseListMarker(CharSequence line, int index, int indent) {
            char charAt = line.charAt(index);
            if ((charAt == '-' || charAt == '+') || charAt == '*') {
                int i = index + 1;
                if (isSpaceTabOrEnd(line, i)) {
                    ListBlock bulletList = new BulletList();
                    bulletList.setBulletMarker(charAt);
                    ListBlock listBlock = bulletList;
                    ListBlockExtKt.setIndent(listBlock, indent);
                    return new ListMarkerData(listBlock, i);
                }
                return null;
            }
            return parseOrderedList(line, index, indent);
        }

        private final ListMarkerData parseOrderedList(CharSequence line, int index, int indent) {
            int length = line.length();
            int i = 0;
            for (int i2 = index; i2 < length; i2++) {
                char charAt = line.charAt(i2);
                if (!(((((((((charAt == '0' || charAt == '1') || charAt == '2') || charAt == '3') || charAt == '4') || charAt == '5') || charAt == '6') || charAt == '7') || charAt == '8') || charAt == '9')) {
                    if (!(charAt == '.' || charAt == ')')) {
                        return null;
                    }
                    if (i >= 1) {
                        int i3 = i2 + 1;
                        if (isSpaceTabOrEnd(line, i3)) {
                            String obj = line.subSequence(index, i2).toString();
                            ListBlock orderedList = new OrderedList();
                            orderedList.setStartNumber(Integer.parseInt(obj));
                            orderedList.setDelimiter(charAt);
                            ListBlock listBlock = orderedList;
                            ListBlockExtKt.setIndent(listBlock, indent);
                            return new ListMarkerData(listBlock, i3);
                        }
                    }
                    return null;
                }
                i++;
                if (i > 9) {
                    return null;
                }
            }
            return null;
        }

        private final boolean isSpaceTabOrEnd(CharSequence line, int index) {
            if (index >= line.length()) {
                return true;
            }
            char charAt = line.charAt(index);
            return charAt == ' ' || charAt == '\t';
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean listsMatch(ListBlock a, ListBlock b) {
            if ((a instanceof BulletList) && (b instanceof BulletList)) {
                return equals(Character.valueOf(((BulletList) a).getBulletMarker()), Character.valueOf(((BulletList) b).getBulletMarker()));
            }
            if ((a instanceof OrderedList) && (b instanceof OrderedList)) {
                return equals(Character.valueOf(((OrderedList) a).getDelimiter()), Character.valueOf(((OrderedList) b).getDelimiter()));
            }
            return false;
        }

        private final boolean equals(Object a, Object b) {
            if (a == null) {
                return b == null;
            }
            return Intrinsics.areEqual(a, b);
        }
    }
}
