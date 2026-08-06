package com.bytedance.sdk.open.aweme.core.net;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class OpenNetHeaders {
    public static final OpenNetHeaders empty = new Builder().build();
    private List<Header> headers;

    /* loaded from: classes5.dex */
    public static class Builder {
        private List<Header> headers;

        public Builder() {
            this.headers = new ArrayList();
        }

        public Builder(OpenNetHeaders openNetHeaders) {
            this.headers = openNetHeaders.headers;
        }

        public Builder addHeader(String str, String str2) {
            this.headers.add(new Header(str, str2));
            return this;
        }

        public Builder addHeader(Map<String, String> map) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                addHeader(entry.getKey(), entry.getValue());
            }
            return this;
        }

        public Builder addHeaderIfNotNull(String str, String str2) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                this.headers.add(new Header(str, str2));
            }
            return this;
        }

        public OpenNetHeaders build() {
            return new OpenNetHeaders(this.headers);
        }

        public List<String> getHeader(String str) {
            ArrayList arrayList = new ArrayList();
            for (Header header : this.headers) {
                if (TextUtils.equals(header.getName().toLowerCase(), str.toLowerCase())) {
                    arrayList.add(header.value);
                }
            }
            return arrayList;
        }

        public Builder removeHeader(String str) {
            Iterator<Header> it = this.headers.iterator();
            while (it.hasNext()) {
                if (TextUtils.equals(it.next().name.toLowerCase(), str.toLowerCase())) {
                    it.remove();
                }
            }
            return this;
        }

        public Builder replaceHeader(String str, String str2) {
            removeHeader(str);
            addHeader(str, str2);
            return this;
        }

        public Builder setHeaders(List<Header> list) {
            if (list == null) {
                return this;
            }
            this.headers.clear();
            this.headers.addAll(list);
            return this;
        }

        public Builder setHeaders(Map<String, String> map) {
            if (map == null) {
                return this;
            }
            this.headers.clear();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                addHeader(entry.getKey(), entry.getValue());
            }
            return this;
        }

        public Builder setHeaders(JSONObject jSONObject) {
            if (jSONObject == null) {
                return this;
            }
            this.headers.clear();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                this.headers.add(new Header(next, jSONObject.optString(next)));
            }
            return this;
        }
    }

    /* loaded from: classes5.dex */
    public static class Header {
        private String name;
        private String value;

        public Header(String str, String str2) {
            this.name = str;
            this.value = str2;
        }

        public String getName() {
            return this.name;
        }

        public String getValue() {
            return this.value;
        }
    }

    public OpenNetHeaders(List<Header> list) {
        this.headers = list;
    }

    public String firstHeaderString(String str) {
        for (Header header : this.headers) {
            if (TextUtils.equals(header.getName().toLowerCase(), str.toLowerCase())) {
                return header.getValue();
            }
        }
        return null;
    }

    public long getContentLength() {
        try {
            return Long.parseLong(firstHeaderString("Content-Length"));
        } catch (Exception unused) {
            return -1L;
        }
    }

    public List<String> getCookies() {
        ArrayList arrayList = new ArrayList();
        for (Header header : this.headers) {
            if (TextUtils.equals(header.getName().toLowerCase(), "Cookies".toLowerCase())) {
                arrayList.add(header.getValue());
            }
        }
        return arrayList;
    }

    public List<Header> getHeaderList() {
        return this.headers;
    }

    public String getHeaderString(String str) {
        StringBuilder sb = new StringBuilder();
        for (Header header : this.headers) {
            if (TextUtils.equals(header.getName().toLowerCase(), str.toLowerCase())) {
                sb.append(header.getValue());
                sb.append(",");
            }
        }
        if (sb.length() > 1) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    public String getLogId() {
        return firstHeaderString("x-tt-logid");
    }

    public boolean isExist(String str) {
        Iterator<Header> it = this.headers.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(it.next().getName().toLowerCase(), str.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    public int size() {
        return this.headers.size();
    }

    public JSONObject toJson(boolean z) {
        JSONObject jSONObject = new JSONObject();
        for (Header header : this.headers) {
            try {
                String lowerCase = header.name.toLowerCase(Locale.getDefault());
                String optString = jSONObject.optString(lowerCase);
                jSONObject.put(lowerCase, (!z || TextUtils.isEmpty(optString)) ? header.value : optString + "," + header.value);
            } catch (Throwable unused) {
            }
        }
        return jSONObject;
    }

    public String toString() {
        return this.headers.toString();
    }
}
