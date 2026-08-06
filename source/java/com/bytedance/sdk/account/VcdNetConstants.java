package com.bytedance.sdk.account;

import com.bytedance.sdk.account.api.BDAccountNetApi;

/* loaded from: classes5.dex */
public class VcdNetConstants extends BDAccountNetApi {
    public static final int API_VCD_ACCOUNT_SWITCH = 2000;
    public static final int API_VCD_AUTHORIZE = 2005;
    public static final int API_VCD_GET_ACCOUNT_BY_TICKET = 2002;
    public static final int API_VCD_GET_AUTH_ACCOUNT = 2003;
    public static final int API_VCD_GET_LOGIN_TICKET = 2001;
    public static final int API_VCD_LOGIN_BY_TICKET = 2004;
    public static final String VCD_AUTHORIZE = "/user/vcd/authorize/";
    public static final String VCD_GET_AUTH_ACCOUNT = "/passport/vcd/get_auth_account/";
    public static final String VCD_GET_LOGIN_TICKET = "/passport/vcd/get_login_ticket/";
    public static final String VCD_GET_USER_INFO_BY_TICKET = "/passport/vcd/get_user_info_by_ticket/";
    public static final String VCD_LOGIN_BY_TICKET = "/passport/vcd/login_by_ticket/";
    public static final String VCD_SWITCH_ACCOUNT = "/passport/vcd/switch_account/";

    public static String getVcdSwitchAccountPath() {
        return getUrl(VCD_SWITCH_ACCOUNT);
    }

    public static String getVcdLoginTicketPath() {
        return getUrl(VCD_GET_LOGIN_TICKET);
    }

    public static String getVcdGetAuthAccountPath() {
        return getUrl(VCD_GET_AUTH_ACCOUNT);
    }

    public static String getVcdGetUserInfoByTicketPath() {
        return getUrl(VCD_GET_USER_INFO_BY_TICKET);
    }

    public static String getVcdAuthorizePath() {
        return getUrl(VCD_AUTHORIZE);
    }

    public static String getVcdLoginByTicketPath() {
        return getUrl(VCD_LOGIN_BY_TICKET);
    }
}
