package com.bytedance.trae.conversation;

import com.bytedance.trae.im.service.Conversation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: ConversationProjectContext.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0000\u001a\u000e\u0010\u0003\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0000\u001a\u000e\u0010\u0004\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0000\u001a\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u0001H\u0000¨\u0006\u0006"}, d2 = {"ideProjectId", "", "Lcom/bytedance/trae/im/service/Conversation;", "ownerIdeProjectId", "ideProjectPath", "takeNotBlank", "conversation_mainlandRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ConversationProjectContextKt {
    public static final String ideProjectId(Conversation conversation) {
        Intrinsics.checkNotNullParameter(conversation, "<this>");
        String takeNotBlank = takeNotBlank(conversation.getOwnerProjectId());
        return takeNotBlank == null ? takeNotBlank(conversation.getLatestProjectId()) : takeNotBlank;
    }

    public static final String ownerIdeProjectId(Conversation conversation) {
        Intrinsics.checkNotNullParameter(conversation, "<this>");
        return takeNotBlank(conversation.getOwnerProjectId());
    }

    public static final String ideProjectPath(Conversation conversation) {
        Intrinsics.checkNotNullParameter(conversation, "<this>");
        String takeNotBlank = takeNotBlank(conversation.getOwnerProjectAbsolutePath());
        return takeNotBlank == null ? takeNotBlank(conversation.getWorkspace()) : takeNotBlank;
    }

    public static final String takeNotBlank(String str) {
        if (str == null || !(!StringsKt.isBlank(str))) {
            return null;
        }
        return str;
    }
}
