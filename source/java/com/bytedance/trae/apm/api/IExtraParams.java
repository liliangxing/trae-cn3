package com.bytedance.trae.apm.api;

import com.bytedance.trae.apm.api.IExtraParams;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IExtraParams.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\bg\u0018\u0000 \b2\u00020\u0001:\u0001\bJ\b\u0010\u0007\u001a\u00020\u0004H&R\u001e\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/trae/apm/api/IExtraParams;", "", "staticParams", "", "", "getStaticParams", "()Ljava/util/Map;", "getAppVariant", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public interface IExtraParams {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final String KEY_APP_VARIANT = "flow_app_variant";
    public static final String KEY_BUILD_JOB_ID = "flow_build_job_id";
    public static final String KEY_GIT_BRANCH = "flow_build_branch";
    public static final String KEY_GIT_COMMIT_ID = "flow_git_commit_id";
    public static final String KEY_PROCESS_ID = "flow_process_id";
    public static final String KEY_PROCESS_NAME = "flow_process_name";

    String getAppVariant();

    Map<String, String> getStaticParams();

    /* compiled from: IExtraParams.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0016\u001a\u00020\u0005H\u0016J \u0010\u0017\u001a\u00020\u00182\u0018\u0010\u0019\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\r0\fJ\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\"\u0010\u000b\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\r\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u000e\u001a\u0004\u0018\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R \u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001b"}, d2 = {"Lcom/bytedance/trae/apm/api/IExtraParams$Companion;", "Lcom/bytedance/trae/apm/api/IExtraParams;", "<init>", "()V", "KEY_GIT_COMMIT_ID", "", "KEY_BUILD_JOB_ID", "KEY_GIT_BRANCH", "KEY_PROCESS_NAME", "KEY_PROCESS_ID", "KEY_APP_VARIANT", "dynamicParamsProvider", "Lkotlin/Function0;", "", "impl", "getImpl", "()Lcom/bytedance/trae/apm/api/IExtraParams;", "impl$delegate", "Lkotlin/Lazy;", "staticParams", "getStaticParams", "()Ljava/util/Map;", "getAppVariant", "registerDynamicParamsProvider", "", "provider", "getDynamicParams", "api_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion implements IExtraParams {
        public static final String KEY_APP_VARIANT = "flow_app_variant";
        public static final String KEY_BUILD_JOB_ID = "flow_build_job_id";
        public static final String KEY_GIT_BRANCH = "flow_build_branch";
        public static final String KEY_GIT_COMMIT_ID = "flow_git_commit_id";
        public static final String KEY_PROCESS_ID = "flow_process_id";
        public static final String KEY_PROCESS_NAME = "flow_process_name";
        private static volatile Function0<? extends Map<String, String>> dynamicParamsProvider;
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        /* renamed from: impl$delegate, reason: from kotlin metadata */
        private static final Lazy<IExtraParams> impl = LazyKt.lazy(new Function0() { // from class: com.bytedance.trae.apm.api.IExtraParams$Companion$$ExternalSyntheticLambda0
            public final Object invoke() {
                IExtraParams impl_delegate$lambda$0;
                impl_delegate$lambda$0 = IExtraParams.Companion.impl_delegate$lambda$0();
                return impl_delegate$lambda$0;
            }
        });

        private Companion() {
        }

        private final IExtraParams getImpl() {
            return (IExtraParams) impl.getValue();
        }

        @Override // com.bytedance.trae.apm.api.IExtraParams
        public Map<String, String> getStaticParams() {
            Map<String, String> staticParams;
            IExtraParams impl2 = getImpl();
            return (impl2 == null || (staticParams = impl2.getStaticParams()) == null) ? MapsKt.emptyMap() : staticParams;
        }

        @Override // com.bytedance.trae.apm.api.IExtraParams
        public String getAppVariant() {
            String appVariant;
            IExtraParams impl2 = getImpl();
            return (impl2 == null || (appVariant = impl2.getAppVariant()) == null) ? "" : appVariant;
        }

        public final void registerDynamicParamsProvider(Function0<? extends Map<String, String>> provider) {
            Intrinsics.checkNotNullParameter(provider, "provider");
            dynamicParamsProvider = provider;
        }

        public final Map<String, String> getDynamicParams() {
            Map<String, String> map;
            Function0<? extends Map<String, String>> function0 = dynamicParamsProvider;
            return (function0 == null || (map = (Map) function0.invoke()) == null) ? MapsKt.emptyMap() : map;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final IExtraParams impl_delegate$lambda$0() {
            return (IExtraParams) ServiceManager.get().getService(IExtraParams.class);
        }
    }
}
