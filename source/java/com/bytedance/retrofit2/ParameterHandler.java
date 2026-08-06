package com.bytedance.retrofit2;

import com.bytedance.retrofit2.http.ext.QueryParamObject;
import com.bytedance.retrofit2.mime.TypedOutput;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import okhttp3.Headers;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public abstract class ParameterHandler<T> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void apply(RequestBuilder requestBuilder, @Nullable T t) throws IOException;

    ParameterHandler() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final ParameterHandler<Iterable<T>> iterable() {
        return new ParameterHandler<Iterable<T>>() { // from class: com.bytedance.retrofit2.ParameterHandler.1
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.bytedance.retrofit2.ParameterHandler
            public void apply(RequestBuilder requestBuilder, @Nullable Iterable<T> iterable) throws IOException {
                if (iterable == null) {
                    return;
                }
                Iterator<T> it = iterable.iterator();
                while (it.hasNext()) {
                    ParameterHandler.this.apply(requestBuilder, it.next());
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final ParameterHandler<Object> array() {
        return new ParameterHandler<Object>() { // from class: com.bytedance.retrofit2.ParameterHandler.2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.bytedance.retrofit2.ParameterHandler
            void apply(RequestBuilder requestBuilder, @Nullable Object obj) throws IOException {
                if (obj == null) {
                    return;
                }
                int length = Array.getLength(obj);
                for (int i = 0; i < length; i++) {
                    ParameterHandler.this.apply(requestBuilder, Array.get(obj, i));
                }
            }
        };
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    static final class RelativeUrl extends ParameterHandler<Object> {
        private final java.lang.reflect.Method method;

        /* renamed from: p */
        private final int f113p;

        /* JADX INFO: Access modifiers changed from: package-private */
        public RelativeUrl(java.lang.reflect.Method method, int i) {
            this.method = method;
            this.f113p = i;
        }

        @Override // com.bytedance.retrofit2.ParameterHandler
        void apply(RequestBuilder requestBuilder, @Nullable Object obj) {
            requestBuilder.setRelativeUrl(obj);
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    static final class Header<T> extends ParameterHandler<T> {
        private final String name;
        private final Converter<T, String> valueConverter;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Header(String str, Converter<T, String> converter) {
            this.name = (String) Utils.checkNotNull(str, "name == null");
            this.valueConverter = converter;
        }

        @Override // com.bytedance.retrofit2.ParameterHandler
        void apply(RequestBuilder requestBuilder, @Nullable T t) throws IOException {
            String convert;
            if (t == null || (convert = this.valueConverter.convert(t)) == null) {
                return;
            }
            requestBuilder.addHeader(this.name, convert);
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    static final class HeaderList<T> extends ParameterHandler<List<T>> {
        private final Converter<T, com.bytedance.retrofit2.client.Header> valueConverter;

        /* JADX INFO: Access modifiers changed from: package-private */
        public HeaderList(Converter<T, com.bytedance.retrofit2.client.Header> converter) {
            this.valueConverter = converter;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.bytedance.retrofit2.ParameterHandler
        public void apply(RequestBuilder requestBuilder, List<T> list) throws IOException {
            if (list == null) {
                return;
            }
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                com.bytedance.retrofit2.client.Header convert = this.valueConverter.convert(it.next());
                requestBuilder.addHeader(convert.getName(), convert.getValue());
            }
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    static final class Path<T> extends ParameterHandler<T> {
        private final boolean encode;
        private final java.lang.reflect.Method method;
        private final String name;

        /* renamed from: p */
        private final int f111p;
        private final Converter<T, String> valueConverter;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Path(java.lang.reflect.Method method, int i, String str, Converter<T, String> converter, boolean z) {
            this.method = method;
            this.f111p = i;
            this.name = (String) Utils.checkNotNull(str, "name == null");
            this.valueConverter = converter;
            this.encode = z;
        }

        @Override // com.bytedance.retrofit2.ParameterHandler
        void apply(RequestBuilder requestBuilder, @Nullable T t) throws IOException {
            if (t == null) {
                throw Utils.parameterError(this.method, this.f111p, "Path parameter \"" + this.name + "\" value must not be null.", new Object[0]);
            }
            requestBuilder.addPathParam(this.name, this.valueConverter.convert(t), this.encode);
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    static final class Method<T> extends ParameterHandler<T> {
        private final String name;
        private final Converter<T, String> valueConverter;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Method(String str, Converter<T, String> converter) {
            this.name = (String) Utils.checkNotNull(str, "name == null");
            this.valueConverter = converter;
        }

        @Override // com.bytedance.retrofit2.ParameterHandler
        void apply(RequestBuilder requestBuilder, T t) throws IOException {
            if (t == null) {
                throw new IllegalArgumentException("Method parameter \"" + this.name + "\" value must not be null.");
            }
            requestBuilder.setMethod(this.name, this.valueConverter.convert(t));
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    static final class Query<T> extends ParameterHandler<T> {
        private final boolean encode;
        private final String name;
        private final Converter<T, String> valueConverter;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Query(String str, Converter<T, String> converter, boolean z) {
            this.name = (String) Utils.checkNotNull(str, "name == null");
            this.valueConverter = converter;
            this.encode = z;
        }

        @Override // com.bytedance.retrofit2.ParameterHandler
        void apply(RequestBuilder requestBuilder, T t) throws IOException {
            String convert;
            if (t == null || (convert = this.valueConverter.convert(t)) == null) {
                return;
            }
            requestBuilder.addQueryParam(this.name, convert, this.encode);
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    static final class QueryName<T> extends ParameterHandler<T> {
        private final boolean encoded;
        private final Converter<T, String> nameConverter;

        /* JADX INFO: Access modifiers changed from: package-private */
        public QueryName(Converter<T, String> converter, boolean z) {
            this.nameConverter = converter;
            this.encoded = z;
        }

        @Override // com.bytedance.retrofit2.ParameterHandler
        void apply(RequestBuilder requestBuilder, @Nullable T t) throws IOException {
            if (t == null) {
                return;
            }
            requestBuilder.addQueryParam(this.nameConverter.convert(t), null, this.encoded);
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    static final class QueryMap<T> extends ParameterHandler<Map<String, T>> {
        private final boolean encode;
        private final java.lang.reflect.Method method;

        /* renamed from: p */
        private final int f112p;
        private final Converter<T, String> valueConverter;

        /* JADX INFO: Access modifiers changed from: package-private */
        public QueryMap(java.lang.reflect.Method method, int i, Converter<T, String> converter, boolean z) {
            this.method = method;
            this.f112p = i;
            this.valueConverter = converter;
            this.encode = z;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.bytedance.retrofit2.ParameterHandler
        public void apply(RequestBuilder requestBuilder, @Nullable Map<String, T> map) throws IOException {
            if (map == null) {
                return;
            }
            for (Map.Entry<String, T> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key == null) {
                    throw Utils.parameterError(this.method, this.f112p, "Query map contained null key.", new Object[0]);
                }
                T value = entry.getValue();
                if (value != null) {
                    String convert = this.valueConverter.convert(value);
                    if (convert == null) {
                        throw Utils.parameterError(this.method, this.f112p, "Query map value '" + value + "' converted to null by " + this.valueConverter.getClass().getName() + " for key '" + key + "'.", new Object[0]);
                    }
                    requestBuilder.addQueryParam(key, convert, this.encode);
                }
            }
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    static final class HeaderMap<T> extends ParameterHandler<Map<String, T>> {
        private final java.lang.reflect.Method method;

        /* renamed from: p */
        private final int f108p;
        private final Converter<T, String> valueConverter;

        /* JADX INFO: Access modifiers changed from: package-private */
        public HeaderMap(java.lang.reflect.Method method, int i, Converter<T, String> converter) {
            this.method = method;
            this.f108p = i;
            this.valueConverter = converter;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.bytedance.retrofit2.ParameterHandler
        public void apply(RequestBuilder requestBuilder, @Nullable Map<String, T> map) throws IOException {
            if (map == null) {
                throw Utils.parameterError(this.method, this.f108p, "Header map was null.", new Object[0]);
            }
            for (Map.Entry<String, T> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key == null) {
                    throw Utils.parameterError(this.method, this.f108p, "Header map contained null key.", new Object[0]);
                }
                T value = entry.getValue();
                if (value == null) {
                    throw Utils.parameterError(this.method, this.f108p, "Header map contained null value for key '" + key + "'.", new Object[0]);
                }
                requestBuilder.addHeader(key, this.valueConverter.convert(value));
            }
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    static final class Field<T> extends ParameterHandler<T> {
        private final boolean encode;
        private final String name;
        private final Converter<T, String> valueConverter;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Field(String str, Converter<T, String> converter, boolean z) {
            this.name = (String) Utils.checkNotNull(str, "name == null");
            this.valueConverter = converter;
            this.encode = z;
        }

        @Override // com.bytedance.retrofit2.ParameterHandler
        void apply(RequestBuilder requestBuilder, @Nullable T t) throws IOException {
            String convert;
            if (t == null || (convert = this.valueConverter.convert(t)) == null) {
                return;
            }
            requestBuilder.addFormField(this.name, convert, this.encode);
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    static final class FieldMap<T> extends ParameterHandler<Map<String, T>> {
        private final boolean encode;
        private final java.lang.reflect.Method method;

        /* renamed from: p */
        private final int f107p;
        private final Converter<T, String> valueConverter;

        /* JADX INFO: Access modifiers changed from: package-private */
        public FieldMap(java.lang.reflect.Method method, int i, Converter<T, String> converter, boolean z) {
            this.method = method;
            this.f107p = i;
            this.valueConverter = converter;
            this.encode = z;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.bytedance.retrofit2.ParameterHandler
        public void apply(RequestBuilder requestBuilder, @Nullable Map<String, T> map) throws IOException {
            if (map == null) {
                throw Utils.parameterError(this.method, this.f107p, "Field map was null.", new Object[0]);
            }
            for (Map.Entry<String, T> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key == null) {
                    throw Utils.parameterError(this.method, this.f107p, "Field map contained null key.", new Object[0]);
                }
                T value = entry.getValue();
                if (value == null) {
                    throw Utils.parameterError(this.method, this.f107p, "Field map contained null value for key '" + key + "'.", new Object[0]);
                }
                String convert = this.valueConverter.convert(value);
                if (convert == null) {
                    throw Utils.parameterError(this.method, this.f107p, "Field map value '" + value + "' converted to null by " + this.valueConverter.getClass().getName() + " for key '" + key + "'.", new Object[0]);
                }
                requestBuilder.addFormField(key, convert, this.encode);
            }
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    static final class Part<T> extends ParameterHandler<T> {
        private final Converter<T, TypedOutput> converter;
        private final java.lang.reflect.Method method;
        private final String name;

        /* renamed from: p */
        private final int f109p;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Part(java.lang.reflect.Method method, int i, String str, Converter<T, TypedOutput> converter) {
            this.method = method;
            this.f109p = i;
            this.name = str;
            this.converter = converter;
        }

        @Override // com.bytedance.retrofit2.ParameterHandler
        void apply(RequestBuilder requestBuilder, T t) {
            if (t == null) {
                return;
            }
            try {
                requestBuilder.addPart(this.name, this.converter.convert(t));
            } catch (IOException e) {
                throw Utils.parameterError(this.method, this.f109p, "Unable to convert " + t + " to RequestBody", e);
            }
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    static final class PartMap<T> extends ParameterHandler<Map<String, T>> {
        private final java.lang.reflect.Method method;

        /* renamed from: p */
        private final int f110p;
        private final String transferEncoding;
        private final Converter<T, TypedOutput> valueConverter;

        /* JADX INFO: Access modifiers changed from: package-private */
        public PartMap(java.lang.reflect.Method method, int i, Converter<T, TypedOutput> converter, String str) {
            this.method = method;
            this.f110p = i;
            this.valueConverter = converter;
            this.transferEncoding = str;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.bytedance.retrofit2.ParameterHandler
        public void apply(RequestBuilder requestBuilder, @Nullable Map<String, T> map) throws IOException {
            if (map == null) {
                throw Utils.parameterError(this.method, this.f110p, "Part map was null.", new Object[0]);
            }
            for (Map.Entry<String, T> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key == null) {
                    throw Utils.parameterError(this.method, this.f110p, "Part map contained null key.", new Object[0]);
                }
                T value = entry.getValue();
                if (value == null) {
                    throw Utils.parameterError(this.method, this.f110p, "Part map contained null value for key '" + key + "'.", new Object[0]);
                }
                requestBuilder.addPart(key, this.transferEncoding, this.valueConverter.convert(value));
            }
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    static final class Body<T> extends ParameterHandler<T> {
        private final Converter<T, TypedOutput> converter;
        private final boolean isCustomMethod;
        private final java.lang.reflect.Method method;

        /* renamed from: p */
        private final int f106p;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Body(java.lang.reflect.Method method, int i, boolean z, Converter<T, TypedOutput> converter) {
            this.method = method;
            this.f106p = i;
            this.isCustomMethod = z;
            this.converter = converter;
        }

        @Override // com.bytedance.retrofit2.ParameterHandler
        void apply(RequestBuilder requestBuilder, @Nullable T t) {
            TypedOutput convert;
            if (t == null) {
                if (!this.isCustomMethod) {
                    throw Utils.parameterError(this.method, this.f106p, "Body parameter value must not be null.", new Object[0]);
                }
                return;
            }
            try {
                if (this.converter.needRequestBuilder()) {
                    convert = this.converter.convertWithRequestBuilder(t, requestBuilder);
                } else {
                    convert = this.converter.convert(t);
                }
                requestBuilder.setBody(convert);
            } catch (IOException e) {
                throw Utils.parameterError(this.method, e, this.f106p, "Unable to convert " + t + " to RequestBody", new Object[0]);
            }
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    static final class MaxLength<T> extends ParameterHandler<T> {
        private final Converter<T, String> converter;

        /* JADX INFO: Access modifiers changed from: package-private */
        public MaxLength(Converter<T, String> converter) {
            this.converter = (Converter) Utils.checkNotNull(converter, "converter == null");
        }

        @Override // com.bytedance.retrofit2.ParameterHandler
        void apply(RequestBuilder requestBuilder, T t) throws IOException {
            if (t == null) {
                return;
            }
            try {
                requestBuilder.setMaxLength(Integer.parseInt(this.converter.convert(t)));
            } catch (IOException e) {
                throw new RuntimeException("Unable to convert " + t + " to MaxLength", e);
            }
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    static final class AddCommonParam<T> extends ParameterHandler<T> {
        private final Converter<T, String> converter;

        /* JADX INFO: Access modifiers changed from: package-private */
        public AddCommonParam(Converter<T, String> converter) {
            this.converter = (Converter) Utils.checkNotNull(converter, "converter == null");
        }

        @Override // com.bytedance.retrofit2.ParameterHandler
        void apply(RequestBuilder requestBuilder, T t) throws IOException {
            if (t == null) {
                return;
            }
            try {
                requestBuilder.setAddCommonParam(Boolean.parseBoolean(this.converter.convert(t)));
            } catch (IOException e) {
                throw new RuntimeException("Unable to convert " + t + " to AddCommonParam", e);
            }
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    static final class ExtraInfo<T> extends ParameterHandler<T> {
        private final Converter<T, Object> converter;

        /* JADX INFO: Access modifiers changed from: package-private */
        public ExtraInfo(Converter<T, Object> converter) {
            this.converter = (Converter) Utils.checkNotNull(converter, "converter == null");
        }

        @Override // com.bytedance.retrofit2.ParameterHandler
        void apply(RequestBuilder requestBuilder, T t) throws IOException {
            if (t == null) {
                return;
            }
            try {
                requestBuilder.setExtraInfo(this.converter.convert(t));
            } catch (IOException e) {
                throw new RuntimeException("Unable to convert " + t + " to ExtraInfo", e);
            }
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    static final class QueryObject<T> extends ParameterHandler<T> {
        @Override // com.bytedance.retrofit2.ParameterHandler
        void apply(RequestBuilder requestBuilder, T t) throws IOException {
            if (t == null) {
                return;
            }
            if (!(t instanceof QueryParamObject)) {
                throw new RuntimeException("wrong type:" + t.getClass() + ",not implement QueryParamObject");
            }
            requestBuilder.setQueryObjectParams(((QueryParamObject) t).toQuery());
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    static final class ConverterRawPart extends ParameterHandler<MultipartBody.Part> {
        static final ConverterRawPart INSTANCE = new ConverterRawPart();

        ConverterRawPart() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.bytedance.retrofit2.ParameterHandler
        public void apply(RequestBuilder requestBuilder, MultipartBody.Part part) throws IOException {
            if (part != null) {
                requestBuilder.addPart(part);
            }
            requestBuilder.useRequestBody();
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    static final class ConverterPart extends ParameterHandler<RequestBody> {
        private final Headers headers;

        /* JADX INFO: Access modifiers changed from: package-private */
        public ConverterPart(Headers headers) {
            this.headers = headers;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.bytedance.retrofit2.ParameterHandler
        public void apply(RequestBuilder requestBuilder, RequestBody requestBody) {
            if (requestBody == null) {
                return;
            }
            requestBuilder.addPart(this.headers, requestBody);
            requestBuilder.useRequestBody();
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    static final class ConverterPartMap extends ParameterHandler<Map<String, RequestBody>> {
        private final String transferEncoding;

        /* JADX INFO: Access modifiers changed from: package-private */
        public ConverterPartMap(String str) {
            this.transferEncoding = str;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.bytedance.retrofit2.ParameterHandler
        public void apply(RequestBuilder requestBuilder, Map<String, RequestBody> map) throws IOException {
            if (map == null) {
                throw new IllegalArgumentException("Part map was null.");
            }
            for (Map.Entry<String, RequestBody> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key == null) {
                    throw new IllegalArgumentException("Part map contained null key.");
                }
                RequestBody value = entry.getValue();
                if (value == null) {
                    throw new IllegalArgumentException("Part map contained null value for key '" + key + "'.");
                }
                requestBuilder.addPart(Headers.of(new String[]{"Content-Disposition", "form-data; name=\"" + key + "\"", "Content-Transfer-Encoding", this.transferEncoding}), value);
            }
            requestBuilder.useRequestBody();
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    static final class ConverterBody extends ParameterHandler<RequestBody> {
        static final ConverterBody INSTANCE = new ConverterBody();

        ConverterBody() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.bytedance.retrofit2.ParameterHandler
        public void apply(RequestBuilder requestBuilder, RequestBody requestBody) {
            if (requestBody == null) {
                throw new IllegalArgumentException("Body parameter value must not be null.");
            }
            requestBuilder.setBody(requestBody);
            requestBuilder.useRequestBody();
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    static final class Tag<T> extends ParameterHandler<T> {
        final Class<T> cls;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Tag(Class<T> cls) {
            this.cls = cls;
        }

        @Override // com.bytedance.retrofit2.ParameterHandler
        void apply(RequestBuilder requestBuilder, @Nullable T t) {
            requestBuilder.addTag(this.cls, t);
        }
    }
}
