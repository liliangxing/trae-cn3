package com.bytedance.trae.conversation.network;

import android.util.Log;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.Converter;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.ExtraInfo;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.QueryMap;
import com.bytedance.sdk.account.api.AccountErrorCode;
import com.bytedance.sdk.account.api.OauthTokenTriggerScene;
import com.bytedance.trae.conversation.network.IGetProjectApi;
import com.bytedance.trae.network.TraeHttpConnection;
import com.bytedance.trae.network.response.BizResponse;
import com.bytedance.trae.network.response.HttpDataResult;
import com.bytedance.ttnet.http.RequestContext;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IGetProjectApi.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fJ*\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0014\b\u0001\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006H§@¢\u0006\u0002\u0010\bJ*\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\u0014\b\u0001\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006H§@¢\u0006\u0002\u0010\bJ\u001e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00032\b\b\u0001\u0010\r\u001a\u00020\u000eH§@¢\u0006\u0002\u0010\u000fJ*\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00032\u0014\b\u0001\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006H§@¢\u0006\u0002\u0010\bJ\u001e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00032\b\b\u0001\u0010\r\u001a\u00020\u0014H§@¢\u0006\u0002\u0010\u0015J*\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00032\u0014\b\u0001\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006H§@¢\u0006\u0002\u0010\bJ2\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00192\u0014\b\u0001\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00062\n\b\u0001\u0010\u001a\u001a\u0004\u0018\u00010\u0001H'J2\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00192\u0014\b\u0001\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00062\n\b\u0001\u0010\u001a\u001a\u0004\u0018\u00010\u0001H'J&\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00192\b\b\u0001\u0010\r\u001a\u00020\u000e2\n\b\u0001\u0010\u001a\u001a\u0004\u0018\u00010\u0001H'J2\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00192\u0014\b\u0001\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00062\n\b\u0001\u0010\u001a\u001a\u0004\u0018\u00010\u0001H'J&\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00192\b\b\u0001\u0010\r\u001a\u00020\u00142\n\b\u0001\u0010\u001a\u001a\u0004\u0018\u00010\u0001H'¨\u0006 "}, d2 = {"Lcom/bytedance/trae/conversation/network/IGetProjectApi;", "", "getUserProjectFolders", "Lcom/bytedance/trae/conversation/network/RemoteResponse;", "Lcom/bytedance/trae/conversation/network/UserProjectFoldersData;", "query", "", "", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "listFolder", "Lcom/bytedance/trae/conversation/network/ListFolderData;", "createFolder", "Lcom/bytedance/trae/conversation/network/CreateFolderData;", OauthTokenTriggerScene.REQUEST, "Lcom/bytedance/trae/conversation/network/CreateFolderRequest;", "(Lcom/bytedance/trae/conversation/network/CreateFolderRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkNeedAuthorization", "Lcom/bytedance/trae/conversation/network/CheckAuthorizationData;", "authorizationResult", "", "Lcom/bytedance/trae/conversation/network/AuthorizationResultRequest;", "(Lcom/bytedance/trae/conversation/network/AuthorizationResultRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "listProjects", "Lcom/bytedance/trae/conversation/network/ListProjectsData;", "getUserProjectFoldersRaw", "Lcom/bytedance/retrofit2/Call;", "extraInfo", "listFolderRaw", "createFolderRaw", "checkNeedAuthorizationRaw", "authorizationResultRaw", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public interface IGetProjectApi {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @POST("api/solo_hub/v1/clis/folders/authorization/result")
    Object authorizationResult(@Body AuthorizationResultRequest authorizationResultRequest, Continuation<? super RemoteResponse<Unit>> continuation);

    @POST("api/solo_hub/v1/clis/folders/authorization/result")
    Call<String> authorizationResultRaw(@Body AuthorizationResultRequest request, @ExtraInfo Object extraInfo);

    @GET("api/solo_hub/v1/clis/folders/authorization/check")
    Object checkNeedAuthorization(@QueryMap Map<String, String> map, Continuation<? super RemoteResponse<CheckAuthorizationData>> continuation);

    @GET("api/solo_hub/v1/clis/folders/authorization/check")
    Call<String> checkNeedAuthorizationRaw(@QueryMap Map<String, String> query, @ExtraInfo Object extraInfo);

    @POST("api/solo_hub/v1/clis/folders")
    Object createFolder(@Body CreateFolderRequest createFolderRequest, Continuation<? super RemoteResponse<CreateFolderData>> continuation);

    @POST("api/solo_hub/v1/clis/folders")
    Call<String> createFolderRaw(@Body CreateFolderRequest request, @ExtraInfo Object extraInfo);

    @GET("api/solo_hub/v1/clis/folders/user")
    Object getUserProjectFolders(@QueryMap Map<String, String> map, Continuation<? super RemoteResponse<UserProjectFoldersData>> continuation);

    @GET("api/solo_hub/v1/clis/folders/user")
    Call<String> getUserProjectFoldersRaw(@QueryMap Map<String, String> query, @ExtraInfo Object extraInfo);

    @GET("api/solo_hub/v1/clis/folders")
    Object listFolder(@QueryMap Map<String, String> map, Continuation<? super RemoteResponse<ListFolderData>> continuation);

    @GET("api/solo_hub/v1/clis/folders")
    Call<String> listFolderRaw(@QueryMap Map<String, String> query, @ExtraInfo Object extraInfo);

    @GET("api/solo_hub/v1/clis/projects")
    Object listProjects(@QueryMap Map<String, String> map, Continuation<? super RemoteResponse<ListProjectsData>> continuation);

    /* compiled from: IGetProjectApi.kt */
    @Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Ja\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u000b0\n\"\u0004\b\u0000\u0010\u000b2\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\r2/\u0010\u000e\u001a+\b\u0001\u0012\u0004\u0012\u00020\u0010\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\u000b\u0018\u00010\u00120\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000f¢\u0006\u0002\b\u0013H\u0086@¢\u0006\u0002\u0010\u0014J(\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\n2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\rH\u0086@¢\u0006\u0002\u0010\u0018J(\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\n2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\rH\u0086@¢\u0006\u0002\u0010\u0018J\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\n2\u0006\u0010\u001d\u001a\u00020\u001eH\u0086@¢\u0006\u0002\u0010\u001fJ(\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\n2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\rH\u0086@¢\u0006\u0002\u0010\u0018J\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\n2\u0006\u0010\u001d\u001a\u00020$H\u0086@¢\u0006\u0002\u0010%J<\u0010&\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050'\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000b0(0\u000f\"\u0004\b\u0000\u0010\u000b2\f\u0010)\u001a\b\u0012\u0004\u0012\u0002H\u000b0*H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/bytedance/trae/conversation/network/IGetProjectApi$Companion;", "", "<init>", "()V", "TAG", "", "RAW_SUCCESS_CODES", "", "", "safeCall", "Lcom/bytedance/trae/network/response/HttpDataResult;", "T", "headers", "", "call", "Lkotlin/Function2;", "Lcom/bytedance/trae/conversation/network/IGetProjectApi;", "Lkotlin/coroutines/Continuation;", "Lcom/bytedance/trae/conversation/network/RemoteResponse;", "Lkotlin/ExtensionFunctionType;", "(Ljava/util/Map;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUserProjectFoldersRawCall", "Lcom/bytedance/trae/conversation/network/UserProjectFoldersData;", "query", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "listFolderRawCall", "Lcom/bytedance/trae/conversation/network/ListFolderData;", "createFolderRawCall", "Lcom/bytedance/trae/conversation/network/CreateFolderData;", OauthTokenTriggerScene.REQUEST, "Lcom/bytedance/trae/conversation/network/CreateFolderRequest;", "(Lcom/bytedance/trae/conversation/network/CreateFolderRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkNeedAuthorizationRawCall", "Lcom/bytedance/trae/conversation/network/CheckAuthorizationData;", "authorizationResultRawCall", "", "Lcom/bytedance/trae/conversation/network/AuthorizationResultRequest;", "(Lcom/bytedance/trae/conversation/network/AuthorizationResultRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "remoteResponseParser", "Lcom/bytedance/retrofit2/SsResponse;", "Lcom/bytedance/trae/network/response/BizResponse;", "dataClazz", "Ljava/lang/Class;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final Set<Long> RAW_SUCCESS_CODES = SetsKt.setOf(200L);
        private static final String TAG = "IGetProjectApi";

        private Companion() {
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x0066 A[Catch: all -> 0x0032, CancellationException -> 0x0036, TryCatch #2 {CancellationException -> 0x0036, all -> 0x0032, blocks: (B:10:0x002e, B:11:0x0062, B:13:0x0066, B:16:0x0081, B:19:0x0096, B:21:0x0092, B:25:0x0044), top: B:7:0x002a }] */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0081 A[Catch: all -> 0x0032, CancellationException -> 0x0036, TryCatch #2 {CancellationException -> 0x0036, all -> 0x0032, blocks: (B:10:0x002e, B:11:0x0062, B:13:0x0066, B:16:0x0081, B:19:0x0096, B:21:0x0092, B:25:0x0044), top: B:7:0x002a }] */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0041  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x002c  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final <T> Object safeCall(Map<String, String> map, Function2<? super IGetProjectApi, ? super Continuation<? super RemoteResponse<T>>, ? extends Object> function2, Continuation<? super HttpDataResult<? extends T>> continuation) {
            IGetProjectApi$Companion$safeCall$1 iGetProjectApi$Companion$safeCall$1;
            int i;
            RemoteResponse remoteResponse;
            try {
                if (continuation instanceof IGetProjectApi$Companion$safeCall$1) {
                    iGetProjectApi$Companion$safeCall$1 = (IGetProjectApi$Companion$safeCall$1) continuation;
                    if ((iGetProjectApi$Companion$safeCall$1.label & Integer.MIN_VALUE) != 0) {
                        iGetProjectApi$Companion$safeCall$1.label -= Integer.MIN_VALUE;
                        Object obj = iGetProjectApi$Companion$safeCall$1.result;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        i = iGetProjectApi$Companion$safeCall$1.label;
                        if (i != 0) {
                            ResultKt.throwOnFailure(obj);
                            IGetProjectApi iGetProjectApi = (IGetProjectApi) TraeHttpConnection.createService$default(TraeHttpConnection.INSTANCE, "project", IGetProjectApi.class, (Converter.Factory) null, (String) null, (Map) null, false, 60, (Object) null);
                            iGetProjectApi$Companion$safeCall$1.label = 1;
                            obj = function2.invoke(iGetProjectApi, iGetProjectApi$Companion$safeCall$1);
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
                        return new HttpDataResult.Success(new BizResponse(remoteResponse.getCode() == 200 ? 0L : remoteResponse.getCode(), remoteResponse.getMsg(), (String) null, (String) null, remoteResponse.getData(), (String) null, 44, (DefaultConstructorMarker) null), (Throwable) null);
                    }
                }
                if (i != 0) {
                }
                remoteResponse = (RemoteResponse) obj;
                if (remoteResponse != null) {
                }
            } catch (CancellationException e) {
                CancellationException cancellationException = e;
                Log.e(TAG, "CancellationException", cancellationException);
                return new HttpDataResult.Error(-1001, "", cancellationException, (String) null, 8, (DefaultConstructorMarker) null);
            } catch (Throwable th) {
                Log.e(TAG, "Error", th);
                return new HttpDataResult.Error(-1000, "", th, (String) null, 8, (DefaultConstructorMarker) null);
            }
            iGetProjectApi$Companion$safeCall$1 = new IGetProjectApi$Companion$safeCall$1(this, continuation);
            Object obj2 = iGetProjectApi$Companion$safeCall$1.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            i = iGetProjectApi$Companion$safeCall$1.label;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Object safeCall$default(Companion companion, Map map, Function2 function2, Continuation continuation, int i, Object obj) {
            if ((i & 1) != 0) {
                map = MapsKt.emptyMap();
            }
            return companion.safeCall(map, function2, continuation);
        }

        public final Object getUserProjectFoldersRawCall(final Map<String, String> map, Continuation<? super HttpDataResult<UserProjectFoldersData>> continuation) {
            return TraeHttpConnection.rawBizCall$default(TraeHttpConnection.INSTANCE, "project", IGetProjectApi.class, (String) null, (String) null, (Map) null, false, RAW_SUCCESS_CODES, false, false, remoteResponseParser(UserProjectFoldersData.class), new Function2() { // from class: com.bytedance.trae.conversation.network.IGetProjectApi$Companion$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Call userProjectFoldersRawCall$lambda$0;
                    userProjectFoldersRawCall$lambda$0 = IGetProjectApi.Companion.getUserProjectFoldersRawCall$lambda$0(map, (IGetProjectApi) obj, (RequestContext) obj2);
                    return userProjectFoldersRawCall$lambda$0;
                }
            }, continuation, 444, (Object) null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Call getUserProjectFoldersRawCall$lambda$0(Map map, IGetProjectApi iGetProjectApi, RequestContext requestContext) {
            Intrinsics.checkNotNullParameter(iGetProjectApi, "$this$rawBizCall");
            Intrinsics.checkNotNullParameter(requestContext, "requestContext");
            return iGetProjectApi.getUserProjectFoldersRaw(map, requestContext);
        }

        public final Object listFolderRawCall(final Map<String, String> map, Continuation<? super HttpDataResult<ListFolderData>> continuation) {
            return TraeHttpConnection.rawBizCall$default(TraeHttpConnection.INSTANCE, "project", IGetProjectApi.class, (String) null, (String) null, (Map) null, false, RAW_SUCCESS_CODES, false, false, remoteResponseParser(ListFolderData.class), new Function2() { // from class: com.bytedance.trae.conversation.network.IGetProjectApi$Companion$$ExternalSyntheticLambda5
                public final Object invoke(Object obj, Object obj2) {
                    Call listFolderRawCall$lambda$1;
                    listFolderRawCall$lambda$1 = IGetProjectApi.Companion.listFolderRawCall$lambda$1(map, (IGetProjectApi) obj, (RequestContext) obj2);
                    return listFolderRawCall$lambda$1;
                }
            }, continuation, 444, (Object) null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Call listFolderRawCall$lambda$1(Map map, IGetProjectApi iGetProjectApi, RequestContext requestContext) {
            Intrinsics.checkNotNullParameter(iGetProjectApi, "$this$rawBizCall");
            Intrinsics.checkNotNullParameter(requestContext, "requestContext");
            return iGetProjectApi.listFolderRaw(map, requestContext);
        }

        public final Object createFolderRawCall(final CreateFolderRequest createFolderRequest, Continuation<? super HttpDataResult<CreateFolderData>> continuation) {
            return TraeHttpConnection.rawBizCall$default(TraeHttpConnection.INSTANCE, "project", IGetProjectApi.class, (String) null, (String) null, (Map) null, false, RAW_SUCCESS_CODES, false, false, remoteResponseParser(CreateFolderData.class), new Function2() { // from class: com.bytedance.trae.conversation.network.IGetProjectApi$Companion$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2) {
                    Call createFolderRawCall$lambda$2;
                    createFolderRawCall$lambda$2 = IGetProjectApi.Companion.createFolderRawCall$lambda$2(CreateFolderRequest.this, (IGetProjectApi) obj, (RequestContext) obj2);
                    return createFolderRawCall$lambda$2;
                }
            }, continuation, 444, (Object) null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Call createFolderRawCall$lambda$2(CreateFolderRequest createFolderRequest, IGetProjectApi iGetProjectApi, RequestContext requestContext) {
            Intrinsics.checkNotNullParameter(iGetProjectApi, "$this$rawBizCall");
            Intrinsics.checkNotNullParameter(requestContext, "requestContext");
            return iGetProjectApi.createFolderRaw(createFolderRequest, requestContext);
        }

        public final Object checkNeedAuthorizationRawCall(final Map<String, String> map, Continuation<? super HttpDataResult<CheckAuthorizationData>> continuation) {
            return TraeHttpConnection.rawBizCall$default(TraeHttpConnection.INSTANCE, "project", IGetProjectApi.class, (String) null, (String) null, (Map) null, false, RAW_SUCCESS_CODES, false, false, remoteResponseParser(CheckAuthorizationData.class), new Function2() { // from class: com.bytedance.trae.conversation.network.IGetProjectApi$Companion$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Call checkNeedAuthorizationRawCall$lambda$3;
                    checkNeedAuthorizationRawCall$lambda$3 = IGetProjectApi.Companion.checkNeedAuthorizationRawCall$lambda$3(map, (IGetProjectApi) obj, (RequestContext) obj2);
                    return checkNeedAuthorizationRawCall$lambda$3;
                }
            }, continuation, 444, (Object) null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Call checkNeedAuthorizationRawCall$lambda$3(Map map, IGetProjectApi iGetProjectApi, RequestContext requestContext) {
            Intrinsics.checkNotNullParameter(iGetProjectApi, "$this$rawBizCall");
            Intrinsics.checkNotNullParameter(requestContext, "requestContext");
            return iGetProjectApi.checkNeedAuthorizationRaw(map, requestContext);
        }

        public final Object authorizationResultRawCall(final AuthorizationResultRequest authorizationResultRequest, Continuation<? super HttpDataResult<Unit>> continuation) {
            return TraeHttpConnection.rawBizCall$default(TraeHttpConnection.INSTANCE, "project", IGetProjectApi.class, (String) null, (String) null, (Map) null, false, RAW_SUCCESS_CODES, false, false, remoteResponseParser(Unit.class), new Function2() { // from class: com.bytedance.trae.conversation.network.IGetProjectApi$Companion$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Call authorizationResultRawCall$lambda$4;
                    authorizationResultRawCall$lambda$4 = IGetProjectApi.Companion.authorizationResultRawCall$lambda$4(AuthorizationResultRequest.this, (IGetProjectApi) obj, (RequestContext) obj2);
                    return authorizationResultRawCall$lambda$4;
                }
            }, continuation, 444, (Object) null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Call authorizationResultRawCall$lambda$4(AuthorizationResultRequest authorizationResultRequest, IGetProjectApi iGetProjectApi, RequestContext requestContext) {
            Intrinsics.checkNotNullParameter(iGetProjectApi, "$this$rawBizCall");
            Intrinsics.checkNotNullParameter(requestContext, "requestContext");
            return iGetProjectApi.authorizationResultRaw(authorizationResultRequest, requestContext);
        }

        private final <T> Function2<String, SsResponse<String>, BizResponse<T>> remoteResponseParser(final Class<T> dataClazz) {
            return new Function2() { // from class: com.bytedance.trae.conversation.network.IGetProjectApi$Companion$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    BizResponse remoteResponseParser$lambda$5;
                    remoteResponseParser$lambda$5 = IGetProjectApi.Companion.remoteResponseParser$lambda$5(dataClazz, (String) obj, (SsResponse) obj2);
                    return remoteResponseParser$lambda$5;
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final BizResponse remoteResponseParser$lambda$5(Class cls, String str, SsResponse ssResponse) {
            Intrinsics.checkNotNullParameter(str, "body");
            Intrinsics.checkNotNullParameter(ssResponse, "<unused var>");
            RemoteResponse remoteResponse = (RemoteResponse) TraeHttpConnection.INSTANCE.getHttpGson().fromJson(str, TypeToken.getParameterized(RemoteResponse.class, new Type[]{cls}).getType());
            return new BizResponse(remoteResponse.getCode(), remoteResponse.getMsg(), (String) null, (String) null, remoteResponse.getData(), (String) null, 44, (DefaultConstructorMarker) null);
        }
    }
}
