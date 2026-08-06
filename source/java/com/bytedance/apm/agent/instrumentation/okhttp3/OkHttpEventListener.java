package com.bytedance.apm.agent.instrumentation.okhttp3;

import android.text.TextUtils;
import com.bytedance.android.standard.tools.url.UrlUtils;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.agent.instrumentation.okhttp3.OkHttpRecord;
import com.bytedance.apm.agent.monitor.MonitorTool;
import com.bytedance.apm.constant.SlardarSettingsConsts;
import com.bytedance.apm.constant.TrafficConsts;
import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.bytedance.apm.util.NetUtils;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.Headers;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class OkHttpEventListener extends EventListener {
    public static final String X_TT_CONTENT_ENCODING = "x-tt-content-encoding";
    public static final String X_TT_TRACE_HOST = "x-tt-trace-host";
    public static final String X_TT_TRACE_ID = "x-tt-trace-id";
    public static final String X_TT_TRACE_TAG = "x-tt-trace-tag";
    private static String sIgnoreMonitorLabel;
    private long connectStartTime;
    private long dnsStartTime;
    private boolean needToDeal = true;
    private OkHttpRecord okHttpRecord = new OkHttpRecord();
    public EventListener originListener;
    private long requestBodyEndTime;
    private JSONObject requestHeader;
    private long requestHeadersEndTime;
    private long requestHeadersStartTime;
    private long responseBodyStartTime;
    private JSONObject responseHeader;
    private long responseHeadersStartTime;
    private long secureConnectStartTime;
    private String url;

    public static void setIgnoreMonitorLabel(String str) {
        sIgnoreMonitorLabel = str;
    }

    public OkHttpEventListener(EventListener eventListener) {
        this.originListener = eventListener;
    }

    public void callStart(Call call) {
        super.callStart(call);
        EventListener eventListener = this.originListener;
        if (eventListener != null) {
            eventListener.callStart(call);
        }
        if (this.needToDeal) {
            this.okHttpRecord.timeRequest.start_time = System.currentTimeMillis();
        }
    }

    public void dnsStart(Call call, String str) {
        super.dnsStart(call, str);
        if (this.needToDeal) {
            this.dnsStartTime = System.currentTimeMillis();
        }
        EventListener eventListener = this.originListener;
        if (eventListener != null) {
            eventListener.dnsStart(call, str);
        }
    }

    public void dnsEnd(Call call, String str, List<InetAddress> list) {
        super.dnsEnd(call, str, list);
        EventListener eventListener = this.originListener;
        if (eventListener != null) {
            eventListener.dnsEnd(call, str, list);
        }
        if (this.needToDeal) {
            this.okHttpRecord.timeDetailedDuration.dns = (int) (System.currentTimeMillis() - this.dnsStartTime);
            if (list == null || list.size() <= 0) {
                return;
            }
            for (InetAddress inetAddress : list) {
                OkHttpRecord.DnsInfo dnsInfo = new OkHttpRecord.DnsInfo();
                dnsInfo.address = inetAddress.getHostAddress();
                this.okHttpRecord.addressList.add(dnsInfo);
            }
        }
    }

    public void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
        super.connectStart(call, inetSocketAddress, proxy);
        if (this.needToDeal) {
            this.connectStartTime = System.currentTimeMillis();
        }
        EventListener eventListener = this.originListener;
        if (eventListener != null) {
            eventListener.connectStart(call, inetSocketAddress, proxy);
        }
    }

    public void secureConnectStart(Call call) {
        super.secureConnectStart(call);
        if (this.needToDeal) {
            this.okHttpRecord.timeDetailedDuration.tcp = (int) (System.currentTimeMillis() - this.connectStartTime);
            this.secureConnectStartTime = System.currentTimeMillis();
        }
        EventListener eventListener = this.originListener;
        if (eventListener != null) {
            eventListener.secureConnectStart(call);
        }
    }

    public void secureConnectEnd(Call call, Handshake handshake) {
        super.secureConnectEnd(call, handshake);
        if (this.needToDeal) {
            this.okHttpRecord.timeDetailedDuration.ssl = (int) (System.currentTimeMillis() - this.secureConnectStartTime);
        }
        EventListener eventListener = this.originListener;
        if (eventListener != null) {
            eventListener.secureConnectEnd(call, handshake);
        }
    }

    public void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
        super.connectEnd(call, inetSocketAddress, proxy, protocol);
        EventListener eventListener = this.originListener;
        if (eventListener != null) {
            eventListener.connectEnd(call, inetSocketAddress, proxy, protocol);
        }
        if (this.needToDeal) {
            this.okHttpRecord.recordResponse.via_Proxy = proxy.address() != null;
            if (inetSocketAddress == null || inetSocketAddress.getAddress() == null) {
                return;
            }
            this.okHttpRecord.socketInfo.remote = inetSocketAddress.getAddress().getHostAddress() + ":" + inetSocketAddress.getPort();
            this.okHttpRecord.socketInfo.host = inetSocketAddress.getAddress().getHostAddress();
            this.okHttpRecord.socketInfo.port = inetSocketAddress.getPort() + "";
        }
    }

    public void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException iOException) {
        super.connectFailed(call, inetSocketAddress, proxy, protocol, iOException);
        EventListener eventListener = this.originListener;
        if (eventListener != null) {
            eventListener.connectFailed(call, inetSocketAddress, proxy, protocol, iOException);
        }
    }

    public void connectionAcquired(Call call, Connection connection) {
        super.connectionAcquired(call, connection);
        EventListener eventListener = this.originListener;
        if (eventListener != null) {
            eventListener.connectionAcquired(call, connection);
        }
        if (this.needToDeal) {
            if (this.dnsStartTime == 0) {
                this.okHttpRecord.socketInfo.socketReused = true;
            } else {
                this.okHttpRecord.socketInfo.socketReused = false;
            }
        }
    }

    public void connectionReleased(Call call, Connection connection) {
        super.connectionReleased(call, connection);
        EventListener eventListener = this.originListener;
        if (eventListener != null) {
            eventListener.connectionReleased(call, connection);
        }
    }

    public void requestHeadersStart(Call call) {
        super.requestHeadersStart(call);
        if (this.needToDeal) {
            this.requestHeadersStartTime = System.currentTimeMillis();
            this.okHttpRecord.timeRequest.request_sent_time = this.requestHeadersStartTime;
        }
        EventListener eventListener = this.originListener;
        if (eventListener != null) {
            eventListener.requestHeadersStart(call);
        }
    }

    public void requestHeadersEnd(Call call, Request request) {
        super.requestHeadersEnd(call, request);
        if (this.needToDeal) {
            this.requestHeadersEndTime = System.currentTimeMillis();
            this.okHttpRecord.timeDetailedDuration.send = (int) (System.currentTimeMillis() - this.requestHeadersStartTime);
        }
        EventListener eventListener = this.originListener;
        if (eventListener != null) {
            eventListener.requestHeadersEnd(call, request);
        }
        String header = request.header(UrlUtils.USER_AGENT);
        String str = sIgnoreMonitorLabel;
        if (str != null && header != null && header.contains(str)) {
            this.needToDeal = false;
        }
        if (this.needToDeal) {
            this.okHttpRecord.recordResponse.sent_bytes += request.headers().byteCount();
            this.url = request.url().toString();
            this.requestHeader = getHeaders(request.headers());
        }
    }

    private JSONObject getHeaders(Headers headers) {
        JSONObject jSONObject = new JSONObject();
        if (headers != null) {
            try {
                for (String str : headers.names()) {
                    try {
                        jSONObject.put(str, headers.get(str));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return jSONObject;
    }

    public void requestBodyStart(Call call) {
        super.requestBodyStart(call);
        EventListener eventListener = this.originListener;
        if (eventListener != null) {
            eventListener.requestBodyStart(call);
        }
    }

    public void requestBodyEnd(Call call, long j) {
        super.requestBodyEnd(call, j);
        if (this.needToDeal) {
            this.requestBodyEndTime = System.currentTimeMillis();
            this.okHttpRecord.timeDetailedDuration.send = (int) (System.currentTimeMillis() - this.requestHeadersStartTime);
        }
        EventListener eventListener = this.originListener;
        if (eventListener != null) {
            eventListener.requestBodyEnd(call, j);
        }
        if (this.needToDeal) {
            this.okHttpRecord.recordResponse.sent_bytes += j;
        }
    }

    public void responseHeadersStart(Call call) {
        long currentTimeMillis;
        long j;
        super.responseHeadersStart(call);
        if (this.needToDeal) {
            this.responseHeadersStartTime = System.currentTimeMillis();
            if (this.requestBodyEndTime != 0) {
                currentTimeMillis = System.currentTimeMillis();
                j = this.requestBodyEndTime;
            } else {
                currentTimeMillis = System.currentTimeMillis();
                j = this.requestHeadersEndTime;
            }
            this.okHttpRecord.timeDetailedDuration.ttfb = (int) (currentTimeMillis - j);
            this.okHttpRecord.timeRequest.response_recv_time = System.currentTimeMillis();
        }
        EventListener eventListener = this.originListener;
        if (eventListener != null) {
            eventListener.responseHeadersStart(call);
        }
    }

    public void responseHeadersEnd(Call call, Response response) {
        super.responseHeadersEnd(call, response);
        EventListener eventListener = this.originListener;
        if (eventListener != null) {
            eventListener.responseHeadersEnd(call, response);
        }
        if (this.needToDeal) {
            this.okHttpRecord.timeDetailedDuration.header_recv = (int) (System.currentTimeMillis() - this.responseHeadersStartTime);
            this.okHttpRecord.recordResponse.code = response.code();
            this.okHttpRecord.recordResponse.received_bytes += response.headers().byteCount();
            this.okHttpRecord.recordResponse.network_accessed = NetUtils.isNetworkAvailable(ApmContext.getContext());
            this.okHttpRecord.headerRequest.x_tt_trace_id = response.header(X_TT_TRACE_ID, "");
            this.okHttpRecord.headerRequest.x_tt_trace_host = response.header(X_TT_TRACE_HOST, "");
            this.okHttpRecord.headerRequest.x_tt_trace_tag = response.header(X_TT_TRACE_TAG, "");
            this.okHttpRecord.headerRequest.x_tt_content_encoding = response.header(X_TT_CONTENT_ENCODING, "");
            try {
                dealSpecialHeader(response);
            } catch (Exception unused) {
            }
            this.responseHeader = getHeaders(response.headers());
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:18:0x006b. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:32:0x009d. Please report as an issue. */
    private void dealSpecialHeader(Response response) {
        for (String str : response.headers("server-timing")) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.okHttpRecord.headerRequest.serverTimings.add(str);
            for (String str2 : str.split(",")) {
                if (!TextUtils.isEmpty(str2) && str2.contains(";")) {
                    String[] split = str2.split(";");
                    if (split.length >= 2) {
                        String replace = split[0].replace(" ", "");
                        String replace2 = split[1].replace(" ", "");
                        if (!TextUtils.isEmpty(replace)) {
                            replace.hashCode();
                            char c = 65535;
                            switch (replace.hashCode()) {
                                case -1008619738:
                                    if (replace.equals("origin")) {
                                        c = 0;
                                        break;
                                    }
                                    break;
                                case -138105374:
                                    if (replace.equals("cdn-cache")) {
                                        c = 1;
                                        break;
                                    }
                                    break;
                                case 3108285:
                                    if (replace.equals("edge")) {
                                        c = 2;
                                        break;
                                    }
                                    break;
                                case 100355670:
                                    if (replace.equals("inner")) {
                                        c = 3;
                                        break;
                                    }
                                    break;
                            }
                            switch (c) {
                                case 0:
                                    if (!TextUtils.isEmpty(replace2)) {
                                        String[] split2 = replace2.split("=");
                                        if (split2.length >= 2) {
                                            this.okHttpRecord.timeDetailedDuration.origin = !TextUtils.isEmpty(split2[1]) ? Integer.parseInt(split2[1]) : 0;
                                            break;
                                        }
                                    }
                                    break;
                                case 1:
                                    if (!TextUtils.isEmpty(replace2)) {
                                        String[] split3 = replace2.split("=");
                                        if (split3.length >= 2) {
                                            this.okHttpRecord.timeDetailedDuration.cdn_hit_cache = !TextUtils.isEmpty(split3[1]) && split3[1].equalsIgnoreCase("hit");
                                            break;
                                        }
                                    }
                                    break;
                                case 2:
                                    if (!TextUtils.isEmpty(replace2)) {
                                        String[] split4 = replace2.split("=");
                                        if (split4.length >= 2) {
                                            this.okHttpRecord.timeDetailedDuration.edge = !TextUtils.isEmpty(split4[1]) ? Integer.parseInt(split4[1]) : 0;
                                            break;
                                        }
                                    }
                                    break;
                                case 3:
                                    if (!TextUtils.isEmpty(replace2)) {
                                        String[] split5 = replace2.split("=");
                                        if (split5.length >= 2) {
                                            this.okHttpRecord.timeDetailedDuration.inner = !TextUtils.isEmpty(split5[1]) ? Integer.parseInt(split5[1]) : 0;
                                            break;
                                        }
                                    }
                                    break;
                            }
                        }
                    }
                }
            }
        }
        int i = (this.okHttpRecord.timeDetailedDuration.ttfb - this.okHttpRecord.timeDetailedDuration.edge) - this.okHttpRecord.timeDetailedDuration.origin;
        if (i > 0) {
            this.okHttpRecord.timeDetailedDuration.rtt = i;
        }
        int i2 = this.okHttpRecord.timeDetailedDuration.origin - this.okHttpRecord.timeDetailedDuration.inner;
        if (i2 > 0) {
            this.okHttpRecord.timeDetailedDuration.origin = i2;
        }
    }

    public void responseBodyStart(Call call) {
        super.responseBodyStart(call);
        if (this.needToDeal) {
            this.responseBodyStartTime = System.currentTimeMillis();
        }
        EventListener eventListener = this.originListener;
        if (eventListener != null) {
            eventListener.responseBodyStart(call);
        }
    }

    public void responseBodyEnd(Call call, long j) {
        super.responseBodyEnd(call, j);
        EventListener eventListener = this.originListener;
        if (eventListener != null) {
            eventListener.responseBodyEnd(call, j);
        }
        if (this.needToDeal) {
            this.okHttpRecord.recordResponse.received_bytes += j;
            this.okHttpRecord.timeDetailedDuration.body_recv = (int) (System.currentTimeMillis() - this.responseBodyStartTime);
        }
    }

    public void callEnd(Call call) {
        super.callEnd(call);
        EventListener eventListener = this.originListener;
        if (eventListener != null) {
            eventListener.callEnd(call);
        }
        record();
    }

    public void callFailed(Call call, IOException iOException) {
        super.callFailed(call, iOException);
        EventListener eventListener = this.originListener;
        if (eventListener != null) {
            eventListener.callFailed(call, iOException);
        }
        record();
    }

    private void record() {
        OkHttpRecord okHttpRecord;
        if (this.needToDeal && (okHttpRecord = this.okHttpRecord) != null) {
            okHttpRecord.timeRequest.duration = System.currentTimeMillis() - this.okHttpRecord.timeRequest.start_time;
            try {
                JSONObject jSONObject = new JSONObject(this.okHttpRecord.toString());
                jSONObject.put(TrafficConsts.KEY_SENT_BYTES, this.okHttpRecord.recordResponse.sent_bytes);
                jSONObject.put(TrafficConsts.KEY_RECEIVED_BYTES, this.okHttpRecord.recordResponse.received_bytes);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(ApmTrafficStats.TTNET_REQUEST_LOG, jSONObject);
                jSONObject2.put(TrafficConsts.KEY_NET_CONSUME_TYPE, "okhttp");
                JSONObject jSONObject3 = this.requestHeader;
                jSONObject2.put(SlardarSettingsConsts.EXT_REQUEST_HEADER, jSONObject3 != null ? jSONObject3.toString() : "");
                JSONObject jSONObject4 = this.responseHeader;
                jSONObject2.put(SlardarSettingsConsts.EXT_RESPONSE_HEADER, jSONObject4 != null ? jSONObject4.toString() : "");
                MonitorTool.monitorSLA(this.okHttpRecord.timeRequest.duration, this.okHttpRecord.timeRequest.start_time, this.url, this.okHttpRecord.socketInfo.remote, "", this.okHttpRecord.recordResponse.code, jSONObject2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
