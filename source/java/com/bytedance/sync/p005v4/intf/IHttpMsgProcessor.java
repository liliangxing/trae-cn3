package com.bytedance.sync.p005v4.intf;

import com.bytedance.retrofit2.SsResponse;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public interface IHttpMsgProcessor {
    String process(SsResponse ssResponse);

    String process(Map<String, String> map, String str);
}
