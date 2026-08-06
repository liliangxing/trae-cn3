package com.ss.android.deviceregister.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.bdinstall.BDInstall;
import com.bytedance.bdinstall.InstallOptions;
import com.bytedance.bdinstall.util.LocalConstants;
import com.ss.android.deviceregister.base.RegistrationHeaderHelper;
import java.util.UUID;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class Cdid {
    private static Singleton<String> sCdid = new CdidSingleTon();

    private Cdid() {
    }

    public static String get(Context context) {
        InstallOptions installOptions = BDInstall.getInstance().getInstallOptions();
        String str = installOptions != null ? com.bytedance.bdinstall.Cdid.get(installOptions) : null;
        return str == null ? getCdidFallback(context) : str;
    }

    public static void clear(Context context) {
        InstallOptions installOptions = BDInstall.getInstance().getInstallOptions();
        if (installOptions != null) {
            com.bytedance.bdinstall.Cdid.clearCdid(context, installOptions);
        } else {
            context.getSharedPreferences(LocalConstants.getOldSpName(), 0).edit().putString(RegistrationHeaderHelper.KEY_CDID, null).apply();
            sCdid = new CdidSingleTon();
        }
    }

    private static String getCdidFallback(Context context) {
        return sCdid.get(context);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    private static class CdidSingleTon extends Singleton<String> {
        private CdidSingleTon() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.ss.android.deviceregister.utils.Singleton
        public String create(Object... objArr) {
            if (objArr == null || objArr[0] == null) {
                return null;
            }
            SharedPreferences sharedPreferences = ((Context) objArr[0]).getSharedPreferences(LocalConstants.getOldSpName(), 0);
            String string = sharedPreferences.getString(RegistrationHeaderHelper.KEY_CDID, "");
            if (!TextUtils.isEmpty(string)) {
                return string;
            }
            String uuid = UUID.randomUUID().toString();
            sharedPreferences.edit().putString(RegistrationHeaderHelper.KEY_CDID, uuid).apply();
            return uuid;
        }
    }
}
