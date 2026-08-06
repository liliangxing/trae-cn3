package com.bytedance.ttnet;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.Callback;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.ttnet.utils.TTNetProtocolUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class NQEManager {
    public static final int CAPTIVE_PORTAL = -2;
    public static final int EXCELLENT_4G = 8;
    public static final int FAKE = -1;
    public static final int GOOD_4G = 7;
    private static final String HEADER_EFFECTIVE_CONNECTION_TYPE = "ECT";
    private static final String HOST_NQE = "nqe";
    public static final int INVALID = -3;
    public static final int MODERATE_4G = 6;
    public static final int NORMAL_2G = 3;
    public static final int NORMAL_3G = 4;
    public static final int OFFLINE = 1;
    private static final String PATH_FORCE_GET = "/force_get";
    public static final int SLOW_2G = 2;
    public static final int SLOW_4G = 5;
    private static final String TAG = "NQEManager";
    public static final int UNKNOWN = 0;
    private static Map<NQEObserver, Handler> sObservers = new HashMap();

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public interface NQEObserver {
        void onNetworkQualityTypeChanged(int i);
    }

    public static void regNQEObserver(NQEObserver nQEObserver, Handler handler) {
        if (nQEObserver == null) {
            throw new NullPointerException("observer == null");
        }
        if (handler == null) {
            throw new NullPointerException("handler == null");
        }
        synchronized (NQEManager.class) {
            if (!sObservers.containsKey(nQEObserver)) {
                sObservers.put(nQEObserver, handler);
            }
        }
    }

    public static void unregNQEObserver(NQEObserver nQEObserver) {
        if (nQEObserver == null) {
            throw new NullPointerException("observer == null");
        }
        synchronized (NQEManager.class) {
            sObservers.remove(nQEObserver);
        }
    }

    public static void getForceComputeNetworkQuality(final Handler handler, final NQEObserver nQEObserver) {
        if (nQEObserver == null) {
            throw new NullPointerException("observer == null");
        }
        if (handler == null) {
            handler = new Handler(Looper.getMainLooper());
        }
        try {
            TTNetProtocolUtil.sendTTNetProtocolRequestAsync(HOST_NQE, PATH_FORCE_GET, null, null, new Callback<TypedInput>() { // from class: com.bytedance.ttnet.NQEManager.1
                @Override // com.bytedance.retrofit2.Callback
                public void onResponse(Call<TypedInput> call, SsResponse<TypedInput> ssResponse) {
                    List<Header> headers;
                    String str = null;
                    if (ssResponse != null) {
                        try {
                            headers = ssResponse.headers();
                        } finally {
                            try {
                            } finally {
                            }
                        }
                    } else {
                        headers = null;
                    }
                    if (headers != null) {
                        Iterator<Header> it = headers.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            Header next = it.next();
                            if (NQEManager.HEADER_EFFECTIVE_CONNECTION_TYPE.equalsIgnoreCase(next.getName())) {
                                str = next.getValue();
                                break;
                            }
                        }
                    }
                    NQEManager.postResult(handler, nQEObserver, str != null ? NQEManager.parseOrUnknown(str) : 0);
                }

                @Override // com.bytedance.retrofit2.Callback
                public void onFailure(Call<TypedInput> call, Throwable th) {
                    th.printStackTrace();
                    NQEManager.postResult(handler, nQEObserver, 0);
                    call.cancel();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            postResult(handler, nQEObserver, 0);
        }
    }

    private static void notifyNQTChanged(final int i) {
        synchronized (NQEManager.class) {
            for (Map.Entry<NQEObserver, Handler> entry : sObservers.entrySet()) {
                final NQEObserver key = entry.getKey();
                entry.getValue().post(new Runnable() { // from class: com.bytedance.ttnet.NQEManager.2
                    @Override // java.lang.Runnable
                    public void run() {
                        NQEObserver.this.onNetworkQualityTypeChanged(i);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int parseOrUnknown(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void postResult(Handler handler, final NQEObserver nQEObserver, final int i) {
        handler.post(new Runnable() { // from class: com.bytedance.ttnet.NQEManager.3
            @Override // java.lang.Runnable
            public void run() {
                NQEObserver.this.onNetworkQualityTypeChanged(i);
            }
        });
    }
}
