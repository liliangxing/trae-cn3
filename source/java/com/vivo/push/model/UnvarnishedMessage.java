package com.vivo.push.model;

import android.text.TextUtils;
import com.vivo.push.util.q;
import com.vivo.push.util.t;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class UnvarnishedMessage {
    private static final String TAG = "UnvarnishedMessage";
    private String mMessage;
    private long mMsgId;
    private int mTargetType;
    private String mTragetContent;
    private Map<String, String> mParams = new HashMap();
    private int mTransmissionMessageEventType = 0;

    public UnvarnishedMessage() {
    }

    public UnvarnishedMessage(String str) {
        packToObj(str);
    }

    public long getMsgId() {
        return this.mMsgId;
    }

    public void setMsgId(long j) {
        this.mMsgId = j;
    }

    public String getMessage() {
        return this.mMessage;
    }

    public void setMessage(String str) {
        this.mMessage = str;
    }

    public String getTragetContent() {
        return this.mTragetContent;
    }

    public void setTragetContent(String str) {
        this.mTragetContent = str;
    }

    public int getTargetType() {
        return this.mTargetType;
    }

    public void setTargetType(int i) {
        this.mTargetType = i;
    }

    public Map<String, String> getParams() {
        return this.mParams;
    }

    public void setParams(Map<String, String> map) {
        this.mParams = map;
    }

    public boolean isTransMsgArrive() {
        return this.mTransmissionMessageEventType == 0;
    }

    public boolean isTransMsgExpired() {
        return this.mTransmissionMessageEventType == 1;
    }

    public void setTransmissionMessageEventType(int i) {
        this.mTransmissionMessageEventType = i;
    }

    public String unpackToJson() {
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(this.mTargetType);
        jSONArray.put(this.mTragetContent);
        jSONArray.put(this.mMessage);
        Object obj = this.mParams;
        if (obj == null) {
            obj = new HashMap();
        }
        jSONArray.put(obj);
        return jSONArray.toString();
    }

    private void packToObj(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                t.a(TAG, "unvarnishedMsg pack to obj is null");
                return;
            }
            JSONArray jSONArray = new JSONArray(str);
            this.mTargetType = jSONArray.optInt(0);
            this.mTragetContent = jSONArray.getString(1);
            this.mMessage = jSONArray.getString(2);
            this.mParams = q.a(new JSONObject(jSONArray.getString(3)));
        } catch (JSONException e) {
            e.printStackTrace();
            t.a(TAG, "unvarnishedMsg pack to obj error", e);
        }
    }
}
