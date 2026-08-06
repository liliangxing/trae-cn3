package com.bytedance.trae.login.user;

import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.http.GET;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* compiled from: BytecloudUserInfoApi.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003H§@¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/login/user/BytecloudUserInfoApi;", "", "getBytecloudUserInfo", "Lcom/bytedance/retrofit2/SsResponse;", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface BytecloudUserInfoApi {
    @GET("/cloudide/api/v3/trae/GetBytecloudUserInfo")
    Object getBytecloudUserInfo(Continuation<? super SsResponse<String>> continuation);
}
