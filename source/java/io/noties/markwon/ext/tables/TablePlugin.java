package io.noties.markwon.ext.tables;

import android.content.Context;
import android.text.Spanned;
import android.widget.TextView;
import io.noties.markwon.AbstractMarkwonPlugin;
import io.noties.markwon.MarkwonVisitor;
import io.noties.markwon.SpannableBuilder;
import io.noties.markwon.ext.tables.TableRowSpan;
import io.noties.markwon.ext.tables.TableTheme;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.commonmark.ext.gfm.tables.TableBlock;
import org.commonmark.ext.gfm.tables.TableBody;
import org.commonmark.ext.gfm.tables.TableCell;
import org.commonmark.ext.gfm.tables.TableHead;
import org.commonmark.ext.gfm.tables.TableRow;
import org.commonmark.ext.gfm.tables.TablesExtension;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class TablePlugin extends AbstractMarkwonPlugin {
    private final TableTheme theme;
    private final TableVisitor visitor;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public interface ThemeConfigure {
        void configureTheme(TableTheme.Builder builder);
    }

    public static TablePlugin create(Context context) {
        return create(TableTheme.create(context));
    }

    public static TablePlugin create(TableTheme tableTheme) {
        return new TablePlugin(tableTheme);
    }

    public static TablePlugin create(ThemeConfigure themeConfigure) {
        TableTheme.Builder builder = new TableTheme.Builder();
        themeConfigure.configureTheme(builder);
        return create(builder.build());
    }

    TablePlugin(TableTheme tableTheme) {
        this.theme = tableTheme;
        this.visitor = new TableVisitor(tableTheme);
    }

    public TableTheme theme() {
        return this.theme;
    }

    public void configureParser(Parser.Builder builder) {
        builder.extensions(Collections.singleton(TablesExtension.create()));
    }

    public void configureVisitor(MarkwonVisitor.Builder builder) {
        this.visitor.configure(builder);
    }

    public void beforeRender(TextView textView, Node node) {
        this.visitor.clear();
    }

    public void beforeRender(CharSequence charSequence, Node node) {
        this.visitor.clear();
    }

    public void beforeSetText(TextView textView, Spanned spanned) {
        TableRowsScheduler.unschedule(textView);
    }

    public void afterSetText(TextView textView) {
        TableRowsScheduler.schedule(textView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class TableVisitor {
        private List<TableRowSpan.Cell> pendingTableRow;
        private boolean tableRowIsHeader;
        private int tableRows;
        private final TableTheme tableTheme;

        TableVisitor(TableTheme tableTheme) {
            this.tableTheme = tableTheme;
        }

        void clear() {
            this.pendingTableRow = null;
            this.tableRowIsHeader = false;
            this.tableRows = 0;
        }

        void configure(MarkwonVisitor.Builder builder) {
            builder.on(TableBlock.class, new MarkwonVisitor.NodeVisitor<TableBlock>() { // from class: io.noties.markwon.ext.tables.TablePlugin.TableVisitor.5
                public void visit(MarkwonVisitor markwonVisitor, TableBlock tableBlock) {
                    TableVisitor.this.tableRows = 0;
                    markwonVisitor.blockStart(tableBlock);
                    int length = markwonVisitor.length();
                    markwonVisitor.visitChildren(tableBlock);
                    markwonVisitor.setSpans(length, new TableSpan());
                    markwonVisitor.blockEnd(tableBlock);
                    TableVisitor.this.tableRows = 0;
                }
            }).on(TableBody.class, new MarkwonVisitor.NodeVisitor<TableBody>() { // from class: io.noties.markwon.ext.tables.TablePlugin.TableVisitor.4
                public void visit(MarkwonVisitor markwonVisitor, TableBody tableBody) {
                    markwonVisitor.visitChildren(tableBody);
                }
            }).on(TableRow.class, new MarkwonVisitor.NodeVisitor<TableRow>() { // from class: io.noties.markwon.ext.tables.TablePlugin.TableVisitor.3
                public void visit(MarkwonVisitor markwonVisitor, TableRow tableRow) {
                    TableVisitor.this.visitRow(markwonVisitor, tableRow);
                }
            }).on(TableHead.class, new MarkwonVisitor.NodeVisitor<TableHead>() { // from class: io.noties.markwon.ext.tables.TablePlugin.TableVisitor.2
                public void visit(MarkwonVisitor markwonVisitor, TableHead tableHead) {
                    TableVisitor.this.visitRow(markwonVisitor, tableHead);
                }
            }).on(TableCell.class, new MarkwonVisitor.NodeVisitor<TableCell>() { // from class: io.noties.markwon.ext.tables.TablePlugin.TableVisitor.1
                public void visit(MarkwonVisitor markwonVisitor, TableCell tableCell) {
                    int length = markwonVisitor.length();
                    markwonVisitor.visitChildren(tableCell);
                    if (TableVisitor.this.pendingTableRow == null) {
                        TableVisitor.this.pendingTableRow = new ArrayList(2);
                    }
                    TableVisitor.this.pendingTableRow.add(new TableRowSpan.Cell(AlignmentKt.tableCellAlignment(tableCell.getAlignment()), markwonVisitor.builder().removeFromEnd(length)));
                    TableVisitor.this.tableRowIsHeader = tableCell.isHeader();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void visitRow(MarkwonVisitor markwonVisitor, Node node) {
            int length = markwonVisitor.length();
            markwonVisitor.visitChildren(node);
            if (this.pendingTableRow != null) {
                SpannableBuilder builder = markwonVisitor.builder();
                int length2 = builder.length();
                boolean z = length2 > 0 && '\n' != builder.charAt(length2 - 1);
                if (z) {
                    markwonVisitor.forceNewLine();
                }
                builder.append((char) 160);
                TableRowSpan tableRowSpan = new TableRowSpan(this.tableTheme, this.pendingTableRow, this.tableRowIsHeader, this.tableRows % 2 == 1);
                this.tableRows = this.tableRowIsHeader ? 0 : this.tableRows + 1;
                if (z) {
                    length++;
                }
                markwonVisitor.setSpans(length, tableRowSpan);
                this.pendingTableRow = null;
            }
        }
    }
}
