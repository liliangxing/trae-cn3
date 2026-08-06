package com.bytedance.sdk.account.information.method.can_modify;

import com.bytedance.sdk.account.api.call.BaseApiResponse;

/* loaded from: classes5.dex */
public class CanModifyUserResponse extends BaseApiResponse {
    public boolean canSet;

    public CanModifyUserResponse(boolean z, int i) {
        super(z, i);
    }

    public boolean isCanSet() {
        return this.canSet;
    }
}
