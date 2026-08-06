package com.bytedance.sdk.account.helper;

import android.text.TextUtils;
import com.bytedance.sdk.account.impl.BDAccountAPIV3Impl;
import com.bytedance.sdk.account.mobile.thread.call.BindMobileCallback;
import com.bytedance.sdk.account.mobile.thread.call.SendCodeCallback;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class BindMobileHelper {
    public static void sendCode(String str, SendCodeCallback sendCodeCallback) {
        BDAccountAPIV3Impl.instance().sendCodeForBind(str, sendCodeCallback);
    }

    public static void bindMobile(String str, String str2, String str3, boolean z, BindMobileCallback bindMobileCallback) {
        if (TextUtils.isEmpty(str3)) {
            BDAccountAPIV3Impl.instance().bindMobileNoPassword(str, str2, null, z ? 1 : 0, bindMobileCallback);
        } else {
            BDAccountAPIV3Impl.instance().bindMobile(str, str2, str3, null, z ? 1 : 0, bindMobileCallback);
        }
    }

    public static void bindMobileNotLogin(String str, String str2, boolean z, String str3, String str4, Map<String, String> map, BindMobileCallback bindMobileCallback) {
        BDAccountAPIV3Impl.instance().bindMobileNoPassword(str, str2, null, z ? 1 : 0, str3, str4, map, bindMobileCallback);
    }
}
