package com.bytedance.sync.p005v4.protocal;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.common.utility.NetworkClient;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.bytedance.sync.SyncConstants;
import com.bytedance.sync.SyncMonitor;
import com.bytedance.sync.p005v4.intf.IMsgConverter;
import com.bytedance.sync.p005v4.utils.ProtocolUtils;
import com.bytedance.sync.p005v4.utils.UtilKtKt;
import com.bytedance.sync.settings.SyncSettings;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MsgConverterV2.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0014\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0014\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\r\u001a\u0004\u0018\u00010\u0007H\u0016J\u001e\u0010\u000e\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/bytedance/sync/v4/protocal/MsgConverterV2;", "Lcom/bytedance/sync/v4/intf/IMsgConverter;", "mChannelId", "", "upStreamServiceId", "(II)V", "convertToBytes", "", "protocol", "Lcom/bytedance/sync/v4/protocal/BsyncProtocol;", "convertToProtocol", "msg", "Lcom/bytedance/common/wschannel/model/WsChannelMsg;", "bytes", "convertToWsMsg", "context", "Landroid/content/Context;", "sync-sdk_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class MsgConverterV2 implements IMsgConverter {
    private final int mChannelId;
    private final int upStreamServiceId;

    public MsgConverterV2(int i, int i2) {
        this.mChannelId = i;
        this.upStreamServiceId = i2;
    }

    @Override // com.bytedance.sync.p005v4.intf.IMsgConverter
    public BsyncProtocol convertToProtocol(WsChannelMsg msg) {
        if (msg == null || msg.getService() != 20032 || msg.getMethod() != 1) {
            return null;
        }
        byte[] payload = msg.getPayload();
        if (payload != null && TextUtils.equals(msg.getPayloadEncoding(), SyncConstants.GZIP)) {
            payload = UtilKtKt.ungzip(payload);
        }
        try {
            return (BsyncProtocol) BsyncProtocol.ADAPTER.decode(payload);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // com.bytedance.sync.p005v4.intf.IMsgConverter
    public WsChannelMsg convertToWsMsg(Context context, BsyncProtocol protocol) {
        String str;
        byte[] compressWithgzip;
        byte[] encode = BsyncProtocol.ADAPTER.encode(protocol);
        Intrinsics.checkNotNull(context);
        if (SyncSettings.inst(context).getSettings().enableCompress() && (compressWithgzip = NetworkClient.compressWithgzip(encode)) != null) {
            if (!(compressWithgzip.length == 0)) {
                int length = encode.length;
                int length2 = compressWithgzip.length;
                Integer protocolMsgType = ProtocolUtils.INSTANCE.protocolMsgType(protocol);
                SyncMonitor.monitorCompressRatio(length, length2, protocolMsgType == null ? -1 : protocolMsgType.intValue());
                str = "gzip";
                encode = compressWithgzip;
                return WsChannelMsg.Builder.create(this.mChannelId).setPayload(encode).setMethod(2).setService(this.upStreamServiceId).setPayloadEncoding(str).setPayloadType(str).build();
            }
        }
        str = "pb";
        return WsChannelMsg.Builder.create(this.mChannelId).setPayload(encode).setMethod(2).setService(this.upStreamServiceId).setPayloadEncoding(str).setPayloadType(str).build();
    }

    @Override // com.bytedance.sync.p005v4.intf.IMsgConverter
    public byte[] convertToBytes(BsyncProtocol protocol) {
        if (protocol == null) {
            return null;
        }
        return BsyncProtocol.ADAPTER.encode(protocol);
    }

    @Override // com.bytedance.sync.p005v4.intf.IMsgConverter
    public BsyncProtocol convertToProtocol(byte[] bytes) {
        if (bytes == null) {
            return null;
        }
        try {
            return (BsyncProtocol) BsyncProtocol.ADAPTER.decode(bytes);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
