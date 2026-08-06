package com.bytedance.vcloud.impl;

import com.bytedance.vcloud.uniplayer.UniInstConfig;
import com.bytedance.vcloud.uniplayer.VideoModel;
import kotlin.Metadata;

/* compiled from: SoundPoolImpl.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0000\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\u001a\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\u0018\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\tH&J\u0018\u0010\u0016\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0018H&¨\u0006\u0019"}, d2 = {"Lcom/bytedance/vcloud/impl/SoundPoolBridge;", "", "attachCallback", "", "callback", "Lcom/bytedance/vcloud/impl/SoundPoolCallbackBridge;", "clearAll", "close", "getCurrentPos", "", "soundId", "", "load", "videoModel", "Lcom/bytedance/vcloud/uniplayer/VideoModel;", "instConfig", "Lcom/bytedance/vcloud/uniplayer/UniInstConfig;", "pause", "play", "release", "seek", "positionMs", "setVolume", "volume", "", "uniplayer_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public interface SoundPoolBridge {
    void attachCallback(SoundPoolCallbackBridge callback);

    void clearAll();

    void close();

    long getCurrentPos(int soundId);

    int load(VideoModel videoModel, UniInstConfig instConfig);

    void pause(int soundId);

    void play(int soundId);

    void release(int soundId);

    int seek(int soundId, long positionMs);

    void setVolume(int soundId, float volume);
}
