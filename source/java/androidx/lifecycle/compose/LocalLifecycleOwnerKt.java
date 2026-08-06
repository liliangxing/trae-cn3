package androidx.lifecycle.compose;

import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.lifecycle.LifecycleOwner;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LocalLifecycleOwner.android.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u001d\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\u000e\n\u0000\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"LocalLifecycleOwner", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/lifecycle/LifecycleOwner;", "getLocalLifecycleOwner$annotations", "()V", "getLocalLifecycleOwner", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "lifecycle-runtime-compose"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class LocalLifecycleOwnerKt {
    private static final ProvidableCompositionLocal<LifecycleOwner> LocalLifecycleOwner;

    public static /* synthetic */ void getLocalLifecycleOwner$annotations() {
    }

    public static final ProvidableCompositionLocal<LifecycleOwner> getLocalLifecycleOwner() {
        return LocalLifecycleOwner;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x005b  */
    static {
        Object obj;
        ProvidableCompositionLocal<LifecycleOwner> providableCompositionLocal;
        Method method;
        boolean z;
        ProvidableCompositionLocal providableCompositionLocal2;
        try {
            Result.Companion companion = Result.Companion;
            ClassLoader classLoader = LifecycleOwner.class.getClassLoader();
            Intrinsics.checkNotNull(classLoader);
            method = classLoader.loadClass("androidx.compose.ui.platform.AndroidCompositionLocals_androidKt").getMethod("getLocalLifecycleOwner", new Class[0]);
            Annotation[] annotations = method.getAnnotations();
            int length = annotations.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    z = false;
                    break;
                } else {
                    if (annotations[i] instanceof Deprecated) {
                        z = true;
                        break;
                    }
                    i++;
                }
            }
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (!z) {
            Object invoke = method.invoke(null, new Object[0]);
            if (invoke instanceof ProvidableCompositionLocal) {
                providableCompositionLocal2 = (ProvidableCompositionLocal) invoke;
                obj = Result.constructor-impl(providableCompositionLocal2);
                providableCompositionLocal = (ProvidableCompositionLocal) (Result.isFailure-impl(obj) ? null : obj);
                if (providableCompositionLocal == null) {
                    providableCompositionLocal = CompositionLocalKt.staticCompositionLocalOf(new Function0() { // from class: androidx.lifecycle.compose.LocalLifecycleOwnerKt$$ExternalSyntheticLambda0
                        public final Object invoke() {
                            LifecycleOwner LocalLifecycleOwner$lambda$3$lambda$2;
                            LocalLifecycleOwner$lambda$3$lambda$2 = LocalLifecycleOwnerKt.LocalLifecycleOwner$lambda$3$lambda$2();
                            return LocalLifecycleOwner$lambda$3$lambda$2;
                        }
                    });
                }
                LocalLifecycleOwner = providableCompositionLocal;
            }
        }
        providableCompositionLocal2 = null;
        obj = Result.constructor-impl(providableCompositionLocal2);
        providableCompositionLocal = (ProvidableCompositionLocal) (Result.isFailure-impl(obj) ? null : obj);
        if (providableCompositionLocal == null) {
        }
        LocalLifecycleOwner = providableCompositionLocal;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LifecycleOwner LocalLifecycleOwner$lambda$3$lambda$2() {
        throw new IllegalStateException("CompositionLocal LocalLifecycleOwner not present".toString());
    }
}
