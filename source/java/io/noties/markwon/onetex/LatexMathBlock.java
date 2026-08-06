package io.noties.markwon.onetex;

import org.commonmark.node.CustomBlock;

/* loaded from: classes7.dex */
public class LatexMathBlock extends CustomBlock {
    private String latex;

    public String latex() {
        return this.latex;
    }

    public void latex(String str) {
        this.latex = str;
    }
}
