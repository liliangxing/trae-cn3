package com.bytedance.trae.conversation.skill;

import com.bytedance.trae.conversation.R;
import kotlin.Metadata;

/* compiled from: SkillsEmptyStateTextPolicy.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/conversation/skill/SkillsEmptyStateTextPolicy;", "", "<init>", "()V", "emptyStateTextRes", "", "isIdeSkills", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SkillsEmptyStateTextPolicy {
    public static final SkillsEmptyStateTextPolicy INSTANCE = new SkillsEmptyStateTextPolicy();

    private SkillsEmptyStateTextPolicy() {
    }

    public final int emptyStateTextRes(boolean isIdeSkills) {
        if (isIdeSkills) {
            return R.string.trae_skills_empty_ide;
        }
        return R.string.trae_skills_empty;
    }
}
