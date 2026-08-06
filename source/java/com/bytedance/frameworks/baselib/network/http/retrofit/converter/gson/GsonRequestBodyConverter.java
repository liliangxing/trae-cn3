package com.bytedance.frameworks.baselib.network.http.retrofit.converter.gson;

import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import com.bytedance.retrofit2.Converter;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.retrofit2.mime.TypedOutput;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
final class GsonRequestBodyConverter<T> implements Converter<T, TypedOutput> {
    private static final String MEDIA_TYPE = "application/json; charset=UTF-8";
    private static final Charset UTF_8 = Charset.forName(UrlUtils.UTF_8);
    private final TypeAdapter<T> adapter;
    private final Gson gson;

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: convert, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m3478convert(Object obj) throws IOException {
        return convert((GsonRequestBodyConverter<T>) obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GsonRequestBodyConverter(Gson gson, TypeAdapter<T> typeAdapter) {
        this.gson = gson;
        this.adapter = typeAdapter;
    }

    public TypedOutput convert(T t) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
        JsonWriter newJsonWriter = this.gson.newJsonWriter(new OutputStreamWriter(byteArrayOutputStream, UTF_8));
        this.adapter.write(newJsonWriter, t);
        newJsonWriter.close();
        return new TypedByteArray(MEDIA_TYPE, byteArrayOutputStream.toByteArray(), new String[0]);
    }
}
