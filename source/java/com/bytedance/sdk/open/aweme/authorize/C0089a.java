package com.bytedance.sdk.open.aweme.authorize;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.sdk.account.platform.api.IWeiboService;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.bytedance.sdk.open.aweme.authorize.model.Authorization;
import com.bytedance.sdk.open.aweme.authorize.model.VerifyObject;
import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;
import com.bytedance.sdk.open.aweme.core.OpenOptionService;
import com.bytedance.sdk.open.aweme.core.OpenServiceManager;
import com.bytedance.sdk.open.aweme.utils.LogUtils;
import com.bytedance.sdk.open.aweme.utils.Md5Utils;
import com.bytedance.sdk.open.aweme.utils.NetUtils;
import com.bytedance.sdk.open.aweme.utils.OpenUtils;
import com.bytedance.sdk.open.aweme.utils.SignatureUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.bytedance.sdk.open.aweme.authorize.a */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class C0089a {
    /* renamed from: a */
    private static String m16a() {
        OpenOptionService openOptionService;
        HashMap<String, String> commonParams;
        if (!OpenUtils.isExternal() && (openOptionService = (OpenOptionService) OpenServiceManager.getInst().getService(OpenOptionService.class)) != null && (commonParams = openOptionService.getCommonParams()) != null && !commonParams.isEmpty()) {
            JSONObject jSONObject = new JSONObject();
            try {
                for (Map.Entry<String, String> entry : commonParams.entrySet()) {
                    jSONObject.putOpt(entry.getKey(), entry.getValue());
                }
                return jSONObject.toString();
            } catch (Exception unused) {
            }
        }
        return null;
    }

    /* renamed from: a */
    public static String m17a(Context context, Authorization.Request request, String str, String str2, String str3) {
        String str4;
        String str5;
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(request.optionalScope1)) {
            for (String str6 : request.optionalScope1.split(IWeiboService.Scope.EMPTY_SCOPE)) {
                if (sb.length() > 0) {
                    sb.append(IWeiboService.Scope.EMPTY_SCOPE);
                }
                sb.append(str6 + ",1");
            }
        }
        if (!TextUtils.isEmpty(request.optionalScope0)) {
            for (String str7 : request.optionalScope0.split(IWeiboService.Scope.EMPTY_SCOPE)) {
                if (sb.length() > 0) {
                    sb.append(IWeiboService.Scope.EMPTY_SCOPE);
                }
                sb.append(str7 + ",0");
            }
        }
        StringBuilder sb2 = new StringBuilder();
        String str8 = request.scope;
        if (str8 != null) {
            sb2.append(str8);
        }
        VerifyObject verifyObject = request.verifyObject;
        if (verifyObject != null && verifyObject.verifyScope != null) {
            if (sb2.length() > 0) {
                sb2.append(',');
            }
            sb2.append(request.verifyObject.verifyScope);
        }
        List<String> md5Signs = SignatureUtils.getMd5Signs(context, request.getCallerPackage());
        Bundle bundle = request.extras;
        if (bundle != null) {
            str5 = bundle.getString(ParamKeyConstants.WebViewConstants.LIVE_ENTER_FROM_KEY, "");
            str4 = bundle.getString("enter_from", "auth_login");
        } else {
            str4 = "auth_login";
            str5 = "";
        }
        Uri.Builder appendQueryParameter = new Uri.Builder().scheme(str).authority(str2).path(str3).appendQueryParameter("response_type", "code").appendQueryParameter("redirect_uri", request.redirectUri).appendQueryParameter("client_key", request.getClientKey()).appendQueryParameter("state", request.state).appendQueryParameter("from", "opensdk").appendQueryParameter("scope", sb2.toString()).appendQueryParameter("optionalScope", sb.toString()).appendQueryParameter("signature", SignatureUtils.packageSignature(md5Signs)).appendQueryParameter("app_identity", Md5Utils.hexDigest(request.getCallerPackage())).appendQueryParameter("device_platform", "android").appendQueryParameter(ParamKeyConstants.WebViewConstants.LIVE_ENTER_FROM_KEY, str5).appendQueryParameter("enter_from", TextUtils.isEmpty(str4) ? "auth_login" : str4).appendQueryParameter(ParamKeyConstants.WebViewConstants.IS_WIFI, String.valueOf(NetUtils.getNetWorkType(context).getValue())).appendQueryParameter("comment_id", TextUtils.isEmpty(request.commentId) ? "" : request.commentId).appendQueryParameter("is_other_account_auth", request.isOtherAccountAuth ? "1" : OnekeyLoginConstants.UNICOM_TYPE);
        String m16a = m16a();
        if (!TextUtils.isEmpty(m16a)) {
            appendQueryParameter.appendQueryParameter("common_params", m16a);
        }
        LogUtils.m29i("WebViewHelper", appendQueryParameter.build().toString());
        return appendQueryParameter.build().toString();
    }
}
