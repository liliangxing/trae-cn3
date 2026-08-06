package com.bytedance.sdk.account.job;

import android.content.Context;
import com.bytedance.sdk.account.api.BDAccountNetApi;
import com.bytedance.sdk.account.api.call.BaseApiResponse;
import com.bytedance.sdk.account.api.callback.LoginInfoCallback;
import com.bytedance.sdk.account.api.response.LoginInfoResponse;
import com.bytedance.sdk.account.execute.ApiRequest;
import com.bytedance.sdk.account.execute.ApiResponse;
import com.bytedance.sdk.account.impl.ApiHelper;
import com.bytedance.sdk.account.impl.BaseAccountApi;
import com.bytedance.sdk.account.monitor.AccountMonitorConstants;
import com.bytedance.sdk.account.monitor.AccountMonitorUtil;
import com.bytedance.sdk.account.save.SaveConstants;
import com.bytedance.sdk.account.save.database.DBService;
import com.bytedance.sdk.account.save.entity.LoginInfo;
import com.bytedance.sdk.account.save.entity.LoginType;
import com.bytedance.sdk.account.user.LoginInfoEntity;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class GetLoginInfoJob extends BaseAccountApi<LoginInfoResponse> {
    private Map<Integer, LoginInfoEntity> loginInfoEntityMap;
    private boolean matchDB;

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void onStatusError(JSONObject jSONObject, JSONObject jSONObject2) {
    }

    public GetLoginInfoJob(Context context, ApiRequest apiRequest, boolean z, LoginInfoCallback loginInfoCallback) {
        this(context, apiRequest, loginInfoCallback);
        this.matchDB = z;
    }

    public GetLoginInfoJob(Context context, ApiRequest apiRequest, LoginInfoCallback loginInfoCallback) {
        super(context, apiRequest, loginInfoCallback);
    }

    public static GetLoginInfoJob getDeviceLoginInfo(Context context, boolean z, int i, int i2, LoginInfoCallback loginInfoCallback) {
        return new GetLoginInfoJob(context, new ApiRequest.Builder().url(BDAccountNetApi.getDeviceLoginInfoPath()).parameter("info_type", String.valueOf(i)).parameter("time_range", String.valueOf(i2)).post(), z, loginInfoCallback);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public LoginInfoResponse transformResponse(boolean z, ApiResponse apiResponse) {
        LoginInfoResponse loginInfoResponse = new LoginInfoResponse(z, BaseApiResponse.API_DEVICE_LOGIN_INFO);
        if (z) {
            if (this.matchDB) {
                matchClearData();
                if (this.loginInfoEntityMap.size() != 0) {
                    loginInfoResponse.loginInfoEntityMap = this.loginInfoEntityMap;
                } else {
                    loginInfoResponse.success = false;
                    loginInfoResponse.error = -7;
                    loginInfoResponse.errorMsg = SaveConstants.Error.MSG_MATCH_NOTHING;
                }
            } else {
                loginInfoResponse.loginInfoEntityMap = this.loginInfoEntityMap;
            }
        } else {
            loginInfoResponse.error = apiResponse.mError;
            loginInfoResponse.errorMsg = apiResponse.mErrorMsg;
        }
        return loginInfoResponse;
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    protected void parseData(JSONObject jSONObject, JSONObject jSONObject2) throws Exception {
        this.loginInfoEntityMap = ApiHelper.UserApiHelper.parseLoginInfo(jSONObject2);
    }

    @Override // com.bytedance.sdk.account.impl.BaseAccountApi
    public void onSendEvent(LoginInfoResponse loginInfoResponse) {
        AccountMonitorUtil.onGetLoginInfoEvent(AccountMonitorConstants.EventAccount.GET_DEVICE_LOGIN_INFO, loginInfoResponse, null);
    }

    private void matchClearData() {
        if (this.loginInfoEntityMap == null) {
            return;
        }
        for (int i = 1; i <= 3; i++) {
            LoginInfoEntity loginInfoEntity = this.loginInfoEntityMap.get(Integer.valueOf(i));
            if (loginInfoEntity != null) {
                if (!LoginType.isInLoginType(loginInfoEntity.getLoginType().intValue())) {
                    this.loginInfoEntityMap.remove(Integer.valueOf(i));
                } else {
                    int intValue = loginInfoEntity.getLoginType().intValue();
                    if (intValue == 2 || intValue == 3) {
                        String maskMobile = loginInfoEntity.getMaskMobile();
                        LoginInfo queryMask = DBService.getInstance().queryMask(intValue, maskMobile);
                        if (queryMask != null) {
                            String info = queryMask.getInfo();
                            if (maskMobile != null && !maskMobile.equals("")) {
                                String[] split = maskMobile.split("\\*");
                                if (maskMobile.charAt(0) == '+') {
                                    loginInfoEntity.setCc(split[0]);
                                    if (info.charAt(0) == '+') {
                                        loginInfoEntity.setMobile(info.replace(split[0], ""));
                                    } else {
                                        this.loginInfoEntityMap.remove(Integer.valueOf(i));
                                    }
                                } else if (info.charAt(0) == '+') {
                                    String[] split2 = info.split(split[0]);
                                    loginInfoEntity.setCc(split2[0]);
                                    loginInfoEntity.setMobile(info.replace(split2[0], ""));
                                } else {
                                    loginInfoEntity.setCc("+86");
                                    loginInfoEntity.setMobile(info);
                                }
                            }
                        } else {
                            this.loginInfoEntityMap.remove(Integer.valueOf(i));
                        }
                    } else if (intValue == 4) {
                        LoginInfo queryMask2 = DBService.getInstance().queryMask(intValue, loginInfoEntity.getMaskEmail());
                        if (queryMask2 != null) {
                            loginInfoEntity.setEmail(queryMask2.getInfo());
                        } else {
                            this.loginInfoEntityMap.remove(Integer.valueOf(i));
                        }
                    }
                }
            }
        }
    }
}
