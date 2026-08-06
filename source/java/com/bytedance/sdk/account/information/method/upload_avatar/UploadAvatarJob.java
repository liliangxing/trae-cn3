package com.bytedance.sdk.account.information.method.upload_avatar;

import android.content.Context;
import com.bytedance.sdk.account.execute.ApiRequest;
import com.bytedance.sdk.account.execute.ApiResponse;
import com.bytedance.sdk.account.impl.BaseAccountApi;
import com.bytedance.sdk.account.information.UserInfoNetConstants;
import com.bytedance.sdk.account.monitor.AccountMonitorUtil;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class UploadAvatarJob extends BaseAccountApi<UploadAvatarResponse> {
    private String webUri;

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void onStatusError(JSONObject jSONObject, JSONObject jSONObject2) {
    }

    public UploadAvatarJob(Context context, ApiRequest apiRequest, UploadAvatarCallback uploadAvatarCallback) {
        super(context, apiRequest, uploadAvatarCallback);
    }

    public static UploadAvatarJob uploadAvatar(Context context, String str, UploadAvatarCallback uploadAvatarCallback) {
        return new UploadAvatarJob(context, new ApiRequest.Builder().url(UserInfoNetConstants.getUploadAvatarPath()).file("avatar", str).postFile(), uploadAvatarCallback);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public UploadAvatarResponse transformResponse(boolean z, ApiResponse apiResponse) {
        UploadAvatarResponse uploadAvatarResponse = new UploadAvatarResponse(z, UserInfoNetConstants.API_UPLOAD_AVATAR);
        if (z) {
            uploadAvatarResponse.webUri = this.webUri;
        } else {
            uploadAvatarResponse.error = apiResponse.mError;
            uploadAvatarResponse.errorMsg = apiResponse.mErrorMsg;
        }
        return uploadAvatarResponse;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void parseData(JSONObject jSONObject, JSONObject jSONObject2) throws Exception {
        this.webUri = jSONObject2.optString("web_uri");
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public void onSendEvent(UploadAvatarResponse uploadAvatarResponse) {
        AccountMonitorUtil.onEvent(UserInfoNetConstants.EventName.UPLOAD_AVATAR, null, null, uploadAvatarResponse, this.mApiCall);
    }
}
