package com.bytedance.security.android.aopcheck.reporter;

import com.bytedance.security.android.aopcheck.utils.LogPrint;
import com.bytedance.security.android.aopcheck.utils.ThreadPool;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class InfoMon {
    public static void doPathTraversalReport(String str, String str2, String str3) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("child", str);
            jSONObject.put("parent", str2);
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            StringBuffer stringBuffer = new StringBuffer();
            int i = 0;
            for (StackTraceElement stackTraceElement : stackTrace) {
                if (i < 3) {
                    i++;
                } else {
                    if (stringBuffer.length() > 0) {
                        stringBuffer.append(System.getProperty("line.separator"));
                    }
                    stringBuffer.append(stackTraceElement.toString());
                }
            }
            final AOPReportEvent aOPReportEvent = new AOPReportEvent(str3, System.currentTimeMillis(), jSONObject.toString(), stringBuffer.toString());
            ThreadPool.getDefaultThreadPool().execute(new Runnable() { // from class: com.bytedance.security.android.aopcheck.reporter.InfoMon.1
                @Override // java.lang.Runnable
                public void run() {
                    ReportManager.INSTANCE.report(ReportConstant.AOP_REPORT_PATH_TRAVERSAL, AOPReportEvent.this);
                }
            });
            LogPrint.m177d("AOPReportEvent: " + aOPReportEvent);
        } catch (JSONException e) {
            LogPrint.printStackTrace(e);
        }
    }
}
