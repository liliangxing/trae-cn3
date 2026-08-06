package com.bytedance.trae.conversation.chat.track;

import com.bytedance.sdk.account.platform.api.IWeixinService;
import com.bytedance.timonbase.pipeline.TimonPipeline;
import com.bytedance.trae.applog.api.IApplog;
import com.bytedance.trae.conversation.tracker.NewTaskTracker;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: CustomActivityTracker.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\f\rB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0018\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007H\u0007¨\u0006\u000e"}, d2 = {"Lcom/bytedance/trae/conversation/chat/track/CustomActivityTracker;", "", "<init>", "()V", "trackHomeEntryShow", "", NewTaskTracker.Param.POSITION, "", "trackHomeEntryClick", "trackShareButtonClick", TimonPipeline.KEY_SOURCE, "shareUrl", "Event", "Position", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class CustomActivityTracker {
    public static final CustomActivityTracker INSTANCE = new CustomActivityTracker();

    private CustomActivityTracker() {
    }

    /* compiled from: CustomActivityTracker.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/conversation/chat/track/CustomActivityTracker$Event;", "", "<init>", "()V", "HOME_ENTRY_SHOW", "", "HOME_ENTRY_CLICK", "SHARE_BUTTON_CLICK", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Event {
        public static final String HOME_ENTRY_CLICK = "activity_home_entry_click";
        public static final String HOME_ENTRY_SHOW = "activity_home_entry_show";
        public static final Event INSTANCE = new Event();
        public static final String SHARE_BUTTON_CLICK = "share_button_click";

        private Event() {
        }
    }

    /* compiled from: CustomActivityTracker.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/bytedance/trae/conversation/chat/track/CustomActivityTracker$Position;", "", "<init>", "()V", "NEW_SESSION", "", "TASK_MANAGE", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Position {
        public static final Position INSTANCE = new Position();
        public static final String NEW_SESSION = "new_session";
        public static final String TASK_MANAGE = "task_manage";

        private Position() {
        }
    }

    @JvmStatic
    public static final void trackHomeEntryShow(String position) {
        Intrinsics.checkNotNullParameter(position, NewTaskTracker.Param.POSITION);
        IApplog.INSTANCE.reportEvent(Event.HOME_ENTRY_SHOW, new JSONObject().put(NewTaskTracker.Param.POSITION, position));
    }

    @JvmStatic
    public static final void trackHomeEntryClick(String position) {
        Intrinsics.checkNotNullParameter(position, NewTaskTracker.Param.POSITION);
        IApplog.INSTANCE.reportEvent(Event.HOME_ENTRY_CLICK, new JSONObject().put(NewTaskTracker.Param.POSITION, position));
    }

    @JvmStatic
    public static final void trackShareButtonClick(String source, String shareUrl) {
        Intrinsics.checkNotNullParameter(source, TimonPipeline.KEY_SOURCE);
        Intrinsics.checkNotNullParameter(shareUrl, "shareUrl");
        IApplog.INSTANCE.reportEvent(Event.SHARE_BUTTON_CLICK, new JSONObject().put(TimonPipeline.KEY_SOURCE, source).put(IWeixinService.ResponseConstants.URL, shareUrl));
    }
}
