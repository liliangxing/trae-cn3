package com.ss.android.agilelogger;

import android.content.Context;
import android.text.TextUtils;
import com.ss.android.agilelogger.utils.FileUtils;

/* loaded from: classes7.dex */
public class ALogConfig {
    private String bufferDirPath;
    private int cacheFileSizeInKB;
    private boolean compress;
    private Context context;
    private boolean enableOffloadInAllProcess;
    private boolean enableOffloadInAllThread;
    private boolean encrypt;
    private int level;
    private String logDirPath;
    private int logFileExpDays;
    private boolean mainThreadSpeedUp;
    private int maxDirSize;
    private boolean newCompression;
    private boolean newThreadPoolImplementation;
    private boolean offloadMainThreadWrite;
    private int perSize;
    private String pubKey;
    private float subProcessMaxDirSizeRatio;

    private ALogConfig() {
    }

    public Context getContext() {
        return this.context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public int getLogFileExpDays() {
        return this.logFileExpDays;
    }

    public void setLogFileExpDays(int i) {
        this.logFileExpDays = i;
    }

    public int getMaxDirSize() {
        return this.maxDirSize;
    }

    public void setMaxDirSize(int i) {
        this.maxDirSize = i;
    }

    public void setSubProcessMaxDirSizeRatio(float f) {
        this.subProcessMaxDirSizeRatio = f;
    }

    public float getSubProcessMaxDirSizeRatio() {
        return this.subProcessMaxDirSizeRatio;
    }

    public int getPerSize() {
        return this.perSize;
    }

    public void setPerSize(int i) {
        this.perSize = i;
    }

    public String getBufferDirPath() {
        return this.bufferDirPath;
    }

    public void setBufferDirPath(String str) {
        this.bufferDirPath = str;
    }

    public String getLogDirPath() {
        return this.logDirPath;
    }

    public void setLogDirPath(String str) {
        this.logDirPath = str;
    }

    public boolean isCompress() {
        return this.compress;
    }

    public void setCompress(boolean z) {
        this.compress = z;
    }

    public boolean isEncrypt() {
        return this.encrypt;
    }

    public void setEncrypt(boolean z) {
        this.encrypt = z;
    }

    public int getLevel() {
        return this.level;
    }

    public void setLevel(int i) {
        this.level = i;
    }

    public String getPubKey() {
        return this.pubKey;
    }

    public void setPubKey(String str) {
        this.pubKey = str;
    }

    public boolean isMainThreadSpeedUp() {
        return this.mainThreadSpeedUp;
    }

    public void setMainThreadSpeedUp(boolean z) {
        this.mainThreadSpeedUp = z;
    }

    public void setOffloadMainThreadWrite(boolean z) {
        this.offloadMainThreadWrite = z;
    }

    public boolean isOffloadMainThreadWrite() {
        return this.offloadMainThreadWrite;
    }

    public void setEnableOffloadInAllProcess(boolean z) {
        this.enableOffloadInAllProcess = z;
    }

    public boolean enableOffloadInAllProcess() {
        return this.enableOffloadInAllProcess;
    }

    public void setEnableOffloadInAllThread(boolean z) {
        this.enableOffloadInAllThread = z;
    }

    public boolean enableOffloadInAllThread() {
        return this.enableOffloadInAllThread;
    }

    public void setNewThreadPoolImplementation(boolean z) {
        this.newThreadPoolImplementation = z;
    }

    public void enableNewCompression(boolean z) {
        this.newCompression = z;
    }

    public boolean isEnableNewCompression() {
        return this.newCompression;
    }

    public boolean isNewThreadPoolImplementation() {
        return this.newThreadPoolImplementation;
    }

    public int getCacheFileSizeInKB() {
        return this.cacheFileSizeInKB;
    }

    public void setCacheFileSizeInKB(int i) {
        this.cacheFileSizeInKB = i;
    }

    /* loaded from: classes7.dex */
    public static class Builder {
        private String bufferDirPath;
        private Context context;
        private String logDirPath;
        private int logFileExpDays = 14;
        private int maxDirSize = 20971520;
        private float subProcessMaxDirSizeRatio = 0.1f;
        private int perSize = 1048576;
        private boolean compress = true;
        private boolean encrypt = true;
        private int level = 3;
        private String pubKey = "fecbb32b759120b672045f74edc41d159b6a426ffc863b9e0be9ad4be12824546f549959b838993a430344f15197221e87bd362298814c75f5068148b980306f";
        private boolean mainThreadSpeedUp = true;
        private boolean offloadMainThreadWrite = false;
        private boolean enableOffloadInAllProcess = false;
        private boolean newThreadPoolImplementation = false;
        private boolean enableOffloadInAllThread = false;
        private int cacheFileSizeInKB = 64;
        private boolean isNewCompression = false;

        public Builder(Context context) {
            if (context == null) {
                throw new RuntimeException("context must not be null");
            }
            Context applicationContext = context.getApplicationContext();
            this.context = applicationContext != null ? applicationContext : context;
        }

        public Builder setLogFileExpDays(int i) {
            this.logFileExpDays = i;
            return this;
        }

        public Builder setMaxDirSize(int i) {
            this.maxDirSize = i;
            return this;
        }

        public Builder setSubProcessMaxDirSizeRatio(float f) {
            this.subProcessMaxDirSizeRatio = f;
            return this;
        }

        public Builder setPerSize(int i) {
            this.perSize = i;
            return this;
        }

        public Builder setBufferDirPath(String str) {
            this.bufferDirPath = str;
            return this;
        }

        public Builder setLogDirPath(String str) {
            this.logDirPath = str;
            return this;
        }

        public Builder setCompress(boolean z) {
            this.compress = z;
            return this;
        }

        public Builder setEncrypt(boolean z) {
            this.encrypt = z;
            return this;
        }

        public Builder setLevel(int i) {
            this.level = i;
            return this;
        }

        public Builder setPubKey(String str) {
            this.pubKey = str;
            return this;
        }

        public Builder setMainThreadSpeedUp(boolean z) {
            this.mainThreadSpeedUp = z;
            return this;
        }

        public Builder setOffloadMainThreadWrite(boolean z) {
            this.offloadMainThreadWrite = z;
            return this;
        }

        public Builder setEnableOffloadInAllProcess(boolean z) {
            this.enableOffloadInAllProcess = z;
            return this;
        }

        public Builder setEnableOffloadInAllThread(boolean z) {
            this.enableOffloadInAllThread = z;
            return this;
        }

        public Builder setNewThreadPoolImplementation(boolean z) {
            this.newThreadPoolImplementation = z;
            return this;
        }

        public Builder setCacheFileSizeInKB(int i) {
            this.cacheFileSizeInKB = i;
            return this;
        }

        public Builder setEnableNewCompression(boolean z) {
            this.isNewCompression = z;
            return this;
        }

        public ALogConfig build() {
            ALogConfig aLogConfig = new ALogConfig();
            aLogConfig.setContext(this.context);
            aLogConfig.setLogFileExpDays(this.logFileExpDays);
            aLogConfig.setMaxDirSize(this.maxDirSize);
            aLogConfig.setSubProcessMaxDirSizeRatio(this.subProcessMaxDirSizeRatio);
            aLogConfig.setPerSize(this.perSize);
            aLogConfig.setBufferDirPath(TextUtils.isEmpty(this.bufferDirPath) ? FileUtils.getBufferDirPath(this.context) : this.bufferDirPath);
            aLogConfig.setLogDirPath(TextUtils.isEmpty(this.logDirPath) ? FileUtils.getDefaultLogDir(this.context).getAbsolutePath() : this.logDirPath);
            aLogConfig.setCompress(this.compress);
            aLogConfig.setEncrypt(this.encrypt);
            aLogConfig.setLevel(this.level);
            aLogConfig.setPubKey(this.pubKey);
            aLogConfig.setMainThreadSpeedUp(this.mainThreadSpeedUp);
            aLogConfig.setOffloadMainThreadWrite(this.offloadMainThreadWrite);
            aLogConfig.setEnableOffloadInAllProcess(this.enableOffloadInAllProcess);
            aLogConfig.setEnableOffloadInAllThread(this.enableOffloadInAllThread);
            aLogConfig.setNewThreadPoolImplementation(this.newThreadPoolImplementation);
            aLogConfig.enableNewCompression(this.isNewCompression);
            aLogConfig.setCacheFileSizeInKB(this.cacheFileSizeInKB);
            return aLogConfig;
        }
    }
}
