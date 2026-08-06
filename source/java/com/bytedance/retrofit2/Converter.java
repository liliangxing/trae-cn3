package com.bytedance.retrofit2;

import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.mime.TypedOutput;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import javax.annotation.Nullable;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public interface Converter<F, T> {

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static abstract class Factory {
        @Nullable
        public Converter<?, Header> headerConverter(Type type, Annotation[] annotationArr, Retrofit retrofit) {
            return null;
        }

        @Nullable
        public Converter<?, Object> objectConverter(Type type, Annotation[] annotationArr, Retrofit retrofit) {
            return null;
        }

        @Nullable
        public Converter<?, TypedOutput> requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, Retrofit retrofit) {
            return null;
        }

        @Nullable
        public Converter<TypedInput, ?> responseBodyConverter(Type type, Annotation[] annotationArr, Retrofit retrofit) {
            return null;
        }

        @Nullable
        public Converter<?, String> stringConverter(Type type, Annotation[] annotationArr, Retrofit retrofit) {
            return null;
        }
    }

    @Nullable
    T convert(F f) throws IOException;

    default T convertWithRequestBuilder(F f, RequestBuilder requestBuilder) {
        return null;
    }

    default boolean needRequestBuilder() {
        return false;
    }
}
