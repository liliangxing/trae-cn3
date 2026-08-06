package com.ttnet.org.chromium.net.urlconnection;

import com.ttnet.org.chromium.base.Logger;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes7.dex */
public final class SegmentPool {
    static long byteCount = 0;
    static Segment next = null;
    private static long sMaxPoolSize = 262144;
    private static long sMinIdleSizeSinceLastCheck = 0;
    private static long sMinPoolSize = 131072;
    private static boolean sSizesSet;
    private static final AtomicLong segmentAllocateTimes = new AtomicLong(0);
    private static final AtomicLong segmentReuseTimes = new AtomicLong(0);
    private static final AtomicLong segmentRequestTimes = new AtomicLong(0);

    public static void setSizes(long j, long j2) {
        if (j < 0) {
            throw new IllegalArgumentException("Minimum pool size cannot be negative");
        }
        if (j2 <= 0) {
            throw new IllegalArgumentException("Max pool size cannot be negative");
        }
        if (j > j2) {
            throw new IllegalArgumentException("Minimum pool size cannot be greater than maximum pool size");
        }
        synchronized (SegmentPool.class) {
            if (sSizesSet) {
                return;
            }
            sMinPoolSize = j;
            sMaxPoolSize = j2;
            sSizesSet = true;
            releaseSegmentsToTarget(j2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Segment take() {
        Segment take = take(false);
        if (Logger.debug()) {
            Logger.d("SegmentPool", new StringBuilder("after take state:当前pool中segment数量: ").append(byteCount / Segment.getSize()).append(" 请求次数: ").append(segmentRequestTimes.get()).append(" 不复用次数: ").append(segmentAllocateTimes.get()).append(" 复用次数: ").append(segmentReuseTimes.get()).append(" 复用率: ").append(r3.get() / r2.get()).toString());
        }
        return take;
    }

    static Segment take(boolean z) {
        synchronized (SegmentPool.class) {
            if (Logger.debug() && !z) {
                segmentRequestTimes.incrementAndGet();
            }
            if (next == null) {
                if (z) {
                    return null;
                }
                if (Logger.debug()) {
                    segmentAllocateTimes.incrementAndGet();
                }
                return new Segment();
            }
            if (Logger.debug() && !z) {
                segmentReuseTimes.incrementAndGet();
            }
            Segment segment = next;
            next = segment.next;
            segment.next = null;
            byteCount -= Segment.getSize();
            if (Logger.debug()) {
                Logger.d("SegmentPool", "sMinIdleSizeSinceLastCheck check if decreased, current is " + (sMinIdleSizeSinceLastCheck / Segment.getSize()));
            }
            long j = byteCount;
            if (j < sMinIdleSizeSinceLastCheck && !z) {
                sMinIdleSizeSinceLastCheck = j;
                if (Logger.debug()) {
                    Logger.d("SegmentPool", "segment count decreased to " + (sMinIdleSizeSinceLastCheck / Segment.getSize()));
                }
            }
            return segment;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean recycle(Segment segment) {
        if (segment.next != null || segment.prev != null) {
            throw new IllegalArgumentException("Segment is still in use");
        }
        synchronized (SegmentPool.class) {
            long size = Segment.getSize();
            long j = byteCount;
            if (j + size > sMaxPoolSize) {
                if (Logger.debug()) {
                    Logger.d("SegmentPool", "full, will not recycle this segment");
                }
                return false;
            }
            byteCount = j + size;
            segment.next = next;
            next = segment;
            if (Logger.debug()) {
                Logger.d("SegmentPool", "after recycle state:当前pool中segment数量: " + (byteCount / Segment.getSize()));
            }
            return true;
        }
    }

    public static boolean checkAndReleaseIdleSegments() {
        synchronized (SegmentPool.class) {
            if (Logger.debug()) {
                Logger.d("SegmentPool", "sMinIdleSizeSinceLastCheck before reset " + (sMinIdleSizeSinceLastCheck / Segment.getSize()) + ", byteCount: " + (byteCount / Segment.getSize()));
            }
            long j = byteCount;
            long j2 = sMinPoolSize;
            if (j <= j2) {
                if (Logger.debug()) {
                    Logger.d("SegmentPool", "will not shrink 1");
                }
                sMinIdleSizeSinceLastCheck = byteCount;
                return false;
            }
            long max = Math.max(j2, j - sMinIdleSizeSinceLastCheck);
            if (Logger.debug()) {
                Logger.d("SegmentPool", "segment count want save targetByteCount " + (max / Segment.getSize()));
            }
            long j3 = byteCount;
            if (j3 <= max) {
                sMinIdleSizeSinceLastCheck = j3;
                if (Logger.debug()) {
                    Logger.d("SegmentPool", "will not shrink 2");
                }
                return false;
            }
            releaseSegmentsToTarget(max);
            sMinIdleSizeSinceLastCheck = byteCount;
            if (Logger.debug()) {
                Logger.d("SegmentPool", "segment count has been reset to " + (sMinIdleSizeSinceLastCheck / Segment.getSize()));
            }
            return true;
        }
    }

    private static void releaseSegmentsToTarget(long j) {
        if (byteCount <= j) {
            return;
        }
        int ceil = (int) Math.ceil((byteCount - j) / Segment.getSize());
        if (Logger.debug()) {
            Logger.d("SegmentPool", "releaseSegmentsToTarget, targetByteCount: " + j + ", segmentsToRelease: " + ceil);
        }
        for (int i = 0; i < ceil; i++) {
            take(true);
        }
    }
}
