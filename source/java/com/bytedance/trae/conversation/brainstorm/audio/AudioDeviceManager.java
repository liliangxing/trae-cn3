package com.bytedance.trae.conversation.brainstorm.audio;

import android.content.Context;
import android.media.AudioManager;
import android.util.Log;
import com.bytedance.trae.conversation.brainstorm.model.AudioDevice;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AudioDeviceManager.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/audio/AudioDeviceManager;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "audioManager", "Landroid/media/AudioManager;", "init", "", "release", "switchToDevice", "device", "Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice;", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AudioDeviceManager {
    private static final String TAG = "AudioDeviceManager";
    private final AudioManager audioManager;
    private final Context context;

    /* compiled from: AudioDeviceManager.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AudioDevice.values().length];
            try {
                iArr[AudioDevice.Speaker.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AudioDevice.Earpiece.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public AudioDeviceManager(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        Object systemService = context.getSystemService("audio");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
        this.audioManager = (AudioManager) systemService;
    }

    public final void init() {
        Log.d(TAG, "init: AudioDeviceManager initialized (speaker/earpiece only)");
    }

    public final void release() {
        Log.d(TAG, "release: AudioDeviceManager released");
    }

    public final void switchToDevice(AudioDevice device) {
        Intrinsics.checkNotNullParameter(device, "device");
        Log.d(TAG, "switchToDevice: target=" + device);
        int i = WhenMappings.$EnumSwitchMapping$0[device.ordinal()];
        if (i == 1) {
            this.audioManager.setMode(0);
            this.audioManager.setSpeakerphoneOn(true);
            Log.d(TAG, "switchToDevice: routed to Speaker");
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            this.audioManager.setMode(3);
            this.audioManager.setSpeakerphoneOn(false);
            Log.d(TAG, "switchToDevice: routed to Earpiece");
        }
    }
}
