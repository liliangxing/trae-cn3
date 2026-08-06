package com.facebook.soloader;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Parcel;
import android.os.Process;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import com.bytedance.librarian.LibrarianImpl;
import com.facebook.soloader.MinElf;
import com.ss.android.socialbase.downloader.file.DownloadFileUtils;
import com.ss.ttm.player.C;
import dalvik.system.BaseDexClassLoader;
import java.io.DataOutput;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.TreeSet;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import javax.annotation.Nullable;

/* loaded from: classes6.dex */
public final class SysUtil {
    private static final long APK_DEP_BLOCK_METADATA_LENGTH = 20;
    private static final byte APK_SIGNATURE_VERSION = 1;
    private static final String TAG = "SysUtil";

    public static int findAbiScore(String[] strArr, String str) {
        for (int i = 0; i < strArr.length; i++) {
            String str2 = strArr[i];
            if (str2 != null && str.equals(str2)) {
                return i;
            }
        }
        return -1;
    }

    public static void deleteOrThrow(File file) throws IOException {
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.canWrite() && !parentFile.setWritable(true)) {
            Log.e(TAG, "Enable write permission failed: " + parentFile);
        }
        if (!file.delete() && file.exists()) {
            throw new IOException("Could not delete file " + file);
        }
    }

    public static String[] getSupportedAbis() {
        return MarshmallowSysdeps.getSupportedAbis();
    }

    public static void fallocateIfSupported(FileDescriptor fileDescriptor, long j) throws IOException {
        LollipopSysdeps.fallocateIfSupported(fileDescriptor, j);
    }

    public static void dumbDeleteRecursive(File file) throws IOException {
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                return;
            }
            for (File file2 : listFiles) {
                dumbDeleteRecursive(file2);
            }
        }
        deleteOrThrow(file);
    }

    /* loaded from: classes6.dex */
    private static final class LollipopSysdeps {
        private LollipopSysdeps() {
        }

        public static String[] getSupportedAbis() {
            String[] strArr = Build.SUPPORTED_ABIS;
            TreeSet treeSet = new TreeSet();
            try {
                if (is64Bit()) {
                    treeSet.add(MinElf.ISA.AARCH64.toString());
                    treeSet.add(MinElf.ISA.X86_64.toString());
                } else {
                    treeSet.add(MinElf.ISA.ARM.toString());
                    treeSet.add(MinElf.ISA.X86.toString());
                }
                ArrayList arrayList = new ArrayList();
                for (String str : strArr) {
                    if (treeSet.contains(str)) {
                        arrayList.add(str);
                    }
                }
                return (String[]) arrayList.toArray(new String[arrayList.size()]);
            } catch (ErrnoException e) {
                Log.e(SysUtil.TAG, String.format("Could not read /proc/self/exe. Falling back to default ABI list: %s. errno: %d Err msg: %s", Arrays.toString(strArr), Integer.valueOf(e.errno), e.getMessage()));
                return Build.SUPPORTED_ABIS;
            }
        }

        public static void fallocateIfSupported(FileDescriptor fileDescriptor, long j) throws IOException {
            try {
                Os.posix_fallocate(fileDescriptor, 0L, j);
            } catch (ErrnoException e) {
                if (e.errno != OsConstants.EOPNOTSUPP && e.errno != OsConstants.ENOSYS && e.errno != OsConstants.EINVAL) {
                    throw new IOException(e.toString(), e);
                }
            }
        }

        public static boolean is64Bit() throws ErrnoException {
            return Os.readlink("/proc/self/exe").contains("64");
        }
    }

    /* loaded from: classes6.dex */
    private static final class MarshmallowSysdeps {
        private MarshmallowSysdeps() {
        }

        public static String[] getSupportedAbis() {
            String[] strArr = Build.SUPPORTED_ABIS;
            TreeSet treeSet = new TreeSet();
            if (is64Bit()) {
                treeSet.add(MinElf.ISA.AARCH64.toString());
                treeSet.add(MinElf.ISA.X86_64.toString());
            } else {
                treeSet.add(MinElf.ISA.ARM.toString());
                treeSet.add(MinElf.ISA.X86.toString());
            }
            ArrayList arrayList = new ArrayList();
            for (String str : strArr) {
                if (treeSet.contains(str)) {
                    arrayList.add(str);
                }
            }
            return (String[]) arrayList.toArray(new String[arrayList.size()]);
        }

        public static boolean is64Bit() {
            return Process.is64Bit();
        }

        public static boolean isSupportedDirectLoad(Context context, int i) throws IOException {
            if (i == 2) {
                return isApkUncompressedDso(context);
            }
            return isDisabledExtractNativeLibs(context);
        }

        public static boolean isDisabledExtractNativeLibs(Context context) {
            return context != null && (context.getApplicationInfo().flags & C.ENCODING_PCM_MU_LAW) == 0;
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x003f, code lost:
        
            if (r1.getMethod() != 0) goto L15;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0041, code lost:
        
            r2 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x0042, code lost:
        
            r5.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x0045, code lost:
        
            return r2;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private static boolean isApkUncompressedDso(Context context) throws IOException {
            ZipFile zipFile = new ZipFile(new File(context.getApplicationInfo().sourceDir));
            try {
                Enumeration<? extends ZipEntry> entries = zipFile.entries();
                while (true) {
                    boolean z = false;
                    if (!entries.hasMoreElements()) {
                        zipFile.close();
                        return false;
                    }
                    ZipEntry nextElement = entries.nextElement();
                    if (nextElement != null && nextElement.getName().endsWith(LibrarianImpl.Constants.SO_SUFFIX) && nextElement.getName().contains("/lib")) {
                        break;
                    }
                }
            } catch (Throwable th) {
                try {
                    zipFile.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
    }

    public static void mkdirOrThrow(File file) throws IOException {
        if (!file.mkdirs() && !file.isDirectory()) {
            throw new IOException("cannot mkdir: " + file);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int copyBytes(DataOutput dataOutput, InputStream inputStream, int i, byte[] bArr) throws IOException {
        int i2 = 0;
        while (i2 < i) {
            int read = inputStream.read(bArr, 0, Math.min(bArr.length, i - i2));
            if (read == -1) {
                break;
            }
            dataOutput.write(bArr, 0, read);
            i2 += read;
        }
        return i2;
    }

    public static void fsyncRecursive(File file) throws IOException {
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                throw new IOException("cannot list directory " + file);
            }
            for (File file2 : listFiles) {
                fsyncRecursive(file2);
            }
            return;
        }
        if (file.getPath().endsWith("_lock")) {
            return;
        }
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, DownloadFileUtils.MODE_READ);
        try {
            randomAccessFile.getFD().sync();
            randomAccessFile.close();
        } catch (Throwable th) {
            try {
                randomAccessFile.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private static long getParcelPadSize(long j) {
        return j + ((4 - (j % 4)) % 4);
    }

    public static long getApkDepBlockLength(File file) throws IOException {
        return getParcelPadSize((file.getCanonicalFile().getPath().length() + 1) * 2) + 20;
    }

    public static byte[] makeApkDepBlock(File file, Context context) throws IOException {
        File canonicalFile = file.getCanonicalFile();
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeByte((byte) 1);
            obtain.writeString(canonicalFile.getPath());
            obtain.writeLong(canonicalFile.lastModified());
            obtain.writeInt(getAppVersionCode(context));
            return obtain.marshall();
        } finally {
            obtain.recycle();
        }
    }

    public static int getAppVersionCode(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            try {
                return packageManager.getPackageInfo(context.getPackageName(), 0).versionCode;
            } catch (PackageManager.NameNotFoundException | RuntimeException unused) {
            }
        }
        return 0;
    }

    public static boolean is64Bit() {
        return MarshmallowSysdeps.is64Bit();
    }

    public static boolean isSupportedDirectLoad(Context context, int i) throws IOException {
        return MarshmallowSysdeps.isSupportedDirectLoad(context, i);
    }

    public static boolean isDisabledExtractNativeLibs(Context context) {
        return MarshmallowSysdeps.isDisabledExtractNativeLibs(context);
    }

    @Nullable
    public static FileLocker getOrCreateLockOnDir(File file, File file2, boolean z) throws IOException {
        boolean z2;
        try {
            if (z) {
                return FileLocker.lock(file2);
            }
            return FileLocker.tryLock(file2);
        } catch (FileNotFoundException e) {
            z2 = true;
            try {
                if (!file.setWritable(true)) {
                    throw e;
                }
                if (z) {
                    FileLocker lock = FileLocker.lock(file2);
                    if (!file.setWritable(false)) {
                        Log.w(TAG, "error removing " + file.getCanonicalPath() + " write permission");
                    }
                    return lock;
                }
                FileLocker tryLock = FileLocker.tryLock(file2);
                if (!file.setWritable(false)) {
                    Log.w(TAG, "error removing " + file.getCanonicalPath() + " write permission");
                }
                return tryLock;
            } catch (Throwable th) {
                th = th;
                if (z2 && !file.setWritable(false)) {
                    Log.w(TAG, "error removing " + file.getCanonicalPath() + " write permission");
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            z2 = false;
            if (z2) {
                Log.w(TAG, "error removing " + file.getCanonicalPath() + " write permission");
            }
            throw th;
        }
    }

    public static String getBaseName(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        return lastIndexOf > 0 ? str.substring(0, lastIndexOf) : str;
    }

    /* loaded from: classes6.dex */
    public static class Api14Utils {
        public static String getClassLoaderLdLoadLibrary() {
            ClassLoader classLoader = SoLoader.class.getClassLoader();
            if (classLoader != null && !(classLoader instanceof BaseDexClassLoader)) {
                throw new IllegalStateException("ClassLoader " + classLoader.getClass().getName() + " should be of type BaseDexClassLoader");
            }
            try {
                return (String) BaseDexClassLoader.class.getMethod("getLdLibraryPath", new Class[0]).invoke((BaseDexClassLoader) classLoader, new Object[0]);
            } catch (Exception e) {
                throw new RuntimeException("Cannot call getLdLibraryPath", e);
            }
        }
    }
}
