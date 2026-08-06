package com.bytedance.push.settings.signal.sync;

import com.bytedance.push.settings.IDefaultValueProvider;
import com.bytedance.push.settings.ITypeConverter;
import com.bytedance.push.utils.GsonUtils;

/* loaded from: classes4.dex */
public class SignalReportHistoryConverter implements ITypeConverter<SignalReportHistory>, IDefaultValueProvider<SignalReportHistory> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.push.settings.IDefaultValueProvider
    public SignalReportHistory create() {
        return new SignalReportHistory();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.push.settings.ITypeConverter
    public SignalReportHistory to(String str) {
        return (SignalReportHistory) GsonUtils.from(str, SignalReportHistory.class);
    }

    @Override // com.bytedance.push.settings.ITypeConverter
    public String from(SignalReportHistory signalReportHistory) {
        return GsonUtils.toJson(signalReportHistory);
    }
}
