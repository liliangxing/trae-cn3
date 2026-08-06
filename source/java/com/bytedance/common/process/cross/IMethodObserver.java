package com.bytedance.common.process.cross;

import com.bytedance.common.model.ProcessEnum;
import java.util.List;

/* loaded from: classes3.dex */
public interface IMethodObserver {
    String getMethodName();

    String onMethodCall(ProcessEnum processEnum, List list);
}
