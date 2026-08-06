package com.ss.bytertc.audio.device.router.device;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.media.AudioManager;
import com.bytedance.ies.bullet.service.router.RouterConstants;

/* loaded from: classes7.dex */
public class KaraokeMediaHelper {
    private AudioManager mAudioManager;
    private ContentResolver mContentResolver;
    private Context mContext;
    private int mEnabled;
    private int mEqMode;
    private int mReverbMode;
    private SharedPreferences mSp;
    private int mVolume;
    private final String KARAOKE_ENABLE = "audio_karaoke_enable";
    private final String KARAOKE_VOLUME = "audio_karaoke_volume";
    private final String KARAOKE_EQ = "audio_karaoke_EQ";
    private final String KARAOKE_REVERB = "karaoke_Reverb";
    private final String KARAOKE_SUPPORT = "audio_karaoke_support";
    private final String KARAOKE_APP_SUPPORT = "karaoke_app_support";
    private final String KARAOKE_KTVMODE = "audio_karaoke_ktvmode";
    private final int VOLUME_MAX_APP = 15;
    private final int VOLUME_MIN_APP = 0;
    private boolean mInitialized = false;

    public KaraokeMediaHelper(Context context) {
        this.mContext = context;
        this.mContentResolver = context.getContentResolver();
        this.mAudioManager = (AudioManager) this.mContext.getSystemService("audio");
        this.mSp = this.mContext.getSharedPreferences("loopback_mode", 0);
    }

    public static KaraokeMediaHelper getInstance(Context context) {
        return new KaraokeMediaHelper(context);
    }

    public boolean isDeviceSupportKaraoke() {
        return this.mAudioManager.getParameters("audio_karaoke_support").contains(RouterConstants.TRUE);
    }

    public boolean isAppSupportKaraoke(String appName) {
        return this.mAudioManager.getParameters("karaoke_app_support:" + appName).contains(RouterConstants.TRUE);
    }

    public void openKTVDevice() {
        if (this.mInitialized) {
            return;
        }
        this.mVolume = this.mSp.getInt("audio_karaoke_volume", 50);
        this.mEqMode = this.mSp.getInt("audio_karaoke_EQ", 0);
        this.mReverbMode = this.mSp.getInt("karaoke_Reverb", 0);
        this.mAudioManager.setParameters("audio_karaoke_ktvmode=enable");
        this.mAudioManager.setParameters("audio_karaoke_volume=" + this.mVolume);
        this.mAudioManager.setParameters("audio_karaoke_EQ=" + this.mEqMode);
        this.mAudioManager.setParameters("karaoke_Reverb=" + this.mReverbMode);
        this.mInitialized = true;
    }

    public void closeKTVDevice() {
        this.mAudioManager.setParameters("audio_karaoke_ktvmode=disable");
        this.mInitialized = false;
    }

    public void setMicVolParam(int param) {
        if (param > 15) {
            param = 15;
        }
        if (param < 0) {
            param = 0;
        }
        if (this.mVolume == param || !isEnable()) {
            return;
        }
        this.mAudioManager.setParameters("audio_karaoke_volume=" + param);
        this.mVolume = param;
    }

    public int getMicVolParam() {
        return this.mVolume;
    }

    public void setPlayFeedbackParam(int enabled) {
        if (this.mEnabled == enabled) {
            return;
        }
        this.mEnabled = enabled;
        this.mAudioManager.setParameters("audio_karaoke_enable=" + enabled);
    }

    public int getPlayFeedbackParam() {
        return isEnable() ? 1 : 0;
    }

    public void setFeedbackEffect(int revertMode) {
        if (revertMode <= 0 || revertMode > 3 || this.mReverbMode == revertMode) {
            return;
        }
        this.mAudioManager.setParameters("karaoke_Reverb=" + revertMode);
        this.mReverbMode = revertMode;
    }

    public boolean isEnable() {
        return this.mEnabled == 1;
    }
}
