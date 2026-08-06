package com.bytedance.geckox.net;

import android.util.Pair;
import com.bytedance.geckox.buffer.stream.BufferOutputStream;
import com.bytedance.geckox.utils.CloseableUtils;
import java.io.BufferedInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class DefaultNetWork implements INetWork {
    protected OkHttpClient mApiClient = new OkHttpClient.Builder().connectTimeout(10, TimeUnit.SECONDS).readTimeout(10, TimeUnit.SECONDS).writeTimeout(10, TimeUnit.SECONDS).build();
    protected OkHttpClient mDownloadClient = new OkHttpClient.Builder().connectTimeout(10, TimeUnit.SECONDS).readTimeout(30, TimeUnit.SECONDS).writeTimeout(30, TimeUnit.SECONDS).build();

    @Override // com.bytedance.geckox.net.INetWork
    public Response doGet(String str) throws Exception {
        okhttp3.Response execute = this.mApiClient.newCall(new Request.Builder().get().url(str).build()).execute();
        return new Response(headers(execute.headers()), execute.code() == 200 ? execute.body().string() : null, execute.code(), execute.message());
    }

    @Override // com.bytedance.geckox.net.INetWork
    public Response doPost(String str, List<Pair<String, String>> list) throws Exception {
        FormBody.Builder builder = new FormBody.Builder();
        if (list != null) {
            for (Pair<String, String> pair : list) {
                builder.add((String) pair.first, (String) pair.second);
            }
        }
        okhttp3.Response execute = this.mApiClient.newCall(new Request.Builder().url(str).post(builder.build()).build()).execute();
        return new Response(headers(execute.headers()), execute.code() == 200 ? execute.body().string() : null, execute.code(), execute.message());
    }

    @Override // com.bytedance.geckox.net.INetWork
    public Response doPost(String str, String str2) throws Exception {
        okhttp3.Response execute = this.mApiClient.newCall(new Request.Builder().url(str).post(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), str2)).build()).execute();
        return new Response(headers(execute.headers()), execute.code() == 200 ? execute.body().string() : null, execute.code(), execute.message());
    }

    @Override // com.bytedance.geckox.net.INetWork
    public void downloadFile(String str, long j, BufferOutputStream bufferOutputStream) throws Exception {
        BufferedInputStream bufferedInputStream = null;
        int i = 0;
        try {
            try {
                okhttp3.Response execute = this.mDownloadClient.newCall(new Request.Builder().get().url(str).build()).execute();
                int code = execute.code();
                try {
                    if (code != 200) {
                        throw new RuntimeException("response code error: " + code);
                    }
                    BufferedInputStream bufferedInputStream2 = new BufferedInputStream(execute.body().byteStream());
                    try {
                        byte[] bArr = new byte[2048];
                        while (true) {
                            int read = bufferedInputStream2.read(bArr, 0, 2048);
                            if (read != -1) {
                                bufferOutputStream.write(bArr, 0, read);
                            } else {
                                CloseableUtils.close(bufferedInputStream2);
                                return;
                            }
                        }
                    } catch (Exception e) {
                        e = e;
                        i = code;
                        throw new RuntimeException("downloadFile failed, code: " + i + ", caused by:" + e.getMessage(), e);
                    } catch (Throwable th) {
                        th = th;
                        bufferedInputStream = bufferedInputStream2;
                        CloseableUtils.close(bufferedInputStream);
                        throw th;
                    }
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    private Map<String, String> headers(Headers headers) {
        if (headers == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (String str : headers.names()) {
            hashMap.put(str, headers.get(str));
        }
        return hashMap;
    }
}
