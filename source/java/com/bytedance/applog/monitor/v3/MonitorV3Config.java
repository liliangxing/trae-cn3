package com.bytedance.applog.monitor.v3;

import android.content.Context;
import com.bytedance.bdinstall.INetworkClient;
import java.util.concurrent.ExecutorService;

/* loaded from: classes3.dex */
public class MonitorV3Config {
    private final MonitorV3AppLogConfig appLogConfig;
    private final Context context;
    private final IMonitorDataFetcher dataFetcher;
    private long eventReportInterval;
    private final ExecutorService executor;
    private final INetworkClient networkClient;
    private final String reportUrl;

    public String toString() {
        return "MonitorV3Config{context=" + this.context + ", appLogConfig=" + this.appLogConfig + ", eventReportInterval=" + this.eventReportInterval + ", networkClient=" + this.networkClient + ", executor=" + this.executor + ", reportUrl='" + this.reportUrl + "'}";
    }

    private MonitorV3Config(Builder builder) {
        this.eventReportInterval = 60000L;
        this.context = builder.context;
        this.appLogConfig = builder.appLogConfig;
        this.eventReportInterval = builder.eventReportInterval;
        this.networkClient = builder.networkClient;
        this.reportUrl = builder.reportUrl;
        this.executor = builder.executor;
        this.dataFetcher = builder.dataFetcher;
    }

    public Context getContext() {
        return this.context;
    }

    public MonitorV3AppLogConfig getAppLogConfig() {
        return this.appLogConfig;
    }

    public long getEventReportInterval() {
        return this.eventReportInterval;
    }

    public INetworkClient getNetworkClient() {
        return this.networkClient;
    }

    public String getReportUrl() {
        return this.reportUrl;
    }

    public ExecutorService getExecutor() {
        return this.executor;
    }

    public IMonitorDataFetcher getDataFetcher() {
        return this.dataFetcher;
    }

    /* loaded from: classes3.dex */
    public static final class Builder {
        private MonitorV3AppLogConfig appLogConfig;
        private Context context;
        private IMonitorDataFetcher dataFetcher;
        private long eventReportInterval;
        private ExecutorService executor;
        private INetworkClient networkClient;
        private String reportUrl;

        public Builder context(Context context) {
            this.context = context;
            return this;
        }

        public Builder appLogConfig(MonitorV3AppLogConfig monitorV3AppLogConfig) {
            this.appLogConfig = monitorV3AppLogConfig;
            return this;
        }

        public Builder eventReportInterval(long j) {
            this.eventReportInterval = j;
            return this;
        }

        public Builder networkClient(INetworkClient iNetworkClient) {
            this.networkClient = iNetworkClient;
            return this;
        }

        public Builder reportUrl(String str) {
            this.reportUrl = str;
            return this;
        }

        public Builder executor(ExecutorService executorService) {
            this.executor = executorService;
            return this;
        }

        public Builder dataFetcher(IMonitorDataFetcher iMonitorDataFetcher) {
            this.dataFetcher = iMonitorDataFetcher;
            return this;
        }

        public MonitorV3Config build() {
            return new MonitorV3Config(this);
        }
    }
}
