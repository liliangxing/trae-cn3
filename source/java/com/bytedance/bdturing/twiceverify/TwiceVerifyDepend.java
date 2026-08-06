package com.bytedance.bdturing.twiceverify;

import android.app.Activity;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public interface TwiceVerifyDepend {

    /* loaded from: classes3.dex */
    public interface TwiceVerifyCertVerifyCallback {
        void onFailed(int i, String str);

        @Deprecated
        void onSucc();

        void onVerifyAuthTicket(String str, String str2, Map<String, String> map);
    }

    void dismissLoading();

    String host();

    void showCertLiveVerify(HashMap<String, String> hashMap, TwiceVerifyCertVerifyCallback twiceVerifyCertVerifyCallback);

    void showCertVerify(HashMap<String, String> hashMap, TwiceVerifyCertVerifyCallback twiceVerifyCertVerifyCallback);

    void showLoading(Activity activity, String str);

    String url();
}
