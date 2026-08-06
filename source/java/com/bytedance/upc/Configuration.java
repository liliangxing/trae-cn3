package com.bytedance.upc;

import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public class Configuration {
    public String mAid;
    public AppInfo mAppInfo;
    public IAppListConfiguration mAppListConfiguration;
    public IClipBoardConfiguration mClipBoardConfiguration;
    public boolean mDebug;
    public IAppStatusChange mIAppStatusChange;
    public IBridgeService mIBridgeService;
    public ICommonService mICommonService;
    public IDeleteEventService mIDeleteEventService;
    public IDeviceGetter mIDeviceGetter;
    public ILoaderService mILoaderService;
    public IOpenService mIOpenService;
    public IPrivacyApiConfiguration mIPrivacyApiConfiguration;
    public IPrivacyService mIPrivacyService;
    public IThirdAuthorizeConfig mIThirdAuthorizeConfig;
    public IThirdAuthorizeService mIThirdAuthorizeService;
    public IUpcCertService mIUpcCertService;
    public IUpcDialogService mIUpcPrivacyDialogService;
    public IUpcTeenModeService mIUpcTeenModeService;
    public String mMonitorHost;
    public NavigatorConfiguration mNavigatorConfiguration;
    public boolean mNeedInitRpc;
    public boolean mOversea;
    public Map<String, PopupConfiguration> mPopupConfigurations;
    public IUpcMonitorAndEventService mUpcMonitorAndEventService;
    public UpcSettingsConfig mUpcSettingsConfig;
    public IUpcTeenModeConfiguration mUpcTeenModeConfiguration;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
    public static class AppInfo {
        public String appName;
        public String appVersion;
        public String appVersionCode;
        public String channel;
        public String language;
    }

    private Configuration() {
    }

    Configuration(Builder builder) {
        this.mNeedInitRpc = builder.needInitRpc;
        this.mIOpenService = builder.iOpenService;
        this.mIPrivacyApiConfiguration = builder.iPrivacyApiConfiguration;
        this.mILoaderService = builder.iLoaderService;
        this.mIPrivacyService = builder.iPrivacyService;
        this.mIBridgeService = builder.iBridgeService;
        this.mICommonService = builder.iCommonService;
        this.mIUpcTeenModeService = builder.iUpcTeenModeService;
        this.mIAppStatusChange = builder.iAppStatusChange;
        this.mIDeleteEventService = builder.iDeleteEventService;
        this.mIUpcPrivacyDialogService = builder.iUpcPrivacyDialogService;
        this.mIThirdAuthorizeService = builder.iThirdAuthorizeService;
        this.mIThirdAuthorizeConfig = builder.iThirdAuthorizeConfig;
        this.mPopupConfigurations = builder.popupConfigurations;
        this.mNavigatorConfiguration = builder.navigatorConfiguration;
        this.mClipBoardConfiguration = builder.clipBoardConfiguration;
        this.mAppListConfiguration = builder.appListConfiguration;
        this.mUpcTeenModeConfiguration = builder.iUpcTeenModeConfiguration;
        this.mIUpcCertService = builder.iUpcCertService;
        this.mUpcSettingsConfig = builder.upcSettingsConfig;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
    public static class Builder {
        private IAppListConfiguration appListConfiguration;
        private IClipBoardConfiguration clipBoardConfiguration;
        private IAppStatusChange iAppStatusChange;
        private IBridgeService iBridgeService;
        private ICommonService iCommonService;
        private IDeleteEventService iDeleteEventService;
        private ILoaderService iLoaderService;
        private IOpenService iOpenService;
        private IPrivacyApiConfiguration iPrivacyApiConfiguration;
        private IPrivacyService iPrivacyService;
        private IThirdAuthorizeConfig iThirdAuthorizeConfig;
        private IThirdAuthorizeService iThirdAuthorizeService;
        private IUpcCertService iUpcCertService;
        private IUpcDialogService iUpcPrivacyDialogService;
        private IUpcTeenModeConfiguration iUpcTeenModeConfiguration;
        private IUpcTeenModeService iUpcTeenModeService;
        private String monitorHost;
        private NavigatorConfiguration navigatorConfiguration;
        public boolean needInitRpc;
        private Map<String, PopupConfiguration> popupConfigurations;
        private UpcSettingsConfig upcSettingsConfig;

        public Builder setOpenService(IOpenService iOpenService) {
            this.iOpenService = iOpenService;
            return this;
        }

        public Builder setLoaderService(ILoaderService iLoaderService) {
            this.iLoaderService = iLoaderService;
            return this;
        }

        public Builder setThirdAuthorizeConfig(IThirdAuthorizeConfig iThirdAuthorizeConfig) {
            this.iThirdAuthorizeConfig = iThirdAuthorizeConfig;
            return this;
        }

        public Builder setThirdAuthorizeService(IThirdAuthorizeService iThirdAuthorizeService) {
            this.iThirdAuthorizeService = iThirdAuthorizeService;
            return this;
        }

        public Builder setPrivacyService(IPrivacyService iPrivacyService) {
            this.iPrivacyService = iPrivacyService;
            return this;
        }

        public Builder setBridgeService(IBridgeService iBridgeService) {
            this.iBridgeService = iBridgeService;
            return this;
        }

        public Builder setAppStatusChange(IAppStatusChange iAppStatusChange) {
            this.iAppStatusChange = iAppStatusChange;
            return this;
        }

        public Builder setDeleteEventService(IDeleteEventService iDeleteEventService) {
            this.iDeleteEventService = iDeleteEventService;
            return this;
        }

        public Builder setCommonService(ICommonService iCommonService) {
            this.iCommonService = iCommonService;
            return this;
        }

        public Builder setNeedInitRpc(boolean z) {
            this.needInitRpc = z;
            return this;
        }

        public Builder setPopupConfigurations(Map<String, PopupConfiguration> map) {
            this.popupConfigurations = map;
            return this;
        }

        public Builder setNavigatorConfiguration(NavigatorConfiguration navigatorConfiguration) {
            this.navigatorConfiguration = navigatorConfiguration;
            return this;
        }

        public Builder setPrivacyApiConfiguration(IPrivacyApiConfiguration iPrivacyApiConfiguration) {
            this.iPrivacyApiConfiguration = iPrivacyApiConfiguration;
            return this;
        }

        public Builder setClipBoardConfiguration(IClipBoardConfiguration iClipBoardConfiguration) {
            this.clipBoardConfiguration = iClipBoardConfiguration;
            return this;
        }

        public Builder setAppListConfiguration(IAppListConfiguration iAppListConfiguration) {
            this.appListConfiguration = iAppListConfiguration;
            return this;
        }

        public Builder setTeenModeConfiguration(IUpcTeenModeConfiguration iUpcTeenModeConfiguration) {
            this.iUpcTeenModeConfiguration = iUpcTeenModeConfiguration;
            return this;
        }

        public Builder setUpcCertService(IUpcCertService iUpcCertService) {
            this.iUpcCertService = iUpcCertService;
            return this;
        }

        public Builder setUpcSettingsConfig(UpcSettingsConfig upcSettingsConfig) {
            this.upcSettingsConfig = upcSettingsConfig;
            return this;
        }

        public Configuration build() {
            if (this.iLoaderService == null) {
                try {
                    this.iLoaderService = (ILoaderService) Class.forName("com.bytedance.upc.web.InnerWebViewService").newInstance();
                } catch (Throwable unused) {
                }
            }
            if (this.iBridgeService == null) {
                try {
                    this.iBridgeService = (IBridgeService) Class.forName("com.bytedance.upc.bridge.UpcBridgeService").newInstance();
                } catch (Throwable unused2) {
                }
            }
            if (this.iPrivacyService == null) {
                try {
                    this.iPrivacyService = (IPrivacyService) Class.forName("com.bytedance.upc.privacy.UpcPrivacyService").newInstance();
                } catch (Throwable unused3) {
                }
            }
            if (this.iThirdAuthorizeConfig == null && this.iThirdAuthorizeService == null) {
                try {
                    this.iThirdAuthorizeConfig = (IThirdAuthorizeConfig) Class.forName("com.bytedance.upc.third.authorize.UpcThirdAuthorizeService").newInstance();
                } catch (Throwable unused4) {
                }
            }
            if (this.iThirdAuthorizeService == null) {
                try {
                    this.iThirdAuthorizeService = (IThirdAuthorizeService) Class.forName("com.bytedance.upc.third.authorize.UpcThirdAuthorizeService").newInstance();
                } catch (Throwable unused5) {
                }
            }
            if (this.iUpcPrivacyDialogService == null) {
                try {
                    this.iUpcPrivacyDialogService = (IUpcDialogService) Class.forName("com.bytedance.upc.dialog.UpcDialogService").newInstance();
                } catch (Throwable unused6) {
                }
            }
            if (this.iUpcTeenModeService == null) {
                try {
                    this.iUpcTeenModeService = (IUpcTeenModeService) Class.forName("com.bytedance.upc.teen.UpcTeenService").newInstance();
                } catch (Throwable unused7) {
                }
            }
            return new Configuration(this);
        }
    }
}
