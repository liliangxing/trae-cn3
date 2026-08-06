package com.bytedance.security.android.polaris;

import com.bytedance.trae.im.model.MessagePart;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import kotlin.Metadata;
import kotlin.io.ByteStreamsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* compiled from: PolarisFile.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\tH\u0007J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H\u0007J\u001c\u0010\u000f\u001a\u0004\u0018\u00010\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0011\u001a\u00020\u0006H\u0007J\u001c\u0010\u000f\u001a\u0004\u0018\u00010\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0011\u001a\u00020\u0006H\u0007J\u001a\u0010\u0012\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0007J\u001a\u0010\u0012\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\tH\u0007J\u001a\u0010\u0012\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u0006H\u0007J\u001a\u0010\u0012\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\tH\u0007J\u001a\u0010\u0012\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H\u0007J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\tH\u0007J \u0010\u0016\u001a\u00020\u00172\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\tH\u0007J \u0010\u0016\u001a\u00020\u00172\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0006H\u0007J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H\u0007J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\tH\u0007J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H\u0007J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\tH\u0007J \u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\tH\u0007J \u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0006H\u0007J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H\u0007J\u001d\u0010\u001e\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\tH\u0000¢\u0006\u0002\b J\u001d\u0010\u001e\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u0006H\u0000¢\u0006\u0002\b J\u001d\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u0006H\u0000¢\u0006\u0002\b J\u0018\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\t2\u0006\u0010$\u001a\u00020\tH\u0007J\u0018\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\t2\u0006\u0010$\u001a\u00020\u0006H\u0007J\u0018\u0010!\u001a\u00020\"2\u0006\u0010%\u001a\u00020&2\u0006\u0010$\u001a\u00020\tH\u0007J\u0018\u0010!\u001a\u00020\"2\u0006\u0010'\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\tH\u0007J\u0018\u0010!\u001a\u00020\"2\u0006\u0010'\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u0006H\u0007¨\u0006("}, d2 = {"Lcom/bytedance/security/android/polaris/PolarisFile;", "", "()V", "containsMaliciousPath", "", "path", "", "containsMaliciousPath$polaris_release", "getFinalCanonicalFile", "Ljava/io/File;", MessagePart.TYPE_FILE, "getSafeFileInputStreamUnderAllowedFolder", "Ljava/io/FileInputStream;", "name", "allowedFolder", "getSafeFileOrNull", "parent", "child", "getSafeFileOrNullUnderAllowedFolder", "uri", "Ljava/net/URI;", "pathname", "getSafeFileOutputStreamUnderAllowedFolder", "Ljava/io/FileOutputStream;", "append", "getSafeFileReaderUnderAllowedFolder", "Ljava/io/FileReader;", "fileName", "getSafeFileWriterUnderAllowedFolder", "Ljava/io/FileWriter;", "isFileInTargetDir", "targetDir", "isFileInTargetDir$polaris_release", "safeUnzip", "", "zipFile", "destFolder", "inputStream", "Ljava/io/InputStream;", "zipPath", "polaris_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class PolarisFile {
    public static final PolarisFile INSTANCE = new PolarisFile();

    private PolarisFile() {
    }

    public final boolean containsMaliciousPath$polaris_release(String path) {
        Intrinsics.checkParameterIsNotNull(path, "path");
        return StringsKt.contains$default(path, ".." + File.separator, false, 2, (Object) null);
    }

    private final File getFinalCanonicalFile(String path) {
        return getFinalCanonicalFile(new File(path));
    }

    private final File getFinalCanonicalFile(File file) {
        File canonicalFile = file.getCanonicalFile();
        Intrinsics.checkExpressionValueIsNotNull(canonicalFile, "file.canonicalFile");
        File canonicalFile2 = canonicalFile.getCanonicalFile();
        Intrinsics.checkExpressionValueIsNotNull(canonicalFile2, "file.canonicalFile.canonicalFile");
        return canonicalFile2;
    }

    public final boolean isFileInTargetDir$polaris_release(String fileName, String targetDir) {
        Intrinsics.checkParameterIsNotNull(fileName, "fileName");
        Intrinsics.checkParameterIsNotNull(targetDir, "targetDir");
        return isFileInTargetDir$polaris_release(getFinalCanonicalFile(fileName), getFinalCanonicalFile(targetDir));
    }

    public final boolean isFileInTargetDir$polaris_release(File file, String targetDir) {
        Intrinsics.checkParameterIsNotNull(file, MessagePart.TYPE_FILE);
        Intrinsics.checkParameterIsNotNull(targetDir, "targetDir");
        return isFileInTargetDir$polaris_release(file, getFinalCanonicalFile(targetDir));
    }

    public final boolean isFileInTargetDir$polaris_release(File file, File targetDir) {
        Intrinsics.checkParameterIsNotNull(file, MessagePart.TYPE_FILE);
        Intrinsics.checkParameterIsNotNull(targetDir, "targetDir");
        try {
            return (!Intrinsics.areEqual(file, targetDir)) & FilesKt.startsWith(file, new File(targetDir, "/"));
        } catch (IOException unused) {
            return false;
        }
    }

    @JvmStatic
    public static final void safeUnzip(File zipFile, File destFolder) throws IOException {
        Intrinsics.checkParameterIsNotNull(zipFile, "zipFile");
        Intrinsics.checkParameterIsNotNull(destFolder, "destFolder");
        safeUnzip(new FileInputStream(zipFile), destFolder);
    }

    @JvmStatic
    public static final void safeUnzip(File zipFile, String destFolder) throws IOException {
        Intrinsics.checkParameterIsNotNull(zipFile, "zipFile");
        Intrinsics.checkParameterIsNotNull(destFolder, "destFolder");
        safeUnzip(new FileInputStream(zipFile), new File(destFolder));
    }

    @JvmStatic
    public static final void safeUnzip(String zipPath, File destFolder) throws IOException {
        Intrinsics.checkParameterIsNotNull(zipPath, "zipPath");
        Intrinsics.checkParameterIsNotNull(destFolder, "destFolder");
        safeUnzip(new FileInputStream(zipPath), destFolder);
    }

    @JvmStatic
    public static final void safeUnzip(String zipPath, String destFolder) throws IOException {
        Intrinsics.checkParameterIsNotNull(zipPath, "zipPath");
        Intrinsics.checkParameterIsNotNull(destFolder, "destFolder");
        safeUnzip(new FileInputStream(zipPath), new File(destFolder));
    }

    @JvmStatic
    public static final void safeUnzip(InputStream inputStream, File destFolder) throws IOException {
        String name;
        Intrinsics.checkParameterIsNotNull(inputStream, "inputStream");
        Intrinsics.checkParameterIsNotNull(destFolder, "destFolder");
        try {
            ZipInputStream zipInputStream = new ZipInputStream(inputStream);
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            while (true) {
                ZipEntry nextEntry = zipInputStream.getNextEntry();
                objectRef.element = nextEntry;
                if (nextEntry != null) {
                    ZipEntry zipEntry = (ZipEntry) objectRef.element;
                    if (zipEntry != null && (name = zipEntry.getName()) != null) {
                        if (INSTANCE.containsMaliciousPath$polaris_release(name)) {
                            zipInputStream.closeEntry();
                        } else {
                            File file = new File(destFolder, name);
                            ZipEntry zipEntry2 = (ZipEntry) objectRef.element;
                            if (zipEntry2 != null && zipEntry2.isDirectory()) {
                                file.mkdirs();
                            } else {
                                File parentFile = file.getParentFile();
                                if (parentFile != null && !parentFile.exists()) {
                                    parentFile.mkdirs();
                                }
                                FileOutputStream fileOutputStream = new FileOutputStream(file);
                                ByteStreamsKt.copyTo$default(zipInputStream, fileOutputStream, 0, 2, (Object) null);
                                fileOutputStream.close();
                            }
                            zipInputStream.closeEntry();
                        }
                    }
                } else {
                    zipInputStream.close();
                    return;
                }
            }
        } catch (IOException e) {
            throw e;
        }
    }

    @JvmStatic
    public static final File getSafeFileOrNullUnderAllowedFolder(String pathname, File allowedFolder) {
        Intrinsics.checkParameterIsNotNull(pathname, "pathname");
        Intrinsics.checkParameterIsNotNull(allowedFolder, "allowedFolder");
        return getSafeFileOrNullUnderAllowedFolder(new File(pathname), allowedFolder);
    }

    @JvmStatic
    public static final File getSafeFileOrNullUnderAllowedFolder(String pathname, String allowedFolder) {
        Intrinsics.checkParameterIsNotNull(pathname, "pathname");
        Intrinsics.checkParameterIsNotNull(allowedFolder, "allowedFolder");
        return getSafeFileOrNullUnderAllowedFolder(new File(pathname), new File(allowedFolder));
    }

    @JvmStatic
    public static final File getSafeFileOrNullUnderAllowedFolder(URI uri, File allowedFolder) {
        Intrinsics.checkParameterIsNotNull(uri, "uri");
        Intrinsics.checkParameterIsNotNull(allowedFolder, "allowedFolder");
        return getSafeFileOrNullUnderAllowedFolder(new File(uri), allowedFolder);
    }

    @JvmStatic
    public static final File getSafeFileOrNullUnderAllowedFolder(URI uri, String allowedFolder) {
        Intrinsics.checkParameterIsNotNull(uri, "uri");
        Intrinsics.checkParameterIsNotNull(allowedFolder, "allowedFolder");
        return getSafeFileOrNullUnderAllowedFolder(new File(uri), new File(allowedFolder));
    }

    @JvmStatic
    public static final File getSafeFileOrNullUnderAllowedFolder(File file, File allowedFolder) {
        Intrinsics.checkParameterIsNotNull(file, MessagePart.TYPE_FILE);
        Intrinsics.checkParameterIsNotNull(allowedFolder, "allowedFolder");
        try {
            PolarisFile polarisFile = INSTANCE;
            File finalCanonicalFile = polarisFile.getFinalCanonicalFile(file);
            if (polarisFile.isFileInTargetDir$polaris_release(finalCanonicalFile, polarisFile.getFinalCanonicalFile(allowedFolder))) {
                return finalCanonicalFile;
            }
            return null;
        } catch (IOException unused) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0017 A[Catch: IOException -> 0x0043, TryCatch #0 {IOException -> 0x0043, blocks: (B:3:0x0006, B:5:0x000b, B:10:0x0017, B:13:0x0023, B:16:0x002c, B:19:0x0033), top: B:2:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0023 A[Catch: IOException -> 0x0043, TryCatch #0 {IOException -> 0x0043, blocks: (B:3:0x0006, B:5:0x000b, B:10:0x0017, B:13:0x0023, B:16:0x002c, B:19:0x0033), top: B:2:0x0006 }] */
    @JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final File getSafeFileOrNull(String parent, String child) {
        boolean z;
        Intrinsics.checkParameterIsNotNull(child, "child");
        try {
            String str = parent;
            if (str != null && str.length() != 0) {
                z = false;
                if (!z) {
                    return INSTANCE.getFinalCanonicalFile(new File(parent, child));
                }
                PolarisFile polarisFile = INSTANCE;
                if (polarisFile.containsMaliciousPath$polaris_release(parent) || polarisFile.containsMaliciousPath$polaris_release(child)) {
                    return null;
                }
                File finalCanonicalFile = polarisFile.getFinalCanonicalFile(new File(parent, child));
                if (polarisFile.isFileInTargetDir$polaris_release(finalCanonicalFile, parent)) {
                    return finalCanonicalFile;
                }
                return null;
            }
            z = true;
            if (!z) {
            }
        } catch (IOException unused) {
            return null;
        }
    }

    @JvmStatic
    public static final File getSafeFileOrNull(File parent, String child) {
        Intrinsics.checkParameterIsNotNull(child, "child");
        return getSafeFileOrNull(parent != null ? parent.getPath() : null, child);
    }

    @JvmStatic
    public static final FileOutputStream getSafeFileOutputStreamUnderAllowedFolder(String name, String allowedFolder) throws FileNotFoundException {
        Intrinsics.checkParameterIsNotNull(name, "name");
        Intrinsics.checkParameterIsNotNull(allowedFolder, "allowedFolder");
        return getSafeFileOutputStreamUnderAllowedFolder(name, false, new File(allowedFolder));
    }

    @JvmStatic
    public static final FileOutputStream getSafeFileOutputStreamUnderAllowedFolder(String name, File allowedFolder) throws FileNotFoundException {
        Intrinsics.checkParameterIsNotNull(name, "name");
        Intrinsics.checkParameterIsNotNull(allowedFolder, "allowedFolder");
        return getSafeFileOutputStreamUnderAllowedFolder(name, false, allowedFolder);
    }

    @JvmStatic
    public static final FileOutputStream getSafeFileOutputStreamUnderAllowedFolder(String name, boolean append, String allowedFolder) throws FileNotFoundException {
        Intrinsics.checkParameterIsNotNull(name, "name");
        Intrinsics.checkParameterIsNotNull(allowedFolder, "allowedFolder");
        return getSafeFileOutputStreamUnderAllowedFolder(name, append, new File(allowedFolder));
    }

    @JvmStatic
    public static final FileOutputStream getSafeFileOutputStreamUnderAllowedFolder(String name, boolean append, File allowedFolder) throws FileNotFoundException {
        Intrinsics.checkParameterIsNotNull(name, "name");
        Intrinsics.checkParameterIsNotNull(allowedFolder, "allowedFolder");
        PolarisFile polarisFile = INSTANCE;
        File finalCanonicalFile = polarisFile.getFinalCanonicalFile(new File(name));
        if (polarisFile.containsMaliciousPath$polaris_release(name) || !polarisFile.isFileInTargetDir$polaris_release(finalCanonicalFile, polarisFile.getFinalCanonicalFile(allowedFolder))) {
            throw new FileNotFoundException("Malicious file path");
        }
        return new FileOutputStream(finalCanonicalFile, append);
    }

    @JvmStatic
    public static final FileInputStream getSafeFileInputStreamUnderAllowedFolder(String name, String allowedFolder) throws FileNotFoundException {
        Intrinsics.checkParameterIsNotNull(name, "name");
        Intrinsics.checkParameterIsNotNull(allowedFolder, "allowedFolder");
        return getSafeFileInputStreamUnderAllowedFolder(name, new File(allowedFolder));
    }

    @JvmStatic
    public static final FileInputStream getSafeFileInputStreamUnderAllowedFolder(String name, File allowedFolder) throws FileNotFoundException {
        Intrinsics.checkParameterIsNotNull(name, "name");
        Intrinsics.checkParameterIsNotNull(allowedFolder, "allowedFolder");
        PolarisFile polarisFile = INSTANCE;
        File finalCanonicalFile = polarisFile.getFinalCanonicalFile(new File(name));
        if (polarisFile.containsMaliciousPath$polaris_release(name) || !polarisFile.isFileInTargetDir$polaris_release(finalCanonicalFile, polarisFile.getFinalCanonicalFile(allowedFolder))) {
            throw new FileNotFoundException("Malicious file path");
        }
        return new FileInputStream(finalCanonicalFile);
    }

    @JvmStatic
    public static final FileWriter getSafeFileWriterUnderAllowedFolder(String fileName, String allowedFolder) throws IOException {
        Intrinsics.checkParameterIsNotNull(fileName, "fileName");
        Intrinsics.checkParameterIsNotNull(allowedFolder, "allowedFolder");
        return getSafeFileWriterUnderAllowedFolder(fileName, false, new File(allowedFolder));
    }

    @JvmStatic
    public static final FileWriter getSafeFileWriterUnderAllowedFolder(String fileName, File allowedFolder) throws IOException {
        Intrinsics.checkParameterIsNotNull(fileName, "fileName");
        Intrinsics.checkParameterIsNotNull(allowedFolder, "allowedFolder");
        return getSafeFileWriterUnderAllowedFolder(fileName, false, allowedFolder);
    }

    @JvmStatic
    public static final FileWriter getSafeFileWriterUnderAllowedFolder(String fileName, boolean append, String allowedFolder) throws IOException {
        Intrinsics.checkParameterIsNotNull(fileName, "fileName");
        Intrinsics.checkParameterIsNotNull(allowedFolder, "allowedFolder");
        return getSafeFileWriterUnderAllowedFolder(fileName, append, new File(allowedFolder));
    }

    @JvmStatic
    public static final FileWriter getSafeFileWriterUnderAllowedFolder(String fileName, boolean append, File allowedFolder) throws IOException {
        Intrinsics.checkParameterIsNotNull(fileName, "fileName");
        Intrinsics.checkParameterIsNotNull(allowedFolder, "allowedFolder");
        PolarisFile polarisFile = INSTANCE;
        File finalCanonicalFile = polarisFile.getFinalCanonicalFile(new File(fileName));
        if (polarisFile.containsMaliciousPath$polaris_release(fileName) || !polarisFile.isFileInTargetDir$polaris_release(finalCanonicalFile, polarisFile.getFinalCanonicalFile(allowedFolder))) {
            throw new FileNotFoundException("Malicious file path");
        }
        return new FileWriter(finalCanonicalFile, append);
    }

    @JvmStatic
    public static final FileReader getSafeFileReaderUnderAllowedFolder(String fileName, String allowedFolder) throws FileNotFoundException {
        Intrinsics.checkParameterIsNotNull(fileName, "fileName");
        Intrinsics.checkParameterIsNotNull(allowedFolder, "allowedFolder");
        return getSafeFileReaderUnderAllowedFolder(fileName, new File(allowedFolder));
    }

    @JvmStatic
    public static final FileReader getSafeFileReaderUnderAllowedFolder(String fileName, File allowedFolder) throws FileNotFoundException {
        Intrinsics.checkParameterIsNotNull(fileName, "fileName");
        Intrinsics.checkParameterIsNotNull(allowedFolder, "allowedFolder");
        PolarisFile polarisFile = INSTANCE;
        File finalCanonicalFile = polarisFile.getFinalCanonicalFile(new File(fileName));
        if (polarisFile.containsMaliciousPath$polaris_release(fileName) || !polarisFile.isFileInTargetDir$polaris_release(finalCanonicalFile, polarisFile.getFinalCanonicalFile(allowedFolder))) {
            throw new FileNotFoundException("Malicious file path");
        }
        return new FileReader(finalCanonicalFile);
    }
}
