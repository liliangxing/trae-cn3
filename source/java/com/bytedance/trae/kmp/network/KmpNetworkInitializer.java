package com.bytedance.trae.kmp.network;

import com.bytedance.kmp.network.IKmpNetworkService;
import com.bytedance.kmp.spi.KmpServiceManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* compiled from: KmpNetworkInitializer.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/kmp/network/KmpNetworkInitializer;", "", "<init>", "()V", "registered", "", "ensureRegistered", "", "base_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class KmpNetworkInitializer {
    private static volatile boolean registered;
    public static final KmpNetworkInitializer INSTANCE = new KmpNetworkInitializer();
    public static final int $stable = 8;

    private KmpNetworkInitializer() {
    }

    public final void ensureRegistered() {
        if (registered) {
            return;
        }
        synchronized (this) {
            if (registered) {
                return;
            }
            KmpServiceManager.INSTANCE.put((KClass<KClass>) Reflection.getOrCreateKotlinClass(IKmpNetworkService.class), (KClass) new TraeKmpNetworkService());
            registered = true;
            Unit unit = Unit.INSTANCE;
        }
    }
}
