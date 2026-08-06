package org.jetbrains.compose.resources.vector.xmldom;

import com.bytedance.android.anniex.solutions.card.AirActionConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NodeImpl.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0011\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\tH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u0004\u0018\u00010\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u000b¨\u0006\u0017"}, d2 = {"Lorg/jetbrains/compose/resources/vector/xmldom/NodeImpl;", "Lorg/jetbrains/compose/resources/vector/xmldom/Node;", AirActionConstant.ActionId.ACTION_ID_NAME, "Lorg/w3c/dom/Node;", "<init>", "(Lorg/w3c/dom/Node;)V", "getN", "()Lorg/w3c/dom/Node;", "textContent", "", "getTextContent", "()Ljava/lang/String;", "nodeName", "getNodeName", "localName", "getLocalName", "childNodes", "Lorg/jetbrains/compose/resources/vector/xmldom/NodeList;", "getChildNodes", "()Lorg/jetbrains/compose/resources/vector/xmldom/NodeList;", "namespaceURI", "getNamespaceURI", "lookupPrefix", "library_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes9.dex */
public class NodeImpl implements Node {
    public static final int $stable = 8;
    private final org.w3c.dom.Node n;

    public NodeImpl(org.w3c.dom.Node n) {
        Intrinsics.checkNotNullParameter(n, "n");
        this.n = n;
    }

    public final org.w3c.dom.Node getN() {
        return this.n;
    }

    @Override // org.jetbrains.compose.resources.vector.xmldom.Node
    public String getTextContent() {
        return this.n.getTextContent();
    }

    @Override // org.jetbrains.compose.resources.vector.xmldom.Node
    public String getNodeName() {
        String nodeName = this.n.getNodeName();
        Intrinsics.checkNotNullExpressionValue(nodeName, "getNodeName(...)");
        return nodeName;
    }

    @Override // org.jetbrains.compose.resources.vector.xmldom.Node
    public String getLocalName() {
        String localName = this.n.getLocalName();
        Intrinsics.checkNotNullExpressionValue(localName, "getLocalName(...)");
        return localName;
    }

    @Override // org.jetbrains.compose.resources.vector.xmldom.Node
    public NodeList getChildNodes() {
        return new NodeList() { // from class: org.jetbrains.compose.resources.vector.xmldom.NodeImpl$childNodes$1
            private final int length;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.length = NodeImpl.this.getN().getChildNodes().getLength();
            }

            @Override // org.jetbrains.compose.resources.vector.xmldom.NodeList
            public Node item(int i) {
                Node nodeImpl;
                org.w3c.dom.Node item = NodeImpl.this.getN().getChildNodes().item(i);
                if (item instanceof org.w3c.dom.Element) {
                    nodeImpl = new ElementImpl((org.w3c.dom.Element) item);
                } else {
                    Intrinsics.checkNotNull(item);
                    nodeImpl = new NodeImpl(item);
                }
                return nodeImpl;
            }

            @Override // org.jetbrains.compose.resources.vector.xmldom.NodeList
            public int getLength() {
                return this.length;
            }
        };
    }

    @Override // org.jetbrains.compose.resources.vector.xmldom.Node
    public String getNamespaceURI() {
        String namespaceURI = this.n.getNamespaceURI();
        Intrinsics.checkNotNullExpressionValue(namespaceURI, "getNamespaceURI(...)");
        return namespaceURI;
    }

    @Override // org.jetbrains.compose.resources.vector.xmldom.Node
    public String lookupPrefix(String namespaceURI) {
        Intrinsics.checkNotNullParameter(namespaceURI, "namespaceURI");
        String lookupPrefix = this.n.lookupPrefix(namespaceURI);
        Intrinsics.checkNotNullExpressionValue(lookupPrefix, "lookupPrefix(...)");
        return lookupPrefix;
    }
}
