package com.bytedance.trae.home.solo.task;

import com.bytedance.sdk.xbridge.cn.p003ui.utils.StatusBarUtils;
import com.bytedance.trae.home.C0820R;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: TaskModel.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u001e\b\u0086\u0081\u0002\u0018\u0000 -2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001-Bi\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0001\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0003\u0010\r\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0014R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0014R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b \u0010!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,¨\u0006."}, d2 = {"Lcom/bytedance/trae/home/solo/task/TaskStatus;", "", "statusCode", "", "label", "", "iconRes", "textColorRes", "bgColorRes", "displayState", "Lcom/bytedance/trae/home/solo/task/TaskDisplayState;", "circleBorderStyle", "Lcom/bytedance/trae/home/solo/task/CircleBorderStyle;", "circleBgColorRes", "circleBorderColorRes", "showBadge", "", "<init>", "(Ljava/lang/String;IILjava/lang/String;IIILcom/bytedance/trae/home/solo/task/TaskDisplayState;Lcom/bytedance/trae/home/solo/task/CircleBorderStyle;IIZ)V", "getStatusCode", "()I", "getLabel", "()Ljava/lang/String;", "getIconRes", "getTextColorRes", "getBgColorRes", "getDisplayState", "()Lcom/bytedance/trae/home/solo/task/TaskDisplayState;", "getCircleBorderStyle", "()Lcom/bytedance/trae/home/solo/task/CircleBorderStyle;", "getCircleBgColorRes", "getCircleBorderColorRes", "getShowBadge", "()Z", "UNKNOWN", "PENDING", "CREATING", "RUNNING", "STOPPED", "FINISHED", "FAILED", "FROZEN", "WAITING", "REVERTING", "STOPPING", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TaskStatus {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ TaskStatus[] $VALUES;
    public static final TaskStatus CREATING;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final TaskStatus FAILED;
    public static final TaskStatus FINISHED;
    public static final TaskStatus FROZEN;
    public static final TaskStatus PENDING;
    public static final TaskStatus REVERTING;
    public static final TaskStatus RUNNING;
    public static final TaskStatus STOPPED;
    public static final TaskStatus STOPPING;
    public static final TaskStatus UNKNOWN = new TaskStatus("UNKNOWN", 0, 0, "Unknown", C0820R.drawable.ic_solo_unknown_circle, C0820R.color.solo_task_unknown_text, C0820R.color.solo_task_unknown_bg, null, null, 0, 0, false, 992, null);
    public static final TaskStatus WAITING;
    private final int bgColorRes;
    private final int circleBgColorRes;
    private final int circleBorderColorRes;
    private final CircleBorderStyle circleBorderStyle;
    private final TaskDisplayState displayState;
    private final int iconRes;
    private final String label;
    private final boolean showBadge;
    private final int statusCode;
    private final int textColorRes;

    private static final /* synthetic */ TaskStatus[] $values() {
        return new TaskStatus[]{UNKNOWN, PENDING, CREATING, RUNNING, STOPPED, FINISHED, FAILED, FROZEN, WAITING, REVERTING, STOPPING};
    }

    public static EnumEntries<TaskStatus> getEntries() {
        return $ENTRIES;
    }

    private TaskStatus(String str, int i, int i2, String str2, int i3, int i4, int i5, TaskDisplayState taskDisplayState, CircleBorderStyle circleBorderStyle, int i6, int i7, boolean z) {
        this.statusCode = i2;
        this.label = str2;
        this.iconRes = i3;
        this.textColorRes = i4;
        this.bgColorRes = i5;
        this.displayState = taskDisplayState;
        this.circleBorderStyle = circleBorderStyle;
        this.circleBgColorRes = i6;
        this.circleBorderColorRes = i7;
        this.showBadge = z;
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    public final String getLabel() {
        return this.label;
    }

    public final int getIconRes() {
        return this.iconRes;
    }

    public final int getTextColorRes() {
        return this.textColorRes;
    }

    public final int getBgColorRes() {
        return this.bgColorRes;
    }

    /* synthetic */ TaskStatus(String str, int i, int i2, String str2, int i3, int i4, int i5, TaskDisplayState taskDisplayState, CircleBorderStyle circleBorderStyle, int i6, int i7, boolean z, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, i2, str2, i3, i4, i5, (i8 & 32) != 0 ? TaskDisplayState.IDLE : taskDisplayState, (i8 & 64) != 0 ? CircleBorderStyle.NONE : circleBorderStyle, (i8 & 128) != 0 ? C0820R.color.solo_task_circle_default_bg : i6, (i8 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? 0 : i7, (i8 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? false : z);
    }

    public final TaskDisplayState getDisplayState() {
        return this.displayState;
    }

    public final CircleBorderStyle getCircleBorderStyle() {
        return this.circleBorderStyle;
    }

    public final int getCircleBgColorRes() {
        return this.circleBgColorRes;
    }

    public final int getCircleBorderColorRes() {
        return this.circleBorderColorRes;
    }

    public final boolean getShowBadge() {
        return this.showBadge;
    }

    static {
        int i = C0820R.drawable.ic_solo_warning_circle;
        int i2 = C0820R.color.solo_task_pending_text;
        int i3 = C0820R.color.solo_task_pending_bg;
        TaskDisplayState taskDisplayState = TaskDisplayState.LOADING;
        CircleBorderStyle circleBorderStyle = CircleBorderStyle.SOLID;
        int i4 = C0820R.color.solo_task_circle_blue_bg;
        int i5 = C0820R.color.solo_task_circle_blue_border;
        boolean z = false;
        int i6 = StatusBarUtils.FLAG_NOTCH_PORTRAIT;
        DefaultConstructorMarker defaultConstructorMarker = null;
        PENDING = new TaskStatus("PENDING", 1, 1, "Pending", i, i2, i3, taskDisplayState, circleBorderStyle, i4, i5, z, i6, defaultConstructorMarker);
        boolean z2 = false;
        DefaultConstructorMarker defaultConstructorMarker2 = null;
        CREATING = new TaskStatus("CREATING", 2, 2, "Creating", C0820R.drawable.ic_solo_creating_circle, C0820R.color.solo_task_creating_text, C0820R.color.solo_task_creating_bg, TaskDisplayState.LOADING, CircleBorderStyle.SOLID, C0820R.color.solo_task_circle_blue_bg, C0820R.color.solo_task_circle_blue_border, z2, StatusBarUtils.FLAG_NOTCH_PORTRAIT, defaultConstructorMarker2);
        RUNNING = new TaskStatus("RUNNING", 3, 3, "Running", C0820R.drawable.ic_solo_todo, C0820R.color.solo_task_running_text, C0820R.color.solo_task_running_bg, TaskDisplayState.LOADING, CircleBorderStyle.SOLID, C0820R.color.solo_task_circle_blue_bg, C0820R.color.solo_task_circle_blue_border, z, i6, defaultConstructorMarker);
        STOPPED = new TaskStatus("STOPPED", 4, 4, "Stopped", C0820R.drawable.ic_solo_stopped_circle, C0820R.color.solo_task_stopped_text, C0820R.color.solo_task_stopped_bg, null, CircleBorderStyle.SOLID, 0, C0820R.color.solo_task_circle_stopped_border, z2, 672, defaultConstructorMarker2);
        TaskDisplayState taskDisplayState2 = null;
        CircleBorderStyle circleBorderStyle2 = null;
        int i7 = 0;
        int i8 = 0;
        int i9 = 992;
        FINISHED = new TaskStatus("FINISHED", 5, 5, "Finished", C0820R.drawable.ic_solo_checkmark_circle, C0820R.color.solo_task_finished_text, C0820R.color.solo_task_finished_bg, taskDisplayState2, circleBorderStyle2, i7, i8, z, i9, defaultConstructorMarker);
        int i10 = C0820R.drawable.ic_solo_failed_circle;
        int i11 = C0820R.color.solo_task_failed_text;
        int i12 = C0820R.color.solo_task_failed_bg;
        TaskDisplayState taskDisplayState3 = TaskDisplayState.ERROR;
        CircleBorderStyle circleBorderStyle3 = CircleBorderStyle.SOLID;
        int i13 = C0820R.color.solo_task_circle_red_bg;
        int i14 = C0820R.color.solo_task_circle_red_border;
        int i15 = StatusBarUtils.FLAG_NOTCH_PORTRAIT;
        FAILED = new TaskStatus("FAILED", 6, 6, "Failed", i10, i11, i12, taskDisplayState3, circleBorderStyle3, i13, i14, z2, i15, defaultConstructorMarker2);
        FROZEN = new TaskStatus("FROZEN", 7, 7, "Frozen", C0820R.drawable.ic_solo_frozen_circle, C0820R.color.solo_task_frozen_text, C0820R.color.solo_task_frozen_bg, taskDisplayState2, circleBorderStyle2, i7, i8, z, i9, defaultConstructorMarker);
        WAITING = new TaskStatus("WAITING", 8, 8, "Waiting", C0820R.drawable.ic_solo_warning_circle, C0820R.color.solo_task_waiting_text, C0820R.color.solo_task_waiting_bg, TaskDisplayState.WAITING, CircleBorderStyle.DASHED, C0820R.color.solo_task_circle_orange_bg, C0820R.color.solo_task_circle_orange_border, z2, i15, defaultConstructorMarker2);
        REVERTING = new TaskStatus("REVERTING", 9, 9, "Reverting", C0820R.drawable.ic_solo_reverting_circle, C0820R.color.solo_task_reverting_text, C0820R.color.solo_task_reverting_bg, TaskDisplayState.LOADING, CircleBorderStyle.SOLID, C0820R.color.solo_task_circle_blue_bg, C0820R.color.solo_task_circle_blue_border, z, StatusBarUtils.FLAG_NOTCH_PORTRAIT, defaultConstructorMarker);
        STOPPING = new TaskStatus("STOPPING", 10, 10, "Stopping", C0820R.drawable.ic_solo_stopped_circle, C0820R.color.solo_task_stopped_text, C0820R.color.solo_task_stopped_bg, TaskDisplayState.LOADING, CircleBorderStyle.SOLID, C0820R.color.solo_task_circle_blue_bg, C0820R.color.solo_task_circle_blue_border, z2, i15, defaultConstructorMarker2);
        TaskStatus[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        INSTANCE = new Companion(null);
    }

    /* compiled from: TaskModel.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/home/solo/task/TaskStatus$Companion;", "", "<init>", "()V", "fromStatusCode", "Lcom/bytedance/trae/home/solo/task/TaskStatus;", "code", "", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final TaskStatus fromStatusCode(int code) {
            Object obj;
            Iterator it = TaskStatus.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (((TaskStatus) obj).getStatusCode() == code) {
                    break;
                }
            }
            TaskStatus taskStatus = (TaskStatus) obj;
            return taskStatus == null ? TaskStatus.UNKNOWN : taskStatus;
        }
    }

    public static TaskStatus valueOf(String str) {
        return (TaskStatus) Enum.valueOf(TaskStatus.class, str);
    }

    public static TaskStatus[] values() {
        return (TaskStatus[]) $VALUES.clone();
    }
}
