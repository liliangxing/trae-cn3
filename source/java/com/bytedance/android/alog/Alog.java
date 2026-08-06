package com.bytedance.android.alog;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.pia.core.misc.UrlMatcher;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Pattern;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes2.dex */
public class Alog {
    static final long INVALID_NATIVE_REF = 0;
    public static final int LEVEL_ALL = 0;
    public static final int LEVEL_DEBUG = 1;
    public static final int LEVEL_ERROR = 4;
    public static final int LEVEL_FATAL = 5;
    public static final int LEVEL_INFO = 2;
    public static final int LEVEL_SILENT = 6;
    public static final int LEVEL_VERBOSE = 0;
    public static final int LEVEL_WARNING = 3;
    private static final int defaultCacheFileSizeEach = 65536;
    private static final int defaultCacheFileSizeTotal = 196608;
    private static final String defaultInstanceName = "default";
    private static final int defaultLevel = 0;
    private static final int defaultLogFileExpDays = 7;
    private static final int defaultLogFileSizeEach = 2097152;
    private static final int defaultLogFileSizeTotal = 20971520;
    private static final String defaultServerPublicKey = "b012e20c9aab1cb5257aca2069cb79a9339b3a2224f771c78d64972137936eaf0b2f7ebd8d46c2607e1d7fe7723d40b147b8ecfa8fe2eaeee05210c75822381a";
    private static final String defaultSubFolder = "/alog";
    private static final boolean defaultSyslog = false;
    private static final String libName = "alog";
    private int cacheFileCount;
    private String cacheFileDir;
    private int cacheFileSizeEach;
    private Context ctx;
    private String instanceName;
    private int level;
    private String logFileDir;
    private String processName = null;
    private long ref;
    private static final int defaultMode = Mode.SAFE.getValue();
    private static final int defaultTimeFormat = TimeFormat.RAW.getValue();
    private static final int defaultPrefixFormat = PrefixFormat.DEFAULT.getValue();
    private static final int defaultCompress = Compress.ZSTD.getValue();
    private static final int defaultSymCrypt = SymCrypt.TEA_16.getValue();
    private static final int defaultAsymCrypt = AsymCrypt.EC_SECP256K1.getValue();
    private static volatile List<IMessageInterceptor> sMessageInterceptors = null;
    private static final ArrayList<String> instanceNames = new ArrayList<>();
    private static boolean inited = false;

    private static native void nativeAsyncFlush(long j);

    private static native long nativeCreate(int i, boolean z, String str, String str2, int i2, int i3, int i4, String str3, int i5, int i6, String str4, int i7, int i8, int i9, int i10, int i11, int i12, String str5, boolean z2, long j);

    private static native void nativeDestroy(long j);

    private static native long nativeGetLegacyFlushFuncAddr();

    private static native long nativeGetLegacyGetLogFileDirFuncAddr();

    private static native long nativeGetLegacyWriteFuncAddr();

    private static native long nativeGetNativeInitFuncAddr();

    private static native long nativeGetNativeWriteAsyncFuncAddr();

    private static native long nativeGetNativeWriteFuncAddr();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native void nativeSetDefaultInstance(long j);

    private static native void nativeSetLevel(long j, int i);

    private static native void nativeSetSyslog(long j, boolean z);

    private static native void nativeSyncFlush(long j);

    private static native void nativeTimedSyncFlush(long j, int i);

    private static native void nativeWrite(long j, int i, String str, String str2);

    private static native void nativeWriteAsyncMsg(long j, int i, String str, String str2, long j2, long j3);

    public static synchronized void init() {
        synchronized (Alog.class) {
            init(null);
        }
    }

    public static synchronized void init(ILibLoader iLibLoader) {
        synchronized (Alog.class) {
            if (inited) {
                return;
            }
            if (iLibLoader == null) {
                System.loadLibrary("alog");
            } else {
                iLibLoader.loadLibrary("alog");
            }
            inited = true;
        }
    }

    public Alog(Context context, int i, boolean z, String str, String str2, int i2, int i3, int i4, String str3, int i5, int i6, String str4, int i7, int i8, int i9, int i10, int i11, int i12, String str5, boolean z2) {
        this.ctx = context;
        this.level = i;
        this.logFileDir = str2;
        this.cacheFileDir = str3;
        this.cacheFileSizeEach = i5;
        this.cacheFileCount = i6 / i5;
        this.instanceName = str;
        this.ref = nativeCreate(i, z, str, str2, i2, i3, i4, str3, i5, i6, str4, i7, i8, i9, i10, i11, i12, str5, z2, TimeZone.getDefault().getRawOffset() / 1000);
    }

    public void close() {
        synchronized (this) {
            long j = this.ref;
            if (j != 0) {
                this.ctx = null;
                this.level = 6;
                nativeDestroy(j);
                this.ref = 0L;
            }
        }
    }

    public void finalize() throws Throwable {
        try {
            super.finalize();
        } finally {
            close();
        }
    }

    public static void addMessageInterceptor(IMessageInterceptor iMessageInterceptor) {
        if (iMessageInterceptor == null) {
            return;
        }
        if (sMessageInterceptors == null) {
            sMessageInterceptors = new CopyOnWriteArrayList();
        }
        if (sMessageInterceptors.contains(iMessageInterceptor)) {
            return;
        }
        sMessageInterceptors.add(iMessageInterceptor);
    }

    public static void removeMessageInterceptor(IMessageInterceptor iMessageInterceptor) {
        if (iMessageInterceptor == null || sMessageInterceptors == null) {
            return;
        }
        sMessageInterceptors.remove(iMessageInterceptor);
    }

    public void write(int i, String str, String str2) {
        if (this.ref == 0 || i < this.level || str == null || str2 == null) {
            return;
        }
        if (sMessageInterceptors != null) {
            MsgInfo msgInfo = new MsgInfo(i, str, str2);
            Iterator<IMessageInterceptor> it = sMessageInterceptors.iterator();
            while (it.hasNext()) {
                msgInfo = it.next().intercept(msgInfo);
            }
            if (msgInfo == null) {
                return;
            }
            nativeWrite(this.ref, msgInfo.level, msgInfo.tag, msgInfo.msg);
            return;
        }
        nativeWrite(this.ref, i, str, str2);
    }

    public void writeAsyncMsg(int i, String str, String str2, long j, long j2) {
        if (this.ref == 0 || i < this.level || str == null || str2 == null) {
            return;
        }
        if (sMessageInterceptors != null) {
            MsgInfo msgInfo = new MsgInfo(i, str, str2);
            Iterator<IMessageInterceptor> it = sMessageInterceptors.iterator();
            while (it.hasNext()) {
                msgInfo = it.next().intercept(msgInfo);
            }
            if (msgInfo == null) {
                return;
            }
            nativeWriteAsyncMsg(this.ref, msgInfo.level, msgInfo.tag, msgInfo.msg, j, j2);
            return;
        }
        nativeWriteAsyncMsg(this.ref, i, str, str2, j, j2);
    }

    public void asyncFlush() {
        long j = this.ref;
        if (j != 0) {
            nativeAsyncFlush(j);
        }
    }

    public void syncFlush() {
        long j = this.ref;
        if (j != 0) {
            nativeSyncFlush(j);
        }
    }

    public void timedSyncFlush(int i) {
        long j = this.ref;
        if (j != 0) {
            nativeTimedSyncFlush(j, i);
        }
    }

    public void setLevel(int i) {
        this.level = i;
        long j = this.ref;
        if (j != 0) {
            nativeSetLevel(j, i);
        }
    }

    public void setSyslog(boolean z) {
        long j = this.ref;
        if (j != 0) {
            nativeSetSyslog(j, z);
        }
    }

    public long getLegacyWriteFuncAddr() {
        if (this.ref != 0) {
            return nativeGetLegacyWriteFuncAddr();
        }
        return 0L;
    }

    public long getLegacyFlushFuncAddr() {
        if (this.ref != 0) {
            return nativeGetLegacyFlushFuncAddr();
        }
        return 0L;
    }

    public long getLegacyGetLogFileDirFuncAddr() {
        if (this.ref != 0) {
            return nativeGetLegacyGetLogFileDirFuncAddr();
        }
        return 0L;
    }

    public long getNativeWriteFuncAddr() {
        if (this.ref != 0) {
            return nativeGetNativeWriteFuncAddr();
        }
        return 0L;
    }

    public long getNativeWriteAsyncFuncAddr() {
        if (this.ref != 0) {
            return nativeGetNativeWriteAsyncFuncAddr();
        }
        return 0L;
    }

    public long getNativeInitFuncAddr() {
        if (this.ref != 0) {
            return nativeGetNativeInitFuncAddr();
        }
        return 0L;
    }

    public void v(String str, String str2) {
        write(0, str, str2);
    }

    public void d(String str, String str2) {
        write(1, str, str2);
    }

    public void i(String str, String str2) {
        write(2, str, str2);
    }

    public void w(String str, String str2) {
        write(3, str, str2);
    }

    public void e(String str, String str2) {
        write(4, str, str2);
    }

    public void f(String str, String str2) {
        write(5, str, str2);
    }

    public File[] getLogs(long j, long j2) {
        if (this.processName == null) {
            String processName = Util.getProcessName(this.ctx);
            this.processName = processName;
            if (processName == null) {
                return new File[0];
            }
        }
        return FileManager.getLogs(this.logFileDir, this.processName, this.instanceName, j, j2);
    }

    public File[] getLogs(String str, long j, long j2) {
        return getLogs(str, this.instanceName, j, j2);
    }

    public File[] getLogs(String str, String str2, long j, long j2) {
        return FileManager.getLogs(this.logFileDir, str, str2, j, j2);
    }

    public static File[] getLogs(String str, String str2, String str3, long j, long j2) {
        return FileManager.getLogs(str, str2, str3, j, j2);
    }

    public HashMap<String, String> getLastFetchErrorInfo() {
        return FileManager.getLastErrorInfo();
    }

    public String getStatus() {
        File[] fileArr;
        Pattern pattern;
        int i;
        if (!inited) {
            return "not inited";
        }
        if (this.processName == null) {
            this.processName = Util.getProcessName(this.ctx);
        }
        String str = this.processName;
        if (str == null) {
            return "get process name failed";
        }
        String replace = str.replace(AbstractJsonLexerKt.COLON, '-');
        File file = new File(this.cacheFileDir);
        if (!file.exists()) {
            return "cache dir not exists";
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return "cache dir is empty";
        }
        String str2 = replace + "__" + this.instanceName + ".alog.cache.guard";
        Pattern compile = Pattern.compile(UrlMatcher.EXTRACTOR + Pattern.quote(replace) + "__" + Pattern.quote(this.instanceName) + "__\\d{5}\\.alog\\.cache$");
        int length = listFiles.length;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (i2 < length) {
            File file2 = listFiles[i2];
            if (file2.getName().equals(str2)) {
                i3++;
                if (file2.length() >= 24576) {
                    i4++;
                }
                fileArr = listFiles;
            } else {
                fileArr = listFiles;
                if (file2.getName().startsWith(replace + "__" + this.instanceName + "__") && compile.matcher(file2.getName()).find()) {
                    i5++;
                    pattern = compile;
                    i = length;
                    if (file2.length() >= this.cacheFileSizeEach) {
                        i6++;
                    }
                    i2++;
                    compile = pattern;
                    listFiles = fileArr;
                    length = i;
                }
            }
            pattern = compile;
            i = length;
            i2++;
            compile = pattern;
            listFiles = fileArr;
            length = i;
        }
        if (i3 < 1) {
            android.util.Log.d("alog_trace", str2);
            android.util.Log.d("alog_trace", file.getAbsolutePath());
            return "cache guard not exists";
        }
        if (i4 < 1) {
            return "cache guard size insufficiently";
        }
        int i7 = this.cacheFileCount;
        if (i5 < i7) {
            return "cache block count insufficiently";
        }
        if (i6 < i7) {
            return "cache block size insufficiently";
        }
        File file3 = new File(this.logFileDir);
        if (!file3.exists()) {
            return "log dir not exists";
        }
        final Pattern compile2 = Pattern.compile("^\\d{4}_\\d{2}_\\d{2}_\\d+__" + Pattern.quote(replace) + "__" + Pattern.quote(this.instanceName) + "\\.alog\\.hot$");
        File[] listFiles2 = file3.listFiles(new FilenameFilter() { // from class: com.bytedance.android.alog.Alog.1
            @Override // java.io.FilenameFilter
            public boolean accept(File file4, String str3) {
                return compile2.matcher(str3).find();
            }
        });
        return (listFiles2 == null || listFiles2.length == 0) ? "no log file for current process and instance" : "OK";
    }

    public long getNativeRef() {
        return this.ref;
    }

    /* loaded from: classes2.dex */
    public enum Mode {
        SPEED(0),
        SAFE(1);

        private final int value;

        Mode(int i) {
            this.value = i;
        }

        int getValue() {
            return this.value;
        }
    }

    /* loaded from: classes2.dex */
    public enum TimeFormat {
        RAW(0),
        ISO_8601(1);

        private final int value;

        TimeFormat(int i) {
            this.value = i;
        }

        int getValue() {
            return this.value;
        }
    }

    /* loaded from: classes2.dex */
    public enum PrefixFormat {
        DEFAULT(0),
        LEGACY(1);

        private final int value;

        PrefixFormat(int i) {
            this.value = i;
        }

        int getValue() {
            return this.value;
        }
    }

    /* loaded from: classes2.dex */
    public enum Compress {
        NONE(0),
        ZLIB(1),
        ZSTD(2);

        private final int value;

        Compress(int i) {
            this.value = i;
        }

        int getValue() {
            return this.value;
        }
    }

    /* loaded from: classes2.dex */
    public enum SymCrypt {
        NONE(0),
        TEA_16(1),
        TEA_32(2),
        TEA_64(3);

        private final int value;

        SymCrypt(int i) {
            this.value = i;
        }

        int getValue() {
            return this.value;
        }
    }

    /* loaded from: classes2.dex */
    public enum AsymCrypt {
        NONE(0),
        EC_SECP256K1(1),
        EC_SECP256R1(2);

        private final int value;

        AsymCrypt(int i) {
            this.value = i;
        }

        int getValue() {
            return this.value;
        }
    }

    /* loaded from: classes2.dex */
    public static class Builder {
        private Context ctx;
        private int level = 0;
        private boolean syslog = false;
        private String instanceName = null;
        private String logFileDir = null;
        private int logFileSizeEach = 2097152;
        private int logFileSizeTotal = Alog.defaultLogFileSizeTotal;
        private int logFileExpDays = 7;
        private String cacheFileDir = null;
        private int cacheFileSizeEach = 65536;
        private int cacheFileSizeTotal = 196608;
        private String appVersion = null;
        private int mode = Alog.defaultMode;
        private int timeFormat = Alog.defaultTimeFormat;
        private int prefixFormat = Alog.defaultPrefixFormat;
        private int compress = Alog.defaultCompress;
        private int symCrypt = Alog.defaultSymCrypt;
        private int asymCrypt = Alog.defaultAsymCrypt;
        private String serverPublicKey = Alog.defaultServerPublicKey;
        private boolean isNewCompression = false;

        public Builder(Context context) {
            Context applicationContext = context.getApplicationContext();
            this.ctx = applicationContext != null ? applicationContext : context;
        }

        public Builder setLevel(int i) {
            this.level = i;
            return this;
        }

        public Builder setSyslog(boolean z) {
            this.syslog = z;
            return this;
        }

        public Builder setInstanceName(String str) {
            if (!TextUtils.isEmpty(str)) {
                if (str.contains(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
                    str = str.replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "");
                }
                if (str.contains("_")) {
                    str = str.replace("_", "");
                }
                if (!TextUtils.isEmpty(str)) {
                    this.instanceName = str;
                }
            }
            return this;
        }

        public Builder setLogFileDir(String str) {
            this.logFileDir = str;
            return this;
        }

        public Builder setLogFileSizeEach(int i) {
            this.logFileSizeEach = i;
            return this;
        }

        public Builder setLogFileSizeTotal(int i) {
            this.logFileSizeTotal = i;
            return this;
        }

        public Builder setLogFileExpDays(int i) {
            this.logFileExpDays = i;
            return this;
        }

        public Builder setCacheFileDir(String str) {
            this.cacheFileDir = str;
            return this;
        }

        public Builder setCacheFileSizeEach(int i) {
            this.cacheFileSizeEach = i;
            return this;
        }

        public Builder setCacheFileSizeTotal(int i) {
            this.cacheFileSizeTotal = i;
            return this;
        }

        public Builder setAppVersion(String str) {
            this.appVersion = str;
            return this;
        }

        public Builder setMode(Mode mode) {
            this.mode = mode.getValue();
            return this;
        }

        public Builder setTimeFormat(TimeFormat timeFormat) {
            this.timeFormat = timeFormat.getValue();
            return this;
        }

        public Builder setPrefixFormat(PrefixFormat prefixFormat) {
            this.prefixFormat = prefixFormat.getValue();
            return this;
        }

        public Builder setCompress(Compress compress) {
            this.compress = compress.getValue();
            return this;
        }

        public Builder setSymCrypt(SymCrypt symCrypt) {
            this.symCrypt = symCrypt.getValue();
            return this;
        }

        public Builder setAsymCrypt(AsymCrypt asymCrypt) {
            this.asymCrypt = asymCrypt.getValue();
            return this;
        }

        public Builder setServerPublicKey(String str) {
            this.serverPublicKey = str;
            return this;
        }

        public Builder setNewCompression(boolean z) {
            this.isNewCompression = z;
            return this;
        }

        public Alog build() {
            if (this.instanceName == null) {
                this.instanceName = "default";
            }
            synchronized (Alog.instanceNames) {
                Iterator it = Alog.instanceNames.iterator();
                while (it.hasNext()) {
                    if (((String) it.next()).equals(this.instanceName)) {
                        return null;
                    }
                }
                Alog.instanceNames.add(this.instanceName);
                if (this.logFileDir == null) {
                    File externalFilesDir = this.ctx.getExternalFilesDir(null);
                    if (externalFilesDir != null) {
                        this.logFileDir = externalFilesDir.getPath() + Alog.defaultSubFolder;
                    } else {
                        this.logFileDir = this.ctx.getFilesDir() + Alog.defaultSubFolder;
                    }
                }
                if (this.cacheFileDir == null) {
                    this.cacheFileDir = this.ctx.getFilesDir() + Alog.defaultSubFolder;
                }
                if (this.appVersion == null) {
                    this.appVersion = Util.getAppVersion(this.ctx);
                }
                int i = (this.cacheFileSizeEach / 4096) * 4096;
                this.cacheFileSizeEach = i;
                int i2 = (this.cacheFileSizeTotal / 4096) * 4096;
                this.cacheFileSizeTotal = i2;
                if (i < 4096) {
                    this.cacheFileSizeEach = 4096;
                }
                int i3 = this.cacheFileSizeEach;
                if (i2 < i3 * 2) {
                    this.cacheFileSizeTotal = i3 * 2;
                }
                return new Alog(this.ctx, this.level, this.syslog, this.instanceName, this.logFileDir, this.logFileSizeEach, this.logFileSizeTotal, this.logFileExpDays, this.cacheFileDir, this.cacheFileSizeEach, this.cacheFileSizeTotal, this.appVersion, this.mode, this.timeFormat, this.prefixFormat, this.compress, this.symCrypt, this.asymCrypt, this.serverPublicKey, this.isNewCompression);
            }
        }
    }
}
