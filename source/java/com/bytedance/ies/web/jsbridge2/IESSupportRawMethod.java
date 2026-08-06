package com.bytedance.ies.web.jsbridge2;

import com.bytedance.ies.web.jsbridge.IJavaMethod;
import com.bytedance.ies.web.jsbridge.ISupportJavaMethod;
import com.bytedance.ies.web.jsbridge.JsMsg;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class IESSupportRawMethod extends BaseRawMethod {
    private IJavaMethod legacyMethod;

    /* JADX INFO: Access modifiers changed from: package-private */
    public IESSupportRawMethod(IJavaMethod iJavaMethod) {
        this.legacyMethod = iJavaMethod;
    }

    public Map<String, Object> getMetaInfo() {
        IJavaMethod iJavaMethod = this.legacyMethod;
        if (iJavaMethod instanceof ISupportJavaMethod) {
            return ((ISupportJavaMethod) iJavaMethod).getMetaInfo();
        }
        return new HashMap();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.ies.web.jsbridge2.BaseRawMethod
    public void invoke(Js2JavaCall js2JavaCall, LegacySupportStub legacySupportStub) throws Exception {
        JsMsg jsMsg = new JsMsg();
        jsMsg.func = js2JavaCall.methodName;
        jsMsg.params = new JSONObject(js2JavaCall.params);
        jsMsg.callback_id = js2JavaCall.callbackId;
        jsMsg.type = js2JavaCall.type;
        jsMsg.version = 0;
        jsMsg.namespace = js2JavaCall.namespace;
        jsMsg.iFrameUrl = js2JavaCall.iFrameUrl;
        jsMsg.needCallback = true;
        if (legacySupportStub.getPermissionGroup() != null) {
            jsMsg.permissionGroup = legacySupportStub.getPermissionGroup().toString();
        }
        JSONObject jSONObject = new JSONObject();
        DebugUtil.m65i("Invoking legacy method with: " + jsMsg.toString());
        try {
            this.legacyMethod.call(jsMsg, jSONObject);
        } catch (Exception unused) {
        }
        if (!jsMsg.needCallback) {
            DebugUtil.m65i("No need for callback: " + jsMsg.toString());
            return;
        }
        legacySupportStub.onResponse(jSONObject.toString());
        if (DebugUtil.isDebug()) {
            if (jSONObject.optInt("code", 0) == 1) {
                DebugUtil.m65i("Method succeed with: " + jsMsg.toString());
            } else {
                DebugUtil.m65i("No need for callback, but error occurred: " + jsMsg.toString());
            }
        }
    }
}
