package com.bytedance.push.settings.message.unduplicate;

import com.bytedance.push.settings.IDefaultValueProvider;
import com.bytedance.push.settings.ITypeConverter;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class UnDuplicateSettingsConverter implements ITypeConverter<UnDuplicateSettingsModel>, IDefaultValueProvider<UnDuplicateSettingsModel> {
    private final String KEY_ENABLE_UN_DUPLICATE_MESSAGE = "enable_un_duplicate_message";
    private final String KEY_MAX_CACHE_MESSAGE = "max_cache_message";
    private final String KEY_MAX_CACHE_TIME_IN_HOUR = "max_cache_time_in_hour";

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.push.settings.IDefaultValueProvider
    public UnDuplicateSettingsModel create() {
        return new UnDuplicateSettingsModel();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.push.settings.ITypeConverter
    public UnDuplicateSettingsModel to(String str) {
        UnDuplicateSettingsModel create = create();
        try {
            JSONObject jSONObject = new JSONObject(str);
            create.enableUnDuplicateMessage = jSONObject.optBoolean("enable_un_duplicate_message");
            create.maxCacheMessage = jSONObject.optInt("max_cache_message", 200);
            create.maxCacheTimeInHour = jSONObject.optLong("max_cache_time_in_hour", 24L);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return create;
    }

    @Override // com.bytedance.push.settings.ITypeConverter
    public String from(UnDuplicateSettingsModel unDuplicateSettingsModel) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("enable_un_duplicate_message", unDuplicateSettingsModel.enableUnDuplicateMessage);
            jSONObject.put("max_cache_message", unDuplicateSettingsModel.maxCacheMessage);
            jSONObject.put("max_cache_time_in_hour", unDuplicateSettingsModel.maxCacheTimeInHour);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject.toString();
    }
}
