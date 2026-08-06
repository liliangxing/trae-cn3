package com.bytedance.sdk.account.execute;

import android.text.TextUtils;
import com.ss.android.TTHeader;
import com.ss.android.account.TTAccountInit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes5.dex */
public class ApiRequest {
    public static final String METHOD_GET = "get";
    public static final String METHOD_POST = "post";
    public static final String METHOD_POST_FILE = "post_file";
    public final String filePath;
    public final List<TTHeader> headers;
    public long keepTime;
    public final String method;
    public final String paramName;
    public final Map<String, String> parms;
    public final String url;
    public boolean valueNullable;

    public ApiRequest(String str, String str2, Map<String, String> map, List<TTHeader> list) {
        this.keepTime = 0L;
        this.url = str;
        this.method = str2;
        this.parms = map;
        this.headers = list;
        this.paramName = null;
        this.filePath = null;
    }

    public ApiRequest(String str, String str2, Map<String, String> map, List<TTHeader> list, String str3, String str4) {
        this.keepTime = 0L;
        this.url = str;
        this.method = str2;
        this.parms = map;
        this.paramName = str3;
        this.filePath = str4;
        this.headers = list;
    }

    public String parameter(String str) {
        Map<String, String> map = this.parms;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    public Builder newBuilder() {
        return new Builder(this);
    }

    /* loaded from: classes5.dex */
    public static class Builder {
        private String filePath;
        private List<TTHeader> headers;
        private String method;
        private String paramName;
        private Map<String, String> parms;
        private String url;
        private boolean valueNullable;

        public Builder() {
        }

        public Builder(ApiRequest apiRequest) {
            this.url = apiRequest.url;
            this.method = apiRequest.method;
            this.parms = apiRequest.parms;
            this.headers = apiRequest.headers;
            this.paramName = apiRequest.paramName;
            this.filePath = apiRequest.filePath;
            this.valueNullable = apiRequest.valueNullable;
        }

        public Builder url(String str) {
            this.url = str;
            return this;
        }

        public Builder file(String str, String str2) {
            if (str != null && str2 != null) {
                this.paramName = str;
                this.filePath = str2;
            }
            return this;
        }

        public Builder addHeader(TTHeader tTHeader) {
            if (tTHeader == null) {
                return this;
            }
            if (this.headers == null) {
                this.headers = new ArrayList();
            }
            this.headers.add(tTHeader);
            return this;
        }

        public Builder addHeader(String str, String str2) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                if (this.headers == null) {
                    this.headers = new ArrayList();
                }
                this.headers.add(new TTHeader(str, str2));
            }
            return this;
        }

        public Builder addHeaders(List<TTHeader> list) {
            if (list != null && !list.isEmpty()) {
                if (this.headers == null) {
                    this.headers = new ArrayList();
                }
                this.headers.addAll(list);
            }
            return this;
        }

        public Builder addHeaders(Map<String, String> map) {
            if (map != null && !map.isEmpty()) {
                if (this.headers == null) {
                    this.headers = new ArrayList();
                }
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    this.headers.add(new TTHeader(entry.getKey(), entry.getValue()));
                }
            }
            return this;
        }

        public Builder parameter(String str, String str2) {
            if (this.parms == null) {
                this.parms = new HashMap();
            }
            this.parms.put(str, str2);
            return this;
        }

        public Builder parameters(Map<String, String> map) {
            if (this.parms == null) {
                this.parms = map;
            } else if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    this.parms.put(entry.getKey(), entry.getValue());
                }
            }
            return this;
        }

        public Builder parameters(Map<String, String> map, Map<String, String> map2) {
            if (this.parms == null) {
                this.parms = new HashMap();
            }
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    this.parms.put(entry.getKey(), entry.getValue());
                }
            }
            if (map2 != null && !map2.isEmpty()) {
                for (String str : map2.keySet()) {
                    if (!TextUtils.isEmpty(str) && map2.get(str) != null) {
                        this.parms.put(str, map2.get(str));
                    }
                }
            }
            return this;
        }

        public Builder valueNullable(boolean z) {
            this.valueNullable = z;
            return this;
        }

        public Builder checkSupportMultiLogin() {
            if (this.parms == null) {
                this.parms = new HashMap();
            }
            if (TTAccountInit.getConfig().isSupportMultiLogin()) {
                this.parms.put("multi_login", "1");
            }
            return this;
        }

        public ApiRequest get() {
            this.method = "get";
            ApiRequest apiRequest = new ApiRequest(this.url, this.method, this.parms, this.headers);
            apiRequest.valueNullable = this.valueNullable;
            return apiRequest;
        }

        public ApiRequest post() {
            this.method = "post";
            ApiRequest apiRequest = new ApiRequest(this.url, this.method, this.parms, this.headers);
            apiRequest.valueNullable = this.valueNullable;
            return apiRequest;
        }

        public ApiRequest postFile() {
            this.method = ApiRequest.METHOD_POST_FILE;
            ApiRequest apiRequest = new ApiRequest(this.url, this.method, this.parms, this.headers, this.paramName, this.filePath);
            apiRequest.valueNullable = this.valueNullable;
            return apiRequest;
        }

        public ApiRequest build() {
            if (TextUtils.isEmpty(this.method)) {
                this.method = "get";
            }
            ApiRequest apiRequest = new ApiRequest(this.url, this.method, this.parms, this.headers, this.paramName, this.filePath);
            apiRequest.valueNullable = this.valueNullable;
            return apiRequest;
        }
    }
}
