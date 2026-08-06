package com.bytedance.bdinstall.util;

import android.util.Pair;
import com.bytedance.bdinstall.BDInstall;
import com.bytedance.bdinstall.DrLog;
import com.bytedance.bdinstall.ExecutorUtil;
import com.bytedance.bdinstall.InstallOptions;
import com.bytedance.bdinstall.network.TTResponse;
import com.bytedance.bdinstall.storage.ICache;
import com.bytedance.bdinstall.ticket.ITicketGuard;
import com.bytedance.bdinstall.ticket.ITicketParseResultCallback;
import com.bytedance.bdinstall.ticket.TicketInitCallback;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class TicketGuardHelper {
    private ITicketGuard ticketGuard;
    private ITicketParseResultCallback ticketParseResultCallback;
    private volatile String uuid;

    public void setTicketParseResultCallback(ITicketParseResultCallback iTicketParseResultCallback) {
        this.ticketParseResultCallback = iTicketParseResultCallback;
    }

    public ITicketParseResultCallback getTicketParseResultCallback() {
        return this.ticketParseResultCallback;
    }

    public void initTicketGuard(InstallOptions installOptions, final TicketInitCallback ticketInitCallback) throws Exception {
        if (this.ticketGuard == null) {
            this.ticketGuard = (ITicketGuard) Class.forName(Constants.CLASS_TICKET_GUARD_ADAPTER).getConstructor(InstallOptions.class).newInstance(installOptions);
        }
        ExecutorUtil.submitToFirstIOExecutor(new Callable<Void>() { // from class: com.bytedance.bdinstall.util.TicketGuardHelper.1
            @Override // java.util.concurrent.Callable
            public Void call() throws Exception {
                if (TicketGuardHelper.this.ticketGuard == null) {
                    return null;
                }
                TicketGuardHelper.this.ticketGuard.init(ticketInitCallback);
                return null;
            }
        }).get(BDInstall.getBDInstallConfig().getTimeoutForTicketGuard() > 0 ? BDInstall.getBDInstallConfig().getTimeoutForTicketGuard() : 200L, TimeUnit.MILLISECONDS);
    }

    public List<Pair<String, String>> getTicketHeader(String str, boolean z, boolean z2) {
        if (this.ticketGuard != null) {
            this.uuid = UUID.randomUUID().toString();
            return this.ticketGuard.providerTicketHeader(str, z, z2, this.uuid);
        }
        return new ArrayList();
    }

    public List<Map<String, String>> handleProviderResponse(long j, String str, String str2, boolean z, List<Pair<String, String>> list) {
        ITicketGuard iTicketGuard = this.ticketGuard;
        if (iTicketGuard != null) {
            return iTicketGuard.handleProviderResponse(j, str, str2, z, list, this.uuid);
        }
        return new ArrayList();
    }

    public List<Pair<String, String>> consumerTicketDataHeader(String str, String str2, String str3, boolean z) {
        ITicketGuard iTicketGuard = this.ticketGuard;
        if (iTicketGuard != null) {
            return iTicketGuard.consumerTicketData(str, str2, str3, z);
        }
        return new ArrayList();
    }

    public void cacheTicketAndTsSign(TTResponse tTResponse, ICache iCache, List<Map<String, String>> list) {
        if (tTResponse == null || iCache == null || this.ticketGuard == null) {
            return;
        }
        Map<String, String> map = null;
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                Map<String, String> map2 = list.get(i);
                if (map2 != null) {
                    iCache.cacheString("ticket", map2.get("ticket"));
                    iCache.cacheString("ts_sign", map2.get("ts_sign"));
                    DrLog.m139d("TicketGuard# parse ticketData by response " + map2);
                    map = map2;
                }
            }
        }
        if (getTicketParseResultCallback() != null) {
            DrLog.m139d("TicketGuard# TicketParseResultCallback , " + map);
            getTicketParseResultCallback().onResult(map);
        }
    }

    public String decryptTicket(byte[] bArr) {
        byte[] decryptTicket;
        ITicketGuard iTicketGuard = this.ticketGuard;
        return (iTicketGuard == null || (decryptTicket = iTicketGuard.decryptTicket(bArr)) == null) ? "" : new String(decryptTicket);
    }

    public Map<String, Long> getTimestamp() {
        ITicketGuard iTicketGuard = this.ticketGuard;
        if (iTicketGuard != null) {
            return iTicketGuard.getTimestamp();
        }
        return new HashMap();
    }
}
