package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import net.openid.appauth.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Builders.common.kt */
@Metadata(m4d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\b\u0012\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0014¨\u0006\u000b"}, m5d2 = {"Lkotlinx/coroutines/StandaloneCoroutine;", "Lkotlinx/coroutines/AbstractCoroutine;", BuildConfig.FLAVOR, "parentContext", "Lkotlin/coroutines/CoroutineContext;", "active", BuildConfig.FLAVOR, "(Lkotlin/coroutines/CoroutineContext;Z)V", "handleJobException", "exception", BuildConfig.FLAVOR, "kotlinx-coroutines-core"}, m6k = 1, m7mv = {1, 9, 0}, m9xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public class StandaloneCoroutine extends AbstractCoroutine<Unit> {
    public StandaloneCoroutine(CoroutineContext coroutineContext, boolean z) {
        super(coroutineContext, true, z);
    }

    @Override // kotlinx.coroutines.JobSupport
    protected boolean handleJobException(Throwable exception) {
        CoroutineExceptionHandlerKt.handleCoroutineException(getContext(), exception);
        return true;
    }
}
