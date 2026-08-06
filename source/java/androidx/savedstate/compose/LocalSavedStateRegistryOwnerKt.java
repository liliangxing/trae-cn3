package androidx.savedstate.compose;

import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.savedstate.SavedStateRegistryOwner;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LocalSavedStateRegistryOwner.android.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"LocalSavedStateRegistryOwner", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/savedstate/SavedStateRegistryOwner;", "getLocalSavedStateRegistryOwner", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "savedstate-compose"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class LocalSavedStateRegistryOwnerKt {
    private static final ProvidableCompositionLocal<SavedStateRegistryOwner> LocalSavedStateRegistryOwner;

    public static final ProvidableCompositionLocal<SavedStateRegistryOwner> getLocalSavedStateRegistryOwner() {
        return LocalSavedStateRegistryOwner;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0064  */
    static {
        Object obj;
        ProvidableCompositionLocal<SavedStateRegistryOwner> providableCompositionLocal;
        Method method;
        boolean z;
        ProvidableCompositionLocal providableCompositionLocal2;
        try {
            Result.Companion companion = Result.Companion;
            ClassLoader classLoader = SavedStateRegistryOwner.class.getClassLoader();
            Intrinsics.checkNotNull(classLoader);
            method = classLoader.loadClass("androidx.compose.ui.platform.AndroidCompositionLocals_androidKt").getMethod("getLocalSavedStateRegistryOwner", new Class[0]);
            Annotation[] annotations = method.getAnnotations();
            Intrinsics.checkNotNullExpressionValue(annotations, "getAnnotations(...)");
            Annotation[] annotationArr = annotations;
            int length = annotationArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    z = false;
                    break;
                } else {
                    if (annotationArr[i] instanceof Deprecated) {
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
                    providableCompositionLocal = CompositionLocalKt.staticCompositionLocalOf(new Function0() { // from class: androidx.savedstate.compose.LocalSavedStateRegistryOwnerKt$$ExternalSyntheticLambda0
                        public final Object invoke() {
                            SavedStateRegistryOwner LocalSavedStateRegistryOwner$lambda$3$lambda$2;
                            LocalSavedStateRegistryOwner$lambda$3$lambda$2 = LocalSavedStateRegistryOwnerKt.LocalSavedStateRegistryOwner$lambda$3$lambda$2();
                            return LocalSavedStateRegistryOwner$lambda$3$lambda$2;
                        }
                    });
                }
                LocalSavedStateRegistryOwner = providableCompositionLocal;
            }
        }
        providableCompositionLocal2 = null;
        obj = Result.constructor-impl(providableCompositionLocal2);
        providableCompositionLocal = (ProvidableCompositionLocal) (Result.isFailure-impl(obj) ? null : obj);
        if (providableCompositionLocal == null) {
        }
        LocalSavedStateRegistryOwner = providableCompositionLocal;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SavedStateRegistryOwner LocalSavedStateRegistryOwner$lambda$3$lambda$2() {
        throw new IllegalStateException("CompositionLocal LocalSavedStateRegistryOwner not present".toString());
    }
}
