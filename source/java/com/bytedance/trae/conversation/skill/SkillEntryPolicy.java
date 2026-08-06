package com.bytedance.trae.conversation.skill;

import com.bytedance.trae.conversation.IDEProjectAvailabilityPolicy;
import com.bytedance.trae.conversation.devices.SelectedDeviceItem;
import com.bytedance.trae.im.service.CliType;
import kotlin.Metadata;
import kotlin.text.StringsKt;

/* compiled from: SkillEntryPolicy.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\n\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\u000b\u001a\u00020\f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¨\u0006\r"}, d2 = {"Lcom/bytedance/trae/conversation/skill/SkillEntryPolicy;", "", "<init>", "()V", "actionFor", "Lcom/bytedance/trae/conversation/skill/SkillEntryAction;", "device", "Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;", "isNewConversation", "", "canOpenCheckedIdeSkills", "unavailableToastForCheckedIdeSkills", "Lcom/bytedance/trae/conversation/skill/SkillEntryUnavailableToast;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class SkillEntryPolicy {
    public static final SkillEntryPolicy INSTANCE = new SkillEntryPolicy();

    /* compiled from: SkillEntryPolicy.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CliType.values().length];
            try {
                iArr[CliType.IDE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private SkillEntryPolicy() {
    }

    public final SkillEntryAction actionFor(SelectedDeviceItem device, boolean isNewConversation) {
        CliType type = device != null ? device.getType() : null;
        boolean z = true;
        if ((type == null ? -1 : WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) != 1) {
            return SkillEntryAction.OPEN_SKILLS;
        }
        if (!isNewConversation) {
            return SkillEntryAction.CHECK_HISTORICAL_IDE_PROJECT;
        }
        String projectId = device.getProjectId();
        if (!(projectId == null || StringsKt.isBlank(projectId))) {
            String selectedDirectory = device.getSelectedDirectory();
            if (selectedDirectory != null && !StringsKt.isBlank(selectedDirectory)) {
                z = false;
            }
            if (!z) {
                return SkillEntryAction.OPEN_SKILLS;
            }
        }
        return SkillEntryAction.OPEN_IDE_PROJECT_PICKER;
    }

    public final boolean canOpenCheckedIdeSkills(SelectedDeviceItem device) {
        if ((device != null ? device.getType() : null) != CliType.IDE || IDEProjectAvailabilityPolicy.INSTANCE.isUnavailable(device)) {
            return false;
        }
        String selectedDirectory = device.getSelectedDirectory();
        return !(selectedDirectory == null || StringsKt.isBlank(selectedDirectory));
    }

    public final SkillEntryUnavailableToast unavailableToastForCheckedIdeSkills(SelectedDeviceItem device) {
        if ((device != null ? device.getType() : null) == CliType.IDE && !device.isProjectAvailable()) {
            return SkillEntryUnavailableToast.WORKSPACE_CLOSED;
        }
        return SkillEntryUnavailableToast.DEVICE_OFFLINE;
    }
}
