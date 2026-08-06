package com.bytedance.bdturing.ttnet;

import com.bytedance.bdturing.livedetect.net.CommonResponse;

/* loaded from: classes3.dex */
public interface ITuringNetworkCallBack {
    void onError(Throwable th);

    void onResponse(CommonResponse commonResponse);
}
