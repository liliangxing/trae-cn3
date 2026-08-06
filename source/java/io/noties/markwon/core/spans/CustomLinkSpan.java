package io.noties.markwon.core.spans;

import android.text.TextPaint;
import android.view.View;
import com.larus.business.markdown.api.depend.LinkResolverWithStyle;
import io.noties.markwon.LinkResolver;
import io.noties.markwon.core.MarkwonTheme;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CustomLinkSpan.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001cH\u0016R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0011\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lio/noties/markwon/core/spans/CustomLinkSpan;", "Lio/noties/markwon/core/spans/LinkSpan;", "theme", "Lio/noties/markwon/core/MarkwonTheme;", "link", "", "resolver", "Lio/noties/markwon/LinkResolver;", "(Lio/noties/markwon/core/MarkwonTheme;Ljava/lang/String;Lio/noties/markwon/LinkResolver;)V", "clickListener", "Landroid/view/View$OnClickListener;", "getClickListener", "()Landroid/view/View$OnClickListener;", "setClickListener", "(Landroid/view/View$OnClickListener;)V", "enableLinkStyle", "", "needUnderLine", "getNeedUnderLine", "()Z", "resolverWithStyle", "Lcom/larus/business/markdown/api/depend/LinkResolverWithStyle;", "onClick", "", "widget", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class CustomLinkSpan extends LinkSpan {
    private View.OnClickListener clickListener;
    private final boolean enableLinkStyle;
    private final boolean needUnderLine;
    private final LinkResolver resolver;
    private final LinkResolverWithStyle resolverWithStyle;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomLinkSpan(MarkwonTheme markwonTheme, String str, LinkResolver linkResolver) {
        super(markwonTheme, str, linkResolver);
        Intrinsics.checkNotNullParameter(markwonTheme, "theme");
        Intrinsics.checkNotNullParameter(str, "link");
        Intrinsics.checkNotNullParameter(linkResolver, "resolver");
        this.resolver = linkResolver;
        LinkResolver linkResolver2 = super.resolver;
        LinkResolverWithStyle linkResolverWithStyle = linkResolver2 instanceof LinkResolverWithStyle ? (LinkResolverWithStyle) linkResolver2 : null;
        linkResolverWithStyle = linkResolverWithStyle == null ? new LinkResolverWithStyle() { // from class: io.noties.markwon.core.spans.CustomLinkSpan$resolverWithStyle$1
            @Override // com.larus.business.markdown.api.depend.LinkResolverWithStyle
            public boolean enableLinkColor(String url) {
                Intrinsics.checkNotNullParameter(url, "url");
                return false;
            }

            @Override // com.larus.business.markdown.api.depend.LinkResolverWithStyle
            public boolean enableLinkStyle(String link) {
                Intrinsics.checkNotNullParameter(link, "link");
                return true;
            }

            @Override // com.larus.business.markdown.api.depend.LinkResolverWithStyle
            public int getLinkColor(String url) {
                Intrinsics.checkNotNullParameter(url, "url");
                return 0;
            }

            @Override // com.larus.business.markdown.api.depend.LinkResolverWithStyle
            public boolean needUnderline(String link) {
                Intrinsics.checkNotNullParameter(link, "link");
                return false;
            }

            @Override // com.larus.business.markdown.api.depend.LinkResolverWithStyle
            public void resolve(View view, String str2, boolean z) {
                LinkResolverWithStyle.DefaultImpls.resolve(this, view, str2, z);
            }

            @Override // com.larus.business.markdown.api.depend.LinkResolverWithStyle, io.noties.markwon.LinkResolver
            public void resolve(View view, String link) {
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(link, "link");
                ((LinkSpan) CustomLinkSpan.this).resolver.resolve(view, link);
            }
        } : linkResolverWithStyle;
        this.resolverWithStyle = linkResolverWithStyle;
        this.needUnderLine = linkResolverWithStyle.needUnderline(str);
        this.enableLinkStyle = linkResolverWithStyle.enableLinkStyle(str);
    }

    public final View.OnClickListener getClickListener() {
        return this.clickListener;
    }

    public final void setClickListener(View.OnClickListener onClickListener) {
        this.clickListener = onClickListener;
    }

    public final boolean getNeedUnderLine() {
        return this.needUnderLine;
    }

    @Override // io.noties.markwon.core.spans.LinkSpan, android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint ds) {
        Intrinsics.checkNotNullParameter(ds, "ds");
        if (super.resolver instanceof LinkResolverWithStyle) {
            LinkResolver linkResolver = super.resolver;
            Intrinsics.checkNotNull(linkResolver, "null cannot be cast to non-null type com.larus.business.markdown.api.depend.LinkResolverWithStyle");
            String link = getLink();
            Intrinsics.checkNotNullExpressionValue(link, "link");
            if (((LinkResolverWithStyle) linkResolver).enableLinkColor(link)) {
                super.updateDrawState(ds);
                LinkResolver linkResolver2 = super.resolver;
                Intrinsics.checkNotNull(linkResolver2, "null cannot be cast to non-null type com.larus.business.markdown.api.depend.LinkResolverWithStyle");
                String link2 = getLink();
                Intrinsics.checkNotNullExpressionValue(link2, "link");
                ds.setColor(((LinkResolverWithStyle) linkResolver2).getLinkColor(link2));
                return;
            }
        }
        if (this.enableLinkStyle) {
            super.updateDrawState(ds);
        }
    }

    @Override // io.noties.markwon.core.spans.LinkSpan, android.text.style.URLSpan, android.text.style.ClickableSpan
    public void onClick(View widget) {
        Intrinsics.checkNotNullParameter(widget, "widget");
        View.OnClickListener onClickListener = this.clickListener;
        if (onClickListener != null) {
            onClickListener.onClick(widget);
        }
        LinkResolverWithStyle linkResolverWithStyle = this.resolverWithStyle;
        String link = getLink();
        Intrinsics.checkNotNullExpressionValue(link, "link");
        linkResolverWithStyle.resolve(widget, link, this.enableLinkStyle);
    }
}
