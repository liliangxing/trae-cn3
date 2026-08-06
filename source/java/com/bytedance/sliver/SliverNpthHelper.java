package com.bytedance.sliver;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import com.bytedance.crash.CrashInfoCallback;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.Npth;
import com.bytedance.sliver.Sliver;
import com.bytedance.tobshadow.applog.log.LogUtils;
import java.io.File;
import java.io.FilenameFilter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.Locale;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class SliverNpthHelper extends CrashInfoCallback {
    private static final String DIR = "sliver-npth";
    private static final int MAX_BUFFER_SIZE = 50000;
    private static final int MAX_SAVE_SLIVER = 10;
    private static final String SUFFIX_SLIVER = ".zip";
    private static final String SUFFIX_TMP = ".tmp";
    private static final String SUFFIX_TXT = ".txt";
    private Context context = null;
    private static final SliverNpthHelper sInstance = new SliverNpthHelper();
    private static final SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss", Locale.CHINESE);
    private static boolean isInit = false;

    public static void init(Context context) {
        Config config = new Config();
        config.setAllThreadEnable(false);
        config.setAnrEnable(true);
        config.setNativeEnable(true);
        config.setJavaEnable(true);
        config.setLaunchEnable(true);
        config.setSamplingMs(getSuggestSamplingMs());
        config.setBufferSize(MAX_BUFFER_SIZE);
        init(context, config);
    }

    public static synchronized void init(Context context, Config config) {
        synchronized (SliverNpthHelper.class) {
            if (isInit) {
                return;
            }
            if (context != null && context.getApplicationContext() != null) {
                boolean z = true;
                isInit = true;
                if (config.debug) {
                    z = false;
                }
                if (Sliver.init(z)) {
                    if (config.allThreadEnable) {
                        Sliver.startAll(5, config.samplingMs);
                    } else {
                        Sliver.start(Looper.getMainLooper().getThread(), config.samplingMs, config.bufferSize, Sliver.Mode.RING);
                    }
                    SliverNpthHelper sliverNpthHelper = sInstance;
                    sliverNpthHelper.setContext(context.getApplicationContext());
                    sliverNpthHelper.deleteLocalFiles();
                    if (config.launchEnable) {
                        Npth.registerCrashInfoCallback(sliverNpthHelper, CrashType.LAUNCH);
                    }
                    if (config.javaEnable) {
                        Npth.registerCrashInfoCallback(sliverNpthHelper, CrashType.JAVA);
                    }
                    if (config.nativeEnable) {
                        Npth.registerCrashInfoCallback(sliverNpthHelper, CrashType.NATIVE);
                    }
                    if (config.anrEnable) {
                        Npth.registerCrashInfoCallback(sliverNpthHelper, CrashType.ANR);
                    }
                }
            }
        }
    }

    private void deleteLocalFiles() {
        File externalFilesDir;
        Context context = this.context;
        if (context == null || (externalFilesDir = context.getExternalFilesDir(DIR)) == null) {
            return;
        }
        if (externalFilesDir.exists() || externalFilesDir.mkdirs()) {
            File[] listFiles = externalFilesDir.listFiles(new FilenameFilter() { // from class: com.bytedance.sliver.SliverNpthHelper.1
                @Override // java.io.FilenameFilter
                public boolean accept(File file, String str) {
                    return !str.endsWith(SliverNpthHelper.SUFFIX_SLIVER);
                }
            });
            if (listFiles != null && listFiles.length > 0) {
                for (File file : listFiles) {
                    file.delete();
                }
            }
            File[] listFiles2 = externalFilesDir.listFiles(new FilenameFilter() { // from class: com.bytedance.sliver.SliverNpthHelper.2
                @Override // java.io.FilenameFilter
                public boolean accept(File file2, String str) {
                    return str.endsWith(SliverNpthHelper.SUFFIX_SLIVER);
                }
            });
            if (listFiles2 == null || listFiles2.length <= 10) {
                return;
            }
            Arrays.sort(listFiles2, new Comparator<File>() { // from class: com.bytedance.sliver.SliverNpthHelper.3
                @Override // java.util.Comparator
                public int compare(File file2, File file3) {
                    long lastModified = file2.lastModified();
                    long lastModified2 = file3.lastModified();
                    if (lastModified < lastModified2) {
                        return -1;
                    }
                    return lastModified == lastModified2 ? 0 : 1;
                }
            });
            for (int i = 0; i < listFiles2.length - 10; i++) {
                listFiles2[i].delete();
            }
        }
    }

    public static int getSuggestSamplingMs() {
        return Build.VERSION.SDK_INT <= 27 ? 20 : 15;
    }

    /* renamed from: com.bytedance.sliver.SliverNpthHelper$4 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    static /* synthetic */ class C02004 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$crash$CrashType;

        static {
            int[] iArr = new int[CrashType.values().length];
            $SwitchMap$com$bytedance$crash$CrashType = iArr;
            try {
                iArr[CrashType.LAUNCH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$bytedance$crash$CrashType[CrashType.JAVA.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$bytedance$crash$CrashType[CrashType.NATIVE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$bytedance$crash$CrashType[CrashType.ANR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public File[] crashFileList(CrashType crashType) {
        try {
            String str = "";
            int i = C02004.$SwitchMap$com$bytedance$crash$CrashType[crashType.ordinal()];
            if (i == 1) {
                str = LogUtils.EVENT_TYPE_LAUNCH;
            } else if (i == 2) {
                str = "JAVA";
            } else if (i == 3) {
                str = "NATIVE";
            } else if (i == 4) {
                str = "ANR";
            }
            Context context = this.context;
            if (context == null) {
                return super.crashFileList(crashType);
            }
            File externalFilesDir = context.getExternalFilesDir(DIR);
            if (externalFilesDir != null && (externalFilesDir.exists() || externalFilesDir.mkdirs())) {
                String str2 = "trace-" + str + "-" + FORMAT.format(new Date());
                File file = new File(externalFilesDir, str2 + SUFFIX_TMP);
                Sliver.dumpAll(file.getAbsolutePath(), true);
                Sliver.dump(Looper.getMainLooper().getThread(), file.getAbsolutePath(), true);
                if (!file.exists()) {
                    return super.crashFileList(crashType);
                }
                File file2 = new File(externalFilesDir, str2 + SUFFIX_TXT);
                if (file.renameTo(file2)) {
                    file = file2;
                }
                File file3 = new File(externalFilesDir, str2 + SUFFIX_SLIVER);
                try {
                    SliverFileUtils.compress(file3.getAbsolutePath(), file.getAbsolutePath());
                } catch (Throwable unused) {
                }
                return file3.exists() ? new File[]{file3} : new File[]{file};
            }
            return super.crashFileList(crashType);
        } catch (Throwable unused2) {
            return super.crashFileList(crashType);
        }
    }

    private void setContext(Context context) {
        this.context = context;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static class Config {
        private boolean debug = false;
        private int samplingMs = SliverNpthHelper.getSuggestSamplingMs();
        private int bufferSize = SliverNpthHelper.MAX_BUFFER_SIZE;
        private boolean launchEnable = true;
        private boolean javaEnable = true;
        private boolean nativeEnable = true;
        private boolean anrEnable = true;
        private boolean allThreadEnable = false;

        public void setSamplingMs(int i) {
            this.samplingMs = i;
        }

        public void setLaunchEnable(boolean z) {
            this.launchEnable = z;
        }

        public void setJavaEnable(boolean z) {
            this.javaEnable = z;
        }

        public void setNativeEnable(boolean z) {
            this.nativeEnable = z;
        }

        public void setAnrEnable(boolean z) {
            this.anrEnable = z;
        }

        public void setBufferSize(int i) {
            if (this.bufferSize > SliverNpthHelper.MAX_BUFFER_SIZE) {
                this.bufferSize = SliverNpthHelper.MAX_BUFFER_SIZE;
            } else {
                this.bufferSize = i;
            }
        }

        public void setDebug(boolean z) {
            this.debug = z;
        }

        public void setAllThreadEnable(boolean z) {
            this.allThreadEnable = z;
        }
    }
}
