package com.bytedance.trae.conversation.git;

import android.content.Context;
import com.bytedance.android.monitorV2.constant.ReportConst;
import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.trae.multilanguage.R;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GitHubConnectorError.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00060\u0001j\u0002`\u0002:\b\n\u000b\f\r\u000e\u000f\u0010\u0011B\u0011\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t\u0082\u0001\b\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019¨\u0006\u001a"}, d2 = {"Lcom/bytedance/trae/conversation/git/GitHubConnectorError;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "message", "", "<init>", "(Ljava/lang/String;)V", "localizedMessage", "context", "Landroid/content/Context;", "InvalidAuthorizeUrl", "OAuthCancelled", "OAuthFailed", "CallbackMissingUrl", "CallbackMissingCode", "InvalidUrl", "BackendError", "DecodingFailed", "Lcom/bytedance/trae/conversation/git/GitHubConnectorError$BackendError;", "Lcom/bytedance/trae/conversation/git/GitHubConnectorError$CallbackMissingCode;", "Lcom/bytedance/trae/conversation/git/GitHubConnectorError$CallbackMissingUrl;", "Lcom/bytedance/trae/conversation/git/GitHubConnectorError$DecodingFailed;", "Lcom/bytedance/trae/conversation/git/GitHubConnectorError$InvalidAuthorizeUrl;", "Lcom/bytedance/trae/conversation/git/GitHubConnectorError$InvalidUrl;", "Lcom/bytedance/trae/conversation/git/GitHubConnectorError$OAuthCancelled;", "Lcom/bytedance/trae/conversation/git/GitHubConnectorError$OAuthFailed;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class GitHubConnectorError extends Exception {
    public /* synthetic */ GitHubConnectorError(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    /* compiled from: GitHubConnectorError.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/conversation/git/GitHubConnectorError$InvalidAuthorizeUrl;", "Lcom/bytedance/trae/conversation/git/GitHubConnectorError;", "<init>", "()V", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class InvalidAuthorizeUrl extends GitHubConnectorError {
        public static final InvalidAuthorizeUrl INSTANCE = new InvalidAuthorizeUrl();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof InvalidAuthorizeUrl)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 895832472;
        }

        @Override // java.lang.Throwable
        public String toString() {
            return "InvalidAuthorizeUrl";
        }

        private InvalidAuthorizeUrl() {
            super("Unable to generate GitHub OAuth authorization URL.", null);
        }
    }

    private GitHubConnectorError(String str) {
        super(str);
    }

    /* compiled from: GitHubConnectorError.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/conversation/git/GitHubConnectorError$OAuthCancelled;", "Lcom/bytedance/trae/conversation/git/GitHubConnectorError;", "<init>", "()V", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class OAuthCancelled extends GitHubConnectorError {
        public static final OAuthCancelled INSTANCE = new OAuthCancelled();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OAuthCancelled)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -106244545;
        }

        @Override // java.lang.Throwable
        public String toString() {
            return "OAuthCancelled";
        }

        private OAuthCancelled() {
            super("Authorization cancelled by user.", null);
        }
    }

    /* compiled from: GitHubConnectorError.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/bytedance/trae/conversation/git/GitHubConnectorError$OAuthFailed;", "Lcom/bytedance/trae/conversation/git/GitHubConnectorError;", "description", "", "<init>", "(Ljava/lang/String;)V", "getDescription", "()Ljava/lang/String;", "component1", "copy", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class OAuthFailed extends GitHubConnectorError {
        private final String description;

        public static /* synthetic */ OAuthFailed copy$default(OAuthFailed oAuthFailed, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = oAuthFailed.description;
            }
            return oAuthFailed.copy(str);
        }

        /* renamed from: component1, reason: from getter */
        public final String getDescription() {
            return this.description;
        }

        public final OAuthFailed copy(String description) {
            Intrinsics.checkNotNullParameter(description, "description");
            return new OAuthFailed(description);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof OAuthFailed) && Intrinsics.areEqual(this.description, ((OAuthFailed) other).description);
        }

        public int hashCode() {
            return this.description.hashCode();
        }

        @Override // java.lang.Throwable
        public String toString() {
            return "OAuthFailed(description=" + this.description + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OAuthFailed(String description) {
            super("Authorization failed: " + description, null);
            Intrinsics.checkNotNullParameter(description, "description");
            this.description = description;
        }

        public final String getDescription() {
            return this.description;
        }
    }

    /* compiled from: GitHubConnectorError.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/conversation/git/GitHubConnectorError$CallbackMissingUrl;", "Lcom/bytedance/trae/conversation/git/GitHubConnectorError;", "<init>", "()V", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class CallbackMissingUrl extends GitHubConnectorError {
        public static final CallbackMissingUrl INSTANCE = new CallbackMissingUrl();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CallbackMissingUrl)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1647039565;
        }

        @Override // java.lang.Throwable
        public String toString() {
            return "CallbackMissingUrl";
        }

        private CallbackMissingUrl() {
            super("Authorization callback URL not received.", null);
        }
    }

    /* compiled from: GitHubConnectorError.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/conversation/git/GitHubConnectorError$CallbackMissingCode;", "Lcom/bytedance/trae/conversation/git/GitHubConnectorError;", "<init>", "()V", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class CallbackMissingCode extends GitHubConnectorError {
        public static final CallbackMissingCode INSTANCE = new CallbackMissingCode();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CallbackMissingCode)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 480841769;
        }

        @Override // java.lang.Throwable
        public String toString() {
            return "CallbackMissingCode";
        }

        private CallbackMissingCode() {
            super("Authorization callback is missing code.", null);
        }
    }

    /* compiled from: GitHubConnectorError.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/bytedance/trae/conversation/git/GitHubConnectorError$InvalidUrl;", "Lcom/bytedance/trae/conversation/git/GitHubConnectorError;", "url", "", "<init>", "(Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "component1", "copy", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class InvalidUrl extends GitHubConnectorError {
        private final String url;

        public static /* synthetic */ InvalidUrl copy$default(InvalidUrl invalidUrl, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = invalidUrl.url;
            }
            return invalidUrl.copy(str);
        }

        /* renamed from: component1, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        public final InvalidUrl copy(String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            return new InvalidUrl(url);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof InvalidUrl) && Intrinsics.areEqual(this.url, ((InvalidUrl) other).url);
        }

        public int hashCode() {
            return this.url.hashCode();
        }

        @Override // java.lang.Throwable
        public String toString() {
            return "InvalidUrl(url=" + this.url + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InvalidUrl(String url) {
            super("Invalid URL parameter: " + url, null);
            Intrinsics.checkNotNullParameter(url, "url");
            this.url = url;
        }

        public final String getUrl() {
            return this.url;
        }
    }

    /* compiled from: GitHubConnectorError.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/trae/conversation/git/GitHubConnectorError$BackendError;", "Lcom/bytedance/trae/conversation/git/GitHubConnectorError;", HiAnalyticsConstant.HaKey.BI_KEY_RESULT, "", ReportConst.ValidationReport.BODY, "", "<init>", "(ILjava/lang/String;)V", "getStatusCode", "()I", "getBody", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class BackendError extends GitHubConnectorError {
        private final String body;
        private final int statusCode;

        public static /* synthetic */ BackendError copy$default(BackendError backendError, int i, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = backendError.statusCode;
            }
            if ((i2 & 2) != 0) {
                str = backendError.body;
            }
            return backendError.copy(i, str);
        }

        /* renamed from: component1, reason: from getter */
        public final int getStatusCode() {
            return this.statusCode;
        }

        /* renamed from: component2, reason: from getter */
        public final String getBody() {
            return this.body;
        }

        public final BackendError copy(int statusCode, String body) {
            return new BackendError(statusCode, body);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof BackendError)) {
                return false;
            }
            BackendError backendError = (BackendError) other;
            return this.statusCode == backendError.statusCode && Intrinsics.areEqual(this.body, backendError.body);
        }

        public int hashCode() {
            int hashCode = Integer.hashCode(this.statusCode) * 31;
            String str = this.body;
            return hashCode + (str == null ? 0 : str.hashCode());
        }

        @Override // java.lang.Throwable
        public String toString() {
            return "BackendError(statusCode=" + this.statusCode + ", body=" + this.body + ')';
        }

        public BackendError(int i, String str) {
            super("Backend request failed (HTTP " + i + ").", null);
            this.statusCode = i;
            this.body = str;
        }

        public final String getBody() {
            return this.body;
        }

        public final int getStatusCode() {
            return this.statusCode;
        }
    }

    /* compiled from: GitHubConnectorError.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/conversation/git/GitHubConnectorError$DecodingFailed;", "Lcom/bytedance/trae/conversation/git/GitHubConnectorError;", "<init>", "()V", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class DecodingFailed extends GitHubConnectorError {
        public static final DecodingFailed INSTANCE = new DecodingFailed();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DecodingFailed)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 806031661;
        }

        @Override // java.lang.Throwable
        public String toString() {
            return "DecodingFailed";
        }

        private DecodingFailed() {
            super("Failed to parse server response.", null);
        }
    }

    public final String localizedMessage(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (this instanceof InvalidAuthorizeUrl) {
            String string = context.getString(R.string.trae_github_error_invalid_authorize_url);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            return string;
        }
        if (this instanceof OAuthCancelled) {
            String string2 = context.getString(R.string.trae_github_error_oauth_cancelled);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            return string2;
        }
        if (this instanceof OAuthFailed) {
            String string3 = context.getString(R.string.trae_github_error_oauth_failed, ((OAuthFailed) this).getDescription());
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            return string3;
        }
        if (this instanceof CallbackMissingUrl) {
            String string4 = context.getString(R.string.trae_github_error_callback_missing_url);
            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
            return string4;
        }
        if (this instanceof CallbackMissingCode) {
            String string5 = context.getString(R.string.trae_github_error_callback_missing_code);
            Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
            return string5;
        }
        if (this instanceof InvalidUrl) {
            String string6 = context.getString(R.string.trae_github_error_invalid_url, ((InvalidUrl) this).getUrl());
            Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
            return string6;
        }
        if (this instanceof BackendError) {
            String string7 = context.getString(R.string.trae_github_error_backend_error, Integer.valueOf(((BackendError) this).getStatusCode()));
            Intrinsics.checkNotNullExpressionValue(string7, "getString(...)");
            return string7;
        }
        if (!(this instanceof DecodingFailed)) {
            throw new NoWhenBranchMatchedException();
        }
        String string8 = context.getString(R.string.trae_github_error_decoding_failed);
        Intrinsics.checkNotNullExpressionValue(string8, "getString(...)");
        return string8;
    }
}
