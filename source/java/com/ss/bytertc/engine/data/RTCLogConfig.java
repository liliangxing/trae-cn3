package com.ss.bytertc.engine.data;

/* loaded from: classes7.dex */
public class RTCLogConfig {
    public int logFileSize;
    public String logFilenamePrefix;
    public LocalLogLevel logLevel;
    public String logPath;

    public RTCLogConfig(LocalLogLevel logLevel, String logPath, int logFileSize, String logFilenamePrefix) {
        this.logFileSize = 10;
        LocalLogLevel localLogLevel = LocalLogLevel.WARNING;
        this.logLevel = logLevel;
        this.logPath = logPath;
        this.logFileSize = logFileSize;
        this.logFilenamePrefix = logFilenamePrefix;
    }

    public RTCLogConfig(String logPath) {
        this.logFileSize = 10;
        this.logLevel = LocalLogLevel.WARNING;
        this.logPath = logPath;
    }

    public String toString() {
        return "RTCLogConfig{log_level='" + this.logLevel + "', log_path='" + this.logPath + "', log_file_size='" + this.logFileSize + "', log_filename_prefix='" + this.logFilenamePrefix + "'}";
    }

    public static RTCLogConfig create(LocalLogLevel logLevel, String logPath, int logFileSize, String logFilenamePrefix) {
        return new RTCLogConfig(logLevel, logPath, logFileSize, logFilenamePrefix);
    }
}
