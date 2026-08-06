package com.bytedance.bdturing;

import android.view.MotionEvent;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class OnTouchSmarterListener {
    private static long CLICK_INTERVAL = 1000;
    private long mActionDownTime = 0;
    private long mActionUpTime;

    /* loaded from: classes3.dex */
    public interface SmarterCallback {
        void execute(JSONObject jSONObject);
    }

    public void onActionDownEvent() {
        this.mActionDownTime = System.currentTimeMillis();
    }

    public void onActionUpEvent(MotionEvent motionEvent, SmarterCallback smarterCallback) {
        if (throttle()) {
            return;
        }
        this.mActionUpTime = System.currentTimeMillis();
        smarterCallback.execute(getData(motionEvent));
    }

    private JSONObject getData(MotionEvent motionEvent) {
        JSONObject jSONObject = new JSONObject();
        float pressure = motionEvent.getPressure();
        float touchMajor = motionEvent.getTouchMajor();
        JSONArray jSONArray = new JSONArray();
        long j = this.mActionUpTime - this.mActionDownTime;
        try {
            jSONArray.put(motionEvent.getX());
            jSONArray.put(motionEvent.getY());
            jSONObject.put("force", pressure);
            jSONObject.put("majorRadius", touchMajor);
            jSONObject.put("click_coordinate", jSONArray);
            jSONObject.put("click_duration", j);
            jSONObject.put("operate_duration", 0);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public long getActionDownTime() {
        return this.mActionDownTime;
    }

    private boolean throttle() {
        return System.currentTimeMillis() - this.mActionUpTime < CLICK_INTERVAL;
    }
}
