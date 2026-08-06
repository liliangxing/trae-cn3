package com.bytedance.sdk.open.douyin.impl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import com.bytedance.sdk.open.aweme.base.BaseCheckHelperImpl;
import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;
import com.bytedance.sdk.open.douyin.settings.C0125a;

/* renamed from: com.bytedance.sdk.open.douyin.impl.e */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class C0121e extends BaseCheckHelperImpl {

    /* renamed from: b */
    private static final String[] f80b = {"com.ss.android.ugc.aweme.share.SystemShareActivity", "com.ss.android.ugc.aweme.opensdk.share.SystemShareActivity"};

    /* renamed from: a */
    private final C0123g f81a;

    public C0121e(Context context, C0123g c0123g) {
        super(context);
        this.f81a = c0123g;
    }

    @Override // com.bytedance.sdk.open.aweme.base.BaseCheckHelperImpl
    public boolean allowAuth() {
        return C0125a.m44a(C0125a.c.AUTH, C0125a.b.DOUYIN_LITE);
    }

    @Override // com.bytedance.sdk.open.aweme.base.BaseCheckHelperImpl
    public boolean allowShare() {
        return C0125a.m44a(C0125a.c.SHARE, C0125a.b.DOUYIN_LITE);
    }

    @Override // com.bytedance.sdk.open.aweme.base.BaseCheckHelperImpl
    protected int getAuthRequestApi() {
        return 10;
    }

    @Override // com.bytedance.sdk.open.aweme.base.IAPPCheckHelper
    public String getPackageName() {
        return ParamKeyConstants.DOUYIN_LITE_PACKAGE_NAME;
    }

    @Override // com.bytedance.sdk.open.aweme.base.BaseCheckHelperImpl, com.bytedance.sdk.open.aweme.base.IAPPCheckHelper
    public boolean isAppSupportShare() {
        if (!allowShare() || !isAppInstalled() || this.mContext == null) {
            return false;
        }
        for (String str : f80b) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(this.f81a.getPackageName(), str));
            ActivityInfo resolveActivityInfo = intent.resolveActivityInfo(this.mContext.getPackageManager(), 65536);
            if (resolveActivityInfo != null && resolveActivityInfo.exported) {
                this.f81a.m42a(str);
                return true;
            }
        }
        return false;
    }

    @Override // com.bytedance.sdk.open.aweme.base.BaseCheckHelperImpl
    public boolean isSupportAuthSwitchAccount() {
        return isAppSupportAuthorization() && super.isSupportAuthSwitchAccount();
    }
}
