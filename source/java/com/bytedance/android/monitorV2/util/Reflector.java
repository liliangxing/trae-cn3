package com.bytedance.android.monitorV2.util;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.bdinstall.Api;
import com.vivo.push.PushClientConstants;
import java.lang.ref.WeakReference;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Reflector.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003\u0012\u0013\u0014B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J6\u0010\u0003\u001a\u00020\u0004\"\b\b\u0000\u0010\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u0002H\u00052\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u00020\u00040\t¢\u0006\u0002\b\n¢\u0006\u0002\u0010\u000bJ \u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00050\r\"\u0004\b\u0000\u0010\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00050\u000eJ\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\r2\u0006\u0010\u000f\u001a\u00020\u0001J\u0014\u0010\f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u0011¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/monitorV2/util/Reflector;", "", "()V", Api.KEY_ACCESS, "", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/lang/reflect/AccessibleObject;", "f", "accessor", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/reflect/AccessibleObject;Lkotlin/jvm/functions/Function1;)V", "clazz", "Lcom/bytedance/android/monitorV2/util/Reflector$RefClass;", "Ljava/lang/Class;", "obj", "clazzName", "", "RefClass", "RefInstance", "RefMethod", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public final class Reflector {
    public static final Reflector INSTANCE = new Reflector();

    private Reflector() {
    }

    public final <T extends AccessibleObject> void access(T f, Function1<? super T, Unit> accessor) {
        Intrinsics.checkNotNullParameter(f, "f");
        Intrinsics.checkNotNullParameter(accessor, "accessor");
        boolean isAccessible = f.isAccessible();
        f.setAccessible(true);
        accessor.invoke(f);
        f.setAccessible(isAccessible);
    }

    public final <T> RefClass<T> clazz(Class<T> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        return new RefClass<>(clazz);
    }

    public final RefClass<Object> clazz(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        return new RefClass<>(obj.getClass());
    }

    public final RefClass<?> clazz(String clazzName) {
        Intrinsics.checkNotNullParameter(clazzName, "clazzName");
        try {
            Class<?> cls = Class.forName(clazzName);
            Intrinsics.checkNotNullExpressionValue(cls, "forName(clazzName)");
            return new RefClass<>(cls);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* compiled from: Reflector.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B9\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0010\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002¢\u0006\u0002\u0010\nJ\u0006\u0010\u0010\u001a\u00020\u0011J\b\u0010\u0012\u001a\u0004\u0018\u00010\fJ(\u0010\u0013\u001a\u0004\u0018\u00010\u00022\u0016\u0010\u0014\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\b\"\u0004\u0018\u00010\u0002H\u0086\u0002¢\u0006\u0002\u0010\u0015J\t\u0010\u0016\u001a\u00020\u0011H\u0086\u0002J\u0019\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\t\u001a\u00028\u0000¢\u0006\u0002\u0010\u0018J2\u0010\u0017\u001a\u00020\u00192\u0006\u0010\t\u001a\u00028\u00002\u001d\u0010\u001a\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0000\u0012\u0004\u0012\u00020\u00190\u001b¢\u0006\u0002\b\u001c¢\u0006\u0002\u0010\u001dR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000f¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/monitorV2/util/Reflector$RefMethod;", ExifInterface.GPS_DIRECTION_TRUE, "", "clazz", "Ljava/lang/Class;", "methodName", "", PushClientConstants.TAG_PARAM_TYPES, "", "obj", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;Ljava/lang/Object;)V", "mMethodInstance", "Ljava/lang/reflect/Method;", "mObjRef", "Ljava/lang/ref/WeakReference;", "[Ljava/lang/Class;", "exist", "", "getMethod", "invoke", "args", "([Ljava/lang/Object;)Ljava/lang/Object;", "not", "with", "(Ljava/lang/Object;)Lcom/bytedance/android/monitorV2/util/Reflector$RefMethod;", "", "domain", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes3.dex */
    public static class RefMethod<T> {
        private final Class<T> clazz;
        private Method mMethodInstance;
        private WeakReference<Object> mObjRef;
        private final String methodName;
        private final Class<?>[] paramTypes;

        public RefMethod(Class<T> clazz, String methodName, Class<?>[] paramTypes, Object obj) {
            Intrinsics.checkNotNullParameter(clazz, "clazz");
            Intrinsics.checkNotNullParameter(methodName, "methodName");
            Intrinsics.checkNotNullParameter(paramTypes, "paramTypes");
            this.clazz = clazz;
            this.methodName = methodName;
            this.paramTypes = paramTypes;
            this.mObjRef = new WeakReference<>(obj);
        }

        public /* synthetic */ RefMethod(Class cls, String str, Class[] clsArr, Object obj, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(cls, str, clsArr, (i & 8) != 0 ? null : obj);
        }

        public final Method getMethod() {
            if (this.mMethodInstance == null) {
                try {
                    Class<T> cls = this.clazz;
                    String str = this.methodName;
                    Class<?>[] clsArr = this.paramTypes;
                    this.mMethodInstance = cls.getDeclaredMethod(str, (Class[]) Arrays.copyOf(clsArr, clsArr.length));
                } catch (Throwable th) {
                    ExceptionUtil.handleException(th);
                }
            }
            return this.mMethodInstance;
        }

        public final RefMethod<T> with(T obj) {
            this.mObjRef = new WeakReference<>(obj);
            return this;
        }

        public final void with(T obj, Function1<? super RefMethod<T>, Unit> domain) {
            Intrinsics.checkNotNullParameter(domain, "domain");
            this.mObjRef = new WeakReference<>(obj);
            domain.invoke(this);
        }

        public final boolean exist() {
            return getMethod() != null;
        }

        public final boolean not() {
            return !exist();
        }

        public final Object invoke(Object... args) {
            Intrinsics.checkNotNullParameter(args, "args");
            if (not()) {
                return null;
            }
            try {
                Method method = getMethod();
                if (method == null) {
                    return null;
                }
                WeakReference<Object> weakReference = this.mObjRef;
                return method.invoke(weakReference != null ? weakReference.get() : null, Arrays.copyOf(args, args.length));
            } catch (Throwable th) {
                ExceptionUtil.handleException(th);
                return null;
            }
        }
    }

    /* compiled from: Reflector.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u001f\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0002\u0010\u0006J-\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b2\u0006\u0010\t\u001a\u00020\n2\u0012\b\u0002\u0010\u000b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\f¢\u0006\u0002\u0010\rR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/monitorV2/util/Reflector$RefInstance;", ExifInterface.GPS_DIRECTION_TRUE, "", "clazz", "Ljava/lang/Class;", "obj", "(Ljava/lang/Class;Ljava/lang/Object;)V", "method", "Lcom/bytedance/android/monitorV2/util/Reflector$RefMethod;", "methodName", "", PushClientConstants.TAG_PARAM_TYPES, "", "(Ljava/lang/String;[Ljava/lang/Class;)Lcom/bytedance/android/monitorV2/util/Reflector$RefMethod;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class RefInstance<T> {
        private final Class<T> clazz;
        private final Object obj;

        public RefInstance(Class<T> clazz, Object obj) {
            Intrinsics.checkNotNullParameter(clazz, "clazz");
            this.clazz = clazz;
            this.obj = obj;
        }

        public /* synthetic */ RefInstance(Class cls, Object obj, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(cls, (i & 2) != 0 ? null : obj);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ RefMethod method$default(RefInstance refInstance, String str, Class[] clsArr, int i, Object obj) {
            if ((i & 2) != 0) {
                clsArr = new Class[0];
            }
            return refInstance.method(str, clsArr);
        }

        public final RefMethod<T> method(String methodName, Class<?>[] paramTypes) {
            Intrinsics.checkNotNullParameter(methodName, "methodName");
            Intrinsics.checkNotNullParameter(paramTypes, "paramTypes");
            return new RefMethod<>(this.clazz, methodName, paramTypes, this.obj);
        }
    }

    /* compiled from: Reflector.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005J-\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\u0006\u0010\b\u001a\u00020\t2\u0012\b\u0002\u0010\n\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u000b¢\u0006\u0002\u0010\fJ\u001b\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u0010R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/monitorV2/util/Reflector$RefClass;", ExifInterface.GPS_DIRECTION_TRUE, "", "clazz", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "method", "Lcom/bytedance/android/monitorV2/util/Reflector$RefMethod;", "methodName", "", PushClientConstants.TAG_PARAM_TYPES, "", "(Ljava/lang/String;[Ljava/lang/Class;)Lcom/bytedance/android/monitorV2/util/Reflector$RefMethod;", "with", "Lcom/bytedance/android/monitorV2/util/Reflector$RefInstance;", "obj", "(Ljava/lang/Object;)Lcom/bytedance/android/monitorV2/util/Reflector$RefInstance;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class RefClass<T> {
        private final Class<T> clazz;

        public RefClass(Class<T> clazz) {
            Intrinsics.checkNotNullParameter(clazz, "clazz");
            this.clazz = clazz;
        }

        public final RefInstance<T> with(T obj) {
            return new RefInstance<>(this.clazz, obj);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ RefMethod method$default(RefClass refClass, String str, Class[] clsArr, int i, Object obj) {
            if ((i & 2) != 0) {
                clsArr = new Class[0];
            }
            return refClass.method(str, clsArr);
        }

        public final RefMethod<T> method(String methodName, Class<?>[] paramTypes) {
            Intrinsics.checkNotNullParameter(methodName, "methodName");
            Intrinsics.checkNotNullParameter(paramTypes, "paramTypes");
            DefaultConstructorMarker defaultConstructorMarker = null;
            return new RefInstance(this.clazz, defaultConstructorMarker, 2, defaultConstructorMarker).method(methodName, paramTypes);
        }
    }
}
