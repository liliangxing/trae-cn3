package com.bytedance.trae.init.task.base;

import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.bytedance.trae.apm.api.IApmTrace;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.init.task.FirstFrameSchedulerExecutors;
import com.bytedance.trae.utils.logger.FLogger;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: TaskDurationCollector.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010#\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001-B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J0\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u00052\u0006\u0010#\u001a\u00020\u000eJ\u0012\u0010$\u001a\u00020\u001d2\b\u0010\"\u001a\u0004\u0018\u00010\u0005H\u0002J\u0006\u0010%\u001a\u00020\u001dJ$\u0010&\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020\u00052\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000e0\rH\u0002J\u000e\u0010)\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020\u0019J\u000e\u0010*\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\u0019J\u0010\u0010+\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020\u000eH\u0002J\u0006\u0010\u001a\u001a\u00020\u0019J\u0006\u0010\u001b\u001a\u00020\u0019J\b\u0010,\u001a\u00020\u001dH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/bytedance/trae/init/task/base/TaskDurationCollector;", "", "<init>", "()V", "TAG", "", "REPORT_TASK_KEY", "TOTAL_APP_INIT_DURATION_DIFFERENTIATED_SERVICES", "FIRST_FRAME_APP_INIT_DURATION_DIFFERENTIATED_SERVICES", "FEED_SHOW_APP_INIT_DURATION_DIFFERENTIATED_SERVICES", "OTHER_APP_INIT_DURATION_DIFFERENTIATED_SERVICES", "APP_INIT_DURATION_DIFFERENTIATED_SERVICES_ERROR", "firstFramedDurationsByScene", "", "", "firstFeedDurationsByScene", "otherDurationsByScene", "totalInitDurationsByScene", "addedTaskNames", "", "MAX_DURATION", "", "FIRST_FRAME_REPORT_DELAY_DURATION", "FIRST_FEED_REPORT_DELAY_DURATION", "alreadyReported", "", "isFirstFrame", "isFirstFeedShow", "addTaskDuration", "", "scene", "isMainThread", "stage", "Lcom/bytedance/trae/init/task/base/TaskDurationCollector$AppInitStage;", "taskName", ReportConstant.COMMON_INIT_DURATION, "reportTaskInfoError", "reportAndClearDurations", "reportData", "key", "mutableMap", "setIsFirstFrame", "setIsFirstFeedShow", "startReportingTimer", "clearData", "AppInitStage", "app_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TaskDurationCollector {
    public static final int $stable;
    private static final String APP_INIT_DURATION_DIFFERENTIATED_SERVICES_ERROR = "app_init_duration_differentiated_services_error";
    private static final String FEED_SHOW_APP_INIT_DURATION_DIFFERENTIATED_SERVICES = "feed_show_init_duration_differentiated_services";
    private static final long FIRST_FEED_REPORT_DELAY_DURATION = 10000;
    private static final String FIRST_FRAME_APP_INIT_DURATION_DIFFERENTIATED_SERVICES = "first_frame_init_duration_differentiated_services";
    private static final long FIRST_FRAME_REPORT_DELAY_DURATION = 20000;
    private static final int MAX_DURATION = 20000;
    private static final String OTHER_APP_INIT_DURATION_DIFFERENTIATED_SERVICES = "other_app_init_duration_differentiated_services";
    private static final String REPORT_TASK_KEY = "task";
    private static final String TAG = "TaskDurationCollector";
    private static final String TOTAL_APP_INIT_DURATION_DIFFERENTIATED_SERVICES = "total_app_init_duration_differentiated_services";
    private static final Set<String> addedTaskNames;
    private static volatile boolean alreadyReported;
    private static volatile boolean isFirstFeedShow;
    private static volatile boolean isFirstFrame;
    public static final TaskDurationCollector INSTANCE = new TaskDurationCollector();
    private static final Map<String, Long> firstFramedDurationsByScene = new ConcurrentHashMap();
    private static final Map<String, Long> firstFeedDurationsByScene = new ConcurrentHashMap();
    private static final Map<String, Long> otherDurationsByScene = new ConcurrentHashMap();
    private static final Map<String, Long> totalInitDurationsByScene = new ConcurrentHashMap();

    /* compiled from: TaskDurationCollector.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AppInitStage.values().length];
            try {
                iArr[AppInitStage.FIRST_FRAME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AppInitStage.FIRST_FEED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AppInitStage.OTHER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AppInitStage.DEFAULT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private TaskDurationCollector() {
    }

    static {
        Set<String> synchronizedSet = Collections.synchronizedSet(new HashSet());
        Intrinsics.checkNotNullExpressionValue(synchronizedSet, "synchronizedSet(...)");
        addedTaskNames = synchronizedSet;
        $stable = 8;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: TaskDurationCollector.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/init/task/base/TaskDurationCollector$AppInitStage;", "", "stage", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getStage", "()Ljava/lang/String;", "FIRST_FRAME", "FIRST_FEED", "OTHER", "DEFAULT", "app_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class AppInitStage {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ AppInitStage[] $VALUES;
        private final String stage;
        public static final AppInitStage FIRST_FRAME = new AppInitStage("FIRST_FRAME", 0, "FIRST_FRAME");
        public static final AppInitStage FIRST_FEED = new AppInitStage("FIRST_FEED", 1, "FIRST_FEED");
        public static final AppInitStage OTHER = new AppInitStage("OTHER", 2, "OTHER");
        public static final AppInitStage DEFAULT = new AppInitStage("DEFAULT", 3, "DEFAULT");

        private static final /* synthetic */ AppInitStage[] $values() {
            return new AppInitStage[]{FIRST_FRAME, FIRST_FEED, OTHER, DEFAULT};
        }

        public static EnumEntries<AppInitStage> getEntries() {
            return $ENTRIES;
        }

        private AppInitStage(String str, int i, String str2) {
            this.stage = str2;
        }

        public final String getStage() {
            return this.stage;
        }

        static {
            AppInitStage[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        public static AppInitStage valueOf(String str) {
            return (AppInitStage) Enum.valueOf(AppInitStage.class, str);
        }

        public static AppInitStage[] values() {
            return (AppInitStage[]) $VALUES.clone();
        }
    }

    public final synchronized void addTaskDuration(String scene, boolean isMainThread, AppInitStage stage, String taskName, long duration) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        Intrinsics.checkNotNullParameter(stage, "stage");
        if (isMainThread) {
            if (!StringsKt.isBlank(scene)) {
                String str = taskName;
                if (!(str == null || StringsKt.isBlank(str))) {
                    if (duration > FIRST_FRAME_REPORT_DELAY_DURATION) {
                        return;
                    }
                    if (addedTaskNames.add(taskName)) {
                        if (!isFirstFeedShow) {
                            Map<String, Long> map = totalInitDurationsByScene;
                            Long l = map.get(scene);
                            map.put(scene, Long.valueOf((l != null ? l.longValue() : 0L) + duration));
                        }
                        int i = WhenMappings.$EnumSwitchMapping$0[stage.ordinal()];
                        if (i == 1) {
                            Map<String, Long> map2 = firstFramedDurationsByScene;
                            Long l2 = map2.get(scene);
                            map2.put(scene, Long.valueOf((l2 != null ? l2.longValue() : 0L) + duration));
                        } else if (i == 2) {
                            Map<String, Long> map3 = firstFeedDurationsByScene;
                            Long l3 = map3.get(scene);
                            map3.put(scene, Long.valueOf((l3 != null ? l3.longValue() : 0L) + duration));
                        } else {
                            if (i != 3 && i != 4) {
                                throw new NoWhenBranchMatchedException();
                            }
                            Map<String, Long> map4 = otherDurationsByScene;
                            Long l4 = map4.get(scene);
                            map4.put(scene, Long.valueOf((l4 != null ? l4.longValue() : 0L) + duration));
                        }
                    }
                    return;
                }
            }
            reportTaskInfoError(taskName);
        }
    }

    private final void reportTaskInfoError(String taskName) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(REPORT_TASK_KEY, taskName);
        IApmTrace.INSTANCE.reportTeaEvent(APP_INIT_DURATION_DIFFERENTIATED_SERVICES_ERROR, jSONObject);
        IApmTrace.DefaultImpls.reportApmEvent$default(IApmTrace.INSTANCE, APP_INIT_DURATION_DIFFERENTIATED_SERVICES_ERROR, jSONObject, null, null, 12, null);
    }

    public final synchronized void reportAndClearDurations() {
        if (alreadyReported) {
            return;
        }
        alreadyReported = true;
        FirstFrameSchedulerExecutors.INSTANCE.singleAsync(new Function0() { // from class: com.bytedance.trae.init.task.base.TaskDurationCollector$$ExternalSyntheticLambda0
            public final Object invoke() {
                Unit reportAndClearDurations$lambda$0;
                reportAndClearDurations$lambda$0 = TaskDurationCollector.reportAndClearDurations$lambda$0();
                return reportAndClearDurations$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit reportAndClearDurations$lambda$0() {
        TaskDurationCollector taskDurationCollector = INSTANCE;
        taskDurationCollector.reportData(TOTAL_APP_INIT_DURATION_DIFFERENTIATED_SERVICES, totalInitDurationsByScene);
        taskDurationCollector.reportData(FIRST_FRAME_APP_INIT_DURATION_DIFFERENTIATED_SERVICES, firstFramedDurationsByScene);
        taskDurationCollector.reportData(FEED_SHOW_APP_INIT_DURATION_DIFFERENTIATED_SERVICES, firstFeedDurationsByScene);
        taskDurationCollector.reportData(OTHER_APP_INIT_DURATION_DIFFERENTIATED_SERVICES, otherDurationsByScene);
        taskDurationCollector.clearData();
        return Unit.INSTANCE;
    }

    private final void reportData(String key, Map<String, Long> mutableMap) {
        if (mutableMap.isEmpty()) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, Long> entry : mutableMap.entrySet()) {
            jSONObject.put(entry.getKey(), entry.getValue().longValue());
        }
        IApmTrace.INSTANCE.reportTeaEvent(key, jSONObject);
        IApmTrace.INSTANCE.reportApmEvent(key, new JSONObject(), jSONObject, null);
        if (AppHost.INSTANCE.isDebug()) {
            FLogger.INSTANCE.d(TAG, "key: " + key + ", data: " + jSONObject);
        }
    }

    public final synchronized void setIsFirstFrame(boolean isFirstFrame2) {
        isFirstFrame = isFirstFrame2;
        FLogger.INSTANCE.d(TAG, "setIsFirstFrame:" + isFirstFrame2);
        if (isFirstFrame2) {
            startReportingTimer(FIRST_FRAME_REPORT_DELAY_DURATION);
        }
    }

    public final synchronized void setIsFirstFeedShow(boolean isFirstFeedShow2) {
        isFirstFeedShow = isFirstFeedShow2;
        FLogger.INSTANCE.d(TAG, "setIsFirstFrame:" + isFirstFrame);
        if (isFirstFeedShow2) {
            startReportingTimer(10000L);
        }
    }

    private final synchronized void startReportingTimer(long duration) {
        new Timer().schedule(new TimerTask() { // from class: com.bytedance.trae.init.task.base.TaskDurationCollector$startReportingTimer$1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                TaskDurationCollector.INSTANCE.reportAndClearDurations();
            }
        }, duration);
    }

    public final boolean isFirstFrame() {
        return isFirstFrame;
    }

    public final boolean isFirstFeedShow() {
        return isFirstFeedShow;
    }

    private final synchronized void clearData() {
        firstFramedDurationsByScene.clear();
        firstFeedDurationsByScene.clear();
        totalInitDurationsByScene.clear();
        addedTaskNames.clear();
    }
}
