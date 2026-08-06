package io.noties.markwon;

import io.noties.markwon.MarkwonVisitor;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
abstract class MarkwonVisitorFactory {
    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract MarkwonVisitor create();

    MarkwonVisitorFactory() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static MarkwonVisitorFactory create(final MarkwonVisitor.Builder builder, final MarkwonConfiguration markwonConfiguration) {
        return new MarkwonVisitorFactory() { // from class: io.noties.markwon.MarkwonVisitorFactory.1
            @Override // io.noties.markwon.MarkwonVisitorFactory
            MarkwonVisitor create() {
                return MarkwonVisitor.Builder.this.build(markwonConfiguration, new RenderPropsImpl());
            }
        };
    }
}
