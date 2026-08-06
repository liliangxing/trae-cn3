package com.lynx.canvas.hardware;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.lynx.canvas.KryptonLLog;
import com.lynx.canvas.KryptonSensorService;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes6.dex */
public class KryptonDefaultSensorService extends KryptonSensorService {
    private static final String TAG = "KryptonDefaultSensorService";
    private HashMap<Integer, Sensor> mCachedSensors;
    private final Invoker mInvoker;
    private KryptonSensorService.Listener mListener;
    private SensorEventListener mOrientationListener;
    private final SensorManager mSensorManager;

    /* loaded from: classes6.dex */
    public interface Invoker {
        boolean registerSensorListener(SensorManager sensorManager, SensorEventListener sensorEventListener, Sensor sensor, int i);

        void unregisterSensorListener(SensorManager sensorManager, SensorEventListener sensorEventListener);
    }

    public KryptonDefaultSensorService(Context context, Invoker invoker) {
        this.mSensorManager = (SensorManager) context.getSystemService("sensor");
        this.mInvoker = invoker;
    }

    @Override // com.lynx.canvas.KryptonSensorService
    public void setListener(KryptonSensorService.Listener listener) {
        synchronized (this) {
            this.mListener = listener;
        }
    }

    @Override // com.lynx.canvas.KryptonSensorService
    public boolean start(List<Integer> list, int i) {
        if (this.mSensorManager == null) {
            KryptonLLog.e(TAG, "get system sensor service error");
            return false;
        }
        Collection<Sensor> sensors = getSensors(list);
        if (sensors == null || sensors.isEmpty()) {
            KryptonLLog.e(TAG, "start error with empty type list");
            return false;
        }
        if (this.mOrientationListener == null) {
            initSensorEventListener();
        }
        int i2 = i * 1000;
        Invoker invoker = this.mInvoker;
        if (invoker != null) {
            invoker.unregisterSensorListener(this.mSensorManager, this.mOrientationListener);
            Iterator<Sensor> it = sensors.iterator();
            while (it.hasNext()) {
                this.mInvoker.registerSensorListener(this.mSensorManager, this.mOrientationListener, it.next(), i2);
            }
            return true;
        }
        this.mSensorManager.unregisterListener(this.mOrientationListener);
        Iterator<Sensor> it2 = sensors.iterator();
        while (it2.hasNext()) {
            this.mSensorManager.registerListener(this.mOrientationListener, it2.next(), i2);
        }
        return true;
    }

    @Override // com.lynx.canvas.KryptonSensorService
    public void stop() {
        Invoker invoker = this.mInvoker;
        if (invoker != null) {
            invoker.unregisterSensorListener(this.mSensorManager, this.mOrientationListener);
        } else {
            this.mSensorManager.unregisterListener(this.mOrientationListener);
        }
    }

    private void initSensorEventListener() {
        this.mOrientationListener = new SensorEventListener() { // from class: com.lynx.canvas.hardware.KryptonDefaultSensorService.1
            private final float[] rotationMatrix = new float[16];
            private final float[] orientation = new float[3];

            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i) {
            }

            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                KryptonSensorService.Listener listener;
                synchronized (this) {
                    listener = KryptonDefaultSensorService.this.mListener;
                }
                if (sensorEvent.sensor.getType() != 15) {
                    if (sensorEvent.sensor.getType() != 4 || listener == null) {
                        return;
                    }
                    listener.notifyGyroscopeData(sensorEvent.values[0], sensorEvent.values[1], sensorEvent.values[2], sensorEvent.timestamp);
                    return;
                }
                if (listener != null) {
                    SensorManager.getRotationMatrixFromVector(this.rotationMatrix, sensorEvent.values);
                    SensorManager.getOrientation(this.rotationMatrix, this.orientation);
                    float[] fArr = this.orientation;
                    listener.notifyOrientationData(fArr[2], -fArr[1], -fArr[0], sensorEvent.timestamp);
                }
            }
        };
    }

    private Collection<Sensor> getSensors(List<Integer> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        HashMap<Integer, Sensor> hashMap = this.mCachedSensors;
        if (hashMap == null) {
            this.mCachedSensors = new HashMap<>();
        } else if (hashMap.size() != list.size()) {
            this.mCachedSensors.clear();
        } else {
            Iterator<Integer> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (!this.mCachedSensors.containsKey(it.next())) {
                    this.mCachedSensors.clear();
                    break;
                }
            }
            if (!this.mCachedSensors.isEmpty()) {
                return this.mCachedSensors.values();
            }
        }
        for (Integer num : list) {
            Sensor defaultSensor = this.mSensorManager.getDefaultSensor(num.intValue());
            if (defaultSensor != null) {
                this.mCachedSensors.put(num, defaultSensor);
            }
        }
        return this.mCachedSensors.values();
    }
}
