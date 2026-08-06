package com.bytedance.push.client.intelligence;

import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.text.TextUtils;
import com.bytedance.android.service.manager.push.client.intelligence.IClientFeatureService;
import com.bytedance.android.service.manager.push.client.intelligence.IFeatureCallBack;
import com.bytedance.common.interfaze.SensorAbility;
import com.bytedance.common.push.BaseJson;
import com.bytedance.common.push.ThreadPlus;
import com.bytedance.common.support.PushCommonSupport;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.push.PushSupporter;
import com.bytedance.push.settings.client.intelligence.ClientIntelligenceSettingsModel;
import com.bytedance.push.utils.Logger;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class FeatureCollectionHelper extends BaseJson implements SensorEventListener, IClientFeatureService {
    public static final String CLIENT_INTELLIGENCE_TAG = "CLIENT_INTELLIGENCE-";
    private static volatile FeatureCollectionHelper mInstance;
    private boolean mAccelerometerCollectSuccess;
    private JSONObject mAccelerometerInfo;
    private Sensor mAccelerometerSensor;
    private ActivityManager mActivityManager;
    private boolean mAllowCollectClientFeature;
    private List<String> mAllowCollectClientFeatureScene;
    private AudioManager mAudioManager;
    private CountDownLatch mAudioManagerInitCountDownLatch;
    private BatteryManager mBatteryManager;
    private Context mContext;
    private float mDistance;
    private boolean mDistanceCollectSuccess;
    private Sensor mGyroScopeSensor;
    private boolean mGyroscopeCollectSuccess;
    private JSONObject mGyroscopeInfo;
    private Handler mHandler;
    private KeyguardManager mKeyguardManager;
    private long mLastBrightScreenTime;
    private long mLastRestScreenTime;
    private float mLight;
    private boolean mLightCollectSuccess;
    private Sensor mLightSensor;
    private PowerManager mPowerManager;
    private Sensor mProximitySensor;
    private CountDownLatch mPushShowCountDownLatch;
    private CountDownLatch mReportFeatureCountDownLatch;
    private SensorAbility mSensorAbility;
    private SensorManager mSensorManager;
    private final String TAG = "CLIENT_INTELLIGENCE-FeatureCollectionHelper";
    private final int VALUE_UNKNOWN = -1;
    private final float F_VALUE_UNKNOWN = -1.0f;
    private float xAc = -1.0f;
    private float yAc = -1.0f;
    private float zAc = -1.0f;

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public static FeatureCollectionHelper getInstance(Context context) {
        if (mInstance == null) {
            synchronized (FeatureCollectionHelper.class) {
                if (mInstance == null) {
                    mInstance = new FeatureCollectionHelper(context);
                }
            }
        }
        return mInstance;
    }

    private FeatureCollectionHelper(Context context) {
        this.mContext = context;
        ClientIntelligenceSettingsModel clientIntelligenceSettings = PushSupporter.get().getClientIntelligenceService().getClientIntelligenceSettings();
        boolean z = clientIntelligenceSettings.allowCollectClientFeature;
        this.mAllowCollectClientFeature = z;
        if (z) {
            List<String> list = clientIntelligenceSettings.allowFeatureCollectScene;
            this.mAllowCollectClientFeatureScene = list;
            if (list.isEmpty()) {
                return;
            }
            this.mSensorAbility = PushCommonSupport.getInstance().getPushConfigurationService().getPushCommonConfiguration().mIPushCommonConfiguration.getSensorAbility();
            this.mHandler = new Handler(Looper.getMainLooper());
            this.mGyroscopeInfo = new JSONObject();
            this.mAccelerometerInfo = new JSONObject();
            this.mSensorManager = (SensorManager) this.mContext.getSystemService("sensor");
            this.mBatteryManager = (BatteryManager) this.mContext.getSystemService("batterymanager");
            this.mAudioManagerInitCountDownLatch = new CountDownLatch(1);
            this.mHandler.post(new Runnable() { // from class: com.bytedance.push.client.intelligence.FeatureCollectionHelper.1
                @Override // java.lang.Runnable
                public void run() {
                    FeatureCollectionHelper featureCollectionHelper = FeatureCollectionHelper.this;
                    featureCollectionHelper.mAudioManager = (AudioManager) featureCollectionHelper.mContext.getSystemService("audio");
                    FeatureCollectionHelper.this.mAudioManagerInitCountDownLatch.countDown();
                }
            });
            this.mPowerManager = (PowerManager) this.mContext.getSystemService("power");
            this.mKeyguardManager = (KeyguardManager) this.mContext.getSystemService("keyguard");
            this.mActivityManager = (ActivityManager) this.mContext.getSystemService("activity");
            if (isScreenOn()) {
                this.mLastBrightScreenTime = System.currentTimeMillis();
            } else {
                this.mLastRestScreenTime = System.currentTimeMillis();
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            PushCommonSupport.getInstance().getIPushCommonConfiguration().registerReceiver(this.mContext, new ScreenReceiver(), intentFilter);
        }
    }

    public void setAllowCollectClientFeature(boolean z) {
        this.mAllowCollectClientFeature = z;
    }

    private void initSensor() {
        this.mGyroscopeCollectSuccess = false;
        this.mGyroscopeInfo = new JSONObject();
        Sensor defaultSensor = this.mSensorAbility.getDefaultSensor(this.mSensorManager, 4);
        this.mGyroScopeSensor = defaultSensor;
        this.mSensorAbility.registerListener(this.mSensorManager, this, defaultSensor, 0);
        this.mLightCollectSuccess = false;
        this.mLight = -1.0f;
        Sensor defaultSensor2 = this.mSensorAbility.getDefaultSensor(this.mSensorManager, 5);
        this.mLightSensor = defaultSensor2;
        this.mSensorAbility.registerListener(this.mSensorManager, this, defaultSensor2, 0);
        initPushShowFeatureSensor();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initPushShowFeatureSensor() {
        this.mAccelerometerCollectSuccess = false;
        this.mAccelerometerInfo = new JSONObject();
        this.xAc = -1.0f;
        this.yAc = -1.0f;
        this.zAc = -1.0f;
        Sensor defaultSensor = this.mSensorAbility.getDefaultSensor(this.mSensorManager, 1);
        this.mAccelerometerSensor = defaultSensor;
        this.mSensorAbility.registerListener(this.mSensorManager, this, defaultSensor, 0);
        this.mDistanceCollectSuccess = false;
        this.mDistance = -1.0f;
        Sensor defaultSensor2 = this.mSensorAbility.getDefaultSensor(this.mSensorManager, 8);
        this.mProximitySensor = defaultSensor2;
        this.mSensorAbility.registerListener(this.mSensorManager, this, defaultSensor2, 0);
    }

    public synchronized void getFeatureForLocalPush(ILocalPushClientFeatureCallback iLocalPushClientFeatureCallback) {
        boolean z = PushSupporter.get().getClientIntelligenceService().getClientIntelligenceSettings().localPushClientIntelligenceSettingsModel.enableClientIntelligenceLocalPush;
        Logger.m268d("CLIENT_INTELLIGENCE-FeatureCollectionHelper", "[getFeatureForLocalPush] allowCollectClientFeature is " + this.mAllowCollectClientFeature + " enableClientIntelligenceLocalPush is " + z);
        if (this.mAllowCollectClientFeature && z) {
            if (this.mAudioManagerInitCountDownLatch.getCount() > 0) {
                try {
                    this.mAudioManagerInitCountDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            iLocalPushClientFeatureCallback.onFeatureCallback(isUsingEarPhone(this.mAudioManager), isScreenOn(), isMusicActive());
            return;
        }
        Logger.m278w("CLIENT_INTELLIGENCE-FeatureCollectionHelper", "getFeatureForLocalPush callback null because settings is not enable");
        iLocalPushClientFeatureCallback.onNullFeatureCallback();
    }

    public synchronized void getFeatureForPushShow(final IPushShowClientFeatureCallback iPushShowClientFeatureCallback) {
        boolean z = PushSupporter.get().getClientIntelligenceService().getClientIntelligenceSettings().enableClientIntelligencePushShow;
        Logger.m268d("CLIENT_INTELLIGENCE-FeatureCollectionHelper", "[getFeatureForPushShow] allowCollectClientFeature is " + this.mAllowCollectClientFeature + " enableClientIntelligencePushShow is " + z);
        if (this.mAllowCollectClientFeature && z) {
            ThreadPlus.submitRunnable(new Runnable() { // from class: com.bytedance.push.client.intelligence.FeatureCollectionHelper.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        boolean z2 = true;
                        FeatureCollectionHelper.this.mPushShowCountDownLatch = new CountDownLatch(1);
                        FeatureCollectionHelper.this.initPushShowFeatureSensor();
                        boolean await = FeatureCollectionHelper.this.mPushShowCountDownLatch.await(PushSupporter.get().getClientIntelligenceService().getClientIntelligenceSettings().featureCollectTimeOutInMill, TimeUnit.MILLISECONDS);
                        StringBuilder sb = new StringBuilder("finish getFeatureForPushShow, awaitTimeout is ");
                        if (await) {
                            z2 = false;
                        }
                        Logger.m268d("CLIENT_INTELLIGENCE-FeatureCollectionHelper", sb.append(z2).toString());
                        iPushShowClientFeatureCallback.onFeatureCallback(FeatureCollectionHelper.this.isMusicActive(), FeatureCollectionHelper.this.mDistanceCollectSuccess, FeatureCollectionHelper.this.mDistance, FeatureCollectionHelper.this.mAccelerometerCollectSuccess, FeatureCollectionHelper.this.xAc, FeatureCollectionHelper.this.yAc, FeatureCollectionHelper.this.zAc);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        Logger.m272e("CLIENT_INTELLIGENCE-FeatureCollectionHelper", "getFeatureForPushShow callback null because InterruptedException: ", e);
                        iPushShowClientFeatureCallback.onNullFeatureCallback();
                    }
                }
            });
            return;
        }
        Logger.m278w("CLIENT_INTELLIGENCE-FeatureCollectionHelper", "getFeatureForPushShow callback null because settings is not enable");
        iPushShowClientFeatureCallback.onNullFeatureCallback();
    }

    public void getClientFeatureAsync(final IFeatureCallBack iFeatureCallBack, final String str) {
        ThreadPlus.submitRunnable(new Runnable() { // from class: com.bytedance.push.client.intelligence.FeatureCollectionHelper.3
            @Override // java.lang.Runnable
            public void run() {
                iFeatureCallBack.onFeatureCallBack(FeatureCollectionHelper.this.getClientFeatureSync(str));
            }
        });
    }

    public JSONObject getClientFeatureSync(String str) {
        Logger.m268d("CLIENT_INTELLIGENCE-FeatureCollectionHelper", "[getClientFeatureSync] allowCollectClientFeature is " + this.mAllowCollectClientFeature + " invokeScene is " + str);
        if (!this.mAllowCollectClientFeature) {
            return null;
        }
        if (!this.mAllowCollectClientFeatureScene.contains(str)) {
            Logger.m268d("CLIENT_INTELLIGENCE-FeatureCollectionHelper", "[getClientFeatureSync] return null because mAllowCollectClientFeatureScene not contains " + str);
            return null;
        }
        boolean z = true;
        this.mReportFeatureCountDownLatch = new CountDownLatch(1);
        initSensor();
        try {
            boolean await = this.mReportFeatureCountDownLatch.await(PushSupporter.get().getClientIntelligenceService().getClientIntelligenceSettings().featureCollectTimeOutInMill, TimeUnit.MILLISECONDS);
            StringBuilder sb = new StringBuilder("finish getClientFeatureSync, awaitTimeout is ");
            if (await) {
                z = false;
            }
            Logger.m268d("CLIENT_INTELLIGENCE-FeatureCollectionHelper", sb.append(z).toString());
            JSONObject jSONObject = new JSONObject();
            add(jSONObject, "client_time", System.currentTimeMillis());
            add(jSONObject, FeatureConnectionConstant.VOICE, getAudioFeature());
            add(jSONObject, FeatureConnectionConstant.IS_USING_EAR_PHONE, isUsingEarPhone(this.mAudioManager));
            add(jSONObject, FeatureConnectionConstant.IS_MUSIC_ACTIVE, isMusicActive());
            add(jSONObject, FeatureConnectionConstant.CUR_BATTERY_CAPACITY, getBatteryCapacity());
            add(jSONObject, FeatureConnectionConstant.CUR_BATTERY_STATUS, getBatteryStatus());
            add(jSONObject, FeatureConnectionConstant.IS_SCREEN_ON, isScreenOn());
            add(jSONObject, FeatureConnectionConstant.LAST_SCREEN_ON_TIME, this.mLastBrightScreenTime);
            add(jSONObject, FeatureConnectionConstant.LAST_SCREEN_OFF_TIME, this.mLastRestScreenTime);
            add(jSONObject, FeatureConnectionConstant.IS_LOCK_SCREEN, isLockScreen());
            add(jSONObject, FeatureConnectionConstant.NETWORK_TYPE, getNetWorkType());
            add(jSONObject, FeatureConnectionConstant.GYROSCOPE_INFO, this.mGyroscopeInfo);
            add(jSONObject, FeatureConnectionConstant.ACCELEROMETER_INFO, this.mAccelerometerInfo);
            add(jSONObject, FeatureConnectionConstant.LIGNT, this.mLight);
            add(jSONObject, FeatureConnectionConstant.DISTANCE, this.mDistance);
            return jSONObject;
        } catch (InterruptedException e) {
            Logger.m272e("CLIENT_INTELLIGENCE-FeatureCollectionHelper", "error when await mReportFeatureCountDownLatch:", e);
            return null;
        }
    }

    public synchronized void getFeatureForEventReport(IFeatureCallBack iFeatureCallBack, String str) {
        boolean z = PushSupporter.get().getClientIntelligenceService().getClientIntelligenceSettings().enableClientFeatureReport;
        Logger.m268d("CLIENT_INTELLIGENCE-FeatureCollectionHelper", "[getFeatureForEventReport] enableClientFeatureReport is " + z);
        if (!z) {
            iFeatureCallBack.onFeatureCallBack((JSONObject) null);
        } else {
            getClientFeatureAsync(iFeatureCallBack, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isMusicActive() {
        AudioManager audioManager = this.mAudioManager;
        return audioManager != null && audioManager.isMusicActive();
    }

    private int getNetWorkType() {
        NetworkUtils.NetworkType networkType = NetworkUtils.getNetworkType(this.mContext);
        if (!networkType.isAvailable()) {
            return 0;
        }
        if (networkType.is4GOrHigher()) {
            return 4;
        }
        if (networkType.is3GOrHigher()) {
            return 3;
        }
        if (networkType.is2G()) {
            return 2;
        }
        return networkType.isWifi() ? 1 : -1;
    }

    private boolean isScreenOn() {
        return this.mPowerManager.isScreenOn();
    }

    private boolean isLockScreen() {
        return this.mKeyguardManager.inKeyguardRestrictedInputMode();
    }

    private JSONObject getAudioFeature() {
        JSONObject jSONObject = new JSONObject();
        if (this.mAudioManager == null) {
            return jSONObject;
        }
        add(jSONObject, FeatureConnectionConstant.CUR_CALL_VOICE, r1.getStreamVolume(0));
        add(jSONObject, FeatureConnectionConstant.MAX_CALL_VOICE, this.mAudioManager.getStreamMaxVolume(0));
        add(jSONObject, FeatureConnectionConstant.CUR_SYSTEM_VOICE, this.mAudioManager.getStreamVolume(1));
        add(jSONObject, FeatureConnectionConstant.MAX_SYSTEM_VOICE, this.mAudioManager.getStreamMaxVolume(1));
        add(jSONObject, FeatureConnectionConstant.CUR_RING_VOICE, this.mAudioManager.getStreamVolume(2));
        add(jSONObject, FeatureConnectionConstant.MAX_RING_VOICE, this.mAudioManager.getStreamMaxVolume(2));
        add(jSONObject, FeatureConnectionConstant.CUR_MUSIC_VOICE, this.mAudioManager.getStreamVolume(3));
        add(jSONObject, FeatureConnectionConstant.MAX_MUSIC_VOICE, this.mAudioManager.getStreamMaxVolume(3));
        add(jSONObject, FeatureConnectionConstant.CUR_ALARM_VOICE, this.mAudioManager.getStreamVolume(4));
        add(jSONObject, FeatureConnectionConstant.MAX_ALARM_VOICE, this.mAudioManager.getStreamMaxVolume(4));
        return jSONObject;
    }

    private boolean isUsingEarPhone(AudioManager audioManager) {
        int profileConnectionState;
        int profileConnectionState2;
        int profileConnectionState3;
        if (audioManager.isWiredHeadsetOn()) {
            return true;
        }
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter == null || !defaultAdapter.isEnabled()) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 34 || this.mContext.checkSelfPermission("android.permission.BLUETOOTH_CONNECT") == 0) {
            profileConnectionState = defaultAdapter.getProfileConnectionState(2);
            profileConnectionState2 = defaultAdapter.getProfileConnectionState(1);
            profileConnectionState3 = defaultAdapter.getProfileConnectionState(3);
        } else {
            profileConnectionState3 = 0;
            profileConnectionState = 0;
            profileConnectionState2 = 0;
        }
        if (profileConnectionState == 2) {
            profileConnectionState3 = profileConnectionState;
        } else if (profileConnectionState2 == 2) {
            profileConnectionState3 = profileConnectionState2;
        } else if (profileConnectionState3 != 2) {
            profileConnectionState3 = -1;
        }
        return profileConnectionState3 != -1;
    }

    private int getBatteryCapacity() {
        if (this.mBatteryManager != null) {
            return this.mBatteryManager.getIntProperty(4);
        }
        return -1;
    }

    private int getBatteryStatus() {
        if (this.mBatteryManager == null || Build.VERSION.SDK_INT < 26) {
            return -1;
        }
        return this.mBatteryManager.getIntProperty(6);
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (!this.mGyroscopeCollectSuccess && sensorEvent.sensor.getType() == 4) {
            add(this.mGyroscopeInfo, "xGy", sensorEvent.values[0]);
            add(this.mGyroscopeInfo, "yGy", sensorEvent.values[1]);
            add(this.mGyroscopeInfo, "zGy", sensorEvent.values[2]);
            Logger.m268d("CLIENT_INTELLIGENCE-FeatureCollectionHelper", "陀螺仪传感器更新：" + this.mGyroscopeInfo.toString());
            ThreadPlus.runOnChildThread(new Runnable() { // from class: com.bytedance.push.client.intelligence.FeatureCollectionHelper.4
                @Override // java.lang.Runnable
                public void run() {
                    SensorAbility sensorAbility = FeatureCollectionHelper.this.mSensorAbility;
                    SensorManager sensorManager = FeatureCollectionHelper.this.mSensorManager;
                    FeatureCollectionHelper featureCollectionHelper = FeatureCollectionHelper.this;
                    sensorAbility.unregisterListener(sensorManager, featureCollectionHelper, featureCollectionHelper.mGyroScopeSensor);
                }
            });
            this.mGyroscopeCollectSuccess = true;
        } else if (!this.mAccelerometerCollectSuccess && sensorEvent.sensor.getType() == 1) {
            this.xAc = sensorEvent.values[0];
            this.yAc = sensorEvent.values[1];
            this.zAc = sensorEvent.values[2];
            add(this.mAccelerometerInfo, "xAc", this.xAc);
            add(this.mAccelerometerInfo, "yAc", this.yAc);
            add(this.mAccelerometerInfo, "zAc", this.zAc);
            Logger.m268d("CLIENT_INTELLIGENCE-FeatureCollectionHelper", "加速度传感器更新：" + this.mAccelerometerInfo.toString());
            ThreadPlus.runOnChildThread(new Runnable() { // from class: com.bytedance.push.client.intelligence.FeatureCollectionHelper.5
                @Override // java.lang.Runnable
                public void run() {
                    SensorAbility sensorAbility = FeatureCollectionHelper.this.mSensorAbility;
                    SensorManager sensorManager = FeatureCollectionHelper.this.mSensorManager;
                    FeatureCollectionHelper featureCollectionHelper = FeatureCollectionHelper.this;
                    sensorAbility.unregisterListener(sensorManager, featureCollectionHelper, featureCollectionHelper.mAccelerometerSensor);
                }
            });
            this.mAccelerometerCollectSuccess = true;
        } else if (!this.mLightCollectSuccess && sensorEvent.sensor.getType() == 5) {
            this.mLight = sensorEvent.values[0];
            Logger.m268d("CLIENT_INTELLIGENCE-FeatureCollectionHelper", "光线传感器更新：" + this.mLight);
            ThreadPlus.runOnChildThread(new Runnable() { // from class: com.bytedance.push.client.intelligence.FeatureCollectionHelper.6
                @Override // java.lang.Runnable
                public void run() {
                    SensorAbility sensorAbility = FeatureCollectionHelper.this.mSensorAbility;
                    SensorManager sensorManager = FeatureCollectionHelper.this.mSensorManager;
                    FeatureCollectionHelper featureCollectionHelper = FeatureCollectionHelper.this;
                    sensorAbility.unregisterListener(sensorManager, featureCollectionHelper, featureCollectionHelper.mLightSensor);
                }
            });
            this.mLightCollectSuccess = true;
        } else if (!this.mDistanceCollectSuccess && sensorEvent.sensor.getType() == 8) {
            this.mDistance = sensorEvent.values[0];
            Logger.m268d("CLIENT_INTELLIGENCE-FeatureCollectionHelper", "距离传感器更新：" + this.mDistance);
            ThreadPlus.runOnChildThread(new Runnable() { // from class: com.bytedance.push.client.intelligence.FeatureCollectionHelper.7
                @Override // java.lang.Runnable
                public void run() {
                    SensorAbility sensorAbility = FeatureCollectionHelper.this.mSensorAbility;
                    SensorManager sensorManager = FeatureCollectionHelper.this.mSensorManager;
                    FeatureCollectionHelper featureCollectionHelper = FeatureCollectionHelper.this;
                    sensorAbility.unregisterListener(sensorManager, featureCollectionHelper, featureCollectionHelper.mProximitySensor);
                }
            });
            this.mDistanceCollectSuccess = true;
        }
        if (this.mAccelerometerCollectSuccess && this.mDistanceCollectSuccess) {
            if (this.mPushShowCountDownLatch != null) {
                Logger.m268d("CLIENT_INTELLIGENCE-FeatureCollectionHelper", "finish get push show feature,invoke mPushShowCountDownLatch.countDown()");
                this.mPushShowCountDownLatch.countDown();
            }
            if (this.mGyroscopeCollectSuccess && this.mLightCollectSuccess && this.mReportFeatureCountDownLatch != null) {
                Logger.m268d("CLIENT_INTELLIGENCE-FeatureCollectionHelper", "finish get report feature,invoke mReportFeatureCountDownLatch.countDown()");
                this.mReportFeatureCountDownLatch.countDown();
            }
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    private class ScreenReceiver extends BroadcastReceiver {
        private ScreenReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (TextUtils.equals("android.intent.action.SCREEN_ON", action)) {
                Logger.m268d("CLIENT_INTELLIGENCE-FeatureCollectionHelper", "监听到亮屏");
                FeatureCollectionHelper.this.mLastBrightScreenTime = System.currentTimeMillis();
            } else if (TextUtils.equals("android.intent.action.SCREEN_OFF", action)) {
                Logger.m268d("CLIENT_INTELLIGENCE-FeatureCollectionHelper", "监听到息屏");
                FeatureCollectionHelper.this.mLastRestScreenTime = System.currentTimeMillis();
            }
        }
    }
}
