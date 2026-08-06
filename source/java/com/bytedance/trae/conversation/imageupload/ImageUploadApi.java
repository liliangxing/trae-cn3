package com.bytedance.trae.conversation.imageupload;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* compiled from: ImageUploadApi.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0006J(\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\nH¦@¢\u0006\u0002\u0010\u000bJ\u0018\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/bytedance/trae/conversation/imageupload/ImageUploadApi;", "", "getStsToken", "Lcom/bytedance/trae/conversation/imageupload/StsTokenResponse;", "userId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getImageUrls", "", "tosUris", "", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkImageContent", "Lcom/bytedance/trae/conversation/imageupload/ContentCheckResult;", "uri", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface ImageUploadApi {

    /* compiled from: ImageUploadApi.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class DefaultImpls {
        public static Object checkImageContent(ImageUploadApi imageUploadApi, String str, Continuation<? super ContentCheckResult> continuation) {
            return null;
        }
    }

    Object checkImageContent(String str, Continuation<? super ContentCheckResult> continuation);

    Object getImageUrls(List<String> list, Continuation<? super Map<String, String>> continuation);

    Object getStsToken(String str, Continuation<? super StsTokenResponse> continuation);
}
