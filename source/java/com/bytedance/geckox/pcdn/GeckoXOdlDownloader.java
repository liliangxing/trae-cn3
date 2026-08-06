package com.bytedance.geckox.pcdn;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.android.live.pcdn.api.IPCDNDownloadTask;
import com.bytedance.android.live.pcdn.api.IPCDNDownloadTaskListener;
import com.bytedance.android.live.pcdn.api.IPCDNDownloader;
import com.bytedance.android.live.pcdn.api.IPCDNDownloaderListener;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.bytedance.geckox.GeckoGlobalConfig;
import com.bytedance.geckox.GeckoGlobalManager;
import com.bytedance.geckox.buffer.stream.BufferOutputStream;
import com.bytedance.geckox.gson.GsonUtil;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.geckox.net.HttpRequestInfo;
import com.bytedance.geckox.pcdn.GeckoXOdlDownloader$Companion$odlListenerImpl$2;
import com.bytedance.iesgurd.meta.PrepareMeta;
import com.bytedance.iesgurd.settings.GlobalSettingsManager;
import com.bytedance.iesgurd.settings.SettingsExtra;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

/* compiled from: GeckoXOdlDownloader.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/bytedance/geckox/pcdn/GeckoXOdlDownloader;", "", "url", "", "destName", "updatePackage", "Lcom/bytedance/iesgurd/meta/PrepareMeta;", "outputStream", "Lcom/bytedance/geckox/buffer/stream/BufferOutputStream;", "(Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/iesgurd/meta/PrepareMeta;Lcom/bytedance/geckox/buffer/stream/BufferOutputStream;)V", "downloader", "Lcom/bytedance/android/live/pcdn/api/IPCDNDownloader;", "taskId", "", "download", "", "Companion", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class GeckoXOdlDownloader {
    private static volatile File odlBaseAbsPath;
    private static volatile IPCDNDownloader odlDownloader;
    private final String destName;
    private final IPCDNDownloader downloader;
    private final BufferOutputStream outputStream;
    private final int taskId;
    private final PrepareMeta updatePackage;
    private final String url;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static AtomicInteger pcdnTaskId = new AtomicInteger(0);
    private static final Lazy odlListenerImpl$delegate = LazyKt.lazy(new Function0<GeckoXOdlDownloader$Companion$odlListenerImpl$2.C11281>() { // from class: com.bytedance.geckox.pcdn.GeckoXOdlDownloader$Companion$odlListenerImpl$2
        /* JADX WARN: Type inference failed for: r0v0, types: [com.bytedance.geckox.pcdn.GeckoXOdlDownloader$Companion$odlListenerImpl$2$1] */
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final C11281 m545invoke() {
            return new IPCDNDownloaderListener() { // from class: com.bytedance.geckox.pcdn.GeckoXOdlDownloader$Companion$odlListenerImpl$2.1
                public void notifyAllCompleteFiles(String[] fileNamesWithPath) {
                    GeckoLogger.m296d("[pcdn]Odl perform notifyAllCompleteFiles, fileNamesWithPath=" + fileNamesWithPath);
                }

                public void notifyAllUnfinishedFiles(String[] fileNamesWithPath) {
                    GeckoLogger.m296d("[pcdn]Odl perform notifyAllUnfinishedFiles, fileNamesWithPath=" + fileNamesWithPath);
                }

                public void notifyMsg(String msgType, String msgValue) {
                    GeckoLogger.m296d("[pcdn]Odl perform notifyAllUnfinishedFiles, msgType=" + msgType + ", msgValue=" + msgValue);
                }

                public void notifyPointLog(int msgTpye, String msgValue) {
                    GeckoLogger.m296d("[pcdn]Odl perform notifyPointLog, msgType=" + msgTpye + ", msgValue=" + msgValue);
                }

                public void notifyOdlLog(int msgTpye, String msgValue) {
                    GeckoLogger.m296d("[pcdn]Odl perform notifyOdlLog, msgType=" + msgTpye + ", msgValue=" + msgValue);
                }
            };
        }
    });

    public GeckoXOdlDownloader(String str, String str2, PrepareMeta prepareMeta, BufferOutputStream bufferOutputStream) {
        Intrinsics.checkParameterIsNotNull(str, "url");
        Intrinsics.checkParameterIsNotNull(str2, "destName");
        Intrinsics.checkParameterIsNotNull(prepareMeta, "updatePackage");
        Intrinsics.checkParameterIsNotNull(bufferOutputStream, "outputStream");
        this.url = str;
        this.destName = str2;
        this.updatePackage = prepareMeta;
        this.outputStream = bufferOutputStream;
        this.taskId = pcdnTaskId.incrementAndGet();
        this.downloader = odlDownloader;
    }

    /* compiled from: GeckoXOdlDownloader.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/bytedance/geckox/pcdn/GeckoXOdlDownloader$Companion;", "", "()V", "odlBaseAbsPath", "Ljava/io/File;", "odlDownloader", "Lcom/bytedance/android/live/pcdn/api/IPCDNDownloader;", "odlListenerImpl", "Lcom/bytedance/android/live/pcdn/api/IPCDNDownloaderListener;", "getOdlListenerImpl", "()Lcom/bytedance/android/live/pcdn/api/IPCDNDownloaderListener;", "odlListenerImpl$delegate", "Lkotlin/Lazy;", "pcdnTaskId", "Ljava/util/concurrent/atomic/AtomicInteger;", "initIfNeed", "", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static final class Companion {
        private final IPCDNDownloaderListener getOdlListenerImpl() {
            Lazy lazy = GeckoXOdlDownloader.odlListenerImpl$delegate;
            Companion companion = GeckoXOdlDownloader.INSTANCE;
            return (IPCDNDownloaderListener) lazy.getValue();
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String initIfNeed() {
            String str;
            synchronized (this) {
                GeckoGlobalManager inst = GeckoGlobalManager.inst();
                Intrinsics.checkExpressionValueIsNotNull(inst, "GeckoGlobalManager.inst()");
                GeckoGlobalConfig globalConfig = inst.getGlobalConfig();
                if (globalConfig == null) {
                    str = "config not exist";
                } else {
                    if (GeckoXOdlDownloader.odlDownloader != null) {
                        GeckoLogger.m296d("[pcdn]Odl already initialized");
                        return null;
                    }
                    SettingsExtra settingsExtra = GlobalSettingsManager.INSTANCE.getSettingsExtra();
                    SettingsExtra.PCDNInfo pcdnInfo = settingsExtra != null ? settingsExtra.getPcdnInfo() : null;
                    if (pcdnInfo == null) {
                        str = "p2p struct not exists";
                    } else if (pcdnInfo.getBusinessId() == null) {
                        str = "sid not exists";
                    } else {
                        try {
                            Class<?> cls = Class.forName("com.bytedance.android.live.pcdn.impl.PCDNDownloader");
                            try {
                                if (!TextUtils.isEmpty(globalConfig.getDeviceId())) {
                                    GeckoLogger.m296d("[pcdn]Starting to build odl config...");
                                    JSONObject jSONObject = new JSONObject();
                                    Context context = globalConfig.getContext();
                                    Intrinsics.checkExpressionValueIsNotNull(context, "config.context");
                                    GeckoXOdlDownloader.odlBaseAbsPath = new File(context.getFilesDir(), "geckox_odl_root");
                                    File file = GeckoXOdlDownloader.odlBaseAbsPath;
                                    if (file == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("odlBaseAbsPath");
                                    }
                                    jSONObject.put("pcdn_basepath", new File(file, TraceStatsConsts.STATS_BASE_MODULE).getAbsolutePath());
                                    File file2 = GeckoXOdlDownloader.odlBaseAbsPath;
                                    if (file2 == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("odlBaseAbsPath");
                                    }
                                    jSONObject.put("pcdn_cachepath", new File(file2, "meta_cache").getAbsolutePath());
                                    File file3 = GeckoXOdlDownloader.odlBaseAbsPath;
                                    if (file3 == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("odlBaseAbsPath");
                                    }
                                    jSONObject.put("odl_cachepath", new File(file3, "odl_cache").getAbsolutePath());
                                    jSONObject.put("pcdn_cachesize", 20);
                                    jSONObject.put("pcdn_memorysize", 1);
                                    jSONObject.put("pcdn_businessid", pcdnInfo.getBusinessId());
                                    jSONObject.put("pcdn_groupid", pcdnInfo.getGroupId());
                                    jSONObject.put("pcdn_testid", pcdnInfo.getTestId());
                                    jSONObject.put("deviceid", globalConfig.getDeviceId());
                                    jSONObject.put("appid", globalConfig.getAppId());
                                    GeckoLogger.m296d("[pcdn]Starting to init odl downloader...");
                                    if (cls == null) {
                                        Intrinsics.throwNpe();
                                    }
                                    GeckoXOdlDownloader.odlDownloader = (IPCDNDownloader) cls.getConstructor(new Class[0]).newInstance(new Object[0]);
                                    IPCDNDownloader iPCDNDownloader = GeckoXOdlDownloader.odlDownloader;
                                    if (iPCDNDownloader == null) {
                                        Intrinsics.throwNpe();
                                    }
                                    String jSONObject2 = jSONObject.toString();
                                    Intrinsics.checkExpressionValueIsNotNull(jSONObject2, "odlConfig.toString()");
                                    int init = iPCDNDownloader.init(jSONObject2, GeckoXOdlDownloader.INSTANCE.getOdlListenerImpl());
                                    if (init == 0) {
                                        GeckoLogger.m296d("[pcdn]Odl initialize success");
                                        return null;
                                    }
                                    throw new IllegalStateException("initDownloader failed, ret=" + init);
                                }
                                str = "device_id is empty";
                            } catch (Throwable th) {
                                th.printStackTrace();
                                GeckoXOdlDownloader.odlDownloader = null;
                                GeckoLogger.m296d("[pcdn]Odl initialize failed, cause=" + th);
                                return th.getMessage();
                            }
                        } catch (Throwable th2) {
                            GeckoLogger.m296d("[pcdn]Odl plugin not installed yet..., cause by " + th2);
                            str = th2.toString();
                        }
                    }
                }
                return str;
            }
        }
    }

    public final void download() {
        Object obj;
        FileInputStream fileInputStream;
        if (this.downloader == null) {
            throw new IllegalStateException("Odl downloader still be null, do you invoke initIfNeed?");
        }
        String md5 = this.updatePackage.getPackage().getMd5();
        String str = this.updatePackage.getAccessKey() + '-' + this.updatePackage.getChannel() + '-' + this.updatePackage.getVersion() + '-' + this.destName;
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = null;
        BufferOutputStream bufferOutputStream = this.outputStream;
        String str2 = this.url;
        Uri parse = Uri.parse(str2);
        Intrinsics.checkExpressionValueIsNotNull(parse, "Uri.parse(url)");
        String host = parse.getHost();
        if (host == null) {
            Intrinsics.throwNpe();
        }
        bufferOutputStream.setHttpRequestInfo(new HttpRequestInfo(str2, host, this.updatePackage.getPackage().getLength()));
        long currentTimeMillis = System.currentTimeMillis();
        IPCDNDownloadTask createTask = this.downloader.createTask(this.url, md5, str);
        if (createTask == null) {
            throw new IllegalStateException("Create odl task failed, receive null");
        }
        createTask.setStringValue("notify_sizeinfo", "true");
        GeckoLogger.m296d("[pcdn][" + this.taskId + "]Start to perform odl task " + createTask.hashCode() + " for " + this.url + ", uniqueId=" + md5 + ", fileName=" + str);
        Ref.ObjectRef countDownLatch = new CountDownLatch(1);
        final Ref.IntRef intRef = new Ref.IntRef();
        final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        Pair pair = new Pair(0, "");
        intRef.element = ((Number) pair.component1()).intValue();
        objectRef2.element = (String) pair.component2();
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = false;
        final Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
        booleanRef2.element = false;
        final Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
        objectRef3.element = null;
        final Ref.ObjectRef objectRef4 = countDownLatch;
        int start = createTask.start(new IPCDNDownloadTaskListener() { // from class: com.bytedance.geckox.pcdn.GeckoXOdlDownloader$download$ret$1
            public void notifyTaskProgress(IPCDNDownloadTask task, long fileSize, long dloadPos, long dloadSpeed) {
                Intrinsics.checkParameterIsNotNull(task, "task");
            }

            public void notifyTaskData(IPCDNDownloadTask task, long offset, long canReadSize) {
                int i;
                Intrinsics.checkParameterIsNotNull(task, "task");
                StringBuilder sb = new StringBuilder("[pcdn][");
                i = GeckoXOdlDownloader.this.taskId;
                GeckoLogger.m296d(sb.append(i).append("]Odl perform ").append(hashCode()).append(" notifyTaskData, offset=").append(offset).append(", canReadSize=").append(canReadSize).toString());
            }

            public void notifyTaskComplete(IPCDNDownloadTask task) {
                int i;
                Intrinsics.checkParameterIsNotNull(task, "task");
                StringBuilder sb = new StringBuilder("[pcdn][");
                i = GeckoXOdlDownloader.this.taskId;
                GeckoLogger.m296d(sb.append(i).append("]Odl perform ").append(hashCode()).append(" notifyTaskComplete").toString());
                booleanRef2.element = true;
                booleanRef.element = true;
                objectRef4.countDown();
            }

            public void notifyTaskError(IPCDNDownloadTask task, int errorCode, String errorMsg) {
                int i;
                Intrinsics.checkParameterIsNotNull(task, "task");
                StringBuilder sb = new StringBuilder("[pcdn][");
                i = GeckoXOdlDownloader.this.taskId;
                GeckoLogger.m296d(sb.append(i).append("]Odl perform ").append(hashCode()).append(" notifyTaskError, iErrorCode=").append(errorCode).append(", strErrorMsg=").append(errorMsg).toString());
                booleanRef2.element = true;
                booleanRef.element = false;
                intRef.element = errorCode;
                Ref.ObjectRef objectRef5 = objectRef2;
                if (errorMsg == null) {
                    errorMsg = "";
                }
                objectRef5.element = errorMsg;
                objectRef4.countDown();
            }

            public void notifyMsg(IPCDNDownloadTask task, String msgType, String msgValue) {
                int i;
                int i2;
                Object obj2;
                int i3;
                Intrinsics.checkParameterIsNotNull(task, "task");
                if (msgType != null) {
                    int hashCode = msgType.hashCode();
                    if (hashCode == -1316408056) {
                        if (msgType.equals("file_path")) {
                            objectRef.element = new File(msgValue);
                        }
                    } else if (hashCode == 661970438 && msgType.equals("download_sizeinfo")) {
                        String str3 = msgValue;
                        if (!(str3 == null || str3.length() == 0)) {
                            Ref.ObjectRef objectRef5 = objectRef3;
                            try {
                                Result.Companion companion = Result.Companion;
                                obj2 = Result.constructor-impl((OdlDownloadSize) GsonUtil.INSTANCE.inst().getGson().fromJson(msgValue, OdlDownloadSize.class));
                            } catch (Throwable th) {
                                Result.Companion companion2 = Result.Companion;
                                obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                            }
                            Throwable th2 = Result.exceptionOrNull-impl(obj2);
                            if (th2 != null) {
                                StringBuilder sb = new StringBuilder("[pcdn][");
                                i3 = GeckoXOdlDownloader.this.taskId;
                                GeckoLogger.m296d(sb.append(i3).append("]Odl pass ").append(hashCode()).append(" download_sizeinfo through but jsonify failed, ").append(th2).toString());
                                obj2 = null;
                            }
                            objectRef5.element = (OdlDownloadSize) obj2;
                        } else {
                            StringBuilder sb2 = new StringBuilder("[pcdn][");
                            i2 = GeckoXOdlDownloader.this.taskId;
                            GeckoLogger.m296d(sb2.append(i2).append("]Odl pass ").append(hashCode()).append(" download_sizeinfo through but msgValue is empty").toString());
                        }
                    }
                }
                StringBuilder sb3 = new StringBuilder("[pcdn][");
                i = GeckoXOdlDownloader.this.taskId;
                GeckoLogger.m296d(sb3.append(i).append("]Odl perform ").append(hashCode()).append(" notifyMsg, msgType=").append(msgType).append(", msgValue=").append(msgValue).toString());
            }
        });
        long j = -1;
        try {
            if (start == 0) {
                try {
                    if (!booleanRef2.element) {
                        GeckoLogger.m296d("[pcdn][" + this.taskId + "]Waiting odl task complete...");
                        countDownLatch.await(1L, TimeUnit.MINUTES);
                    }
                    j = System.currentTimeMillis() - currentTimeMillis;
                    GeckoLogger.m296d("[pcdn][" + this.taskId + "]Odl task complete, result=" + booleanRef.element + ", costTime=" + j);
                    if (!booleanRef.element) {
                        throw new IOException("Odl running task failed, errCode=" + intRef.element + ", errMsg=" + ((String) objectRef2.element));
                    }
                    File file = (File) objectRef.element;
                    if (file != null && !file.exists()) {
                        GeckoLogger.m296d("[pcdn][" + this.taskId + "]Odl not pass file_path through, assign default");
                        File file2 = odlBaseAbsPath;
                        if (file2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("odlBaseAbsPath");
                        }
                        objectRef.element = new File(file2, "odl_cache/" + str);
                    }
                    FileInputStream fileInputStream2 = new FileInputStream((File) objectRef.element);
                    try {
                        Result.Companion companion = Result.Companion;
                        fileInputStream = fileInputStream2;
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.Companion;
                        obj = Result.constructor-impl(ResultKt.createFailure(th));
                    }
                    try {
                        long copyTo = ByteStreamsKt.copyTo(fileInputStream, this.outputStream, 8192);
                        CloseableKt.closeFinally(fileInputStream, (Throwable) null);
                        obj = Result.constructor-impl(Long.valueOf(copyTo));
                        Throwable th2 = Result.exceptionOrNull-impl(obj);
                        if (th2 != null) {
                            throw th2;
                        }
                        this.updatePackage.odlDuration = j;
                        if (((OdlDownloadSize) objectRef3.element) == null) {
                            GeckoLogger.m296d("[pcdn][" + this.taskId + "]Odl not pass download_sizeinfo through");
                        } else {
                            PrepareMeta prepareMeta = this.updatePackage;
                            OdlDownloadSize odlDownloadSize = (OdlDownloadSize) objectRef3.element;
                            if (odlDownloadSize == null) {
                                Intrinsics.throwNpe();
                            }
                            prepareMeta.odlP2PReceivedBytes = odlDownloadSize.getP2pSize();
                            PrepareMeta prepareMeta2 = this.updatePackage;
                            OdlDownloadSize odlDownloadSize2 = (OdlDownloadSize) objectRef3.element;
                            if (odlDownloadSize2 == null) {
                                Intrinsics.throwNpe();
                            }
                            prepareMeta2.odlCDNReceivedBytes = odlDownloadSize2.getCdnSize();
                        }
                        createTask.deleteFile();
                        createTask.stop();
                        this.downloader.deleteTask(createTask);
                    } finally {
                    }
                } catch (Throwable th3) {
                    th = th3;
                    objectRef4 = objectRef3;
                    this.updatePackage.odlDuration = j;
                    if (((OdlDownloadSize) objectRef4.element) == null) {
                        GeckoLogger.m296d("[pcdn][" + this.taskId + "]Odl not pass download_sizeinfo through");
                    } else {
                        PrepareMeta prepareMeta3 = this.updatePackage;
                        OdlDownloadSize odlDownloadSize3 = (OdlDownloadSize) objectRef4.element;
                        if (odlDownloadSize3 == null) {
                            Intrinsics.throwNpe();
                        }
                        prepareMeta3.odlP2PReceivedBytes = odlDownloadSize3.getP2pSize();
                        PrepareMeta prepareMeta4 = this.updatePackage;
                        OdlDownloadSize odlDownloadSize4 = (OdlDownloadSize) objectRef4.element;
                        if (odlDownloadSize4 == null) {
                            Intrinsics.throwNpe();
                        }
                        prepareMeta4.odlCDNReceivedBytes = odlDownloadSize4.getCdnSize();
                    }
                    createTask.deleteFile();
                    createTask.stop();
                    this.downloader.deleteTask(createTask);
                    throw th;
                }
            } else {
                throw new IllegalStateException("Odl start task failed, ret=" + start);
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }
}
