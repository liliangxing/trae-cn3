package com.ss.bytertc.audio.device.webrtc;

import android.os.Build;
import android.util.Log;
import com.bytedance.realx.base.ContextUtils;
import com.bytedance.realx.base.RXLogging;
import com.ss.bytertc.audio.device.base.ManufacturerChecker;
import com.ss.bytertc.audio.device.hwearback.HardwareEarbackPackageChecker;
import com.ss.bytertc.audio.device.hwearback.HnEarback;
import com.ss.bytertc.audio.device.hwearback.HwEarback;
import com.ss.bytertc.audio.device.hwearback.IHardWareEarback;
import com.ss.bytertc.audio.device.hwearback.VivoEarback;
import com.ss.bytertc.audio.device.hwearback.XMEarback;
import com.ss.bytertc.audio.device.hwearback.ovm.OVMEarback;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class WebRtcAudioEarBack {
    private WebRtcAudioManager audioManager;
    IHardWareEarback hardWareEarback;
    private int curVolume = -1;
    private int curEffect = -1;
    private int curEq = -1;

    public void ByteAudioEarBackInit() {
        if (this.hardWareEarback == null) {
            ManufacturerChecker.Type manufacturerType = ManufacturerChecker.getManufacturerType(Build.BRAND);
            if (manufacturerType == ManufacturerChecker.Type.HW || manufacturerType == ManufacturerChecker.Type.HR) {
                this.hardWareEarback = createHWEarback();
            }
            if (Build.VERSION.SDK_INT >= 33 && (manufacturerType == ManufacturerChecker.Type.OP || manufacturerType == ManufacturerChecker.Type.XM || manufacturerType == ManufacturerChecker.Type.RM)) {
                this.hardWareEarback = new OVMEarback(ContextUtils.getApplicationContext(), this);
            } else if (manufacturerType == ManufacturerChecker.Type.VO) {
                this.hardWareEarback = new VivoEarback(this);
            } else if (manufacturerType == ManufacturerChecker.Type.XM) {
                this.hardWareEarback = new XMEarback(this);
            }
        }
        IHardWareEarback iHardWareEarback = this.hardWareEarback;
        if (iHardWareEarback != null) {
            iHardWareEarback.init();
        } else {
            onHardwareEarbackSupported(false);
        }
    }

    private IHardWareEarback createHWEarback() {
        if (HardwareEarbackPackageChecker.isHnEarbackPackageSupported()) {
            HnEarback hnEarback = new HnEarback(this);
            Log.e("HardWareEarback", "Honor");
            return hnEarback;
        }
        if (!HardwareEarbackPackageChecker.isHwEarbackPackageSupported()) {
            return null;
        }
        HwEarback hwEarback = new HwEarback(this);
        Log.e("HardWareEarback", "Huawei");
        return hwEarback;
    }

    public void ByteAudioEarBackRelease() {
        IHardWareEarback iHardWareEarback = this.hardWareEarback;
        if (iHardWareEarback != null) {
            iHardWareEarback.release();
            onHardwareEarbackReleased(true);
        }
    }

    public boolean ByteAudioEarBackSupport() {
        try {
            IHardWareEarback iHardWareEarback = this.hardWareEarback;
            if (iHardWareEarback != null) {
                return iHardWareEarback.isSupport();
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            RXLogging.e("WebRtcAudioEarBack", "HW hardware earmonitor get earback is not support", th);
            return false;
        }
    }

    public int ByteAudioEarBackSetVolume(int vol) {
        try {
            this.curVolume = vol;
            IHardWareEarback iHardWareEarback = this.hardWareEarback;
            if (iHardWareEarback != null) {
                return iHardWareEarback.setVolume(vol);
            }
            return -1;
        } catch (Throwable th) {
            th.printStackTrace();
            RXLogging.e("WebRtcAudioEarBack", "HW hardware earmonitor set volume is not support", th);
            return -1;
        }
    }

    public void ByteAudioEarBackEffect(int value) {
        try {
            this.curEffect = value;
            IHardWareEarback iHardWareEarback = this.hardWareEarback;
            if (iHardWareEarback != null) {
                iHardWareEarback.setEffect(value);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            RXLogging.e("WebRtcAudioEarBack", "HW hardware earmonitor set effect is not support", th);
        }
    }

    public void ByteAudioEarBackEqualizer(int value) {
        try {
            this.curEq = value;
            IHardWareEarback iHardWareEarback = this.hardWareEarback;
            if (iHardWareEarback != null) {
                iHardWareEarback.setEqualizer(value);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            RXLogging.e("WebRtcAudioEarBack", "HW hardware earmonitor set eq is not support", th);
        }
    }

    public int ByteAudioEarBackEnable(boolean enable) {
        Throwable th;
        int i;
        IHardWareEarback iHardWareEarback;
        try {
            iHardWareEarback = this.hardWareEarback;
        } catch (Throwable th2) {
            th = th2;
            i = -1;
        }
        if (iHardWareEarback == null) {
            return -1;
        }
        if (enable) {
            i = iHardWareEarback.open();
            try {
                int i2 = this.curVolume;
                if (i2 != -1) {
                    ByteAudioEarBackSetVolume(i2);
                }
                int i3 = this.curEq;
                if (i3 != -1) {
                    ByteAudioEarBackEqualizer(i3);
                }
                int i4 = this.curEffect;
                if (i4 != -1) {
                    ByteAudioEarBackEffect(i4);
                }
            } catch (Throwable th3) {
                th = th3;
                th.printStackTrace();
                RXLogging.e("WebRtcAudioEarBack", "HW hardware earmonitor enable earback is not support", th);
                return i;
            }
            return i;
        }
        return iHardWareEarback.close();
    }

    public int ByteAudioEarBackGetLatency() {
        try {
            IHardWareEarback iHardWareEarback = this.hardWareEarback;
            if (iHardWareEarback != null) {
                return iHardWareEarback.getLatency();
            }
            return -1;
        } catch (Throwable th) {
            th.printStackTrace();
            RXLogging.e("WebRtcAudioEarBack", "HW hardware earmonitor get latency is not support", th);
            return -1;
        }
    }

    public void onHardwareEarbackSupported(boolean isSupported) {
        WebRtcAudioManager webRtcAudioManager = this.audioManager;
        if (webRtcAudioManager != null) {
            webRtcAudioManager.onHardwareEarbackSupported(isSupported);
        }
    }

    public void onHardwareEarbackReleased(boolean success) {
        WebRtcAudioManager webRtcAudioManager = this.audioManager;
        if (webRtcAudioManager != null) {
            webRtcAudioManager.onHardwareEarbackReleased(success);
        }
    }

    public WebRtcAudioEarBack(WebRtcAudioManager webRtcAudioManager) {
        this.audioManager = webRtcAudioManager;
    }

    public void notifyEarbackRecordStateChanged(boolean recordStart) {
        IHardWareEarback iHardWareEarback = this.hardWareEarback;
        if (iHardWareEarback != null) {
            iHardWareEarback.notifyEarbackRecordStateChanged(recordStart);
        }
    }

    public void onHardwareEarbackSupportParamsGet(String params) {
        WebRtcAudioManager webRtcAudioManager = this.audioManager;
        if (webRtcAudioManager != null) {
            if (params == null) {
                params = "";
            }
            webRtcAudioManager.onHardwareEarbackSupportParamsGet(params);
        }
    }
}
