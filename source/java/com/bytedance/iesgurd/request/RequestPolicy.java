package com.bytedance.iesgurd.request;

import kotlin.Metadata;

/* compiled from: RequestPolicy.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&¨\u0006\u0006"}, d2 = {"Lcom/bytedance/iesgurd/request/RequestPolicy;", "", "prepareRequest", "", "requestFail", "requestSuccess", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes4.dex */
public interface RequestPolicy {
    void prepareRequest() throws Exception;

    void requestFail();

    void requestSuccess();
}
