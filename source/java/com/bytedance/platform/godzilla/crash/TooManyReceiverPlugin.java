package com.bytedance.platform.godzilla.crash;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

@Deprecated
/* loaded from: classes4.dex */
public final class TooManyReceiverPlugin {
    public static int getErrorStat() {
        return -1;
    }

    public static Intent registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, Context context) {
        return null;
    }

    private TooManyReceiverPlugin() {
    }
}
