package com.ss.android.common.app;

import android.app.Activity;
import com.bytedance.common.utility.collection.WeakContainer;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes7.dex */
public class ActivityStackManager {
    private static volatile int sActivityId;
    private static Set<String> sActivitySet = new HashSet();
    private static WeakContainer<StackRecorder> sFinishedActivityContainer = new WeakContainer<>();

    /* loaded from: classes7.dex */
    public interface StackRecorder {
        String getRecorderKey();

        boolean isFinishing();
    }

    public static String buildKey(Activity activity) {
        StringBuilder append = new StringBuilder().append(activity.getClass().getCanonicalName()).append("@");
        int i = sActivityId;
        sActivityId = i + 1;
        return append.append(i).toString();
    }

    public static void addRecorder(StackRecorder stackRecorder) {
        if (stackRecorder != null) {
            try {
                sFinishedActivityContainer.add(stackRecorder);
                sActivitySet.add(stackRecorder.getRecorderKey());
            } catch (Throwable unused) {
            }
        }
    }

    public static void removeRecorder(StackRecorder stackRecorder) {
        if (stackRecorder != null) {
            try {
                sActivitySet.remove(stackRecorder.getRecorderKey());
            } catch (Throwable unused) {
            }
        }
    }

    public static String getAliveActivitiesString() {
        Set<String> set = sActivitySet;
        if (set != null && !set.isEmpty()) {
            try {
                StringBuilder sb = new StringBuilder();
                int i = 0;
                for (String str : sActivitySet) {
                    if (i < sActivitySet.size() - 1) {
                        sb.append(str).append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
                    } else {
                        sb.append(str);
                    }
                    i++;
                }
                return sb.toString();
            } catch (Throwable unused) {
            }
        }
        return "";
    }

    public static String getFinishedActivitiesString() {
        WeakContainer<StackRecorder> weakContainer = sFinishedActivityContainer;
        if (weakContainer != null && !weakContainer.isEmpty()) {
            try {
                StringBuilder sb = new StringBuilder();
                Iterator<StackRecorder> it = sFinishedActivityContainer.iterator();
                int i = 0;
                while (it.hasNext()) {
                    StackRecorder next = it.next();
                    if (next != null && !sActivitySet.contains(next.getRecorderKey()) && next.isFinishing()) {
                        if (i < sFinishedActivityContainer.size() - 1) {
                            sb.append(next.getRecorderKey()).append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
                        } else {
                            sb.append(next.getRecorderKey());
                        }
                    }
                    i++;
                }
                return sb.toString();
            } catch (Throwable unused) {
            }
        }
        return "";
    }
}
