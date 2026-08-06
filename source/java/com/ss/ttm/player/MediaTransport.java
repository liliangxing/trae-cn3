package com.ss.ttm.player;

import java.nio.ByteBuffer;

/* loaded from: classes7.dex */
public abstract class MediaTransport extends NativeObject {
    public static final int FILTER_AUDIO = 2;
    public static final int FILTER_VIDEO = 1;

    private native void nativeSetFilterType(int filterType);

    protected abstract void sendPacket(MediaPacket packet);

    /* loaded from: classes7.dex */
    public static class MediaPacket {
        public static final int CODEC_ID_AAC = 2;
        public static final int CODEC_ID_BYTE_VC1 = 1;
        public static final int CODEC_ID_H264 = 0;
        public static final int FLAG_CONFIG_FRAME = 1;
        public static final int FLAG_IS_DECODED_ONLY = 3;
        public static final int FLAG_KEY_FRAME = 2;
        public ByteBuffer mBuffer;
        public int mCodecId;
        public int mFlags;
        public boolean mIsAccessUnit;
        public boolean mIsVideo;
        public int mOffset;
        public long mPresentationTimeMs;
        public int mSize;

        public void set(ByteBuffer buffer, boolean isVideo, boolean isAccessUnit, int offset, int size, long presentationTimeUs, int flag, int codecId) {
            this.mBuffer = buffer;
            this.mOffset = offset;
            this.mSize = size;
            this.mPresentationTimeMs = presentationTimeUs;
            this.mFlags = flag;
            this.mIsVideo = isVideo;
            this.mCodecId = codecId;
            this.mIsAccessUnit = isAccessUnit;
        }
    }

    public void setFilterType(int filterType) {
        nativeSetFilterType(filterType);
    }
}
