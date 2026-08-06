package com.bytedance.ies.bullet.forest;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ForestRequestInfoBuilder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ies/bullet/forest/RequestInfoCacheKey;", "", "srcUrl", "", "cdnUrl", "(Ljava/lang/String;Ljava/lang/String;)V", "getCdnUrl", "()Ljava/lang/String;", "getSrcUrl", "component1", "component2", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class RequestInfoCacheKey {
    private final String cdnUrl;
    private final String srcUrl;

    public static /* synthetic */ RequestInfoCacheKey copy$default(RequestInfoCacheKey requestInfoCacheKey, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = requestInfoCacheKey.srcUrl;
        }
        if ((i & 2) != 0) {
            str2 = requestInfoCacheKey.cdnUrl;
        }
        return requestInfoCacheKey.copy(str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getSrcUrl() {
        return this.srcUrl;
    }

    /* renamed from: component2, reason: from getter */
    public final String getCdnUrl() {
        return this.cdnUrl;
    }

    public final RequestInfoCacheKey copy(String srcUrl, String cdnUrl) {
        Intrinsics.checkNotNullParameter(srcUrl, "srcUrl");
        return new RequestInfoCacheKey(srcUrl, cdnUrl);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RequestInfoCacheKey)) {
            return false;
        }
        RequestInfoCacheKey requestInfoCacheKey = (RequestInfoCacheKey) other;
        return Intrinsics.areEqual(this.srcUrl, requestInfoCacheKey.srcUrl) && Intrinsics.areEqual(this.cdnUrl, requestInfoCacheKey.cdnUrl);
    }

    public int hashCode() {
        int hashCode = this.srcUrl.hashCode() * 31;
        String str = this.cdnUrl;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "RequestInfoCacheKey(srcUrl=" + this.srcUrl + ", cdnUrl=" + this.cdnUrl + ')';
    }

    public RequestInfoCacheKey(String srcUrl, String str) {
        Intrinsics.checkNotNullParameter(srcUrl, "srcUrl");
        this.srcUrl = srcUrl;
        this.cdnUrl = str;
    }

    public /* synthetic */ RequestInfoCacheKey(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? "" : str2);
    }

    public final String getCdnUrl() {
        return this.cdnUrl;
    }

    public final String getSrcUrl() {
        return this.srcUrl;
    }
}
