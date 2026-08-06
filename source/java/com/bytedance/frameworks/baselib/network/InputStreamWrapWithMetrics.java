package com.bytedance.frameworks.baselib.network;

import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.frameworks.baselib.network.http.InputStreamWrap;
import com.bytedance.retrofit2.client.SsCall;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class InputStreamWrapWithMetrics extends InputStreamWrap {
    private BaseHttpRequestInfo requestInfo;

    public InputStreamWrapWithMetrics(InputStream inputStream, SsCall ssCall, BaseHttpRequestInfo baseHttpRequestInfo) {
        super(inputStream, ssCall);
        this.requestInfo = baseHttpRequestInfo;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.InputStreamWrap, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        if (this.requestInfo.metrics != null) {
            this.requestInfo.metrics.readResponseBodyStart();
        }
        try {
            return super.read(bArr);
        } finally {
            if (this.requestInfo.metrics != null) {
                this.requestInfo.metrics.readResponseBodyEnd();
            }
        }
    }

    @Override // com.bytedance.frameworks.baselib.network.http.InputStreamWrap, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.requestInfo.metrics != null) {
            this.requestInfo.metrics.readResponseBodyStart();
        }
        try {
            return super.read(bArr, i, i2);
        } finally {
            if (this.requestInfo.metrics != null) {
                this.requestInfo.metrics.readResponseBodyEnd();
            }
        }
    }

    @Override // com.bytedance.frameworks.baselib.network.http.InputStreamWrap, java.io.InputStream
    public int read() throws IOException {
        if (this.requestInfo.metrics != null) {
            this.requestInfo.metrics.readResponseBodyStart();
        }
        try {
            return super.read();
        } finally {
            if (this.requestInfo.metrics != null) {
                this.requestInfo.metrics.readResponseBodyEnd();
            }
        }
    }
}
