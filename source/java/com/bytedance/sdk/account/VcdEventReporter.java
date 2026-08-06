package com.bytedance.sdk.account;

/* loaded from: classes5.dex */
public class VcdEventReporter {

    /* loaded from: classes5.dex */
    public interface EventPlatform {
        public static final String VCD_AUTHORIZE = "user_vcd_authorize";
        public static final String VCD_GET_ACCOUNT_BY_TICKET = "passport_vcd_get_user_info_by_ticket";
        public static final String VCD_GET_AUTH_ACCOUNT = "passport_vcd_get_auth_account";
        public static final String VCD_GET_LOGIN_TICKET = "passport_vcd_get_login_ticket";
        public static final String VCD_LOGIN_BY_TICKET = "passport_vcd_login_by_ticket";
        public static final String VCD_SWITCH_ACCOUNT = "passport_vcd_switch_account";
    }
}
