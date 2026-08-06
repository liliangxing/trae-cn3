package com.huawei.multimedia.audiokit.interfaces;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import com.huawei.multimedia.audiokit.utils.LogUtils;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes6.dex */
public class EnhancedDeviceInfo {
    private static final int BLUETOOTH_A2DP_FB_RECORDING = 10005;
    private static final String TAG = "HwAudioKit.EnhancedDeviceInfo";
    private static BluetoothAdapter mBluetoothAdapter;
    private static BluetoothDevice mBluetoothDevice;
    private AudioManager mAudioManager = null;
    private Context mContext;
    private int mDeviceType;
    private static final Object LOCK_ISKARAOKE_SUPPORTED = new Object();
    private static final Object LOCK_ISFULLBAND_RECORD_SUPPORTED = new Object();

    public EnhancedDeviceInfo(Context context, int i) {
        this.mContext = context;
        this.mDeviceType = i;
    }

    public boolean isFullbandRecordSupported() {
        boolean z;
        synchronized (LOCK_ISFULLBAND_RECORD_SUPPORTED) {
            int i = this.mDeviceType;
            if (i != 3) {
                z = false;
                if (i != 4) {
                    if (i == 8) {
                        createAudioManager();
                        z = getBluetoothFBEnable(this.mAudioManager);
                    } else if (i != 11 && i != 22) {
                    }
                }
                LogUtils.info(TAG, "mDeviceType=" + this.mDeviceType + ",isFbRecordSupported=" + z);
            }
            z = true;
            LogUtils.info(TAG, "mDeviceType=" + this.mDeviceType + ",isFbRecordSupported=" + z);
        }
        return z;
    }

    public boolean isKaraokeSupported() {
        boolean z;
        synchronized (LOCK_ISKARAOKE_SUPPORTED) {
            int i = this.mDeviceType;
            if (i != 3 && i != 4) {
                if (i == 8) {
                    createAudioManager();
                    z = getBluetoothFBEnable(this.mAudioManager);
                } else if (i != 11 && i != 22) {
                    z = false;
                }
                LogUtils.info(TAG, "mDeviceType=" + this.mDeviceType + ",isDeviceSupported=" + z);
            }
            z = true;
            LogUtils.info(TAG, "mDeviceType=" + this.mDeviceType + ",isDeviceSupported=" + z);
        }
        return z;
    }

    public static boolean getBluetoothFBEnable(AudioManager audioManager) {
        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        AudioDeviceInfo[] audioDeviceInfoArr = new AudioDeviceInfo[0];
        if (audioManager != null) {
            audioDeviceInfoArr = audioManager.getDevices(2);
        }
        for (AudioDeviceInfo audioDeviceInfo : audioDeviceInfoArr) {
            if (audioDeviceInfo.getType() == 8) {
                mBluetoothDevice = mBluetoothAdapter.getRemoteDevice(audioDeviceInfo.getAddress());
            }
        }
        if (mBluetoothDevice == null) {
            return false;
        }
        return isBluetoothFBRecording();
    }

    private static boolean isBluetoothFBRecording() {
        boolean z = false;
        try {
            Object invoke = BluetoothDevice.class.getMethod("getMetadata", Integer.TYPE).invoke(mBluetoothDevice, 10005);
            if (!(invoke instanceof byte[])) {
                return false;
            }
            byte[] bArr = (byte[]) invoke;
            if (bArr.length <= 0) {
                return false;
            }
            boolean z2 = bArr[0] != 0;
            try {
                LogUtils.info(TAG, "isBluetoothFBRecording byteArray[0]=" + ((int) bArr[0]));
                return z2;
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused) {
                z = z2;
                LogUtils.error(TAG, "isBluetoothFBRecording Exception");
                return z;
            } catch (NoSuchMethodException unused2) {
                z = z2;
                LogUtils.error(TAG, "No Such Method getMetadata");
                return z;
            }
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused3) {
        } catch (NoSuchMethodException unused4) {
        }
    }

    private void createAudioManager() {
        if (this.mAudioManager == null) {
            Object systemService = this.mContext.getSystemService("audio");
            if (systemService instanceof AudioManager) {
                this.mAudioManager = (AudioManager) systemService;
            }
        }
    }
}
