package io.noties.markwon.maybe;

import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import io.noties.markwon.inlineparser.InlineProcessor;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.commonmark.node.HtmlInline;
import org.commonmark.node.Node;

/* compiled from: MaybeHtmlProcessor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\u0004H\u0002J\n\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014J\b\u0010\f\u001a\u00020\rH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lio/noties/markwon/maybe/MaybeHtmlProcessor;", "Lio/noties/markwon/inlineparser/InlineProcessor;", "origin", "Ljava/util/concurrent/atomic/AtomicReference;", "", "(Ljava/util/concurrent/atomic/AtomicReference;)V", "createMaybeNode", "Lio/noties/markwon/maybe/MaybeNode;", "Lorg/commonmark/node/HtmlInline;", "literal", "parse", "Lorg/commonmark/node/Node;", "specialCharacter", "", "Companion", "markwon-maybe_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class MaybeHtmlProcessor extends InlineProcessor {
    private static final Pattern endTagNotFinishPattern;
    private static final String maybeAttribute = "(\\s+[^>]*)?";
    private static final String maybeCommentOrDeclare = "^<![-\\w][^>]*$";
    private static final String maybeTag = "^<[A-Za-z][-_/\\w\\d]*(\\s+[^>]*)?(?!>)$";
    private static final String maybeTagName = "[A-Za-z][-_/\\w\\d]*";
    private static final Pattern pattern;
    private static final Pattern startPattern;
    private static final Pattern startTagFinishWithPropertiesNotFinishPattern;
    private static final Pattern startTagNotFinishPattern;
    private final AtomicReference<String> origin;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Set<String> supportedTags = SetsKt.setOf(new String[]{"img", "a", "blockquote", "sub", "sup", "b", "strong", "s", "del", "u", "ins", "ol", "ul", RXScreenCaptureService.KEY_INDEX, "em", "cite", "dfn", "h1", "h2", "h3", "h4", "h5", "h6", "p", "div", "span"});

    public char specialCharacter() {
        return '<';
    }

    public MaybeHtmlProcessor(AtomicReference<String> atomicReference) {
        Intrinsics.checkParameterIsNotNull(atomicReference, "origin");
        this.origin = atomicReference;
    }

    protected Node parse() {
        Object obj;
        Object obj2;
        if (match(startPattern) != null) {
            String input = this.context.input();
            Intrinsics.checkExpressionValueIsNotNull(input, "context.input()");
            return createMaybeNode(input);
        }
        String match = match(startTagNotFinishPattern);
        if (match != null) {
            String substring = match.substring(1);
            Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.String).substring(startIndex)");
            Iterator<T> it = supportedTags.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj2 = null;
                    break;
                }
                obj2 = it.next();
                if (StringsKt.startsWith$default((String) obj2, substring, false, 2, (Object) null)) {
                    break;
                }
            }
            if (((String) obj2) == null) {
                return null;
            }
            String input2 = this.context.input();
            Intrinsics.checkExpressionValueIsNotNull(input2, "context.input()");
            return createMaybeNode(input2);
        }
        String match2 = match(startTagFinishWithPropertiesNotFinishPattern);
        if (match2 != null) {
            String substring2 = match2.substring(1, StringsKt.indexOf$default(match2, " ", 0, false, 6, (Object) null));
            Intrinsics.checkExpressionValueIsNotNull(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            if (!supportedTags.contains(substring2)) {
                return null;
            }
            String input3 = this.context.input();
            Intrinsics.checkExpressionValueIsNotNull(input3, "context.input()");
            return createMaybeNode(input3);
        }
        String match3 = match(endTagNotFinishPattern);
        if (match3 == null) {
            return null;
        }
        String substring3 = match3.substring(2);
        Intrinsics.checkExpressionValueIsNotNull(substring3, "(this as java.lang.String).substring(startIndex)");
        Iterator<T> it2 = supportedTags.iterator();
        while (true) {
            if (!it2.hasNext()) {
                obj = null;
                break;
            }
            obj = it2.next();
            if (StringsKt.startsWith$default((String) obj, substring3, false, 2, (Object) null)) {
                break;
            }
        }
        if (((String) obj) == null) {
            return null;
        }
        String input4 = this.context.input();
        Intrinsics.checkExpressionValueIsNotNull(input4, "context.input()");
        return createMaybeNode(input4);
    }

    private final MaybeNode<HtmlInline> createMaybeNode(String literal) {
        HtmlInline htmlInline = new HtmlInline();
        htmlInline.setLiteral("");
        MaybeNode<HtmlInline> maybeNode = new MaybeNode<>(htmlInline);
        maybeNode.appendChild(text(""));
        return maybeNode;
    }

    /* compiled from: MaybeHtmlProcessor.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\"\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\u0002\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \u0010*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n \u0010*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lio/noties/markwon/maybe/MaybeHtmlProcessor$Companion;", "", "()V", "endTagNotFinishPattern", "Ljava/util/regex/Pattern;", "maybeAttribute", "", "maybeCommentOrDeclare", "maybeTag", "maybeTagName", "pattern", "pattern$annotations", "getPattern", "()Ljava/util/regex/Pattern;", "startPattern", "startTagFinishWithPropertiesNotFinishPattern", "kotlin.jvm.PlatformType", "startTagNotFinishPattern", "supportedTags", "", "markwon-maybe_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static final class Companion {
        public static /* synthetic */ void pattern$annotations() {
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Pattern getPattern() {
            return MaybeHtmlProcessor.pattern;
        }
    }

    static {
        Pattern compile = Pattern.compile("(^<![-\\w][^>]*$)|(^<[A-Za-z][-_/\\w\\d]*(\\s+[^>]*)?(?!>)$)");
        Intrinsics.checkExpressionValueIsNotNull(compile, "Pattern.compile(\"($maybe…tOrDeclare)|($maybeTag)\")");
        pattern = compile;
        Pattern compile2 = Pattern.compile("^<$", 0);
        Intrinsics.checkExpressionValueIsNotNull(compile2, "java.util.regex.Pattern.compile(this, flags)");
        startPattern = compile2;
        startTagNotFinishPattern = Pattern.compile("^<[A-Za-z0-9]*$");
        startTagFinishWithPropertiesNotFinishPattern = Pattern.compile("^<[A-Za-z0-9]+ [^>\\n]*$");
        Pattern compile3 = Pattern.compile("^</[A-Za-z0-9]*$", 0);
        Intrinsics.checkExpressionValueIsNotNull(compile3, "java.util.regex.Pattern.compile(this, flags)");
        endTagNotFinishPattern = compile3;
    }
}
