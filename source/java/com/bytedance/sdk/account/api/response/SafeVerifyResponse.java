package com.bytedance.sdk.account.api.response;

import com.bytedance.sdk.account.api.call.BaseApiResponse;

/* loaded from: classes5.dex */
public class SafeVerifyResponse extends BaseApiResponse {
    public boolean safe;
    public String ticket;

    public SafeVerifyResponse(boolean z, int i) {
        super(z, i);
    }
}
