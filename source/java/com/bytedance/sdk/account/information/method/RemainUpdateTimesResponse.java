package com.bytedance.sdk.account.information.method;

import com.bytedance.sdk.account.api.call.BaseApiResponse;
import com.bytedance.sdk.account.information.UserInfoNetConstants;

/* loaded from: classes5.dex */
public class RemainUpdateTimesResponse extends BaseApiResponse {
    public int leftUpdateTimes;

    public RemainUpdateTimesResponse(boolean z) {
        super(z, UserInfoNetConstants.API_REMAIN_UPDATE_TIMES);
    }
}
