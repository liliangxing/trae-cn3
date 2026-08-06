package com.bytedance.bdturing.ttnet;

import android.app.Activity;
import android.text.TextUtils;
import com.bytedance.bdturing.BdTuring;
import com.bytedance.bdturing.BdTuringCallback;
import com.bytedance.bdturing.LogUtil;
import com.bytedance.bdturing.loginverify.LoginVerifyService;
import com.bytedance.bdturing.verify.request.AbstractRequest;
import com.bytedance.bdturing.verify.request.RiskInfoRequest;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.frameworks.baselib.network.http.RequestRetryResult;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.bytedance.retrofit2.mime.DigestUtil;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.mime.TypedOutput;
import com.bytedance.ttnet.utils.RetrofitUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class TTNetUtil {
    private static final String TAG = "TTNetUtil";

    public static byte[] executeGet(String str, String str2, Map<String, String> map, Map<String, String> map2) {
        try {
            SsResponse execute = createRetrofitApi(str).doGet(true, str, map, toHeaderList(map2)).execute();
            if (execute.code() == 200) {
                return inputStreamToByteArray(((TypedInput) execute.body()).in());
            }
        } catch (Exception unused) {
        }
        return new byte[0];
    }

    public static byte[] executePost(String str, String str2, Map<String, String> map, final byte[] bArr, Map<String, String> map2) {
        try {
            SsResponse execute = createRetrofitApi(str).doPost(str, map, new TypedOutput() { // from class: com.bytedance.bdturing.ttnet.TTNetUtil.1
                public String fileName() {
                    return null;
                }

                public String mimeType() {
                    return null;
                }

                public long length() {
                    return bArr.length;
                }

                public void writeTo(OutputStream outputStream) throws IOException {
                    outputStream.write(bArr);
                }

                public String md5Stub() {
                    byte[] bArr2 = bArr;
                    if (bArr2 == null) {
                        return null;
                    }
                    return DigestUtil.md5Hex(bArr2);
                }
            }, toHeaderList(map2)).execute();
            if (execute.code() == 200) {
                return inputStreamToByteArray(((TypedInput) execute.body()).in());
            }
        } catch (Exception unused) {
        }
        return new byte[0];
    }

    private static byte[] inputStreamToByteArray(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    public static List<Header> toHeaderList(Map<String, String> map) {
        LinkedList linkedList = new LinkedList();
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                linkedList.add(new Header(entry.getKey(), entry.getValue()));
            }
        }
        return linkedList;
    }

    public static void addVersionHeaders() {
        RetrofitUtils.addInterceptor(BdTuringInterceptor.getInstance());
    }

    public static INetworkApi createRetrofitApi(String str) {
        return (INetworkApi) RetrofitUtils.getSsRetrofit(str).create(INetworkApi.class);
    }

    public static void setProcessorForTTNet() {
        NetworkParams.setRetryRequestCallback(new NetworkParams.RetryRequestByTuringHeaderCallback() { // from class: com.bytedance.bdturing.ttnet.TTNetUtil.2
            public RequestRetryResult onCallToRetryRequestByTuringHeader(Map<String, List<String>> map) {
                List<String> list;
                final boolean[] zArr = {false};
                final HashMap hashMap = new HashMap();
                final CountDownLatch countDownLatch = new CountDownLatch(1);
                if (map.containsKey("bdturing-verify")) {
                    List<String> list2 = map.get("bdturing-verify");
                    if (list2 == null || list2.size() < 1) {
                        return new RequestRetryResult(zArr[0], hashMap);
                    }
                    String str = list2.get(0);
                    if (map.containsKey("bdturing-extra") && (list = map.get("bdturing-extra")) != null && list.size() >= 1) {
                        hashMap.put("bdturing-extra", list.get(0));
                    }
                    final RiskInfoRequest riskInfoRequest = new RiskInfoRequest(str);
                    Activity topActivity = BdTuring.getInstance().getConfig() != null ? BdTuring.getInstance().getConfig().getTopActivity() : null;
                    riskInfoRequest.setCallType(0);
                    BdTuring.getInstance().showVerifyDialog(topActivity, riskInfoRequest, new BdTuringCallback() { // from class: com.bytedance.bdturing.ttnet.TTNetUtil.2.1
                        @Override // com.bytedance.bdturing.BdTuringCallback
                        public void onFail(int i, JSONObject jSONObject) {
                            LogUtil.m160d(TTNetUtil.TAG, "===>onFail result:" + i + ":extras=" + jSONObject);
                            countDownLatch.countDown();
                        }

                        @Override // com.bytedance.bdturing.BdTuringCallback
                        public void onSuccess(int i, JSONObject jSONObject) {
                            zArr[0] = true;
                            if (jSONObject != null && !TextUtils.isEmpty(jSONObject.optString(LoginVerifyService.X_TT_TOKEN))) {
                                hashMap.put(LoginVerifyService.X_TT_TOKEN, jSONObject.optString(LoginVerifyService.X_TT_TOKEN));
                            }
                            TTNetUtil.fillReplayData(riskInfoRequest, hashMap);
                            countDownLatch.countDown();
                        }
                    });
                    try {
                        countDownLatch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                return new RequestRetryResult(zArr[0], hashMap);
            }
        });
    }

    public static void byPassBdTuring() {
        final HashMap hashMap = new HashMap();
        hashMap.put("x-tt-bypass-bdturing", "1");
        RetrofitUtils.addInterceptor(new Interceptor() { // from class: com.bytedance.bdturing.ttnet.TTNetUtil.3
            public SsResponse intercept(Interceptor.Chain chain) throws Exception {
                Request request = chain.request();
                LinkedList linkedList = new LinkedList();
                linkedList.addAll(request.getHeaders());
                for (String str : hashMap.keySet()) {
                    linkedList.add(new Header(str, (String) hashMap.get(str)));
                }
                return chain.proceed(request.newBuilder().headers(linkedList).build());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void fillReplayData(AbstractRequest abstractRequest, Map<String, String> map) {
        if (abstractRequest == null || TextUtils.isEmpty(abstractRequest.getReplayData())) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(abstractRequest.getReplayData());
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                String optString = jSONObject.optString(next, "");
                if (!TextUtils.isEmpty(optString)) {
                    map.put(next, optString);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
