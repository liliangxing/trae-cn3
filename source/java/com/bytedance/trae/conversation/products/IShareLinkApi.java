package com.bytedance.trae.conversation.products;

import com.bytedance.retrofit2.Converter;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.HTTP;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Path;
import com.bytedance.retrofit2.http.Query;
import com.bytedance.sdk.account.api.AccountErrorCode;
import com.bytedance.sdk.account.api.OauthTokenTriggerScene;
import com.bytedance.sdk.open.aweme.core.net.OpenNetMethod;
import com.bytedance.trae.login.api.ILoginService;
import com.bytedance.trae.network.HostResolver;
import com.bytedance.trae.network.HostType;
import com.bytedance.trae.network.TraeHttpConnection;
import com.bytedance.trae.network.response.BizResponse;
import com.bytedance.trae.network.response.HttpDataResult;
import com.bytedance.trae.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: IShareLinkApi.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fJ\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u0007J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\nH§@¢\u0006\u0002\u0010\u000bJ(\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\b\b\u0001\u0010\u000e\u001a\u00020\u000f2\b\b\u0001\u0010\u0005\u001a\u00020\u0010H§@¢\u0006\u0002\u0010\u0011J(\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00032\b\b\u0001\u0010\u0014\u001a\u00020\u000f2\b\b\u0001\u0010\u0015\u001a\u00020\u000fH§@¢\u0006\u0002\u0010\u0016J\u001e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0019H§@¢\u0006\u0002\u0010\u001aJ\u001e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u001dH§@¢\u0006\u0002\u0010\u001e¨\u0006 "}, d2 = {"Lcom/bytedance/trae/conversation/products/IShareLinkApi;", "", "createShareLink", "Lcom/bytedance/trae/network/response/BizResponse;", "Lcom/bytedance/trae/conversation/products/ShareLinkData;", "body", "Lcom/bytedance/trae/conversation/products/ShareLinkRequest;", "(Lcom/bytedance/trae/conversation/products/ShareLinkRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createLocalShareLink", "Lcom/bytedance/trae/conversation/products/LocalShareLinkData;", "Lcom/bytedance/trae/conversation/products/LocalShareLinkRequest;", "(Lcom/bytedance/trae/conversation/products/LocalShareLinkRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateShareLinkStatus", "Lcom/bytedance/trae/conversation/products/UpdateShareLinkStatusData;", "shareSessionId", "", "Lcom/bytedance/trae/conversation/products/UpdateShareLinkStatusRequest;", "(Ljava/lang/String;Lcom/bytedance/trae/conversation/products/UpdateShareLinkStatusRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRemoteShareLink", "Lcom/bytedance/trae/conversation/products/ShareArtifactData;", "chatSessionId", "artifactPath", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLocalShareLink", "Lcom/bytedance/trae/conversation/products/GetLocalShareLinkData;", "Lcom/bytedance/trae/conversation/products/GetLocalShareLinkRequest;", "(Lcom/bytedance/trae/conversation/products/GetLocalShareLinkRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateLocalShareLinkStatus", "Lcom/bytedance/trae/conversation/products/UpdateLocalShareLinkStatusData;", "Lcom/bytedance/trae/conversation/products/UpdateLocalShareLinkStatusRequest;", "(Lcom/bytedance/trae/conversation/products/UpdateLocalShareLinkStatusRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public interface IShareLinkApi {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @POST("api/solo_hub/v1/conversations/artifact/share")
    Object createLocalShareLink(@Body LocalShareLinkRequest localShareLinkRequest, Continuation<? super BizResponse<LocalShareLinkData>> continuation);

    @POST("api/remote/v1/share")
    Object createShareLink(@Body ShareLinkRequest shareLinkRequest, Continuation<? super BizResponse<ShareLinkData>> continuation);

    @POST("api/solo_hub/v1/conversations/artifact/share/get")
    Object getLocalShareLink(@Body GetLocalShareLinkRequest getLocalShareLinkRequest, Continuation<? super BizResponse<GetLocalShareLinkData>> continuation);

    @GET("api/remote/v1/share/artifact")
    Object getRemoteShareLink(@Query("chat_session_id") String str, @Query("artifact_path") String str2, Continuation<? super BizResponse<ShareArtifactData>> continuation);

    @POST("api/solo_hub/v1/conversations/artifact/share/status")
    Object updateLocalShareLinkStatus(@Body UpdateLocalShareLinkStatusRequest updateLocalShareLinkStatusRequest, Continuation<? super BizResponse<UpdateLocalShareLinkStatusData>> continuation);

    @HTTP(hasBody = true, method = OpenNetMethod.PATCH, path = "api/remote/v1/share/{share_session_id}/status")
    Object updateShareLinkStatus(@Path("share_session_id") String str, @Body UpdateShareLinkStatusRequest updateShareLinkStatusRequest, Continuation<? super BizResponse<UpdateShareLinkStatusData>> continuation);

    /* compiled from: IShareLinkApi.kt */
    @Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0086@¢\u0006\u0002\u0010\tJ\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00052\u0006\u0010\u0007\u001a\u00020\fH\u0086@¢\u0006\u0002\u0010\rJ\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00052\u0006\u0010\u0007\u001a\u00020\u0010H\u0086@¢\u0006\u0002\u0010\u0011J$\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00052\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0086@¢\u0006\u0002\u0010\u0017J$\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u00052\u0006\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0007\u001a\u00020\u001bH\u0086@¢\u0006\u0002\u0010\u001cJ\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00052\u0006\u0010\u0007\u001a\u00020\u001fH\u0086@¢\u0006\u0002\u0010 ¨\u0006!"}, d2 = {"Lcom/bytedance/trae/conversation/products/IShareLinkApi$Companion;", "", "<init>", "()V", "createShareLink", "Lcom/bytedance/trae/network/response/HttpDataResult;", "Lcom/bytedance/trae/conversation/products/ShareLinkData;", OauthTokenTriggerScene.REQUEST, "Lcom/bytedance/trae/conversation/products/ShareLinkRequest;", "(Lcom/bytedance/trae/conversation/products/ShareLinkRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createLocalShareLink", "Lcom/bytedance/trae/conversation/products/LocalShareLinkData;", "Lcom/bytedance/trae/conversation/products/LocalShareLinkRequest;", "(Lcom/bytedance/trae/conversation/products/LocalShareLinkRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLocalShareLink", "Lcom/bytedance/trae/conversation/products/GetLocalShareLinkData;", "Lcom/bytedance/trae/conversation/products/GetLocalShareLinkRequest;", "(Lcom/bytedance/trae/conversation/products/GetLocalShareLinkRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRemoteShareLink", "Lcom/bytedance/trae/conversation/products/ShareArtifactData;", "chatSessionId", "", "artifactPath", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateShareLinkStatus", "Lcom/bytedance/trae/conversation/products/UpdateShareLinkStatusData;", "shareSessionId", "Lcom/bytedance/trae/conversation/products/UpdateShareLinkStatusRequest;", "(Ljava/lang/String;Lcom/bytedance/trae/conversation/products/UpdateShareLinkStatusRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateLocalShareLinkStatus", "Lcom/bytedance/trae/conversation/products/UpdateLocalShareLinkStatusData;", "Lcom/bytedance/trae/conversation/products/UpdateLocalShareLinkStatusRequest;", "(Lcom/bytedance/trae/conversation/products/UpdateLocalShareLinkStatusRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x00de A[Catch: all -> 0x003c, CancellationException -> 0x0040, TryCatch #2 {CancellationException -> 0x0040, all -> 0x003c, blocks: (B:10:0x0037, B:11:0x00da, B:13:0x00de, B:16:0x0103, B:18:0x012e, B:19:0x0134, B:21:0x0144, B:22:0x014a, B:24:0x015c, B:25:0x0166, B:33:0x0080, B:35:0x008e, B:38:0x0097), top: B:7:0x0033 }] */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0103 A[Catch: all -> 0x003c, CancellationException -> 0x0040, TryCatch #2 {CancellationException -> 0x0040, all -> 0x003c, blocks: (B:10:0x0037, B:11:0x00da, B:13:0x00de, B:16:0x0103, B:18:0x012e, B:19:0x0134, B:21:0x0144, B:22:0x014a, B:24:0x015c, B:25:0x0166, B:33:0x0080, B:35:0x008e, B:38:0x0097), top: B:7:0x0033 }] */
        /* JADX WARN: Removed duplicated region for block: B:32:0x004b  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0035  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object createShareLink(ShareLinkRequest shareLinkRequest, Continuation<? super HttpDataResult<ShareLinkData>> continuation) {
            IShareLinkApi$Companion$createShareLink$1 iShareLinkApi$Companion$createShareLink$1;
            int i;
            BizResponse bizResponse;
            try {
                if (continuation instanceof IShareLinkApi$Companion$createShareLink$1) {
                    iShareLinkApi$Companion$createShareLink$1 = (IShareLinkApi$Companion$createShareLink$1) continuation;
                    if ((iShareLinkApi$Companion$createShareLink$1.label & Integer.MIN_VALUE) != 0) {
                        iShareLinkApi$Companion$createShareLink$1.label -= Integer.MIN_VALUE;
                        Object obj = iShareLinkApi$Companion$createShareLink$1.result;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        i = iShareLinkApi$Companion$createShareLink$1.label;
                        if (i != 0) {
                            ResultKt.throwOnFailure(obj);
                            FLogger.INSTANCE.i("ShareLinkApi", "createShareLink request: chatSessionId=" + shareLinkRequest.getChatSessionId() + ", artifactPath=" + shareLinkRequest.getArtifactPath() + ", title=" + shareLinkRequest.getTitle());
                            ILoginService iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
                            String xTToken = iLoginService != null ? iLoginService.getXTToken() : null;
                            if (xTToken == null) {
                                xTToken = "";
                            }
                            IShareLinkApi iShareLinkApi = (IShareLinkApi) TraeHttpConnection.createService$default(TraeHttpConnection.INSTANCE, "share_link", IShareLinkApi.class, (Converter.Factory) null, HostResolver.INSTANCE.getBaseUrl(HostType.REMOTE), MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("authorization", "Cloud-IDE-JWT " + xTToken)}), false, 36, (Object) null);
                            iShareLinkApi$Companion$createShareLink$1.label = 1;
                            obj = iShareLinkApi.createShareLink(shareLinkRequest, iShareLinkApi$Companion$createShareLink$1);
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
                            FLogger.INSTANCE.e("ShareLinkApi", "createShareLink response is null");
                            return new HttpDataResult.Error(AccountErrorCode.CommonError.COMMON_ERROR_REQUEST_API, "BizResponse is null", new Exception("BizResponse is null"), (String) null, 8, (DefaultConstructorMarker) null);
                        }
                        FLogger fLogger = FLogger.INSTANCE;
                        StringBuilder append = new StringBuilder("createShareLink success: code=").append(bizResponse.getCode()).append(", msg=").append(bizResponse.getMsg()).append(", shareSessionId=");
                        ShareLinkData shareLinkData = (ShareLinkData) bizResponse.getData();
                        StringBuilder append2 = append.append(shareLinkData != null ? shareLinkData.getShareSessionId() : null).append(", title=");
                        ShareLinkData shareLinkData2 = (ShareLinkData) bizResponse.getData();
                        StringBuilder append3 = append2.append(shareLinkData2 != null ? shareLinkData2.getTitle() : null).append(", anonymous=");
                        ShareLinkData shareLinkData3 = (ShareLinkData) bizResponse.getData();
                        fLogger.i("ShareLinkApi", append3.append(shareLinkData3 != null ? Boxing.boxBoolean(shareLinkData3.getAnonymous()) : null).toString());
                        return new HttpDataResult.Success(new BizResponse(bizResponse.getCode(), bizResponse.getMsg(), (String) null, (String) null, bizResponse.getData(), (String) null, 44, (DefaultConstructorMarker) null), (Throwable) null);
                    }
                }
                if (i != 0) {
                }
                bizResponse = (BizResponse) obj;
                if (bizResponse != null) {
                }
            } catch (CancellationException e) {
                FLogger.INSTANCE.i("ShareLinkApi", "createShareLink cancelled");
                throw e;
            } catch (Throwable th) {
                FLogger.INSTANCE.e("ShareLinkApi", "createShareLink error: " + th.getClass().getName() + ": " + th.getMessage(), th);
                String message = th.getMessage();
                return new HttpDataResult.Error(-1000, message != null ? message : "", th, (String) null, 8, (DefaultConstructorMarker) null);
            }
            iShareLinkApi$Companion$createShareLink$1 = new IShareLinkApi$Companion$createShareLink$1(this, continuation);
            Object obj2 = iShareLinkApi$Companion$createShareLink$1.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            i = iShareLinkApi$Companion$createShareLink$1.label;
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x008f A[Catch: all -> 0x0034, CancellationException -> 0x0037, TryCatch #2 {CancellationException -> 0x0037, all -> 0x0034, blocks: (B:10:0x0030, B:11:0x008b, B:13:0x008f, B:16:0x00b2, B:18:0x00de, B:19:0x00e4, B:25:0x006b), top: B:7:0x002c }] */
        /* JADX WARN: Removed duplicated region for block: B:16:0x00b2 A[Catch: all -> 0x0034, CancellationException -> 0x0037, TryCatch #2 {CancellationException -> 0x0037, all -> 0x0034, blocks: (B:10:0x0030, B:11:0x008b, B:13:0x008f, B:16:0x00b2, B:18:0x00de, B:19:0x00e4, B:25:0x006b), top: B:7:0x002c }] */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0042  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x002e  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object createLocalShareLink(LocalShareLinkRequest localShareLinkRequest, Continuation<? super HttpDataResult<LocalShareLinkData>> continuation) {
            IShareLinkApi$Companion$createLocalShareLink$1 iShareLinkApi$Companion$createLocalShareLink$1;
            int i;
            BizResponse bizResponse;
            try {
                if (continuation instanceof IShareLinkApi$Companion$createLocalShareLink$1) {
                    iShareLinkApi$Companion$createLocalShareLink$1 = (IShareLinkApi$Companion$createLocalShareLink$1) continuation;
                    if ((iShareLinkApi$Companion$createLocalShareLink$1.label & Integer.MIN_VALUE) != 0) {
                        iShareLinkApi$Companion$createLocalShareLink$1.label -= Integer.MIN_VALUE;
                        Object obj = iShareLinkApi$Companion$createLocalShareLink$1.result;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        i = iShareLinkApi$Companion$createLocalShareLink$1.label;
                        if (i != 0) {
                            ResultKt.throwOnFailure(obj);
                            FLogger.INSTANCE.i("ShareLinkApi", "createLocalShareLink request: conversationId=" + localShareLinkRequest.getConversationId() + ", target=" + localShareLinkRequest.getTarget());
                            IShareLinkApi iShareLinkApi = (IShareLinkApi) TraeHttpConnection.createService$default(TraeHttpConnection.INSTANCE, "share_link_local", IShareLinkApi.class, (Converter.Factory) null, (String) null, (Map) null, false, 60, (Object) null);
                            iShareLinkApi$Companion$createLocalShareLink$1.label = 1;
                            obj = iShareLinkApi.createLocalShareLink(localShareLinkRequest, iShareLinkApi$Companion$createLocalShareLink$1);
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
                            FLogger.INSTANCE.e("ShareLinkApi", "createLocalShareLink response is null");
                            return new HttpDataResult.Error(AccountErrorCode.CommonError.COMMON_ERROR_REQUEST_API, "BizResponse is null", new Exception("BizResponse is null"), (String) null, 8, (DefaultConstructorMarker) null);
                        }
                        FLogger fLogger = FLogger.INSTANCE;
                        StringBuilder append = new StringBuilder("createLocalShareLink success: code=").append(bizResponse.getCode()).append(", msg=").append(bizResponse.getMsg()).append(", shareUrl=");
                        LocalShareLinkData localShareLinkData = (LocalShareLinkData) bizResponse.getData();
                        fLogger.i("ShareLinkApi", append.append(localShareLinkData != null ? localShareLinkData.getShareUrl() : null).toString());
                        return new HttpDataResult.Success(new BizResponse(bizResponse.getCode(), bizResponse.getMsg(), (String) null, (String) null, bizResponse.getData(), (String) null, 44, (DefaultConstructorMarker) null), (Throwable) null);
                    }
                }
                if (i != 0) {
                }
                bizResponse = (BizResponse) obj;
                if (bizResponse != null) {
                }
            } catch (CancellationException e) {
                FLogger.INSTANCE.i("ShareLinkApi", "createLocalShareLink cancelled");
                throw e;
            } catch (Throwable th) {
                FLogger.INSTANCE.e("ShareLinkApi", "createLocalShareLink error: " + th.getClass().getName() + ": " + th.getMessage(), th);
                String message = th.getMessage();
                if (message == null) {
                    message = "";
                }
                return new HttpDataResult.Error(-1000, message, th, (String) null, 8, (DefaultConstructorMarker) null);
            }
            iShareLinkApi$Companion$createLocalShareLink$1 = new IShareLinkApi$Companion$createLocalShareLink$1(this, continuation);
            Object obj2 = iShareLinkApi$Companion$createLocalShareLink$1.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            i = iShareLinkApi$Companion$createLocalShareLink$1.label;
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x008f A[Catch: all -> 0x0034, CancellationException -> 0x0037, TryCatch #2 {CancellationException -> 0x0037, all -> 0x0034, blocks: (B:10:0x0030, B:11:0x008b, B:13:0x008f, B:16:0x00b2, B:18:0x00de, B:19:0x00e4, B:25:0x006b), top: B:7:0x002c }] */
        /* JADX WARN: Removed duplicated region for block: B:16:0x00b2 A[Catch: all -> 0x0034, CancellationException -> 0x0037, TryCatch #2 {CancellationException -> 0x0037, all -> 0x0034, blocks: (B:10:0x0030, B:11:0x008b, B:13:0x008f, B:16:0x00b2, B:18:0x00de, B:19:0x00e4, B:25:0x006b), top: B:7:0x002c }] */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0042  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x002e  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object getLocalShareLink(GetLocalShareLinkRequest getLocalShareLinkRequest, Continuation<? super HttpDataResult<GetLocalShareLinkData>> continuation) {
            IShareLinkApi$Companion$getLocalShareLink$1 iShareLinkApi$Companion$getLocalShareLink$1;
            int i;
            BizResponse bizResponse;
            try {
                if (continuation instanceof IShareLinkApi$Companion$getLocalShareLink$1) {
                    iShareLinkApi$Companion$getLocalShareLink$1 = (IShareLinkApi$Companion$getLocalShareLink$1) continuation;
                    if ((iShareLinkApi$Companion$getLocalShareLink$1.label & Integer.MIN_VALUE) != 0) {
                        iShareLinkApi$Companion$getLocalShareLink$1.label -= Integer.MIN_VALUE;
                        Object obj = iShareLinkApi$Companion$getLocalShareLink$1.result;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        i = iShareLinkApi$Companion$getLocalShareLink$1.label;
                        if (i != 0) {
                            ResultKt.throwOnFailure(obj);
                            FLogger.INSTANCE.i("ShareLinkApi", "getLocalShareLink request: conversationId=" + getLocalShareLinkRequest.getConversationId() + ", target=" + getLocalShareLinkRequest.getTarget());
                            IShareLinkApi iShareLinkApi = (IShareLinkApi) TraeHttpConnection.createService$default(TraeHttpConnection.INSTANCE, "share_link_local_get", IShareLinkApi.class, (Converter.Factory) null, (String) null, (Map) null, false, 60, (Object) null);
                            iShareLinkApi$Companion$getLocalShareLink$1.label = 1;
                            obj = iShareLinkApi.getLocalShareLink(getLocalShareLinkRequest, iShareLinkApi$Companion$getLocalShareLink$1);
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
                            FLogger.INSTANCE.e("ShareLinkApi", "getLocalShareLink response is null");
                            return new HttpDataResult.Error(AccountErrorCode.CommonError.COMMON_ERROR_REQUEST_API, "BizResponse is null", new Exception("BizResponse is null"), (String) null, 8, (DefaultConstructorMarker) null);
                        }
                        FLogger fLogger = FLogger.INSTANCE;
                        StringBuilder append = new StringBuilder("getLocalShareLink success: code=").append(bizResponse.getCode()).append(", msg=").append(bizResponse.getMsg()).append(", shareId=");
                        GetLocalShareLinkData getLocalShareLinkData = (GetLocalShareLinkData) bizResponse.getData();
                        fLogger.i("ShareLinkApi", append.append(getLocalShareLinkData != null ? getLocalShareLinkData.getShareId() : null).append(',').toString());
                        return new HttpDataResult.Success(new BizResponse(bizResponse.getCode(), bizResponse.getMsg(), (String) null, (String) null, bizResponse.getData(), (String) null, 44, (DefaultConstructorMarker) null), (Throwable) null);
                    }
                }
                if (i != 0) {
                }
                bizResponse = (BizResponse) obj;
                if (bizResponse != null) {
                }
            } catch (CancellationException e) {
                FLogger.INSTANCE.i("ShareLinkApi", "getLocalShareLink cancelled");
                throw e;
            } catch (Throwable th) {
                FLogger.INSTANCE.e("ShareLinkApi", "getLocalShareLink error: " + th.getClass().getName() + ": " + th.getMessage(), th);
                String message = th.getMessage();
                if (message == null) {
                    message = "";
                }
                return new HttpDataResult.Error(-1000, message, th, (String) null, 8, (DefaultConstructorMarker) null);
            }
            iShareLinkApi$Companion$getLocalShareLink$1 = new IShareLinkApi$Companion$getLocalShareLink$1(this, continuation);
            Object obj2 = iShareLinkApi$Companion$getLocalShareLink$1.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            i = iShareLinkApi$Companion$getLocalShareLink$1.label;
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x00cb A[Catch: all -> 0x003e, CancellationException -> 0x0042, TryCatch #2 {CancellationException -> 0x0042, all -> 0x003e, blocks: (B:10:0x0039, B:11:0x00c7, B:13:0x00cb, B:16:0x00f1, B:18:0x011c, B:19:0x0122, B:21:0x0134, B:22:0x013a, B:29:0x006e, B:31:0x007c, B:34:0x0085), top: B:7:0x0035 }] */
        /* JADX WARN: Removed duplicated region for block: B:16:0x00f1 A[Catch: all -> 0x003e, CancellationException -> 0x0042, TryCatch #2 {CancellationException -> 0x0042, all -> 0x003e, blocks: (B:10:0x0039, B:11:0x00c7, B:13:0x00cb, B:16:0x00f1, B:18:0x011c, B:19:0x0122, B:21:0x0134, B:22:0x013a, B:29:0x006e, B:31:0x007c, B:34:0x0085), top: B:7:0x0035 }] */
        /* JADX WARN: Removed duplicated region for block: B:28:0x004d  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0037  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object getRemoteShareLink(String str, String str2, Continuation<? super HttpDataResult<ShareArtifactData>> continuation) {
            IShareLinkApi$Companion$getRemoteShareLink$1 iShareLinkApi$Companion$getRemoteShareLink$1;
            int i;
            BizResponse bizResponse;
            try {
                if (continuation instanceof IShareLinkApi$Companion$getRemoteShareLink$1) {
                    iShareLinkApi$Companion$getRemoteShareLink$1 = (IShareLinkApi$Companion$getRemoteShareLink$1) continuation;
                    if ((iShareLinkApi$Companion$getRemoteShareLink$1.label & Integer.MIN_VALUE) != 0) {
                        iShareLinkApi$Companion$getRemoteShareLink$1.label -= Integer.MIN_VALUE;
                        Object obj = iShareLinkApi$Companion$getRemoteShareLink$1.result;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        i = iShareLinkApi$Companion$getRemoteShareLink$1.label;
                        if (i != 0) {
                            ResultKt.throwOnFailure(obj);
                            FLogger.INSTANCE.i("ShareLinkApi", "getRemoteShareLink request: chatSessionId=" + str + ", artifactPath=" + str2);
                            ILoginService iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
                            String xTToken = iLoginService != null ? iLoginService.getXTToken() : null;
                            if (xTToken == null) {
                                xTToken = "";
                            }
                            IShareLinkApi iShareLinkApi = (IShareLinkApi) TraeHttpConnection.createService$default(TraeHttpConnection.INSTANCE, "share_link_remote_get", IShareLinkApi.class, (Converter.Factory) null, HostResolver.INSTANCE.getBaseUrl(HostType.REMOTE), MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("authorization", "Cloud-IDE-JWT " + xTToken)}), false, 36, (Object) null);
                            iShareLinkApi$Companion$getRemoteShareLink$1.label = 1;
                            obj = iShareLinkApi.getRemoteShareLink(str, str2, iShareLinkApi$Companion$getRemoteShareLink$1);
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
                            FLogger.INSTANCE.e("ShareLinkApi", "getRemoteShareLink response is null");
                            return new HttpDataResult.Error(AccountErrorCode.CommonError.COMMON_ERROR_REQUEST_API, "BizResponse is null", new Exception("BizResponse is null"), (String) null, 8, (DefaultConstructorMarker) null);
                        }
                        FLogger fLogger = FLogger.INSTANCE;
                        StringBuilder append = new StringBuilder("getRemoteShareLink success: code=").append(bizResponse.getCode()).append(", msg=").append(bizResponse.getMsg()).append(", shareSessionId=");
                        ShareArtifactData shareArtifactData = (ShareArtifactData) bizResponse.getData();
                        StringBuilder append2 = append.append(shareArtifactData != null ? shareArtifactData.getShareSessionId() : null).append(", status=");
                        ShareArtifactData shareArtifactData2 = (ShareArtifactData) bizResponse.getData();
                        fLogger.i("ShareLinkApi", append2.append(shareArtifactData2 != null ? shareArtifactData2.getStatus() : null).toString());
                        return new HttpDataResult.Success(new BizResponse(bizResponse.getCode(), bizResponse.getMsg(), (String) null, (String) null, bizResponse.getData(), (String) null, 44, (DefaultConstructorMarker) null), (Throwable) null);
                    }
                }
                if (i != 0) {
                }
                bizResponse = (BizResponse) obj;
                if (bizResponse != null) {
                }
            } catch (CancellationException e) {
                FLogger.INSTANCE.i("ShareLinkApi", "getRemoteShareLink cancelled");
                throw e;
            } catch (Throwable th) {
                FLogger.INSTANCE.e("ShareLinkApi", "getRemoteShareLink error: " + th.getClass().getName() + ": " + th.getMessage(), th);
                String message = th.getMessage();
                return new HttpDataResult.Error(-1000, message != null ? message : "", th, (String) null, 8, (DefaultConstructorMarker) null);
            }
            iShareLinkApi$Companion$getRemoteShareLink$1 = new IShareLinkApi$Companion$getRemoteShareLink$1(this, continuation);
            Object obj2 = iShareLinkApi$Companion$getRemoteShareLink$1.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            i = iShareLinkApi$Companion$getRemoteShareLink$1.label;
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x00d1 A[Catch: all -> 0x003f, CancellationException -> 0x0043, TryCatch #2 {CancellationException -> 0x0043, all -> 0x003f, blocks: (B:10:0x003a, B:11:0x00cd, B:13:0x00d1, B:16:0x00f8, B:18:0x0123, B:19:0x0129, B:21:0x0139, B:22:0x013f, B:29:0x0072, B:31:0x0080, B:34:0x0089), top: B:7:0x0036 }] */
        /* JADX WARN: Removed duplicated region for block: B:16:0x00f8 A[Catch: all -> 0x003f, CancellationException -> 0x0043, TryCatch #2 {CancellationException -> 0x0043, all -> 0x003f, blocks: (B:10:0x003a, B:11:0x00cd, B:13:0x00d1, B:16:0x00f8, B:18:0x0123, B:19:0x0129, B:21:0x0139, B:22:0x013f, B:29:0x0072, B:31:0x0080, B:34:0x0089), top: B:7:0x0036 }] */
        /* JADX WARN: Removed duplicated region for block: B:28:0x004e  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0038  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object updateShareLinkStatus(String str, UpdateShareLinkStatusRequest updateShareLinkStatusRequest, Continuation<? super HttpDataResult<UpdateShareLinkStatusData>> continuation) {
            IShareLinkApi$Companion$updateShareLinkStatus$1 iShareLinkApi$Companion$updateShareLinkStatus$1;
            int i;
            BizResponse bizResponse;
            try {
                if (continuation instanceof IShareLinkApi$Companion$updateShareLinkStatus$1) {
                    iShareLinkApi$Companion$updateShareLinkStatus$1 = (IShareLinkApi$Companion$updateShareLinkStatus$1) continuation;
                    if ((iShareLinkApi$Companion$updateShareLinkStatus$1.label & Integer.MIN_VALUE) != 0) {
                        iShareLinkApi$Companion$updateShareLinkStatus$1.label -= Integer.MIN_VALUE;
                        Object obj = iShareLinkApi$Companion$updateShareLinkStatus$1.result;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        i = iShareLinkApi$Companion$updateShareLinkStatus$1.label;
                        if (i != 0) {
                            ResultKt.throwOnFailure(obj);
                            FLogger.INSTANCE.i("ShareLinkApi", "updateShareLinkStatus request: shareSessionId=" + str + ", status=" + updateShareLinkStatusRequest.getStatus());
                            ILoginService iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
                            String xTToken = iLoginService != null ? iLoginService.getXTToken() : null;
                            if (xTToken == null) {
                                xTToken = "";
                            }
                            IShareLinkApi iShareLinkApi = (IShareLinkApi) TraeHttpConnection.createService$default(TraeHttpConnection.INSTANCE, "share_link_status", IShareLinkApi.class, (Converter.Factory) null, HostResolver.INSTANCE.getBaseUrl(HostType.REMOTE), MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("authorization", "Cloud-IDE-JWT " + xTToken)}), false, 36, (Object) null);
                            iShareLinkApi$Companion$updateShareLinkStatus$1.label = 1;
                            obj = iShareLinkApi.updateShareLinkStatus(str, updateShareLinkStatusRequest, iShareLinkApi$Companion$updateShareLinkStatus$1);
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
                            FLogger.INSTANCE.e("ShareLinkApi", "updateShareLinkStatus response is null");
                            return new HttpDataResult.Error(AccountErrorCode.CommonError.COMMON_ERROR_REQUEST_API, "BizResponse is null", new Exception("BizResponse is null"), (String) null, 8, (DefaultConstructorMarker) null);
                        }
                        FLogger fLogger = FLogger.INSTANCE;
                        StringBuilder append = new StringBuilder("updateShareLinkStatus success: code=").append(bizResponse.getCode()).append(", msg=").append(bizResponse.getMsg()).append(", shareSessionId=");
                        UpdateShareLinkStatusData updateShareLinkStatusData = (UpdateShareLinkStatusData) bizResponse.getData();
                        StringBuilder append2 = append.append(updateShareLinkStatusData != null ? updateShareLinkStatusData.getShareSessionId() : null).append(", status=");
                        UpdateShareLinkStatusData updateShareLinkStatusData2 = (UpdateShareLinkStatusData) bizResponse.getData();
                        fLogger.i("ShareLinkApi", append2.append(updateShareLinkStatusData2 != null ? updateShareLinkStatusData2.getStatus() : null).toString());
                        return new HttpDataResult.Success(new BizResponse(bizResponse.getCode(), bizResponse.getMsg(), (String) null, (String) null, bizResponse.getData(), (String) null, 44, (DefaultConstructorMarker) null), (Throwable) null);
                    }
                }
                if (i != 0) {
                }
                bizResponse = (BizResponse) obj;
                if (bizResponse != null) {
                }
            } catch (CancellationException e) {
                FLogger.INSTANCE.i("ShareLinkApi", "updateShareLinkStatus cancelled");
                throw e;
            } catch (Throwable th) {
                FLogger.INSTANCE.e("ShareLinkApi", "updateShareLinkStatus error: " + th.getClass().getName() + ": " + th.getMessage(), th);
                String message = th.getMessage();
                return new HttpDataResult.Error(-1000, message != null ? message : "", th, (String) null, 8, (DefaultConstructorMarker) null);
            }
            iShareLinkApi$Companion$updateShareLinkStatus$1 = new IShareLinkApi$Companion$updateShareLinkStatus$1(this, continuation);
            Object obj2 = iShareLinkApi$Companion$updateShareLinkStatus$1.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            i = iShareLinkApi$Companion$updateShareLinkStatus$1.label;
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x00a1 A[Catch: all -> 0x0039, CancellationException -> 0x003d, TryCatch #2 {CancellationException -> 0x003d, all -> 0x0039, blocks: (B:10:0x0035, B:11:0x009d, B:13:0x00a1, B:16:0x00c6, B:18:0x00f0, B:19:0x00f6, B:21:0x0106, B:22:0x010c, B:29:0x007c), top: B:7:0x0031 }] */
        /* JADX WARN: Removed duplicated region for block: B:16:0x00c6 A[Catch: all -> 0x0039, CancellationException -> 0x003d, TryCatch #2 {CancellationException -> 0x003d, all -> 0x0039, blocks: (B:10:0x0035, B:11:0x009d, B:13:0x00a1, B:16:0x00c6, B:18:0x00f0, B:19:0x00f6, B:21:0x0106, B:22:0x010c, B:29:0x007c), top: B:7:0x0031 }] */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0048  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0033  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object updateLocalShareLinkStatus(UpdateLocalShareLinkStatusRequest updateLocalShareLinkStatusRequest, Continuation<? super HttpDataResult<UpdateLocalShareLinkStatusData>> continuation) {
            IShareLinkApi$Companion$updateLocalShareLinkStatus$1 iShareLinkApi$Companion$updateLocalShareLinkStatus$1;
            int i;
            BizResponse bizResponse;
            try {
                if (continuation instanceof IShareLinkApi$Companion$updateLocalShareLinkStatus$1) {
                    iShareLinkApi$Companion$updateLocalShareLinkStatus$1 = (IShareLinkApi$Companion$updateLocalShareLinkStatus$1) continuation;
                    if ((iShareLinkApi$Companion$updateLocalShareLinkStatus$1.label & Integer.MIN_VALUE) != 0) {
                        iShareLinkApi$Companion$updateLocalShareLinkStatus$1.label -= Integer.MIN_VALUE;
                        Object obj = iShareLinkApi$Companion$updateLocalShareLinkStatus$1.result;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        i = iShareLinkApi$Companion$updateLocalShareLinkStatus$1.label;
                        if (i != 0) {
                            ResultKt.throwOnFailure(obj);
                            FLogger.INSTANCE.i("ShareLinkApi", "updateLocalShareLinkStatus request: conversationId=" + updateLocalShareLinkStatusRequest.getConversationId() + ", shareId=" + updateLocalShareLinkStatusRequest.getShareId() + ", status=" + updateLocalShareLinkStatusRequest.getStatus());
                            IShareLinkApi iShareLinkApi = (IShareLinkApi) TraeHttpConnection.createService$default(TraeHttpConnection.INSTANCE, "share_link_local_status", IShareLinkApi.class, (Converter.Factory) null, (String) null, (Map) null, false, 60, (Object) null);
                            iShareLinkApi$Companion$updateLocalShareLinkStatus$1.label = 1;
                            obj = iShareLinkApi.updateLocalShareLinkStatus(updateLocalShareLinkStatusRequest, iShareLinkApi$Companion$updateLocalShareLinkStatus$1);
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
                            FLogger.INSTANCE.e("ShareLinkApi", "updateLocalShareLinkStatus response is null");
                            return new HttpDataResult.Error(AccountErrorCode.CommonError.COMMON_ERROR_REQUEST_API, "BizResponse is null", new Exception("BizResponse is null"), (String) null, 8, (DefaultConstructorMarker) null);
                        }
                        FLogger fLogger = FLogger.INSTANCE;
                        StringBuilder append = new StringBuilder("updateLocalShareLinkStatus success: code=").append(bizResponse.getCode()).append(", msg=").append(bizResponse.getMsg()).append(", shareId=");
                        UpdateLocalShareLinkStatusData updateLocalShareLinkStatusData = (UpdateLocalShareLinkStatusData) bizResponse.getData();
                        StringBuilder append2 = append.append(updateLocalShareLinkStatusData != null ? updateLocalShareLinkStatusData.getShareId() : null).append(", status=");
                        UpdateLocalShareLinkStatusData updateLocalShareLinkStatusData2 = (UpdateLocalShareLinkStatusData) bizResponse.getData();
                        fLogger.i("ShareLinkApi", append2.append(updateLocalShareLinkStatusData2 != null ? updateLocalShareLinkStatusData2.getStatus() : null).toString());
                        return new HttpDataResult.Success(new BizResponse(bizResponse.getCode(), bizResponse.getMsg(), (String) null, (String) null, bizResponse.getData(), (String) null, 44, (DefaultConstructorMarker) null), (Throwable) null);
                    }
                }
                if (i != 0) {
                }
                bizResponse = (BizResponse) obj;
                if (bizResponse != null) {
                }
            } catch (CancellationException e) {
                FLogger.INSTANCE.i("ShareLinkApi", "updateLocalShareLinkStatus cancelled");
                throw e;
            } catch (Throwable th) {
                FLogger.INSTANCE.e("ShareLinkApi", "updateLocalShareLinkStatus error: " + th.getClass().getName() + ": " + th.getMessage(), th);
                String message = th.getMessage();
                if (message == null) {
                    message = "";
                }
                return new HttpDataResult.Error(-1000, message, th, (String) null, 8, (DefaultConstructorMarker) null);
            }
            iShareLinkApi$Companion$updateLocalShareLinkStatus$1 = new IShareLinkApi$Companion$updateLocalShareLinkStatus$1(this, continuation);
            Object obj2 = iShareLinkApi$Companion$updateLocalShareLinkStatus$1.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            i = iShareLinkApi$Companion$updateLocalShareLinkStatus$1.label;
        }
    }
}
