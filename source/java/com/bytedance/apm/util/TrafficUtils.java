package com.bytedance.apm.util;

import android.app.usage.NetworkStats;
import android.app.usage.NetworkStatsManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.entity.TrafficEntity;
import com.bytedance.monitor.util.IoUtil;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class TrafficUtils {
    private static final int DEFAULT_NET_STATS = 0;
    private static volatile String sSubscriberId = null;
    private static volatile int sUId = -1;

    public static boolean canCheck() {
        return Build.VERSION.SDK_INT < 28 && ContextCompat.checkSelfPermission(ApmContext.getContext(), "android.permission.READ_PHONE_STATE") == 0;
    }

    public static TrafficEntity getTrafficBytes() {
        if (Build.VERSION.SDK_INT >= 28) {
            return null;
        }
        int myUid = Process.myUid();
        List<String> readFile2List = readFile2List(new File("/proc/net/xt_qtaguid/stats"), "utf-8");
        if (ListUtils.isEmpty(readFile2List)) {
            return null;
        }
        return getFormatTrafficEntity(myUid, readFile2List);
    }

    public static long getNetStats(Context context, long j, long j2) {
        return getNetStats(context, j, j2, 1) + getNetStats(context, j, j2, 0);
    }

    public static long getNetStats(Context context, long j, long j2, int i) {
        NetworkStatsManager networkStatsManager;
        NetworkStats networkStats;
        long j3 = 0;
        if (!canCheck() || (networkStatsManager = (NetworkStatsManager) context.getApplicationContext().getSystemService("netstats")) == null) {
            return 0L;
        }
        NetworkStats.Bucket bucket = new NetworkStats.Bucket();
        try {
            networkStats = networkStatsManager.querySummary(i, null, j, j2);
        } catch (Exception e) {
            e.printStackTrace();
            networkStats = null;
        }
        long j4 = 0;
        while (networkStats != null && networkStats.hasNextBucket()) {
            networkStats.getNextBucket(bucket);
            if (getAppUid(context) == bucket.getUid()) {
                j3 += bucket.getRxBytes();
                j4 += bucket.getTxBytes();
            }
        }
        if (networkStats != null) {
            networkStats.close();
        }
        return j3 + j4;
    }

    private static TrafficEntity getFormatTrafficEntity(int i, List<String> list) {
        TrafficEntity trafficEntity;
        long j;
        long j2;
        long j3;
        TrafficEntity trafficEntity2 = new TrafficEntity();
        Iterator<String> it = list.iterator();
        long j4 = 0;
        long j5 = 0;
        long j6 = 0;
        long j7 = 0;
        long j8 = 0;
        long j9 = 0;
        long j10 = 0;
        long j11 = 0;
        long j12 = 0;
        long j13 = 0;
        while (it.hasNext()) {
            String[] split = it.next().split(" ");
            Iterator<String> it2 = it;
            try {
            } catch (Exception unused) {
                trafficEntity = trafficEntity2;
                j = j8;
                j2 = j10;
                j3 = j11;
            }
            if (TextUtils.equals(split[3], "uid_tag_int")) {
                it = it2;
            } else {
                if (i == Integer.parseInt(split[3])) {
                    long parseLong = Long.parseLong(split[5]);
                    long parseLong2 = Long.parseLong(split[7]);
                    trafficEntity = trafficEntity2;
                    if (Long.valueOf(split[4]).longValue() == 0) {
                        j = j8;
                        j13 += parseLong + parseLong2;
                        try {
                            if (split[1].startsWith("rmnet_data")) {
                                j5 += parseLong2;
                                j4 += parseLong;
                            } else if (split[1].startsWith("wlan")) {
                                j7 += parseLong2;
                                j6 += parseLong;
                            }
                        } catch (Exception unused2) {
                            j2 = j10;
                            j3 = j11;
                            j10 = j2;
                            j11 = j3;
                            j8 = j;
                            it = it2;
                            trafficEntity2 = trafficEntity;
                        }
                    } else {
                        j = j8;
                        long j14 = j13;
                        j12 += parseLong + parseLong2;
                        try {
                        } catch (Exception unused3) {
                            j2 = j10;
                            j3 = j11;
                            j13 = j14;
                            j10 = j2;
                            j11 = j3;
                            j8 = j;
                            it = it2;
                            trafficEntity2 = trafficEntity;
                        }
                        if (split[1].startsWith("rmnet_data")) {
                            j9 += parseLong2;
                            j8 = j + parseLong;
                            j13 = j14;
                            it = it2;
                            trafficEntity2 = trafficEntity;
                        } else {
                            if (split[1].startsWith("wlan")) {
                                j11 += parseLong2;
                                j10 += parseLong;
                            }
                            j13 = j14;
                        }
                    }
                } else {
                    trafficEntity = trafficEntity2;
                    j = j8;
                }
                j8 = j;
                it = it2;
                trafficEntity2 = trafficEntity;
            }
        }
        long j15 = j8;
        TrafficEntity trafficEntity3 = trafficEntity2;
        trafficEntity3.setBackMobileRecBytes(j4);
        trafficEntity3.setBackMobileSendBytes(j5);
        trafficEntity3.setBackWifiRecBytes(j6);
        trafficEntity3.setBackWifiSendBytes(j7);
        trafficEntity3.setFrontMobileRecBytes(j15);
        trafficEntity3.setFrontMobileSendBytes(j9);
        trafficEntity3.setFrontWifiRecBytes(j10);
        trafficEntity3.setFrontWifiSendBytes(j11);
        trafficEntity3.setFrontTotalBytes(j12);
        trafficEntity3.setBackTotalBytes(j13);
        return trafficEntity3;
    }

    private static int getAppUid(Context context) {
        if (sUId == -1) {
            try {
                PackageInfo packageInfo = context.getApplicationContext().getPackageManager().getPackageInfo(context.getApplicationContext().getPackageName(), 128);
                if (packageInfo != null) {
                    sUId = packageInfo.applicationInfo.uid;
                }
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
        }
        return sUId;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003f A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static List<String> readFile2List(File file, String str) {
        BufferedReader bufferedReader;
        String readLine;
        if (file == null) {
            return null;
        }
        try {
            ArrayList arrayList = new ArrayList();
            int i = 1;
            if (str != null && str.trim().length() != 0) {
                bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), str));
                while (true) {
                    try {
                        readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            return arrayList;
                        }
                        if (i >= 0) {
                            arrayList.add(readLine);
                        }
                        i++;
                    } catch (Throwable th) {
                        th = th;
                        try {
                            th.printStackTrace();
                            return null;
                        } finally {
                            IoUtil.safeClose(bufferedReader);
                        }
                    }
                }
            }
            bufferedReader = new BufferedReader(new FileReader(file));
            while (true) {
                readLine = bufferedReader.readLine();
                if (readLine != null) {
                }
                i++;
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedReader = null;
        }
    }
}
