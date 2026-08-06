package com.bytedance.trae.conversation.chat.block.renderer.ref;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TraeRefModels.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J)\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefSource;", "", "url", "", "host", "title", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "getHost", "getTitle", "component1", "component2", "component3", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class TraeRefSource {
    private final String host;
    private final String title;
    private final String url;

    public static /* synthetic */ TraeRefSource copy$default(TraeRefSource traeRefSource, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = traeRefSource.url;
        }
        if ((i & 2) != 0) {
            str2 = traeRefSource.host;
        }
        if ((i & 4) != 0) {
            str3 = traeRefSource.title;
        }
        return traeRefSource.copy(str, str2, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* renamed from: component2, reason: from getter */
    public final String getHost() {
        return this.host;
    }

    /* renamed from: component3, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    public final TraeRefSource copy(String url, String host, String title) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(host, "host");
        return new TraeRefSource(url, host, title);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TraeRefSource)) {
            return false;
        }
        TraeRefSource traeRefSource = (TraeRefSource) other;
        return Intrinsics.areEqual(this.url, traeRefSource.url) && Intrinsics.areEqual(this.host, traeRefSource.host) && Intrinsics.areEqual(this.title, traeRefSource.title);
    }

    public int hashCode() {
        int hashCode = ((this.url.hashCode() * 31) + this.host.hashCode()) * 31;
        String str = this.title;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "TraeRefSource(url=" + this.url + ", host=" + this.host + ", title=" + this.title + ')';
    }

    public TraeRefSource(String url, String host, String str) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(host, "host");
        this.url = url;
        this.host = host;
        this.title = str;
    }

    public /* synthetic */ TraeRefSource(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? null : str3);
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getHost() {
        return this.host;
    }

    public final String getTitle() {
        return this.title;
    }
}
