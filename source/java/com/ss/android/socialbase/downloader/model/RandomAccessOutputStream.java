package com.ss.android.socialbase.downloader.model;

import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class RandomAccessOutputStream implements Closeable {
    private static final int MAX_FLUSH_BUFFER_SIZE = 131072;
    private static final int MIN_FLUSH_BUFFER_SIZE = 8192;
    private RandomOutputStream randomAccess;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    private interface RandomOutputStream {
        void close() throws IOException;

        void flush() throws IOException;

        void flushAndSync() throws IOException;

        void seek(long j) throws IOException;

        void setLength(long j) throws IOException;

        void sync() throws IOException;

        void write(byte[] bArr, int i, int i2) throws IOException;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    private class BufferRandomAccessOutputStream implements RandomOutputStream {

        /* renamed from: fd */
        private FileDescriptor f77fd;
        private BufferedOutputStream outputStream;
        private RandomAccessFile randomAccess;

        public BufferRandomAccessOutputStream(File file, int i) throws BaseException {
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                this.randomAccess = randomAccessFile;
                this.f77fd = randomAccessFile.getFD();
                if (i > 0) {
                    int i2 = 8192;
                    if (i >= 8192) {
                        i2 = 131072;
                        if (i > 131072) {
                        }
                        this.outputStream = new BufferedOutputStream(new FileOutputStream(this.randomAccess.getFD()), i);
                        return;
                    }
                    i = i2;
                    this.outputStream = new BufferedOutputStream(new FileOutputStream(this.randomAccess.getFD()), i);
                    return;
                }
                this.outputStream = new BufferedOutputStream(new FileOutputStream(this.randomAccess.getFD()));
            } catch (IOException e) {
                throw new BaseException(1039, e);
            }
        }

        @Override // com.ss.android.socialbase.downloader.model.RandomAccessOutputStream.RandomOutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            this.outputStream.write(bArr, i, i2);
        }

        @Override // com.ss.android.socialbase.downloader.model.RandomAccessOutputStream.RandomOutputStream
        public void flushAndSync() throws IOException {
            BufferedOutputStream bufferedOutputStream = this.outputStream;
            if (bufferedOutputStream != null) {
                bufferedOutputStream.flush();
            }
            FileDescriptor fileDescriptor = this.f77fd;
            if (fileDescriptor != null) {
                fileDescriptor.sync();
            }
        }

        @Override // com.ss.android.socialbase.downloader.model.RandomAccessOutputStream.RandomOutputStream
        public void flush() throws IOException {
            BufferedOutputStream bufferedOutputStream = this.outputStream;
            if (bufferedOutputStream != null) {
                bufferedOutputStream.flush();
            }
        }

        @Override // com.ss.android.socialbase.downloader.model.RandomAccessOutputStream.RandomOutputStream
        public void sync() throws IOException {
            FileDescriptor fileDescriptor = this.f77fd;
            if (fileDescriptor != null) {
                fileDescriptor.sync();
            }
        }

        @Override // com.ss.android.socialbase.downloader.model.RandomAccessOutputStream.RandomOutputStream
        public void close() throws IOException {
            DownloadUtils.safeClose(this.outputStream, this.randomAccess);
        }

        @Override // com.ss.android.socialbase.downloader.model.RandomAccessOutputStream.RandomOutputStream
        public void setLength(long j) throws IOException {
            this.randomAccess.setLength(j);
        }

        @Override // com.ss.android.socialbase.downloader.model.RandomAccessOutputStream.RandomOutputStream
        public void seek(long j) throws IOException {
            this.randomAccess.seek(j);
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    private class ChannelRandomAccessOutputStream implements RandomOutputStream {
        private ByteBuffer byteBuffer;
        private FileChannel fileChannel;
        private RandomAccessFile randomAccess;

        @Override // com.ss.android.socialbase.downloader.model.RandomAccessOutputStream.RandomOutputStream
        public void sync() throws IOException {
        }

        public ChannelRandomAccessOutputStream(File file) throws BaseException {
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                this.randomAccess = randomAccessFile;
                this.fileChannel = randomAccessFile.getChannel();
                this.byteBuffer = ByteBuffer.allocateDirect(DownloadConstants.TTNET_DEFAULT_BUFFER_SIZE);
            } catch (IOException e) {
                throw new BaseException(1039, e);
            }
        }

        @Override // com.ss.android.socialbase.downloader.model.RandomAccessOutputStream.RandomOutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            this.byteBuffer.clear();
            this.byteBuffer.put(bArr, i, i2);
            this.byteBuffer.flip();
            while (this.byteBuffer.hasRemaining()) {
                this.fileChannel.write(this.byteBuffer);
            }
        }

        @Override // com.ss.android.socialbase.downloader.model.RandomAccessOutputStream.RandomOutputStream
        public void flushAndSync() throws IOException {
            flush();
        }

        @Override // com.ss.android.socialbase.downloader.model.RandomAccessOutputStream.RandomOutputStream
        public void flush() throws IOException {
            this.fileChannel.force(true);
        }

        @Override // com.ss.android.socialbase.downloader.model.RandomAccessOutputStream.RandomOutputStream
        public void close() throws IOException {
            DownloadUtils.safeClose(this.fileChannel, this.randomAccess);
        }

        @Override // com.ss.android.socialbase.downloader.model.RandomAccessOutputStream.RandomOutputStream
        public void setLength(long j) throws IOException {
            this.randomAccess.setLength(j);
        }

        @Override // com.ss.android.socialbase.downloader.model.RandomAccessOutputStream.RandomOutputStream
        public void seek(long j) throws IOException {
            this.fileChannel.position(j);
        }
    }

    public RandomAccessOutputStream(File file, int i) throws BaseException {
        this(file, i, false);
    }

    public RandomAccessOutputStream(File file, int i, boolean z) throws BaseException {
        if (z) {
            this.randomAccess = new ChannelRandomAccessOutputStream(file);
        } else {
            this.randomAccess = new BufferRandomAccessOutputStream(file, i);
        }
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.randomAccess.write(bArr, i, i2);
    }

    public void flushAndSync() throws IOException {
        this.randomAccess.flushAndSync();
    }

    public void flush() throws IOException {
        this.randomAccess.flush();
    }

    public void sync() throws IOException {
        this.randomAccess.sync();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.randomAccess.close();
    }

    public void seek(long j) throws IOException {
        this.randomAccess.seek(j);
    }

    public void setLength(long j) throws IOException {
        this.randomAccess.setLength(j);
    }
}
