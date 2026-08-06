package com.bytedance.crash.dumper;

import android.os.Build;
import android.text.TextUtils;
import androidx.collection.SieveCacheKt;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.bytedance.crash.util.DoubleReflectHelper;
import com.bytedance.crash.util.FileSystemUtils;
import com.bytedance.crash.util.FileUtils;
import com.ss.android.update.UpdateDialogNewBase;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class ProcessState {
    private static final int LENGTH = 10;
    private static ProcessState sProcessState = new ProcessState();
    private Class activityThreadClass;
    private Entry[] state = new Entry[10];
    private Entry[] result = new Entry[10];
    private int index = 0;
    private Object activityThread = null;
    private Object applicationThread = null;
    private Field processStateField = null;
    private volatile boolean isInited = false;
    private Runnable runnable = new Runnable() { // from class: com.bytedance.crash.dumper.ProcessState.1
        @Override // java.lang.Runnable
        public void run() {
            ProcessState.this.collect();
        }
    };

    public static ProcessState getInstance() {
        return sProcessState;
    }

    public void start() {
        for (int i = 0; i < 10; i++) {
            this.state[i] = new Entry();
        }
        DefaultWorkThread.postDelayed(this.runnable, 3000L);
        this.isInited = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void collect() {
        this.state[this.index].reset();
        this.state[this.index].time = System.currentTimeMillis();
        this.state[this.index].state = getState();
        this.index = (this.index + 1) % 10;
        DefaultWorkThread.postDelayed(this.runnable, 3000L);
    }

    private synchronized void copy() {
        synchronized (this.state) {
            for (int i = 0; i < 10; i++) {
                this.result[i] = this.state[i];
            }
        }
    }

    private int getState() {
        try {
            if (this.activityThread == null) {
                Class<?> cls = Class.forName("android.app.ActivityThread");
                this.activityThreadClass = cls;
                Method methodInner = DoubleReflectHelper.getMethodInner(cls, "currentActivityThread", null);
                methodInner.setAccessible(true);
                this.activityThread = methodInner.invoke(this.activityThreadClass, new Object[0]);
            }
            if (Build.VERSION.SDK_INT >= 29) {
                if (this.processStateField == null) {
                    this.processStateField = DoubleReflectHelper.getField(this.activityThreadClass, "mLastProcessState");
                }
                this.processStateField.setAccessible(true);
                return ((Integer) this.processStateField.get(this.activityThread)).intValue();
            }
            if (this.applicationThread == null) {
                Method methodInner2 = DoubleReflectHelper.getMethodInner(this.activityThreadClass, "getApplicationThread", null);
                methodInner2.setAccessible(true);
                Object invoke = methodInner2.invoke(this.activityThread, new Object[0]);
                this.applicationThread = invoke;
                this.processStateField = DoubleReflectHelper.getField(invoke.getClass(), "mLastProcessState");
            }
            Field field = this.processStateField;
            if (field == null) {
                return -1;
            }
            field.setAccessible(true);
            return ((Integer) this.processStateField.get(this.applicationThread)).intValue();
        } catch (Throwable unused) {
            return -1;
        }
    }

    public void dump(File file) {
        if (!this.isInited) {
            return;
        }
        try {
            DefaultWorkThread.removeCallbacks(this.runnable);
            collect();
            copy();
            StringBuilder sb = new StringBuilder();
            Arrays.sort(this.result, new Comparator<Entry>() { // from class: com.bytedance.crash.dumper.ProcessState.2
                @Override // java.util.Comparator
                public int compare(Entry entry, Entry entry2) {
                    if (entry.time > entry2.time) {
                        return -1;
                    }
                    return entry.time == entry2.time ? 0 : 1;
                }
            });
            int i = 0;
            while (true) {
                Entry[] entryArr = this.result;
                if (i < entryArr.length) {
                    sb.append(entryArr[i].time);
                    sb.append(",");
                    sb.append(this.result[i].state);
                    sb.append(UpdateDialogNewBase.TYPE);
                    i++;
                } else {
                    FileUtils.writeFile(new File(file, "process_state.txt"), sb.toString(), false);
                    return;
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x00be, code lost:
    
        if (r0 > 7) goto L44;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00ab A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ac A[Catch: all -> 0x00e5, TryCatch #2 {all -> 0x00e5, blocks: (B:3:0x0006, B:7:0x001d, B:28:0x00a1, B:29:0x00a5, B:32:0x00ac, B:37:0x00d2, B:40:0x00c4, B:55:0x008d, B:64:0x009b, B:65:0x009e), top: B:2:0x0006 }] */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void pushFilters(File file, JSONObject jSONObject, JSONObject jSONObject2) {
        boolean z;
        String str;
        boolean z2;
        String[] split;
        try {
            long optLong = jSONObject.optLong("crash_time");
            File file2 = new File(file, "process_state.txt");
            if (file2.exists()) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                StringBuilder sb = new StringBuilder();
                BufferedReader bufferedReader = null;
                String str2 = null;
                BufferedReader bufferedReader2 = null;
                ?? r9 = 0;
                try {
                    BufferedReader bufferedReader3 = new BufferedReader(new FileReader(file2));
                    long j = SieveCacheKt.NodeLinkMask;
                    while (true) {
                        try {
                            try {
                                String readLine = bufferedReader3.readLine();
                                if (readLine != null) {
                                    try {
                                        split = readLine.split(",");
                                    } catch (Exception unused) {
                                        str = str2;
                                        z = r9;
                                        bufferedReader2 = bufferedReader3;
                                        FileSystemUtils.close(bufferedReader2);
                                        str2 = str;
                                        if (TextUtils.isEmpty(str2)) {
                                        }
                                    }
                                    try {
                                        long parseLong = Long.parseLong(split[r9]);
                                        long j2 = parseLong - optLong;
                                        if (j2 > 0 && j2 < j) {
                                            str2 = readLine;
                                            j = j2;
                                        }
                                        sb.append(simpleDateFormat.format(new Date(parseLong)));
                                        sb.append(Constants.COLON_SEPARATOR);
                                        sb.append(split[1]);
                                        sb.append(UpdateDialogNewBase.TYPE);
                                        r9 = 0;
                                    } catch (Exception unused2) {
                                        str = str2;
                                        bufferedReader2 = bufferedReader3;
                                        z = false;
                                        FileSystemUtils.close(bufferedReader2);
                                        str2 = str;
                                        if (TextUtils.isEmpty(str2)) {
                                        }
                                    }
                                } else {
                                    try {
                                        break;
                                    } catch (Exception unused3) {
                                        z = false;
                                    }
                                }
                            } catch (Throwable th) {
                                th = th;
                                bufferedReader = bufferedReader3;
                                FileSystemUtils.close(bufferedReader);
                                throw th;
                            }
                        } catch (Exception unused4) {
                            z = r9;
                        }
                    }
                    z = false;
                    try {
                        FileUtils.writeFile(new File(file, "process_state_format.txt"), sb.toString(), false);
                        FileSystemUtils.close(bufferedReader3);
                    } catch (Exception unused5) {
                        str = str2;
                        bufferedReader2 = bufferedReader3;
                        FileSystemUtils.close(bufferedReader2);
                        str2 = str;
                        if (TextUtils.isEmpty(str2)) {
                        }
                    }
                } catch (Exception unused6) {
                    z = false;
                    str = null;
                } catch (Throwable th2) {
                    th = th2;
                }
                if (TextUtils.isEmpty(str2)) {
                    int parseInt = Integer.parseInt(str2.split(",")[1]);
                    if (Build.VERSION.SDK_INT != 29) {
                        if (Build.VERSION.SDK_INT == 28) {
                            if (parseInt > 5) {
                                z2 = true;
                            }
                            z2 = z;
                        } else {
                            if (parseInt > 6) {
                                z2 = true;
                            }
                            z2 = z;
                        }
                    }
                    jSONObject2.put("is_background_v2", String.valueOf(z2));
                    jSONObject2.put("process_state", String.valueOf(parseInt));
                }
            }
        } catch (Throwable unused7) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class Entry {
        public int state;
        public long time;

        Entry() {
        }

        public void reset() {
            this.time = 0L;
            this.state = 0;
        }
    }
}
