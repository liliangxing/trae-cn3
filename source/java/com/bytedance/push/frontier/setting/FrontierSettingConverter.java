package com.bytedance.push.frontier.setting;

import com.bytedance.push.settings.IDefaultValueProvider;
import com.bytedance.push.settings.ITypeConverter;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class FrontierSettingConverter implements ITypeConverter<FrontierSetting>, IDefaultValueProvider<FrontierSetting> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.push.settings.IDefaultValueProvider
    public FrontierSetting create() {
        return new FrontierSetting();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.push.settings.ITypeConverter
    public FrontierSetting to(String str) {
        FrontierSetting frontierSetting = new FrontierSetting();
        try {
            return FrontierSetting.parse(new JSONObject(str));
        } catch (JSONException e) {
            e.printStackTrace();
            return frontierSetting;
        }
    }

    @Override // com.bytedance.push.settings.ITypeConverter
    public String from(FrontierSetting frontierSetting) {
        return frontierSetting.toJson().toString();
    }
}
