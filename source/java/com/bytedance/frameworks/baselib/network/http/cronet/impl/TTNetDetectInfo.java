package com.bytedance.frameworks.baselib.network.http.cronet.impl;

import android.text.TextUtils;
import com.bytedance.ug.sdk.deeplink.EventConstants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class TTNetDetectInfo {
    public int actions;
    public String appVersion;
    public String clientIp;
    public List<TTNetDetectInfoBase> details = new ArrayList();
    public int failCount;
    public String localDnsServer;
    public String nettype;
    public String os;
    public String osVersion;
    public int rank;
    public int source;
    public int succCount;
    public long timestamp;

    /* loaded from: classes2.dex */
    public static class TTNetDetectInfoBase {
    }

    /* loaded from: classes2.dex */
    public static class TTNetDetectHttpGetInfo extends TTNetDetectInfoBase {
        public int cached;
        public int dnsCost;
        public int errorCode;
        public int httpCode;
        public String ip;
        public int port;
        public int recvBytes;
        public int recvCost;
        public int sendCost;
        public int sockReused;
        public int sslCost;
        public int tcpCost;
        public int timeout;
        public int totalCost;
        public String url;
        public int waitCost;

        public static TTNetDetectHttpGetInfo fromJson(JSONObject jSONObject) {
            try {
                TTNetDetectHttpGetInfo tTNetDetectHttpGetInfo = new TTNetDetectHttpGetInfo();
                tTNetDetectHttpGetInfo.url = jSONObject.getString("url");
                tTNetDetectHttpGetInfo.httpCode = jSONObject.getInt("httpcode");
                tTNetDetectHttpGetInfo.errorCode = jSONObject.getInt("error");
                tTNetDetectHttpGetInfo.timeout = jSONObject.getInt(EventConstants.PARAM_TIME_OUT);
                tTNetDetectHttpGetInfo.ip = jSONObject.getString("addr");
                tTNetDetectHttpGetInfo.port = jSONObject.getInt("port");
                tTNetDetectHttpGetInfo.cached = jSONObject.getInt("cached");
                tTNetDetectHttpGetInfo.sockReused = jSONObject.getInt("sock_reused");
                tTNetDetectHttpGetInfo.totalCost = jSONObject.getInt("totalcost");
                tTNetDetectHttpGetInfo.dnsCost = jSONObject.getInt("dnscost");
                tTNetDetectHttpGetInfo.tcpCost = jSONObject.getInt("tcpcost");
                tTNetDetectHttpGetInfo.sslCost = jSONObject.getInt("sslcost");
                tTNetDetectHttpGetInfo.sendCost = jSONObject.getInt("sendcost");
                tTNetDetectHttpGetInfo.waitCost = jSONObject.getInt("waitcost");
                tTNetDetectHttpGetInfo.recvCost = jSONObject.getInt("recvcost");
                tTNetDetectHttpGetInfo.recvBytes = jSONObject.getInt("recvd_bytes");
                return tTNetDetectHttpGetInfo;
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class TTNetDetectPingInfo extends TTNetDetectInfoBase {
        public int avgCost;
        public int error;
        public String host;
        public String ip;
        public int pingTimes;
        public int succTimes;

        public static TTNetDetectPingInfo fromJson(JSONObject jSONObject) {
            try {
                TTNetDetectPingInfo tTNetDetectPingInfo = new TTNetDetectPingInfo();
                tTNetDetectPingInfo.host = jSONObject.getString("host");
                tTNetDetectPingInfo.ip = jSONObject.getString("ip");
                tTNetDetectPingInfo.error = jSONObject.getInt("error");
                tTNetDetectPingInfo.pingTimes = jSONObject.getInt("ping_times");
                tTNetDetectPingInfo.succTimes = jSONObject.getInt("succ_times");
                tTNetDetectPingInfo.avgCost = jSONObject.getInt("avg_cost");
                return tTNetDetectPingInfo;
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class TTNetDetectTracerouteInfo extends TTNetDetectInfoBase {
        public List<TracerouteHopInfo> details = new ArrayList();
        public int error;
        public String host;
        public String ip;
        public int tryHops;

        public static TTNetDetectTracerouteInfo fromJson(JSONObject jSONObject) {
            try {
                TTNetDetectTracerouteInfo tTNetDetectTracerouteInfo = new TTNetDetectTracerouteInfo();
                tTNetDetectTracerouteInfo.host = jSONObject.getString("host");
                tTNetDetectTracerouteInfo.ip = jSONObject.getString("ip");
                tTNetDetectTracerouteInfo.error = jSONObject.getInt("error");
                tTNetDetectTracerouteInfo.tryHops = jSONObject.getInt("hops");
                JSONArray optJSONArray = jSONObject.optJSONArray("detail");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        TracerouteHopInfo fromJson = TracerouteHopInfo.fromJson((JSONObject) optJSONArray.get(i));
                        if (fromJson != null) {
                            tTNetDetectTracerouteInfo.details.add(fromJson);
                        }
                    }
                }
                return tTNetDetectTracerouteInfo;
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class TracerouteHopInfo {
        public int cost;
        public String ip;
        public int replyHops;
        public int sendHops;

        public static TracerouteHopInfo fromJson(JSONObject jSONObject) {
            try {
                TracerouteHopInfo tracerouteHopInfo = new TracerouteHopInfo();
                tracerouteHopInfo.ip = jSONObject.getString("ip");
                tracerouteHopInfo.sendHops = jSONObject.getInt("sendhops");
                tracerouteHopInfo.replyHops = jSONObject.getInt("replyhops");
                tracerouteHopInfo.cost = jSONObject.getInt("cost");
                return tracerouteHopInfo;
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class TTNetDetectLocalDnsInfo extends TTNetDetectInfoBase {
        public int cost;
        public int error;
        public String host;
        public List<String> ips = new ArrayList();

        public static TTNetDetectLocalDnsInfo fromJson(JSONObject jSONObject) {
            try {
                TTNetDetectLocalDnsInfo tTNetDetectLocalDnsInfo = new TTNetDetectLocalDnsInfo();
                tTNetDetectLocalDnsInfo.host = jSONObject.getString("host");
                tTNetDetectLocalDnsInfo.error = jSONObject.getInt("error");
                tTNetDetectLocalDnsInfo.cost = jSONObject.getInt("cost");
                JSONArray optJSONArray = jSONObject.optJSONArray("ips");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        if (optJSONArray.get(i) != null && (optJSONArray.get(i) instanceof String)) {
                            String str = (String) optJSONArray.get(i);
                            if (!TextUtils.isEmpty(str)) {
                                tTNetDetectLocalDnsInfo.ips.add(str);
                            }
                        }
                    }
                }
                return tTNetDetectLocalDnsInfo;
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class TTNetDetectHttpDnsInfo extends TTNetDetectInfoBase {
        public int cost;
        public int error;
        public String host;
        public List<String> ips = new ArrayList();

        public static TTNetDetectHttpDnsInfo fromJson(JSONObject jSONObject) {
            try {
                TTNetDetectHttpDnsInfo tTNetDetectHttpDnsInfo = new TTNetDetectHttpDnsInfo();
                tTNetDetectHttpDnsInfo.host = jSONObject.getString("host");
                tTNetDetectHttpDnsInfo.error = jSONObject.getInt("error");
                tTNetDetectHttpDnsInfo.cost = jSONObject.getInt("cost");
                JSONArray optJSONArray = jSONObject.optJSONArray("ips");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        if (optJSONArray.get(i) != null && (optJSONArray.get(i) instanceof String)) {
                            String str = (String) optJSONArray.get(i);
                            if (!TextUtils.isEmpty(str)) {
                                tTNetDetectHttpDnsInfo.ips.add(str);
                            }
                        }
                    }
                }
                return tTNetDetectHttpDnsInfo;
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
    }
}
