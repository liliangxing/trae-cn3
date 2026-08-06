package com.bytedance.crash.monitor;

import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.crash.Global;
import com.bytedance.crash.diagnose.NpthMonitor;
import com.bytedance.crash.util.FileSystemUtils;
import com.bytedance.crash.util.FileUtils;
import com.bytedance.crash.util.SerializeFactory;
import java.io.File;
import java.io.FilenameFilter;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class CacheManager {
    private static final String AID_SUFFIX = ".aid";
    private static final String CHN_SUFFIX = ".chn";
    private static final String DID_SUFFIX = ".did";
    private static final String DIR = "params";
    private static final long TOW_WEEKS = 1209600000;
    private static final String UID_SUFFIX = ".uid";
    private CachedString mAppIdCached;
    private CachedString mChannelCached;
    private CachedString mDeviceIdCached;
    private final File mDirectory;
    private CachedString mUserIdCached;
    private CachedVersion mVersionCached;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CacheManager(File file) {
        this.mDirectory = FileSystemUtils.createDirectory(file, "params");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CacheManager(File file, String str) {
        this.mDirectory = FileSystemUtils.createDirectory(FileSystemUtils.createDirectory(file, "params"), str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getDeviceId() {
        return getDeviceId(0L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getAppId() {
        return getAppId(0L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long getUserId() {
        return getUserId(0L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getChannel() {
        return getChannel(0L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AppVersionModel getVersion() {
        AppVersionModel version = getVersion(0L);
        return version == null ? new AppVersionModel(0L, 0L, 0L, "0") : version;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private CachedString getCachedString(String str) {
        char c;
        switch (str.hashCode()) {
            case 1466958:
                if (str.equals(AID_SUFFIX)) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 1468859:
                if (str.equals(CHN_SUFFIX)) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 1469841:
                if (str.equals(DID_SUFFIX)) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 1486178:
                if (str.equals(UID_SUFFIX)) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        if (c == 0) {
            if (this.mDeviceIdCached == null) {
                this.mDeviceIdCached = CachedString.getCurrent(this.mDirectory, str);
            }
            return this.mDeviceIdCached;
        }
        if (c == 1) {
            if (this.mAppIdCached == null) {
                this.mAppIdCached = CachedString.getCurrent(this.mDirectory, str);
            }
            return this.mAppIdCached;
        }
        if (c == 2) {
            if (this.mUserIdCached == null) {
                this.mUserIdCached = CachedString.getCurrent(this.mDirectory, str);
            }
            return this.mUserIdCached;
        }
        if (this.mChannelCached == null) {
            this.mChannelCached = CachedString.getCurrent(this.mDirectory, CHN_SUFFIX);
        }
        return this.mChannelCached;
    }

    private CachedVersion getCachedVersion() {
        if (this.mVersionCached == null) {
            this.mVersionCached = CachedVersion.getCurrent(this.mDirectory);
        }
        return this.mVersionCached;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getDeviceId(long j) {
        return getCachedString(DID_SUFFIX).getBefore(this.mDirectory, DID_SUFFIX, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setDeviceId(String str) {
        getCachedString(DID_SUFFIX).update(this.mDirectory, DID_SUFFIX, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getAppId(long j) {
        return getCachedString(AID_SUFFIX).getBefore(this.mDirectory, AID_SUFFIX, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setAppId(String str) {
        getCachedString(AID_SUFFIX).update(this.mDirectory, AID_SUFFIX, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long getUserId(long j) {
        String before = getCachedString(UID_SUFFIX).getBefore(this.mDirectory, UID_SUFFIX, j);
        if (before != null) {
            try {
                return Long.decode(before).longValue();
            } catch (Throwable th) {
                NpthMonitor.reportInnerException(th);
            }
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setUserId(long j) {
        getCachedString(UID_SUFFIX).update(this.mDirectory, UID_SUFFIX, String.valueOf(j));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getChannel(long j) {
        return getCachedString(CHN_SUFFIX).getBefore(this.mDirectory, CHN_SUFFIX, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setChannel(String str) {
        getCachedString(CHN_SUFFIX).update(this.mDirectory, CHN_SUFFIX, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AppVersionModel getVersion(long j) {
        return getCachedVersion().getBefore(this.mDirectory, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setVersion(long j, long j2, long j3, String str) {
        getCachedVersion().update(this.mDirectory, j, j2, j3, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AppVersionModel getVersionAfter(long j) {
        return getCachedVersion().getAfter(this.mDirectory, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static class CachedString implements Serializable {
        private static final long serialVersionUID = 1;
        private long mCreateTime;
        private String mValue;

        CachedString() {
        }

        String getBefore(File file, String str, long j) {
            String str2;
            String str3;
            if (j != 0) {
                long j2 = this.mCreateTime;
                if (j2 == 0 || j <= j2) {
                    File[] expiredFiles = CacheManager.getExpiredFiles(file, str);
                    if (expiredFiles == null) {
                        return this.mValue;
                    }
                    for (File file2 : expiredFiles) {
                        if (j > CacheManager.getCreateTime(file2, str)) {
                            CachedString cachedString = (CachedString) SerializeFactory.load(file2);
                            if (cachedString != null && (str3 = cachedString.mValue) != null) {
                                return str3;
                            }
                            FileUtils.deleteFile(file2);
                        }
                    }
                    for (int length = expiredFiles.length - 1; length >= 0; length--) {
                        CachedString cachedString2 = (CachedString) SerializeFactory.load(expiredFiles[length]);
                        if (cachedString2 != null && (str2 = cachedString2.mValue) != null) {
                            return str2;
                        }
                        expiredFiles[length].delete();
                    }
                    return this.mValue;
                }
            }
            return this.mValue;
        }

        static CachedString getCurrent(File file, String str) {
            CachedString cachedString = (CachedString) SerializeFactory.load(new File(file, PerfConsts.KEY_CURRENT_GALVANIC + str));
            return cachedString == null ? new CachedString() : cachedString;
        }

        void update(File file, String str, String str2) {
            long currentTimeMillis = System.currentTimeMillis();
            String str3 = this.mValue;
            if (str3 != null) {
                if (str3.equals(str2)) {
                    return;
                }
                CacheManager.clear(file, str);
                SerializeFactory.store(new File(file, this.mCreateTime + str), this);
            }
            this.mValue = str2;
            this.mCreateTime = currentTimeMillis;
            SerializeFactory.store(new File(file, PerfConsts.KEY_CURRENT_GALVANIC + str), this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static class CachedVersion implements Serializable {
        public static final int VERSION_NEW = 2;
        public static final int VERSION_NO_CHANGE = 0;
        public static final int VERSION_UPDATE = 1;
        private static final String VER_SUFFIX = ".ver";
        private static final long serialVersionUID = 1;
        private long mCreateTime;
        private long mManifestCode;
        private String mName;
        private long mUpdateVersionCode;
        private long mVersionCode;

        CachedVersion() {
        }

        AppVersionModel getAfter(File file, long j) {
            long j2 = this.mCreateTime;
            AppVersionModel appVersionModel = null;
            if (j2 != 0 && j > j2) {
                return null;
            }
            if (this.mVersionCode != 0 && this.mName != null) {
                appVersionModel = new AppVersionModel(this.mVersionCode, this.mUpdateVersionCode, this.mManifestCode, this.mName);
            }
            File[] expiredFiles = CacheManager.getExpiredFiles(file, VER_SUFFIX);
            if (expiredFiles != null) {
                for (File file2 : expiredFiles) {
                    if (j < CacheManager.getCreateTime(file2, VER_SUFFIX)) {
                        CachedVersion cachedVersion = (CachedVersion) SerializeFactory.load(file2);
                        if (cachedVersion != null && cachedVersion.mName != null && cachedVersion.mVersionCode != 0) {
                            appVersionModel = new AppVersionModel(cachedVersion.mVersionCode, cachedVersion.mUpdateVersionCode, cachedVersion.mManifestCode, cachedVersion.mName);
                        } else {
                            FileUtils.deleteFile(file2);
                        }
                    }
                }
            }
            return appVersionModel;
        }

        AppVersionModel getBefore(File file, long j) {
            if (j != 0) {
                long j2 = this.mCreateTime;
                if (j2 == 0 || j <= j2) {
                    File[] expiredFiles = CacheManager.getExpiredFiles(file, VER_SUFFIX);
                    if (expiredFiles == null) {
                        return null;
                    }
                    for (File file2 : expiredFiles) {
                        if (j > CacheManager.getCreateTime(file2, VER_SUFFIX)) {
                            CachedVersion cachedVersion = (CachedVersion) SerializeFactory.load(file2);
                            if (cachedVersion != null && cachedVersion.mName != null && cachedVersion.mVersionCode != 0 && cachedVersion.mUpdateVersionCode != 0) {
                                return new AppVersionModel(cachedVersion.mVersionCode, cachedVersion.mUpdateVersionCode, cachedVersion.mManifestCode, cachedVersion.mName);
                            }
                            FileUtils.deleteFile(file2);
                        }
                    }
                    return null;
                }
            }
            return new AppVersionModel(this.mVersionCode, this.mUpdateVersionCode, this.mManifestCode, this.mName);
        }

        static CachedVersion getCurrent(File file) {
            CachedVersion cachedVersion = (CachedVersion) SerializeFactory.load(new File(file, "current.ver"));
            return cachedVersion == null ? new CachedVersion() : cachedVersion;
        }

        void update(File file, long j, long j2, long j3, String str) {
            long currentTimeMillis = System.currentTimeMillis();
            String str2 = this.mName;
            if (str2 != null && this.mVersionCode != 0) {
                if (str2.equals(str) && this.mVersionCode == j && j3 == this.mManifestCode && this.mUpdateVersionCode == j2) {
                    return;
                }
                Global.setAppLaunchMode(1);
                CacheManager.clear(file, VER_SUFFIX);
                SerializeFactory.store(new File(file, this.mCreateTime + VER_SUFFIX), this);
            } else {
                Global.setAppLaunchMode(2);
            }
            this.mName = str;
            this.mVersionCode = j;
            this.mUpdateVersionCode = j2;
            this.mCreateTime = currentTimeMillis;
            this.mManifestCode = j3;
            SerializeFactory.store(new File(file, "current.ver"), this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long getCreateTime(File file, String str) {
        try {
            String name = file.getName();
            return Long.parseLong(name.substring(0, name.length() - str.length()));
        } catch (Throwable th) {
            NpthMonitor.reportInnerException(th);
            return -1L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static File[] getExpiredFiles(File file, final String str) {
        File[] listFiles = file.listFiles(new FilenameFilter() { // from class: com.bytedance.crash.monitor.CacheManager.1
            @Override // java.io.FilenameFilter
            public boolean accept(File file2, String str2) {
                return str2.endsWith(str) && !str2.startsWith(PerfConsts.KEY_CURRENT_GALVANIC);
            }
        });
        if (listFiles != null) {
            Arrays.sort(listFiles, new Comparator<File>() { // from class: com.bytedance.crash.monitor.CacheManager.2
                @Override // java.util.Comparator
                public int compare(File file2, File file3) {
                    return Long.compare(CacheManager.getCreateTime(file3, str), CacheManager.getCreateTime(file2, str));
                }
            });
        }
        return listFiles;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void clear(File file, String str) {
        File[] expiredFiles = getExpiredFiles(file, str);
        if (expiredFiles != null) {
            long currentTimeMillis = System.currentTimeMillis();
            for (File file2 : expiredFiles) {
                long createTime = getCreateTime(file2, str);
                if (createTime > currentTimeMillis || currentTimeMillis - createTime > TOW_WEEKS) {
                    FileUtils.deleteFile(file2);
                }
            }
        }
    }
}
