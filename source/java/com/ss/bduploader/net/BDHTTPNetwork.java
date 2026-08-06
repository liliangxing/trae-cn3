package com.ss.bduploader.net;

import com.ss.bduploader.net.BDVNetClient;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class BDHTTPNetwork extends BDVNetClient {
    private static final int HTTP_TIME_OUT = 10;
    public static final MediaType JSON = MediaType.parse("application/json");
    private static OkHttpClient mClient;
    private Call mCall;

    @Override // com.ss.bduploader.net.BDVNetClient
    public void startTask(String str, Map<String, String> map, final BDVNetClient.CompletionListener completionListener) {
        synchronized (BDHTTPNetwork.class) {
            if (mClient == null) {
                mClient = new OkHttpClient().newBuilder().connectTimeout(10L, TimeUnit.SECONDS).writeTimeout(10L, TimeUnit.SECONDS).readTimeout(10L, TimeUnit.SECONDS).build();
            }
        }
        Request.Builder url = new Request.Builder().url(str);
        if (map != null) {
            for (String str2 : map.keySet()) {
                url.header(str2, map.get(str2));
            }
        }
        Call newCall = mClient.newCall(url.build());
        this.mCall = newCall;
        newCall.enqueue(new Callback() { // from class: com.ss.bduploader.net.BDHTTPNetwork.1
            public void onFailure(Call call, IOException iOException) {
                completionListener.onCompletion(null, new Error(0, null, null, iOException.toString()));
            }

            public void onResponse(Call call, Response response) {
                ResponseBody responseBody;
                Throwable th;
                JSONObject jSONObject;
                try {
                    responseBody = response.body();
                    try {
                        try {
                            jSONObject = new JSONObject(responseBody.string());
                            e = null;
                        } catch (Throwable th2) {
                            th = th2;
                            if (responseBody != null) {
                                try {
                                    responseBody.close();
                                } catch (Exception unused) {
                                }
                            }
                            throw th;
                        }
                    } catch (Exception e) {
                        e = e;
                        e.printStackTrace();
                        jSONObject = null;
                    }
                    if (e == null && !response.isSuccessful()) {
                        e = new Exception("http fail");
                        response.code();
                    }
                    if (responseBody != null) {
                        try {
                            responseBody.close();
                        } catch (Exception unused2) {
                        }
                    }
                    if (e == null) {
                        completionListener.onCompletion(jSONObject, null);
                    } else {
                        completionListener.onCompletion(jSONObject, new Error(0, null, null, e.toString()));
                    }
                } catch (Throwable th3) {
                    responseBody = null;
                    th = th3;
                }
            }
        });
    }

    @Override // com.ss.bduploader.net.BDVNetClient
    public void startTask(String str, Map<String, String> map, JSONObject jSONObject, int i, final BDVNetClient.CompletionListener completionListener) {
        synchronized (BDHTTPNetwork.class) {
            if (mClient == null) {
                mClient = new OkHttpClient().newBuilder().connectTimeout(10L, TimeUnit.SECONDS).writeTimeout(10L, TimeUnit.SECONDS).readTimeout(10L, TimeUnit.SECONDS).build();
            }
        }
        Request.Builder url = new Request.Builder().url(str);
        if (map != null && map.size() > 0) {
            for (String str2 : map.keySet()) {
                url.addHeader(str2, map.get(str2));
            }
        }
        if (i == 1) {
            url.post(RequestBody.create(JSON, String.valueOf(jSONObject)));
        }
        Call newCall = mClient.newCall(url.build());
        this.mCall = newCall;
        newCall.enqueue(new Callback() { // from class: com.ss.bduploader.net.BDHTTPNetwork.2
            public void onFailure(Call call, IOException iOException) {
                completionListener.onCompletion(null, new Error(0, null, null, iOException.toString()));
            }

            public void onResponse(Call call, Response response) throws IOException {
                ResponseBody responseBody;
                Throwable th;
                String exc;
                JSONObject jSONObject2;
                try {
                    responseBody = response.body();
                    try {
                        try {
                            jSONObject2 = new JSONObject(responseBody.string());
                            exc = null;
                        } catch (Throwable th2) {
                            th = th2;
                            if (responseBody != null) {
                                try {
                                    responseBody.close();
                                } catch (Exception unused) {
                                }
                            }
                            throw th;
                        }
                    } catch (Exception e) {
                        exc = e.toString();
                        e.printStackTrace();
                        jSONObject2 = null;
                    }
                    if (!response.isSuccessful()) {
                        exc = response.message();
                        response.code();
                    }
                    if (responseBody != null) {
                        try {
                            responseBody.close();
                        } catch (Exception unused2) {
                        }
                    }
                    if (exc == null) {
                        completionListener.onCompletion(jSONObject2, null);
                    } else {
                        completionListener.onCompletion(jSONObject2, new Error(0, null, null, exc.toString()));
                    }
                } catch (Throwable th3) {
                    responseBody = null;
                    th = th3;
                }
            }
        });
    }

    @Override // com.ss.bduploader.net.BDVNetClient
    public void cancel() {
        Call call = this.mCall;
        if (call == null || call.isCanceled()) {
            return;
        }
        this.mCall.cancel();
    }
}
