package com.bytedance.trae.conversation.tracker;

import com.bytedance.trae.applog.api.IApplog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: NewTaskTracker.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003\u0017\u0018\u0019B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J6\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\nJ\u001e\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\nJ\u000e\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0007J\u000e\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0007J\u000e\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0007J\u001e\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\u001a"}, d2 = {"Lcom/bytedance/trae/conversation/tracker/NewTaskTracker;", "", "<init>", "()V", "trackPageView", "", "enterFrom", "", "trackTaskListPageView", "taskCount", "", "showType", "ideTaskCount", "pcTaskCount", "remoteTaskCount", "trackTaskCardClick", "taskId", "taskStatus", Param.POSITION, "trackTaskCardSlide", "trackTaskRenameClick", "trackTaskDeleteClick", "trackTaskDetailPageView", "Event", "Param", "EnterFrom", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class NewTaskTracker {
    public static final NewTaskTracker INSTANCE = new NewTaskTracker();

    private NewTaskTracker() {
    }

    /* compiled from: NewTaskTracker.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/conversation/tracker/NewTaskTracker$Event;", "", "<init>", "()V", "NEW_TASK_PAGE_VIEW", "", "TASK_LIST_PAGE_VIEW", "TASK_CARD_CLICK", "TASK_CARD_SLIDE", "TASK_RENAME_CLICK", "TASK_DELETE_CLICK", "TASK_DETAIL_PAGE_VIEW", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Event {
        public static final Event INSTANCE = new Event();
        public static final String NEW_TASK_PAGE_VIEW = "new_task_page_view";
        public static final String TASK_CARD_CLICK = "icube_task_card_click";
        public static final String TASK_CARD_SLIDE = "icube_task_card_slide";
        public static final String TASK_DELETE_CLICK = "icube_task_delete_click";
        public static final String TASK_DETAIL_PAGE_VIEW = "task_detail_page_view";
        public static final String TASK_LIST_PAGE_VIEW = "task_list_page_view";
        public static final String TASK_RENAME_CLICK = "icube_task_rename_click";

        private Event() {
        }
    }

    /* compiled from: NewTaskTracker.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/bytedance/trae/conversation/tracker/NewTaskTracker$Param;", "", "<init>", "()V", "ENTER_FROM", "", "TASK_COUNT", "IDE_TASK_COUNT", "PC_TASK_COUNT", "REMOTE_TASK_COUNT", "TASK_ID", "TASK_STATUS", "POSITION", "SHOW_TYPE", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Param {
        public static final String ENTER_FROM = "enter_from";
        public static final String IDE_TASK_COUNT = "ide_task_count";
        public static final Param INSTANCE = new Param();
        public static final String PC_TASK_COUNT = "pc_task_count";
        public static final String POSITION = "position";
        public static final String REMOTE_TASK_COUNT = "remote_task_count";
        public static final String SHOW_TYPE = "show_type";
        public static final String TASK_COUNT = "task_count";
        public static final String TASK_ID = "task_id";
        public static final String TASK_STATUS = "task_status";

        private Param() {
        }
    }

    /* compiled from: NewTaskTracker.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bytedance/trae/conversation/tracker/NewTaskTracker$EnterFrom;", "", "<init>", "()V", "TASK_LIST", "", "HISTORY_CHAT", "NOTIFICATION", "DEEPLINK", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class EnterFrom {
        public static final String DEEPLINK = "deeplink";
        public static final String HISTORY_CHAT = "history_chat";
        public static final EnterFrom INSTANCE = new EnterFrom();
        public static final String NOTIFICATION = "notification";
        public static final String TASK_LIST = "task_list";

        private EnterFrom() {
        }
    }

    public final void trackPageView(String enterFrom) {
        Intrinsics.checkNotNullParameter(enterFrom, "enterFrom");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("enter_from", enterFrom);
        IApplog.INSTANCE.reportEvent(Event.NEW_TASK_PAGE_VIEW, jSONObject);
    }

    public static /* synthetic */ void trackTaskListPageView$default(NewTaskTracker newTaskTracker, int i, String str, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            str = "";
        }
        newTaskTracker.trackTaskListPageView(i, str, (i5 & 4) != 0 ? 0 : i2, (i5 & 8) != 0 ? 0 : i3, (i5 & 16) != 0 ? 0 : i4);
    }

    public final void trackTaskListPageView(int taskCount, String showType, int ideTaskCount, int pcTaskCount, int remoteTaskCount) {
        Intrinsics.checkNotNullParameter(showType, "showType");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(Param.TASK_COUNT, taskCount);
        jSONObject.put(Param.IDE_TASK_COUNT, ideTaskCount);
        jSONObject.put(Param.PC_TASK_COUNT, pcTaskCount);
        jSONObject.put(Param.REMOTE_TASK_COUNT, remoteTaskCount);
        if (showType.length() > 0) {
            jSONObject.put(Param.SHOW_TYPE, showType);
        }
        IApplog.INSTANCE.reportEvent(Event.TASK_LIST_PAGE_VIEW, jSONObject);
    }

    public final void trackTaskCardClick(String taskId, String taskStatus, int position) {
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        Intrinsics.checkNotNullParameter(taskStatus, "taskStatus");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(Param.TASK_ID, taskId);
        jSONObject.put(Param.TASK_STATUS, taskStatus);
        jSONObject.put(Param.POSITION, position);
        IApplog.INSTANCE.reportEvent(Event.TASK_CARD_CLICK, jSONObject);
    }

    public final void trackTaskCardSlide(String taskId) {
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(Param.TASK_ID, taskId);
        IApplog.INSTANCE.reportEvent(Event.TASK_CARD_SLIDE, jSONObject);
    }

    public final void trackTaskRenameClick(String taskId) {
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(Param.TASK_ID, taskId);
        IApplog.INSTANCE.reportEvent(Event.TASK_RENAME_CLICK, jSONObject);
    }

    public final void trackTaskDeleteClick(String taskId) {
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(Param.TASK_ID, taskId);
        IApplog.INSTANCE.reportEvent(Event.TASK_DELETE_CLICK, jSONObject);
    }

    public final void trackTaskDetailPageView(String taskId, String taskStatus, String enterFrom) {
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        Intrinsics.checkNotNullParameter(taskStatus, "taskStatus");
        Intrinsics.checkNotNullParameter(enterFrom, "enterFrom");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(Param.TASK_ID, taskId);
        jSONObject.put(Param.TASK_STATUS, taskStatus);
        jSONObject.put("enter_from", enterFrom);
        IApplog.INSTANCE.reportEvent(Event.TASK_DETAIL_PAGE_VIEW, jSONObject);
    }
}
