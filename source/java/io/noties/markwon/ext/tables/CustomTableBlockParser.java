package io.noties.markwon.ext.tables;

import com.larus.business.markdown.api.depend.IMarkdownLogger;
import com.larus.business.markdown.api.depend.IMarkdownLoggerKt;
import com.lynx.tasm.behavior.PropsConstants;
import com.ss.android.update.UpdateDialogNewBase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import org.commonmark.ext.gfm.tables.TableBlock;
import org.commonmark.ext.gfm.tables.TableBody;
import org.commonmark.ext.gfm.tables.TableCell;
import org.commonmark.ext.gfm.tables.TableHead;
import org.commonmark.ext.gfm.tables.TableRow;
import org.commonmark.ext.gfm.tables.internal.TableBlockParser;
import org.commonmark.node.Block;
import org.commonmark.node.Node;
import org.commonmark.parser.InlineParser;
import org.commonmark.parser.block.AbstractBlockParser;
import org.commonmark.parser.block.BlockContinue;
import org.commonmark.parser.block.BlockParser;
import org.commonmark.parser.block.BlockStart;
import org.commonmark.parser.block.MatchedBlockParser;
import org.commonmark.parser.block.ParserState;

/* compiled from: CustomTableBlockParser.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 !2\u00020\u0001:\u0002!\"B-\b\u0002\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\fH\u0016J\b\u0010\u0012\u001a\u00020\u000eH\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J \u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lio/noties/markwon/ext/tables/CustomTableBlockParser;", "Lorg/commonmark/parser/block/AbstractBlockParser;", "columns", "", "Lorg/commonmark/ext/gfm/tables/TableCell$Alignment;", "headerCells", "", "(Ljava/util/List;Ljava/util/List;)V", "block", "Lorg/commonmark/ext/gfm/tables/TableBlock;", "bodyLines", "", "", "nextIsSeparatorLine", "", "addLine", "", "line", "canHaveLazyContinuationLines", "getBlock", "Lorg/commonmark/node/Block;", "parseCell", "Lorg/commonmark/ext/gfm/tables/TableCell;", "cell", "column", "", "inlineParser", "Lorg/commonmark/parser/InlineParser;", "parseInlines", "tryContinue", "Lorg/commonmark/parser/block/BlockContinue;", "state", "Lorg/commonmark/parser/block/ParserState;", "Companion", "Factory", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class CustomTableBlockParser extends AbstractBlockParser {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String LOG_TAG = "md_table";
    private final TableBlock block;
    private final List<CharSequence> bodyLines;
    private final List<TableCell.Alignment> columns;
    private final List<String> headerCells;
    private boolean nextIsSeparatorLine;

    public /* synthetic */ CustomTableBlockParser(List list, List list2, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, list2);
    }

    public boolean canHaveLazyContinuationLines() {
        return true;
    }

    /* synthetic */ CustomTableBlockParser(List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : list2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private CustomTableBlockParser(List<? extends TableCell.Alignment> list, List<String> list2) {
        this.columns = list;
        this.headerCells = list2;
        this.block = new TableBlock();
        this.bodyLines = new ArrayList();
        this.nextIsSeparatorLine = true;
    }

    public Block getBlock() {
        return this.block;
    }

    public BlockContinue tryContinue(ParserState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (StringsKt.contains$default(state.getLine().toString(), "|", false, 2, (Object) null)) {
            return BlockContinue.atIndex(state.getIndex());
        }
        return BlockContinue.none();
    }

    public void addLine(CharSequence line) {
        Intrinsics.checkNotNullParameter(line, "line");
        if (this.nextIsSeparatorLine) {
            this.nextIsSeparatorLine = false;
        } else {
            this.bodyLines.add(line);
        }
    }

    public void parseInlines(InlineParser inlineParser) {
        Intrinsics.checkNotNullParameter(inlineParser, "inlineParser");
        List<String> list = this.headerCells;
        Intrinsics.checkNotNull(list);
        int size = list.size();
        Node tableHead = new TableHead();
        this.block.appendChild(tableHead);
        Node tableRow = new TableRow();
        tableHead.appendChild(tableRow);
        for (int i = 0; i < size; i++) {
            TableCell parseCell = parseCell(this.headerCells.get(i), i, inlineParser);
            parseCell.setHeader(true);
            tableRow.appendChild((Node) parseCell);
        }
        Iterator<CharSequence> it = this.bodyLines.iterator();
        Node node = null;
        while (it.hasNext()) {
            List split = INSTANCE.split(it.next());
            Node tableRow2 = new TableRow();
            int i2 = 0;
            while (i2 < size) {
                tableRow2.appendChild((Node) parseCell(i2 < split.size() ? (String) split.get(i2) : "", i2, inlineParser));
                i2++;
            }
            if (node == null) {
                node = (Node) new TableBody();
                this.block.appendChild(node);
            }
            node.appendChild(tableRow2);
        }
    }

    private final TableCell parseCell(String cell, int column, InlineParser inlineParser) {
        Node tableCell = new TableCell();
        List<TableCell.Alignment> list = this.columns;
        Intrinsics.checkNotNull(list);
        if (column < list.size()) {
            tableCell.setAlignment(this.columns.get(column));
        }
        String str = cell;
        int length = str.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean z2 = Intrinsics.compare(str.charAt(!z ? i : length), 32) <= 0;
            if (z) {
                if (!z2) {
                    break;
                }
                length--;
            } else if (z2) {
                i++;
            } else {
                z = true;
            }
        }
        inlineParser.parse(str.subSequence(i, length + 1).toString(), tableCell);
        return tableCell;
    }

    /* compiled from: CustomTableBlockParser.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0002J\u001a\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b2\u0006\u0010\u000f\u001a\u00020\rH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lio/noties/markwon/ext/tables/CustomTableBlockParser$Companion;", "", "()V", "LOG_TAG", "", "getAlignment", "Lorg/commonmark/ext/gfm/tables/TableCell$Alignment;", PropsConstants.HIT_SLOP_LEFT, "", PropsConstants.HIT_SLOP_RIGHT, "parseSeparator", "", "s", "", "split", "input", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<String> split(CharSequence input) {
            String obj = input.toString();
            int length = obj.length() - 1;
            int i = 0;
            boolean z = false;
            while (i <= length) {
                boolean z2 = Intrinsics.compare(obj.charAt(!z ? i : length), 32) <= 0;
                if (z) {
                    if (!z2) {
                        break;
                    }
                    length--;
                } else if (z2) {
                    i++;
                } else {
                    z = true;
                }
            }
            String obj2 = obj.subSequence(i, length + 1).toString();
            if (StringsKt.startsWith$default(obj2, "|", false, 2, (Object) null)) {
                if (obj2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                obj2 = obj2.substring(1);
                Intrinsics.checkNotNullExpressionValue(obj2, "(this as java.lang.String).substring(startIndex)");
            }
            ArrayList arrayList = new ArrayList();
            StringBuilder sb = new StringBuilder();
            int i2 = 0;
            while (i2 < obj2.length()) {
                char charAt = obj2.charAt(i2);
                if (charAt == '\\') {
                    int i3 = i2 + 1;
                    if (i3 < obj2.length() && obj2.charAt(i3) == '|') {
                        sb.append('|');
                        i2 = i3;
                    } else {
                        sb.append('\\');
                    }
                } else if (charAt == '|') {
                    String sb2 = sb.toString();
                    Intrinsics.checkNotNullExpressionValue(sb2, "sb.toString()");
                    arrayList.add(sb2);
                    sb.setLength(0);
                } else {
                    sb.append(charAt);
                }
                i2++;
            }
            if (sb.length() > 0) {
                String sb3 = sb.toString();
                Intrinsics.checkNotNullExpressionValue(sb3, "sb.toString()");
                arrayList.add(sb3);
            }
            return arrayList;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<TableCell.Alignment> parseSeparator(CharSequence s) {
            boolean z;
            ArrayList arrayList = new ArrayList();
            int i = 0;
            boolean z2 = false;
            int i2 = 0;
            while (i < s.length()) {
                char charAt = s.charAt(i);
                boolean z3 = true;
                if (charAt == '|') {
                    i++;
                    i2++;
                    if (i2 > 1) {
                        return null;
                    }
                    z2 = true;
                } else {
                    if (!(charAt == '-' || charAt == ':')) {
                        if (charAt != ' ' && charAt != '\t') {
                            z3 = false;
                        }
                        if (!z3) {
                            return null;
                        }
                        i++;
                    } else {
                        if (i2 == 0 && !arrayList.isEmpty()) {
                            return null;
                        }
                        if (charAt == ':') {
                            i++;
                            z = true;
                        } else {
                            z = false;
                        }
                        boolean z4 = false;
                        while (i < s.length() && s.charAt(i) == '-') {
                            i++;
                            z4 = true;
                        }
                        if (!z4) {
                            return null;
                        }
                        if (i >= s.length() || s.charAt(i) != ':') {
                            z3 = false;
                        } else {
                            i++;
                        }
                        arrayList.add(getAlignment(z, z3));
                        i2 = 0;
                    }
                }
            }
            if (z2) {
                return arrayList;
            }
            return null;
        }

        private final TableCell.Alignment getAlignment(boolean left, boolean right) {
            if (left && right) {
                return TableCell.Alignment.CENTER;
            }
            if (left) {
                return TableCell.Alignment.LEFT;
            }
            if (right) {
                return TableCell.Alignment.RIGHT;
            }
            return null;
        }
    }

    /* compiled from: CustomTableBlockParser.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lio/noties/markwon/ext/tables/CustomTableBlockParser$Factory;", "Lorg/commonmark/ext/gfm/tables/internal/TableBlockParser$Factory;", "()V", "tryStart", "Lorg/commonmark/parser/block/BlockStart;", "state", "Lorg/commonmark/parser/block/ParserState;", "matchedBlockParser", "Lorg/commonmark/parser/block/MatchedBlockParser;", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static final class Factory extends TableBlockParser.Factory {
        @Override // org.commonmark.ext.gfm.tables.internal.TableBlockParser.Factory
        public BlockStart tryStart(ParserState state, MatchedBlockParser matchedBlockParser) {
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(matchedBlockParser, "matchedBlockParser");
            CharSequence line = state.getLine();
            CharSequence paragraphContent = matchedBlockParser.getParagraphContent();
            if (paragraphContent == null) {
                return BlockStart.none();
            }
            DefaultConstructorMarker defaultConstructorMarker = null;
            StringBuilder sb = paragraphContent instanceof StringBuilder ? (StringBuilder) paragraphContent : null;
            if (sb == null) {
                IMarkdownLogger markdownLoggerDelegate = IMarkdownLoggerKt.getMarkdownLoggerDelegate();
                if (markdownLoggerDelegate != null) {
                    markdownLoggerDelegate.e(CustomTableBlockParser.LOG_TAG, "paragraph content type:" + Reflection.getOrCreateKotlinClass(paragraphContent.getClass()).getQualifiedName() + "; value:" + ((Object) paragraphContent));
                }
                return super.tryStart(state, matchedBlockParser);
            }
            String str = (String) CollectionsKt.last(StringsKt.split$default(paragraphContent, new String[]{UpdateDialogNewBase.TYPE}, false, 0, 6, (Object) null));
            String str2 = str;
            if (StringsKt.contains$default(str2, "|", false, 2, (Object) null)) {
                List parseSeparator = CustomTableBlockParser.INSTANCE.parseSeparator(line.subSequence(state.getIndex(), line.length()));
                List list = parseSeparator;
                if (!(list == null || list.isEmpty())) {
                    List split = CustomTableBlockParser.INSTANCE.split(str2);
                    if (parseSeparator.size() >= split.size()) {
                        int length = sb.length();
                        int length2 = length - str.length();
                        if (length2 > 0 && paragraphContent.charAt(length2 - 1) == '\n') {
                            length2--;
                        }
                        sb.delete(length2, length);
                        return BlockStart.of(new BlockParser[]{(BlockParser) new CustomTableBlockParser(parseSeparator, split, defaultConstructorMarker)}).atIndex(state.getIndex());
                    }
                }
            }
            return BlockStart.none();
        }
    }
}
