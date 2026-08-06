package io.noties.markwon;

import io.noties.markwon.MarkwonVisitor;
import org.commonmark.node.BlockQuote;
import org.commonmark.node.BulletList;
import org.commonmark.node.Code;
import org.commonmark.node.CustomBlock;
import org.commonmark.node.CustomNode;
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

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class DelegateVisitor implements MarkwonVisitor {
    private final MarkwonVisitor actual;

    public DelegateVisitor(MarkwonVisitor markwonVisitor) {
        this.actual = markwonVisitor;
    }

    @Override // io.noties.markwon.MarkwonVisitor
    public MarkwonConfiguration configuration() {
        return this.actual.configuration();
    }

    @Override // io.noties.markwon.MarkwonVisitor
    public RenderProps renderProps() {
        return this.actual.renderProps();
    }

    @Override // io.noties.markwon.MarkwonVisitor
    public SpannableBuilder builder() {
        return this.actual.builder();
    }

    @Override // io.noties.markwon.MarkwonVisitor
    public MarkwonVisitor.NodeVisitor<Node> getNodeVisitor(Node node) {
        return this.actual.getNodeVisitor(node);
    }

    protected void visit(Node node) {
        MarkwonVisitor.NodeVisitor<Node> nodeVisitor = getNodeVisitor(node);
        if (nodeVisitor != null) {
            nodeVisitor.visit(this, node);
        } else {
            visitChildren(node);
        }
    }

    @Override // io.noties.markwon.MarkwonVisitor
    public void visitChildren(Node node) {
        Node firstChild = node.getFirstChild();
        while (firstChild != null) {
            Node next = firstChild.getNext();
            firstChild.accept(this);
            firstChild = next;
        }
    }

    @Override // io.noties.markwon.MarkwonVisitor
    public boolean hasNext(Node node) {
        return this.actual.hasNext(node);
    }

    @Override // io.noties.markwon.MarkwonVisitor
    public void ensureNewLine() {
        this.actual.ensureNewLine();
    }

    @Override // io.noties.markwon.MarkwonVisitor
    public void forceNewLine() {
        this.actual.forceNewLine();
    }

    @Override // io.noties.markwon.MarkwonVisitor
    public int length() {
        return this.actual.length();
    }

    @Override // io.noties.markwon.MarkwonVisitor
    public void clear() {
        this.actual.clear();
    }

    @Override // io.noties.markwon.MarkwonVisitor
    public void setSpans(int i, Object obj) {
        this.actual.setSpans(i, obj);
    }

    @Override // io.noties.markwon.MarkwonVisitor
    public <N extends Node> void setSpansForNode(N n, int i) {
        this.actual.setSpansForNode((MarkwonVisitor) n, i);
    }

    @Override // io.noties.markwon.MarkwonVisitor
    public <N extends Node> void setSpansForNode(Class<N> cls, int i) {
        this.actual.setSpansForNode(cls, i);
    }

    @Override // io.noties.markwon.MarkwonVisitor
    public <N extends Node> void setSpansForNodeOptional(N n, int i) {
        this.actual.setSpansForNodeOptional((MarkwonVisitor) n, i);
    }

    @Override // io.noties.markwon.MarkwonVisitor
    public <N extends Node> void setSpansForNodeOptional(Class<N> cls, int i) {
        this.actual.setSpansForNodeOptional(cls, i);
    }

    @Override // io.noties.markwon.MarkwonVisitor
    public void blockStart(Node node) {
        this.actual.blockStart(node);
    }

    @Override // io.noties.markwon.MarkwonVisitor
    public void blockEnd(Node node) {
        this.actual.blockEnd(node);
    }

    public void visit(BlockQuote blockQuote) {
        visit((Node) blockQuote);
    }

    public void visit(BulletList bulletList) {
        visit((Node) bulletList);
    }

    public void visit(Code code) {
        visit((Node) code);
    }

    public void visit(Document document) {
        visit((Node) document);
    }

    public void visit(Emphasis emphasis) {
        visit((Node) emphasis);
    }

    public void visit(FencedCodeBlock fencedCodeBlock) {
        visit((Node) fencedCodeBlock);
    }

    public void visit(HardLineBreak hardLineBreak) {
        visit((Node) hardLineBreak);
    }

    public void visit(Heading heading) {
        visit((Node) heading);
    }

    public void visit(ThematicBreak thematicBreak) {
        visit((Node) thematicBreak);
    }

    public void visit(HtmlInline htmlInline) {
        visit((Node) htmlInline);
    }

    public void visit(HtmlBlock htmlBlock) {
        visit((Node) htmlBlock);
    }

    public void visit(Image image) {
        visit((Node) image);
    }

    public void visit(IndentedCodeBlock indentedCodeBlock) {
        visit((Node) indentedCodeBlock);
    }

    public void visit(Link link) {
        visit((Node) link);
    }

    public void visit(ListItem listItem) {
        visit((Node) listItem);
    }

    public void visit(OrderedList orderedList) {
        visit((Node) orderedList);
    }

    public void visit(Paragraph paragraph) {
        visit((Node) paragraph);
    }

    public void visit(SoftLineBreak softLineBreak) {
        visit((Node) softLineBreak);
    }

    public void visit(StrongEmphasis strongEmphasis) {
        visit((Node) strongEmphasis);
    }

    public void visit(Text text) {
        visit((Node) text);
    }

    public void visit(LinkReferenceDefinition linkReferenceDefinition) {
        visit((Node) linkReferenceDefinition);
    }

    public void visit(CustomBlock customBlock) {
        visit((Node) customBlock);
    }

    public void visit(CustomNode customNode) {
        visit((Node) customNode);
    }
}
