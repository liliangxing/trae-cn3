package com.bytedance.push.client.intelligence;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.os.BatteryManager;
import android.os.Build;
import android.util.Log;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.common.push.ThreadPlus;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class ReportHelper {
    private static final String TAG = "ReportHelper";
    private static volatile ReportHelper sInstance;
    private JSONObject allInfo = new JSONObject();
    private JSONObject deviceContextCollectTime = new JSONObject();
    private Sensor mAccelerometerSensor;
    private AudioManager mAudioManager;
    private BatteryManager mBatteryManager;
    private Context mContext;
    private Sensor mGyroScopeSensor;
    private Sensor mLightSensor;
    private Sensor mProximitySensor;
    private SensorManager mSensorManager;
    private Sensor mStepCounterSensor;
    private MySensorEventListener sensorEventListener;

    public static ReportHelper getInstance() {
        if (sInstance == null) {
            synchronized (ReportHelper.class) {
                if (sInstance == null) {
                    sInstance = new ReportHelper();
                }
            }
        }
        return sInstance;
    }

    private ReportHelper() {
    }

    public void collectData(Context context) {
        this.mContext = context;
        ThreadPlus.submitRunnable(new Runnable() { // from class: com.bytedance.push.client.intelligence.ReportHelper.1
            @Override // java.lang.Runnable
            public void run() {
                ReportHelper.this.initSensor();
                ReportHelper.this.initBattery();
                ReportHelper.this.initAudio();
            }
        });
    }

    public JSONObject reportData() {
        try {
            this.allInfo.put("current_time", System.currentTimeMillis());
        } catch (JSONException e) {
            Log.e(TAG, "reportData : " + e.getMessage());
        }
        return this.allInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initBattery() {
        if (this.mBatteryManager == null) {
            this.mBatteryManager = (BatteryManager) this.mContext.getSystemService("batterymanager");
        }
        try {
            BatteryManager batteryManager = this.mBatteryManager;
            if (batteryManager != null) {
                this.allInfo.put(PerfConsts.KEY_CURRENT_CAPACITY, batteryManager.getIntProperty(4));
                if (Build.VERSION.SDK_INT >= 26) {
                    this.allInfo.put("status", this.mBatteryManager.getIntProperty(6));
                }
            }
        } catch (JSONException e) {
            Log.e(TAG, "initBattery : " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initAudio() {
        if (this.mAudioManager == null) {
            this.mAudioManager = (AudioManager) this.mContext.getSystemService("audio");
        }
        try {
            AudioManager audioManager = this.mAudioManager;
            if (audioManager != null) {
                this.allInfo.put("isUsingEarPhone", getHeadsetStatus(audioManager));
                this.allInfo.put("isMusicActive", this.mAudioManager.isMusicActive());
                this.allInfo.put("curCallVoice", this.mAudioManager.getStreamVolume(0));
                this.allInfo.put("maxCallVoice", this.mAudioManager.getStreamMaxVolume(0));
                this.allInfo.put("curSystemVoice", this.mAudioManager.getStreamVolume(1));
                this.allInfo.put("maxSystemVoice", this.mAudioManager.getStreamMaxVolume(1));
                this.allInfo.put("curRingVoice", this.mAudioManager.getStreamVolume(2));
                this.allInfo.put("maxRingVoice", this.mAudioManager.getStreamMaxVolume(2));
                this.allInfo.put("curMusicVoice", this.mAudioManager.getStreamVolume(3));
                this.allInfo.put("maxMusicVoice", this.mAudioManager.getStreamMaxVolume(3));
                this.allInfo.put("curAlarmVoice", this.mAudioManager.getStreamVolume(4));
                this.allInfo.put("maxAlarmVoice", this.mAudioManager.getStreamMaxVolume(4));
            }
        } catch (JSONException e) {
            Log.e(TAG, "initAudio : " + e.getMessage());
        }
    }

    private boolean getHeadsetStatus(AudioManager audioManager) {
        if (audioManager.isWiredHeadsetOn()) {
            return true;
        }
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter == null || !defaultAdapter.isEnabled()) {
            return false;
        }
        int profileConnectionState = defaultAdapter.getProfileConnectionState(2);
        int profileConnectionState2 = defaultAdapter.getProfileConnectionState(1);
        int profileConnectionState3 = defaultAdapter.getProfileConnectionState(3);
        if (profileConnectionState != 2) {
            profileConnectionState = profileConnectionState2 == 2 ? profileConnectionState2 : profileConnectionState3 == 2 ? profileConnectionState3 : -1;
        }
        return profileConnectionState != -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initSensor() {
        if (this.sensorEventListener == null) {
            this.sensorEventListener = new MySensorEventListener();
        }
        if (this.mSensorManager == null) {
            SensorManager sensorManager = (SensorManager) this.mContext.getSystemService("sensor");
            this.mSensorManager = sensorManager;
            if (sensorManager != null) {
                this.mAccelerometerSensor = sensorManager.getDefaultSensor(1);
                this.mGyroScopeSensor = this.mSensorManager.getDefaultSensor(4);
                this.mLightSensor = this.mSensorManager.getDefaultSensor(5);
                this.mStepCounterSensor = this.mSensorManager.getDefaultSensor(19);
                this.mProximitySensor = this.mSensorManager.getDefaultSensor(8);
            }
        }
        SensorManager sensorManager2 = this.mSensorManager;
        if (sensorManager2 != null) {
            sensorManager2.registerListener(this.sensorEventListener, this.mGyroScopeSensor, 0);
            this.mSensorManager.registerListener(this.sensorEventListener, this.mAccelerometerSensor, 0);
            this.mSensorManager.registerListener(this.sensorEventListener, this.mLightSensor, 0);
            this.mSensorManager.registerListener(this.sensorEventListener, this.mStepCounterSensor, 0);
            this.mSensorManager.registerListener(this.sensorEventListener, this.mProximitySensor, 0);
            try {
                this.deviceContextCollectTime.put("registerTime", System.currentTimeMillis());
            } catch (JSONException e) {
                Log.e(TAG, "initSensor : " + e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public final class MySensorEventListener implements SensorEventListener {
        boolean acReady;
        boolean gyReady;
        boolean lightReady;
        boolean proReady;
        JSONObject sensorInfo;
        boolean stepReady;

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        private MySensorEventListener() {
            this.sensorInfo = new JSONObject();
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            try {
                if (sensorEvent.sensor.getType() == 4) {
                    this.sensorInfo.put("xGy", sensorEvent.values[0]);
                    this.sensorInfo.put("yGy", sensorEvent.values[1]);
                    this.sensorInfo.put("zGy", sensorEvent.values[2]);
                    ReportHelper.this.deviceContextCollectTime.put("gyroscopeTime", System.currentTimeMillis());
                    ReportHelper.this.mSensorManager.unregisterListener(ReportHelper.this.sensorEventListener, ReportHelper.this.mGyroScopeSensor);
                    this.gyReady = true;
                }
                if (sensorEvent.sensor.getType() == 1) {
                    this.sensorInfo.put("xAc", sensorEvent.values[0]);
                    this.sensorInfo.put("yAc", sensorEvent.values[1]);
                    this.sensorInfo.put("zAc", sensorEvent.values[2]);
                    ReportHelper.this.deviceContextCollectTime.put("accelerometerTime", System.currentTimeMillis());
                    ReportHelper.this.mSensorManager.unregisterListener(ReportHelper.this.sensorEventListener, ReportHelper.this.mAccelerometerSensor);
                    this.acReady = true;
                }
                if (sensorEvent.sensor.getType() == 5) {
                    this.sensorInfo.put("light", sensorEvent.values[0]);
                    ReportHelper.this.deviceContextCollectTime.put("lightTime", System.currentTimeMillis());
                    ReportHelper.this.mSensorManager.unregisterListener(ReportHelper.this.sensorEventListener, ReportHelper.this.mLightSensor);
                    this.lightReady = true;
                }
                if (sensorEvent.sensor.getType() == 19) {
                    this.sensorInfo.put("stepCount", (int) sensorEvent.values[0]);
                    ReportHelper.this.deviceContextCollectTime.put("stepcountTime", System.currentTimeMillis());
                    ReportHelper.this.mSensorManager.unregisterListener(ReportHelper.this.sensorEventListener, ReportHelper.this.mStepCounterSensor);
                    this.stepReady = true;
                }
                if (sensorEvent.sensor.getType() == 8) {
                    this.sensorInfo.put("distance", sensorEvent.values[0]);
                    ReportHelper.this.deviceContextCollectTime.put("distanceTime", System.currentTimeMillis());
                    ReportHelper.this.mSensorManager.unregisterListener(ReportHelper.this.sensorEventListener, ReportHelper.this.mProximitySensor);
                    this.proReady = true;
                }
                if (this.gyReady && this.lightReady && this.proReady && this.stepReady && this.acReady) {
                    JSONObject jSONObject = ReportHelper.this.allInfo;
                    ReportHelper.this.allInfo = this.sensorInfo;
                    ReportHelper reportHelper = ReportHelper.this;
                    reportHelper.appendJson(reportHelper.allInfo, jSONObject);
                    ReportHelper.this.allInfo.put("sensor_collect_time", ReportHelper.this.deviceContextCollectTime);
                    this.gyReady = false;
                    this.acReady = false;
                    this.lightReady = false;
                    this.stepReady = false;
                    this.proReady = false;
                }
            } catch (JSONException e) {
                Log.e(ReportHelper.TAG, "SensorEventListener : " + e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void appendJson(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        if (jSONObject == null || jSONObject2 == null) {
            return;
        }
        Iterator<String> keys = jSONObject2.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            jSONObject.put(next, jSONObject2.getString(next));
        }
    }
}
