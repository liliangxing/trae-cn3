package com.bytedance.android.bytehook;

import com.bytedance.shadowhook.ShadowHook;

/* loaded from: classes2.dex */
public class ByteHook {
    private static final int ERRNO_INIT_EXCEPTION = 101;
    private static final int ERRNO_LOAD_LIBRARY_EXCEPTION = 100;
    private static final int ERRNO_OK = 0;
    private static final int ERRNO_UNINIT = 1;
    private static final boolean defaultDebug = false;
    private static final ILibLoader defaultLibLoader = null;
    private static final boolean defaultRecordable = false;
    private static final boolean defaultShadowhookDebug = false;
    private static final boolean defaultShadowhookRecordable = false;
    private static long initCostMs = -1;
    private static int initStatus = 1;
    private static boolean inited = false;
    private static final String libName = "bytehook";
    private static final int recordItemAll = 255;
    private static final int recordItemCallerLibName = 2;
    private static final int recordItemErrno = 64;
    private static final int recordItemLibName = 8;
    private static final int recordItemNewAddr = 32;
    private static final int recordItemOp = 4;
    private static final int recordItemStub = 128;
    private static final int recordItemSymName = 16;
    private static final int recordItemTimestamp = 1;
    private static final int defaultMode = Mode.AUTOMATIC.getValue();
    private static final ShadowHook.ILibLoader defaultShadowhookLibLoader = null;
    private static final ShadowHook.Mode defaultShadowhookMode = ShadowHook.Mode.SHARED;

    /* loaded from: classes2.dex */
    public enum RecordItem {
        TIMESTAMP,
        CALLER_LIB_NAME,
        OP,
        LIB_NAME,
        SYM_NAME,
        NEW_ADDR,
        ERRNO,
        STUB
    }

    private static native int nativeAddIgnore(String str);

    private static native String nativeGetArch();

    private static native boolean nativeGetDebug();

    private static native int nativeGetMode();

    private static native boolean nativeGetRecordable();

    private static native String nativeGetRecords(int i);

    private static native String nativeGetVersion();

    private static native int nativeInit(int i, boolean z);

    private static native void nativeSetDebug(boolean z);

    private static native void nativeSetRecordable(boolean z);

    public static String getVersion() {
        return nativeGetVersion();
    }

    public static int init() {
        return init(null);
    }

    public static synchronized int init(Config config) {
        synchronized (ByteHook.class) {
            if (inited) {
                return initStatus;
            }
            inited = true;
            long currentTimeMillis = System.currentTimeMillis();
            if (config == null) {
                config = new ConfigBuilder().build();
            }
            ShadowHook.init(new ShadowHook.ConfigBuilder().setLibLoader(config.getShadowhookLibLoader()).setMode(config.getShadowhookMode()).setDebuggable(config.getShadowhookDebug()).setRecordable(config.getShadowhookRecordable()).build());
            try {
                if (config.getLibLoader() == null) {
                    System.loadLibrary(libName);
                } else {
                    config.getLibLoader().loadLibrary(libName);
                }
                try {
                    initStatus = nativeInit(config.getMode(), config.getDebug());
                } catch (Throwable unused) {
                    initStatus = 101;
                }
                if (config.getRecordable()) {
                    try {
                        nativeSetRecordable(config.getRecordable());
                    } catch (Throwable unused2) {
                        initStatus = 101;
                    }
                }
                initCostMs = System.currentTimeMillis() - currentTimeMillis;
                return initStatus;
            } catch (Throwable unused3) {
                initStatus = 100;
                initCostMs = System.currentTimeMillis() - currentTimeMillis;
                return initStatus;
            }
        }
    }

    public static int addIgnore(String str) {
        int i = initStatus;
        return i == 0 ? nativeAddIgnore(str) : i;
    }

    public static int getInitErrno() {
        return initStatus;
    }

    public static long getInitCostMs() {
        return initCostMs;
    }

    public static Mode getMode() {
        if (initStatus == 0) {
            return Mode.AUTOMATIC.getValue() == nativeGetMode() ? Mode.AUTOMATIC : Mode.MANUAL;
        }
        return Mode.AUTOMATIC;
    }

    public static boolean getDebug() {
        if (initStatus == 0) {
            return nativeGetDebug();
        }
        return false;
    }

    public static void setDebug(boolean z) {
        if (initStatus == 0) {
            nativeSetDebug(z);
        }
    }

    public static boolean getRecordable() {
        if (initStatus == 0) {
            return nativeGetRecordable();
        }
        return false;
    }

    public static void setRecordable(boolean z) {
        if (initStatus == 0) {
            nativeSetRecordable(z);
        }
    }

    public static String getRecords(RecordItem... recordItemArr) {
        if (initStatus != 0) {
            return null;
        }
        int i = 0;
        for (RecordItem recordItem : recordItemArr) {
            switch (AnonymousClass1.$SwitchMap$com$bytedance$android$bytehook$ByteHook$RecordItem[recordItem.ordinal()]) {
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
            }
        }
        if (i == 0) {
            i = 255;
        }
        return nativeGetRecords(i);
    }

    /* renamed from: com.bytedance.android.bytehook.ByteHook$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$android$bytehook$ByteHook$RecordItem;

        static {
            int[] iArr = new int[RecordItem.values().length];
            $SwitchMap$com$bytedance$android$bytehook$ByteHook$RecordItem = iArr;
            try {
                iArr[RecordItem.TIMESTAMP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$bytedance$android$bytehook$ByteHook$RecordItem[RecordItem.CALLER_LIB_NAME.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$bytedance$android$bytehook$ByteHook$RecordItem[RecordItem.OP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$bytedance$android$bytehook$ByteHook$RecordItem[RecordItem.LIB_NAME.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$bytedance$android$bytehook$ByteHook$RecordItem[RecordItem.SYM_NAME.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$bytedance$android$bytehook$ByteHook$RecordItem[RecordItem.NEW_ADDR.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$bytedance$android$bytehook$ByteHook$RecordItem[RecordItem.ERRNO.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$bytedance$android$bytehook$ByteHook$RecordItem[RecordItem.STUB.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public static String getArch() {
        return initStatus == 0 ? nativeGetArch() : "unknown";
    }

    /* loaded from: classes2.dex */
    public static class Config {
        private boolean debug;
        private ILibLoader libLoader;
        private int mode;
        private boolean recordable;
        private boolean shadowhookDebug;
        private ShadowHook.ILibLoader shadowhookLibLoader;
        private ShadowHook.Mode shadowhookMode;
        private boolean shadowhookRecordable;

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

        public void setDebug(boolean z) {
            this.debug = z;
        }

        public boolean getDebug() {
            return this.debug;
        }

        public void setRecordable(boolean z) {
            this.recordable = z;
        }

        public boolean getRecordable() {
            return this.recordable;
        }

        public void setShadowhookLibLoader(ShadowHook.ILibLoader iLibLoader) {
            this.shadowhookLibLoader = iLibLoader;
        }

        public ShadowHook.ILibLoader getShadowhookLibLoader() {
            return this.shadowhookLibLoader;
        }

        public void setShadowhookMode(ShadowHook.Mode mode) {
            this.shadowhookMode = mode;
        }

        public ShadowHook.Mode getShadowhookMode() {
            return this.shadowhookMode;
        }

        public void setShadowhookDebug(boolean z) {
            this.shadowhookDebug = z;
        }

        public boolean getShadowhookDebug() {
            return this.shadowhookDebug;
        }

        public void setShadowhookRecordable(boolean z) {
            this.shadowhookRecordable = z;
        }

        public boolean getShadowhookRecordable() {
            return this.shadowhookRecordable;
        }
    }

    /* loaded from: classes2.dex */
    public static class ConfigBuilder {
        private ILibLoader libLoader = ByteHook.defaultLibLoader;
        private int mode = ByteHook.defaultMode;
        private boolean debug = false;
        private boolean recordable = false;
        private ShadowHook.ILibLoader shadowhookLibLoader = ByteHook.defaultShadowhookLibLoader;
        private ShadowHook.Mode shadowhookMode = ByteHook.defaultShadowhookMode;
        private boolean shadowhookDebug = false;
        private boolean shadowhookRecordable = false;

        public ConfigBuilder setLibLoader(ILibLoader iLibLoader) {
            this.libLoader = iLibLoader;
            return this;
        }

        public ConfigBuilder setMode(Mode mode) {
            this.mode = mode.getValue();
            return this;
        }

        public ConfigBuilder setDebug(boolean z) {
            this.debug = z;
            return this;
        }

        public ConfigBuilder setRecordable(boolean z) {
            this.recordable = z;
            return this;
        }

        public ConfigBuilder setShadowhookLibLoader(ShadowHook.ILibLoader iLibLoader) {
            this.shadowhookLibLoader = iLibLoader;
            return this;
        }

        public ConfigBuilder setShadowhookMode(ShadowHook.Mode mode) {
            this.shadowhookMode = mode;
            return this;
        }

        public ConfigBuilder setShadowhookDebug(boolean z) {
            this.shadowhookDebug = z;
            return this;
        }

        public ConfigBuilder setShadowhookRecordable(boolean z) {
            this.shadowhookRecordable = z;
            return this;
        }

        public Config build() {
            Config config = new Config();
            config.setLibLoader(this.libLoader);
            config.setMode(this.mode);
            config.setDebug(this.debug);
            config.setRecordable(this.recordable);
            config.setShadowhookLibLoader(this.shadowhookLibLoader);
            config.setShadowhookMode(this.shadowhookMode);
            config.setShadowhookDebug(this.shadowhookDebug);
            config.setShadowhookRecordable(this.shadowhookRecordable);
            return config;
        }
    }

    /* loaded from: classes2.dex */
    public enum Mode {
        AUTOMATIC(0),
        MANUAL(1);

        private final int value;

        Mode(int i) {
            this.value = i;
        }

        int getValue() {
            return this.value;
        }
    }
}
