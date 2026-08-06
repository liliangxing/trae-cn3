package com.ss.android.socialbase.downloader.segment;

/* loaded from: classes7.dex */
public interface IBufferPool {
    Buffer obtain() throws StreamClosedException, InterruptedException;

    void recycle(Buffer buffer);
}
