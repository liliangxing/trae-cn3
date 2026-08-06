package com.bytedance.trae.kmp.artifacts.artifact;

import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.trae.kmp.network.KmpRequestAuth;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ArtifactModels.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÇ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u0012\u001a\u00020\u0013H×\u0001J\t\u0010\u0014\u001a\u00020\u0003H×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDownloadRequest;", "", "url", "", "auth", "Lcom/bytedance/trae/kmp/network/KmpRequestAuth;", "<init>", "(Ljava/lang/String;Lcom/bytedance/trae/kmp/network/KmpRequestAuth;)V", "getUrl", "()Ljava/lang/String;", "getAuth", "()Lcom/bytedance/trae/kmp/network/KmpRequestAuth;", "component1", "component2", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "artifacts_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class ArtifactDownloadRequest {
    public static final int $stable = 0;
    private final KmpRequestAuth auth;
    private final String url;

    public static /* synthetic */ ArtifactDownloadRequest copy$default(ArtifactDownloadRequest artifactDownloadRequest, String str, KmpRequestAuth kmpRequestAuth, int i, Object obj) {
        if ((i & 1) != 0) {
            str = artifactDownloadRequest.url;
        }
        if ((i & 2) != 0) {
            kmpRequestAuth = artifactDownloadRequest.auth;
        }
        return artifactDownloadRequest.copy(str, kmpRequestAuth);
    }

    /* renamed from: component1, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* renamed from: component2, reason: from getter */
    public final KmpRequestAuth getAuth() {
        return this.auth;
    }

    public final ArtifactDownloadRequest copy(String url, KmpRequestAuth auth) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(auth, "auth");
        return new ArtifactDownloadRequest(url, auth);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ArtifactDownloadRequest)) {
            return false;
        }
        ArtifactDownloadRequest artifactDownloadRequest = (ArtifactDownloadRequest) other;
        return Intrinsics.areEqual(this.url, artifactDownloadRequest.url) && this.auth == artifactDownloadRequest.auth;
    }

    public int hashCode() {
        return (this.url.hashCode() * 31) + this.auth.hashCode();
    }

    public String toString() {
        return "ArtifactDownloadRequest(url=" + this.url + ", auth=" + this.auth + ')';
    }

    public ArtifactDownloadRequest(String url, KmpRequestAuth auth) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(auth, "auth");
        this.url = url;
        this.auth = auth;
    }

    public final String getUrl() {
        return this.url;
    }

    public final KmpRequestAuth getAuth() {
        return this.auth;
    }
}
