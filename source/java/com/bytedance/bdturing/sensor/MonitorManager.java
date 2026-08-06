package com.bytedance.bdturing.sensor;

import android.app.Activity;
import android.os.Handler;
import android.os.HandlerThread;
import com.bytedance.bdturing.BdTuring;
import com.bytedance.bdturing.BdTuringConfig;
import com.bytedance.bdturing.EventReport;
import com.bytedance.bdturing.setting.SettingsManager;
import com.bytedance.bdturing.utils.JsonUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class MonitorManager {
    private static final double INTERVAL_MAX = 1.0d;
    private static final double INTERVAL_MIN = 0.01d;
    private static final long SENSOR_EVENT_NUM_MAX = 3000;
    private static final String TAG = "MonitorManager";
    private AccMonitor mAccMonitor;
    private GyroMonitor mGyroMonitor;
    private Handler mSensorHandler;
    private HandlerThread mSensorThread;
    private JSONObject mStateRecord = new JSONObject();
    private SensorStatus mStatus;

    public MonitorManager(Activity activity) {
        init(activity);
    }

    private void init(Activity activity) {
        initSensorHandler();
        this.mStatus = new SensorStatus();
        boolean h5AccEnable = SettingsManager.INSTANCE.getH5AccEnable();
        boolean h5GyroEnable = SettingsManager.INSTANCE.getH5GyroEnable();
        BdTuringConfig config = BdTuring.getInstance().getConfig();
        boolean privacyPolicyAgree = config != null ? config.privacyPolicyAgree() : false;
        this.mStatus.f108cb = h5GyroEnable;
        this.mStatus.f111ve = h5AccEnable;
        this.mStatus.f105a = privacyPolicyAgree;
        double sensorUpdateInterval = SettingsManager.INSTANCE.getSensorUpdateInterval();
        long sensorMaxNum = SettingsManager.INSTANCE.getSensorMaxNum();
        JsonUtils.putValue(this.mStateRecord, "init_config", "h5AccEnable=" + h5AccEnable + ":h5GyroEnable=" + h5GyroEnable + ":privacyPolicyAgree=" + privacyPolicyAgree + ":updateInterval=" + sensorUpdateInterval + ":eventNum=" + sensorMaxNum);
        EventReport.sensorCollectStart(h5AccEnable, h5GyroEnable, privacyPolicyAgree, sensorUpdateInterval, sensorMaxNum);
        if (privacyPolicyAgree) {
            if (sensorUpdateInterval > INTERVAL_MAX) {
                sensorUpdateInterval = 1.0d;
            }
            if (sensorUpdateInterval < INTERVAL_MIN) {
                sensorUpdateInterval = 0.01d;
            }
            int i = (int) (sensorUpdateInterval * 1000.0d);
            if (sensorMaxNum <= 0) {
                sensorMaxNum = 0;
            }
            if (sensorMaxNum > 3000) {
                sensorMaxNum = 3000;
            }
            if (sensorMaxNum == 0) {
                return;
            }
            if (h5AccEnable) {
                AccMonitor accMonitor = new AccMonitor(activity, this.mSensorHandler, i, sensorMaxNum);
                this.mAccMonitor = accMonitor;
                this.mStatus.f109ef = accMonitor.sensorEnable();
                JsonUtils.putValue(this.mStateRecord, "acc_enbale", Boolean.valueOf(this.mStatus.f109ef));
                EventReport.sensorState(0, this.mStatus.f109ef);
            }
            if (h5GyroEnable) {
                GyroMonitor gyroMonitor = new GyroMonitor(activity, this.mSensorHandler, i, sensorMaxNum);
                this.mGyroMonitor = gyroMonitor;
                this.mStatus.f110ka = gyroMonitor.sensorEnable();
                JsonUtils.putValue(this.mStateRecord, "gyro_enbale", Boolean.valueOf(this.mStatus.f110ka));
                EventReport.sensorState(1, this.mStatus.f110ka);
            }
        }
    }

    private void initSensorHandler() {
        try {
            HandlerThread handlerThread = new HandlerThread("bdTuring_sensor");
            this.mSensorThread = handlerThread;
            handlerThread.start();
            this.mSensorHandler = new Handler(this.mSensorThread.getLooper());
        } catch (Exception e) {
            e.printStackTrace();
            JsonUtils.putValue(this.mStateRecord, "init_handler_error", "errorMessage:" + e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public JSONObject getSensorData() {
        Exception exc;
        int i;
        int i2;
        int i3;
        JSONObject jSONObject;
        JSONObject jSONObject2;
        JSONArray jSONArray;
        JSONArray jSONArray2;
        JSONArray jSONArray3;
        Object obj;
        int i4;
        int i5;
        JSONObject jSONObject3;
        JSONObject jSONObject4;
        JSONObject jSONObject5;
        JSONArray jSONArray4;
        int i6;
        JSONObject jSONObject6;
        JSONArray jSONArray5;
        int i7;
        int i8;
        JSONObject jSONObject7;
        Object obj2;
        Object obj3;
        int i9;
        Object obj4;
        JSONArray data;
        JSONArray initialData;
        JSONObject jSONObject8 = new JSONObject();
        int i10 = -1;
        try {
            jSONObject8.put("s", this.mStatus.toJsonObj());
            GyroMonitor gyroMonitor = this.mGyroMonitor;
            if (gyroMonitor != null) {
                jSONObject2 = gyroMonitor.getStateRecord();
                try {
                    data = this.mGyroMonitor.getData();
                    jSONArray = this.mGyroMonitor.getAccuracyData();
                } catch (Exception e) {
                    exc = e;
                    i = -1;
                    i2 = -1;
                    i3 = -1;
                    jSONObject = null;
                    jSONArray = null;
                    jSONArray2 = jSONArray;
                    jSONArray3 = jSONArray2;
                    obj = jSONArray2;
                    exc.printStackTrace();
                    i4 = i;
                    i5 = i10;
                    jSONObject3 = r4;
                    jSONObject4 = jSONObject;
                    jSONObject5 = jSONObject2;
                    jSONArray4 = jSONArray;
                    i6 = i2;
                    jSONObject6 = obj;
                    jSONArray5 = jSONArray3;
                    i7 = i3;
                    EventReport.reportSensorDetail(i5, i6, jSONObject3, i7, i4, jSONObject4, jSONArray4, jSONArray5, this.mStateRecord, jSONObject6, jSONObject5);
                    return jSONObject8;
                }
                try {
                    i8 = data.length();
                    try {
                        jSONObject8.put("ae", data);
                        initialData = this.mGyroMonitor.getInitialData();
                        i2 = initialData.length();
                        if (i2 > 0) {
                            try {
                                jSONObject7 = initialData.getJSONObject(0);
                            } catch (Exception e2) {
                                e = e2;
                                i3 = -1;
                                jSONObject = null;
                                obj3 = null;
                                jSONArray3 = null;
                                i10 = i8;
                                exc = e;
                                i = i3;
                                obj = obj3;
                                exc.printStackTrace();
                                i4 = i;
                                i5 = i10;
                                jSONObject3 = r4;
                                jSONObject4 = jSONObject;
                                jSONObject5 = jSONObject2;
                                jSONArray4 = jSONArray;
                                i6 = i2;
                                jSONObject6 = obj;
                                jSONArray5 = jSONArray3;
                                i7 = i3;
                                EventReport.reportSensorDetail(i5, i6, jSONObject3, i7, i4, jSONObject4, jSONArray4, jSONArray5, this.mStateRecord, jSONObject6, jSONObject5);
                                return jSONObject8;
                            }
                        } else {
                            jSONObject7 = null;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        i2 = -1;
                        i3 = -1;
                    }
                    try {
                        jSONObject8.put("be", initialData);
                    } catch (Exception e4) {
                        e = e4;
                        i3 = -1;
                        jSONObject = null;
                        obj2 = null;
                        jSONArray3 = null;
                        r4 = jSONObject7;
                        obj3 = obj2;
                        i10 = i8;
                        exc = e;
                        i = i3;
                        obj = obj3;
                        exc.printStackTrace();
                        i4 = i;
                        i5 = i10;
                        jSONObject3 = r4;
                        jSONObject4 = jSONObject;
                        jSONObject5 = jSONObject2;
                        jSONArray4 = jSONArray;
                        i6 = i2;
                        jSONObject6 = obj;
                        jSONArray5 = jSONArray3;
                        i7 = i3;
                        EventReport.reportSensorDetail(i5, i6, jSONObject3, i7, i4, jSONObject4, jSONArray4, jSONArray5, this.mStateRecord, jSONObject6, jSONObject5);
                        return jSONObject8;
                    }
                } catch (Exception e5) {
                    exc = e5;
                    i = -1;
                    i2 = -1;
                    i3 = -1;
                    jSONObject = null;
                    jSONArray2 = null;
                    jSONArray3 = jSONArray2;
                    obj = jSONArray2;
                    exc.printStackTrace();
                    i4 = i;
                    i5 = i10;
                    jSONObject3 = r4;
                    jSONObject4 = jSONObject;
                    jSONObject5 = jSONObject2;
                    jSONArray4 = jSONArray;
                    i6 = i2;
                    jSONObject6 = obj;
                    jSONArray5 = jSONArray3;
                    i7 = i3;
                    EventReport.reportSensorDetail(i5, i6, jSONObject3, i7, i4, jSONObject4, jSONArray4, jSONArray5, this.mStateRecord, jSONObject6, jSONObject5);
                    return jSONObject8;
                }
            } else {
                i8 = -1;
                i2 = -1;
                jSONObject2 = null;
                jSONArray = null;
                jSONObject7 = null;
            }
            AccMonitor accMonitor = this.mAccMonitor;
            if (accMonitor != null) {
                Object stateRecord = accMonitor.getStateRecord();
                try {
                    JSONArray data2 = this.mAccMonitor.getData();
                    jSONArray3 = this.mAccMonitor.getAccuracyData();
                    try {
                        i3 = data2.length();
                    } catch (Exception e6) {
                        e = e6;
                        i3 = -1;
                        jSONObject = null;
                        obj2 = stateRecord;
                        r4 = jSONObject7;
                        obj3 = obj2;
                        i10 = i8;
                        exc = e;
                        i = i3;
                        obj = obj3;
                        exc.printStackTrace();
                        i4 = i;
                        i5 = i10;
                        jSONObject3 = r4;
                        jSONObject4 = jSONObject;
                        jSONObject5 = jSONObject2;
                        jSONArray4 = jSONArray;
                        i6 = i2;
                        jSONObject6 = obj;
                        jSONArray5 = jSONArray3;
                        i7 = i3;
                        EventReport.reportSensorDetail(i5, i6, jSONObject3, i7, i4, jSONObject4, jSONArray4, jSONArray5, this.mStateRecord, jSONObject6, jSONObject5);
                        return jSONObject8;
                    }
                    try {
                        jSONObject8.put("qs", data2);
                        JSONArray initialData2 = this.mAccMonitor.getInitialData();
                        i10 = initialData2.length();
                        r4 = i10 > 0 ? initialData2.getJSONObject(0) : null;
                        jSONObject8.put("qa", initialData2);
                        i9 = i10;
                        i10 = i3;
                        obj4 = stateRecord;
                    } catch (Exception e7) {
                        jSONObject = r4;
                        r4 = jSONObject7;
                        int i11 = i8;
                        exc = e7;
                        i = i10;
                        i10 = i11;
                        obj = stateRecord;
                        exc.printStackTrace();
                        i4 = i;
                        i5 = i10;
                        jSONObject3 = r4;
                        jSONObject4 = jSONObject;
                        jSONObject5 = jSONObject2;
                        jSONArray4 = jSONArray;
                        i6 = i2;
                        jSONObject6 = obj;
                        jSONArray5 = jSONArray3;
                        i7 = i3;
                        EventReport.reportSensorDetail(i5, i6, jSONObject3, i7, i4, jSONObject4, jSONArray4, jSONArray5, this.mStateRecord, jSONObject6, jSONObject5);
                        return jSONObject8;
                    }
                } catch (Exception e8) {
                    e = e8;
                    i3 = -1;
                    jSONObject = null;
                    jSONArray3 = null;
                    obj2 = stateRecord;
                }
            } else {
                i9 = -1;
                obj4 = null;
                jSONArray3 = null;
            }
            i4 = i9;
            i7 = i10;
            jSONObject4 = r4;
            jSONObject5 = jSONObject2;
            jSONArray4 = jSONArray;
            i5 = i8;
            i6 = i2;
            jSONObject3 = jSONObject7;
            jSONObject6 = obj4;
            jSONArray5 = jSONArray3;
        } catch (Exception e9) {
            exc = e9;
            i = -1;
            i2 = -1;
            i3 = -1;
            jSONObject = null;
            jSONObject2 = null;
            jSONArray = null;
        }
        EventReport.reportSensorDetail(i5, i6, jSONObject3, i7, i4, jSONObject4, jSONArray4, jSONArray5, this.mStateRecord, jSONObject6, jSONObject5);
        return jSONObject8;
    }

    public void onResume() {
        long currentTimeMillis = System.currentTimeMillis();
        this.mStatus.f107c.add(Long.valueOf(currentTimeMillis));
        GyroMonitor gyroMonitor = this.mGyroMonitor;
        if (gyroMonitor != null) {
            gyroMonitor.onResume();
        }
        AccMonitor accMonitor = this.mAccMonitor;
        if (accMonitor != null) {
            accMonitor.onResume();
        }
        JsonUtils.putValue(this.mStateRecord, "onResume_" + currentTimeMillis, "");
    }

    public void onPause() {
        long currentTimeMillis = System.currentTimeMillis();
        this.mStatus.f106b.add(Long.valueOf(currentTimeMillis));
        GyroMonitor gyroMonitor = this.mGyroMonitor;
        if (gyroMonitor != null) {
            gyroMonitor.onPause();
        }
        AccMonitor accMonitor = this.mAccMonitor;
        if (accMonitor != null) {
            accMonitor.onPause();
        }
        JsonUtils.putValue(this.mStateRecord, "onPause_" + currentTimeMillis, "");
    }

    public void release() {
        try {
            HandlerThread handlerThread = this.mSensorThread;
            if (handlerThread != null) {
                handlerThread.quitSafely();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
