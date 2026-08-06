package com.bytedance.trae.login.bytecloud;

import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Query;
import com.bytedance.trae.network.response.BizResponse;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* compiled from: IEnableSsoApi.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/trae/login/bytecloud/IEnableSsoApi;", "", "checkEnableSso", "Lcom/bytedance/trae/network/response/BizResponse;", "Lcom/bytedance/trae/login/bytecloud/EnableSsoData;", "platform", "", "version", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface IEnableSsoApi {
    @GET("api/solo_hub/v1/config/enable_sso")
    Object checkEnableSso(@Query("platform") String str, @Query("version") String str2, Continuation<? super BizResponse<EnableSsoData>> continuation);
}
