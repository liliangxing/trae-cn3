package com.bytedance.sdk.account.information.method;

import android.content.Context;
import com.bytedance.sdk.account.CommonCallBack;
import com.bytedance.sdk.account.execute.ApiRequest;
import com.bytedance.sdk.account.execute.ApiResponse;
import com.bytedance.sdk.account.impl.BaseAccountApi;
import com.bytedance.sdk.account.information.UserInfoNetConstants;
import com.bytedance.sdk.account.monitor.AccountMonitorUtil;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class UploadPicJob extends BaseAccountApi<UploadPicResponse> {
    private String webUri;

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void onStatusError(JSONObject jSONObject, JSONObject jSONObject2) {
    }

    public UploadPicJob(Context context, ApiRequest apiRequest, CommonCallBack<UploadPicResponse> commonCallBack) {
        super(context, apiRequest, commonCallBack);
    }

    public static UploadPicJob uploadPic(Context context, boolean z, String str, Map<String, String> map, CommonCallBack<UploadPicResponse> commonCallBack) {
        return new UploadPicJob(context, new ApiRequest.Builder().url(UserInfoNetConstants.getUploadPicUrl()).parameter("is_sensitive", z ? "true" : "false").parameters(map).file("pic", str).postFile(), commonCallBack);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public UploadPicResponse transformResponse(boolean z, ApiResponse apiResponse) {
        UploadPicResponse uploadPicResponse = new UploadPicResponse(z, UserInfoNetConstants.API_UPLOAD_PIC);
        if (z) {
            uploadPicResponse.webUri = this.webUri;
        } else {
            uploadPicResponse.error = apiResponse.mError;
            uploadPicResponse.errorMsg = apiResponse.mErrorMsg;
        }
        return uploadPicResponse;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void parseData(JSONObject jSONObject, JSONObject jSONObject2) throws Exception {
        this.webUri = jSONObject2.optString("web_uri");
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public void onSendEvent(UploadPicResponse uploadPicResponse) {
        AccountMonitorUtil.onEvent(UserInfoNetConstants.EventName.UPLOAD_PIC, null, null, uploadPicResponse, this.mApiCall);
    }
}
