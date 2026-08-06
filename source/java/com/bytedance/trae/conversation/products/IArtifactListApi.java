package com.bytedance.trae.conversation.products;

import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Path;
import com.bytedance.retrofit2.http.Query;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* compiled from: IArtifactListApi.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0006\u001a\u00020\u0004H§@¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/conversation/products/IArtifactListApi;", "", "getArtifactList", "Lcom/bytedance/retrofit2/SsResponse;", "", "fileName", "chatSessionId", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface IArtifactListApi {
    @GET("diffview/{file_name}")
    Object getArtifactList(@Path("file_name") String str, @Query("chat_session_id") String str2, Continuation<? super SsResponse<String>> continuation);
}
