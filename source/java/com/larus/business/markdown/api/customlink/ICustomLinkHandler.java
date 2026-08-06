package com.larus.business.markdown.api.customlink;

import android.view.View;
import com.bytedance.forest.model.PreloadConfig;
import com.larus.business.markdown.api.model.ILinkIconSpan;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ICustomLinkHandler.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \r2\u00020\u0001:\u0001\rJ\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0007H&J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u000e"}, d2 = {"Lcom/larus/business/markdown/api/customlink/ICustomLinkHandler;", "", "getSpan", "Lcom/larus/business/markdown/api/model/ILinkIconSpan;", "url", "", "linkColor", "", "getTitle", "onClick", "", "view", "Landroid/view/View;", "Companion", "markdown-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public interface ICustomLinkHandler {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    ILinkIconSpan getSpan(String url, int linkColor);

    String getTitle(String url);

    void onClick(View view, String url);

    /* compiled from: ICustomLinkHandler.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/larus/business/markdown/api/customlink/ICustomLinkHandler$Companion;", "", "()V", "LinkInfo", "markdown-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        /* compiled from: ICustomLinkHandler.kt */
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001f\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/larus/business/markdown/api/customlink/ICustomLinkHandler$Companion$LinkInfo;", "", "title", "", "url", "(Ljava/lang/String;Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "getUrl", "component1", "component2", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "markdown-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes6.dex */
        public static final /* data */ class LinkInfo {
            private final String title;
            private final String url;

            public static /* synthetic */ LinkInfo copy$default(LinkInfo linkInfo, String str, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = linkInfo.title;
                }
                if ((i & 2) != 0) {
                    str2 = linkInfo.url;
                }
                return linkInfo.copy(str, str2);
            }

            /* renamed from: component1, reason: from getter */
            public final String getTitle() {
                return this.title;
            }

            /* renamed from: component2, reason: from getter */
            public final String getUrl() {
                return this.url;
            }

            public final LinkInfo copy(String title, String url) {
                Intrinsics.checkNotNullParameter(url, "url");
                return new LinkInfo(title, url);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof LinkInfo)) {
                    return false;
                }
                LinkInfo linkInfo = (LinkInfo) other;
                return Intrinsics.areEqual(this.title, linkInfo.title) && Intrinsics.areEqual(this.url, linkInfo.url);
            }

            public int hashCode() {
                String str = this.title;
                return ((str == null ? 0 : str.hashCode()) * 31) + this.url.hashCode();
            }

            public String toString() {
                return "LinkInfo(title=" + this.title + ", url=" + this.url + ')';
            }

            public LinkInfo(String str, String url) {
                Intrinsics.checkNotNullParameter(url, "url");
                this.title = str;
                this.url = url;
            }

            public final String getTitle() {
                return this.title;
            }

            public final String getUrl() {
                return this.url;
            }
        }

        private Companion() {
        }
    }
}
