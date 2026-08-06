package com.bytedance.trae.conversation.fileupload;

import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.POST;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* compiled from: ResourceUploadApi.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\u0004\u001a\u00020\tH§@¢\u0006\u0002\u0010\nJ\u0018\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\u0004\u001a\u00020\rH§@¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/trae/conversation/fileupload/ICopilotResourceUploadRetrofitApi;", "", "getResourceUploadUrl", "Lcom/bytedance/trae/conversation/fileupload/GetResourceUploadUrlResponse;", "body", "Lcom/bytedance/trae/conversation/fileupload/GetResourceUploadUrlRequest;", "(Lcom/bytedance/trae/conversation/fileupload/GetResourceUploadUrlRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "commitResourceUploadResult", "Lcom/bytedance/trae/conversation/fileupload/CommitResourceUploadResultResponse;", "Lcom/bytedance/trae/conversation/fileupload/CommitResourceUploadResultRequest;", "(Lcom/bytedance/trae/conversation/fileupload/CommitResourceUploadResultRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getResourceUrl", "Lcom/bytedance/trae/conversation/fileupload/GetResourceUrlResponse;", "Lcom/bytedance/trae/conversation/fileupload/GetResourceUrlRequest;", "(Lcom/bytedance/trae/conversation/fileupload/GetResourceUrlRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public interface ICopilotResourceUploadRetrofitApi {
    @POST("api/ide/v1/commit_resource_upload_result")
    Object commitResourceUploadResult(@Body CommitResourceUploadResultRequest commitResourceUploadResultRequest, Continuation<? super CommitResourceUploadResultResponse> continuation);

    @POST("api/ide/v1/get_resource_upload_url")
    Object getResourceUploadUrl(@Body GetResourceUploadUrlRequest getResourceUploadUrlRequest, Continuation<? super GetResourceUploadUrlResponse> continuation);

    @POST("api/ide/v1/get_resource_url")
    Object getResourceUrl(@Body GetResourceUrlRequest getResourceUrlRequest, Continuation<? super GetResourceUrlResponse> continuation);
}
