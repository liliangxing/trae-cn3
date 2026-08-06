package com.bytedance.sdk.open.douyin.impl;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;
import com.bytedance.sdk.open.aweme.share.IShareApplier;
import com.bytedance.sdk.open.aweme.share.Share;
import com.ss.ttm.player.C;

/* loaded from: classes5.dex */
public class g implements IShareApplier {
    private final String a;
    private String b = null;

    public g(String str) {
        this.a = str;
    }

    public void a(String str) {
        this.b = str;
    }

    @Override // com.bytedance.sdk.open.aweme.share.IShareApplier
    public void addIntentFlags(Context context, Intent intent) {
        intent.addFlags(67108864);
        intent.addFlags(C.ENCODING_PCM_MU_LAW);
    }

    @Override // com.bytedance.sdk.open.aweme.share.IShareApplier
    public void fillBundle(Context context, Share.Request request, Bundle bundle) {
        request.toBundle(bundle);
    }

    @Override // com.bytedance.sdk.open.aweme.share.IShareApplier
    public String getClientKey() {
        return this.a;
    }

    @Override // com.bytedance.sdk.open.aweme.share.IShareApplier
    public String getComponentClassName() {
        String str = this.b;
        return str != null ? str : "com.ss.android.ugc.aweme.share.SystemShareActivity";
    }

    @Override // com.bytedance.sdk.open.aweme.share.IShareApplier
    public String getPackageName() {
        return ParamKeyConstants.DOUYIN_LITE_PACKAGE_NAME;
    }
}
