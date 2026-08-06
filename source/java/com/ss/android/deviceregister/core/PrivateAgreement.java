package com.ss.android.deviceregister.core;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.common.utility.concurrent.ThreadPlus;
import com.ss.android.deviceregister.I18nController;
import com.ss.android.deviceregister.utils.Singleton;

/* loaded from: classes7.dex */
public class PrivateAgreement {
    private static final String KEY_STARTED = "_install_started_v2";
    private static final String SP_INSTALL = "ug_install_settings_pref";
    private static boolean sAccepted;
    private static Singleton<SharedPreferences> sInstallSpref = new Singleton<SharedPreferences>() { // from class: com.ss.android.deviceregister.core.PrivateAgreement.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.ss.android.deviceregister.utils.Singleton
        public SharedPreferences create(Object... objArr) {
            return ((Context) objArr[0]).getSharedPreferences("ug_install_settings_pref", 0);
        }
    };

    public static boolean hasAccept(Context context) {
        if (I18nController.isI18n()) {
            return true;
        }
        if (context == null) {
            return false;
        }
        if (sAccepted) {
            return true;
        }
        return getPrivateInstallSp(context).getBoolean("_install_started_v2", false);
    }

    private static SharedPreferences getPrivateInstallSp(Context context) {
        return sInstallSpref.get(context);
    }

    public static void setAccepted(final Context context) {
        sAccepted = true;
        ThreadPlus.submitRunnable(new Runnable() { // from class: com.ss.android.deviceregister.core.PrivateAgreement.2
            @Override // java.lang.Runnable
            public void run() {
                ((SharedPreferences) PrivateAgreement.sInstallSpref.get(context)).edit().putBoolean("_install_started_v2", true).apply();
            }
        });
    }
}
