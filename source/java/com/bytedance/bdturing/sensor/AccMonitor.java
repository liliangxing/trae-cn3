package com.bytedance.bdturing.sensor;

import android.app.Activity;
import android.hardware.SensorEvent;
import android.os.Handler;
import com.bytedance.android.anniex.solutions.card.AirActionConstant;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class AccMonitor extends AbstractSensorMonitor {
    private static final String TAG = "AccMonitor";

    @Override // com.bytedance.bdturing.sensor.AbstractSensorMonitor
    public int sensorType() {
        return 1;
    }

    public AccMonitor(Activity activity, Handler handler, long j, long j2) {
        super(activity, handler, j, j2);
    }

    @Override // com.bytedance.bdturing.sensor.AbstractSensorMonitor
    public JSONObject handleSensorEvent(SensorEvent sensorEvent) {
        float f = sensorEvent.values[0];
        float f2 = sensorEvent.values[1];
        float f3 = sensorEvent.values[2];
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("x", f);
            jSONObject.put("y", f2);
            jSONObject.put("z", f3);
            jSONObject.put(AirActionConstant.ActionId.ACTION_ID_MEMBER, System.currentTimeMillis());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
