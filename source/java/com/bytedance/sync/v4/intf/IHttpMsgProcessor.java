package com.bytedance.sync.v4.intf;

import com.bytedance.retrofit2.SsResponse;
import java.util.Map;

/* loaded from: classes5.dex */
public interface IHttpMsgProcessor {
    String process(SsResponse ssResponse);

    String process(Map<String, String> map, String str);
}
