package com.ttnet.org.chromium.net.urlconnection;

import java.io.IOException;

/* loaded from: classes7.dex */
public class TTRequestCanceledException extends IOException {
    public int getCronetInternalErrorCode() {
        return -999;
    }

    public TTRequestCanceledException(String str) {
        super(str);
    }
}
