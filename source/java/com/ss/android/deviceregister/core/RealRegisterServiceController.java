package com.ss.android.deviceregister.core;

import android.content.Context;
import com.bytedance.common.utility.StringUtils;
import com.ss.android.deviceregister.DeviceRegisterManager;
import com.ss.android.deviceregister.base.RegistrationHeaderHelper;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class RealRegisterServiceController extends RegisterServiceController {
    public RealRegisterServiceController(Context context, boolean z) {
        super(context, z);
    }

    public String getUdId() {
        return this.mDeviceParamsProvider.getUdId();
    }

    public JSONArray getUdIdList() {
        return this.mDeviceParamsProvider.getUdIdList();
    }

    public String[] getSimSerialNumbers() {
        return this.mDeviceParamsProvider.getSimSerialNumbers();
    }

    public String getSerialNumber() {
        return this.mDeviceParamsProvider.getSerialNumber();
    }

    @Override // com.ss.android.deviceregister.core.RegisterServiceController
    protected void onEventDidChanged(String str, String str2) {
        String[] simSerialNumbers;
        if (StringUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            String openUdid = getOpenUdid();
            if (!DeviceRegisterManager.isTouristMode()) {
                String udId = this.mDeviceParamsProvider.getUdId();
                String serialNumber = this.mDeviceParamsProvider.getSerialNumber();
                if (!StringUtils.isEmpty(udId)) {
                    jSONObject.put("udid", udId);
                }
                if (!StringUtils.isEmpty(serialNumber)) {
                    jSONObject.put("serial_number", serialNumber);
                }
                if (RegistrationHeaderHelper.reportPhoneDetailInfo() && (simSerialNumbers = this.mDeviceParamsProvider.getSimSerialNumbers()) != null && simSerialNumbers.length > 0) {
                    jSONObject.put("sim_serial_number", Arrays.toString(simSerialNumbers));
                }
            }
            Object clientUDID = this.mDeviceParamsProvider.getClientUDID();
            jSONObject.put("old_id", str);
            jSONObject.put("new_id", str2);
            jSONObject.put("openudid", openUdid);
            jSONObject.put("clientudid", clientUDID);
            onEvent("did_change", jSONObject);
        } catch (Exception unused) {
        }
    }
}
