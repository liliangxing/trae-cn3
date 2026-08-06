package com.bytedance.reparo.secondary;

import com.bytedance.reparo.core.PatchEventReporter;
import com.bytedance.reparo.core.common.event.Event;
import com.bytedance.reparo.core.common.event.EventSender;
import com.bytedance.reparo.core.common.utils.FileUtils;
import com.bytedance.reparo.core.exception.PatchException;
import com.bytedance.reparo.model.PatchFetchInfo;
import java.io.File;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class EventReporter {
    static final String STEP_DOWNLOAD = "patch_download";
    static final String STEP_QUERY_REMOTE_PATCH_INFO = "query_remote_patch_info";
    static final String STEP_SDK_INIT = "sdk_init";
    private static final EventSender eventSenderImpl = new EventSender() { // from class: com.bytedance.reparo.secondary.EventReporter.1
        @Override // com.bytedance.reparo.core.common.event.EventSender
        public void send(Event event) {
            if (EventReporter.impl != null) {
                EventReporter.impl.report(event);
            }
        }
    };
    private static EventReporterImpl impl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void init() {
        EventReporterImpl eventReporterImpl = new EventReporterImpl();
        impl = eventReporterImpl;
        PatchEventReporter.init(eventReporterImpl);
    }

    private static Event obtainSdkInitEvent(String str, boolean z) {
        Event sender = new Event().tag(str).step(STEP_SDK_INIT).sender(eventSenderImpl);
        if (z) {
            sender.eventType(0).isSuccess(true);
        } else {
            sender.eventType(2).isSuccess(false);
        }
        return sender;
    }

    private static Event obtainServerInterfaceRequestEvent(String str, boolean z) {
        Event sender = new Event().tag(str).step(STEP_QUERY_REMOTE_PATCH_INFO).sender(eventSenderImpl);
        if (z) {
            sender.eventType(0).isSuccess(true);
        } else {
            sender.eventType(2).isSuccess(false);
        }
        return sender;
    }

    private static Event obtainDownloadEvent(String str, PatchFetchInfo patchFetchInfo, boolean z) {
        Event sender = new Event().tag(str).step(STEP_DOWNLOAD).sender(eventSenderImpl);
        if (z) {
            sender.eventType(0).isSuccess(true);
        } else {
            sender.eventType(2).isSuccess(false);
        }
        sender.putCategory("patch_version", String.valueOf(patchFetchInfo.getVersionCode()));
        sender.putCategory("patch_id", String.valueOf(patchFetchInfo.getPatchId()));
        return sender;
    }

    public static void reportDownloadPatchSuccess(String str, PatchFetchInfo patchFetchInfo, File file, long j) {
        obtainDownloadEvent(str, patchFetchInfo, true).msg(String.format("download %s success.", patchFetchInfo.toString())).putMetrics("patch_size", Long.valueOf(FileUtils.sizeOf(file))).startTime(j).collectDuration().send();
    }

    public static void reportDownloadPatchFailed(String str, PatchFetchInfo patchFetchInfo, PatchException patchException, long j) {
        obtainDownloadEvent(str, patchFetchInfo, false).exception(patchException).startTime(j).send();
    }

    public static void reportQueryRemotePatchSuccess(String str, String str2, long j) {
        obtainServerInterfaceRequestEvent(str, true).msg(str2).startTime(j).collectDuration().send();
    }

    public static void reportQueryRemotePatchFailed(String str, PatchException patchException, long j) {
        obtainServerInterfaceRequestEvent(str, false).startTime(j).exception(patchException).send();
    }

    public static void reportSdkInitSuccessEvent(String str, long j) {
        obtainSdkInitEvent(str, true).startTime(j).collectDuration().send();
    }

    public static void reportSdkInitFailedEvent(String str, PatchException patchException, long j) {
        obtainSdkInitEvent(str, false).startTime(j).exception(patchException).send();
    }
}
