package io.noties.markwon.html;

import com.larus.business.markdown.api.depend.ICustomDataHandler;
import com.larus.business.markdown.api.depend.IMarkdownEnsureManager;
import com.larus.business.markdown.api.depend.IMarkdownEnsureManagerKt;
import com.larus.business.markdown.api.extplugin.html.HtmlCssStyle;
import com.larus.business.markdown.api.widget.IMarkdownWidgetHandlerKt;
import com.larus.business.markdown.impl.markwon.customdata.CustomDataTagHandler;
import io.noties.markwon.MarkwonVisitor;
import io.noties.markwon.html.HtmlPlugin;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CustomHtmlPlugin.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013BC\b\u0000\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\u001a\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0007H\u0014¨\u0006\u0014"}, d2 = {"Lio/noties/markwon/html/CustomHtmlPlugin;", "Lio/noties/markwon/html/HtmlPlugin3;", "handlerList", "", "Lcom/larus/business/markdown/api/depend/ICustomDataHandler;", "htmlCssStyleMap", "", "", "Lcom/larus/business/markdown/api/extplugin/html/HtmlCssStyle;", "darkMode", "", "printLog", "Lio/noties/markwon/html/IPrintLog;", "(Ljava/util/List;Ljava/util/Map;ZLio/noties/markwon/html/IPrintLog;)V", "visitHtml", "", "visitor", "Lio/noties/markwon/MarkwonVisitor;", "html", "Companion", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class CustomHtmlPlugin extends HtmlPlugin3 {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static boolean sHasHtml;

    public /* synthetic */ CustomHtmlPlugin(List list, Map map, boolean z, IPrintLog iPrintLog, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i & 2) != 0 ? null : map, (i & 4) != 0 ? false : z, iPrintLog);
    }

    public CustomHtmlPlugin(List<? extends ICustomDataHandler> list, Map<String, HtmlCssStyle> map, boolean z, IPrintLog iPrintLog) {
        super(null, 1, null);
        addHandler(new PWithCssHandler(map, z));
        addHandler(new DivWithCssHandler(map, z));
        addHandler(new LinkWithCssHandler(map, z));
        addHandler(new SpanWithCssHandler(map, z));
        addHandler(new UnderlineWithCssHandler(map, z));
        addHandler(new CustomDataTagHandler(list));
        additionBlockTags(SetsKt.setOf(new String[]{IMarkdownWidgetHandlerKt.DATA_BLOCK_TAG, IMarkdownWidgetHandlerKt.DATA_BLOCK_FULL_TAG, IMarkdownWidgetHandlerKt.DATA_BLOCK_IMAGE_GALLERY}));
        additionInlineTags(SetsKt.setOf(new String[]{IMarkdownWidgetHandlerKt.DATA_INLINE_TAG, IMarkdownWidgetHandlerKt.DATA_INLINE_NO_MARGIN_TAG}));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.noties.markwon.html.HtmlPlugin
    public void visitHtml(MarkwonVisitor visitor, String html) {
        Object obj;
        IMarkdownEnsureManager markdownEnsureManagerDelegate;
        Intrinsics.checkNotNullParameter(visitor, "visitor");
        if (html != null && !sHasHtml) {
            sHasHtml = true;
        }
        try {
            Result.Companion companion = Result.Companion;
            super.visitHtml(visitor, html);
            obj = Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable th2 = Result.exceptionOrNull-impl(obj);
        if (th2 == null || (markdownEnsureManagerDelegate = IMarkdownEnsureManagerKt.getMarkdownEnsureManagerDelegate()) == null) {
            return;
        }
        markdownEnsureManagerDelegate.ensureNotReachHere(th2, String.valueOf(th2.getMessage()));
    }

    /* compiled from: CustomHtmlPlugin.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ<\u0010\t\u001a\u00020\n2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u00112\u0006\u0010\u0014\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0017"}, d2 = {"Lio/noties/markwon/html/CustomHtmlPlugin$Companion;", "", "()V", "sHasHtml", "", "getSHasHtml", "()Z", "setSHasHtml", "(Z)V", "create", "Lio/noties/markwon/html/HtmlPlugin;", "configure", "Lio/noties/markwon/html/HtmlPlugin$HtmlConfigure;", "list", "", "Lcom/larus/business/markdown/api/depend/ICustomDataHandler;", "htmlCssStyleMap", "", "", "Lcom/larus/business/markdown/api/extplugin/html/HtmlCssStyle;", "darkMode", "printLog", "Lio/noties/markwon/html/IPrintLog;", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final HtmlPlugin create(List<? extends ICustomDataHandler> list, Map<String, HtmlCssStyle> htmlCssStyleMap, boolean darkMode, IPrintLog printLog) {
            Intrinsics.checkNotNullParameter(htmlCssStyleMap, "htmlCssStyleMap");
            return new CustomHtmlPlugin(list, htmlCssStyleMap, darkMode, printLog);
        }

        public final HtmlPlugin create(HtmlPlugin.HtmlConfigure configure) {
            Intrinsics.checkNotNullParameter(configure, "configure");
            HtmlPlugin3 create = HtmlPlugin3.INSTANCE.create();
            configure.configureHtml(create);
            return create;
        }

        public final boolean getSHasHtml() {
            return CustomHtmlPlugin.sHasHtml;
        }

        public final void setSHasHtml(boolean z) {
            CustomHtmlPlugin.sHasHtml = z;
        }
    }
}
