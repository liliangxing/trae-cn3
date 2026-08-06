package com.bytedance.android.monitor.base;

import com.bytedance.android.monitor.entity.NativeCommon;

/* loaded from: classes3.dex */
public abstract class BaseReportData implements IReportData {
    @Override // com.bytedance.android.monitor.base.IReportData
    public abstract NativeCommon getNativeBase();

    @Override // com.bytedance.android.monitor.base.IReportData
    public abstract BaseNativeInfo getNativeInfo();
}
