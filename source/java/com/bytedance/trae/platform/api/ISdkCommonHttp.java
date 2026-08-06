package com.bytedance.trae.platform.api;

import com.bytedance.trae.platform.ITraeSdkCommonDepend;
import com.bytedance.trae.platform.api.ISdkCommonHttp;
import com.bytedance.trae.platform.model.HttpEnvConfig;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;

/* compiled from: ISdkCommonHttp.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0005H&J\n\u0010\b\u001a\u0004\u0018\u00010\u0005H&J\n\u0010\t\u001a\u0004\u0018\u00010\u0005H&J\u0014\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000bH&J\u0014\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000bH&J\b\u0010\r\u001a\u00020\u000eH&J\b\u0010\u000f\u001a\u00020\u0005H&¨\u0006\u0011"}, d2 = {"Lcom/bytedance/trae/platform/api/ISdkCommonHttp;", "", "getHttpEnvConfig", "Lcom/bytedance/trae/platform/model/HttpEnvConfig;", "getToken", "", "getBoeHost", "getBoeBaseUrl", "getOnlineHost", "getOnlineBaseUrl", "getCommonParams", "", "getCommonAppendHeaders", "getPluginVersion", "", "getFrontierUserId", "Companion", "platform_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public interface ISdkCommonHttp {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    String getBoeBaseUrl();

    String getBoeHost();

    Map<String, String> getCommonAppendHeaders();

    Map<String, String> getCommonParams();

    String getFrontierUserId();

    HttpEnvConfig getHttpEnvConfig();

    String getOnlineBaseUrl();

    String getOnlineHost();

    int getPluginVersion();

    String getToken();

    /* compiled from: ISdkCommonHttp.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\fH\u0016J\b\u0010\u0010\u001a\u00020\fH\u0016J\u0014\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u0012H\u0016J\u0014\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u0012H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\fH\u0016R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0017"}, d2 = {"Lcom/bytedance/trae/platform/api/ISdkCommonHttp$Companion;", "Lcom/bytedance/trae/platform/api/ISdkCommonHttp;", "<init>", "()V", "service", "getService", "()Lcom/bytedance/trae/platform/api/ISdkCommonHttp;", "service$delegate", "Lkotlin/Lazy;", "getHttpEnvConfig", "Lcom/bytedance/trae/platform/model/HttpEnvConfig;", "getToken", "", "getBoeHost", "getBoeBaseUrl", "getOnlineHost", "getOnlineBaseUrl", "getCommonParams", "", "getCommonAppendHeaders", "getPluginVersion", "", "getFrontierUserId", "platform_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion implements ISdkCommonHttp {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        /* renamed from: service$delegate, reason: from kotlin metadata */
        private static final Lazy<ISdkCommonHttp> service = LazyKt.lazy(new Function0() { // from class: com.bytedance.trae.platform.api.ISdkCommonHttp$Companion$$ExternalSyntheticLambda0
            public final Object invoke() {
                ISdkCommonHttp service_delegate$lambda$0;
                service_delegate$lambda$0 = ISdkCommonHttp.Companion.service_delegate$lambda$0();
                return service_delegate$lambda$0;
            }
        });

        private Companion() {
        }

        private final ISdkCommonHttp getService() {
            return (ISdkCommonHttp) service.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final ISdkCommonHttp service_delegate$lambda$0() {
            ITraeSdkCommonDepend iTraeSdkCommonDepend = (ITraeSdkCommonDepend) ServiceManager.get().getService(ITraeSdkCommonDepend.class);
            if (iTraeSdkCommonDepend != null) {
                return iTraeSdkCommonDepend.getCommonHttpService();
            }
            return null;
        }

        @Override // com.bytedance.trae.platform.api.ISdkCommonHttp
        public HttpEnvConfig getHttpEnvConfig() {
            HttpEnvConfig httpEnvConfig;
            ISdkCommonHttp service2 = getService();
            return (service2 == null || (httpEnvConfig = service2.getHttpEnvConfig()) == null) ? new HttpEnvConfig(false, null, false, null, 15, null) : httpEnvConfig;
        }

        @Override // com.bytedance.trae.platform.api.ISdkCommonHttp
        public String getToken() {
            String token;
            ISdkCommonHttp service2 = getService();
            return (service2 == null || (token = service2.getToken()) == null) ? "" : token;
        }

        @Override // com.bytedance.trae.platform.api.ISdkCommonHttp
        public String getBoeHost() {
            String boeHost;
            ISdkCommonHttp service2 = getService();
            return (service2 == null || (boeHost = service2.getBoeHost()) == null) ? "" : boeHost;
        }

        @Override // com.bytedance.trae.platform.api.ISdkCommonHttp
        public String getBoeBaseUrl() {
            String boeBaseUrl;
            ISdkCommonHttp service2 = getService();
            return (service2 == null || (boeBaseUrl = service2.getBoeBaseUrl()) == null) ? "" : boeBaseUrl;
        }

        @Override // com.bytedance.trae.platform.api.ISdkCommonHttp
        public String getOnlineHost() {
            String onlineHost;
            ISdkCommonHttp service2 = getService();
            return (service2 == null || (onlineHost = service2.getOnlineHost()) == null) ? "" : onlineHost;
        }

        @Override // com.bytedance.trae.platform.api.ISdkCommonHttp
        public String getOnlineBaseUrl() {
            String onlineBaseUrl;
            ISdkCommonHttp service2 = getService();
            return (service2 == null || (onlineBaseUrl = service2.getOnlineBaseUrl()) == null) ? "" : onlineBaseUrl;
        }

        @Override // com.bytedance.trae.platform.api.ISdkCommonHttp
        public Map<String, String> getCommonParams() {
            Map<String, String> commonParams;
            ISdkCommonHttp service2 = getService();
            return (service2 == null || (commonParams = service2.getCommonParams()) == null) ? MapsKt.emptyMap() : commonParams;
        }

        @Override // com.bytedance.trae.platform.api.ISdkCommonHttp
        public Map<String, String> getCommonAppendHeaders() {
            Map<String, String> commonAppendHeaders;
            ISdkCommonHttp service2 = getService();
            return (service2 == null || (commonAppendHeaders = service2.getCommonAppendHeaders()) == null) ? MapsKt.emptyMap() : commonAppendHeaders;
        }

        @Override // com.bytedance.trae.platform.api.ISdkCommonHttp
        public int getPluginVersion() {
            ISdkCommonHttp service2 = getService();
            if (service2 != null) {
                return service2.getPluginVersion();
            }
            return -1;
        }

        @Override // com.bytedance.trae.platform.api.ISdkCommonHttp
        public String getFrontierUserId() {
            String frontierUserId;
            ISdkCommonHttp service2 = getService();
            return (service2 == null || (frontierUserId = service2.getFrontierUserId()) == null) ? "" : frontierUserId;
        }
    }
}
