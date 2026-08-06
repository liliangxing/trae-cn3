package com.bytedance.bdinstall.storage;

import android.accounts.Account;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.Utils;
import com.bytedance.bdinstall.migrate.MigrateDetector;
import com.bytedance.bdinstall.service.IInstallParameters;
import com.bytedance.bdinstall.util.HardwareUtils;
import com.bytedance.bdinstall.util.LocalConstants;
import com.bytedance.bdinstall.util.RomUtils;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.UUID;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public abstract class AbsDeviceParamsProvider implements IInstallParameters {
    private static final String LOCAL_TEST_SUFFIX_STR = "_local";
    protected AccountCache mAccountCache;
    protected Cache mCache;
    protected final Context mContext;
    protected final String mLocalTestSuffix;
    protected final StorageSettings mSettings;
    private volatile String sDeviceId;
    protected String sOpenClientUdid;
    protected String sOpenUdid;

    private String createLocalTestSuffix(boolean z) {
        return z ? LOCAL_TEST_SUFFIX_STR : "";
    }

    protected void buildFileCacher(StorageSettings storageSettings, Cache cache) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbsDeviceParamsProvider(Context context, StorageSettings storageSettings) {
        this.mLocalTestSuffix = createLocalTestSuffix(storageSettings.isLocalTest());
        Context applicationContext = context.getApplicationContext();
        this.mContext = applicationContext;
        this.mSettings = storageSettings;
        this.mCache = new SPCache(applicationContext, storageSettings.getSp(), storageSettings.getOptions());
        if (!MigrateDetector.isThisDeviceMigrate(context, storageSettings.getOptions())) {
            AccountCache accountCache = new AccountCache(context, storageSettings.getSuffix(), storageSettings.getOptions());
            this.mAccountCache = accountCache;
            this.mCache.setSuccessor(accountCache);
            AccountCache accountCache2 = this.mAccountCache;
            if ((!RomUtils.isAndroidROrHigher() || !RomUtils.isTargetROrHigher(context)) && storageSettings.isNeedSharedStorage()) {
                buildFileCacher(storageSettings, accountCache2);
            }
        }
        setAccount(storageSettings.getAccount());
    }

    @Override // com.bytedance.bdinstall.service.IInstallParameters
    public String getOpenUdid(boolean z) {
        if (!TextUtils.isEmpty(this.sOpenUdid)) {
            return this.sOpenUdid;
        }
        String secureAndroidId = HardwareUtils.getSecureAndroidId(this.mContext);
        SharedPreferences commonSp = LocalConstants.getCommonSp(this.mContext, this.mSettings.getOptions());
        String string = commonSp.getString("openudid", null);
        try {
            if (!Utils.isValidUDID(secureAndroidId) || IInstallParameters.FAKE_ANDROID_ID.equals(secureAndroidId)) {
                if (!Utils.isValidUDID(string)) {
                    string = new BigInteger(80, new SecureRandom()).toString(16);
                    if (string.charAt(0) == '-') {
                        string = string.substring(1);
                    }
                    int length = 13 - string.length();
                    if (length > 0) {
                        StringBuilder sb = new StringBuilder();
                        while (length > 0) {
                            sb.append('F');
                            length--;
                        }
                        sb.append(string);
                        secureAndroidId = sb.toString();
                    }
                }
                secureAndroidId = string;
            }
        } catch (Exception unused) {
        }
        SharedPreferences.Editor edit = commonSp.edit();
        edit.putString("openudid", secureAndroidId);
        edit.apply();
        if (!TextUtils.isEmpty(secureAndroidId)) {
            secureAndroidId = secureAndroidId + this.mLocalTestSuffix;
        }
        if (!TextUtils.isEmpty(secureAndroidId)) {
            this.sOpenUdid = secureAndroidId;
        }
        return secureAndroidId;
    }

    @Override // com.bytedance.bdinstall.service.IInstallParameters
    public String getClientUDID() {
        if (!TextUtils.isEmpty(this.sOpenClientUdid)) {
            return this.sOpenClientUdid;
        }
        try {
            SharedPreferences commonSp = LocalConstants.getCommonSp(this.mContext, this.mSettings.getOptions());
            String string = commonSp.getString("clientudid", null);
            if (!Utils.isValidUDID(string)) {
                string = UUID.randomUUID().toString();
                SharedPreferences.Editor edit = commonSp.edit();
                edit.putString("clientudid", string);
                edit.apply();
            }
            if (!TextUtils.isEmpty(string)) {
                string = string + this.mLocalTestSuffix;
            }
            this.sOpenClientUdid = string;
            return string;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override // com.bytedance.bdinstall.service.IInstallParameters
    public String getDeviceId() {
        if (!TextUtils.isEmpty(this.sDeviceId)) {
            return this.sDeviceId;
        }
        this.sDeviceId = this.mCache.loadDeviceId("", "");
        return this.sDeviceId;
    }

    @Override // com.bytedance.bdinstall.service.IInstallParameters
    public void updateDeviceId(String str) {
        if (!Utils.checkId(str) || Utils.equal(str, this.sDeviceId)) {
            return;
        }
        this.sDeviceId = this.mCache.loadDeviceId(str, this.sDeviceId);
    }

    @Override // com.bytedance.bdinstall.service.IInstallParameters
    public void setAccount(Account account) {
        AccountCache accountCache = this.mAccountCache;
        if (accountCache != null) {
            accountCache.setAccount(this.mSettings.getOptions().getAidString(), account);
        }
    }

    public void clear(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.sDeviceId = null;
        String str2 = Api.KEY_CLEAR_KEY_PREFIX + str;
        SharedPreferences sp = this.mSettings.getSp();
        if (sp.getBoolean(str2, false)) {
            return;
        }
        SharedPreferences.Editor edit = sp.edit();
        edit.putBoolean(str2, true);
        if (sp.contains("device_id")) {
            edit.remove("device_id");
        }
        if (sp.contains("install_id")) {
            edit.remove("install_id");
        }
        edit.apply();
        this.mCache.clear(Collections.singletonList("device_id"));
    }

    public AccountCache getCache() {
        return this.mAccountCache;
    }
}
