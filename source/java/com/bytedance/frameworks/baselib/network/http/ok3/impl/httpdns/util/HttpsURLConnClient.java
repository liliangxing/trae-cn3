package com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.util;

import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.SsOkHttp3Client;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.HttpDns;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.client.Response;
import com.bytedance.retrofit2.client.SsCall;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class HttpsURLConnClient {
    private static final String TAG = "HttpsURLConnClient";

    /* JADX WARN: Removed duplicated region for block: B:39:0x00fa A[Catch: JSONException -> 0x011f, TRY_ENTER, TryCatch #5 {JSONException -> 0x011f, blocks: (B:36:0x00e5, B:39:0x00fa, B:40:0x0103, B:42:0x0115, B:46:0x0100), top: B:35:0x00e5 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0115 A[Catch: JSONException -> 0x011f, TRY_LEAVE, TryCatch #5 {JSONException -> 0x011f, blocks: (B:36:0x00e5, B:39:0x00fa, B:40:0x0103, B:42:0x0115, B:46:0x0100), top: B:35:0x00e5 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0100 A[Catch: JSONException -> 0x011f, TryCatch #5 {JSONException -> 0x011f, blocks: (B:36:0x00e5, B:39:0x00fa, B:40:0x0103, B:42:0x0115, B:46:0x0100), top: B:35:0x00e5 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00d8 A[Catch: IOException -> 0x00d4, TRY_LEAVE, TryCatch #1 {IOException -> 0x00d4, blocks: (B:67:0x00d0, B:60:0x00d8), top: B:66:0x00d0 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00d0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0134 A[Catch: IOException -> 0x0130, TRY_LEAVE, TryCatch #3 {IOException -> 0x0130, blocks: (B:81:0x012c, B:74:0x0134), top: B:80:0x012c }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x012c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String executeGet(String str, String str2) {
        InputStream inputStream;
        SsCall ssCall;
        SsCall ssCall2;
        SsCall ssCall3;
        if (Logger.debug()) {
            Logger.d(TAG, "start execute httpdns get " + str);
        }
        long currentTimeMillis = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        SsCall ssCall4 = null;
        int i = 0;
        try {
            Request build = new Request.Builder().url(str).build();
            build.setMetrics(new RetrofitMetrics());
            SsCall newSsCall = SsOkHttp3Client.inst(HttpDns.getService().getHttpDnsDepend().getContext()).newSsCall(build);
            try {
                Response execute = newSsCall.execute();
                if (execute != null) {
                    if (!execute.isSuccessful() || execute.getBody() == null) {
                        inputStream = null;
                        ssCall = null;
                    } else {
                        inputStream = execute.getBody().in();
                        try {
                            ssCall = new BufferedReader(new InputStreamReader(inputStream, UrlUtils.UTF_8));
                            while (true) {
                                try {
                                    String readLine = ssCall.readLine();
                                    if (readLine == null) {
                                        break;
                                    }
                                    sb.append(readLine);
                                } catch (Exception e) {
                                    e = e;
                                    ssCall2 = ssCall4;
                                    ssCall4 = newSsCall;
                                    try {
                                        e.printStackTrace();
                                        if (ssCall4 != null) {
                                            ssCall4.cancel();
                                        }
                                        if (ssCall != null) {
                                            try {
                                                ssCall.close();
                                            } catch (IOException e2) {
                                                e2.printStackTrace();
                                                ssCall3 = ssCall2;
                                                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                                                JSONObject jSONObject = new JSONObject();
                                                jSONObject.put("request_url", str);
                                                jSONObject.put("httpdns_domain", str2);
                                                if (ssCall3 != null) {
                                                }
                                                jSONObject.put("response_code", i);
                                                jSONObject.put("rtt", currentTimeMillis2);
                                                if (Logger.debug()) {
                                                }
                                                return ssCall3;
                                            }
                                        }
                                        if (inputStream != null) {
                                            inputStream.close();
                                        }
                                        ssCall3 = ssCall2;
                                        long currentTimeMillis22 = System.currentTimeMillis() - currentTimeMillis;
                                        JSONObject jSONObject2 = new JSONObject();
                                        jSONObject2.put("request_url", str);
                                        jSONObject2.put("httpdns_domain", str2);
                                        if (ssCall3 != null) {
                                        }
                                        jSONObject2.put("response_code", i);
                                        jSONObject2.put("rtt", currentTimeMillis22);
                                        if (Logger.debug()) {
                                        }
                                        return ssCall3;
                                    } catch (Throwable th) {
                                        th = th;
                                        if (ssCall4 != null) {
                                            ssCall4.cancel();
                                        }
                                        if (ssCall != null) {
                                            try {
                                                ssCall.close();
                                            } catch (IOException e3) {
                                                e3.printStackTrace();
                                                throw th;
                                            }
                                        }
                                        if (inputStream != null) {
                                            inputStream.close();
                                        }
                                        throw th;
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    ssCall4 = newSsCall;
                                    if (ssCall4 != null) {
                                    }
                                    if (ssCall != null) {
                                    }
                                    if (inputStream != null) {
                                    }
                                    throw th;
                                }
                            }
                        } catch (Exception e4) {
                            e = e4;
                            ssCall = null;
                            ssCall4 = newSsCall;
                            ssCall2 = ssCall;
                            e.printStackTrace();
                            if (ssCall4 != null) {
                            }
                            if (ssCall != null) {
                            }
                            if (inputStream != null) {
                            }
                            ssCall3 = ssCall2;
                            long currentTimeMillis222 = System.currentTimeMillis() - currentTimeMillis;
                            JSONObject jSONObject22 = new JSONObject();
                            jSONObject22.put("request_url", str);
                            jSONObject22.put("httpdns_domain", str2);
                            if (ssCall3 != null) {
                            }
                            jSONObject22.put("response_code", i);
                            jSONObject22.put("rtt", currentTimeMillis222);
                            if (Logger.debug()) {
                            }
                            return ssCall3;
                        } catch (Throwable th3) {
                            th = th3;
                            ssCall = null;
                            ssCall4 = newSsCall;
                            if (ssCall4 != null) {
                            }
                            if (ssCall != null) {
                            }
                            if (inputStream != null) {
                            }
                            throw th;
                        }
                    }
                    ssCall4 = sb.toString();
                    i = execute.getStatus();
                    ssCall3 = ssCall4;
                    ssCall4 = ssCall;
                } else {
                    ssCall3 = null;
                    inputStream = null;
                }
                if (newSsCall != null) {
                    newSsCall.cancel();
                }
                if (ssCall4 != null) {
                    try {
                        ssCall4.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (Exception e6) {
                e = e6;
                inputStream = null;
                ssCall = null;
            } catch (Throwable th4) {
                th = th4;
                inputStream = null;
                ssCall = null;
            }
        } catch (Exception e7) {
            e = e7;
            ssCall2 = null;
            inputStream = null;
            ssCall = null;
        } catch (Throwable th5) {
            th = th5;
            inputStream = null;
            ssCall = null;
        }
        long currentTimeMillis2222 = System.currentTimeMillis() - currentTimeMillis;
        try {
            JSONObject jSONObject222 = new JSONObject();
            jSONObject222.put("request_url", str);
            jSONObject222.put("httpdns_domain", str2);
            if (ssCall3 != null) {
                jSONObject222.put(StrategyConstants.RESULT, "");
            } else {
                jSONObject222.put(StrategyConstants.RESULT, ssCall3);
            }
            jSONObject222.put("response_code", i);
            jSONObject222.put("rtt", currentTimeMillis2222);
            if (Logger.debug()) {
                Logger.d(TAG, jSONObject222.toString());
            }
        } catch (JSONException e8) {
            e8.printStackTrace();
        }
        return ssCall3;
    }
}
