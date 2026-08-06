package com.ss.android.deviceregister.base;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.common.utility.StringUtils;
import com.ss.android.deviceregister.core.cache.internal.EncryptUtils;

/* loaded from: classes7.dex */
public class AppLogConstants {
    public static final String KEY_AID = "aid";
    public static final String KEY_CLEAR_KEY_PREFIX = "clear_key_prefix";
    public static final String KEY_CLIENTUDID = "clientudid";
    public static final String KEY_DEVICE_ID = "device_id";
    public static final String KEY_FIRST_INSTALL_TIME = "apk_first_install_time";
    public static final String KEY_HEADER = "header";
    public static final String KEY_INSTALL_ID = "install_id";
    public static final String KEY_IS_SYSTEM_APP = "is_system_app";
    public static final String KEY_OPENUDID = "openudid";
    public static final String KEY_PRE_INSTALL_CHANNEL = "pre_installed_channel";
    public static final String KEY_SERIAL_NUMBER = "serial_number";
    public static final String KEY_SIM_SERIAL_NUMBER = "sim_serial_number";
    public static final String KEY_UDID = "udid";
    public static final String KEY_UDID_LIST = "udid_list";
    public static final String KEY_USER_AGENT = "user_agent";
    public static final String KLINK_EGDI = "klink_egdi";
    public static final int MAX_UDID_LENGTH = 160;
    public static final int MIN_UDID_LENGTH = 13;
    public static final int SC_UNKNOWN = 1;
    public static final String SDCARD_CLIENTUDID_FNAME = "clientudid.dat";
    public static final String SDCARD_OPENUDID_FNAME = "openudid.dat";
    private static volatile String SP_APPLOG_STATS = "applog_stats";
    private static String SP_OPENUDID;
    private static boolean sAnonymous;

    public static void setSPName(String str) {
        if (StringUtils.isEmpty(str)) {
            return;
        }
        SP_APPLOG_STATS = str;
    }

    public static String getSPName() {
        return SP_APPLOG_STATS;
    }

    public static void setAnonymous(boolean z) {
        sAnonymous = z;
    }

    public static boolean isAnonymous() {
        return sAnonymous;
    }

    public static String getDeviceParamsSpName() {
        if (TextUtils.isEmpty(SP_OPENUDID)) {
            SP_OPENUDID = EncryptUtils.base64DecodeToString("c25zc2RrX29wZW51ZGlk");
        }
        return SP_OPENUDID;
    }

    public static SharedPreferences getApplogStatsSp(Context context) {
        return context.getSharedPreferences(getSPName(), 0);
    }
}
