package com.bytedance.sdk.account.information.method.check_default_info;

import android.content.Context;
import com.bytedance.sdk.account.execute.ApiRequest;
import com.bytedance.sdk.account.execute.ApiResponse;
import com.bytedance.sdk.account.impl.BaseAccountApi;
import com.bytedance.sdk.account.information.UserInfoNetConstants;
import com.bytedance.sdk.account.monitor.AccountMonitorUtil;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class CheckDefaultInfoJob extends BaseAccountApi<CheckDefaultInfoResponse> {
    private boolean isAvatarValid;
    private boolean isDescriptionValid;
    private boolean isNameValid;
    private boolean isShow;
    private String mAvatarUrl;
    private String mName;
    private JSONObject mResult;
    private String mSave;
    private String mTips;
    private String mTitle;

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void onStatusError(JSONObject jSONObject, JSONObject jSONObject2) {
    }

    public CheckDefaultInfoJob(Context context, ApiRequest apiRequest, CheckDefaultInfoCallback checkDefaultInfoCallback) {
        super(context, apiRequest, checkDefaultInfoCallback);
    }

    public static CheckDefaultInfoJob checkDefaultInfo(Context context, int i, Map<String, String> map, CheckDefaultInfoCallback checkDefaultInfoCallback) {
        return new CheckDefaultInfoJob(context, new ApiRequest.Builder().url(UserInfoNetConstants.getCheckDefaultInfoPath()).parameter("scene", String.valueOf(i)).parameters(map).get(), checkDefaultInfoCallback);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public CheckDefaultInfoResponse transformResponse(boolean z, ApiResponse apiResponse) {
        CheckDefaultInfoResponse checkDefaultInfoResponse = new CheckDefaultInfoResponse(z, UserInfoNetConstants.API_CHECK_DEFAULT_INFO);
        if (z) {
            checkDefaultInfoResponse.result = this.mResult;
            checkDefaultInfoResponse.isNameValid = this.isNameValid;
            checkDefaultInfoResponse.isAvatarValid = this.isAvatarValid;
            checkDefaultInfoResponse.isDescriptionValid = this.isDescriptionValid;
            checkDefaultInfoResponse.isShow = this.isShow;
            checkDefaultInfoResponse.mName = this.mName;
            checkDefaultInfoResponse.mAvatarUrl = this.mAvatarUrl;
            checkDefaultInfoResponse.mTitle = this.mTitle;
            checkDefaultInfoResponse.mTips = this.mTips;
            checkDefaultInfoResponse.mSave = this.mSave;
        } else {
            checkDefaultInfoResponse.error = apiResponse.mError;
            checkDefaultInfoResponse.errorMsg = apiResponse.mErrorMsg;
        }
        return checkDefaultInfoResponse;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void parseData(JSONObject jSONObject, JSONObject jSONObject2) throws Exception {
        this.mResult = jSONObject;
        this.isNameValid = jSONObject2.optBoolean("is_name_valid");
        this.isAvatarValid = jSONObject2.optBoolean("is_avatar_valid");
        this.isDescriptionValid = jSONObject2.optBoolean("is_description_valid");
        this.isShow = jSONObject2.optBoolean("show");
        this.mName = jSONObject2.optString("name");
        this.mAvatarUrl = jSONObject2.optString("avatar_url");
        this.mTitle = jSONObject2.optString("title");
        this.mTips = jSONObject2.optString("tips");
        this.mSave = jSONObject2.optString("save");
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public void onSendEvent(CheckDefaultInfoResponse checkDefaultInfoResponse) {
        AccountMonitorUtil.onEvent(UserInfoNetConstants.EventName.CHECK_DEFAULT_INFO, null, null, checkDefaultInfoResponse, this.mApiCall);
    }
}
