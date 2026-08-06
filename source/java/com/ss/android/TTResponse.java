package com.ss.android;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes7.dex */
public final class TTResponse {
    private final String body;
    private Object extraInfo;
    private final List<TTHeader> headers;
    private final int status;
    private TTRequest ttRequest;
    private final String url;

    public TTResponse(String str, int i, List<TTHeader> list, String str2) {
        this.url = str;
        this.status = i;
        this.headers = Collections.unmodifiableList(new ArrayList(list));
        this.body = str2;
    }

    public String getUrl() {
        return this.url;
    }

    public int getStatus() {
        return this.status;
    }

    public List<TTHeader> getHeaders() {
        return this.headers;
    }

    public List<TTHeader> headers(String str) {
        List<TTHeader> list;
        ArrayList arrayList = null;
        if (str != null && (list = this.headers) != null) {
            for (TTHeader tTHeader : list) {
                if (str.equalsIgnoreCase(tTHeader.getName())) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(tTHeader);
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

    public void setExtraInfo(Object obj) {
        this.extraInfo = obj;
    }

    public Object getExtraInfo() {
        return this.extraInfo;
    }

    public TTRequest getTtRequest() {
        return this.ttRequest;
    }

    public void setTtRequest(TTRequest tTRequest) {
        this.ttRequest = tTRequest;
    }
}
