package coil3.decode;

import coil3.decode.ImageSource;
import coil3.util.FileSystems_commonKt;
import coil3.util.Utils_commonKt;
import java.io.Closeable;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.FileSystem;
import okio.Okio;
import okio.Path;
import okio.Source;

/* compiled from: ImageSource.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0016\u001a\u00020\u0013H\u0016J\n\u0010\u0017\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0018\u001a\u00020\u0003H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u001bH\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcoil3/decode/SourceImageSource;", "Lcoil3/decode/ImageSource;", "source", "Lokio/BufferedSource;", "fileSystem", "Lokio/FileSystem;", "metadata", "Lcoil3/decode/ImageSource$Metadata;", "byteArray", "", "<init>", "(Lokio/BufferedSource;Lokio/FileSystem;Lcoil3/decode/ImageSource$Metadata;[B)V", "getFileSystem", "()Lokio/FileSystem;", "getMetadata", "()Lcoil3/decode/ImageSource$Metadata;", "lock", "", "isClosed", "", Utils_commonKt.SCHEME_FILE, "Lokio/Path;", "hasByteArray", "getByteArray", "sourceOrNull", "fileOrNull", "close", "", "assertNotClosed", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class SourceImageSource implements ImageSource {
    private byte[] byteArray;
    private Path file;
    private final FileSystem fileSystem;
    private boolean isClosed;
    private final Object lock = new Object();
    private final ImageSource.Metadata metadata;
    private BufferedSource source;

    public SourceImageSource(BufferedSource bufferedSource, FileSystem fileSystem, ImageSource.Metadata metadata, byte[] bArr) {
        this.fileSystem = fileSystem;
        this.metadata = metadata;
        this.byteArray = bArr;
        this.source = bufferedSource;
    }

    @Override // coil3.decode.ImageSource
    public FileSystem getFileSystem() {
        return this.fileSystem;
    }

    @Override // coil3.decode.ImageSource
    public ImageSource.Metadata getMetadata() {
        return this.metadata;
    }

    @Override // coil3.decode.ImageSource
    public boolean hasByteArray() {
        return this.byteArray != null;
    }

    @Override // coil3.decode.ImageSource
    public byte[] getByteArray() {
        return this.byteArray;
    }

    @Override // coil3.decode.ImageSource
    public BufferedSource source() {
        synchronized (this.lock) {
            assertNotClosed();
            BufferedSource bufferedSource = this.source;
            if (bufferedSource != null) {
                return bufferedSource;
            }
            FileSystem fileSystem = getFileSystem();
            Path path = this.file;
            Intrinsics.checkNotNull(path);
            BufferedSource buffer = Okio.buffer(fileSystem.source(path));
            this.source = buffer;
            return buffer;
        }
    }

    @Override // coil3.decode.ImageSource
    public BufferedSource sourceOrNull() {
        return source();
    }

    @Override // coil3.decode.ImageSource
    public Path file() {
        Throwable th;
        synchronized (this.lock) {
            assertNotClosed();
            Path path = this.file;
            if (path != null) {
                return path;
            }
            Path createTempFile = FileSystems_commonKt.createTempFile(getFileSystem());
            BufferedSink bufferedSink = (Closeable) Okio.buffer(getFileSystem().sink(createTempFile, false));
            try {
                Source source = this.source;
                Intrinsics.checkNotNull(source);
                Long.valueOf(bufferedSink.writeAll(source));
                if (bufferedSink != null) {
                    try {
                        bufferedSink.close();
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
                th = null;
            } catch (Throwable th3) {
                if (bufferedSink != null) {
                    try {
                        bufferedSink.close();
                    } catch (Throwable th4) {
                        ExceptionsKt.addSuppressed(th3, th4);
                    }
                }
                th = th3;
            }
            if (th == null) {
                this.source = null;
                this.file = createTempFile;
                return createTempFile;
            }
            throw th;
        }
    }

    @Override // coil3.decode.ImageSource
    public Path fileOrNull() {
        Path path;
        synchronized (this.lock) {
            assertNotClosed();
            path = this.file;
        }
        return path;
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        synchronized (this.lock) {
            this.isClosed = true;
            Closeable closeable = this.source;
            if (closeable != null) {
                Utils_commonKt.closeQuietly(closeable);
            }
            Path path = this.file;
            if (path != null) {
                getFileSystem().delete(path);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void assertNotClosed() {
        if (!(!this.isClosed)) {
            throw new IllegalStateException("closed".toString());
        }
    }
}
