package com.ss.android.socialbase.downloader.segment;

import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.HttpResponse;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public interface ISegmentCallback {
    void applySegment(SegmentReader segmentReader, Segment segment) throws BaseException;

    IOutput createOutput(SegmentReader segmentReader, Segment segment) throws BaseException;

    Segment obtainSegment(SegmentReader segmentReader, UrlRecord urlRecord);

    void onReaderExit(SegmentReader segmentReader);

    void onReaderRun(SegmentReader segmentReader);

    void onSegmentConnected(SegmentReader segmentReader, Segment segment, UrlRecord urlRecord, HttpResponse httpResponse) throws BaseException;

    void onSegmentFailed(SegmentReader segmentReader, UrlRecord urlRecord, Segment segment, BaseException baseException);

    boolean onSegmentRetry(SegmentReader segmentReader, UrlRecord urlRecord, Segment segment, BaseException baseException, int i, int i2);

    void unApplySegment(SegmentReader segmentReader, Segment segment);

    void unObtainSegment(SegmentReader segmentReader, Segment segment);
}
