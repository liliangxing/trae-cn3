package coil3.network.bytedance.internal;

import com.bytedance.kmp.spi.KmpServiceManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: utils.common.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\u001a\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0002\u001a\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\u0082@¢\u0006\u0002\u0010\n\"\u001a\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u000b"}, d2 = {"coilInterceptors", "", "Lcoil3/network/bytedance/internal/CoilInterceptor;", "getCoilInterceptors", "()Ljava/util/List;", "addCoilInterceptor", "", "interceptor", "getAllInterceptors", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "coil_network_service_release"}, k = 2, mv = {1, 7, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class Utils_commonKt {
    private static final List<CoilInterceptor> coilInterceptors = new ArrayList();

    public static final List<CoilInterceptor> getCoilInterceptors() {
        return coilInterceptors;
    }

    public static final void addCoilInterceptor(CoilInterceptor coilInterceptor) {
        Intrinsics.checkNotNullParameter(coilInterceptor, "interceptor");
        List<CoilInterceptor> list = coilInterceptors;
        boolean z = true;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (((CoilInterceptor) it.next()).getClass() == coilInterceptor.getClass()) {
                    z = false;
                    break;
                }
            }
        }
        if (z) {
            coilInterceptors.add(coilInterceptor);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object getAllInterceptors(Continuation<? super List<? extends CoilInterceptor>> continuation) {
        Utils_commonKt$getAllInterceptors$1 utils_commonKt$getAllInterceptors$1;
        int i;
        if (continuation instanceof Utils_commonKt$getAllInterceptors$1) {
            utils_commonKt$getAllInterceptors$1 = (Utils_commonKt$getAllInterceptors$1) continuation;
            if ((utils_commonKt$getAllInterceptors$1.label & Integer.MIN_VALUE) != 0) {
                utils_commonKt$getAllInterceptors$1.label -= Integer.MIN_VALUE;
                Object obj = utils_commonKt$getAllInterceptors$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = utils_commonKt$getAllInterceptors$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    ICoilInterceptorProvider iCoilInterceptorProvider = (ICoilInterceptorProvider) KmpServiceManager.INSTANCE.get(Reflection.getOrCreateKotlinClass(ICoilInterceptorProvider.class));
                    if (iCoilInterceptorProvider == null) {
                        return coilInterceptors;
                    }
                    CoroutineContext immediate = Dispatchers.getMain().getImmediate();
                    Utils_commonKt$getAllInterceptors$provideInterceptors$1 utils_commonKt$getAllInterceptors$provideInterceptors$1 = new Utils_commonKt$getAllInterceptors$provideInterceptors$1(iCoilInterceptorProvider, null);
                    utils_commonKt$getAllInterceptors$1.label = 1;
                    obj = BuildersKt.withContext(immediate, utils_commonKt$getAllInterceptors$provideInterceptors$1, utils_commonKt$getAllInterceptors$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return CollectionsKt.plus(coilInterceptors, (List) obj);
            }
        }
        utils_commonKt$getAllInterceptors$1 = new Utils_commonKt$getAllInterceptors$1(continuation);
        Object obj2 = utils_commonKt$getAllInterceptors$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = utils_commonKt$getAllInterceptors$1.label;
        if (i != 0) {
        }
        return CollectionsKt.plus(coilInterceptors, (List) obj2);
    }
}
