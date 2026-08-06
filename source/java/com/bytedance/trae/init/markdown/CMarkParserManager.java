package com.bytedance.trae.init.markdown;

import android.text.TextUtils;
import com.bytedance.trae.conversation.voice.VoiceAttemptMetricsTracker;
import com.flow.cmark.adapter.CMarkNodeJava;
import io.noties.markwon.ext.tables.TableTitle;
import io.noties.markwon.ext.tasklist.TaskListItem;
import io.noties.markwon.onetex.LatexMathNode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.commonmark.ext.gfm.strikethrough.Strikethrough;
import org.commonmark.ext.gfm.tables.TableBlock;
import org.commonmark.ext.gfm.tables.TableBody;
import org.commonmark.ext.gfm.tables.TableCell;
import org.commonmark.ext.gfm.tables.TableHead;
import org.commonmark.ext.gfm.tables.TableRow;
import org.commonmark.node.BlockQuote;
import org.commonmark.node.BulletList;
import org.commonmark.node.Code;
import org.commonmark.node.CustomNode;
import org.commonmark.node.Document;
import org.commonmark.node.Emphasis;
import org.commonmark.node.FencedCodeBlock;
import org.commonmark.node.Heading;
import org.commonmark.node.HtmlBlock;
import org.commonmark.node.HtmlInline;
import org.commonmark.node.Image;
import org.commonmark.node.Link;
import org.commonmark.node.ListItem;
import org.commonmark.node.Node;
import org.commonmark.node.OrderedList;
import org.commonmark.node.Paragraph;
import org.commonmark.node.SoftLineBreak;
import org.commonmark.node.StrongEmphasis;
import org.commonmark.node.Text;
import org.commonmark.node.ThematicBreak;

/* compiled from: CMarkParserManager.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u001e\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007H\u0002J \u0010\f\u001a\u0004\u0018\u00010\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u00072\n\u0010\r\u001a\u00060\u000ej\u0002`\u000fH\u0002J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\u0007H\u0002¨\u0006\u0011"}, d2 = {"Lcom/bytedance/trae/init/markdown/CMarkParserManager;", "", "<init>", "()V", "transformToMarkwonNode", "Lorg/commonmark/node/Node;", "root", "Lcom/flow/cmark/adapter/CMarkNodeJava;", "generateTableTitleLiteral", "Lkotlin/Pair;", "", "node", "getTableNodeContent", "result", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "generateTransformNode", "app_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class CMarkParserManager {
    public static final int $stable = 0;
    public static final CMarkParserManager INSTANCE = new CMarkParserManager();

    private CMarkParserManager() {
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0065  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Node transformToMarkwonNode(CMarkNodeJava root) {
        CMarkNodeJava cMarkNodeJava;
        if (root == null) {
            return null;
        }
        TableBlock generateTransformNode = generateTransformNode(root);
        if (generateTransformNode instanceof TableBlock) {
            TableBlock tableBlock = generateTransformNode;
            if (!(tableBlock.firstChild instanceof TableTitle)) {
                Node tableTitle = new TableTitle();
                tableTitle.setInfo("table");
                Pair<String, String> generateTableTitleLiteral = INSTANCE.generateTableTitleLiteral(root);
                tableTitle.setLiteral((String) generateTableTitleLiteral.getFirst());
                tableTitle.setExcelLiteral((String) generateTableTitleLiteral.getSecond());
                tableBlock.prependChild(tableTitle);
                for (cMarkNodeJava = root.firstChild; cMarkNodeJava != null; cMarkNodeJava = cMarkNodeJava.next) {
                    if (((generateTransformNode instanceof TableHead) && (((TableHead) generateTransformNode).firstChild instanceof TableRow)) || ((generateTransformNode instanceof TableBody) && (((TableBody) generateTransformNode).firstChild instanceof TableRow))) {
                        Node node = ((CustomNode) generateTransformNode).firstChild;
                        if (node != null) {
                            node.appendChild(transformToMarkwonNode(cMarkNodeJava));
                        }
                    } else if (generateTransformNode != null) {
                        generateTransformNode.appendChild(transformToMarkwonNode(cMarkNodeJava));
                    }
                }
                return generateTransformNode;
            }
        }
        if (((generateTransformNode instanceof TableHead) && ((TableHead) generateTransformNode).firstChild == null) || ((generateTransformNode instanceof TableBody) && ((TableBody) generateTransformNode).firstChild == null)) {
            ((CustomNode) generateTransformNode).appendChild(new TableRow());
        }
        while (cMarkNodeJava != null) {
        }
        return generateTransformNode;
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x00b0, code lost:
    
        if ((r3 != null && r3.tableAlignment == 'c') != false) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00d0, code lost:
    
        if ((r3 != null && r3.tableAlignment == 'c') != false) goto L71;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Pair<String, String> generateTableTitleLiteral(CMarkNodeJava node) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        if (Intrinsics.areEqual(node != null ? node.typeString : null, "table")) {
            for (CMarkNodeJava cMarkNodeJava = node.firstChild; cMarkNodeJava != null; cMarkNodeJava = cMarkNodeJava.next) {
                CMarkNodeJava cMarkNodeJava2 = cMarkNodeJava.firstChild;
                int i = 0;
                while (cMarkNodeJava2 != null) {
                    CMarkNodeJava cMarkNodeJava3 = cMarkNodeJava2.firstChild;
                    if (!TextUtils.isEmpty(cMarkNodeJava3 != null ? cMarkNodeJava3.literal : null)) {
                        if (cMarkNodeJava2.prev == null) {
                            sb.append('|');
                        }
                        sb.append(cMarkNodeJava2.content);
                        getTableNodeContent(cMarkNodeJava2, sb2);
                        sb.append('|');
                        sb2.append('\t');
                    } else {
                        if (cMarkNodeJava2.prev == null) {
                            sb.append('|');
                        }
                        sb.append(cMarkNodeJava2.content);
                        sb.append('|');
                        getTableNodeContent(cMarkNodeJava2, sb2);
                        if (cMarkNodeJava2.next != null) {
                            sb2.append('\t');
                        }
                    }
                    if (cMarkNodeJava2.next == null) {
                        sb.append('\n');
                        if (cMarkNodeJava.next != null) {
                            sb2.append('\n');
                        }
                    }
                    cMarkNodeJava2 = cMarkNodeJava2.next;
                    i++;
                }
                if (cMarkNodeJava.prev == null) {
                    CMarkNodeJava cMarkNodeJava4 = Intrinsics.areEqual(cMarkNodeJava.typeString, "table_header") ? cMarkNodeJava.firstChild : null;
                    sb.append('|');
                    if (1 <= i) {
                        int i2 = 1;
                        while (true) {
                            if (!(cMarkNodeJava4 != null && cMarkNodeJava4.tableAlignment == 'l')) {
                            }
                            sb.append(':');
                            sb.append("---");
                            if (!(cMarkNodeJava4 != null && cMarkNodeJava4.tableAlignment == 'r')) {
                            }
                            sb.append(':');
                            sb.append('|');
                            cMarkNodeJava4 = cMarkNodeJava4 != null ? cMarkNodeJava4.next : null;
                            if (i2 == i) {
                                break;
                            }
                            i2++;
                        }
                    }
                    sb.append('\n');
                }
            }
        }
        String sb3 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "toString(...)");
        return TuplesKt.to(sb3, sb2.toString());
    }

    private final CMarkNodeJava getTableNodeContent(CMarkNodeJava node, StringBuilder result) {
        if (Intrinsics.areEqual(node != null ? node.typeString : null, "text")) {
            result.append(node.literal);
            return node.next;
        }
        CMarkNodeJava cMarkNodeJava = node != null ? node.firstChild : null;
        while (cMarkNodeJava != null) {
            cMarkNodeJava = getTableNodeContent(cMarkNodeJava, result);
        }
        if (node != null) {
            return node.next;
        }
        return null;
    }

    private final Node generateTransformNode(CMarkNodeJava node) {
        String str = node.typeString;
        if (str != null) {
            switch (str.hashCode()) {
                case -2069336299:
                    if (str.equals("softbreak")) {
                        return new SoftLineBreak();
                    }
                    break;
                case -1988194839:
                    if (str.equals("table_row")) {
                        return new TableBody();
                    }
                    break;
                case -1793359477:
                    if (str.equals("linebreak")) {
                        return new SoftLineBreak();
                    }
                    break;
                case -1601338631:
                    if (str.equals("html_block")) {
                        Node htmlBlock = new HtmlBlock();
                        htmlBlock.setLiteral(node.literal);
                        return htmlBlock;
                    }
                    break;
                case -1504954573:
                    if (str.equals("table_cell")) {
                        Node tableCell = new TableCell();
                        char c = node.tableAlignment;
                        tableCell.setAlignment(c != 'c' ? c != 'l' ? c != 'r' ? TableCell.Alignment.LEFT : TableCell.Alignment.RIGHT : TableCell.Alignment.LEFT : TableCell.Alignment.CENTER);
                        return tableCell;
                    }
                    break;
                case -972521773:
                    if (str.equals("strikethrough")) {
                        return new Strikethrough();
                    }
                    break;
                case -891980137:
                    if (str.equals("strong")) {
                        return new StrongEmphasis();
                    }
                    break;
                case -677424794:
                    if (str.equals("formula")) {
                        Node latexMathNode = new LatexMathNode();
                        latexMathNode.latex(node.formulaLiteral);
                        return latexMathNode;
                    }
                    break;
                case -594415685:
                    if (str.equals("code_block")) {
                        Node fencedCodeBlock = new FencedCodeBlock();
                        fencedCodeBlock.setLiteral(node.codeLiteral);
                        fencedCodeBlock.setInfo(node.codeLanguage);
                        return fencedCodeBlock;
                    }
                    break;
                case -409429085:
                    if (str.equals("tasklist")) {
                        return new TaskListItem(node.isDone);
                    }
                    break;
                case 3059181:
                    if (str.equals("code")) {
                        Node code = new Code();
                        code.setLiteral(node.literal);
                        return code;
                    }
                    break;
                case 3117216:
                    if (str.equals("emph")) {
                        return new Emphasis();
                    }
                    break;
                case 3242771:
                    if (str.equals("item")) {
                        return new ListItem();
                    }
                    break;
                case 3321850:
                    if (str.equals("link")) {
                        Node link = new Link();
                        link.setDestination(node.url);
                        CMarkNodeJava cMarkNodeJava = node.firstChild;
                        if (Intrinsics.areEqual(cMarkNodeJava != null ? cMarkNodeJava.typeString : null, "text")) {
                            CMarkNodeJava cMarkNodeJava2 = node.firstChild;
                            link.setTitle(cMarkNodeJava2 != null ? cMarkNodeJava2.literal : null);
                        }
                        return link;
                    }
                    break;
                case 3322014:
                    if (str.equals("list")) {
                        if (node.listType == 1) {
                            return new BulletList();
                        }
                        Node orderedList = new OrderedList();
                        orderedList.setStartNumber(node.listStartIndex);
                        orderedList.setOriginalStartNumber(orderedList.getStartNumber());
                        return orderedList;
                    }
                    break;
                case 3556653:
                    if (str.equals("text")) {
                        Node text = new Text();
                        text.setLiteral(node.literal);
                        return text;
                    }
                    break;
                case 100313435:
                    if (str.equals("image")) {
                        Node image = new Image();
                        image.setDestination(node.url);
                        image.setTitle(node.title);
                        return image;
                    }
                    break;
                case 110115790:
                    if (str.equals("table")) {
                        return new TableBlock();
                    }
                    break;
                case 172286122:
                    if (str.equals("data-block")) {
                        Node htmlBlock2 = new HtmlBlock();
                        htmlBlock2.setLiteral(node.literal);
                        return htmlBlock2;
                    }
                    break;
                case 589402601:
                    if (str.equals("thematic_break")) {
                        return new ThematicBreak();
                    }
                    break;
                case 714512959:
                    if (str.equals("custom_block")) {
                        Node text2 = new Text();
                        text2.setLiteral(node.literal);
                        return text2;
                    }
                    break;
                case 795311618:
                    if (str.equals("heading")) {
                        Node heading = new Heading();
                        heading.setLevel(node.headingLevel);
                        return heading;
                    }
                    break;
                case 861720859:
                    if (str.equals("document")) {
                        return new Document();
                    }
                    break;
                case 877232935:
                    if (str.equals("custom_inline")) {
                        Node text3 = new Text();
                        text3.setLiteral(node.literal);
                        return text3;
                    }
                    break;
                case 1225721930:
                    if (str.equals("block_quote")) {
                        return new BlockQuote();
                    }
                    break;
                case 1248070172:
                    if (str.equals("data-inline")) {
                        Node htmlInline = new HtmlInline();
                        htmlInline.setLiteral(node.literal);
                        return htmlInline;
                    }
                    break;
                case 1285447710:
                    if (str.equals("table_header")) {
                        return new TableHead();
                    }
                    break;
                case 1949288814:
                    if (str.equals(VoiceAttemptMetricsTracker.FINAL_SOURCE_PARAGRAPH)) {
                        return new Paragraph();
                    }
                    break;
                case 2100277677:
                    if (str.equals("html_inline")) {
                        Node htmlInline2 = new HtmlInline();
                        htmlInline2.setLiteral(node.literal);
                        return htmlInline2;
                    }
                    break;
            }
        }
        Node text4 = new Text();
        text4.setLiteral(node.literal);
        return text4;
    }
}
