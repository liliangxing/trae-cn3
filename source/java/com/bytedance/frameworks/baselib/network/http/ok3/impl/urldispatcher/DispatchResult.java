package com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class DispatchResult {
    public String mDispatchedURL = "";
    public List<Long> mActionRuleIdList = new ArrayList();
    public List<DispatchActionInfo> mDispatchActionChain = new ArrayList();
    public int mDropCode = -555;
}
