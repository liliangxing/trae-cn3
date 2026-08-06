package com.bytedance.retrofit2;

import com.bytedance.retrofit2.Utils;
import com.bytedance.retrofit2.mime.TypedInput;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import javax.annotation.Nullable;
import kotlin.coroutines.Continuation;
import okhttp3.Response;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public abstract class HttpServiceMethod<ResponseT, ReturnT> extends ServiceMethod<ReturnT> {
    final RequestFactory<ReturnT> requestFactory;

    @Nullable
    protected abstract ReturnT adapt(Call<ResponseT> call, Object[] objArr);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <ResponseT, ReturnT> HttpServiceMethod<ResponseT, ReturnT> parseAnnotations(Retrofit retrofit, Method method, RequestFactory requestFactory) {
        Type genericReturnType;
        boolean z;
        boolean z2 = requestFactory.isKotlinSuspendFunction;
        Annotation[] annotations = method.getAnnotations();
        if (z2) {
            Type[] genericParameterTypes = method.getGenericParameterTypes();
            Type parameterLowerBound = Utils.getParameterLowerBound(0, (ParameterizedType) genericParameterTypes[genericParameterTypes.length - 1]);
            if (Utils.getRawType(parameterLowerBound) == SsResponse.class && (parameterLowerBound instanceof ParameterizedType)) {
                parameterLowerBound = Utils.getParameterUpperBound(0, (ParameterizedType) parameterLowerBound);
                z = true;
            } else {
                z = false;
            }
            genericReturnType = new Utils.ParameterizedTypeImpl(null, Call.class, parameterLowerBound);
            annotations = SkipCallbackExecutorImpl.ensurePresent(annotations);
        } else {
            genericReturnType = method.getGenericReturnType();
            z = false;
        }
        CallAdapter createCallAdapter = createCallAdapter(retrofit, method, genericReturnType, annotations);
        Type responseType = createCallAdapter.responseType();
        if (responseType == Response.class) {
            throw Utils.methodError(method, "'" + Utils.getRawType(responseType).getName() + "' is not a valid response body type. Did you mean ResponseBody?", new Object[0]);
        }
        if (responseType == SsResponse.class) {
            throw Utils.methodError(method, "Response must include generic type (e.g., SsResponse<String>)", new Object[0]);
        }
        if (responseType == com.bytedance.retrofit2.client.Response.class) {
            throw Utils.methodError(method, "'" + Utils.getRawType(responseType).getName() + "' is not a valid response body type.", new Object[0]);
        }
        if (requestFactory.httpMethod.equals(HttpMethodContrants.HEAD) && !Void.class.equals(responseType)) {
            throw Utils.methodError(method, "HEAD method must use Void as response type.", new Object[0]);
        }
        requestFactory.responseConverter = createResponseConverter(retrofit, method, responseType);
        if (!z2) {
            return new CallAdapted(requestFactory, createCallAdapter);
        }
        if (z) {
            return new SuspendForResponse(requestFactory, createCallAdapter);
        }
        return new SuspendForBody(requestFactory, createCallAdapter, false);
    }

    private static <ResponseT, ReturnT> CallAdapter<ResponseT, ReturnT> createCallAdapter(Retrofit retrofit, Method method, Type type, Annotation[] annotationArr) {
        try {
            return (CallAdapter<ResponseT, ReturnT>) retrofit.callAdapter(type, annotationArr);
        } catch (RuntimeException e) {
            throw Utils.methodError(method, e, "Unable to create call adapter for %s", type);
        }
    }

    private static <ResponseT> Converter<TypedInput, ResponseT> createResponseConverter(Retrofit retrofit, Method method, Type type) {
        try {
            return retrofit.responseBodyConverter(type, method.getAnnotations());
        } catch (RuntimeException e) {
            throw Utils.methodError(method, e, "Unable to create converter for %s", type);
        }
    }

    HttpServiceMethod(RequestFactory<ReturnT> requestFactory) {
        this.requestFactory = requestFactory;
    }

    @Override // com.bytedance.retrofit2.ServiceMethod
    @Nullable
    final ReturnT invoke(Object[] objArr) {
        return adapt(new SsHttpCall(this.requestFactory, objArr), objArr);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    static final class CallAdapted<ResponseT, ReturnT> extends HttpServiceMethod<ResponseT, ReturnT> {
        private final CallAdapter<ResponseT, ReturnT> callAdapter;

        CallAdapted(RequestFactory requestFactory, CallAdapter<ResponseT, ReturnT> callAdapter) {
            super(requestFactory);
            this.callAdapter = callAdapter;
        }

        @Override // com.bytedance.retrofit2.HttpServiceMethod
        protected ReturnT adapt(Call<ResponseT> call, Object[] objArr) {
            return this.callAdapter.adapt2(call);
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    static final class SuspendForResponse<ResponseT> extends HttpServiceMethod<ResponseT, Object> {
        private final CallAdapter<ResponseT, Call<ResponseT>> callAdapter;

        SuspendForResponse(RequestFactory requestFactory, CallAdapter<ResponseT, Call<ResponseT>> callAdapter) {
            super(requestFactory);
            this.callAdapter = callAdapter;
        }

        @Override // com.bytedance.retrofit2.HttpServiceMethod
        protected Object adapt(Call<ResponseT> call, Object[] objArr) {
            Call<ResponseT> adapt2 = this.callAdapter.adapt2(call);
            Continuation continuation = (Continuation) objArr[objArr.length - 1];
            try {
                return KotlinExtensions.awaitResponse(adapt2, continuation);
            } catch (Exception e) {
                return KotlinExtensions.suspendAndThrow(e, continuation);
            }
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    static final class SuspendForBody<ResponseT> extends HttpServiceMethod<ResponseT, Object> {
        private final CallAdapter<ResponseT, Call<ResponseT>> callAdapter;
        private final boolean isNullable;

        SuspendForBody(RequestFactory requestFactory, CallAdapter<ResponseT, Call<ResponseT>> callAdapter, boolean z) {
            super(requestFactory);
            this.callAdapter = callAdapter;
            this.isNullable = z;
        }

        @Override // com.bytedance.retrofit2.HttpServiceMethod
        protected Object adapt(Call<ResponseT> call, Object[] objArr) {
            Call<ResponseT> adapt2 = this.callAdapter.adapt2(call);
            Continuation continuation = (Continuation) objArr[objArr.length - 1];
            try {
                if (this.isNullable) {
                    return KotlinExtensions.awaitNullable(adapt2, continuation);
                }
                return KotlinExtensions.await(adapt2, continuation);
            } catch (Exception e) {
                return KotlinExtensions.suspendAndThrow(e, continuation);
            }
        }
    }
}
