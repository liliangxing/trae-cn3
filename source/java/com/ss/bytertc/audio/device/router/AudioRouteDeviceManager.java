package com.ss.bytertc.audio.device.router;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothClass;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.usb.UsbConfiguration;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbInterface;
import android.hardware.usb.UsbManager;
import android.media.AudioDeviceCallback;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import androidx.core.content.ContextCompat;
import com.bytedance.realx.base.RXLogging;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.ss.ttm.player.MediaFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class AudioRouteDeviceManager extends BroadcastReceiver {
    private static final String ACTION_BT_A2DP_CONNECTION_STATE_CHANGED = "android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED";
    private static final String ACTION_BT_HEADSET_CONNECTION_STATE_CHANGED = "android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED";
    private static final String ACTION_BT_SCO_AUDIO_STATE_UPDATED = "android.media.ACTION_SCO_AUDIO_STATE_UPDATED";
    private static final String ACTION_BT_STATE_CHANGED = "android.bluetooth.adapter.action.STATE_CHANGED";
    private static final String ACTION_HEADSET_PLUG = "android.intent.action.HEADSET_PLUG";
    private static final String ACTION_USB_DEVICE_ATTACHED = "android.hardware.usb.action.USB_DEVICE_ATTACHED";
    private static final String ACTION_USB_DEVICE_DETACHED = "android.hardware.usb.action.USB_DEVICE_DETACHED";
    private static final int BLUETOOTH_SCO_CONNECT_CHECK_MAX_RETRY_TIMES = 3;
    private static final int BLUETOOTH_SCO_CONNECT_CHECK_TIME_GAP = 3000;
    private static final int BLUETOOTH_SCO_DISCONNECT_CHECK_TIME_GAP = 6000;
    private static final int BLUETOOTH_SCO_RESTART_MAX_TIMES = 3;
    private static final int BLUETOOTH_SCO_RESTART_TIME_GAP = 3000;
    private static final String TAG = "AudioRouteDeviceManager";
    private BluetoothAdapter mBluetoothAdapter;
    private MyBluetoothDevice mBluetoothDevice;
    private AudioDeviceCallback mBluetoothDeviceCallback;
    private IAudioRouteCallback mCallback;
    private Handler mHandler;
    private HandlerThread mHandlerThread;
    private IntentFilter mIntentFilter;
    private UsbDevice mUsbHeadsetDevice;
    private String mWiredHeadsetDevice;
    private volatile boolean registered = false;
    private boolean mAudioRouteEnable = true;
    private int mInitDeviceState = 0;
    private int mBluetoothScoConnectCheckTimes = -1;
    private int mBluetoothScoRestartTimes = 0;
    private boolean mScoHasStarted = false;
    private final Runnable bluetoothScoConnectionCheckRunnable = new Runnable() { // from class: com.ss.bytertc.audio.device.router.AudioRouteDeviceManager$$ExternalSyntheticLambda0
        @Override // java.lang.Runnable
        public final void run() {
            AudioRouteDeviceManager.this.bluetoothScoConnectionCheck();
        }
    };
    private String mBluetoothPermissionDesp = "NULL";
    private int currentRouting = -1;
    private boolean mEnableUseAudioDeviceCallback = false;
    private boolean mUseAudioDeviceCallback = false;
    private final Object bluetoothLock = new Object();

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public @interface RoutingDeviceType {
        public static final int BLUETOOTH_A2DP = 16;
        public static final int BLUETOOTH_HEADSET = 8;
        public static final int BLUETOOTH_SCO = 64;
        public static final int BUILT_IN_EARPIECE = 1;
        public static final int BUILT_IN_SPEAKER = 2;
        public static final int UNKNOWN = -1;
        public static final int USB_HEADSET = 32;
        public static final int WIRED_HEADSET = 4;
    }

    private String routingDeviceType2Text(int deviceType) {
        return deviceType != -1 ? deviceType != 4 ? deviceType != 8 ? deviceType != 16 ? deviceType != 32 ? deviceType != 64 ? deviceType != 1 ? deviceType != 2 ? "device-NA" : "device-speaker" : "device-earpiece" : "device-bt-sco" : "device-usb-headset" : "device-bt-a2dp" : "device-bt-headset" : "device-wired-headset" : "device-unknown";
    }

    public AudioRouteDeviceManager(IAudioRouteCallback callback) {
        this.mCallback = callback;
    }

    private boolean checkPermission() {
        Context context = AudioRouteUtil.getContext();
        if (context == null) {
            return false;
        }
        int i = Build.VERSION.SDK_INT;
        int i2 = context.getApplicationInfo().targetSdkVersion;
        if (i2 >= 23) {
            this.mUseAudioDeviceCallback = this.mEnableUseAudioDeviceCallback;
            RXLogging.w(TAG, "AudioRouteDeviceManager: mUseAudioDeviceCallback: " + this.mUseAudioDeviceCallback);
        }
        if (i >= 31 && i2 >= 31) {
            if (context.checkCallingOrSelfPermission("android.permission.BLUETOOTH_CONNECT") != 0) {
                this.mBluetoothPermissionDesp = "[permission android.permission.BLUETOOTH_CONNECT not be granted. osVersion:" + i + ", targetVersion:" + i2 + " ]";
                RXLogging.e(TAG, "AudioRouteDeviceManager: " + this.mBluetoothPermissionDesp);
                return false;
            }
            this.mBluetoothPermissionDesp = "[permission android.permission.BLUETOOTH_CONNECT granted. osVersion:" + i + ", targetVersion:" + i2 + " ]";
            RXLogging.w(TAG, "AudioRouteDeviceManager: " + this.mBluetoothPermissionDesp);
            return true;
        }
        if (context.checkCallingOrSelfPermission("android.permission.BLUETOOTH") != 0) {
            String str = "[permission android.permission.BLUETOOTH not be granted. osVersion:" + i + ", targetVersion:" + i2 + " ]";
            this.mBluetoothPermissionDesp = str;
            RXLogging.e(TAG, str);
            Log.e(TAG, TAG + this.mBluetoothPermissionDesp);
            return false;
        }
        this.mBluetoothPermissionDesp = "[permission android.permission.BLUETOOTH granted. osVersion:" + i + ", targetVersion:" + i2 + " ]";
        RXLogging.w(TAG, "AudioRouteDeviceManager: " + this.mBluetoothPermissionDesp);
        return true;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:(2:54|55)|(2:57|(8:59|60|61|(1:63)(1:69)|64|65|(1:67)|68))|75|60|61|(0)(0)|64|65|(0)|68) */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x009a, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x009b, code lost:
    
        r5 = r1;
        r1 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00a1, code lost:
    
        com.bytedance.realx.base.RXLogging.e(com.ss.bytertc.audio.device.router.AudioRouteDeviceManager.TAG, "AudioRouteDeviceManager: getProfileConnectionState failed.", r1);
        r8 = false;
        r7 = r5;
     */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00e8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0096  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void initBluetooth() {
        boolean z;
        boolean z2;
        boolean z3;
        String[] strArr = {""};
        synchronized (this.bluetoothLock) {
            this.mBluetoothDevice = null;
        }
        if (!checkPermission()) {
            if (this.mUseAudioDeviceCallback) {
                Context context = AudioRouteUtil.getContext();
                if (context == null) {
                    Log.e(TAG, "AudioRouteDeviceManager: initBluetooth without permission failed. Context is null.");
                    return;
                }
                AudioManager audioManager = (AudioManager) context.getSystemService(MediaFormat.KEY_AUDIO);
                if (audioManager == null) {
                    Log.e(TAG, "AudioRouteDeviceManager: initBluetooth without permission failed. AudioManager is null.");
                    return;
                }
                Log.w(TAG, "initBluetooth() with no bluetooth-connect permision.");
                z2 = false;
                z = false;
                for (AudioDeviceInfo audioDeviceInfo : audioManager.getDevices(2)) {
                    if (!audioDeviceInfo.isSource()) {
                        if (7 == audioDeviceInfo.getType()) {
                            z2 = true;
                        } else if (8 == audioDeviceInfo.getType()) {
                            z = true;
                        }
                    }
                }
            } else {
                z2 = false;
                z = false;
            }
        } else {
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            this.mBluetoothAdapter = defaultAdapter;
            if (defaultAdapter == null) {
                Log.e(TAG, "AudioRouteDeviceManager: initBluetooth with permission failed. GetDefaultAdapter is null");
                return;
            }
            try {
            } catch (Throwable th) {
                th = th;
                boolean z4 = false;
            }
            if (2 == defaultAdapter.getProfileConnectionState(1)) {
                if (hasValidBtDeviceMajor(1, strArr)) {
                    z3 = true;
                    z2 = z3;
                    z = 2 != this.mBluetoothAdapter.getProfileConnectionState(2);
                    Log.w(TAG, "AudioRouteDeviceManager: initBluetooth() with bluetooth-connect broadcast. headset_connected:" + z2 + " a2dp_connected:" + z);
                    if (!this.mUseAudioDeviceCallback) {
                        this.mIntentFilter.addAction(ACTION_BT_HEADSET_CONNECTION_STATE_CHANGED);
                        this.mIntentFilter.addAction(ACTION_BT_A2DP_CONNECTION_STATE_CHANGED);
                    }
                    this.mIntentFilter.addAction(ACTION_BT_SCO_AUDIO_STATE_UPDATED);
                }
            }
            z3 = false;
            z2 = z3;
            z = 2 != this.mBluetoothAdapter.getProfileConnectionState(2);
            Log.w(TAG, "AudioRouteDeviceManager: initBluetooth() with bluetooth-connect broadcast. headset_connected:" + z2 + " a2dp_connected:" + z);
            if (!this.mUseAudioDeviceCallback) {
            }
            this.mIntentFilter.addAction(ACTION_BT_SCO_AUDIO_STATE_UPDATED);
        }
        if (!z2 || z) {
            synchronized (this.bluetoothLock) {
                MyBluetoothDevice myBluetoothDevice = new MyBluetoothDevice("bluetooth-headset[init]");
                this.mBluetoothDevice = myBluetoothDevice;
                myBluetoothDevice.appendDeviceInfo("init", strArr[0]);
                this.mBluetoothDevice.setBluetoothConnected(1, z2);
                this.mBluetoothDevice.setBluetoothConnected(2, z);
            }
        }
    }

    private boolean hasValidBtDeviceMajor(int profile, final String[] headset_extra_infos) {
        final Context context;
        if (this.mBluetoothAdapter == null || (context = AudioRouteUtil.getContext()) == null) {
            return false;
        }
        final Object obj = new Object();
        final boolean[] zArr = {true};
        if (profile == 1) {
            try {
                this.mBluetoothAdapter.getProfileProxy(context, new BluetoothProfile.ServiceListener() { // from class: com.ss.bytertc.audio.device.router.AudioRouteDeviceManager.1
                    @Override // android.bluetooth.BluetoothProfile.ServiceListener
                    public void onServiceDisconnected(int profile2) {
                    }

                    @Override // android.bluetooth.BluetoothProfile.ServiceListener
                    public void onServiceConnected(int profile2, BluetoothProfile proxy) {
                        boolean z;
                        Log.i(AudioRouteDeviceManager.TAG, "onServiceConnected");
                        List<BluetoothDevice> connectedDevices = proxy.getConnectedDevices();
                        if (connectedDevices != null && !connectedDevices.isEmpty()) {
                            Iterator<BluetoothDevice> it = connectedDevices.iterator();
                            z = false;
                            while (it.hasNext()) {
                                if (AudioRouteDeviceManager.this.isBtDeviceMajorValid(context, profile2, it.next(), headset_extra_infos)) {
                                    z = true;
                                }
                            }
                        } else {
                            Log.w(AudioRouteDeviceManager.TAG, "proxy.getConnectedDevices is null");
                            z = false;
                        }
                        if (!z) {
                            zArr[0] = false;
                        }
                        synchronized (obj) {
                            obj.notify();
                        }
                    }
                }, profile);
                synchronized (obj) {
                    obj.wait(300);
                }
            } catch (Throwable th) {
                RXLogging.e(TAG, "AudioRouteDeviceManager: hasValidBtDeviceMajor failed.", th);
            }
        }
        return zArr[0];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isBtDeviceMajorValid(Context context, int profile, BluetoothDevice device, String[] infos) {
        if (context == null || device == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 31 || context.getApplicationInfo().targetSdkVersion < 31 ? context.checkCallingOrSelfPermission("android.permission.BLUETOOTH") == 0 : context.checkCallingOrSelfPermission("android.permission.BLUETOOTH_CONNECT") == 0) {
            try {
                String name = device.getName();
                BluetoothClass bluetoothClass = device.getBluetoothClass();
                if (bluetoothClass == null) {
                    return false;
                }
                int majorDeviceClass = bluetoothClass.getMajorDeviceClass();
                Log.w(TAG, "check bluetooth device major, profile:" + profile + ", name:" + name + ", major class:" + majorDeviceClass);
                infos[0] = infos[0] + "[device:" + name + ", majorClass:" + majorDeviceClass + "] ";
                if (profile == 1) {
                    return (majorDeviceClass == 1792 || majorDeviceClass == 7936) ? false : true;
                }
            } catch (Throwable th) {
                RXLogging.e(TAG, "AudioRouteDeviceManager: isBtDeviceMajorValid failed.", th);
            }
        }
        return true;
    }

    private boolean hasAudioForUsbDevice(UsbDevice device) {
        if (device == null) {
            return false;
        }
        for (int i = 0; i < device.getConfigurationCount(); i++) {
            UsbConfiguration configuration = device.getConfiguration(i);
            if (configuration != null) {
                for (int i2 = 0; i2 < configuration.getInterfaceCount(); i2++) {
                    UsbInterface usbInterface = configuration.getInterface(i2);
                    if (usbInterface != null && usbInterface.getInterfaceClass() == 1) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean initUsbHeadset() {
        Context context;
        UsbManager usbManager;
        try {
            context = AudioRouteUtil.getContext();
        } catch (Throwable th) {
            RXLogging.e(TAG, "AudioRouteDeviceManager: initUsbHeadset failed.", th);
        }
        if (context == null || (usbManager = (UsbManager) context.getSystemService("usb")) == null) {
            return false;
        }
        HashMap<String, UsbDevice> deviceList = usbManager.getDeviceList();
        Iterator<String> it = deviceList.keySet().iterator();
        while (it.hasNext()) {
            UsbDevice usbDevice = deviceList.get(it.next());
            if (hasAudioForUsbDevice(usbDevice)) {
                this.mUsbHeadsetDevice = usbDevice;
                RXLogging.e(TAG, "AudioRouteDeviceManager: initUsbHeadset finished.");
                return true;
            }
        }
        return false;
    }

    private boolean initHeadset() {
        Intent intent;
        Context context = AudioRouteUtil.getContext();
        if (context == null) {
            return false;
        }
        try {
            intent = m172xbaca1e0d(context, this, new IntentFilter(ACTION_HEADSET_PLUG));
        } catch (Exception e) {
            RXLogging.e(TAG, "AudioRouteDeviceManager: registerReceiver failed for ACTION_HEADSET_PLUG", e);
            intent = null;
        }
        return (intent == null || headsetPlugActionIsFromUsbHeadset(intent) || 1 != intent.getIntExtra("state", -99)) ? false : true;
    }

    private void initHandler() {
        Looper looper;
        try {
            HandlerThread handlerThread = this.mHandlerThread;
            if (handlerThread != null) {
                handlerThread.quit();
            }
            HandlerThread handlerThread2 = new HandlerThread("AudioRouteDeviceManagerThread");
            this.mHandlerThread = handlerThread2;
            handlerThread2.start();
            looper = this.mHandlerThread.getLooper();
        } catch (Exception e) {
            RXLogging.e(TAG, "AudioRouteDeviceManager: AudioRouteDeviceManagerThread init failed, ", e);
            HandlerThread handlerThread3 = this.mHandlerThread;
            if (handlerThread3 != null) {
                handlerThread3.quit();
                this.mHandlerThread = null;
            }
            looper = null;
        }
        if (looper != null || (looper = Looper.getMainLooper()) != null) {
            Handler handler = new Handler(looper);
            this.mHandler = handler;
            handler.removeCallbacks(this.bluetoothScoConnectionCheckRunnable);
            RXLogging.e(TAG, "AudioRouteDeviceManager: initHandler success");
            return;
        }
        RXLogging.e(TAG, "AudioRouteDeviceManager: initHandler failed");
    }

    public int getDeviceState() {
        return this.mInitDeviceState;
    }

    public void setUseAudioDeviceCallback(boolean enableSkipPermission, IAudioRouteCallback callback) {
        this.mEnableUseAudioDeviceCallback = enableSkipPermission;
        this.mCallback = callback;
        RXLogging.w(TAG, "AudioRouteDeviceManager: setUseAudioDeviceCallback:" + enableSkipPermission);
        Log.w(TAG, "AudioRouteDeviceManager: setUseAudioDeviceCallback:" + enableSkipPermission);
    }

    public void setAudioRouteEnable(boolean enable) {
        this.mAudioRouteEnable = enable;
        RXLogging.w(TAG, "AudioRouteDeviceManager: setAudioRouteEnable:" + enable);
        Log.w(TAG, "AudioRouteDeviceManager: setAudioRouteEnable:" + enable);
    }

    public int init() {
        IntentFilter intentFilter = new IntentFilter();
        this.mIntentFilter = intentFilter;
        intentFilter.addAction(ACTION_BT_STATE_CHANGED);
        this.mIntentFilter.addAction(ACTION_USB_DEVICE_ATTACHED);
        this.mIntentFilter.addAction(ACTION_USB_DEVICE_DETACHED);
        initHandler();
        if (initHeadset()) {
            this.mInitDeviceState += 4;
        }
        if (initUsbHeadset()) {
            this.mInitDeviceState += 32;
        }
        initBluetooth();
        MyBluetoothDevice myBluetoothDevice = this.mBluetoothDevice;
        if (myBluetoothDevice != null) {
            if (myBluetoothDevice.getBluetoothConnected(1)) {
                this.mInitDeviceState += 8;
            }
            if (this.mBluetoothDevice.getBluetoothConnected(2)) {
                this.mInitDeviceState += 16;
            }
        }
        if (registerReceiver() == 0) {
            return 0;
        }
        Log.e(TAG, "AudioRouteDeviceManager: registerReceiver failed.");
        release();
        return -2;
    }

    private int registerReceiver() {
        Context context = AudioRouteUtil.getContext();
        if (context == null) {
            return -1;
        }
        if (this.registered) {
            RXLogging.i(TAG, "registerReceiver registered");
            return 0;
        }
        this.registered = true;
        try {
            m172xbaca1e0d(context, this, this.mIntentFilter);
        } catch (Exception e) {
            RXLogging.e(TAG, "AudioRouteDeviceManager: registerReceiver failed", e);
            this.registered = false;
        }
        if (this.mUseAudioDeviceCallback) {
            AudioManager audioManager = (AudioManager) context.getSystemService(MediaFormat.KEY_AUDIO);
            if (audioManager == null) {
                return -2;
            }
            BluetoothConnectCallback bluetoothConnectCallback = new BluetoothConnectCallback();
            this.mBluetoothDeviceCallback = bluetoothConnectCallback;
            audioManager.registerAudioDeviceCallback(bluetoothConnectCallback, null);
        }
        Log.w(TAG, "AudioRouteDeviceManager: registerReceiver SkipBluetooth:" + this.mUseAudioDeviceCallback);
        RXLogging.w(TAG, "AudioRouteDeviceManager: registerReceiver SkipBluetooth:" + this.mUseAudioDeviceCallback);
        return 0;
    }

    private int unregisterReceiver() {
        Context context = AudioRouteUtil.getContext();
        if (context == null) {
            return -1;
        }
        if (!this.registered) {
            return 0;
        }
        this.registered = false;
        try {
            m173x15882fe6(context, this);
        } catch (Exception e) {
            RXLogging.e(TAG, "AudioRouteDeviceManager: unregisterReceiver failed", e);
        }
        clearAbortBroadcast();
        if (this.mUseAudioDeviceCallback) {
            AudioManager audioManager = (AudioManager) context.getSystemService(MediaFormat.KEY_AUDIO);
            if (audioManager == null) {
                return -2;
            }
            audioManager.unregisterAudioDeviceCallback(this.mBluetoothDeviceCallback);
            this.mBluetoothDeviceCallback = null;
        }
        Log.w(TAG, "AudioRouteDeviceManager: unregisterReceiver SkipBluetooth:" + this.mUseAudioDeviceCallback);
        RXLogging.w(TAG, "AudioRouteDeviceManager: unregisterReceiver SkipBluetooth:" + this.mUseAudioDeviceCallback);
        return 0;
    }

    public String getRenderDeviceName() {
        int i = this.currentRouting;
        if (i == 1) {
            return "earpiece";
        }
        if (i == 2) {
            return "built-in speaker";
        }
        if (i == 4) {
            String str = this.mWiredHeadsetDevice;
            return str != null ? str : "failed_wired-headset";
        }
        if (i == 8) {
            MyBluetoothDevice myBluetoothDevice = this.mBluetoothDevice;
            return myBluetoothDevice != null ? myBluetoothDevice.getName() : "failed_bluetooth-headset";
        }
        if (i == 16) {
            MyBluetoothDevice myBluetoothDevice2 = this.mBluetoothDevice;
            return myBluetoothDevice2 != null ? myBluetoothDevice2.getName() : "failed_bluetooth-a2dp";
        }
        if (i != 32) {
            return "failed_device_name";
        }
        UsbDevice usbDevice = this.mUsbHeadsetDevice;
        return usbDevice != null ? usbDevice.getDeviceName() : "failed_usb-headset";
    }

    public String getCaptureDeviceName() {
        return getRenderDeviceName();
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0067, code lost:
    
        if (androidx.core.content.ContextCompat.checkSelfPermission(r2, "android.permission.FOREGROUND_SERVICE") == 0) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0078, code lost:
    
        if (androidx.core.content.ContextCompat.checkSelfPermission(r2, "android.permission.FOREGROUND_SERVICE_MICROPHONE") == 0) goto L38;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0061 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String getSessionInfo() {
        boolean z;
        boolean z2;
        int i;
        Context context = AudioRouteUtil.getContext();
        if (context == null) {
            return "Context is null";
        }
        AudioManager audioManager = (AudioManager) context.getSystemService(MediaFormat.KEY_AUDIO);
        if (audioManager == null) {
            return "AudioManager is null";
        }
        if (this.mCallback == null) {
            return "mCallback is null";
        }
        boolean z3 = true;
        boolean z4 = false;
        try {
            z = context.getPackageManager().hasSystemFeature("android.hardware.microphone");
        } catch (Exception e) {
            e = e;
            z = false;
        }
        try {
            try {
            } catch (Exception e2) {
                e = e2;
                RXLogging.e(TAG, "getSessionInfo failed to determine the availability of microphone " + e.toString());
                z2 = false;
                i = context.getApplicationInfo().targetSdkVersion;
                if (30 <= i) {
                }
                if (34 <= i) {
                }
                return "{ Audio State: audio_mode:" + AudioRouteUtil.modeString(audioManager.getMode()) + ", has_mic:" + z + ", mic_muted:" + audioManager.isMicrophoneMute() + ", speakerphone:" + audioManager.isSpeakerphoneOn() + ", headset:" + audioManager.isWiredHeadsetOn() + ", bt_sco:" + audioManager.isBluetoothScoOn() + ", permission:" + z2 + ", foregroundServiceMic:" + z4 + ", bluetoothPermission:" + this.mBluetoothPermissionDesp + " }";
            }
            if (ContextCompat.checkSelfPermission(context, "android.permission.RECORD_AUDIO") == 0) {
                z2 = true;
                i = context.getApplicationInfo().targetSdkVersion;
                if (30 <= i || i >= 34) {
                    if (34 <= i) {
                        if (ContextCompat.checkSelfPermission(context, "android.permission.FOREGROUND_SERVICE") == 0) {
                        }
                        z3 = false;
                        z4 = z3;
                    }
                }
                return "{ Audio State: audio_mode:" + AudioRouteUtil.modeString(audioManager.getMode()) + ", has_mic:" + z + ", mic_muted:" + audioManager.isMicrophoneMute() + ", speakerphone:" + audioManager.isSpeakerphoneOn() + ", headset:" + audioManager.isWiredHeadsetOn() + ", bt_sco:" + audioManager.isBluetoothScoOn() + ", permission:" + z2 + ", foregroundServiceMic:" + z4 + ", bluetoothPermission:" + this.mBluetoothPermissionDesp + " }";
            }
            return "{ Audio State: audio_mode:" + AudioRouteUtil.modeString(audioManager.getMode()) + ", has_mic:" + z + ", mic_muted:" + audioManager.isMicrophoneMute() + ", speakerphone:" + audioManager.isSpeakerphoneOn() + ", headset:" + audioManager.isWiredHeadsetOn() + ", bt_sco:" + audioManager.isBluetoothScoOn() + ", permission:" + z2 + ", foregroundServiceMic:" + z4 + ", bluetoothPermission:" + this.mBluetoothPermissionDesp + " }";
        } catch (Exception e3) {
            String str = "getSessionInfo failed, exception: " + e3.toString();
            RXLogging.e(TAG, "AudioRouteDeviceManager: " + str);
            return str;
        }
        z2 = false;
        i = context.getApplicationInfo().targetSdkVersion;
        if (30 <= i) {
        }
        if (34 <= i) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bluetoothScoDisconnectionForNormalMode() {
        Context context = AudioRouteUtil.getContext();
        if (context == null) {
            RXLogging.e(TAG, "AudioRouteDeviceManager: bluetoothScoDisconnectionForNormalMode failed. Context is null.");
            return;
        }
        AudioManager audioManager = (AudioManager) context.getSystemService(MediaFormat.KEY_AUDIO);
        if (audioManager == null) {
            RXLogging.e(TAG, "AudioRouteDeviceManager: bluetoothScoDisconnectionForNormalMode failed. AudioManager is null.");
            return;
        }
        int mode = audioManager.getMode();
        boolean isBluetoothScoOn = audioManager.isBluetoothScoOn();
        RXLogging.e(TAG, "AudioRouteDeviceManager: bluetoothScoDisconnectionForNormalMode mode(" + mode + "), bluetoothScoOn(" + isBluetoothScoOn + ")");
        if (mode == 0) {
            if (isBluetoothScoOn || this.mScoHasStarted) {
                stopSystemBluetoothSco(audioManager);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bluetoothScoConnectionCheck() {
        if (this.mCallback == null) {
            return;
        }
        Context context = AudioRouteUtil.getContext();
        if (context == null) {
            RXLogging.e(TAG, "AudioRouteDeviceManager: bluetoothScoConnectionCheck failed. Context is null.");
            return;
        }
        AudioManager audioManager = (AudioManager) context.getSystemService(MediaFormat.KEY_AUDIO);
        if (audioManager == null) {
            RXLogging.e(TAG, "AudioRouteDeviceManager: bluetoothScoConnectionCheck failed. AudioManager is null.");
            return;
        }
        if (this.mBluetoothScoConnectCheckTimes >= 3) {
            if (this.mScoHasStarted) {
                stopSystemBluetoothSco(audioManager);
            }
            RXLogging.e(TAG, "AudioRouteDeviceManager: bluetoothScoConnectionCheck timeout, time: " + this.mBluetoothScoConnectCheckTimes);
            this.mBluetoothScoConnectCheckTimes = -1;
            this.mHandler.removeCallbacks(this.bluetoothScoConnectionCheckRunnable);
            this.mCallback.onError(AudioRouteController.EVENT_SCO_FAILED_FORCE_TO_MEDIA_MODE, "change to normal mode due to sco started timeout");
            return;
        }
        if (audioManager.isBluetoothScoOn()) {
            RXLogging.e(TAG, "AudioRouteDeviceManager: bluetoothScoConnectionCheck success.");
            this.mBluetoothScoConnectCheckTimes = -1;
            this.mHandler.removeCallbacks(this.bluetoothScoConnectionCheckRunnable);
            return;
        }
        this.mBluetoothScoConnectCheckTimes++;
        RXLogging.e(TAG, "AudioRouteDeviceManager: bluetoothScoConnectionCheck failed. retry again, time: " + this.mBluetoothScoConnectCheckTimes);
        startSystemBluetoothSco(audioManager);
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.postDelayed(this.bluetoothScoConnectionCheckRunnable, 3000L);
        }
    }

    public void restartBluetoothSco() {
        Handler handler;
        RXLogging.w(TAG, "restartBluetoothSco enter.");
        if (!(this.mBluetoothDevice != null)) {
            RXLogging.w(TAG, "restartBluetoothSco skip, no bluetooth device now.");
            this.mHandler.removeCallbacks(new Runnable() { // from class: com.ss.bytertc.audio.device.router.AudioRouteDeviceManager$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    AudioRouteDeviceManager.this.restartBluetoothScoAsynTask();
                }
            });
            return;
        }
        Context context = AudioRouteUtil.getContext();
        if (context == null) {
            RXLogging.e(TAG, "restartBluetoothSco failed. Context is null.");
            return;
        }
        AudioManager audioManager = (AudioManager) context.getSystemService(MediaFormat.KEY_AUDIO);
        if (audioManager == null) {
            RXLogging.e(TAG, "restartBluetoothSco failed. AudioManager is null.");
            return;
        }
        if (3 != audioManager.getMode()) {
            RXLogging.e(TAG, "restartBluetoothSco failed. Not in communication mode.");
            return;
        }
        if (bluetoothScoIsStarting()) {
            RXLogging.w(TAG, "restartBluetoothSco skip. sco is starting.");
            return;
        }
        int i = this.mBluetoothScoRestartTimes + 1;
        this.mBluetoothScoRestartTimes = i;
        if (i <= 3) {
            RXLogging.w(TAG, "restartBluetoothScoAsynTask, restart time: " + this.mBluetoothScoRestartTimes);
            if (!audioManager.isBluetoothScoOn() && (handler = this.mHandler) != null) {
                handler.postDelayed(new Runnable() { // from class: com.ss.bytertc.audio.device.router.AudioRouteDeviceManager$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        AudioRouteDeviceManager.this.restartBluetoothScoAsynTask();
                    }
                }, 3000L);
            }
        } else {
            if (this.mScoHasStarted) {
                stopSystemBluetoothSco(audioManager);
            }
            IAudioRouteCallback iAudioRouteCallback = this.mCallback;
            if (iAudioRouteCallback != null) {
                iAudioRouteCallback.onError(AudioRouteController.EVENT_SCO_FAILED_FORCE_TO_MEDIA_MODE, "change to normal mode due to sco restart timeout");
            }
        }
        RXLogging.w(TAG, "restartBluetoothSco leave.");
    }

    public void stopBluetoothSco() {
        RXLogging.w(TAG, "AudioRouteDeviceManager: stopBluetoothSco begin.");
        if (this.mScoHasStarted) {
            Context context = AudioRouteUtil.getContext();
            if (context == null) {
                RXLogging.e(TAG, "stopBluetoothSco failed. Context is null.");
                return;
            }
            stopSystemBluetoothSco((AudioManager) context.getSystemService(MediaFormat.KEY_AUDIO));
        }
        this.mBluetoothScoConnectCheckTimes = -1;
        this.mHandler.removeCallbacks(this.bluetoothScoConnectionCheckRunnable);
        RXLogging.w(TAG, "AudioRouteDeviceManager: stopBluetoothSco end, mBluetoothScoConnectCheckTimes: " + this.mBluetoothScoConnectCheckTimes);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void restartBluetoothScoAsynTask() {
        RXLogging.w(TAG, "restartBluetoothScoAsynTask enter.");
        if (!(this.mBluetoothDevice != null)) {
            RXLogging.w(TAG, "AudioRouteDeviceManager: restartBluetoothScoAsynTask skip, no bluetooth device now.");
            return;
        }
        if (bluetoothScoIsStarting()) {
            RXLogging.w(TAG, "AudioRouteDeviceManager: restartBluetoothScoAsynTask skip. sco is starting.");
            return;
        }
        Context context = AudioRouteUtil.getContext();
        if (context == null) {
            RXLogging.e(TAG, "AudioRouteDeviceManager: restartBluetoothScoAsynTask failed. Context is null.");
            return;
        }
        AudioManager audioManager = (AudioManager) context.getSystemService(MediaFormat.KEY_AUDIO);
        if (audioManager == null) {
            RXLogging.e(TAG, "AudioRouteDeviceManager: restartBluetoothScoAsynTask failed. AudioManager is null.");
        } else {
            startSystemBluetoothSco(audioManager);
            RXLogging.w(TAG, "AudioRouteDeviceManager: restartBluetoothScoAsynTask has start bluetooth.");
        }
    }

    private boolean bluetoothScoIsStarting() {
        return this.mHandler != null && this.mBluetoothScoConnectCheckTimes >= 0;
    }

    private void startSystemBluetoothSco(AudioManager audioManager) {
        if (audioManager != null) {
            try {
                audioManager.startBluetoothSco();
                this.mScoHasStarted = true;
                return;
            } catch (Exception e) {
                RXLogging.e(TAG, "AudioRouteDeviceManager: startSystemBluetoothSco failed, Exception: " + e.toString());
                return;
            }
        }
        RXLogging.e(TAG, "AudioRouteDeviceManager: startSystemBluetoothSco skipped, audioManager is null");
    }

    private void stopSystemBluetoothSco(AudioManager audioManager) {
        if (audioManager != null) {
            try {
                audioManager.stopBluetoothSco();
                audioManager.setBluetoothScoOn(false);
                this.mScoHasStarted = false;
                RXLogging.i(TAG, "AudioRouteDeviceManager: stopSystemBluetoothSco begin.");
                return;
            } catch (Exception e) {
                RXLogging.e(TAG, "AudioRouteDeviceManager: stopSystemBluetoothSco failed, Exception: " + e.toString());
                return;
            }
        }
        RXLogging.e(TAG, "AudioRouteDeviceManager: stopSystemBluetoothSco skipped, audioManager is null");
    }

    public int setAudioRoute(int deviceType, boolean isMediaMode) {
        Context context = AudioRouteUtil.getContext();
        if (context == null) {
            RXLogging.e(TAG, "AudioRouteDeviceManager: setAudioRoute failed. Context is null.");
            return -1;
        }
        AudioManager audioManager = (AudioManager) context.getSystemService(MediaFormat.KEY_AUDIO);
        if (audioManager == null) {
            RXLogging.e(TAG, "AudioRouteDeviceManager: setAudioRoute failed. AudioManager is null.");
            return -2;
        }
        if (this.mCallback == null) {
            RXLogging.e(TAG, "AudioRouteDeviceManager: setAudioRoute failed. mCallback is null.");
            return -6;
        }
        int mode = audioManager.getMode();
        int i = isMediaMode ? 0 : 3;
        if (i != mode) {
            RXLogging.e(TAG, "AudioRouteDeviceManager: isMediaMode:" + isMediaMode + ", cacheMode:" + i + ", systemMode: " + mode + " not matched with system!!!");
            audioManager.setMode(i);
            mode = audioManager.getMode();
        }
        boolean isSpeakerphoneOn = audioManager.isSpeakerphoneOn();
        boolean isBluetoothScoOn = audioManager.isBluetoothScoOn();
        RXLogging.e(TAG, "AudioRouteDeviceManager: setAudioRoute, deviceType: " + routingDeviceType2Text(deviceType) + ", cacheMode:" + i + ", systemMode: " + mode + ", speakerPhoneOn: " + isSpeakerphoneOn + ", bluetoothScoOn: " + isBluetoothScoOn);
        if (mode != 3) {
            if (mode == 0) {
                if (isBluetoothScoOn || this.mScoHasStarted) {
                    RXLogging.w(TAG, "AudioRouteDeviceManager: MODE_NORMAL,but BluetoothScoOn is true, force to close sco.");
                    stopSystemBluetoothSco(audioManager);
                }
                Handler handler = this.mHandler;
                if (handler != null) {
                    handler.removeCallbacks(this.bluetoothScoConnectionCheckRunnable);
                    this.mHandler.removeCallbacks(new Runnable() { // from class: com.ss.bytertc.audio.device.router.AudioRouteDeviceManager$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            AudioRouteDeviceManager.this.bluetoothScoDisconnectionForNormalMode();
                        }
                    });
                    this.mHandler.postDelayed(new Runnable() { // from class: com.ss.bytertc.audio.device.router.AudioRouteDeviceManager$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            AudioRouteDeviceManager.this.bluetoothScoDisconnectionForNormalMode();
                        }
                    }, 6000L);
                }
                if (deviceType == 2) {
                    if (!isSpeakerphoneOn) {
                        audioManager.setSpeakerphoneOn(true);
                    }
                } else if (deviceType == 1 && isSpeakerphoneOn) {
                    audioManager.setSpeakerphoneOn(false);
                }
                return 0;
            }
            RXLogging.e(TAG, "AudioRouteDeviceManager: mode(" + mode + ") is not support to setAudioRoute");
            return -4;
        }
        if (deviceType == 8) {
            boolean bluetoothScoIsStarting = bluetoothScoIsStarting();
            RXLogging.w(TAG, "AudioRouteDeviceManager: need to start bluetooth sco in communication mode, sco is starting: " + bluetoothScoIsStarting + (bluetoothScoIsStarting ? ", skip start sco" : ", continue start sco"));
            if (!isBluetoothScoOn && !bluetoothScoIsStarting) {
                RXLogging.w(TAG, "AudioRouteDeviceManager: ready to start sco");
                this.mBluetoothScoConnectCheckTimes = 0;
                startSystemBluetoothSco(audioManager);
                Handler handler2 = this.mHandler;
                if (handler2 != null) {
                    handler2.removeCallbacks(new Runnable() { // from class: com.ss.bytertc.audio.device.router.AudioRouteDeviceManager$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            AudioRouteDeviceManager.this.bluetoothScoDisconnectionForNormalMode();
                        }
                    });
                    this.mHandler.removeCallbacks(this.bluetoothScoConnectionCheckRunnable);
                    this.mHandler.postDelayed(this.bluetoothScoConnectionCheckRunnable, 3000L);
                }
            }
        } else {
            if (isBluetoothScoOn || this.mScoHasStarted) {
                stopSystemBluetoothSco(audioManager);
            }
            if (deviceType == 2) {
                if (!isSpeakerphoneOn) {
                    audioManager.setSpeakerphoneOn(true);
                }
            } else {
                if (deviceType != 1 && deviceType != 4 && deviceType != 32) {
                    if (deviceType == 16) {
                        RXLogging.e(TAG, "AudioRouteDeviceManager: Error: setAudioRoute to a2dp in communication mode");
                        return -7;
                    }
                    RXLogging.e(TAG, "AudioRouteDeviceManager: setAudioRoute failed. deviceType(" + routingDeviceType2Text(deviceType) + ") invalid.");
                    return -3;
                }
                if (isSpeakerphoneOn) {
                    audioManager.setSpeakerphoneOn(false);
                }
            }
        }
        this.currentRouting = deviceType;
        return 0;
    }

    public int release() {
        int i;
        AudioManager audioManager;
        this.mCallback = null;
        Context context = AudioRouteUtil.getContext();
        if (context != null && (audioManager = (AudioManager) context.getSystemService(MediaFormat.KEY_AUDIO)) != null && this.mAudioRouteEnable && (audioManager.isBluetoothScoOn() || this.mScoHasStarted)) {
            stopSystemBluetoothSco(audioManager);
        }
        if (unregisterReceiver() != 0) {
            RXLogging.e(TAG, "AudioRouteDeviceManager: unregisterReceiver failed.");
            i = -1;
        } else {
            i = 0;
        }
        if (this.mHandler != null) {
            this.mHandler = null;
        }
        HandlerThread handlerThread = this.mHandlerThread;
        if (handlerThread != null) {
            handlerThread.quit();
            this.mHandlerThread = null;
        }
        this.mBluetoothAdapter = null;
        this.mIntentFilter = null;
        this.mInitDeviceState = 0;
        synchronized (this.bluetoothLock) {
            this.mBluetoothDevice = null;
        }
        this.mUsbHeadsetDevice = null;
        this.mWiredHeadsetDevice = null;
        this.currentRouting = -1;
        this.mEnableUseAudioDeviceCallback = false;
        this.mUseAudioDeviceCallback = false;
        return i;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0374  */
    @Override // android.content.BroadcastReceiver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onReceive(Context context, Intent intent) {
        String str;
        int i;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        String attrsString;
        IAudioRouteCallback iAudioRouteCallback;
        if (intent == null) {
            return;
        }
        String action = intent.getAction();
        if (action == null) {
            RXLogging.e(TAG, "AudioRouteDeviceManager: action is null");
            return;
        }
        str = "";
        int i2 = 16;
        if (action.equals(ACTION_BT_STATE_CHANGED)) {
            i = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", -99);
            BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
            if (i == 10) {
                RXLogging.w(TAG, "AudioRouteDeviceManager: ACTION_BT_STATE_CHANGED:STATE_OFF:" + this.mBluetoothDevice);
                IAudioRouteCallback iAudioRouteCallback2 = this.mCallback;
                if (iAudioRouteCallback2 != null) {
                    iAudioRouteCallback2.onDeviceEvent(8, false, "");
                    this.mCallback.onDeviceEvent(16, false, "");
                }
                synchronized (this.bluetoothLock) {
                    if (this.mBluetoothDevice != null) {
                        RXLogging.w(TAG, "AudioRouteDeviceManager: destroy mBluetoothDevice due to bluetooth adapter is closed: " + bluetoothDevice);
                        this.mBluetoothDevice = null;
                    }
                }
                return;
            }
            if (i == 12) {
                RXLogging.w(TAG, "AudioRouteDeviceManager: ACTION_BT_STATE_CHANGED:STATE_ON:" + bluetoothDevice);
            }
            i2 = 8;
        } else {
            if (action.equals(ACTION_BT_HEADSET_CONNECTION_STATE_CHANGED)) {
                int intExtra = intent.getIntExtra("android.bluetooth.profile.extra.STATE", -99);
                BluetoothDevice bluetoothDevice2 = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                if (intExtra != 0) {
                    if (intExtra != 1) {
                        if (intExtra == 2) {
                            RXLogging.w(TAG, "AudioRouteDeviceManager: ACTION_BT_HEADSET_CONNECTION_STATE_CHANGED:STATE_CONNECTED:" + bluetoothDevice2);
                            String[] strArr = {""};
                            if (bluetoothDevice2 != null && isBtDeviceMajorValid(context, 1, bluetoothDevice2, strArr)) {
                                synchronized (this.bluetoothLock) {
                                    if (this.mBluetoothDevice == null) {
                                        this.mBluetoothDevice = new MyBluetoothDevice(bluetoothDevice2);
                                    }
                                    this.mBluetoothDevice.appendDeviceInfo("broadcast", strArr[0]);
                                    this.mBluetoothDevice.setBluetoothConnected(1, true);
                                    attrsString = this.mBluetoothDevice.getAttrsString();
                                }
                                this.mBluetoothScoRestartTimes = 0;
                                str = attrsString;
                                z7 = true;
                                z8 = z7;
                            }
                        } else if (intExtra != 3) {
                            RXLogging.w(TAG, "AudioRouteDeviceManager: ACTION_BT_HEADSET_CONNECTION_STATE_CHANGED, unknown state: " + intExtra);
                        }
                    }
                    z7 = false;
                    z8 = z7;
                } else {
                    RXLogging.w(TAG, "AudioRouteDeviceManager: ACTION_BT_HEADSET_CONNECTION_STATE_CHANGED:STATE_DISCONNECTED:" + bluetoothDevice2);
                    synchronized (this.bluetoothLock) {
                        MyBluetoothDevice myBluetoothDevice = this.mBluetoothDevice;
                        if (myBluetoothDevice != null) {
                            myBluetoothDevice.setBluetoothConnected(1, false);
                            str = this.mBluetoothDevice.getAttrsString();
                            if (!this.mBluetoothDevice.getBluetoothConnected(1) && !this.mBluetoothDevice.getBluetoothConnected(2)) {
                                RXLogging.w(TAG, "AudioRouteDeviceManager: destroy mBluetoothDevice due to headset & a2dp disconncected" + bluetoothDevice2);
                                this.mBluetoothDevice = null;
                            }
                        }
                    }
                    z7 = false;
                    z8 = true;
                }
                i2 = 8;
                boolean z9 = z8;
                z = z7;
                i = intExtra;
                z2 = z9;
            } else if (action.equals(ACTION_BT_A2DP_CONNECTION_STATE_CHANGED)) {
                int intExtra2 = intent.getIntExtra("android.bluetooth.profile.extra.STATE", -99);
                BluetoothDevice bluetoothDevice3 = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                if (intExtra2 != 0) {
                    if (intExtra2 != 1) {
                        if (intExtra2 == 2) {
                            RXLogging.w(TAG, "AudioRouteDeviceManager: ACTION_BT_A2DP_CONNECTION_STATE_CHANGED:STATE_CONNECTED:" + bluetoothDevice3);
                            String[] strArr2 = {""};
                            synchronized (this.bluetoothLock) {
                                if (bluetoothDevice3 != null) {
                                    if (this.mBluetoothDevice == null) {
                                        this.mBluetoothDevice = new MyBluetoothDevice(bluetoothDevice3);
                                    }
                                    isBtDeviceMajorValid(context, 2, bluetoothDevice3, strArr2);
                                    this.mBluetoothDevice.appendDeviceInfo("broadcast", strArr2[0]);
                                    this.mBluetoothDevice.setBluetoothConnected(2, true);
                                    String attrsString2 = this.mBluetoothDevice.getAttrsString();
                                    this.mBluetoothScoRestartTimes = 0;
                                    str = attrsString2;
                                    z5 = true;
                                } else {
                                    z5 = false;
                                }
                                z6 = z5;
                            }
                        } else if (intExtra2 != 3) {
                            RXLogging.w(TAG, "AudioRouteDeviceManager: ACTION_BT_A2DP_CONNECTION_STATE_CHANGED, unknown state: " + intExtra2);
                        }
                    }
                    z5 = false;
                    z6 = false;
                } else {
                    RXLogging.w(TAG, "AudioRouteDeviceManager: ACTION_BT_A2DP_CONNECTION_STATE_CHANGED:STATE_DISCONNECTED:" + bluetoothDevice3);
                    synchronized (this.bluetoothLock) {
                        MyBluetoothDevice myBluetoothDevice2 = this.mBluetoothDevice;
                        if (myBluetoothDevice2 != null) {
                            myBluetoothDevice2.setBluetoothConnected(2, false);
                            String attrsString3 = this.mBluetoothDevice.getAttrsString();
                            if (!this.mBluetoothDevice.getBluetoothConnected(1) && !this.mBluetoothDevice.getBluetoothConnected(2)) {
                                RXLogging.w(TAG, "AudioRouteDeviceManager: destroy mBluetoothDevice due to headset & a2dp disconncected" + bluetoothDevice3);
                                this.mBluetoothDevice = null;
                            }
                            str = attrsString3;
                        }
                    }
                    z5 = false;
                    z6 = true;
                }
                z2 = z6;
                z = z5;
                i = intExtra2;
            } else if (action.equals(ACTION_BT_SCO_AUDIO_STATE_UPDATED)) {
                i = intent.getIntExtra("android.media.extra.SCO_AUDIO_STATE", -99);
                if (i != 0) {
                    if (i != 1) {
                        z = false;
                    } else {
                        RXLogging.w(TAG, "AudioRouteDeviceManager: SCO_AUDIO_STATE_CONNECTED");
                        synchronized (this.bluetoothLock) {
                            MyBluetoothDevice myBluetoothDevice3 = this.mBluetoothDevice;
                            str = myBluetoothDevice3 != null ? myBluetoothDevice3.getAttrsString() : "";
                        }
                        z = true;
                    }
                    z2 = z;
                } else {
                    RXLogging.w(TAG, "AudioRouteDeviceManager: SCO_AUDIO_STATE_DISCONNECTED");
                    synchronized (this.bluetoothLock) {
                        MyBluetoothDevice myBluetoothDevice4 = this.mBluetoothDevice;
                        str = myBluetoothDevice4 != null ? myBluetoothDevice4.getAttrsString() : "";
                    }
                    z = false;
                    z2 = true;
                }
                i2 = 64;
            } else {
                i2 = 32;
                if (action.equals(ACTION_USB_DEVICE_ATTACHED)) {
                    UsbDevice usbDevice = (UsbDevice) intent.getParcelableExtra("device");
                    RXLogging.w(TAG, "AudioRouteDeviceManager: ACTION_USB_DEVICE_ATTACHED:" + usbDevice);
                    if (hasAudioForUsbDevice(usbDevice)) {
                        this.mUsbHeadsetDevice = usbDevice;
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    i = -1234;
                    z2 = z4;
                    z = true;
                } else if (action.equals(ACTION_USB_DEVICE_DETACHED)) {
                    UsbDevice usbDevice2 = (UsbDevice) intent.getParcelableExtra("device");
                    RXLogging.w(TAG, "AudioRouteDeviceManager: ACTION_USB_DEVICE_DETACHED:" + usbDevice2);
                    if (hasAudioForUsbDevice(usbDevice2)) {
                        this.mUsbHeadsetDevice = null;
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    i = -1234;
                    z2 = z3;
                    z = false;
                } else if (!action.equals(ACTION_HEADSET_PLUG)) {
                    i2 = -1;
                    i = -1234;
                } else {
                    if (headsetPlugActionIsFromUsbHeadset(intent)) {
                        return;
                    }
                    boolean z10 = intent.getIntExtra("state", -99) == 1;
                    RXLogging.w(TAG, "AudioRouteDeviceManager: ACTION_HEADSET_PLUG:".concat(z10 ? "connected" : "disconnected"));
                    if (z10) {
                        this.mWiredHeadsetDevice = "wired-headset";
                    } else {
                        this.mWiredHeadsetDevice = null;
                    }
                    i2 = 4;
                    z = z10;
                    i = -1234;
                    z2 = true;
                }
            }
            RXLogging.w(TAG, "AudioRouteDeviceManager: received action:" + action + " state:" + i + " needReport:" + z2 + ", mCallback:" + (this.mCallback != null) + ", deviceType:" + i2 + ", connectedStatus:" + z);
            if (z2 || (iAudioRouteCallback = this.mCallback) == null) {
            }
            iAudioRouteCallback.onDeviceEvent(i2, z, str);
            return;
        }
        z = false;
        z2 = false;
        RXLogging.w(TAG, "AudioRouteDeviceManager: received action:" + action + " state:" + i + " needReport:" + z2 + ", mCallback:" + (this.mCallback != null) + ", deviceType:" + i2 + ", connectedStatus:" + z);
        if (z2) {
        }
    }

    private boolean headsetPlugActionIsFromUsbHeadset(Intent intent) {
        String stringExtra = intent.getStringExtra("address");
        String stringExtra2 = intent.getStringExtra("portName");
        RXLogging.w(TAG, "ACTION_HEADSET_PLUG info, address: " + stringExtra + ", portName: " + stringExtra2 + ", connected: " + intent.getIntExtra("state", -99) + ", hasMic: " + intent.getIntExtra("microphone", -99));
        if ("".equals(stringExtra) || "".equals(stringExtra2) || stringExtra2 == null) {
            return false;
        }
        if (!stringExtra2.startsWith("USB") && !stringExtra2.startsWith("usb")) {
            return false;
        }
        RXLogging.e(TAG, "AudioRouteDeviceManager: received ACTION_HEADSET_PLUG, may be is a usb device");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public class MyBluetoothDevice {
        private BluetoothDevice bluetoothDevice;
        private String name;
        private String extraInfo = "";
        private boolean headsetConnected = false;
        private boolean a2dpConnected = false;

        public MyBluetoothDevice(String name) {
            this.name = name;
        }

        public MyBluetoothDevice(BluetoothDevice device) {
            this.bluetoothDevice = device;
        }

        public void appendDeviceInfo(String from, String info) {
            String str = " ,from:" + from + " " + info;
            if (this.extraInfo.contains(str)) {
                return;
            }
            this.extraInfo += str;
        }

        public boolean getBluetoothConnected(int bluetoothProfile) {
            if (bluetoothProfile == 1) {
                return this.headsetConnected;
            }
            if (bluetoothProfile == 2) {
                return this.a2dpConnected;
            }
            return false;
        }

        public void setBluetoothConnected(int bluetoothProfile, boolean connected) {
            if (bluetoothProfile == 1) {
                this.headsetConnected = connected;
            } else if (bluetoothProfile == 2) {
                this.a2dpConnected = connected;
            }
        }

        public String getName() {
            return this.bluetoothDevice == null ? this.name : "bluetooth-headset";
        }

        public String toString() {
            return getName();
        }

        public String getAttrsString() {
            return ((("name:" + getName()) + ", headset:" + (this.headsetConnected ? "true" : "false")) + ", a2dp:" + (this.a2dpConnected ? "true" : "false")) + this.extraInfo;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public class BluetoothConnectCallback extends AudioDeviceCallback {
        private BluetoothConnectCallback() {
        }

        @Override // android.media.AudioDeviceCallback
        public void onAudioDevicesAdded(AudioDeviceInfo[] addedDevices) {
            String attrsString;
            String attrsString2;
            for (AudioDeviceInfo audioDeviceInfo : addedDevices) {
                if (!audioDeviceInfo.isSource()) {
                    int type = audioDeviceInfo.getType();
                    if (type != 7 || AudioRouteDeviceManager.this.mCallback == null) {
                        if (type == 8 && AudioRouteDeviceManager.this.mCallback != null) {
                            String obj = audioDeviceInfo.getProductName().toString();
                            RXLogging.w(AudioRouteDeviceManager.TAG, "AudioRouteDeviceManager: addedDevices: " + type + ", name: " + obj);
                            synchronized (AudioRouteDeviceManager.this.bluetoothLock) {
                                if (AudioRouteDeviceManager.this.mBluetoothDevice == null) {
                                    AudioRouteDeviceManager.this.mBluetoothDevice = new MyBluetoothDevice("bluetooth-headset");
                                }
                                AudioRouteDeviceManager.this.mBluetoothDevice.appendDeviceInfo("callback", "[device:" + obj + "] ");
                                AudioRouteDeviceManager.this.mBluetoothDevice.setBluetoothConnected(2, true);
                                attrsString = AudioRouteDeviceManager.this.mBluetoothDevice.getAttrsString();
                            }
                            AudioRouteDeviceManager.this.mCallback.onDeviceEvent(16, true, attrsString);
                        }
                    } else {
                        String obj2 = audioDeviceInfo.getProductName().toString();
                        RXLogging.w(AudioRouteDeviceManager.TAG, "AudioRouteDeviceManager: addedDevices: " + type + ", name: " + obj2);
                        synchronized (AudioRouteDeviceManager.this.bluetoothLock) {
                            if (AudioRouteDeviceManager.this.mBluetoothDevice == null) {
                                AudioRouteDeviceManager.this.mBluetoothDevice = new MyBluetoothDevice("bluetooth-headset");
                            }
                            AudioRouteDeviceManager.this.mBluetoothDevice.appendDeviceInfo("callback", "[device:" + obj2 + "] ");
                            AudioRouteDeviceManager.this.mBluetoothDevice.setBluetoothConnected(1, true);
                            attrsString2 = AudioRouteDeviceManager.this.mBluetoothDevice.getAttrsString();
                        }
                        AudioRouteDeviceManager.this.mBluetoothScoRestartTimes = 0;
                        AudioRouteDeviceManager.this.mCallback.onDeviceEvent(8, true, attrsString2);
                    }
                }
            }
        }

        @Override // android.media.AudioDeviceCallback
        public void onAudioDevicesRemoved(AudioDeviceInfo[] removedDevices) {
            for (AudioDeviceInfo audioDeviceInfo : removedDevices) {
                if (!audioDeviceInfo.isSource()) {
                    int type = audioDeviceInfo.getType();
                    if (type != 7 || AudioRouteDeviceManager.this.mCallback == null) {
                        if (type == 8 && AudioRouteDeviceManager.this.mCallback != null) {
                            RXLogging.w(AudioRouteDeviceManager.TAG, "AudioRouteDeviceManager: removedDevices: " + type + ", name: " + ((Object) audioDeviceInfo.getProductName()));
                            String str = "";
                            synchronized (AudioRouteDeviceManager.this.bluetoothLock) {
                                if (AudioRouteDeviceManager.this.mBluetoothDevice != null) {
                                    AudioRouteDeviceManager.this.mBluetoothDevice.setBluetoothConnected(2, false);
                                    str = AudioRouteDeviceManager.this.mBluetoothDevice.getAttrsString();
                                    if (!AudioRouteDeviceManager.this.mBluetoothDevice.getBluetoothConnected(1) && !AudioRouteDeviceManager.this.mBluetoothDevice.getBluetoothConnected(2)) {
                                        RXLogging.w(AudioRouteDeviceManager.TAG, "AudioRouteDeviceManager: destroy mBluetoothDevice due to headset & a2dp disconncected");
                                        AudioRouteDeviceManager.this.mBluetoothDevice = null;
                                    }
                                }
                            }
                            AudioRouteDeviceManager.this.mCallback.onDeviceEvent(16, false, str);
                            return;
                        }
                    } else {
                        RXLogging.w(AudioRouteDeviceManager.TAG, "AudioRouteDeviceManager: removedDevices: " + type + ", name: " + ((Object) audioDeviceInfo.getProductName()));
                        String str2 = "";
                        synchronized (AudioRouteDeviceManager.this.bluetoothLock) {
                            if (AudioRouteDeviceManager.this.mBluetoothDevice != null) {
                                AudioRouteDeviceManager.this.mBluetoothDevice.setBluetoothConnected(1, false);
                                str2 = AudioRouteDeviceManager.this.mBluetoothDevice.getAttrsString();
                                if (!AudioRouteDeviceManager.this.mBluetoothDevice.getBluetoothConnected(1) && !AudioRouteDeviceManager.this.mBluetoothDevice.getBluetoothConnected(2)) {
                                    RXLogging.w(AudioRouteDeviceManager.TAG, "AudioRouteDeviceManager: destroy mBluetoothDevice due to headset & a2dp disconncected");
                                    AudioRouteDeviceManager.this.mBluetoothDevice = null;
                                }
                            }
                            AudioRouteDeviceManager.this.mBluetoothDevice = null;
                        }
                        AudioRouteDeviceManager.this.mCallback.onDeviceEvent(8, false, str2);
                        return;
                    }
                }
            }
        }
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator"})
    /* renamed from: INVOKEVIRTUAL_com_ss_bytertc_audio_device_router_AudioRouteDeviceManager_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver */
    public static Intent m172xbaca1e0d(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen()) {
            ReceiverRegisterCrashOptimizer.doHWReceiverFix();
        }
        try {
            if (ReceiverRegisterCrashOptimizer.doRegisterHandler()) {
                ReceiverRegisterLancet.initHandler();
                Context context2 = context;
                return context.registerReceiver(broadcastReceiver, intentFilter, null, ReceiverRegisterLancet.sReceiverHandler);
            }
            if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null && ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(intentFilter)) {
                ReceiverRegisterLancet.initProxyHandler();
                Context context3 = context;
                return ContextCompat.registerReceiver(context, broadcastReceiver, intentFilter, (String) null, ReceiverRegisterLancet.sProxyHandler, 2);
            }
            return context.registerReceiver(broadcastReceiver, intentFilter);
        } catch (Exception e) {
            if (!ReceiverRegisterCrashOptimizer.fixedOpen()) {
                throw e;
            }
            return ReceiverRegisterCrashOptimizer.registerReceiver(broadcastReceiver, intentFilter);
        }
    }

    @Proxy("unregisterReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    /* renamed from: INVOKEVIRTUAL_com_ss_bytertc_audio_device_router_AudioRouteDeviceManager_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver */
    public static void m173x15882fe6(Context context, BroadcastReceiver broadcastReceiver) {
        ReceiverRegisterLancet.loge(broadcastReceiver, false);
        context.unregisterReceiver(broadcastReceiver);
    }
}
