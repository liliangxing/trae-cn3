package com.bytedance.ies.web.jsbridge2;

import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class Java2JsMsg {
    private final Map<String, Object> params = new ConcurrentHashMap();

    public static Java2JsMsg create() {
        return new Java2JsMsg();
    }

    private Java2JsMsg() {
    }

    public Java2JsMsg putParam(String str, Object obj) {
        if (!TextUtils.isEmpty(str) && obj != null) {
            this.params.put(str, obj);
        }
        return this;
    }

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, Object> entry : this.params.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            return jSONObject.toString();
        } catch (JSONException unused) {
            return "";
        }
    }
}
