package com.bytedance.sdk.account.api;

import android.text.TextUtils;
import com.bytedance.sdk.account.api.AccountDef;
import java.util.Map;

/* loaded from: classes5.dex */
public class BDAccountEvent {
    public static final int EVENT_ACCOUNT_LOGOUT = 1;
    public static final int EVENT_ACCOUNT_MULTI_LOGOUT = 3;
    public static final int EVENT_ACCOUNT_REFRESH = 0;
    public static final int EVENT_ACCOUNT_SESSION_EXIPIRED = 2;
    public Map<String, String> extra;
    public int logoutScene;
    public String sessionDropMessage;
    public int sessionDropProtocolType;
    public boolean success;
    public final int type;

    public BDAccountEvent(int i) {
        this.type = i;
    }

    public static int getLogoutScene(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -2085722047:
                if (str.equals(AccountDef.LogoutScene.CANCEL_ACCOUNT_LOGOUT)) {
                    c = 0;
                    break;
                }
                break;
            case -1242784755:
                if (str.equals("frontier")) {
                    c = 1;
                    break;
                }
                break;
            case -355378050:
                if (str.equals(AccountDef.LogoutScene.USER_LOGOUT)) {
                    c = 2;
                    break;
                }
                break;
            case 90865289:
                if (str.equals("sdk_expired_logout")) {
                    c = 3;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return 2;
            case 1:
                return 4;
            case 2:
                return 0;
            case 3:
                return 1;
            default:
                return 3;
        }
    }
}
