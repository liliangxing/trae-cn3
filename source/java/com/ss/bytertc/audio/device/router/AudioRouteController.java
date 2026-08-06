package com.ss.bytertc.audio.device.router;

import com.bytedance.realx.base.RXLogging;
import com.xiaomi.mipush.sdk.Constants;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class AudioRouteController implements IAudioRouteCallback {
    public static int EVENT_ONLY_LOG = 0;
    public static int EVENT_SCO_FAILED_FORCE_TO_MEDIA_MODE = 1;
    private static final String TAG = "AudioRouteController";
    private int currentRouting = -1;
    private boolean isMediaMode = true;
    private ReadWriteLock lock;
    private AudioRouteDeviceManager mAudioRouteDeviceManager;
    private long nativeAudioRouteControllerPtr;
    private Lock rLock;
    private Lock wLock;

    private native void onDeviceEvent(long nativeAudioRouteControllerPtr, int deviceType, boolean connected, String deviceInfo);

    private native void onError(long nativeAudioRouteControllerPtr, int eventCode);

    private AudioRouteController(long nativePtr) {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.lock = reentrantReadWriteLock;
        this.rLock = reentrantReadWriteLock.readLock();
        this.wLock = this.lock.writeLock();
        this.nativeAudioRouteControllerPtr = nativePtr;
        this.mAudioRouteDeviceManager = new AudioRouteDeviceManager(this);
    }

    private int init() {
        this.rLock.lock();
        try {
            if (this.nativeAudioRouteControllerPtr != 0 && initAudioRouteDeviceManager() == 0) {
                return this.mAudioRouteDeviceManager.getDeviceState();
            }
            return -1;
        } finally {
            this.rLock.unlock();
        }
    }

    private int setUseAudioDeviceCallback(boolean enableSkipPermission) {
        this.rLock.lock();
        try {
            if (this.nativeAudioRouteControllerPtr != 0) {
                AudioRouteDeviceManager audioRouteDeviceManager = this.mAudioRouteDeviceManager;
                if (audioRouteDeviceManager == null) {
                    this.rLock.unlock();
                    return 0;
                }
                audioRouteDeviceManager.release();
                this.mAudioRouteDeviceManager.setUseAudioDeviceCallback(enableSkipPermission, this);
                if (initAudioRouteDeviceManager() == 0) {
                    return this.mAudioRouteDeviceManager.getDeviceState();
                }
            }
            return -1;
        } finally {
            this.rLock.unlock();
        }
    }

    private void setAudioRouteEnable(boolean enable) {
        this.rLock.lock();
        try {
            if (this.nativeAudioRouteControllerPtr == 0) {
                return;
            }
            AudioRouteDeviceManager audioRouteDeviceManager = this.mAudioRouteDeviceManager;
            if (audioRouteDeviceManager != null) {
                audioRouteDeviceManager.setAudioRouteEnable(enable);
            }
        } finally {
            this.rLock.unlock();
        }
    }

    private int initAudioRouteDeviceManager() {
        int init = this.mAudioRouteDeviceManager.init();
        if (init != 0) {
            release();
            RXLogging.e(TAG, "init failed. code: " + init);
        }
        return init;
    }

    private int release() {
        int i;
        this.wLock.lock();
        RXLogging.w(TAG, "AudioRouteController: release begin");
        try {
            this.nativeAudioRouteControllerPtr = 0L;
            AudioRouteDeviceManager audioRouteDeviceManager = this.mAudioRouteDeviceManager;
            if (audioRouteDeviceManager != null) {
                i = audioRouteDeviceManager.release();
                this.mAudioRouteDeviceManager = null;
            } else {
                i = 0;
            }
            this.currentRouting = -1;
            this.isMediaMode = true;
            return i;
        } finally {
            RXLogging.w(TAG, "AudioRouteController: release end");
            this.wLock.unlock();
        }
    }

    private int setAudioRoute(int routing, boolean isMediaMode) {
        this.rLock.lock();
        RXLogging.w(TAG, "AudioRouteController: setAudioRoute, begin, routing: " + routing + ", isMediaMode: " + isMediaMode);
        try {
            if (this.nativeAudioRouteControllerPtr != 0) {
                this.isMediaMode = isMediaMode;
                int audioRoute = this.mAudioRouteDeviceManager.setAudioRoute(routing, isMediaMode);
                this.currentRouting = audioRoute == 0 ? routing : this.currentRouting;
                return audioRoute;
            }
            RXLogging.w(TAG, "AudioRouteController: setAudioRoute, end, routing: " + routing + ", isMediaMode: " + isMediaMode);
            this.rLock.unlock();
            return -5;
        } finally {
            RXLogging.w(TAG, "AudioRouteController: setAudioRoute, end, routing: " + routing + ", isMediaMode: " + isMediaMode);
            this.rLock.unlock();
        }
    }

    private String getRenderDeviceName() {
        this.rLock.lock();
        try {
            return this.nativeAudioRouteControllerPtr == 0 ? "nativePtr is 0" : this.mAudioRouteDeviceManager.getRenderDeviceName();
        } finally {
            this.rLock.unlock();
        }
    }

    private String getCaptureDeviceName() {
        this.rLock.lock();
        try {
            return this.nativeAudioRouteControllerPtr == 0 ? "nativePtr is 0" : this.mAudioRouteDeviceManager.getCaptureDeviceName();
        } finally {
            this.rLock.unlock();
        }
    }

    private String getSessionInfo() {
        this.rLock.lock();
        try {
            return this.nativeAudioRouteControllerPtr == 0 ? "nativePtr is 0" : this.mAudioRouteDeviceManager.getSessionInfo();
        } finally {
            this.rLock.unlock();
        }
    }

    private void restartBluetoothSco() {
        this.rLock.lock();
        try {
            if (this.nativeAudioRouteControllerPtr == 0) {
                return;
            }
            AudioRouteDeviceManager audioRouteDeviceManager = this.mAudioRouteDeviceManager;
            if (audioRouteDeviceManager != null) {
                audioRouteDeviceManager.restartBluetoothSco();
            }
        } finally {
            this.rLock.unlock();
        }
    }

    private void stopBluetoothSco() {
        this.rLock.lock();
        try {
            if (this.nativeAudioRouteControllerPtr == 0) {
                return;
            }
            if (this.mAudioRouteDeviceManager != null) {
                RXLogging.w(TAG, "stopBluetoothSco, begin");
                this.mAudioRouteDeviceManager.stopBluetoothSco();
            }
        } finally {
            this.rLock.unlock();
        }
    }

    @Override // com.ss.bytertc.audio.device.router.IAudioRouteCallback
    public void onDeviceEvent(int deviceType, boolean connected, String deviceInfo) {
        this.rLock.lock();
        RXLogging.w(TAG, "onDeviceEvent, begin, deviceType: " + deviceType + ", connected: " + connected + ", deviceInfo:" + deviceInfo);
        try {
            if (this.nativeAudioRouteControllerPtr == 0) {
                return;
            }
            RXLogging.e(TAG, "AudioRouteController: onDeviceEvent(Java) deviceType:" + deviceType + ", connected:" + connected + ", deviceInfo:" + deviceInfo);
            onDeviceEvent(this.nativeAudioRouteControllerPtr, deviceType, connected, deviceInfo);
        } finally {
            RXLogging.w(TAG, "AudioRouteController: onDeviceEvent, end");
            this.rLock.unlock();
        }
    }

    @Override // com.ss.bytertc.audio.device.router.IAudioRouteCallback
    public void onError(int eventCode, String info) {
        this.rLock.lock();
        try {
            if (this.nativeAudioRouteControllerPtr == 0) {
                return;
            }
            RXLogging.e(TAG, "AudioRouteController: ERROR-" + eventCode + Constants.COLON_SEPARATOR + info);
            if (eventCode == EVENT_SCO_FAILED_FORCE_TO_MEDIA_MODE) {
                onError(this.nativeAudioRouteControllerPtr, eventCode);
            }
        } finally {
            this.rLock.unlock();
        }
    }
}
