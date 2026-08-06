package com.bytedance.trae.service;

import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.login.api.ILoginService;
import com.bytedance.trae.login.bytecloud.BytecloudAuthManager;
import com.bytedance.trae.login.traeauth.TraeAuthStorage;
import com.bytedance.trae.login.user.UserInfo;
import com.bytedance.trae.network.HostResolver;
import com.bytedance.trae.network.HostType;
import com.bytedance.trae.network.HttpConst;
import com.bytedance.trae.network.TraeTTNet;
import com.bytedance.trae.platform.api.ISdkCommonHttp;
import com.bytedance.trae.platform.model.HttpEnvConfig;
import com.bytedance.trae.platform.service.ApplogService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* compiled from: SdkCommonHttpImpl.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\u0007H\u0016J\u0014\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\rH\u0016J\u0014\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\rH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0007H\u0016¨\u0006\u0012"}, d2 = {"Lcom/bytedance/trae/service/SdkCommonHttpImpl;", "Lcom/bytedance/trae/platform/api/ISdkCommonHttp;", "<init>", "()V", "getHttpEnvConfig", "Lcom/bytedance/trae/platform/model/HttpEnvConfig;", "getToken", "", "getBoeHost", "getBoeBaseUrl", "getOnlineHost", "getOnlineBaseUrl", "getCommonParams", "", "getCommonAppendHeaders", "getPluginVersion", "", "getFrontierUserId", "app_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class SdkCommonHttpImpl implements ISdkCommonHttp {
    public static final int $stable = 0;
    public static final SdkCommonHttpImpl INSTANCE = new SdkCommonHttpImpl();

    @Override // com.bytedance.trae.platform.api.ISdkCommonHttp
    public int getPluginVersion() {
        return -1;
    }

    private SdkCommonHttpImpl() {
    }

    @Override // com.bytedance.trae.platform.api.ISdkCommonHttp
    public HttpEnvConfig getHttpEnvConfig() {
        return TraeTTNet.INSTANCE.getHttpEnv();
    }

    @Override // com.bytedance.trae.platform.api.ISdkCommonHttp
    public String getToken() {
        String xTToken;
        ILoginService iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        return (iLoginService == null || (xTToken = iLoginService.getXTToken()) == null) ? "" : xTToken;
    }

    @Override // com.bytedance.trae.platform.api.ISdkCommonHttp
    public String getBoeHost() {
        return HttpConst.INSTANCE.getBOE_HOST();
    }

    @Override // com.bytedance.trae.platform.api.ISdkCommonHttp
    public String getBoeBaseUrl() {
        return HttpConst.INSTANCE.getBOE();
    }

    @Override // com.bytedance.trae.platform.api.ISdkCommonHttp
    public String getOnlineHost() {
        return HostResolver.INSTANCE.getBaseUrl(HostType.f144AI);
    }

    @Override // com.bytedance.trae.platform.api.ISdkCommonHttp
    public String getOnlineBaseUrl() {
        return HostResolver.INSTANCE.getBaseUrl(HostType.f144AI);
    }

    @Override // com.bytedance.trae.platform.api.ISdkCommonHttp
    public Map<String, String> getCommonParams() {
        return MapsKt.emptyMap();
    }

    @Override // com.bytedance.trae.platform.api.ISdkCommonHttp
    public Map<String, String> getCommonAppendHeaders() {
        if (!AppHost.Companion.isOversea()) {
            return MapsKt.emptyMap();
        }
        String uploadRegion = TraeAuthStorage.INSTANCE.getUploadRegion();
        return uploadRegion.length() == 0 ? MapsKt.emptyMap() : MapsKt.mapOf(TuplesKt.to("x-user-region", uploadRegion));
    }

    @Override // com.bytedance.trae.platform.api.ISdkCommonHttp
    public String getFrontierUserId() {
        String userId;
        if (BytecloudAuthManager.INSTANCE.isBytecloudLogin()) {
            UserInfo userInfo = TraeAuthStorage.INSTANCE.getUserInfo();
            return (userInfo == null || (userId = userInfo.getUserId()) == null) ? "" : userId;
        }
        return ApplogService.INSTANCE.getUserID();
    }
}
