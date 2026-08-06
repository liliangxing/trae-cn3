package com.bytedance.sdk.open.aweme.init;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.open.aweme.core.OpenEventService;
import com.bytedance.sdk.open.aweme.core.OpenHostInfoService;
import com.bytedance.sdk.open.aweme.core.OpenHostSettingService;
import com.bytedance.sdk.open.aweme.core.OpenHostTicketService;
import com.bytedance.sdk.open.aweme.core.OpenImageService;
import com.bytedance.sdk.open.aweme.core.OpenLogService;
import com.bytedance.sdk.open.aweme.core.OpenNetworkService;
import com.bytedance.sdk.open.aweme.core.OpenOptionService;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class DouYinOpenSDKConfig {
    private String clientKey;
    private Context context;
    private Boolean enableDefaultTicketGuard;
    private OpenEventService eventService;
    private OpenHostInfoService hostInfoService;
    private OpenHostSettingService hostSettingService;
    private OpenHostTicketService hostTicketService;
    private OpenImageService imageService;
    private OpenLogService logService;
    private OpenNetworkService networkService;
    private OpenOptionService openOptionService;
    private boolean useClientTicket;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static class Builder {
        private String clientKey;
        private Context context;
        private Boolean enableDefaultTicketGuard;
        private OpenEventService eventService;
        private OpenHostInfoService hostInfoService;
        private OpenHostSettingService hostSettingService;
        private OpenHostTicketService hostTicketService;
        private OpenImageService imageService;
        private OpenLogService logService;
        private OpenNetworkService networkService;
        private OpenOptionService openOptionService;
        public boolean useClientTicket = false;

        public DouYinOpenSDKConfig build() {
            if (this.context == null) {
                throw new IllegalArgumentException("context不能为空");
            }
            if (TextUtils.isEmpty(this.clientKey)) {
                throw new IllegalArgumentException("clientKey不能为空");
            }
            DouYinOpenSDKConfig douYinOpenSDKConfig = new DouYinOpenSDKConfig();
            Context context = this.context;
            if (!(context instanceof Application)) {
                context = context.getApplicationContext();
            }
            douYinOpenSDKConfig.context = context;
            douYinOpenSDKConfig.clientKey = this.clientKey;
            douYinOpenSDKConfig.hostInfoService = this.hostInfoService;
            douYinOpenSDKConfig.networkService = this.networkService;
            douYinOpenSDKConfig.imageService = this.imageService;
            douYinOpenSDKConfig.logService = this.logService;
            douYinOpenSDKConfig.eventService = this.eventService;
            douYinOpenSDKConfig.enableDefaultTicketGuard = this.enableDefaultTicketGuard;
            douYinOpenSDKConfig.hostSettingService = this.hostSettingService;
            douYinOpenSDKConfig.hostTicketService = this.hostTicketService;
            douYinOpenSDKConfig.useClientTicket = this.useClientTicket;
            douYinOpenSDKConfig.openOptionService = this.openOptionService;
            return douYinOpenSDKConfig;
        }

        public Builder clientKey(String str) {
            this.clientKey = str;
            return this;
        }

        public Builder context(Context context) {
            this.context = context;
            return this;
        }

        public Builder enableDefaultTicketGuard(Boolean bool) {
            this.enableDefaultTicketGuard = bool;
            return this;
        }

        public Builder eventService(OpenEventService openEventService) {
            this.eventService = openEventService;
            return this;
        }

        public Builder hostInfoService(OpenHostInfoService openHostInfoService) {
            this.hostInfoService = openHostInfoService;
            return this;
        }

        public Builder hostSettingService(OpenHostSettingService openHostSettingService) {
            this.hostSettingService = openHostSettingService;
            return this;
        }

        public Builder hostTicketService(OpenHostTicketService openHostTicketService) {
            this.hostTicketService = openHostTicketService;
            return this;
        }

        public Builder imageService(OpenImageService openImageService) {
            this.imageService = openImageService;
            return this;
        }

        public Builder logService(OpenLogService openLogService) {
            this.logService = openLogService;
            return this;
        }

        public Builder networkService(OpenNetworkService openNetworkService) {
            this.networkService = openNetworkService;
            return this;
        }

        public Builder openOptionService(OpenOptionService openOptionService) {
            this.openOptionService = openOptionService;
            return this;
        }

        public Builder useClientTicket(boolean z) {
            this.useClientTicket = z;
            return this;
        }
    }

    private DouYinOpenSDKConfig() {
        this.enableDefaultTicketGuard = Boolean.FALSE;
        this.useClientTicket = false;
    }

    public String getClientKey() {
        return this.clientKey;
    }

    public Context getContext() {
        return this.context;
    }

    public Boolean getEnableDefaultTicketGuard() {
        return this.enableDefaultTicketGuard;
    }

    public OpenEventService getEventService() {
        return this.eventService;
    }

    public OpenHostInfoService getHostInfoService() {
        return this.hostInfoService;
    }

    public OpenHostSettingService getHostSettingService() {
        return this.hostSettingService;
    }

    public OpenHostTicketService getHostTicketService() {
        return this.hostTicketService;
    }

    public OpenImageService getImageService() {
        return this.imageService;
    }

    public OpenLogService getLogService() {
        return this.logService;
    }

    public OpenNetworkService getNetworkService() {
        return this.networkService;
    }

    public OpenOptionService getOpenOptionService() {
        return this.openOptionService;
    }

    public boolean isUseClientTicket() {
        return this.useClientTicket;
    }
}
