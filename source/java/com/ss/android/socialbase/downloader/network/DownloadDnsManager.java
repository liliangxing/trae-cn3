package com.ss.android.socialbase.downloader.network;

import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.thread.DownloadWatchDog;
import com.ss.android.socialbase.downloader.utils.LruCache;
import java.net.InetAddress;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class DownloadDnsManager {
    private static volatile DownloadDnsManager INSTANCE;
    private final LruCache<String, DnsRecord> cache = new LruCache<>(4, 16, false);
    private final Handler cpuHandler;
    private final Looper mLooper;
    private final Handler networkHandler;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public interface Callback {
        void onDnsResolved(String str, List<InetAddress> list);
    }

    private DownloadDnsManager() {
        HandlerThread handlerThread = new HandlerThread("Network-Handler");
        handlerThread.start();
        Looper looper = handlerThread.getLooper();
        this.mLooper = looper;
        this.networkHandler = new Handler(looper);
        this.cpuHandler = new Handler(DownloadWatchDog.getThreadLooper());
    }

    public static DownloadDnsManager getInstance() {
        if (INSTANCE == null) {
            synchronized (DownloadDnsManager.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DownloadDnsManager();
                }
            }
        }
        return INSTANCE;
    }

    public void resolveDnsAsync(final String str, final Callback callback, final long j) {
        this.networkHandler.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.network.DownloadDnsManager.1
            @Override // java.lang.Runnable
            public void run() {
                DownloadDnsManager.this.resolveDns(str, callback, j);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(14:1|2|a|(2:8|(1:(2:11|12)(1:14)))|15|(6:19|20|(3:36|37|38)|(3:28|29|(2:31|32)(1:33))|29|(0)(0))|45|(1:22)|36|37|38|(4:25|28|29|(0)(0))|29|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0086, code lost:
    
        r10 = r2.value;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0073, code lost:
    
        r11 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0074, code lost:
    
        r11.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x008f A[Catch: all -> 0x0096, TRY_LEAVE, TryCatch #2 {all -> 0x0096, blocks: (B:2:0x0000, B:3:0x000a, B:8:0x0016, B:11:0x0034, B:15:0x003a, B:17:0x0052, B:22:0x0064, B:25:0x0079, B:28:0x0080, B:29:0x0088, B:31:0x008f, B:35:0x0086, B:36:0x006a, B:41:0x0074, B:44:0x005e, B:49:0x0095, B:38:0x006e, B:5:0x000b, B:6:0x0013, B:20:0x0058), top: B:1:0x0000, inners: #0, #1, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void resolveDns(final String str, final Callback callback, long j) {
        final DnsRecord dnsRecord;
        List<InetAddress> list;
        IDownloadDns downloadDns;
        try {
            String host = Uri.parse(str).getHost();
            synchronized (this.cache) {
                dnsRecord = this.cache.get(host);
            }
            if (dnsRecord != null) {
                if (System.currentTimeMillis() - dnsRecord.timestamp < DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.DNS_EXPIRE_MIN, 10) * 60 * 1000) {
                    if (callback != null) {
                        callback.onDnsResolved(str, dnsRecord.value);
                        return;
                    }
                    return;
                }
            }
            Runnable runnable = new Runnable() { // from class: com.ss.android.socialbase.downloader.network.DownloadDnsManager.2
                @Override // java.lang.Runnable
                public void run() {
                    Callback callback2 = callback;
                    if (callback2 != null) {
                        String str2 = str;
                        DnsRecord dnsRecord2 = dnsRecord;
                        callback2.onDnsResolved(str2, dnsRecord2 == null ? null : dnsRecord2.value);
                    }
                }
            };
            this.cpuHandler.postDelayed(runnable, j);
            if (DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.USE_HOST_DNS, 1) == 1 && (downloadDns = DownloadComponentManager.getDownloadDns()) != null) {
                try {
                    list = downloadDns.lookup(host);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                if (list != null || list.isEmpty()) {
                    list = DownloadComponentManager.getDefaultDownloadDns().lookup(host);
                }
                if (list != null && !list.isEmpty()) {
                    updateIpAddressToCache(host, list);
                    this.cpuHandler.removeCallbacks(runnable);
                    if (callback == null) {
                        callback.onDnsResolved(str, list);
                        return;
                    }
                    return;
                }
                this.cpuHandler.removeCallbacks(runnable);
                if (callback == null) {
                }
            }
            list = null;
            if (list != null) {
            }
            list = DownloadComponentManager.getDefaultDownloadDns().lookup(host);
            if (list != null) {
                updateIpAddressToCache(host, list);
                this.cpuHandler.removeCallbacks(runnable);
                if (callback == null) {
                }
            }
            this.cpuHandler.removeCallbacks(runnable);
            if (callback == null) {
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    private void updateIpAddressToCache(String str, List<InetAddress> list) {
        synchronized (this.cache) {
            DnsRecord dnsRecord = this.cache.get(str);
            if (dnsRecord == null) {
                dnsRecord = new DnsRecord();
                this.cache.put(str, dnsRecord);
            }
            dnsRecord.value = list;
            dnsRecord.timestamp = System.currentTimeMillis();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class DnsRecord {
        long timestamp;
        List<InetAddress> value;

        private DnsRecord() {
        }
    }
}
