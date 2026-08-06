package coil3;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: SingletonImageLoader.common.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* renamed from: coil3.SingletonImageLoader$SingletonImageLoader$VolatileWrapper$atomicfu$private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public /* synthetic */ class C0709x535a4b86 {
    private static final /* synthetic */ AtomicReferenceFieldUpdater reference$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(C0709x535a4b86.class, Object.class, "reference$volatile");
    private volatile /* synthetic */ Object reference$volatile;

    private C0709x535a4b86() {
    }

    public /* synthetic */ C0709x535a4b86(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private final /* synthetic */ Object getReference$volatile() {
        return this.reference$volatile;
    }

    private final /* synthetic */ void setReference$volatile(Object obj) {
        this.reference$volatile = obj;
    }
}
