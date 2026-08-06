package com.bytedance.trae.conversation.chat.checkpoint;

import android.content.Context;
import android.view.View;
import com.bytedance.trae.conversation.chat.checkpoint.creators.AskUserQuestionDialogCreator;
import com.bytedance.trae.conversation.chat.checkpoint.creators.BrowserActionDialogCreator;
import com.bytedance.trae.conversation.chat.checkpoint.creators.CommandTimeoutDialogCreator;
import com.bytedance.trae.conversation.chat.checkpoint.creators.DeleteFileDialogCreator;
import com.bytedance.trae.conversation.chat.checkpoint.creators.ExitPlanModeDialogCreator;
import com.bytedance.trae.conversation.chat.checkpoint.creators.FallbackDialogCreator;
import com.bytedance.trae.conversation.chat.checkpoint.creators.MCPCallDialogCreator;
import com.bytedance.trae.conversation.chat.checkpoint.creators.NotifyUserDialogCreator;
import com.bytedance.trae.conversation.chat.checkpoint.creators.PluginAuthorizationDialogCreator;
import com.bytedance.trae.conversation.chat.checkpoint.creators.RunCommandDialogCreator;
import com.bytedance.trae.im.model.ConfirmInfo;
import com.bytedance.trae.im.model.ParsedToolCallInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: CheckpointDialogFactory.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010J\"\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016J)\u0010\u0017\u001a\u00020\u00182\u0012\u0010\u0019\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u001a\"\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0007H\u0002¢\u0006\u0002\u0010\u001cJ$\u0010\u001d\u001a\u00020\u00182\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u001b\u001a\u00020\u0007H\u0002R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R,\u0010\b\u001a \u0012\u001c\u0012\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0004\u0012\u00020\u00070\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogFactory;", "", "<init>", "()V", "exactMatch", "", "", "Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator;", "matcherList", "", "Lkotlin/Pair;", "Lkotlin/Function1;", "", "fallbackCreator", "getCreator", "toolCallInfo", "Lcom/bytedance/trae/im/model/ParsedToolCallInfo;", "createContentView", "Landroid/view/View;", "context", "Landroid/content/Context;", "confirmInfo", "Lcom/bytedance/trae/im/model/ConfirmInfo;", "register", "", "names", "", "creator", "([Ljava/lang/String;Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator;)V", "registerMatcher", "matcher", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class CheckpointDialogFactory {
    public static final CheckpointDialogFactory INSTANCE;
    private static final Map<String, ICheckpointDialogCreator> exactMatch;
    private static ICheckpointDialogCreator fallbackCreator;
    private static final List<Pair<Function1<String, Boolean>, ICheckpointDialogCreator>> matcherList;

    private CheckpointDialogFactory() {
    }

    static {
        CheckpointDialogFactory checkpointDialogFactory = new CheckpointDialogFactory();
        INSTANCE = checkpointDialogFactory;
        exactMatch = new LinkedHashMap();
        matcherList = new ArrayList();
        fallbackCreator = new FallbackDialogCreator();
        checkpointDialogFactory.register(new String[]{"run_command", "RunCommand", "Shell", "exec_command"}, new RunCommandDialogCreator());
        checkpointDialogFactory.register(new String[]{"AskUserQuestion"}, new AskUserQuestionDialogCreator());
        checkpointDialogFactory.register(new String[]{"NotifyUser"}, new NotifyUserDialogCreator());
        checkpointDialogFactory.register(new String[]{"delete_file", "DeleteFile"}, new DeleteFileDialogCreator());
        checkpointDialogFactory.register(new String[]{"run_mcp", "RunMcp"}, new MCPCallDialogCreator());
        checkpointDialogFactory.register(new String[]{"ExitPlanMode"}, new ExitPlanModeDialogCreator());
        checkpointDialogFactory.register(new String[]{"CommandTimeout"}, new CommandTimeoutDialogCreator());
        checkpointDialogFactory.register(new String[]{"RequestAuthorization"}, new PluginAuthorizationDialogCreator());
        checkpointDialogFactory.registerMatcher(new Function1() { // from class: com.bytedance.trae.conversation.chat.checkpoint.CheckpointDialogFactory$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                boolean _init_$lambda$0;
                _init_$lambda$0 = CheckpointDialogFactory._init_$lambda$0((String) obj);
                return Boolean.valueOf(_init_$lambda$0);
            }
        }, new BrowserActionDialogCreator());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _init_$lambda$0(String str) {
        Intrinsics.checkNotNullParameter(str, "it");
        return StringsKt.startsWith$default(str, "browser_", false, 2, (Object) null) || Intrinsics.areEqual(str, "BrowserHandOver") || Intrinsics.areEqual(str, "BrowserWaitingForUserInteraction");
    }

    public final ICheckpointDialogCreator getCreator(ParsedToolCallInfo toolCallInfo) {
        Object obj;
        Intrinsics.checkNotNullParameter(toolCallInfo, "toolCallInfo");
        String name = toolCallInfo.getName();
        if (name == null) {
            return fallbackCreator;
        }
        ICheckpointDialogCreator iCheckpointDialogCreator = exactMatch.get(name);
        if (iCheckpointDialogCreator != null) {
            return iCheckpointDialogCreator;
        }
        Iterator<T> it = matcherList.iterator();
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
        return pair != null ? (ICheckpointDialogCreator) pair.getSecond() : fallbackCreator;
    }

    public static /* synthetic */ View createContentView$default(CheckpointDialogFactory checkpointDialogFactory, Context context, ParsedToolCallInfo parsedToolCallInfo, ConfirmInfo confirmInfo, int i, Object obj) {
        if ((i & 4) != 0) {
            confirmInfo = null;
        }
        return checkpointDialogFactory.createContentView(context, parsedToolCallInfo, confirmInfo);
    }

    public final View createContentView(Context context, ParsedToolCallInfo toolCallInfo, ConfirmInfo confirmInfo) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(toolCallInfo, "toolCallInfo");
        return getCreator(toolCallInfo).createContentView(context, toolCallInfo, confirmInfo);
    }

    private final void registerMatcher(Function1<? super String, Boolean> matcher, ICheckpointDialogCreator creator) {
        matcherList.add(TuplesKt.to(matcher, creator));
    }

    private final void register(String[] names, ICheckpointDialogCreator creator) {
        for (String str : names) {
            exactMatch.put(str, creator);
        }
    }
}
