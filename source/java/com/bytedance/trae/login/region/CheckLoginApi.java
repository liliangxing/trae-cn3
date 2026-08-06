package com.bytedance.trae.login.region;

import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.sdk.account.api.OauthTokenTriggerScene;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* compiled from: CheckLoginApi.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/login/region/CheckLoginApi;", "", "checkLogin", "Lcom/bytedance/retrofit2/SsResponse;", "", OauthTokenTriggerScene.REQUEST, "Lcom/bytedance/trae/login/region/CheckLoginRequest;", "(Lcom/bytedance/trae/login/region/CheckLoginRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface CheckLoginApi {
    @POST("/cloudide/api/v3/trae/CheckLogin")
    Object checkLogin(@Body CheckLoginRequest checkLoginRequest, Continuation<? super SsResponse<String>> continuation);
}
