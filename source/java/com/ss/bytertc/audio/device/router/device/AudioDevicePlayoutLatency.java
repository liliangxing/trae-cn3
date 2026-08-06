package com.ss.bytertc.audio.device.router.device;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;
import android.os.Build;
import android.util.Log;
import com.bytedance.realx.base.RXLogging;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes7.dex */
public class AudioDevicePlayoutLatency {
    private static final String TAG = "AudioDevicePlayoutLatency";
    private AudioTrack mAudioTrack = null;
    private int performanceMode = 2;
    private int playoutChannel = 4;

    AudioDevicePlayoutLatency() {
        RXLogging.e(TAG, "AudioDevicePlayoutLatency Created");
    }

    public int getPlayoutLatency(int mSampleRate, int channel, int perfMode) {
        if (mSampleRate != 8000 && mSampleRate != 16000 && mSampleRate != 32000 && mSampleRate != 44100 && mSampleRate != 48000) {
            return 0;
        }
        if (perfMode == 1) {
            this.performanceMode = 1;
        } else if (perfMode == 3) {
            this.performanceMode = 2;
        } else {
            this.performanceMode = 1;
        }
        if (channel == 1) {
            this.playoutChannel = 4;
        } else if (channel == 2) {
            this.playoutChannel = 12;
        } else {
            this.playoutChannel = 4;
        }
        int ceil = ((int) Math.ceil(mSampleRate / 200.0d)) * 2 * channel;
        if (ceil <= 0) {
            return 0;
        }
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                this.mAudioTrack = new AudioTrack.Builder().setAudioAttributes(new AudioAttributes.Builder().setUsage(1).setContentType(2).setLegacyStreamType(3).build()).setAudioFormat(new AudioFormat.Builder().setEncoding(2).setSampleRate(mSampleRate).setChannelMask(this.playoutChannel).build()).setTransferMode(1).setBufferSizeInBytes(ceil).setPerformanceMode(this.performanceMode).build();
            } else {
                this.mAudioTrack = new AudioTrack(3, mSampleRate, this.playoutChannel, 2, ceil, 1);
            }
            AudioTrack audioTrack = this.mAudioTrack;
            if (audioTrack == null) {
                return 0;
            }
            try {
                Method declaredMethod = audioTrack.getClass().getDeclaredMethod("getLatency", new Class[0]);
                declaredMethod.setAccessible(true);
                try {
                    int max = Math.max(((Integer) declaredMethod.invoke(this.mAudioTrack, new Object[0])).intValue(), 0);
                    this.mAudioTrack.release();
                    Log.d(TAG, "play out latency:" + max);
                    return max;
                } catch (IllegalAccessException unused) {
                    this.mAudioTrack.release();
                    return 0;
                } catch (InvocationTargetException unused2) {
                    this.mAudioTrack.release();
                    return 0;
                }
            } catch (NoSuchMethodException unused3) {
                this.mAudioTrack.release();
                return 0;
            }
        } catch (Exception unused4) {
        }
    }
}
