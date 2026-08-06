package com.bytedance.retrofit2;

import com.bytedance.retrofit2.Converter;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.http.Streaming;
import com.bytedance.retrofit2.mime.MimeUtil;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.mime.TypedOutput;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import javax.annotation.Nullable;
import kotlin.Unit;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class BuiltInConverters extends Converter.Factory {
    private boolean checkForKotlinUnit = true;

    @Override // com.bytedance.retrofit2.Converter.Factory
    @Nullable
    public Converter<TypedInput, ?> responseBodyConverter(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        if (type == TypedInput.class) {
            if (Utils.isAnnotationPresent(annotationArr, Streaming.class)) {
                return StreamingResponseBodyConverter.INSTANCE;
            }
            return BufferingResponseBodyConverter.INSTANCE;
        }
        if (type == String.class) {
            return StringResponseBodyConverter.INSTANCE;
        }
        if (type == Void.class) {
            return VoidResponseBodyConverter.INSTANCE;
        }
        if (!this.checkForKotlinUnit || type != Unit.class) {
            return null;
        }
        try {
            return UnitResponseBodyConverter.INSTANCE;
        } catch (NoClassDefFoundError unused) {
            this.checkForKotlinUnit = false;
            return null;
        }
    }

    @Override // com.bytedance.retrofit2.Converter.Factory
    @Nullable
    public Converter<?, TypedOutput> requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, Retrofit retrofit) {
        if (TypedOutput.class.isAssignableFrom(Utils.getRawType(type))) {
            return RequestBodyConverter.INSTANCE;
        }
        return null;
    }

    @Override // com.bytedance.retrofit2.Converter.Factory
    public Converter<?, Object> objectConverter(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        if (type == Object.class) {
            return ObjectConverter.INSTANCE;
        }
        return null;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    static final class ObjectConverter implements Converter<Object, Object> {
        static final ObjectConverter INSTANCE = new ObjectConverter();

        @Override // com.bytedance.retrofit2.Converter
        public Object convert(Object obj) throws IOException {
            return obj;
        }

        ObjectConverter() {
        }
    }

    @Override // com.bytedance.retrofit2.Converter.Factory
    public Converter<?, String> stringConverter(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        if (type == String.class) {
            return StringConverter.INSTANCE;
        }
        return null;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    static final class StringConverter implements Converter<String, String> {
        static final StringConverter INSTANCE = new StringConverter();

        @Override // com.bytedance.retrofit2.Converter
        public String convert(String str) throws IOException {
            return str;
        }

        StringConverter() {
        }
    }

    @Override // com.bytedance.retrofit2.Converter.Factory
    public Converter<?, Header> headerConverter(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        if (type == Header.class) {
            return HeaderConverter.INSTANCE;
        }
        return null;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    static final class HeaderConverter implements Converter<Header, Header> {
        static final HeaderConverter INSTANCE = new HeaderConverter();

        @Override // com.bytedance.retrofit2.Converter
        public Header convert(Header header) throws IOException {
            return header;
        }

        HeaderConverter() {
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    static final class VoidResponseBodyConverter implements Converter<TypedInput, Void> {
        static final VoidResponseBodyConverter INSTANCE = new VoidResponseBodyConverter();

        VoidResponseBodyConverter() {
        }

        @Override // com.bytedance.retrofit2.Converter
        public Void convert(TypedInput typedInput) throws IOException {
            InputStream mo349in = typedInput.mo349in();
            if (mo349in == null) {
                return null;
            }
            mo349in.close();
            return null;
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    static final class StringResponseBodyConverter implements Converter<TypedInput, String> {
        static final StringResponseBodyConverter INSTANCE = new StringResponseBodyConverter();

        StringResponseBodyConverter() {
        }

        @Override // com.bytedance.retrofit2.Converter
        public String convert(TypedInput typedInput) throws IOException {
            if (typedInput instanceof TypedByteArray) {
                return new String(((TypedByteArray) typedInput).getBytes(), typedInput.mimeType() != null ? MimeUtil.parseCharset(typedInput.mimeType(), "UTF-8") : "UTF-8");
            }
            return null;
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    static final class RequestBodyConverter implements Converter<TypedOutput, TypedOutput> {
        static final RequestBodyConverter INSTANCE = new RequestBodyConverter();

        @Override // com.bytedance.retrofit2.Converter
        public TypedOutput convert(TypedOutput typedOutput) {
            return typedOutput;
        }

        RequestBodyConverter() {
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    static final class StreamingResponseBodyConverter implements Converter<TypedInput, TypedInput> {
        static final StreamingResponseBodyConverter INSTANCE = new StreamingResponseBodyConverter();

        @Override // com.bytedance.retrofit2.Converter
        public TypedInput convert(TypedInput typedInput) {
            return typedInput;
        }

        StreamingResponseBodyConverter() {
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    static final class BufferingResponseBodyConverter implements Converter<TypedInput, TypedInput> {
        static final BufferingResponseBodyConverter INSTANCE = new BufferingResponseBodyConverter();

        BufferingResponseBodyConverter() {
        }

        @Override // com.bytedance.retrofit2.Converter
        public TypedInput convert(@Nullable TypedInput typedInput) throws IOException {
            if (typedInput == null || (typedInput instanceof TypedByteArray)) {
                return typedInput;
            }
            String mimeType = typedInput.mimeType();
            InputStream mo349in = typedInput.mo349in();
            try {
                TypedByteArray typedByteArray = new TypedByteArray(mimeType, Utils.streamToBytes(mo349in), new String[0]);
                if (mo349in != null) {
                    try {
                        mo349in.close();
                    } catch (IOException unused) {
                    }
                }
                return typedByteArray;
            } catch (Throwable th) {
                if (mo349in != null) {
                    try {
                        mo349in.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class ToStringConverter implements Converter<Object, String> {
        static final ToStringConverter INSTANCE = new ToStringConverter();

        ToStringConverter() {
        }

        @Override // com.bytedance.retrofit2.Converter
        public String convert(Object obj) {
            return obj.toString();
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    static final class UnitResponseBodyConverter implements Converter<TypedInput, Unit> {
        static final UnitResponseBodyConverter INSTANCE = new UnitResponseBodyConverter();

        UnitResponseBodyConverter() {
        }

        @Override // com.bytedance.retrofit2.Converter
        public Unit convert(TypedInput typedInput) {
            try {
                typedInput.mo349in().close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return Unit.INSTANCE;
        }
    }
}
