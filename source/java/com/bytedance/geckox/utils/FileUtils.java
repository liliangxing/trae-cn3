package com.bytedance.geckox.utils;

import com.bytedance.geckox.GkFSUtils;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.gkfs.GeckoFileSystem;
import com.bytedance.iesgurd.core.EventSubType;
import com.bytedance.iesgurd.meta.ChannelMeta;
import com.bytedance.iesgurd.meta.ChannelMetaManager;
import com.bytedance.iesgurd.statistic.model.EventMessageModel;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.util.zip.CRC32;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FileUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J!\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0000¢\u0006\u0002\b\rJ\u0015\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\u0010J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007J\u0012\u0010\u0013\u001a\u00020\u00122\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002J\u0017\u0010\u0014\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0000¢\u0006\u0002\b\u0015J\u0015\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\u0017J\u0017\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0006H\u0000¢\u0006\u0002\b\u001bJ&\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u0019¨\u0006 "}, d2 = {"Lcom/bytedance/geckox/utils/FileUtils;", "", "()V", "checkLynxFileBroken", "", "file", "Ljava/io/File;", "copyStream", "", "in", "Ljava/io/InputStream;", "out", "Ljava/io/OutputStream;", "copyStream$geckox_noasanRelease", "createDir", "src", "createDir$geckox_noasanRelease", "delete", "", "deleteTraversals", "getCRC32", "getCRC32$geckox_noasanRelease", "getTotalSizeOfFiles", "getTotalSizeOfFiles$geckox_noasanRelease", "readJsonFile", "", "jsonFile", "readJsonFile$geckox_noasanRelease", "uploadFileBrokenEvent", "accessKey", "channel", "relativePath", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class FileUtils {
    public static final FileUtils INSTANCE = new FileUtils();

    private FileUtils() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0019, code lost:
    
        if (r0 == false) goto L12;
     */
    @JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean delete(File file) {
        boolean z;
        if (file == null || !file.exists()) {
            return true;
        }
        try {
            z = GkFSUtils.INSTANCE.isEnable() ? GeckoFileSystem.INSTANCE.delete(file) : false;
        } catch (Throwable unused) {
        }
        z = INSTANCE.deleteTraversals(file);
        GeckoLogger.m296d("delete file: " + z + ", " + file.getAbsolutePath());
        return z;
    }

    private final boolean deleteTraversals(File file) {
        boolean z;
        File[] listFiles;
        if (file == null || !file.exists()) {
            return true;
        }
        if (!file.isDirectory() || (listFiles = file.listFiles()) == null) {
            z = true;
        } else {
            z = true;
            for (File file2 : listFiles) {
                z = z && deleteTraversals(file2);
            }
        }
        return z && file.delete();
    }

    public final long copyStream$geckox_noasanRelease(InputStream in, OutputStream out) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(in);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(out);
        byte[] bArr = new byte[8192];
        int i = 0;
        while (true) {
            int read = bufferedInputStream.read(bArr);
            if (read != -1) {
                i += read;
                bufferedOutputStream.write(bArr, 0, read);
            } else {
                bufferedOutputStream.flush();
                return i;
            }
        }
    }

    public final long getTotalSizeOfFiles$geckox_noasanRelease(File file) {
        Intrinsics.checkParameterIsNotNull(file, "file");
        if (file.isFile()) {
            return file.length();
        }
        File[] listFiles = file.listFiles();
        long j = 0;
        if (listFiles != null) {
            for (File file2 : listFiles) {
                Intrinsics.checkExpressionValueIsNotNull(file2, "child");
                j += getTotalSizeOfFiles$geckox_noasanRelease(file2);
            }
        }
        return j;
    }

    public final void createDir$geckox_noasanRelease(File src) throws Exception {
        Intrinsics.checkParameterIsNotNull(src, "src");
        if (src.exists()) {
            if (src.isFile()) {
                throw new RuntimeException("create dir failed: path is a file");
            }
        } else if (!src.mkdirs()) {
            throw new RuntimeException("create dir failed: " + src.getPath());
        }
    }

    public final String readJsonFile$geckox_noasanRelease(File jsonFile) throws IOException {
        InputStreamReader inputStreamReader = null;
        try {
            InputStreamReader inputStreamReader2 = new InputStreamReader(new FileInputStream(jsonFile), "utf-8");
            try {
                StringBuffer stringBuffer = new StringBuffer();
                while (true) {
                    int read = inputStreamReader2.read();
                    if (read != -1) {
                        stringBuffer.append((char) read);
                    } else {
                        String stringBuffer2 = stringBuffer.toString();
                        Intrinsics.checkExpressionValueIsNotNull(stringBuffer2, "sb.toString()");
                        CloseableUtils.close(inputStreamReader2);
                        return stringBuffer2;
                    }
                }
            } catch (Throwable th) {
                th = th;
                inputStreamReader = inputStreamReader2;
                CloseableUtils.close(inputStreamReader);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final void checkLynxFileBroken(File file) throws Throwable {
        Intrinsics.checkParameterIsNotNull(file, "file");
        if (!file.exists()) {
            return;
        }
        boolean z = true;
        if (!Intrinsics.areEqual(file.getName(), "template.js")) {
            return;
        }
        if (file.length() < 4) {
            throw new RuntimeException("file size less than 4: " + file.getName());
        }
        RandomAccessFile randomAccessFile = null;
        try {
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, "r");
            int i = 0;
            while (true) {
                if (i > 3) {
                    break;
                }
                try {
                    if (randomAccessFile2.readByte() != 0) {
                        z = false;
                        break;
                    }
                    i++;
                } catch (Throwable th) {
                    th = th;
                    randomAccessFile = randomAccessFile2;
                    CloseableUtils.close(randomAccessFile);
                    throw th;
                }
            }
            if (z) {
                throw new RuntimeException("file start with 4 zero: " + file.getName());
            }
            CloseableUtils.close(randomAccessFile2);
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final void uploadFileBrokenEvent(String accessKey, String channel, File file, String relativePath) {
        Object obj;
        Intrinsics.checkParameterIsNotNull(accessKey, "accessKey");
        Intrinsics.checkParameterIsNotNull(channel, "channel");
        Intrinsics.checkParameterIsNotNull(file, "file");
        Intrinsics.checkParameterIsNotNull(relativePath, "relativePath");
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.constructor-impl(MD5Utils.INSTANCE.getMD5$geckox_noasanRelease(file));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        String str = "path: " + relativePath + ", length: " + file.length() + ", md5: " + ((String) obj);
        ChannelMeta meta = ChannelMetaManager.INSTANCE.getMeta(accessKey, channel);
        Long updateTime = meta != null ? meta.getUpdateTime() : null;
        long lastModified = file.lastModified();
        new EventMessageModel(EventSubType.FILE_BROKEN, accessKey, channel, "updateTime: " + updateTime + ", lastModified: " + lastModified + ", isModified: " + (updateTime != null && updateTime.longValue() < lastModified), str, 0L, 32, (DefaultConstructorMarker) null).upload();
    }

    public final long getCRC32$geckox_noasanRelease(File file) throws Exception {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
        byte[] bArr = new byte[8192];
        CRC32 crc32 = new CRC32();
        while (true) {
            int read = bufferedInputStream.read(bArr);
            if (read != -1) {
                crc32.update(bArr, 0, read);
            } else {
                bufferedInputStream.close();
                return crc32.getValue();
            }
        }
    }
}
