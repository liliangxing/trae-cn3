package com.bytedance.trae.conversation.widget;

import com.bytedance.trae.im.service.CliType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TaskTemplateDeviceSelectionPolicy.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\fB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\tJ\u0016\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t¨\u0006\r"}, d2 = {"Lcom/bytedance/trae/conversation/widget/TaskTemplateDeviceSelectionPolicy;", "", "<init>", "()V", "actionForDeviceChange", "Lcom/bytedance/trae/conversation/widget/TaskTemplateDeviceSelectionPolicy$Action;", "isNewConversation", "", "previousDeviceType", "Lcom/bytedance/trae/im/service/CliType;", "selectedDeviceType", "actionForModeChange", "Action", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TaskTemplateDeviceSelectionPolicy {
    public static final TaskTemplateDeviceSelectionPolicy INSTANCE = new TaskTemplateDeviceSelectionPolicy();

    private TaskTemplateDeviceSelectionPolicy() {
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: TaskTemplateDeviceSelectionPolicy.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/trae/conversation/widget/TaskTemplateDeviceSelectionPolicy$Action;", "", "<init>", "(Ljava/lang/String;I)V", "KEEP", "HIDE", "REFRESH", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Action {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Action[] $VALUES;
        public static final Action KEEP = new Action("KEEP", 0);
        public static final Action HIDE = new Action("HIDE", 1);
        public static final Action REFRESH = new Action("REFRESH", 2);

        private static final /* synthetic */ Action[] $values() {
            return new Action[]{KEEP, HIDE, REFRESH};
        }

        public static EnumEntries<Action> getEntries() {
            return $ENTRIES;
        }

        private Action(String str, int i) {
        }

        static {
            Action[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        public static Action valueOf(String str) {
            return (Action) Enum.valueOf(Action.class, str);
        }

        public static Action[] values() {
            return (Action[]) $VALUES.clone();
        }
    }

    public final Action actionForDeviceChange(boolean isNewConversation, CliType previousDeviceType, CliType selectedDeviceType) {
        Intrinsics.checkNotNullParameter(selectedDeviceType, "selectedDeviceType");
        if (isNewConversation) {
            return selectedDeviceType == CliType.IDE ? Action.HIDE : previousDeviceType == CliType.IDE ? Action.REFRESH : Action.KEEP;
        }
        return Action.KEEP;
    }

    public final Action actionForModeChange(boolean isNewConversation, CliType selectedDeviceType) {
        Intrinsics.checkNotNullParameter(selectedDeviceType, "selectedDeviceType");
        if (isNewConversation) {
            return selectedDeviceType == CliType.IDE ? Action.HIDE : Action.REFRESH;
        }
        return Action.KEEP;
    }
}
