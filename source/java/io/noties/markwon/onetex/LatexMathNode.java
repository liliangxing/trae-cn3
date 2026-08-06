package io.noties.markwon.onetex;

import org.commonmark.node.CustomNode;

/* loaded from: classes7.dex */
public class LatexMathNode extends CustomNode {
    private String latex;

    public String latex() {
        return this.latex;
    }

    public void latex(String str) {
        this.latex = str;
    }
}
