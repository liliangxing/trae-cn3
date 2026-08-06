package com.bytedance.trae.conversation.chat.detail;

import com.bytedance.trae.conversation.chat.block.AgentContentBlock;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DetailSegment.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/trae/conversation/chat/detail/DetailSegment;", "", "<init>", "()V", "ToolSegment", "ThoughtSegment", "SubAgentSegment", "Lcom/bytedance/trae/conversation/chat/detail/DetailSegment$SubAgentSegment;", "Lcom/bytedance/trae/conversation/chat/detail/DetailSegment$ThoughtSegment;", "Lcom/bytedance/trae/conversation/chat/detail/DetailSegment$ToolSegment;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public abstract class DetailSegment {
    public /* synthetic */ DetailSegment(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private DetailSegment() {
    }

    /* compiled from: DetailSegment.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/bytedance/trae/conversation/chat/detail/DetailSegment$ToolSegment;", "Lcom/bytedance/trae/conversation/chat/detail/DetailSegment;", "title", "", "children", "", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "getTitle", "()Ljava/lang/String;", "getChildren", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class ToolSegment extends DetailSegment {
        private final List<AgentContentBlock> children;
        private final String title;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ToolSegment copy$default(ToolSegment toolSegment, String str, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = toolSegment.title;
            }
            if ((i & 2) != 0) {
                list = toolSegment.children;
            }
            return toolSegment.copy(str, list);
        }

        /* renamed from: component1, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        public final List<AgentContentBlock> component2() {
            return this.children;
        }

        public final ToolSegment copy(String title, List<? extends AgentContentBlock> children) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(children, "children");
            return new ToolSegment(title, children);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ToolSegment)) {
                return false;
            }
            ToolSegment toolSegment = (ToolSegment) other;
            return Intrinsics.areEqual(this.title, toolSegment.title) && Intrinsics.areEqual(this.children, toolSegment.children);
        }

        public int hashCode() {
            return (this.title.hashCode() * 31) + this.children.hashCode();
        }

        public String toString() {
            return "ToolSegment(title=" + this.title + ", children=" + this.children + ')';
        }

        public final String getTitle() {
            return this.title;
        }

        public final List<AgentContentBlock> getChildren() {
            return this.children;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public ToolSegment(String str, List<? extends AgentContentBlock> list) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(list, "children");
            this.title = str;
            this.children = list;
        }
    }

    /* compiled from: DetailSegment.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/bytedance/trae/conversation/chat/detail/DetailSegment$ThoughtSegment;", "Lcom/bytedance/trae/conversation/chat/detail/DetailSegment;", "thought", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Thought;", "<init>", "(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Thought;)V", "getThought", "()Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Thought;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class ThoughtSegment extends DetailSegment {
        private final AgentContentBlock.Thought thought;

        public static /* synthetic */ ThoughtSegment copy$default(ThoughtSegment thoughtSegment, AgentContentBlock.Thought thought, int i, Object obj) {
            if ((i & 1) != 0) {
                thought = thoughtSegment.thought;
            }
            return thoughtSegment.copy(thought);
        }

        /* renamed from: component1, reason: from getter */
        public final AgentContentBlock.Thought getThought() {
            return this.thought;
        }

        public final ThoughtSegment copy(AgentContentBlock.Thought thought) {
            Intrinsics.checkNotNullParameter(thought, "thought");
            return new ThoughtSegment(thought);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ThoughtSegment) && Intrinsics.areEqual(this.thought, ((ThoughtSegment) other).thought);
        }

        public int hashCode() {
            return this.thought.hashCode();
        }

        public String toString() {
            return "ThoughtSegment(thought=" + this.thought + ')';
        }

        public final AgentContentBlock.Thought getThought() {
            return this.thought;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ThoughtSegment(AgentContentBlock.Thought thought) {
            super(null);
            Intrinsics.checkNotNullParameter(thought, "thought");
            this.thought = thought;
        }
    }

    /* compiled from: DetailSegment.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/bytedance/trae/conversation/chat/detail/DetailSegment$SubAgentSegment;", "Lcom/bytedance/trae/conversation/chat/detail/DetailSegment;", "subAgent", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;", "<init>", "(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;)V", "getSubAgent", "()Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class SubAgentSegment extends DetailSegment {
        private final AgentContentBlock.SubAgentGroup subAgent;

        public static /* synthetic */ SubAgentSegment copy$default(SubAgentSegment subAgentSegment, AgentContentBlock.SubAgentGroup subAgentGroup, int i, Object obj) {
            if ((i & 1) != 0) {
                subAgentGroup = subAgentSegment.subAgent;
            }
            return subAgentSegment.copy(subAgentGroup);
        }

        /* renamed from: component1, reason: from getter */
        public final AgentContentBlock.SubAgentGroup getSubAgent() {
            return this.subAgent;
        }

        public final SubAgentSegment copy(AgentContentBlock.SubAgentGroup subAgent) {
            Intrinsics.checkNotNullParameter(subAgent, "subAgent");
            return new SubAgentSegment(subAgent);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof SubAgentSegment) && Intrinsics.areEqual(this.subAgent, ((SubAgentSegment) other).subAgent);
        }

        public int hashCode() {
            return this.subAgent.hashCode();
        }

        public String toString() {
            return "SubAgentSegment(subAgent=" + this.subAgent + ')';
        }

        public final AgentContentBlock.SubAgentGroup getSubAgent() {
            return this.subAgent;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SubAgentSegment(AgentContentBlock.SubAgentGroup subAgentGroup) {
            super(null);
            Intrinsics.checkNotNullParameter(subAgentGroup, "subAgent");
            this.subAgent = subAgentGroup;
        }
    }
}
