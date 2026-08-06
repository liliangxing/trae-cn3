package com.bytedance.sync.p005v4.net;

import android.content.Context;
import com.bytedance.sync.SyncEventCompat;
import com.bytedance.sync.p005v4.intf.IMsgSender;
import com.bytedance.sync.p005v4.intf.ISyncStatus;
import com.bytedance.sync.p005v4.model.PayloadEntry;
import com.bytedance.sync.p005v4.utils.ProtocolUtils;
import com.bytedance.sync.p005v4.utils.ToolUtils;
import com.bytedance.sync.util.JSONUtils;
import com.bytedance.trae.conversation.voice.subtask.SubTaskRequestMessage;
import com.ss.android.ug.bus.UgBusFramework;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public abstract class BaseMsgSender implements IMsgSender {
    protected final Context context;

    abstract int method();

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseMsgSender(Context context) {
        this.context = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onTraceSendMsg(PayloadEntry payloadEntry, int i, int i2, boolean z) {
        NetTrace netTrace = payloadEntry.trace;
        if (netTrace != null) {
            netTrace.mSendMethod = method();
            netTrace.mSendResult = i;
            netTrace.mSendMsgType = i2;
            netTrace.mIsConnect = z ? 1 : 0;
            netTrace.send();
        }
        if (ProtocolUtils.INSTANCE.isSyncMsg(i2)) {
            ((ISyncStatus) UgBusFramework.getService(ISyncStatus.class)).updateLastSendSyncMethod(method(), i, System.currentTimeMillis());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onEventSendMsg(PayloadEntry payloadEntry) {
        try {
            if (payloadEntry.sendReason != 3) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            JSONUtils.safePutParam(jSONObject, "ev_name", ProtocolUtils.INSTANCE.protocolMsgTypeString(payloadEntry.msg));
            String str = "http";
            JSONUtils.safePutParam(jSONObject, "ev_channel", method() == 1 ? "frontier" : "http");
            JSONUtils.safePutParam(jSONObject, "src", SubTaskRequestMessage.EXECUTOR_CLIENT);
            if (payloadEntry.sendReason == 1) {
                str = "cold";
            } else if (payloadEntry.sendReason == 2) {
                str = "timer";
            } else if (payloadEntry.sendReason == 3) {
                str = "switch";
            } else if (payloadEntry.sendReason == 4) {
                str = "reconnect";
            } else if (payloadEntry.sendReason == 5) {
                str = "data";
            } else if (payloadEntry.sendReason != 7) {
                str = payloadEntry.sendReason == 8 ? "biz" : "";
            }
            JSONUtils.safePutParam(jSONObject, "reason", str);
            JSONUtils.safePutParam(jSONObject, "start_ms", System.currentTimeMillis());
            if (!ToolUtils.isMainProcess(this.context)) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("process", ToolUtils.getCurProcessNameSuffix(this.context));
                JSONUtils.safePutParam(jSONObject, "extra", jSONObject2.toString());
            }
            SyncEventCompat.onEvent("sync_sdk_event_send", jSONObject);
        } catch (Throwable unused) {
        }
    }
}
