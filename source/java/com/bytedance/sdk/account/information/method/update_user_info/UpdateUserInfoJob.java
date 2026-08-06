package com.bytedance.sdk.account.information.method.update_user_info;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.account.execute.ApiRequest;
import com.bytedance.sdk.account.execute.ApiResponse;
import com.bytedance.sdk.account.impl.BaseAccountApi;
import com.bytedance.sdk.account.information.UserInfoNetConstants;
import com.bytedance.sdk.account.information.method.update_user_info.data.AuditInfo;
import com.bytedance.sdk.account.information.method.update_user_info.data.UserInfo;
import com.bytedance.sdk.account.monitor.AccountMonitorUtil;
import com.bytedance.sdk.account.platform.api.IWeiboService;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class UpdateUserInfoJob extends BaseAccountApi<UpdateUserInfoResponse> {
    private JSONObject data;
    private UserInfo mCurrentInfo;
    private AuditInfo mPgcAuditInfo;
    private AuditInfo mVerifiedAuditInfo;
    private JSONObject rawResult;

    public UpdateUserInfoJob(Context context, ApiRequest apiRequest, UpdateUserInfoCallback updateUserInfoCallback) {
        super(context, apiRequest, updateUserInfoCallback);
    }

    public static UpdateUserInfoJob updateUserInfo(Context context, Map<String, String> map, JSONObject jSONObject, String[] strArr, boolean z, UpdateUserInfoCallback updateUserInfoCallback) {
        return new UpdateUserInfoJob(context, new ApiRequest.Builder().url(UserInfoNetConstants.getUpdateUserInfoPath()).parameters(getParams(map, jSONObject, strArr)).valueNullable(z).post(), updateUserInfoCallback);
    }

    private static Map<String, String> getParams(Map<String, String> map, JSONObject jSONObject, String[] strArr) {
        if (map == null) {
            map = new HashMap<>();
        }
        if (jSONObject != null) {
            map.put("expend_attrs", jSONObject.toString());
        }
        String buildDeleteAttrInfo = buildDeleteAttrInfo(strArr);
        if (!TextUtils.isEmpty(buildDeleteAttrInfo)) {
            map.put("delete_attrs", buildDeleteAttrInfo);
        }
        return map;
    }

    private static String buildDeleteAttrInfo(String[] strArr) {
        if (strArr == null || strArr.length <= 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (String str : strArr) {
            if (!TextUtils.isEmpty(str)) {
                if (sb.length() > 0) {
                    sb.append(IWeiboService.Scope.EMPTY_SCOPE);
                }
                sb.append(str);
            }
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public UpdateUserInfoResponse transformResponse(boolean z, ApiResponse apiResponse) {
        UpdateUserInfoResponse updateUserInfoResponse = new UpdateUserInfoResponse(z, UserInfoNetConstants.API_UPDATE_USER_INFO);
        if (z) {
            updateUserInfoResponse.currentInfo = this.mCurrentInfo;
            updateUserInfoResponse.pgcAuditInfo = this.mPgcAuditInfo;
            updateUserInfoResponse.verifiedAuditInfo = this.mVerifiedAuditInfo;
        } else {
            updateUserInfoResponse.error = apiResponse.mError;
            updateUserInfoResponse.errorMsg = apiResponse.mErrorMsg;
        }
        updateUserInfoResponse.data = this.data;
        updateUserInfoResponse.result = this.rawResult;
        return updateUserInfoResponse;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void onStatusError(JSONObject jSONObject, JSONObject jSONObject2) {
        this.data = jSONObject;
        this.rawResult = jSONObject2;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void parseData(JSONObject jSONObject, JSONObject jSONObject2) throws Exception {
        JSONObject optJSONObject = jSONObject2.optJSONObject("current_info");
        JSONObject optJSONObject2 = jSONObject2.optJSONObject("pgc_audit_info");
        JSONObject optJSONObject3 = jSONObject2.optJSONObject("verified_audit_info");
        if (optJSONObject != null) {
            this.mCurrentInfo = extractUserInfo(optJSONObject);
        }
        if (optJSONObject2 != null) {
            this.mPgcAuditInfo = extractAuditInfo(optJSONObject2);
        }
        if (optJSONObject3 != null) {
            this.mVerifiedAuditInfo = extractAuditInfo(optJSONObject3);
        }
        this.data = jSONObject2;
        this.rawResult = jSONObject;
    }

    private UserInfo extractUserInfo(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        UserInfo userInfo = new UserInfo();
        String optString = jSONObject.optString("name");
        String optString2 = jSONObject.optString("avatar_url");
        String optString3 = jSONObject.optString("description");
        String optString4 = jSONObject.optString("area");
        Integer valueOf = Integer.valueOf(jSONObject.optInt("gender"));
        JSONObject optJSONObject = jSONObject.optJSONObject("expend_attrs");
        if (!TextUtils.isEmpty(optString)) {
            userInfo.setName(optString);
        }
        if (!TextUtils.isEmpty(optString2)) {
            userInfo.setAvatarUrl(optString2);
        }
        if (!TextUtils.isEmpty(optString3)) {
            userInfo.setDescription(optString3);
        }
        if (!TextUtils.isEmpty(optString4)) {
            userInfo.setArea(optString4);
        }
        userInfo.setGender(valueOf);
        if (optJSONObject != null) {
            userInfo.setExtra(optJSONObject.toString());
        }
        return userInfo;
    }

    private AuditInfo extractAuditInfo(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        AuditInfo auditInfo = new AuditInfo();
        boolean optBoolean = jSONObject.optBoolean("is_auditing");
        UserInfo extractUserInfo = extractUserInfo(jSONObject.optJSONObject("audit_info"));
        Long valueOf = Long.valueOf(jSONObject.optLong("last_update_time"));
        auditInfo.setAuditing(optBoolean);
        auditInfo.setLastUpdateTime(valueOf);
        if (extractUserInfo != null) {
            auditInfo.setAuditInfo(extractUserInfo);
        }
        return auditInfo;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public void onSendEvent(UpdateUserInfoResponse updateUserInfoResponse) {
        AccountMonitorUtil.onEvent(UserInfoNetConstants.EventName.UPDATE_USER_INFO, null, null, updateUserInfoResponse, this.mApiCall);
    }
}
