package com.bytedance.librarian;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import com.bytedance.android.anniex.solutions.card.AirActionConstant;
import com.bytedance.librarian.elf.ElfParser;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class LibrarianImpl {
    private static final String[] SYSTEM_LIB_LIST = {"log", AirActionConstant.ActionId.ACTION_ID_MEMBER, "stdc++", "dl", AirActionConstant.ActionId.ACTION_ID_CALL, "z", "android", "jnigraphics", "EGL", "GLESv1_CM", "GLESv2", "GLESv3", "OpenSLES", "OpenMAXAL"};
    static final LibrarianImpl instance;
    private String mAbi;
    private Map<String, String> mAbiToInstructionSetMap;
    private String[] mAbis;
    private ZipFile[] mApkZipFiles;
    private ApplicationInfo mApplicationInfo;
    private volatile boolean mIsLazyInitialized;
    private final File mLockFile;
    private final LibrarianMonitor mMonitor;
    private File mNativeLibDir;
    private String mVmInstructionSet;
    private final File mWorkDir;
    final String[] SYSTEM_LIB64_DIR_LIST = {"/system/lib64", "/vendor/lib64"};
    private final Map<String, LibRecorder> mLoadedLibMap = new HashMap();

    /* loaded from: classes4.dex */
    interface Constants {
        public static final int BUFFER_SIZE = 8192;
        public static final String DEFAULT_VERSION = "default.version";
        public static final String DOT = ".";
        public static final String LIB_PREFIX = "lib";
        public static final String LOCK_FILE_NAME = "process.lock";
        public static final String SEPARATOR = "/";
        public static final String SO_SUFFIX = ".so";
        public static final String TAG = "librarian";
    }

    private boolean tryOptimizeNativeLibDirsOnLollipop(String str) {
        return false;
    }

    static {
        Context context = Librarian.sContext;
        Librarian.sContext = null;
        if (context == null) {
            throw new LibrarianUnsatisfiedLinkError("you should call init first or use loadLibraryForModule.");
        }
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        File dir = context.getDir(Constants.TAG, 0);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        File file = new File(dir, (Librarian.sVersion != null ? Librarian.sVersion : Constants.DEFAULT_VERSION) + Constants.DOT + (new File(applicationInfo.sourceDir).lastModified() >> 8));
        File[] listFiles = dir.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (!file.getName().equals(file2.getName())) {
                    File[] listFiles2 = file2.listFiles();
                    if (listFiles2 != null) {
                        for (File file3 : listFiles2) {
                            file3.delete();
                        }
                    }
                    file2.delete();
                }
            }
        }
        file.mkdirs();
        if (file.exists()) {
            instance = new LibrarianImpl(applicationInfo, file, Librarian.sMonitor != null ? Librarian.sMonitor : new LibrarianMonitor());
        } else {
            instance = null;
        }
    }

    private LibrarianImpl(ApplicationInfo applicationInfo, File file, LibrarianMonitor librarianMonitor) {
        this.mWorkDir = file;
        this.mMonitor = librarianMonitor;
        this.mApplicationInfo = applicationInfo;
        this.mLockFile = new File(file, Constants.LOCK_FILE_NAME);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getLoadedLibsInfo() {
        String obj;
        synchronized (this.mLoadedLibMap) {
            obj = this.mLoadedLibMap.toString();
        }
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void loadLibrary(String str, boolean z) {
        synchronized (this.mLoadedLibMap) {
            LibRecorder libRecorder = this.mLoadedLibMap.get(str);
            if (libRecorder != null) {
                if (libRecorder.loaded) {
                    return;
                }
            } else {
                libRecorder = new LibRecorder();
                this.mLoadedLibMap.put(str, libRecorder);
            }
            synchronized (libRecorder) {
                if (libRecorder.loaded) {
                    this.mMonitor.logDebug("lib was already loaded before: " + str);
                } else {
                    loadLibraryLockedRecorder(str, z);
                    libRecorder.loaded = true;
                }
            }
        }
    }

    private void loadLibraryLockedRecorder(String str, boolean z) {
        File file = new File(this.mWorkDir, getLibFileName(str));
        if (loadOriginLib(str, "preload")) {
            return;
        }
        if (file.exists() && loadExtractedLib(file, str, false)) {
            return;
        }
        checkLazyInitialization();
        if (tryOptimizeNativeLibDirsOnLollipop(str) && loadOriginLib(str, "lollipop")) {
            return;
        }
        File obtainValidLibFile = obtainValidLibFile(str, file, z);
        loadDependencyLibs(obtainValidLibFile, z);
        if (obtainValidLibFile != file) {
            if (loadOriginLib(str, "after loading dep libs")) {
                return;
            } else {
                extractLibFromZip(file, z);
            }
        }
        loadExtractedLib(file, str, true);
    }

    private File obtainValidLibFile(String str, File file, boolean z) {
        File file2 = new File(this.mNativeLibDir, getLibFileName(str));
        if (checkLibValid(file2)) {
            return file2;
        }
        extractLibFromZip(file, z);
        return file;
    }

    private void extractLibFromZip(File file, boolean z) {
        Locker locker;
        String name = file.getName();
        synchronized (this) {
            try {
                locker = new Locker(this.mLockFile);
                try {
                    locker.lock();
                    if (!doExtractLibFromZip(file)) {
                        if (!z) {
                            throw new LibrarianUnsatisfiedLinkError("fail to extract " + name);
                        }
                        this.mMonitor.logDebug("may be system lib, no found " + name);
                    }
                } catch (IOException e) {
                    throw new LibrarianUnsatisfiedLinkError("fail to extract " + name, e);
                }
            } finally {
                locker.close();
            }
        }
    }

    private boolean checkLibValid(File file) {
        long j;
        if (!file.exists()) {
            this.mMonitor.logWarning("file is not exist: " + file.getPath());
            return false;
        }
        ensureRuntimeAbi(file.getName());
        String str = "lib/" + this.mAbi + "/" + file.getName();
        ZipFile[] zipFileArr = this.mApkZipFiles;
        int length = zipFileArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                j = 0;
                break;
            }
            ZipEntry entry = zipFileArr[i].getEntry(str);
            if (entry != null) {
                j = entry.getCrc();
                break;
            }
            i++;
        }
        long doFileCheckSum = doFileCheckSum(file);
        if (j == doFileCheckSum) {
            this.mMonitor.logDebug(str + " compare crc ok: entry is " + j + ", file is " + doFileCheckSum);
            return true;
        }
        this.mMonitor.logWarning(str + " crc is wrong: entry is " + j + ", file is " + doFileCheckSum);
        return false;
    }

    private boolean loadOriginLib(String str, String str2) {
        try {
            this.mMonitor.systemLoadLibrary(str);
            this.mMonitor.logDebug("loaded the origin lib " + str + ", tag: " + str2);
            return true;
        } catch (UnsatisfiedLinkError e) {
            this.mMonitor.logWarning("fail to load " + str + ", tag: " + str2, e);
            return false;
        }
    }

    private boolean loadExtractedLib(File file, String str, boolean z) {
        try {
            this.mMonitor.systemLoad(file.getPath());
            this.mMonitor.logDebug("loaded the extracted lib " + str);
            return true;
        } catch (UnsatisfiedLinkError e) {
            if (z) {
                throw new LibrarianUnsatisfiedLinkError("finally fail to load " + file.getPath(), e);
            }
            this.mMonitor.logWarning("fail to load " + file.getName() + ", out lib exists", e);
            return false;
        }
    }

    private void loadDependencyLibs(File file, boolean z) {
        try {
            Iterator<String> it = obtainDependencies(file).iterator();
            while (it.hasNext()) {
                String libBaseName = getLibBaseName(it.next());
                if (!isSystemLib(libBaseName)) {
                    this.mMonitor.logDebug("to load depended lib " + libBaseName);
                    loadLibrary(libBaseName, z);
                }
            }
        } catch (IOException e) {
            throw new LibrarianUnsatisfiedLinkError("fail to load depended lib", e);
        }
    }

    private void checkLazyInitialization() {
        if (this.mIsLazyInitialized) {
            return;
        }
        synchronized (this) {
            if (this.mIsLazyInitialized) {
                return;
            }
            File file = new File(this.mApplicationInfo.sourceDir);
            ArrayList arrayList = new ArrayList();
            arrayList.add(file);
            String[] strArr = this.mApplicationInfo.splitSourceDirs;
            if (strArr != null && strArr.length != 0) {
                for (String str : strArr) {
                    arrayList.add(new File(str));
                }
            }
            ZipFile[] zipFileArr = new ZipFile[arrayList.size()];
            Iterator it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                File file2 = (File) it.next();
                int i2 = i + 1;
                try {
                    zipFileArr[i] = new ZipFile(file2);
                } catch (IOException e) {
                    new LibrarianUnsatisfiedLinkError("fail to get zip file " + file2.getName() + ", size " + file2.length() + ", exists " + file2.exists(), e).printStackTrace();
                }
                i = i2;
            }
            this.mApkZipFiles = zipFileArr;
            this.mNativeLibDir = new File(this.mApplicationInfo.nativeLibraryDir);
            HashMap hashMap = new HashMap();
            this.mAbiToInstructionSetMap = hashMap;
            hashMap.put("arm64-v8a", "arm64");
            this.mAbiToInstructionSetMap.put("armeabi-v7a", "arm");
            this.mAbiToInstructionSetMap.put("armeabi", "arm");
            String str2 = null;
            try {
                Class<?> cls = Class.forName("dalvik.system.VMRuntime");
                str2 = (String) cls.getDeclaredMethod("vmInstructionSet", new Class[0]).invoke(cls.getDeclaredMethod("getRuntime", new Class[0]).invoke(null, new Object[0]), new Object[0]);
            } catch (Exception e2) {
                this.mMonitor.logWarning("fail to process vm abi previously", new LibrarianUnsatisfiedLinkError("reflect err", e2));
            }
            this.mVmInstructionSet = str2;
            this.mMonitor.logDebug("vm instruction set: " + this.mVmInstructionSet);
            this.mAbis = Build.SUPPORTED_ABIS;
            this.mIsLazyInitialized = true;
        }
    }

    private void swapFilesInList(File[] fileArr, int i, int i2) {
        if (i == i2) {
            return;
        }
        File file = fileArr[i];
        fileArr[i] = fileArr[i2];
        fileArr[i2] = file;
    }

    private boolean isSystemLibDir(String str) {
        for (String str2 : this.SYSTEM_LIB64_DIR_LIST) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    private boolean isSystemLib(String str) {
        for (String str2 : SYSTEM_LIB_LIST) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    private List<String> obtainDependencies(File file) throws IOException {
        Closeable closeable = null;
        try {
            ElfParser elfParser = new ElfParser(file);
            try {
                List<String> parseNeededDependencies = elfParser.parseNeededDependencies();
                Collections.sort(parseNeededDependencies);
                closeQuietly(elfParser);
                return parseNeededDependencies;
            } catch (Throwable th) {
                th = th;
                closeable = elfParser;
                closeQuietly(closeable);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private long doFileCheckSum(File file) {
        byte[] bArr = new byte[8192];
        Closeable closeable = null;
        try {
            try {
                CheckedInputStream checkedInputStream = new CheckedInputStream(new FileInputStream(file), new CRC32());
                do {
                    try {
                    } catch (IOException e) {
                        e = e;
                        closeable = checkedInputStream;
                        this.mMonitor.logWarning("fail to check sum for " + file.getPath(), e);
                        closeQuietly(closeable);
                        return 0L;
                    } catch (Throwable th) {
                        th = th;
                        closeable = checkedInputStream;
                        closeQuietly(closeable);
                        throw th;
                    }
                } while (checkedInputStream.read(bArr) >= 0);
                long value = checkedInputStream.getChecksum().getValue();
                closeQuietly(checkedInputStream);
                return value;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e2) {
            e = e2;
        }
    }

    private boolean doExtractLibFromZip(File file) throws IOException {
        ensureRuntimeAbi(file.getName());
        String str = "lib/" + this.mAbi + "/" + file.getName();
        for (ZipFile zipFile : this.mApkZipFiles) {
            ZipEntry entry = zipFile.getEntry(str);
            if (entry != null) {
                InputStream inputStream = zipFile.getInputStream(entry);
                try {
                    obtainEntryFileFromInputStream(inputStream, file);
                    this.mMonitor.logDebug("get lib file " + file.getPath() + " from " + str + " of " + zipFile.getName());
                    closeQuietly(inputStream);
                    return true;
                } catch (Throwable th) {
                    closeQuietly(inputStream);
                    throw th;
                }
            }
        }
        return false;
    }

    private void ensureRuntimeAbi(String str) {
        if (this.mAbi != null) {
            return;
        }
        for (String str2 : this.mAbis) {
            if (checkRuntimeAbi(str2)) {
                String str3 = "lib/" + str2 + "/" + str;
                for (ZipFile zipFile : this.mApkZipFiles) {
                    if (zipFile != null && zipFile.getEntry(str3) != null) {
                        this.mAbi = str2;
                        this.mMonitor.logDebug("ensure that abi is " + str2);
                        return;
                    }
                }
            }
        }
        throw new LibrarianUnsatisfiedLinkError("can not ensure abi for " + str + ", check " + this.mVmInstructionSet + ", apks " + getApkZipFileInfo());
    }

    private String getApkZipFileInfo() {
        StringBuilder sb = new StringBuilder("[");
        for (ZipFile zipFile : this.mApkZipFiles) {
            if (zipFile != null) {
                String name = zipFile.getName();
                sb.append(name).append("#").append(zipFile.size()).append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR).append(new File(name).length()).append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
            }
        }
        sb.append("]");
        return sb.toString();
    }

    private boolean checkRuntimeAbi(String str) {
        if (this.mVmInstructionSet == null) {
            return true;
        }
        String str2 = this.mAbiToInstructionSetMap.get(str);
        String str3 = this.mVmInstructionSet;
        if (str2 != null) {
            str = str2;
        }
        return str3.equals(str);
    }

    private static String getLibFileName(String str) {
        return Constants.LIB_PREFIX + str + Constants.SO_SUFFIX;
    }

    private static String getLibBaseName(String str) {
        return str.substring(3, str.length() - 3);
    }

    private File obtainEntryFileFromInputStream(InputStream inputStream, File file) throws IOException {
        File createTempFile = File.createTempFile("tmp-", file.getName(), file.getParentFile());
        this.mMonitor.logDebug("extracting " + createTempFile.getPath());
        FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
        try {
            byte[] bArr = new byte[8192];
            int read = inputStream.read(bArr);
            while (read != -1) {
                fileOutputStream.write(bArr, 0, read);
                read = inputStream.read(bArr);
            }
            if (!createTempFile.setReadOnly()) {
                throw new IOException("failed to mark readonly \"" + createTempFile.getAbsolutePath() + "\" (tmp of \"" + file.getAbsolutePath() + "\")");
            }
            this.mMonitor.logDebug("renaming to " + file.getPath());
            if (createTempFile.renameTo(file)) {
                return file;
            }
            throw new IOException("failed to rename \"" + createTempFile.getAbsolutePath() + "\" to \"" + file.getAbsolutePath() + "\"");
        } finally {
            closeQuietly(fileOutputStream);
            createTempFile.delete();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeQuietly(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException e) {
            this.mMonitor.logWarning("failed to close resource", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class LibRecorder {
        boolean loaded = false;

        LibRecorder() {
        }

        public String toString() {
            return Boolean.toString(this.loaded);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class Locker {
        private FileLock cacheLock;
        private FileChannel lockChannel;
        private File lockFile;
        private RandomAccessFile lockRaf;

        Locker(File file) {
            this.lockFile = file;
        }

        void lock() throws IOException {
            RandomAccessFile randomAccessFile = new RandomAccessFile(this.lockFile, "rw");
            this.lockRaf = randomAccessFile;
            try {
                this.lockChannel = randomAccessFile.getChannel();
                try {
                    LibrarianImpl.this.mMonitor.logDebug("blocking on lock " + this.lockFile.getPath());
                    this.cacheLock = this.lockChannel.lock();
                    LibrarianImpl.this.mMonitor.logDebug("acquired on lock " + this.lockFile.getPath());
                } catch (IOException e) {
                    LibrarianImpl.this.closeQuietly(this.lockChannel);
                    throw e;
                }
            } catch (IOException e2) {
                LibrarianImpl.this.closeQuietly(this.lockRaf);
                throw e2;
            }
        }

        void close() {
            FileLock fileLock = this.cacheLock;
            if (fileLock != null) {
                try {
                    fileLock.release();
                } catch (IOException unused) {
                }
            }
            LibrarianImpl.this.mMonitor.logDebug("released lock " + this.lockFile.getPath());
            LibrarianImpl.this.closeQuietly(this.lockChannel);
            LibrarianImpl.this.closeQuietly(this.lockRaf);
        }
    }
}
