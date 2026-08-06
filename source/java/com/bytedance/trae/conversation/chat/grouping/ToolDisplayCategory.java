package com.bytedance.trae.conversation.chat.grouping;

import android.content.res.Resources;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.im.model.ParsedToolCallInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ToolDisplayCategory.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u0000 #2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002\"#B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dJ\u0016\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010!\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019¨\u0006$"}, d2 = {"Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;", "", "countType", "Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory$CountType;", "<init>", "(Ljava/lang/String;ILcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory$CountType;)V", "getCountType", "()Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory$CountType;", "FILE_EDIT", "FILE_VIEW", "FILE_CREATE", "FOLDER_VIEW", "FILE_DELETE", "COMMAND_EXEC", "MCP_TOOL", "SKILL", "FILE_SEARCH", "WEB_SEARCH", "THINKING", "PREVIEW", "TASK_MANAGE", "ENV_INIT", "ASK_USER", "BROWSER_USE", "SUB_AGENT", "FALLBACK", "getRunningTitle", "", "resources", "Landroid/content/res/Resources;", "getCompletedTitle", "count", "", "getSummaryTitle", "CountType", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ToolDisplayCategory {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ToolDisplayCategory[] $VALUES;
    private static final Set<String> ASK_USER_NAMES;
    private static final Set<String> BROWSER_USE_NAMES;
    private static final Set<String> COMMAND_EXEC_NAMES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static final Set<String> ENV_INIT_NAMES;
    private static final Set<String> FILE_CREATE_NAMES;
    private static final Set<String> FILE_DELETE_NAMES;
    private static final Set<String> FILE_EDIT_NAMES;
    private static final Set<String> FILE_SEARCH_NAMES;
    private static final Set<String> FILE_VIEW_NAMES;
    private static final Set<String> FOLDER_VIEW_NAMES;
    private static final Set<String> MCP_TOOL_NAMES;
    private static final Set<String> PREVIEW_NAMES;
    private static final Set<String> SKILL_NAMES;
    private static final Set<String> SUB_AGENT_NAMES;
    private static final Set<String> TASK_MANAGE_NAMES;
    private static final Set<String> THINKING_NAMES;
    private static final Set<String> WEB_SEARCH_NAMES;
    private final CountType countType;
    public static final ToolDisplayCategory FILE_EDIT = new ToolDisplayCategory("FILE_EDIT", 0, CountType.OBJECT);
    public static final ToolDisplayCategory FILE_VIEW = new ToolDisplayCategory("FILE_VIEW", 1, CountType.OBJECT);
    public static final ToolDisplayCategory FILE_CREATE = new ToolDisplayCategory("FILE_CREATE", 2, CountType.OBJECT);
    public static final ToolDisplayCategory FOLDER_VIEW = new ToolDisplayCategory("FOLDER_VIEW", 3, CountType.OBJECT);
    public static final ToolDisplayCategory FILE_DELETE = new ToolDisplayCategory("FILE_DELETE", 4, CountType.OBJECT);
    public static final ToolDisplayCategory COMMAND_EXEC = new ToolDisplayCategory("COMMAND_EXEC", 5, CountType.OBJECT);
    public static final ToolDisplayCategory MCP_TOOL = new ToolDisplayCategory("MCP_TOOL", 6, CountType.OBJECT);
    public static final ToolDisplayCategory SKILL = new ToolDisplayCategory("SKILL", 7, CountType.OBJECT);
    public static final ToolDisplayCategory FILE_SEARCH = new ToolDisplayCategory("FILE_SEARCH", 8, CountType.ACTION);
    public static final ToolDisplayCategory WEB_SEARCH = new ToolDisplayCategory("WEB_SEARCH", 9, CountType.ACTION);
    public static final ToolDisplayCategory THINKING = new ToolDisplayCategory("THINKING", 10, CountType.NONE);
    public static final ToolDisplayCategory PREVIEW = new ToolDisplayCategory("PREVIEW", 11, CountType.NONE);
    public static final ToolDisplayCategory TASK_MANAGE = new ToolDisplayCategory("TASK_MANAGE", 12, CountType.NONE);
    public static final ToolDisplayCategory ENV_INIT = new ToolDisplayCategory("ENV_INIT", 13, CountType.NONE);
    public static final ToolDisplayCategory ASK_USER = new ToolDisplayCategory("ASK_USER", 14, CountType.NONE);
    public static final ToolDisplayCategory BROWSER_USE = new ToolDisplayCategory("BROWSER_USE", 15, CountType.NONE);
    public static final ToolDisplayCategory SUB_AGENT = new ToolDisplayCategory("SUB_AGENT", 16, CountType.NONE);
    public static final ToolDisplayCategory FALLBACK = new ToolDisplayCategory("FALLBACK", 17, CountType.OBJECT);

    /* compiled from: ToolDisplayCategory.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ToolDisplayCategory.values().length];
            try {
                iArr[ToolDisplayCategory.FILE_EDIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ToolDisplayCategory.FILE_VIEW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ToolDisplayCategory.FILE_CREATE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ToolDisplayCategory.FOLDER_VIEW.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ToolDisplayCategory.FILE_DELETE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ToolDisplayCategory.COMMAND_EXEC.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[ToolDisplayCategory.MCP_TOOL.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[ToolDisplayCategory.SKILL.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[ToolDisplayCategory.FILE_SEARCH.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[ToolDisplayCategory.WEB_SEARCH.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[ToolDisplayCategory.THINKING.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[ToolDisplayCategory.PREVIEW.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[ToolDisplayCategory.TASK_MANAGE.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[ToolDisplayCategory.ENV_INIT.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[ToolDisplayCategory.ASK_USER.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr[ToolDisplayCategory.BROWSER_USE.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr[ToolDisplayCategory.SUB_AGENT.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr[ToolDisplayCategory.FALLBACK.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static final /* synthetic */ ToolDisplayCategory[] $values() {
        return new ToolDisplayCategory[]{FILE_EDIT, FILE_VIEW, FILE_CREATE, FOLDER_VIEW, FILE_DELETE, COMMAND_EXEC, MCP_TOOL, SKILL, FILE_SEARCH, WEB_SEARCH, THINKING, PREVIEW, TASK_MANAGE, ENV_INIT, ASK_USER, BROWSER_USE, SUB_AGENT, FALLBACK};
    }

    public static EnumEntries<ToolDisplayCategory> getEntries() {
        return $ENTRIES;
    }

    private ToolDisplayCategory(String str, int i, CountType countType) {
        this.countType = countType;
    }

    public final CountType getCountType() {
        return this.countType;
    }

    static {
        ToolDisplayCategory[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        INSTANCE = new Companion(null);
        FILE_EDIT_NAMES = SetsKt.setOf(new String[]{"edit_file_search_replace", "Write", "Edit", "MultiEdit", "SearchReplace", "edit_file", "write_to_file", "edit_file_update", "ShowDiff", "WriteToFile"});
        FILE_VIEW_NAMES = SetsKt.setOf(new String[]{"view_file", "view_files", "Read", "ViewFile", "ViewFiles"});
        FILE_CREATE_NAMES = SetsKt.setOf(new String[]{"create_file", "CreateFile"});
        FOLDER_VIEW_NAMES = SetsKt.setOf(new String[]{"view_folder", "LS", "ViewFolder"});
        FILE_DELETE_NAMES = SetsKt.setOf(new String[]{"delete_file", "DeleteFile"});
        COMMAND_EXEC_NAMES = SetsKt.setOf(new String[]{"run_command", "RunCommand", "Shell", "exec_command", "CheckCommandStatus", "StopCommand"});
        MCP_TOOL_NAMES = SetsKt.setOf(new String[]{"run_mcp", "mcp_call", "MCPCall", "RunMcp"});
        SKILL_NAMES = SetsKt.setOf("Skill");
        FILE_SEARCH_NAMES = SetsKt.setOf(new String[]{"file_search", "FileSearch", "Glob", "SearchByRegex", "Grep", "SearchCodebase", "search_codebase", "search_by_regex"});
        WEB_SEARCH_NAMES = SetsKt.setOf(new String[]{"web_search", "WebSearch", "WebFetch"});
        THINKING_NAMES = SetsKt.setOf(new String[]{"Thinking", "Reasoning"});
        PREVIEW_NAMES = SetsKt.setOf(new String[]{"open_preview", "OpenPreview", "open_preview_and_wait_for_error"});
        TASK_MANAGE_NAMES = SetsKt.setOf(new String[]{"todo_write", "TodoWrite"});
        ENV_INIT_NAMES = SetsKt.setOf("InitEnv");
        ASK_USER_NAMES = SetsKt.setOf(new String[]{"AskUserQuestion", "RequestAuthorization"});
        BROWSER_USE_NAMES = SetsKt.setOf(new String[]{"BrowserHandOver", "BrowserWaitingForUserInteraction"});
        SUB_AGENT_NAMES = SetsKt.setOf(new String[]{"RunAgent", "Task"});
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: ToolDisplayCategory.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory$CountType;", "", "<init>", "(Ljava/lang/String;I)V", "OBJECT", "ACTION", "NONE", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class CountType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ CountType[] $VALUES;
        public static final CountType OBJECT = new CountType("OBJECT", 0);
        public static final CountType ACTION = new CountType("ACTION", 1);
        public static final CountType NONE = new CountType("NONE", 2);

        private static final /* synthetic */ CountType[] $values() {
            return new CountType[]{OBJECT, ACTION, NONE};
        }

        public static EnumEntries<CountType> getEntries() {
            return $ENTRIES;
        }

        static {
            CountType[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        private CountType(String str, int i) {
        }

        public static CountType valueOf(String str) {
            return (CountType) Enum.valueOf(CountType.class, str);
        }

        public static CountType[] values() {
            return (CountType[]) $VALUES.clone();
        }
    }

    public final String getRunningTitle(Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
            case 1:
                String string = resources.getString(C0637R.string.trae_group_running_file_edit);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                return string;
            case 2:
                String string2 = resources.getString(C0637R.string.trae_group_running_file_view);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                return string2;
            case 3:
                String string3 = resources.getString(C0637R.string.trae_group_running_file_create);
                Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                return string3;
            case 4:
                String string4 = resources.getString(C0637R.string.trae_group_running_folder_view);
                Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
                return string4;
            case 5:
                String string5 = resources.getString(C0637R.string.trae_group_running_file_delete);
                Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
                return string5;
            case 6:
                String string6 = resources.getString(C0637R.string.trae_group_running_command_exec);
                Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
                return string6;
            case 7:
                String string7 = resources.getString(C0637R.string.trae_group_running_mcp_tool);
                Intrinsics.checkNotNullExpressionValue(string7, "getString(...)");
                return string7;
            case 8:
                String string8 = resources.getString(C0637R.string.trae_group_running_skill);
                Intrinsics.checkNotNullExpressionValue(string8, "getString(...)");
                return string8;
            case 9:
                String string9 = resources.getString(C0637R.string.trae_group_running_file_search);
                Intrinsics.checkNotNullExpressionValue(string9, "getString(...)");
                return string9;
            case 10:
                String string10 = resources.getString(C0637R.string.trae_group_running_web_search);
                Intrinsics.checkNotNullExpressionValue(string10, "getString(...)");
                return string10;
            case 11:
                String string11 = resources.getString(C0637R.string.trae_group_running_thinking);
                Intrinsics.checkNotNullExpressionValue(string11, "getString(...)");
                return string11;
            case 12:
                String string12 = resources.getString(C0637R.string.trae_group_running_preview);
                Intrinsics.checkNotNullExpressionValue(string12, "getString(...)");
                return string12;
            case 13:
                String string13 = resources.getString(C0637R.string.trae_group_running_task_manage);
                Intrinsics.checkNotNullExpressionValue(string13, "getString(...)");
                return string13;
            case 14:
                String string14 = resources.getString(C0637R.string.trae_group_running_env_init);
                Intrinsics.checkNotNullExpressionValue(string14, "getString(...)");
                return string14;
            case 15:
                String string15 = resources.getString(C0637R.string.trae_group_running_ask_user);
                Intrinsics.checkNotNullExpressionValue(string15, "getString(...)");
                return string15;
            case 16:
                String string16 = resources.getString(C0637R.string.trae_group_running_browser_use);
                Intrinsics.checkNotNullExpressionValue(string16, "getString(...)");
                return string16;
            case 17:
                String string17 = resources.getString(C0637R.string.trae_group_running_file_edit);
                Intrinsics.checkNotNullExpressionValue(string17, "getString(...)");
                return string17;
            case 18:
                String string18 = resources.getString(C0637R.string.trae_group_running_mcp_tool);
                Intrinsics.checkNotNullExpressionValue(string18, "getString(...)");
                return string18;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final String getCompletedTitle(Resources resources, int count) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
            case 1:
                String string = resources.getString(C0637R.string.trae_group_done_file_edit, Integer.valueOf(count));
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                return string;
            case 2:
                String string2 = resources.getString(C0637R.string.trae_group_done_file_view, Integer.valueOf(count));
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                return string2;
            case 3:
                String string3 = resources.getString(C0637R.string.trae_group_done_file_create, Integer.valueOf(count));
                Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                return string3;
            case 4:
                String string4 = resources.getString(C0637R.string.trae_group_done_folder_view, Integer.valueOf(count));
                Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
                return string4;
            case 5:
                String string5 = resources.getString(C0637R.string.trae_group_done_file_delete, Integer.valueOf(count));
                Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
                return string5;
            case 6:
                String string6 = resources.getString(C0637R.string.trae_group_done_command_exec, Integer.valueOf(count));
                Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
                return string6;
            case 7:
                String string7 = resources.getString(C0637R.string.trae_group_done_mcp_tool, Integer.valueOf(count));
                Intrinsics.checkNotNullExpressionValue(string7, "getString(...)");
                return string7;
            case 8:
                String string8 = resources.getString(C0637R.string.trae_group_done_skill, Integer.valueOf(count));
                Intrinsics.checkNotNullExpressionValue(string8, "getString(...)");
                return string8;
            case 9:
                String string9 = resources.getString(C0637R.string.trae_group_done_file_search, Integer.valueOf(count));
                Intrinsics.checkNotNullExpressionValue(string9, "getString(...)");
                return string9;
            case 10:
                String string10 = resources.getString(C0637R.string.trae_group_done_web_search, Integer.valueOf(count));
                Intrinsics.checkNotNullExpressionValue(string10, "getString(...)");
                return string10;
            case 11:
                String string11 = resources.getString(C0637R.string.trae_group_done_thinking);
                Intrinsics.checkNotNullExpressionValue(string11, "getString(...)");
                return string11;
            case 12:
                String string12 = resources.getString(C0637R.string.trae_group_done_preview);
                Intrinsics.checkNotNullExpressionValue(string12, "getString(...)");
                return string12;
            case 13:
                String string13 = resources.getString(C0637R.string.trae_group_done_task_manage);
                Intrinsics.checkNotNullExpressionValue(string13, "getString(...)");
                return string13;
            case 14:
                String string14 = resources.getString(C0637R.string.trae_group_done_env_init);
                Intrinsics.checkNotNullExpressionValue(string14, "getString(...)");
                return string14;
            case 15:
                String string15 = resources.getString(C0637R.string.trae_group_done_ask_user);
                Intrinsics.checkNotNullExpressionValue(string15, "getString(...)");
                return string15;
            case 16:
                String string16 = resources.getString(C0637R.string.trae_group_done_browser_use);
                Intrinsics.checkNotNullExpressionValue(string16, "getString(...)");
                return string16;
            case 17:
                String string17 = resources.getString(C0637R.string.trae_group_done_file_edit, Integer.valueOf(count));
                Intrinsics.checkNotNullExpressionValue(string17, "getString(...)");
                return string17;
            case 18:
                String string18 = resources.getString(C0637R.string.trae_group_done_mcp_tool, Integer.valueOf(count));
                Intrinsics.checkNotNullExpressionValue(string18, "getString(...)");
                return string18;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final String getSummaryTitle(Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
            case 1:
                String string = resources.getString(C0637R.string.trae_group_summary_file_edit);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                return string;
            case 2:
                String string2 = resources.getString(C0637R.string.trae_group_summary_file_view);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                return string2;
            case 3:
                String string3 = resources.getString(C0637R.string.trae_group_summary_file_create);
                Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                return string3;
            case 4:
                String string4 = resources.getString(C0637R.string.trae_group_summary_folder_view);
                Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
                return string4;
            case 5:
                String string5 = resources.getString(C0637R.string.trae_group_summary_file_delete);
                Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
                return string5;
            case 6:
                String string6 = resources.getString(C0637R.string.trae_group_summary_command_exec);
                Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
                return string6;
            case 7:
                String string7 = resources.getString(C0637R.string.trae_group_summary_mcp_tool);
                Intrinsics.checkNotNullExpressionValue(string7, "getString(...)");
                return string7;
            case 8:
                String string8 = resources.getString(C0637R.string.trae_group_summary_skill);
                Intrinsics.checkNotNullExpressionValue(string8, "getString(...)");
                return string8;
            case 9:
                String string9 = resources.getString(C0637R.string.trae_group_summary_file_search);
                Intrinsics.checkNotNullExpressionValue(string9, "getString(...)");
                return string9;
            case 10:
                String string10 = resources.getString(C0637R.string.trae_group_summary_web_search);
                Intrinsics.checkNotNullExpressionValue(string10, "getString(...)");
                return string10;
            case 11:
                String string11 = resources.getString(C0637R.string.trae_group_done_thinking);
                Intrinsics.checkNotNullExpressionValue(string11, "getString(...)");
                return string11;
            case 12:
                String string12 = resources.getString(C0637R.string.trae_group_done_preview);
                Intrinsics.checkNotNullExpressionValue(string12, "getString(...)");
                return string12;
            case 13:
                String string13 = resources.getString(C0637R.string.trae_group_done_task_manage);
                Intrinsics.checkNotNullExpressionValue(string13, "getString(...)");
                return string13;
            case 14:
                String string14 = resources.getString(C0637R.string.trae_group_done_env_init);
                Intrinsics.checkNotNullExpressionValue(string14, "getString(...)");
                return string14;
            case 15:
                String string15 = resources.getString(C0637R.string.trae_group_done_ask_user);
                Intrinsics.checkNotNullExpressionValue(string15, "getString(...)");
                return string15;
            case 16:
                String string16 = resources.getString(C0637R.string.trae_group_done_browser_use);
                Intrinsics.checkNotNullExpressionValue(string16, "getString(...)");
                return string16;
            case 17:
                String string17 = resources.getString(C0637R.string.trae_group_summary_file_edit);
                Intrinsics.checkNotNullExpressionValue(string17, "getString(...)");
                return string17;
            case 18:
                String string18 = resources.getString(C0637R.string.trae_group_summary_mcp_tool);
                Intrinsics.checkNotNullExpressionValue(string18, "getString(...)");
                return string18;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* compiled from: ToolDisplayCategory.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0006J>\u0010\u001a\u001a\u00020\u00062\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u001f2\u000e\b\u0002\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory$Companion;", "", "<init>", "()V", "FILE_EDIT_NAMES", "", "", "FILE_VIEW_NAMES", "FILE_CREATE_NAMES", "FOLDER_VIEW_NAMES", "FILE_DELETE_NAMES", "COMMAND_EXEC_NAMES", "MCP_TOOL_NAMES", "SKILL_NAMES", "FILE_SEARCH_NAMES", "WEB_SEARCH_NAMES", "THINKING_NAMES", "PREVIEW_NAMES", "TASK_MANAGE_NAMES", "ENV_INIT_NAMES", "ASK_USER_NAMES", "BROWSER_USE_NAMES", "SUB_AGENT_NAMES", "fromToolName", "Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;", "name", "buildDynamicGroupTitle", "toolcalls", "", "Lcom/bytedance/trae/im/model/ParsedToolCallInfo;", "hasThinking", "", "resources", "Landroid/content/res/Resources;", "groupFinished", "waitingConfirmIds", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {

        /* compiled from: ToolDisplayCategory.kt */
        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[CountType.values().length];
                try {
                    iArr[CountType.NONE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ToolDisplayCategory fromToolName(String name) {
            if (name != null) {
                if (ToolDisplayCategory.FILE_EDIT_NAMES.contains(name)) {
                    return ToolDisplayCategory.FILE_EDIT;
                }
                if (ToolDisplayCategory.FILE_VIEW_NAMES.contains(name)) {
                    return ToolDisplayCategory.FILE_VIEW;
                }
                if (ToolDisplayCategory.FILE_CREATE_NAMES.contains(name)) {
                    return ToolDisplayCategory.FILE_CREATE;
                }
                if (ToolDisplayCategory.FOLDER_VIEW_NAMES.contains(name)) {
                    return ToolDisplayCategory.FOLDER_VIEW;
                }
                if (ToolDisplayCategory.FILE_DELETE_NAMES.contains(name)) {
                    return ToolDisplayCategory.FILE_DELETE;
                }
                if (ToolDisplayCategory.COMMAND_EXEC_NAMES.contains(name)) {
                    return ToolDisplayCategory.COMMAND_EXEC;
                }
                if (ToolDisplayCategory.MCP_TOOL_NAMES.contains(name)) {
                    return ToolDisplayCategory.MCP_TOOL;
                }
                if (ToolDisplayCategory.SKILL_NAMES.contains(name)) {
                    return ToolDisplayCategory.SKILL;
                }
                if (ToolDisplayCategory.FILE_SEARCH_NAMES.contains(name)) {
                    return ToolDisplayCategory.FILE_SEARCH;
                }
                if (ToolDisplayCategory.WEB_SEARCH_NAMES.contains(name)) {
                    return ToolDisplayCategory.WEB_SEARCH;
                }
                if (ToolDisplayCategory.THINKING_NAMES.contains(name)) {
                    return ToolDisplayCategory.THINKING;
                }
                if (ToolDisplayCategory.PREVIEW_NAMES.contains(name)) {
                    return ToolDisplayCategory.PREVIEW;
                }
                if (ToolDisplayCategory.TASK_MANAGE_NAMES.contains(name)) {
                    return ToolDisplayCategory.TASK_MANAGE;
                }
                if (ToolDisplayCategory.ENV_INIT_NAMES.contains(name)) {
                    return ToolDisplayCategory.ENV_INIT;
                }
                if (ToolDisplayCategory.ASK_USER_NAMES.contains(name)) {
                    return ToolDisplayCategory.ASK_USER;
                }
                if (StringsKt.startsWith$default(name, "browser_", false, 2, (Object) null) || ToolDisplayCategory.BROWSER_USE_NAMES.contains(name)) {
                    return ToolDisplayCategory.BROWSER_USE;
                }
                return ToolDisplayCategory.SUB_AGENT_NAMES.contains(name) ? ToolDisplayCategory.SUB_AGENT : ToolDisplayCategory.FALLBACK;
            }
            return ToolDisplayCategory.FALLBACK;
        }

        public static /* synthetic */ String buildDynamicGroupTitle$default(Companion companion, List list, boolean z, Resources resources, boolean z2, Set set, int i, Object obj) {
            if ((i & 8) != 0) {
                z2 = false;
            }
            boolean z3 = z2;
            if ((i & 16) != 0) {
                set = SetsKt.emptySet();
            }
            return companion.buildDynamicGroupTitle(list, z, resources, z3, set);
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x007b  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0092  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final String buildDynamicGroupTitle(List<ParsedToolCallInfo> toolcalls, boolean hasThinking, Resources resources, boolean groupFinished, Set<String> waitingConfirmIds) {
            boolean z;
            boolean z2;
            Intrinsics.checkNotNullParameter(toolcalls, "toolcalls");
            Intrinsics.checkNotNullParameter(resources, "resources");
            Intrinsics.checkNotNullParameter(waitingConfirmIds, "waitingConfirmIds");
            if (toolcalls.isEmpty() && hasThinking) {
                if (groupFinished) {
                    String string = resources.getString(C0637R.string.trae_group_done_thinking);
                    Intrinsics.checkNotNull(string);
                    return string;
                }
                return ToolDisplayCategory.THINKING.getRunningTitle(resources);
            }
            if (!toolcalls.isEmpty()) {
                List<ParsedToolCallInfo> list = toolcalls;
                if (!(list instanceof Collection) || !list.isEmpty()) {
                    for (ParsedToolCallInfo parsedToolCallInfo : list) {
                        if (!((parsedToolCallInfo.getResult() == null || CollectionsKt.contains(waitingConfirmIds, parsedToolCallInfo.getId())) ? false : true)) {
                            z2 = false;
                            break;
                        }
                    }
                }
                z2 = true;
                if (z2) {
                    z = true;
                    if (z) {
                        ParsedToolCallInfo parsedToolCallInfo2 = (ParsedToolCallInfo) CollectionsKt.lastOrNull(toolcalls);
                        return fromToolName(parsedToolCallInfo2 != null ? parsedToolCallInfo2.getName() : null).getRunningTitle(resources);
                    }
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    Iterator<ParsedToolCallInfo> it = toolcalls.iterator();
                    while (it.hasNext()) {
                        ToolDisplayCategory fromToolName = fromToolName(it.next().getName());
                        Integer num = (Integer) linkedHashMap.get(fromToolName);
                        linkedHashMap.put(fromToolName, Integer.valueOf((num != null ? num.intValue() : 0) + 1));
                    }
                    LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                    for (Map.Entry entry : linkedHashMap.entrySet()) {
                        if ((entry.getKey() == ToolDisplayCategory.THINKING && hasThinking && linkedHashMap.size() != 1) ? false : true) {
                            linkedHashMap2.put(entry.getKey(), entry.getValue());
                        }
                    }
                    if (linkedHashMap2.isEmpty() && hasThinking) {
                        String string2 = resources.getString(C0637R.string.trae_group_done_thinking);
                        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                        return string2;
                    }
                    ArrayList arrayList = new ArrayList();
                    for (Map.Entry entry2 : linkedHashMap2.entrySet()) {
                        ToolDisplayCategory toolDisplayCategory = (ToolDisplayCategory) entry2.getKey();
                        int intValue = ((Number) entry2.getValue()).intValue();
                        if (WhenMappings.$EnumSwitchMapping$0[toolDisplayCategory.getCountType().ordinal()] == 1) {
                            arrayList.add(toolDisplayCategory.getSummaryTitle(resources));
                        } else {
                            arrayList.add(toolDisplayCategory.getCompletedTitle(resources, intValue));
                        }
                    }
                    if (arrayList.isEmpty()) {
                        return ToolDisplayCategory.FALLBACK.getRunningTitle(resources);
                    }
                    String string3 = resources.getString(C0637R.string.trae_group_title_separator);
                    Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                    return CollectionsKt.joinToString$default(arrayList, string3, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
                }
            }
            z = false;
            if (z) {
            }
        }
    }

    public static ToolDisplayCategory valueOf(String str) {
        return (ToolDisplayCategory) Enum.valueOf(ToolDisplayCategory.class, str);
    }

    public static ToolDisplayCategory[] values() {
        return (ToolDisplayCategory[]) $VALUES.clone();
    }
}
