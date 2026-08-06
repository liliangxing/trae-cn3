package com.bytedance.gkfs;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.widget.Toast;
import com.bytedance.geckox.utils.UIHandler;
import com.bytedance.iesgurd.core.GlobalManager;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: utils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u001c\n\u0002\b\u0002\u001a\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0001H\u0000\u001a\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011\u001a.\u0010\u0012\u001a\u0002H\u0013\"\u0004\b\u0000\u0010\u00132\u0018\u0010\u0014\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u0016\u0012\u0004\u0012\u0002H\u00130\u0015H\u0080\b¢\u0006\u0002\u0010\u0017\u001a.\u0010\u0018\u001a\u0002H\u0013\"\u0004\b\u0000\u0010\u00132\u0018\u0010\u0014\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u0016\u0012\u0004\u0012\u0002H\u00130\u0015H\u0080\b¢\u0006\u0002\u0010\u0017\u001a\"\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u001b2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u000f0\u0015\u001a\u0012\u0010\u001d\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u0001\u001a-\u0010\u001f\u001a\u00020\f\"\u0004\b\u0000\u0010 *\b\u0012\u0004\u0012\u0002H 0!2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u0002H \u0012\u0004\u0012\u00020\f0\u0015H\u0086\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006\"\u001b\u0010\t\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\b\u001a\u0004\b\t\u0010\u0006¨\u0006#"}, d2 = {"CHUNK_META_SIZE", "", "GKFS_HEADER_META_SIZE", "debuggable", "", "getDebuggable", "()Z", "debuggable$delegate", "Lkotlin/Lazy;", "isMainProcess", "isMainProcess$delegate", "calcHeaderSize", "", "chunkCount", "showToast", "", "text", "", "traceTime", "R", "block", "Lkotlin/Function1;", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "traceTimePrecise", "traversalSingleFiles", "dir", "Ljava/io/File;", "onSingleFile", "alignTo", "alignment", "sumByLong", "T", "", "selector", "geckox_noasanRelease"}, k = 2, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class UtilsKt {
    public static final int CHUNK_META_SIZE = 44;
    public static final int GKFS_HEADER_META_SIZE = 13;
    private static final Lazy debuggable$delegate = LazyKt.lazy(new Function0<Boolean>() { // from class: com.bytedance.gkfs.UtilsKt$debuggable$2
        public /* bridge */ /* synthetic */ Object invoke() {
            return Boolean.valueOf(m556invoke());
        }

        /* renamed from: invoke, reason: collision with other method in class */
        public final boolean m556invoke() {
            Object obj;
            try {
                Result.Companion companion = Result.Companion;
                obj = Result.constructor-impl(Class.forName("com.bytedance.geckox.debugtool.ui.GkFSDebugActivity"));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            return Result.isSuccess-impl(obj);
        }
    });
    private static final Lazy isMainProcess$delegate = LazyKt.lazy(new Function0<Boolean>() { // from class: com.bytedance.gkfs.UtilsKt$isMainProcess$2
        public /* bridge */ /* synthetic */ Object invoke() {
            return Boolean.valueOf(m557invoke());
        }

        /* renamed from: invoke, reason: collision with other method in class */
        public final boolean m557invoke() {
            List listOf = CollectionsKt.listOf(new Function0[]{new Function0<String>() { // from class: com.bytedance.gkfs.UtilsKt$isMainProcess$2$getProcessNameFuncs$1
                /* JADX WARN: Removed duplicated region for block: B:15:0x0036  */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final String invoke() {
                    Object obj;
                    String str;
                    try {
                        Result.Companion companion = Result.Companion;
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.Companion;
                        obj = Result.constructor-impl(ResultKt.createFailure(th));
                    }
                    if (Build.VERSION.SDK_INT >= 28 && (str = Application.getProcessName()) != null) {
                        if (str.length() > 0) {
                            obj = Result.constructor-impl(str);
                            return (String) (Result.isFailure-impl(obj) ? null : obj);
                        }
                    }
                    str = null;
                    obj = Result.constructor-impl(str);
                    return (String) (Result.isFailure-impl(obj) ? null : obj);
                }
            }, new Function0<String>() { // from class: com.bytedance.gkfs.UtilsKt$isMainProcess$2$getProcessNameFuncs$2
                public final String invoke() {
                    Object obj;
                    try {
                        Result.Companion companion = Result.Companion;
                        Method declaredMethod = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", null);
                        Intrinsics.checkExpressionValueIsNotNull(declaredMethod, "it");
                        declaredMethod.setAccessible(true);
                        Object invoke = declaredMethod.invoke(null, null);
                        if (!(invoke instanceof String)) {
                            invoke = null;
                        }
                        obj = Result.constructor-impl((String) invoke);
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.Companion;
                        obj = Result.constructor-impl(ResultKt.createFailure(th));
                    }
                    return (String) (Result.isFailure-impl(obj) ? null : obj);
                }
            }, new Function0<String>() { // from class: com.bytedance.gkfs.UtilsKt$isMainProcess$2$getProcessNameFuncs$3
                public final String invoke() {
                    Object obj;
                    int read;
                    try {
                        Result.Companion companion = Result.Companion;
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));
                        try {
                            BufferedReader bufferedReader2 = bufferedReader;
                            StringBuilder sb = new StringBuilder();
                            do {
                                read = bufferedReader2.read();
                                sb.append(read);
                            } while (read > 0);
                            String sb2 = sb.toString();
                            CloseableKt.closeFinally(bufferedReader, (Throwable) null);
                            obj = Result.constructor-impl(sb2);
                        } finally {
                        }
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.Companion;
                        obj = Result.constructor-impl(ResultKt.createFailure(th));
                    }
                    return (String) (Result.isFailure-impl(obj) ? null : obj);
                }
            }, new Function0<String>() { // from class: com.bytedance.gkfs.UtilsKt$isMainProcess$2$getProcessNameFuncs$4
                /* JADX WARN: Removed duplicated region for block: B:27:0x0066  */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final String invoke() {
                    Object obj;
                    ActivityManager activityManager;
                    String str;
                    Object obj2;
                    try {
                        Result.Companion companion = Result.Companion;
                        Context context = GlobalManager.INSTANCE.getContext();
                        Object systemService = context != null ? context.getSystemService("activity") : null;
                        if (!(systemService instanceof ActivityManager)) {
                            systemService = null;
                        }
                        activityManager = (ActivityManager) systemService;
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.Companion;
                        obj = Result.constructor-impl(ResultKt.createFailure(th));
                    }
                    if (activityManager != null) {
                        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
                        Intrinsics.checkExpressionValueIsNotNull(runningAppProcesses, "am.runningAppProcesses");
                        Iterator<T> it = runningAppProcesses.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                obj2 = null;
                                break;
                            }
                            obj2 = it.next();
                            if (((ActivityManager.RunningAppProcessInfo) obj2).pid == Process.myPid()) {
                                break;
                            }
                        }
                        ActivityManager.RunningAppProcessInfo runningAppProcessInfo = (ActivityManager.RunningAppProcessInfo) obj2;
                        if (runningAppProcessInfo != null) {
                            str = runningAppProcessInfo.processName;
                            obj = Result.constructor-impl(str);
                            return (String) (Result.isFailure-impl(obj) ? null : obj);
                        }
                    }
                    str = null;
                    obj = Result.constructor-impl(str);
                    return (String) (Result.isFailure-impl(obj) ? null : obj);
                }
            }});
            Context context = GlobalManager.INSTANCE.getContext();
            String packageName = context != null ? context.getPackageName() : null;
            Iterator it = listOf.iterator();
            String str = "";
            while (it.hasNext()) {
                str = (String) ((Function0) it.next()).invoke();
                if (str == null) {
                    str = "";
                }
                if (str.length() > 0) {
                    break;
                }
            }
            return Intrinsics.areEqual(str, packageName);
        }
    });

    public static final long calcHeaderSize(int i) {
        return (i * 44) + 15;
    }

    public static final boolean getDebuggable() {
        return ((Boolean) debuggable$delegate.getValue()).booleanValue();
    }

    public static final boolean isMainProcess() {
        return ((Boolean) isMainProcess$delegate.getValue()).booleanValue();
    }

    public static final <R> R traceTime(Function1<? super Function0<Long>, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "block");
        return (R) function1.invoke(new UtilsKt$traceTime$1$1(System.currentTimeMillis()));
    }

    public static final <R> R traceTimePrecise(Function1<? super Function0<Long>, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "block");
        return (R) function1.invoke(new UtilsKt$traceTimePrecise$1$1(System.nanoTime()));
    }

    public static final void traversalSingleFiles(File file, Function1<? super File, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(file, "dir");
        Intrinsics.checkParameterIsNotNull(function1, "onSingleFile");
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.offer(file);
        ArrayDeque arrayDeque2 = arrayDeque;
        ArrayList arrayList = new ArrayList();
        while (arrayDeque2.size() > 0) {
            File file2 = (File) arrayDeque2.poll();
            if (!arrayList.contains(file2)) {
                Intrinsics.checkExpressionValueIsNotNull(file2, "file");
                arrayList.add(file2);
                if (file2.isDirectory()) {
                    File[] listFiles = file2.listFiles();
                    Intrinsics.checkExpressionValueIsNotNull(listFiles, "file.listFiles()");
                    for (File file3 : listFiles) {
                        arrayDeque2.offer(file3);
                    }
                } else if (file2.isFile()) {
                    function1.invoke(file2);
                }
            }
        }
    }

    public static final <T> long sumByLong(Iterable<? extends T> iterable, Function1<? super T, Long> function1) {
        Intrinsics.checkParameterIsNotNull(iterable, "$this$sumByLong");
        Intrinsics.checkParameterIsNotNull(function1, "selector");
        Iterator<? extends T> it = iterable.iterator();
        long j = 0;
        while (it.hasNext()) {
            j += ((Number) function1.invoke(it.next())).longValue();
        }
        return j;
    }

    public static final void showToast(final String str) {
        Intrinsics.checkParameterIsNotNull(str, "text");
        final Context context = GlobalManager.INSTANCE.getContext();
        if (context != null) {
            UIHandler.INSTANCE.runOnUIThread(new Function0<Unit>() { // from class: com.bytedance.gkfs.UtilsKt$showToast$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m562invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m562invoke() {
                    Toast.makeText(context, str, 1).show();
                }
            });
        }
    }

    public static final int alignTo(int i, int i2) {
        return ((i / i2) + (i % i2 == 0 ? 0 : 1)) * i2;
    }
}
