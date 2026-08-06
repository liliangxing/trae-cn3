package com.bytedance.ttnet.http;

import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.common.utility.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class GetDomainContext {
    public String localSign;
    public String logid;
    public long queryTime;
    public String rawSign;
    public String ssSign;
    public int status;
    public String tncAbTest;
    public String tncCanary;
    public String tncConfigId;
    public String tncControl;
    public String tncEtag;
    public String tncQueryRegion;
    public String url;
    public boolean useHttps;
    public String errMsg = "";
    public boolean addCommonParam = true;

    public JSONObject toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("status", this.status);
        jSONObject.put("url", this.url);
        jSONObject.put("query_time", this.queryTime);
        if (!this.useHttps) {
            jSONObject.put("raw_sign", this.rawSign);
            jSONObject.put("ss_sign", this.ssSign);
            jSONObject.put("local_sign", this.localSign);
        }
        if (!StringUtils.isEmpty(this.errMsg)) {
            jSONObject.put(StrategyConstants.ERR_MSG, this.errMsg);
        }
        return jSONObject;
    }
}
