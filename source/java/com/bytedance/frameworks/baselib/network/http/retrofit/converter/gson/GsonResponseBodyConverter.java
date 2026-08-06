package com.bytedance.frameworks.baselib.network.http.retrofit.converter.gson;

import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import com.bytedance.retrofit2.Converter;
import com.bytedance.retrofit2.mime.MimeUtil;
import com.bytedance.retrofit2.mime.TypedInput;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import java.io.IOException;
import java.io.InputStreamReader;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
final class GsonResponseBodyConverter<T> implements Converter<TypedInput, T> {
    private final TypeAdapter<T> adapter;
    private final Gson gson;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GsonResponseBodyConverter(Gson gson, TypeAdapter<T> typeAdapter) {
        this.gson = gson;
        this.adapter = typeAdapter;
    }

    public T convert(TypedInput typedInput) throws IOException {
        String mimeType = typedInput.mimeType();
        String str = UrlUtils.UTF_8;
        if (mimeType != null) {
            str = MimeUtil.parseCharset(typedInput.mimeType(), UrlUtils.UTF_8);
        }
        InputStreamReader inputStreamReader = new InputStreamReader(typedInput.in(), str);
        try {
            return (T) this.adapter.read(this.gson.newJsonReader(inputStreamReader));
        } finally {
            try {
                inputStreamReader.close();
            } catch (IOException unused) {
            }
        }
    }
}
