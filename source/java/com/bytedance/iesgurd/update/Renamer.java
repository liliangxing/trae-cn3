package com.bytedance.iesgurd.update;

import com.bytedance.geckox.AppSettingsManager;
import com.bytedance.geckox.GeckoGlobalManager;
import com.bytedance.geckox.GkFSUtils;
import com.bytedance.geckox.gson.GsonUtil;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.geckox.model.GeckoManifest;
import com.bytedance.geckox.model.GeckoMd5Check;
import com.bytedance.geckox.policy.meta.MetaDataManager;
import com.bytedance.geckox.utils.ChannelState;
import com.bytedance.geckox.utils.FileUtils;
import com.bytedance.geckox.utils.GeckoExecutors;
import com.bytedance.geckox.utils.MD5Utils;
import com.bytedance.gkfs.GeckoFileSystem;
import com.bytedance.gkfs.GkFSExecutor;
import com.bytedance.iesgurd.clean.CleanManager;
import com.bytedance.iesgurd.core.EventSubType;
import com.bytedance.iesgurd.meta.ChannelMeta;
import com.bytedance.iesgurd.meta.ChannelMetaManager;
import com.bytedance.iesgurd.meta.PrepareMeta;
import com.bytedance.iesgurd.meta.PrepareMetaManager;
import com.bytedance.iesgurd.statistic.UploadStatistic;
import com.bytedance.pia.core.cache.IPiaCacheProvider;
import com.bytedance.trae.login.traeauth.TraeAuthManager;
import java.io.File;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Renamer.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0006\u0010\b\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bytedance/iesgurd/update/Renamer;", "", IPiaCacheProvider.CacheConfig.FIELD_META, "Lcom/bytedance/iesgurd/meta/PrepareMeta;", "(Lcom/bytedance/iesgurd/meta/PrepareMeta;)V", "checkFileBroken", "", "onTerminal", TraeAuthManager.STAGE_START, "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class Renamer {
    private final PrepareMeta meta;

    public Renamer(PrepareMeta prepareMeta) {
        Intrinsics.checkParameterIsNotNull(prepareMeta, IPiaCacheProvider.CacheConfig.FIELD_META);
        this.meta = prepareMeta;
    }

    public final void start() {
        GeckoLogger.d("[" + this.meta + "]start rename channel");
        if (!this.meta.getUpdatingDir().renameTo(this.meta.getDestDir())) {
            throw new RuntimeException("rename failed, exist: " + this.meta.getDestDir().exists() + ", path: " + this.meta.getDestDir().getAbsolutePath());
        }
        AppSettingsManager inst = AppSettingsManager.inst();
        Intrinsics.checkExpressionValueIsNotNull(inst, "AppSettingsManager.inst()");
        if (inst.isCheckFileBrokenNew()) {
            try {
                checkFileBroken();
            } catch (Exception e) {
                FileUtils.delete(this.meta.getDestDir());
                throw new RuntimeException("check file broken failed: " + e.getMessage());
            }
        }
        final String accessKey = this.meta.getAccessKey();
        final String channel = this.meta.getChannel();
        ChannelMeta meta = ChannelMetaManager.INSTANCE.getMeta(accessKey, channel);
        if (meta == null) {
            meta = new ChannelMeta();
        }
        meta.setId(Long.valueOf(this.meta.getVersion()));
        meta.setUpdateTime(Long.valueOf(System.currentTimeMillis()));
        meta.setForbidden(false);
        ChannelMetaManager.INSTANCE.setMeta(accessKey, channel, meta);
        GkFSExecutor.sequence(new Runnable() { // from class: com.bytedance.iesgurd.update.Renamer$start$1
            @Override // java.lang.Runnable
            public final void run() {
                PrepareMeta prepareMeta;
                if (GkFSUtils.INSTANCE.useGkFS(accessKey, channel)) {
                    GeckoFileSystem geckoFileSystem = GeckoFileSystem.INSTANCE;
                    prepareMeta = Renamer.this.meta;
                    geckoFileSystem.store(prepareMeta.getDestDir());
                }
            }
        });
        onTerminal();
    }

    private final void checkFileBroken() {
        File file = new File(this.meta.getDestDir(), "res" + File.separator + "gecko_manifest.json");
        if (file.exists()) {
            Map files = ((GeckoManifest) GsonUtil.Companion.inst().gson().fromJson(FileUtils.INSTANCE.readJsonFile$geckox_noasanRelease(file), GeckoManifest.class)).getFiles();
            if (files == null || files.isEmpty()) {
                return;
            }
            for (Map.Entry entry : files.entrySet()) {
                String str = (String) entry.getKey();
                String md5 = ((GeckoMd5Check) entry.getValue()).getMd5();
                if (!(str.length() == 0)) {
                    if (md5.length() == 0) {
                        continue;
                    } else {
                        File file2 = new File(this.meta.getDestDir(), "res" + File.separator + str);
                        if (file2.exists()) {
                            try {
                                FileUtils.INSTANCE.checkLynxFileBroken(file2);
                            } catch (Exception unused) {
                                String mD5$geckox_noasanRelease = MD5Utils.INSTANCE.getMD5$geckox_noasanRelease(file2);
                                if (!Intrinsics.areEqual(mD5$geckox_noasanRelease, md5)) {
                                    throw new RuntimeException("md5 check failed, " + mD5$geckox_noasanRelease + '-' + md5 + ", length: " + file2.length());
                                }
                                throw new RuntimeException("file broken, but md5 is the same, file length: " + file2.length());
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
        }
    }

    private final void onTerminal() {
        final String accessKey = this.meta.getAccessKey();
        final String channel = this.meta.getChannel();
        GeckoGlobalManager inst = GeckoGlobalManager.inst();
        Intrinsics.checkExpressionValueIsNotNull(inst, "GeckoGlobalManager.inst()");
        String str = (String) inst.getAccessKeyDirs().get(accessKey);
        PrepareMetaManager.INSTANCE.removeUpdateMeta(accessKey, channel, Long.valueOf(this.meta.getVersion()));
        if (ChannelState.INSTANCE.isChannelAccessed(accessKey, channel)) {
            ChannelState.INSTANCE.setChannelConsumed(accessKey, channel);
        }
        String str2 = str;
        if (!(str2 == null || str2.length() == 0)) {
            File file = new File(str, accessKey);
            CleanManager cleanManager = CleanManager.INSTANCE;
            String absolutePath = new File(file, channel).getAbsolutePath();
            Intrinsics.checkExpressionValueIsNotNull(absolutePath, "File(accessKeyDir, channel).absolutePath");
            cleanManager.cleanOldVersion(absolutePath, Long.valueOf(this.meta.getVersion()));
        }
        GeckoExecutors.INSTANCE.getCallbackExecutor().execute(new Runnable() { // from class: com.bytedance.iesgurd.update.Renamer$onTerminal$1
            @Override // java.lang.Runnable
            public final void run() {
                CleanManager.INSTANCE.callbackWhenClean(accessKey, channel);
            }
        });
        if (MetaDataManager.INSTANCE.isBlocklistChannel(accessKey, channel)) {
            UploadStatistic.INSTANCE.uploadEvent(EventSubType.BLOCK_DOWNLOAD_ERROR, accessKey, channel, 0L);
        }
    }
}
