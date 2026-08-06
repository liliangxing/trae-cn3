package com.heytap.mcssdk.p015f;

import android.app.NotificationManager;
import android.content.Context;
import com.heytap.mcssdk.utils.C0895d;
import com.heytap.mcssdk.utils.C0897f;
import com.heytap.msp.push.callback.IDataMessageCallBackService;
import com.heytap.msp.push.mode.BaseMode;
import com.heytap.msp.push.mode.DataMessage;
import com.heytap.msp.push.statis.StatisticUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.ArrayList;
import java.util.HashMap;

/* renamed from: com.heytap.mcssdk.f.b */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C0889b implements InterfaceC0890c {

    /* renamed from: a */
    private static final int f611a = 1;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m639a(Context context, DataMessage dataMessage) {
        if (context == null) {
            C0895d.m661b("context is null");
            return;
        }
        C0895d.m661b("Receive revokeMessage  extra : " + dataMessage.getStatisticsExtra() + "notifyId :" + dataMessage.getNotifyID() + "messageId : " + dataMessage.getTaskID());
        ((NotificationManager) context.getSystemService(RemoteMessageConst.NOTIFICATION)).cancel(dataMessage.getNotifyID());
        m641b(context, dataMessage);
    }

    /* renamed from: b */
    private void m641b(Context context, DataMessage dataMessage) {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        arrayList.add(dataMessage);
        hashMap.put(dataMessage.getEventId(), arrayList);
        StatisticUtils.statisticEvent(context, hashMap);
    }

    @Override // com.heytap.mcssdk.p015f.InterfaceC0890c
    /* renamed from: a */
    public void mo638a(final Context context, BaseMode baseMode, final IDataMessageCallBackService iDataMessageCallBackService) {
        if (baseMode != null && baseMode.getType() == 4103) {
            final DataMessage dataMessage = (DataMessage) baseMode;
            if (iDataMessageCallBackService != null) {
                C0897f.m691b(new Runnable() { // from class: com.heytap.mcssdk.f.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (dataMessage.getMsgCommand() == 1) {
                            C0889b.this.m639a(context, dataMessage);
                        } else {
                            iDataMessageCallBackService.processMessage(context, dataMessage);
                        }
                    }
                });
            }
        }
    }
}
