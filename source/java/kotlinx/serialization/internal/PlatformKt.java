package kotlinx.serialization.internal;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Polymorphic;
import kotlinx.serialization.PolymorphicSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationException;
import me.ele.lancet.base.annotations.ClassOf;
import net.openid.appauth.BuildConfig;

/* compiled from: Platform.kt */
@Metadata(m4d1 = {"\u0000N\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u0018\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\u0005\u001a&\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0080\b¢\u0006\u0002\u0010\u0005\u001a\u0015\u0010\u0000\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0004H\u0080\b\u001a\u001c\u0010\b\u001a\u00020\u0006\"\b\b\u0000\u0010\u0001*\u00020\t*\b\u0012\u0004\u0012\u0002H\u00010\nH\u0000\u001a$\u0010\u000b\u001a\n\u0012\u0004\u0012\u0002H\u0001\u0018\u00010\f\"\b\b\u0000\u0010\u0001*\u00020\t*\b\u0012\u0004\u0012\u0002H\u00010\nH\u0000\u001aK\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u0002\"\b\b\u0000\u0010\u0001*\u00020\t\"\n\b\u0001\u0010\u000e*\u0004\u0018\u0001H\u0001*\u0012\u0012\u0004\u0012\u0002H\u000e0\u0010j\b\u0012\u0004\u0012\u0002H\u000e`\u000f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00010\nH\u0000¢\u0006\u0002\u0010\u0012\u001a\u0010\u0010\u0013\u001a\u00020\u0014*\u0006\u0012\u0002\b\u00030\nH\u0000\u001a\u0010\u0010\u0015\u001a\u00020\u0014*\u0006\u0012\u0002\b\u00030\u0016H\u0000\u001aM\u0010\u0017\u001a\n\u0012\u0004\u0012\u0002H\u0001\u0018\u00010\f\"\b\b\u0000\u0010\u0001*\u00020\t*\b\u0012\u0004\u0012\u0002H\u00010\n2\"\u0010\u0018\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\f0\u0002\"\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\fH\u0000¢\u0006\u0002\u0010\u0019\u001aM\u0010\u0017\u001a\n\u0012\u0004\u0012\u0002H\u0001\u0018\u00010\f\"\b\b\u0000\u0010\u0001*\u00020\t*\b\u0012\u0004\u0012\u0002H\u00010\u00162\"\u0010\u0018\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\f0\u0002\"\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\fH\u0000¢\u0006\u0002\u0010\u001a\u001aM\u0010\u001b\u001a\n\u0012\u0004\u0012\u0002H\u0001\u0018\u00010\f\"\b\b\u0000\u0010\u0001*\u00020\t*\b\u0012\u0004\u0012\u0002H\u00010\u00162\"\u0010\u0018\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\f0\u0002\"\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\fH\u0002¢\u0006\u0002\u0010\u001a\u001a\u001e\u0010\u001c\u001a\u0004\u0018\u00010\t\"\b\b\u0000\u0010\u0001*\u00020\t*\b\u0012\u0004\u0012\u0002H\u00010\u0016H\u0002\u001a\u001c\u0010\u001d\u001a\u00020\u0006\"\b\b\u0000\u0010\u0001*\u00020\t*\b\u0012\u0004\u0012\u0002H\u00010\u0016H\u0002\u001a\u001c\u0010\u001e\u001a\u00020\u0006\"\b\b\u0000\u0010\u0001*\u00020\t*\b\u0012\u0004\u0012\u0002H\u00010\u0016H\u0002\u001aO\u0010\u001f\u001a\n\u0012\u0004\u0012\u0002H\u0001\u0018\u00010\f\"\b\b\u0000\u0010\u0001*\u00020\t2\n\u0010 \u001a\u0006\u0012\u0002\b\u00030\u00162\"\u0010\u0018\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\f0\u0002\"\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\fH\u0002¢\u0006\u0002\u0010\u001a\u001aK\u0010!\u001a\n\u0012\u0004\u0012\u0002H\u0001\u0018\u00010\f\"\b\b\u0000\u0010\u0001*\u00020\t2\u0006\u0010\"\u001a\u00020\t2\"\u0010\u0018\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\f0\u0002\"\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\fH\u0002¢\u0006\u0002\u0010#\u001a\u001a\u0010$\u001a\u0004\u0018\u00010\t*\u0006\u0012\u0002\b\u00030\u00162\u0006\u0010%\u001a\u00020&H\u0002\u001a\"\u0010'\u001a\b\u0012\u0004\u0012\u0002H\u00010\f\"\b\b\u0000\u0010\u0001*\u00020\t*\b\u0012\u0004\u0012\u0002H\u00010\u0016H\u0002\u001a$\u0010(\u001a\n\u0012\u0004\u0012\u0002H\u0001\u0018\u00010\f\"\b\b\u0000\u0010\u0001*\u00020\t*\b\u0012\u0004\u0012\u0002H\u00010\u0016H\u0002\u001a\u0016\u0010)\u001a\u00020\u00062\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\t0\nH\u0000¨\u0006+"}, m5d2 = {"getChecked", "T", BuildConfig.FLAVOR, ClassOf.INDEX, BuildConfig.FLAVOR, "([Ljava/lang/Object;I)Ljava/lang/Object;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "isInterface", BuildConfig.FLAVOR, "Lkotlin/reflect/KClass;", "compiledSerializerImpl", "Lkotlinx/serialization/KSerializer;", "toNativeArrayImpl", "E", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "eClass", "(Ljava/util/ArrayList;Lkotlin/reflect/KClass;)[Ljava/lang/Object;", "platformSpecificSerializerNotRegistered", BuildConfig.FLAVOR, "serializerNotRegistered", "Ljava/lang/Class;", "constructSerializerForGivenTypeArgs", "args", "(Lkotlin/reflect/KClass;[Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/KSerializer;", "(Ljava/lang/Class;[Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/KSerializer;", "findInNamedCompanion", "findNamedCompanionByAnnotation", "isNotAnnotated", "isPolymorphicSerializer", "invokeSerializerOnDefaultCompanion", "jClass", "invokeSerializerOnCompanion", "companion", "(Ljava/lang/Object;[Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/KSerializer;", "companionOrNull", "companionName", BuildConfig.FLAVOR, "createEnumSerializer", "findObjectSerializer", "isReferenceArray", "rootClass", "kotlinx-serialization-core"}, m6k = 2, m7mv = {2, 0, 0}, m9xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class PlatformKt {
    public static final <T> T getChecked(T[] tArr, int i) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return tArr[i];
    }

    public static final boolean getChecked(boolean[] zArr, int i) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        return zArr[i];
    }

    public static final <T> boolean isInterface(KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        return JvmClassMappingKt.getJavaClass((KClass) kClass).isInterface();
    }

    public static final <T> KSerializer<T> compiledSerializerImpl(KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        return constructSerializerForGivenTypeArgs(kClass, (KSerializer<Object>[]) new KSerializer[0]);
    }

    public static final <T, E extends T> E[] toNativeArrayImpl(ArrayList<E> arrayList, KClass<T> eClass) {
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        Intrinsics.checkNotNullParameter(eClass, "eClass");
        Object newInstance = Array.newInstance((Class<?>) JvmClassMappingKt.getJavaClass((KClass) eClass), arrayList.size());
        Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type kotlin.Array<E of kotlinx.serialization.internal.PlatformKt.toNativeArrayImpl>");
        E[] eArr = (E[]) arrayList.toArray((Object[]) newInstance);
        Intrinsics.checkNotNullExpressionValue(eArr, "toArray(...)");
        return eArr;
    }

    public static final Void platformSpecificSerializerNotRegistered(KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Platform_commonKt.serializerNotRegistered(kClass);
        throw new KotlinNothingValueException();
    }

    public static final Void serializerNotRegistered(Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "<this>");
        throw new SerializationException(Platform_commonKt.notRegisteredMessage((KClass<?>) JvmClassMappingKt.getKotlinClass(cls)));
    }

    public static final <T> KSerializer<T> constructSerializerForGivenTypeArgs(KClass<T> kClass, KSerializer<Object>... args) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Intrinsics.checkNotNullParameter(args, "args");
        return constructSerializerForGivenTypeArgs(JvmClassMappingKt.getJavaClass((KClass) kClass), (KSerializer<Object>[]) Arrays.copyOf(args, args.length));
    }

    public static final <T> KSerializer<T> constructSerializerForGivenTypeArgs(Class<T> cls, KSerializer<Object>... args) {
        Intrinsics.checkNotNullParameter(cls, "<this>");
        Intrinsics.checkNotNullParameter(args, "args");
        if (cls.isEnum() && isNotAnnotated(cls)) {
            return createEnumSerializer(cls);
        }
        KSerializer<T> invokeSerializerOnDefaultCompanion = invokeSerializerOnDefaultCompanion(cls, (KSerializer[]) Arrays.copyOf(args, args.length));
        if (invokeSerializerOnDefaultCompanion != null) {
            return invokeSerializerOnDefaultCompanion;
        }
        KSerializer<T> findObjectSerializer = findObjectSerializer(cls);
        if (findObjectSerializer != null) {
            return findObjectSerializer;
        }
        KSerializer<T> findInNamedCompanion = findInNamedCompanion(cls, (KSerializer[]) Arrays.copyOf(args, args.length));
        if (findInNamedCompanion != null) {
            return findInNamedCompanion;
        }
        if (isPolymorphicSerializer(cls)) {
            return new PolymorphicSerializer(JvmClassMappingKt.getKotlinClass(cls));
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x003f, code lost:
    
        if (r2 == false) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final <T> KSerializer<T> findInNamedCompanion(Class<T> cls, KSerializer<Object>... kSerializerArr) {
        Field field;
        KSerializer<T> invokeSerializerOnCompanion;
        Object findNamedCompanionByAnnotation = findNamedCompanionByAnnotation(cls);
        if (findNamedCompanionByAnnotation != null && (invokeSerializerOnCompanion = invokeSerializerOnCompanion(findNamedCompanionByAnnotation, (KSerializer[]) Arrays.copyOf(kSerializerArr, kSerializerArr.length))) != null) {
            return invokeSerializerOnCompanion;
        }
        try {
            Class<?>[] declaredClasses = cls.getDeclaredClasses();
            Intrinsics.checkNotNullExpressionValue(declaredClasses, "getDeclaredClasses(...)");
            Class<?>[] clsArr = declaredClasses;
            int length = clsArr.length;
            int i = 0;
            Class<?> cls2 = null;
            boolean z = false;
            while (true) {
                if (i < length) {
                    Class<?> cls3 = clsArr[i];
                    if (Intrinsics.areEqual(cls3.getSimpleName(), "$serializer")) {
                        if (z) {
                            break;
                        }
                        z = true;
                        cls2 = cls3;
                    }
                    i++;
                }
            }
            cls2 = null;
            Class<?> cls4 = cls2;
            Object obj = (cls4 == null || (field = cls4.getField("INSTANCE")) == null) ? null : field.get(null);
            if (obj instanceof KSerializer) {
                return (KSerializer) obj;
            }
            return null;
        } catch (NoSuchFieldException unused) {
            return null;
        }
    }

    private static final <T> Object findNamedCompanionByAnnotation(Class<T> cls) {
        Class<?> cls2;
        Class<?>[] declaredClasses = cls.getDeclaredClasses();
        Intrinsics.checkNotNullExpressionValue(declaredClasses, "getDeclaredClasses(...)");
        Class<?>[] clsArr = declaredClasses;
        int length = clsArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                cls2 = null;
                break;
            }
            cls2 = clsArr[i];
            if (cls2.getAnnotation(NamedCompanion.class) != null) {
                break;
            }
            i++;
        }
        Class<?> cls3 = cls2;
        if (cls3 == null) {
            return null;
        }
        String simpleName = cls3.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
        return companionOrNull(cls, simpleName);
    }

    private static final <T> boolean isNotAnnotated(Class<T> cls) {
        return cls.getAnnotation(Serializable.class) == null && cls.getAnnotation(Polymorphic.class) == null;
    }

    private static final <T> boolean isPolymorphicSerializer(Class<T> cls) {
        if (cls.getAnnotation(Polymorphic.class) != null) {
            return true;
        }
        Serializable serializable = (Serializable) cls.getAnnotation(Serializable.class);
        return serializable != null && Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(serializable.with()), Reflection.getOrCreateKotlinClass(PolymorphicSerializer.class));
    }

    private static final <T> KSerializer<T> invokeSerializerOnDefaultCompanion(Class<?> cls, KSerializer<Object>... kSerializerArr) {
        Object companionOrNull = companionOrNull(cls, "Companion");
        if (companionOrNull == null) {
            return null;
        }
        return invokeSerializerOnCompanion(companionOrNull, (KSerializer[]) Arrays.copyOf(kSerializerArr, kSerializerArr.length));
    }

    private static final <T> KSerializer<T> invokeSerializerOnCompanion(Object obj, KSerializer<Object>... kSerializerArr) {
        Class[] clsArr;
        try {
            if (kSerializerArr.length == 0) {
                clsArr = new Class[0];
            } else {
                int length = kSerializerArr.length;
                Class[] clsArr2 = new Class[length];
                for (int i = 0; i < length; i++) {
                    clsArr2[i] = KSerializer.class;
                }
                clsArr = clsArr2;
            }
            Object invoke = obj.getClass().getDeclaredMethod("serializer", (Class[]) Arrays.copyOf(clsArr, clsArr.length)).invoke(obj, Arrays.copyOf(kSerializerArr, kSerializerArr.length));
            if (invoke instanceof KSerializer) {
                return (KSerializer) invoke;
            }
            return null;
        } catch (NoSuchMethodException unused) {
            return null;
        } catch (InvocationTargetException e) {
            Throwable cause = e.getCause();
            if (cause == null) {
                throw e;
            }
            String message = cause.getMessage();
            if (message == null) {
                message = e.getMessage();
            }
            throw new InvocationTargetException(cause, message);
        }
    }

    private static final Object companionOrNull(Class<?> cls, String str) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.get(null);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static final <T> KSerializer<T> createEnumSerializer(Class<T> cls) {
        T[] enumConstants = cls.getEnumConstants();
        String canonicalName = cls.getCanonicalName();
        Intrinsics.checkNotNullExpressionValue(canonicalName, "getCanonicalName(...)");
        Intrinsics.checkNotNull(enumConstants, "null cannot be cast to non-null type kotlin.Array<out kotlin.Enum<*>>");
        return new EnumSerializer(canonicalName, (Enum[]) enumConstants);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x006b, code lost:
    
        r7 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00c3, code lost:
    
        if (r6 == false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0069, code lost:
    
        if (r6 == false) goto L32;
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0025 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00c0 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final <T> KSerializer<T> findObjectSerializer(Class<T> cls) {
        boolean z;
        boolean z2;
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            if (!(StringsKt.startsWith$default(canonicalName, "java.", false, 2, (Object) null) || StringsKt.startsWith$default(canonicalName, "kotlin.", false, 2, (Object) null))) {
                z = true;
                if (z) {
                    return null;
                }
                Field[] declaredFields = cls.getDeclaredFields();
                Intrinsics.checkNotNullExpressionValue(declaredFields, "getDeclaredFields(...)");
                Field[] fieldArr = declaredFields;
                int length = fieldArr.length;
                Field field = null;
                int i = 0;
                boolean z3 = false;
                while (true) {
                    if (i < length) {
                        Field field2 = fieldArr[i];
                        Field field3 = field2;
                        if (Intrinsics.areEqual(field3.getName(), "INSTANCE") && Intrinsics.areEqual(field3.getType(), cls) && Modifier.isStatic(field3.getModifiers())) {
                            if (z3) {
                                break;
                            }
                            z3 = true;
                            field = field2;
                        }
                        i++;
                    }
                }
                Field field4 = field;
                if (field4 == null) {
                    return null;
                }
                Object obj = field4.get(null);
                Method[] methods = cls.getMethods();
                Intrinsics.checkNotNullExpressionValue(methods, "getMethods(...)");
                Method[] methodArr = methods;
                int length2 = methodArr.length;
                Method method = null;
                int i2 = 0;
                boolean z4 = false;
                while (true) {
                    if (i2 < length2) {
                        Method method2 = methodArr[i2];
                        Method method3 = method2;
                        if (Intrinsics.areEqual(method3.getName(), "serializer")) {
                            Class<?>[] parameterTypes = method3.getParameterTypes();
                            Intrinsics.checkNotNullExpressionValue(parameterTypes, "getParameterTypes(...)");
                            if ((parameterTypes.length == 0) && Intrinsics.areEqual(method3.getReturnType(), KSerializer.class)) {
                                z2 = true;
                                if (z2) {
                                    if (z4) {
                                        break;
                                    }
                                    z4 = true;
                                    method = method2;
                                }
                                i2++;
                            }
                        }
                        z2 = false;
                        if (z2) {
                        }
                        i2++;
                    }
                }
                method = null;
                Method method4 = method;
                if (method4 == null) {
                    return null;
                }
                Object invoke = method4.invoke(obj, new Object[0]);
                if (invoke instanceof KSerializer) {
                    return (KSerializer) invoke;
                }
                return null;
            }
        }
        z = false;
        if (z) {
        }
    }

    public static final boolean isReferenceArray(KClass<Object> rootClass) {
        Intrinsics.checkNotNullParameter(rootClass, "rootClass");
        return JvmClassMappingKt.getJavaClass((KClass) rootClass).isArray();
    }
}
