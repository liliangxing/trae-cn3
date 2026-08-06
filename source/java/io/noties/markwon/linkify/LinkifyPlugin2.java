package io.noties.markwon.linkify;

import androidx.core.util.PatternsCompat;
import com.bytedance.webx.seclink.util.ReportUtil;
import io.noties.markwon.AbstractMarkwonPlugin;
import io.noties.markwon.MarkwonPlugin;
import io.noties.markwon.MarkwonVisitor;
import io.noties.markwon.RenderProps;
import io.noties.markwon.SpanFactory;
import io.noties.markwon.SpannableBuilder;
import io.noties.markwon.core.CorePlugin;
import io.noties.markwon.core.CoreProps;
import io.noties.markwon.linkify.LinkifyPlugin2;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.commonmark.node.Link;
import org.commonmark.node.Node;

/* compiled from: LinkifyPlugin2.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lio/noties/markwon/linkify/LinkifyPlugin2;", "Lio/noties/markwon/AbstractMarkwonPlugin;", "()V", "configure", "", "registry", "Lio/noties/markwon/MarkwonPlugin$Registry;", "InlineLinkifyParser", "markwon-linkify_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class LinkifyPlugin2 extends AbstractMarkwonPlugin {
    @Override // io.noties.markwon.AbstractMarkwonPlugin, io.noties.markwon.MarkwonPlugin
    public void configure(MarkwonPlugin.Registry registry) {
        Intrinsics.checkParameterIsNotNull(registry, "registry");
        registry.require(CorePlugin.class, new MarkwonPlugin.Action<CorePlugin>() { // from class: io.noties.markwon.linkify.LinkifyPlugin2$configure$1
            @Override // io.noties.markwon.MarkwonPlugin.Action
            public final void apply(CorePlugin corePlugin) {
                Intrinsics.checkParameterIsNotNull(corePlugin, "corePlugin");
                corePlugin.addOnTextAddedListener(new LinkifyPlugin2.InlineLinkifyParser());
            }
        });
    }

    /* compiled from: LinkifyPlugin2.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\u000e"}, d2 = {"Lio/noties/markwon/linkify/LinkifyPlugin2$InlineLinkifyParser;", "Lio/noties/markwon/core/CorePlugin$OnTextAddedListener;", "()V", "onTextAdded", "", "visitor", "Lio/noties/markwon/MarkwonVisitor;", "text", "", "start", "", "node", "Lorg/commonmark/node/Node;", "Companion", "markwon-linkify_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static class InlineLinkifyParser implements CorePlugin.OnTextAddedListener {
        private static final String fragment;

        /* renamed from: ip */
        private static final Pattern f2329ip;
        private static final String path;
        private static final String port;
        private static final String query;
        private static final Pattern urlPattern;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final String scheme = scheme;
        private static final String scheme = scheme;
        private static final String host = host;
        private static final String host = host;

        /* compiled from: LinkifyPlugin2.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0084D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0084D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\nX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u0004X\u0084D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u0004X\u0084D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0014\u0010\u0011\u001a\u00020\u0004X\u0084D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0014\u0010\u0013\u001a\u00020\u0004X\u0084D¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006R\u001c\u0010\u0015\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0002\u001a\u0004\b\u0017\u0010\f¨\u0006\u0018"}, d2 = {"Lio/noties/markwon/linkify/LinkifyPlugin2$InlineLinkifyParser$Companion;", "", "()V", "fragment", "", "getFragment", "()Ljava/lang/String;", ReportUtil.Params.HOST, "getHost", "ip", "Ljava/util/regex/Pattern;", "getIp", "()Ljava/util/regex/Pattern;", "path", "getPath", "port", "getPort", "query", "getQuery", "scheme", "getScheme", "urlPattern", "urlPattern$annotations", "getUrlPattern", "markwon-linkify_release"}, k = 1, mv = {1, 1, 15})
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
        public static final class Companion {
            public static /* synthetic */ void urlPattern$annotations() {
            }

            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            protected final String getScheme() {
                return InlineLinkifyParser.scheme;
            }

            protected final String getHost() {
                return InlineLinkifyParser.host;
            }

            protected final Pattern getIp() {
                return InlineLinkifyParser.f2329ip;
            }

            protected final String getPort() {
                return InlineLinkifyParser.port;
            }

            protected final String getPath() {
                return InlineLinkifyParser.path;
            }

            protected final String getQuery() {
                return InlineLinkifyParser.query;
            }

            protected final String getFragment() {
                return InlineLinkifyParser.fragment;
            }

            public final Pattern getUrlPattern() {
                return InlineLinkifyParser.urlPattern;
            }
        }

        static {
            Pattern pattern = PatternsCompat.IP_ADDRESS;
            if (pattern == null) {
                Intrinsics.throwNpe();
            }
            f2329ip = pattern;
            port = port;
            path = path;
            query = query;
            fragment = fragment;
            Pattern compile = Pattern.compile(scheme + '(' + host + '|' + pattern + ')' + port + path + query + fragment);
            Intrinsics.checkExpressionValueIsNotNull(compile, "Pattern.compile(\"$scheme…ort$path$query$fragment\")");
            urlPattern = compile;
        }

        @Override // io.noties.markwon.core.CorePlugin.OnTextAddedListener
        public void onTextAdded(MarkwonVisitor visitor, String text, int start, Node node) {
            Intrinsics.checkParameterIsNotNull(visitor, "visitor");
            Intrinsics.checkParameterIsNotNull(text, "text");
            Intrinsics.checkParameterIsNotNull(node, "node");
            SpanFactory spanFactory = visitor.configuration().spansFactory().get(Link.class);
            if (spanFactory != null) {
                Intrinsics.checkExpressionValueIsNotNull(spanFactory, "visitor.configuration().…nk::class.java) ?: return");
                Matcher matcher = urlPattern.matcher(text);
                while (matcher.find()) {
                    int start2 = matcher.start();
                    int end = matcher.end();
                    String group = matcher.group();
                    if (!PatternsCompat.EMAIL_ADDRESS.matcher(group).find()) {
                        RenderProps renderProps = visitor.renderProps();
                        Intrinsics.checkExpressionValueIsNotNull(renderProps, "visitor.renderProps()");
                        SpannableBuilder builder = visitor.builder();
                        Intrinsics.checkExpressionValueIsNotNull(builder, "visitor.builder()");
                        CoreProps.LINK_DESTINATION.set(renderProps, group);
                        SpannableBuilder.setSpans(builder, spanFactory.getSpans(visitor.configuration(), renderProps), start2 + start, end + start);
                    }
                }
            }
        }
    }
}
