package com.bytedance.trae.conversation.chat;

import com.bytedance.trae.im.model.ParsedChatMessage;
import com.bytedance.trae.im.service.Conversation;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public interface IMessageListener {
    List<ParsedChatMessage> getAllMessages();

    Conversation getCurrentConversation();

    boolean isStreaming();
}
