package com.bytedance.bdturing.sensor;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import com.bytedance.bdturing.utils.JsonUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public abstract class AbstractSensorMonitor implements SensorEventListener {
    private static final int DEFAULT_SENSOR_TYPE = -1213;
    private static final int INITIAL_SIZE = 20;
    private static final int SAMPLE_RATE_GAME = 25;
    private static final int SAMPLE_RATE_NORMAL = 300;
    private long mEventNum;
    private long mLastTimeStamp;
    private final SensorManager mManager;
    private final Handler mSensorHandler;
    private long mTimeInterval;
    private JSONObject mStateRecord = new JSONObject();
    private List<String> mSensorTypeList = new ArrayList();
    private final JSONArray mInitData = new JSONArray();
    private final LinkedList<JSONObject> mEventInfoList = new LinkedList<>();
    private JSONArray mData = new JSONArray();
    private JSONArray mAccuracyData = new JSONArray();

    public abstract JSONObject handleSensorEvent(SensorEvent sensorEvent);

    public abstract int sensorType();

    public AbstractSensorMonitor(Activity activity, Handler handler, long j, long j2) {
        this.mTimeInterval = j;
        this.mManager = (SensorManager) activity.getSystemService("sensor");
        this.mEventNum = j2;
        this.mSensorHandler = handler;
    }

    public void onResume() {
        try {
            long j = this.mTimeInterval;
            int i = j >= 300 ? 3 : 1;
            if (j < 25) {
                i = 0;
            }
            Sensor defaultSensor = this.mManager.getDefaultSensor(sensorType());
            JsonUtils.putValue(this.mStateRecord, "register_listener", "sensorName=" + (defaultSensor != null ? defaultSensor.getName() : "") + ":sampleRate=" + i + ":sensorDetail=" + defaultSensor);
            this.mManager.registerListener(this, defaultSensor, i, this.mSensorHandler);
        } catch (Exception e) {
            e.printStackTrace();
            JsonUtils.putValue(this.mStateRecord, "register_listener_error", "errorMessage:" + e);
        }
    }

    public boolean sensorEnable() {
        try {
            boolean z = this.mManager.getDefaultSensor(sensorType()) != null;
            JsonUtils.putValue(this.mStateRecord, "sensor_enable", Boolean.valueOf(z));
            return z;
        } catch (Exception e) {
            e.printStackTrace();
            JsonUtils.putValue(this.mStateRecord, "sensor_enable_error", String.valueOf(e));
            return false;
        }
    }

    public void onPause() {
        try {
            JsonUtils.putValue(this.mStateRecord, "handle_onPause", Long.valueOf(System.currentTimeMillis()));
            this.mManager.unregisterListener(this);
        } catch (Exception e) {
            e.printStackTrace();
            JsonUtils.putValue(this.mStateRecord, "handle_onPause_error", String.valueOf(e));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0072 A[Catch: Exception -> 0x0014, TryCatch #0 {Exception -> 0x0014, blocks: (B:34:0x0009, B:36:0x000d, B:5:0x001a, B:7:0x0026, B:8:0x006c, B:10:0x0072, B:12:0x0080, B:14:0x0088, B:19:0x008f, B:21:0x0099, B:22:0x009e, B:24:0x00a2, B:26:0x00ad, B:28:0x00b8), top: B:33:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    @Override // android.hardware.SensorEventListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onSensorChanged(SensorEvent sensorEvent) {
        int type;
        if (sensorEvent != null) {
            try {
                if (sensorEvent.sensor != null) {
                    type = sensorEvent.sensor.getType();
                    if (type != DEFAULT_SENSOR_TYPE && !this.mSensorTypeList.contains(String.valueOf(type))) {
                        this.mSensorTypeList.add(String.valueOf(type));
                        JsonUtils.putValue(this.mStateRecord, "onSensorChanged_" + type, "sensor_type=" + type + ":values=" + Arrays.toString(sensorEvent.values) + ":accept_sensor=" + sensorType());
                    }
                    if (sensorType() != type) {
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - this.mLastTimeStamp >= this.mTimeInterval) {
                            this.mLastTimeStamp = currentTimeMillis;
                            JSONObject handleSensorEvent = handleSensorEvent(sensorEvent);
                            if (handleSensorEvent != null && handleSensorEvent.length() != 0) {
                                if (this.mInitData.length() < 20) {
                                    this.mInitData.put(handleSensorEvent);
                                }
                                if (this.mData != null && r0.length() < this.mEventNum) {
                                    this.mEventInfoList.add(handleSensorEvent);
                                    this.mData.put(handleSensorEvent);
                                    return;
                                } else {
                                    this.mData = null;
                                    this.mEventInfoList.remove(0);
                                    this.mEventInfoList.add(handleSensorEvent);
                                    return;
                                }
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
                JsonUtils.putValue(this.mStateRecord, "onSensorChanged_error", String.valueOf(e));
                return;
            }
        }
        type = DEFAULT_SENSOR_TYPE;
        if (type != DEFAULT_SENSOR_TYPE) {
            this.mSensorTypeList.add(String.valueOf(type));
            JsonUtils.putValue(this.mStateRecord, "onSensorChanged_" + type, "sensor_type=" + type + ":values=" + Arrays.toString(sensorEvent.values) + ":accept_sensor=" + sensorType());
        }
        if (sensorType() != type) {
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
        JSONArray jSONArray;
        int type = sensor != null ? sensor.getType() : DEFAULT_SENSOR_TYPE;
        if (type == DEFAULT_SENSOR_TYPE) {
            return;
        }
        if (!this.mSensorTypeList.contains(String.valueOf(type))) {
            this.mSensorTypeList.add(String.valueOf(type));
            JsonUtils.putValue(this.mStateRecord, "onAccuracyChanged_" + type, "accuracy=" + i);
        }
        if (sensorType() != type || (jSONArray = this.mAccuracyData) == null || jSONArray.length() >= 100) {
            return;
        }
        this.mAccuracyData.put(i);
    }

    public JSONArray getData() {
        JSONArray jSONArray = this.mData;
        if (jSONArray != null) {
            return jSONArray;
        }
        LinkedList<JSONObject> linkedList = this.mEventInfoList;
        if (linkedList == null || linkedList.size() <= 0) {
            return null;
        }
        JSONArray jSONArray2 = new JSONArray();
        Iterator<JSONObject> it = this.mEventInfoList.iterator();
        while (it.hasNext()) {
            jSONArray2.put(it.next());
        }
        return jSONArray2;
    }

    public JSONArray getInitialData() {
        return this.mInitData;
    }

    public JSONArray getAccuracyData() {
        return this.mAccuracyData;
    }

    public JSONObject getStateRecord() {
        return this.mStateRecord;
    }
}
