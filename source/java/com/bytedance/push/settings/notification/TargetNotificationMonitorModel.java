package com.bytedance.push.settings.notification;

import com.bytedance.common.push.BaseJson;
import com.bytedance.push.utils.PatternUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class TargetNotificationMonitorModel extends BaseJson {
    private static final String KEY_BLACK_FIELD_LIST = "black_field_list";
    private static final String KEY_NEED_INTERCEPT = "need_intercept";
    private static final String KEY_REG = "reg";
    public List<String> blackFiledList;
    public boolean needIntercept;
    public String regText;

    public TargetNotificationMonitorModel(JSONObject jSONObject) {
        try {
            this.regText = jSONObject.optString(KEY_REG);
            this.needIntercept = jSONObject.optBoolean(KEY_NEED_INTERCEPT);
            JSONArray optJSONArray = jSONObject.optJSONArray(KEY_BLACK_FIELD_LIST);
            this.blackFiledList = new ArrayList();
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.blackFiledList.add(optJSONArray.getString(i));
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        add(jSONObject, KEY_REG, this.regText);
        add(jSONObject, KEY_NEED_INTERCEPT, this.needIntercept);
        if (this.blackFiledList != null) {
            JSONArray jSONArray = new JSONArray();
            Iterator<String> it = this.blackFiledList.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next());
            }
            add(jSONObject, KEY_BLACK_FIELD_LIST, jSONArray);
        }
        return jSONObject;
    }

    public boolean matchTarget(String str) {
        return PatternUtils.inputMatchRegText(str, this.regText);
    }

    public String toString() {
        return "regText:" + this.regText + " blackFiledList:" + this.blackFiledList;
    }
}
