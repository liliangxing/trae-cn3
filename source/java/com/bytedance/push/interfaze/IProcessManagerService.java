package com.bytedance.push.interfaze;

import android.content.Context;
import com.bytedance.common.model.ProcessEnum;
import java.util.List;

/* loaded from: classes4.dex */
public interface IProcessManagerService {
    boolean allowStartNonMainProcess();

    void allowStartNonMainProcessCallback(boolean z, long j);

    boolean curIsWorkerProcess(Context context);

    int getDelayStartChildProcessMode();

    ProcessEnum getWorkerProcessEnum(Context context);

    List<Integer> needDisableChannelWhenStrictMode();

    void onMainProcessStart(Context context);

    void onProcessInit(Context context);

    boolean settingsAllowStartNonMainProcess();

    void startNonMainProcess();
}
