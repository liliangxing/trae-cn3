package com.bytedance.sdk.account.execute;

import com.ss.android.TTHeader;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class ApiResponse {
    public JSONObject body;
    public String decisionConf;
    public List<TTHeader> headers;
    public String logId;
    public String mDetailErrorMsg;
    public int mError = 0;
    public String mErrorMsg;
    public String mRequestUrl;
    public ApiRequest request;
    public String secondaryDecisionConf;
    public String xTtToken;

    public ApiResponse(ApiRequest apiRequest) {
        this.request = apiRequest;
    }
}
