package coil3.decode;

import coil3.decode.ImageSource;
import coil3.util.Utils_commonKt;
import kotlin.Metadata;
import okio.BufferedSource;
import okio.FileSystem;
import okio.Okio;
import okio.Path;

/* compiled from: ImageSource.kt */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u001aE\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\b\u001a\n\u0018\u00010\nj\u0004\u0018\u0001`\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\r\u001a0\u0010\u0000\u001a\u00020\u00012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u001a\n\u0010\u0012\u001a\u00020\u000f*\u00020\u0011¨\u0006\u0013"}, d2 = {"ImageSource", "Lcoil3/decode/ImageSource;", Utils_commonKt.SCHEME_FILE, "Lokio/Path;", "fileSystem", "Lokio/FileSystem;", "diskCacheKey", "", "closeable", "Lkotlin/AutoCloseable;", "Ljava/lang/AutoCloseable;", "metadata", "Lcoil3/decode/ImageSource$Metadata;", "(Lokio/Path;Lokio/FileSystem;Ljava/lang/String;Ljava/lang/AutoCloseable;Lcoil3/decode/ImageSource$Metadata;)Lcoil3/decode/ImageSource;", "source", "Lokio/BufferedSource;", "byteArray", "", "asBufferedSource", "coil-core_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class ImageSourceKt {
    public static /* synthetic */ ImageSource ImageSource$default(Path path, FileSystem fileSystem, String str, AutoCloseable autoCloseable, ImageSource.Metadata metadata, int i, Object obj) {
        if ((i & 4) != 0) {
            str = null;
        }
        if ((i & 8) != 0) {
            autoCloseable = null;
        }
        if ((i & 16) != 0) {
            metadata = null;
        }
        return ImageSource(path, fileSystem, str, autoCloseable, metadata);
    }

    public static final ImageSource ImageSource(Path path, FileSystem fileSystem, String str, AutoCloseable autoCloseable, ImageSource.Metadata metadata) {
        return new FileImageSource(path, fileSystem, str, autoCloseable, metadata);
    }

    public static /* synthetic */ ImageSource ImageSource$default(BufferedSource bufferedSource, FileSystem fileSystem, ImageSource.Metadata metadata, byte[] bArr, int i, Object obj) {
        if ((i & 4) != 0) {
            metadata = null;
        }
        if ((i & 8) != 0) {
            bArr = null;
        }
        return ImageSource(bufferedSource, fileSystem, metadata, bArr);
    }

    public static final ImageSource ImageSource(BufferedSource bufferedSource, FileSystem fileSystem, ImageSource.Metadata metadata, byte[] bArr) {
        return new SourceImageSource(bufferedSource, fileSystem, metadata, bArr);
    }

    public static final BufferedSource asBufferedSource(byte[] bArr) {
        return Okio.buffer(new ByteArraySource(bArr));
    }
}
