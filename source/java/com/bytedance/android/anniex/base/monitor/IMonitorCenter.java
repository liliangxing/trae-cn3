package com.bytedance.android.anniex.base.monitor;

import java.util.Map;
import kotlin.Metadata;

/* compiled from: IMonitorCenter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\bf\u0018\u0000 \t2\u00020\u0001:\u0001\tJ>\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007H&¨\u0006\n"}, d2 = {"Lcom/bytedance/android/anniex/base/monitor/IMonitorCenter;", "", "onEvent", "", "sessionId", "", "event", "", "extra", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes2.dex */
public interface IMonitorCenter {
    public static final String ACTION_RESULT = "action_result";
    public static final String ARGUS_CONTAINER_TRACE_ID = "argus_container_trace_id";
    public static final String ARGUS_REPORT_URL = "argus_report_url";
    public static final String ARGUS_SECLINK_SCENE = "argus_seclink_scene";
    public static final String ARGUS_VIEW_TRACE_ID = "argus_view_trace_id";
    public static final String BUTTON_NAME = "button_name";
    public static final String CONTAINER_EVENT = "container_event";
    public static final String CONTAINER_EVENT_CREATE = "container_event_create";
    public static final String CONTAINER_EVENT_DESTROY = "container_event_destroy";
    public static final String CONTAINER_EVENT_NAVIGATE_FAIL = "container_event_navigate_fail";
    public static final String CONTAINER_EVENT_NAVIGATE_SUCCESS = "container_event_navigate_success";
    public static final String CONTAINER_STATUS_ENTER_BACKGROUND_COUNT = "enter_background_count";
    public static final String CONTAINER_STATUS_LAST_FOREGROUND_DURATION = "last_foreground_duration";
    public static final String CONTAINER_STATUS_LOAD_FAIL_REASON = "load_fail_reason";
    public static final String CONTAINER_STATUS_TITLE_BAR = "title_bar";
    public static final String CONTAINER_STATUS_TOTAL_DURATION = "total_duration";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final String EVENT_SOURCE = "event_source";
    public static final String EVENT_SOURCE_PRESS_PICTURE_PANEL = "event_source_press_picture_panel";
    public static final String EVENT_SOURCE_PRESS_TEXT_PANEL = "event_source_press_text_panel";
    public static final String EVENT_SOURCE_SECLINK_REPORT_BTN = "event_source_seclink_report_btn";
    public static final String EVENT_SOURCE_SHARE_PANEL = "event_source_share_panel";
    public static final String EVENT_SOURCE_TITLE_BAR = "event_source_title_bar";
    public static final String EVENT_TYPE = "event_type";
    public static final String EVENT_TYPE_CLICK = "event_type_click";
    public static final String EVENT_TYPE_CONTAINER = "event_type_container";
    public static final String EVENT_TYPE_PRESS = "event_type_press";
    public static final String EVENT_TYPE_RESULT = "event_type_result";
    public static final String EVENT_TYPE_UI = "event_type_ui";

    void onEvent(String sessionId, Map<String, String> event, Map<String, String> extra);

    /* compiled from: IMonitorCenter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001c\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/bytedance/android/anniex/base/monitor/IMonitorCenter$Companion;", "", "()V", "ACTION_RESULT", "", "ARGUS_CONTAINER_TRACE_ID", "ARGUS_REPORT_URL", "ARGUS_SECLINK_SCENE", "ARGUS_VIEW_TRACE_ID", "BUTTON_NAME", "CONTAINER_EVENT", "CONTAINER_EVENT_CREATE", "CONTAINER_EVENT_DESTROY", "CONTAINER_EVENT_NAVIGATE_FAIL", "CONTAINER_EVENT_NAVIGATE_SUCCESS", "CONTAINER_STATUS_ENTER_BACKGROUND_COUNT", "CONTAINER_STATUS_LAST_FOREGROUND_DURATION", "CONTAINER_STATUS_LOAD_FAIL_REASON", "CONTAINER_STATUS_TITLE_BAR", "CONTAINER_STATUS_TOTAL_DURATION", "EVENT_SOURCE", "EVENT_SOURCE_PRESS_PICTURE_PANEL", "EVENT_SOURCE_PRESS_TEXT_PANEL", "EVENT_SOURCE_SECLINK_REPORT_BTN", "EVENT_SOURCE_SHARE_PANEL", "EVENT_SOURCE_TITLE_BAR", "EVENT_TYPE", "EVENT_TYPE_CLICK", "EVENT_TYPE_CONTAINER", "EVENT_TYPE_PRESS", "EVENT_TYPE_RESULT", "EVENT_TYPE_UI", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String ACTION_RESULT = "action_result";
        public static final String ARGUS_CONTAINER_TRACE_ID = "argus_container_trace_id";
        public static final String ARGUS_REPORT_URL = "argus_report_url";
        public static final String ARGUS_SECLINK_SCENE = "argus_seclink_scene";
        public static final String ARGUS_VIEW_TRACE_ID = "argus_view_trace_id";
        public static final String BUTTON_NAME = "button_name";
        public static final String CONTAINER_EVENT = "container_event";
        public static final String CONTAINER_EVENT_CREATE = "container_event_create";
        public static final String CONTAINER_EVENT_DESTROY = "container_event_destroy";
        public static final String CONTAINER_EVENT_NAVIGATE_FAIL = "container_event_navigate_fail";
        public static final String CONTAINER_EVENT_NAVIGATE_SUCCESS = "container_event_navigate_success";
        public static final String CONTAINER_STATUS_ENTER_BACKGROUND_COUNT = "enter_background_count";
        public static final String CONTAINER_STATUS_LAST_FOREGROUND_DURATION = "last_foreground_duration";
        public static final String CONTAINER_STATUS_LOAD_FAIL_REASON = "load_fail_reason";
        public static final String CONTAINER_STATUS_TITLE_BAR = "title_bar";
        public static final String CONTAINER_STATUS_TOTAL_DURATION = "total_duration";
        public static final String EVENT_SOURCE = "event_source";
        public static final String EVENT_SOURCE_PRESS_PICTURE_PANEL = "event_source_press_picture_panel";
        public static final String EVENT_SOURCE_PRESS_TEXT_PANEL = "event_source_press_text_panel";
        public static final String EVENT_SOURCE_SECLINK_REPORT_BTN = "event_source_seclink_report_btn";
        public static final String EVENT_SOURCE_SHARE_PANEL = "event_source_share_panel";
        public static final String EVENT_SOURCE_TITLE_BAR = "event_source_title_bar";
        public static final String EVENT_TYPE = "event_type";
        public static final String EVENT_TYPE_CLICK = "event_type_click";
        public static final String EVENT_TYPE_CONTAINER = "event_type_container";
        public static final String EVENT_TYPE_PRESS = "event_type_press";
        public static final String EVENT_TYPE_RESULT = "event_type_result";
        public static final String EVENT_TYPE_UI = "event_type_ui";

        private Companion() {
        }
    }

    /* compiled from: IMonitorCenter.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void onEvent$default(IMonitorCenter iMonitorCenter, String str, Map map, Map map2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onEvent");
            }
            if ((i & 4) != 0) {
                map2 = null;
            }
            iMonitorCenter.onEvent(str, map, map2);
        }
    }
}
