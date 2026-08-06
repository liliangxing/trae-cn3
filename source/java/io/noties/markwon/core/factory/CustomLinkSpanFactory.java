package io.noties.markwon.core.factory;

import com.larus.business.markdown.api.citation.ICitationHandler;
import io.noties.markwon.LinkResolver;
import io.noties.markwon.MarkwonConfiguration;
import io.noties.markwon.RenderProps;
import io.noties.markwon.core.CorePlugin2;
import io.noties.markwon.core.CoreProps;
import io.noties.markwon.core.MarkwonTheme;
import io.noties.markwon.core.spans.CustomCitationSpan;
import io.noties.markwon.core.spans.CustomLinkSpan;
import io.noties.markwon.core.spans.CustomMentionSpan;
import io.noties.markwon.html.IPrintLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: CustomLinkSpanFactory.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lio/noties/markwon/core/factory/CustomLinkSpanFactory;", "Lio/noties/markwon/core/factory/LinkSpanFactory;", "handler", "Lcom/larus/business/markdown/api/citation/ICitationHandler;", "printLog", "Lio/noties/markwon/html/IPrintLog;", "(Lcom/larus/business/markdown/api/citation/ICitationHandler;Lio/noties/markwon/html/IPrintLog;)V", "getSpans", "", "configuration", "Lio/noties/markwon/MarkwonConfiguration;", "props", "Lio/noties/markwon/RenderProps;", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class CustomLinkSpanFactory extends LinkSpanFactory {
    private final ICitationHandler handler;
    private final IPrintLog printLog;

    public /* synthetic */ CustomLinkSpanFactory(ICitationHandler iCitationHandler, IPrintLog iPrintLog, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : iCitationHandler, iPrintLog);
    }

    public CustomLinkSpanFactory(ICitationHandler iCitationHandler, IPrintLog iPrintLog) {
        this.handler = iCitationHandler;
        this.printLog = iPrintLog;
    }

    @Override // io.noties.markwon.core.factory.LinkSpanFactory, io.noties.markwon.SpanFactory
    public Object getSpans(MarkwonConfiguration configuration, RenderProps props) {
        String str;
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(props, "props");
        String require = CoreProps.LINK_DESTINATION.require(props);
        Intrinsics.checkNotNullExpressionValue(require, "LINK_DESTINATION.require(props)");
        String str2 = require;
        try {
            str = CorePlugin2.INSTANCE.getLINK_TITLE().require(props);
        } catch (Exception unused) {
            str = "";
        }
        String str3 = str;
        Intrinsics.checkNotNullExpressionValue(str3, "try {\n            CorePl…\n            \"\"\n        }");
        ICitationHandler iCitationHandler = this.handler;
        if (iCitationHandler != null && iCitationHandler.enableCustomCitation(str3)) {
            MarkwonTheme theme = configuration.theme();
            Intrinsics.checkNotNullExpressionValue(theme, "configuration.theme()");
            LinkResolver linkResolver = configuration.linkResolver();
            Intrinsics.checkNotNullExpressionValue(linkResolver, "configuration.linkResolver()");
            return new CustomCitationSpan(theme, str3, str2, linkResolver, this.handler);
        }
        if (StringsKt.startsWith$default(str2, "mention://", false, 2, (Object) null)) {
            return new CustomMentionSpan(1);
        }
        IPrintLog iPrintLog = this.printLog;
        if (iPrintLog != null) {
            iPrintLog.m2593d("CustomLinkSpanFactory", "link: " + str2 + ",title: " + str3);
        }
        MarkwonTheme theme2 = configuration.theme();
        Intrinsics.checkNotNullExpressionValue(theme2, "configuration.theme()");
        LinkResolver linkResolver2 = configuration.linkResolver();
        Intrinsics.checkNotNullExpressionValue(linkResolver2, "configuration.linkResolver()");
        return new CustomLinkSpan(theme2, str2, linkResolver2);
    }
}
