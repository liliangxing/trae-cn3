package com.ss.bytertc.engine.data;

/* loaded from: classes7.dex */
public enum AudioPlaybackDevice {
    AUDIO_PLAYBACK_DEVICE_HEADSET(1),
    AUDIO_PLAYBACK_DEVICE_EARPIECE(2),
    AUDIO_PLAYBACK_DEVICE_SPEAKERPHONE(3),
    AUDIO_PLAYBACK_DEVICE_HEADSET_BLUETOOTH(4),
    AUDIO_PLAYBACK_DEVICE_HEADSET_USB(5);

    private int value;

    AudioPlaybackDevice(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    /* renamed from: com.ss.bytertc.engine.data.AudioPlaybackDevice$1, reason: invalid class name */
    /* loaded from: classes7.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$engine$data$AudioPlaybackDevice;

        static {
            int[] iArr = new int[AudioPlaybackDevice.values().length];
            $SwitchMap$com$ss$bytertc$engine$data$AudioPlaybackDevice = iArr;
            try {
                iArr[AudioPlaybackDevice.AUDIO_PLAYBACK_DEVICE_SPEAKERPHONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$data$AudioPlaybackDevice[AudioPlaybackDevice.AUDIO_PLAYBACK_DEVICE_EARPIECE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$data$AudioPlaybackDevice[AudioPlaybackDevice.AUDIO_PLAYBACK_DEVICE_HEADSET.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$data$AudioPlaybackDevice[AudioPlaybackDevice.AUDIO_PLAYBACK_DEVICE_HEADSET_BLUETOOTH.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$data$AudioPlaybackDevice[AudioPlaybackDevice.AUDIO_PLAYBACK_DEVICE_HEADSET_USB.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    @Override // java.lang.Enum
    public String toString() {
        int i = AnonymousClass1.$SwitchMap$com$ss$bytertc$engine$data$AudioPlaybackDevice[ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? "" : "kAudioPlaybackDeviceHeadsetUSB" : "kAudioPlaybackDeviceHeadsetBluetooth" : "kAudioPlaybackDeviceHeadset" : "kAudioPlaybackDeviceEarpiece" : "kAudioPlaybackDeviceSpeakerphone";
    }

    public static AudioPlaybackDevice fromId(int id) {
        for (AudioPlaybackDevice audioPlaybackDevice : values()) {
            if (audioPlaybackDevice.value() == id) {
                return audioPlaybackDevice;
            }
        }
        return null;
    }
}
