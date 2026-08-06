package com.bytedance.iesgurd.update;

import com.bytedance.geckox.GeckoGlobalManager;
import com.bytedance.geckox.GeckoUpdateParams;
import com.bytedance.geckox.buffer.Buffer;
import com.bytedance.geckox.listener.GeckoUpdateListener;
import com.bytedance.geckox.listener.ListenerManager;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.geckox.policy.meta.MetaDataManager;
import com.bytedance.geckox.utils.FileUtils;
import com.bytedance.geckox.utils.GeckoExecutors;
import com.bytedance.geckox.utils.ResLoadUtils;
import com.bytedance.iesgurd.IESGurdKit;
import com.bytedance.iesgurd.IESGurdObserver;
import com.bytedance.iesgurd.IESGurdObserverUpdateInfo;
import com.bytedance.iesgurd.clean.CleanManager;
import com.bytedance.iesgurd.core.EventSubType;
import com.bytedance.iesgurd.meta.ChannelMeta;
import com.bytedance.iesgurd.meta.ChannelMetaManager;
import com.bytedance.iesgurd.meta.PrepareMeta;
import com.bytedance.iesgurd.meta.PrepareMetaManager;
import com.bytedance.iesgurd.meta.PrepareMetaPackage;
import com.bytedance.iesgurd.meta.UpdateStatisticModel;
import com.bytedance.iesgurd.statistic.UploadStatistic;
import com.bytedance.iesgurd.strategy.StorageManager;
import com.bytedance.pia.core.cache.IPiaCacheProvider;
import com.bytedance.trae.login.traeauth.TraeAuthManager;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Updater.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u0001\u001fB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0013\u001a\u00020\u0011H\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\u0018\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\u0003H\u0002J\u0010\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u0011H\u0002J\u0006\u0010\u001e\u001a\u00020\u0011R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0003X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/bytedance/iesgurd/update/Updater;", "", "oldMeta", "Lcom/bytedance/iesgurd/meta/PrepareMeta;", "params", "Lcom/bytedance/geckox/GeckoUpdateParams;", "(Lcom/bytedance/iesgurd/meta/PrepareMeta;Lcom/bytedance/geckox/GeckoUpdateParams;)V", "channelFile", "Ljava/io/File;", "listener", "Lcom/bytedance/geckox/listener/GeckoUpdateListener;", IPiaCacheProvider.CacheConfig.FIELD_META, "model", "Lcom/bytedance/iesgurd/meta/UpdateStatisticModel;", "startTime", "", "checkCanPatch", "", "checkNotUsePatchReason", "download", "needUpdate", "", "onEventUpdateFailed", "msg", "", "onEventUpdateSuccess", "onFailed", "e", "Lcom/bytedance/iesgurd/update/UpdateException;", "onSuccess", TraeAuthManager.STAGE_START, "NotUsePatchReason", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class Updater {
    private File channelFile;
    private GeckoUpdateListener listener;
    private PrepareMeta meta;
    private UpdateStatisticModel model;
    private final PrepareMeta oldMeta;
    private final GeckoUpdateParams params;
    private long startTime;

    public Updater(PrepareMeta prepareMeta, GeckoUpdateParams geckoUpdateParams) {
        Intrinsics.checkParameterIsNotNull(prepareMeta, "oldMeta");
        Intrinsics.checkParameterIsNotNull(geckoUpdateParams, "params");
        this.oldMeta = prepareMeta;
        this.params = geckoUpdateParams;
    }

    public static final /* synthetic */ PrepareMeta access$getMeta$p(Updater updater) {
        PrepareMeta prepareMeta = updater.meta;
        if (prepareMeta == null) {
            Intrinsics.throwUninitializedPropertyAccessException(IPiaCacheProvider.CacheConfig.FIELD_META);
        }
        return prepareMeta;
    }

    /* compiled from: Updater.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/bytedance/iesgurd/update/Updater$NotUsePatchReason;", "", "()V", "LOCAL_VERSION_CHANGED", "", "MISS_OLD_FILE", "RES_NO_PATCH", "RES_NO_PATCH_URL", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    private static final class NotUsePatchReason {
        public static final NotUsePatchReason INSTANCE = new NotUsePatchReason();
        public static final int LOCAL_VERSION_CHANGED = 2;
        public static final int MISS_OLD_FILE = 3;
        public static final int RES_NO_PATCH = 1;
        public static final int RES_NO_PATCH_URL = 4;

        private NotUsePatchReason() {
        }
    }

    public final void start() {
        this.startTime = System.currentTimeMillis();
        this.listener = this.params.getListener$geckox_noasanRelease();
        String accessKey = this.oldMeta.getAccessKey();
        String channel = this.oldMeta.getChannel();
        GeckoGlobalManager inst = GeckoGlobalManager.inst();
        Intrinsics.checkExpressionValueIsNotNull(inst, "GeckoGlobalManager.inst()");
        String str = (String) inst.getAccessKeyDirs().get(accessKey);
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            onEventUpdateFailed(this.oldMeta, "update failed, no dir for " + accessKey);
            return;
        }
        PrepareMeta updateMeta = PrepareMetaManager.INSTANCE.getUpdateMeta(accessKey, channel);
        if (updateMeta == null) {
            if (ResLoadUtils.innerGetLatestChannelVersion((File) null, accessKey, channel) != null) {
                onEventUpdateSuccess(this.oldMeta);
                return;
            } else {
                onEventUpdateFailed(this.oldMeta, "no update meta, " + accessKey + ", " + channel);
                return;
            }
        }
        PrepareMeta prepareMeta = this.oldMeta;
        if (updateMeta != prepareMeta) {
            updateMeta.setTimeAddQueue(prepareMeta.getTimeAddQueue());
            updateMeta.setPreTriggerChannel(this.oldMeta.getPreTriggerChannel());
        }
        this.meta = updateMeta;
        if (updateMeta == null) {
            Intrinsics.throwUninitializedPropertyAccessException(IPiaCacheProvider.CacheConfig.FIELD_META);
        }
        updateMeta.setUpdatePriority(this.params.getPriority().ordinal());
        PrepareMeta prepareMeta2 = this.meta;
        if (prepareMeta2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(IPiaCacheProvider.CacheConfig.FIELD_META);
        }
        prepareMeta2.setTimeUpdateStart(System.currentTimeMillis());
        PrepareMeta prepareMeta3 = this.meta;
        if (prepareMeta3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(IPiaCacheProvider.CacheConfig.FIELD_META);
        }
        if (prepareMeta3.getTimeAddQueue() == 0) {
            PrepareMeta prepareMeta4 = this.meta;
            if (prepareMeta4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(IPiaCacheProvider.CacheConfig.FIELD_META);
            }
            prepareMeta4.setTimeAddQueue(System.currentTimeMillis());
        }
        this.model = new UpdateStatisticModel();
        PrepareMeta prepareMeta5 = this.meta;
        if (prepareMeta5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(IPiaCacheProvider.CacheConfig.FIELD_META);
        }
        UpdateStatisticModel updateStatisticModel = this.model;
        if (updateStatisticModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("model");
        }
        prepareMeta5.setStatisticModel(updateStatisticModel);
        this.channelFile = new File(new File(str, accessKey), channel);
        PrepareMeta prepareMeta6 = this.meta;
        if (prepareMeta6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(IPiaCacheProvider.CacheConfig.FIELD_META);
        }
        File file = this.channelFile;
        if (file == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelFile");
        }
        PrepareMeta prepareMeta7 = this.meta;
        if (prepareMeta7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(IPiaCacheProvider.CacheConfig.FIELD_META);
        }
        prepareMeta6.setDestDir(new File(file, String.valueOf(prepareMeta7.getVersion())));
        if (needUpdate()) {
            PrepareMeta prepareMeta8 = this.meta;
            if (prepareMeta8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(IPiaCacheProvider.CacheConfig.FIELD_META);
            }
            File file2 = this.channelFile;
            if (file2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("channelFile");
            }
            StringBuilder sb = new StringBuilder();
            PrepareMeta prepareMeta9 = this.meta;
            if (prepareMeta9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(IPiaCacheProvider.CacheConfig.FIELD_META);
            }
            prepareMeta8.setUpdatingDir(new File(file2, sb.append(prepareMeta9.getVersion()).append("--updating").toString()));
            PrepareMeta prepareMeta10 = this.meta;
            if (prepareMeta10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(IPiaCacheProvider.CacheConfig.FIELD_META);
            }
            if (!FileUtils.delete(prepareMeta10.getUpdatingDir())) {
                PrepareMeta prepareMeta11 = this.meta;
                if (prepareMeta11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(IPiaCacheProvider.CacheConfig.FIELD_META);
                }
                onEventUpdateFailed(prepareMeta11, "delete updating dir failed, " + accessKey + ", " + channel);
                return;
            }
            PrepareMeta prepareMeta12 = this.meta;
            if (prepareMeta12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(IPiaCacheProvider.CacheConfig.FIELD_META);
            }
            prepareMeta12.getUpdatingDir().mkdirs();
            StringBuilder sb2 = new StringBuilder("[");
            PrepareMeta prepareMeta13 = this.meta;
            if (prepareMeta13 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(IPiaCacheProvider.CacheConfig.FIELD_META);
            }
            StringBuilder append = sb2.append(prepareMeta13).append("]start update: ");
            PrepareMeta prepareMeta14 = this.meta;
            if (prepareMeta14 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(IPiaCacheProvider.CacheConfig.FIELD_META);
            }
            GeckoLogger.d(append.append(prepareMeta14.getReqType()).toString());
            GeckoExecutors.INSTANCE.getCallbackExecutor().execute(new Runnable() { // from class: com.bytedance.iesgurd.update.Updater$start$1
                @Override // java.lang.Runnable
                public final void run() {
                    GeckoUpdateListener geckoUpdateListener;
                    try {
                        geckoUpdateListener = Updater.this.listener;
                        if (geckoUpdateListener != null) {
                            geckoUpdateListener.onUpdateStart(Updater.access$getMeta$p(Updater.this).getPack());
                        }
                        Iterator it = ListenerManager.INSTANCE.getListeners().iterator();
                        while (it.hasNext()) {
                            ((GeckoUpdateListener) it.next()).onUpdateStart(Updater.access$getMeta$p(Updater.this).getPack());
                        }
                    } catch (Throwable th) {
                        GeckoLogger.w("onUpdateStart exception: " + th.getMessage());
                    }
                }
            });
            checkCanPatch();
            download();
        }
    }

    private final boolean needUpdate() {
        String accessKey = this.oldMeta.getAccessKey();
        String channel = this.oldMeta.getChannel();
        PrepareMeta prepareMeta = this.meta;
        if (prepareMeta == null) {
            Intrinsics.throwUninitializedPropertyAccessException(IPiaCacheProvider.CacheConfig.FIELD_META);
        }
        long version = prepareMeta.getVersion();
        ChannelMeta meta = ChannelMetaManager.INSTANCE.getMeta(accessKey, channel);
        PrepareMeta prepareMeta2 = this.meta;
        if (prepareMeta2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(IPiaCacheProvider.CacheConfig.FIELD_META);
        }
        if (prepareMeta2.getDestDir().exists()) {
            PrepareMeta prepareMeta3 = this.meta;
            if (prepareMeta3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(IPiaCacheProvider.CacheConfig.FIELD_META);
            }
            if (prepareMeta3.getDestDir().isDirectory()) {
                PrepareMeta prepareMeta4 = this.meta;
                if (prepareMeta4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(IPiaCacheProvider.CacheConfig.FIELD_META);
                }
                prepareMeta4.setLocalVersion(version);
                GeckoLogger.d("current channel is the newest: " + channel);
                if (meta == null) {
                    meta = new ChannelMeta();
                }
                Long id = meta.getId();
                if (id == null || id.longValue() != version) {
                    meta.setId(Long.valueOf(version));
                    meta.setUpdateTime(Long.valueOf(System.currentTimeMillis()));
                    ChannelMetaManager.INSTANCE.setMeta(accessKey, channel, meta);
                    UploadStatistic.INSTANCE.uploadEvent(EventSubType.META_PRE_DOWNLOAD_ERROR, accessKey, channel, new StringBuilder().append(id).append('-').append(version).toString());
                }
                CleanManager cleanManager = CleanManager.INSTANCE;
                File file = this.channelFile;
                if (file == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("channelFile");
                }
                String absolutePath = file.getAbsolutePath();
                Intrinsics.checkExpressionValueIsNotNull(absolutePath, "channelFile.absolutePath");
                cleanManager.cleanOldVersion(absolutePath, Long.valueOf(version));
                PrepareMeta prepareMeta5 = this.meta;
                if (prepareMeta5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(IPiaCacheProvider.CacheConfig.FIELD_META);
                }
                onEventUpdateSuccess(prepareMeta5);
                return false;
            }
            PrepareMeta prepareMeta6 = this.meta;
            if (prepareMeta6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(IPiaCacheProvider.CacheConfig.FIELD_META);
            }
            prepareMeta6.getDestDir().delete();
        }
        PrepareMeta prepareMeta7 = this.meta;
        if (prepareMeta7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(IPiaCacheProvider.CacheConfig.FIELD_META);
        }
        if (!prepareMeta7.getIgnoreBlockList() && MetaDataManager.INSTANCE.isBlocklistChannel(accessKey, channel)) {
            PrepareMeta prepareMeta8 = this.meta;
            if (prepareMeta8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(IPiaCacheProvider.CacheConfig.FIELD_META);
            }
            onEventUpdateFailed(prepareMeta8, "block by black list, " + accessKey + ", " + channel);
            return false;
        }
        StorageManager storageManager = StorageManager.INSTANCE;
        PrepareMeta prepareMeta9 = this.meta;
        if (prepareMeta9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(IPiaCacheProvider.CacheConfig.FIELD_META);
        }
        if (!storageManager.checkNeedUpdate(prepareMeta9)) {
            PrepareMeta prepareMeta10 = this.meta;
            if (prepareMeta10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(IPiaCacheProvider.CacheConfig.FIELD_META);
            }
            onEventUpdateFailed(prepareMeta10, "block by storage, " + accessKey + ", " + channel);
            return false;
        }
        File file2 = this.channelFile;
        if (file2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelFile");
        }
        if (file2.isFile()) {
            File file3 = this.channelFile;
            if (file3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("channelFile");
            }
            FileUtils.delete(file3);
        }
        File file4 = this.channelFile;
        if (file4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelFile");
        }
        if (file4.mkdirs()) {
            return true;
        }
        File file5 = this.channelFile;
        if (file5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelFile");
        }
        if (file5.isDirectory()) {
            return true;
        }
        PrepareMeta prepareMeta11 = this.meta;
        if (prepareMeta11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(IPiaCacheProvider.CacheConfig.FIELD_META);
        }
        onEventUpdateFailed(prepareMeta11, "create channel dir failed, " + accessKey + ", " + channel);
        return false;
    }

    private final void checkCanPatch() {
        checkNotUsePatchReason();
        PrepareMeta prepareMeta = this.meta;
        if (prepareMeta == null) {
            Intrinsics.throwUninitializedPropertyAccessException(IPiaCacheProvider.CacheConfig.FIELD_META);
        }
        if (prepareMeta.getPatch() != null) {
            PrepareMeta prepareMeta2 = this.meta;
            if (prepareMeta2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(IPiaCacheProvider.CacheConfig.FIELD_META);
            }
            PrepareMetaPackage patch = prepareMeta2.getPatch();
            if (patch == null) {
                Intrinsics.throwNpe();
            }
            if (patch.getUrlList().isEmpty()) {
                return;
            }
            PrepareMeta prepareMeta3 = this.meta;
            if (prepareMeta3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(IPiaCacheProvider.CacheConfig.FIELD_META);
            }
            if (!prepareMeta3.getIsSingleFile()) {
                PrepareMeta prepareMeta4 = this.meta;
                if (prepareMeta4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(IPiaCacheProvider.CacheConfig.FIELD_META);
                }
                if (!prepareMeta4.getUseZstd()) {
                    return;
                }
            }
            PrepareMeta prepareMeta5 = this.meta;
            if (prepareMeta5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(IPiaCacheProvider.CacheConfig.FIELD_META);
            }
            prepareMeta5.setUpdateWithPatch(true);
        }
    }

    private final void checkNotUsePatchReason() {
        Long id;
        PrepareMeta prepareMeta = this.meta;
        if (prepareMeta == null) {
            Intrinsics.throwUninitializedPropertyAccessException(IPiaCacheProvider.CacheConfig.FIELD_META);
        }
        long localVersion = prepareMeta.getLocalVersion();
        long j = 0;
        if (localVersion == 0) {
            return;
        }
        PrepareMeta prepareMeta2 = this.meta;
        if (prepareMeta2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(IPiaCacheProvider.CacheConfig.FIELD_META);
        }
        if (prepareMeta2.getPatch() == null) {
            PrepareMeta prepareMeta3 = this.meta;
            if (prepareMeta3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(IPiaCacheProvider.CacheConfig.FIELD_META);
            }
            prepareMeta3.setNotUsePatchReason(1);
            return;
        }
        PrepareMeta prepareMeta4 = this.meta;
        if (prepareMeta4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(IPiaCacheProvider.CacheConfig.FIELD_META);
        }
        PrepareMetaPackage patch = prepareMeta4.getPatch();
        if (patch == null) {
            Intrinsics.throwNpe();
        }
        if (patch.getUrlList().isEmpty()) {
            PrepareMeta prepareMeta5 = this.meta;
            if (prepareMeta5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(IPiaCacheProvider.CacheConfig.FIELD_META);
            }
            prepareMeta5.setNotUsePatchReason(4);
            return;
        }
        ChannelMetaManager channelMetaManager = ChannelMetaManager.INSTANCE;
        PrepareMeta prepareMeta6 = this.meta;
        if (prepareMeta6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(IPiaCacheProvider.CacheConfig.FIELD_META);
        }
        String accessKey = prepareMeta6.getAccessKey();
        PrepareMeta prepareMeta7 = this.meta;
        if (prepareMeta7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(IPiaCacheProvider.CacheConfig.FIELD_META);
        }
        ChannelMeta meta = channelMetaManager.getMeta(accessKey, prepareMeta7.getChannel());
        if (meta != null && (id = meta.getId()) != null) {
            j = id.longValue();
        }
        if (j != localVersion) {
            GeckoLogger.d("local version change, delete patch: old: " + localVersion + ", new: " + j);
            PrepareMeta prepareMeta8 = this.meta;
            if (prepareMeta8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(IPiaCacheProvider.CacheConfig.FIELD_META);
            }
            prepareMeta8.setPatch(null);
            PrepareMeta prepareMeta9 = this.meta;
            if (prepareMeta9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(IPiaCacheProvider.CacheConfig.FIELD_META);
            }
            prepareMeta9.setLocalVersion(j);
            PrepareMeta prepareMeta10 = this.meta;
            if (prepareMeta10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(IPiaCacheProvider.CacheConfig.FIELD_META);
            }
            prepareMeta10.setLocalVersionOld(localVersion);
            PrepareMeta prepareMeta11 = this.meta;
            if (prepareMeta11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(IPiaCacheProvider.CacheConfig.FIELD_META);
            }
            prepareMeta11.setNotUsePatchReason(2);
            return;
        }
        File file = this.channelFile;
        if (file == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelFile");
        }
        if (new File(file, localVersion + "/res").isDirectory()) {
            return;
        }
        PrepareMeta prepareMeta12 = this.meta;
        if (prepareMeta12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(IPiaCacheProvider.CacheConfig.FIELD_META);
        }
        prepareMeta12.setPatch(null);
        PrepareMeta prepareMeta13 = this.meta;
        if (prepareMeta13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(IPiaCacheProvider.CacheConfig.FIELD_META);
        }
        prepareMeta13.setNotUsePatchReason(3);
    }

    private final void download() {
        try {
            try {
                PrepareMeta prepareMeta = this.meta;
                if (prepareMeta == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(IPiaCacheProvider.CacheConfig.FIELD_META);
                }
                new Downloader(prepareMeta, this.params).start();
                onSuccess();
            } finally {
                PrepareMeta prepareMeta2 = this.meta;
                if (prepareMeta2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(IPiaCacheProvider.CacheConfig.FIELD_META);
                }
                Buffer updateBuffer = prepareMeta2.getUpdateBuffer();
                if (updateBuffer != null) {
                    updateBuffer.release();
                }
            }
        } catch (UpdateException e) {
            onFailed(e);
            PrepareMeta prepareMeta3 = this.meta;
            if (prepareMeta3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(IPiaCacheProvider.CacheConfig.FIELD_META);
            }
            Buffer updateBuffer2 = prepareMeta3.getUpdateBuffer();
            if (updateBuffer2 != null) {
                updateBuffer2.release();
            }
        } catch (Throwable th) {
            onFailed(new UpdateException(ErrorCode.UNEXPECTED, "unexpected exception: " + th.getStackTrace()));
            PrepareMeta prepareMeta4 = this.meta;
            if (prepareMeta4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(IPiaCacheProvider.CacheConfig.FIELD_META);
            }
            Buffer updateBuffer3 = prepareMeta4.getUpdateBuffer();
            if (updateBuffer3 != null) {
                updateBuffer3.release();
            }
        }
    }

    private final void onEventUpdateFailed(final PrepareMeta meta, final String msg) {
        GeckoLogger.w("[" + meta + "]update failed: " + msg);
        GeckoExecutors.INSTANCE.getCallbackExecutor().execute(new Runnable() { // from class: com.bytedance.iesgurd.update.Updater$onEventUpdateFailed$1
            @Override // java.lang.Runnable
            public final void run() {
                GeckoUpdateParams geckoUpdateParams;
                GeckoUpdateListener geckoUpdateListener;
                try {
                    RuntimeException runtimeException = new RuntimeException(msg);
                    geckoUpdateListener = Updater.this.listener;
                    if (geckoUpdateListener != null) {
                        geckoUpdateListener.onActivateFail(meta.getPack(), runtimeException);
                        geckoUpdateListener.onUpdateFailed(meta.getPack(), runtimeException);
                        geckoUpdateListener.onUpdateFailed(meta.getChannel(), runtimeException);
                    }
                    for (GeckoUpdateListener geckoUpdateListener2 : ListenerManager.INSTANCE.getListeners()) {
                        geckoUpdateListener2.onUpdateFailed(meta.getPack(), runtimeException);
                        geckoUpdateListener2.onUpdateFailed(meta.getChannel(), runtimeException);
                    }
                } catch (Throwable th) {
                    GeckoLogger.w("onEventUpdateFailed exception: " + th.getMessage());
                }
                geckoUpdateParams = Updater.this.params;
                String channel = meta.getChannel();
                String str = msg;
                if (str == null) {
                    str = "";
                }
                geckoUpdateParams.onUpdateFailed$geckox_noasanRelease(channel, str);
            }
        });
    }

    private final void onEventUpdateSuccess(final PrepareMeta meta) {
        GeckoExecutors.INSTANCE.getCallbackExecutor().execute(new Runnable() { // from class: com.bytedance.iesgurd.update.Updater$onEventUpdateSuccess$1
            @Override // java.lang.Runnable
            public final void run() {
                GeckoUpdateParams geckoUpdateParams;
                GeckoUpdateListener geckoUpdateListener;
                long version = meta.getVersion();
                try {
                    geckoUpdateListener = Updater.this.listener;
                    if (geckoUpdateListener != null) {
                        geckoUpdateListener.onActivateSuccess(meta.getPack());
                        geckoUpdateListener.onUpdateSuccess(meta.getPack(), version);
                        geckoUpdateListener.onUpdateSuccess(meta.getChannel(), version);
                    }
                    for (GeckoUpdateListener geckoUpdateListener2 : ListenerManager.INSTANCE.getListeners()) {
                        geckoUpdateListener2.onActivateSuccess(meta.getPack());
                        geckoUpdateListener2.onUpdateSuccess(meta.getPack(), version);
                        geckoUpdateListener2.onUpdateSuccess(meta.getChannel(), version);
                    }
                } catch (Throwable th) {
                    GeckoLogger.w("onEventUpdateSuccess exception: " + th.getMessage());
                }
                geckoUpdateParams = Updater.this.params;
                geckoUpdateParams.onUpdateSuccess$geckox_noasanRelease(meta.getChannel(), version);
                IESGurdObserverUpdateInfo iESGurdObserverUpdateInfo = new IESGurdObserverUpdateInfo(meta.getAccessKey(), meta.getChannel(), version, meta.getLocalVersion());
                Iterator<Map.Entry<String, IESGurdObserver>> it = IESGurdKit.INSTANCE.getObservers$geckox_noasanRelease().entrySet().iterator();
                while (it.hasNext()) {
                    it.next().getValue().onResUpdate(iESGurdObserverUpdateInfo);
                }
            }
        });
    }

    private final void onFailed(UpdateException e) {
        UpdateStatisticModel updateStatisticModel = this.model;
        if (updateStatisticModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("model");
        }
        PrepareMeta prepareMeta = this.meta;
        if (prepareMeta == null) {
            Intrinsics.throwUninitializedPropertyAccessException(IPiaCacheProvider.CacheConfig.FIELD_META);
        }
        UpdateStatisticModel.StageData stageData = updateStatisticModel.getStageData(prepareMeta.getUpdateWithPatch());
        stageData.setResult(false);
        stageData.setErrCode(e.getCode());
        stageData.setErrMsg(e.getMessage());
        PrepareMeta prepareMeta2 = this.meta;
        if (prepareMeta2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(IPiaCacheProvider.CacheConfig.FIELD_META);
        }
        if (prepareMeta2.getUpdateWithPatch()) {
            StringBuilder sb = new StringBuilder("[");
            PrepareMeta prepareMeta3 = this.meta;
            if (prepareMeta3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(IPiaCacheProvider.CacheConfig.FIELD_META);
            }
            GeckoLogger.d(sb.append(prepareMeta3).append("]update failed, fallback to full: ").append(e.getMessage()).toString());
            PrepareMeta prepareMeta4 = this.meta;
            if (prepareMeta4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(IPiaCacheProvider.CacheConfig.FIELD_META);
            }
            prepareMeta4.setUpdateWithPatch(false);
            download();
            return;
        }
        UpdateStatisticModel updateStatisticModel2 = this.model;
        if (updateStatisticModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("model");
        }
        updateStatisticModel2.resetDuration();
        UpdateStatisticModel updateStatisticModel3 = this.model;
        if (updateStatisticModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("model");
        }
        updateStatisticModel3.setUpdateResult(false);
        PrepareMeta prepareMeta5 = this.meta;
        if (prepareMeta5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(IPiaCacheProvider.CacheConfig.FIELD_META);
        }
        prepareMeta5.upload();
        PrepareMeta prepareMeta6 = this.meta;
        if (prepareMeta6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(IPiaCacheProvider.CacheConfig.FIELD_META);
        }
        String message = e.getMessage();
        if (message == null) {
            Intrinsics.throwNpe();
        }
        onEventUpdateFailed(prepareMeta6, message);
    }

    private final void onSuccess() {
        StringBuilder sb = new StringBuilder("[");
        PrepareMeta prepareMeta = this.meta;
        if (prepareMeta == null) {
            Intrinsics.throwUninitializedPropertyAccessException(IPiaCacheProvider.CacheConfig.FIELD_META);
        }
        GeckoLogger.d(sb.append(prepareMeta).append("]update success").toString());
        long currentTimeMillis = System.currentTimeMillis();
        UpdateStatisticModel updateStatisticModel = this.model;
        if (updateStatisticModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("model");
        }
        updateStatisticModel.setUpdateResult(true);
        UpdateStatisticModel updateStatisticModel2 = this.model;
        if (updateStatisticModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("model");
        }
        updateStatisticModel2.setDurationTotal(currentTimeMillis - this.startTime);
        UpdateStatisticModel updateStatisticModel3 = this.model;
        if (updateStatisticModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("model");
        }
        PrepareMeta prepareMeta2 = this.meta;
        if (prepareMeta2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(IPiaCacheProvider.CacheConfig.FIELD_META);
        }
        UpdateStatisticModel.StageData stageData = updateStatisticModel3.getStageData(prepareMeta2.getUpdateWithPatch());
        stageData.setResult(true);
        UpdateStatisticModel updateStatisticModel4 = this.model;
        if (updateStatisticModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("model");
        }
        updateStatisticModel4.setDurationLastStage(currentTimeMillis - stageData.getStartTime());
        PrepareMeta prepareMeta3 = this.meta;
        if (prepareMeta3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(IPiaCacheProvider.CacheConfig.FIELD_META);
        }
        prepareMeta3.upload();
        PrepareMeta prepareMeta4 = this.meta;
        if (prepareMeta4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(IPiaCacheProvider.CacheConfig.FIELD_META);
        }
        onEventUpdateSuccess(prepareMeta4);
    }
}
