package com.bytedance.sync;

import android.text.TextUtils;
import com.bytedance.sync.interfaze.IAccountService;
import com.bytedance.sync.interfaze.ICommonService;
import com.bytedance.sync.interfaze.ILogger;
import com.bytedance.sync.interfaze.IRequestTagHeaderProvider;
import com.bytedance.sync.interfaze.IWsService;
import com.bytedance.sync.p005v4.history.ISyncHistory;
import com.bytedance.sync.p005v4.lifecycle.ISyncLifeCycle;
import com.bytedance.sync.user.AccountSDKImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class Configuration {
    public final IAccountService accountService;
    public final String aid;
    public final int channelId;
    public final ICommonParamProvider commonParamProvider;
    public final ICommonService commonService;
    public final boolean debug;
    public final boolean enableMultiProcess;
    public final List<Integer> enableMultiProcessBusiness;
    public final boolean enableMultiProcessCompensate;
    public final String host;
    public final IRequestTagHeaderProvider iRequestTagHeaderProvider;
    public final ILogger logger;
    public final String monitorHost;
    public final boolean oversea;
    public final boolean retainFin;
    public final Map<String, ISyncHistory.HistoryDataConfiguration> syncHistoryConfiguration;
    public final ISyncLifeCycle syncLifeCycle;
    public final int upStreamServiceId;
    public final IWsService wsService;

    private Configuration(Builder builder) {
        this.aid = builder.aid;
        this.commonParamProvider = new CommonParamWrapper(builder.commonParamProvider);
        this.wsService = builder.wsService;
        this.accountService = builder.mAccountService;
        this.channelId = builder.channelId;
        this.upStreamServiceId = builder.upStreamServiceId;
        this.host = builder.host;
        this.monitorHost = builder.monitorHost;
        this.oversea = builder.oversea;
        this.logger = builder.logger;
        this.debug = builder.debug;
        this.retainFin = builder.retainFin;
        this.commonService = builder.commonService;
        this.syncLifeCycle = builder.syncLifeCycle;
        if (builder.syncHistoryConfiguration != null && !builder.syncHistoryConfiguration.isEmpty()) {
            this.syncHistoryConfiguration = new HashMap(builder.syncHistoryConfiguration);
        } else {
            this.syncHistoryConfiguration = new HashMap();
        }
        this.enableMultiProcess = builder.enableMultiProcess;
        this.enableMultiProcessCompensate = builder.enableMultiProcessCompensate;
        this.enableMultiProcessBusiness = builder.enableMultiProcessBusinessList;
        this.iRequestTagHeaderProvider = builder.iRequestTagHeaderProvider;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Builder {
        private final String aid;
        private final int channelId;
        private ICommonParamProvider commonParamProvider;
        private ICommonService commonService;
        private boolean debug;
        private boolean enableMultiProcess;
        private List<Integer> enableMultiProcessBusinessList;
        private boolean enableMultiProcessCompensate;
        private String host;
        private IRequestTagHeaderProvider iRequestTagHeaderProvider;
        public ILogger logger;
        private IAccountService mAccountService;
        private String monitorHost;
        private boolean oversea;
        private boolean retainFin;
        public Map<String, ISyncHistory.HistoryDataConfiguration> syncHistoryConfiguration;
        private ISyncLifeCycle syncLifeCycle;
        private final int upStreamServiceId;
        private IWsService wsService;

        public Builder(String str, int i, int i2) {
            this.retainFin = false;
            this.enableMultiProcess = false;
            this.enableMultiProcessCompensate = true;
            this.aid = str;
            this.channelId = i;
            this.upStreamServiceId = i2;
        }

        @Deprecated
        public Builder(String str, String str2, int i, int i2) {
            this(str2, i, i2);
        }

        public Builder commonParam(ICommonParamProvider iCommonParamProvider) {
            this.commonParamProvider = iCommonParamProvider;
            return this;
        }

        public Builder wsService(IWsService iWsService) {
            this.wsService = iWsService;
            return this;
        }

        public Builder accountService(IAccountService iAccountService) {
            this.mAccountService = iAccountService;
            return this;
        }

        public Builder host(String str) {
            this.host = str;
            return this;
        }

        public Builder monitorHost(String str) {
            this.monitorHost = str;
            return this;
        }

        public Builder isOversea(boolean z) {
            this.oversea = z;
            return this;
        }

        public Builder logger(ILogger iLogger) {
            this.logger = iLogger;
            return this;
        }

        public Builder isDebug(boolean z) {
            this.debug = z;
            return this;
        }

        public Builder retainFin(boolean z) {
            this.retainFin = z;
            return this;
        }

        public Builder commonService(ICommonService iCommonService) {
            this.commonService = iCommonService;
            return this;
        }

        public Builder syncLifeCycle(ISyncLifeCycle iSyncLifeCycle) {
            this.syncLifeCycle = iSyncLifeCycle;
            return this;
        }

        public Builder syncHistoryConfiguration(ISyncHistory.HistoryDataConfiguration historyDataConfiguration) {
            if (this.syncHistoryConfiguration == null) {
                this.syncHistoryConfiguration = new HashMap();
            }
            synchronized (this.syncHistoryConfiguration) {
                this.syncHistoryConfiguration.put(historyDataConfiguration.toKey(), historyDataConfiguration);
            }
            return this;
        }

        public Builder syncHistoryConfiguration(List<ISyncHistory.HistoryDataConfiguration> list) {
            if (this.syncHistoryConfiguration == null) {
                this.syncHistoryConfiguration = new HashMap();
            }
            if (list != null && !list.isEmpty()) {
                for (ISyncHistory.HistoryDataConfiguration historyDataConfiguration : list) {
                    this.syncHistoryConfiguration.put(historyDataConfiguration.toKey(), historyDataConfiguration);
                }
            }
            return this;
        }

        public Builder setEnableMultiProcess(boolean z) {
            this.enableMultiProcess = z;
            return this;
        }

        public Builder setEnableMultiProcessCompensate(boolean z) {
            this.enableMultiProcessCompensate = z;
            return this;
        }

        public Builder setEnableMultiProcessBusiness(int i) {
            if (this.enableMultiProcessBusinessList == null) {
                this.enableMultiProcessBusinessList = new ArrayList();
            }
            if (!this.enableMultiProcessBusinessList.contains(Integer.valueOf(i))) {
                this.enableMultiProcessBusinessList.add(Integer.valueOf(i));
            }
            return this;
        }

        public Builder iRequestTagHeaderProvider(IRequestTagHeaderProvider iRequestTagHeaderProvider) {
            this.iRequestTagHeaderProvider = iRequestTagHeaderProvider;
            return this;
        }

        public Configuration build() {
            List<Integer> list;
            if (TextUtils.isEmpty(this.host)) {
                throw new IllegalArgumentException("please set host before build");
            }
            if (TextUtils.isEmpty(this.aid)) {
                throw new IllegalArgumentException("please set aid before build");
            }
            if (this.upStreamServiceId < 0) {
                throw new IllegalArgumentException("please set upStreamServiceId before build");
            }
            if (this.commonParamProvider == null) {
                throw new IllegalArgumentException("please set commonParamProvider before build");
            }
            if (this.wsService == null) {
                throw new IllegalArgumentException("please set wsService before build");
            }
            if (this.mAccountService == null) {
                this.mAccountService = new AccountSDKImpl();
            }
            if (this.enableMultiProcess && ((list = this.enableMultiProcessBusinessList) == null || list.isEmpty())) {
                throw new IllegalArgumentException("please set process business id before build");
            }
            return new Configuration(this);
        }
    }
}
