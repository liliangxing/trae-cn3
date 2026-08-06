package com.bytedance.bdinstall;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.bdinstall.util.Constants;
import com.bytedance.bdinstall.util.LocalConstants;
import com.bytedance.bdinstall.util.MultiSingleton;
import com.bytedance.bdinstall.util.Singleton;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public abstract class AbsEnv implements Cloneable {
    private InstallUrl config;
    private boolean isBoe;
    private boolean isChildMode;
    private boolean isI18n;
    private final Singleton<SharedPreferences> mSharedSp = new Singleton<SharedPreferences>() { // from class: com.bytedance.bdinstall.AbsEnv.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bytedance.bdinstall.util.Singleton
        public SharedPreferences create(Object... objArr) {
            String wrapServerIdSpName = LocalConstants.wrapServerIdSpName(AbsEnv.this);
            if (TextUtils.equals(wrapServerIdSpName, Constants.SP_INSTALL)) {
                return LocalConstants.getMainCommonSp((Context) objArr[0]);
            }
            return ((Context) objArr[0]).getSharedPreferences(wrapServerIdSpName, 0);
        }
    };
    private final MultiSingleton<SharedPreferences> mSharedSpSub = new MultiSingleton<SharedPreferences>() { // from class: com.bytedance.bdinstall.AbsEnv.2
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bytedance.bdinstall.util.MultiSingleton
        public SharedPreferences create(String str, Object... objArr) {
            String wrapServerIdSpName = LocalConstants.wrapServerIdSpName(AbsEnv.this, str);
            if (TextUtils.equals(wrapServerIdSpName, "ug_install_settings_pref_" + str)) {
                return LocalConstants.getCommonSp((Context) objArr[0], str);
            }
            return ((Context) objArr[0]).getSharedPreferences(wrapServerIdSpName, 0);
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbsEnv(InstallUrl installUrl, boolean z, boolean z2, boolean z3) {
        this.config = installUrl;
        this.isI18n = z;
        this.isBoe = z2;
        this.isChildMode = z3;
    }

    public InstallUrl getConfig() {
        return this.config;
    }

    public boolean isI18n() {
        return this.isI18n;
    }

    public boolean isBoe() {
        return this.isBoe;
    }

    public boolean isChildMode() {
        return this.isChildMode;
    }

    public String toString() {
        return "AbsEnv{isChildMode=" + this.isChildMode + ", config=" + this.config + ", isI18n=" + this.isI18n + ", isBoe=" + this.isBoe + '}';
    }

    public SharedPreferences getEnvIsolateSp(InstallOptions installOptions) {
        return installOptions.isMainInstance() ? getEnvIsolateSp(installOptions.getContext()) : getEnvIsolateSp(installOptions.getContext(), String.valueOf(installOptions.getAid()));
    }

    public SharedPreferences getEnvIsolateSp(Context context) {
        return this.mSharedSp.get(context);
    }

    public SharedPreferences getEnvIsolateSp(Context context, String str) {
        return this.mSharedSpSub.get(str, context);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbsEnv)) {
            return false;
        }
        AbsEnv absEnv = (AbsEnv) obj;
        return this.config.equals(absEnv.config) && this.isBoe == absEnv.isBoe && this.isI18n == absEnv.isI18n && this.isChildMode == absEnv.isChildMode();
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
