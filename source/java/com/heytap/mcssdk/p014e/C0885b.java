package com.heytap.mcssdk.p014e;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.heytap.mcssdk.constant.C0879b;
import com.heytap.mcssdk.constant.C0880c;
import com.heytap.mcssdk.p016g.C0891a;
import com.heytap.mcssdk.utils.C0893b;
import com.heytap.mcssdk.utils.C0895d;
import com.heytap.msp.push.mode.BaseMode;
import com.heytap.msp.push.mode.DataMessage;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.heytap.mcssdk.e.b */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C0885b extends AbstractC0886c {
    @Override // com.heytap.mcssdk.p014e.InterfaceC0887d
    /* renamed from: a */
    public BaseMode mo632a(Context context, int i, Intent intent) {
        if (4103 != i && 4098 != i && 4108 != i) {
            return null;
        }
        BaseMode mo633a = mo633a(intent, i);
        C0891a.m643a(context, C0880c.a.f584b, (DataMessage) mo633a);
        return mo633a;
    }

    @Override // com.heytap.mcssdk.p014e.AbstractC0886c
    /* renamed from: a */
    public BaseMode mo633a(Intent intent, int i) {
        try {
            DataMessage dataMessage = new DataMessage();
            dataMessage.setMessageID(C0893b.m652d(intent.getStringExtra(C0879b.f559c)));
            dataMessage.setTaskID(C0893b.m652d(intent.getStringExtra(C0879b.f560d)));
            dataMessage.setGlobalId(C0893b.m652d(intent.getStringExtra(C0879b.f564h)));
            dataMessage.setAppPackage(C0893b.m652d(intent.getStringExtra(C0879b.f561e)));
            dataMessage.setTitle(C0893b.m652d(intent.getStringExtra("title")));
            dataMessage.setContent(C0893b.m652d(intent.getStringExtra("content")));
            dataMessage.setDescription(C0893b.m652d(intent.getStringExtra(C0879b.f565i)));
            String m652d = C0893b.m652d(intent.getStringExtra(C0879b.f566j));
            int i2 = 0;
            dataMessage.setNotifyID(TextUtils.isEmpty(m652d) ? 0 : Integer.parseInt(m652d));
            dataMessage.setMiniProgramPkg(C0893b.m652d(intent.getStringExtra("miniProgramPkg")));
            dataMessage.setMessageType(i);
            dataMessage.setEventId(C0893b.m652d(intent.getStringExtra(C0879b.f567k)));
            dataMessage.setStatisticsExtra(C0893b.m652d(intent.getStringExtra(C0879b.f568l)));
            String m652d2 = C0893b.m652d(intent.getStringExtra(C0879b.f569m));
            dataMessage.setDataExtra(m652d2);
            String m634a = m634a(m652d2);
            if (!TextUtils.isEmpty(m634a)) {
                i2 = Integer.parseInt(m634a);
            }
            dataMessage.setMsgCommand(i2);
            dataMessage.setBalanceTime(C0893b.m652d(intent.getStringExtra(C0879b.f570n)));
            dataMessage.setStartDate(C0893b.m652d(intent.getStringExtra(C0879b.f575s)));
            dataMessage.setEndDate(C0893b.m652d(intent.getStringExtra(C0879b.f576t)));
            dataMessage.setTimeRanges(C0893b.m652d(intent.getStringExtra(C0879b.f571o)));
            dataMessage.setRule(C0893b.m652d(intent.getStringExtra(C0879b.f572p)));
            dataMessage.setForcedDelivery(C0893b.m652d(intent.getStringExtra(C0879b.f573q)));
            dataMessage.setDistinctContent(C0893b.m652d(intent.getStringExtra(C0879b.f574r)));
            dataMessage.setAppId(C0893b.m652d(intent.getStringExtra(C0879b.f577u)));
            return dataMessage;
        } catch (Exception e) {
            C0895d.m661b("OnHandleIntent--" + e.getMessage());
            return null;
        }
    }

    /* renamed from: a */
    public String m634a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return new JSONObject(str).optString(C0879b.f578v);
        } catch (JSONException e) {
            C0895d.m661b(e.getMessage());
            return "";
        }
    }
}
