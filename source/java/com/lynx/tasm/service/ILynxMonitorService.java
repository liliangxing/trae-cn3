package com.lynx.tasm.service;

import com.lynx.tasm.LynxView;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public interface ILynxMonitorService extends IServiceProvider {
    void formatEventReporter(LynxView lynxView, String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3);

    void reportCrashGlobalContextTag(String str, String str2);

    void reportImageInfo(LynxImageInfo lynxImageInfo);

    void reportImageStatus(String str, JSONObject jSONObject);

    void reportResourceStatus(LynxView lynxView, String str, JSONObject jSONObject, JSONObject jSONObject2);

    void reportTrailEvent(String str, JSONObject jSONObject);

    @Override // com.lynx.tasm.service.IServiceProvider
    default Class<? extends IServiceProvider> getServiceClass() {
        return ILynxMonitorService.class;
    }
}
