package com.bytedance.trae.login.enterprise;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.ExtraInfo;
import com.bytedance.retrofit2.http.POST;
import kotlin.Metadata;

/* compiled from: EnterpriseAuthApi.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0001H'J&\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\t2\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0001H'J&\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u000b2\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0001H'J&\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\r2\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0001H'J&\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u000f2\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0001H'J&\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00112\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0001H'J&\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00132\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0001H'J&\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00152\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0001H'J\u001c\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0001H'¨\u0006\u0017"}, d2 = {"Lcom/bytedance/trae/login/enterprise/EnterpriseAuthApi;", "", "accountLogin", "Lcom/bytedance/retrofit2/Call;", "", "request", "Lcom/bytedance/trae/login/enterprise/EnterpriseAccountLoginRequest;", "extraInfo", "checkLoginConfig", "Lcom/bytedance/trae/login/enterprise/CheckLoginConfigRequest;", "getRefreshToken", "Lcom/bytedance/trae/login/enterprise/EnterpriseGetRefreshTokenRequest;", "exchangeToken", "Lcom/bytedance/trae/login/enterprise/EnterpriseExchangeTokenRequest;", "sendEmailVerification", "Lcom/bytedance/trae/login/enterprise/SendEmailVerificationRequest;", "getCodeInfo", "Lcom/bytedance/trae/login/enterprise/GetCodeInfoRequest;", "setUserPassword", "Lcom/bytedance/trae/login/enterprise/SetUserPasswordRequest;", "setUserInfo", "Lcom/bytedance/trae/login/enterprise/SetUserInfoRequest;", "getUserInfo", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public interface EnterpriseAuthApi {
    @POST("/trae/gtm/tob/api/v1/account/login")
    Call<String> accountLogin(@Body EnterpriseAccountLoginRequest request, @ExtraInfo Object extraInfo);

    @POST("/trae/gtm/tob/api/v1/account/check_login_config")
    Call<String> checkLoginConfig(@Body CheckLoginConfigRequest request, @ExtraInfo Object extraInfo);

    @POST("/cloudide/api/v3/trae/oauth/ExchangeToken")
    Call<String> exchangeToken(@Body EnterpriseExchangeTokenRequest request, @ExtraInfo Object extraInfo);

    @POST("/trae/gtm/tob/api/v1/account/get_code_info")
    Call<String> getCodeInfo(@Body GetCodeInfoRequest request, @ExtraInfo Object extraInfo);

    @POST("/cloudide/api/v3/trae/oauth/GetRefreshToken")
    Call<String> getRefreshToken(@Body EnterpriseGetRefreshTokenRequest request, @ExtraInfo Object extraInfo);

    @POST("/cloudide/api/v3/trae/GetUserInfo")
    Call<String> getUserInfo(@ExtraInfo Object extraInfo);

    @POST("/trae/gtm/tob/api/v1/account/send_email_verification")
    Call<String> sendEmailVerification(@Body SendEmailVerificationRequest request, @ExtraInfo Object extraInfo);

    @POST("/trae/gtm/tob/api/v1/account/set_user_info")
    Call<String> setUserInfo(@Body SetUserInfoRequest request, @ExtraInfo Object extraInfo);

    @POST("/trae/gtm/tob/api/v1/account/set_user_password")
    Call<String> setUserPassword(@Body SetUserPasswordRequest request, @ExtraInfo Object extraInfo);
}
