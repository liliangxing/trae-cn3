package com.bytedance.ies.web.jsbridge2;

import com.bytedance.ies.web.jsbridge.IJavaMethod;
import com.bytedance.ies.web.jsbridge.JsMsg;
import java.util.Set;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class LegacyMethodImpl implements IJavaMethod {
    private WebViewBridge bridge;
    private Set<String> unregisteredMethodSet;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LegacyMethodImpl(WebViewBridge webViewBridge, Set<String> set) {
        this.unregisteredMethodSet = set;
        this.bridge = webViewBridge;
    }

    @Override // com.bytedance.ies.web.jsbridge.IJavaMethod
    public void call(JsMsg jsMsg, JSONObject jSONObject) throws Exception {
        if (this.unregisteredMethodSet.contains(jsMsg.func)) {
            jSONObject.put("code", "-1");
            return;
        }
        jsMsg.needCallback = false;
        this.bridge.invokeMethod(Js2JavaCall.builder().setMethodName(jsMsg.func).setType(jsMsg.type).setParams(jsMsg.params.toString()).setCallbackId(jsMsg.callback_id).setVersion(String.valueOf(jsMsg.version)).setNamespace(jsMsg.namespace).setIFrameUrl(jsMsg.iFrameUrl).setSafeV1AuthUrl(jsMsg.safeV1AuthUrl).build());
        DebugUtil.m65i("Legacy call forwarded to new bridge: " + jsMsg.toString());
    }
}
