package com.bytedance.sdk.account.bdplatform.impl.send;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.account.bdplatform.api.BDAuthorizePlatformDepend;
import com.bytedance.sdk.account.bdplatform.coreapi.BDAuthorizeContact;
import com.bytedance.sdk.account.bdplatform.model.AuthCodeResponse;
import com.bytedance.sdk.account.bdplatform.model.AuthInfoResponse;
import com.bytedance.sdk.account.bdplatform.model.AuthInfoResponseV2;
import com.bytedance.sdk.account.bdplatform.model.BDPlatformConstants;
import com.bytedance.sdk.account.bdplatform.model.CommonResponse;
import com.bytedance.sdk.account.bdplatform.model.TicketResponse;
import com.bytedance.sdk.account.bdplatform.utils.NetUtils;
import com.bytedance.sdk.account.common.model.SendAuth;
import com.bytedance.sdk.account.common.utils.Md5Utils;
import com.bytedance.sdk.account.common.utils.SignatureUtils;
import com.bytedance.sdk.account.platform.core.C0047R;
import com.bytedance.timonbase.pipeline.TimonPipeline;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class BDAuthorizeModel implements BDAuthorizeContact.Model {
    public static final String AUTH_CODE_PATH = "/oauth/authorize/";
    private static final String AUTH_CODE_PATH_V2 = "/passport/open/auth/";
    public static final String AUTH_INFO_PATH = "/oauth/auth_info/";
    private static final String AUTH_INFO_PATH_V2 = "/passport/open/auth_info/v2/";
    public static final String GET_TICKET = "/passport/open/authorize/ticket/";
    private final Context context;
    BDAuthorizePlatformDepend depend;

    public BDAuthorizeModel(Context context, BDAuthorizePlatformDepend bDAuthorizePlatformDepend) {
        this.depend = bDAuthorizePlatformDepend;
        this.context = context;
    }

    @Override // com.bytedance.sdk.account.bdplatform.api.IBDAuthorizeModel
    public AuthInfoResponse requestGetAuthInfo(SendAuth.Request request, String str) {
        return requestGetAuthInfo(request, str, null);
    }

    @Override // com.bytedance.sdk.account.bdplatform.api.IBDAuthorizeModel
    public AuthInfoResponse requestGetAuthInfo(SendAuth.Request request, String str, Map<String, String> map) {
        return requestGetAuthInfo(request, null, str, this.depend.authHost(), AUTH_INFO_PATH, map);
    }

    @Override // com.bytedance.sdk.account.bdplatform.api.IBDAuthorizeModel
    public AuthInfoResponse requestGetAuthInfo(SendAuth.Request request, String str, String str2, Map<String, String> map) {
        return requestGetAuthInfo(request, str, str2, this.depend.authHost(), AUTH_INFO_PATH, map);
    }

    @Override // com.bytedance.sdk.account.bdplatform.api.IBDAuthorizeModel
    public AuthInfoResponse requestGetAuthInfo(SendAuth.Request request, String str, String str2, String str3, String str4, Map<String, String> map) {
        AuthInfoResponse authInfoResponse;
        int i;
        String str5;
        if (TextUtils.isEmpty(str)) {
            str = BDApiDataParser.getScope(request);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("client_key", request.getClientKey());
        hashMap.put("scope", str);
        hashMap.put("ticket", str2);
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
        }
        try {
            authInfoResponse = BDApiDataParser.parseAuthInfo(this.depend.executePost(new Uri.Builder().scheme("https").authority(str3).path(str4).build().toString(), hashMap));
        } catch (Throwable th) {
            th.printStackTrace();
            AuthInfoResponse authInfoResponse2 = new AuthInfoResponse();
            authInfoResponse2.errorCode = NetUtils.checkApiException(this.depend, th);
            authInfoResponse = authInfoResponse2;
        }
        String str6 = "fail";
        if (authInfoResponse == null) {
            str5 = this.context.getString(C0047R.string.bd_platform_error_tips_common);
            i = -1;
        } else if (authInfoResponse.success) {
            i = 0;
            str5 = "";
            str6 = "success";
        } else {
            i = authInfoResponse.errorCode;
            str5 = authInfoResponse.errorMessage;
        }
        onEvent(BDPlatformConstants.EventName.EVENT_PLATFORM_AUTH_INFO, getResultData(request, str6, i, str5));
        return authInfoResponse;
    }

    @Override // com.bytedance.sdk.account.bdplatform.api.IBDAuthorizeModel
    public AuthInfoResponseV2 requestGetAuthInfoV2(SendAuth.Request request, String str, String str2, String str3, Map<String, String> map) {
        AuthInfoResponseV2 authInfoResponseV2;
        int i;
        String str4;
        if (TextUtils.isEmpty(str)) {
            str = BDApiDataParser.getScope(request);
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = this.depend.authHost();
        }
        if (TextUtils.isEmpty(str3)) {
            str3 = AUTH_INFO_PATH_V2;
        }
        Uri.Builder appendQueryParameter = new Uri.Builder().scheme("https").authority(str2).path(str3).appendQueryParameter("client_key", request.getClientKey()).appendQueryParameter("scope", str);
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (!TextUtils.isEmpty(entry.getKey()) && !TextUtils.isEmpty(entry.getValue())) {
                    appendQueryParameter.appendQueryParameter(entry.getKey(), entry.getValue());
                }
            }
        }
        try {
            authInfoResponseV2 = BDApiDataParser.parseAuthInfoV2(this.depend.executeGet(appendQueryParameter.build().toString()));
        } catch (Throwable th) {
            th.printStackTrace();
            AuthInfoResponseV2 authInfoResponseV22 = new AuthInfoResponseV2();
            authInfoResponseV22.errorCode = NetUtils.checkApiException(this.depend, th);
            authInfoResponseV2 = authInfoResponseV22;
        }
        String str5 = "fail";
        if (authInfoResponseV2 == null) {
            str4 = this.context.getString(C0047R.string.bd_platform_error_tips_common);
            i = -1;
        } else if (authInfoResponseV2.success) {
            i = 0;
            str4 = "";
            str5 = "success";
        } else {
            i = authInfoResponseV2.errorCode;
            str4 = authInfoResponseV2.errorMessage;
        }
        onEvent(BDPlatformConstants.EventName.EVENT_PLATFORM_AUTH_INFO, getResultData(request, str5, i, str4));
        return authInfoResponseV2;
    }

    @Override // com.bytedance.sdk.account.bdplatform.api.IBDAuthorizeModel
    public CommonResponse requestCommonInfo(SendAuth.Request request, String str, String str2, Map<String, String> map) {
        int i;
        String str3;
        String str4;
        Uri build = new Uri.Builder().scheme("https").authority(str).path(str2).build();
        CommonResponse commonResponse = new CommonResponse();
        try {
            BDApiDataParser.parseCommon(commonResponse, this.depend.executePost(build.toString(), map));
        } catch (Throwable th) {
            th.printStackTrace();
            commonResponse = new AuthInfoResponse();
            commonResponse.errorCode = NetUtils.checkApiException(this.depend, th);
        }
        if (commonResponse.success) {
            i = 0;
            str3 = "";
            str4 = "success";
        } else {
            i = commonResponse.errorCode;
            str3 = commonResponse.errorMessage;
            str4 = "fail";
        }
        onEvent(BDPlatformConstants.EventName.EVENT_PLATFORM_AUTH_INFO, getResultData(request, str4, i, str3));
        return commonResponse;
    }

    @Override // com.bytedance.sdk.account.bdplatform.api.IBDAuthorizeModel
    public TicketResponse requestGetTicket(SendAuth.Request request) {
        return requestGetTicket(request, null, this.depend.ticketHost(), GET_TICKET, null);
    }

    @Override // com.bytedance.sdk.account.bdplatform.api.IBDAuthorizeModel
    public TicketResponse requestGetTicket(SendAuth.Request request, Map<String, String> map) {
        return requestGetTicket(request, null, this.depend.ticketHost(), GET_TICKET, map);
    }

    @Override // com.bytedance.sdk.account.bdplatform.api.IBDAuthorizeModel
    public TicketResponse requestGetTicket(SendAuth.Request request, String str, Map<String, String> map) {
        return requestGetTicket(request, str, this.depend.ticketHost(), GET_TICKET, map);
    }

    @Override // com.bytedance.sdk.account.bdplatform.api.IBDAuthorizeModel
    public TicketResponse requestGetTicket(SendAuth.Request request, String str, String str2, String str3, Map<String, String> map) {
        TicketResponse ticketResponse;
        int i;
        String str4;
        if (map == null) {
            map = new HashMap<>();
        }
        if (TextUtils.isEmpty(str)) {
            str = BDApiDataParser.getScope(request);
        }
        Uri.Builder appendQueryParameter = new Uri.Builder().scheme("https").authority(str2).path(str3).appendQueryParameter("client_key", request.clientKey).appendQueryParameter("scope", str);
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (!TextUtils.isEmpty(entry.getKey()) && !TextUtils.isEmpty(entry.getValue())) {
                appendQueryParameter.appendQueryParameter(entry.getKey(), entry.getValue());
            }
        }
        try {
            ticketResponse = BDApiDataParser.parseTicket(this.depend.executeGet(appendQueryParameter.build().toString()));
        } catch (Throwable th) {
            th.printStackTrace();
            TicketResponse ticketResponse2 = new TicketResponse();
            ticketResponse2.errorCode = NetUtils.checkApiException(this.depend, th);
            ticketResponse = ticketResponse2;
        }
        String str5 = "fail";
        if (ticketResponse == null) {
            str4 = this.context.getString(C0047R.string.bd_platform_error_tips_common);
            i = -1;
        } else if (ticketResponse.success) {
            i = 0;
            str4 = "";
            str5 = "success";
        } else {
            i = ticketResponse.errorCode;
            str4 = ticketResponse.errorMessage;
        }
        onEvent(BDPlatformConstants.EventName.EVENT_PLATFORM_AUTH_TICKET, getResultData(request, str5, i, str4));
        return ticketResponse;
    }

    @Override // com.bytedance.sdk.account.bdplatform.api.IBDAuthorizeModel
    public AuthCodeResponse requestGetAuthCode(SendAuth.Request request, String str) {
        return requestGetAuthCode(request, null, str, this.depend.authHost(), "/oauth/authorize/", null);
    }

    @Override // com.bytedance.sdk.account.bdplatform.api.IBDAuthorizeModel
    public AuthCodeResponse requestGetAuthCode(SendAuth.Request request, String str, Map<String, String> map) {
        return requestGetAuthCode(request, null, str, this.depend.authHost(), "/oauth/authorize/", map);
    }

    @Override // com.bytedance.sdk.account.bdplatform.api.IBDAuthorizeModel
    public AuthCodeResponse requestGetAuthCode(SendAuth.Request request, String str, String str2, Map<String, String> map) {
        return requestGetAuthCode(request, str, str2, this.depend.authHost(), "/oauth/authorize/", map);
    }

    @Override // com.bytedance.sdk.account.bdplatform.api.IBDAuthorizeModel
    public AuthCodeResponse requestGetAuthCode(SendAuth.Request request, String str, String str2, String str3, String str4, Map<String, String> map) {
        AuthCodeResponse authCodeResponse;
        int i;
        String str5;
        if (TextUtils.isEmpty(str)) {
            str = request.scope;
        }
        List<String> md5Signs = SignatureUtils.getMd5Signs(this.context, request.getCallerPackage());
        HashMap hashMap = new HashMap();
        hashMap.put("client_key", request.getClientKey());
        hashMap.put("response_type", "code");
        hashMap.put("scope", str);
        hashMap.put("ticket", str2);
        if (!TextUtils.isEmpty(request.authFrom)) {
            hashMap.put("from", request.authFrom);
        }
        if (TextUtils.equals("wap_to_native", request.authFrom) && !TextUtils.isEmpty(request.redirectUri)) {
            hashMap.put("redirect_uri", request.redirectUri);
        }
        if (!TextUtils.isEmpty(request.state)) {
            hashMap.put("state", request.state);
        }
        if (!TextUtils.isEmpty(request.getCallerPackage())) {
            hashMap.put("app_identity", Md5Utils.hexDigest(request.getCallerPackage()));
        }
        String packageSignature = SignatureUtils.packageSignature(md5Signs);
        if (!TextUtils.isEmpty(packageSignature)) {
            hashMap.put("signature", packageSignature);
            hashMap.put("sign", packageSignature);
        }
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
        }
        try {
            authCodeResponse = BDApiDataParser.parseAuthCode(this.depend.executePost(new Uri.Builder().scheme("https").authority(str3).path(str4).build().toString(), hashMap));
        } catch (Throwable th) {
            th.printStackTrace();
            AuthCodeResponse authCodeResponse2 = new AuthCodeResponse();
            authCodeResponse2.errorCode = NetUtils.checkApiException(this.depend, th);
            authCodeResponse = authCodeResponse2;
        }
        String str6 = "fail";
        if (authCodeResponse == null) {
            str5 = this.context.getString(C0047R.string.bd_platform_error_tips_common);
            i = -1;
        } else if (authCodeResponse.success) {
            i = 0;
            str5 = "";
            str6 = "success";
        } else {
            i = authCodeResponse.errorCode;
            str5 = authCodeResponse.errorMessage;
        }
        onEvent(BDPlatformConstants.EventName.EVENT_PLATFORM_AUTH_CODE, getResultData(request, str6, i, str5));
        return authCodeResponse;
    }

    @Override // com.bytedance.sdk.account.bdplatform.api.IBDAuthorizeModel
    public AuthCodeResponse requestGetAuthCodeV2(SendAuth.Request request, String str, String str2, String str3, Map<String, String> map) {
        AuthCodeResponse authCodeResponse;
        int i;
        String str4;
        if (TextUtils.isEmpty(str)) {
            str = request.scope;
        }
        List<String> md5Signs = SignatureUtils.getMd5Signs(this.context, request.getCallerPackage());
        HashMap hashMap = new HashMap();
        hashMap.put("client_key", request.getClientKey());
        hashMap.put("response_type", "code");
        hashMap.put(TimonPipeline.KEY_SOURCE, "native");
        hashMap.put("scope", str);
        if (!TextUtils.isEmpty(request.authFrom)) {
            hashMap.put("from", request.authFrom);
        }
        if (TextUtils.equals("wap_to_native", request.authFrom) && !TextUtils.isEmpty(request.redirectUri)) {
            hashMap.put("redirect_uri", request.redirectUri);
        }
        if (!TextUtils.isEmpty(request.state)) {
            hashMap.put("state", request.state);
        }
        if (!TextUtils.isEmpty(request.getCallerPackage())) {
            hashMap.put("app_identity", Md5Utils.hexDigest(request.getCallerPackage()));
        }
        String packageSignature = SignatureUtils.packageSignature(md5Signs);
        if (!TextUtils.isEmpty(packageSignature)) {
            hashMap.put("signature", packageSignature);
            hashMap.put("sign", packageSignature);
        }
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = this.depend.authHost();
        }
        if (TextUtils.isEmpty(str3)) {
            str3 = AUTH_CODE_PATH_V2;
        }
        try {
            authCodeResponse = BDApiDataParser.parseAuthCode(this.depend.executePost(new Uri.Builder().scheme("https").authority(str2).path(str3).build().toString(), hashMap));
        } catch (Throwable th) {
            th.printStackTrace();
            AuthCodeResponse authCodeResponse2 = new AuthCodeResponse();
            authCodeResponse2.errorCode = NetUtils.checkApiException(this.depend, th);
            authCodeResponse = authCodeResponse2;
        }
        String str5 = "fail";
        if (authCodeResponse == null) {
            str4 = this.context.getString(C0047R.string.bd_platform_error_tips_common);
            i = -1;
        } else if (authCodeResponse.success) {
            i = 0;
            str4 = "";
            str5 = "success";
        } else {
            i = authCodeResponse.errorCode;
            str4 = authCodeResponse.errorMessage;
        }
        onEvent(BDPlatformConstants.EventName.EVENT_PLATFORM_AUTH_CODE, getResultData(request, str5, i, str4));
        return authCodeResponse;
    }

    private void onEvent(String str, JSONObject jSONObject) {
        try {
            if (this.depend == null || TextUtils.isEmpty(str)) {
                return;
            }
            this.depend.onLogEvent(str, jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private JSONObject getResultData(SendAuth.Request request, String str, int i, String str2) {
        try {
            JSONObject commonData = getCommonData(request);
            if (commonData == null) {
                commonData = new JSONObject();
            }
            commonData.put("result", str);
            commonData.put("errCode", i);
            commonData.put("errDesc", str2);
            return commonData;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public JSONObject getCommonData(SendAuth.Request request) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (request != null) {
                jSONObject.put("client_key", request.clientKey);
            }
            jSONObject.put(BDPlatformConstants.EventKey.EVENT_KEY_SDK_VERSION, 7);
            jSONObject.put("params_for_special", "uc_login");
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
