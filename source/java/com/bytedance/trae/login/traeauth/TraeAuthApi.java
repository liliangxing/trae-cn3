package com.bytedance.trae.login.traeauth;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.ExtraInfo;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Query;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* compiled from: TraeAuthApi.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J.\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0004H§@¢\u0006\u0002\u0010\bJ\"\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\b\b\u0001\u0010\u0005\u001a\u00020\nH§@¢\u0006\u0002\u0010\u000bJ&\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\r2\b\b\u0001\u0010\u0005\u001a\u00020\n2\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u0001H'J&\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\r2\b\b\u0001\u0010\u0005\u001a\u00020\u00102\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u0001H'J&\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\r2\b\b\u0001\u0010\u0005\u001a\u00020\u00122\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u0001H'J&\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\r2\b\b\u0001\u0010\u0005\u001a\u00020\u00142\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u0001H'J\"\u0010\u0015\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0016H§@¢\u0006\u0002\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/bytedance/trae/login/traeauth/TraeAuthApi;", "", "login", "Lcom/bytedance/retrofit2/SsResponse;", "", "request", "Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;", "type", "(Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRefreshToken", "Lcom/bytedance/trae/login/traeauth/TraeGetRefreshTokenRequest;", "(Lcom/bytedance/trae/login/traeauth/TraeGetRefreshTokenRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRefreshTokenRaw", "Lcom/bytedance/retrofit2/Call;", "extraInfo", "exchangeTokenRaw", "Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenRequest;", "listDevicesRaw", "Lcom/bytedance/trae/login/traeauth/ListDevicesRequest;", "bindDeviceRaw", "Lcom/bytedance/trae/login/traeauth/BindDeviceRequest;", "clearRefreshToken", "Lcom/bytedance/trae/login/traeauth/ClearRefreshTokenRequest;", "(Lcom/bytedance/trae/login/traeauth/ClearRefreshTokenRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public interface TraeAuthApi {
    @POST("/cloudide/api/v3/trae/oauth/BindDevice")
    Call<String> bindDeviceRaw(@Body BindDeviceRequest request, @ExtraInfo Object extraInfo);

    @POST("/trae/api/v3/oauth/ClearRefreshToken")
    Object clearRefreshToken(@Body ClearRefreshTokenRequest clearRefreshTokenRequest, Continuation<? super SsResponse<String>> continuation);

    @POST("/trae/api/v3/oauth/ExchangeToken")
    Call<String> exchangeTokenRaw(@Body TraeExchangeTokenRequest request, @ExtraInfo Object extraInfo);

    @POST("/trae/api/v3/oauth/GetRefreshToken")
    Object getRefreshToken(@Body TraeGetRefreshTokenRequest traeGetRefreshTokenRequest, Continuation<? super SsResponse<String>> continuation);

    @POST("/trae/api/v3/oauth/GetRefreshToken")
    Call<String> getRefreshTokenRaw(@Body TraeGetRefreshTokenRequest request, @ExtraInfo Object extraInfo);

    @POST("/cloudide/api/v3/trae/oauth/ListDevices")
    Call<String> listDevicesRaw(@Body ListDevicesRequest request, @ExtraInfo Object extraInfo);

    @POST("/cloudide/api/v3/trae/Login")
    Object login(@Body TraeLoginRequest traeLoginRequest, @Query("type") String str, Continuation<? super SsResponse<String>> continuation);

    /* compiled from: TraeAuthApi.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ Object login$default(TraeAuthApi traeAuthApi, TraeLoginRequest traeLoginRequest, String str, Continuation continuation, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: login");
            }
            if ((i & 2) != 0) {
                str = null;
            }
            return traeAuthApi.login(traeLoginRequest, str, continuation);
        }
    }
}
