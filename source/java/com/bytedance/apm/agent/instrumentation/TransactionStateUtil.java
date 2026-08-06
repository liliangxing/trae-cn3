package com.bytedance.apm.agent.instrumentation;

import com.bytedance.apm.agent.instrumentation.transaction.TxState;
import com.bytedance.apm.agent.logging.AgentLog;
import com.bytedance.apm.agent.logging.AgentLogManager;
import java.io.IOException;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLException;
import org.apache.http.conn.ConnectTimeoutException;

/* loaded from: classes3.dex */
public class TransactionStateUtil {
    private static final AgentLog log = AgentLogManager.getAgentLog();

    public static void inspectAndInstrument(TxState txState, HttpURLConnection httpURLConnection) {
        txState.setUrl(httpURLConnection.getURL().toString());
        txState.setStartTime(System.currentTimeMillis());
        txState.setCarrier("");
    }

    public static void inspectAndInstrumentResponse(TxState txState, HttpURLConnection httpURLConnection) {
        int i;
        int contentLength = httpURLConnection.getContentLength();
        if (contentLength >= 0) {
            txState.setBytesReceived(contentLength);
        }
        try {
            i = httpURLConnection.getResponseCode();
        } catch (IOException | NullPointerException unused) {
            i = 0;
        }
        txState.setStatusCode(i);
    }

    public static void setErrorCodeFromException(TxState txState, Exception exc) {
        if (exc instanceof UnknownHostException) {
            txState.setErrorCode(-10);
            return;
        }
        if ((exc instanceof SocketTimeoutException) || (exc instanceof ConnectTimeoutException)) {
            txState.setErrorCode(-11);
            return;
        }
        if (exc instanceof ConnectException) {
            txState.setErrorCode(-12);
            return;
        }
        if (exc instanceof MalformedURLException) {
            txState.setErrorCode(-13);
        } else if (exc instanceof SSLException) {
            txState.setErrorCode(-14);
        } else {
            txState.setErrorCode(-1);
        }
    }
}
