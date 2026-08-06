package com.bytedance.bdinstall.loader;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.bdinstall.BDInstall;
import com.bytedance.bdinstall.DrLog;
import com.bytedance.bdinstall.InstallOptions;
import com.bytedance.bdinstall.Utils;
import com.bytedance.bdinstall.oaid.Oaid;
import com.bytedance.bdinstall.oaid.OaidMonitor;
import com.bytedance.bdinstall.service.IInstallParameters;
import com.bytedance.bdinstall.service.ServiceManager;
import com.bytedance.bdinstall.storage.CNDeviceParamsProvider;
import com.bytedance.bdinstall.util.SensitiveUtils;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class SstLoader extends BaseLoader {
    private static final String KEY_ALIYUN_UUID = "aliyun_uuid";
    public static final String KEY_BUILD_SERIAL = "build_serial";
    public static final String KEY_IPV6_LIST = "ipv6_list";
    public static final String KEY_IPV6_TYPE_ANPI = "client_anpi";
    public static final String KEY_IPV6_TYPE_TUN = "client_tun";
    public static final String KEY_MC = "mc";
    public static final String KEY_MEDIA_ID = "miid";
    public static final String KEY_OAID_SUPPORT = "oaid_may_support";
    public static final String KEY_SIM_SERIAL_NUMBER = "sim_serial_number";
    public static final String KEY_UDID = "udid";
    public static final String KEY_UDID_LIST = "udid_list";
    private final Context mApp;
    private final InstallOptions mOptions;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SstLoader(Context context, InstallOptions installOptions) {
        super(true, false);
        this.mApp = context;
        this.mOptions = installOptions;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.bdinstall.loader.BaseLoader
    public boolean doLoad(JSONObject jSONObject) throws JSONException {
        String serialNumber;
        JSONArray multiImei;
        String deviceIdWithCache;
        JSONArray iPV6Address;
        if (!this.mOptions.isTouristMode()) {
            IInstallParameters iInstallParameters = (IInstallParameters) ServiceManager.getService(IInstallParameters.class, String.valueOf(this.mOptions.getAid()));
            String[] strArr = null;
            if (iInstallParameters instanceof CNDeviceParamsProvider) {
                CNDeviceParamsProvider cNDeviceParamsProvider = (CNDeviceParamsProvider) iInstallParameters;
                serialNumber = cNDeviceParamsProvider.getSerialNumber();
                multiImei = cNDeviceParamsProvider.getUdIdList();
                deviceIdWithCache = cNDeviceParamsProvider.getUdId();
                if (this.mOptions.reportPhoneDetailInfo()) {
                    strArr = cNDeviceParamsProvider.getSimSerialNumbers();
                }
            } else {
                serialNumber = SensitiveUtils.getSerialNumber(this.mApp, this.mOptions);
                multiImei = SensitiveUtils.getMultiImei(this.mApp, this.mOptions);
                deviceIdWithCache = SensitiveUtils.getDeviceIdWithCache(this.mApp, this.mOptions);
                if (this.mOptions.reportPhoneDetailInfo()) {
                    strArr = SensitiveUtils.getSimSerialNumbers(this.mApp, this.mOptions);
                }
            }
            Utils.putStringIfNotEmpty(jSONObject, "build_serial", serialNumber);
            Utils.putStringIfNotEmpty(jSONObject, "aliyun_uuid", AliYunUUIDHandler.inst().getCloudUUID());
            if (validMultiIm(multiImei)) {
                jSONObject.put(KEY_UDID_LIST, multiImei);
            }
            String macAddress = SensitiveUtils.getMacAddress(this.mApp, this.mOptions);
            if (!TextUtils.isEmpty(macAddress)) {
                jSONObject.put(KEY_MC, macAddress);
            }
            if (this.mOptions.isEnableGetIPV6() && (iPV6Address = SensitiveUtils.getIPV6Address(this.mApp, this.mOptions)) != null && iPV6Address.length() != 0) {
                jSONObject.put(KEY_IPV6_LIST, iPV6Address);
            }
            Utils.putStringIfNotEmpty(jSONObject, KEY_UDID, deviceIdWithCache);
            Utils.putStringIfNotEmpty(jSONObject, "serial_number", serialNumber);
            if (this.mOptions.reportPhoneDetailInfo() && strArr != null) {
                JSONArray jSONArray = new JSONArray();
                for (String str : strArr) {
                    jSONArray.put(new JSONObject().put("sim_serial_number", str));
                }
                jSONObject.put("sim_serial_number", jSONArray);
            }
            if (BDInstall.getBDInstallConfig().isEnableMediaID()) {
                Utils.putStringIfNotEmpty(jSONObject, KEY_MEDIA_ID, SensitiveUtils.getMediaId(this.mOptions));
            }
        }
        OaidMonitor.registerWaitOaid();
        Map<String, String> oaid = Oaid.instance(this.mApp).getOaid(this.mOptions.isMainInstance() ? BDInstall.getAdIdConfig().getAdIdWaitTime() : BDInstall.getInstance(String.valueOf(this.mOptions.getAid())).getAdIdConfig().getAdIdWaitTime());
        OaidMonitor.registerWaitFinish();
        DrLog.m139d("getOaid: returned=" + oaid);
        jSONObject.put(KEY_OAID_SUPPORT, Oaid.instance(this.mApp).maySupport());
        if (oaid == null) {
            return true;
        }
        jSONObject.put(Oaid.KEY_OAID_ID, new JSONObject(oaid));
        return true;
    }

    private static boolean validMultiIm(JSONArray jSONArray) {
        int length;
        if (jSONArray == null || (length = jSONArray.length()) <= 0) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null && !TextUtils.isEmpty(optJSONObject.optString("id"))) {
                return true;
            }
        }
        return false;
    }
}
