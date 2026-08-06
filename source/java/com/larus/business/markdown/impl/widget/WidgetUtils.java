package com.larus.business.markdown.impl.widget;

import io.noties.markwon.ext.tables.TableTitle;
import io.noties.markwon.ext.tasklist.TaskListItem;
import io.noties.markwon.onetex.LatexMathBlock;
import io.noties.markwon.onetex.LatexMathNode;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.commonmark.ext.gfm.strikethrough.Strikethrough;
import org.commonmark.ext.gfm.tables.TableBlock;
import org.commonmark.ext.gfm.tables.TableBody;
import org.commonmark.ext.gfm.tables.TableCell;
import org.commonmark.ext.gfm.tables.TableHead;
import org.commonmark.ext.gfm.tables.TableRow;
import org.commonmark.node.BlockQuote;
import org.commonmark.node.BulletList;
import org.commonmark.node.Code;
import org.commonmark.node.Document;
import org.commonmark.node.Emphasis;
import org.commonmark.node.FencedCodeBlock;
import org.commonmark.node.HardLineBreak;
import org.commonmark.node.Heading;
import org.commonmark.node.HtmlBlock;
import org.commonmark.node.HtmlInline;
import org.commonmark.node.Image;
import org.commonmark.node.IndentedCodeBlock;
import org.commonmark.node.Link;
import org.commonmark.node.LinkReferenceDefinition;
import org.commonmark.node.ListItem;
import org.commonmark.node.Node;
import org.commonmark.node.OrderedList;
import org.commonmark.node.Paragraph;
import org.commonmark.node.SoftLineBreak;
import org.commonmark.node.StrongEmphasis;
import org.commonmark.node.Text;
import org.commonmark.node.ThematicBreak;

/* compiled from: WidgetUtils.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u001a\u0010\b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u0006J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\rH\u0002J \u0010\u000e\u001a\u0004\u0018\u00010\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u00062\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0010J\u0010\u0010\u0011\u001a\u00020\u00122\b\u0010\f\u001a\u0004\u0018\u00010\u0006J\u0012\u0010\u0013\u001a\u00020\u0012*\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0006J\f\u0010\u0015\u001a\u0004\u0018\u00010\u0006*\u00020\u0006J\u0012\u0010\u0016\u001a\u00020\u0012*\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006J\u0012\u0010\u0018\u001a\u00020\u0012*\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006J\u0012\u0010\u0019\u001a\u00020\u0012*\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0006J\n\u0010\u001a\u001a\u00020\u0012*\u00020\u0006¨\u0006\u001b"}, d2 = {"Lcom/larus/business/markdown/impl/widget/WidgetUtils;", "", "()V", "checkNodeSame", "", "oldNode", "Lorg/commonmark/node/Node;", "newNode", "checkTreeSame", "oldRoot", "newRoot", "handleHtmlInlineNode", "node", "Lorg/commonmark/node/HtmlInline;", "preorderTraversal", "nodeList", "", "resetTree", "", "appendChildMod", "child", "copy", "insertAfterMod", "sibling", "insertBeforeMod", "prependChildMod", "unlinkMod", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class WidgetUtils {
    public static final WidgetUtils INSTANCE = new WidgetUtils();

    private WidgetUtils() {
    }

    public final Node preorderTraversal(Node node, Set<Node> nodeList) {
        Node node2;
        Intrinsics.checkNotNullParameter(nodeList, "nodeList");
        if (node instanceof HtmlBlock) {
            HtmlBlock htmlBlock = (HtmlBlock) node;
            String literal = htmlBlock.getLiteral();
            Intrinsics.checkNotNullExpressionValue(literal, "node.literal");
            if (!StringsKt.startsWith$default(literal, "<data-block", false, 2, (Object) null)) {
                htmlBlock = null;
            }
            node2 = (Node) htmlBlock;
        } else if (node instanceof HtmlInline) {
            node2 = handleHtmlInlineNode((HtmlInline) node);
        } else if (node instanceof Image ? true : node instanceof FencedCodeBlock ? true : node instanceof TableBlock) {
            node2 = node;
        } else {
            if (node instanceof ListItem) {
                ListItem listItem = (ListItem) node;
                OrderedList orderedList = ((Node) listItem).parent;
                OrderedList orderedList2 = orderedList instanceof OrderedList ? orderedList : null;
                if (orderedList2 != null) {
                    int startNumber = orderedList2.getStartNumber();
                    for (Node node3 = orderedList2.firstChild; node3 != null && !Intrinsics.areEqual(node3, node); node3 = node3.next) {
                        startNumber++;
                    }
                    Map map = ((Node) listItem).extraInfoMap;
                    Intrinsics.checkNotNullExpressionValue(map, "node.extraInfoMap");
                    map.put("order_number", Integer.valueOf(startNumber));
                }
            }
            node2 = null;
        }
        if (node2 != null) {
            nodeList.add(node2);
            return node2.next;
        }
        Node node4 = node != null ? node.firstChild : null;
        while (node4 != null) {
            node4 = preorderTraversal(node4, nodeList);
        }
        if (node != null) {
            return node.next;
        }
        return null;
    }

    private final Node handleHtmlInlineNode(HtmlInline node) {
        String str;
        WidgetNode widgetNode = new WidgetNode();
        HtmlInline htmlInline = (Node) node;
        String literal = node.getLiteral();
        Intrinsics.checkNotNullExpressionValue(literal, "node.literal");
        if (!StringsKt.startsWith$default(literal, "<data-block", false, 2, (Object) null)) {
            String literal2 = node.getLiteral();
            Intrinsics.checkNotNullExpressionValue(literal2, "node.literal");
            str = StringsKt.startsWith$default(literal2, "<data-inline", false, 2, (Object) null) ? "</data-inline" : "</data-block";
            return null;
        }
        while (htmlInline != null) {
            if (htmlInline instanceof HtmlInline) {
                String literal3 = htmlInline.getLiteral();
                Intrinsics.checkNotNullExpressionValue(literal3, "nextNode.literal");
                if (StringsKt.startsWith$default(literal3, str, false, 2, (Object) null)) {
                    break;
                }
            }
            widgetNode.getNodeList().add(htmlInline);
            htmlInline = ((Node) htmlInline).next;
        }
        if (htmlInline != null) {
            widgetNode.getNodeList().add(htmlInline);
        }
        Node node2 = node.parent;
        if (Intrinsics.areEqual(CollectionsKt.firstOrNull(widgetNode.getNodeList()), node2.firstChild) && Intrinsics.areEqual(CollectionsKt.lastOrNull(widgetNode.getNodeList()), node2.lastChild)) {
            return node2;
        }
        Node node3 = (Node) CollectionsKt.firstOrNull(widgetNode.getNodeList());
        Node previous = node3 != null ? node3.getPrevious() : null;
        Node node4 = (Node) CollectionsKt.lastOrNull(widgetNode.getNodeList());
        Node node5 = node4 != null ? node4.next : null;
        Iterator<T> it = widgetNode.getNodeList().iterator();
        while (it.hasNext()) {
            INSTANCE.appendChildMod(widgetNode, (Node) it.next());
        }
        if (previous != null && node5 != null) {
            insertAfterMod(previous, widgetNode);
        } else {
            if (previous == null) {
                if (node5 != null) {
                    insertAfterMod(node5, widgetNode);
                }
                return null;
            }
            insertAfterMod(previous, widgetNode);
        }
        return widgetNode;
    }

    public final Node copy(Node node) {
        Node node2;
        Map map;
        Intrinsics.checkNotNullParameter(node, "<this>");
        if (node instanceof BlockQuote) {
            node2 = (Node) new BlockQuote();
        } else if (node instanceof BulletList) {
            BulletList bulletList = new BulletList();
            BulletList bulletList2 = (BulletList) node;
            bulletList.setBulletMarker(bulletList2.getBulletMarker());
            bulletList.setTight(bulletList2.isTight());
            node2 = (Node) bulletList;
        } else if (node instanceof Code) {
            Code code = new Code();
            code.setLiteral(((Code) node).getLiteral());
            node2 = (Node) code;
        } else if (node instanceof Document) {
            node2 = (Node) new Document();
        } else if (node instanceof Emphasis) {
            Emphasis emphasis = new Emphasis();
            emphasis.setDelimiter(((Emphasis) node).getOpeningDelimiter());
            node2 = (Node) emphasis;
        } else if (node instanceof FencedCodeBlock) {
            FencedCodeBlock fencedCodeBlock = new FencedCodeBlock();
            FencedCodeBlock fencedCodeBlock2 = (FencedCodeBlock) node;
            fencedCodeBlock.setFenceChar(fencedCodeBlock2.getFenceChar());
            fencedCodeBlock.setFenceLength(fencedCodeBlock2.getFenceLength());
            fencedCodeBlock.setFenceIndent(fencedCodeBlock2.getFenceIndent());
            fencedCodeBlock.setInfo(fencedCodeBlock2.getInfo());
            fencedCodeBlock.setLiteral(fencedCodeBlock2.getLiteral());
            node2 = (Node) fencedCodeBlock;
        } else if (node instanceof HardLineBreak) {
            node2 = (Node) new HardLineBreak();
        } else if (node instanceof Heading) {
            Heading heading = new Heading();
            heading.setLevel(((Heading) node).getLevel());
            node2 = (Node) heading;
        } else if (node instanceof ThematicBreak) {
            node2 = (Node) new ThematicBreak();
        } else if (node instanceof HtmlInline) {
            HtmlInline htmlInline = new HtmlInline();
            htmlInline.setLiteral(((HtmlInline) node).getLiteral());
            node2 = (Node) htmlInline;
        } else if (node instanceof HtmlBlock) {
            HtmlBlock htmlBlock = new HtmlBlock();
            htmlBlock.setLiteral(((HtmlBlock) node).getLiteral());
            node2 = (Node) htmlBlock;
        } else if (node instanceof Image) {
            Image image = new Image();
            Image image2 = (Image) node;
            image.setDestination(image2.getDestination());
            image.setTitle(image2.getTitle());
            node2 = (Node) image;
        } else if (node instanceof IndentedCodeBlock) {
            IndentedCodeBlock indentedCodeBlock = new IndentedCodeBlock();
            indentedCodeBlock.setLiteral(((IndentedCodeBlock) node).getLiteral());
            node2 = (Node) indentedCodeBlock;
        } else if (node instanceof Link) {
            Link link = new Link();
            Link link2 = (Link) node;
            link.setDestination(link2.getDestination());
            link.setTitle(link2.getTitle());
            node2 = (Node) link;
        } else if (node instanceof ListItem) {
            node2 = (Node) new ListItem();
        } else if (node instanceof OrderedList) {
            OrderedList orderedList = new OrderedList();
            OrderedList orderedList2 = (OrderedList) node;
            orderedList.setStartNumber(orderedList2.getStartNumber());
            orderedList.setDelimiter(orderedList2.getDelimiter());
            node2 = (Node) orderedList;
        } else if (node instanceof Paragraph) {
            node2 = (Node) new Paragraph();
        } else if (node instanceof SoftLineBreak) {
            node2 = (Node) new SoftLineBreak();
        } else if (node instanceof StrongEmphasis) {
            StrongEmphasis strongEmphasis = new StrongEmphasis();
            strongEmphasis.setDelimiter(((StrongEmphasis) node).getOpeningDelimiter());
            node2 = (Node) strongEmphasis;
        } else if (node instanceof Text) {
            Text text = new Text();
            text.setLiteral(((Text) node).getLiteral());
            node2 = (Node) text;
        } else if (node instanceof LinkReferenceDefinition) {
            LinkReferenceDefinition linkReferenceDefinition = new LinkReferenceDefinition();
            LinkReferenceDefinition linkReferenceDefinition2 = (LinkReferenceDefinition) node;
            linkReferenceDefinition.setLabel(linkReferenceDefinition2.getLabel());
            linkReferenceDefinition.setDestination(linkReferenceDefinition2.getDestination());
            linkReferenceDefinition.setTitle(linkReferenceDefinition2.getTitle());
            node2 = (Node) linkReferenceDefinition;
        } else if (node instanceof LatexMathBlock) {
            LatexMathBlock latexMathBlock = new LatexMathBlock();
            latexMathBlock.latex(((LatexMathBlock) node).latex());
            node2 = (Node) latexMathBlock;
        } else if (node instanceof TaskListItem) {
            node2 = (Node) new TaskListItem(((TaskListItem) node).isDone());
        } else if (node instanceof TableBlock) {
            node2 = (Node) new TableBlock();
        } else if (node instanceof LatexMathNode) {
            LatexMathNode latexMathNode = new LatexMathNode();
            latexMathNode.latex(((LatexMathNode) node).latex());
            node2 = (Node) latexMathNode;
        } else if (node instanceof TableTitle) {
            TableTitle tableTitle = new TableTitle();
            TableTitle tableTitle2 = (TableTitle) node;
            tableTitle.setInfo(tableTitle2.getInfo());
            tableTitle.setLiteral(tableTitle2.getLiteral());
            node2 = (Node) tableTitle;
        } else if (node instanceof Strikethrough) {
            node2 = (Node) new Strikethrough();
        } else if (node instanceof TableBody) {
            node2 = (Node) new TableBody();
        } else if (node instanceof TableCell) {
            TableCell tableCell = new TableCell();
            TableCell tableCell2 = (TableCell) node;
            tableCell.setHeader(tableCell2.isHeader());
            tableCell.setAlignment(tableCell2.getAlignment());
            node2 = (Node) tableCell;
        } else if (node instanceof TableHead) {
            node2 = (Node) new TableHead();
        } else {
            node2 = node instanceof TableRow ? (Node) new TableRow() : null;
        }
        if (node2 != null && (map = node2.extraInfoMap) != null) {
            Map map2 = node.extraInfoMap;
            Intrinsics.checkNotNullExpressionValue(map2, "this.extraInfoMap");
            map.putAll(map2);
        }
        return node2;
    }

    public final void appendChildMod(Node node, Node node2) {
        Intrinsics.checkNotNullParameter(node, "<this>");
        Intrinsics.checkNotNullParameter(node2, "child");
        unlinkMod(node2);
        node2.parent = node;
        if (node.lastChild != null) {
            Node node3 = node.lastChild;
            if (node3 != null) {
                node3.next = node2;
            }
            node2.prev = node.lastChild;
            node.lastChild = node2;
            return;
        }
        node.firstChild = node2;
        node.lastChild = node2;
    }

    public final void prependChildMod(Node node, Node node2) {
        Intrinsics.checkNotNullParameter(node, "<this>");
        Intrinsics.checkNotNullParameter(node2, "child");
        unlinkMod(node2);
        node2.parent = node;
        if (node.firstChild != null) {
            Node node3 = node.firstChild;
            if (node3 != null) {
                node3.prev = node2;
            }
            node2.next = node.firstChild;
            node.firstChild = node2;
            return;
        }
        node.firstChild = node2;
        node.lastChild = node2;
    }

    public final void insertAfterMod(Node node, Node node2) {
        Node node3;
        Intrinsics.checkNotNullParameter(node, "<this>");
        Intrinsics.checkNotNullParameter(node2, "sibling");
        unlinkMod(node2);
        node2.next = node.next;
        if (node2.next != null) {
            node2.next.prev = node2;
        }
        node2.prev = node;
        node.next = node2;
        node2.parent = node.parent;
        if (node2.next != null || (node3 = node2.parent) == null) {
            return;
        }
        node3.lastChild = node2;
    }

    public final void insertBeforeMod(Node node, Node node2) {
        Node node3;
        Intrinsics.checkNotNullParameter(node, "<this>");
        Intrinsics.checkNotNullParameter(node2, "sibling");
        unlinkMod(node2);
        node2.prev = node.prev;
        if (node2.prev != null) {
            node2.prev.next = node2;
        }
        node2.next = node;
        node.prev = node2;
        node2.parent = node.parent;
        if (node2.prev != null || (node3 = node2.parent) == null) {
            return;
        }
        node3.firstChild = node2;
    }

    public final void unlinkMod(Node node) {
        Node node2;
        Node node3;
        Intrinsics.checkNotNullParameter(node, "<this>");
        Node node4 = node.prev;
        if (node4 != null) {
            node4.next = node.next;
        }
        Node node5 = node.next;
        if (node5 != null) {
            node5.prev = node.prev;
        }
        Node node6 = node.parent;
        if (Intrinsics.areEqual(node6 != null ? node6.firstChild : null, node) && (node3 = node.parent) != null) {
            node3.firstChild = node.next;
        }
        Node node7 = node.parent;
        if (Intrinsics.areEqual(node7 != null ? node7.lastChild : null, node) && (node2 = node.parent) != null) {
            node2.lastChild = node.prev;
        }
        node.parent = null;
        node.next = null;
        node.prev = null;
    }

    public final void resetTree(Node node) {
        if (node == null) {
            return;
        }
        for (Node node2 = node.firstChild; node2 != null; node2 = node2.next) {
            resetTree(node2);
            if (node instanceof OrderedList) {
                OrderedList orderedList = (OrderedList) node;
                orderedList.setStartNumber(orderedList.getOriginalStartNumber());
            }
        }
    }

    public final boolean checkTreeSame(Node oldRoot, Node newRoot) {
        if (oldRoot == null && newRoot == null) {
            return true;
        }
        if (oldRoot == null || newRoot == null || !checkNodeSame(oldRoot, newRoot)) {
            return false;
        }
        Node node = oldRoot.firstChild;
        Node node2 = newRoot.firstChild;
        while (true) {
            if (node == null && node2 == null) {
                return true;
            }
            if (!checkTreeSame(node, node2)) {
                return false;
            }
            node = node != null ? node.next : null;
            node2 = node2 != null ? node2.next : null;
        }
    }

    private final boolean checkNodeSame(Node oldNode, Node newNode) {
        BulletList bulletList;
        Class<?> cls;
        Class<?> cls2;
        if (!Intrinsics.areEqual((oldNode == null || (cls2 = oldNode.getClass()) == null) ? null : cls2.getCanonicalName(), (newNode == null || (cls = newNode.getClass()) == null) ? null : cls.getCanonicalName())) {
            return false;
        }
        if (oldNode instanceof BlockQuote) {
            return true;
        }
        boolean z = oldNode instanceof BulletList;
        if (z) {
            BulletList bulletList2 = z ? (BulletList) oldNode : null;
            if (bulletList2 == null) {
                return false;
            }
            bulletList = newNode instanceof BulletList ? (BulletList) newNode : null;
            return bulletList != null && bulletList2.getBulletMarker() == bulletList.getBulletMarker() && bulletList2.isTight() == bulletList.isTight();
        }
        boolean z2 = oldNode instanceof Code;
        if (z2) {
            Code code = z2 ? (Code) oldNode : null;
            if (code == null) {
                return false;
            }
            bulletList = newNode instanceof Code ? (Code) newNode : null;
            if (bulletList == null) {
                return false;
            }
            return Intrinsics.areEqual(code.getLiteral(), bulletList.getLiteral());
        }
        if (oldNode instanceof Document) {
            return true;
        }
        boolean z3 = oldNode instanceof Emphasis;
        if (z3) {
            Emphasis emphasis = z3 ? (Emphasis) oldNode : null;
            if (emphasis == null) {
                return false;
            }
            bulletList = newNode instanceof Emphasis ? (Emphasis) newNode : null;
            if (bulletList == null) {
                return false;
            }
            return Intrinsics.areEqual(emphasis.getOpeningDelimiter(), bulletList.getOpeningDelimiter());
        }
        boolean z4 = oldNode instanceof FencedCodeBlock;
        if (z4) {
            FencedCodeBlock fencedCodeBlock = z4 ? (FencedCodeBlock) oldNode : null;
            if (fencedCodeBlock == null) {
                return false;
            }
            bulletList = newNode instanceof FencedCodeBlock ? (FencedCodeBlock) newNode : null;
            return bulletList != null && fencedCodeBlock.getFenceChar() == bulletList.getFenceChar() && fencedCodeBlock.getFenceLength() == bulletList.getFenceLength() && fencedCodeBlock.getFenceIndent() == bulletList.getFenceIndent() && Intrinsics.areEqual(fencedCodeBlock.getInfo(), bulletList.getInfo()) && Intrinsics.areEqual(fencedCodeBlock.getLiteral(), bulletList.getLiteral());
        }
        if (oldNode instanceof HardLineBreak) {
            return true;
        }
        boolean z5 = oldNode instanceof Heading;
        if (z5) {
            Heading heading = z5 ? (Heading) oldNode : null;
            if (heading == null) {
                return false;
            }
            bulletList = newNode instanceof Heading ? (Heading) newNode : null;
            return bulletList != null && heading.getLevel() == bulletList.getLevel();
        }
        if (oldNode instanceof ThematicBreak) {
            return true;
        }
        boolean z6 = oldNode instanceof HtmlInline;
        if (z6) {
            HtmlInline htmlInline = z6 ? (HtmlInline) oldNode : null;
            if (htmlInline == null) {
                return false;
            }
            bulletList = newNode instanceof HtmlInline ? (HtmlInline) newNode : null;
            if (bulletList == null) {
                return false;
            }
            return Intrinsics.areEqual(htmlInline.getLiteral(), bulletList.getLiteral());
        }
        boolean z7 = oldNode instanceof HtmlBlock;
        if (z7) {
            HtmlBlock htmlBlock = z7 ? (HtmlBlock) oldNode : null;
            if (htmlBlock == null) {
                return false;
            }
            bulletList = newNode instanceof HtmlBlock ? (HtmlBlock) newNode : null;
            if (bulletList == null) {
                return false;
            }
            return Intrinsics.areEqual(htmlBlock.getLiteral(), bulletList.getLiteral());
        }
        boolean z8 = oldNode instanceof Image;
        if (z8) {
            Image image = z8 ? (Image) oldNode : null;
            if (image == null) {
                return false;
            }
            bulletList = newNode instanceof Image ? (Image) newNode : null;
            return bulletList != null && Intrinsics.areEqual(image.getDestination(), bulletList.getDestination()) && Intrinsics.areEqual(image.getTitle(), bulletList.getTitle());
        }
        boolean z9 = oldNode instanceof IndentedCodeBlock;
        if (z9) {
            IndentedCodeBlock indentedCodeBlock = z9 ? (IndentedCodeBlock) oldNode : null;
            if (indentedCodeBlock == null) {
                return false;
            }
            bulletList = newNode instanceof IndentedCodeBlock ? (IndentedCodeBlock) newNode : null;
            if (bulletList == null) {
                return false;
            }
            return Intrinsics.areEqual(indentedCodeBlock.getLiteral(), bulletList.getLiteral());
        }
        boolean z10 = oldNode instanceof Link;
        if (z10) {
            Link link = z10 ? (Link) oldNode : null;
            if (link == null) {
                return false;
            }
            bulletList = newNode instanceof Link ? (Link) newNode : null;
            return bulletList != null && Intrinsics.areEqual(link.getDestination(), bulletList.getDestination()) && Intrinsics.areEqual(link.getTitle(), bulletList.getTitle());
        }
        if (oldNode instanceof ListItem) {
            return true;
        }
        boolean z11 = oldNode instanceof OrderedList;
        if (z11) {
            OrderedList orderedList = z11 ? (OrderedList) oldNode : null;
            if (orderedList == null) {
                return false;
            }
            bulletList = newNode instanceof OrderedList ? (OrderedList) newNode : null;
            return bulletList != null && orderedList.getOriginalStartNumber() == bulletList.getOriginalStartNumber() && orderedList.getDelimiter() == bulletList.getDelimiter();
        }
        if ((oldNode instanceof Paragraph) || (oldNode instanceof SoftLineBreak)) {
            return true;
        }
        boolean z12 = oldNode instanceof StrongEmphasis;
        if (z12) {
            StrongEmphasis strongEmphasis = z12 ? (StrongEmphasis) oldNode : null;
            if (strongEmphasis == null) {
                return false;
            }
            bulletList = newNode instanceof StrongEmphasis ? (StrongEmphasis) newNode : null;
            if (bulletList == null) {
                return false;
            }
            return Intrinsics.areEqual(strongEmphasis.getOpeningDelimiter(), bulletList.getOpeningDelimiter());
        }
        boolean z13 = oldNode instanceof Text;
        if (z13) {
            Text text = z13 ? (Text) oldNode : null;
            if (text == null) {
                return false;
            }
            bulletList = newNode instanceof Text ? (Text) newNode : null;
            if (bulletList == null) {
                return false;
            }
            return Intrinsics.areEqual(text.getLiteral(), bulletList.getLiteral());
        }
        boolean z14 = oldNode instanceof LinkReferenceDefinition;
        if (z14) {
            LinkReferenceDefinition linkReferenceDefinition = z14 ? (LinkReferenceDefinition) oldNode : null;
            if (linkReferenceDefinition == null) {
                return false;
            }
            bulletList = newNode instanceof LinkReferenceDefinition ? (LinkReferenceDefinition) newNode : null;
            return bulletList != null && Intrinsics.areEqual(linkReferenceDefinition.getLabel(), bulletList.getLabel()) && Intrinsics.areEqual(linkReferenceDefinition.getDestination(), bulletList.getDestination()) && Intrinsics.areEqual(linkReferenceDefinition.getTitle(), bulletList.getTitle());
        }
        boolean z15 = oldNode instanceof LatexMathBlock;
        if (z15) {
            LatexMathBlock latexMathBlock = z15 ? (LatexMathBlock) oldNode : null;
            if (latexMathBlock == null) {
                return false;
            }
            bulletList = newNode instanceof LatexMathBlock ? (LatexMathBlock) newNode : null;
            if (bulletList == null) {
                return false;
            }
            return Intrinsics.areEqual(latexMathBlock.latex(), bulletList.latex());
        }
        boolean z16 = oldNode instanceof TaskListItem;
        if (z16) {
            TaskListItem taskListItem = z16 ? (TaskListItem) oldNode : null;
            if (taskListItem == null) {
                return false;
            }
            bulletList = newNode instanceof TaskListItem ? (TaskListItem) newNode : null;
            return bulletList != null && taskListItem.isDone() == bulletList.isDone();
        }
        if (oldNode instanceof TableBlock) {
            return true;
        }
        boolean z17 = oldNode instanceof LatexMathNode;
        if (z17) {
            LatexMathNode latexMathNode = z17 ? (LatexMathNode) oldNode : null;
            if (latexMathNode == null) {
                return false;
            }
            bulletList = newNode instanceof LatexMathNode ? (LatexMathNode) newNode : null;
            if (bulletList == null) {
                return false;
            }
            return Intrinsics.areEqual(latexMathNode.latex(), bulletList.latex());
        }
        boolean z18 = oldNode instanceof TableTitle;
        if (z18) {
            TableTitle tableTitle = z18 ? (TableTitle) oldNode : null;
            if (tableTitle == null) {
                return false;
            }
            bulletList = newNode instanceof TableTitle ? (TableTitle) newNode : null;
            return bulletList != null && Intrinsics.areEqual(tableTitle.getInfo(), bulletList.getInfo()) && Intrinsics.areEqual(tableTitle.getLiteral(), bulletList.getLiteral());
        }
        if ((oldNode instanceof Strikethrough) || (oldNode instanceof TableBody)) {
            return true;
        }
        boolean z19 = oldNode instanceof TableCell;
        if (!z19) {
            return (oldNode instanceof TableHead) || (oldNode instanceof TableRow);
        }
        TableCell tableCell = z19 ? (TableCell) oldNode : null;
        if (tableCell == null) {
            return false;
        }
        bulletList = newNode instanceof TableCell ? (TableCell) newNode : null;
        return bulletList != null && tableCell.isHeader() == bulletList.isHeader() && tableCell.getAlignment() == bulletList.getAlignment();
    }
}
