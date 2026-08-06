package com.bytedance.common.interfaze;

import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

/* loaded from: classes3.dex */
public interface SensorAbility {
    Sensor getDefaultSensor(SensorManager sensorManager, int i);

    boolean registerListener(SensorManager sensorManager, SensorEventListener sensorEventListener, Sensor sensor, int i);

    void unregisterListener(SensorManager sensorManager, SensorEventListener sensorEventListener, Sensor sensor);
}
