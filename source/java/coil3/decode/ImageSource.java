package coil3.decode;

import okio.BufferedSource;
import okio.FileSystem;
import okio.Path;

/* compiled from: ImageSource.kt */
@kotlin.Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00060\u0002j\u0002`\u0001:\u0001\u0015J\n\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H&J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0010H&J\b\u0010\u0012\u001a\u00020\u0013H&J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0013H&R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n\u0082\u0001\u0002\u0016\u0017ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0018À\u0006\u0001"}, d2 = {"Lcoil3/decode/ImageSource;", "Lkotlin/AutoCloseable;", "Ljava/lang/AutoCloseable;", "fileSystem", "Lokio/FileSystem;", "getFileSystem", "()Lokio/FileSystem;", "metadata", "Lcoil3/decode/ImageSource$Metadata;", "getMetadata", "()Lcoil3/decode/ImageSource$Metadata;", "getByteArray", "", "hasByteArray", "", "source", "Lokio/BufferedSource;", "sourceOrNull", "file", "Lokio/Path;", "fileOrNull", "Metadata", "Lcoil3/decode/FileImageSource;", "Lcoil3/decode/SourceImageSource;", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface ImageSource extends AutoCloseable {

    /* compiled from: ImageSource.kt */
    @kotlin.Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcoil3/decode/ImageSource$Metadata;", "", "<init>", "()V", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static abstract class Metadata {
    }

    Path file();

    Path fileOrNull();

    default byte[] getByteArray() {
        return null;
    }

    FileSystem getFileSystem();

    Metadata getMetadata();

    default boolean hasByteArray() {
        return false;
    }

    BufferedSource source();

    BufferedSource sourceOrNull();
}
