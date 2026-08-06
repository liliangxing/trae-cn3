package com.bytedance.android.monitorV2.entity;

import com.bytedance.android.monitorV2.AnnieXMonitorConstants;
import com.bytedance.android.monitorV2.base.BaseMonitorData;
import com.bytedance.android.monitorV2.constant.ReportConst;
import com.bytedance.android.monitorV2.hybridSetting.SettingsParseManager;
import com.bytedance.android.monitorV2.settings.MonitorConfig;
import com.bytedance.android.monitorV2.util.JsonUtils;
import com.bytedance.android.monitorV2.util.Utilities;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class NativeCommon extends BaseMonitorData {
    public long attachTs;
    public long clickStart;
    public long containerInitTs;
    public Boolean containerReuse;
    public String containerType;
    public JSONObject context;
    public JSONObject debugContext;
    public long detachTs;
    public String nativePage;
    public String navigationId;
    public String url;

    @Deprecated
    public String virtualAid;

    public NativeCommon() {
        this.url = null;
        this.navigationId = Utilities.INSTANCE.uuid();
        this.containerType = null;
        this.nativePage = null;
        this.clickStart = 0L;
        this.debugContext = new JSONObject();
    }

    public NativeCommon(String str, String str2) {
        this.url = null;
        this.navigationId = Utilities.INSTANCE.uuid();
        this.containerType = null;
        this.nativePage = null;
        this.clickStart = 0L;
        this.debugContext = new JSONObject();
        this.url = str;
        this.containerType = str2;
    }

    @Override // com.bytedance.android.monitorV2.base.BaseMonitorData
    public void fillInJsonObject(JSONObject jSONObject) {
        JsonUtils.safePut(jSONObject, "navigation_id", this.navigationId);
        JsonUtils.safePut(jSONObject, "url", this.url);
        JsonUtils.safePut(jSONObject, "container_type", this.containerType);
        JsonUtils.safePut(jSONObject, "native_page", this.nativePage);
        JsonUtils.safePut(jSONObject, "sdk_version", AnnieXMonitorConstants.ANNIEX_VERSION);
        if (useVirtualAid()) {
            JsonUtils.safePut(jSONObject, "virtual_aid", this.virtualAid);
        }
        JsonUtils.safePut(jSONObject, "context", this.context);
        JsonUtils.safePut(jSONObject, "sdk_version", AnnieXMonitorConstants.ANNIEX_VERSION);
        JsonUtils.safePut(jSONObject, "debug_context", this.debugContext);
        long j = this.containerInitTs;
        if (j != 0) {
            JsonUtils.safePut(jSONObject, "container_init_ts", j);
        }
        Boolean bool = this.containerReuse;
        if (bool != null) {
            JsonUtils.safePut(jSONObject, "container_reuse", bool);
        }
        JsonUtils.safePut(this.debugContext, ReportConst.Params.MONITOR_PACKAGE, "monitorV2");
    }

    public void addContext(String str, Object obj) {
        if (this.context == null) {
            this.context = new JSONObject();
        }
        JsonUtils.safePut(this.context, str, String.valueOf(obj));
    }

    public void addContext(JSONObject jSONObject) {
        if (this.context == null) {
            this.context = new JSONObject();
        }
        JsonUtils.deepCopy(this.context, jSONObject);
    }

    private boolean useVirtualAid() {
        try {
            if (SettingsParseManager.INSTANCE.getSettingsCenter() == null || SettingsParseManager.INSTANCE.getSettingsCenter().obtainSettings(MonitorConfig.class) == null) {
                return true;
            }
            return ((MonitorConfig) SettingsParseManager.INSTANCE.getSettingsCenter().obtainSettings(MonitorConfig.class)).getEnableVirtualAid();
        } catch (Throwable unused) {
            return true;
        }
    }
}
