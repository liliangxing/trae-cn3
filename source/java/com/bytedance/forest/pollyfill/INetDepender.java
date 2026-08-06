package com.bytedance.forest.pollyfill;

import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.bytedance.forest.model.Response;
import kotlin.Metadata;

/* compiled from: CDNFetchDepender.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, d2 = {"Lcom/bytedance/forest/pollyfill/INetDepender;", "", "cancel", "", "fetchTask", "Lcom/bytedance/forest/pollyfill/FetchTask;", "fetchFile", ApmTrafficStats.TTNET_RESPONSE, "Lcom/bytedance/forest/model/Response;", "onlyLocal", "", "forest_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public interface INetDepender {
    void cancel(FetchTask fetchTask);

    void fetchFile(Response response, FetchTask fetchTask, boolean onlyLocal);
}
