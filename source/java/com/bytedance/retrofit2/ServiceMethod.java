package com.bytedance.retrofit2;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public abstract class ServiceMethod<T> {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public abstract T invoke(Object[] objArr);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> ServiceMethod<T> parseAnnotations(Retrofit retrofit, Method method, RetrofitMetrics retrofitMetrics) {
        retrofitMetrics.createRequestFactoryStart();
        try {
            RequestFactory parseAnnotations = RequestFactory.parseAnnotations(retrofit, method, retrofitMetrics);
            retrofitMetrics.createRequestFactoryEnd();
            Type genericReturnType = method.getGenericReturnType();
            if (Utils.hasUnresolvableType(genericReturnType)) {
                throw Utils.methodError(method, "Method return type must not include a type variable or wildcard: %s", genericReturnType);
            }
            if (genericReturnType == Void.TYPE) {
                throw Utils.methodError(method, "Service methods cannot return void.", new Object[0]);
            }
            retrofitMetrics.createHttpServiceMethodStart();
            try {
                return HttpServiceMethod.parseAnnotations(retrofit, method, parseAnnotations);
            } finally {
                retrofitMetrics.createHttpServiceMethodEnd();
            }
        } catch (Throwable th) {
            retrofitMetrics.createRequestFactoryEnd();
            throw th;
        }
    }
}
