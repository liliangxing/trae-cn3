package com.bytedance.ies.bullet.web.pia;

import com.bytedance.ies.bullet.prefetchv2.PrefetchRequestConfig;
import com.bytedance.ies.bullet.web.pia.PiaResourceLoader;
import com.bytedance.pia.core.api.context.IContainerContext;
import com.bytedance.pia.core.api.resource.IPiaPreloader;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PiaCustomContext.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J&\u0010\u000b\u001a\u0004\u0018\u0001H\f\"\u0004\b\u0000\u0010\f2\u000e\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\f0\u000eH\u0096\u0002¢\u0006\u0002\u0010\u000fR\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ies/bullet/web/pia/PiaCustomContext;", "Lcom/bytedance/pia/core/api/context/IContainerContext;", "resLoadConfig", "Lcom/bytedance/ies/bullet/web/pia/PiaResourceLoader$Config;", "(Lcom/bytedance/ies/bullet/web/pia/PiaResourceLoader$Config;)V", "preloader", "Lcom/bytedance/ies/bullet/web/pia/ForestPiaPreloader;", "getPreloader", "()Lcom/bytedance/ies/bullet/web/pia/ForestPiaPreloader;", "preloader$delegate", "Lkotlin/Lazy;", PrefetchRequestConfig.METHOD_GET, "T", "type", "Ljava/lang/Class;", "(Ljava/lang/Class;)Ljava/lang/Object;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class PiaCustomContext implements IContainerContext {

    /* renamed from: preloader$delegate, reason: from kotlin metadata */
    private final Lazy preloader;
    private final PiaResourceLoader.Config resLoadConfig;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public PiaCustomContext() {
        this(r0, 1, r0);
        PiaResourceLoader.Config config = null;
    }

    public PiaCustomContext(PiaResourceLoader.Config config) {
        this.resLoadConfig = config;
        this.preloader = LazyKt.lazy(new Function0<ForestPiaPreloader>() { // from class: com.bytedance.ies.bullet.web.pia.PiaCustomContext$preloader$2
            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final ForestPiaPreloader m603invoke() {
                return new ForestPiaPreloader();
            }
        });
    }

    public /* synthetic */ PiaCustomContext(PiaResourceLoader.Config config, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : config);
    }

    private final ForestPiaPreloader getPreloader() {
        return (ForestPiaPreloader) this.preloader.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.pia.core.api.context.IContainerContext
    public <T> T get(Class<? extends T> type) {
        Object obj;
        Intrinsics.checkNotNullParameter(type, "type");
        if (Intrinsics.areEqual(type, IPiaPreloader.class)) {
            Object preloader = getPreloader();
            obj = preloader;
            if (preloader == null) {
                return null;
            }
        } else {
            if (!Intrinsics.areEqual(type, PiaResourceLoader.Config.class)) {
                return null;
            }
            Object obj2 = this.resLoadConfig;
            obj = obj2;
            if (obj2 == null) {
                return null;
            }
        }
        return obj;
    }
}
