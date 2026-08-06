package com.bytedance.sdk.account.api;

import android.content.ContentResolver;

/* loaded from: classes5.dex */
public interface IAccountShare {
    void queryShareAccount(String str, ContentResolver contentResolver, boolean z, OnShareAccountListener onShareAccountListener);

    void queryShareAccount(String str, OnShareAccountListener onShareAccountListener);

    void queryShareAccountData(String str, String str2, OnShareAccountListener onShareAccountListener);
}
