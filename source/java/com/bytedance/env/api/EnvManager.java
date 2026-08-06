package com.bytedance.env.api;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: EnvManagerApi.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/bytedance/env/api/EnvManager;", "", "()V", "Companion", "env_platform_api_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class EnvManager {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy apiImpl$delegate = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new Function0<EnvManagerApi>() { // from class: com.bytedance.env.api.EnvManager$Companion$apiImpl$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final EnvManagerApi m450invoke() {
            try {
                Object newInstance = Class.forName("com.bytedance.env.core.impl.EnvManagerApiImpl").newInstance();
                if (newInstance != null) {
                    return (EnvManagerApi) newInstance;
                }
                throw new TypeCastException("null cannot be cast to non-null type com.bytedance.env.api.EnvManagerApi");
            } catch (Exception unused) {
                return new DefaultEnvManagerApi();
            }
        }
    });

    @JvmStatic
    public static final EnvManagerApi getService() {
        return INSTANCE.getService();
    }

    /* compiled from: EnvManagerApi.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\u0004H\u0007R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/bytedance/env/api/EnvManager$Companion;", "", "()V", "apiImpl", "Lcom/bytedance/env/api/EnvManagerApi;", "getApiImpl", "()Lcom/bytedance/env/api/EnvManagerApi;", "apiImpl$delegate", "Lkotlin/Lazy;", "getService", "env_platform_api_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static final class Companion {
        private final EnvManagerApi getApiImpl() {
            Lazy lazy = EnvManager.apiImpl$delegate;
            Companion companion = EnvManager.INSTANCE;
            return (EnvManagerApi) lazy.getValue();
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final EnvManagerApi getService() {
            return getApiImpl();
        }
    }
}
