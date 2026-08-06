package com.bytedance.iesgurd.update;

import android.util.Log;
import com.bytedance.geckox.utils.BsPatch;
import com.bytedance.geckox.utils.CloseableUtils;
import com.bytedance.geckox.utils.FileUtils;
import com.bytedance.geckox.utils.MD5Utils;
import com.bytedance.iesgurd.exception.BytePatchException;
import com.bytedance.retrofit2.HttpMethodContrants;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* compiled from: BytePatch.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0011\b\u0000\u0018\u0000  2\u00020\u0001:\u0001 B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0004H\u0002J\u0018\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0004H\u0002J\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0004H\u0002J\b\u0010\u0016\u001a\u00020\u0010H\u0002J\b\u0010\u0017\u001a\u00020\u0010H\u0002J\u0018\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0004H\u0002J\u0018\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0004H\u0002J\"\u0010\u001b\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0014\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u0004J\b\u0010\u001c\u001a\u00020\u0006H\u0002J\u0012\u0010\u001d\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u0004H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/bytedance/iesgurd/update/BytePatch;", "", "()V", "mDest", "Ljava/io/File;", "mErrorPrefix", "", "mPatch", "mPatchRAF", "Ljava/io/RandomAccessFile;", "mPathHandled", "", "mSrc", "mVersion", "", "checkMD5ByRAF", "", "path", "copy", "src", "dest", "createDir", "doPatch", "handlePatch", "handleTypeModify", "oldFile", "handleTypeRename", "patch", "readMD5", "traversalSrc", "writeContentToFile", "file", "Companion", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class BytePatch {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String HEAD = "BYTEDIFF";
    private static final String PATCH_TEMP = "bytepatch_patch_temp_file";
    private static final String TAG = "BytePatch";
    private static final byte TYPE_ADD = 3;
    private static final byte TYPE_DELETE = 2;
    private static final byte TYPE_MODIFY = 1;
    private static final byte TYPE_RENAME = 4;
    private static final byte TYPE_REWRITE = 5;
    private static final byte TYPE_SAME = 6;
    private static final Map<Integer, String> TYPE_STR;
    private File mDest;
    private File mPatch;
    private RandomAccessFile mPatchRAF;
    private File mSrc;
    private int mVersion;
    private final Set<String> mPathHandled = new HashSet();
    private String mErrorPrefix = "";

    /* compiled from: BytePatch.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00040\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/bytedance/iesgurd/update/BytePatch$Companion;", "", "()V", HttpMethodContrants.HEAD, "", "PATCH_TEMP", "TAG", "TYPE_ADD", "", "TYPE_DELETE", "TYPE_MODIFY", "TYPE_RENAME", "TYPE_REWRITE", "TYPE_SAME", "TYPE_STR", "", "", "getRelativePath", "file", "Ljava/io/File;", "root", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String getRelativePath(File file, File root) {
            String absolutePath = file.getAbsolutePath();
            Intrinsics.checkExpressionValueIsNotNull(absolutePath, "file.absolutePath");
            if (root == null) {
                Intrinsics.throwNpe();
            }
            int length = root.getAbsolutePath().length() + 1;
            if (absolutePath == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            String substring = absolutePath.substring(length);
            Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.String).substring(startIndex)");
            return substring;
        }
    }

    static {
        HashMap hashMap = new HashMap();
        TYPE_STR = hashMap;
        hashMap.put(1, "modify");
        hashMap.put(2, "delete");
        hashMap.put(3, "add");
        hashMap.put(4, "rename");
        hashMap.put(5, "rewrite");
        hashMap.put(6, "same");
    }

    public final void patch(File src, File dest, File patch) throws BytePatchException {
        Intrinsics.checkParameterIsNotNull(dest, "dest");
        if (src == null || !src.exists() || src.isFile()) {
            StringBuilder sb = new StringBuilder("param src error: ");
            if (src == null) {
                Intrinsics.throwNpe();
            }
            throw new BytePatchException(BytePatchException.ErrorCode.paramsError, sb.append(src.getPath()).toString());
        }
        if (patch == null || !patch.exists() || patch.isDirectory()) {
            StringBuilder sb2 = new StringBuilder("param patch error: ");
            if (patch == null) {
                Intrinsics.throwNpe();
            }
            throw new BytePatchException(BytePatchException.ErrorCode.paramsError, sb2.append(patch.getPath()).toString());
        }
        if (dest.exists() && dest.isFile()) {
            throw new BytePatchException(BytePatchException.ErrorCode.paramsError, "param dest error,  is a file: " + dest.getPath());
        }
        if (dest.exists() && dest.isDirectory() && !FileUtils.delete(dest)) {
            throw new BytePatchException(BytePatchException.ErrorCode.paramsError, "param dest error, remove failed: " + dest.getPath());
        }
        this.mSrc = src;
        this.mDest = dest;
        this.mPatch = patch;
        doPatch();
    }

    private final void doPatch() throws BytePatchException {
        try {
            try {
                try {
                    RandomAccessFile randomAccessFile = new RandomAccessFile(this.mPatch, "rw");
                    this.mPatchRAF = randomAccessFile;
                    byte[] bArr = new byte[8];
                    randomAccessFile.readFully(bArr);
                    if (!Intrinsics.areEqual(HEAD, new String(bArr, Charsets.UTF_8))) {
                        throw new BytePatchException(1005, "not bytediff file: ".concat(new String(bArr, Charsets.UTF_8)));
                    }
                    RandomAccessFile randomAccessFile2 = this.mPatchRAF;
                    if (randomAccessFile2 == null) {
                        Intrinsics.throwNpe();
                    }
                    byte readByte = randomAccessFile2.readByte();
                    if (readByte > 1 || readByte < 0) {
                        throw new BytePatchException(1005, "unsupported version: " + ((int) readByte));
                    }
                    this.mVersion = readByte;
                    handlePatch();
                    this.mErrorPrefix = "";
                    if (readByte == 0) {
                        traversalSrc(this.mSrc);
                    }
                    Log.d(TAG, "patch success");
                } catch (Exception e) {
                    FileUtils.delete(this.mDest);
                    throw new BytePatchException(BytePatchException.ErrorCode.unknown, this.mErrorPrefix + e.getMessage());
                }
            } catch (BytePatchException e2) {
                FileUtils.delete(this.mDest);
                throw e2;
            }
        } finally {
            CloseableUtils.close(this.mPatchRAF);
        }
    }

    private final void handlePatch() throws Exception {
        while (true) {
            RandomAccessFile randomAccessFile = this.mPatchRAF;
            if (randomAccessFile == null) {
                Intrinsics.throwNpe();
            }
            long filePointer = randomAccessFile.getFilePointer();
            RandomAccessFile randomAccessFile2 = this.mPatchRAF;
            if (randomAccessFile2 == null) {
                Intrinsics.throwNpe();
            }
            if (filePointer == randomAccessFile2.length()) {
                return;
            }
            RandomAccessFile randomAccessFile3 = this.mPatchRAF;
            if (randomAccessFile3 == null) {
                Intrinsics.throwNpe();
            }
            String readUTF = randomAccessFile3.readUTF();
            Intrinsics.checkExpressionValueIsNotNull(readUTF, "path");
            if (readUTF.length() == 0) {
                throw new BytePatchException(1006, "read path is empty");
            }
            this.mPathHandled.add(readUTF);
            File file = new File(this.mSrc, readUTF);
            if (!StringsKt.startsWith$default(readUTF, "__MACOSX/", false, 2, (Object) null) && !Intrinsics.areEqual(readUTF, ".DS_Store")) {
                RandomAccessFile randomAccessFile4 = this.mPatchRAF;
                if (randomAccessFile4 == null) {
                    Intrinsics.throwNpe();
                }
                byte readByte = randomAccessFile4.readByte();
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                Map<Integer, String> map = TYPE_STR;
                String format = String.format("patch failed, type:%s, path:%s, detail:", Arrays.copyOf(new Object[]{map.get(Integer.valueOf(readByte)), readUTF}, 2));
                Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(format, *args)");
                this.mErrorPrefix = format;
                switch (readByte) {
                    case 1:
                        handleTypeModify(readUTF, file);
                        break;
                    case 2:
                        break;
                    case 3:
                        File file2 = new File(this.mDest, readUTF);
                        File parentFile = file2.getParentFile();
                        Intrinsics.checkExpressionValueIsNotNull(parentFile, "newFile.parentFile");
                        createDir(parentFile);
                        writeContentToFile(file2);
                        if (this.mVersion != 0) {
                            break;
                        } else {
                            checkMD5ByRAF(file2);
                            break;
                        }
                    case 4:
                        RandomAccessFile randomAccessFile5 = this.mPatchRAF;
                        if (randomAccessFile5 == null) {
                            Intrinsics.throwNpe();
                        }
                        String readUTF2 = randomAccessFile5.readUTF();
                        Intrinsics.checkExpressionValueIsNotNull(readUTF2, "newPath");
                        if (readUTF2.length() == 0) {
                            throw new BytePatchException(1006, this.mErrorPrefix + "read path is nil");
                        }
                        handleTypeRename(readUTF2, file);
                        break;
                    case 5:
                        RandomAccessFile randomAccessFile6 = this.mPatchRAF;
                        if (randomAccessFile6 == null) {
                            Intrinsics.throwNpe();
                        }
                        String readUTF3 = randomAccessFile6.readUTF();
                        Intrinsics.checkExpressionValueIsNotNull(readUTF3, "newPath");
                        if (readUTF3.length() == 0) {
                            throw new BytePatchException(1006, this.mErrorPrefix + "read path is nil");
                        }
                        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                        String format2 = String.format("patch failed, type:%s, path:%s, newPath: %s, detail:", Arrays.copyOf(new Object[]{map.get(Integer.valueOf(readByte)), readUTF, readUTF3}, 3));
                        Intrinsics.checkExpressionValueIsNotNull(format2, "java.lang.String.format(format, *args)");
                        this.mErrorPrefix = format2;
                        handleTypeModify(readUTF3, file);
                        break;
                    case 6:
                        handleTypeRename(readUTF, file);
                        break;
                    default:
                        throw new BytePatchException(1006, this.mErrorPrefix + "not support change type");
                }
            }
        }
    }

    private final void handleTypeModify(String path, File oldFile) throws Exception {
        if (!oldFile.exists()) {
            throw new BytePatchException(1006, this.mErrorPrefix + "path not exists: ");
        }
        File file = new File(this.mDest, path);
        File parentFile = file.getParentFile();
        Intrinsics.checkExpressionValueIsNotNull(parentFile, "newFile.parentFile");
        createDir(parentFile);
        File file2 = this.mPatch;
        if (file2 == null) {
            Intrinsics.throwNpe();
        }
        File file3 = new File(file2.getParentFile(), PATCH_TEMP);
        writeContentToFile(file3);
        try {
            BsPatch bsPatch = BsPatch.INSTANCE;
            File file4 = this.mDest;
            if (file4 == null) {
                Intrinsics.throwNpe();
            }
            bsPatch.patch(oldFile, file3, file4, path);
            file3.delete();
            String readMD5 = readMD5();
            String mD5$geckox_noasanRelease = MD5Utils.INSTANCE.getMD5$geckox_noasanRelease(file);
            if (!Intrinsics.areEqual(mD5$geckox_noasanRelease, readMD5)) {
                if (Intrinsics.areEqual(MD5Utils.INSTANCE.getMD5$geckox_noasanRelease(oldFile), readMD5)) {
                    throw new BytePatchException(1024, this.mErrorPrefix + "old file is same");
                }
                throw new BytePatchException(1011, this.mErrorPrefix + "md5 check failed, local md5:" + mD5$geckox_noasanRelease + ", expect md5:" + readMD5);
            }
        } catch (Exception e) {
            throw new BytePatchException(1010, this.mErrorPrefix + "bspatch error:" + e.getMessage());
        }
    }

    private final void handleTypeRename(String path, File oldFile) throws Exception {
        if (!oldFile.exists()) {
            throw new BytePatchException(1006, this.mErrorPrefix + "path not exists: ");
        }
        File file = new File(this.mDest, path);
        copy(oldFile, file);
        if (this.mVersion == 0) {
            String readMD5 = readMD5();
            String mD5$geckox_noasanRelease = MD5Utils.INSTANCE.getMD5$geckox_noasanRelease(file);
            if (!Intrinsics.areEqual(mD5$geckox_noasanRelease, readMD5)) {
                String mD5$geckox_noasanRelease2 = MD5Utils.INSTANCE.getMD5$geckox_noasanRelease(oldFile);
                if (!Intrinsics.areEqual(mD5$geckox_noasanRelease2, mD5$geckox_noasanRelease)) {
                    throw new BytePatchException(1013, this.mErrorPrefix + "copy error, old file md5:" + mD5$geckox_noasanRelease2 + ", new file md5:" + mD5$geckox_noasanRelease + ", expect md5:" + readMD5);
                }
                throw new BytePatchException(1011, this.mErrorPrefix + "md5 check failed, local md5:" + mD5$geckox_noasanRelease + ", expect md5:" + readMD5);
            }
        }
    }

    private final void traversalSrc(File src) throws Exception {
        if (src == null) {
            Intrinsics.throwNpe();
        }
        File[] listFiles = src.listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                Intrinsics.checkExpressionValueIsNotNull(file, "file");
                if (file.isFile()) {
                    String relativePath = INSTANCE.getRelativePath(file, this.mSrc);
                    if (!this.mPathHandled.contains(relativePath) && !StringsKt.endsWith$default(relativePath, ".gkfsf", false, 2, (Object) null)) {
                        copy(file, new File(this.mDest, relativePath));
                    }
                } else {
                    traversalSrc(file);
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x006b, code lost:
    
        r13 = r12.mPatchRAF;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x006d, code lost:
    
        if (r13 != null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x006f, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwNpe();
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0072, code lost:
    
        r2 = (int) r7;
        r13.readFully(r0, 0, r2);
        r4.write(r0, 0, r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void writeContentToFile(File file) throws Exception {
        long readLong;
        FileOutputStream fileOutputStream;
        if (file.exists() && !file.delete()) {
            throw new BytePatchException(1007, this.mErrorPrefix + "remove old file error: " + file.getPath());
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                RandomAccessFile randomAccessFile = this.mPatchRAF;
                if (randomAccessFile == null) {
                    Intrinsics.throwNpe();
                }
                readLong = randomAccessFile.readLong();
                fileOutputStream = new FileOutputStream(file);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e) {
            e = e;
        }
        try {
            byte[] bArr = new byte[8192];
            long j = 0;
            while (true) {
                if (j >= readLong) {
                    break;
                }
                long j2 = readLong - j;
                long j3 = 8192;
                if (j2 < j3) {
                    break;
                }
                j += j3;
                RandomAccessFile randomAccessFile2 = this.mPatchRAF;
                if (randomAccessFile2 == null) {
                    Intrinsics.throwNpe();
                }
                randomAccessFile2.readFully(bArr);
                fileOutputStream.write(bArr);
            }
            CloseableUtils.close(fileOutputStream);
        } catch (Exception e2) {
            e = e2;
            throw new BytePatchException(1007, this.mErrorPrefix + e.getMessage());
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            CloseableUtils.close(fileOutputStream2);
            throw th;
        }
    }

    private final void createDir(File src) throws Exception {
        try {
            FileUtils.INSTANCE.createDir$geckox_noasanRelease(src);
        } catch (Exception e) {
            throw new BytePatchException(1012, this.mErrorPrefix + e.getMessage());
        }
    }

    private final void copy(File src, File dest) throws Exception {
        FileChannel fileChannel;
        File parentFile = dest.getParentFile();
        Intrinsics.checkExpressionValueIsNotNull(parentFile, "dest.parentFile");
        createDir(parentFile);
        FileChannel fileChannel2 = null;
        try {
            FileChannel channel = new FileInputStream(src).getChannel();
            try {
                fileChannel2 = new FileOutputStream(dest).getChannel();
                long size = channel.size();
                long j = 0;
                while (size > 0) {
                    long transferTo = channel.transferTo(j, size, fileChannel2);
                    if (transferTo > 0) {
                        j += transferTo;
                        size -= transferTo;
                    }
                }
                CloseableUtils.close(channel);
                CloseableUtils.close(fileChannel2);
            } catch (Exception e) {
                e = e;
                fileChannel = fileChannel2;
                fileChannel2 = channel;
                try {
                    throw new BytePatchException(1012, this.mErrorPrefix + e.getMessage());
                } catch (Throwable th) {
                    th = th;
                    CloseableUtils.close(fileChannel2);
                    CloseableUtils.close(fileChannel);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                fileChannel = fileChannel2;
                fileChannel2 = channel;
                CloseableUtils.close(fileChannel2);
                CloseableUtils.close(fileChannel);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            fileChannel = null;
        } catch (Throwable th3) {
            th = th3;
            fileChannel = null;
        }
    }

    private final String readMD5() throws Exception {
        byte[] bArr = new byte[32];
        RandomAccessFile randomAccessFile = this.mPatchRAF;
        if (randomAccessFile == null) {
            Intrinsics.throwNpe();
        }
        randomAccessFile.readFully(bArr);
        return new String(bArr, Charsets.UTF_8);
    }

    private final void checkMD5ByRAF(File path) throws Exception {
        String readMD5 = readMD5();
        String mD5$geckox_noasanRelease = MD5Utils.INSTANCE.getMD5$geckox_noasanRelease(path);
        if (!Intrinsics.areEqual(mD5$geckox_noasanRelease, readMD5)) {
            throw new BytePatchException(1011, this.mErrorPrefix + "md5 check failed, local md5:" + mD5$geckox_noasanRelease + ", expect md5:" + readMD5);
        }
    }
}
