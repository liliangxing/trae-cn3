package com.bytedance.iesgurd.update;

import com.bytedance.geckox.buffer.Buffer;
import com.bytedance.geckox.buffer.impl.BufferPolicy;
import com.bytedance.geckox.buffer.stream.BufferInputStream;
import com.bytedance.geckox.lock.ResLockManager;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.geckox.utils.BsPatch;
import com.bytedance.geckox.utils.FileUtils;
import com.bytedance.geckox.utils.MD5Utils;
import com.bytedance.geckox.utils.UnZipUtils;
import com.bytedance.iesgurd.exception.BytePatchException;
import com.bytedance.iesgurd.meta.PrepareMeta;
import com.bytedance.iesgurd.meta.PrepareMetaPackage;
import com.bytedance.iesgurd.meta.UpdateStatisticModel;
import com.bytedance.pia.core.cache.IPiaCacheProvider;
import com.bytedance.trae.login.traeauth.TraeAuthManager;
import java.io.File;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: Activator.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0006H\u0002J\b\u0010\u0012\u001a\u00020\u000fH\u0002J\b\u0010\u0013\u001a\u00020\bH\u0002J\b\u0010\u0014\u001a\u00020\u000fH\u0002J\u0006\u0010\u0015\u001a\u00020\u000fJ\b\u0010\u0016\u001a\u00020\u000fH\u0002J\u0010\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/bytedance/iesgurd/update/Activator;", "", IPiaCacheProvider.CacheConfig.FIELD_META, "Lcom/bytedance/iesgurd/meta/PrepareMeta;", "(Lcom/bytedance/iesgurd/meta/PrepareMeta;)V", "buffer", "Lcom/bytedance/geckox/buffer/Buffer;", "channelFile", "Ljava/io/File;", "kotlin.jvm.PlatformType", "localResFile", "model", "Lcom/bytedance/iesgurd/meta/UpdateStatisticModel;", "resFile", "bytePatch", "", "changeBuffer", "buf", "decompressZstd", "getDestFileForSingle", "mergePatch", TraeAuthManager.STAGE_START, "unzip", "unzipProcess", "retryCount", "", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class Activator {
    private Buffer buffer;
    private final File channelFile;
    private final File localResFile;
    private final PrepareMeta meta;
    private final UpdateStatisticModel model;
    private final File resFile;

    public Activator(PrepareMeta prepareMeta) {
        Intrinsics.checkParameterIsNotNull(prepareMeta, IPiaCacheProvider.CacheConfig.FIELD_META);
        this.meta = prepareMeta;
        Buffer updateBuffer = prepareMeta.getUpdateBuffer();
        if (updateBuffer == null) {
            Intrinsics.throwNpe();
        }
        this.buffer = updateBuffer;
        UpdateStatisticModel statisticModel = prepareMeta.getStatisticModel();
        if (statisticModel == null) {
            Intrinsics.throwNpe();
        }
        this.model = statisticModel;
        File parentFile = prepareMeta.getUpdatingDir().getParentFile();
        this.channelFile = parentFile;
        this.resFile = new File(prepareMeta.getUpdatingDir(), "res");
        this.localResFile = new File(parentFile, prepareMeta.getLocalVersion() + "/res");
    }

    public final void start() {
        long currentTimeMillis = System.currentTimeMillis();
        GeckoLogger.d("[" + this.meta + "]start active");
        boolean updateWithPatch = this.meta.getUpdateWithPatch();
        if (this.meta.getUseZstd()) {
            decompressZstd();
            if (updateWithPatch) {
                bytePatch();
            } else {
                unzip();
            }
        } else if (!this.meta.getIsSingleFile()) {
            unzip();
        } else if (updateWithPatch) {
            mergePatch();
        } else {
            if (!this.resFile.mkdirs()) {
                throw new UpdateException(ErrorCode.RENAME_SINGLE, "single file channel make dir failed");
            }
            if (!this.meta.getDownloadFile().renameTo(getDestFileForSingle())) {
                throw new UpdateException(ErrorCode.RENAME_SINGLE, "single file channel rename failed");
            }
        }
        try {
            new Renamer(this.meta).start();
            this.model.setDurationActive(System.currentTimeMillis() - currentTimeMillis);
        } catch (Throwable th) {
            throw new UpdateException(ErrorCode.RENAME, th.getMessage());
        }
    }

    private final void decompressZstd() {
        GeckoLogger.d("[" + this.meta + "]start decompress zstd");
        long currentTimeMillis = System.currentTimeMillis();
        this.buffer.position(0L);
        File file = new File(this.meta.getUpdatingDir(), "res.zst.tmp");
        FileUtils.delete(file);
        Buffer create = BufferPolicy.INSTANCE.create(file, file.length());
        try {
            try {
                UnZipUtils.INSTANCE.decompressZstd(this.buffer, create);
                this.buffer.releaseAndDeleteSwap();
                create.position(0L);
                try {
                    MD5Utils.INSTANCE.check$geckox_noasanRelease(new BufferInputStream(create), this.meta.getPackage().getDecompressMd5());
                    changeBuffer(create);
                    this.model.setDurationDecompressZstd(System.currentTimeMillis() - currentTimeMillis);
                } catch (Throwable th) {
                    create.releaseAndDeleteSwap();
                    throw new UpdateException(ErrorCode.DECOMPRESS_ZSTD_CHECK, th.getMessage());
                }
            } catch (Exception e) {
                create.releaseAndDeleteSwap();
                throw new UpdateException(ErrorCode.DECOMPRESS_ZSTD, e.getMessage());
            }
        } catch (Throwable th2) {
            this.buffer.releaseAndDeleteSwap();
            throw th2;
        }
    }

    private final void bytePatch() {
        GeckoLogger.d("[" + this.meta + "]start merge dir");
        long currentTimeMillis = System.currentTimeMillis();
        File swap = this.buffer.swap();
        this.buffer.persistence();
        this.buffer.release();
        ResLockManager resLockManager = ResLockManager.INSTANCE;
        File file = this.channelFile;
        Intrinsics.checkExpressionValueIsNotNull(file, "channelFile");
        String absolutePath = file.getAbsolutePath();
        Intrinsics.checkExpressionValueIsNotNull(absolutePath, "channelFile.absolutePath");
        try {
            if (!resLockManager.readLock(absolutePath)) {
                throw new UpdateException(ErrorCode.BYTE_PATCH_LOCK, "read lock failed");
            }
            try {
                new BytePatch().patch(this.localResFile, this.resFile, swap);
                ResLockManager resLockManager2 = ResLockManager.INSTANCE;
                File file2 = this.channelFile;
                Intrinsics.checkExpressionValueIsNotNull(file2, "channelFile");
                String absolutePath2 = file2.getAbsolutePath();
                Intrinsics.checkExpressionValueIsNotNull(absolutePath2, "channelFile.absolutePath");
                resLockManager2.readUnlock(absolutePath2);
                swap.delete();
                this.model.setDurationBytepatch(System.currentTimeMillis() - currentTimeMillis);
            } catch (BytePatchException e) {
                GeckoLogger.w("[" + this.meta + "]merge dir failed: " + e.getMessage());
                int code = e.getCode();
                String message = e.getMessage();
                if (message == null) {
                    message = "";
                }
                throw new UpdateException(code, message);
            }
        } catch (Throwable th) {
            ResLockManager resLockManager3 = ResLockManager.INSTANCE;
            File file3 = this.channelFile;
            Intrinsics.checkExpressionValueIsNotNull(file3, "channelFile");
            String absolutePath3 = file3.getAbsolutePath();
            Intrinsics.checkExpressionValueIsNotNull(absolutePath3, "channelFile.absolutePath");
            resLockManager3.readUnlock(absolutePath3);
            swap.delete();
            throw th;
        }
    }

    private final void unzip() {
        GeckoLogger.d("[" + this.meta + "]start unzip");
        long currentTimeMillis = System.currentTimeMillis();
        try {
            unzipProcess(0);
            if (!FileUtils.delete(this.resFile)) {
                throw new UpdateException(ErrorCode.UNZIP, "delete res dir failed");
            }
            if (!new File(this.meta.getUpdatingDir(), this.meta.getChannel()).renameTo(this.resFile)) {
                throw new UpdateException(ErrorCode.UNZIP, "rename zip file failed");
            }
            this.buffer.swap().delete();
            this.model.setDurationUnzip(System.currentTimeMillis() - currentTimeMillis);
        } catch (Exception e) {
            throw new UpdateException(ErrorCode.UNZIP, e.getMessage());
        }
    }

    private final void unzipProcess(int retryCount) {
        File file = new File(this.meta.getUpdatingDir(), this.meta.getChannel());
        if (file.exists()) {
            FileUtils.delete(file);
        }
        try {
            this.buffer.position(0L);
            UnZipUtils unZipUtils = UnZipUtils.INSTANCE;
            InputStream bufferInputStream = new BufferInputStream(this.buffer);
            String absolutePath = this.meta.getUpdatingDir().getAbsolutePath();
            Intrinsics.checkExpressionValueIsNotNull(absolutePath, "meta.updatingDir.absolutePath");
            unZipUtils.unzip(bufferInputStream, absolutePath, this.meta.getChannel());
            this.buffer.persistence();
        } catch (Throwable th) {
            int i = retryCount + 1;
            if (i >= 2) {
                GeckoLogger.d("unzip failed, not retry: " + th.getMessage());
                FileUtils.delete(this.meta.getUpdatingDir());
                throw th;
            }
            GeckoLogger.d("unzip failed, retry: " + th.getMessage());
            unzipProcess(i);
        }
    }

    private final void mergePatch() {
        GeckoLogger.d("[" + this.meta + "]start merge patch");
        long currentTimeMillis = System.currentTimeMillis();
        File swap = this.buffer.swap();
        this.buffer.persistence();
        this.buffer.release();
        File[] listFiles = this.localResFile.listFiles();
        boolean z = true;
        if (listFiles != null) {
            if (!(listFiles.length == 0)) {
                z = false;
            }
        }
        if (z) {
            throw new UpdateException(ErrorCode.MERGE_PATCH_NO_LOCAL, "get old file is null");
        }
        File file = listFiles[0];
        File destFileForSingle = getDestFileForSingle();
        File file2 = this.channelFile;
        Intrinsics.checkExpressionValueIsNotNull(file2, "channelFile");
        String absolutePath = file2.getAbsolutePath();
        ResLockManager resLockManager = ResLockManager.INSTANCE;
        Intrinsics.checkExpressionValueIsNotNull(absolutePath, "channelPath");
        if (!resLockManager.readLock(absolutePath)) {
            throw new UpdateException(ErrorCode.MERGE_PATCH_LOCK, "read lock failed");
        }
        try {
            try {
                BsPatch bsPatch = BsPatch.INSTANCE;
                Intrinsics.checkExpressionValueIsNotNull(file, "oldFile");
                File parentFile = destFileForSingle.getParentFile();
                Intrinsics.checkExpressionValueIsNotNull(parentFile, "destFile.parentFile");
                String name = destFileForSingle.getName();
                Intrinsics.checkExpressionValueIsNotNull(name, "destFile.name");
                bsPatch.patch(file, swap, parentFile, name);
                ResLockManager.INSTANCE.readUnlock(absolutePath);
                FileUtils.delete(swap);
                Buffer create = BufferPolicy.INSTANCE.create(destFileForSingle, destFileForSingle.length());
                create.position(0L);
                try {
                    MD5Utils mD5Utils = MD5Utils.INSTANCE;
                    InputStream bufferInputStream = new BufferInputStream(create);
                    PrepareMetaPackage fullPackage = this.meta.getFullPackage();
                    if (fullPackage == null) {
                        Intrinsics.throwNpe();
                    }
                    mD5Utils.check$geckox_noasanRelease(bufferInputStream, fullPackage.getMd5());
                    changeBuffer(create);
                    this.model.setDurationZipPatch(System.currentTimeMillis() - currentTimeMillis);
                } catch (Throwable th) {
                    throw new UpdateException(ErrorCode.MERGE_PATCH_CHECK, th.getMessage());
                }
            } catch (Exception e) {
                throw new UpdateException(ErrorCode.MERGE_PATCH, e.getMessage());
            }
        } catch (Throwable th2) {
            ResLockManager.INSTANCE.readUnlock(absolutePath);
            FileUtils.delete(swap);
            throw th2;
        }
    }

    private final void changeBuffer(Buffer buf) {
        this.buffer = buf;
        this.meta.setUpdateBuffer(buf);
    }

    private final File getDestFileForSingle() {
        PrepareMetaPackage fullPackage = this.meta.getFullPackage();
        if (fullPackage == null) {
            Intrinsics.throwNpe();
        }
        String str = fullPackage.getUrlList().get(0);
        int lastIndexOf$default = StringsKt.lastIndexOf$default(str, "/", 0, false, 6, (Object) null);
        if (lastIndexOf$default == -1) {
            throw new RuntimeException("url path illegal, url:" + str);
        }
        int i = lastIndexOf$default + 1;
        if (str != null) {
            String substring = str.substring(i);
            Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.String).substring(startIndex)");
            if (substring.length() == 0) {
                throw new RuntimeException("url path illegal, url:" + str);
            }
            return new File(this.resFile, substring);
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }
}
