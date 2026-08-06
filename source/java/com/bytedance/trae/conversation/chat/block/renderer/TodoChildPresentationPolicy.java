package com.bytedance.trae.conversation.chat.block.renderer;

import com.bytedance.trae.conversation.chat.block.AgentContentBlock;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TodoChildPresentationPolicy.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J\u0014\u0010\b\u001a\u00020\t2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J\u0014\u0010\n\u001a\u00020\t2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0006H\u0002¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildPresentationPolicy;", "", "<init>", "()V", "visibleChildren", "", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;", "children", "shouldAutoExpand", "", "containsPureShowWidget", "block", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TodoChildPresentationPolicy {
    public static final TodoChildPresentationPolicy INSTANCE = new TodoChildPresentationPolicy();

    private TodoChildPresentationPolicy() {
    }

    public final List<AgentContentBlock> visibleChildren(List<? extends AgentContentBlock> children) {
        Intrinsics.checkNotNullParameter(children, "children");
        ArrayList arrayList = new ArrayList();
        for (Object obj : children) {
            AgentContentBlock agentContentBlock = (AgentContentBlock) obj;
            if ((agentContentBlock instanceof AgentContentBlock.Thought) || (agentContentBlock instanceof AgentContentBlock.Toolcall) || (agentContentBlock instanceof AgentContentBlock.ToolcallGroup) || (agentContentBlock instanceof AgentContentBlock.PureShowWidgetToolcallGroup) || (agentContentBlock instanceof AgentContentBlock.SubAgentGroup)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public final boolean shouldAutoExpand(List<? extends AgentContentBlock> children) {
        Intrinsics.checkNotNullParameter(children, "children");
        return containsPureShowWidget(children);
    }

    public final boolean containsPureShowWidget(List<? extends AgentContentBlock> children) {
        Intrinsics.checkNotNullParameter(children, "children");
        List<? extends AgentContentBlock> list = children;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (containsPureShowWidget((AgentContentBlock) it.next())) {
                return true;
            }
        }
        return false;
    }

    private final boolean containsPureShowWidget(AgentContentBlock block) {
        if (block instanceof AgentContentBlock.PureShowWidgetToolcallGroup) {
            return true;
        }
        if (!(block instanceof AgentContentBlock.TodoGroup)) {
            if (!(block instanceof AgentContentBlock.SubAgentGroup)) {
                if (block instanceof AgentContentBlock.ToolcallGroup) {
                    List<AgentContentBlock> children = ((AgentContentBlock.ToolcallGroup) block).getChildren();
                    if (!(children instanceof Collection) || !children.isEmpty()) {
                        Iterator<T> it = children.iterator();
                        while (it.hasNext()) {
                            if (containsPureShowWidget((AgentContentBlock) it.next())) {
                                return true;
                            }
                        }
                    }
                }
            } else {
                List<AgentContentBlock> children2 = ((AgentContentBlock.SubAgentGroup) block).getChildren();
                if (!(children2 instanceof Collection) || !children2.isEmpty()) {
                    Iterator<T> it2 = children2.iterator();
                    while (it2.hasNext()) {
                        if (containsPureShowWidget((AgentContentBlock) it2.next())) {
                            return true;
                        }
                    }
                }
            }
        } else {
            List<AgentContentBlock> children3 = ((AgentContentBlock.TodoGroup) block).getChildren();
            if (!(children3 instanceof Collection) || !children3.isEmpty()) {
                Iterator<T> it3 = children3.iterator();
                while (it3.hasNext()) {
                    if (containsPureShowWidget((AgentContentBlock) it3.next())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
