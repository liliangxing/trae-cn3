package com.ss.android.deviceregister.base;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.helios.statichook.api.ExtraInfo;
import com.bytedance.helios.statichook.api.HeliosApiHook;
import com.bytedance.helios.statichook.api.Result;
import com.ss.android.common.AppContext;
import com.ss.android.common.applog.NetUtil;
import com.ss.android.deviceregister.DeviceRegisterManager;
import com.ss.android.deviceregister.core.RealRegisterServiceController;
import com.ss.android.deviceregister.utils.HardwareUtils;
import com.ss.android.pushmanager.PushCommonConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class DrHelperWithRegion {
    static final String CHANNEL_APP_KEY = "UMENG_APPKEY";
    static final String CHANNEL_KEY = "UMENG_CHANNEL";
    static final String KEY_ALIYUN_UUID = "aliyun_uuid";
    static final String KEY_BUILD_SERIAL = "build_serial";
    static final String KEY_MC = "mc";
    public static final String SP_KEY_MAC_ADDR = "mac_addr";

    /* renamed from: com_ss_android_deviceregister_base_DrHelperWithRegion_com_ss_android_deviceregister_base_Oaid_getOaidId */
    private static String m98xbf1e3155(Oaid oaid) {
        HeliosApiHook heliosApiHook = new HeliosApiHook();
        Object[] objArr = new Object[0];
        ExtraInfo extraInfo = new ExtraInfo(false, "()Ljava/lang/String;");
        Result preInvoke = heliosApiHook.preInvoke(10000009, "com/ss/android/deviceregister/base/Oaid", "getOaidId", oaid, objArr, "java.lang.String", extraInfo);
        if (preInvoke.isIntercept()) {
            heliosApiHook.postInvoke(10000009, "com/ss/android/deviceregister/base/Oaid", "getOaidId", oaid, objArr, (Object) null, extraInfo, false);
            return (String) preInvoke.getReturnValue();
        }
        String oaidId = oaid.getOaidId();
        heliosApiHook.postInvoke(10000009, "com/ss/android/deviceregister/base/Oaid", "getOaidId", oaid, objArr, oaidId, extraInfo, true);
        return oaidId;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0048 A[Catch: JSONException -> 0x0060, TryCatch #6 {JSONException -> 0x0060, blocks: (B:8:0x001f, B:10:0x002a, B:13:0x0042, B:15:0x0048, B:17:0x004e, B:19:0x0055, B:62:0x0031, B:65:0x003a), top: B:7:0x001f }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0055 A[Catch: JSONException -> 0x0060, TRY_LEAVE, TryCatch #6 {JSONException -> 0x0060, blocks: (B:8:0x001f, B:10:0x002a, B:13:0x0042, B:15:0x0048, B:17:0x004e, B:19:0x0055, B:62:0x0031, B:65:0x003a), top: B:7:0x001f }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00cd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0066 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void updateHeader(Context context, RealRegisterServiceController realRegisterServiceController, JSONObject jSONObject, boolean z, boolean z2) {
        String macAddress;
        String[] simSerialNumbers;
        String string;
        boolean z3;
        if (!z2) {
            SharedPreferences applogStatsSp = AppLogConstants.getApplogStatsSp(context);
            if (DeviceRegisterManager.getMacAddressApiCallback() != null) {
                macAddress = DeviceRegisterManager.getMacAddressApiCallback().getMacAdress();
            } else {
                macAddress = HardwareUtils.getMacAddress(context);
            }
            try {
                string = applogStatsSp.getString(SP_KEY_MAC_ADDR, null);
                z3 = true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (StringUtils.isEmpty(string)) {
                if (!StringUtils.isEmpty(macAddress)) {
                    if (!StringUtils.isEmpty(macAddress) && !DeviceRegisterManager.isNewUserMode(context)) {
                        jSONObject.put(KEY_MC, macAddress);
                    }
                    if (z3) {
                        SharedPreferences.Editor edit = applogStatsSp.edit();
                        edit.putString(SP_KEY_MAC_ADDR, macAddress);
                        edit.commit();
                    }
                    if (realRegisterServiceController != null) {
                        try {
                            String udId = realRegisterServiceController.getUdId();
                            if (!StringUtils.isEmpty(udId)) {
                                jSONObject.put("udid", udId);
                            }
                            JSONArray udIdList = realRegisterServiceController.getUdIdList();
                            if (HardwareUtils.validMultiImei(udIdList)) {
                                jSONObject.put(AppLogConstants.KEY_UDID_LIST, udIdList);
                            }
                            String serialNumber = realRegisterServiceController.getSerialNumber();
                            if (!StringUtils.isEmpty(serialNumber)) {
                                jSONObject.put("serial_number", serialNumber);
                            }
                            if (z && (simSerialNumbers = realRegisterServiceController.getSimSerialNumbers()) != null) {
                                JSONArray jSONArray = new JSONArray();
                                for (String str : simSerialNumbers) {
                                    try {
                                        jSONArray.put(new JSONObject().put("sim_serial_number", str));
                                    } catch (JSONException e2) {
                                        e2.printStackTrace();
                                    }
                                }
                                jSONObject.put("sim_serial_number", jSONArray);
                            }
                        } catch (JSONException e3) {
                            e3.printStackTrace();
                        }
                    }
                    if (!DeviceRegisterManager.isNewUserMode(context)) {
                        try {
                            String serialNumber2 = HardwareUtils.getSerialNumber(context);
                            if (!TextUtils.isEmpty(serialNumber2)) {
                                jSONObject.put(KEY_BUILD_SERIAL, serialNumber2);
                            }
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                    }
                }
                z3 = false;
                if (!StringUtils.isEmpty(macAddress)) {
                    jSONObject.put(KEY_MC, macAddress);
                }
                if (z3) {
                }
                if (realRegisterServiceController != null) {
                }
                if (!DeviceRegisterManager.isNewUserMode(context)) {
                }
            } else {
                if (StringUtils.isEmpty(macAddress)) {
                    z3 = false;
                    macAddress = string;
                } else {
                    if (!string.equals(macAddress)) {
                    }
                    z3 = false;
                }
                if (!StringUtils.isEmpty(macAddress)) {
                }
                if (z3) {
                }
                if (realRegisterServiceController != null) {
                }
                if (!DeviceRegisterManager.isNewUserMode(context)) {
                }
            }
        }
        try {
            if (!StringUtils.isEmpty(NetUtil.getAliyunUuid())) {
                jSONObject.put(KEY_ALIYUN_UUID, NetUtil.getAliyunUuid());
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
        try {
            Map<String, String> oaid = Oaid.instance(context).getOaid(DeviceRegisterManager.getAdIdConfig().getAdIdWaitTime());
            Log.d("ARegistrationHeader", "getOaid: returned=" + oaid);
            if (oaid != null) {
                jSONObject.put(PushCommonConstants.KEY_OAID, new JSONObject(oaid));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            boolean maySupport = Oaid.instance(context).maySupport();
            Log.d("ARegistrationHeader", "maySupport: returned=" + maySupport);
            jSONObject.put("oaid_may_support", maySupport);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getChannel(Bundle bundle) {
        return bundle.getString(CHANNEL_KEY);
    }

    public static void filterHeader(JSONObject jSONObject) {
        if (jSONObject == null || RegistrationHeaderHelper.reportPhoneDetailInfo()) {
            return;
        }
        try {
            jSONObject.remove("sim_serial_number");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void doInDeviceRegisterInit(Context context) {
        OaidWrapper.instance(context).init();
    }

    public static void appendCommonParam(Context context, AppContext appContext, Map<String, String> map, boolean z) {
        if (!z) {
            if (DeviceRegisterManager.getAdIdConfig().enablePrefetchAdId()) {
                OaidWrapper.instance(context).init();
                return;
            }
            return;
        }
        if (!DeviceRegisterManager.isTouristMode()) {
            String deviceId = appContext.getDeviceId();
            if (!NetUtil.isBadId(deviceId)) {
                map.put("uuid", deviceId);
            }
        }
        if (z) {
            try {
                String m98xbf1e3155 = m98xbf1e3155(Oaid.instance(context));
                if (m98xbf1e3155 != null) {
                    map.put(PushCommonConstants.KEY_OAID, m98xbf1e3155);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void appendActiveUserParam(Context context, StringBuilder sb) {
        if (DeviceRegisterManager.isTouristMode()) {
            return;
        }
        String[] simSerialNumbers = HardwareUtils.getSimSerialNumbers(context);
        if (simSerialNumbers != null && simSerialNumbers.length > 0) {
            String str = simSerialNumbers[0];
            for (int i = 1; i < simSerialNumbers.length; i++) {
                str = str + Constants.ACCEPT_TIME_SEPARATOR_SP + simSerialNumbers[i];
            }
            addParams(sb, "sim_serial_number", str, true);
        }
        addParams(sb, KEY_BUILD_SERIAL, HardwareUtils.getSerialNumber(context), true);
    }

    private static void addParams(StringBuilder sb, String str, String str2, boolean z) {
        if (sb == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        if (sb.toString().indexOf(63) < 0) {
            sb.append("?");
        } else {
            sb.append("&");
        }
        StringBuilder append = sb.append(str).append("=");
        if (z) {
            str2 = Uri.encode(str2);
        }
        append.append(str2);
    }
}
