package com.bytedance.applog.bdinstall;

import android.content.SharedPreferences;
import com.bytedance.applog.AppLogHelper;
import com.bytedance.applog.AppLogInstance;
import com.bytedance.applog.util.Utils;
import com.bytedance.bdinstall.IBDInstallApi;
import com.bytedance.bdinstall.ICustomExtraHeader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
final class CustomHeaderAdapter implements ICustomExtraHeader {
    private static final String CUSTOM_CUSTOM_INFO = "header_custom_info";
    private static final String SP_CUSTOM_HEADER = "header_custom";
    private static final List<String> TAGS = Collections.singletonList("CustomHeaderAdapter");
    private final AppLogInstance appLogInstance;
    private final IBDInstallApi bdInstallApi;
    private volatile JSONObject customHeader;
    private volatile SharedPreferences mCustomSp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CustomHeaderAdapter(AppLogInstance appLogInstance, IBDInstallApi iBDInstallApi) {
        this.appLogInstance = appLogInstance;
        this.bdInstallApi = iBDInstallApi;
    }

    @Override // com.bytedance.bdinstall.ICustomExtraHeader
    public Map<String, Object> getExtraParams() {
        JSONObject customInfo = getCustomInfo();
        if (customInfo == null) {
            return Collections.emptyMap();
        }
        HashMap hashMap = new HashMap();
        Iterator<String> keys = customInfo.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (next != null) {
                hashMap.put(next, customInfo.opt(next));
            }
        }
        return hashMap;
    }

    public void appendHeaderInfo(Map<String, Object> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        try {
            JSONObject customInfo = getCustomInfo();
            if (!Utils.jsonChanged(map, customInfo)) {
                this.appLogInstance.getLogger().debug(TAGS, "appendHeaderInfo no value changed", new Object[0]);
                return;
            }
            JSONObject jSONObject = new JSONObject();
            if (customInfo != null) {
                Utils.copy(jSONObject, customInfo);
            }
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                if (Utils.isNotEmpty(entry.getKey())) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            }
            updateCustomInfo(jSONObject);
        } catch (Throwable th) {
            this.appLogInstance.getLogger().error(TAGS, "appendHeaderInfo failed", th, new Object[0]);
        }
    }

    public void removeHeader(String str) {
        JSONObject customInfo = getCustomInfo();
        if (customInfo == null || !customInfo.has(str)) {
            return;
        }
        customInfo.remove(str);
        JSONObject jSONObject = new JSONObject();
        Utils.copy(jSONObject, customInfo);
        updateCustomInfo(jSONObject);
    }

    private void updateCustomInfo(JSONObject jSONObject) {
        this.customHeader = jSONObject;
        SharedPreferences sp = getSp();
        if (sp != null) {
            sp.edit().putString(CUSTOM_CUSTOM_INFO, jSONObject != null ? jSONObject.toString() : "").apply();
        }
        this.bdInstallApi.setCustomHeader(this.appLogInstance.getContext(), jSONObject);
    }

    private JSONObject getCustomInfo() {
        if (this.customHeader == null) {
            try {
                SharedPreferences sp = getSp();
                if (sp != null) {
                    String string = sp.getString(CUSTOM_CUSTOM_INFO, null);
                    if (Utils.isNotEmpty(string)) {
                        this.customHeader = new JSONObject(string);
                    } else {
                        this.customHeader = new JSONObject();
                    }
                }
            } catch (Throwable th) {
                this.appLogInstance.getLogger().error(TAGS, "getCustomInfo failed", th, new Object[0]);
            }
        }
        return this.customHeader;
    }

    private SharedPreferences getSp() {
        if (this.mCustomSp == null && this.appLogInstance.getContext() != null) {
            this.mCustomSp = this.appLogInstance.getContext().getSharedPreferences(AppLogHelper.getInstanceSpName(this.appLogInstance, SP_CUSTOM_HEADER), 0);
        }
        return this.mCustomSp;
    }
}
