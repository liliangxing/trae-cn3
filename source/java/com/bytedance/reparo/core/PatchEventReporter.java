package com.bytedance.reparo.core;

import com.bytedance.reparo.core.common.event.Event;
import com.bytedance.reparo.core.common.event.EventSender;
import com.bytedance.reparo.core.common.utils.StringUtils;
import com.bytedance.reparo.core.exception.PatchException;
import com.bytedance.reparo.core.exception.PatchInstallException;
import com.bytedance.reparo.core.parse.PatchRecordInfo;
import com.bytedance.reparo.core.parse.SoInfoParser;
import com.bytedance.reparo.core.patch.DurationMetric;
import com.bytedance.reparo.core.patch.Patch;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class PatchEventReporter {
    public static final String STEP_LOAD = "patch_load";
    public static final String STEP_LOAD_DURATION = "patch_load_duration";
    public static final String STEP_PATCH_INSTALL = "patch_install";
    public static final String STEP_PATCH_UPDATE = "patch_update";
    public static final String STEP_SO_MD5_CHECK = "so_md5_check";
    private static final String TAG = "PatchEventReporter";
    private static final EventSender eventSenderImpl = new EventSender() { // from class: com.bytedance.reparo.core.PatchEventReporter.1
        @Override // com.bytedance.reparo.core.common.event.EventSender
        public void send(Event event) {
            PatchEventReporter.report(event);
        }
    };
    private static IReporter reporter;
    private static final IReporter sDefault;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public interface IReporter {
        void report(Event event);
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public @interface InstallStatus {
        public static final int INSTALL_FAILED = 0;
        public static final int INSTALL_SUCCESS = 1;
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public @interface UpdateStatus {
        public static final int UPDATE_FAILED_INSTALL = 0;
        public static final int UPDATE_FAILED_PRELOAD = 1;
        public static final int UPDATE_SUCCESS = 2;
    }

    static {
        IReporter iReporter = new IReporter() { // from class: com.bytedance.reparo.core.PatchEventReporter.2
            @Override // com.bytedance.reparo.core.PatchEventReporter.IReporter
            public void report(Event event) {
                if (event.isSuccess()) {
                    PatchLogger.m305i(PatchEventReporter.TAG, event.toString());
                } else {
                    PatchLogger.m303e(PatchEventReporter.TAG, event.toString());
                }
            }
        };
        sDefault = iReporter;
        reporter = iReporter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void report(Event event) {
        reporter.report(event);
    }

    public static Event obtainInstallEvent(String str, PatchRecordInfo patchRecordInfo, int i) {
        Event sender = new Event().tag(str).step(STEP_PATCH_INSTALL).sender(eventSenderImpl);
        if (i == 0) {
            sender.eventType(2).isSuccess(false);
        } else {
            sender.eventType(0).isSuccess(true);
        }
        sender.putCategory("patch_version", StringUtils.notNull(patchRecordInfo.getPatchVersion()));
        sender.putCategory("patch_id", StringUtils.notNull(patchRecordInfo.getPatchId()));
        sender.putCategory("install_status", Integer.valueOf(i));
        return sender;
    }

    public static Event obtainUpdateEvent(String str, PatchRecordInfo patchRecordInfo, int i) {
        Event sender = new Event().tag(str).step(STEP_PATCH_UPDATE).sender(eventSenderImpl);
        if (i == 2) {
            sender.eventType(0).isSuccess(true);
        } else {
            sender.eventType(2).isSuccess(false);
        }
        sender.putCategory("patch_version", StringUtils.notNull(patchRecordInfo.getPatchVersion()));
        sender.putCategory("patch_id", StringUtils.notNull(patchRecordInfo.getPatchId()));
        sender.putCategory("update_status", Integer.valueOf(i));
        return sender;
    }

    public static Event obtainLoadEvent(String str, PatchRecordInfo patchRecordInfo, boolean z) {
        Event sender = new Event().tag(str).step(STEP_LOAD).sender(eventSenderImpl);
        if (z) {
            sender.eventType(0).isSuccess(true);
        } else {
            sender.eventType(2).isSuccess(false);
        }
        sender.putCategory("patch_version", StringUtils.notNull(patchRecordInfo.getPatchVersion()));
        sender.putCategory("patch_id", StringUtils.notNull(patchRecordInfo.getPatchId()));
        sender.putCategory("is_async", StringUtils.notNull(Boolean.valueOf(patchRecordInfo.isAsyncLoad())));
        return sender;
    }

    public static Event obtainLoadDurationEvent(String str, PatchRecordInfo patchRecordInfo, boolean z) {
        Event sender = new Event().tag(str).step(STEP_LOAD_DURATION).sender(eventSenderImpl);
        if (z) {
            sender.eventType(0).isSuccess(true);
        } else {
            sender.eventType(2).isSuccess(false);
        }
        sender.putCategory("patch_id", StringUtils.notNull(patchRecordInfo.getPatchId()));
        sender.putCategory("is_async", StringUtils.notNull(Boolean.valueOf(patchRecordInfo.isAsyncLoad())));
        return sender;
    }

    public static Event obtainSoMd5CheckEvent(String str, boolean z, List<SoInfoParser.SoInfo> list) {
        Event sender = new Event().tag(str).step(STEP_SO_MD5_CHECK).sender(eventSenderImpl);
        if (z) {
            sender.eventType(0).isSuccess(true);
        } else {
            sender.eventType(2).isSuccess(false);
        }
        sender.putMetrics("so_list_size", Integer.valueOf(list != null ? list.size() : 0));
        return sender;
    }

    public static void init(IReporter iReporter) {
        reporter = iReporter;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void reportInstallSuccess(Patch patch, long j) {
        obtainInstallEvent(TAG, patch.getRecordInfo(), 1).startTime(j).collectDuration().send();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void reportInstallFailed(PatchRecordInfo patchRecordInfo, PatchInstallException patchInstallException, long j) {
        obtainInstallEvent(TAG, patchRecordInfo, 0).startTime(j).exception(patchInstallException).send();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void reportUpdateSuccess(PatchRecordInfo patchRecordInfo, long j) {
        obtainUpdateEvent(TAG, patchRecordInfo, 2).startTime(j).collectDuration().send();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void reportUpdateFailed(PatchRecordInfo patchRecordInfo, PatchException patchException, int i, long j) {
        obtainUpdateEvent(TAG, patchRecordInfo, i).startTime(j).exception(patchException).send();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void reportPatchLoadSuccess(PatchRecordInfo patchRecordInfo, long j, DurationMetric durationMetric) {
        obtainLoadEvent(TAG, patchRecordInfo, true).startTime(j).collectDuration().send();
        durationMetric.putEvent(obtainLoadDurationEvent(TAG, patchRecordInfo, true)).send();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void reportPatchLoadFailed(PatchRecordInfo patchRecordInfo, PatchException patchException, long j) {
        obtainLoadEvent(TAG, patchRecordInfo, false).startTime(j).exception(patchException).send();
    }
}
