package com.bytedance.push.event.sync;

import android.app.Activity;

/* loaded from: classes4.dex */
public interface IUserExitsSignalInfoProvider {
    HostUserExitsSignalInfo getHostUserExitsSignalInfo(Activity activity, UserExitsReason userExitsReason);
}
