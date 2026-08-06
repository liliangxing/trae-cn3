package com.ss.android.pushmanager;

import android.util.Pair;
import com.ss.android.push.Triple;

/* loaded from: classes7.dex */
public interface KeyConfiguration {
    Pair<String, String> getMatrixPushConfig();

    Pair<String, String> getMiPushConfig();

    Pair<String, String> getMzPushConfig();

    Pair<String, String> getOpPushConfig();

    Triple<String, String, String> getUmPushConfig();
}
