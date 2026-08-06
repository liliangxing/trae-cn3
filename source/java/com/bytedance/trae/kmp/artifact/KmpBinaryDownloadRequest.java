package com.bytedance.trae.kmp.artifact;

import com.bytedance.forest.model.PreloadConfig;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KmpArtifactIo.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J=\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÇ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u001c\u001a\u00020\u001dH×\u0001J\t\u0010\u001e\u001a\u00020\u0003H×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcom/bytedance/trae/kmp/artifact/KmpBinaryDownloadRequest;", "", "url", "", "headers", "", "auth", "Lcom/bytedance/trae/kmp/artifact/KmpBinaryAuth;", "target", "Lcom/bytedance/trae/kmp/artifact/KmpFileReference;", "<init>", "(Ljava/lang/String;Ljava/util/Map;Lcom/bytedance/trae/kmp/artifact/KmpBinaryAuth;Lcom/bytedance/trae/kmp/artifact/KmpFileReference;)V", "getUrl", "()Ljava/lang/String;", "getHeaders", "()Ljava/util/Map;", "getAuth", "()Lcom/bytedance/trae/kmp/artifact/KmpBinaryAuth;", "getTarget", "()Lcom/bytedance/trae/kmp/artifact/KmpFileReference;", "component1", "component2", "component3", "component4", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "base_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class KmpBinaryDownloadRequest {
    public static final int $stable = 8;
    private final KmpBinaryAuth auth;
    private final Map<String, String> headers;
    private final KmpFileReference target;
    private final String url;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ KmpBinaryDownloadRequest copy$default(KmpBinaryDownloadRequest kmpBinaryDownloadRequest, String str, Map map, KmpBinaryAuth kmpBinaryAuth, KmpFileReference kmpFileReference, int i, Object obj) {
        if ((i & 1) != 0) {
            str = kmpBinaryDownloadRequest.url;
        }
        if ((i & 2) != 0) {
            map = kmpBinaryDownloadRequest.headers;
        }
        if ((i & 4) != 0) {
            kmpBinaryAuth = kmpBinaryDownloadRequest.auth;
        }
        if ((i & 8) != 0) {
            kmpFileReference = kmpBinaryDownloadRequest.target;
        }
        return kmpBinaryDownloadRequest.copy(str, map, kmpBinaryAuth, kmpFileReference);
    }

    /* renamed from: component1, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    public final Map<String, String> component2() {
        return this.headers;
    }

    /* renamed from: component3, reason: from getter */
    public final KmpBinaryAuth getAuth() {
        return this.auth;
    }

    /* renamed from: component4, reason: from getter */
    public final KmpFileReference getTarget() {
        return this.target;
    }

    public final KmpBinaryDownloadRequest copy(String url, Map<String, String> headers, KmpBinaryAuth auth, KmpFileReference target) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(auth, "auth");
        Intrinsics.checkNotNullParameter(target, "target");
        return new KmpBinaryDownloadRequest(url, headers, auth, target);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof KmpBinaryDownloadRequest)) {
            return false;
        }
        KmpBinaryDownloadRequest kmpBinaryDownloadRequest = (KmpBinaryDownloadRequest) other;
        return Intrinsics.areEqual(this.url, kmpBinaryDownloadRequest.url) && Intrinsics.areEqual(this.headers, kmpBinaryDownloadRequest.headers) && this.auth == kmpBinaryDownloadRequest.auth && Intrinsics.areEqual(this.target, kmpBinaryDownloadRequest.target);
    }

    public int hashCode() {
        return (((((this.url.hashCode() * 31) + this.headers.hashCode()) * 31) + this.auth.hashCode()) * 31) + this.target.hashCode();
    }

    public String toString() {
        return "KmpBinaryDownloadRequest(url=" + this.url + ", headers=" + this.headers + ", auth=" + this.auth + ", target=" + this.target + ')';
    }

    public KmpBinaryDownloadRequest(String url, Map<String, String> headers, KmpBinaryAuth auth, KmpFileReference target) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(auth, "auth");
        Intrinsics.checkNotNullParameter(target, "target");
        this.url = url;
        this.headers = headers;
        this.auth = auth;
        this.target = target;
    }

    public final String getUrl() {
        return this.url;
    }

    public /* synthetic */ KmpBinaryDownloadRequest(String str, Map map, KmpBinaryAuth kmpBinaryAuth, KmpFileReference kmpFileReference, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? MapsKt.emptyMap() : map, (i & 4) != 0 ? KmpBinaryAuth.None : kmpBinaryAuth, kmpFileReference);
    }

    public final Map<String, String> getHeaders() {
        return this.headers;
    }

    public final KmpBinaryAuth getAuth() {
        return this.auth;
    }

    public final KmpFileReference getTarget() {
        return this.target;
    }
}
