package com.bytedance.pia.core.bridge.methods;

import com.bytedance.pia.core.metrics.ErrorType;
import com.google.gson.annotations.SerializedName;

/* loaded from: classes4.dex */
public class WorkerOnError {
    public static final String NAME = "pia.internal.worker.onError";

    /* loaded from: classes4.dex */
    public static class Params {

        @SerializedName("error")
        private String error;

        @SerializedName(ErrorType.WORKER)
        private String worker;

        public Params(String str, String str2) {
            this.worker = str;
            this.error = str2;
        }
    }
}
