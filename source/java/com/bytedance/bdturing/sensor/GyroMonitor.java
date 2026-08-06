package com.bytedance.bdturing.sensor;

import android.app.Activity;
import android.hardware.SensorEvent;
import android.os.Handler;
import com.bytedance.android.anniex.solutions.card.AirActionConstant;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class GyroMonitor extends AbstractSensorMonitor {
    private static final float NS2S = 1.0E-9f;
    private static final String TAG = "GyroMonitor";
    private long mTimestamp;

    @Override // com.bytedance.bdturing.sensor.AbstractSensorMonitor
    public int sensorType() {
        return 4;
    }

    public GyroMonitor(Activity activity, Handler handler, long j, long j2) {
        super(activity, handler, j, j2);
    }

    @Override // com.bytedance.bdturing.sensor.AbstractSensorMonitor
    public JSONObject handleSensorEvent(SensorEvent sensorEvent) {
        if (this.mTimestamp == 0) {
            this.mTimestamp = sensorEvent.timestamp;
            return null;
        }
        float f = ((float) (sensorEvent.timestamp - this.mTimestamp)) * NS2S;
        float degrees = (float) Math.toDegrees(sensorEvent.values[0] * f);
        float degrees2 = (float) Math.toDegrees(sensorEvent.values[1] * f);
        float degrees3 = (float) Math.toDegrees(sensorEvent.values[2] * f);
        this.mTimestamp = sensorEvent.timestamp;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("x", degrees);
            jSONObject.put("y", degrees2);
            jSONObject.put("z", degrees3);
            jSONObject.put(AirActionConstant.ActionId.ACTION_ID_MEMBER, System.currentTimeMillis());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
