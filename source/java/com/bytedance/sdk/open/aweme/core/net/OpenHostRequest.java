package com.bytedance.sdk.open.aweme.core.net;

import com.bytedance.sdk.open.aweme.core.net.OpenNetHeaders;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes5.dex */
public class OpenHostRequest {
    public static final long DEFAULT_TIMEOUT = 60000;
    private boolean addHostCommonParams;
    private String clientKey;
    private long connectTimeOut;
    private OpenNetHeaders headers;
    private String method;
    private long readTimeOut;
    private OpenRequestBody requestBody;
    private boolean responseStreaming;
    private String url;
    private int useTicketType;
    private long writeTimeOut;

    /* loaded from: classes5.dex */
    public static class Builder {
        private boolean addHostCommonParams;
        private String clientKey;
        private long connectTimeOut;
        private OpenNetHeaders.Builder headers;
        private String method;
        private long readTimeOut;
        private OpenRequestBody requestBody;
        private boolean responseStreaming;
        private String url;
        private int useTicketType;
        private long writeTimeOut;

        public Builder(OpenHostRequest openHostRequest) {
            this.useTicketType = 0;
            this.clientKey = "";
            this.url = openHostRequest.url;
            this.method = openHostRequest.method;
            this.connectTimeOut = openHostRequest.connectTimeOut;
            this.writeTimeOut = openHostRequest.writeTimeOut;
            this.readTimeOut = openHostRequest.readTimeOut;
            this.responseStreaming = openHostRequest.responseStreaming;
            this.addHostCommonParams = openHostRequest.addHostCommonParams;
            this.headers = new OpenNetHeaders.Builder(openHostRequest.headers);
            this.requestBody = openHostRequest.requestBody;
            this.clientKey = openHostRequest.clientKey;
            this.useTicketType = openHostRequest.useTicketType;
        }

        public Builder(String str) {
            this.useTicketType = 0;
            this.clientKey = "";
            this.url = str;
            this.method = "GET";
            this.connectTimeOut = 60000L;
            this.writeTimeOut = 60000L;
            this.readTimeOut = 60000L;
            this.responseStreaming = false;
            this.addHostCommonParams = true;
            this.headers = new OpenNetHeaders.Builder();
            this.requestBody = null;
        }

        public Builder addHeader(String str, String str2) {
            this.headers.addHeader(str, str2);
            return this;
        }

        public Builder addHostCommonParams(boolean z) {
            this.addHostCommonParams = z;
            return this;
        }

        public OpenHostRequest build() {
            return new OpenHostRequest(this.url, this.method, this.responseStreaming, this.addHostCommonParams, this.headers.build(), this.requestBody, this.connectTimeOut, this.readTimeOut, this.writeTimeOut, this.useTicketType, this.clientKey);
        }

        public Builder connectTimeOut(long j) {
            this.connectTimeOut = j;
            return this;
        }

        public Builder delete(OpenRequestBody openRequestBody) {
            return method("DELETE", openRequestBody);
        }

        public Builder get() {
            return method("GET", null);
        }

        public List<String> getHeaders(String str) {
            return this.headers.getHeader(str);
        }

        public Builder head() {
            return method("HEAD", null);
        }

        public Builder method(String str, OpenRequestBody openRequestBody) {
            this.method = str;
            this.requestBody = openRequestBody;
            return this;
        }

        public Builder patch(OpenRequestBody openRequestBody) {
            return method("PATCH", openRequestBody);
        }

        public Builder post(OpenRequestBody openRequestBody) {
            return method("POST", openRequestBody);
        }

        public Builder put(OpenRequestBody openRequestBody) {
            return method("PUT", openRequestBody);
        }

        public Builder readTimeOut(long j) {
            this.readTimeOut = j;
            return this;
        }

        public Builder removeHeader(String str) {
            this.headers.removeHeader(str);
            return this;
        }

        public Builder replaceHeader(String str, String str2) {
            this.headers.replaceHeader(str, str2);
            return this;
        }

        public Builder responseStreaming(boolean z) {
            this.responseStreaming = z;
            return this;
        }

        public Builder setClientKey(String str) {
            this.clientKey = str;
            return this;
        }

        public Builder setHeaders(OpenNetHeaders openNetHeaders) {
            this.headers = new OpenNetHeaders.Builder(openNetHeaders);
            return this;
        }

        public Builder setHeaders(Map<String, String> map) {
            this.headers.setHeaders(map);
            return this;
        }

        public Builder setUseTicketType(int i) {
            this.useTicketType = i;
            return this;
        }

        public Builder url(String str) {
            this.url = str;
            return this;
        }

        public Builder writeTimeOut(long j) {
            this.writeTimeOut = j;
            return this;
        }
    }

    public OpenHostRequest(String str, String str2, boolean z, boolean z2, OpenNetHeaders openNetHeaders, OpenRequestBody openRequestBody, long j, long j2, long j3, int i, String str3) {
        this.url = str;
        this.method = str2;
        this.responseStreaming = z;
        this.addHostCommonParams = z2;
        this.headers = openNetHeaders;
        this.requestBody = openRequestBody;
        this.connectTimeOut = j;
        this.readTimeOut = j2;
        this.writeTimeOut = j3;
        this.useTicketType = i;
        this.clientKey = str3;
    }

    public boolean addHostCommonParams() {
        return this.addHostCommonParams;
    }

    public String getClientKey() {
        return this.clientKey;
    }

    public long getConnectTimeOut() {
        return this.connectTimeOut;
    }

    public OpenNetHeaders getHeaders() {
        return this.headers;
    }

    public String getMethod() {
        return this.method;
    }

    public long getReadTimeOut() {
        return this.readTimeOut;
    }

    public OpenRequestBody getRequestBody() {
        return this.requestBody;
    }

    public String getUrl() {
        return this.url;
    }

    public int getUseTicketType() {
        return this.useTicketType;
    }

    public long getWriteTimeOut() {
        return this.writeTimeOut;
    }

    public boolean isResponseStreaming() {
        return this.responseStreaming;
    }

    public String toString() {
        return "OpenHostRequest{url='" + this.url + "', method='" + this.method + "', responseStreaming=" + this.responseStreaming + ", addHostCommonParams=" + this.addHostCommonParams + ", headers=" + this.headers + ", connectTimeOut=" + this.connectTimeOut + ", readTimeOut=" + this.readTimeOut + ", writeTimeOut=" + this.writeTimeOut + AbstractJsonLexerKt.END_OBJ;
    }
}
