package com.ttnet.org.chromium.base.library_loader;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Bundle;
import android.system.Os;
import com.ttnet.org.chromium.base.BaseSwitches;
import com.ttnet.org.chromium.base.CommandLine;
import com.ttnet.org.chromium.base.ContextUtils;
import com.ttnet.org.chromium.base.JNIUtils;
import com.ttnet.org.chromium.base.Log;
import com.ttnet.org.chromium.base.NativeLibraryLoadedStatus;
import com.ttnet.org.chromium.base.StrictModeContext;
import com.ttnet.org.chromium.base.TimeUtils;
import com.ttnet.org.chromium.base.TraceEvent;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.MainDex;
import com.ttnet.org.chromium.base.compat.ApiHelperForM;
import com.ttnet.org.chromium.base.metrics.RecordHistogram;
import com.ttnet.org.chromium.base.metrics.UmaRecorderHolder;
import com.ttnet.org.chromium.build.BuildConfig;
import com.ttnet.org.chromium.build.NativeLibraries;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Locale;

@JNINamespace("base::android")
@MainDex
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class LibraryLoader {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final boolean ALLOW_CHROMIUM_LINKER_IN_ZYGOTE = true;
    private static final String BACKGROUND_THREAD_POOL_KEY = "background_thread_pool_enabled";
    static final boolean DEBUG = false;
    private static final int DEFAULT_REACHED_CODE_SAMPLING_INTERVAL_US = 10000;
    private static final String DEPRECATED_REACHED_CODE_PROFILER_KEY = "reached_code_profiler_enabled";
    private static final String REACHED_CODE_SAMPLING_INTERVAL_KEY = "reached_code_sampling_interval";
    private static final String TAG = "LibraryLoader";
    private static boolean sBrowserStartupBlockedForTesting;
    private static LibraryLoader sInstance = new LibraryLoader();
    private boolean mCommandLineSwitched;
    private boolean mConfigurationSet;
    private boolean mFallbackToSystemLinker;
    private volatile boolean mInitialized;
    private NativeLibraryPreloader mLibraryPreloader;
    private boolean mLibraryPreloaderCalled;
    private int mLibraryProcessType;
    private Linker mLinker;
    private volatile int mLoadState;
    private boolean mLoadedByZygote;
    private boolean mUseChromiumLinker;
    private boolean mUseModernLinker;
    private final Object mNonMainDexLock = new Object();
    private final MultiProcessMediator mMediator = new MultiProcessMediator();
    private final Object mLock = new Object();

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    private @interface CreatedIn {
        public static final int CHILD_WITHOUT_ZYGOTE = 2;
        public static final int MAIN = 0;
        public static final int ZYGOTE = 1;
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    private @interface LoadState {
        public static final int LOADED = 2;
        public static final int MAIN_DEX_LOADED = 1;
        public static final int NOT_LOADED = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public interface Natives {
        boolean libraryLoaded(int i);

        void registerNonMainDexJni();
    }

    public void assertCompatibleProcessType(int i) {
    }

    public static boolean mainProcessIntendsToProvideRelroFd() {
        return Build.VERSION.SDK_INT <= 30;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public class MultiProcessMediator {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final String LINKER_HISTOGRAM_PREFIX = "ChromiumAndroidLinker.";
        private volatile int mCreatedIn = 0;
        private volatile boolean mInitDone;
        private long mLoadAddress;

        public MultiProcessMediator() {
        }

        public void takeLoadAddressFromBundle(Bundle bundle) {
            this.mLoadAddress = Linker.extractLoadAddressFromBundle(bundle);
        }

        private long getLoadAddress() {
            long j;
            synchronized (LibraryLoader.this.mLock) {
                j = this.mLoadAddress;
            }
            return j;
        }

        public void ensureInitializedInMainProcess() {
            if (this.mInitDone) {
                return;
            }
            if (LibraryLoader.this.useChromiumLinker()) {
                boolean mainProcessIntendsToProvideRelroFd = LibraryLoader.mainProcessIntendsToProvideRelroFd();
                LibraryLoader.this.getLinker().ensureInitialized(mainProcessIntendsToProvideRelroFd, mainProcessIntendsToProvideRelroFd ? 2 : 0, 0L);
            }
            this.mCreatedIn = 0;
            this.mInitDone = true;
        }

        public void putLoadAddressToBundle(Bundle bundle) {
            if (LibraryLoader.this.useChromiumLinker()) {
                LibraryLoader.this.getLinker().putLoadAddressToBundle(bundle);
            }
        }

        public void initInAppZygote() {
            if (!LibraryLoader.this.useChromiumLinker() || LibraryLoader.mainProcessIntendsToProvideRelroFd()) {
                LibraryLoader.this.mFallbackToSystemLinker = true;
            } else {
                LibraryLoader.this.getLinker().ensureInitialized(true, 0, 0L);
            }
            this.mCreatedIn = 1;
        }

        public void initInChildProcess() {
            if (!LibraryLoader.this.useChromiumLinker()) {
                this.mInitDone = true;
                return;
            }
            if (LibraryLoader.mainProcessIntendsToProvideRelroFd()) {
                LibraryLoader.this.getLinker().ensureInitialized(false, 1, getLoadAddress());
            } else if (!LibraryLoader.this.isLoadedByZygote()) {
                if (this.mCreatedIn == 1) {
                    LibraryLoader.this.getLinker().ensureInitialized(false, 1, getLoadAddress());
                } else {
                    LibraryLoader.this.getLinker().ensureInitialized(false, 0, getLoadAddress());
                }
            }
            if (this.mCreatedIn != 1) {
                this.mCreatedIn = 2;
            }
            this.mInitDone = true;
        }

        public void takeSharedRelrosFromBundle(Bundle bundle) {
            if (LibraryLoader.this.useChromiumLinker()) {
                LibraryLoader.this.getLinker().takeSharedRelrosFromBundle(bundle);
            }
        }

        public void putSharedRelrosToBundle(Bundle bundle) {
            if (LibraryLoader.this.useChromiumLinker()) {
                LibraryLoader.this.getLinker().putSharedRelrosToBundle(bundle);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void recordLinkerHistogramsAfterLibraryLoad() {
            if (LibraryLoader.this.useChromiumLinker()) {
                LibraryLoader.this.getLinker().recordHistograms(creationAsString());
            }
        }

        private String creationAsString() {
            int i = this.mCreatedIn;
            return i != 0 ? i != 1 ? i != 2 ? "" : "Child" : "Zygote" : "Browser";
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void recordLoadTimeHistogram(long j) {
            RecordHistogram.recordTimesHistogram(LINKER_HISTOGRAM_PREFIX + creationAsString() + "LoadTime2", j);
        }

        public void recordLoadThreadTimeHistogram(long j) {
            RecordHistogram.recordTimesHistogram(LINKER_HISTOGRAM_PREFIX + creationAsString() + "ThreadLoadTime", j);
        }
    }

    public final MultiProcessMediator getMediator() {
        return this.mMediator;
    }

    private static boolean isInZipFile() {
        return NativeLibraries.sUseLibraryInZipFile;
    }

    public static LibraryLoader getInstance() {
        return sInstance;
    }

    protected LibraryLoader() {
    }

    public void setLibraryProcessType(int i) {
        int i2 = this.mLibraryProcessType;
        if (i == i2) {
            return;
        }
        if (i2 != 0) {
            throw new IllegalStateException(String.format("Trying to change the LibraryProcessType from %d to %d", Integer.valueOf(this.mLibraryProcessType), Integer.valueOf(i)));
        }
        this.mLibraryProcessType = i;
    }

    public void setNativeLibraryPreloader(NativeLibraryPreloader nativeLibraryPreloader) {
        synchronized (this.mLock) {
            this.mLibraryPreloader = nativeLibraryPreloader;
        }
    }

    public void setLinkerImplementation(boolean z, boolean z2) {
        this.mUseChromiumLinker = z;
        this.mUseModernLinker = z2;
        this.mConfigurationSet = true;
    }

    private void setLinkerImplementationIfNeededAlreadyLocked() {
        if (this.mConfigurationSet) {
            return;
        }
        this.mUseChromiumLinker = NativeLibraries.sUseLinker;
        this.mUseModernLinker = NativeLibraries.sUseModernLinker;
        this.mConfigurationSet = true;
    }

    private void logLinkersUsed() {
        Log.m283i(TAG, "Configuration: useChromiumLinker() = %b, mUseModernLinker = %b", Boolean.valueOf(useChromiumLinker()), Boolean.valueOf(this.mUseModernLinker));
    }

    private boolean forceSystemLinker() {
        return this.mUseChromiumLinker && !this.mUseModernLinker && Build.VERSION.SDK_INT >= 29;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean useChromiumLinker() {
        return this.mUseChromiumLinker && !forceSystemLinker();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Linker getLinker() {
        Linker linker;
        synchronized (this.mLock) {
            if (this.mLinker == null) {
                this.mLinker = this.mUseModernLinker ? new ModernLinker() : new LegacyLinker();
                Log.m283i(TAG, this.mUseModernLinker ? "Using ModernLinker" : "Using LegacyLinker", new Object[0]);
            }
            linker = this.mLinker;
        }
        return linker;
    }

    public void enableJniChecks() {
        if (BuildConfig.ENABLE_ASSERTS) {
            NativeLibraryLoadedStatus.setProvider(new NativeLibraryLoadedStatus.NativeLibraryLoadedStatusProvider() { // from class: com.ttnet.org.chromium.base.library_loader.LibraryLoader.1
                @Override // com.ttnet.org.chromium.base.NativeLibraryLoadedStatus.NativeLibraryLoadedStatusProvider
                public boolean areMainDexNativeMethodsReady() {
                    return LibraryLoader.this.mLoadState >= 1;
                }

                @Override // com.ttnet.org.chromium.base.NativeLibraryLoadedStatus.NativeLibraryLoadedStatusProvider
                public boolean areNativeMethodsReady() {
                    return LibraryLoader.this.isInitialized();
                }
            });
        }
    }

    public boolean isLoadedByZygote() {
        boolean z;
        synchronized (this.mLock) {
            z = this.mLoadedByZygote;
        }
        return z;
    }

    public void ensureInitialized() {
        if (isInitialized()) {
            return;
        }
        ensureMainDexInitialized();
        loadNonMainDex();
    }

    public void ensureMainDexInitialized() {
        synchronized (this.mLock) {
            loadMainDexAlreadyLocked(ContextUtils.getApplicationContext().getApplicationInfo(), false);
            initializeAlreadyLocked();
        }
    }

    public void preloadNow() {
        preloadNowOverridePackageName(ContextUtils.getApplicationContext().getApplicationInfo().packageName);
    }

    public void preloadNowOverridePackageName(String str) {
        synchronized (this.mLock) {
            setLinkerImplementationIfNeededAlreadyLocked();
            if (useChromiumLinker()) {
                return;
            }
            preloadAlreadyLocked(str, false);
        }
    }

    private void preloadAlreadyLocked(String str, boolean z) {
        TraceEvent scoped = TraceEvent.scoped("LibraryLoader.preloadAlreadyLocked");
        try {
            NativeLibraryPreloader nativeLibraryPreloader = this.mLibraryPreloader;
            if (nativeLibraryPreloader != null && !this.mLibraryPreloaderCalled) {
                nativeLibraryPreloader.loadLibrary(str);
                this.mLibraryPreloaderCalled = true;
            }
            if (scoped != null) {
                scoped.close();
            }
        } catch (Throwable th) {
            if (scoped != null) {
                try {
                    scoped.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public boolean isLoaded() {
        return this.mLoadState == 2;
    }

    public boolean isInitialized() {
        return this.mInitialized && isLoaded();
    }

    public void loadNow() {
        loadNowOverrideApplicationContext(ContextUtils.getApplicationContext());
    }

    public void loadNowOverrideApplicationContext(Context context) {
        synchronized (this.mLock) {
            if (this.mLoadState != 0 && context != ContextUtils.getApplicationContext()) {
                throw new IllegalStateException("Attempt to load again from alternate context.");
            }
            loadMainDexAlreadyLocked(context.getApplicationInfo(), false);
        }
        loadNonMainDex();
    }

    public void loadNowInZygote(ApplicationInfo applicationInfo) {
        synchronized (this.mLock) {
            loadMainDexAlreadyLocked(applicationInfo, true);
            loadNonMainDex();
            this.mLoadedByZygote = true;
        }
    }

    public void initialize() {
        synchronized (this.mLock) {
            initializeAlreadyLocked();
        }
    }

    public static void setReachedCodeProfilerEnabledOnNextRuns(boolean z, int i) {
        if (z && i == 0) {
            i = 10000;
        } else if (!z) {
            i = 0;
        }
        SharedPreferences.Editor edit = ContextUtils.getAppSharedPreferences().edit();
        edit.remove(DEPRECATED_REACHED_CODE_PROFILER_KEY);
        edit.putInt(REACHED_CODE_SAMPLING_INTERVAL_KEY, i).apply();
    }

    public static int getReachedCodeSamplingIntervalUs() {
        StrictModeContext allowDiskReads = StrictModeContext.allowDiskReads();
        try {
            if (ContextUtils.getAppSharedPreferences().getBoolean(DEPRECATED_REACHED_CODE_PROFILER_KEY, false)) {
                if (allowDiskReads == null) {
                    return 10000;
                }
                allowDiskReads.close();
                return 10000;
            }
            int i = ContextUtils.getAppSharedPreferences().getInt(REACHED_CODE_SAMPLING_INTERVAL_KEY, 0);
            if (allowDiskReads != null) {
                allowDiskReads.close();
            }
            return i;
        } catch (Throwable th) {
            if (allowDiskReads != null) {
                try {
                    allowDiskReads.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public static void setBackgroundThreadPoolEnabledOnNextRuns(boolean z) {
        ContextUtils.getAppSharedPreferences().edit().putBoolean(BACKGROUND_THREAD_POOL_KEY, z).apply();
    }

    public static boolean isBackgroundThreadPoolEnabled() {
        StrictModeContext allowDiskReads = StrictModeContext.allowDiskReads();
        try {
            boolean z = ContextUtils.getAppSharedPreferences().getBoolean(BACKGROUND_THREAD_POOL_KEY, false);
            if (allowDiskReads != null) {
                allowDiskReads.close();
            }
            return z;
        } catch (Throwable th) {
            if (allowDiskReads != null) {
                try {
                    allowDiskReads.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    private void loadWithChromiumLinker(ApplicationInfo applicationInfo, String str) {
        Linker linker = getLinker();
        if (isInZipFile()) {
            String str2 = applicationInfo.sourceDir;
            linker.setApkFilePath(str2);
            Log.m283i(TAG, "Loading %s from within %s", str, str2);
        } else {
            Log.m283i(TAG, "Loading %s", str);
        }
        linker.loadLibrary(str);
        getMediator().recordLinkerHistogramsAfterLibraryLoad();
    }

    private void loadWithSystemLinkerAlreadyLocked(ApplicationInfo applicationInfo, boolean z) {
        setEnvForNative();
        preloadAlreadyLocked(applicationInfo.packageName, z);
        for (String str : NativeLibraries.LIBRARIES) {
            boolean z2 = !forceSystemLinker() && Build.VERSION.SDK_INT >= 29;
            if (!isInZipFile() || z2) {
                System.loadLibrary(str);
            } else {
                boolean isProcess64Bit = ApiHelperForM.isProcess64Bit();
                String str2 = applicationInfo.sourceDir;
                boolean forceSystemLinker = forceSystemLinker();
                String str3 = str2 + "!/" + makeLibraryPathInZipFile(str, forceSystemLinker, isProcess64Bit);
                Log.m283i(TAG, "libraryName: %s", str3);
                if (forceSystemLinker) {
                    Log.m285w(TAG, "Forcing system linker, relocations will not be shared. This negatively impacts memory usage.", new Object[0]);
                }
                System.load(str3);
            }
        }
    }

    protected void loadMainDexAlreadyLocked(ApplicationInfo applicationInfo, boolean z) {
        if (this.mLoadState >= 1) {
            return;
        }
        try {
            TraceEvent scoped = TraceEvent.scoped("LibraryLoader.loadMainDexAlreadyLocked");
            try {
                setLinkerImplementationIfNeededAlreadyLocked();
                TimeUtils.UptimeMillisTimer uptimeMillisTimer = new TimeUtils.UptimeMillisTimer();
                TimeUtils.CurrentThreadTimeMillisTimer currentThreadTimeMillisTimer = new TimeUtils.CurrentThreadTimeMillisTimer();
                if (useChromiumLinker() && !this.mFallbackToSystemLinker) {
                    loadWithChromiumLinker(applicationInfo, NativeLibraries.LIBRARIES[0]);
                } else {
                    loadWithSystemLinkerAlreadyLocked(applicationInfo, z);
                }
                getMediator().recordLoadTimeHistogram(uptimeMillisTimer.getElapsedMillis());
                getMediator().recordLoadThreadTimeHistogram(currentThreadTimeMillisTimer.getElapsedMillis());
                this.mLoadState = 1;
                if (scoped != null) {
                    scoped.close();
                }
            } finally {
            }
        } catch (UnsatisfiedLinkError e) {
            throw new ProcessInitException(2, e);
        }
    }

    protected void loadNonMainDex() {
        if (this.mLoadState == 2) {
            return;
        }
        synchronized (this.mNonMainDexLock) {
            if (this.mLoadState == 2) {
                return;
            }
            TraceEvent scoped = TraceEvent.scoped("LibraryLoader.loadNonMainDex");
            try {
                if (!JNIUtils.isSelectiveJniRegistrationEnabled()) {
                    LibraryLoaderJni.get().registerNonMainDexJni();
                }
                this.mLoadState = 2;
                if (scoped != null) {
                    scoped.close();
                }
            } finally {
            }
        }
    }

    public static String makeLibraryPathInZipFile(String str, boolean z, boolean z2) {
        String str2;
        int i = NativeLibraries.sCpuFamily;
        if (i == 1) {
            str2 = z2 ? "arm64-v8a" : "armeabi-v7a";
        } else if (i == 2) {
            str2 = z2 ? "mips64" : "mips";
        } else {
            if (i != 3) {
                throw new RuntimeException("Unknown CPU ABI for native libraries");
            }
            str2 = z2 ? "x86_64" : "x86";
        }
        return String.format(Locale.US, "lib/%s/%s%s", str2, z ? "crazy." : "", System.mapLibraryName(str));
    }

    public void switchCommandLineForWebView() {
        synchronized (this.mLock) {
            ensureCommandLineSwitchedAlreadyLocked();
        }
    }

    private void ensureCommandLineSwitchedAlreadyLocked() {
        if (this.mCommandLineSwitched) {
            return;
        }
        CommandLine.enableNativeProxy();
        this.mCommandLineSwitched = true;
    }

    private void initializeAlreadyLocked() {
        if (this.mInitialized) {
            return;
        }
        if (this.mLibraryProcessType == 1) {
            int reachedCodeSamplingIntervalUs = getReachedCodeSamplingIntervalUs();
            if (reachedCodeSamplingIntervalUs > 0) {
                CommandLine.getInstance().appendSwitch(BaseSwitches.ENABLE_REACHED_CODE_PROFILER);
                CommandLine.getInstance().appendSwitchWithValue(BaseSwitches.REACHED_CODE_SAMPLING_INTERVAL_US, Integer.toString(reachedCodeSamplingIntervalUs));
            }
            if (isBackgroundThreadPoolEnabled()) {
                CommandLine.getInstance().appendSwitch(BaseSwitches.ENABLE_BACKGROUND_THREAD_POOL);
            }
        }
        ensureCommandLineSwitchedAlreadyLocked();
        if (!LibraryLoaderJni.get().libraryLoaded(this.mLibraryProcessType)) {
            Log.m282e(TAG, "error calling LibraryLoaderJni.get().libraryLoaded", new Object[0]);
            throw new ProcessInitException(1);
        }
        Log.m283i(TAG, "Successfully loaded native library", new Object[0]);
        UmaRecorderHolder.onLibraryLoaded();
        TraceEvent.onNativeTracingReady();
        this.mInitialized = true;
    }

    public static void setLibraryLoaderForTesting(LibraryLoader libraryLoader) {
        sInstance = libraryLoader;
    }

    public static void setEnvForNative() {
        if (BuildConfig.IS_UBSAN) {
            try {
                Os.setenv("UBSAN_OPTIONS", "print_stacktrace=1 stack_trace_format='#%n pc %o %m' handle_segv=0 handle_sigbus=0 handle_sigfpe=0", true);
            } catch (Exception e) {
                Log.m285w(TAG, "failed to set UBSAN_OPTIONS", e);
            }
        }
    }

    public void setLibrariesLoadedForNativeTests() {
        this.mLoadState = 2;
        this.mInitialized = true;
    }

    public static void setBrowserProcessStartupBlockedForTesting() {
        sBrowserStartupBlockedForTesting = true;
    }

    public static boolean isBrowserProcessStartupBlockedForTesting() {
        return sBrowserStartupBlockedForTesting;
    }
}
