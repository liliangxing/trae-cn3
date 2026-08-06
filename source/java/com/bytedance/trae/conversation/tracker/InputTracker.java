package com.bytedance.trae.conversation.tracker;

import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.trae.applog.api.IApplog;
import com.bytedance.trae.conversation.tracker.NewTaskTracker;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: InputTracker.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000e\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005J\u000e\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0005J\u000e\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005J\u000e\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0005J\u000e\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u0015J\u0016\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u0005J\u000e\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u0015J\u000e\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u0005J\u000e\u0010!\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/bytedance/trae/conversation/tracker/InputTracker;", "", "<init>", "()V", "EVENT_MODE_SWITCH_CLICK", "", "EVENT_VOICE_INPUT_CLICK", "EVENT_ATTACHMENT_CLICK", "EVENT_SKILLS_PANEL_SHOW", "EVENT_SKILL_SELECT_CLICK", "EVENT_SHOWCASE_SHOW", "EVENT_SHOWCASE_CLICK", "EVENT_SELECT_REPOSITORY_CLICK", "trackModeSwitchClick", "", "type", "trackVoiceInputClick", "currentPage", "trackAttachmentClick", "trackSkillsPanelShow", "skillCount", "", "trackSkillSelectClick", "skillName", "trackShowcaseShow", "itemCount", "trackShowcaseClick", "position", "showcaseId", "trackSelectRepositoryClick", "isSelect", "trackMenuClick", DBDefinition.TASK_ID, "trackConversationMenuItemClick", StrategyConstants.ACTION, "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class InputTracker {
    private static final String EVENT_ATTACHMENT_CLICK = "icube_attachment_click";
    private static final String EVENT_MODE_SWITCH_CLICK = "icube_mode_switch_click";
    private static final String EVENT_SELECT_REPOSITORY_CLICK = "icube_select_repository_click";
    private static final String EVENT_SHOWCASE_CLICK = "icube_showcase_click";
    private static final String EVENT_SHOWCASE_SHOW = "icube_showcase_show";
    private static final String EVENT_SKILLS_PANEL_SHOW = "icube_skills_panel_show";
    private static final String EVENT_SKILL_SELECT_CLICK = "icube_skill_select_click";
    private static final String EVENT_VOICE_INPUT_CLICK = "icube_voice_input_click";
    public static final InputTracker INSTANCE = new InputTracker();

    private InputTracker() {
    }

    public final void trackModeSwitchClick(String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", type);
            IApplog.INSTANCE.reportEvent(EVENT_MODE_SWITCH_CLICK, jSONObject);
        } catch (Throwable unused) {
        }
    }

    public final void trackVoiceInputClick(String currentPage) {
        Intrinsics.checkNotNullParameter(currentPage, "currentPage");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("current_page", currentPage);
            IApplog.INSTANCE.reportEvent(EVENT_VOICE_INPUT_CLICK, jSONObject);
        } catch (Throwable unused) {
        }
    }

    public final void trackAttachmentClick(String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", type);
            IApplog.INSTANCE.reportEvent(EVENT_ATTACHMENT_CLICK, jSONObject);
        } catch (Throwable unused) {
        }
    }

    public final void trackSkillsPanelShow(int skillCount) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("skill_count", skillCount);
            IApplog.INSTANCE.reportEvent(EVENT_SKILLS_PANEL_SHOW, jSONObject);
        } catch (Throwable unused) {
        }
    }

    public final void trackSkillSelectClick(String skillName) {
        Intrinsics.checkNotNullParameter(skillName, "skillName");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("skill_name", skillName);
            IApplog.INSTANCE.reportEvent(EVENT_SKILL_SELECT_CLICK, jSONObject);
        } catch (Throwable unused) {
        }
    }

    public final void trackShowcaseShow(int itemCount) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("item_count", itemCount);
            IApplog.INSTANCE.reportEvent(EVENT_SHOWCASE_SHOW, jSONObject);
        } catch (Throwable unused) {
        }
    }

    public final void trackShowcaseClick(int position, String showcaseId) {
        Intrinsics.checkNotNullParameter(showcaseId, "showcaseId");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("position", position);
            jSONObject.put("showcase_id", showcaseId);
            IApplog.INSTANCE.reportEvent(EVENT_SHOWCASE_CLICK, jSONObject);
        } catch (Throwable unused) {
        }
    }

    public final void trackSelectRepositoryClick(int isSelect) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("is_select", isSelect);
            IApplog.INSTANCE.reportEvent(EVENT_SELECT_REPOSITORY_CLICK, jSONObject);
        } catch (Throwable unused) {
        }
    }

    public final void trackMenuClick(String taskId) {
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(NewTaskTracker.Param.TASK_ID, taskId);
            IApplog.INSTANCE.reportEvent("icube_menu_click", jSONObject);
        } catch (Throwable unused) {
        }
    }

    public final void trackConversationMenuItemClick(String action) {
        Intrinsics.checkNotNullParameter(action, "action");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(StrategyConstants.ACTION, action);
            IApplog.INSTANCE.reportEvent("icube_menu_action_click", jSONObject);
        } catch (Throwable unused) {
        }
    }
}
