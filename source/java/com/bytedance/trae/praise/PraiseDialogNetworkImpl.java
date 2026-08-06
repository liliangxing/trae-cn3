package com.bytedance.trae.praise;

import com.bytedance.ies.bullet.prefetchv2.PrefetchRequestConfig;
import com.bytedance.praisedialoglib.depend.IPraiseDialogNetworkConfig;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.http.FieldMap;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Url;
import com.bytedance.trae.network.HostResolver;
import com.bytedance.trae.network.HostType;
import com.bytedance.trae.praise.PraiseDialogNetworkImpl;
import com.bytedance.ttnet.utils.RetrofitUtils;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PraiseDialogNetworkImpl.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000bH\u0016J.\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000b2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0016"}, d2 = {"Lcom/bytedance/trae/praise/PraiseDialogNetworkImpl;", "Lcom/bytedance/praisedialoglib/depend/IPraiseDialogNetworkConfig;", "<init>", "()V", "api", "Lcom/bytedance/trae/praise/PraiseDialogNetworkImpl$PraiseApi;", "getApi", "()Lcom/bytedance/trae/praise/PraiseDialogNetworkImpl$PraiseApi;", "api$delegate", "Lkotlin/Lazy;", "executeGet", "", "maxLength", "", "url", "executePost", "params", "", "checkResponseException", "e", "", "PraiseApi", "praise_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class PraiseDialogNetworkImpl implements IPraiseDialogNetworkConfig {

    /* renamed from: api$delegate, reason: from kotlin metadata */
    private final Lazy api = LazyKt.lazy(new Function0() { // from class: com.bytedance.trae.praise.PraiseDialogNetworkImpl$$ExternalSyntheticLambda0
        public final Object invoke() {
            PraiseDialogNetworkImpl.PraiseApi api_delegate$lambda$0;
            api_delegate$lambda$0 = PraiseDialogNetworkImpl.api_delegate$lambda$0();
            return api_delegate$lambda$0;
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PraiseDialogNetworkImpl.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\bb\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0004H'J0\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00042\u0014\b\u0001\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\bH'¨\u0006\t"}, d2 = {"Lcom/bytedance/trae/praise/PraiseDialogNetworkImpl$PraiseApi;", "", PrefetchRequestConfig.METHOD_GET, "Lcom/bytedance/retrofit2/Call;", "", "url", PrefetchRequestConfig.METHOD_POST, "params", "", "praise_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public interface PraiseApi {
        @GET
        Call<String> get(@Url String url);

        @FormUrlEncoded
        @POST
        Call<String> post(@Url String url, @FieldMap Map<String, String> params);
    }

    @Override // com.bytedance.praisedialoglib.depend.IPraiseDialogNetworkConfig
    public int checkResponseException(Throwable e) {
        Intrinsics.checkNotNullParameter(e, "e");
        return 0;
    }

    private final PraiseApi getApi() {
        Object value = this.api.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (PraiseApi) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PraiseApi api_delegate$lambda$0() {
        return (PraiseApi) RetrofitUtils.createSsRetrofit(HostResolver.INSTANCE.getBaseUrl(HostType.PRAISE), CollectionsKt.emptyList(), null).create(PraiseApi.class);
    }

    @Override // com.bytedance.praisedialoglib.depend.IPraiseDialogNetworkConfig
    public String executeGet(int maxLength, String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        SsResponse<String> execute = getApi().get(url).execute();
        if (execute != null) {
            return execute.body();
        }
        return null;
    }

    @Override // com.bytedance.praisedialoglib.depend.IPraiseDialogNetworkConfig
    public String executePost(int maxLength, String url, Map<String, String> params) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(params, "params");
        SsResponse<String> execute = getApi().post(url, params).execute();
        if (execute != null) {
            return execute.body();
        }
        return null;
    }
}
