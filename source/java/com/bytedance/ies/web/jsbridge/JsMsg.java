package com.bytedance.ies.web.jsbridge;

import android.text.TextUtils;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class JsMsg {
    public String callback_id;
    public String func;
    public String iFrameUrl;
    public String namespace;
    public JSONObject params;
    public String permissionGroup;
    public String safeV1AuthUrl;
    public String type;
    public int version;
    public Boolean fromBDXBridge = false;
    public boolean needCallback = true;

    public String toString() {
        return "JsMsg{type='" + this.type + "', callback_id='" + this.callback_id + "', func='" + this.func + "', params=" + this.params + ", version=" + this.version + ", namespace=" + this.namespace + ", iFrameUrl=" + this.iFrameUrl + ", safeV1AuthUrl=" + this.safeV1AuthUrl + ", permissionGroup=" + (TextUtils.isEmpty(this.permissionGroup) ? "" : this.permissionGroup) + AbstractJsonLexerKt.END_OBJ;
    }
}
