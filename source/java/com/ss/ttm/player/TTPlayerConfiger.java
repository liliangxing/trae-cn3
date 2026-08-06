package com.ss.ttm.player;

import android.content.Context;
import android.util.Log;
import com.bytedance.keva.KevaImpl;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes7.dex */
public final class TTPlayerConfiger {
    private static String APP_EXTERNAL_DATA_PATH = null;
    private static String APP_PATH = null;
    private static String CRASH_FILE_NAME = "ttplayer_crash.log";
    private static String CRASH_FILE_PATH = null;
    public static final boolean DEBUG = false;
    public static final int DEFAULT_POOL_STACK_SIZE = 32;
    public static final int DEFAULT_VC2_DEC_POOL_SIZE = 2;
    public static final int DEFAULT_VC2_STACK_SIZE_VALUE = 131072;
    public static final int DEFAULT_VC2_THREAD_PRIORITY_VALUE = 5242880;
    public static final int FALSE = 0;
    public static boolean IS_PRINT_INFO = false;
    public static final int IS_TIME_OUT_COUNT = 3;
    private static final ConcurrentHashMap<Integer, Value> KEYS = new ConcurrentHashMap<>();
    public static final int KEY_IS_AUDIOTRACK_POOL_CHECK_INTERVAL = 82;
    public static final int KEY_IS_AUDIOTRACK_POOL_EXPIRE_CHECK = 81;
    public static final int KEY_IS_AUDIOTRACK_POOL_MAX_USED_COUNT = 50;
    public static final int KEY_IS_AUDIOTRACK_POOL_SAMPLES_CHECK = 51;
    public static final int KEY_IS_AUDIOTRACK_POOL_SIZE = 47;
    public static final int KEY_IS_AUDIOX_BAT_CONFIG_JSON = 77;
    public static final int KEY_IS_AUDIO_ADAPTER_MAX_QUEUE_SIZE = 52;
    public static final int KEY_IS_AUDIO_ADAPTER_MAX_USE_COUNT = 53;
    public static final int KEY_IS_AUDIO_DECODER_THREAD_STACK_SIZE_KB = 63;
    public static final int KEY_IS_AUDIO_GRAPH_THREAD_STACK_SIZE_KB = 72;
    public static final int KEY_IS_AUDIO_OUTLET_THREAD_STACK_SIZE_KB = 61;
    public static final int KEY_IS_AUDIO_POOL_MAX_SAME_COUNT = 89;
    public static final int KEY_IS_AV_BASE_PLAYER_THREAD_STACK_SIZE_KB = 65;
    public static final int KEY_IS_AV_FORMATER_THREAD_STACK_SIZE_KB = 66;
    public static final int KEY_IS_BATTERY_INFO = 23;
    public static final int KEY_IS_BUSINESS_TYPE = 33;
    public static final int KEY_IS_CHECK_LIB = 3;
    public static final int KEY_IS_CHECK_TTPLAYER_MODEL = 0;
    public static final int KEY_IS_CRASHED = 7;
    public static final int KEY_IS_CRASH_FILE_NAME = 17;
    public static final int KEY_IS_CRASH_PATH = 19;
    public static final int KEY_IS_DEBUG_MODEL = 6;
    public static final int KEY_IS_DIRECTBUFFER_POOL_CHECK_INTERVAL = 86;
    public static final int KEY_IS_DIRECTBUFFER_POOL_EXPIRE_CHECK = 85;
    public static final int KEY_IS_DIRECTBUFFER_POOL_SIZE = 84;
    public static final int KEY_IS_ENABLE_AUDIOTRACK_POOL_REFACTOR = 90;
    public static final int KEY_IS_ENABLE_AUDIOTRACK_PRECREATE_ASYNC = 91;
    public static final int KEY_IS_ENABLE_AUDIOX_PLUGIN = 78;
    public static final int KEY_IS_ENABLE_AVBUFFER_REUSE = 79;
    public static final int KEY_IS_ENABLE_AVPACKET_REUSE = 80;
    public static final int KEY_IS_ENABLE_GLOBAL_MUTE_FEATURE = 31;
    public static final int KEY_IS_ENABLE_LOAD_AFLNA_SO = 83;
    public static final int KEY_IS_ENABLE_LOAD_AFLNS_SO = 92;
    public static final int KEY_IS_ENABLE_REFACTOR_LOGGER = 75;
    public static final int KEY_IS_ENABLE_THREAD2_POOL = 45;
    public static final int KEY_IS_ENABLE_VC2_DEC_POOL = 41;
    public static final int KEY_IS_ENABLE_VC2_THREAD_PRIORITY = 34;
    public static final int KEY_IS_ENABLE_VC2_THREAD_PRIORITY_LITE = 36;
    public static final int KEY_IS_EXO_PLAYER_ON = 26;
    public static final int KEY_IS_FALLBACK_EXO_FIRST = 27;
    public static final int KEY_IS_FAST_MALLOC_ARENAS_NUM = 68;
    public static final int KEY_IS_FAST_MALLOC_ENABLE_TCACHE = 69;
    public static final int KEY_IS_FAST_MALLOC_LG_CHUNK = 71;
    public static final int KEY_IS_FAST_MALLOC_LG_TCACHE_MAX = 70;
    public static final int KEY_IS_FORBID_CREATED_OS_PLAYER = 11;
    public static final int KEY_IS_FOREGROUND = 21;
    public static final int KEY_IS_FREEDOM_PLAYER_ON = 37;
    public static final int KEY_IS_GET_VC2_DEC_POOL_SIZE = 42;
    public static final int KEY_IS_GLOBAL_AUDIO_GRAPH_POOL = 93;
    public static final int KEY_IS_GLOBAL_AVMESSAGE_POOL_SIZE = 56;
    public static final int KEY_IS_GLOBAL_BUFFER_POOL = 55;
    public static final int KEY_IS_GLOBAL_CHECK_POOL_EXPIRE_INTERVAL_MS = 58;
    public static final int KEY_IS_GLOBAL_ENABLE_MEMORY_POOL = 59;
    public static final int KEY_IS_GLOBAL_FFPKTBUFFER_POOL_SIZE = 57;
    public static final int KEY_IS_GLOBAL_FF_REGISTER_CACHE = 88;
    public static final int KEY_IS_GLOBAL_MEMORY_OPT = 49;
    public static final int KEY_IS_GLOBAL_MEM_POOL_BLOCKSIZE = 87;
    public static final int KEY_IS_GLOBAL_MUTE = 32;
    public static final int KEY_IS_GLOBAL_QOS_LOOPER = 44;
    public static final int KEY_IS_GLOBAL_THREAD2_REFACTOR = 54;
    public static final int KEY_IS_IPTTPLAYER_ON = 2;
    public static final int KEY_IS_LOG_FILE_DIR = 20;
    public static final int KEY_IS_LOOPER_THREAD_STACK_SIZE_KB = 67;
    public static final int KEY_IS_MEDIA_CODEC_USING_CODEC2 = 48;
    public static final int KEY_IS_ON_SCREEN = 22;
    public static final int KEY_IS_OPEN_DEVICE_FAIL = 8;
    public static final int KEY_IS_OTHER_THREAD_STACK_SIZE_KB = 73;
    public static final int KEY_IS_PLAYER_CREATION_CONFIG = 43;
    public static final int KEY_IS_PORT_VERSION = 18;
    public static final int KEY_IS_PRINT_INFO = 5;
    public static final int KEY_IS_SDK_VERSION = 13;
    public static final int KEY_IS_SDK_VERSION_INFO = 15;
    public static final int KEY_IS_SDK_VERSION_NAME = 14;
    public static final int KEY_IS_SKIP_LOAD_SSL = 28;
    public static final int KEY_IS_SKIP_LOAD_STL = 30;
    public static final int KEY_IS_START_SERVICE = 16;
    public static final int KEY_IS_STOP_SERVICE = 12;
    public static final int KEY_IS_THREAD2_POOL_SIZE = 46;
    public static final int KEY_IS_THREAD_POOL_STACK_SIZE = 25;
    public static final int KEY_IS_THREAD_V2 = 38;
    public static final int KEY_IS_THROW_CRASH = 4;
    public static final int KEY_IS_TIMEOUT_COUNT = 10;
    public static final int KEY_IS_TTPLAYER_ON = 1;
    public static final int KEY_IS_TUNER_GLOBAL_UPDATE_SIZE = 74;
    public static final int KEY_IS_USED_THREAD_POOL = 24;
    public static final int KEY_IS_USE_BETA_PLAYER = 29;
    public static final int KEY_IS_USE_PGO_PLAYER = 76;
    public static final int KEY_IS_VC2_STACK_SIZE_OPT = 39;
    public static final int KEY_IS_VC2_STACK_SIZE_VALUE = 40;
    public static final int KEY_IS_VC2_THREAD_PRIORITY_VALUE = 35;
    public static final int KEY_IS_VIDEO_DECODER_THREAD_STACK_SIZE_KB = 62;
    public static final int KEY_IS_VIDEO_MEDIACODEC_THREAD_STACK_SIZE_KB = 64;
    public static final int KEY_IS_VIDEO_OUTLET_THREAD_STACK_SIZE_KB = 60;
    private static String LIBRARY_DIR = null;
    private static String PLAYER_LIBRARY_NAME = "libttmplayer.so";
    private static final int PORT_VERSION = 2;
    public static final String TAG = "ttplayer";
    public static final int TRUE = 1;
    private static String TTPLAYER_FILE_CACHE_DIR = null;
    private static final int VERSION = 1;
    private static final String VERSION_INFO = "version code:1,name:999.999.999.9default sdk info 2016-12-05";
    private static final String VERSION_NAME = "999.999.999.9";

    public static void checkDebugTTPlayerLib() {
    }

    public static final String getExternalStorageDirectoryCrashFilePath(Context context) {
        return null;
    }

    public static final int getVersion() {
        return 1;
    }

    static {
        setValue(13, 1);
        setValue(14, VERSION_NAME);
        setValue(15, VERSION_INFO);
        setValue(0, false);
        setValue(1, true);
        setValue(2, true);
        setValue(3, false);
        setValue(4, false);
        setValue(5, false);
        setValue(6, false);
        setValue(7, false);
        setValue(8, false);
        setValue(10, 0);
        setValue(11, false);
        setValue(18, 2);
        setValue(25, 32);
        setValue(34, 0);
        setValue(35, 5242880);
        setValue(36, 0);
        setValue(39, 0);
        setValue(40, 131072);
        setValue(41, 0);
        setValue(42, 2);
        setValue(47, 3);
        setValue(48, 0);
        setValue(50, 20);
        setValue(51, 0);
        setValue(74, 0);
    }

    public static final String getValue(int key, String dValue) {
        if (key == 17) {
            return CRASH_FILE_NAME;
        }
        Value value = KEYS.get(Integer.valueOf(key));
        return (value == null || !(value instanceof StringValue)) ? dValue : ((StringValue) value).getValue();
    }

    public static final boolean getValue(int key, boolean dValue) {
        Value value = KEYS.get(Integer.valueOf(key));
        return (value == null || !(value instanceof IntValue)) ? dValue : ((IntValue) value).getValue() == 1;
    }

    public static final int getValue(int key, int dValue) {
        Value value = KEYS.get(Integer.valueOf(key));
        return (value == null || !(value instanceof IntValue)) ? dValue : ((IntValue) value).getValue();
    }

    public static final long getValue(int key, long dValue) {
        Value value = KEYS.get(Integer.valueOf(key));
        return (value == null || !(value instanceof LongValue)) ? dValue : ((LongValue) value).getValue();
    }

    public static final void setValue(int i, boolean z) {
        setValue(i, z ? 1 : 0);
    }

    public static final void setValue(int key, int value) {
        ConcurrentHashMap<Integer, Value> concurrentHashMap = KEYS;
        Value value2 = concurrentHashMap.get(Integer.valueOf(key));
        if (value2 != null) {
            if (value2 instanceof IntValue) {
                if (key == 2 && getValue(6, false)) {
                    return;
                }
                ((IntValue) value2).setValue(value);
                return;
            }
            concurrentHashMap.remove(Integer.valueOf(key));
        }
        concurrentHashMap.put(Integer.valueOf(key), new IntValue(key, value));
    }

    public static final void setValue(int key, long value) {
        ConcurrentHashMap<Integer, Value> concurrentHashMap = KEYS;
        Value value2 = concurrentHashMap.get(Integer.valueOf(key));
        if (value2 != null) {
            if (value2 instanceof LongValue) {
                ((LongValue) value2).setValue(value);
                return;
            }
            concurrentHashMap.remove(Integer.valueOf(key));
        }
        concurrentHashMap.put(Integer.valueOf(key), new LongValue(key, value));
    }

    public static final void setValue(int key, String value) {
        ConcurrentHashMap<Integer, Value> concurrentHashMap = KEYS;
        Value value2 = concurrentHashMap.get(Integer.valueOf(key));
        if (value2 != null) {
            if (value2 instanceof StringValue) {
                ((StringValue) value2).setValue(value);
                return;
            }
            concurrentHashMap.remove(Integer.valueOf(key));
        }
        concurrentHashMap.put(Integer.valueOf(key), new StringValue(key, value));
    }

    public static final boolean isOnTTPlayer() {
        if (getValue(6, 0) == 1) {
            return true;
        }
        if (getValue(1, 0) == 0) {
            return false;
        }
        if (getValue(11, 0) == 1) {
            return true;
        }
        return (getValue(7, 0) == 1 || getValue(8, 0) == 1 || getValue(10, 0) >= 3) ? false : true;
    }

    public static final void setLibraryName(String name) {
        PLAYER_LIBRARY_NAME = name;
    }

    public static final void setLibrarysDir(String dir) {
        LIBRARY_DIR = dir;
    }

    public static final void setCrashFileName(String name) {
        CRASH_FILE_NAME = name;
    }

    public static final void setCrashFilePath(String path) {
        CRASH_FILE_PATH = path;
    }

    public static final String getAppFilesPath(Context context) {
        String str = APP_PATH;
        if (str != null) {
            return str;
        }
        if (context == null) {
            return null;
        }
        try {
            APP_PATH = context.getApplicationContext().getFilesDir().getAbsolutePath();
            try {
                APP_EXTERNAL_DATA_PATH = ((File) Objects.requireNonNull(context.getApplicationContext().getExternalCacheDir())).getAbsolutePath();
            } catch (Exception unused) {
            }
            return APP_PATH;
        } catch (Exception unused2) {
            return null;
        }
    }

    public static final String getAppExternalDataPath() {
        return APP_EXTERNAL_DATA_PATH;
    }

    public static final String getAppCrashFilePath2(Context context) {
        if (context != null && APP_PATH == null) {
            APP_PATH = context.getApplicationContext().getFilesDir().getAbsolutePath();
        }
        if (CRASH_FILE_PATH == null) {
            if (APP_PATH == null) {
                APP_PATH = getAppFilesPath(context);
            }
            if (isPrintInfo()) {
                Log.i(TAG, "<TTPlayerConfigure.java,getAppCrashFilePath2,211>app files path:" + APP_PATH);
            }
            if (APP_PATH != null) {
                return APP_PATH + File.separatorChar + CRASH_FILE_NAME;
            }
            return null;
        }
        if (isPrintInfo()) {
            Log.i(TAG, "<TTPlayerConfigure.java,getAppCrashFileStorePath,195>carsh file path:" + CRASH_FILE_PATH);
        }
        return CRASH_FILE_PATH;
    }

    public static final String getPlugerCrashFilePath(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append(APP_PATH).append(File.separatorChar);
        sb.append("plugins").append(File.separatorChar);
        sb.append("com.ss.ttm").append(File.separatorChar);
        sb.append("data").append(File.separatorChar);
        sb.append(KevaImpl.PrivateConstants.FILES_DIR_NAME).append(File.separatorChar);
        sb.append(CRASH_FILE_NAME);
        return sb.toString();
    }

    @Deprecated
    public static final String getAppCrashFileStorePath(Context context) {
        if (context != null && APP_PATH == null) {
            APP_PATH = context.getApplicationContext().getFilesDir().getAbsolutePath();
        }
        if (CRASH_FILE_PATH == null) {
            if (APP_PATH == null) {
                APP_PATH = getAppFilesPath(context);
            }
            if (isPrintInfo()) {
                Log.i(TAG, "<TTPlayerConfigure.java,getAppCrashFileStorePath,245>app files path:" + APP_PATH);
            }
            if (APP_PATH != null) {
                return APP_PATH + File.separatorChar + CRASH_FILE_NAME;
            }
            return null;
        }
        if (isPrintInfo()) {
            Log.i(TAG, "<TTPlayerConfigure.java,getAppCrashFileStorePath,253>carsh file path:" + CRASH_FILE_PATH);
        }
        return CRASH_FILE_PATH;
    }

    @Deprecated
    public static final String getAppCrashFilePath(Context context) {
        if (CRASH_FILE_PATH == null && !new File(getAppCrashFileStorePath(context)).exists()) {
            StringBuilder sb = new StringBuilder();
            sb.append(APP_PATH).append(File.separatorChar);
            sb.append("plugins").append(File.separatorChar);
            sb.append("com.ss.ttm").append(File.separatorChar);
            sb.append("data").append(File.separatorChar);
            sb.append(KevaImpl.PrivateConstants.FILES_DIR_NAME).append(File.separatorChar);
            sb.append(CRASH_FILE_NAME);
            return sb.toString();
        }
        if (isPrintInfo()) {
            Log.i(TAG, "<TTPlayerConfigure.java,getAppCrashFileStorePath,278>carsh file path:" + CRASH_FILE_PATH);
        }
        return CRASH_FILE_PATH;
    }

    public static final String getAppFileCachePath(Context context) {
        if (context != null && APP_PATH == null) {
            APP_PATH = context.getApplicationContext().getFilesDir().getAbsolutePath();
        }
        String str = TTPLAYER_FILE_CACHE_DIR;
        if (str != null) {
            return str;
        }
        String str2 = APP_PATH;
        if (str2 != null) {
            return str2;
        }
        if (context == null) {
            return null;
        }
        try {
            String absolutePath = context.getApplicationContext().getFilesDir().getAbsolutePath();
            APP_PATH = absolutePath;
            return absolutePath;
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean isPrintInfo() {
        return IS_PRINT_INFO;
    }

    public static String getPlayerLibrarysDir(Context context) {
        String str = LIBRARY_DIR;
        if (str == null) {
            String str2 = getAppFilesPath(context) + File.separatorChar;
            LIBRARY_DIR = str2;
            return str2;
        }
        if (str.endsWith(String.valueOf(File.separatorChar))) {
            return LIBRARY_DIR;
        }
        return LIBRARY_DIR + File.separatorChar;
    }

    public static String getPlayerLibraryPath(Context context) {
        if (APP_PATH == null || context != null) {
            APP_PATH = getAppFilesPath(context);
        }
        if (APP_PATH == null && LIBRARY_DIR == null) {
            return null;
        }
        String str = LIBRARY_DIR;
        if (str != null) {
            if (str.endsWith(String.valueOf(File.separatorChar))) {
                return LIBRARY_DIR + PLAYER_LIBRARY_NAME;
            }
            return LIBRARY_DIR + File.separatorChar + PLAYER_LIBRARY_NAME;
        }
        return APP_PATH + File.separatorChar + PLAYER_LIBRARY_NAME;
    }

    public static String getPlayerLibraryPath() {
        return getPlayerLibraryPath(null);
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x0088 A[Catch: IOException -> 0x0084, TRY_LEAVE, TryCatch #10 {IOException -> 0x0084, blocks: (B:67:0x0080, B:60:0x0088), top: B:66:0x0080 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0080 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean copyFile(String destFileName, String srcFileName, boolean overlay, boolean deleteSrc) {
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;
        Throwable th;
        File file = new File(srcFileName);
        if (!file.exists() || !file.isFile()) {
            return false;
        }
        File file2 = new File(destFileName);
        if (file2.exists()) {
            if (overlay) {
                new File(destFileName).delete();
            }
        } else if (!file2.getParentFile().exists() && !file2.getParentFile().mkdirs()) {
            return false;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    fileOutputStream.close();
                    fileInputStream.close();
                    if (deleteSrc) {
                        file.delete();
                    }
                    try {
                        fileOutputStream.close();
                        fileInputStream.close();
                        return true;
                    } catch (IOException e) {
                        e.printStackTrace();
                        return true;
                    }
                } catch (FileNotFoundException unused) {
                    fileOutputStream2 = fileOutputStream;
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            return false;
                        }
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    return false;
                } catch (IOException unused2) {
                    fileOutputStream2 = fileOutputStream;
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                            return false;
                        }
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                            throw th;
                        }
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    throw th;
                }
            } catch (FileNotFoundException unused3) {
            } catch (IOException unused4) {
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
                th = th;
                if (fileOutputStream != null) {
                }
                if (fileInputStream != null) {
                }
                throw th;
            }
        } catch (FileNotFoundException unused5) {
            fileInputStream = null;
        } catch (IOException unused6) {
            fileInputStream = null;
        } catch (Throwable th4) {
            th = th4;
            fileInputStream = null;
            fileOutputStream = null;
        }
    }

    public static final boolean moveFile(String destFileName, String srcFileName, boolean overlay) {
        return copyFile(destFileName, srcFileName, overlay, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static class Value {
        private int mKey;

        protected Value(int key) {
            this.mKey = key;
        }

        public int getKey() {
            return this.mKey;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class IntValue extends Value {
        private int mValue;

        public IntValue(int key, int value) {
            super(key);
            this.mValue = value;
        }

        public void setValue(int value) {
            this.mValue = value;
        }

        public int getValue() {
            return this.mValue;
        }
    }

    /* loaded from: classes7.dex */
    static class LongValue extends Value {
        private long mValue;

        public LongValue(int key, long value) {
            super(key);
            this.mValue = value;
        }

        public void setValue(long value) {
            this.mValue = value;
        }

        public long getValue() {
            return this.mValue;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static class StringValue extends Value {
        private String mValue;

        public StringValue(int key, String value) {
            super(key);
            this.mValue = value;
        }

        public void setValue(String value) {
            this.mValue = value;
        }

        public String getValue() {
            return this.mValue;
        }
    }
}
