package com.bytedance.sdk.open.aweme.core;

import java.util.List;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public interface OpenHostSettingService extends IOpenService {
    List<String> getExposeVids();

    JSONObject getSettingJson(String str);

    boolean setExposeVids(List<String> list);
}
