package com.bytedance.platform.settingsx.api;

import android.app.Application;
import android.content.Context;
import com.bytedance.platform.settingsx.api.Logger;
import com.bytedance.platform.settingsx.api.storage.BlockCreator;
import com.bytedance.platform.settingsx.monitor.MonitorCallback;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public class Config {
    public BlockCreator blockCreator;
    public int blockKeyCount;
    public IBoost boost;
    public Context context;
    public boolean enableForceClearLocalSettings;
    public boolean enableLocalSettings;
    public boolean isBackupLocalSettings;
    public boolean isDebug;
    public boolean isMigrationLocalSettings;
    public ILog logImpl;
    public Logger.Level logLevel;
    public MonitorCallback monitorCallback;
    public boolean onlyMainProcessLog;
    public boolean openBlackList;
    public int settingsKeyCount;
    public ISharedPreferences sharedPreferences;
    public ScheduledThreadPoolExecutor timerExecutor;
    public ThreadPoolExecutor workPool;

    public static Builder with(Context context) {
        return new Builder(context);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        private BlockCreator blockCreator;
        private int blockKeyCount;
        private IBoost boost;
        private Context context;
        private boolean enableForceClearLocalSettings;
        private boolean enableLocalSettings;
        public boolean isBackupLocalSettings;
        private boolean isDebug;
        public boolean isMigrationLocalSettings;
        private ILog logImpl;
        private Logger.Level logLevel;
        private MonitorCallback monitorCallback;
        private boolean onlyMainProcessLog;
        private boolean openBlackList;
        private int settingsKeyCount;
        private ISharedPreferences sharedPreferences;
        private ScheduledThreadPoolExecutor timerExecutor;
        private ThreadPoolExecutor workPool;

        private Builder(Context context) {
            this.onlyMainProcessLog = true;
            if (context == null) {
                throw new NullPointerException("settingsx need context");
            }
            if (!(context instanceof Application)) {
                this.context = context.getApplicationContext();
            } else {
                this.context = context;
            }
        }

        public Builder workPool(ThreadPoolExecutor threadPoolExecutor) {
            if (threadPoolExecutor.getCorePoolSize() != 1) {
                throw new RuntimeException("核心线程必须为1");
            }
            this.workPool = threadPoolExecutor;
            return this;
        }

        public Builder blockCreator(BlockCreator blockCreator) {
            this.blockCreator = blockCreator;
            return this;
        }

        public Builder settingsKeyCount(int i) {
            this.settingsKeyCount = i;
            return this;
        }

        public Builder blockKeyCount(int i) {
            this.blockKeyCount = i;
            return this;
        }

        public Builder onlyMainProcessLog(boolean z) {
            this.onlyMainProcessLog = z;
            return this;
        }

        public Builder logLevel(Logger.Level level) {
            this.logLevel = level;
            return this;
        }

        public Builder logImpl(ILog iLog) {
            this.logImpl = iLog;
            return this;
        }

        public Builder sharePreference(ISharedPreferences iSharedPreferences) {
            this.sharedPreferences = iSharedPreferences;
            return this;
        }

        public Builder openBlackList(boolean z) {
            this.openBlackList = z;
            return this;
        }

        public Builder setDebug(boolean z) {
            this.isDebug = z;
            return this;
        }

        public Builder setBackupLocalSettings(boolean z) {
            this.isBackupLocalSettings = z;
            return this;
        }

        public Builder setMigrationLocalSettings(boolean z) {
            this.isMigrationLocalSettings = z;
            return this;
        }

        public Builder timerExecutor(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
            if (scheduledThreadPoolExecutor.getCorePoolSize() != 1) {
                throw new RuntimeException("核心线程必须为1");
            }
            this.timerExecutor = scheduledThreadPoolExecutor;
            return this;
        }

        public Builder monitorCallback(MonitorCallback monitorCallback) {
            this.monitorCallback = monitorCallback;
            return this;
        }

        public Builder boost(IBoost iBoost) {
            this.boost = iBoost;
            return this;
        }

        public Builder enableLocalSettings(boolean z) {
            this.enableLocalSettings = z;
            return this;
        }

        public Builder enableForceClearLocalSettings(boolean z) {
            this.enableForceClearLocalSettings = z;
            return this;
        }

        public Config build() {
            Config config = new Config();
            config.context = this.context;
            ThreadPoolExecutor threadPoolExecutor = this.workPool;
            if (threadPoolExecutor != null) {
                config.workPool = threadPoolExecutor;
            } else {
                config.workPool = new ThreadPoolExecutor(1, 1, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue());
            }
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = this.timerExecutor;
            if (scheduledThreadPoolExecutor != null) {
                config.timerExecutor = scheduledThreadPoolExecutor;
            } else {
                config.timerExecutor = new ScheduledThreadPoolExecutor(1);
            }
            BlockCreator blockCreator = this.blockCreator;
            if (blockCreator != null) {
                config.blockCreator = blockCreator;
            }
            int i = this.settingsKeyCount;
            if (i > 0) {
                config.settingsKeyCount = i;
            } else {
                config.settingsKeyCount = 4096;
            }
            int i2 = this.blockKeyCount;
            if (i2 > 0) {
                config.blockKeyCount = i2;
            } else {
                config.blockKeyCount = 256;
            }
            config.onlyMainProcessLog = this.onlyMainProcessLog;
            ILog iLog = this.logImpl;
            if (iLog != null) {
                config.logImpl = iLog;
            }
            Logger.Level level = this.logLevel;
            if (level != null) {
                config.logLevel = level;
            }
            config.monitorCallback = this.monitorCallback;
            config.boost = this.boost;
            ISharedPreferences iSharedPreferences = this.sharedPreferences;
            if (iSharedPreferences != null) {
                config.sharedPreferences = iSharedPreferences;
            }
            config.openBlackList = this.openBlackList;
            config.isDebug = this.isDebug;
            config.enableLocalSettings = this.enableLocalSettings;
            config.enableForceClearLocalSettings = this.enableForceClearLocalSettings;
            config.isBackupLocalSettings = this.isBackupLocalSettings;
            config.isMigrationLocalSettings = this.isMigrationLocalSettings;
            return config;
        }
    }
}
