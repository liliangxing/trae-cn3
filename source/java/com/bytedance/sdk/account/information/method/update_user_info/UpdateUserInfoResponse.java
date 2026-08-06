package com.bytedance.sdk.account.information.method.update_user_info;

import com.bytedance.sdk.account.api.call.BaseApiResponse;
import com.bytedance.sdk.account.information.method.update_user_info.data.AuditInfo;
import com.bytedance.sdk.account.information.method.update_user_info.data.UserInfo;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class UpdateUserInfoResponse extends BaseApiResponse {
    public UserInfo currentInfo;
    public JSONObject data;
    public AuditInfo pgcAuditInfo;
    public AuditInfo verifiedAuditInfo;

    public UpdateUserInfoResponse(boolean z, int i) {
        super(z, i);
    }
}
