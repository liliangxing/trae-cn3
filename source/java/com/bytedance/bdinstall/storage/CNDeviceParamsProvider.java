package com.bytedance.bdinstall.storage;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.text.TextUtils;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.Utils;
import com.bytedance.bdinstall.loader.SstLoader;
import com.bytedance.bdinstall.service.IInstallParameters;
import com.bytedance.bdinstall.util.HardwareUtils;
import com.bytedance.bdinstall.util.LocalConstants;
import com.bytedance.bdinstall.util.SensitiveUtils;
import com.bytedance.bdinstall.util.StringEncryptUtils;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.UUID;
import org.json.JSONArray;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class CNDeviceParamsProvider extends AbsDeviceParamsProvider {
    private volatile String[] sAccid;
    private volatile String sSerialNumber;
    private volatile String sUdid;
    private volatile JSONArray sUdidList;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CNDeviceParamsProvider(Context context, StorageSettings storageSettings) {
        super(context, storageSettings);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00d4  */
    @Override // com.bytedance.bdinstall.storage.AbsDeviceParamsProvider, com.bytedance.bdinstall.service.IInstallParameters
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String getOpenUdid(boolean z) {
        String loadOpenUdid;
        if (!TextUtils.isEmpty(this.sOpenUdid)) {
            return this.sOpenUdid;
        }
        String secureAndroidId = HardwareUtils.getSecureAndroidId(this.mContext);
        SharedPreferences commonSp = LocalConstants.getCommonSp(this.mContext, this.mSettings.getOptions());
        String string = commonSp.getString("openudid", null);
        if (Utils.isValidUDID(secureAndroidId) && !IInstallParameters.FAKE_ANDROID_ID.equals(secureAndroidId)) {
            if (Utils.isValidUDID(string)) {
                loadOpenUdid = this.mCache.loadOpenUdid(secureAndroidId, string);
            } else {
                loadOpenUdid = this.mCache.loadOpenUdid(null, secureAndroidId);
            }
            secureAndroidId = loadOpenUdid;
            if (!TextUtils.isEmpty(secureAndroidId)) {
                secureAndroidId = secureAndroidId + this.mLocalTestSuffix;
            }
            if (!TextUtils.isEmpty(secureAndroidId)) {
                this.sOpenUdid = secureAndroidId;
            }
            return secureAndroidId;
        }
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
                string = sb.toString();
            }
            if (z) {
                String loadOpenUdid2 = this.mAccountCache != null ? this.mAccountCache.loadOpenUdid(null, string) : null;
                if (Utils.isValidUDID(loadOpenUdid2)) {
                    string = loadOpenUdid2;
                }
            }
            SharedPreferences.Editor edit = commonSp.edit();
            edit.putString("openudid", string);
            edit.apply();
        } else if (this.mAccountCache != null) {
            this.mAccountCache.loadOpenUdid(string, null);
        }
        secureAndroidId = string;
        if (!TextUtils.isEmpty(secureAndroidId)) {
        }
        if (!TextUtils.isEmpty(secureAndroidId)) {
        }
        return secureAndroidId;
    }

    @Override // com.bytedance.bdinstall.storage.AbsDeviceParamsProvider, com.bytedance.bdinstall.service.IInstallParameters
    public String getClientUDID() {
        if (!TextUtils.isEmpty(this.sOpenClientUdid)) {
            return this.sOpenClientUdid;
        }
        try {
            SharedPreferences commonSp = LocalConstants.getCommonSp(this.mContext, this.mSettings.getOptions());
            String string = commonSp.getString("clientudid", null);
            if (!Utils.isValidUDID(string)) {
                string = UUID.randomUUID().toString();
                String loadClientUdid = this.mAccountCache != null ? this.mAccountCache.loadClientUdid(null, string) : null;
                if (Utils.isValidUDID(loadClientUdid)) {
                    string = loadClientUdid;
                }
                SharedPreferences.Editor edit = commonSp.edit();
                edit.putString("clientudid", string);
                edit.apply();
            } else if (this.mAccountCache != null) {
                this.mAccountCache.loadClientUdid(string, null);
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
    public void clearAll() {
        this.mCache.clear(Arrays.asList("openudid", "clientudid", "serial_number", "sim_serial_number", SstLoader.KEY_UDID, "device_id", "install_id"));
    }

    public String getSerialNumber() {
        if (!TextUtils.isEmpty(this.sSerialNumber)) {
            return this.sSerialNumber;
        }
        try {
            String loadSerialNumber = this.mCache.loadSerialNumber(null, SensitiveUtils.getSerialNumber(this.mContext, this.mSettings.getOptions()));
            if (!TextUtils.isEmpty(loadSerialNumber)) {
                loadSerialNumber = loadSerialNumber + this.mLocalTestSuffix;
            }
            this.sSerialNumber = loadSerialNumber;
            return loadSerialNumber;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String[] getSimSerialNumbers() {
        if (this.sAccid != null && this.sAccid.length > 0) {
            return this.sAccid;
        }
        try {
            String[] loadAccId = this.mCache.loadAccId(null, SensitiveUtils.getSimSerialNumbers(this.mContext, this.mSettings.getOptions()));
            if (loadAccId == null) {
                loadAccId = new String[0];
            }
            for (int i = 0; i < loadAccId.length; i++) {
                loadAccId[i] = loadAccId[i] + this.mLocalTestSuffix;
            }
            this.sAccid = loadAccId;
            return loadAccId;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getUdId() {
        if (!TextUtils.isEmpty(this.sUdid)) {
            return this.sUdid;
        }
        try {
            String loadUdid = this.mCache.loadUdid(null, SensitiveUtils.getDeviceIdWithCache(this.mContext, this.mSettings.getOptions()));
            if (!TextUtils.isEmpty(loadUdid)) {
                loadUdid = loadUdid + this.mLocalTestSuffix;
            }
            this.sUdid = loadUdid;
            return loadUdid;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public JSONArray getUdIdList() {
        if (this.sUdidList != null) {
            return this.sUdidList;
        }
        try {
            this.sUdidList = SensitiveUtils.getMultiImei(this.mContext, this.mSettings.getOptions());
            return this.sUdidList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.bytedance.bdinstall.storage.AbsDeviceParamsProvider
    protected void buildFileCacher(StorageSettings storageSettings, Cache cache) {
        String key = getKey();
        boolean z = !storageSettings.isAnonymous();
        try {
            ExternalCache externalCache = new ExternalCache(this.mContext, z, Environment.getExternalStorageDirectory().getPath() + StringEncryptUtils.base64DecodeToString("L0FuZHJvaWQvZGF0YS9jb20uc25zc2RrLmFwaS9ieXRlZGFuY2U=") + this.mLocalTestSuffix, storageSettings.getFileName(), key, storageSettings.getOptions().getAidString());
            cache.setSuccessor(externalCache);
            cache = externalCache;
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            cache.setSuccessor(new ExternalCache(this.mContext, z, Environment.getExternalStorageDirectory().getPath() + "/" + StringEncryptUtils.getBytedanceString() + this.mLocalTestSuffix, storageSettings.getFileName(), key, storageSettings.getOptions().getAidString()));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private static String getKey() {
        String str = Api.KEY_EXTERNAL_DERECTORY_DEVICE_PARAMETER + StringEncryptUtils.getBytedanceString();
        return new String(new char[]{str.charAt(1), str.charAt(3), str.charAt(1), str.charAt(11), str.charAt(15), str.charAt(10), str.charAt(8), str.charAt(17), str.charAt(9), str.charAt(9), str.charAt(12), str.charAt(13), str.charAt(13), str.charAt(5), str.charAt(18), str.charAt(13), str.charAt(14), str.charAt(11), str.charAt(4), str.charAt(19), str.charAt(7)}).substring(2, 18);
    }
}
