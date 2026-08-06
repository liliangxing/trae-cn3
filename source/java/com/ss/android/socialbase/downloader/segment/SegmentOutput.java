package com.ss.android.socialbase.downloader.segment;

import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.RandomAccessOutputStream;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.thread.IDownloadRunnableCallback;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class SegmentOutput implements IOutput {
    private IDownloadRunnableCallback mCallback;
    private boolean mHandleRequest;
    private long mOffset;
    private final RandomAccessOutputStream output;
    private final Segment segment;
    private final IOutput stub;

    public SegmentOutput(DownloadInfo downloadInfo, BufferQueue bufferQueue, Segment segment, IDownloadRunnableCallback iDownloadRunnableCallback) throws BaseException {
        this.segment = segment;
        this.output = createOutStream(downloadInfo, segment);
        this.stub = new OutputStub(bufferQueue, this);
        this.mCallback = iDownloadRunnableCallback;
    }

    public IOutput getStub() {
        return this.stub;
    }

    @Override // com.ss.android.socialbase.downloader.segment.IOutput
    public void write(Buffer buffer) throws IOException {
        IDownloadRunnableCallback iDownloadRunnableCallback;
        this.output.write(buffer.data, 0, buffer.size);
        if (this.mHandleRequest && (iDownloadRunnableCallback = this.mCallback) != null) {
            iDownloadRunnableCallback.onReceiveSegmentData(this.mOffset, buffer.data, buffer.size);
            this.mOffset += buffer.size;
        }
        this.segment.increaseCurrentOffset(buffer.size);
    }

    public void flush() throws IOException {
        this.output.flush();
    }

    public void sync() throws IOException {
        this.output.sync();
    }

    public void close() {
        DownloadUtils.safeClose(this.output);
    }

    public Segment getSegment() {
        return this.segment;
    }

    private RandomAccessOutputStream createOutStream(DownloadInfo downloadInfo, Segment segment) throws BaseException {
        DownloadSetting obtain = DownloadSetting.obtain(downloadInfo.getId());
        RandomAccessOutputStream createOutputStream = DownloadHelper.createOutputStream(downloadInfo, downloadInfo.getTempPath(), downloadInfo.getTempName(), obtain.optInt(DownloadSettingKeys.FLUSH_BUFFER_SIZE_BYTE, -1), obtain.optInt(DownloadSettingKeys.SEGMENT_NIO) > 0);
        long startOffset = downloadInfo.getStartOffset();
        if (startOffset < 0) {
            startOffset = 0;
        }
        this.mHandleRequest = downloadInfo.isHandleRequest();
        long currentOffsetRead = segment.getCurrentOffsetRead() - startOffset;
        this.mOffset = currentOffsetRead;
        try {
            createOutputStream.seek(currentOffsetRead);
            return createOutputStream;
        } catch (IOException e) {
            throw new BaseException(1054, e);
        }
    }
}
