package com.bytedance.push.event.sync;

/* loaded from: classes4.dex */
public interface ISignalReportApi {
    void setBusinessExtraInfoProvider(String str, IBusinessExtraInfoProvider iBusinessExtraInfoProvider);

    void setUserExitsSignalInfoProvider(IUserExitsSignalInfoProvider iUserExitsSignalInfoProvider);
}
