package com.bytedance.push.settings.assosiation.start;

import android.text.TextUtils;
import com.bytedance.common.push.BaseJson;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.push.utils.Logger;
import com.ss.android.message.util.ToolUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class ComponentProcessInfo extends BaseJson {
    private final String COMPONENT_INFO = "component_info";
    private final String UPDATE_VERSION_CODE = "update_version_code";
    public Map<String, String> componentInfo;
    public int updateVersionCode;

    public ComponentProcessInfo(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("component_info");
            if (!TextUtils.isEmpty(optString)) {
                this.componentInfo = StringUtils.stringToMap(optString, new HashMap());
            }
            this.updateVersionCode = jSONObject.optInt("update_version_code");
        } catch (Throwable th) {
            Logger.e("ComponentProcessInfo", "error when parse ComponentProcessInfo ", th);
        }
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        Map<String, String> map = this.componentInfo;
        if (map != null) {
            add(jSONObject, "component_info", StringUtils.mapToString(map));
        }
        add(jSONObject, "update_version_code", this.updateVersionCode);
        return jSONObject.toString();
    }

    public List<String> getTargetProcessComponents(String str) {
        String str2;
        Map<String, String> map = this.componentInfo;
        if (map == null || (str2 = map.get(str)) == null) {
            return null;
        }
        return ToolUtils.stringDividedByCommaToList(str2);
    }
}
