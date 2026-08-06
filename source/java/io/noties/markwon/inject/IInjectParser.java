package io.noties.markwon.inject;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.commonmark.node.Node;

/* compiled from: IInjectParser.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"Lio/noties/markwon/inject/IInjectParser;", "", "parseMarkdown", "Lorg/commonmark/node/Node;", "input", "", "finished", "", "supportMultiThread", "markwon-core_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes6.dex */
public interface IInjectParser {
    Node parseMarkdown(String input);

    Node parseMarkdown(String input, boolean finished);

    boolean supportMultiThread();

    /* compiled from: IInjectParser.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 15})
    /* loaded from: classes6.dex */
    public static final class DefaultImpls {
        public static boolean supportMultiThread(IInjectParser iInjectParser) {
            return false;
        }

        public static /* synthetic */ Node parseMarkdown$default(IInjectParser iInjectParser, String str, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: parseMarkdown");
            }
            if ((i & 2) != 0) {
                z = true;
            }
            return iInjectParser.parseMarkdown(str, z);
        }

        public static Node parseMarkdown(IInjectParser iInjectParser, String input, boolean z) {
            Intrinsics.checkParameterIsNotNull(input, "input");
            return iInjectParser.parseMarkdown(input);
        }
    }
}
