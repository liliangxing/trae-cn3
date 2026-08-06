package com.ss.bytertc.audio.device.hwearback;

import com.bytedance.realx.base.ContextUtils;
import com.hihonor.android.magicx.media.audio.interfaces.HnAudioClient;
import com.hihonor.android.magicx.media.audio.interfaces.IAudioServiceCallback;
import com.huawei.multimedia.audiokit.interfaces.HwAudioKit;

/* loaded from: classes7.dex */
public class HardwareEarbackPackageChecker {
    public static boolean isHwEarbackPackageSupported() {
        HwAudioKit hwAudioKit = null;
        try {
            hwAudioKit = new HwAudioKit(ContextUtils.getApplicationContext(), null);
        } catch (NoClassDefFoundError unused) {
        }
        return hwAudioKit != null;
    }

    public static boolean isHnEarbackPackageSupported() {
        boolean z;
        HnAudioClient hnAudioClient = null;
        try {
            z = HnAudioClient.isDeviceSupported(ContextUtils.getApplicationContext());
            if (z) {
                try {
                    hnAudioClient = new HnAudioClient(ContextUtils.getApplicationContext(), (IAudioServiceCallback) null);
                } catch (NoClassDefFoundError unused) {
                }
            }
        } catch (NoClassDefFoundError unused2) {
            z = false;
        }
        return z && hnAudioClient != null;
    }
}
