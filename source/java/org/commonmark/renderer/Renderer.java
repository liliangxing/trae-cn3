package org.commonmark.renderer;

import org.commonmark.node.Node;

/* loaded from: classes.dex */
public interface Renderer {
    String render(Node node);

    void render(Node node, Appendable appendable);
}
