package com.bytedance.reparo.secondary;

import com.bytedance.reparo.Reparo;
import com.bytedance.reparo.core.PatchEventReporter;
import com.bytedance.reparo.core.common.event.Event;
import com.bytedance.reparo.core.utils.ExecutorServiceUtils;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class EventReporterImpl implements PatchEventReporter.IReporter {
    private static final String TAG = "EventReporterImpl";

    @Override // com.bytedance.reparo.core.PatchEventReporter.IReporter
    public void report(final Event event) {
        ExecutorServiceUtils.getReparoCoreExecutorService().execute(new Runnable() { // from class: com.bytedance.reparo.secondary.EventReporterImpl.1
            @Override // java.lang.Runnable
            public void run() {
                if (Reparo.getInstance().getEventReporter() != null) {
                    Reparo.getInstance().getEventReporter().report(event);
                }
                MonitorService.report(event);
                AppMonitorService.report(event);
            }
        });
        if (PatchEventReporter.STEP_LOAD.equals(event.getStep())) {
            NpthService.updatePatchId(String.valueOf(event.getCategoryMap().get("patch_id")));
        }
    }
}
