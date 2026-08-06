package com.bytedance.trae.conversation.network;

import com.bytedance.apm.ApmAgent;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.Converter;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.http.ExtraInfo;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.QueryMap;
import com.bytedance.sdk.account.api.AccountErrorCode;
import com.bytedance.sdk.account.monitor.AccountMonitorConstants;
import com.bytedance.trae.conversation.network.IGetGitApi;
import com.bytedance.trae.network.HostResolver;
import com.bytedance.trae.network.HostType;
import com.bytedance.trae.network.TraeHttpConnection;
import com.bytedance.trae.network.response.BizResponse;
import com.bytedance.trae.network.response.HttpDataResult;
import com.bytedance.ttnet.http.RequestContext;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: IGetGitApi.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011J\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H§@¢\u0006\u0002\u0010\u0005J*\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u00032\u0014\b\u0001\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tH§@¢\u0006\u0002\u0010\u000bJ*\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\u0014\b\u0001\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tH§@¢\u0006\u0002\u0010\u000bJ2\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u000f2\u0014\b\u0001\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t2\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\u0001H'¨\u0006\u0012"}, d2 = {"Lcom/bytedance/trae/conversation/network/IGetGitApi;", "", "listRepositories", "Lcom/bytedance/trae/conversation/network/RemoteResponse;", "Lcom/bytedance/trae/conversation/network/ListRepositoriesData;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "listBranches", "Lcom/bytedance/trae/conversation/network/ListBranchesData;", "query", "", "", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getGitToken", "Lcom/bytedance/trae/conversation/network/GetGitTokenData;", "listRepositoriesRaw", "Lcom/bytedance/retrofit2/Call;", "extraInfo", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public interface IGetGitApi {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @GET("api/remote/v1/git/token")
    Object getGitToken(@QueryMap Map<String, String> map, Continuation<? super RemoteResponse<GetGitTokenData>> continuation);

    @GET("api/remote/v1/git/branches")
    Object listBranches(@QueryMap Map<String, String> map, Continuation<? super RemoteResponse<ListBranchesData>> continuation);

    @GET("api/remote/v1/git/repositories")
    Object listRepositories(Continuation<? super RemoteResponse<ListRepositoriesData>> continuation);

    @GET("api/remote/v1/git/repositories")
    Call<String> listRepositoriesRaw(@QueryMap Map<String, String> query, @ExtraInfo Object extraInfo);

    /* compiled from: IGetGitApi.kt */
    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J_\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\r0\f\"\u0004\b\u0000\u0010\r2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000f2/\u0010\u0010\u001a+\b\u0001\u0012\u0004\u0012\u00020\u0012\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\r\u0018\u00010\u00140\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0011¢\u0006\u0002\b\u0015H\u0086@¢\u0006\u0002\u0010\u0016J(\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\f2\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000fH\u0086@¢\u0006\u0002\u0010\u001aJ\u001a\u0010\u001b\u001a\u00020\u001c2\u0010\u0010\u001d\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u001eH\u0002R\u0014\u0010\u0004\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/bytedance/trae/conversation/network/IGetGitApi$Companion;", "", "<init>", "()V", "BASE_URL", "", "getBASE_URL", "()Ljava/lang/String;", "LIST_REPOSITORIES_SUCCESS_CODES", "", "", "safeCall", "Lcom/bytedance/trae/network/response/HttpDataResult;", "T", "headers", "", "call", "Lkotlin/Function2;", "Lcom/bytedance/trae/conversation/network/IGetGitApi;", "Lkotlin/coroutines/Continuation;", "Lcom/bytedance/trae/conversation/network/RemoteResponse;", "Lkotlin/ExtensionFunctionType;", "(Ljava/util/Map;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "listRepositoriesRawCall", "Lcom/bytedance/trae/conversation/network/ListRepositoriesData;", "query", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "monitorRepoResponse", "", "ssResponse", "Lcom/bytedance/retrofit2/SsResponse;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final Set<Long> LIST_REPOSITORIES_SUCCESS_CODES = BizResponse.Companion.getDEFAULT_SUCCESS_CODES();

        private Companion() {
        }

        private final String getBASE_URL() {
            return HostResolver.INSTANCE.getBaseUrl(HostType.REMOTE);
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x005e A[Catch: all -> 0x002a, CancellationException -> 0x002d, TryCatch #2 {CancellationException -> 0x002d, all -> 0x002a, blocks: (B:10:0x0026, B:11:0x005a, B:13:0x005e, B:16:0x0079, B:21:0x003b), top: B:7:0x0022 }] */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0079 A[Catch: all -> 0x002a, CancellationException -> 0x002d, TRY_LEAVE, TryCatch #2 {CancellationException -> 0x002d, all -> 0x002a, blocks: (B:10:0x0026, B:11:0x005a, B:13:0x005e, B:16:0x0079, B:21:0x003b), top: B:7:0x0022 }] */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0038  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final <T> Object safeCall(Map<String, String> map, Function2<? super IGetGitApi, ? super Continuation<? super RemoteResponse<T>>, ? extends Object> function2, Continuation<? super HttpDataResult<? extends T>> continuation) {
            IGetGitApi$Companion$safeCall$1 iGetGitApi$Companion$safeCall$1;
            int i;
            RemoteResponse remoteResponse;
            try {
                if (continuation instanceof IGetGitApi$Companion$safeCall$1) {
                    iGetGitApi$Companion$safeCall$1 = (IGetGitApi$Companion$safeCall$1) continuation;
                    if ((iGetGitApi$Companion$safeCall$1.label & Integer.MIN_VALUE) != 0) {
                        iGetGitApi$Companion$safeCall$1.label -= Integer.MIN_VALUE;
                        Object obj = iGetGitApi$Companion$safeCall$1.result;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        i = iGetGitApi$Companion$safeCall$1.label;
                        if (i != 0) {
                            ResultKt.throwOnFailure(obj);
                            IGetGitApi iGetGitApi = (IGetGitApi) TraeHttpConnection.createService$default(TraeHttpConnection.INSTANCE, "git", IGetGitApi.class, (Converter.Factory) null, getBASE_URL(), (Map) null, false, 52, (Object) null);
                            iGetGitApi$Companion$safeCall$1.label = 1;
                            obj = function2.invoke(iGetGitApi, iGetGitApi$Companion$safeCall$1);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                        }
                        remoteResponse = (RemoteResponse) obj;
                        if (remoteResponse != null) {
                            return new HttpDataResult.Error(AccountErrorCode.CommonError.COMMON_ERROR_REQUEST_API, "BizResponse is null", new Exception("BizResponse is null"), (String) null, 8, (DefaultConstructorMarker) null);
                        }
                        return new HttpDataResult.Success(new BizResponse(remoteResponse.getCode(), remoteResponse.getMsg(), (String) null, (String) null, remoteResponse.getData(), (String) null, 44, (DefaultConstructorMarker) null), (Throwable) null);
                    }
                }
                if (i != 0) {
                }
                remoteResponse = (RemoteResponse) obj;
                if (remoteResponse != null) {
                }
            } catch (CancellationException e) {
                return new HttpDataResult.Error(-1001, "", e, (String) null, 8, (DefaultConstructorMarker) null);
            } catch (Throwable th) {
                return new HttpDataResult.Error(-1000, "", th, (String) null, 8, (DefaultConstructorMarker) null);
            }
            iGetGitApi$Companion$safeCall$1 = new IGetGitApi$Companion$safeCall$1(this, continuation);
            Object obj2 = iGetGitApi$Companion$safeCall$1.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            i = iGetGitApi$Companion$safeCall$1.label;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x003b  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object listRepositoriesRawCall(final Map<String, String> map, Continuation<? super HttpDataResult<ListRepositoriesData>> continuation) {
            IGetGitApi$Companion$listRepositoriesRawCall$1 iGetGitApi$Companion$listRepositoriesRawCall$1;
            int i;
            Companion companion;
            if (continuation instanceof IGetGitApi$Companion$listRepositoriesRawCall$1) {
                iGetGitApi$Companion$listRepositoriesRawCall$1 = (IGetGitApi$Companion$listRepositoriesRawCall$1) continuation;
                if ((iGetGitApi$Companion$listRepositoriesRawCall$1.label & Integer.MIN_VALUE) != 0) {
                    iGetGitApi$Companion$listRepositoriesRawCall$1.label -= Integer.MIN_VALUE;
                    IGetGitApi$Companion$listRepositoriesRawCall$1 iGetGitApi$Companion$listRepositoriesRawCall$12 = iGetGitApi$Companion$listRepositoriesRawCall$1;
                    Object obj = iGetGitApi$Companion$listRepositoriesRawCall$12.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = iGetGitApi$Companion$listRepositoriesRawCall$12.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        String base_url = getBASE_URL();
                        Set<Long> set = LIST_REPOSITORIES_SUCCESS_CODES;
                        Function2 function2 = new Function2() { // from class: com.bytedance.trae.conversation.network.IGetGitApi$Companion$$ExternalSyntheticLambda0
                            public final Object invoke(Object obj2, Object obj3) {
                                Call listRepositoriesRawCall$lambda$0;
                                listRepositoriesRawCall$lambda$0 = IGetGitApi.Companion.listRepositoriesRawCall$lambda$0(map, (IGetGitApi) obj2, (RequestContext) obj3);
                                return listRepositoriesRawCall$lambda$0;
                            }
                        };
                        iGetGitApi$Companion$listRepositoriesRawCall$12.L$0 = this;
                        iGetGitApi$Companion$listRepositoriesRawCall$12.label = 1;
                        obj = TraeHttpConnection.rawBizCallWithBody$default(TraeHttpConnection.INSTANCE, "git", IGetGitApi.class, ListRepositoriesData.class, (String) null, base_url, (Map) null, false, set, false, function2, iGetGitApi$Companion$listRepositoriesRawCall$12, 360, (Object) null);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        companion = this;
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        companion = (Companion) iGetGitApi$Companion$listRepositoriesRawCall$12.L$0;
                        ResultKt.throwOnFailure(obj);
                    }
                    TraeHttpConnection.RawBizCallResult rawBizCallResult = (TraeHttpConnection.RawBizCallResult) obj;
                    companion.monitorRepoResponse(rawBizCallResult.getSsResponse());
                    return rawBizCallResult.getResult();
                }
            }
            iGetGitApi$Companion$listRepositoriesRawCall$1 = new IGetGitApi$Companion$listRepositoriesRawCall$1(this, continuation);
            IGetGitApi$Companion$listRepositoriesRawCall$1 iGetGitApi$Companion$listRepositoriesRawCall$122 = iGetGitApi$Companion$listRepositoriesRawCall$1;
            Object obj2 = iGetGitApi$Companion$listRepositoriesRawCall$122.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            i = iGetGitApi$Companion$listRepositoriesRawCall$122.label;
            if (i != 0) {
            }
            TraeHttpConnection.RawBizCallResult rawBizCallResult2 = (TraeHttpConnection.RawBizCallResult) obj2;
            companion.monitorRepoResponse(rawBizCallResult2.getSsResponse());
            return rawBizCallResult2.getResult();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Call listRepositoriesRawCall$lambda$0(Map map, IGetGitApi iGetGitApi, RequestContext requestContext) {
            Intrinsics.checkNotNullParameter(iGetGitApi, "$this$rawBizCallWithBody");
            Intrinsics.checkNotNullParameter(requestContext, "requestContext");
            return iGetGitApi.listRepositoriesRaw(map, requestContext);
        }

        private final void monitorRepoResponse(SsResponse<String> ssResponse) {
            Object obj;
            if (ssResponse == null) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("http_code", ssResponse.code());
                JSONObject jSONObject2 = new JSONObject();
                List headers = ssResponse.headers();
                Intrinsics.checkNotNullExpressionValue(headers, "headers(...)");
                Iterator it = headers.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    } else {
                        obj = it.next();
                        if (StringsKt.equals(((Header) obj).getName(), "X-Tt-Logid", true)) {
                            break;
                        }
                    }
                }
                Header header = (Header) obj;
                jSONObject2.put(AccountMonitorConstants.CommonParameter.LOGID, header != null ? header.getValue() : null);
                ApmAgent.monitorEvent("repo_response", jSONObject, (JSONObject) null, jSONObject2);
            } catch (Throwable unused) {
            }
        }
    }
}
