package com.bytedance.android.monitor.entity;

import com.bytedance.android.monitor.base.BaseMonitorData;
import com.bytedance.android.monitor.util.JsonUtils;
import com.bytedance.android.monitor.util.NavigationUtil;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class NativeCommon extends BaseMonitorData {
    public long attachTs;
    public long clickStart;
    public long containerInitTs;
    public Boolean containerReuse;
    public String containerType;
    public JSONObject context;
    public long detachTs;
    public String navigationId;
    public String url;
    public String virtualAid;
    public String webViewType;

    public NativeCommon() {
        this.url = null;
        this.navigationId = NavigationUtil.generateID();
        this.containerType = null;
        this.webViewType = null;
        this.clickStart = 0L;
        this.attachTs = 0L;
        this.detachTs = 0L;
    }

    public NativeCommon(String str, String str2) {
        this.url = null;
        this.navigationId = NavigationUtil.generateID();
        this.webViewType = null;
        this.clickStart = 0L;
        this.attachTs = 0L;
        this.detachTs = 0L;
        this.url = str;
        this.containerType = str2;
    }

    @Override // com.bytedance.android.monitor.base.BaseMonitorData
    public void fillInJsonObject(JSONObject jSONObject) {
        JsonUtils.safePut(jSONObject, "navigation_id", this.navigationId);
        JsonUtils.safePut(jSONObject, "url", this.url);
        JsonUtils.safePut(jSONObject, "container_type", this.containerType);
        JsonUtils.safePut(jSONObject, "click_start", this.clickStart);
        JsonUtils.safePut(jSONObject, "sdk_version", "1.2.2-rc.3.1-bugfix");
        JsonUtils.safePut(jSONObject, "virtual_aid", this.virtualAid);
        JsonUtils.safePut(jSONObject, "context", this.context);
        JsonUtils.safePut(jSONObject, "debug_context", new JSONObject());
        long j = this.containerInitTs;
        if (j != 0) {
            JsonUtils.safePut(jSONObject, "container_init_ts", j);
        }
        Boolean bool = this.containerReuse;
        if (bool != null) {
            JsonUtils.safePut(jSONObject, "container_reuse", bool);
        }
    }

    public void addContext(String str, Object obj) {
        if (this.context == null) {
            this.context = new JSONObject();
        }
        JsonUtils.safePut(this.context, str, obj);
    }
}
