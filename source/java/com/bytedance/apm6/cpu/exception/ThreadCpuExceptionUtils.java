package com.bytedance.apm6.cpu.exception;

import android.text.TextUtils;
import com.bytedance.apm6.cpu.Constants;
import com.bytedance.apm6.perf.base.model.ThreadStatInfo;
import com.bytedance.apm6.util.log.Logger;
import com.bytedance.apm6.util.proc.CommonProcUtil;
import com.bytedance.common.utility.io.IOUtils;
import com.bytedance.monitor.collector.PerfMonitorManager;
import com.bytedance.monitor.util.IoUtil;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class ThreadCpuExceptionUtils {
    public static void getThreadInfo(int i, Map<Integer, ThreadExceptionItem> map) {
        for (File file : new File("/proc/" + i + "/task/").listFiles()) {
            try {
                int parseInt = Integer.parseInt(file.getName());
                ThreadStatInfo dumpThreadStatInfo = PerfMonitorManager.getInstance().dumpThreadStatInfo(i, parseInt);
                if (parseInt != 0 && dumpThreadStatInfo != null && !TextUtils.isEmpty(dumpThreadStatInfo.threadName) && dumpThreadStatInfo.threadCpuTime != 0) {
                    ThreadExceptionItem threadExceptionItem = new ThreadExceptionItem();
                    threadExceptionItem.setThreadId(parseInt);
                    threadExceptionItem.setThreadName(dumpThreadStatInfo.threadName);
                    threadExceptionItem.setThreadCpuTime(dumpThreadStatInfo.threadCpuTime);
                    map.put(Integer.valueOf(parseInt), threadExceptionItem);
                }
            } catch (NumberFormatException unused) {
            }
        }
    }

    public static void getThreadInfo(int i, List<ThreadExceptionItem> list) {
        File[] listFiles = new File("/proc/" + i + "/task/").listFiles();
        long appCPUTime = CommonProcUtil.getAppCPUTime();
        BufferedReader bufferedReader = null;
        for (File file : listFiles) {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream(file.getPath() + "/stat")), 1000);
                try {
                    String readLine = bufferedReader2.readLine();
                    int lastIndexOf = readLine.lastIndexOf(41);
                    String substring = readLine.substring(0, lastIndexOf);
                    String substring2 = readLine.substring(lastIndexOf + 4);
                    int indexOf = substring.indexOf(40);
                    int intValue = Integer.valueOf(substring.substring(0, indexOf - 1)).intValue();
                    String substring3 = substring.substring(indexOf + 1);
                    String[] split = substring2.split(" ");
                    long parseLong = Long.parseLong(split[10]) + Long.parseLong(split[11]);
                    if (intValue != 0 && !substring3.isEmpty() && parseLong != 0 && !Thread.currentThread().getName().contains(substring3)) {
                        ThreadExceptionItem threadExceptionItem = new ThreadExceptionItem();
                        threadExceptionItem.setThreadName(substring3);
                        threadExceptionItem.setThreadId(intValue);
                        threadExceptionItem.setThreadCpuTime(parseLong);
                        threadExceptionItem.setProcessCpuTime(appCPUTime);
                        threadExceptionItem.setPriority(Integer.parseInt(split[14]));
                        list.add(threadExceptionItem);
                    }
                    IoUtil.safeClose(bufferedReader2);
                    bufferedReader = bufferedReader2;
                } catch (Throwable unused) {
                    bufferedReader = bufferedReader2;
                    IoUtil.safeClose(bufferedReader);
                }
            } catch (Throwable unused2) {
            }
        }
    }

    public static void filterThreads(int i, List<ThreadExceptionItem> list, List<ThreadExceptionItem> list2, double d, Map<String, Double> map) {
        String str;
        Iterator<ThreadExceptionItem> it;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        String[] split;
        long parseLong;
        String str2 = "/proc/" + i + "/task/";
        Logger.m122i(Constants.TAG, "size: " + list.size());
        long appCPUTime = CommonProcUtil.getAppCPUTime();
        BufferedReader bufferedReader3 = null;
        for (Iterator<ThreadExceptionItem> it2 = list.iterator(); it2.hasNext(); it2 = it) {
            ThreadExceptionItem next = it2.next();
            if (next == null) {
                IOUtils.close(bufferedReader3);
                str = str2;
                it = it2;
            } else {
                try {
                    str = str2;
                } catch (Throwable unused) {
                    str = str2;
                }
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(str2 + next.getThreadId() + "/stat")), 1000);
                    try {
                        String readLine = bufferedReader.readLine();
                        split = readLine.substring(readLine.lastIndexOf(41) + 4).split(" ");
                        parseLong = Long.parseLong(split[10]) + Long.parseLong(split[11]);
                        it = it2;
                    } catch (Throwable th) {
                        th = th;
                        it = it2;
                    }
                } catch (Throwable unused2) {
                    it = it2;
                    try {
                        list2.add(next);
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            Logger.m122i(Constants.TAG, "error: " + th.getLocalizedMessage());
                            str2 = str;
                        } finally {
                            IOUtils.close(bufferedReader3);
                        }
                    }
                    str2 = str;
                }
                try {
                    bufferedReader2 = bufferedReader;
                    float threadCpuTime = ((float) (parseLong - next.getThreadCpuTime())) / ((float) (appCPUTime - next.getProcessCpuTime()));
                    try {
                        Logger.m122i(Constants.TAG, next.getThreadName() + " judge: " + parseLong + " " + next.getThreadCpuTime() + " " + threadCpuTime + " " + d);
                        if (map == null || !map.containsKey(next.getThreadName())) {
                            double d2 = threadCpuTime;
                            if (d2 >= d) {
                                next.setCpuUsage(d2);
                                next.setPriority(Integer.parseInt(split[18]));
                            } else {
                                list2.add(next);
                            }
                        } else {
                            double d3 = threadCpuTime;
                            if (d3 >= map.get(next.getThreadName()).doubleValue()) {
                                next.setCpuUsage(d3);
                                next.setPriority(Integer.parseInt(split[18]));
                            } else {
                                list2.add(next);
                            }
                        }
                        Logger.m122i(Constants.TAG, "after item: " + next);
                        IOUtils.close(bufferedReader2);
                        bufferedReader3 = bufferedReader2;
                    } catch (Throwable th3) {
                        th = th3;
                        bufferedReader3 = bufferedReader2;
                        Logger.m122i(Constants.TAG, "error: " + th.getLocalizedMessage());
                        str2 = str;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    bufferedReader2 = bufferedReader;
                    bufferedReader3 = bufferedReader2;
                    Logger.m122i(Constants.TAG, "error: " + th.getLocalizedMessage());
                    str2 = str;
                }
            }
            str2 = str;
        }
        list.removeAll(list2);
        Logger.m122i(Constants.TAG, "after size: " + list.size());
    }

    public static void filterThreads(int i, List<ThreadExceptionItem> list, double d, Map<String, Double> map) {
        filterThreads(i, list, new LinkedList(), d, map);
    }
}
