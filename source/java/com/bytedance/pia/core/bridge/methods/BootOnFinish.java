package com.bytedance.pia.core.bridge.methods;

import com.google.gson.JsonArray;
import com.google.gson.annotations.SerializedName;

/* loaded from: classes4.dex */
public class BootOnFinish {
    public static final String NAME = "pia.internal.boot.onFinish";

    /* loaded from: classes4.dex */
    public static class Result {

        @SerializedName("results")
        JsonArray results;

        public Result(JsonArray jsonArray) {
            this.results = jsonArray;
        }
    }
}
