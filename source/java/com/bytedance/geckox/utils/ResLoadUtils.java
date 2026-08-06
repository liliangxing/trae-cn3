package com.bytedance.geckox.utils;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.android.sdk.bdticketguard.TicketGuardApiKt;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.iesgurd.core.GeckoStore;
import com.bytedance.iesgurd.loader.AccessManager;
import com.bytedance.iesgurd.meta.ChannelMeta;
import com.bytedance.iesgurd.meta.ChannelMetaManager;
import com.bytedance.iesgurd.statistic.model.CleanStrategy;
import com.bytedance.iesgurd.statistic.model.StatisticCleanData;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Deprecated
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class ResLoadUtils {
    @Deprecated
    public static boolean checkExist(File file, String str, String str2) {
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || file == null || !file.exists() || !file.isDirectory() || innerGetLatestChannelVersion(file, str, str2) == null) ? false : true;
    }

    public static boolean checkChannelFileExist(File file, String str, String str2, String str3) {
        return searchChannelFile(file, str, str2, str3) != null;
    }

    public static String searchChannelFile(File file, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || file == null || !file.exists() || !file.isDirectory() || TextUtils.isEmpty(str3)) {
            return null;
        }
        File file2 = new File(file, str + File.separator + str2);
        if (file2.exists() && file2.listFiles().length > 0) {
            for (File file3 : file2.listFiles()) {
                if (file3.getName().endsWith(str3)) {
                    return file3.getName();
                }
            }
        }
        return null;
    }

    public static String getChannelPath(File file, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && file != null && file.exists() && file.isDirectory()) {
            String tripChannel = tripChannel(str2);
            try {
                String absolutePath = new File(file, File.separator + str).getAbsolutePath();
                File file2 = new File(absolutePath, tripChannel);
                Long innerGetLatestChannelVersion = ResVersionUtils.innerGetLatestChannelVersion(file2);
                if (!file2.exists() || innerGetLatestChannelVersion == null) {
                    AccessManager.INSTANCE.handleAccess(str, tripChannel, innerGetLatestChannelVersion, TicketGuardApiKt.TICKET_GUARD_VERSION);
                    return null;
                }
                String str3 = absolutePath + File.separator + tripChannel + File.separator + innerGetLatestChannelVersion + File.separator + "res";
                AccessManager.INSTANCE.handleAccess(str, tripChannel, innerGetLatestChannelVersion, TicketGuardApiKt.TICKET_GUARD_VERSION);
                return str3;
            } catch (Throwable th) {
                GeckoLogger.m303w("getChannelPath:error:", th);
            }
        }
        return null;
    }

    public static InputStream getPrefetchDataForPath(File file, String str, String str2, String str3) throws FileNotFoundException {
        Long innerGetLatestChannelVersion;
        if (!GeckoStore.INSTANCE.validatePrefetchConfig(str, str2, str3)) {
            return null;
        }
        File file2 = new File(file, str + File.separator + str2);
        if (!file2.exists() || (innerGetLatestChannelVersion = ResVersionUtils.innerGetLatestChannelVersion(file2)) == null) {
            return null;
        }
        File file3 = new File(file2, innerGetLatestChannelVersion + File.separator + "res" + File.separator + str3);
        if (file3.exists()) {
            return new FileInputStream(file3);
        }
        return null;
    }

    public static String getChannelPath(File file, String str, String str2, long j) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && file != null && j != 0 && file.exists() && file.isDirectory()) {
            String tripChannel = tripChannel(str2);
            try {
                File file2 = new File(file, File.separator + str);
                if (!file2.exists()) {
                    return null;
                }
                String absolutePath = file2.getAbsolutePath();
                if (new File(absolutePath, tripChannel).exists()) {
                    return absolutePath + File.separator + tripChannel + File.separator + j + File.separator + "res";
                }
                return null;
            } catch (Throwable th) {
                GeckoLogger.m303w("getChannelPath:error:", th);
            }
        }
        return null;
    }

    @Deprecated
    public static boolean deleteChannel(File file, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && file != null && file.exists() && file.isDirectory()) {
            String tripChannel = tripChannel(str2);
            try {
                File file2 = new File(file, File.separator + str);
                if (!file2.exists()) {
                    return false;
                }
                File file3 = new File(file2.getAbsolutePath(), tripChannel);
                if (!file3.exists()) {
                    return false;
                }
                GeckoLogger.m296d("deleteChannel: " + str + "-" + tripChannel);
                ChannelMetaManager.INSTANCE.removeChannel(str, tripChannel);
                new StatisticCleanData(CleanStrategy.BUSINESS_CALL, -1, str, tripChannel, 0L, 200, 0, (String) null).upload();
                return FileUtils.delete(file3);
            } catch (Throwable th) {
                GeckoLogger.m303w("deleteChannel:error:", th);
            }
        }
        return false;
    }

    private static String tripChannel(String str) {
        if (str.indexOf("/") == 0) {
            str = str.substring(1);
        }
        return str.lastIndexOf("/") == str.length() - 1 ? str.substring(0, str.lastIndexOf("/")) : str;
    }

    @Deprecated
    public static List<Pair<String, Long>> getAllLocalChannels(File file, String str) {
        Long innerGetLatestChannelVersion;
        if (file == null || TextUtils.isEmpty(str)) {
            return null;
        }
        File file2 = new File(file, str);
        String[] list = file2.list();
        ArrayList arrayList = new ArrayList();
        if (list != null && list.length > 0) {
            for (String str2 : list) {
                File file3 = new File(file2, str2);
                if (file3.isDirectory() && (innerGetLatestChannelVersion = ResVersionUtils.innerGetLatestChannelVersion(file3)) != null) {
                    arrayList.add(new Pair(str2, innerGetLatestChannelVersion));
                }
            }
        }
        return arrayList;
    }

    @Deprecated
    public static Long getLatestChannelVersion(File file, String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || file == null) {
            return null;
        }
        return innerGetLatestChannelVersion(file, str, str2);
    }

    @Deprecated
    public static Long innerGetLatestChannelVersion(File file, String str, String str2) {
        ChannelMeta meta;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (meta = ChannelMetaManager.INSTANCE.getMeta(str, str2)) == null) {
            return null;
        }
        return ChannelMetaManager.INSTANCE.checkLatestVersion(str, str2, meta, file != null ? "rootDir: " + file.getAbsolutePath() : "rootDir: ");
    }
}
