package com.bytedance.push.frontier.setting;

import android.content.Context;
import android.os.Looper;
import com.bytedance.common.push.ThreadPlus;
import com.bytedance.push.frontier.interfaze.ISettingService;
import com.bytedance.push.frontier.interfaze.OnFrontierSettingUpdateListener;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class SettingService implements ISettingService {
    private UpdateSettingTask mUpdateSettingTask = new UpdateSettingTask();

    @Override // com.bytedance.push.frontier.interfaze.ISettingService
    public void getFrontierSetting(final Context context, final OnFrontierSettingUpdateListener onFrontierSettingUpdateListener) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            ThreadPlus.submitRunnable(new Runnable() { // from class: com.bytedance.push.frontier.setting.SettingService.1
                @Override // java.lang.Runnable
                public void run() {
                    SettingService.this.mUpdateSettingTask.runTasks(context, onFrontierSettingUpdateListener);
                }
            });
        } else {
            this.mUpdateSettingTask.runTasks(context, onFrontierSettingUpdateListener);
        }
    }
}
