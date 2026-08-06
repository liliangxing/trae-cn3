package com.bytedance.push.settings.notification;

import com.bytedance.apm.constant.AgentConstants;
import com.bytedance.common.push.BaseJson;
import com.bytedance.push.settings.IDefaultValueProvider;
import com.bytedance.push.settings.ITypeConverter;
import com.bytedance.sdk.account.induce.FrequencyController;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class MessageBlackTimeWindowConverter extends BaseJson implements ITypeConverter<MessageBlackTimeWindowSettingsModel>, IDefaultValueProvider<MessageBlackTimeWindowSettingsModel> {
    private final String KEY_NEED_INTERCEPT = "need_intercept";
    private final String KEY_BEGIN_TIME = AgentConstants.BEGIN_TIME;
    private final String KEY_END_TIME = "end_time";
    private final String KEY_DAY = FrequencyController.RangeType.DAY;
    private final String KEY_MINUTE = FrequencyController.RangeType.MINUTE;
    private final String KEY_HOUR = FrequencyController.RangeType.HOUR;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.push.settings.IDefaultValueProvider
    public MessageBlackTimeWindowSettingsModel create() {
        return new MessageBlackTimeWindowSettingsModel();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.push.settings.ITypeConverter
    public MessageBlackTimeWindowSettingsModel to(String str) {
        MessageBlackTimeWindowSettingsModel create = create();
        try {
            JSONObject jSONObject = new JSONObject(str);
            create.needIntercept = jSONObject.optBoolean("need_intercept");
            JSONObject optJSONObject = jSONObject.optJSONObject(AgentConstants.BEGIN_TIME);
            if (optJSONObject != null) {
                create.beginHour = optJSONObject.optInt(FrequencyController.RangeType.HOUR, -1);
                create.beginMinute = optJSONObject.optInt(FrequencyController.RangeType.MINUTE, -1);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("end_time");
            if (optJSONObject2 != null) {
                create.endDay = optJSONObject2.optInt(FrequencyController.RangeType.DAY, -1);
                create.endHour = optJSONObject2.optInt(FrequencyController.RangeType.HOUR, -1);
                create.endMinute = optJSONObject2.optInt(FrequencyController.RangeType.MINUTE, -1);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return create;
    }

    @Override // com.bytedance.push.settings.ITypeConverter
    public String from(MessageBlackTimeWindowSettingsModel messageBlackTimeWindowSettingsModel) {
        JSONObject jSONObject = new JSONObject();
        add(jSONObject, "need_intercept", messageBlackTimeWindowSettingsModel.needIntercept);
        JSONObject jSONObject2 = new JSONObject();
        add(jSONObject2, FrequencyController.RangeType.HOUR, messageBlackTimeWindowSettingsModel.beginHour);
        add(jSONObject2, FrequencyController.RangeType.MINUTE, messageBlackTimeWindowSettingsModel.beginMinute);
        add(jSONObject, AgentConstants.BEGIN_TIME, jSONObject2);
        JSONObject jSONObject3 = new JSONObject();
        add(jSONObject3, FrequencyController.RangeType.DAY, messageBlackTimeWindowSettingsModel.endDay);
        add(jSONObject3, FrequencyController.RangeType.HOUR, messageBlackTimeWindowSettingsModel.endHour);
        add(jSONObject3, FrequencyController.RangeType.MINUTE, messageBlackTimeWindowSettingsModel.endMinute);
        add(jSONObject, "end_time", jSONObject3);
        return null;
    }
}
