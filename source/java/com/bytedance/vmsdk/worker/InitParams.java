package com.bytedance.vmsdk.worker;

import com.bytedance.vmsdk.jsbridge.JSModuleManager;
import com.bytedance.vmsdk.worker.JsWorker;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class InitParams {
    private final String mBizName;
    private final String mCodeCachePath;
    private final boolean mEnableInspector;
    private final boolean mEnableLogcatConsole;
    private final boolean mEnableMultiThread;
    private final boolean mEnableWorkerThread;
    private final JsWorker.EngineType mEngineType;
    private final boolean mIcuEnabled;
    private final boolean mInitWasm;
    private final JSModuleManager mJSModuleManager;
    private final String mSnapshotPath;
    private final boolean mUsePlatformThread;

    private InitParams(Builder builder) {
        this.mEngineType = builder.mEngineType;
        this.mBizName = builder.mBizName;
        this.mSnapshotPath = builder.mSnapshotPath;
        this.mCodeCachePath = builder.mCodeCachePath;
        this.mEnableWorkerThread = builder.mEnableWorkerThread;
        this.mEnableInspector = builder.mEnableInspector;
        this.mEnableLogcatConsole = builder.mEnableLogcatConsole;
        boolean z = builder.mEnableMultiThread;
        this.mEnableMultiThread = z;
        this.mJSModuleManager = builder.mJSModuleManager;
        this.mIcuEnabled = builder.mIcuEnabled;
        this.mInitWasm = builder.mInitWasm;
        boolean z2 = builder.mUsePlatformThread;
        this.mUsePlatformThread = z2;
        if (z2 && !z) {
            throw new IllegalArgumentException("Platform thread must be used with multi thread enabled");
        }
    }

    public JsWorker.EngineType engineType() {
        return this.mEngineType;
    }

    public String bizName() {
        return this.mBizName;
    }

    public String snapshotPath() {
        return this.mSnapshotPath;
    }

    public String codeCachePath() {
        return this.mCodeCachePath;
    }

    public boolean enableMultiThread() {
        return this.mEnableMultiThread;
    }

    public boolean enableWorkerThread() {
        return this.mEnableWorkerThread;
    }

    public boolean enableInspector() {
        return this.mEnableInspector;
    }

    public boolean enableLogcatConsole() {
        return this.mEnableLogcatConsole;
    }

    public JSModuleManager jsModuleManager() {
        return this.mJSModuleManager;
    }

    public boolean enableIcu() {
        return this.mIcuEnabled;
    }

    public boolean initWasm() {
        return this.mInitWasm;
    }

    public boolean usePlatformThread() {
        return this.mUsePlatformThread;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final class Builder {
        private JsWorker.EngineType mEngineType = JsWorker.EngineType.QUICKJS;
        private String mBizName = JsWorker.DEFAULT_BIZ_NAME;
        private String mSnapshotPath = "";
        private String mCodeCachePath = null;
        private String mTimeZone = "";
        private boolean mEnableWorkerThread = false;
        private boolean mEnableInspector = false;
        private boolean mEnableLogcatConsole = false;
        private boolean mEnableMultiThread = false;
        private JSModuleManager mJSModuleManager = null;
        private boolean mInitWasm = false;
        private boolean mIcuEnabled = false;
        private boolean mUsePlatformThread = false;

        public Builder withEngineType(JsWorker.EngineType engineType) {
            this.mEngineType = engineType;
            return this;
        }

        public Builder withBizName(String str) {
            this.mBizName = str;
            return this;
        }

        public Builder withSnapshotPath(String str) {
            this.mSnapshotPath = str;
            return this;
        }

        public Builder withCodeCachePath(String str) {
            this.mCodeCachePath = str;
            return this;
        }

        public Builder withEnableWorkerThread(boolean z) {
            this.mEnableWorkerThread = z;
            return this;
        }

        public Builder withEnableInspector(boolean z) {
            this.mEnableInspector = z;
            return this;
        }

        public Builder withEnableLogcatConsole(boolean z) {
            this.mEnableLogcatConsole = z;
            return this;
        }

        public Builder withEnableMultiThread(boolean z) {
            this.mEnableMultiThread = z;
            return this;
        }

        public Builder withJSModuleManager(JSModuleManager jSModuleManager) {
            this.mJSModuleManager = jSModuleManager;
            return this;
        }

        public Builder withIcuEnabled(boolean z) {
            this.mIcuEnabled = z;
            return this;
        }

        public Builder withInitWasm(boolean z) {
            this.mInitWasm = z;
            return this;
        }

        public Builder withUsePlatformThread(boolean z) {
            this.mUsePlatformThread = z;
            return this;
        }

        public InitParams build() {
            return new InitParams(this);
        }
    }
}
