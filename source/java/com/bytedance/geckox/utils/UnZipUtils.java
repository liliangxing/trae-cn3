package com.bytedance.geckox.utils;

import com.bytedance.geckox.buffer.Buffer;
import com.bytedance.geckox.buffer.stream.BufferInputStream;
import com.bytedance.iesgurd.core.CacheManager;
import com.bytedance.zoin.zstd.ZstdInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* compiled from: UnZipUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u0006J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\tJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\"\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\r2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\r¨\u0006\u0012"}, d2 = {"Lcom/bytedance/geckox/utils/UnZipUtils;", "", "()V", "decompressZstd", "", "src", "Lcom/bytedance/geckox/buffer/Buffer;", "dest", "Ljava/io/InputStream;", "Ljava/io/File;", "ignore", "", "folder", "", "unzip", "inStream", "dir", "channelName", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class UnZipUtils {
    public static final UnZipUtils INSTANCE = new UnZipUtils();

    private UnZipUtils() {
    }

    public static /* synthetic */ void unzip$default(UnZipUtils unZipUtils, InputStream inputStream, String str, String str2, int i, Object obj) throws Exception {
        if ((i & 4) != 0) {
            str2 = null;
        }
        unZipUtils.unzip(inputStream, str, str2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v12, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r7v1, types: [com.bytedance.geckox.utils.FileUtils] */
    public final void unzip(InputStream inStream, String dir, String channelName) throws Exception {
        Intrinsics.checkParameterIsNotNull(inStream, "inStream");
        Intrinsics.checkParameterIsNotNull(dir, "dir");
        ZipInputStream zipInputStream = null;
        try {
            String canonicalPath = new File(dir).getCanonicalPath();
            Intrinsics.checkExpressionValueIsNotNull(canonicalPath, "File(dir).canonicalPath");
            ZipInputStream zipInputStream2 = new ZipInputStream(inStream);
            boolean z = false;
            while (true) {
                try {
                    ZipEntry nextEntry = zipInputStream2.getNextEntry();
                    if (nextEntry == null) {
                        if (!z) {
                            inStream.reset();
                            throw new RuntimeException("not zip file");
                        }
                        CloseableUtils.close(zipInputStream2);
                        return;
                    }
                    String name = nextEntry.getName();
                    Intrinsics.checkExpressionValueIsNotNull(name, "name");
                    if (!ignore(name)) {
                        if (StringsKt.contains$default(name, "../", false, 2, (Object) null)) {
                            throw new RuntimeException("directory traversal, dir:" + name);
                        }
                        if (channelName != null && !StringsKt.startsWith$default(name, channelName + File.separator, false, 2, (Object) null)) {
                            CacheManager.INSTANCE.renameFileToPending(new File(canonicalPath));
                            throw new RuntimeException("the zip package outermost folder is not named by channel:" + channelName + ",name:" + name);
                        }
                        if (nextEntry.isDirectory()) {
                            File file = new File(canonicalPath, name);
                            String canonicalPath2 = file.getCanonicalPath();
                            Intrinsics.checkExpressionValueIsNotNull(canonicalPath2, "folder.canonicalPath");
                            if (!StringsKt.startsWith$default(canonicalPath2, canonicalPath, false, 2, (Object) null)) {
                                throw new RuntimeException("directory traversal, dir:" + name);
                            }
                            file.mkdirs();
                        } else {
                            String canonicalPath3 = new File(canonicalPath, name).getCanonicalPath();
                            Intrinsics.checkExpressionValueIsNotNull(canonicalPath3, "canonicalPath");
                            if (!StringsKt.startsWith$default(canonicalPath3, canonicalPath, false, 2, (Object) null)) {
                                throw new RuntimeException("directory traversal, file name:" + name);
                            }
                            File file2 = new File(canonicalPath3);
                            file2.getParentFile().mkdirs();
                            try {
                                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                                try {
                                    FileUtils.INSTANCE.copyStream$geckox_noasanRelease(zipInputStream2, fileOutputStream);
                                    if (!file2.exists()) {
                                        throw new RuntimeException("unzip failed, file not exist: " + name);
                                    }
                                    long cRC32$geckox_noasanRelease = FileUtils.INSTANCE.getCRC32$geckox_noasanRelease(file2);
                                    long crc = nextEntry.getCrc();
                                    if (crc > 0 && cRC32$geckox_noasanRelease != crc) {
                                        throw new RuntimeException("unzip failed, crc check error: " + name + ", crc32: " + cRC32$geckox_noasanRelease + ",expected crc32: " + nextEntry.getCrc());
                                    }
                                    CloseableUtils.close(fileOutputStream);
                                } catch (Throwable th) {
                                    th = th;
                                    zipInputStream = fileOutputStream;
                                    CloseableUtils.close(zipInputStream);
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                            }
                        }
                    }
                    z = true;
                } catch (Throwable th3) {
                    th = th3;
                    zipInputStream = zipInputStream2;
                    CloseableUtils.close(zipInputStream);
                    throw th;
                }
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    private final boolean ignore(String folder) {
        return StringsKt.startsWith$default(folder, "__MACOSX/", false, 2, (Object) null) || StringsKt.endsWith$default(folder, ".DS_Store", false, 2, (Object) null);
    }

    public final void decompressZstd(Buffer src, Buffer dest) throws Exception {
        Closeable closeable;
        Throwable th;
        Intrinsics.checkParameterIsNotNull(dest, "dest");
        if (src == null) {
            Intrinsics.throwNpe();
        }
        BufferInputStream bufferInputStream = new BufferInputStream(src);
        try {
            closeable = new ZstdInputStream(bufferInputStream);
            try {
                byte[] bArr = new byte[32768];
                Ref.IntRef intRef = new Ref.IntRef();
                while (true) {
                    int read = closeable.read(bArr);
                    intRef.element = read;
                    if (read != -1) {
                        dest.write(bArr, 0, intRef.element);
                    } else {
                        CloseableUtils.close(bufferInputStream);
                        CloseableUtils.close(closeable);
                        return;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                CloseableUtils.close(bufferInputStream);
                CloseableUtils.close(closeable);
                throw th;
            }
        } catch (Throwable th3) {
            closeable = null;
            th = th3;
        }
    }

    public final void decompressZstd(InputStream src, File dest) throws Exception {
        FileOutputStream fileOutputStream;
        Throwable th;
        Closeable closeable;
        try {
            fileOutputStream = new FileOutputStream(dest);
            try {
                closeable = new ZstdInputStream(src);
                try {
                    byte[] bArr = new byte[32768];
                    Ref.IntRef intRef = new Ref.IntRef();
                    while (true) {
                        int read = closeable.read(bArr);
                        intRef.element = read;
                        if (read != -1) {
                            fileOutputStream.write(bArr, 0, intRef.element);
                        } else {
                            CloseableUtils.close(src);
                            CloseableUtils.close(fileOutputStream);
                            CloseableUtils.close(closeable);
                            return;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    CloseableUtils.close(src);
                    CloseableUtils.close(fileOutputStream);
                    CloseableUtils.close(closeable);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                closeable = null;
            }
        } catch (Throwable th4) {
            fileOutputStream = null;
            th = th4;
            closeable = null;
        }
    }
}
