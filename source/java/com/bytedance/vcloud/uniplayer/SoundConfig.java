package com.bytedance.vcloud.uniplayer;

import com.bytedance.push.settings.pull.PullSettingsModel;
import kotlin.Metadata;

/* compiled from: SoundPool.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\u0000H&J\u0010\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\u000b\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\rH&J\u0010\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0006H&J\u0010\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\rH&J\u0010\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\rH&¨\u0006\u0014"}, d2 = {"Lcom/bytedance/vcloud/uniplayer/SoundConfig;", "Ljava/lang/AutoCloseable;", "close", "", "enablePosUpdate", "intervalMs", "", "enableSeek", "setLoop", PullSettingsModel.SCENE_LOOP, "", "setSpeed", "speed", "", "setStartPos", "posMs", "setTargetLufs", "targetLufs", "setVolume", "volume", "uniplayer_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes6.dex */
public interface SoundConfig extends AutoCloseable {
    @Override // java.lang.AutoCloseable
    void close();

    SoundConfig enablePosUpdate(long intervalMs);

    SoundConfig enableSeek();

    SoundConfig setLoop(boolean loop);

    SoundConfig setSpeed(float speed);

    SoundConfig setStartPos(long posMs);

    SoundConfig setTargetLufs(float targetLufs);

    SoundConfig setVolume(float volume);
}
