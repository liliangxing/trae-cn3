package com.bytedance.crash;

import android.app.ApplicationExitInfo;
import java.util.List;

/* loaded from: classes3.dex */
public interface IExitReasonListCallback {
    void findExitReasons(List<ApplicationExitInfo> list);
}
