package com.bytedance.trae.conversation;

import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.im.database.ConversationDao;
import com.bytedance.trae.im.database.DatabaseManager;
import com.bytedance.trae.im.service.Conversation;
import com.bytedance.trae.login.api.AccountInfo;
import com.bytedance.trae.login.api.ILoginService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;

/* compiled from: ConversationUtils.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0005¨\u0006\t"}, d2 = {"Lcom/bytedance/trae/conversation/ConversationUtils;", "", "<init>", "()V", "resolveInitialConversation", "Lcom/bytedance/trae/im/service/Conversation;", "conversationId", "", "conversation", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ConversationUtils {
    public static final ConversationUtils INSTANCE = new ConversationUtils();

    private ConversationUtils() {
    }

    public final Conversation resolveInitialConversation(String conversationId, Conversation conversation) {
        AccountInfo accountInfo;
        String userId;
        if (conversation == null) {
            String str = conversationId;
            if (!(str == null || str.length() == 0)) {
                ILoginService iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
                if (iLoginService == null || (accountInfo = iLoginService.getAccountInfo()) == null || (userId = accountInfo.getUserId()) == null) {
                    return null;
                }
                return new ConversationDao(DatabaseManager.INSTANCE.getDatabase(AppHost.INSTANCE.getApplication(), userId)).queryById(conversationId);
            }
        }
        return conversation;
    }
}
