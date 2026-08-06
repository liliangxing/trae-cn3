package com.larus.business.markdown.api.depend;

import android.view.View;
import io.noties.markwon.LinkResolver;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LinkResolverWithStyle.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H&J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u0005H&J \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u000f"}, d2 = {"Lcom/larus/business/markdown/api/depend/LinkResolverWithStyle;", "Lio/noties/markwon/LinkResolver;", "enableLinkColor", "", "url", "", "enableLinkStyle", "link", "getLinkColor", "", "needUnderline", "resolve", "", "view", "Landroid/view/View;", "markdown-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public interface LinkResolverWithStyle extends LinkResolver {
    boolean enableLinkColor(String url);

    boolean enableLinkStyle(String link);

    int getLinkColor(String url);

    boolean needUnderline(String link);

    @Override // io.noties.markwon.LinkResolver
    void resolve(View view, String link);

    void resolve(View view, String link, boolean enableLinkStyle);

    /* compiled from: LinkResolverWithStyle.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class DefaultImpls {
        public static boolean needUnderline(LinkResolverWithStyle linkResolverWithStyle, String link) {
            Intrinsics.checkNotNullParameter(link, "link");
            return false;
        }

        public static void resolve(LinkResolverWithStyle linkResolverWithStyle, View view, String link, boolean z) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(link, "link");
            if (z) {
                linkResolverWithStyle.resolve(view, link);
            }
        }
    }
}
