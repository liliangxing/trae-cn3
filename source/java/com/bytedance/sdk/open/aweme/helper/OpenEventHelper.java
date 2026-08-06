package com.bytedance.sdk.open.aweme.helper;

import com.bytedance.sdk.account.platform.api.IDouYin2Service;
import com.bytedance.sdk.open.aweme.authorize.model.Authorization;
import com.bytedance.sdk.open.aweme.authorize.model.VerifyObject;
import com.bytedance.sdk.open.aweme.commonbase.OpenEvent;
import com.bytedance.sdk.xbridge.cn.auth.respository.PermissionConfigParser;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class OpenEventHelper {
    public static void mobApiAuth(Authorization.Request request, String str) {
        if (request == null) {
            return;
        }
        OpenEvent.Builder m18kv = new OpenEvent.Builder("dysdk_api_auth").m18kv("auth_host_type", str).m18kv("scope", request.scope).m18kv("scope_option", request.optionalScope0).m18kv("scope_option_checked", request.optionalScope1);
        VerifyObject verifyObject = request.verifyObject;
        if (verifyObject != null) {
            m18kv.m18kv(IDouYin2Service.Extra.VERIFY_SCOPE, verifyObject.verifyScope);
            m18kv.m18kv(IDouYin2Service.Extra.VERIFY_OPENID, request.verifyObject.verifyOpenId);
            m18kv.m18kv(IDouYin2Service.Extra.VERIFY_TIC, request.verifyObject.verifyTic);
        }
        m18kv.build().flush();
    }

    public static void mobApiInvoke(String str) {
        new OpenEvent.Builder("dysdk_api_invoke").m18kv("api_name", str).build().flush();
    }

    public static void mobApiInvoke(String str, boolean z) {
        new OpenEvent.Builder("dysdk_api_invoke").m18kv("api_name", str).m18kv("is_support", z ? "1" : "0").build().flush();
    }

    public static void mobApiInvoke(String str, boolean z, int i) {
        new OpenEvent.Builder("dysdk_api_invoke").m18kv("api_name", str).m18kv("is_support", z ? "1" : "0").m18kv("common_type", Integer.valueOf(i)).build().flush();
    }

    public static void mobApiInvoke(String str, boolean z, int i, int i2) {
        new OpenEvent.Builder("dysdk_api_invoke").m18kv("api_name", str).m18kv("is_support", z ? "1" : "0").m18kv("ability", Integer.valueOf(i)).m18kv("api", Integer.valueOf(i2)).build().flush();
    }

    public static void mobSdkCallHost(String str, String str2) {
        new OpenEvent.Builder("dysdk_call_host").m18kv(PermissionConfigParser.WEBCAST_HOST_NAMESPACE, str).m18kv("api_type", str2).build().flush();
    }
}
