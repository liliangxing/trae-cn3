package com.bytedance.sdk.open.douyin.impl;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;
import com.bytedance.sdk.open.aweme.share.IShareApplier;
import com.bytedance.sdk.open.aweme.share.Share;

/* renamed from: com.bytedance.sdk.open.douyin.impl.g */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class C0123g implements IShareApplier {

    /* renamed from: a */
    private final String f94a;

    /* renamed from: b */
    private String f95b = null;

    public C0123g(String str) {
        this.f94a = str;
    }

    /* renamed from: a */
    public void m42a(String str) {
        this.f95b = str;
    }

    @Override // com.bytedance.sdk.open.aweme.share.IShareApplier
    public void addIntentFlags(Context context, Intent intent) {
        intent.addFlags(67108864);
        intent.addFlags(268435456);
    }

    @Override // com.bytedance.sdk.open.aweme.share.IShareApplier
    public void fillBundle(Context context, Share.Request request, Bundle bundle) {
        request.toBundle(bundle);
    }

    @Override // com.bytedance.sdk.open.aweme.share.IShareApplier
    public String getClientKey() {
        return this.f94a;
    }

    @Override // com.bytedance.sdk.open.aweme.share.IShareApplier
    public String getComponentClassName() {
        String str = this.f95b;
        return str != null ? str : "com.ss.android.ugc.aweme.share.SystemShareActivity";
    }

    @Override // com.bytedance.sdk.open.aweme.share.IShareApplier
    public String getPackageName() {
        return ParamKeyConstants.DOUYIN_LITE_PACKAGE_NAME;
    }
}
