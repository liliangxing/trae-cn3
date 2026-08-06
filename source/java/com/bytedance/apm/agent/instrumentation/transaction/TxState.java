package com.bytedance.apm.agent.instrumentation.transaction;

import com.bytedance.apm.agent.logging.AgentLog;
import com.bytedance.apm.agent.logging.AgentLogManager;
import com.bytedance.apm.util.UrlUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class TxState {
    private static final AgentLog LOG = AgentLogManager.getAgentLog();
    private long bytesReceived;
    private long bytesSent;
    private long endTime;
    private int errorCode;
    private String httpMethod;
    private String rawUrl;
    private long startTime;
    private int statusCode;
    private TransactionData transactionData;
    private String url;
    private String carrier = "unknown";
    private String wanType = "unknown";
    private State state = State.READY;
    private JSONObject extraData = new JSONObject();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public enum State {
        READY,
        SENT,
        COMPLETE
    }

    public long getStartTime() {
        return this.startTime;
    }

    public void setStartTime(long j) {
        this.startTime = j;
    }

    public void setUrl(String str) {
        if (this.rawUrl == null) {
            this.rawUrl = str;
        }
        String sanitizeUrl = UrlUtils.sanitizeUrl(str);
        if (sanitizeUrl == null) {
            return;
        }
        if (!isSent()) {
            this.url = sanitizeUrl;
        } else {
            LOG.warning("setUrl(...) called on TransactionState in " + this.state.toString() + " state");
        }
    }

    public String getUrl() {
        return this.url;
    }

    public void setCarrier(String str) {
        if (!isSent()) {
            this.carrier = str;
        } else {
            LOG.warning("setCarrier(...) called on TransactionState in " + this.state.toString() + " state");
        }
    }

    public void setMethod(String str) {
        if (!isSent()) {
            this.httpMethod = str;
        } else {
            LOG.warning("setHttpMethod(...) called on TransactionState in " + this.state.toString() + " state");
        }
    }

    public void setWanType(String str) {
        if (!isSent()) {
            this.wanType = str;
        } else {
            LOG.warning("setWanType(...) called on TransactionState in " + this.state.toString() + " state");
        }
    }

    public void addAssistData(String str, String str2) {
        if (isComplete()) {
            LOG.warning("addAssistData(...) called on TransactionState in " + this.state.toString() + " state");
        }
        try {
            this.extraData.put(str, str2);
        } catch (JSONException e) {
            LOG.error("Caught error while addAssistData: ", e);
        }
    }

    public boolean isSent() {
        return this.state.ordinal() >= State.SENT.ordinal();
    }

    public boolean isComplete() {
        return this.state.ordinal() >= State.COMPLETE.ordinal();
    }

    public void setStatusCode(int i) {
        if (!isComplete()) {
            this.statusCode = i;
            return;
        }
        if (this.statusCode == 0 && i != 0) {
            this.statusCode = i;
        }
        LOG.warning("setStatusCode(...) called on TransactionState in " + this.state.toString() + " state");
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public void setErrorCode(int i) {
        if (!isComplete()) {
            this.errorCode = i;
            return;
        }
        TransactionData transactionData = this.transactionData;
        if (transactionData != null) {
            transactionData.setErrorCode(i);
        }
        LOG.warning("setErrorCode(...) called on TransactionState in " + this.state.toString() + " state");
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public void setBytesSent(long j) {
        if (!isComplete()) {
            this.bytesSent = j;
            this.state = State.SENT;
        } else {
            LOG.warning("setBytesSent(...) called on TransactionState in " + this.state.toString() + " state");
        }
    }

    public void setBytesReceived(long j) {
        if (!isComplete()) {
            this.bytesReceived = j;
        } else {
            LOG.warning("setBytesReceived(...) called on TransactionState in " + this.state.toString() + " state");
        }
    }

    public long getReceivedBytes() {
        return this.bytesReceived;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(" StartTime ");
        sb.append(String.valueOf(this.startTime)).append(" BytesReceived ").append(String.valueOf(this.bytesReceived)).append(" BytesSent ").append(String.valueOf(this.bytesSent)).append(" Url ").append(this.url);
        return sb.toString();
    }

    public TransactionData end() {
        addAssistData("startTime", this.startTime + "");
        if (!isComplete()) {
            this.state = State.COMPLETE;
            this.endTime = System.currentTimeMillis();
        }
        return toTransactionData();
    }

    private TransactionData toTransactionData() {
        if (!isComplete()) {
            LOG.warning("toTransactionData() called on incomplete TransactionState");
        }
        if (this.url == null) {
            LOG.error("Attempted to convert TransactionData TransactionState instance with no URL into TransactionData TransactionData");
            return null;
        }
        if (this.transactionData == null) {
            TransactionData transactionData = new TransactionData(this.url, this.carrier, this.endTime - this.startTime, this.statusCode, this.errorCode, this.bytesSent, this.bytesReceived, this.wanType, this.httpMethod, this.extraData);
            this.transactionData = transactionData;
            transactionData.setRequestEnd(this.endTime);
            this.transactionData.setErrorCode(this.errorCode);
        }
        return this.transactionData;
    }
}
