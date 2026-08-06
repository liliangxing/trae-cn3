package com.bytedance.sdk.account.common.api;

import android.content.Intent;
import com.bytedance.sdk.account.common.model.BaseReq;
import com.bytedance.sdk.account.common.model.BaseResp;

/* loaded from: classes5.dex */
public interface BDApiEventHandler {
    void onErrorIntent(Intent intent);

    void onReq(BaseReq baseReq);

    void onResp(BaseResp baseResp);
}
