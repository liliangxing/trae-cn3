package com.bytedance.common.model;

import android.text.TextUtils;
import com.bytedance.common.push.BaseJson;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class MethodCallRecord extends BaseJson {
    private String args;
    private String id;
    private List listArgs;
    private String methodName;
    private String originProcessSuffix;
    private String targetProcessSuffix;

    public String toString() {
        return "MethodCallRecord{originProcessSuffix='" + this.originProcessSuffix + "', targetProcessSuffix='" + this.targetProcessSuffix + "', methodName='" + this.methodName + "', args='" + this.args + "', id='" + this.id + "'}";
    }

    public MethodCallRecord(String str, String str2, String str3, String str4, String str5) {
        this.originProcessSuffix = str;
        this.targetProcessSuffix = str2;
        this.methodName = str3;
        this.args = str4;
        this.id = str5;
        if (TextUtils.isEmpty(str4)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str4);
            int length = jSONObject.length();
            this.listArgs = new ArrayList();
            for (int i = 0; i < length; i++) {
                this.listArgs.add(jSONObject.getString(i + ""));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public MethodCallRecord(String str, String str2, String str3, List list) {
        this.originProcessSuffix = str;
        this.targetProcessSuffix = str2;
        this.methodName = str3;
        this.listArgs = list;
        if (list == null) {
            this.args = new JSONObject().toString();
            return;
        }
        JSONObject jSONObject = new JSONObject();
        for (int i = 0; i < list.size(); i++) {
            add(jSONObject, i + "", list.get(i).toString());
        }
        this.args = jSONObject.toString();
    }

    public String getMethodName() {
        return this.methodName;
    }

    public MethodCallRecord setMethodName(String str) {
        this.methodName = str;
        return this;
    }

    public String getArgs() {
        return this.args;
    }

    public MethodCallRecord setArgs(String str) {
        this.args = str;
        return this;
    }

    public String getTargetProcessSuffix() {
        return this.targetProcessSuffix;
    }

    public MethodCallRecord setTargetProcessSuffix(String str) {
        this.targetProcessSuffix = str;
        return this;
    }

    public List getListArgs() {
        return this.listArgs;
    }

    public MethodCallRecord setListArgs(List list) {
        this.listArgs = list;
        return this;
    }

    public String getOriginProcessSuffix() {
        return this.originProcessSuffix;
    }

    public MethodCallRecord setOriginProcessSuffix(String str) {
        this.originProcessSuffix = str;
        return this;
    }

    public String getId() {
        return this.id;
    }

    public MethodCallRecord setId(String str) {
        this.id = str;
        return this;
    }
}
