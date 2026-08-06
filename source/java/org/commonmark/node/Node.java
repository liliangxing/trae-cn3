package org.commonmark.node;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes8.dex */
public abstract class Node {
    public Node parent = null;
    public Node firstChild = null;
    public Node lastChild = null;
    public Node prev = null;
    public Node next = null;
    public String originText = null;
    public Map<String, Object> extraInfoMap = new HashMap();

    public abstract void accept(Visitor visitor);

    protected String toStringAttributes() {
        return "";
    }

    public Node getNext() {
        return this.next;
    }

    public Node getPrevious() {
        return this.prev;
    }

    public Node getFirstChild() {
        return this.firstChild;
    }

    public Node getLastChild() {
        return this.lastChild;
    }

    public Node getParent() {
        return this.parent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setParent(Node node) {
        this.parent = node;
    }

    public void appendChild(Node node) {
        node.unlink();
        node.setParent(this);
        Node node2 = this.lastChild;
        if (node2 != null) {
            node2.next = node;
            node.prev = node2;
            this.lastChild = node;
        } else {
            this.firstChild = node;
            this.lastChild = node;
        }
    }

    public void prependChild(Node node) {
        node.unlink();
        node.setParent(this);
        Node node2 = this.firstChild;
        if (node2 != null) {
            node2.prev = node;
            node.next = node2;
            this.firstChild = node;
        } else {
            this.firstChild = node;
            this.lastChild = node;
        }
    }

    public void unlink() {
        Node node = this.prev;
        if (node != null) {
            node.next = this.next;
        } else {
            Node node2 = this.parent;
            if (node2 != null) {
                node2.firstChild = this.next;
            }
        }
        Node node3 = this.next;
        if (node3 != null) {
            node3.prev = node;
        } else {
            Node node4 = this.parent;
            if (node4 != null) {
                node4.lastChild = node;
            }
        }
        this.parent = null;
        this.next = null;
        this.prev = null;
    }

    public void insertAfter(Node node) {
        node.unlink();
        Node node2 = this.next;
        node.next = node2;
        if (node2 != null) {
            node2.prev = node;
        }
        node.prev = this;
        this.next = node;
        Node node3 = this.parent;
        node.parent = node3;
        if (node.next == null) {
            node3.lastChild = node;
        }
    }

    public void insertBefore(Node node) {
        node.unlink();
        Node node2 = this.prev;
        node.prev = node2;
        if (node2 != null) {
            node2.next = node;
        }
        node.next = this;
        this.prev = node;
        Node node3 = this.parent;
        node.parent = node3;
        if (node.prev == null) {
            node3.firstChild = node;
        }
    }

    public String toString() {
        return getClass().getSimpleName() + "{" + toStringAttributes() + "}";
    }
}
