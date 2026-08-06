package com.bytedance.trae.conversation.ideproject;

import com.bytedance.trae.conversation.network.ProjectItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IDEProjectListPolicy.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/conversation/ideproject/IDEProjectListPolicy;", "", "<init>", "()V", "visibleProjects", "", "Lcom/bytedance/trae/conversation/network/ProjectItem;", "projects", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class IDEProjectListPolicy {
    public static final IDEProjectListPolicy INSTANCE = new IDEProjectListPolicy();

    public final List<ProjectItem> visibleProjects(List<ProjectItem> projects) {
        Intrinsics.checkNotNullParameter(projects, "projects");
        return projects;
    }

    private IDEProjectListPolicy() {
    }
}
