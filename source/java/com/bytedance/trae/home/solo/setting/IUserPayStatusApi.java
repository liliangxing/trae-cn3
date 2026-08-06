package com.bytedance.trae.home.solo.setting;

import com.bytedance.retrofit2.Converter;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.trae.network.HostResolver;
import com.bytedance.trae.network.HostType;
import com.bytedance.trae.network.TraeHttpConnection;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* compiled from: UserPayStatusApi.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005J\u000e\u0010\u0002\u001a\u00020\u0003H§@¢\u0006\u0002\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/IUserPayStatusApi;", "", "getUserPayStatus", "Lcom/bytedance/trae/home/solo/setting/UserPayStatusData;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public interface IUserPayStatusApi {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @GET("trae/api/v1/pay/ide_user_pay_status")
    Object getUserPayStatus(Continuation<? super UserPayStatusData> continuation);

    /* compiled from: UserPayStatusApi.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0002J\u000e\u0010\u0006\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/IUserPayStatusApi$Companion;", "", "<init>", "()V", "createService", "Lcom/bytedance/trae/home/solo/setting/IUserPayStatusApi;", "fetchPayStatus", "Lcom/bytedance/trae/home/solo/setting/UserPayStatusData;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        private final IUserPayStatusApi createService() {
            return (IUserPayStatusApi) TraeHttpConnection.createService$default(TraeHttpConnection.INSTANCE, "user_pay_status", IUserPayStatusApi.class, (Converter.Factory) null, HostResolver.INSTANCE.getBaseUrl(HostType.LOGIN), (Map) null, false, 52, (Object) null);
        }

        public final Object fetchPayStatus(Continuation<? super UserPayStatusData> continuation) {
            return createService().getUserPayStatus(continuation);
        }
    }
}
