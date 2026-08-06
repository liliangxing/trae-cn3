package com.bytedance.push.settings.notification;

import com.bytedance.common.push.BaseJson;
import com.bytedance.push.settings.IDefaultValueProvider;
import com.bytedance.push.settings.ITypeConverter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class NotificationMonitorSettingsConverter extends BaseJson implements ITypeConverter<NotificationMonitorSettingsModel>, IDefaultValueProvider<NotificationMonitorSettingsModel> {
    private final String KEY_ENABLE_MONITOR_NOTIFICATION_SHOW = "enable_monitor_notification_show";
    private final String KEY_ALLOW_INTERCEPT_FOREGROUND_NOTIFICATION = "allow_intercept_foreground_notification";
    private final String KEY_REPORT_VALID_NOTIFICATION = "report_valid_notification";
    private final String KEY_NEED_INTERCEPT_EMPTY_NOTIFICATION = "need_intercept_empty_notification";
    private final String KEY_NEED_INTERCEPT_GROUP = "need_intercept_group";
    private final String KEY_NEED_INTERCEPT_TOP = "need_intercept_top";
    private final String KEY_NEED_INTERCEPT_STICK = "need_intercept_stick";
    private final String KEY_NEED_INTERCEPT_CANCEL_ERROR = "need_intercept_cancel_error";
    private final String KEY_NEED_INTERCEPT_PENDING_INTENT_ERROR = "need_intercept_pending_intent_error";
    private final String KEY_INTERCEPT_STACK = "intercept_stack";
    private final String KEY_NEED_INTERCEPT_STYLE_LIST = "need_intercept_style_list";
    private final String KEY_BLACK_FIELD_LIST = "black_field_list";
    private final String KEY_WHITE_GROUP_LIST = "white_group_list";
    private final String KEY_GROUP_TAG_LIST = "group_tag_list";
    private final String KEY_GROUP_NAME_LIST = "group_name_list";
    private final String KEY_TARGET_TEXT_REG_LIST = "target_text_reg_list";
    private final String KEY_MIN_MONITOR_INTERVAL = "min_monitor_interval";

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.push.settings.IDefaultValueProvider
    public NotificationMonitorSettingsModel create() {
        return new NotificationMonitorSettingsModel();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.push.settings.ITypeConverter
    public NotificationMonitorSettingsModel to(String str) {
        NotificationMonitorSettingsModel create = create();
        try {
            JSONObject jSONObject = new JSONObject(str);
            create.enableMonitorNotificationShow = jSONObject.optBoolean("enable_monitor_notification_show");
            create.allowInterceptForegroundNotification = jSONObject.optBoolean("allow_intercept_foreground_notification");
            create.reportValidNotification = jSONObject.optBoolean("report_valid_notification");
            create.needInterceptEmptyNotification = jSONObject.optBoolean("need_intercept_empty_notification");
            create.needInterceptGroup = jSONObject.optBoolean("need_intercept_group");
            create.needInterceptTop = jSONObject.optBoolean("need_intercept_top");
            create.needInterceptStick = jSONObject.optBoolean("need_intercept_stick");
            create.needInterceptCancelError = jSONObject.optBoolean("need_intercept_cancel_error");
            create.needInterceptPendingIntentError = jSONObject.optBoolean("need_intercept_pending_intent_error");
            create.minMonitorInterval = jSONObject.optLong("min_monitor_interval", 5000L);
            JSONArray optJSONArray = jSONObject.optJSONArray("need_intercept_style_list");
            if (optJSONArray != null) {
                create.needInterceptStyleList = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    create.needInterceptStyleList.add(optJSONArray.getString(i));
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("black_field_list");
            create.blackFiledList = new ArrayList();
            if (optJSONArray2 != null) {
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    create.blackFiledList.add(optJSONArray2.getString(i2));
                }
            }
            JSONArray optJSONArray3 = jSONObject.optJSONArray("white_group_list");
            create.whiteGroupList = new ArrayList();
            if (optJSONArray3 != null) {
                for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                    create.whiteGroupList.add(optJSONArray3.getString(i3));
                }
            }
            JSONArray optJSONArray4 = jSONObject.optJSONArray("group_tag_list");
            create.groupTagList = new ArrayList();
            if (optJSONArray4 != null) {
                for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                    create.groupTagList.add(optJSONArray4.getString(i4));
                }
            }
            JSONArray optJSONArray5 = jSONObject.optJSONArray("group_name_list");
            create.groupNameList = new ArrayList();
            if (optJSONArray5 != null) {
                for (int i5 = 0; i5 < optJSONArray5.length(); i5++) {
                    create.groupNameList.add(optJSONArray5.getString(i5));
                }
            }
            JSONArray optJSONArray6 = jSONObject.optJSONArray("intercept_stack");
            if (optJSONArray6 != null) {
                create.interceptStack = new ArrayList();
                for (int i6 = 0; i6 < optJSONArray6.length(); i6++) {
                    JSONArray jSONArray = (JSONArray) optJSONArray6.get(i6);
                    if (jSONArray != null) {
                        ArrayList arrayList = new ArrayList();
                        for (int i7 = 0; i7 < jSONArray.length(); i7++) {
                            arrayList.add((String) jSONArray.get(i7));
                        }
                        create.interceptStack.add(arrayList);
                    }
                }
            }
            JSONArray optJSONArray7 = jSONObject.optJSONArray("target_text_reg_list");
            create.targetNotificationMonitorModelList = new ArrayList();
            if (optJSONArray7 != null) {
                for (int i8 = 0; i8 < optJSONArray7.length(); i8++) {
                    create.targetNotificationMonitorModelList.add(new TargetNotificationMonitorModel(optJSONArray7.getJSONObject(i8)));
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return create;
    }

    @Override // com.bytedance.push.settings.ITypeConverter
    public String from(NotificationMonitorSettingsModel notificationMonitorSettingsModel) {
        JSONObject jSONObject = new JSONObject();
        add(jSONObject, "enable_monitor_notification_show", notificationMonitorSettingsModel.enableMonitorNotificationShow);
        add(jSONObject, "allow_intercept_foreground_notification", notificationMonitorSettingsModel.allowInterceptForegroundNotification);
        add(jSONObject, "report_valid_notification", notificationMonitorSettingsModel.reportValidNotification);
        add(jSONObject, "need_intercept_empty_notification", notificationMonitorSettingsModel.needInterceptEmptyNotification);
        add(jSONObject, "need_intercept_group", notificationMonitorSettingsModel.needInterceptGroup);
        add(jSONObject, "need_intercept_top", notificationMonitorSettingsModel.needInterceptTop);
        add(jSONObject, "need_intercept_stick", notificationMonitorSettingsModel.needInterceptStick);
        add(jSONObject, "need_intercept_cancel_error", notificationMonitorSettingsModel.needInterceptCancelError);
        add(jSONObject, "need_intercept_pending_intent_error", notificationMonitorSettingsModel.needInterceptPendingIntentError);
        add(jSONObject, "min_monitor_interval", notificationMonitorSettingsModel.minMonitorInterval);
        if (notificationMonitorSettingsModel.needInterceptStyleList != null) {
            JSONArray jSONArray = new JSONArray();
            Iterator<String> it = notificationMonitorSettingsModel.needInterceptStyleList.iterator();
            while (it.hasNext()) {
                jSONArray.put((String) it.next());
            }
            add(jSONObject, "need_intercept_style_list", jSONArray);
        }
        if (notificationMonitorSettingsModel.blackFiledList != null) {
            JSONArray jSONArray2 = new JSONArray();
            Iterator<String> it2 = notificationMonitorSettingsModel.blackFiledList.iterator();
            while (it2.hasNext()) {
                jSONArray2.put((String) it2.next());
            }
            add(jSONObject, "black_field_list", jSONArray2);
        }
        if (notificationMonitorSettingsModel.whiteGroupList != null) {
            JSONArray jSONArray3 = new JSONArray();
            Iterator<String> it3 = notificationMonitorSettingsModel.whiteGroupList.iterator();
            while (it3.hasNext()) {
                jSONArray3.put((String) it3.next());
            }
            add(jSONObject, "white_group_list", jSONArray3);
        }
        if (notificationMonitorSettingsModel.groupTagList != null) {
            JSONArray jSONArray4 = new JSONArray();
            Iterator<String> it4 = notificationMonitorSettingsModel.groupTagList.iterator();
            while (it4.hasNext()) {
                jSONArray4.put((String) it4.next());
            }
            add(jSONObject, "group_tag_list", jSONArray4);
        }
        if (notificationMonitorSettingsModel.groupNameList != null) {
            JSONArray jSONArray5 = new JSONArray();
            Iterator<String> it5 = notificationMonitorSettingsModel.groupNameList.iterator();
            while (it5.hasNext()) {
                jSONArray5.put((String) it5.next());
            }
            add(jSONObject, "group_name_list", jSONArray5);
        }
        if (notificationMonitorSettingsModel.interceptStack != null) {
            JSONArray jSONArray6 = new JSONArray();
            for (List<String> list : notificationMonitorSettingsModel.interceptStack) {
                JSONArray jSONArray7 = new JSONArray();
                Iterator<String> it6 = list.iterator();
                while (it6.hasNext()) {
                    jSONArray7.put(it6.next());
                }
                jSONArray6.put(jSONArray7);
            }
            add(jSONObject, "intercept_stack", jSONArray6);
        }
        if (notificationMonitorSettingsModel.targetNotificationMonitorModelList != null) {
            JSONArray jSONArray8 = new JSONArray();
            Iterator<TargetNotificationMonitorModel> it7 = notificationMonitorSettingsModel.targetNotificationMonitorModelList.iterator();
            while (it7.hasNext()) {
                jSONArray8.put(it7.next().toJson());
            }
            add(jSONObject, "target_text_reg_list", jSONArray8);
        }
        return jSONObject.toString();
    }
}
