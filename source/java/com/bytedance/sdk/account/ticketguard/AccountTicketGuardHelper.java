package com.bytedance.sdk.account.ticketguard;

import android.content.Context;
import com.bytedance.android.sdk.bdticketguard.ILogger;
import com.bytedance.android.sdk.bdticketguard.IMonitor;
import com.bytedance.android.sdk.bdticketguard.INetwork;
import com.bytedance.android.sdk.bdticketguard.TicketGuardEventHelper;
import com.bytedance.android.sdk.bdticketguard.TicketGuardFramework;
import com.bytedance.android.sdk.bdticketguard.TicketGuardInitParam;
import com.ss.android.token.TTTokenManager;
import com.ss.android.token.TTTokenMonitor;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class AccountTicketGuardHelper {
    public static void initTicketGuard(final Context context, Function1<Boolean, Unit> function1) {
        final ILogger iLogger = new ILogger() { // from class: com.bytedance.sdk.account.ticketguard.AccountTicketGuardHelper.1
            public void log(String str, String str2) {
                TTTokenManager.log(str, str2);
            }
        };
        final IMonitor iMonitor = new IMonitor() { // from class: com.bytedance.sdk.account.ticketguard.AccountTicketGuardHelper.2
            public void onEvent(String str, JSONObject jSONObject) {
                TTTokenMonitor.onEvent(str, jSONObject);
            }
        };
        TicketGuardFramework.tryInit(new TicketGuardInitParam() { // from class: com.bytedance.sdk.account.ticketguard.AccountTicketGuardHelper.3
            public INetwork getNetwork() {
                return TTTokenManager.getTicketNetwork();
            }

            public Context getApplicationContext() {
                return context.getApplicationContext();
            }

            public ILogger getLogger() {
                return iLogger;
            }

            public IMonitor getMonitor() {
                return iMonitor;
            }
        }, function1);
        TicketGuardEventHelper.INSTANCE.setEnableFullPathTrack(TokenGuardSettingManager.isEnableFullLog());
    }
}
