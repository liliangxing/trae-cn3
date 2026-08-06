package com.heytap.mcssdk.utils;

import android.content.Context;
import android.content.Intent;
import com.heytap.mcssdk.PushService;
import com.heytap.mcssdk.constant.C0879b;
import com.heytap.mcssdk.constant.MessageConstant;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class DataMessageUtil {
    private static final String TYPE = "type";

    public void appArrive(Context context, String str) {
        try {
            Intent intent = new Intent();
            intent.setAction(PushService.getInstance().getReceiveSdkAction(context));
            intent.setPackage(PushService.getInstance().getMcsPackageName(context));
            intent.putExtra(C0879b.f561e, context.getPackageName());
            intent.putExtra(C0879b.f559c, str);
            intent.putExtra("type", MessageConstant.CommandId.COMMAND_SEND_INSTANT_ACK);
            context.startService(intent);
        } catch (Exception e) {
            C0895d.m673e("statisticMessage--Exception" + e.getMessage());
        }
    }
}
