package com.ss.android.deviceregister;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.bytedance.common.utility.StringUtils;
import com.ss.android.deviceregister.base.AppLogConstants;
import com.ss.android.deviceregister.core.cache.internal.CacheHelper;
import com.ss.android.deviceregister.core.cache.internal.EncryptUtils;
import com.ss.android.deviceregister.core.cache.internal.ExternalDirectoryCacheHelper;
import com.ss.android.deviceregister.utils.HardwareUtils;
import org.json.JSONArray;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class DeviceParamsProvider extends AbsDeviceParamsProvider {
    private static final String FILE_NAME = "device_parameters";
    private static String[] sAccid;
    private static String sSerialNumber;
    private static String sUdid;
    private static JSONArray sUdidList;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DeviceParamsProvider(Context context, boolean z) {
        super(context, z);
    }

    @Override // com.ss.android.deviceregister.AbsDeviceParamsProvider
    protected void buildFileCacher(DeprecatedFileCleaner deprecatedFileCleaner, CacheHelper cacheHelper) {
        String concat = FILE_NAME.concat(I18nController.isI18n() ? "_i18n" : "");
        if (this.mIsLocal) {
            concat = concat + "_local";
        }
        String str = concat + ".dat";
        String key = getKey(this.mContext);
        try {
            ExternalDirectoryCacheHelper externalDirectoryCacheHelper = new ExternalDirectoryCacheHelper(this.mContext, true, this.mContext.getExternalCacheDir().getParent() + "/" + (AppLogConstants.isAnonymous() ? "device_id" : EncryptUtils.getBytedanceString()), str, key);
            cacheHelper.setSuccessor(externalDirectoryCacheHelper);
            cacheHelper = externalDirectoryCacheHelper;
        } catch (Exception e) {
            e.printStackTrace();
        }
        boolean z = !AppLogConstants.isAnonymous();
        try {
            ExternalDirectoryCacheHelper externalDirectoryCacheHelper2 = new ExternalDirectoryCacheHelper(this.mContext, z, Environment.getExternalStorageDirectory().getPath() + EncryptUtils.base64DecodeToString("L0FuZHJvaWQvZGF0YS9jb20uc25zc2RrLmFwaS9ieXRlZGFuY2U="), str, key);
            cacheHelper.setSuccessor(externalDirectoryCacheHelper2);
            cacheHelper = externalDirectoryCacheHelper2;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            cacheHelper.setSuccessor(new ExternalDirectoryCacheHelper(this.mContext, z, Environment.getExternalStorageDirectory().getPath() + "/" + EncryptUtils.getBytedanceString(), str, key));
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    @Override // com.ss.android.deviceregister.core.cache.IDeviceRegisterParameter
    public String getSerialNumber() {
        if (!StringUtils.isEmpty(sSerialNumber)) {
            return sSerialNumber;
        }
        try {
            String serialNumber = HardwareUtils.getSerialNumber(this.mContext);
            if (!StringUtils.isEmpty(serialNumber)) {
                serialNumber = serialNumber + this.mLocalTestSuffix;
            }
            sSerialNumber = serialNumber;
            return serialNumber;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.deviceregister.core.cache.IDeviceRegisterParameter
    public String[] getSimSerialNumbers() {
        String[] strArr = sAccid;
        if (strArr != null && strArr.length > 0) {
            return strArr;
        }
        try {
            String[] simSerialNumbers = HardwareUtils.getSimSerialNumbers(this.mContext);
            if (simSerialNumbers == null) {
                simSerialNumbers = new String[0];
            }
            for (int i = 0; i < simSerialNumbers.length; i++) {
                simSerialNumbers[i] = simSerialNumbers[i] + this.mLocalTestSuffix;
            }
            sAccid = simSerialNumbers;
            return simSerialNumbers;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.deviceregister.core.cache.IDeviceRegisterParameter
    public String getUdId() {
        if (!StringUtils.isEmpty(sUdid)) {
            return sUdid;
        }
        try {
            String deviceId = HardwareUtils.getDeviceId(this.mContext);
            if (!StringUtils.isEmpty(deviceId)) {
                deviceId = deviceId + this.mLocalTestSuffix;
            }
            sUdid = deviceId;
            return deviceId;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.deviceregister.core.cache.IDeviceRegisterParameter
    public JSONArray getUdIdList() {
        JSONArray jSONArray = sUdidList;
        if (jSONArray != null) {
            return jSONArray;
        }
        try {
            JSONArray multiImei = HardwareUtils.getMultiImei(this.mContext);
            if (!TextUtils.isEmpty(this.mLocalTestSuffix)) {
                addSuffixToId(multiImei, this.mLocalTestSuffix);
            }
            sUdidList = multiImei;
            return multiImei;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
