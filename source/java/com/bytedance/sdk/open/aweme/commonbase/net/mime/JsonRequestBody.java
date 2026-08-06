package com.bytedance.sdk.open.aweme.commonbase.net.mime;

import com.bytedance.sdk.open.aweme.commonbase.net.b;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class JsonRequestBody extends ByteArrayRequestBody {
    public JsonRequestBody(JSONObject jSONObject) {
        super("application/json; charset=UTF-8", b.a(jSONObject.toString()), null);
    }
}
