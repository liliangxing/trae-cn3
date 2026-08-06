package com.bytedance.sdk.open.aweme.common.handler;

import android.content.Intent;
import com.bytedance.sdk.open.aweme.common.model.BaseReq;
import com.bytedance.sdk.open.aweme.common.model.BaseResp;

/* loaded from: classes5.dex */
public interface IApiEventHandler {
    void onErrorIntent(Intent intent);

    void onReq(BaseReq baseReq);

    void onResp(BaseResp baseResp);
}
