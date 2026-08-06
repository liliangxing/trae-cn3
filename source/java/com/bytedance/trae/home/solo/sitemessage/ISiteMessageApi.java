package com.bytedance.trae.home.solo.sitemessage;

import com.bytedance.retrofit2.Converter;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.QueryMap;
import com.bytedance.trae.login.api.ILoginService;
import com.bytedance.trae.network.DebugSettings;
import com.bytedance.trae.network.HostResolver;
import com.bytedance.trae.network.HostType;
import com.bytedance.trae.network.TraeHttpConnection;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;

/* compiled from: SiteMessageApi.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013J$\u0010\u0002\u001a\u00020\u00032\u0014\b\u0001\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005H§@¢\u0006\u0002\u0010\u0007J$\u0010\b\u001a\u00020\t2\u0014\b\u0001\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005H§@¢\u0006\u0002\u0010\u0007J\u0018\u0010\n\u001a\u00020\u00012\b\b\u0001\u0010\u000b\u001a\u00020\fH§@¢\u0006\u0002\u0010\rJ$\u0010\u000e\u001a\u00020\u000f2\u0014\b\u0001\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005H§@¢\u0006\u0002\u0010\u0007J)\u0010\u0010\u001a\u00020\u00112\u0019\b\u0001\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\t\u0012\u00070\u0001¢\u0006\u0002\b\u00120\u0005H§@¢\u0006\u0002\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/bytedance/trae/home/solo/sitemessage/ISiteMessageApi;", "", "getUnreadCount", "Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageCountResponse;", "params", "", "", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getList", "Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListResponse;", "updateStatus", "body", "Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageUpdateStatusBody;", "(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageUpdateStatusBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPreferences", "Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesGetResponse;", "updatePreferences", "Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesPostResponse;", "Lkotlin/jvm/JvmSuppressWildcards;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public interface ISiteMessageApi {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @GET("icube/api/v1/notifications/list")
    Object getList(@QueryMap Map<String, String> map, Continuation<? super SiteMessageListResponse> continuation);

    @GET("icube/api/v1/notifications/preferences")
    Object getPreferences(@QueryMap Map<String, String> map, Continuation<? super SiteMessagePreferencesGetResponse> continuation);

    @GET("icube/api/v1/notifications/count")
    Object getUnreadCount(@QueryMap Map<String, String> map, Continuation<? super SiteMessageCountResponse> continuation);

    @POST("icube/api/v1/notifications/preferences")
    Object updatePreferences(@Body Map<String, Object> map, Continuation<? super SiteMessagePreferencesPostResponse> continuation);

    @POST("icube/api/v1/notifications/update_status")
    Object updateStatus(@Body SiteMessageUpdateStatusBody siteMessageUpdateStatusBody, Continuation<Object> continuation);

    /* compiled from: SiteMessageApi.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/home/solo/sitemessage/ISiteMessageApi$Companion;", "", "<init>", "()V", "BOE_BASE_URL", "", "createService", "Lcom/bytedance/trae/home/solo/sitemessage/ISiteMessageApi;", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final String BOE_BASE_URL = "https://icube-boe-api.bytedance.net";

        private Companion() {
        }

        public final ISiteMessageApi createService() {
            boolean notificationBoe = DebugSettings.INSTANCE.getNotificationBoe();
            String baseUrl = notificationBoe ? BOE_BASE_URL : HostResolver.INSTANCE.getBaseUrl(HostType.NOTIFICATION);
            ILoginService iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
            String xTToken = iLoginService != null ? iLoginService.getXTToken() : null;
            if (xTToken == null) {
                xTToken = "";
            }
            Map createMapBuilder = MapsKt.createMapBuilder();
            if (xTToken.length() > 0) {
                createMapBuilder.put("Authorization", "Cloud-IDE-JWT " + xTToken);
            }
            if (notificationBoe) {
                createMapBuilder.put("x-tt-env", "boe_notification");
                createMapBuilder.put("x-use-boe", "1");
            }
            return (ISiteMessageApi) TraeHttpConnection.createService$default(TraeHttpConnection.INSTANCE, "site_message", ISiteMessageApi.class, (Converter.Factory) null, baseUrl, MapsKt.build(createMapBuilder), false, 36, (Object) null);
        }
    }
}
