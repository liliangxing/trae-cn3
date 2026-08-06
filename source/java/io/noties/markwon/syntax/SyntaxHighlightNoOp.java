package io.noties.markwon.syntax;

/* loaded from: classes.dex */
public class SyntaxHighlightNoOp implements SyntaxHighlight {
    @Override // io.noties.markwon.syntax.SyntaxHighlight
    public CharSequence highlight(String str, String str2) {
        return str2;
    }
}
