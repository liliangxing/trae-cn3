package com.larus.business.markdown.impl.markwon;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.core.util.PatternsCompat;
import com.larus.business.markdown.api.customlink.ICustomLinkHandler;
import com.larus.business.markdown.api.model.ILinkIconSpan;
import com.larus.business.markdown.impl.markwon.IgnoreMentionLinkifyPlugin;
import io.noties.markwon.MarkwonPlugin;
import io.noties.markwon.MarkwonVisitor;
import io.noties.markwon.RenderProps;
import io.noties.markwon.SpanFactory;
import io.noties.markwon.SpannableBuilder;
import io.noties.markwon.core.CorePlugin;
import io.noties.markwon.core.CorePlugin2;
import io.noties.markwon.core.CoreProps;
import io.noties.markwon.html.IPrintLog;
import io.noties.markwon.linkify.LinkifyPlugin2;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.commonmark.node.Link;
import org.commonmark.node.Node;

/* compiled from: IgnoreMentionLinkifyPlugin.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0015B/\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0016"}, d2 = {"Lcom/larus/business/markdown/impl/markwon/IgnoreMentionLinkifyPlugin;", "Lio/noties/markwon/linkify/LinkifyPlugin2;", "autoLinkMaxLimit", "", "linkHandler", "Lcom/larus/business/markdown/api/customlink/ICustomLinkHandler;", "linkColor", "printLog", "Lio/noties/markwon/html/IPrintLog;", "(Ljava/lang/Integer;Lcom/larus/business/markdown/api/customlink/ICustomLinkHandler;ILio/noties/markwon/html/IPrintLog;)V", "Ljava/lang/Integer;", "getLinkColor", "()I", "getLinkHandler", "()Lcom/larus/business/markdown/api/customlink/ICustomLinkHandler;", "getPrintLog", "()Lio/noties/markwon/html/IPrintLog;", "configure", "", "registry", "Lio/noties/markwon/MarkwonPlugin$Registry;", "LinkifyParser", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class IgnoreMentionLinkifyPlugin extends LinkifyPlugin2 {
    private final Integer autoLinkMaxLimit;
    private final int linkColor;
    private final ICustomLinkHandler linkHandler;
    private final IPrintLog printLog;

    public /* synthetic */ IgnoreMentionLinkifyPlugin(Integer num, ICustomLinkHandler iCustomLinkHandler, int i, IPrintLog iPrintLog, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : num, iCustomLinkHandler, i, iPrintLog);
    }

    public IgnoreMentionLinkifyPlugin(Integer num, ICustomLinkHandler iCustomLinkHandler, int i, IPrintLog iPrintLog) {
        this.autoLinkMaxLimit = num;
        this.linkHandler = iCustomLinkHandler;
        this.linkColor = i;
        this.printLog = iPrintLog;
    }

    public final int getLinkColor() {
        return this.linkColor;
    }

    public final ICustomLinkHandler getLinkHandler() {
        return this.linkHandler;
    }

    public final IPrintLog getPrintLog() {
        return this.printLog;
    }

    @Override // io.noties.markwon.linkify.LinkifyPlugin2, io.noties.markwon.AbstractMarkwonPlugin, io.noties.markwon.MarkwonPlugin
    public void configure(MarkwonPlugin.Registry registry) {
        Intrinsics.checkNotNullParameter(registry, "registry");
        registry.require(CorePlugin.class, new MarkwonPlugin.Action() { // from class: com.larus.business.markdown.impl.markwon.IgnoreMentionLinkifyPlugin$configure$1
            @Override // io.noties.markwon.MarkwonPlugin.Action
            public final void apply(CorePlugin corePlugin) {
                Integer num;
                Intrinsics.checkNotNullParameter(corePlugin, "corePlugin");
                num = IgnoreMentionLinkifyPlugin.this.autoLinkMaxLimit;
                corePlugin.addOnTextAddedListener(new IgnoreMentionLinkifyPlugin.LinkifyParser(num, IgnoreMentionLinkifyPlugin.this.getLinkHandler(), IgnoreMentionLinkifyPlugin.this.getLinkColor(), IgnoreMentionLinkifyPlugin.this.getPrintLog()));
            }
        });
    }

    /* compiled from: IgnoreMentionLinkifyPlugin.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB/\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ(\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0019H\u0017R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/larus/business/markdown/impl/markwon/IgnoreMentionLinkifyPlugin$LinkifyParser;", "Lio/noties/markwon/linkify/LinkifyPlugin2$InlineLinkifyParser;", "autoLinkMaxLimit", "", "linkHandler", "Lcom/larus/business/markdown/api/customlink/ICustomLinkHandler;", "linkColor", "printLog", "Lio/noties/markwon/html/IPrintLog;", "(Ljava/lang/Integer;Lcom/larus/business/markdown/api/customlink/ICustomLinkHandler;ILio/noties/markwon/html/IPrintLog;)V", "Ljava/lang/Integer;", "getLinkColor", "()I", "getLinkHandler", "()Lcom/larus/business/markdown/api/customlink/ICustomLinkHandler;", "getPrintLog", "()Lio/noties/markwon/html/IPrintLog;", "onTextAdded", "", "visitor", "Lio/noties/markwon/MarkwonVisitor;", "text", "", "start", "node", "Lorg/commonmark/node/Node;", "Companion", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static class LinkifyParser extends LinkifyPlugin2.InlineLinkifyParser {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final String REPLACE;
        private static final Pattern excludeMatcher;
        private final Integer autoLinkMaxLimit;
        private final int linkColor;
        private final ICustomLinkHandler linkHandler;
        private final IPrintLog printLog;

        public LinkifyParser(Integer num, ICustomLinkHandler iCustomLinkHandler, int i, IPrintLog iPrintLog) {
            this.autoLinkMaxLimit = num;
            this.linkHandler = iCustomLinkHandler;
            this.linkColor = i;
            this.printLog = iPrintLog;
        }

        public /* synthetic */ LinkifyParser(Integer num, ICustomLinkHandler iCustomLinkHandler, int i, IPrintLog iPrintLog, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? null : num, iCustomLinkHandler, i, iPrintLog);
        }

        public final int getLinkColor() {
            return this.linkColor;
        }

        public final ICustomLinkHandler getLinkHandler() {
            return this.linkHandler;
        }

        public final IPrintLog getPrintLog() {
            return this.printLog;
        }

        /* compiled from: IgnoreMentionLinkifyPlugin.kt */
        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/larus/business/markdown/impl/markwon/IgnoreMentionLinkifyPlugin$LinkifyParser$Companion;", "", "()V", "REPLACE", "", "getREPLACE", "()Ljava/lang/String;", "excludeMatcher", "Ljava/util/regex/Pattern;", "getExcludeMatcher", "()Ljava/util/regex/Pattern;", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Pattern getExcludeMatcher() {
                return LinkifyParser.excludeMatcher;
            }

            public final String getREPLACE() {
                return LinkifyParser.REPLACE;
            }
        }

        static {
            Pattern compile = Pattern.compile("[a-zA-Z]*\\.[a-zA-Z]*");
            Intrinsics.checkNotNullExpressionValue(compile, "compile(\"[a-zA-Z]*\\\\.[a-zA-Z]*\")");
            excludeMatcher = compile;
            REPLACE = "¥";
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r12v3, types: [io.noties.markwon.SpannableBuilder, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r3v11 */
        /* JADX WARN: Type inference failed for: r3v12 */
        /* JADX WARN: Type inference failed for: r3v17 */
        /* JADX WARN: Type inference failed for: r3v7 */
        /* JADX WARN: Type inference failed for: r3v8, types: [int, boolean] */
        @Override // io.noties.markwon.linkify.LinkifyPlugin2.InlineLinkifyParser, io.noties.markwon.core.CorePlugin.OnTextAddedListener
        public void onTextAdded(MarkwonVisitor visitor, String text, int start, Node node) {
            SpanFactory spanFactory;
            Matcher matcher;
            SpanFactory spanFactory2;
            boolean z;
            Matcher matcher2;
            SpanFactory spanFactory3;
            boolean z2;
            Intrinsics.checkNotNullParameter(visitor, "visitor");
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(node, "node");
            if ((this.autoLinkMaxLimit != null && text.length() > this.autoLinkMaxLimit.intValue()) || (node.parent instanceof Link) || (spanFactory = visitor.configuration().spansFactory().get(Link.class)) == null) {
                return;
            }
            Matcher matcher3 = LinkifyPlugin2.InlineLinkifyParser.INSTANCE.getUrlPattern().matcher(text);
            ?? r3 = 0;
            int i = 0;
            while (matcher3.find()) {
                int start2 = matcher3.start();
                int end = matcher3.end();
                final String group = matcher3.group();
                Intrinsics.checkNotNullExpressionValue(group, "url");
                if (!StringsKt.startsWith$default(group, "@", (boolean) r3, 2, (Object) null)) {
                    String str = group;
                    if (!excludeMatcher.matcher(str).matches() && !PatternsCompat.EMAIL_ADDRESS.matcher(str).find()) {
                        RenderProps renderProps = visitor.renderProps();
                        Intrinsics.checkNotNullExpressionValue(renderProps, "visitor.renderProps()");
                        ?? builder = visitor.builder();
                        Intrinsics.checkNotNullExpressionValue((Object) builder, "visitor.builder()");
                        CoreProps.LINK_DESTINATION.set(renderProps, group);
                        CorePlugin2.INSTANCE.getLINK_TITLE().clear(renderProps);
                        ICustomLinkHandler iCustomLinkHandler = this.linkHandler;
                        if (iCustomLinkHandler != null) {
                            String title = iCustomLinkHandler.getTitle(group);
                            if (!((title == null || title.length() == 0) ? true : r3)) {
                                CharSequence subSequence = builder.subSequence(r3, (start + start2) - i);
                                Intrinsics.checkNotNullExpressionValue(subSequence, "spannableBuilder.subSequ…rt + urlStart - shortLen)");
                                CharSequence subSequence2 = builder.subSequence((start + end) - i, builder.length());
                                Intrinsics.checkNotNullExpressionValue(subSequence2, "spannableBuilder.subSequ… spannableBuilder.length)");
                                builder.clear();
                                builder.append(subSequence);
                                int length = builder.length();
                                String title2 = this.linkHandler.getTitle(group);
                                String str2 = title2;
                                if ((str2 == null || str2.length() == 0) ? true : r3) {
                                    builder.append(group);
                                    matcher2 = matcher3;
                                    spanFactory3 = spanFactory;
                                    z2 = r3;
                                } else {
                                    ILinkIconSpan span = this.linkHandler.getSpan(group, this.linkColor);
                                    if (span != null) {
                                        String str3 = REPLACE;
                                        matcher2 = matcher3;
                                        spanFactory3 = spanFactory;
                                        z2 = false;
                                        if (StringsKt.endsWith$default(subSequence, str3, false, 2, (Object) null)) {
                                            builder.setSpan(span, builder.length() - 1);
                                        } else {
                                            builder.append(str3, span);
                                        }
                                    } else {
                                        matcher2 = matcher3;
                                        spanFactory3 = spanFactory;
                                        z2 = false;
                                    }
                                    builder.append(title2);
                                }
                                builder.setSpan(new ClickableSpan() { // from class: com.larus.business.markdown.impl.markwon.IgnoreMentionLinkifyPlugin$LinkifyParser$onTextAdded$2
                                    @Override // android.text.style.ClickableSpan
                                    public void onClick(View widget) {
                                        Intrinsics.checkNotNullParameter(widget, "widget");
                                        ICustomLinkHandler linkHandler = IgnoreMentionLinkifyPlugin.LinkifyParser.this.getLinkHandler();
                                        String str4 = group;
                                        Intrinsics.checkNotNullExpressionValue(str4, "url");
                                        linkHandler.onClick(widget, str4);
                                    }

                                    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                                    public void updateDrawState(TextPaint ds) {
                                        Intrinsics.checkNotNullParameter(ds, "ds");
                                        ds.setColor(IgnoreMentionLinkifyPlugin.LinkifyParser.this.getLinkColor());
                                    }
                                }, length, builder.length());
                                i += ((end - start2) - builder.length()) + length;
                                IPrintLog iPrintLog = this.printLog;
                                if (iPrintLog != null) {
                                    iPrintLog.m2593d("LinkifyParser", "url: " + group + ",title: " + this.linkHandler.getTitle(group));
                                }
                                builder.append(subSequence2);
                                r3 = z2;
                                matcher3 = matcher2;
                                spanFactory = spanFactory3;
                            }
                        }
                        matcher = matcher3;
                        SpanFactory spanFactory4 = spanFactory;
                        z = r3;
                        spanFactory2 = spanFactory4;
                        SpannableBuilder.setSpans(builder, spanFactory2.getSpans(visitor.configuration(), renderProps), start + start2, start + end);
                        matcher3 = matcher;
                        SpanFactory spanFactory5 = spanFactory2;
                        r3 = z;
                        spanFactory = spanFactory5;
                    }
                }
                matcher = matcher3;
                boolean z3 = r3;
                spanFactory2 = spanFactory;
                z = z3;
                matcher3 = matcher;
                SpanFactory spanFactory52 = spanFactory2;
                r3 = z;
                spanFactory = spanFactory52;
            }
        }
    }
}
