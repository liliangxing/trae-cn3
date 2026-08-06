package com.bytedance.shadowhook;

/* loaded from: classes5.dex */
public final class ShadowHook {
    private static final int ERRNO_INIT_EXCEPTION = 101;
    private static final int ERRNO_LOAD_LIBRARY_EXCEPTION = 100;
    private static final int ERRNO_OK = 0;
    private static final int ERRNO_PENDING = 1;
    private static final int ERRNO_UNINIT = 2;
    private static final boolean defaultDebuggable = false;
    private static final ILibLoader defaultLibLoader = null;
    private static final int defaultMode = Mode.SHARED.getValue();
    private static final boolean defaultRecordable = false;
    private static long initCostMs = -1;
    private static int initErrno = 2;
    private static boolean inited = false;
    private static final String libName = "shadowhook";
    private static final int recordItemAll = 1023;
    private static final int recordItemBackupLen = 128;
    private static final int recordItemCallerLibName = 2;
    private static final int recordItemErrno = 256;
    private static final int recordItemLibName = 8;
    private static final int recordItemNewAddr = 64;
    private static final int recordItemOp = 4;
    private static final int recordItemStub = 512;
    private static final int recordItemSymAddr = 32;
    private static final int recordItemSymName = 16;
    private static final int recordItemTimestamp = 1;

    /* loaded from: classes5.dex */
    public interface ILibLoader {
        void loadLibrary(String str);
    }

    /* loaded from: classes5.dex */
    public enum RecordItem {
        TIMESTAMP,
        CALLER_LIB_NAME,
        OP,
        LIB_NAME,
        SYM_NAME,
        SYM_ADDR,
        NEW_ADDR,
        BACKUP_LEN,
        ERRNO,
        STUB
    }

    private static native String nativeGetArch();

    private static native boolean nativeGetDebuggable();

    private static native int nativeGetInitErrno();

    private static native int nativeGetMode();

    private static native boolean nativeGetRecordable();

    private static native String nativeGetRecords(int i);

    private static native String nativeGetVersion();

    private static native int nativeInit(int i, boolean z);

    private static native void nativeSetDebuggable(boolean z);

    private static native void nativeSetRecordable(boolean z);

    private static native String nativeToErrmsg(int i);

    public static String getVersion() {
        return nativeGetVersion();
    }

    public static int init() {
        return init(null);
    }

    public static synchronized int init(Config config) {
        synchronized (ShadowHook.class) {
            if (inited) {
                return initErrno;
            }
            inited = true;
            long currentTimeMillis = System.currentTimeMillis();
            if (config == null) {
                config = new ConfigBuilder().build();
            }
            if (!loadLibrary(config)) {
                initErrno = 100;
                initCostMs = System.currentTimeMillis() - currentTimeMillis;
                return initErrno;
            }
            try {
                initErrno = nativeInit(config.getMode(), config.getDebuggable());
            } catch (Throwable unused) {
                initErrno = 101;
            }
            if (config.getRecordable()) {
                try {
                    nativeSetRecordable(config.getRecordable());
                } catch (Throwable unused2) {
                    initErrno = 101;
                }
            }
            initCostMs = System.currentTimeMillis() - currentTimeMillis;
            return initErrno;
        }
    }

    public static int getInitErrno() {
        return initErrno;
    }

    public static long getInitCostMs() {
        return initCostMs;
    }

    public static Mode getMode() {
        if (isInitedOk()) {
            return Mode.SHARED.getValue() == nativeGetMode() ? Mode.SHARED : Mode.UNIQUE;
        }
        return Mode.SHARED;
    }

    public static boolean getDebuggable() {
        if (isInitedOk()) {
            return nativeGetDebuggable();
        }
        return false;
    }

    public static void setDebuggable(boolean z) {
        if (isInitedOk()) {
            nativeSetDebuggable(z);
        }
    }

    public static boolean getRecordable() {
        if (isInitedOk()) {
            return nativeGetRecordable();
        }
        return false;
    }

    public static void setRecordable(boolean z) {
        if (isInitedOk()) {
            nativeSetRecordable(z);
        }
    }

    public static String toErrmsg(int i) {
        return i == 0 ? "OK" : i == 1 ? "Pending task" : i == 2 ? "Not initialized" : i == 100 ? "Load libshadowhook.so failed" : i == 101 ? "Init exception" : isInitedOk() ? nativeToErrmsg(i) : "Unknown";
    }

    public static String getRecords(RecordItem... recordItemArr) {
        if (!isInitedOk()) {
            return null;
        }
        int i = 0;
        for (RecordItem recordItem : recordItemArr) {
            switch (AnonymousClass1.$SwitchMap$com$bytedance$shadowhook$ShadowHook$RecordItem[recordItem.ordinal()]) {
                case 1:
                    i |= 1;
                    break;
                case 2:
                    i |= 2;
                    break;
                case 3:
                    i |= 4;
                    break;
                case 4:
                    i |= 8;
                    break;
                case 5:
                    i |= 16;
                    break;
                case 6:
                    i |= 32;
                    break;
                case 7:
                    i |= 64;
                    break;
                case 8:
                    i |= 128;
                    break;
                case 9:
                    i |= 256;
                    break;
                case 10:
                    i |= 512;
                    break;
            }
        }
        if (i == 0) {
            i = 1023;
        }
        return nativeGetRecords(i);
    }

    /* renamed from: com.bytedance.shadowhook.ShadowHook$1, reason: invalid class name */
    /* loaded from: classes5.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$shadowhook$ShadowHook$RecordItem;

        static {
            int[] iArr = new int[RecordItem.values().length];
            $SwitchMap$com$bytedance$shadowhook$ShadowHook$RecordItem = iArr;
            try {
                iArr[RecordItem.TIMESTAMP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$bytedance$shadowhook$ShadowHook$RecordItem[RecordItem.CALLER_LIB_NAME.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$bytedance$shadowhook$ShadowHook$RecordItem[RecordItem.OP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$bytedance$shadowhook$ShadowHook$RecordItem[RecordItem.LIB_NAME.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$bytedance$shadowhook$ShadowHook$RecordItem[RecordItem.SYM_NAME.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$bytedance$shadowhook$ShadowHook$RecordItem[RecordItem.SYM_ADDR.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$bytedance$shadowhook$ShadowHook$RecordItem[RecordItem.NEW_ADDR.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$bytedance$shadowhook$ShadowHook$RecordItem[RecordItem.BACKUP_LEN.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$bytedance$shadowhook$ShadowHook$RecordItem[RecordItem.ERRNO.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$bytedance$shadowhook$ShadowHook$RecordItem[RecordItem.STUB.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    public static String getArch() {
        return isInitedOk() ? nativeGetArch() : "unknown";
    }

    private static boolean loadLibrary(Config config) {
        if (config != null) {
            try {
                if (config.getLibLoader() != null) {
                    config.getLibLoader().loadLibrary(libName);
                    return true;
                }
            } catch (Throwable unused) {
                return false;
            }
        }
        System.loadLibrary(libName);
        return true;
    }

    private static boolean loadLibrary() {
        return loadLibrary(null);
    }

    private static boolean isInitedOk() {
        if (inited) {
            return initErrno == 0;
        }
        if (!loadLibrary()) {
            return false;
        }
        try {
            int nativeGetInitErrno = nativeGetInitErrno();
            if (nativeGetInitErrno != 2) {
                initErrno = nativeGetInitErrno;
                inited = true;
            }
            return nativeGetInitErrno == 0;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* loaded from: classes5.dex */
    public static class Config {
        private boolean debuggable;
        private ILibLoader libLoader;
        private int mode;
        private boolean recordable;

        public void setLibLoader(ILibLoader iLibLoader) {
            this.libLoader = iLibLoader;
        }

        public ILibLoader getLibLoader() {
            return this.libLoader;
        }

        public void setMode(int i) {
            this.mode = i;
        }

        public int getMode() {
            return this.mode;
        }

        public void setDebuggable(boolean z) {
            this.debuggable = z;
        }

        public boolean getDebuggable() {
            return this.debuggable;
        }

        public void setRecordable(boolean z) {
            this.recordable = z;
        }

        public boolean getRecordable() {
            return this.recordable;
        }
    }

    /* loaded from: classes5.dex */
    public static class ConfigBuilder {
        private ILibLoader libLoader = ShadowHook.defaultLibLoader;
        private int mode = ShadowHook.defaultMode;
        private boolean debuggable = false;
        private boolean recordable = false;

        public ConfigBuilder setLibLoader(ILibLoader iLibLoader) {
            this.libLoader = iLibLoader;
            return this;
        }

        public ConfigBuilder setMode(Mode mode) {
            this.mode = mode.getValue();
            return this;
        }

        public ConfigBuilder setDebuggable(boolean z) {
            this.debuggable = z;
            return this;
        }

        public ConfigBuilder setRecordable(boolean z) {
            this.recordable = z;
            return this;
        }

        public Config build() {
            Config config = new Config();
            config.setLibLoader(this.libLoader);
            config.setMode(this.mode);
            config.setDebuggable(this.debuggable);
            config.setRecordable(this.recordable);
            return config;
        }
    }

    /* loaded from: classes5.dex */
    public enum Mode {
        SHARED(0),
        UNIQUE(1);

        private final int value;

        Mode(int i) {
            this.value = i;
        }

        int getValue() {
            return this.value;
        }
    }
}
