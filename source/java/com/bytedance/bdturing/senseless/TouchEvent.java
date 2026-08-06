package com.bytedance.bdturing.senseless;

import com.bytedance.android.anniex.solutions.card.AirActionConstant;
import com.ss.android.socialbase.downloader.file.DownloadFileUtils;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class TouchEvent {
    public float force;
    public float majorRadius;
    public int phase;
    public long timestamp;
    public float x;
    public float y;

    public JSONObject toJsonObj() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("t", this.timestamp);
            jSONObject.put(AirActionConstant.ActionId.ACTION_ID_PARAMS, this.phase);
            jSONObject.put("x", this.x);
            jSONObject.put("y", this.y);
            jSONObject.put(DownloadFileUtils.MODE_READ, this.majorRadius);
            jSONObject.put("f", this.force);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public TouchEvent copy() {
        TouchEvent touchEvent = new TouchEvent();
        touchEvent.timestamp = this.timestamp;
        touchEvent.phase = this.phase;
        touchEvent.x = this.x;
        touchEvent.y = this.y;
        touchEvent.majorRadius = this.majorRadius;
        touchEvent.force = this.force;
        return touchEvent;
    }
}
