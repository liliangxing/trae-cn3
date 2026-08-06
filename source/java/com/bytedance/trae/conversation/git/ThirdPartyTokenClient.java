package com.bytedance.trae.conversation.git;

import com.bytedance.retrofit2.SsResponse;
import com.bytedance.sdk.account.platform.api.IWeixinService;
import com.bytedance.sdk.account.save.database.DBData;
import com.bytedance.trae.ServiceType;
import com.bytedance.trae.conversation.git.GitHubConnectorError;
import com.bytedance.trae.conversation.network.ThirdPartyTokenRepository;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ThirdPartyTokenClient.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010\tJ&\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010\rJ\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010\u000fJ\u0016\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010\u000fJ\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u001a\u0010\u0014\u001a\u00020\u00152\u0010\u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0017H\u0002J\u0010\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0007H\u0002¨\u0006\u001a"}, d2 = {"Lcom/bytedance/trae/conversation/git/ThirdPartyTokenClient;", "", "<init>", "()V", "exchangeCodeAndFetchGitHubToken", "Lcom/bytedance/trae/conversation/git/GitHubConnectorAuthorization;", "code", "", "redirectUri", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setThirdPartyToken", "", DBData.FIELD_TYPE, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getThirdPartyToken", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "disconnectThirdPartyToken", "findTokenInArray", "array", "Lorg/json/JSONArray;", "parseTraeEnvelopeOrThrow", "Lorg/json/JSONObject;", "response", "Lcom/bytedance/retrofit2/SsResponse;", "ensureTrailingSlash", IWeixinService.ResponseConstants.URL, "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ThirdPartyTokenClient {
    /* JADX WARN: Removed duplicated region for block: B:13:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0059 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object exchangeCodeAndFetchGitHubToken(String str, String str2, Continuation<? super GitHubConnectorAuthorization> continuation) {
        ThirdPartyTokenClient$exchangeCodeAndFetchGitHubToken$1 thirdPartyTokenClient$exchangeCodeAndFetchGitHubToken$1;
        Object obj;
        Object coroutine_suspended;
        int i;
        boolean z;
        ThirdPartyTokenClient thirdPartyTokenClient;
        String str3;
        if (continuation instanceof ThirdPartyTokenClient$exchangeCodeAndFetchGitHubToken$1) {
            thirdPartyTokenClient$exchangeCodeAndFetchGitHubToken$1 = (ThirdPartyTokenClient$exchangeCodeAndFetchGitHubToken$1) continuation;
            if ((thirdPartyTokenClient$exchangeCodeAndFetchGitHubToken$1.label & Integer.MIN_VALUE) != 0) {
                thirdPartyTokenClient$exchangeCodeAndFetchGitHubToken$1.label -= Integer.MIN_VALUE;
                obj = thirdPartyTokenClient$exchangeCodeAndFetchGitHubToken$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = thirdPartyTokenClient$exchangeCodeAndFetchGitHubToken$1.label;
                z = true;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    thirdPartyTokenClient$exchangeCodeAndFetchGitHubToken$1.L$0 = this;
                    thirdPartyTokenClient$exchangeCodeAndFetchGitHubToken$1.label = 1;
                    if (setThirdPartyToken(ThirdPartyTokenRepository.TYPE_GITHUB, str, str2, thirdPartyTokenClient$exchangeCodeAndFetchGitHubToken$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    thirdPartyTokenClient = this;
                } else {
                    if (i != 1) {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        String str4 = (String) obj;
                        str3 = str4;
                        if (str3 != null && !StringsKt.isBlank(str3)) {
                            z = false;
                        }
                        if (z) {
                            throw GitHubConnectorError.DecodingFailed.INSTANCE;
                        }
                        return new GitHubConnectorAuthorization(str4);
                    }
                    thirdPartyTokenClient = (ThirdPartyTokenClient) thirdPartyTokenClient$exchangeCodeAndFetchGitHubToken$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                thirdPartyTokenClient$exchangeCodeAndFetchGitHubToken$1.L$0 = null;
                thirdPartyTokenClient$exchangeCodeAndFetchGitHubToken$1.label = 2;
                obj = thirdPartyTokenClient.getThirdPartyToken(ThirdPartyTokenRepository.TYPE_GITHUB, thirdPartyTokenClient$exchangeCodeAndFetchGitHubToken$1);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                String str42 = (String) obj;
                str3 = str42;
                if (str3 != null) {
                    z = false;
                }
                if (z) {
                }
            }
        }
        thirdPartyTokenClient$exchangeCodeAndFetchGitHubToken$1 = new ThirdPartyTokenClient$exchangeCodeAndFetchGitHubToken$1(this, continuation);
        obj = thirdPartyTokenClient$exchangeCodeAndFetchGitHubToken$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = thirdPartyTokenClient$exchangeCodeAndFetchGitHubToken$1.label;
        z = true;
        if (i != 0) {
        }
        thirdPartyTokenClient$exchangeCodeAndFetchGitHubToken$1.L$0 = null;
        thirdPartyTokenClient$exchangeCodeAndFetchGitHubToken$1.label = 2;
        obj = thirdPartyTokenClient.getThirdPartyToken(ThirdPartyTokenRepository.TYPE_GITHUB, thirdPartyTokenClient$exchangeCodeAndFetchGitHubToken$1);
        if (obj == coroutine_suspended) {
        }
        String str422 = (String) obj;
        str3 = str422;
        if (str3 != null) {
        }
        if (z) {
        }
    }

    public final Object setThirdPartyToken(String str, String str2, String str3, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new ThirdPartyTokenClient$setThirdPartyToken$2(this, str, str2, str3, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    public final Object getThirdPartyToken(String str, Continuation<? super String> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new ThirdPartyTokenClient$getThirdPartyToken$2(this, str, null), continuation);
    }

    public final Object disconnectThirdPartyToken(String str, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new ThirdPartyTokenClient$disconnectThirdPartyToken$2(this, str, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String findTokenInArray(String type, JSONArray array) {
        int length = array.length();
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = array.optJSONObject(i);
            if (optJSONObject != null && StringsKt.equals(optJSONObject.optString("Type"), type, true)) {
                String optString = optJSONObject.optString("AccessToken");
                Intrinsics.checkNotNull(optString);
                if (!StringsKt.isBlank(optString)) {
                    return optString;
                }
                return null;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JSONObject parseTraeEnvelopeOrThrow(SsResponse<String> response) {
        Object obj;
        if (response == null) {
            throw GitHubConnectorError.DecodingFailed.INSTANCE;
        }
        int code = response.code();
        String str = (String) response.body();
        if (!(200 <= code && code < 300)) {
            throw new GitHubConnectorError.BackendError(code, str);
        }
        try {
            Result.Companion companion = Result.Companion;
            ThirdPartyTokenClient thirdPartyTokenClient = this;
            if (str == null) {
                str = "{}";
            }
            obj = Result.constructor-impl(new JSONObject(str));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.exceptionOrNull-impl(obj) != null) {
            throw GitHubConnectorError.DecodingFailed.INSTANCE;
        }
        JSONObject jSONObject = (JSONObject) obj;
        JSONObject optJSONObject = jSONObject.optJSONObject("ResponseMetadata");
        JSONObject optJSONObject2 = optJSONObject != null ? optJSONObject.optJSONObject("Error") : null;
        if (optJSONObject2 == null) {
            return jSONObject;
        }
        throw new GitHubConnectorError.OAuthFailed(StringsKt.trim(CollectionsKt.joinToString$default(CollectionsKt.listOf(new String[]{optJSONObject2.optString("Code"), optJSONObject2.optString(ServiceType.f1279IM)}), " ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null)).toString());
    }

    private final String ensureTrailingSlash(String url) {
        return StringsKt.endsWith$default(url, '/', false, 2, (Object) null) ? url : url + '/';
    }
}
