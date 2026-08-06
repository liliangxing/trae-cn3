package com.ss.android.socialbase.downloader.segment;

import com.ss.android.socialbase.downloader.logger.Logger;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public final class Segment {
    private static final String TAG = "Segment";
    int competitor;
    private final AtomicLong currentOffset;
    private volatile long currentOffsetRead;
    private long endOffset;
    private int index;
    private JSONObject jsonObject;
    volatile SegmentReader owner;
    private final long startOffset;

    /* loaded from: classes7.dex */
    interface JsonKey {
        public static final String CURRENT = "cu";
        public static final String END = "en";
        public static final String START = "st";
    }

    public Segment(long j) {
        this(j, -1L);
    }

    public Segment(long j, long j2) {
        AtomicLong atomicLong = new AtomicLong();
        this.currentOffset = atomicLong;
        this.competitor = 0;
        this.startOffset = j;
        atomicLong.set(j);
        this.currentOffsetRead = j;
        if (j2 >= j) {
            this.endOffset = j2;
        } else {
            this.endOffset = -1L;
        }
    }

    public Segment(Segment segment) {
        AtomicLong atomicLong = new AtomicLong();
        this.currentOffset = atomicLong;
        this.competitor = 0;
        this.startOffset = segment.startOffset;
        this.endOffset = segment.endOffset;
        atomicLong.set(segment.currentOffset.get());
        this.currentOffsetRead = atomicLong.get();
        this.index = segment.index;
    }

    public Segment(JSONObject jSONObject) {
        this.currentOffset = new AtomicLong();
        this.competitor = 0;
        this.startOffset = jSONObject.optLong(JsonKey.START);
        setEndOffset(jSONObject.optLong("en"));
        setCurrentOffset(jSONObject.optLong(JsonKey.CURRENT));
        setCurrentOffsetRead(getCurrentOffset());
    }

    public boolean isDownloaded() {
        return this.endOffset >= this.startOffset && this.currentOffset.get() > this.endOffset;
    }

    public long getDownloadBytes() {
        return this.currentOffset.get() - this.startOffset;
    }

    public long getRemainDownloadBytes() {
        long j = this.endOffset;
        if (j >= this.startOffset) {
            return (j - this.currentOffset.get()) + 1;
        }
        return -1L;
    }

    public boolean isReadFinish() {
        return this.endOffset >= this.startOffset && getCurrentOffsetRead() > this.endOffset;
    }

    public long getReadBytes() {
        return getCurrentOffsetRead() - this.startOffset;
    }

    public long getRemainReadBytes() {
        long j = this.endOffset;
        if (j >= this.startOffset) {
            return (j - getCurrentOffsetRead()) + 1;
        }
        return -1L;
    }

    public long getStartOffset() {
        return this.startOffset;
    }

    public long getCurrentOffset() {
        long j = this.currentOffset.get();
        long j2 = this.endOffset;
        if (j2 > 0) {
            long j3 = j2 + 1;
            if (j > j3) {
                return j3;
            }
        }
        return j;
    }

    public long getCurrentOffsetRead() {
        SegmentReader segmentReader = this.owner;
        if (segmentReader != null) {
            long curSegmentReadOffset = segmentReader.getCurSegmentReadOffset();
            if (curSegmentReadOffset > this.currentOffsetRead) {
                return curSegmentReadOffset;
            }
        }
        return this.currentOffsetRead;
    }

    public void setCurrentOffset(long j) {
        long j2 = this.startOffset;
        if (j < j2) {
            j = j2;
        }
        long j3 = this.endOffset;
        if (j3 > 0) {
            long j4 = j3 + 1;
            if (j > j4) {
                j = j4;
            }
        }
        this.currentOffset.set(j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void increaseCurrentOffset(long j) {
        this.currentOffset.addAndGet(j);
    }

    public long getEndOffset() {
        return this.endOffset;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setEndOffset(long j) {
        if (j >= this.startOffset) {
            this.endOffset = j;
            return;
        }
        if (Logger.debug()) {
            Logger.globalDebug(TAG, "setEndOffset", "EndOffset = " + j + ", segment = " + this);
        }
        if (j == -1) {
            this.endOffset = j;
        }
    }

    public void setCurrentOffsetRead(long j) {
        if (j >= this.currentOffset.get()) {
            this.currentOffsetRead = j;
        }
    }

    public int getIndex() {
        return this.index;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setIndex(int i) {
        this.index = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void increaseCompetitor() {
        this.competitor++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void decreaseCompetitor() {
        this.competitor--;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCompetitor() {
        return this.competitor;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCompetitor(int i) {
        this.competitor = i;
    }

    public String toString() {
        return "Segment{startOffset=" + this.startOffset + ",\t currentOffset=" + this.currentOffset + ",\t currentOffsetRead=" + getCurrentOffsetRead() + ",\t endOffset=" + this.endOffset + AbstractJsonLexerKt.END_OBJ;
    }

    public static String toString(List<Segment> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        Collections.sort(list, new Comparator<Segment>() { // from class: com.ss.android.socialbase.downloader.segment.Segment.1
            @Override // java.util.Comparator
            public int compare(Segment segment, Segment segment2) {
                return (int) (segment.getStartOffset() - segment2.getStartOffset());
            }
        });
        StringBuilder sb = new StringBuilder();
        Iterator<Segment> it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next()).append("\r\n");
        }
        return sb.toString();
    }

    public JSONObject toJson() throws JSONException {
        JSONObject jSONObject = this.jsonObject;
        if (jSONObject == null) {
            jSONObject = new JSONObject();
            this.jsonObject = jSONObject;
        }
        jSONObject.put(JsonKey.START, getStartOffset());
        jSONObject.put(JsonKey.CURRENT, getCurrentOffset());
        jSONObject.put("en", getEndOffset());
        return jSONObject;
    }
}
