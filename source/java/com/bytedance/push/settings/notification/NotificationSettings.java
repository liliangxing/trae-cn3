package com.bytedance.push.settings.notification;

import org.json.JSONObject;

/* loaded from: classes4.dex */
public class NotificationSettings {
    public boolean enableHarmonyOs4ImportanceAndCategory;
    public int harmonyOs4ImportanceAndCategoryInterceptStrategy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public NotificationSettings() {
        this.enableHarmonyOs4ImportanceAndCategory = false;
        this.harmonyOs4ImportanceAndCategoryInterceptStrategy = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public NotificationSettings(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.enableHarmonyOs4ImportanceAndCategory = jSONObject.optBoolean("enable_harmony_os4_importance_category", false);
            this.harmonyOs4ImportanceAndCategoryInterceptStrategy = jSONObject.optInt("harmony_os4_importance_category_intercept_strategy", 0);
        } catch (Throwable unused) {
        }
    }

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("enable_harmony_os4_importance_category", this.enableHarmonyOs4ImportanceAndCategory);
            jSONObject.put("harmony_os4_importance_category_intercept_strategy", this.harmonyOs4ImportanceAndCategoryInterceptStrategy);
        } catch (Throwable unused) {
        }
        return jSONObject.toString();
    }
}
