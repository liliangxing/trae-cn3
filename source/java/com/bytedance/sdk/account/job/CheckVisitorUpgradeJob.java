package com.bytedance.sdk.account.job;

import android.content.Context;
import com.bytedance.sdk.account.CommonCallBack;
import com.bytedance.sdk.account.SpecialNetConstants;
import com.bytedance.sdk.account.api.call.AbsApiCall;
import com.bytedance.sdk.account.api.call.BaseApiResponse;
import com.bytedance.sdk.account.api.response.CheckVisitorUpgradeResponse;
import com.bytedance.sdk.account.execute.ApiRequest;
import com.bytedance.sdk.account.execute.ApiResponse;
import com.bytedance.sdk.account.impl.BaseAccountApi;
import com.bytedance.sdk.account.monitor.AccountMonitorConstants;
import com.bytedance.sdk.account.monitor.AccountMonitorUtil;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class CheckVisitorUpgradeJob extends BaseAccountApi<CheckVisitorUpgradeResponse> {
    private boolean mIsVisitor;

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void onStatusError(JSONObject jSONObject, JSONObject jSONObject2) {
    }

    public CheckVisitorUpgradeJob(Context context, ApiRequest apiRequest, AbsApiCall absApiCall) {
        super(context, apiRequest, absApiCall);
    }

    public static CheckVisitorUpgradeJob checkVisitorUpgrade(Context context, Map<String, String> map, CommonCallBack<CheckVisitorUpgradeResponse> commonCallBack) {
        return new CheckVisitorUpgradeJob(context, new ApiRequest.Builder().parameters(map).url(SpecialNetConstants.getCheckVisitorUpgradePath()).get(), commonCallBack);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public CheckVisitorUpgradeResponse transformResponse(boolean z, ApiResponse apiResponse) {
        CheckVisitorUpgradeResponse checkVisitorUpgradeResponse = new CheckVisitorUpgradeResponse(z, BaseApiResponse.API_CHECK_VISITOR_UPGRADE);
        if (z) {
            checkVisitorUpgradeResponse.isVisitor = this.mIsVisitor;
        } else {
            checkVisitorUpgradeResponse.error = apiResponse.mError;
            checkVisitorUpgradeResponse.errorMsg = apiResponse.mErrorMsg;
        }
        return checkVisitorUpgradeResponse;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void parseData(JSONObject jSONObject, JSONObject jSONObject2) throws Exception {
        if (jSONObject2 != null) {
            this.mIsVisitor = jSONObject2.optBoolean("is_visitor");
        }
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public void onSendEvent(CheckVisitorUpgradeResponse checkVisitorUpgradeResponse) {
        AccountMonitorUtil.onEvent(AccountMonitorConstants.EventAccount.CHECK_VISITOR_UPGRADE_PATH, null, null, checkVisitorUpgradeResponse, this.mApiCall);
    }
}
