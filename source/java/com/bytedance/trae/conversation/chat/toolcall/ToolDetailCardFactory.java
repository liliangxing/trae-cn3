package com.bytedance.trae.conversation.chat.toolcall;

import android.content.Context;
import com.bytedance.trae.conversation.chat.toolcall.cards.detail.AskUserQuestionCardCreator;
import com.bytedance.trae.conversation.chat.toolcall.cards.detail.BrowserActionDetailCardCreator;
import com.bytedance.trae.conversation.chat.toolcall.cards.detail.DeleteFileDetailCardCreator;
import com.bytedance.trae.conversation.chat.toolcall.cards.detail.EditFileDetailCardCreator;
import com.bytedance.trae.conversation.chat.toolcall.cards.detail.EnvironmentSetupDetailCardCreator;
import com.bytedance.trae.conversation.chat.toolcall.cards.detail.FallbackDetailCardCreator;
import com.bytedance.trae.conversation.chat.toolcall.cards.detail.ImageGenerateDetailCardCreator;
import com.bytedance.trae.conversation.chat.toolcall.cards.detail.OpenPreviewDetailCardCreator;
import com.bytedance.trae.conversation.chat.toolcall.cards.detail.RequestAuthorizationDetailCardCreator;
import com.bytedance.trae.conversation.chat.toolcall.cards.detail.RunCommandDetailCardCreator;
import com.bytedance.trae.conversation.chat.toolcall.cards.detail.RunMCPCardCreator;
import com.bytedance.trae.conversation.chat.toolcall.cards.detail.SearchDetailCardCreator;
import com.bytedance.trae.conversation.chat.toolcall.cards.detail.SkillDetailCardCreator;
import com.bytedance.trae.conversation.chat.toolcall.cards.detail.TasksListDetailCardCreator;
import com.bytedance.trae.conversation.chat.toolcall.cards.detail.ThinkingDetailCardCreator;
import com.bytedance.trae.conversation.chat.toolcall.cards.detail.ViewFileDetailCardCreator;
import com.bytedance.trae.conversation.chat.toolcall.cards.detail.WebSearchDetailCardCreator;
import com.bytedance.trae.im.model.ParsedToolCallInfo;
import com.bytedance.trae.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

/* compiled from: ToolDetailCardFactory.kt */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018J\"\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018J$\u0010\u001a\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018J$\u0010\u001b\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018J'\u0010\u001c\u001a\u00020\u001d2\u0012\u0010\u001e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u001f\"\u00020\u00052\u0006\u0010 \u001a\u00020\b¢\u0006\u0002\u0010!J\"\u0010\"\u001a\u00020\u001d2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010 \u001a\u00020\bJ)\u0010$\u001a\u00020\u001d2\u0012\u0010\u001e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u001f\"\u00020\u00052\u0006\u0010 \u001a\u00020\bH\u0002¢\u0006\u0002\u0010!J$\u0010%\u001a\u00020\u001d2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010 \u001a\u00020\bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R,\u0010\t\u001a \u0012\u001c\u0012\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r0\f\u0012\u0004\u0012\u00020\b0\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCardFactory;", "", "<init>", "()V", "TOOL_TAG", "", "exactCreators", "", "Lcom/bytedance/trae/conversation/chat/toolcall/IToolDetailCardCreator;", "matcherCreators", "", "Lkotlin/Pair;", "Lkotlin/Function1;", "", "fallbackCreator", "thinkingCreator", "Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ThinkingDetailCardCreator;", "createDetailCard", "Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;", "context", "Landroid/content/Context;", "toolCallInfo", "Lcom/bytedance/trae/im/model/ParsedToolCallInfo;", "planItemContext", "Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;", "createThinkingCard", "updateDetailCard", "updateThinkingCard", "registerExternal", "", "names", "", "creator", "([Ljava/lang/String;Lcom/bytedance/trae/conversation/chat/toolcall/IToolDetailCardCreator;)V", "registerExternalMatcher", "matcher", "register", "registerMatcher", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ToolDetailCardFactory {
    public static final ToolDetailCardFactory INSTANCE;
    private static final String TOOL_TAG = "AgentTool";
    private static final Map<String, IToolDetailCardCreator> exactCreators;
    private static IToolDetailCardCreator fallbackCreator;
    private static final List<Pair<Function1<String, Boolean>, IToolDetailCardCreator>> matcherCreators;
    private static final ThinkingDetailCardCreator thinkingCreator;

    private ToolDetailCardFactory() {
    }

    static {
        ToolDetailCardFactory toolDetailCardFactory = new ToolDetailCardFactory();
        INSTANCE = toolDetailCardFactory;
        exactCreators = new LinkedHashMap();
        matcherCreators = new ArrayList();
        fallbackCreator = new FallbackDetailCardCreator();
        thinkingCreator = new ThinkingDetailCardCreator();
        toolDetailCardFactory.register(new String[]{"edit_file", "edit_file_search_replace", "edit_file_update", "create_file", "write_to_file", "Write", "Edit", "MultiEdit", "SearchReplace"}, new EditFileDetailCardCreator());
        toolDetailCardFactory.register(new String[]{"Read", "view_file", "view_files", "view_folder", "LS"}, new ViewFileDetailCardCreator());
        toolDetailCardFactory.register(new String[]{"delete_file", "DeleteFile"}, new DeleteFileDetailCardCreator());
        toolDetailCardFactory.register(new String[]{"SearchCodebase", "Grep", "Glob", "file_search", "search_codebase", "search_by_regex"}, new SearchDetailCardCreator());
        toolDetailCardFactory.register(new String[]{"run_command", "RunCommand", "Shell", "exec_command"}, new RunCommandDetailCardCreator());
        toolDetailCardFactory.register(new String[]{"run_mcp", "mcp_call", "MCPCall"}, new RunMCPCardCreator());
        toolDetailCardFactory.register(new String[]{"web_search", "WebSearch"}, new WebSearchDetailCardCreator());
        toolDetailCardFactory.register(new String[]{"todo_write", "TodoWrite"}, new TasksListDetailCardCreator());
        toolDetailCardFactory.register(new String[]{"AskUserQuestion"}, new AskUserQuestionCardCreator());
        toolDetailCardFactory.registerMatcher(new Function1() { // from class: com.bytedance.trae.conversation.chat.toolcall.ToolDetailCardFactory$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                boolean _init_$lambda$0;
                _init_$lambda$0 = ToolDetailCardFactory._init_$lambda$0((String) obj);
                return Boolean.valueOf(_init_$lambda$0);
            }
        }, new BrowserActionDetailCardCreator());
        toolDetailCardFactory.register(new String[]{"Skill"}, new SkillDetailCardCreator());
        toolDetailCardFactory.register(new String[]{"open_preview", "OpenPreview", "open_preview_and_wait_for_error"}, new OpenPreviewDetailCardCreator());
        toolDetailCardFactory.register(new String[]{"environment_setup", "EnvironmentSetup"}, new EnvironmentSetupDetailCardCreator());
        toolDetailCardFactory.register(new String[]{"image_ocr", "GenerateImage"}, new ImageGenerateDetailCardCreator());
        toolDetailCardFactory.register(new String[]{"RequestAuthorization"}, new RequestAuthorizationDetailCardCreator());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _init_$lambda$0(String str) {
        Intrinsics.checkNotNullParameter(str, "it");
        return StringsKt.startsWith$default(str, "browser_", false, 2, (Object) null) || Intrinsics.areEqual(str, "BrowserHandOver") || Intrinsics.areEqual(str, "BrowserWaitingForUserInteraction");
    }

    public static /* synthetic */ ToolDetailCard createDetailCard$default(ToolDetailCardFactory toolDetailCardFactory, Context context, ParsedToolCallInfo parsedToolCallInfo, PlanItemContext planItemContext, int i, Object obj) {
        if ((i & 4) != 0) {
            planItemContext = null;
        }
        return toolDetailCardFactory.createDetailCard(context, parsedToolCallInfo, planItemContext);
    }

    public final ToolDetailCard createDetailCard(Context context, ParsedToolCallInfo toolCallInfo, PlanItemContext planItemContext) {
        Object obj;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(toolCallInfo, "toolCallInfo");
        String name = toolCallInfo.getName();
        if (name == null) {
            FLogger.INSTANCE.i("AgentTool", "[Factory] createDetailCard: name=null, using fallback, id=" + toolCallInfo.getId());
            return fallbackCreator.createDetail(context, toolCallInfo, planItemContext);
        }
        IToolDetailCardCreator iToolDetailCardCreator = exactCreators.get(name);
        if (iToolDetailCardCreator != null) {
            FLogger.INSTANCE.i("AgentTool", "[Factory] createDetailCard: exact match name=" + name + ", creator=" + Reflection.getOrCreateKotlinClass(iToolDetailCardCreator.getClass()).getSimpleName());
            return iToolDetailCardCreator.createDetail(context, toolCallInfo, planItemContext);
        }
        Iterator<T> it = matcherCreators.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((Boolean) ((Function1) ((Pair) obj).getFirst()).invoke(name)).booleanValue()) {
                break;
            }
        }
        Pair pair = (Pair) obj;
        if (pair != null) {
            FLogger.INSTANCE.i("AgentTool", "[Factory] createDetailCard: matcher match name=" + name + ", creator=" + Reflection.getOrCreateKotlinClass(pair.getSecond().getClass()).getSimpleName());
            return ((IToolDetailCardCreator) pair.getSecond()).createDetail(context, toolCallInfo, planItemContext);
        }
        FLogger.INSTANCE.i("AgentTool", "[Factory] createDetailCard: no match, fallback for name=" + name);
        return fallbackCreator.createDetail(context, toolCallInfo, planItemContext);
    }

    public static /* synthetic */ ToolDetailCard createThinkingCard$default(ToolDetailCardFactory toolDetailCardFactory, Context context, ParsedToolCallInfo parsedToolCallInfo, PlanItemContext planItemContext, int i, Object obj) {
        if ((i & 4) != 0) {
            planItemContext = null;
        }
        return toolDetailCardFactory.createThinkingCard(context, parsedToolCallInfo, planItemContext);
    }

    public final ToolDetailCard createThinkingCard(Context context, ParsedToolCallInfo toolCallInfo, PlanItemContext planItemContext) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(toolCallInfo, "toolCallInfo");
        return thinkingCreator.createDetail(context, toolCallInfo, planItemContext);
    }

    public static /* synthetic */ ToolDetailCard updateDetailCard$default(ToolDetailCardFactory toolDetailCardFactory, Context context, ParsedToolCallInfo parsedToolCallInfo, PlanItemContext planItemContext, int i, Object obj) {
        if ((i & 4) != 0) {
            planItemContext = null;
        }
        return toolDetailCardFactory.updateDetailCard(context, parsedToolCallInfo, planItemContext);
    }

    public final ToolDetailCard updateDetailCard(Context context, ParsedToolCallInfo toolCallInfo, PlanItemContext planItemContext) {
        Object obj;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(toolCallInfo, "toolCallInfo");
        String id = toolCallInfo.getId();
        if (id == null) {
            return null;
        }
        String name = toolCallInfo.getName();
        if (name == null) {
            IToolDetailCardCreator iToolDetailCardCreator = fallbackCreator;
            BaseToolDetailCardCreator baseToolDetailCardCreator = iToolDetailCardCreator instanceof BaseToolDetailCardCreator ? (BaseToolDetailCardCreator) iToolDetailCardCreator : null;
            if (baseToolDetailCardCreator != null) {
                return baseToolDetailCardCreator.updateCard(context, id, toolCallInfo, planItemContext);
            }
            return null;
        }
        IToolDetailCardCreator iToolDetailCardCreator2 = exactCreators.get(name);
        if (iToolDetailCardCreator2 == null) {
            Iterator<T> it = matcherCreators.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (((Boolean) ((Function1) ((Pair) obj).getFirst()).invoke(name)).booleanValue()) {
                    break;
                }
            }
            Pair pair = (Pair) obj;
            iToolDetailCardCreator2 = pair != null ? (IToolDetailCardCreator) pair.getSecond() : null;
            if (iToolDetailCardCreator2 == null) {
                iToolDetailCardCreator2 = fallbackCreator;
            }
        }
        BaseToolDetailCardCreator baseToolDetailCardCreator2 = iToolDetailCardCreator2 instanceof BaseToolDetailCardCreator ? (BaseToolDetailCardCreator) iToolDetailCardCreator2 : null;
        ToolDetailCard updateCard = baseToolDetailCardCreator2 != null ? baseToolDetailCardCreator2.updateCard(context, id, toolCallInfo, planItemContext) : null;
        FLogger.INSTANCE.d("AgentTool", "[Factory] updateDetailCard: name=" + name + ", id=" + id);
        return updateCard;
    }

    public static /* synthetic */ ToolDetailCard updateThinkingCard$default(ToolDetailCardFactory toolDetailCardFactory, Context context, ParsedToolCallInfo parsedToolCallInfo, PlanItemContext planItemContext, int i, Object obj) {
        if ((i & 4) != 0) {
            planItemContext = null;
        }
        return toolDetailCardFactory.updateThinkingCard(context, parsedToolCallInfo, planItemContext);
    }

    public final ToolDetailCard updateThinkingCard(Context context, ParsedToolCallInfo toolCallInfo, PlanItemContext planItemContext) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(toolCallInfo, "toolCallInfo");
        String id = toolCallInfo.getId();
        if (id == null) {
            String planItemId = planItemContext != null ? planItemContext.getPlanItemId() : null;
            if (planItemId == null) {
                return null;
            }
            id = planItemId;
        }
        return thinkingCreator.updateCard(context, id, toolCallInfo, planItemContext);
    }

    public final void registerExternal(String[] names, IToolDetailCardCreator creator) {
        Intrinsics.checkNotNullParameter(names, "names");
        Intrinsics.checkNotNullParameter(creator, "creator");
        register((String[]) Arrays.copyOf(names, names.length), creator);
    }

    public final void registerExternalMatcher(Function1<? super String, Boolean> matcher, IToolDetailCardCreator creator) {
        Intrinsics.checkNotNullParameter(matcher, "matcher");
        Intrinsics.checkNotNullParameter(creator, "creator");
        registerMatcher(matcher, creator);
    }

    private final void registerMatcher(Function1<? super String, Boolean> matcher, IToolDetailCardCreator creator) {
        matcherCreators.add(TuplesKt.to(matcher, creator));
    }

    private final void register(String[] names, IToolDetailCardCreator creator) {
        for (String str : names) {
            exactCreators.put(str, creator);
        }
    }
}
