package com.ss.android;

import java.util.List;

/* loaded from: classes7.dex */
public class TTRequest {
    public final List<TTHeader> headers;
    public final int maxLength;
    public final String url;

    public TTRequest(int i, String str, List<TTHeader> list) {
        this.maxLength = i;
        this.url = str;
        this.headers = list;
    }
}
