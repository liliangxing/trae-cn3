package com.ss.ttm.player;

import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class SensorData {
    protected static final int Sensor_ACC_Data = 1;
    protected static final int Sensor_MAG_Data = 2;
    protected static final int Sensor_ROT_Data = 3;
    private long mHandle = 0;
    private SensorManager mSensorManager = null;
    private SensorEventListener mListener = null;
    private float[] magnet = new float[3];
    private float[] accel = new float[3];

    private static final native void _writeData(long handle, int dataType, float ax, float ay, float az);

    protected void finalize() {
        stop();
    }

    public Boolean initListeners() {
        return false;
    }

    public void setHandle(long handle, TTPlayer player) {
        this.mHandle = handle;
        player.getContext();
    }

    public void stop() {
        Log.e("ttmn", "stop sensor");
        this.mHandle = 0L;
    }

    public int start() {
        return initListeners().booleanValue() ? 0 : -1;
    }
}
