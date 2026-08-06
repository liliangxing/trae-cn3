package com.bytedance.trae.login.fragment;

import java.util.Map;

/* loaded from: classes4.dex */
public interface OneClickLoginCallback {
    void onDeviceLimitLoginContinue(Map<String, Object> map, String str);

    void onLoginSuccess();

    void onOneClickLogin();

    void onPrivacyClicked();

    void onSwitchAccount();

    void onTermsClicked();
}
