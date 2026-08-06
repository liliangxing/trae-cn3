package com.bytedance.sdk.account.user;

import com.bytedance.sdk.account.constants.AccountConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class AccountShareInfo {
    public String accountExtra;
    public int accountType;
    public String errMsg;
    public String fromInstallId;
    public int isLogin;
    public String secUserId;
    public String userAvatar;
    public String userName;
    public String userSession;

    public AccountShareInfo() {
    }

    public AccountShareInfo(String str) {
        this.errMsg = str;
    }

    public static AccountShareInfo fromJsonString(String str) {
        try {
            AccountShareInfo accountShareInfo = new AccountShareInfo();
            JSONObject jSONObject = new JSONObject(str);
            accountShareInfo.fromInstallId = jSONObject.optString(AccountConstants.AccountShareCols.FROM_INSTALL_ID);
            accountShareInfo.userAvatar = jSONObject.optString(AccountConstants.AccountShareCols.USER_AVATAR);
            accountShareInfo.userSession = jSONObject.optString(AccountConstants.AccountShareCols.USER_SESSION);
            accountShareInfo.userName = jSONObject.optString("user_name");
            accountShareInfo.secUserId = jSONObject.optString(AccountConstants.AccountShareCols.SEC_USER_ID);
            accountShareInfo.isLogin = jSONObject.optInt(AccountConstants.AccountShareCols.ACCOUNT_ONLINE);
            accountShareInfo.accountExtra = jSONObject.optString(AccountConstants.AccountShareCols.ACCOUNT_EXTRA);
            accountShareInfo.accountType = jSONObject.optInt(AccountConstants.AccountShareCols.ACCOUNT_TYPE);
            return accountShareInfo;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
