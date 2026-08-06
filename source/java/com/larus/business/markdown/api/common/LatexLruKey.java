package com.larus.business.markdown.api.common;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FlowMarkdownReuseDrawablePool.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\bJ$\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/larus/business/markdown/api/common/LatexLruKey;", "", "url", "", "order", "", "(Ljava/lang/String;Ljava/lang/Integer;)V", "getOrder", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getUrl", "()Ljava/lang/String;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Integer;)Lcom/larus/business/markdown/api/common/LatexLruKey;", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "markdown-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public final /* data */ class LatexLruKey {
    private final Integer order;
    private final String url;

    public static /* synthetic */ LatexLruKey copy$default(LatexLruKey latexLruKey, String str, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            str = latexLruKey.url;
        }
        if ((i & 2) != 0) {
            num = latexLruKey.order;
        }
        return latexLruKey.copy(str, num);
    }

    /* renamed from: component1, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* renamed from: component2, reason: from getter */
    public final Integer getOrder() {
        return this.order;
    }

    public final LatexLruKey copy(String url, Integer order) {
        Intrinsics.checkNotNullParameter(url, "url");
        return new LatexLruKey(url, order);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LatexLruKey)) {
            return false;
        }
        LatexLruKey latexLruKey = (LatexLruKey) other;
        return Intrinsics.areEqual(this.url, latexLruKey.url) && Intrinsics.areEqual(this.order, latexLruKey.order);
    }

    public int hashCode() {
        int hashCode = this.url.hashCode() * 31;
        Integer num = this.order;
        return hashCode + (num == null ? 0 : num.hashCode());
    }

    public String toString() {
        return "LatexLruKey(url=" + this.url + ", order=" + this.order + ')';
    }

    public LatexLruKey(String url, Integer num) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.url = url;
        this.order = num;
    }

    public final Integer getOrder() {
        return this.order;
    }

    public final String getUrl() {
        return this.url;
    }
}
