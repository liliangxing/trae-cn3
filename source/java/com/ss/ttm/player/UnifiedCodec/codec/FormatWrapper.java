package com.ss.ttm.player.UnifiedCodec.codec;

import android.media.MediaFormat;
import com.ss.ttm.player.UnifiedCodec.util.CodecUtils;
import com.ss.vcbkit.VLog;
import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: classes7.dex */
public final class FormatWrapper {
    public static final String TAG = "FormatWrapper";
    public int mChannelCount;
    private boolean mIsVideo;
    private boolean mIsVideoChecked;
    public int mRotationDegrees;
    public final String mSampleMimeType;
    public int mSampleRate;
    public ArrayList<byte[]> mInitializationData = new ArrayList<>();
    public int mMaxWidth = -1;
    public int mMaxHeight = -1;
    public int mMaxInputSize = -1;
    public int width = -1;
    public int mHeight = -1;

    public FormatWrapper(String mimeType) {
        this.mSampleMimeType = mimeType;
    }

    public static FormatWrapper create(MediaFormat mediaFormat) {
        FormatWrapper formatWrapper = new FormatWrapper(mediaFormat.getString("mime"));
        try {
            formatWrapper.mMaxInputSize = getInteger(mediaFormat, "max-input-size");
            formatWrapper.mInitializationData = CodecUtils.getCsdBuffers(mediaFormat);
            if (formatWrapper.isVideo()) {
                formatWrapper.mRotationDegrees = getInteger(mediaFormat, "rotation-degrees");
                formatWrapper.width = getInteger(mediaFormat, "width");
                formatWrapper.mHeight = getInteger(mediaFormat, "height");
                formatWrapper.mMaxWidth = getInteger(mediaFormat, "max-width");
                formatWrapper.mMaxHeight = getInteger(mediaFormat, "max-height");
            } else {
                formatWrapper.mSampleRate = getInteger(mediaFormat, com.ss.ttm.player.MediaFormat.KEY_SAMPLE_RATE);
                formatWrapper.mChannelCount = getInteger(mediaFormat, com.ss.ttm.player.MediaFormat.KEY_CHANNEL_COUNT);
            }
        } catch (Throwable th) {
            VLog.e(TAG, "create format error with exception: " + th);
        }
        return formatWrapper;
    }

    public static int getInteger(MediaFormat mediaFormat, String key) {
        return getInteger(mediaFormat, key, 0);
    }

    public final boolean initializationDataEquals(FormatWrapper formatWrapper) {
        if (this.mInitializationData.size() != formatWrapper.mInitializationData.size()) {
            return false;
        }
        for (int i = 0; i < this.mInitializationData.size(); i++) {
            if (!Arrays.equals(this.mInitializationData.get(i), formatWrapper.mInitializationData.get(i))) {
                return false;
            }
        }
        return true;
    }

    public final boolean isVideo() {
        if (!this.mIsVideoChecked) {
            this.mIsVideoChecked = true;
            this.mIsVideo = CodecUtils.isVideo(this.mSampleMimeType);
        }
        return this.mIsVideo;
    }

    public static int getInteger(MediaFormat mediaFormat, String key, int defaultValue) {
        return mediaFormat.containsKey(key) ? mediaFormat.getInteger(key) : defaultValue;
    }
}
