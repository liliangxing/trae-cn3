package com.bytedance.reparo.model;

import java.util.List;

/* loaded from: classes4.dex */
public class Response {
    public PatchResponse data;
    public String message;

    /* loaded from: classes4.dex */
    public static class PatchResponse {
        public List<PatchFetchInfo> patch;
    }
}
