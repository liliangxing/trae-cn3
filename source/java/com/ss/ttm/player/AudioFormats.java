package com.ss.ttm.player;

import android.media.audiofx.AudioEffect;
import com.bytedance.vcloud.strategy.StrategyCenter;

/* loaded from: classes7.dex */
public class AudioFormats {
    private static final int[] validSampleRates = {4000, 8000, 11025, 16000, 22050, 32000, 37800, 44056, 44100, 47250, 48000, StrategyCenter.GLOBAL_OPTION_START, 50400, 88200, 96000, 176400, 192000, 352800, 2822400, 5644800};
    private static boolean sDetectDlbDevices = false;
    private static boolean sDlbDevice = false;

    public static int getDefaultSampleRatesNB() {
        return validSampleRates.length;
    }

    public static int getMaxSupportedSampleRates(int[] sampleRate) {
        int length = validSampleRates.length - 3;
        for (int i = 0; i < length; i++) {
            sampleRate[i] = validSampleRates[i];
        }
        return length;
    }

    public static boolean isLicencedDolbyDevice() {
        if (sDetectDlbDevices) {
            return sDlbDevice;
        }
        AudioEffect.Descriptor[] queryEffects = AudioEffect.queryEffects();
        int length = queryEffects.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            if (queryEffects[i].implementor.contains("Dolby Laboratories")) {
                sDlbDevice = true;
                break;
            }
            i++;
        }
        sDetectDlbDevices = true;
        return sDlbDevice;
    }
}
