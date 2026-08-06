package com.ss.ttm.player.UnifiedCodec.statistics;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes7.dex */
public class MediaCodecStatistics {
    private boolean mEnableReuse;
    private boolean mIsReuse;
    private long mLastCodecFuncMs;
    private boolean mSetIsReuse;
    private String mCacheResultData = "";
    private final Map<String, Long> mStatisticsMap = new HashMap();
    private boolean mIsVideo = true;

    public final void setIsVideo(boolean isVideo) {
        this.mIsVideo = isVideo;
    }

    private final void setIsReuse(boolean reuse) {
        this.mIsReuse = reuse;
        this.mSetIsReuse = true;
    }

    private final void setEnableReuse(boolean enable) {
        this.mEnableReuse = enable;
    }

    public final void configCodecEnd(boolean isReused) {
        setIsReuse(isReused);
        this.mStatisticsMap.put("CfgCodec", Long.valueOf(System.currentTimeMillis() - this.mLastCodecFuncMs));
    }

    public final void configCodecStart(boolean reuseEnable) {
        setEnableReuse(reuseEnable);
        this.mLastCodecFuncMs = System.currentTimeMillis();
    }

    public final void createByCodecEnd() {
        this.mStatisticsMap.put("CCodec", Long.valueOf(System.currentTimeMillis() - this.mLastCodecFuncMs));
    }

    public final void createByCodecStart() {
        this.mCacheResultData = "";
        this.mStatisticsMap.clear();
        this.mLastCodecFuncMs = System.currentTimeMillis();
    }

    public final String getData() {
        return this.mCacheResultData;
    }

    public final void startCodecEnd() {
        this.mStatisticsMap.put("SCodec", Long.valueOf(System.currentTimeMillis() - this.mLastCodecFuncMs));
    }

    public final void startCodecStart() {
        this.mLastCodecFuncMs = System.currentTimeMillis();
    }
}
