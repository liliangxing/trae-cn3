package com.bytedance.bdinstall.service;

import android.accounts.Account;

/* loaded from: classes3.dex */
public interface IInstallParameters {
    public static final String FAKE_ANDROID_ID = "9774d56d682e549c";

    void clearAll();

    String getClientUDID();

    String getDeviceId();

    String getOpenUdid(boolean z);

    void setAccount(Account account);

    void updateDeviceId(String str);
}
