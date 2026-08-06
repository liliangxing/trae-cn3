package com.bytedance.apm.data.type;

import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.apm.constant.SlardarSettingsConsts;
import com.bytedance.apm.data.ITypeData;
import com.bytedance.apm.samplers.SamplerHelper;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class UIActionData implements ITypeData {
    public String action;
    public JSONObject context;
    public JSONObject extraJson;
    public String page;

    @Override // com.bytedance.apm.data.ITypeData
    public String getSubTypeLabel() {
        return "ui_action";
    }

    @Override // com.bytedance.apm.data.ITypeData
    public String getTypeLabel() {
        return "ui_action";
    }

    @Override // com.bytedance.apm.data.ITypeData
    public boolean isSaveImmediately() {
        return false;
    }

    @Override // com.bytedance.apm.data.ITypeData
    public boolean isUploadImmediately() {
        return false;
    }

    @Override // com.bytedance.apm.data.ITypeData
    public boolean supportFetch() {
        return true;
    }

    public UIActionData(String str, String str2, JSONObject jSONObject, JSONObject jSONObject2) {
        this.action = str;
        this.page = str2;
        this.context = jSONObject;
        this.extraJson = jSONObject2;
    }

    @Override // com.bytedance.apm.data.ITypeData
    public JSONObject packLog() {
        try {
            if (this.extraJson == null) {
                this.extraJson = new JSONObject();
            }
            this.extraJson.put("log_type", "ui_action");
            this.extraJson.put(StrategyConstants.ACTION, this.action);
            this.extraJson.put("page", this.page);
            this.extraJson.put("context", this.context);
            return this.extraJson;
        } catch (JSONException unused) {
            return null;
        }
    }

    @Override // com.bytedance.apm.data.ITypeData
    public boolean isSampled(JSONObject jSONObject) {
        return SamplerHelper.getPerfAllowSwitch(SlardarSettingsConsts.PERF_KEY_UI);
    }
}
