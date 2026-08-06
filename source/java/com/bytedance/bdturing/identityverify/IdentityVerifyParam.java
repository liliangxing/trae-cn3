package com.bytedance.bdturing.identityverify;

import android.app.Activity;
import com.bytedance.bdturing.theme.IdentityVerifyTheme;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class IdentityVerifyParam {
    private Activity activity;
    private HashMap<String, String> certParamMap;
    private boolean isBoe;
    private IdentityVerifyTheme theme;

    public IdentityVerifyParam(Activity activity, HashMap<String, String> hashMap, boolean z) {
        this.activity = activity;
        this.certParamMap = hashMap;
        this.isBoe = z;
    }

    public HashMap<String, String> getCertParamMap() {
        return this.certParamMap;
    }

    public void setCertParamMap(HashMap<String, String> hashMap) {
        this.certParamMap = hashMap;
    }

    public boolean isBoe() {
        return this.isBoe;
    }

    public void setBoe(boolean z) {
        this.isBoe = z;
    }

    public Activity getActivity() {
        return this.activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public IdentityVerifyTheme getTheme() {
        return this.theme;
    }

    public void setTheme(IdentityVerifyTheme identityVerifyTheme) {
        this.theme = identityVerifyTheme;
    }
}
