package com.bytedance.trae.conversation.git;

import android.content.Context;
import com.bytedance.trae.common.apphost.AppHost;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GitHubConnectConfig.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\b\u0018\u0000 \u00192\u00020\u0001:\u0003\u0017\u0018\u0019B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001a"}, d2 = {"Lcom/bytedance/trae/conversation/git/GitHubConnectConfig;", "Ljava/io/Serializable;", "oauth", "Lcom/bytedance/trae/conversation/git/GitHubConnectConfig$OAuth;", "gitHubApp", "Lcom/bytedance/trae/conversation/git/GitHubConnectConfig$GitHubApp;", "<init>", "(Lcom/bytedance/trae/conversation/git/GitHubConnectConfig$OAuth;Lcom/bytedance/trae/conversation/git/GitHubConnectConfig$GitHubApp;)V", "getOauth", "()Lcom/bytedance/trae/conversation/git/GitHubConnectConfig$OAuth;", "getGitHubApp", "()Lcom/bytedance/trae/conversation/git/GitHubConnectConfig$GitHubApp;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "OAuth", "GitHubApp", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final /* data */ class GitHubConnectConfig implements Serializable {
    private static final String APP_SLUG_CN = "trae-ai-cn";
    private static final String APP_SLUG_OVERSEA = "trae-ai";
    private static final String CLIENT_ID_CN = "Iv23liZK8tzQx0m4bCRd";
    private static final String CLIENT_ID_OVERSEA = "Iv23li49AhCcfdXa9zKZ";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final GitHubApp gitHubApp;
    private final OAuth oauth;

    public static /* synthetic */ GitHubConnectConfig copy$default(GitHubConnectConfig gitHubConnectConfig, OAuth oAuth, GitHubApp gitHubApp, int i, Object obj) {
        if ((i & 1) != 0) {
            oAuth = gitHubConnectConfig.oauth;
        }
        if ((i & 2) != 0) {
            gitHubApp = gitHubConnectConfig.gitHubApp;
        }
        return gitHubConnectConfig.copy(oAuth, gitHubApp);
    }

    /* renamed from: component1, reason: from getter */
    public final OAuth getOauth() {
        return this.oauth;
    }

    /* renamed from: component2, reason: from getter */
    public final GitHubApp getGitHubApp() {
        return this.gitHubApp;
    }

    public final GitHubConnectConfig copy(OAuth oauth, GitHubApp gitHubApp) {
        Intrinsics.checkNotNullParameter(oauth, "oauth");
        Intrinsics.checkNotNullParameter(gitHubApp, "gitHubApp");
        return new GitHubConnectConfig(oauth, gitHubApp);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GitHubConnectConfig)) {
            return false;
        }
        GitHubConnectConfig gitHubConnectConfig = (GitHubConnectConfig) other;
        return Intrinsics.areEqual(this.oauth, gitHubConnectConfig.oauth) && Intrinsics.areEqual(this.gitHubApp, gitHubConnectConfig.gitHubApp);
    }

    public int hashCode() {
        return (this.oauth.hashCode() * 31) + this.gitHubApp.hashCode();
    }

    public String toString() {
        return "GitHubConnectConfig(oauth=" + this.oauth + ", gitHubApp=" + this.gitHubApp + ')';
    }

    public GitHubConnectConfig(OAuth oAuth, GitHubApp gitHubApp) {
        Intrinsics.checkNotNullParameter(oAuth, "oauth");
        Intrinsics.checkNotNullParameter(gitHubApp, "gitHubApp");
        this.oauth = oAuth;
        this.gitHubApp = gitHubApp;
    }

    public final OAuth getOauth() {
        return this.oauth;
    }

    public final GitHubApp getGitHubApp() {
        return this.gitHubApp;
    }

    /* compiled from: GitHubConnectConfig.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/bytedance/trae/conversation/git/GitHubConnectConfig$OAuth;", "Ljava/io/Serializable;", "clientId", "", "redirectUri", "scope", "authorizeEndpoint", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getClientId", "()Ljava/lang/String;", "getRedirectUri", "getScope", "getAuthorizeEndpoint", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class OAuth implements Serializable {
        private final String authorizeEndpoint;
        private final String clientId;
        private final String redirectUri;
        private final String scope;

        public static /* synthetic */ OAuth copy$default(OAuth oAuth, String str, String str2, String str3, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                str = oAuth.clientId;
            }
            if ((i & 2) != 0) {
                str2 = oAuth.redirectUri;
            }
            if ((i & 4) != 0) {
                str3 = oAuth.scope;
            }
            if ((i & 8) != 0) {
                str4 = oAuth.authorizeEndpoint;
            }
            return oAuth.copy(str, str2, str3, str4);
        }

        /* renamed from: component1, reason: from getter */
        public final String getClientId() {
            return this.clientId;
        }

        /* renamed from: component2, reason: from getter */
        public final String getRedirectUri() {
            return this.redirectUri;
        }

        /* renamed from: component3, reason: from getter */
        public final String getScope() {
            return this.scope;
        }

        /* renamed from: component4, reason: from getter */
        public final String getAuthorizeEndpoint() {
            return this.authorizeEndpoint;
        }

        public final OAuth copy(String clientId, String redirectUri, String scope, String authorizeEndpoint) {
            Intrinsics.checkNotNullParameter(clientId, "clientId");
            Intrinsics.checkNotNullParameter(redirectUri, "redirectUri");
            Intrinsics.checkNotNullParameter(scope, "scope");
            Intrinsics.checkNotNullParameter(authorizeEndpoint, "authorizeEndpoint");
            return new OAuth(clientId, redirectUri, scope, authorizeEndpoint);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OAuth)) {
                return false;
            }
            OAuth oAuth = (OAuth) other;
            return Intrinsics.areEqual(this.clientId, oAuth.clientId) && Intrinsics.areEqual(this.redirectUri, oAuth.redirectUri) && Intrinsics.areEqual(this.scope, oAuth.scope) && Intrinsics.areEqual(this.authorizeEndpoint, oAuth.authorizeEndpoint);
        }

        public int hashCode() {
            return (((((this.clientId.hashCode() * 31) + this.redirectUri.hashCode()) * 31) + this.scope.hashCode()) * 31) + this.authorizeEndpoint.hashCode();
        }

        public String toString() {
            return "OAuth(clientId=" + this.clientId + ", redirectUri=" + this.redirectUri + ", scope=" + this.scope + ", authorizeEndpoint=" + this.authorizeEndpoint + ')';
        }

        public OAuth(String str, String str2, String str3, String str4) {
            Intrinsics.checkNotNullParameter(str, "clientId");
            Intrinsics.checkNotNullParameter(str2, "redirectUri");
            Intrinsics.checkNotNullParameter(str3, "scope");
            Intrinsics.checkNotNullParameter(str4, "authorizeEndpoint");
            this.clientId = str;
            this.redirectUri = str2;
            this.scope = str3;
            this.authorizeEndpoint = str4;
        }

        public /* synthetic */ OAuth(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, (i & 4) != 0 ? "repo read:user" : str3, (i & 8) != 0 ? "https://github.com/login/oauth/authorize" : str4);
        }

        public final String getClientId() {
            return this.clientId;
        }

        public final String getRedirectUri() {
            return this.redirectUri;
        }

        public final String getScope() {
            return this.scope;
        }

        public final String getAuthorizeEndpoint() {
            return this.authorizeEndpoint;
        }
    }

    /* compiled from: GitHubConnectConfig.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/bytedance/trae/conversation/git/GitHubConnectConfig$GitHubApp;", "Ljava/io/Serializable;", "slug", "", "<init>", "(Ljava/lang/String;)V", "getSlug", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class GitHubApp implements Serializable {
        private final String slug;

        public static /* synthetic */ GitHubApp copy$default(GitHubApp gitHubApp, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = gitHubApp.slug;
            }
            return gitHubApp.copy(str);
        }

        /* renamed from: component1, reason: from getter */
        public final String getSlug() {
            return this.slug;
        }

        public final GitHubApp copy(String slug) {
            Intrinsics.checkNotNullParameter(slug, "slug");
            return new GitHubApp(slug);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof GitHubApp) && Intrinsics.areEqual(this.slug, ((GitHubApp) other).slug);
        }

        public int hashCode() {
            return this.slug.hashCode();
        }

        public String toString() {
            return "GitHubApp(slug=" + this.slug + ')';
        }

        public GitHubApp(String str) {
            Intrinsics.checkNotNullParameter(str, "slug");
            this.slug = str;
        }

        public final String getSlug() {
            return this.slug;
        }
    }

    /* compiled from: GitHubConnectConfig.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/bytedance/trae/conversation/git/GitHubConnectConfig$Companion;", "", "<init>", "()V", "CLIENT_ID_OVERSEA", "", "CLIENT_ID_CN", "APP_SLUG_OVERSEA", "APP_SLUG_CN", "shared", "Lcom/bytedance/trae/conversation/git/GitHubConnectConfig;", "context", "Landroid/content/Context;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final GitHubConnectConfig shared(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            boolean isOversea = AppHost.INSTANCE.isOversea();
            return new GitHubConnectConfig(new OAuth(isOversea ? GitHubConnectConfig.CLIENT_ID_OVERSEA : GitHubConnectConfig.CLIENT_ID_CN, context.getPackageName() + "://github-connector-callback", null, null, 12, null), new GitHubApp(isOversea ? GitHubConnectConfig.APP_SLUG_OVERSEA : GitHubConnectConfig.APP_SLUG_CN));
        }
    }
}
