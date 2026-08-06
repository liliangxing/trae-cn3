package com.larus.business.markdown.api.citation;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.trae.home.solo.setting.SettingsTracker;
import com.bytedance.webx.core.webview.WebViewContainer;
import io.noties.markwon.core.MarkwonTheme;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ICitationHandler.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fJr\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\fH&J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J<\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u0015\u001a\u00020\u0016H&¨\u0006 "}, d2 = {"Lcom/larus/business/markdown/api/citation/ICitationHandler;", "", WebViewContainer.EVENT_draw, "", "canvas", "Landroid/graphics/Canvas;", "text", "", "start", "", "end", "x", "", "top", "y", "bottom", "pt", "Landroid/graphics/Paint;", "paint", SettingsTracker.TYPE_THEME, "Lio/noties/markwon/core/MarkwonTheme;", "info", "Lcom/larus/business/markdown/api/citation/ICitationHandler$Companion$CitationInfo;", "pressedProgress", "enableCustomCitation", "", "linkTitle", "", "getSize", "fm", "Landroid/graphics/Paint$FontMetricsInt;", "Companion", "markdown-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public interface ICitationHandler {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    /* compiled from: ICitationHandler.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class DefaultImpls {
        public static boolean enableCustomCitation(ICitationHandler iCitationHandler, String linkTitle) {
            Intrinsics.checkNotNullParameter(linkTitle, "linkTitle");
            return false;
        }
    }

    void draw(Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, Paint pt, Paint paint, MarkwonTheme theme, Companion.CitationInfo info, float pressedProgress);

    boolean enableCustomCitation(String linkTitle);

    int getSize(Paint paint, CharSequence text, int start, int end, Paint.FontMetricsInt fm, Companion.CitationInfo info);

    /* compiled from: ICitationHandler.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/larus/business/markdown/api/citation/ICitationHandler$Companion;", "", "()V", "CitationInfo", "markdown-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        /* compiled from: ICitationHandler.kt */
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/larus/business/markdown/api/citation/ICitationHandler$Companion$CitationInfo;", "", "content", "", "url", "(Ljava/lang/String;Ljava/lang/String;)V", "getContent", "()Ljava/lang/String;", "getUrl", "component1", "component2", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "markdown-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes6.dex */
        public static final /* data */ class CitationInfo {
            private final String content;
            private final String url;

            public static /* synthetic */ CitationInfo copy$default(CitationInfo citationInfo, String str, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = citationInfo.content;
                }
                if ((i & 2) != 0) {
                    str2 = citationInfo.url;
                }
                return citationInfo.copy(str, str2);
            }

            /* renamed from: component1, reason: from getter */
            public final String getContent() {
                return this.content;
            }

            /* renamed from: component2, reason: from getter */
            public final String getUrl() {
                return this.url;
            }

            public final CitationInfo copy(String content, String url) {
                Intrinsics.checkNotNullParameter(content, "content");
                Intrinsics.checkNotNullParameter(url, "url");
                return new CitationInfo(content, url);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof CitationInfo)) {
                    return false;
                }
                CitationInfo citationInfo = (CitationInfo) other;
                return Intrinsics.areEqual(this.content, citationInfo.content) && Intrinsics.areEqual(this.url, citationInfo.url);
            }

            public int hashCode() {
                return (this.content.hashCode() * 31) + this.url.hashCode();
            }

            public String toString() {
                return "CitationInfo(content=" + this.content + ", url=" + this.url + ')';
            }

            public CitationInfo(String content, String url) {
                Intrinsics.checkNotNullParameter(content, "content");
                Intrinsics.checkNotNullParameter(url, "url");
                this.content = content;
                this.url = url;
            }

            public final String getContent() {
                return this.content;
            }

            public final String getUrl() {
                return this.url;
            }
        }

        private Companion() {
        }
    }
}
