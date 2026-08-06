package com.bytedance.sdk.account.bdplatform.model;

import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class AuthInfoResponseV2 extends AuthInfoResponse {
    public boolean canSkipConfirm;
    public boolean containsInvalidScope;
    public boolean flipchatConceal;
    public boolean hasMobile;
    public boolean isLogin;
    public boolean needBindMobile;
    public ScopeSetInfo normalScopes;
    public boolean qqConceal;
    public ScopeSetInfo sensitiveScopes;
    public String tips;
    public boolean toutiaoConceal;
    public boolean weiboConceal;
    public boolean wxConceal;

    /* loaded from: classes5.dex */
    public static class ScopeSetInfo {
        public boolean canSkipConfirm;
        public Set<String> scopes;
        public JSONObject wholeData;

        public ScopeSetInfo(JSONObject jSONObject) {
            int length;
            if (jSONObject != null) {
                this.wholeData = jSONObject;
                this.canSkipConfirm = jSONObject.optBoolean("can_skip_confirm");
                JSONArray optJSONArray = jSONObject.optJSONArray("content");
                if (optJSONArray == null || (length = optJSONArray.length()) <= 0) {
                    return;
                }
                this.scopes = new HashSet();
                for (int i = 0; i < length; i++) {
                    this.scopes.add(optJSONArray.optString(i));
                }
            }
        }
    }
}
