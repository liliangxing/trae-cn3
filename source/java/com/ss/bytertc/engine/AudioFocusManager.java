package com.ss.bytertc.engine;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;

/* loaded from: classes7.dex */
public class AudioFocusManager {
    private boolean isAudioFocusLoss = false;
    private Application.ActivityLifecycleCallbacks mActivityLifecycleCallback = new Application.ActivityLifecycleCallbacks() { // from class: com.ss.bytertc.engine.AudioFocusManager.2
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            int requestAudioFocus;
            AudioManager audioManager = AudioFocusManager.this.getAudioManager();
            if (!AudioFocusManager.this.isAudioFocusLoss || audioManager == null) {
                return;
            }
            if (Build.VERSION.SDK_INT < 26) {
                requestAudioFocus = audioManager.requestAudioFocus(AudioFocusManager.this.onAudioFocusChangeListener, 3, 1);
            } else {
                requestAudioFocus = audioManager.requestAudioFocus(new AudioFocusRequest.Builder(1).setOnAudioFocusChangeListener(AudioFocusManager.this.onAudioFocusChangeListener).build());
            }
            if (requestAudioFocus == 1) {
                AudioFocusManager.this.mCallback.startMicrophone();
                AudioFocusManager.this.mCallback.startSpeakerphone();
            }
            AudioFocusManager.this.isAudioFocusLoss = false;
        }
    };
    private AudioManager mAudioManager;
    private Callback mCallback;
    private Context mContext;
    private AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener;

    /* loaded from: classes7.dex */
    public interface Callback {
        void higherVolume();

        void lowerVolume();

        void startMicrophone();

        void startSpeakerphone();

        void stopMicrophone();

        void stopSpeakerphone();
    }

    public AudioFocusManager(Context context, Callback callback) {
        this.mContext = context;
        this.mCallback = callback;
        this.onAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener(context) { // from class: com.ss.bytertc.engine.AudioFocusManager.1
            AudioManager audioManager;
            final /* synthetic */ Context val$context;

            {
                this.val$context = context;
                this.audioManager = (AudioManager) context.getSystemService("audio");
            }

            @Override // android.media.AudioManager.OnAudioFocusChangeListener
            public void onAudioFocusChange(int focusChange) {
                if (focusChange == -2) {
                    AudioFocusManager.this.mCallback.stopSpeakerphone();
                    AudioFocusManager.this.mCallback.stopMicrophone();
                    return;
                }
                if (focusChange == 1) {
                    AudioFocusManager.this.mCallback.higherVolume();
                    AudioFocusManager.this.mCallback.startSpeakerphone();
                    AudioFocusManager.this.mCallback.startMicrophone();
                } else if (focusChange == -1) {
                    AudioFocusManager.this.mCallback.stopSpeakerphone();
                    AudioFocusManager.this.mCallback.stopMicrophone();
                    AudioFocusManager.this.releaseAudioFocus(true);
                } else if (focusChange == -3) {
                    AudioFocusManager.this.mCallback.lowerVolume();
                }
            }
        };
        Context context2 = this.mContext;
        if (context2 instanceof Application) {
            ((Application) context2).registerActivityLifecycleCallbacks(this.mActivityLifecycleCallback);
        }
    }

    public void requestAudioFocus() {
        AudioManager audioManager = getAudioManager();
        if (audioManager != null) {
            if (Build.VERSION.SDK_INT < 26) {
                audioManager.requestAudioFocus(this.onAudioFocusChangeListener, 3, 1);
            } else {
                audioManager.requestAudioFocus(new AudioFocusRequest.Builder(1).setOnAudioFocusChangeListener(this.onAudioFocusChangeListener).build());
            }
            this.isAudioFocusLoss = false;
        }
    }

    public void releaseAudioFocus() {
        releaseAudioFocus(false);
    }

    public void release() {
        Context context = this.mContext;
        if (context instanceof Application) {
            ((Application) context).unregisterActivityLifecycleCallbacks(this.mActivityLifecycleCallback);
        }
        releaseAudioFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AudioManager getAudioManager() {
        if (this.mAudioManager == null) {
            this.mAudioManager = (AudioManager) this.mContext.getApplicationContext().getSystemService("audio");
        }
        return this.mAudioManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseAudioFocus(boolean isAudioFocusLoss) {
        AudioManager audioManager = getAudioManager();
        if (audioManager != null) {
            if (Build.VERSION.SDK_INT < 26) {
                audioManager.abandonAudioFocus(this.onAudioFocusChangeListener);
            } else {
                audioManager.abandonAudioFocusRequest(new AudioFocusRequest.Builder(1).setOnAudioFocusChangeListener(this.onAudioFocusChangeListener).build());
            }
            this.isAudioFocusLoss = isAudioFocusLoss;
        }
    }
}
