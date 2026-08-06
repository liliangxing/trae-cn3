package com.bytedance.timonbase.network;

import android.os.Build;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.Retrofit;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.QueryMap;
import com.bytedance.security.android.aopcheck.reporter.Constant;
import com.bytedance.timonbase.TMEnv;
import com.bytedance.timonbase.network.TMNetworkService;
import com.bytedance.ttnet.utils.RetrofitUtils;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.text.Regex;

/* compiled from: TMNetworkService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0015B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R#\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR#\u0010\r\u001a\n \b*\u0004\u0018\u00010\u000e0\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0016"}, d2 = {"Lcom/bytedance/timonbase/network/TMNetworkService;", "", "()V", "BASE_URL", "", "PLATFORM", "networkService", "Lcom/bytedance/timonbase/network/TMNetworkService$RequestService;", "kotlin.jvm.PlatformType", "getNetworkService", "()Lcom/bytedance/timonbase/network/TMNetworkService$RequestService;", "networkService$delegate", "Lkotlin/Lazy;", "retrofit", "Lcom/bytedance/retrofit2/Retrofit;", "getRetrofit", "()Lcom/bytedance/retrofit2/Retrofit;", "retrofit$delegate", "getSettings", "Lcom/bytedance/timonbase/network/Response;", "Lcom/bytedance/timonbase/network/Settings;", "RequestService", "timonbase_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TMNetworkService {
    private static final String BASE_URL = "https://timon.zijieapi.com";
    private static final String PLATFORM = "android";
    public static final TMNetworkService INSTANCE = new TMNetworkService();

    /* renamed from: retrofit$delegate, reason: from kotlin metadata */
    private static final Lazy retrofit = LazyKt.lazy(new Function0<Retrofit>() { // from class: com.bytedance.timonbase.network.TMNetworkService$retrofit$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Retrofit m1055invoke() {
            return RetrofitUtils.getSsRetrofit("https://timon.zijieapi.com");
        }
    });

    /* renamed from: networkService$delegate, reason: from kotlin metadata */
    private static final Lazy networkService = LazyKt.lazy(new Function0<RequestService>() { // from class: com.bytedance.timonbase.network.TMNetworkService$networkService$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final TMNetworkService.RequestService m1054invoke() {
            Retrofit retrofit2;
            retrofit2 = TMNetworkService.INSTANCE.getRetrofit();
            return (TMNetworkService.RequestService) retrofit2.create(TMNetworkService.RequestService.class);
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TMNetworkService.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\bb\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0014\b\u0001\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007H'¨\u0006\t"}, d2 = {"Lcom/bytedance/timonbase/network/TMNetworkService$RequestService;", "", "getSettings", "Lcom/bytedance/retrofit2/Call;", "Lcom/bytedance/timonbase/network/Response;", "Lcom/bytedance/timonbase/network/Settings;", "params", "", "", "timonbase_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface RequestService {
        @GET("/api/timon_config_proxy/config/get")
        Call<Response<Settings>> getSettings(@QueryMap Map<String, String> params);
    }

    private final RequestService getNetworkService() {
        return (RequestService) networkService.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Retrofit getRetrofit() {
        return (Retrofit) retrofit.getValue();
    }

    private TMNetworkService() {
    }

    public final Response<Settings> getSettings() {
        Map<String, String> mutableMapOf = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(Constant.KEY_APP_ID, String.valueOf(TMEnv.INSTANCE.getAppId())), TuplesKt.to(Constant.KEY_CHANNEL, TMEnv.INSTANCE.getChannel()), TuplesKt.to("client_version", String.valueOf(TMEnv.INSTANCE.getUpdateVersionCode())), TuplesKt.to("platform", PLATFORM), TuplesKt.to(Constant.KEY_DEVICE_TYPE, Build.MODEL), TuplesKt.to(Constant.KEY_DEVICE_BRAND, Build.BRAND), TuplesKt.to(Constant.KEY_OS_VERSION, Build.VERSION.RELEASE)});
        String str = (String) TMEnv.INSTANCE.getDidGetter().invoke();
        String str2 = str;
        if ((str2.length() > 0) && new Regex("\\d+").matches(str2)) {
            mutableMapOf.put("did", str);
        }
        if (TMEnv.INSTANCE.getUid().length() > 0) {
            mutableMapOf.put("uid", TMEnv.INSTANCE.getUid());
        }
        return (Response) getNetworkService().getSettings(mutableMapOf).execute().body();
    }
}
