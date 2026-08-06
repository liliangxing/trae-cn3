package io.noties.markwon.ext.tables;

import android.content.Context;
import android.text.Spanned;
import android.widget.TextView;
import io.noties.markwon.AbstractMarkwonPlugin;
import io.noties.markwon.MarkwonVisitor;
import io.noties.markwon.SpannableBuilder;
import io.noties.markwon.ext.tables.CustomTableRowSpan;
import io.noties.markwon.ext.tables.TableTheme;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.commonmark.ext.gfm.tables.TableBlock;
import org.commonmark.ext.gfm.tables.TableBody;
import org.commonmark.ext.gfm.tables.TableCell;
import org.commonmark.ext.gfm.tables.TableHead;
import org.commonmark.ext.gfm.tables.TableRow;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class CustomTablePlugin extends AbstractMarkwonPlugin {
    public static final String TAG = "CustomTablePlugin";
    private final TableTheme theme;
    private final TableVisitor visitor;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public interface ThemeConfigure {
        void configureTheme(TableTheme.Builder builder);
    }

    public static CustomTablePlugin create(Context context) {
        return new CustomTablePlugin(TableTheme.create(context));
    }

    public static CustomTablePlugin create(TableTheme tableTheme) {
        return new CustomTablePlugin(tableTheme);
    }

    public static CustomTablePlugin create(ThemeConfigure themeConfigure) {
        TableTheme.Builder builder = new TableTheme.Builder();
        themeConfigure.configureTheme(builder);
        return new CustomTablePlugin(builder.build());
    }

    CustomTablePlugin(TableTheme tableTheme) {
        this.theme = tableTheme;
        this.visitor = new TableVisitor(tableTheme);
    }

    public TableTheme theme() {
        return this.theme;
    }

    public void configureParser(Parser.Builder builder) {
        builder.extensions(Collections.singleton(new CustomTablesExtension()));
    }

    public void configureVisitor(MarkwonVisitor.Builder builder) {
        this.visitor.configure(builder);
    }

    public void beforeRender(Node node) {
        this.visitor.clear();
    }

    public void beforeSetText(TextView textView, Spanned spanned) {
        CustomTableRowsScheduler.unschedule(textView);
    }

    public void afterSetText(TextView textView) {
        CustomTableRowsScheduler.schedule(textView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class TableVisitor {
        private List<CustomTableRowSpan.Cell> pendingTableRow;
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
            builder.on(TableBlock.class, new MarkwonVisitor.NodeVisitor<TableBlock>() { // from class: io.noties.markwon.ext.tables.CustomTablePlugin.TableVisitor.5
                public void visit(MarkwonVisitor markwonVisitor, TableBlock tableBlock) {
                    markwonVisitor.blockStart(tableBlock);
                    int length = markwonVisitor.length();
                    markwonVisitor.visitChildren(tableBlock);
                    markwonVisitor.setSpans(length, new TableSpan(-1));
                    markwonVisitor.blockEnd(tableBlock);
                }
            }).on(TableBody.class, new MarkwonVisitor.NodeVisitor<TableBody>() { // from class: io.noties.markwon.ext.tables.CustomTablePlugin.TableVisitor.4
                public void visit(MarkwonVisitor markwonVisitor, TableBody tableBody) {
                    markwonVisitor.visitChildren(tableBody);
                    TableVisitor.this.tableRows = 0;
                }
            }).on(TableRow.class, new MarkwonVisitor.NodeVisitor<TableRow>() { // from class: io.noties.markwon.ext.tables.CustomTablePlugin.TableVisitor.3
                public void visit(MarkwonVisitor markwonVisitor, TableRow tableRow) {
                    TableVisitor.this.visitRow(markwonVisitor, tableRow);
                }
            }).on(TableHead.class, new MarkwonVisitor.NodeVisitor<TableHead>() { // from class: io.noties.markwon.ext.tables.CustomTablePlugin.TableVisitor.2
                public void visit(MarkwonVisitor markwonVisitor, TableHead tableHead) {
                    TableVisitor.this.visitRow(markwonVisitor, tableHead);
                }
            }).on(TableCell.class, new MarkwonVisitor.NodeVisitor<TableCell>() { // from class: io.noties.markwon.ext.tables.CustomTablePlugin.TableVisitor.1
                public void visit(MarkwonVisitor markwonVisitor, TableCell tableCell) {
                    int length = markwonVisitor.length();
                    markwonVisitor.visitChildren(tableCell);
                    if (TableVisitor.this.pendingTableRow == null) {
                        TableVisitor.this.pendingTableRow = new ArrayList(2);
                    }
                    TableVisitor.this.pendingTableRow.add(new CustomTableRowSpan.Cell(TableVisitor.tableCellAlignment(tableCell.getAlignment()), markwonVisitor.builder().removeFromEnd(length).toString()));
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
                Iterator<CustomTableRowSpan.Cell> it = this.pendingTableRow.iterator();
                while (it.hasNext()) {
                    builder.append(it.next().text.toString()).append(" ");
                }
                CustomTableRowSpan customTableRowSpan = new CustomTableRowSpan(this.tableTheme, this.pendingTableRow, this.tableRowIsHeader, this.tableRows % 2 == 1);
                this.tableRows = this.tableRowIsHeader ? 0 : this.tableRows + 1;
                if (z) {
                    length++;
                }
                markwonVisitor.setSpans(length, customTableRowSpan);
                this.pendingTableRow = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static int tableCellAlignment(TableCell.Alignment alignment) {
            if (alignment == null) {
                return 0;
            }
            int i = C18171.$SwitchMap$org$commonmark$ext$gfm$tables$TableCell$Alignment[alignment.ordinal()];
            int i2 = 1;
            if (i != 1) {
                i2 = 2;
                if (i != 2) {
                    return 0;
                }
            }
            return i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.noties.markwon.ext.tables.CustomTablePlugin$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static /* synthetic */ class C18171 {
        static final /* synthetic */ int[] $SwitchMap$org$commonmark$ext$gfm$tables$TableCell$Alignment;

        static {
            int[] iArr = new int[TableCell.Alignment.values().length];
            $SwitchMap$org$commonmark$ext$gfm$tables$TableCell$Alignment = iArr;
            try {
                iArr[TableCell.Alignment.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$commonmark$ext$gfm$tables$TableCell$Alignment[TableCell.Alignment.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
