package com.bytedance.apm.launch;

import android.os.SystemClock;
import com.bytedance.apm.util.CommonMonitorUtil;
import com.bytedance.monitor.util.IoUtil;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/* loaded from: classes3.dex */
public class ProcessStartupTime {
    public static long getProcessStartupTimeInJiffies(int i) {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/" + i + "/stat"));
        } catch (IOException | NumberFormatException unused) {
        } catch (Throwable th) {
            th = th;
        }
        try {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                IoUtil.safeClose(bufferedReader);
                return -1L;
            }
            long elapsedRealtime = ((SystemClock.elapsedRealtime() * CommonMonitorUtil.getScClkTck(100L)) / 1000) - Long.parseLong(readLine.split(" ")[21]);
            IoUtil.safeClose(bufferedReader);
            return elapsedRealtime;
        } catch (IOException | NumberFormatException unused2) {
            bufferedReader2 = bufferedReader;
            IoUtil.safeClose(bufferedReader2);
            return -1L;
        } catch (Throwable th2) {
            th = th2;
            bufferedReader2 = bufferedReader;
            IoUtil.safeClose(bufferedReader2);
            throw th;
        }
    }
}
