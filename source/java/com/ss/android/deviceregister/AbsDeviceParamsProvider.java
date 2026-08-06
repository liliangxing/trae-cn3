package com.ss.android.deviceregister;

import android.accounts.Account;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.ss.android.common.applog.NetUtil;
import com.ss.android.common.util.TLog;
import com.ss.android.deviceregister.base.AppLogConstants;
import com.ss.android.deviceregister.core.cache.IDeviceRegisterParameter;
import com.ss.android.deviceregister.core.cache.internal.AccountCacheHelper;
import com.ss.android.deviceregister.core.cache.internal.CacheHelper;
import com.ss.android.deviceregister.core.cache.internal.EncryptUtils;
import com.ss.android.deviceregister.core.cache.internal.SharePreferenceCacheHandler;
import com.ss.android.deviceregister.utils.DeviceRegistrationUtils;
import com.ss.android.deviceregister.utils.HardwareUtils;
import com.ss.android.deviceregister.utils.RomUtils;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public abstract class AbsDeviceParamsProvider implements IDeviceRegisterParameter {
    private static final String LOCAL_TEST_SUFFIX_STR = "_local";
    private static final String TAG = "DeviceParamsProvider";
    private static volatile String sDeviceId;
    private static String sOpenClientUdid;
    private static String sOpenUdid;
    private final AccountCacheHelper mAccountCacheHandler;
    private CacheHelper mCacheHandler;
    protected final Context mContext;
    protected final boolean mIsLocal;
    protected final String mLocalTestSuffix;

    private String createLocalTestSuffix(boolean z) {
        return z ? LOCAL_TEST_SUFFIX_STR : "";
    }

    protected void buildFileCacher(DeprecatedFileCleaner deprecatedFileCleaner, CacheHelper cacheHelper) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbsDeviceParamsProvider(Context context, boolean z) {
        this.mLocalTestSuffix = createLocalTestSuffix(z);
        this.mIsLocal = z;
        Context applicationContext = context.getApplicationContext();
        this.mContext = applicationContext;
        DeprecatedFileCleaner deprecatedFileCleaner = new DeprecatedFileCleaner(context, AppLogConstants.isAnonymous());
        this.mCacheHandler = new SharePreferenceCacheHandler(applicationContext);
        AccountCacheHelper accountCacheHelper = new AccountCacheHelper(applicationContext);
        this.mAccountCacheHandler = accountCacheHelper;
        this.mCacheHandler.setSuccessor(accountCacheHelper);
        if ((!RomUtils.isAndroidROrHigher() || !RomUtils.isTargetROrHigher(context)) && DeviceRegisterManager.isNeedSharedStorage()) {
            buildFileCacher(deprecatedFileCleaner, accountCacheHelper);
        }
        if (!DeviceRegisterManager.isDeleteSharedStorage() || DeviceRegisterManager.isNeedSharedStorage()) {
            return;
        }
        deprecatedFileCleaner.execute();
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0023, code lost:
    
        if (r0.length() >= 13) goto L27;
     */
    @Override // com.ss.android.deviceregister.core.cache.IDeviceRegisterParameter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String getOpenUdid(boolean z) {
        if (!StringUtils.isEmpty(sOpenUdid)) {
            return sOpenUdid;
        }
        String secureAndroidId = HardwareUtils.getSecureAndroidId(this.mContext);
        if (secureAndroidId != null) {
            try {
                if (!secureAndroidId.equals("9774d56d682e549c")) {
                }
            } catch (Exception e) {
                TLog.m76e("DeviceParamsProviderexception when making openudid: ", e);
            }
        }
        SharedPreferences sharedPreferences = this.mContext.getSharedPreferences(AppLogConstants.getDeviceParamsSpName(), 0);
        String string = sharedPreferences.getString("openudid", null);
        if (!DeviceRegistrationUtils.isValidUDID(string)) {
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
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString("openudid", string);
            edit.commit();
        }
        secureAndroidId = string;
        if (!StringUtils.isEmpty(secureAndroidId)) {
            secureAndroidId = secureAndroidId + this.mLocalTestSuffix;
        }
        if (!StringUtils.isEmpty(secureAndroidId)) {
            sOpenUdid = secureAndroidId;
        }
        return secureAndroidId;
    }

    @Override // com.ss.android.deviceregister.core.cache.IDeviceRegisterParameter
    public String getClientUDID() {
        if (!TextUtils.isEmpty(sOpenClientUdid)) {
            return sOpenClientUdid;
        }
        try {
            SharedPreferences sharedPreferences = this.mContext.getSharedPreferences(AppLogConstants.getDeviceParamsSpName(), 0);
            String string = sharedPreferences.getString("clientudid", null);
            if (!DeviceRegistrationUtils.isValidUDID(string)) {
                string = UUID.randomUUID().toString();
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putString("clientudid", string);
                edit.commit();
            }
            if (!StringUtils.isEmpty(string)) {
                string = string + this.mLocalTestSuffix;
            }
            sOpenClientUdid = string;
            return string;
        } catch (Exception e) {
            TLog.m82w("DeviceParamsProvider exception when making client_udid: ", e);
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addSuffixToId(JSONArray jSONArray, String str) throws JSONException {
        if (jSONArray == null || jSONArray.length() == 0) {
            return;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("id");
                if (!TextUtils.isEmpty(optString)) {
                    optJSONObject.remove("id");
                    optJSONObject.put("id", optString + str);
                }
            }
        }
    }

    @Override // com.ss.android.deviceregister.core.cache.IDeviceRegisterParameter
    public String getDeviceId() {
        synchronized (this) {
            if (!StringUtils.isEmpty(sDeviceId)) {
                return sDeviceId;
            }
            sDeviceId = this.mCacheHandler.loadDeviceId("", "");
            return sDeviceId;
        }
    }

    @Override // com.ss.android.deviceregister.core.cache.IDeviceRegisterParameter
    public void updateDeviceId(String str) {
        if (NetUtil.isBadId(str) || StringUtils.equal(str, sDeviceId)) {
            return;
        }
        sDeviceId = this.mCacheHandler.loadDeviceId(str, sDeviceId);
    }

    @Override // com.ss.android.deviceregister.core.cache.IDeviceRegisterParameter
    public void clear(String str) {
        if (TextUtils.equals(str, "device_id")) {
            sDeviceId = null;
        }
        if (TextUtils.equals(str, "openudid")) {
            sOpenUdid = null;
        }
        if (TextUtils.equals(str, "clientudid")) {
            sOpenClientUdid = null;
        }
        this.mCacheHandler.clear(str);
    }

    public void setAccount(Account account) {
        this.mAccountCacheHandler.setAccount(account);
    }

    public void clearDidAndIid(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        sDeviceId = null;
        String str2 = AppLogConstants.KEY_CLEAR_KEY_PREFIX + str;
        SharedPreferences applogStatsSp = AppLogConstants.getApplogStatsSp(context);
        if (!applogStatsSp.getBoolean(str2, false)) {
            SharedPreferences.Editor edit = applogStatsSp.edit();
            edit.putBoolean(str2, true);
            if (applogStatsSp.contains("device_id")) {
                edit.remove("device_id");
            }
            if (applogStatsSp.contains("install_id")) {
                edit.remove("install_id");
            }
            edit.commit();
            this.mCacheHandler.clear("device_id");
            if (Logger.debug()) {
                TLog.m81w("DeviceParamsProvider clearKey : " + str + " :clear installId and deviceId finish");
            }
        } else if (Logger.debug()) {
            TLog.m81w("DeviceParamsProvider clearKey : " + str + " : is already cleared");
        }
        LogUtils.m88d(LogUtils.TAG, "DeviceParamsProvider#clear mCacheHandler.loadDeviceId()=" + this.mCacheHandler.loadDeviceId("", ""));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getKey(Context context) {
        String str = context.getString(C0451R.string.key_external_derectory_device_parameter) + EncryptUtils.getBytedanceString();
        return new String(new char[]{str.charAt(1), str.charAt(3), str.charAt(1), str.charAt(11), str.charAt(15), str.charAt(10), str.charAt(8), str.charAt(17), str.charAt(9), str.charAt(9), str.charAt(12), str.charAt(13), str.charAt(13), str.charAt(5), str.charAt(18), str.charAt(13), str.charAt(14), str.charAt(11), str.charAt(4), str.charAt(19), str.charAt(7)}).substring(2, 18);
    }
}
