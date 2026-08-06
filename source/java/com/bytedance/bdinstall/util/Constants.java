package com.bytedance.bdinstall.util;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.bdinstall.AbsEnv;
import com.bytedance.bdinstall.InstallOptions;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class Constants {
    public static final long ACTIVE_RETRY_TIME = 900000;
    public static final String CLASS_TICKET_GUARD_ADAPTER = "com.bytedance.bdinstall.ticket.TicketGuardAdapter";
    public static final int DEFAULT_INSTANCE_CAPACITY = 4;
    public static final String NAME_NEW_USER_IMPL = "com.bytedance.bdinstall.nu.NUModeServiceImpl";
    public static final String PATH_ACTIVATE = "/service/2/app_alert_check/";
    public static final String PATH_REGISTER = "/service/2/device_register/";
    public static final String PATH_VERIFY = "/service/1/client_context/";
    public static final String SP_FILE_OPEN_UDID = "snssdk_openudid";
    public static final String SP_INSTALL = "ug_install_settings_pref";
    public static final String TAG_TICKET = "TicketGuard# ";
    private static final Singleton<SharedPreferences> sInstallSpref = new Singleton<SharedPreferences>() { // from class: com.bytedance.bdinstall.util.Constants.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bytedance.bdinstall.util.Singleton
        public SharedPreferences create(Object... objArr) {
            return ((Context) objArr[0]).getSharedPreferences(Constants.SP_INSTALL, 0);
        }
    };

    /* loaded from: classes3.dex */
    public static class Events {
        public static String DR_ACTIVATE_RESULT = "dr_active_result";
        public static String DR_REGISTER_PARAM = "dr_register_param";
        public static String DR_REGISTER_RESULT = "dr_register_result";
        public static String DR_VERIFY_RESULT = "dr_verify_result";
        public static String KEY_ACTIVATE = "activate";
        public static String KEY_PARAMS = "params";
        public static String KEY_REGISTER = "register";
        public static String KEY_VERIFY = "verify";
    }

    /* loaded from: classes3.dex */
    public static class TicketEvents {
        public static final String KEY_TICKET_CONSUMER_TICKET = "consumer_ticket";
        public static final String KEY_TICKET_DECRYPT = "ticket_decrypt";
        public static final String KEY_TICKET_GET_TICKET = "get_ticket";
        public static final String KEY_TICKET_HANDLE_RESPONSE = "ticket_handle_response";
        public static final String KEY_TICKET_INIT = "ticket_init";
        public static final String KEY_TICKET_TOTAL_TIME = "ticket_total_time";
    }

    public static SharedPreferences getCommonSp(Context context, InstallOptions installOptions) {
        if (installOptions != null) {
            return installOptions.isMainInstance() ? getMainCommonSp(context) : getCommonSp(context, String.valueOf(installOptions.getAid()));
        }
        return getMainCommonSp(context);
    }

    public static SharedPreferences getMainCommonSp(Context context) {
        return sInstallSpref.get(context);
    }

    public static SharedPreferences getCommonSp(Context context, String str) {
        return context.getSharedPreferences("ug_install_settings_pref_" + str, 0);
    }

    public static String wrapEnvSuffix(String str, AbsEnv absEnv) {
        if (absEnv.isI18n()) {
            str = str + "_i18n";
        }
        if (absEnv.isBoe()) {
            str = str + "_boe";
        }
        return absEnv.isChildMode() ? str + "_cm" : str;
    }

    public static String wrapServerIdSpName(AbsEnv absEnv) {
        return wrapEnvSuffix(SP_INSTALL, absEnv);
    }

    public static String wrapServerIdSpName(AbsEnv absEnv, String str) {
        return wrapEnvSuffix(SP_INSTALL, absEnv) + "_" + str;
    }
}
