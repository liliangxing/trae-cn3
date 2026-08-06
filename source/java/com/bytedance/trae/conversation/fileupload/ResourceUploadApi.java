package com.bytedance.trae.conversation.fileupload;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* compiled from: ResourceUploadApi.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\tH¦@¢\u0006\u0002\u0010\nJ\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\rH¦@¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/trae/conversation/fileupload/ResourceUploadApi;", "", "getResourceUploadUrl", "Lcom/bytedance/trae/conversation/fileupload/GetResourceUploadUrlResponse;", "req", "Lcom/bytedance/trae/conversation/fileupload/GetResourceUploadUrlRequest;", "(Lcom/bytedance/trae/conversation/fileupload/GetResourceUploadUrlRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "commitResourceUploadResult", "", "Lcom/bytedance/trae/conversation/fileupload/CommitResourceUploadResultRequest;", "(Lcom/bytedance/trae/conversation/fileupload/CommitResourceUploadResultRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getResourceUrl", "Lcom/bytedance/trae/conversation/fileupload/GetResourceUrlResponse;", "Lcom/bytedance/trae/conversation/fileupload/GetResourceUrlRequest;", "(Lcom/bytedance/trae/conversation/fileupload/GetResourceUrlRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public interface ResourceUploadApi {
    Object commitResourceUploadResult(CommitResourceUploadResultRequest commitResourceUploadResultRequest, Continuation<? super Unit> continuation);

    Object getResourceUploadUrl(GetResourceUploadUrlRequest getResourceUploadUrlRequest, Continuation<? super GetResourceUploadUrlResponse> continuation);

    Object getResourceUrl(GetResourceUrlRequest getResourceUrlRequest, Continuation<? super GetResourceUrlResponse> continuation);
}
