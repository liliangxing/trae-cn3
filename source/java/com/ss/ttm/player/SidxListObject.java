package com.ss.ttm.player;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes7.dex */
public class SidxListObject extends NativeObject {
    private long mBitrate;
    private int mEndIndex;
    private String mFileId;
    private List<SidxItem> mItems = new ArrayList();
    private int mMediaType;
    private int mStartIndex;
    private int mTotalNum;

    /* loaded from: classes7.dex */
    public static class SidxItem {
        private long mDuration;
        private int mIndex;
        private long mOffset;
        private long mSize;
        private long mTimestamp;

        public SidxItem(int index, long offset, long timestamp, long duration, long size) {
            this.mIndex = index;
            this.mOffset = offset;
            this.mTimestamp = timestamp;
            this.mDuration = duration;
            this.mSize = size;
        }

        public int getIndex() {
            return this.mIndex;
        }

        public long getOffset() {
            return this.mOffset;
        }

        public long getTimestamp() {
            return this.mTimestamp;
        }

        public long getDuration() {
            return this.mDuration;
        }

        public long getSize() {
            return this.mSize;
        }
    }

    public SidxListObject(int mediaType, int totalNum, int startIndex, int endIndex, long bitrate, String fileId) {
        this.mMediaType = mediaType;
        this.mTotalNum = totalNum;
        this.mStartIndex = startIndex;
        this.mEndIndex = endIndex;
        this.mBitrate = bitrate;
        this.mFileId = fileId;
    }

    public void addItem(int index, long offset, long timestamp, long duration, long size) {
        this.mItems.add(new SidxItem(index, offset, timestamp, duration, size));
    }

    public int getMediaType() {
        return this.mMediaType;
    }

    public int getTotalNum() {
        return this.mTotalNum;
    }

    public int getStartIndex() {
        return this.mStartIndex;
    }

    public int getEndIndex() {
        return this.mEndIndex;
    }

    public long getBitrate() {
        return this.mBitrate;
    }

    public String getFileId() {
        return this.mFileId;
    }

    public SidxItem getItem(int index) {
        if (index < 0 || index >= this.mItems.size()) {
            return null;
        }
        return this.mItems.get(index);
    }
}
