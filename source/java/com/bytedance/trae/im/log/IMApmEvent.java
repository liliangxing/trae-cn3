package com.bytedance.trae.im.log;

import com.bytedance.timonbase.scene.PageDataManager;
import com.bytedance.trae.im.model.ParsedChatMessage;
import com.bytedance.trae.platform.service.ApmService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: IMApmEvent.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/trae/im/log/IMApmEvent;", "", "<init>", "()V", "reportMessageStatus", "", "message", "Lcom/bytedance/trae/im/model/ParsedChatMessage;", "replyToMessageId", "", PageDataManager.EXTRA_STATUS, "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class IMApmEvent {
    public static final IMApmEvent INSTANCE = new IMApmEvent();

    private IMApmEvent() {
    }

    public final void reportMessageStatus(ParsedChatMessage message, String replyToMessageId, String status) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(replyToMessageId, "replyToMessageId");
        Intrinsics.checkNotNullParameter(status, PageDataManager.EXTRA_STATUS);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(PageDataManager.EXTRA_STATUS, status);
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("message_id", message.getMessageId());
            jSONObject3.put("reply_message_id", message.getReplyToMessageId());
            jSONObject3.put("extra_reply_message_id", replyToMessageId);
            jSONObject3.put("session_id", message.getSessionId());
            String turnId = message.getTurnId();
            if (turnId == null) {
                turnId = "";
            }
            jSONObject3.put("turn_id", turnId);
            jSONObject3.put("create_at", message.getCreatedAt());
            ApmService.INSTANCE.monitorEventForSlardar("im_event_monitor", jSONObject, jSONObject2, jSONObject3);
        } catch (Throwable unused) {
        }
    }
}
