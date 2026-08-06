package com.bytedance.bdinstall;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.bdinstall.SubpSyncManager;
import com.bytedance.bdinstall.util.LocalConstants;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class Cdid {
    public static final String KEY_CDID = "cdid";
    private static final String KEY_MIGRATE = "cdid_migrate";
    private static Map<String, String> sCdidMap = new ConcurrentHashMap(4);

    private Cdid() {
    }

    public static String get(InstallOptions installOptions) {
        if (installOptions == null) {
            return null;
        }
        String aidString = installOptions.getAidString();
        String str = sCdidMap.get(aidString);
        if (str == null) {
            synchronized (Cdid.class) {
                if (str == null) {
                    if (Utils.isMainProcess(installOptions.getContext())) {
                        str = getCdidLocked(installOptions);
                        sCdidMap.put(aidString, str);
                        SubpSyncManager.inst(installOptions.getContext()).sendSubpEvent(installOptions.getAidString(), KEY_CDID, str);
                    } else {
                        str = getCdidWithChildProcess(installOptions.getContext(), installOptions);
                    }
                }
            }
        }
        return str;
    }

    private static String getCdidWithChildProcess(Context context, InstallOptions installOptions) {
        if (context == null || installOptions == null) {
            return null;
        }
        SubpSyncManager.inst(context).observer(installOptions.getAidString(), KEY_CDID, new SubpSyncManager.OnUpdateListener() { // from class: com.bytedance.bdinstall.Cdid.1
            @Override // com.bytedance.bdinstall.SubpSyncManager.OnUpdateListener
            public void onUpdate(String str, String str2) {
                Cdid.sCdidMap.put(str2, str);
            }
        });
        return sCdidMap.get(installOptions.getAidString());
    }

    private static String getCdidLocked(InstallOptions installOptions) {
        if (installOptions == null) {
            return null;
        }
        SharedPreferences commonSp = LocalConstants.getCommonSp(installOptions.getContext(), installOptions);
        String string = commonSp.getString(KEY_CDID, null);
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        SharedPreferences sharedPreferences = installOptions.getContext().getSharedPreferences(installOptions.isMainInstance() ? LocalConstants.getOldSpName() : LocalConstants.getOldSpName() + "_" + installOptions.getAid(), 0);
        String string2 = sharedPreferences.getString(KEY_CDID, null);
        if (TextUtils.isEmpty(string2)) {
            string2 = UUID.randomUUID().toString();
        }
        String str = string2;
        sharedPreferences.edit().putString(KEY_CDID, str).apply();
        commonSp.edit().putString(KEY_CDID, str).putBoolean(KEY_MIGRATE, true).apply();
        return str;
    }

    public static void clearCdid(Context context, InstallOptions installOptions) {
        if (context == null || installOptions == null) {
            return;
        }
        sCdidMap.remove(installOptions.getAidString());
        LocalConstants.getCommonSp(context, installOptions).edit().remove(KEY_CDID).apply();
        SharedPreferences sharedPreferences = context.getSharedPreferences(installOptions.isMainInstance() ? LocalConstants.getOldSpName() : LocalConstants.getOldSpName() + "_" + installOptions.getAid(), 0);
        if (sharedPreferences.contains(KEY_CDID)) {
            sharedPreferences.edit().remove(KEY_CDID).apply();
        }
    }

    public static String getMainInstanceCdid(Context context) {
        if (context == null) {
            return null;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences(LocalConstants.getOldSpName(), 0);
        String string = sharedPreferences.getString(KEY_CDID, null);
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        String uuid = UUID.randomUUID().toString();
        sharedPreferences.edit().putString(KEY_CDID, uuid).apply();
        return uuid;
    }
}
