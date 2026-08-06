package com.bytedance.retrofit2;

import com.bytedance.retrofit2.CallAdapter;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class DefaultCallAdapterFactory extends CallAdapter.Factory {
    static final CallAdapter.Factory INSTANCE = new DefaultCallAdapterFactory();

    DefaultCallAdapterFactory() {
    }

    @Override // com.bytedance.retrofit2.CallAdapter.Factory
    public CallAdapter<?, ?> get(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        if (getRawType(type) != Call.class) {
            return null;
        }
        final Type callResponseType = Utils.getCallResponseType(type);
        return new CallAdapter<Object, Call<?>>() { // from class: com.bytedance.retrofit2.DefaultCallAdapterFactory.1
            @Override // com.bytedance.retrofit2.CallAdapter
            /* renamed from: adapt, reason: merged with bridge method [inline-methods] */
            public Call<?> adapt2(Call<Object> call) {
                return call;
            }

            @Override // com.bytedance.retrofit2.CallAdapter
            public Type responseType() {
                return callResponseType;
            }
        };
    }
}
