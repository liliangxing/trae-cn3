package com.bytedance.geckox.loader;

import com.bytedance.geckox.GkFSUtils;
import com.bytedance.geckox.lock.ResLockManager;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.geckox.utils.ResVersionUtils;
import com.bytedance.iesgurd.clean.CleanManager;
import com.bytedance.iesgurd.core.EventSubType;
import com.bytedance.iesgurd.core.GeckoStore;
import com.bytedance.iesgurd.loader.AccessManager;
import com.bytedance.iesgurd.statistic.UploadStatistic;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicBoolean;

@Deprecated
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class ChannelVerLoader implements ILoader {
    private String accessKey;
    private AtomicBoolean hasLock = new AtomicBoolean(false);
    private String mAccessKeyDir;
    private String mChannel;
    private volatile FileLoader mFileLoader;
    private volatile Long mLatestVersion;
    private volatile File mVersionDir;

    public ChannelVerLoader(String str, String str2, String str3) {
        this.accessKey = str;
        this.mAccessKeyDir = str2;
        this.mChannel = str3;
    }

    @Override // com.bytedance.geckox.loader.ILoader
    public String getBundlePath(String str) throws Throwable {
        return getFileLoader(true, this.mChannel).getBundlePath(getFilePath(this.mChannel, str));
    }

    @Override // com.bytedance.geckox.loader.ILoader
    public final InputStream getInputStream(String str) throws Throwable {
        if (GkFSUtils.INSTANCE.isEnable()) {
            try {
                return getFileLoader(true, this.mChannel).getInputStream(GkFSUtils.INSTANCE.convertBundlePath(this.accessKey, this.mChannel, getFilePath(this.mChannel, str)));
            } catch (Throwable unused) {
                return getFileLoader(true, this.mChannel).getInputStream(getFilePath(this.mChannel, str));
            }
        }
        return getFileLoader(true, this.mChannel).getInputStream(getFilePath(this.mChannel, str));
    }

    public final InputStream load(String str) throws Throwable {
        return getInputStream(str);
    }

    @Override // com.bytedance.geckox.loader.ILoader
    public InputStream getPrefetchData(String str) throws Throwable {
        if (GeckoStore.INSTANCE.validatePrefetchConfig(this.accessKey, this.mChannel, str)) {
            return getFileLoader(false, this.mChannel).getPrefetchData(getFilePath(this.mChannel, str));
        }
        return null;
    }

    @Override // com.bytedance.geckox.loader.ILoader
    public final boolean exist(String str) throws Throwable {
        return getFileLoader(false, this.mChannel).exist(getFilePath(this.mChannel, str));
    }

    private synchronized FileLoader getFileLoader(boolean z, String str) throws Throwable {
        if (this.mFileLoader != null) {
            return this.mFileLoader;
        }
        File curChannelLatestVersion = getCurChannelLatestVersion(str);
        if (curChannelLatestVersion == null) {
            if (z) {
                AccessManager.INSTANCE.handleAccess(this.accessKey, str, (Long) null, "1");
            }
            throw new FileNotFoundException("channel no exist，channel:" + str);
        }
        File file = new File(curChannelLatestVersion, "res");
        if (file.exists() && file.isDirectory()) {
            this.mFileLoader = new FileLoader(curChannelLatestVersion);
            this.mFileLoader.setAccessKey(this.accessKey);
            this.mFileLoader.setChannel(str);
            if (z) {
                AccessManager.INSTANCE.handleAccess(this.accessKey, str, Long.valueOf(Long.parseLong(curChannelLatestVersion.getName())), "1");
            }
            return this.mFileLoader;
        }
        throw new RuntimeException("can not find res, dir:" + curChannelLatestVersion.getAbsolutePath());
    }

    private String getFilePath(String str, String str2) {
        return str2.substring(str.length() + 1);
    }

    private synchronized File getCurChannelLatestVersion(String str) throws Throwable {
        if (this.mVersionDir != null) {
            return this.mVersionDir;
        }
        if (this.mLatestVersion == null) {
            this.mLatestVersion = ResVersionUtils.innerGetLatestChannelVersion(new File(this.mAccessKeyDir, str));
        }
        if (this.mLatestVersion == null) {
            return null;
        }
        String str2 = this.mAccessKeyDir + File.separator + this.mChannel;
        this.hasLock.set(ResLockManager.INSTANCE.readTryLock(str2));
        UploadStatistic.INSTANCE.uploadEvent(EventSubType.FILE_LOCK, this.accessKey, this.mChannel, "");
        if (!this.hasLock.get()) {
            return null;
        }
        this.mVersionDir = new File(str2, String.valueOf(this.mLatestVersion));
        return this.mVersionDir;
    }

    public Long getVersion() {
        return this.mLatestVersion;
    }

    public String getChannel() {
        return this.mChannel;
    }

    @Override // com.bytedance.geckox.loader.ILoader
    public void release() throws Throwable {
        if (this.mFileLoader != null) {
            this.mFileLoader.release();
        }
        if (this.hasLock.compareAndSet(true, false)) {
            String str = this.mAccessKeyDir + File.separator + this.mChannel;
            ResLockManager.INSTANCE.readUnlock(str);
            UploadStatistic.INSTANCE.uploadEvent(EventSubType.FILE_UNLOCK, this.accessKey, this.mChannel, "");
            CleanManager.INSTANCE.cleanOldVersion(str, (Long) null);
        }
    }

    protected void finalize() throws Throwable {
        super.finalize();
        GeckoLogger.m296d("channel loader finalize lock");
        try {
            release();
        } catch (Throwable th) {
            GeckoLogger.m303w("finalize:", th);
        }
    }
}
