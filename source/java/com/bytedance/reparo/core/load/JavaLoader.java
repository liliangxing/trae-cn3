package com.bytedance.reparo.core.load;

import android.os.Looper;
import android.os.SystemClock;
import com.bytedance.platform.thread.Constants;
import com.bytedance.reparo.core.ClassModifier;
import com.bytedance.reparo.core.PatchConfiguration;
import com.bytedance.reparo.core.PatchLogger;
import com.bytedance.reparo.core.WandTrick;
import com.bytedance.reparo.core.exception.JavaLoadException;
import com.bytedance.reparo.core.exception.PatchException;
import com.bytedance.reparo.core.log.TLog;
import com.bytedance.reparo.core.patch.DurationMetric;
import com.bytedance.reparo.core.patch.JavaPatch;
import com.bytedance.reparo.core.utils.ExecutorServiceUtils;
import com.bytedance.reparo.core.utils.ProcessUtils;
import com.bytedance.reparo.core.utils.TimesRecorder;
import java.lang.reflect.Method;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class JavaLoader extends BaseLoader<JavaPatch> {
    private static final String TAG = "JavaLoader";
    private static DisableLoadProtect sDisableLoadProtect;
    private JavaPatch mJavaPatch;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public interface DisableLoadProtect {
        boolean shouldDisable(String str);
    }

    public JavaLoader(PatchConfiguration patchConfiguration) {
        super(patchConfiguration);
    }

    @Override // com.bytedance.reparo.core.load.BaseLoader
    public void load(JavaPatch javaPatch, AsyncLoadResult asyncLoadResult, DurationMetric durationMetric) throws JavaLoadException {
        JavaPatch javaPatch2 = this.mJavaPatch;
        if (javaPatch2 != null && javaPatch2.isOnline() && javaPatch.equals(this.mJavaPatch)) {
            asyncLoadResult.success();
            return;
        }
        checkPatch(javaPatch);
        TimesRecorder timesRecorder = new TimesRecorder(javaPatch.getPatch().installDir, PatchConfiguration.INIT_FILE_NAME, 2, ProcessUtils.getCurrentProcessName(null));
        try {
            javaPatch.parse(durationMetric);
            if (TimesRecorder.enableCrashProtect && timesRecorder.checkOrIncrement()) {
                if (disableLoadProtect(javaPatch.getPatch().getRecordInfo().getPatchId())) {
                    PatchLogger.m303e(TAG, "skip loadProtect for " + javaPatch.getPatch().getRecordInfo().getPatchId());
                    timesRecorder.clear();
                } else {
                    throw new JavaLoadException(String.format("load java patch %s failed due to last crash.", javaPatch.getPatch().installDir.getAbsolutePath()), 101);
                }
            }
            try {
                loadPatchInternal(javaPatch, asyncLoadResult, durationMetric);
            } finally {
                timesRecorder.clear();
            }
        } catch (PatchException e) {
            throw e;
        } catch (Throwable th) {
            throw new JavaLoadException(String.format("load java patch %s failed2.", javaPatch.getJavaPatchRootDir().getAbsolutePath()), th, 103);
        }
    }

    private void checkPatch(JavaPatch javaPatch) throws JavaLoadException {
        javaPatch.isLoadSuccess();
    }

    private void loadPatchInternal(JavaPatch javaPatch, AsyncLoadResult asyncLoadResult, DurationMetric durationMetric) throws JavaLoadException {
        WandTrick.RetryTaskMayFailure applyPatch;
        try {
            try {
                applyPatch = WandTrick.getInstance().applyPatch(this.configuration.getApplication(), this.configuration.allowDebuggable(), javaPatch.getPatchClassInfoMap(), javaPatch.getAddedClassDexPaths(), javaPatch.getAddedClassNames(), javaPatch.getDeoptimizeMethodSet(), durationMetric, javaPatch.getPatch());
            } catch (PatchException e) {
                throw e;
            } catch (Throwable th) {
                javaPatch.loadFailed();
                throw new JavaLoadException(String.format("load java patch %s failed2.", javaPatch.getJavaPatchRootDir().getAbsolutePath()), th, 103);
            }
        } catch (ClassModifier.ClassVerifingException unused) {
            applyPatch = WandTrick.getInstance().applyPatch(this.configuration.getApplication(), this.configuration.allowDebuggable(), javaPatch.getPatchClassInfoMap(), javaPatch.getAddedClassDexPaths(), javaPatch.getAddedClassNames(), javaPatch.getDeoptimizeMethodSet(), durationMetric, javaPatch.getPatch());
        } catch (PatchException e2) {
            throw e2;
        } catch (Throwable th2) {
            javaPatch.loadFailed();
            throw new JavaLoadException(String.format("load java patch %s failed.", javaPatch.getJavaPatchRootDir().getAbsolutePath()), th2, 103);
        }
        try {
            doRetryTask(javaPatch, applyPatch, asyncLoadResult);
            this.mJavaPatch = javaPatch;
        } catch (PatchException e3) {
            throw e3;
        } catch (Exception e4) {
            throw new JavaLoadException(String.format("load java patch %s failed.", javaPatch.getJavaPatchRootDir().getAbsolutePath()), e4, 103);
        }
    }

    private void doRetryTask(final JavaPatch javaPatch, final WandTrick.RetryTaskMayFailure retryTaskMayFailure, final AsyncLoadResult asyncLoadResult) throws Exception {
        final WandTrick.RetryTaskMayFailure retryTaskMayFailure2 = new WandTrick.RetryTaskMayFailure() { // from class: com.bytedance.reparo.core.load.JavaLoader.1
            /* JADX WARN: Removed duplicated region for block: B:6:0x0022  */
            /* JADX WARN: Removed duplicated region for block: B:9:0x0035  */
            @Override // com.bytedance.reparo.core.WandTrick.RetryTaskMayFailure
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public int run() throws Exception {
                Class<?> cls;
                Method method = null;
                try {
                    cls = Class.forName("com.bytedance.common.jato.jit.JitBlock");
                    if (cls != null) {
                        try {
                            cls.getDeclaredMethod("lightJitBlockStart", new Class[0]);
                            method = cls.getDeclaredMethod("lightJitBlockStop", new Class[0]);
                        } catch (Exception unused) {
                            TLog.m323w("JitBlock class not found");
                            if (method != null) {
                            }
                            if (retryTaskMayFailure.tryRun()) {
                            }
                            return retryTaskMayFailure.getErrorCode();
                        }
                    }
                } catch (Exception unused2) {
                    cls = null;
                }
                if (method != null) {
                    TLog.m323w("stop JitBlock");
                    method.invoke(cls, new Object[0]);
                }
                if (retryTaskMayFailure.tryRun()) {
                    javaPatch.loadSuccess();
                    javaPatch.setOnline(true);
                    asyncLoadResult.success();
                }
                return retryTaskMayFailure.getErrorCode();
            }

            @Override // com.bytedance.reparo.core.WandTrick.RetryTaskMayFailure
            public boolean success(int i) {
                return retryTaskMayFailure.success(i);
            }
        };
        Runnable runnable = new Runnable() { // from class: com.bytedance.reparo.core.load.JavaLoader.2
            @Override // java.lang.Runnable
            public void run() {
                for (int i = 0; i < 5; i++) {
                    try {
                        if (retryTaskMayFailure2.tryRun()) {
                            return;
                        }
                        TLog.m322i("doRetryTask times " + i);
                        SystemClock.sleep(Constants.TASK_RUN_THRESHOLD);
                    } catch (PatchException e) {
                        TLog.m321e("reparo", e);
                        asyncLoadResult.failed(e);
                        return;
                    } catch (Throwable th) {
                        TLog.m321e("reparo", th);
                        asyncLoadResult.failed(new JavaLoadException(String.format("load java patch %s failed.", javaPatch.getJavaPatchRootDir().getAbsolutePath()), th, 103));
                        return;
                    }
                }
                asyncLoadResult.failed(new JavaLoadException(String.format("Retry load java patch \"%s\" failed, code =" + retryTaskMayFailure2.getErrorCode(), javaPatch.getJavaPatchRootDir().getAbsolutePath()), 105));
            }
        };
        if (retryTaskMayFailure2.tryRun()) {
            return;
        }
        if (Looper.getMainLooper() == Looper.myLooper()) {
            ExecutorServiceUtils.getReparoCoreExecutorService().execute(runnable);
        } else {
            runnable.run();
        }
    }

    @Override // com.bytedance.reparo.core.load.BaseLoader
    public void offline() {
        JavaPatch javaPatch = this.mJavaPatch;
        if (javaPatch != null) {
            javaPatch.setOnline(false);
        }
    }

    public static void setDisableLoadProtectListener(DisableLoadProtect disableLoadProtect) {
        sDisableLoadProtect = disableLoadProtect;
    }

    private boolean disableLoadProtect(String str) {
        DisableLoadProtect disableLoadProtect = sDisableLoadProtect;
        if (disableLoadProtect == null) {
            return false;
        }
        return disableLoadProtect.shouldDisable(str);
    }
}
