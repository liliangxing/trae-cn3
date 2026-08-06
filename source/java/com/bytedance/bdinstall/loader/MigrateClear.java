package com.bytedance.bdinstall.loader;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.bdinstall.Cdid;
import com.bytedance.bdinstall.Env;
import com.bytedance.bdinstall.InstallOptions;
import com.bytedance.bdinstall.Utils;
import com.bytedance.bdinstall.oaid.Oaid;
import com.bytedance.bdinstall.util.Constants;
import com.bytedance.bdinstall.util.GaidGetter;
import com.bytedance.bdinstall.util.LocalConstants;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class MigrateClear {
    MigrateClear() {
    }

    public static void clear(Context context, InstallOptions installOptions, Env env) {
        SharedPreferences envIsolateSp;
        GaidGetter.clearSp(context, installOptions);
        Utils.removeSpValues(installOptions.getSp(), new String[]{"device_id", "bd_did", "install_id", "device_token"});
        if (env != null && (envIsolateSp = env.getEnvIsolateSp(installOptions)) != null) {
            Utils.removeSpValues(envIsolateSp, new String[]{"device_id", "bd_did", "install_id", "device_token"});
        }
        try {
            Utils.removeSpValues(context.getSharedPreferences(Constants.SP_FILE_OPEN_UDID, 0), new String[]{"clientudid", "openudid", "serial_number"});
        } catch (Exception e) {
            e.printStackTrace();
        }
        Utils.removeSpValues(LocalConstants.getCommonSp(context, installOptions), new String[]{"clientudid", "openudid", "serial_number"});
        Cdid.clearCdid(context, installOptions);
        Oaid.instance(context).clear();
    }
}
