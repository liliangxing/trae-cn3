package com.bytedance.sync.p005v4.net;

import android.content.Context;
import com.bytedance.sync.interfaze.ISettings;
import com.bytedance.sync.logger.LogUtils;
import com.bytedance.sync.p005v4.intf.IMsgSender;
import com.bytedance.sync.p005v4.intf.IProtocolProcessor;
import com.bytedance.sync.p005v4.model.PayloadEntry;
import com.bytedance.sync.p005v4.protocal.BsyncProtocol;
import com.bytedance.sync.p005v4.protocal.BsyncTopic;
import com.bytedance.sync.p005v4.protocal.Flag;
import com.bytedance.sync.settings.SyncSettings;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class MsgSenderV4 implements IMsgSender {
    static final String TAG = "[SendMsgV4] ";
    private final Context context;
    private final IMsgSender mHttpSender;
    private final WsMsgSenderV4 mWsSender;
    private final AtomicBoolean processing = new AtomicBoolean(false);
    private final LinkedBlockingQueue<PayloadEntry> mMessageDequeue = new LinkedBlockingQueue<>();

    public MsgSenderV4(Context context, IProtocolProcessor iProtocolProcessor) {
        this.context = context;
        this.mWsSender = new WsMsgSenderV4(context, new IMsgSender() { // from class: com.bytedance.sync.v4.net.MsgSenderV4.1
            @Override // com.bytedance.sync.p005v4.intf.IMsgSender
            public void send(PayloadEntry payloadEntry) {
                if (MsgSenderV4.this.mHttpSender != null) {
                    MsgSenderV4.this.mHttpSender.send(payloadEntry);
                }
            }

            @Override // com.bytedance.sync.p005v4.intf.IMsgSender
            public boolean isPendingPayloadToSend() {
                if (MsgSenderV4.this.mHttpSender == null) {
                    return false;
                }
                MsgSenderV4.this.mHttpSender.isPendingPayloadToSend();
                return false;
            }
        });
        this.mHttpSender = new HttpMsgSender(context, iProtocolProcessor, new IMsgSender() { // from class: com.bytedance.sync.v4.net.MsgSenderV4.2
            @Override // com.bytedance.sync.p005v4.intf.IMsgSender
            public void send(PayloadEntry payloadEntry) {
                MsgSenderV4.this.mWsSender.send(payloadEntry);
            }

            @Override // com.bytedance.sync.p005v4.intf.IMsgSender
            public boolean isPendingPayloadToSend() {
                return MsgSenderV4.this.mWsSender.isPendingPayloadToSend();
            }
        });
    }

    @Override // com.bytedance.sync.p005v4.intf.IMsgSender
    public void send(PayloadEntry payloadEntry) {
        this.mMessageDequeue.offer(payloadEntry);
        synchronized (this) {
            if (this.processing.compareAndSet(false, true)) {
                NetThreadPool.submit(new SendMsgTask());
            }
        }
    }

    @Override // com.bytedance.sync.p005v4.intf.IMsgSender
    public boolean isPendingPayloadToSend() {
        synchronized (MsgSenderV4.class) {
            Iterator it = new ArrayList(this.mMessageDequeue).iterator();
            while (it.hasNext()) {
                PayloadEntry payloadEntry = (PayloadEntry) it.next();
                if (payloadEntry.msg != null) {
                    Iterator<BsyncTopic> it2 = payloadEntry.msg.topics.iterator();
                    while (it2.hasNext()) {
                        if (it2.next().flag == Flag.Data) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    private class SendMsgTask implements Runnable {
        private SendMsgTask() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ISettings settings = SyncSettings.inst(MsgSenderV4.this.context).getSettings();
            LogUtils.m187i("[SendMsgV4] start send msg to server....");
            while (true) {
                PayloadEntry payloadEntry = (PayloadEntry) MsgSenderV4.this.mMessageDequeue.poll();
                if (payloadEntry == null) {
                    break;
                }
                if (!payloadEntry.forceHttps && payloadEntry.trace == null) {
                    payloadEntry.trace = new CommonNetTrace();
                }
                if (!settings.wsFirst() || payloadEntry.forceHttps) {
                    MsgSenderV4.this.mHttpSender.send(payloadEntry);
                } else {
                    try {
                        MsgSenderV4.this.mWsSender.send(payloadEntry);
                    } catch (Throwable th) {
                        LogUtils.m186e("ws sender send err: " + th);
                    }
                }
            }
            synchronized (MsgSenderV4.this) {
                boolean isEmpty = MsgSenderV4.this.mMessageDequeue.isEmpty();
                MsgSenderV4.this.processing.set(!isEmpty);
                if (!isEmpty) {
                    NetThreadPool.submit(new SendMsgTask());
                }
            }
            LogUtils.m187i("[SendMsgV4] send msg to server finish");
        }
    }

    public static String toLog(BsyncProtocol bsyncProtocol) {
        if (bsyncProtocol == null) {
            return null;
        }
        try {
            return bsyncProtocol.toString();
        } catch (Throwable unused) {
            return " there is an oom exception";
        }
    }
}
