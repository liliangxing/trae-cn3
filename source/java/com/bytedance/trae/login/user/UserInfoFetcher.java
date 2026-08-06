package com.bytedance.trae.login.user;

import com.bytedance.retrofit2.SsResponse;
import com.bytedance.trae.login.traeauth.TraeAuthConfig;
import com.bytedance.trae.login.traeauth.TraeResponse;
import com.bytedance.trae.login.traeauth.TraeResponseMetadata;
import com.bytedance.trae.network.TraeHttpConnection;
import com.bytedance.trae.utils.logger.FLogger;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* compiled from: UserInfoFetcher.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u000f\u0010B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010\u000bJ\u001c\u0010\f\u001a\u0004\u0018\u00010\t2\u0010\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u000eH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/bytedance/trae/login/user/UserInfoFetcher;", "", "<init>", "()V", "TAG", "", "exceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "doFetch", "Lcom/bytedance/trae/login/user/UserInfoFetcher$UserInfoResponse;", "cloudideSession", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "parseResponse", "ssResponse", "Lcom/bytedance/retrofit2/SsResponse;", "Callback", "UserInfoResponse", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class UserInfoFetcher {
    private static final String TAG = "UserInfoFetcher";
    public static final UserInfoFetcher INSTANCE = new UserInfoFetcher();
    private static final CoroutineExceptionHandler exceptionHandler = new UserInfoFetcher$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key);

    /* compiled from: UserInfoFetcher.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u001c\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH&¨\u0006\n"}, d2 = {"Lcom/bytedance/trae/login/user/UserInfoFetcher$Callback;", "", "onSuccess", "", "userInfo", "Lcom/bytedance/trae/login/user/TraeUserInfoResult;", "onFailure", "errorCode", "", "errorMessage", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public interface Callback {
        void onFailure(String errorCode, String errorMessage);

        void onSuccess(TraeUserInfoResult userInfo);
    }

    private UserInfoFetcher() {
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object doFetch(String str, Continuation<? super UserInfoResponse> continuation) {
        UserInfoFetcher$doFetch$1 userInfoFetcher$doFetch$1;
        int i;
        UserInfoFetcher userInfoFetcher;
        try {
            if (continuation instanceof UserInfoFetcher$doFetch$1) {
                userInfoFetcher$doFetch$1 = (UserInfoFetcher$doFetch$1) continuation;
                if ((userInfoFetcher$doFetch$1.label & Integer.MIN_VALUE) != 0) {
                    userInfoFetcher$doFetch$1.label -= Integer.MIN_VALUE;
                    Object obj = userInfoFetcher$doFetch$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = userInfoFetcher$doFetch$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        String baseUrl = TraeAuthConfig.INSTANCE.getBaseUrl();
                        FLogger.INSTANCE.mo426e(TAG, "doFetch: " + baseUrl);
                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                        linkedHashMap.put("X-Cloudide-Token", str);
                        FLogger.INSTANCE.mo426e(TAG, "doFetch: " + str);
                        UserInfoApi userInfoApi = (UserInfoApi) TraeHttpConnection.createService$default(TraeHttpConnection.INSTANCE, "trae_auth", UserInfoApi.class, null, baseUrl, linkedHashMap, true, 4, null);
                        userInfoFetcher$doFetch$1.L$0 = this;
                        userInfoFetcher$doFetch$1.label = 1;
                        obj = userInfoApi.getUserInfo(userInfoFetcher$doFetch$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        userInfoFetcher = this;
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        userInfoFetcher = (UserInfoFetcher) userInfoFetcher$doFetch$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    }
                    return userInfoFetcher.parseResponse((SsResponse) obj);
                }
            }
            if (i != 0) {
            }
            return userInfoFetcher.parseResponse((SsResponse) obj);
        } catch (Exception e) {
            FLogger.INSTANCE.mo426e(TAG, "doFetch exception: " + e.getMessage());
            return null;
        }
        userInfoFetcher$doFetch$1 = new UserInfoFetcher$doFetch$1(this, continuation);
        Object obj2 = userInfoFetcher$doFetch$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = userInfoFetcher$doFetch$1.label;
    }

    private final UserInfoResponse parseResponse(SsResponse<String> ssResponse) {
        String body;
        if (ssResponse == null || (body = ssResponse.body()) == null) {
            return null;
        }
        TraeResponse traeResponse = (TraeResponse) TraeHttpConnection.INSTANCE.getHttpGson().fromJson(body, TypeToken.getParameterized(TraeResponse.class, new Type[]{TraeUserInfoResult.class}).getType());
        Intrinsics.checkNotNull(traeResponse);
        return new UserInfoResponse(traeResponse, ssResponse);
    }

    /* compiled from: UserInfoFetcher.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0010\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0013\u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006HÆ\u0003J-\u0010\u0017\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0007HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001e"}, d2 = {"Lcom/bytedance/trae/login/user/UserInfoFetcher$UserInfoResponse;", "", "response", "Lcom/bytedance/trae/login/traeauth/TraeResponse;", "Lcom/bytedance/trae/login/user/TraeUserInfoResult;", "ssResponse", "Lcom/bytedance/retrofit2/SsResponse;", "", "<init>", "(Lcom/bytedance/trae/login/traeauth/TraeResponse;Lcom/bytedance/retrofit2/SsResponse;)V", "getResponse", "()Lcom/bytedance/trae/login/traeauth/TraeResponse;", "getSsResponse", "()Lcom/bytedance/retrofit2/SsResponse;", "responseMetadata", "Lcom/bytedance/trae/login/traeauth/TraeResponseMetadata;", "getResponseMetadata", "()Lcom/bytedance/trae/login/traeauth/TraeResponseMetadata;", "result", "getResult", "()Lcom/bytedance/trae/login/user/TraeUserInfoResult;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final /* data */ class UserInfoResponse {
        private final TraeResponse<TraeUserInfoResult> response;
        private final SsResponse<String> ssResponse;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ UserInfoResponse copy$default(UserInfoResponse userInfoResponse, TraeResponse traeResponse, SsResponse ssResponse, int i, Object obj) {
            if ((i & 1) != 0) {
                traeResponse = userInfoResponse.response;
            }
            if ((i & 2) != 0) {
                ssResponse = userInfoResponse.ssResponse;
            }
            return userInfoResponse.copy(traeResponse, ssResponse);
        }

        public final TraeResponse<TraeUserInfoResult> component1() {
            return this.response;
        }

        public final SsResponse<String> component2() {
            return this.ssResponse;
        }

        public final UserInfoResponse copy(TraeResponse<TraeUserInfoResult> response, SsResponse<String> ssResponse) {
            Intrinsics.checkNotNullParameter(response, "response");
            return new UserInfoResponse(response, ssResponse);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UserInfoResponse)) {
                return false;
            }
            UserInfoResponse userInfoResponse = (UserInfoResponse) other;
            return Intrinsics.areEqual(this.response, userInfoResponse.response) && Intrinsics.areEqual(this.ssResponse, userInfoResponse.ssResponse);
        }

        public int hashCode() {
            int hashCode = this.response.hashCode() * 31;
            SsResponse<String> ssResponse = this.ssResponse;
            return hashCode + (ssResponse == null ? 0 : ssResponse.hashCode());
        }

        public String toString() {
            return "UserInfoResponse(response=" + this.response + ", ssResponse=" + this.ssResponse + ')';
        }

        public UserInfoResponse(TraeResponse<TraeUserInfoResult> traeResponse, SsResponse<String> ssResponse) {
            Intrinsics.checkNotNullParameter(traeResponse, "response");
            this.response = traeResponse;
            this.ssResponse = ssResponse;
        }

        public final TraeResponse<TraeUserInfoResult> getResponse() {
            return this.response;
        }

        public final SsResponse<String> getSsResponse() {
            return this.ssResponse;
        }

        public final TraeResponseMetadata getResponseMetadata() {
            return this.response.getResponseMetadata();
        }

        public final TraeUserInfoResult getResult() {
            return this.response.getResult();
        }
    }
}
