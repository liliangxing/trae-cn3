package com.bytedance.trae.conversation.chat.detail;

import com.bytedance.trae.conversation.chat.block.AgentContentBlock;
import com.bytedance.trae.conversation.chat.detail.DetailSegment;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* compiled from: DetailSegmenter.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0002J\u0016\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u0005H\u0002J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\rH\u0002¨\u0006\u0011"}, d2 = {"Lcom/bytedance/trae/conversation/chat/detail/DetailSegmenter;", "", "<init>", "()V", "segment", "", "Lcom/bytedance/trae/conversation/chat/detail/DetailSegment;", "children", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;", "isToolBlock", "", "block", "buildSegmentTitle", "", "blocks", "mapToolNameToLabel", "name", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class DetailSegmenter {
    public static final DetailSegmenter INSTANCE = new DetailSegmenter();

    private DetailSegmenter() {
    }

    public final List<DetailSegment> segment(List<? extends AgentContentBlock> children) {
        Intrinsics.checkNotNullParameter(children, "children");
        ArrayList arrayList = new ArrayList();
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = new ArrayList();
        for (AgentContentBlock agentContentBlock : children) {
            if (isToolBlock(agentContentBlock)) {
                ((List) objectRef.element).add(agentContentBlock);
            } else if (agentContentBlock instanceof AgentContentBlock.Thought) {
                segment$flushToolBuffer(objectRef, arrayList);
                arrayList.add(new DetailSegment.ThoughtSegment((AgentContentBlock.Thought) agentContentBlock));
            } else if (agentContentBlock instanceof AgentContentBlock.SubAgentGroup) {
                segment$flushToolBuffer(objectRef, arrayList);
                arrayList.add(new DetailSegment.SubAgentSegment((AgentContentBlock.SubAgentGroup) agentContentBlock));
            } else {
                segment$flushToolBuffer(objectRef, arrayList);
            }
        }
        segment$flushToolBuffer(objectRef, arrayList);
        return arrayList;
    }

    private static final void segment$flushToolBuffer(Ref.ObjectRef<List<AgentContentBlock>> objectRef, List<DetailSegment> list) {
        if (!((Collection) objectRef.element).isEmpty()) {
            list.add(new DetailSegment.ToolSegment(INSTANCE.buildSegmentTitle((List) objectRef.element), CollectionsKt.toList((Iterable) objectRef.element)));
            objectRef.element = new ArrayList();
        }
    }

    private final boolean isToolBlock(AgentContentBlock block) {
        return (block instanceof AgentContentBlock.Toolcall) || (block instanceof AgentContentBlock.Thinking) || (block instanceof AgentContentBlock.ToolcallGroup) || (block instanceof AgentContentBlock.TodoGroup);
    }

    private final String buildSegmentTitle(List<? extends AgentContentBlock> blocks) {
        ArrayList arrayList = new ArrayList();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int i = 0;
        for (AgentContentBlock agentContentBlock : blocks) {
            if (agentContentBlock instanceof AgentContentBlock.Thinking) {
                i++;
            } else if (agentContentBlock instanceof AgentContentBlock.Toolcall) {
                String name = ((AgentContentBlock.Toolcall) agentContentBlock).getToolCallInfo().getName();
                if (name == null) {
                    name = "tool";
                }
                Integer num = (Integer) linkedHashMap.get(name);
                linkedHashMap.put(name, Integer.valueOf((num != null ? num.intValue() : 0) + 1));
            } else if (agentContentBlock instanceof AgentContentBlock.ToolcallGroup) {
                arrayList.add(((AgentContentBlock.ToolcallGroup) agentContentBlock).getTitle());
            } else if (agentContentBlock instanceof AgentContentBlock.TodoGroup) {
                String title = ((AgentContentBlock.TodoGroup) agentContentBlock).getTitle();
                if (title == null) {
                    title = "Todo";
                }
                arrayList.add(title);
            }
        }
        if (i > 0) {
            arrayList.add(0, "Thought");
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            String str = (String) entry.getKey();
            int intValue = ((Number) entry.getValue()).intValue();
            String mapToolNameToLabel = mapToolNameToLabel(str);
            if (intValue > 1) {
                mapToolNameToLabel = mapToolNameToLabel + ' ' + intValue + " files";
            }
            arrayList.add(mapToolNameToLabel);
        }
        return arrayList.isEmpty() ? "Tools" : CollectionsKt.joinToString$default(arrayList, ", ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }

    private final String mapToolNameToLabel(String name) {
        String str = name;
        return (StringsKt.contains(str, "search", true) || Intrinsics.areEqual(name, "Grep") || Intrinsics.areEqual(name, "Glob")) ? "Searched" : (StringsKt.contains(str, "read", true) || Intrinsics.areEqual(name, "view_file") || Intrinsics.areEqual(name, "view_files") || Intrinsics.areEqual(name, "Read")) ? "Read" : (StringsKt.contains(str, "edit", true) || Intrinsics.areEqual(name, "Write") || Intrinsics.areEqual(name, "Edit") || Intrinsics.areEqual(name, "MultiEdit") || Intrinsics.areEqual(name, "SearchReplace")) ? "Edited" : (StringsKt.contains(str, "delete", true) || Intrinsics.areEqual(name, "DeleteFile")) ? "Deleted" : (Intrinsics.areEqual(name, "run_command") || Intrinsics.areEqual(name, "RunCommand") || Intrinsics.areEqual(name, "Shell") || Intrinsics.areEqual(name, "exec_command")) ? "Executed" : StringsKt.startsWith$default(name, "browser_", false, 2, (Object) null) ? "Browser" : name;
    }
}
