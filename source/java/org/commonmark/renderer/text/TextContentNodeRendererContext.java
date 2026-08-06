package org.commonmark.renderer.text;

import org.commonmark.node.Node;

/* loaded from: classes3.dex */
public interface TextContentNodeRendererContext {
    TextContentWriter getWriter();

    void render(Node node);

    boolean stripNewlines();
}
