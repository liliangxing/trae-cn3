package com.bytedance.trae.im.service.tenant;

import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.sdk.account.api.OauthTokenTriggerScene;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* compiled from: TenantUserConfigRepository.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J3\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\u0019\b\u0001\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\t\u0012\u00070\u0001¢\u0006\u0002\b\u00070\u0006H§@¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/trae/im/service/tenant/ITenantUserConfigApi;", "", "getTenantUserConfig", "Lcom/bytedance/retrofit2/SsResponse;", "", OauthTokenTriggerScene.REQUEST, "", "Lkotlin/jvm/JvmSuppressWildcards;", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface ITenantUserConfigApi {
    @POST("api/ide/v1/tenant/get_tenant_user_config")
    Object getTenantUserConfig(@Body Map<String, Object> map, Continuation<? super SsResponse<String>> continuation);
}
