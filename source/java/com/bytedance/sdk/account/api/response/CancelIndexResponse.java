package com.bytedance.sdk.account.api.response;

import com.bytedance.sdk.account.api.call.BaseApiResponse;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class CancelIndexResponse extends BaseApiResponse {
    public Boolean auditStatus;
    public List<Conditions> conditionsList;
    public boolean hasMobile;
    public boolean identified;
    public int protocol;
    public JSONObject rawData;

    /* loaded from: classes5.dex */
    public static class Conditions {
        public String text;
    }

    public CancelIndexResponse(boolean z, int i) {
        super(z, i);
    }
}
