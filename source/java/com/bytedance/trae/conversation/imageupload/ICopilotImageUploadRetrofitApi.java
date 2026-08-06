package com.bytedance.trae.conversation.imageupload;

import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.POST;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;

/* compiled from: ImageUploadApi.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0014\b\u0003\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005H§@¢\u0006\u0002\u0010\u0007J\u0018\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\u0004\u001a\u00020\nH§@¢\u0006\u0002\u0010\u000bJ\u0018\u0010\f\u001a\u00020\r2\b\b\u0001\u0010\u0004\u001a\u00020\u000eH§@¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/trae/conversation/imageupload/ICopilotImageUploadRetrofitApi;", "", "getResourceUploadToken", "Lcom/bytedance/trae/conversation/imageupload/StsTokenResponse;", "body", "", "", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getResourceUrl", "Lcom/bytedance/trae/conversation/imageupload/GetResourceUrlResponse;", "Lcom/bytedance/trae/conversation/imageupload/GetResourceUrlRequest;", "(Lcom/bytedance/trae/conversation/imageupload/GetResourceUrlRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkContent", "Lcom/bytedance/trae/conversation/imageupload/CheckContentResponse;", "Lcom/bytedance/trae/conversation/imageupload/CheckContentRequest;", "(Lcom/bytedance/trae/conversation/imageupload/CheckContentRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public interface ICopilotImageUploadRetrofitApi {
    @POST("api/ide/v1/check_content")
    Object checkContent(@Body CheckContentRequest checkContentRequest, Continuation<? super CheckContentResponse> continuation);

    @POST("api/ide/v1/get_resource_upload_token")
    Object getResourceUploadToken(@Body Map<String, String> map, Continuation<? super StsTokenResponse> continuation);

    @POST("api/ide/v1/get_resource_url")
    Object getResourceUrl(@Body GetResourceUrlRequest getResourceUrlRequest, Continuation<? super GetResourceUrlResponse> continuation);

    /* compiled from: ImageUploadApi.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Object getResourceUploadToken$default(ICopilotImageUploadRetrofitApi iCopilotImageUploadRetrofitApi, Map map, Continuation continuation, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getResourceUploadToken");
            }
            if ((i & 1) != 0) {
                map = MapsKt.emptyMap();
            }
            return iCopilotImageUploadRetrofitApi.getResourceUploadToken(map, continuation);
        }
    }
}
