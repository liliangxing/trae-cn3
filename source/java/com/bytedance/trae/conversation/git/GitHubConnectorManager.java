package com.bytedance.trae.conversation.git;

import android.content.Context;
import android.net.Uri;
import com.bytedance.sdk.account.platform.api.ITiktokService;
import com.bytedance.trae.conversation.git.GitHubConnectorError;
import com.bytedance.trae.conversation.network.ThirdPartyTokenRepository;
import com.bytedance.trae.login.api.AccountInfo;
import com.bytedance.trae.login.api.AccountType;
import com.bytedance.trae.login.api.ILoginService;
import com.bytedance.trae.network.HostResolver;
import com.bytedance.trae.network.HostType;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: GitHubConnectorManager.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\f\u001a\u0004\u0018\u00010\rH\u0086@¢\u0006\u0002\u0010\u000eJ\u000e\u0010\u000f\u001a\u00020\u0010H\u0086@¢\u0006\u0002\u0010\u000eJ\u0012\u0010\u0011\u001a\u00020\r2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\rH\u0002J\"\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\r2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\rH\u0086@¢\u0006\u0002\u0010\u0017J$\u0010\u0018\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\rH\u0086@¢\u0006\u0002\u0010\u0017J\b\u0010\u0019\u001a\u00020\u001aH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/bytedance/trae/conversation/git/GitHubConnectorManager;", "", "context", "Landroid/content/Context;", "config", "Lcom/bytedance/trae/conversation/git/GitHubConnectConfig;", "<init>", "(Landroid/content/Context;Lcom/bytedance/trae/conversation/git/GitHubConnectConfig;)V", "getConfig", "()Lcom/bytedance/trae/conversation/git/GitHubConnectConfig;", "tokenClient", "Lcom/bytedance/trae/conversation/git/ThirdPartyTokenClient;", "checkToken", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "disconnect", "", "buildOAuthUrl", "redirectUri", "buildEnterpriseOAuthUrl", "exchangeCodeAndFetchGitHubToken", "Lcom/bytedance/trae/conversation/git/GitHubConnectorAuthorization;", "code", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "completeOAuthCallback", "isEnterpriseLogin", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class GitHubConnectorManager {
    private final GitHubConnectConfig config;
    private final Context context;
    private final ThirdPartyTokenClient tokenClient;

    public GitHubConnectorManager(Context context, GitHubConnectConfig gitHubConnectConfig) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(gitHubConnectConfig, "config");
        this.context = context;
        this.config = gitHubConnectConfig;
        this.tokenClient = new ThirdPartyTokenClient();
    }

    public /* synthetic */ GitHubConnectorManager(Context context, GitHubConnectConfig gitHubConnectConfig, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? GitHubConnectConfig.INSTANCE.shared(context) : gitHubConnectConfig);
    }

    public final GitHubConnectConfig getConfig() {
        return this.config;
    }

    public final Object checkToken(Continuation<? super String> continuation) {
        return this.tokenClient.getThirdPartyToken(ThirdPartyTokenRepository.TYPE_GITHUB, continuation);
    }

    public final Object disconnect(Continuation<? super Unit> continuation) {
        Object disconnectThirdPartyToken = this.tokenClient.disconnectThirdPartyToken(ThirdPartyTokenRepository.TYPE_GITHUB, continuation);
        return disconnectThirdPartyToken == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? disconnectThirdPartyToken : Unit.INSTANCE;
    }

    public static /* synthetic */ String buildOAuthUrl$default(GitHubConnectorManager gitHubConnectorManager, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        return gitHubConnectorManager.buildOAuthUrl(str);
    }

    public final String buildOAuthUrl(String redirectUri) {
        if (redirectUri == null) {
            redirectUri = this.config.getOauth().getRedirectUri();
        }
        if (isEnterpriseLogin()) {
            return buildEnterpriseOAuthUrl(redirectUri);
        }
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "toString(...)");
        String uri = Uri.parse(this.config.getOauth().getAuthorizeEndpoint()).buildUpon().appendQueryParameter("client_id", this.config.getOauth().getClientId()).appendQueryParameter("redirect_uri", redirectUri).appendQueryParameter("scope", this.config.getOauth().getScope()).appendQueryParameter("state", uuid).build().toString();
        Intrinsics.checkNotNullExpressionValue(uri, "toString(...)");
        return uri;
    }

    private final String buildEnterpriseOAuthUrl(String redirectUri) {
        AccountInfo accountInfo;
        ILoginService iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        String userId = (iLoginService == null || (accountInfo = iLoginService.getAccountInfo()) == null) ? null : accountInfo.getUserId();
        if (userId == null) {
            userId = "";
        }
        if (StringsKt.isBlank(userId)) {
            throw GitHubConnectorError.InvalidAuthorizeUrl.INSTANCE;
        }
        String trimEnd = StringsKt.trimEnd(HostResolver.INSTANCE.getBaseUrl(HostType.LOGIN), new char[]{'/'});
        if (StringsKt.isBlank(trimEnd)) {
            throw GitHubConnectorError.InvalidAuthorizeUrl.INSTANCE;
        }
        String uri = Uri.parse(trimEnd + "/oauth/third-party/github").buildUpon().appendQueryParameter("user_id", userId).appendQueryParameter(ITiktokService.ResponseConstants.REDIRECT_URL, redirectUri).appendQueryParameter("scope", this.config.getOauth().getScope()).build().toString();
        Intrinsics.checkNotNullExpressionValue(uri, "toString(...)");
        return uri;
    }

    public static /* synthetic */ Object exchangeCodeAndFetchGitHubToken$default(GitHubConnectorManager gitHubConnectorManager, String str, String str2, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        return gitHubConnectorManager.exchangeCodeAndFetchGitHubToken(str, str2, continuation);
    }

    public final Object exchangeCodeAndFetchGitHubToken(String str, String str2, Continuation<? super GitHubConnectorAuthorization> continuation) {
        ThirdPartyTokenClient thirdPartyTokenClient = this.tokenClient;
        if (str2 == null) {
            str2 = this.config.getOauth().getRedirectUri();
        }
        return thirdPartyTokenClient.exchangeCodeAndFetchGitHubToken(str, str2, continuation);
    }

    public static /* synthetic */ Object completeOAuthCallback$default(GitHubConnectorManager gitHubConnectorManager, String str, String str2, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        return gitHubConnectorManager.completeOAuthCallback(str, str2, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00af A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00bb A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object completeOAuthCallback(String str, String str2, Continuation<? super GitHubConnectorAuthorization> continuation) {
        GitHubConnectorManager$completeOAuthCallback$1 gitHubConnectorManager$completeOAuthCallback$1;
        Object obj;
        Object coroutine_suspended;
        int i;
        GitHubConnectorManager gitHubConnectorManager;
        Object obj2;
        GitHubConnectorAuthorization gitHubConnectorAuthorization;
        String str3;
        if (continuation instanceof GitHubConnectorManager$completeOAuthCallback$1) {
            gitHubConnectorManager$completeOAuthCallback$1 = (GitHubConnectorManager$completeOAuthCallback$1) continuation;
            if ((gitHubConnectorManager$completeOAuthCallback$1.label & Integer.MIN_VALUE) != 0) {
                gitHubConnectorManager$completeOAuthCallback$1.label -= Integer.MIN_VALUE;
                obj = gitHubConnectorManager$completeOAuthCallback$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = gitHubConnectorManager$completeOAuthCallback$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (!isEnterpriseLogin()) {
                        if (str != null) {
                            if (!(!StringsKt.isBlank(str))) {
                                str = null;
                            }
                            if (str != null) {
                                gitHubConnectorManager$completeOAuthCallback$1.label = 1;
                                obj = exchangeCodeAndFetchGitHubToken(str, str2, gitHubConnectorManager$completeOAuthCallback$1);
                                return obj == coroutine_suspended ? coroutine_suspended : obj;
                            }
                        }
                        throw GitHubConnectorError.CallbackMissingCode.INSTANCE;
                    }
                    String str4 = str;
                    if (str4 == null || StringsKt.isBlank(str4)) {
                        gitHubConnectorManager = this;
                    } else {
                        try {
                            Result.Companion companion = Result.Companion;
                            GitHubConnectorManager gitHubConnectorManager2 = this;
                            gitHubConnectorManager$completeOAuthCallback$1.L$0 = this;
                            gitHubConnectorManager$completeOAuthCallback$1.label = 2;
                            obj = exchangeCodeAndFetchGitHubToken(str, str2, gitHubConnectorManager$completeOAuthCallback$1);
                        } catch (Throwable th) {
                            th = th;
                            gitHubConnectorManager = this;
                            Result.Companion companion2 = Result.Companion;
                            obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                            if (Result.isFailure-impl(obj2)) {
                            }
                            gitHubConnectorAuthorization = (GitHubConnectorAuthorization) obj2;
                            if (gitHubConnectorAuthorization != null) {
                            }
                            gitHubConnectorManager$completeOAuthCallback$1.L$0 = null;
                            gitHubConnectorManager$completeOAuthCallback$1.label = 3;
                            obj = gitHubConnectorManager.checkToken(gitHubConnectorManager$completeOAuthCallback$1);
                            if (obj == coroutine_suspended) {
                            }
                            String str5 = (String) obj;
                            str3 = str5;
                            if (str3 != null || StringsKt.isBlank(str3)) {
                            }
                        }
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        gitHubConnectorManager = this;
                        obj2 = Result.constructor-impl((GitHubConnectorAuthorization) obj);
                        if (Result.isFailure-impl(obj2)) {
                        }
                        gitHubConnectorAuthorization = (GitHubConnectorAuthorization) obj2;
                        if (gitHubConnectorAuthorization != null) {
                        }
                    }
                } else {
                    if (i == 1) {
                        ResultKt.throwOnFailure(obj);
                    }
                    if (i != 2) {
                        if (i != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        String str52 = (String) obj;
                        str3 = str52;
                        if (str3 != null || StringsKt.isBlank(str3)) {
                            throw GitHubConnectorError.DecodingFailed.INSTANCE;
                        }
                        return new GitHubConnectorAuthorization(str52);
                    }
                    gitHubConnectorManager = (GitHubConnectorManager) gitHubConnectorManager$completeOAuthCallback$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        obj2 = Result.constructor-impl((GitHubConnectorAuthorization) obj);
                    } catch (Throwable th2) {
                        th = th2;
                        Result.Companion companion22 = Result.Companion;
                        obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                        if (Result.isFailure-impl(obj2)) {
                        }
                        gitHubConnectorAuthorization = (GitHubConnectorAuthorization) obj2;
                        if (gitHubConnectorAuthorization != null) {
                        }
                        gitHubConnectorManager$completeOAuthCallback$1.L$0 = null;
                        gitHubConnectorManager$completeOAuthCallback$1.label = 3;
                        obj = gitHubConnectorManager.checkToken(gitHubConnectorManager$completeOAuthCallback$1);
                        if (obj == coroutine_suspended) {
                        }
                        String str522 = (String) obj;
                        str3 = str522;
                        if (str3 != null || StringsKt.isBlank(str3)) {
                        }
                    }
                    if (Result.isFailure-impl(obj2)) {
                        obj2 = null;
                    }
                    gitHubConnectorAuthorization = (GitHubConnectorAuthorization) obj2;
                    if (gitHubConnectorAuthorization != null) {
                        return gitHubConnectorAuthorization;
                    }
                }
                gitHubConnectorManager$completeOAuthCallback$1.L$0 = null;
                gitHubConnectorManager$completeOAuthCallback$1.label = 3;
                obj = gitHubConnectorManager.checkToken(gitHubConnectorManager$completeOAuthCallback$1);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                String str5222 = (String) obj;
                str3 = str5222;
                if (str3 != null || StringsKt.isBlank(str3)) {
                }
            }
        }
        gitHubConnectorManager$completeOAuthCallback$1 = new GitHubConnectorManager$completeOAuthCallback$1(this, continuation);
        obj = gitHubConnectorManager$completeOAuthCallback$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = gitHubConnectorManager$completeOAuthCallback$1.label;
        if (i != 0) {
        }
        gitHubConnectorManager$completeOAuthCallback$1.L$0 = null;
        gitHubConnectorManager$completeOAuthCallback$1.label = 3;
        obj = gitHubConnectorManager.checkToken(gitHubConnectorManager$completeOAuthCallback$1);
        if (obj == coroutine_suspended) {
        }
        String str52222 = (String) obj;
        str3 = str52222;
        if (str3 != null || StringsKt.isBlank(str3)) {
        }
    }

    private final boolean isEnterpriseLogin() {
        AccountInfo accountInfo;
        ILoginService iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        return ((iLoginService == null || (accountInfo = iLoginService.getAccountInfo()) == null) ? null : accountInfo.getAccountType()) == AccountType.TOB;
    }
}
