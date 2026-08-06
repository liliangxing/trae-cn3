package com.bytedance.trae.im.service;

import com.bytedance.retrofit2.Converter;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Path;
import com.bytedance.sdk.account.api.AccountErrorCode;
import com.bytedance.sdk.account.api.OauthTokenTriggerScene;
import com.bytedance.trae.network.HostResolver;
import com.bytedance.trae.network.HostType;
import com.bytedance.trae.network.TraeHttpConnection;
import com.bytedance.trae.network.response.BizResponse;
import com.bytedance.trae.network.response.HttpDataResult;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: IChatSessionAuthApi.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \n2\u00020\u0001:\u0001\nJ(\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\bH§@¢\u0006\u0002\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/trae/im/service/IChatSessionAuthApi;", "", "issueSessionToken", "Lcom/bytedance/trae/network/response/BizResponse;", "Lcom/bytedance/trae/im/service/SessionTokenData;", "chatSessionId", "", OauthTokenTriggerScene.REQUEST, "Lcom/bytedance/trae/im/service/IssueSessionTokenRequest;", "(Ljava/lang/String;Lcom/bytedance/trae/im/service/IssueSessionTokenRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public interface IChatSessionAuthApi {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @POST("api/remote/v1/auth/session/{chat_session_id}/token")
    Object issueSessionToken(@Path("chat_session_id") String str, @Body IssueSessionTokenRequest issueSessionTokenRequest, Continuation<? super BizResponse<SessionTokenData>> continuation);

    /* compiled from: IChatSessionAuthApi.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ Object issueSessionToken$default(IChatSessionAuthApi iChatSessionAuthApi, String str, IssueSessionTokenRequest issueSessionTokenRequest, Continuation continuation, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: issueSessionToken");
            }
            if ((i & 2) != 0) {
                issueSessionTokenRequest = new IssueSessionTokenRequest(str, null, 2, null);
            }
            return iChatSessionAuthApi.issueSessionToken(str, issueSessionTokenRequest, continuation);
        }
    }

    /* compiled from: IChatSessionAuthApi.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JK\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\u0004\b\u0000\u0010\n2/\u0010\u000b\u001a+\b\u0001\u0012\u0004\u0012\u00020\r\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\n\u0018\u00010\u000f0\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00010\f¢\u0006\u0002\b\u0010H\u0086@¢\u0006\u0002\u0010\u0011R\u0014\u0010\u0004\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/bytedance/trae/im/service/IChatSessionAuthApi$Companion;", "", "<init>", "()V", "BASE_URL", "", "getBASE_URL", "()Ljava/lang/String;", "safeCall", "Lcom/bytedance/trae/network/response/HttpDataResult;", "T", "call", "Lkotlin/Function2;", "Lcom/bytedance/trae/im/service/IChatSessionAuthApi;", "Lkotlin/coroutines/Continuation;", "Lcom/bytedance/trae/network/response/BizResponse;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        private final String getBASE_URL() {
            return HostResolver.INSTANCE.getBaseUrl(HostType.REMOTE);
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x005d A[Catch: all -> 0x002a, CancellationException -> 0x002d, TryCatch #2 {CancellationException -> 0x002d, all -> 0x002a, blocks: (B:10:0x0026, B:11:0x0059, B:13:0x005d, B:16:0x0078, B:21:0x003a), top: B:7:0x0022 }] */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0078 A[Catch: all -> 0x002a, CancellationException -> 0x002d, TRY_LEAVE, TryCatch #2 {CancellationException -> 0x002d, all -> 0x002a, blocks: (B:10:0x0026, B:11:0x0059, B:13:0x005d, B:16:0x0078, B:21:0x003a), top: B:7:0x0022 }] */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0037  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final <T> Object safeCall(Function2<? super IChatSessionAuthApi, ? super Continuation<? super BizResponse<T>>, ? extends Object> function2, Continuation<? super HttpDataResult<? extends T>> continuation) {
            IChatSessionAuthApi$Companion$safeCall$1 iChatSessionAuthApi$Companion$safeCall$1;
            int i;
            BizResponse bizResponse;
            try {
                if (continuation instanceof IChatSessionAuthApi$Companion$safeCall$1) {
                    iChatSessionAuthApi$Companion$safeCall$1 = (IChatSessionAuthApi$Companion$safeCall$1) continuation;
                    if ((iChatSessionAuthApi$Companion$safeCall$1.label & Integer.MIN_VALUE) != 0) {
                        iChatSessionAuthApi$Companion$safeCall$1.label -= Integer.MIN_VALUE;
                        Object obj = iChatSessionAuthApi$Companion$safeCall$1.result;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        i = iChatSessionAuthApi$Companion$safeCall$1.label;
                        if (i != 0) {
                            ResultKt.throwOnFailure(obj);
                            IChatSessionAuthApi iChatSessionAuthApi = (IChatSessionAuthApi) TraeHttpConnection.createService$default(TraeHttpConnection.INSTANCE, "chat_session_auth", IChatSessionAuthApi.class, (Converter.Factory) null, getBASE_URL(), (Map) null, false, 52, (Object) null);
                            iChatSessionAuthApi$Companion$safeCall$1.label = 1;
                            obj = function2.invoke(iChatSessionAuthApi, iChatSessionAuthApi$Companion$safeCall$1);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                        }
                        bizResponse = (BizResponse) obj;
                        if (bizResponse != null) {
                            return new HttpDataResult.Error(AccountErrorCode.CommonError.COMMON_ERROR_REQUEST_API, "BizResponse is null", new Exception("BizResponse is null"), (String) null, 8, (DefaultConstructorMarker) null);
                        }
                        return new HttpDataResult.Success(bizResponse, (Throwable) null);
                    }
                }
                if (i != 0) {
                }
                bizResponse = (BizResponse) obj;
                if (bizResponse != null) {
                }
            } catch (CancellationException e) {
                return new HttpDataResult.Error(-1001, "", e, (String) null, 8, (DefaultConstructorMarker) null);
            } catch (Throwable th) {
                return new HttpDataResult.Error(-1000, "", th, (String) null, 8, (DefaultConstructorMarker) null);
            }
            iChatSessionAuthApi$Companion$safeCall$1 = new IChatSessionAuthApi$Companion$safeCall$1(this, continuation);
            Object obj2 = iChatSessionAuthApi$Companion$safeCall$1.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            i = iChatSessionAuthApi$Companion$safeCall$1.label;
        }
    }
}
