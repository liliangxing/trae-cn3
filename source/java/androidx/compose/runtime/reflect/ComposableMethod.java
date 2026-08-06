package androidx.compose.runtime.reflect;

import androidx.compose.runtime.Composer;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: ComposableMethod.jvm.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\b\u001a\u00020\u0003J:\u0010\u0016\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u00012\u0016\u0010\u001a\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u000e\"\u0004\u0018\u00010\u0001H\u0086\u0002¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001f\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0012\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00130\u000e8F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006 "}, d2 = {"Landroidx/compose/runtime/reflect/ComposableMethod;", "", "method", "Ljava/lang/reflect/Method;", "composableInfo", "Landroidx/compose/runtime/reflect/ComposableInfo;", "<init>", "(Ljava/lang/reflect/Method;Landroidx/compose/runtime/reflect/ComposableInfo;)V", "asMethod", "parameterCount", "", "getParameterCount", "()I", "parameters", "", "Ljava/lang/reflect/Parameter;", "getParameters", "()[Ljava/lang/reflect/Parameter;", "parameterTypes", "Ljava/lang/Class;", "getParameterTypes", "()[Ljava/lang/Class;", "invoke", "composer", "Landroidx/compose/runtime/Composer;", "instance", "args", "(Landroidx/compose/runtime/Composer;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;", "equals", "", "other", "hashCode", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class ComposableMethod {
    public static final int $stable = 8;
    private final ComposableInfo composableInfo;
    private final Method method;

    public ComposableMethod(Method method, ComposableInfo composableInfo) {
        this.method = method;
        this.composableInfo = composableInfo;
    }

    /* renamed from: asMethod, reason: from getter */
    public final Method getMethod() {
        return this.method;
    }

    public final int getParameterCount() {
        return this.composableInfo.getRealParamsCount();
    }

    public final Parameter[] getParameters() {
        return (Parameter[]) ArraysKt.copyOfRange(this.method.getParameters(), 0, this.composableInfo.getRealParamsCount());
    }

    public final Class<?>[] getParameterTypes() {
        return (Class[]) ArraysKt.copyOfRange(this.method.getParameterTypes(), 0, this.composableInfo.getRealParamsCount());
    }

    public final Object invoke(Composer composer, Object instance, Object... args) {
        Object obj;
        ComposableInfo composableInfo = this.composableInfo;
        int realParamsCount = composableInfo.getRealParamsCount();
        int changedParams = composableInfo.getChangedParams();
        int defaultParams = composableInfo.getDefaultParams();
        int length = this.method.getParameterTypes().length;
        int i = realParamsCount + 1;
        int i2 = changedParams + i;
        Object[] objArr = new Integer[defaultParams];
        for (int i3 = 0; i3 < defaultParams; i3++) {
            int i4 = i3 * 31;
            Iterable until = RangesKt.until(i4, Math.min(i4 + 31, realParamsCount));
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(until, 10));
            IntIterator it = until.iterator();
            while (it.hasNext()) {
                int nextInt = it.nextInt();
                arrayList.add(Integer.valueOf((nextInt >= args.length || args[nextInt] == null) ? 1 : 0));
            }
            int i5 = 0;
            int i6 = 0;
            for (Object obj2 : arrayList) {
                int i7 = i6 + 1;
                if (i6 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                i5 |= ((Number) obj2).intValue() << i6;
                i6 = i7;
            }
            objArr[i3] = Integer.valueOf(i5);
        }
        Object[] objArr2 = new Object[length];
        int i8 = 0;
        while (i8 < length) {
            if (i8 >= 0 && i8 < realParamsCount) {
                obj = i8 >= 0 && i8 < args.length ? args[i8] : ComposableMethodKt.getDefaultValue(this.method.getParameterTypes()[i8]);
            } else if (i8 == realParamsCount) {
                obj = composer;
            } else {
                if (i8 != i) {
                    if (!(i + 1 <= i8 && i8 < i2)) {
                        if (i2 <= i8 && i8 < length) {
                            obj = objArr[i8 - i2];
                        } else {
                            throw new IllegalStateException("Unexpected index".toString());
                        }
                    }
                }
                obj = 0;
            }
            objArr2[i8] = obj;
            i8++;
        }
        return this.method.invoke(instance, Arrays.copyOf(objArr2, length));
    }

    public boolean equals(Object other) {
        if (other instanceof ComposableMethod) {
            return Intrinsics.areEqual(this.method, ((ComposableMethod) other).method);
        }
        return false;
    }

    public int hashCode() {
        return this.method.hashCode();
    }
}
