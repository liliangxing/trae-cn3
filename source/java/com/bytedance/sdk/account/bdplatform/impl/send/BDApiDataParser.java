package com.bytedance.sdk.account.bdplatform.impl.send;

import android.text.TextUtils;
import com.bytedance.sdk.account.bdplatform.model.AlertScope;
import com.bytedance.sdk.account.bdplatform.model.AuthCodeResponse;
import com.bytedance.sdk.account.bdplatform.model.AuthInfoResponse;
import com.bytedance.sdk.account.bdplatform.model.AuthInfoResponseV2;
import com.bytedance.sdk.account.bdplatform.model.CommonResponse;
import com.bytedance.sdk.account.bdplatform.model.TicketResponse;
import com.bytedance.sdk.account.common.model.SendAuth;
import com.bytedance.sdk.account.platform.api.IWeiboService;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class BDApiDataParser {
    public static final String CODE = "code";
    public static final String DATA = "data";
    public static final String DESCRIPTION = "description";
    public static final String ERROR_CODE = "error_code";
    public static final String MESSAGE = "message";
    public static final String SUCCESS = "success";

    public static AuthCodeResponse parseAuthCode(String str) {
        if (str == null) {
            return null;
        }
        AuthCodeResponse authCodeResponse = new AuthCodeResponse();
        try {
            parseCommon(authCodeResponse, str);
            if (authCodeResponse.success) {
                if (authCodeResponse.data != null) {
                    authCodeResponse.authCode = authCodeResponse.data.optString("code");
                    return authCodeResponse;
                }
                authCodeResponse.errorCode = -1;
                return authCodeResponse;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return authCodeResponse;
    }

    public static TicketResponse parseTicket(String str) {
        if (str == null) {
            return null;
        }
        TicketResponse ticketResponse = new TicketResponse();
        try {
            parseCommon(ticketResponse, str);
            if (ticketResponse.success) {
                if (ticketResponse.data != null) {
                    ticketResponse.ticket = ticketResponse.data.optString("ticket");
                    ticketResponse.authorized = ticketResponse.data.optBoolean("authorized");
                    ticketResponse.needAlert = ticketResponse.data.optBoolean("need_alert");
                    return ticketResponse;
                }
                ticketResponse.errorCode = -1;
                return ticketResponse;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ticketResponse;
    }

    public static AuthInfoResponse parseAuthInfo(String str) {
        if (str == null) {
            return null;
        }
        AuthInfoResponse authInfoResponse = new AuthInfoResponse();
        try {
            parseCommon(authInfoResponse, str);
            if (authInfoResponse.success) {
                if (authInfoResponse.data != null) {
                    authInfoResponse.clientName = authInfoResponse.data.optString("client_name");
                    authInfoResponse.clientIcon = authInfoResponse.data.optString("client_icon");
                    JSONArray optJSONArray = authInfoResponse.data.optJSONArray("scopes");
                    if (optJSONArray != null) {
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            authInfoResponse.scopes.add(optJSONArray.optString(i));
                        }
                    }
                    JSONObject optJSONObject = authInfoResponse.data.optJSONObject("scope_dict");
                    if (optJSONObject != null) {
                        authInfoResponse.scope_dict = optJSONObject;
                    }
                    JSONObject optJSONObject2 = authInfoResponse.data.optJSONObject("alert_scope");
                    if (optJSONObject2 != null) {
                        AlertScope alertScope = new AlertScope();
                        alertScope.scopeName = optJSONObject2.optString("scope_name");
                        alertScope.title = optJSONObject2.optString("title");
                        alertScope.content = optJSONObject2.optString(ReportConstant.COMMON_CONTENT);
                        alertScope.negativeButton = optJSONObject2.optString("negative_button");
                        alertScope.positiveButton = optJSONObject2.optString("positive_button");
                        authInfoResponse.alertScope = alertScope;
                    }
                    JSONObject optJSONObject3 = authInfoResponse.data.optJSONObject("customized_scopes");
                    if (optJSONObject3 != null) {
                        authInfoResponse.customizedScopes = parseCustomizedScopes(optJSONObject3);
                    }
                    authInfoResponse.bottomDescription = authInfoResponse.data.optString("bottom_description");
                    return authInfoResponse;
                }
                authInfoResponse.errorCode = -1;
                return authInfoResponse;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return authInfoResponse;
    }

    public static AuthInfoResponseV2 parseAuthInfoV2(String str) {
        if (str == null) {
            return null;
        }
        AuthInfoResponseV2 authInfoResponseV2 = new AuthInfoResponseV2();
        try {
            parseCommon(authInfoResponseV2, str);
            if (authInfoResponseV2.success) {
                if (authInfoResponseV2.data != null) {
                    authInfoResponseV2.clientName = authInfoResponseV2.data.optString("client_name");
                    authInfoResponseV2.clientIcon = authInfoResponseV2.data.optString("client_icon");
                    JSONArray optJSONArray = authInfoResponseV2.data.optJSONArray("scopes");
                    if (optJSONArray != null) {
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            authInfoResponseV2.scopes.add(optJSONArray.optString(i));
                        }
                    }
                    JSONObject optJSONObject = authInfoResponseV2.data.optJSONObject("scope_dict");
                    if (optJSONObject != null) {
                        authInfoResponseV2.scope_dict = optJSONObject;
                    }
                    JSONObject optJSONObject2 = authInfoResponseV2.data.optJSONObject("alert_scope");
                    if (optJSONObject2 != null) {
                        AlertScope alertScope = new AlertScope();
                        alertScope.scopeName = optJSONObject2.optString("scope_name");
                        alertScope.title = optJSONObject2.optString("title");
                        alertScope.content = optJSONObject2.optString(ReportConstant.COMMON_CONTENT);
                        alertScope.negativeButton = optJSONObject2.optString("negative_button");
                        alertScope.positiveButton = optJSONObject2.optString("positive_button");
                        authInfoResponseV2.alertScope = alertScope;
                    }
                    JSONObject optJSONObject3 = authInfoResponseV2.data.optJSONObject("customized_scopes");
                    if (optJSONObject3 != null) {
                        authInfoResponseV2.customizedScopes = parseCustomizedScopes(optJSONObject3);
                    }
                    JSONObject optJSONObject4 = authInfoResponseV2.data.optJSONObject("scope_description");
                    if (optJSONObject4 != null) {
                        authInfoResponseV2.scope_dict = optJSONObject4;
                    }
                    JSONObject optJSONObject5 = authInfoResponseV2.data.optJSONObject("normal_scopes");
                    if (optJSONObject5 != null) {
                        authInfoResponseV2.normalScopes = new AuthInfoResponseV2.ScopeSetInfo(optJSONObject5);
                    }
                    JSONObject optJSONObject6 = authInfoResponseV2.data.optJSONObject("sensitive_scopes");
                    if (optJSONObject6 != null) {
                        authInfoResponseV2.sensitiveScopes = new AuthInfoResponseV2.ScopeSetInfo(optJSONObject6);
                    }
                    authInfoResponseV2.flipchatConceal = authInfoResponseV2.data.optBoolean("flipchat_conceal");
                    authInfoResponseV2.hasMobile = authInfoResponseV2.data.optBoolean("has_mobile");
                    authInfoResponseV2.isLogin = authInfoResponseV2.data.optBoolean("login");
                    authInfoResponseV2.needBindMobile = authInfoResponseV2.data.optBoolean("need_bind_mobile");
                    authInfoResponseV2.qqConceal = authInfoResponseV2.data.optBoolean("qq_conceal");
                    authInfoResponseV2.toutiaoConceal = authInfoResponseV2.data.optBoolean("toutiao_conceal");
                    authInfoResponseV2.weiboConceal = authInfoResponseV2.data.optBoolean("weibo_conceal");
                    authInfoResponseV2.wxConceal = authInfoResponseV2.data.optBoolean("wx_conceal");
                    authInfoResponseV2.containsInvalidScope = authInfoResponseV2.data.optBoolean("contains_invalid_scope");
                    authInfoResponseV2.tips = authInfoResponseV2.data.optString("tips");
                    authInfoResponseV2.canSkipConfirm = authInfoResponseV2.data.optBoolean("can_skip_confirm");
                } else {
                    authInfoResponseV2.errorCode = -1;
                }
                return authInfoResponseV2;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return authInfoResponseV2;
    }

    private static Map<String, Map<String, Integer[][]>> parseCustomizedScopes(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Map<String, Integer[][]> parseStyles = parseStyles(jSONObject.optJSONArray(next));
            if (!TextUtils.isEmpty(next) && parseStyles != null) {
                hashMap.put(next, parseStyles);
            }
        }
        return hashMap;
    }

    private static Map<String, Integer[][]> parseStyles(JSONArray jSONArray) {
        String str = null;
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        HashMap hashMap = new HashMap();
        Integer[][] numArr = null;
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                str = optJSONObject.optString("style");
                numArr = parseRanges(optJSONObject.optJSONArray("range"));
            }
            if (!TextUtils.isEmpty(str) && numArr != null) {
                hashMap.put(str, numArr);
            }
        }
        return hashMap;
    }

    private static Integer[][] parseRanges(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        Integer[][] numArr = (Integer[][]) Array.newInstance((Class<?>) Integer.class, jSONArray.length(), 2);
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONArray optJSONArray = jSONArray.optJSONArray(i);
            if (optJSONArray != null && optJSONArray.length() == 2) {
                numArr[i][0] = Integer.valueOf(optJSONArray.optInt(0));
                numArr[i][1] = Integer.valueOf(optJSONArray.optInt(1));
            }
        }
        return numArr;
    }

    public static void parseCommon(CommonResponse commonResponse, String str) throws Exception {
        if (commonResponse == null || str == null) {
            throw new IllegalArgumentException("argument is null");
        }
        JSONObject jSONObject = new JSONObject(str);
        if ("success".equals(jSONObject.optString("message"))) {
            commonResponse.success = true;
            commonResponse.data = jSONObject.optJSONObject("data");
            return;
        }
        commonResponse.success = false;
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject != null) {
            commonResponse.errorCode = optJSONObject.optInt("error_code");
            commonResponse.errorMessage = optJSONObject.optString("description");
        }
    }

    public static String getScope(SendAuth.Request request) {
        StringBuilder sb = new StringBuilder();
        sb.append(request.scope);
        if (!TextUtils.isEmpty(request.optionalScope0)) {
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) != ',') {
                sb.append(IWeiboService.Scope.EMPTY_SCOPE);
            }
            sb.append(request.optionalScope0);
        }
        if (!TextUtils.isEmpty(request.optionalScope1)) {
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) != ',') {
                sb.append(IWeiboService.Scope.EMPTY_SCOPE);
            }
            sb.append(request.optionalScope1);
        }
        return sb.toString();
    }
}
