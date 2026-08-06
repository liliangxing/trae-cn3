package com.ss.android;

import android.content.Context;
import com.bytedance.sdk.account.INetWork;
import com.bytedance.sdk.account.utils.IMonitor;
import com.ss.android.account.dbtring.IBdTruing;
import com.ss.android.account.sec.IAccountSec;

/* loaded from: classes7.dex */
public interface TTAccountConfig {
    Context getApplicationContext();

    IBdTruing getIBdTruing();

    IAccountSec getISec();

    IMonitor getMonitor();

    INetWork getNetwork();

    String host();

    boolean isLocalTest();

    boolean isSaveLoginInfo();

    @Deprecated
    boolean isSecureCaptchaEnabled();

    boolean isSupportMultiLogin();
}
