package com.bytedance.ttnet;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.common.utility.Logger;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.Callback;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.ttnet.utils.TTNetProtocolUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class TTMultiNetwork {
    private static final String HEADER_ACTIVE_RESULT = "ActiveResult";
    private static final String HOST_MULTINET = "multinet";
    private static final String PATH_ACTIVATE_CELL = "/activatecell";
    private static final String TAG = "TTMultiNetwork";
    private static volatile State sCurrentState = State.STOPPED;
    private static volatile ActiveResult sActiveResult = ActiveResult.DEFAULT;
    private static Map<Observer, Handler> sObservers = new HashMap();

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public interface Observer {
        void onMultiNetStateChanged(State state, State state2, long j);

        void onUserSpecifiedNetworkEnabled(boolean z, long j);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public enum State {
        STOPPED(-1),
        NO_NETWORK(0),
        DEFAULT_CELLULAR_WITH_WIFI_DOWN(1),
        DEFAULT_WIFI_WITH_CELLULAR_DOWN(2),
        DEFAULT_WIFI_WITH_CELLULAR_UP(3),
        WAIT_CELLULAR_ALWAYS_UP(4),
        DEFAULT_VPN(5);

        final int state;

        State(int i) {
            this.state = i;
        }

        public int code() {
            return this.state;
        }

        static State convertToState(int i) {
            return values()[i - STOPPED.code()];
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public enum ActiveResult {
        DEFAULT(0),
        SUCCESS(1),
        FAILED(2),
        DEFERRED_UNSUITABLE_NETWORK(3),
        ACTIVATION_IN_PROGRESS(4);

        private final int code;

        ActiveResult(int i) {
            this.code = i;
        }

        int code() {
            return this.code;
        }

        static ActiveResult convertToResult(String str) {
            try {
                return values()[Integer.parseInt(str) - DEFAULT.code()];
            } catch (NumberFormatException unused) {
                return DEFAULT;
            }
        }

        public int getCode() {
            return this.code;
        }
    }

    public static State getCurrentState() {
        return sCurrentState;
    }

    public static ActiveResult getActiveResult() {
        return sActiveResult;
    }

    public static void registerMultiNetObserver(Observer observer, Handler handler) {
        if (observer == null) {
            throw new NullPointerException("observer == null");
        }
        synchronized (TTMultiNetwork.class) {
            if (!sObservers.containsKey(observer)) {
                if (handler == null) {
                    sObservers.put(observer, new Handler(Looper.getMainLooper()));
                } else {
                    sObservers.put(observer, handler);
                }
            }
        }
    }

    public static void unregisterMultiNetObserver(Observer observer) {
        if (observer == null) {
            throw new NullPointerException("observer == null");
        }
        synchronized (TTMultiNetwork.class) {
            sObservers.remove(observer);
        }
    }

    public static void tryActivateAlternativeNet() {
        try {
            TTNetProtocolUtil.sendTTNetProtocolRequestAsync(HOST_MULTINET, PATH_ACTIVATE_CELL, null, null, new Callback<TypedInput>() { // from class: com.bytedance.ttnet.TTMultiNetwork.1
                @Override // com.bytedance.retrofit2.Callback
                public void onResponse(Call<TypedInput> call, SsResponse<TypedInput> ssResponse) {
                    String str;
                    try {
                        Iterator<Header> it = ssResponse.headers().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                str = null;
                                break;
                            }
                            Header next = it.next();
                            if (TTMultiNetwork.HEADER_ACTIVE_RESULT.equalsIgnoreCase(next.getName())) {
                                str = next.getValue();
                                break;
                            }
                        }
                        ActiveResult unused = TTMultiNetwork.sActiveResult = ActiveResult.convertToResult(str);
                        TTMultiNetwork.notifyUserSpecifiedNetworkEnabled("1".equals(str));
                    } finally {
                        try {
                        } finally {
                        }
                    }
                }

                @Override // com.bytedance.retrofit2.Callback
                public void onFailure(Call<TypedInput> call, Throwable th) {
                    TTMultiNetwork.notifyUserSpecifiedNetworkEnabled(false);
                    th.printStackTrace();
                    call.cancel();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void notifyMultiNetworkState(final int i, final int i2) {
        if (Logger.debug()) {
            Logger.d(TAG, "notifyMultiNetworkState, prev: " + i + ", curr: " + i2);
        }
        sCurrentState = State.convertToState(i2);
        final long currentTimeMillis = System.currentTimeMillis();
        synchronized (TTMultiNetwork.class) {
            for (Map.Entry<Observer, Handler> entry : sObservers.entrySet()) {
                final Observer key = entry.getKey();
                Handler value = entry.getValue();
                if (value != null) {
                    value.post(new Runnable() { // from class: com.bytedance.ttnet.TTMultiNetwork.2
                        @Override // java.lang.Runnable
                        public void run() {
                            Observer.this.onMultiNetStateChanged(State.convertToState(i), State.convertToState(i2), currentTimeMillis);
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void notifyUserSpecifiedNetworkEnabled(final boolean z) {
        final long currentTimeMillis = System.currentTimeMillis();
        synchronized (TTMultiNetwork.class) {
            for (Map.Entry<Observer, Handler> entry : sObservers.entrySet()) {
                final Observer key = entry.getKey();
                Handler value = entry.getValue();
                if (value != null) {
                    value.post(new Runnable() { // from class: com.bytedance.ttnet.TTMultiNetwork.3
                        @Override // java.lang.Runnable
                        public void run() {
                            Observer.this.onUserSpecifiedNetworkEnabled(z, currentTimeMillis);
                        }
                    });
                }
            }
        }
    }
}
