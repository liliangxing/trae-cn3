package com.bytedance.apm.agent.instrumentation.okhttp3;

import android.text.TextUtils;
import com.bytedance.android.standard.tools.url.UrlUtils;
import com.bytedance.apm.agent.instrumentation.transaction.TxState;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class InterceptorImpl implements Interceptor {
    private static final String TAG = "InterceptorImpl";

    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        String header = request.header(UrlUtils.USER_AGENT);
        if (header != null && header.contains("tt")) {
            return chain.proceed(request);
        }
        TxState txState = new TxState();
        MonitorRecorder.recordRequest(request, txState);
        try {
            Response proceed = chain.proceed(request);
            MonitorRecorder.recordResponse(proceed, txState);
            if (txState.getReceivedBytes() < 0 && !TextUtils.isEmpty(proceed.header("Transfer-Encoding"))) {
                txState.addAssistData("Transfer-Encoding", proceed.header("Transfer-Encoding"));
                return proceed.newBuilder().body(new ResponseBodyWrapper(proceed, txState)).build();
            }
            MonitorRecorder.reportMonitorData(txState, proceed);
            return proceed;
        } catch (IOException e) {
            MonitorRecorder.reportExceptionMonitor(txState, e);
            throw e;
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    private class ResponseBodyWrapper extends ResponseBody {
        private BufferedSource bufferedSource;
        private final Response response;
        private final ResponseBody responseBody;
        private long totalBytesRead = 0;
        private final TxState transactionState;

        public ResponseBodyWrapper(Response response, TxState txState) {
            this.response = response;
            this.responseBody = response.body();
            this.transactionState = txState;
        }

        public MediaType contentType() {
            return this.responseBody.contentType();
        }

        public long contentLength() {
            return this.responseBody.contentLength();
        }

        public BufferedSource source() {
            if (this.bufferedSource == null) {
                this.bufferedSource = Okio.buffer(source(this.responseBody.source()));
            }
            return this.bufferedSource;
        }

        private Source source(Source source) {
            return new ForwardingSource(source) { // from class: com.bytedance.apm.agent.instrumentation.okhttp3.InterceptorImpl.ResponseBodyWrapper.1
                public long read(Buffer buffer, long j) throws IOException {
                    long read = super.read(buffer, j);
                    if (read >= 0) {
                        ResponseBodyWrapper.this.totalBytesRead += read;
                    }
                    return read;
                }

                public void close() throws IOException {
                    super.close();
                    ResponseBodyWrapper.this.end();
                }
            };
        }

        public void close() {
            this.responseBody.close();
            end();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void end() {
            if (this.transactionState.isComplete()) {
                return;
            }
            this.transactionState.setBytesReceived(this.totalBytesRead);
            MonitorRecorder.reportMonitorData(this.transactionState, this.response);
        }
    }
}
