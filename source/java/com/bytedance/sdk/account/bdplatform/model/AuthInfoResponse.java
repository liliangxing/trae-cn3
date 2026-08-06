package com.bytedance.sdk.account.bdplatform.model;

import java.util.ArrayList;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class AuthInfoResponse extends CommonResponse {
    public AlertScope alertScope;
    public String bottomDescription;
    public String clientIcon;
    public String clientName;
    public Map<String, Map<String, Integer[][]>> customizedScopes;
    public ArrayList<String> scopes = new ArrayList<>();
    public JSONObject scope_dict = new JSONObject();
}
