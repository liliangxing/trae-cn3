package com.ss.bytertc.base.utils;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.WindowManager;
import com.bytedance.realx.base.ContextUtils;
import com.ss.bytertc.engine.UIDeviceOrientation;

/* loaded from: classes7.dex */
public class OrientationMonitor {
    private Context mContext;
    private GravityOrientationDetector mGravitySensorListener = null;
    private long mNativeObj;

    public static native void nativeOnGravityOrientationChange(long nativeObj, int orientation);

    OrientationMonitor(long nativeObj) {
        this.mContext = null;
        this.mNativeObj = nativeObj;
        this.mContext = ContextUtils.getApplicationContext();
    }

    public int getUIOrientation() {
        Context context = this.mContext;
        if (context == null) {
            this.mContext = ContextUtils.getApplicationContext();
            return -1;
        }
        int rotation = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation();
        if (rotation == 1) {
            return UIDeviceOrientation.LandscapeRight.value();
        }
        if (rotation == 2) {
            return UIDeviceOrientation.PortraitUpsidedown.value();
        }
        if (rotation == 3) {
            return UIDeviceOrientation.LandscapeLeft.value();
        }
        return UIDeviceOrientation.Portrait.value();
    }

    int startGravityRotationCheck() {
        Context context = this.mContext;
        if (context == null) {
            this.mContext = ContextUtils.getApplicationContext();
            return -1;
        }
        SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
        if (sensorManager == null) {
            return -2;
        }
        Sensor defaultSensor = sensorManager.getDefaultSensor(9);
        if (defaultSensor == null) {
            return -3;
        }
        if (this.mGravitySensorListener == null) {
            this.mGravitySensorListener = new GravityOrientationDetector();
        }
        sensorManager.registerListener(this.mGravitySensorListener, defaultSensor, 2);
        return 0;
    }

    int stopGravityRotationCheck() {
        Context context = this.mContext;
        if (context == null) {
            return -1;
        }
        SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
        if (sensorManager == null) {
            return -2;
        }
        GravityOrientationDetector gravityOrientationDetector = this.mGravitySensorListener;
        if (gravityOrientationDetector == null) {
            return -3;
        }
        sensorManager.unregisterListener(gravityOrientationDetector);
        return 0;
    }

    /* loaded from: classes7.dex */
    class GravityOrientationDetector implements SensorEventListener {
        private int mGravityOrientation = UIDeviceOrientation.Portrait.value();

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
        }

        GravityOrientationDetector() {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent event) {
            int value;
            float f = event.values[0];
            float f2 = event.values[1];
            float abs = Math.abs(f);
            float abs2 = Math.abs(f2);
            if (Math.abs(abs - abs2) < 6.0d) {
                return;
            }
            if (abs >= abs2) {
                if (f >= 0.0f) {
                    value = UIDeviceOrientation.LandscapeRight.value();
                } else {
                    value = UIDeviceOrientation.LandscapeLeft.value();
                }
            } else if (f2 >= 0.0f) {
                value = UIDeviceOrientation.Portrait.value();
            } else {
                value = UIDeviceOrientation.PortraitUpsidedown.value();
            }
            if (value != this.mGravityOrientation) {
                this.mGravityOrientation = value;
                OrientationMonitor.nativeOnGravityOrientationChange(OrientationMonitor.this.mNativeObj, this.mGravityOrientation);
            }
        }
    }
}
