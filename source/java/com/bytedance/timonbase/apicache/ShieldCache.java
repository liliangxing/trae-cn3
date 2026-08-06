package com.bytedance.timonbase.apicache;

import com.bytedance.timonbase.commoncache.CacheEnv;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ShieldCache.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00042\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0004B\u0007\b\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/timonbase/apicache/ShieldCache;", "Lcom/bytedance/timonbase/commoncache/CacheEnv;", "Lcom/bytedance/timonbase/apicache/ApiArgs;", "()V", "Companion", "timonbase_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ShieldCache extends CacheEnv<ApiArgs> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy instance$delegate = LazyKt.lazy(new Function0<ShieldCache>() { // from class: com.bytedance.timonbase.apicache.ShieldCache$Companion$instance$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final ShieldCache m1047invoke() {
            return new ShieldCache(null);
        }
    });

    /* compiled from: ShieldCache.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/timonbase/apicache/ShieldCache$Companion;", "", "()V", "instance", "Lcom/bytedance/timonbase/apicache/ShieldCache;", "getInstance", "()Lcom/bytedance/timonbase/apicache/ShieldCache;", "instance$delegate", "Lkotlin/Lazy;", "timonbase_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public final ShieldCache getInstance() {
            Lazy lazy = ShieldCache.instance$delegate;
            Companion companion = ShieldCache.INSTANCE;
            return (ShieldCache) lazy.getValue();
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private ShieldCache() {
    }

    public /* synthetic */ ShieldCache(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
