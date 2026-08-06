package com.bytedance.frameworks.baselib.network.http.ok3.impl;

import com.bytedance.frameworks.baselib.network.http.ok3.IOkHttpAppInfoProvider;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.redirectdispatch.TTRedirectDispatchManager;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.HttpUrl;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class OkHttp3EventListener extends EventListener {
    private final String TAG = "OkHttp3EventListener";
    private final OkHttp3RequestLog mOkHttp3RequestLog;
    private final EventListener mOriginEventListener;

    public OkHttp3EventListener(EventListener eventListener, OkHttp3RequestLog okHttp3RequestLog) {
        this.mOriginEventListener = eventListener;
        this.mOkHttp3RequestLog = okHttp3RequestLog;
    }

    public void callStart(Call call) {
        super.callStart(call);
        EventListener eventListener = this.mOriginEventListener;
        if (eventListener != null) {
            eventListener.callStart(call);
        }
        this.mOkHttp3RequestLog.callStart();
    }

    public void dnsStart(Call call, String str) {
        super.dnsStart(call, str);
        EventListener eventListener = this.mOriginEventListener;
        if (eventListener != null) {
            eventListener.dnsStart(call, str);
        }
        this.mOkHttp3RequestLog.dnsStart();
    }

    public void dnsEnd(Call call, String str, List<InetAddress> list) {
        super.dnsEnd(call, str, list);
        EventListener eventListener = this.mOriginEventListener;
        if (eventListener != null) {
            eventListener.dnsEnd(call, str, list);
        }
        this.mOkHttp3RequestLog.dnsEnd();
    }

    public void dnsEnd(Call call, String str, List<InetAddress> list, String str2) {
        super.dnsEnd(call, str, list, str2);
        EventListener eventListener = this.mOriginEventListener;
        if (eventListener != null) {
            eventListener.dnsEnd(call, str, list);
        }
        this.mOkHttp3RequestLog.dnsEnd(str2);
    }

    public void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
        super.connectStart(call, inetSocketAddress, proxy);
        EventListener eventListener = this.mOriginEventListener;
        if (eventListener != null) {
            eventListener.connectStart(call, inetSocketAddress, proxy);
        }
        this.mOkHttp3RequestLog.connectStart();
    }

    public void secureConnectStart(Call call) {
        super.secureConnectStart(call);
        EventListener eventListener = this.mOriginEventListener;
        if (eventListener != null) {
            eventListener.secureConnectStart(call);
        }
        this.mOkHttp3RequestLog.secureConnectStart();
    }

    public void secureConnectEnd(Call call, Handshake handshake) {
        super.secureConnectEnd(call, handshake);
        EventListener eventListener = this.mOriginEventListener;
        if (eventListener != null) {
            eventListener.secureConnectEnd(call, handshake);
        }
        this.mOkHttp3RequestLog.secureConnectEnd();
    }

    public void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
        super.connectEnd(call, inetSocketAddress, proxy, protocol);
        EventListener eventListener = this.mOriginEventListener;
        if (eventListener != null) {
            eventListener.connectEnd(call, inetSocketAddress, proxy, protocol);
        }
        this.mOkHttp3RequestLog.connectEnd(proxy);
    }

    public void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException iOException) {
        super.connectFailed(call, inetSocketAddress, proxy, protocol, iOException);
        EventListener eventListener = this.mOriginEventListener;
        if (eventListener != null) {
            eventListener.connectFailed(call, inetSocketAddress, proxy, protocol, iOException);
        }
    }

    public void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException iOException, String str) {
        super.connectFailed(call, inetSocketAddress, proxy, protocol, iOException, str);
        EventListener eventListener = this.mOriginEventListener;
        if (eventListener != null) {
            eventListener.connectFailed(call, inetSocketAddress, proxy, protocol, iOException);
        }
        this.mOkHttp3RequestLog.connectFailed(inetSocketAddress, iOException, str);
    }

    public void connectionAcquired(Call call, Connection connection) {
        super.connectionAcquired(call, connection);
        EventListener eventListener = this.mOriginEventListener;
        if (eventListener != null) {
            eventListener.connectionAcquired(call, connection);
        }
        this.mOkHttp3RequestLog.connectionAcquired(connection);
    }

    public void connectionReleased(Call call, Connection connection) {
        super.connectionReleased(call, connection);
        EventListener eventListener = this.mOriginEventListener;
        if (eventListener != null) {
            eventListener.connectionReleased(call, connection);
        }
    }

    public void requestHeadersStart(Call call) {
        super.requestHeadersStart(call);
        EventListener eventListener = this.mOriginEventListener;
        if (eventListener != null) {
            eventListener.requestHeadersStart(call);
        }
        this.mOkHttp3RequestLog.requestHeadersStart();
    }

    public void requestHeadersEnd(Call call, Request request) {
        super.requestHeadersEnd(call, request);
        EventListener eventListener = this.mOriginEventListener;
        if (eventListener != null) {
            eventListener.requestHeadersEnd(call, request);
        }
        this.mOkHttp3RequestLog.requestHeadersEnd(request);
    }

    public void requestBodyStart(Call call) {
        super.requestBodyStart(call);
        EventListener eventListener = this.mOriginEventListener;
        if (eventListener != null) {
            eventListener.requestBodyStart(call);
        }
        this.mOkHttp3RequestLog.requestBodyStart();
    }

    public void requestBodyEnd(Call call, long j) {
        super.requestBodyEnd(call, j);
        EventListener eventListener = this.mOriginEventListener;
        if (eventListener != null) {
            eventListener.requestBodyEnd(call, j);
        }
        this.mOkHttp3RequestLog.requestBodyEnd(j);
    }

    public void responseHeadersStart(Call call) {
        super.responseHeadersStart(call);
        EventListener eventListener = this.mOriginEventListener;
        if (eventListener != null) {
            eventListener.responseHeadersStart(call);
        }
        this.mOkHttp3RequestLog.responseHeadersStart();
    }

    public void responseHeadersEnd(Call call, Response response) {
        super.responseHeadersEnd(call, response);
        EventListener eventListener = this.mOriginEventListener;
        if (eventListener != null) {
            eventListener.responseHeadersEnd(call, response);
        }
        this.mOkHttp3RequestLog.responseHeadersEnd(response);
    }

    public void responseBodyStart(Call call) {
        super.responseBodyStart(call);
        EventListener eventListener = this.mOriginEventListener;
        if (eventListener != null) {
            eventListener.responseBodyStart(call);
        }
        this.mOkHttp3RequestLog.responseBodyStart();
    }

    public void responseBodyEnd(Call call, long j) {
        super.responseBodyEnd(call, j);
        EventListener eventListener = this.mOriginEventListener;
        if (eventListener != null) {
            eventListener.responseBodyEnd(call, j);
        }
        this.mOkHttp3RequestLog.responseBodyEnd(j);
    }

    public void callEnd(Call call) {
        super.callEnd(call);
        EventListener eventListener = this.mOriginEventListener;
        if (eventListener != null) {
            eventListener.callEnd(call);
        }
        this.mOkHttp3RequestLog.callEnd();
    }

    public void callFailed(Call call, IOException iOException) {
        super.callFailed(call, iOException);
        EventListener eventListener = this.mOriginEventListener;
        if (eventListener != null) {
            eventListener.callFailed(call, iOException);
        }
        this.mOkHttp3RequestLog.callFailed(iOException);
    }

    public void callInSecureRedirect(Call call, JSONObject jSONObject) {
        super.callInSecureRedirect(call, jSONObject);
        EventListener eventListener = this.mOriginEventListener;
        if (eventListener != null) {
            eventListener.callInSecureRedirect(call, jSONObject);
        }
        IOkHttpAppInfoProvider okHttpAppInfoProvider = SsOkHttp3Client.getOkHttpAppInfoProvider();
        if (okHttpAppInfoProvider != null) {
            okHttpAppInfoProvider.sendAppMonitorEvent(jSONObject.toString(), "ttnet_insec_rect");
        }
    }

    public HttpUrl callRedirectDispatch(Call call, HttpUrl httpUrl, String str, HttpUrl httpUrl2) {
        return TTRedirectDispatchManager.getInstance().onRedirect(httpUrl, httpUrl2, str, this.mOkHttp3RequestLog);
    }
}
