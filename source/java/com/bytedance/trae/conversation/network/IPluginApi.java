package com.bytedance.trae.conversation.network;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.http.ExtraInfo;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.QueryMap;
import com.bytedance.trae.conversation.network.IPluginApi;
import com.bytedance.trae.network.DebugSettings;
import com.bytedance.trae.network.HostResolver;
import com.bytedance.trae.network.HostType;
import com.bytedance.trae.network.TraeHttpConnection;
import com.bytedance.trae.network.response.HttpDataResult;
import com.bytedance.ttnet.http.RequestContext;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IPluginApi.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\bf\u0018\u0000 \t2\u00020\u0001:\u0001\tJ2\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\u0014\b\u0001\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00062\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0001H'J2\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\u0014\b\u0001\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00062\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0001H'¨\u0006\n"}, d2 = {"Lcom/bytedance/trae/conversation/network/IPluginApi;", "", "listRemotePluginsRaw", "Lcom/bytedance/retrofit2/Call;", "", "query", "", "extraInfo", "listLocalPluginsRaw", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public interface IPluginApi {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @GET("api/solo_hub/v1/apps/clis/plugins")
    Call<String> listLocalPluginsRaw(@QueryMap Map<String, String> query, @ExtraInfo Object extraInfo);

    @GET("api/remote/v1/plugins")
    Call<String> listRemotePluginsRaw(@QueryMap Map<String, String> query, @ExtraInfo Object extraInfo);

    /* compiled from: IPluginApi.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tH\u0086@¢\u0006\u0002\u0010\u0011J(\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tH\u0086@¢\u0006\u0002\u0010\u0011R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/bytedance/trae/conversation/network/IPluginApi$Companion;", "", "<init>", "()V", "REMOTE_PLUGIN_SUCCESS_CODES", "", "", "LOCAL_PLUGIN_SUCCESS_CODES", "DEFAULT_HEADERS", "", "", "getDEFAULT_HEADERS", "()Ljava/util/Map;", "listRemotePlugins", "Lcom/bytedance/trae/network/response/HttpDataResult;", "Lcom/bytedance/trae/conversation/network/ListPluginsData;", "query", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "listLocalPlugins", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final Set<Long> REMOTE_PLUGIN_SUCCESS_CODES = SetsKt.setOf(0L);
        private static final Set<Long> LOCAL_PLUGIN_SUCCESS_CODES = SetsKt.setOf(200L);

        private Companion() {
        }

        private final Map<String, String> getDEFAULT_HEADERS() {
            return DebugSettings.buildDefaultHeaders$default(DebugSettings.INSTANCE, (Map) null, 1, (Object) null);
        }

        public final Object listRemotePlugins(final Map<String, String> map, Continuation<? super HttpDataResult<ListPluginsData>> continuation) {
            return TraeHttpConnection.rawBizCall$default(TraeHttpConnection.INSTANCE, "plugins", IPluginApi.class, ListPluginsData.class, (String) null, HostResolver.INSTANCE.getBaseUrl(HostType.REMOTE), (Map) null, false, REMOTE_PLUGIN_SUCCESS_CODES, true, new Function2() { // from class: com.bytedance.trae.conversation.network.IPluginApi$Companion$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Call listRemotePlugins$lambda$0;
                    listRemotePlugins$lambda$0 = IPluginApi.Companion.listRemotePlugins$lambda$0(map, (IPluginApi) obj, (RequestContext) obj2);
                    return listRemotePlugins$lambda$0;
                }
            }, continuation, 104, (Object) null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Call listRemotePlugins$lambda$0(Map map, IPluginApi iPluginApi, RequestContext requestContext) {
            Intrinsics.checkNotNullParameter(iPluginApi, "$this$rawBizCall");
            Intrinsics.checkNotNullParameter(requestContext, "requestContext");
            return iPluginApi.listRemotePluginsRaw(map, requestContext);
        }

        public final Object listLocalPlugins(final Map<String, String> map, Continuation<? super HttpDataResult<ListPluginsData>> continuation) {
            return TraeHttpConnection.rawBizCall$default(TraeHttpConnection.INSTANCE, "plugins", IPluginApi.class, ListPluginsData.class, (String) null, (String) null, getDEFAULT_HEADERS(), true, LOCAL_PLUGIN_SUCCESS_CODES, true, new Function2() { // from class: com.bytedance.trae.conversation.network.IPluginApi$Companion$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Call listLocalPlugins$lambda$1;
                    listLocalPlugins$lambda$1 = IPluginApi.Companion.listLocalPlugins$lambda$1(map, (IPluginApi) obj, (RequestContext) obj2);
                    return listLocalPlugins$lambda$1;
                }
            }, continuation, 24, (Object) null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Call listLocalPlugins$lambda$1(Map map, IPluginApi iPluginApi, RequestContext requestContext) {
            Intrinsics.checkNotNullParameter(iPluginApi, "$this$rawBizCall");
            Intrinsics.checkNotNullParameter(requestContext, "requestContext");
            return iPluginApi.listLocalPluginsRaw(map, requestContext);
        }
    }
}
