package com.bytedance.bdinstall.loader;

import com.bytedance.bdinstall.util.RomUtils;
import com.bytedance.bdinstall.util.SystemPropertiesWithCache;
import com.bytedance.push.utils.RomVersionParamHelper;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class HarmonyLoader {
    /* JADX INFO: Access modifiers changed from: package-private */
    public void doLoad(JSONObject jSONObject) {
        boolean isHarmonyUI = RomUtils.isHarmonyUI();
        try {
            jSONObject.put("os", isHarmonyUI ? "Harmony" : "Android");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (isHarmonyUI) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("os_api", SystemPropertiesWithCache.get(RomVersionParamHelper.HARMONY_API_VERSION));
                jSONObject2.put("os_version", SystemPropertiesWithCache.get(RomVersionParamHelper.HARMONY_VERSION));
                jSONObject2.put("release_type", SystemPropertiesWithCache.get(RomVersionParamHelper.HARMONY_RELEASE_TYPE));
            } catch (Throwable th) {
                th.printStackTrace();
            }
            try {
                jSONObject.put(com.ss.android.socialbase.appdownloader.util.RomUtils.OS_HARMONY, jSONObject2);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }
}
