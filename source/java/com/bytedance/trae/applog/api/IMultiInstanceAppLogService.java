package com.bytedance.trae.applog.api;

import com.bytedance.trae.applog.api.IMultiInstanceAppLogService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IMultiInstanceAppLogService.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/bytedance/trae/applog/api/IMultiInstanceAppLogService;", "", "createInstance", "Lcom/bytedance/trae/applog/api/IMultiInstanceAppLog;", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public interface IMultiInstanceAppLogService {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    IMultiInstanceAppLog createInstance();

    /* compiled from: IMultiInstanceAppLogService.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\t\u001a\u00020\nH\u0016R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/bytedance/trae/applog/api/IMultiInstanceAppLogService$Companion;", "Lcom/bytedance/trae/applog/api/IMultiInstanceAppLogService;", "<init>", "()V", "impl", "getImpl", "()Lcom/bytedance/trae/applog/api/IMultiInstanceAppLogService;", "impl$delegate", "Lkotlin/Lazy;", "createInstance", "Lcom/bytedance/trae/applog/api/IMultiInstanceAppLog;", "api_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion implements IMultiInstanceAppLogService {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        /* renamed from: impl$delegate, reason: from kotlin metadata */
        private static final Lazy<IMultiInstanceAppLogService> impl = LazyKt.lazy(new Function0() { // from class: com.bytedance.trae.applog.api.IMultiInstanceAppLogService$Companion$$ExternalSyntheticLambda0
            public final Object invoke() {
                IMultiInstanceAppLogService impl_delegate$lambda$0;
                impl_delegate$lambda$0 = IMultiInstanceAppLogService.Companion.impl_delegate$lambda$0();
                return impl_delegate$lambda$0;
            }
        });

        private Companion() {
        }

        private final IMultiInstanceAppLogService getImpl() {
            return (IMultiInstanceAppLogService) impl.getValue();
        }

        @Override // com.bytedance.trae.applog.api.IMultiInstanceAppLogService
        public IMultiInstanceAppLog createInstance() {
            IMultiInstanceAppLogService impl2 = getImpl();
            Intrinsics.checkNotNull(impl2);
            return impl2.createInstance();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final IMultiInstanceAppLogService impl_delegate$lambda$0() {
            return (IMultiInstanceAppLogService) ServiceManager.get().getService(IMultiInstanceAppLogService.class);
        }
    }
}
