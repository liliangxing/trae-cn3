package com.ss.android.account.dbtring;

import android.content.Context;

/* loaded from: classes7.dex */
public interface IBdTruing {

    /* loaded from: classes7.dex */
    public interface IAccountBdTuringCallback {
        void onFail();

        void onSuccess();
    }

    boolean enableShowVersionCheckDialog();

    boolean forceDisable();

    boolean init(Context context);

    void showVerifyDialog(int i, String str, IAccountBdTuringCallback iAccountBdTuringCallback);
}
