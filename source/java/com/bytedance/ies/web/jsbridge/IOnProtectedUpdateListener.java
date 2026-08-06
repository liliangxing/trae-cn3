package com.bytedance.ies.web.jsbridge;

import java.util.List;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public interface IOnProtectedUpdateListener {
    void onUpdate(List<String> list, JsMsg jsMsg, JSONObject jSONObject);
}
