package com.bytedance.crash.applog;

import com.bytedance.crash.NpthCustomHeaderApi;
import com.bytedance.crash.general.HardwareInfo;
import com.bytedance.crash.general.HardwareInfoHelper;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class NpthApplog {
    public static void init() {
        NpthCustomHeaderApi.addCustomHeaderService(new NpthCustomHeaderApi.ICustomHeaderService() { // from class: com.bytedance.crash.applog.NpthApplog.1
            @Override // com.bytedance.crash.NpthCustomHeaderApi.ICustomHeaderService
            public Map<String, String> getCustomHeader() {
                HashMap hashMap = new HashMap();
                hashMap.put(HardwareInfo.KEY_HW_RAM_SIZE, HardwareInfoHelper.getRamSize());
                return hashMap;
            }
        });
        NpthAppLogHeader.init();
    }
}
