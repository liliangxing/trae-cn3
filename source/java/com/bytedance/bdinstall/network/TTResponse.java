package com.bytedance.bdinstall.network;

import android.util.Pair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public class TTResponse {
    private final String body;
    private final List<Pair<String, String>> headers;
    private final int status;
    private final String url;

    public TTResponse(String str, int i, List<Pair<String, String>> list, String str2) {
        this.url = str;
        this.status = i;
        if (list == null) {
            this.headers = new ArrayList();
        } else {
            this.headers = Collections.unmodifiableList(new ArrayList(list));
        }
        this.body = str2;
    }

    public String getUrl() {
        return this.url;
    }

    public int getStatus() {
        return this.status;
    }

    public List<Pair<String, String>> getHeaders() {
        return this.headers;
    }

    public List<Pair<String, String>> headers(String str) {
        List<Pair<String, String>> list;
        ArrayList arrayList = null;
        if (str != null && (list = this.headers) != null) {
            for (Pair<String, String> pair : list) {
                if (str.equalsIgnoreCase((String) pair.first)) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(pair);
                }
            }
        }
        return arrayList;
    }

    public String getBody() {
        return this.body;
    }

    public boolean isSuccessful() {
        int i = this.status;
        return i >= 200 && i < 300;
    }

    public String toString() {
        return "DeviceResponse{\n body=" + this.body + "\n headers=" + this.headers + "\n code=" + this.status + "\n url='" + this.url + "'}";
    }
}
