package com.bytedance.sdk.account.job;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.account.api.BDAccountNetApi;
import com.bytedance.sdk.account.api.call.AbsApiCall;
import com.bytedance.sdk.account.api.call.BaseApiResponse;
import com.bytedance.sdk.account.api.response.CommonRequestResponse;
import com.bytedance.sdk.account.execute.ApiRequest;
import com.bytedance.sdk.account.execute.ApiResponse;
import com.bytedance.sdk.account.impl.ApiHelper;
import com.bytedance.sdk.account.impl.BaseAccountApi;
import com.bytedance.sdk.account.monitor.AccountMonitorConstants;
import com.bytedance.sdk.account.monitor.AccountMonitorUtil;
import com.bytedance.sdk.account.settings.common.CommonConfigManager;
import com.bytedance.sdk.account.user.IBDAccountUserEntity;
import com.bytedance.sdk.account.utils.CommonRequestCacheHelper;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class CommonRequestJob extends BaseAccountApi<CommonRequestResponse> {
    private JSONObject mData;
    private JSONObject mResult;
    private IBDAccountUserEntity mUserEntity;

    private CommonRequestJob(Context context, ApiRequest apiRequest, AbsApiCall<CommonRequestResponse> absApiCall) {
        super(context, apiRequest, absApiCall);
    }

    public static CommonRequestJob doCommonRequest(Context context, String str, Map<String, String> map, Map<String, String> map2, boolean z, AbsApiCall<CommonRequestResponse> absApiCall) {
        return new CommonRequestJob(context, getRequest(str, map, map2, z), absApiCall);
    }

    public static CommonRequestJob doCommonGetRequestWithUrl(Context context, String str, Map<String, String> map, Map<String, String> map2, AbsApiCall<CommonRequestResponse> absApiCall) {
        return new CommonRequestJob(context, getRequest(str, map, map2, true), absApiCall);
    }

    public static CommonRequestJob doCommonGetRequestWithUrlWithCache(Context context, String str, Map<String, String> map, Map<String, String> map2, long j, AbsApiCall<CommonRequestResponse> absApiCall) {
        if (hasCache(CommonRequestCacheHelper.getPathFromUrl(str), map2, absApiCall)) {
            return null;
        }
        ApiRequest request = getRequest(str, map, map2, true);
        request.keepTime = j;
        return new CommonRequestJob(context, request, absApiCall);
    }

    public static CommonRequestJob doCommonGetRequestWithPath(Context context, String str, Map<String, String> map, Map<String, String> map2, AbsApiCall<CommonRequestResponse> absApiCall) {
        return new CommonRequestJob(context, getRequest(BDAccountNetApi.getUrl(str), map, map2, true), absApiCall);
    }

    public static CommonRequestJob doCommonGetRequestWithPathWithCache(Context context, String str, Map<String, String> map, Map<String, String> map2, long j, AbsApiCall<CommonRequestResponse> absApiCall) {
        if (hasCache(str, map2, absApiCall)) {
            return null;
        }
        ApiRequest request = getRequest(BDAccountNetApi.getUrl(str), map, map2, true);
        request.keepTime = j;
        return new CommonRequestJob(context, request, absApiCall);
    }

    public static CommonRequestJob doCommonPostRequestWithUrl(Context context, String str, Map<String, String> map, Map<String, String> map2, AbsApiCall<CommonRequestResponse> absApiCall) {
        return new CommonRequestJob(context, getRequest(str, map, map2, false), absApiCall);
    }

    public static CommonRequestJob doCommonPostRequestWithUrlWithCache(Context context, String str, Map<String, String> map, Map<String, String> map2, long j, AbsApiCall<CommonRequestResponse> absApiCall) {
        if (hasCache(CommonRequestCacheHelper.getPathFromUrl(str), map2, absApiCall)) {
            return null;
        }
        ApiRequest request = getRequest(str, map, map2, false);
        request.keepTime = j;
        return new CommonRequestJob(context, request, absApiCall);
    }

    public static CommonRequestJob doCommonPostRequestWithPath(Context context, String str, Map<String, String> map, Map<String, String> map2, AbsApiCall<CommonRequestResponse> absApiCall) {
        return new CommonRequestJob(context, getRequest(BDAccountNetApi.getUrl(str), map, map2, false), absApiCall);
    }

    public static CommonRequestJob doCommonPostRequestWithPathWithCache(Context context, String str, Map<String, String> map, Map<String, String> map2, long j, AbsApiCall<CommonRequestResponse> absApiCall) {
        if (hasCache(str, map2, absApiCall)) {
            return null;
        }
        ApiRequest request = getRequest(BDAccountNetApi.getUrl(str), map, map2, false);
        request.keepTime = j;
        return new CommonRequestJob(context, request, absApiCall);
    }

    private static boolean hasCache(String str, Map<String, String> map, AbsApiCall<CommonRequestResponse> absApiCall) {
        try {
            String cache = CommonRequestCacheHelper.getInstance().getCache(str, map);
            if (TextUtils.isEmpty(cache)) {
                return false;
            }
            CommonRequestResponse commonRequestResponse = new CommonRequestResponse(true, BaseApiResponse.API_COMMON_REQUEST);
            JSONObject jSONObject = new JSONObject(cache);
            commonRequestResponse.result = jSONObject.optJSONObject("result");
            commonRequestResponse.data = jSONObject.optJSONObject("data");
            if (!TextUtils.isEmpty(commonRequestResponse.data.optString("user_id"))) {
                commonRequestResponse.userInfo = ApiHelper.UserApiHelper.parseUserInfo(commonRequestResponse.result);
            }
            absApiCall.onResponse(commonRequestResponse);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private static ApiRequest getRequest(String str, Map<String, String> map, Map<String, String> map2, boolean z) {
        ApiRequest.Builder parameters = new ApiRequest.Builder().url(str).addHeaders(map).parameters(map2);
        if (z) {
            return parameters.get();
        }
        return parameters.post();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public CommonRequestResponse transformResponse(boolean z, ApiResponse apiResponse) {
        CommonRequestResponse commonRequestResponse = new CommonRequestResponse(z, BaseApiResponse.API_COMMON_REQUEST);
        if (!z) {
            commonRequestResponse.error = apiResponse.mError;
            commonRequestResponse.errorMsg = apiResponse.mErrorMsg;
        } else {
            commonRequestResponse.userInfo = this.mUserEntity;
        }
        commonRequestResponse.result = this.mResult;
        commonRequestResponse.data = this.mData;
        if (z && apiResponse.request.keepTime > 0) {
            String pathFromUrl = CommonRequestCacheHelper.getPathFromUrl(apiResponse.mRequestUrl);
            Map<String, String> map = apiResponse.request.parms;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("result", commonRequestResponse.result);
                jSONObject.put("data", commonRequestResponse.data);
                CommonRequestCacheHelper.getInstance().putCache(pathFromUrl, map, jSONObject.toString(), System.currentTimeMillis() + apiResponse.request.keepTime);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return commonRequestResponse;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void onStatusError(JSONObject jSONObject, JSONObject jSONObject2) {
        this.mResult = jSONObject2;
        this.mData = jSONObject;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void parseData(JSONObject jSONObject, JSONObject jSONObject2) throws Exception {
        this.mResult = jSONObject;
        this.mData = jSONObject2;
        boolean z = false;
        boolean z2 = jSONObject2.optLong("user_id", 0L) > 0;
        int commonRequestParseUserInfoDecision = CommonConfigManager.getCommonRequestParseUserInfoDecision();
        if (z2 && (commonRequestParseUserInfoDecision & 1) != 0) {
            if (!TextUtils.isEmpty(this.apiRequest.url) && this.apiRequest.url.contains("/passport/")) {
                z = true;
            }
            z2 = z;
        }
        if (z2 && (commonRequestParseUserInfoDecision & 2) != 0) {
            z2 = !TextUtils.isEmpty(this.apiResponse.xTtToken);
        }
        if (z2) {
            this.mUserEntity = ApiHelper.UserApiHelper.parseUserInfo(jSONObject);
        }
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public void onSendEvent(CommonRequestResponse commonRequestResponse) {
        AccountMonitorUtil.onEvent(AccountMonitorConstants.EventAccount.PASSPORT_SDK_COMMON_REQUEST, null, null, commonRequestResponse, this.mApiCall);
    }
}
