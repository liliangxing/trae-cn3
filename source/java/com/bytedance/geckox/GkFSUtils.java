package com.bytedance.geckox;

import android.content.Context;
import com.bytedance.android.sdk.bdticketguard.TicketGuardApiKt;
import com.bytedance.bdturing.methods.JsCallParser;
import com.bytedance.geckox.utils.ResLoadUtils;
import com.bytedance.gkfs.GeckoFileSystem;
import com.bytedance.gkfs.GkFSExecutor;
import com.bytedance.gkfs.GkFSLogger;
import com.bytedance.gkfs.UtilsKt;
import com.bytedance.gkfs.io.Meta_ioKt;
import com.bytedance.gkfs.storage.GkFSChunkStorage;
import com.bytedance.gkfs.storage.io.GkFSBlockBuffer;
import com.bytedance.gkfs.storage.io.GkFSBlockBufferKt;
import com.bytedance.keva.Keva;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* compiled from: GkFSUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bJ\u0014\u0010\t\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J\u001e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fJ\u000e\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\bJ\u000e\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0016J\u001a\u0010\u0017\u001a\u00020\u00062\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\u0019J\u000e\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0016J\u0016\u0010\u001b\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fR\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/bytedance/geckox/GkFSUtils;", "", "()V", "cleanCallbacks", "", "Lkotlin/Function0;", "", "allowTidyUp", "", "cleanOldExperiments", "onFinish", "convertBundlePath", "", "ak", "channel", "bundle", "ensureGkFSInit", "context", "Landroid/content/Context;", "isEnable", "isGkFSFile", "file", "Ljava/io/File;", "tidyUp", JsCallParser.VALUE_CALLBACK, "Lkotlin/Function1;", "transfer", "useGkFS", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class GkFSUtils {
    public static final GkFSUtils INSTANCE = new GkFSUtils();
    private static final List<Function0<Unit>> cleanCallbacks = new ArrayList();

    private GkFSUtils() {
    }

    public final boolean isEnable() {
        AppSettingsManager inst = AppSettingsManager.inst();
        Intrinsics.checkExpressionValueIsNotNull(inst, "AppSettingsManager.inst()");
        return inst.getGkFSEnable();
    }

    public final boolean useGkFS(String ak, String channel) {
        Intrinsics.checkParameterIsNotNull(ak, "ak");
        Intrinsics.checkParameterIsNotNull(channel, "channel");
        if (!isEnable()) {
            return false;
        }
        AppSettingsManager inst = AppSettingsManager.inst();
        Intrinsics.checkExpressionValueIsNotNull(inst, "AppSettingsManager.inst()");
        Map<String, List<String>> gkFSTestChannels = inst.getGkFSTestChannels();
        if (gkFSTestChannels == null) {
            return false;
        }
        List<String> list = gkFSTestChannels.get(ak);
        Boolean valueOf = list != null ? Boolean.valueOf(list.contains(channel)) : null;
        if (valueOf != null) {
            return valueOf.booleanValue();
        }
        return false;
    }

    public final String convertBundlePath(String ak, String channel, String bundle) {
        Intrinsics.checkParameterIsNotNull(ak, "ak");
        Intrinsics.checkParameterIsNotNull(channel, "channel");
        Intrinsics.checkParameterIsNotNull(bundle, "bundle");
        return (StringsKt.endsWith$default(bundle, Meta_ioKt.GKFS_FILE_EXTENSION, false, 2, (Object) null) || !useGkFS(ak, channel) || GkFSChunkStorage.INSTANCE.isInTidyUp$geckox_noasanRelease()) ? bundle : bundle + Meta_ioKt.GKFS_FILE_EXTENSION;
    }

    public final boolean isGkFSFile(File file) {
        Intrinsics.checkParameterIsNotNull(file, "file");
        String path = file.getPath();
        Intrinsics.checkExpressionValueIsNotNull(path, "file.path");
        return StringsKt.endsWith$default(path, Meta_ioKt.GKFS_FILE_EXTENSION, false, 2, (Object) null);
    }

    public final boolean allowTidyUp() {
        if (!isEnable()) {
            return false;
        }
        AppSettingsManager inst = AppSettingsManager.inst();
        Intrinsics.checkExpressionValueIsNotNull(inst, "AppSettingsManager.inst()");
        return inst.getGkFSTidyUpEnable();
    }

    public final void transfer(File file) {
        Intrinsics.checkParameterIsNotNull(file, "file");
        GeckoFileSystem.INSTANCE.store(file);
    }

    public final void tidyUp(final Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkParameterIsNotNull(callback, JsCallParser.VALUE_CALLBACK);
        GkFSExecutor.sequence(new Runnable() { // from class: com.bytedance.geckox.GkFSUtils$tidyUp$1
            @Override // java.lang.Runnable
            public final void run() {
                Object obj;
                Function1 function1 = callback;
                try {
                    Result.Companion companion = Result.Companion;
                    obj = Result.constructor-impl(GeckoFileSystem.INSTANCE.tidyUp());
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                }
                function1.invoke(Boolean.valueOf(Result.isSuccess-impl(obj)));
            }
        });
    }

    public final void ensureGkFSInit(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        if (isEnable()) {
            GeckoFileSystem.INSTANCE.init(context);
        }
    }

    public final void cleanOldExperiments(Function0<Unit> onFinish) {
        Intrinsics.checkParameterIsNotNull(onFinish, "onFinish");
        if (isEnable() && GeckoFileSystem.INSTANCE.isInitialized()) {
            final Keva repo = Keva.getRepo("gkfs_clean", 1);
            Intrinsics.checkExpressionValueIsNotNull(repo, "Keva.getRepo(\"gkfs_clean…tants.MODE_MULTI_PROCESS)");
            synchronized (repo) {
                String stringJustDisk = repo.getStringJustDisk("is_cleaned_3470", "0");
                if (stringJustDisk != null) {
                    int hashCode = stringJustDisk.hashCode();
                    if (hashCode == 49) {
                        if (stringJustDisk.equals("1")) {
                            List<Function0<Unit>> list = cleanCallbacks;
                            synchronized (list) {
                                list.add(onFinish);
                            }
                            return;
                        }
                    } else if (hashCode == 50 && stringJustDisk.equals(TicketGuardApiKt.TICKET_GUARD_ITERATION_VERSION)) {
                        onFinish.invoke();
                        return;
                    }
                }
                repo.storeStringJustDisk("is_cleaned_3470", "1");
                List<Function0<Unit>> list2 = cleanCallbacks;
                synchronized (list2) {
                    list2.add(onFinish);
                }
                GkFSExecutor.sequence(new Runnable() { // from class: com.bytedance.geckox.GkFSUtils$cleanOldExperiments$2
                    @Override // java.lang.Runnable
                    public final void run() {
                        List list3;
                        List list4;
                        List list5;
                        String str;
                        final GkFSLogger gkFSLogger = new GkFSLogger();
                        final String str2 = "clean";
                        GkFSLogger.d$default(gkFSLogger, "clean", "start", 0, false, 12, null);
                        if (UtilsKt.getDebuggable()) {
                            UtilsKt.showToast("开始旧数据清理");
                        }
                        GeckoGlobalManager inst = GeckoGlobalManager.inst();
                        Intrinsics.checkExpressionValueIsNotNull(inst, "GeckoGlobalManager.inst()");
                        final Context context = inst.getContext();
                        final Ref.IntRef intRef = new Ref.IntRef();
                        intRef.element = 0;
                        AppSettingsManager inst2 = AppSettingsManager.inst();
                        Intrinsics.checkExpressionValueIsNotNull(inst2, "AppSettingsManager.inst()");
                        Map<String, List<String>> gkFSTestChannels = inst2.getGkFSTestChannels();
                        if (gkFSTestChannels != null) {
                            for (Map.Entry<String, List<String>> entry : gkFSTestChannels.entrySet()) {
                                String key = entry.getKey();
                                GeckoGlobalManager inst3 = GeckoGlobalManager.inst();
                                Intrinsics.checkExpressionValueIsNotNull(inst3, "GeckoGlobalManager.inst()");
                                String str3 = inst3.getAccessKeyDirs().get(key);
                                if (str3 == null) {
                                    StringBuilder sb = new StringBuilder();
                                    Intrinsics.checkExpressionValueIsNotNull(context, "context");
                                    File filesDir = context.getFilesDir();
                                    Intrinsics.checkExpressionValueIsNotNull(filesDir, "context.filesDir");
                                    str3 = sb.append(filesDir.getAbsolutePath()).append("/offlineX").toString();
                                }
                                String str4 = str3;
                                if (str4.length() == 0) {
                                    GkFSLogger.w$default(gkFSLogger, "clean", "dir of " + key + " not registered yet", 0, null, false, 28, null);
                                } else {
                                    List<String> value = entry.getValue();
                                    if (value != null) {
                                        for (String str5 : value) {
                                            String channelPath = ResLoadUtils.getChannelPath(new File(str4), key, str5);
                                            String str6 = channelPath;
                                            if (str6 == null || str6.length() == 0) {
                                                str = str4;
                                                GkFSLogger.w$default(gkFSLogger, "gkfs-clean", "dir of " + key + '/' + str5 + " not found", 0, null, false, 28, null);
                                            } else {
                                                str = str4;
                                                UtilsKt.traversalSingleFiles(new File(channelPath), new Function1<File, Unit>() { // from class: com.bytedance.geckox.GkFSUtils$cleanOldExperiments$2$$special$$inlined$forEach$lambda$1
                                                    /* JADX INFO: Access modifiers changed from: package-private */
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                                        invoke((File) obj);
                                                        return Unit.INSTANCE;
                                                    }

                                                    public final void invoke(File file) {
                                                        Intrinsics.checkParameterIsNotNull(file, "file");
                                                        String name = file.getName();
                                                        Intrinsics.checkExpressionValueIsNotNull(name, "file.name");
                                                        if (StringsKt.endsWith$default(name, Meta_ioKt.GKFS_FILE_EXTENSION, false, 2, (Object) null)) {
                                                            file.delete();
                                                            intRef.element++;
                                                        }
                                                    }
                                                });
                                            }
                                            str4 = str;
                                        }
                                    }
                                }
                            }
                        }
                        final Ref.IntRef intRef2 = new Ref.IntRef();
                        intRef2.element = 0;
                        UtilsKt.traversalSingleFiles(GkFSBlockBuffer.INSTANCE.getRootDir$geckox_noasanRelease(), new Function1<File, Unit>() { // from class: com.bytedance.geckox.GkFSUtils$cleanOldExperiments$2.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((File) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(File file) {
                                Intrinsics.checkParameterIsNotNull(file, "file");
                                if (Intrinsics.areEqual(FilesKt.getExtension(file), GkFSBlockBufferKt.BLOCK_EXT)) {
                                    return;
                                }
                                file.delete();
                                intRef2.element++;
                            }
                        });
                        Keva.getRepo("gkfs_chunk_indexing", 1).clear();
                        repo.storeStringJustDisk("is_cleaned_3470", TicketGuardApiKt.TICKET_GUARD_ITERATION_VERSION);
                        GkFSLogger.d$default(gkFSLogger, "clean", "finish, deletedFileCount=" + intRef.element + ", deletedChunkCount=" + intRef2.element, 0, false, 12, null);
                        if (UtilsKt.getDebuggable()) {
                            UtilsKt.showToast("完成旧数据清理");
                        }
                        GkFSUtils gkFSUtils = GkFSUtils.INSTANCE;
                        list3 = GkFSUtils.cleanCallbacks;
                        synchronized (list3) {
                            GkFSUtils gkFSUtils2 = GkFSUtils.INSTANCE;
                            list4 = GkFSUtils.cleanCallbacks;
                            Iterator it = list4.iterator();
                            while (it.hasNext()) {
                                ((Function0) it.next()).invoke();
                            }
                            GkFSUtils gkFSUtils3 = GkFSUtils.INSTANCE;
                            list5 = GkFSUtils.cleanCallbacks;
                            list5.clear();
                            Unit unit = Unit.INSTANCE;
                        }
                    }
                });
            }
        }
    }
}
