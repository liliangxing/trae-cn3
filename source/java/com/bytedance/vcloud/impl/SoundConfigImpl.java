package com.bytedance.vcloud.impl;

import com.bytedance.push.settings.pull.PullSettingsModel;
import com.bytedance.vcloud.uniplayer.InstFltKey;
import com.bytedance.vcloud.uniplayer.InstIntKey;
import com.bytedance.vcloud.uniplayer.SoundConfig;
import com.bytedance.vcloud.uniplayer.UniInstConfig;
import kotlin.Metadata;

/* compiled from: SoundPoolImpl.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u0001H\u0016J\r\u0010\u000f\u001a\u00020\nH\u0000¢\u0006\u0002\b\u0010J\u0010\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0003H\u0016J\u0010\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\rH\u0016J\u0010\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u0015H\u0016J\u0010\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u0015H\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/bytedance/vcloud/impl/SoundConfigImpl;", "Lcom/bytedance/vcloud/uniplayer/SoundConfig;", "mReuse", "", "(Z)V", "mConfig", "Lcom/bytedance/vcloud/uniplayer/UniInstConfig;", "getMConfig$uniplayer_release", "()Lcom/bytedance/vcloud/uniplayer/UniInstConfig;", "close", "", "enablePosUpdate", "intervalMs", "", "enableSeek", "markUsed", "markUsed$uniplayer_release", "setLoop", PullSettingsModel.SCENE_LOOP, "setSpeed", "speed", "", "setStartPos", "posMs", "setTargetLufs", "targetLufs", "setVolume", "volume", "uniplayer_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class SoundConfigImpl implements SoundConfig {
    private final UniInstConfig mConfig;
    private final boolean mReuse;

    public SoundConfigImpl(boolean z) {
        this.mReuse = z;
        UniInstConfig create = UniInstConfig.INSTANCE.create();
        this.mConfig = create;
        create.setIntValue(InstIntKey.SOUND_CONFIG_REUSE, z ? 1 : 0);
        create.setIntValue(InstIntKey.POSITION_UPDATE_INTERVAL, -1);
        create.setIntValue(InstIntKey.PLAYBACK_DISABLE_SEEK, 1);
    }

    /* renamed from: getMConfig$uniplayer_release, reason: from getter */
    public final UniInstConfig getMConfig() {
        return this.mConfig;
    }

    @Override // com.bytedance.vcloud.uniplayer.SoundConfig
    public SoundConfig setLoop(boolean loop) {
        this.mConfig.setIntValue(InstIntKey.PLAYBACK_LOOP, loop ? 1 : 0);
        return this;
    }

    @Override // com.bytedance.vcloud.uniplayer.SoundConfig
    public SoundConfig setVolume(float volume) {
        this.mConfig.setFloatValue(InstFltKey.AUDIO_VOLUME_FLT, volume);
        return this;
    }

    @Override // com.bytedance.vcloud.uniplayer.SoundConfig
    public SoundConfig setSpeed(float speed) {
        this.mConfig.setFloatValue(InstFltKey.PLAYBACK_SPEED_FLT, speed);
        return this;
    }

    @Override // com.bytedance.vcloud.uniplayer.SoundConfig
    public SoundConfig setStartPos(long posMs) {
        this.mConfig.setIntValue(InstIntKey.START_PLAY_TIME_MS, (int) posMs);
        return this;
    }

    @Override // com.bytedance.vcloud.uniplayer.SoundConfig
    public SoundConfig enablePosUpdate(long intervalMs) {
        this.mConfig.setIntValue(InstIntKey.POSITION_UPDATE_INTERVAL, (int) intervalMs);
        return this;
    }

    @Override // com.bytedance.vcloud.uniplayer.SoundConfig
    public SoundConfig enableSeek() {
        this.mConfig.setIntValue(InstIntKey.PLAYBACK_DISABLE_SEEK, 0);
        return this;
    }

    @Override // com.bytedance.vcloud.uniplayer.SoundConfig
    public SoundConfig setTargetLufs(float targetLufs) {
        this.mConfig.setFloatValue(InstFltKey.AE_TARGET_LOUDNESS, targetLufs);
        this.mConfig.setIntValue(InstIntKey.ENABLE_AUDIO_EFFECT, 1);
        this.mConfig.setIntValue(InstIntKey.AUDIO_EFFECT_TYPE, 1);
        return this;
    }

    @Override // com.bytedance.vcloud.uniplayer.SoundConfig, java.lang.AutoCloseable
    public void close() {
        this.mConfig.close();
    }

    public final void markUsed$uniplayer_release() {
        if (this.mReuse) {
            return;
        }
        this.mConfig.close();
    }
}
