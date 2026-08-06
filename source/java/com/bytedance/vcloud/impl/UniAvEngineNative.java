package com.bytedance.vcloud.impl;

import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.vcloud.uniplayer.SeekMode;
import kotlin.Metadata;

/* compiled from: UniInternal.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H&J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\fH&J\u0018\u0010\u000f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u0005H&J\u0018\u0010\u0010\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bH&J\b\u0010\u0011\u001a\u00020\u0005H&J\b\u0010\u0012\u001a\u00020\u0013H&J\b\u0010\u0014\u001a\u00020\u0003H&J\b\u0010\u0015\u001a\u00020\u0003H&J\b\u0010\u0016\u001a\u00020\u0003H&J\u0018\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u001aH&J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u0013H&J\b\u0010\u001d\u001a\u00020\u0005H&¨\u0006\u001e"}, d2 = {"Lcom/bytedance/vcloud/impl/UniAvEngineNative;", "", "close", "", "currentPosition", "", "doExecute", StrategyConstants.ACTION, "", "arg1", "arg2", "getFloatValue", "", "key", "defaultValue", "getInt64Value", "getIntValue", "getNative", "isPlaying", "", "pause", "play", "prepare", "seek", "seekTimeMs", "seekMode", "Lcom/bytedance/vcloud/uniplayer/SeekMode;", "stop", "savePosition", "watchedDuration", "uniplayer_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes6.dex */
public interface UniAvEngineNative {
    void close();

    long currentPosition();

    void doExecute(int action, long arg1, long arg2);

    float getFloatValue(int key, float defaultValue);

    long getInt64Value(int key, long defaultValue);

    int getIntValue(int key, int defaultValue);

    long getNative();

    boolean isPlaying();

    void pause();

    void play();

    void prepare();

    int seek(long seekTimeMs, SeekMode seekMode);

    void stop(boolean savePosition);

    long watchedDuration();
}
