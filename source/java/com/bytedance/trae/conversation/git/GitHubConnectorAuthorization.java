package com.bytedance.trae.conversation.git;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GitHubConnectorAuthorization.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/bytedance/trae/conversation/git/GitHubConnectorAuthorization;", "", "gitHubAccessToken", "", "<init>", "(Ljava/lang/String;)V", "getGitHubAccessToken", "()Ljava/lang/String;", "component1", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class GitHubConnectorAuthorization {
    private final String gitHubAccessToken;

    public static /* synthetic */ GitHubConnectorAuthorization copy$default(GitHubConnectorAuthorization gitHubConnectorAuthorization, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = gitHubConnectorAuthorization.gitHubAccessToken;
        }
        return gitHubConnectorAuthorization.copy(str);
    }

    /* renamed from: component1, reason: from getter */
    public final String getGitHubAccessToken() {
        return this.gitHubAccessToken;
    }

    public final GitHubConnectorAuthorization copy(String gitHubAccessToken) {
        Intrinsics.checkNotNullParameter(gitHubAccessToken, "gitHubAccessToken");
        return new GitHubConnectorAuthorization(gitHubAccessToken);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof GitHubConnectorAuthorization) && Intrinsics.areEqual(this.gitHubAccessToken, ((GitHubConnectorAuthorization) other).gitHubAccessToken);
    }

    public int hashCode() {
        return this.gitHubAccessToken.hashCode();
    }

    public String toString() {
        return "GitHubConnectorAuthorization(gitHubAccessToken=" + this.gitHubAccessToken + ')';
    }

    public GitHubConnectorAuthorization(String gitHubAccessToken) {
        Intrinsics.checkNotNullParameter(gitHubAccessToken, "gitHubAccessToken");
        this.gitHubAccessToken = gitHubAccessToken;
    }

    public final String getGitHubAccessToken() {
        return this.gitHubAccessToken;
    }
}
