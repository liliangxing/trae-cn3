package com.bytedance.frameworks.baselib.network.http.ok3.impl.metadispatch;

import com.bytedance.frameworks.baselib.network.config.hostpathmatch.TTHostPathValueBase;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public class TTMetaDispatchValue extends TTHostPathValueBase {
    public Map<String, String> headerAddMap;
    public Set<String> headerRmSet;
    public Map<String, String> queryAddMap;
    public Set<String> queryRmSet;
}
