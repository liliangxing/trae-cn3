package com.bytedance.ies.argus.base;

import com.bytedance.ies.argus.api.interfaces.service.IArgusWebSecureService;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ArgusServiceManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/bytedance/ies/argus/base/ArgusServiceManager;", "", "()V", "webServiceList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/bytedance/ies/argus/api/interfaces/service/IArgusWebSecureService;", "getWebServiceList", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "add", "", "delegate", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class ArgusServiceManager {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy<ArgusServiceManager> instance$delegate = LazyKt.lazy(new Function0<ArgusServiceManager>() { // from class: com.bytedance.ies.argus.base.ArgusServiceManager$Companion$instance$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final ArgusServiceManager m610invoke() {
            return new ArgusServiceManager();
        }
    });
    private final CopyOnWriteArrayList<IArgusWebSecureService> webServiceList = new CopyOnWriteArrayList<>();

    /* compiled from: ArgusServiceManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/ies/argus/base/ArgusServiceManager$Companion;", "", "()V", "instance", "Lcom/bytedance/ies/argus/base/ArgusServiceManager;", "getInstance", "()Lcom/bytedance/ies/argus/base/ArgusServiceManager;", "instance$delegate", "Lkotlin/Lazy;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ArgusServiceManager getInstance() {
            return (ArgusServiceManager) ArgusServiceManager.instance$delegate.getValue();
        }
    }

    public final CopyOnWriteArrayList<IArgusWebSecureService> getWebServiceList() {
        return this.webServiceList;
    }

    public final void add(IArgusWebSecureService delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        CopyOnWriteArrayList<IArgusWebSecureService> copyOnWriteArrayList = this.webServiceList;
        boolean z = false;
        if (!(copyOnWriteArrayList instanceof Collection) || !copyOnWriteArrayList.isEmpty()) {
            Iterator<T> it = copyOnWriteArrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (Intrinsics.areEqual(((IArgusWebSecureService) it.next()).serviceName(), delegate.serviceName())) {
                    z = true;
                    break;
                }
            }
        }
        if (z) {
            return;
        }
        this.webServiceList.add(delegate);
    }
}
