package com.bytedance.sync.p005v4.net;

import android.content.Context;
import android.net.Uri;
import com.bytedance.security.android.aopcheck.reporter.Constant;
import com.bytedance.sync.Configuration;
import com.bytedance.sync.interfaze.IDeviceInfoGetter;
import com.bytedance.sync.interfaze.ISyncNetService;
import com.bytedance.sync.logger.LogUtils;
import com.bytedance.sync.p005v4.intf.IConfiguration;
import com.bytedance.sync.p005v4.intf.IMsgSender;
import com.bytedance.sync.p005v4.intf.IProtocolProcessor;
import com.bytedance.sync.p005v4.model.PayloadEntry;
import com.bytedance.sync.p005v4.protocal.BsyncProtocol;
import com.bytedance.sync.p005v4.utils.ProtocolUtils;
import com.ss.android.ug.bus.UgBusFramework;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class HttpMsgSender extends BaseMsgSender {
    private final Configuration configuration;
    private final IMsgSender fallback;
    private final IProtocolProcessor msgProcessor;

    @Override // com.bytedance.sync.p005v4.intf.IMsgSender
    public boolean isPendingPayloadToSend() {
        return false;
    }

    @Override // com.bytedance.sync.p005v4.net.BaseMsgSender
    public int method() {
        return 2;
    }

    public HttpMsgSender(Context context, IProtocolProcessor iProtocolProcessor, IMsgSender iMsgSender) {
        super(context);
        this.configuration = ((IConfiguration) UgBusFramework.getService(IConfiguration.class)).config();
        this.msgProcessor = iProtocolProcessor;
        this.fallback = iMsgSender;
    }

    @Override // com.bytedance.sync.p005v4.intf.IMsgSender
    public void send(PayloadEntry payloadEntry) {
        LogUtils.m185d("[SendMsgV4] send msg with https : " + MsgSenderV4.toLog(payloadEntry.msg) + ", can fallback: " + payloadEntry.canFallback);
        Uri.Builder url = getUrl(payloadEntry.msg);
        if (url == null) {
            LogUtils.m186e("[SendMsgV4] mismatch url with payload:" + MsgSenderV4.toLog(payloadEntry.msg));
            return;
        }
        url.appendQueryParameter(Constant.KEY_AID, this.configuration.aid);
        int intValue = ProtocolUtils.INSTANCE.protocolMsgType(payloadEntry.msg).intValue();
        BsyncProtocol sendPipeline = ((ISyncNetService) UgBusFramework.getService(ISyncNetService.class)).sendPipeline(payloadEntry.msg);
        if (sendPipeline != null) {
            LogUtils.m185d("[SendMsgV4] send payload success with https " + MsgSenderV4.toLog(payloadEntry.msg));
            this.msgProcessor.process(1, sendPipeline);
        } else if (payloadEntry.canFallback && this.fallback != null) {
            LogUtils.m185d("[SendMsgV4] send payload failed with https " + MsgSenderV4.toLog(payloadEntry.msg) + ",do fallback");
            payloadEntry.canFallback = false;
            this.fallback.send(payloadEntry);
        } else {
            LogUtils.m186e("[SendMsgV4] send payload failed with https " + MsgSenderV4.toLog(payloadEntry.msg) + ", throw it");
        }
        if (sendPipeline == null && payloadEntry.canFallback && this.fallback != null) {
            return;
        }
        onTraceSendMsg(payloadEntry, sendPipeline == null ? 2 : 1, intValue, this.configuration.wsService.isConnect());
        onEventSendMsg(payloadEntry);
    }

    private Uri.Builder getUrl(BsyncProtocol bsyncProtocol) {
        if (bsyncProtocol == null) {
            return null;
        }
        return Uri.parse(this.configuration.host).buildUpon().appendPath("v2/bytesync/api/pipeline").appendQueryParameter("device_id", ((IDeviceInfoGetter) UgBusFramework.getService(IDeviceInfoGetter.class)).getDeviceInfo().did).appendQueryParameter("platform", "0");
    }
}
