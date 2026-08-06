package com.bytedance.pia.core.bridge.methods;

import com.bytedance.pia.core.metrics.ErrorType;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

/* loaded from: classes4.dex */
public class WorkerOnMessage {
    public static final String NAME = "pia.internal.worker.onMessage";

    /* loaded from: classes4.dex */
    public static class Params {

        @SerializedName("message")
        private JsonObject message;

        @SerializedName(ErrorType.WORKER)
        private String worker;

        public Params(String str, JsonObject jsonObject) {
            this.worker = str;
            this.message = jsonObject;
        }
    }
}
