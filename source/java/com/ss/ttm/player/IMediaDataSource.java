package com.ss.ttm.player;

import java.io.Closeable;
import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: classes7.dex */
public interface IMediaDataSource extends Closeable {
    public static final int MDS_VERSION_0 = 0;
    public static final int MDS_VERSION_1 = 1;

    default int close(int fd) {
        return -1;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close() throws IOException;

    default String getFilePath() {
        return "/mds_default_file";
    }

    default int getMDSVersion() {
        return 0;
    }

    long getSize() throws IOException;

    default long getSize(int fd) {
        return -1L;
    }

    default int open(String filePath) {
        return -1;
    }

    default int readAt(int fd, long position, ByteBuffer buffer, int offset, int size) {
        return -1;
    }

    int readAt(long position, byte[] buffer, int offset, int size) throws IOException;
}
