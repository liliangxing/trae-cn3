package io.noties.markwon.maybe;

import io.noties.markwon.inlineparser.BangInlineProcessor;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.commonmark.node.Image;
import org.commonmark.node.Node;

/* compiled from: MaybeImageProcessor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lio/noties/markwon/maybe/MaybeImageProcessor;", "Lio/noties/markwon/inlineparser/BangInlineProcessor;", "origin", "Ljava/util/concurrent/atomic/AtomicReference;", "", "(Ljava/util/concurrent/atomic/AtomicReference;)V", "parse", "Lorg/commonmark/node/Node;", "Companion", "markwon-maybe_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class MaybeImageProcessor extends BangInlineProcessor {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Pattern pattern;
    private static final Pattern title;
    private final AtomicReference<String> origin;

    public MaybeImageProcessor(AtomicReference<String> atomicReference) {
        Intrinsics.checkParameterIsNotNull(atomicReference, "origin");
        this.origin = atomicReference;
    }

    protected Node parse() {
        String match;
        String str = this.origin.get();
        Intrinsics.checkExpressionValueIsNotNull(str, "origin.get()");
        String input = this.context.input();
        Intrinsics.checkExpressionValueIsNotNull(input, "context.input()");
        if (StringsKt.endsWith$default(str, input, false, 2, (Object) null) && (match = match(pattern)) != null) {
            Matcher matcher = title.matcher(match);
            MaybeNode maybeNode = new MaybeNode(new Image("", matcher.find() ? matcher.group() : ""));
            maybeNode.appendChild((Node) text(match));
            return maybeNode;
        }
        return super.parse();
    }

    /* compiled from: MaybeImageProcessor.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\u0002\u001a\u0004\b\n\u0010\u0007¨\u0006\u000b"}, d2 = {"Lio/noties/markwon/maybe/MaybeImageProcessor$Companion;", "", "()V", "pattern", "Ljava/util/regex/Pattern;", "pattern$annotations", "getPattern", "()Ljava/util/regex/Pattern;", "title", "title$annotations", "getTitle", "markwon-maybe_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static final class Companion {
        public static /* synthetic */ void pattern$annotations() {
        }

        public static /* synthetic */ void title$annotations() {
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Pattern getPattern() {
            return MaybeImageProcessor.pattern;
        }

        public final Pattern getTitle() {
            return MaybeImageProcessor.title;
        }
    }

    static {
        Pattern compile = Pattern.compile("^!\\[[^\\)\\[]*$");
        Intrinsics.checkExpressionValueIsNotNull(compile, "Pattern.compile(\"^!\\\\[[^\\\\)\\\\[]*$\")");
        pattern = compile;
        Pattern compile2 = Pattern.compile("(?![!\\[])([^\\]])*");
        Intrinsics.checkExpressionValueIsNotNull(compile2, "Pattern.compile(\"(?![!\\\\[])([^\\\\]])*\")");
        title = compile2;
    }
}
