package com.bytedance.ies.bullet.base.utils;

import com.bytedance.env.api.EnvManager;
import com.bytedance.env.api.GeckoConfig;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EnvToolsHelper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/bytedance/ies/bullet/base/utils/EnvToolsHelper;", "", "()V", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class EnvToolsHelper {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static volatile Boolean envSdkExists;

    /* compiled from: EnvToolsHelper.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007R\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/bytedance/ies/bullet/base/utils/EnvToolsHelper$Companion;", "", "()V", "envSdkExists", "", "Ljava/lang/Boolean;", "getGeckoEnv", "Lcom/bytedance/env/api/GeckoConfig;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final GeckoConfig getGeckoEnv() {
            Object obj;
            if (EnvToolsHelper.envSdkExists == null) {
                synchronized (EnvToolsHelper.class) {
                    if (EnvToolsHelper.envSdkExists == null) {
                        Companion companion = EnvToolsHelper.INSTANCE;
                        try {
                            Result.Companion companion2 = Result.Companion;
                            Class.forName("com.bytedance.env.api.GeckoConfig");
                            obj = Result.constructor-impl(Class.forName("com.bytedance.env.core.impl.EnvManagerApiImpl"));
                        } catch (Throwable th) {
                            Result.Companion companion3 = Result.Companion;
                            obj = Result.constructor-impl(ResultKt.createFailure(th));
                        }
                        EnvToolsHelper.envSdkExists = Boolean.valueOf(Result.isSuccess-impl(obj));
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            if (Intrinsics.areEqual(EnvToolsHelper.envSdkExists, true)) {
                return EnvManager.Companion.getService().getGeckoConfig();
            }
            return null;
        }
    }
}
