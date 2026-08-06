package com.bytedance.trae.init.task.bdturing;

import android.app.Activity;
import com.bytedance.bdturing.twiceverify.TwiceVerifyDepend;
import com.bytedance.trae.network.HostResolver;
import com.bytedance.trae.network.HostType;
import java.util.HashMap;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class DefaultTwiceVerifyDepend implements TwiceVerifyDepend {
    private String url = "https://rmc.bytedance.com/verifycenter/authentication";

    public void dismissLoading() {
    }

    public void showCertLiveVerify(HashMap<String, String> hashMap, TwiceVerifyDepend.TwiceVerifyCertVerifyCallback twiceVerifyCertVerifyCallback) {
    }

    public void showCertVerify(HashMap<String, String> hashMap, TwiceVerifyDepend.TwiceVerifyCertVerifyCallback twiceVerifyCertVerifyCallback) {
    }

    public void showLoading(Activity activity, String str) {
    }

    public String host() {
        return HostResolver.INSTANCE.getHost(HostType.ONLINE);
    }

    public String url() {
        return this.url;
    }
}
