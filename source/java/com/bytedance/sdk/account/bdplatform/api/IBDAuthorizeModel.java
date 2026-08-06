package com.bytedance.sdk.account.bdplatform.api;

import com.bytedance.sdk.account.bdplatform.model.AuthCodeResponse;
import com.bytedance.sdk.account.bdplatform.model.AuthInfoResponse;
import com.bytedance.sdk.account.bdplatform.model.AuthInfoResponseV2;
import com.bytedance.sdk.account.bdplatform.model.CommonResponse;
import com.bytedance.sdk.account.bdplatform.model.TicketResponse;
import com.bytedance.sdk.account.common.model.SendAuth;
import java.util.Map;

/* loaded from: classes5.dex */
public interface IBDAuthorizeModel {
    CommonResponse requestCommonInfo(SendAuth.Request request, String str, String str2, Map<String, String> map);

    AuthCodeResponse requestGetAuthCode(SendAuth.Request request, String str);

    AuthCodeResponse requestGetAuthCode(SendAuth.Request request, String str, String str2, String str3, String str4, Map<String, String> map);

    AuthCodeResponse requestGetAuthCode(SendAuth.Request request, String str, String str2, Map<String, String> map);

    AuthCodeResponse requestGetAuthCode(SendAuth.Request request, String str, Map<String, String> map);

    AuthCodeResponse requestGetAuthCodeV2(SendAuth.Request request, String str, String str2, String str3, Map<String, String> map);

    AuthInfoResponse requestGetAuthInfo(SendAuth.Request request, String str);

    AuthInfoResponse requestGetAuthInfo(SendAuth.Request request, String str, String str2, String str3, String str4, Map<String, String> map);

    AuthInfoResponse requestGetAuthInfo(SendAuth.Request request, String str, String str2, Map<String, String> map);

    AuthInfoResponse requestGetAuthInfo(SendAuth.Request request, String str, Map<String, String> map);

    AuthInfoResponseV2 requestGetAuthInfoV2(SendAuth.Request request, String str, String str2, String str3, Map<String, String> map);

    TicketResponse requestGetTicket(SendAuth.Request request);

    TicketResponse requestGetTicket(SendAuth.Request request, String str, String str2, String str3, Map<String, String> map);

    TicketResponse requestGetTicket(SendAuth.Request request, String str, Map<String, String> map);

    TicketResponse requestGetTicket(SendAuth.Request request, Map<String, String> map);
}
