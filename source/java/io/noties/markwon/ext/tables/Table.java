package io.noties.markwon.ext.tables;

import android.text.Spanned;
import io.noties.markwon.Markwon;
import java.util.ArrayList;
import java.util.List;
import org.commonmark.ext.gfm.tables.TableBlock;
import org.commonmark.ext.gfm.tables.TableCell;
import org.commonmark.ext.gfm.tables.TableHead;
import org.commonmark.ext.gfm.tables.TableRow;
import org.commonmark.node.AbstractVisitor;
import org.commonmark.node.CustomNode;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class Table {
    private final List<Row> rows;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public enum Alignment {
        LEFT,
        CENTER,
        RIGHT
    }

    public static Table parse(Markwon markwon, TableBlock tableBlock) {
        ParseVisitor parseVisitor = new ParseVisitor(markwon);
        tableBlock.accept(parseVisitor);
        List<Row> rows = parseVisitor.rows();
        if (rows == null) {
            return null;
        }
        return new Table(rows);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class Row {
        private final List<Column> columns;
        private final boolean isHeader;

        public Row(boolean z, List<Column> list) {
            this.isHeader = z;
            this.columns = list;
        }

        public boolean header() {
            return this.isHeader;
        }

        public List<Column> columns() {
            return this.columns;
        }

        public String toString() {
            return "Row{isHeader=" + this.isHeader + ", columns=" + this.columns + '}';
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class Column {
        private final Alignment alignment;
        private final Spanned content;

        public Column(Alignment alignment, Spanned spanned) {
            this.alignment = alignment;
            this.content = spanned;
        }

        public Alignment alignment() {
            return this.alignment;
        }

        public Spanned content() {
            return this.content;
        }

        public String toString() {
            return "Column{alignment=" + this.alignment + ", content=" + ((Object) this.content) + '}';
        }
    }

    public Table(List<Row> list) {
        this.rows = list;
    }

    public List<Row> rows() {
        return this.rows;
    }

    public String toString() {
        return "Table{rows=" + this.rows + '}';
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    static class ParseVisitor extends AbstractVisitor {
        private final Markwon markwon;
        private List<Column> pendingRow;
        private boolean pendingRowIsHeader;
        private List<Row> rows;

        ParseVisitor(Markwon markwon) {
            this.markwon = markwon;
        }

        public List<Row> rows() {
            return this.rows;
        }

        public void visit(CustomNode customNode) {
            if (customNode instanceof TableCell) {
                TableCell tableCell = (TableCell) customNode;
                if (this.pendingRow == null) {
                    this.pendingRow = new ArrayList(2);
                }
                this.pendingRow.add(new Column(alignment(tableCell.getAlignment()), this.markwon.render(tableCell)));
                this.pendingRowIsHeader = tableCell.isHeader();
                return;
            }
            if ((customNode instanceof TableHead) || (customNode instanceof TableRow)) {
                visitChildren(customNode);
                List<Column> list = this.pendingRow;
                if (list != null && list.size() > 0) {
                    if (this.rows == null) {
                        this.rows = new ArrayList(2);
                    }
                    this.rows.add(new Row(this.pendingRowIsHeader, this.pendingRow));
                }
                this.pendingRow = null;
                this.pendingRowIsHeader = false;
                return;
            }
            visitChildren(customNode);
        }

        private static Alignment alignment(TableCell.Alignment alignment) {
            if (TableCell.Alignment.RIGHT == alignment) {
                return Alignment.RIGHT;
            }
            if (TableCell.Alignment.CENTER == alignment) {
                return Alignment.CENTER;
            }
            return Alignment.LEFT;
        }
    }
}
