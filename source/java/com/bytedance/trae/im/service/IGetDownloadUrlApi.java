package com.bytedance.trae.im.service;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.ExtraInfo;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.sdk.account.api.OauthTokenTriggerScene;
import com.bytedance.trae.im.service.IGetDownloadUrlApi;
import com.bytedance.trae.network.DebugSettings;
import com.bytedance.trae.network.TraeHttpConnection;
import com.bytedance.trae.network.response.BizResponse;
import com.bytedance.trae.network.response.HttpDataResult;
import com.bytedance.ttnet.http.RequestContext;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IGetDownloadUrlApi.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u0000 \f2\u00020\u0001:\u0001\fJ\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u0007J&\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t2\b\b\u0001\u0010\u0005\u001a\u00020\u00062\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u0001H'¨\u0006\r"}, d2 = {"Lcom/bytedance/trae/im/service/IGetDownloadUrlApi;", "", "getDownloadUrl", "Lcom/bytedance/trae/network/response/BizResponse;", "Lcom/bytedance/trae/im/service/GetDownloadUrlData;", OauthTokenTriggerScene.REQUEST, "Lcom/bytedance/trae/im/service/GetDownloadUrlRequest;", "(Lcom/bytedance/trae/im/service/GetDownloadUrlRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDownloadUrlRaw", "Lcom/bytedance/retrofit2/Call;", "", "extraInfo", "Companion", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public interface IGetDownloadUrlApi {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @POST("api/solo_hub/v1/conversations/artifact/get_download_url")
    Object getDownloadUrl(@Body GetDownloadUrlRequest getDownloadUrlRequest, Continuation<? super BizResponse<GetDownloadUrlData>> continuation);

    @POST("api/solo_hub/v1/conversations/artifact/get_download_url")
    Call<String> getDownloadUrlRaw(@Body GetDownloadUrlRequest request, @ExtraInfo Object extraInfo);

    /* compiled from: IGetDownloadUrlApi.kt */
    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JK\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\r\"\u0004\b\u0000\u0010\u000e2/\u0010\u000f\u001a+\b\u0001\u0012\u0004\u0012\u00020\u0011\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\u000e\u0018\u00010\u00130\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0010¢\u0006\u0002\b\u0014H\u0086@¢\u0006\u0002\u0010\u0015J\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\r2\u0006\u0010\u0018\u001a\u00020\u0019H\u0086@¢\u0006\u0002\u0010\u001aR \u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/bytedance/trae/im/service/IGetDownloadUrlApi$Companion;", "", "<init>", "()V", "DEFAULT_HEADERS", "", "", "getDEFAULT_HEADERS", "()Ljava/util/Map;", "SUCCESS_CODES", "", "", "safeCall", "Lcom/bytedance/trae/network/response/HttpDataResult;", "T", "call", "Lkotlin/Function2;", "Lcom/bytedance/trae/im/service/IGetDownloadUrlApi;", "Lkotlin/coroutines/Continuation;", "Lcom/bytedance/trae/network/response/BizResponse;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDownloadUrlRawCall", "Lcom/bytedance/trae/im/service/GetDownloadUrlData;", OauthTokenTriggerScene.REQUEST, "Lcom/bytedance/trae/im/service/GetDownloadUrlRequest;", "(Lcom/bytedance/trae/im/service/GetDownloadUrlRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final Set<Long> SUCCESS_CODES = SetsKt.setOf(200L);

        private Companion() {
        }

        private final Map<String, String> getDEFAULT_HEADERS() {
            return DebugSettings.buildDefaultHeaders$default(DebugSettings.INSTANCE, (Map) null, 1, (Object) null);
        }

        public final <T> Object safeCall(Function2<? super IGetDownloadUrlApi, ? super Continuation<? super BizResponse<T>>, ? extends Object> function2, Continuation<? super HttpDataResult<? extends T>> continuation) {
            return TraeHttpConnection.safeCall$default(TraeHttpConnection.INSTANCE, "download_url", IGetDownloadUrlApi.class, getDEFAULT_HEADERS(), function2, (String) null, (Set) null, continuation, 48, (Object) null);
        }

        public final Object getDownloadUrlRawCall(final GetDownloadUrlRequest getDownloadUrlRequest, Continuation<? super HttpDataResult<GetDownloadUrlData>> continuation) {
            return TraeHttpConnection.rawBizCall$default(TraeHttpConnection.INSTANCE, "download_url", IGetDownloadUrlApi.class, GetDownloadUrlData.class, (String) null, (String) null, getDEFAULT_HEADERS(), true, SUCCESS_CODES, false, new Function2() { // from class: com.bytedance.trae.im.service.IGetDownloadUrlApi$Companion$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Call downloadUrlRawCall$lambda$0;
                    downloadUrlRawCall$lambda$0 = IGetDownloadUrlApi.Companion.getDownloadUrlRawCall$lambda$0(GetDownloadUrlRequest.this, (IGetDownloadUrlApi) obj, (RequestContext) obj2);
                    return downloadUrlRawCall$lambda$0;
                }
            }, continuation, 280, (Object) null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Call getDownloadUrlRawCall$lambda$0(GetDownloadUrlRequest getDownloadUrlRequest, IGetDownloadUrlApi iGetDownloadUrlApi, RequestContext requestContext) {
            Intrinsics.checkNotNullParameter(iGetDownloadUrlApi, "$this$rawBizCall");
            Intrinsics.checkNotNullParameter(requestContext, "requestContext");
            return iGetDownloadUrlApi.getDownloadUrlRaw(getDownloadUrlRequest, requestContext);
        }
    }
}
