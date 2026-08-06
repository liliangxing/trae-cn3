package com.huawei.hms.hatool;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.lynx.tasm.base.trace.TraceEventDef;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.hatool.f0 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1140f0 extends AbstractC1155k0 {

    /* renamed from: g */
    private String f1442g = "";

    @Override // com.huawei.hms.hatool.InterfaceC1168o1
    /* renamed from: a */
    public JSONObject mo1439a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("protocol_version", "3");
        jSONObject.put("compress_mode", "1");
        jSONObject.put("serviceid", this.f1496d);
        jSONObject.put(HiAnalyticsConstant.HaKey.BI_KEY_APPID, this.f1493a);
        jSONObject.put("hmac", this.f1442g);
        jSONObject.put("chifer", this.f1498f);
        jSONObject.put(TraceEventDef.TIMING_TIMESTAMP, this.f1494b);
        jSONObject.put("servicetag", this.f1495c);
        jSONObject.put("requestid", this.f1497e);
        return jSONObject;
    }

    /* renamed from: g */
    public void m1499g(String str) {
        this.f1442g = str;
    }
}
