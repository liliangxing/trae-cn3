package io.noties.markwon.ext.tables;

import android.text.Spanned;
import android.widget.TextView;
import com.lynx.tasm.behavior.PropsConstants;
import com.ss.android.update.UpdateDialogNewBase;
import io.noties.markwon.AbstractMarkwonPlugin;
import io.noties.markwon.MarkwonVisitor;
import io.noties.markwon.ext.tables.TablePlugin2;
import io.noties.markwon.scrollable.HorizontalScrollable;
import io.noties.markwon.scrollable.ScrollBarTheme;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.commonmark.ext.gfm.tables.TableBlock;
import org.commonmark.ext.gfm.tables.TableBody;
import org.commonmark.ext.gfm.tables.TableCell;
import org.commonmark.ext.gfm.tables.TableHead;
import org.commonmark.ext.gfm.tables.TableRow;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;

/* compiled from: TablePlugin2.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0003\u0017\u0018\u0019B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0016H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00060\nR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lio/noties/markwon/ext/tables/TablePlugin2;", "Lio/noties/markwon/AbstractMarkwonPlugin;", "tableTheme", "Lio/noties/markwon/ext/tables/TableTheme2;", "scrollBarTheme", "Lio/noties/markwon/scrollable/ScrollBarTheme;", "tableOptions", "Lio/noties/markwon/ext/tables/TableOptions;", "(Lio/noties/markwon/ext/tables/TableTheme2;Lio/noties/markwon/scrollable/ScrollBarTheme;Lio/noties/markwon/ext/tables/TableOptions;)V", "visitor", "Lio/noties/markwon/ext/tables/TablePlugin2$TableVisitor;", "afterSetText", "", "textView", "Landroid/widget/TextView;", "beforeSetText", "markdown", "Landroid/text/Spanned;", "configureParser", "builder", "Lorg/commonmark/parser/Parser$Builder;", "configureVisitor", "Lio/noties/markwon/MarkwonVisitor$Builder;", "Cell", "Row", "TableVisitor", "markwon-ext-tables_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class TablePlugin2 extends AbstractMarkwonPlugin {
    private final ScrollBarTheme scrollBarTheme;
    private final TableOptions tableOptions;
    private final TableTheme2 tableTheme;
    private final TableVisitor visitor;

    public /* synthetic */ TablePlugin2(TableTheme2 tableTheme2, ScrollBarTheme scrollBarTheme, TableOptions tableOptions, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(tableTheme2, scrollBarTheme, (i & 4) != 0 ? new TableOptions(false, 1, null) : tableOptions);
    }

    public TablePlugin2(TableTheme2 tableTheme2, ScrollBarTheme scrollBarTheme, TableOptions tableOptions) {
        Intrinsics.checkParameterIsNotNull(tableTheme2, "tableTheme");
        Intrinsics.checkParameterIsNotNull(scrollBarTheme, "scrollBarTheme");
        Intrinsics.checkParameterIsNotNull(tableOptions, "tableOptions");
        this.tableTheme = tableTheme2;
        this.scrollBarTheme = scrollBarTheme;
        this.tableOptions = tableOptions;
        this.visitor = new TableVisitor();
    }

    public void configureParser(Parser.Builder builder) {
        Intrinsics.checkParameterIsNotNull(builder, "builder");
        builder.extensions(SetsKt.setOf(new TablesExtension2(this.tableOptions)));
    }

    public void configureVisitor(MarkwonVisitor.Builder builder) {
        Intrinsics.checkParameterIsNotNull(builder, "builder");
        this.visitor.configure(builder);
    }

    public void beforeSetText(TextView textView, Spanned markdown) {
        Intrinsics.checkParameterIsNotNull(textView, "textView");
        Intrinsics.checkParameterIsNotNull(markdown, "markdown");
        TableRowsScheduler.unschedule(textView);
    }

    public void afterSetText(TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "textView");
        TableRowsScheduler.schedule(textView);
    }

    /* compiled from: TablePlugin2.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\r\u001a\u00020\u000eH\u0002J\u000e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011J\u0018\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0018\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lio/noties/markwon/ext/tables/TablePlugin2$TableVisitor;", "", "(Lio/noties/markwon/ext/tables/TablePlugin2;)V", "pendingRow", "", "Lio/noties/markwon/ext/tables/TablePlugin2$Cell;", "pendingTable", "Lio/noties/markwon/ext/tables/TablePlugin2$Row;", "tableBodyIndex", "", "tableRowIndex", "tableRowIsHeader", "", "clear", "", "configure", "builder", "Lio/noties/markwon/MarkwonVisitor$Builder;", "visitRow", "visitor", "Lio/noties/markwon/MarkwonVisitor;", "node", "Lorg/commonmark/node/Node;", "visitTable", "markwon-ext-tables_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    private final class TableVisitor {
        private final List<Cell> pendingRow = new ArrayList();
        private final List<Row> pendingTable = new ArrayList();
        private int tableBodyIndex;
        private int tableRowIndex;
        private boolean tableRowIsHeader;

        public TableVisitor() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void clear() {
            this.pendingRow.clear();
            this.pendingTable.clear();
            this.tableRowIsHeader = false;
            this.tableRowIndex = 0;
            this.tableBodyIndex = 0;
        }

        public final void configure(MarkwonVisitor.Builder builder) {
            Intrinsics.checkParameterIsNotNull(builder, "builder");
            builder.on(TableBlock.class, new MarkwonVisitor.NodeVisitor<TableBlock>() { // from class: io.noties.markwon.ext.tables.TablePlugin2$TableVisitor$configure$1
                public final void visit(MarkwonVisitor markwonVisitor, TableBlock tableBlock) {
                    Intrinsics.checkParameterIsNotNull(markwonVisitor, "visitor");
                    Intrinsics.checkParameterIsNotNull(tableBlock, "tableBlock");
                    TablePlugin2.TableVisitor.this.clear();
                    Node node = (Node) tableBlock;
                    markwonVisitor.blockStart(node);
                    TablePlugin2.TableVisitor.this.visitTable(markwonVisitor, node);
                    markwonVisitor.blockEnd(node);
                    TablePlugin2.TableVisitor.this.clear();
                }
            }).on(TableTitle.class, new MarkwonVisitor.NodeVisitor<TableTitle>() { // from class: io.noties.markwon.ext.tables.TablePlugin2$TableVisitor$configure$2
                public final void visit(MarkwonVisitor markwonVisitor, TableTitle tableTitle) {
                    Intrinsics.checkParameterIsNotNull(markwonVisitor, "visitor");
                    Intrinsics.checkParameterIsNotNull(tableTitle, "tableTitle");
                    markwonVisitor.visitChildren((Node) tableTitle);
                }
            }).on(TableBody.class, new MarkwonVisitor.NodeVisitor<TableBody>() { // from class: io.noties.markwon.ext.tables.TablePlugin2$TableVisitor$configure$3
                public final void visit(MarkwonVisitor markwonVisitor, TableBody tableBody) {
                    Intrinsics.checkParameterIsNotNull(markwonVisitor, "visitor");
                    Intrinsics.checkParameterIsNotNull(tableBody, "tableBody");
                    markwonVisitor.visitChildren((Node) tableBody);
                }
            }).on(TableRow.class, new MarkwonVisitor.NodeVisitor<TableRow>() { // from class: io.noties.markwon.ext.tables.TablePlugin2$TableVisitor$configure$4
                public final void visit(MarkwonVisitor markwonVisitor, TableRow tableRow) {
                    Intrinsics.checkParameterIsNotNull(markwonVisitor, "visitor");
                    Intrinsics.checkParameterIsNotNull(tableRow, "tableRow");
                    TablePlugin2.TableVisitor.this.visitRow(markwonVisitor, (Node) tableRow);
                }
            }).on(TableHead.class, new MarkwonVisitor.NodeVisitor<TableHead>() { // from class: io.noties.markwon.ext.tables.TablePlugin2$TableVisitor$configure$5
                public final void visit(MarkwonVisitor markwonVisitor, TableHead tableHead) {
                    Intrinsics.checkParameterIsNotNull(markwonVisitor, "visitor");
                    Intrinsics.checkParameterIsNotNull(tableHead, "tableHead");
                    TablePlugin2.TableVisitor.this.tableRowIsHeader = true;
                    markwonVisitor.visitChildren((Node) tableHead);
                    TablePlugin2.TableVisitor.this.tableRowIsHeader = false;
                }
            }).on(TableCell.class, new MarkwonVisitor.NodeVisitor<TableCell>() { // from class: io.noties.markwon.ext.tables.TablePlugin2$TableVisitor$configure$6
                public final void visit(MarkwonVisitor markwonVisitor, TableCell tableCell) {
                    List list;
                    Intrinsics.checkParameterIsNotNull(markwonVisitor, "visitor");
                    Intrinsics.checkParameterIsNotNull(tableCell, "tableCell");
                    int length = markwonVisitor.length();
                    markwonVisitor.visitChildren((Node) tableCell);
                    list = TablePlugin2.TableVisitor.this.pendingRow;
                    int tableCellAlignment = AlignmentKt.tableCellAlignment(tableCell.getAlignment());
                    CharSequence removeFromEnd = markwonVisitor.builder().removeFromEnd(length);
                    Intrinsics.checkExpressionValueIsNotNull(removeFromEnd, "visitor.builder().removeFromEnd(length)");
                    list.add(new TablePlugin2.Cell(tableCellAlignment, removeFromEnd));
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void visitRow(MarkwonVisitor visitor, Node node) {
            visitor.visitChildren(node);
            this.pendingTable.add(new Row(this.tableRowIndex, CollectionsKt.toList(this.pendingRow), this.tableRowIsHeader));
            this.tableRowIndex++;
            this.pendingRow.clear();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void visitTable(MarkwonVisitor visitor, Node node) {
            int length = visitor.length();
            visitor.visitChildren(node);
            HorizontalScrollable horizontalScrollable = new HorizontalScrollable(0.0f);
            List list = CollectionsKt.toList(this.pendingTable);
            for (Row row : this.pendingTable) {
                int length2 = visitor.length();
                if (TablePlugin2.this.tableTheme.getPlaceholderStyle() == 1) {
                    for (Cell cell : row.getCells()) {
                        int length3 = visitor.length();
                        visitor.builder().append(StringsKt.replace$default(cell.getText().toString(), UpdateDialogNewBase.TYPE, " ", false, 4, (Object) null)).append(" ");
                        cell.setStart$markwon_ext_tables_release(length3);
                        cell.setEnd$markwon_ext_tables_release(visitor.length() - 1);
                    }
                } else {
                    visitor.builder().append("|");
                    for (Cell cell2 : row.getCells()) {
                        int length4 = visitor.length();
                        visitor.builder().append(" ").append(StringsKt.replace$default(cell2.getText().toString(), UpdateDialogNewBase.TYPE, " ", false, 4, (Object) null)).append(" |");
                        cell2.setStart$markwon_ext_tables_release(length4);
                        cell2.setEnd$markwon_ext_tables_release(visitor.length() - 1);
                    }
                }
                visitor.ensureNewLine();
                visitor.setSpans(length2, new TableRowSpan2(TablePlugin2.this.tableTheme, TablePlugin2.this.scrollBarTheme, list, row, horizontalScrollable));
            }
            visitor.setSpans(length, horizontalScrollable);
            visitor.setSpans(length, new TableSpan());
        }
    }

    /* compiled from: TablePlugin2.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\r\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\rR$\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u000e@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u0014\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\b\"\u0004\b\u0016\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006\""}, d2 = {"Lio/noties/markwon/ext/tables/TablePlugin2$Cell;", "", "alignment", "", PropsConstants.TEXT, "", "(ILjava/lang/CharSequence;)V", "getAlignment", "()I", "<set-?>", "end", "getEnd", "setEnd$markwon_ext_tables_release", "(I)V", "", "maxWidth", "getMaxWidth", "()F", "setMaxWidth$markwon_ext_tables_release", "(F)V", "start", "getStart", "setStart$markwon_ext_tables_release", "getText", "()Ljava/lang/CharSequence;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "markwon-ext-tables_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static final /* data */ class Cell {
        private final int alignment;
        private int end;
        private float maxWidth;
        private int start;
        private final CharSequence text;

        public static /* synthetic */ Cell copy$default(Cell cell, int i, CharSequence charSequence, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = cell.alignment;
            }
            if ((i2 & 2) != 0) {
                charSequence = cell.text;
            }
            return cell.copy(i, charSequence);
        }

        /* renamed from: component1, reason: from getter */
        public final int getAlignment() {
            return this.alignment;
        }

        /* renamed from: component2, reason: from getter */
        public final CharSequence getText() {
            return this.text;
        }

        public final Cell copy(int alignment, CharSequence text) {
            Intrinsics.checkParameterIsNotNull(text, PropsConstants.TEXT);
            return new Cell(alignment, text);
        }

        public boolean equals(Object other) {
            if (this != other) {
                if (other instanceof Cell) {
                    Cell cell = (Cell) other;
                    if (!(this.alignment == cell.alignment) || !Intrinsics.areEqual(this.text, cell.text)) {
                    }
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i = this.alignment * 31;
            CharSequence charSequence = this.text;
            return i + (charSequence != null ? charSequence.hashCode() : 0);
        }

        public String toString() {
            return "Cell(alignment=" + this.alignment + ", text=" + this.text + ")";
        }

        public Cell(int i, CharSequence charSequence) {
            Intrinsics.checkParameterIsNotNull(charSequence, PropsConstants.TEXT);
            this.alignment = i;
            this.text = charSequence;
            this.start = -1;
            this.end = -1;
        }

        public final int getAlignment() {
            return this.alignment;
        }

        public final CharSequence getText() {
            return this.text;
        }

        public final int getStart() {
            return this.start;
        }

        public final void setStart$markwon_ext_tables_release(int i) {
            this.start = i;
        }

        public final int getEnd() {
            return this.end;
        }

        public final void setEnd$markwon_ext_tables_release(int i) {
            this.end = i;
        }

        public final float getMaxWidth() {
            return this.maxWidth;
        }

        public final void setMaxWidth$markwon_ext_tables_release(float f) {
            this.maxWidth = f;
        }
    }

    /* compiled from: TablePlugin2.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\bHÆ\u0003J-\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0013\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u000e¨\u0006\u0018"}, d2 = {"Lio/noties/markwon/ext/tables/TablePlugin2$Row;", "", "index", "", "cells", "", "Lio/noties/markwon/ext/tables/TablePlugin2$Cell;", "isHeader", "", "(ILjava/util/List;Z)V", "getCells", "()Ljava/util/List;", "getIndex", "()I", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "", "markwon-ext-tables_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static final /* data */ class Row {
        private final List<Cell> cells;
        private final int index;
        private final boolean isHeader;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Row copy$default(Row row, int i, List list, boolean z, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = row.index;
            }
            if ((i2 & 2) != 0) {
                list = row.cells;
            }
            if ((i2 & 4) != 0) {
                z = row.isHeader;
            }
            return row.copy(i, list, z);
        }

        /* renamed from: component1, reason: from getter */
        public final int getIndex() {
            return this.index;
        }

        public final List<Cell> component2() {
            return this.cells;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getIsHeader() {
            return this.isHeader;
        }

        public final Row copy(int index, List<Cell> cells, boolean isHeader) {
            Intrinsics.checkParameterIsNotNull(cells, "cells");
            return new Row(index, cells, isHeader);
        }

        public boolean equals(Object other) {
            if (this != other) {
                if (other instanceof Row) {
                    Row row = (Row) other;
                    if ((this.index == row.index) && Intrinsics.areEqual(this.cells, row.cells)) {
                        if (this.isHeader == row.isHeader) {
                        }
                    }
                }
                return false;
            }
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int i = this.index * 31;
            List<Cell> list = this.cells;
            int hashCode = (i + (list != null ? list.hashCode() : 0)) * 31;
            boolean z = this.isHeader;
            int i2 = z;
            if (z != 0) {
                i2 = 1;
            }
            return hashCode + i2;
        }

        public String toString() {
            return "Row(index=" + this.index + ", cells=" + this.cells + ", isHeader=" + this.isHeader + ")";
        }

        public Row(int i, List<Cell> list, boolean z) {
            Intrinsics.checkParameterIsNotNull(list, "cells");
            this.index = i;
            this.cells = list;
            this.isHeader = z;
        }

        public final int getIndex() {
            return this.index;
        }

        public final List<Cell> getCells() {
            return this.cells;
        }

        public /* synthetic */ Row(int i, List list, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? 0 : i, list, (i2 & 4) != 0 ? false : z);
        }

        public final boolean isHeader() {
            return this.isHeader;
        }
    }
}
