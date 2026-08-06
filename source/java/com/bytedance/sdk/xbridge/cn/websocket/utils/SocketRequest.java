package com.bytedance.sdk.xbridge.cn.websocket.utils;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: SocketRequest.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0007"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/websocket/utils/SocketRequest;", "", "()V", "Callback", "OperateTask", "RequestState", "RequestTask", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public final class SocketRequest {

    /* compiled from: SocketRequest.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/websocket/utils/SocketRequest$Callback;", "", "onStateChanged", "", "requestState", "Lcom/bytedance/sdk/xbridge/cn/websocket/utils/SocketRequest$RequestState;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes5.dex */
    public interface Callback {
        void onStateChanged(RequestState requestState);
    }

    /* compiled from: SocketRequest.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/websocket/utils/SocketRequest$OperateTask;", "", "()V", "Callback", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class OperateTask {

        /* compiled from: SocketRequest.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/websocket/utils/SocketRequest$OperateTask$Callback;", "", "onOperateFail", "", "reason", "", "onOperateSuccess", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
        /* loaded from: classes5.dex */
        public interface Callback {
            void onOperateFail(String reason);

            void onOperateSuccess();
        }
    }

    /* compiled from: SocketRequest.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0007HÆ\u0003J+\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/websocket/utils/SocketRequest$RequestTask;", "", "url", "", "header", "Lorg/json/JSONObject;", "protocols", "Lorg/json/JSONArray;", "(Ljava/lang/String;Lorg/json/JSONObject;Lorg/json/JSONArray;)V", "component1", "component2", "component3", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class RequestTask {
        public final JSONObject header;
        public final JSONArray protocols;
        public final String url;

        public static /* synthetic */ RequestTask copy$default(RequestTask requestTask, String str, JSONObject jSONObject, JSONArray jSONArray, int i, Object obj) {
            if ((i & 1) != 0) {
                str = requestTask.url;
            }
            if ((i & 2) != 0) {
                jSONObject = requestTask.header;
            }
            if ((i & 4) != 0) {
                jSONArray = requestTask.protocols;
            }
            return requestTask.copy(str, jSONObject, jSONArray);
        }

        /* renamed from: component1, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        /* renamed from: component2, reason: from getter */
        public final JSONObject getHeader() {
            return this.header;
        }

        /* renamed from: component3, reason: from getter */
        public final JSONArray getProtocols() {
            return this.protocols;
        }

        public final RequestTask copy(String url, JSONObject header, JSONArray protocols) {
            Intrinsics.checkNotNullParameter(url, "url");
            return new RequestTask(url, header, protocols);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RequestTask)) {
                return false;
            }
            RequestTask requestTask = (RequestTask) other;
            return Intrinsics.areEqual(this.url, requestTask.url) && Intrinsics.areEqual(this.header, requestTask.header) && Intrinsics.areEqual(this.protocols, requestTask.protocols);
        }

        public int hashCode() {
            int hashCode = this.url.hashCode() * 31;
            JSONObject jSONObject = this.header;
            int hashCode2 = (hashCode + (jSONObject == null ? 0 : jSONObject.hashCode())) * 31;
            JSONArray jSONArray = this.protocols;
            return hashCode2 + (jSONArray != null ? jSONArray.hashCode() : 0);
        }

        public String toString() {
            return "RequestTask(url=" + this.url + ", header=" + this.header + ", protocols=" + this.protocols + ')';
        }

        public RequestTask(String url, JSONObject jSONObject, JSONArray jSONArray) {
            Intrinsics.checkNotNullParameter(url, "url");
            this.url = url;
            this.header = jSONObject;
            this.protocols = jSONArray;
        }
    }

    /* compiled from: SocketRequest.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u000bB;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\nR\u0012\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/websocket/utils/SocketRequest$RequestState;", "", "status", "", "socketTaskID", "message", "textData", "byteData", "", "dataType", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[BLjava/lang/String;)V", "Builder", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class RequestState {
        public final byte[] byteData;
        public final String dataType;
        public final String message;
        public final String socketTaskID;
        public final String status;
        public final String textData;

        public RequestState(String status, String socketTaskID, String message, String str, byte[] bArr, String str2) {
            Intrinsics.checkNotNullParameter(status, "status");
            Intrinsics.checkNotNullParameter(socketTaskID, "socketTaskID");
            Intrinsics.checkNotNullParameter(message, "message");
            this.status = status;
            this.socketTaskID = socketTaskID;
            this.message = message;
            this.textData = str;
            this.byteData = bArr;
            this.dataType = str2;
        }

        /* compiled from: SocketRequest.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u0010\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0003J\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0003J\u0010\u0010\u0013\u001a\u00020\u00002\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/websocket/utils/SocketRequest$RequestState$Builder;", "", "status", "", "socketTaskID", "(Ljava/lang/String;Ljava/lang/String;)V", "byteData", "", "dataType", "message", "getSocketTaskID", "()Ljava/lang/String;", "getStatus", "textData", "build", "Lcom/bytedance/sdk/xbridge/cn/websocket/utils/SocketRequest$RequestState;", "setByteData", "setDataType", "setMessage", "setTextData", "text", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class Builder {
            private byte[] byteData;
            private String dataType;
            private String message;
            private final String socketTaskID;
            private final String status;
            private String textData;

            public Builder(String status, String socketTaskID) {
                Intrinsics.checkNotNullParameter(status, "status");
                Intrinsics.checkNotNullParameter(socketTaskID, "socketTaskID");
                this.status = status;
                this.socketTaskID = socketTaskID;
                this.message = "unknow error";
            }

            public final String getSocketTaskID() {
                return this.socketTaskID;
            }

            public final String getStatus() {
                return this.status;
            }

            public final Builder setMessage(String message) {
                Intrinsics.checkNotNullParameter(message, "message");
                this.message = message;
                return this;
            }

            public final Builder setTextData(String text) {
                this.textData = text;
                return this;
            }

            public final Builder setByteData(byte[] byteData) {
                this.byteData = byteData;
                return this;
            }

            public final Builder setDataType(String dataType) {
                Intrinsics.checkNotNullParameter(dataType, "dataType");
                this.dataType = dataType;
                return this;
            }

            public final RequestState build() {
                return new RequestState(this.status, this.socketTaskID, this.message, this.textData, this.byteData, this.dataType);
            }
        }
    }
}
