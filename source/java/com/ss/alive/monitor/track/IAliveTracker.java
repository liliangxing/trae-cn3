package com.ss.alive.monitor.track;

import android.content.Context;
import com.ss.alive.monitor.PkgTrackListener;
import com.ss.alive.monitor.ProcessStartInfo;

/* loaded from: classes7.dex */
public interface IAliveTracker {
    void trackPackageName(Context context, ProcessStartInfo processStartInfo, PkgTrackListener pkgTrackListener);
}
