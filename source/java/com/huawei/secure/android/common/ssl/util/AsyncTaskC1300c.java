package com.huawei.secure.android.common.ssl.util;

import android.content.Context;
import android.os.AsyncTask;
import java.io.InputStream;

/* renamed from: com.huawei.secure.android.common.ssl.util.c */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class AsyncTaskC1300c extends AsyncTask<Context, Integer, Boolean> {

    /* renamed from: a */
    private static final String f2202a = "c";

    /* renamed from: b */
    private static final long f2203b = 432000000;

    /* renamed from: c */
    private static final String f2204c = "lastCheckTime";

    /* renamed from: d */
    private static volatile boolean f2205d;

    /* renamed from: a */
    public static void m2387a() {
        if (m2388b()) {
            C1302e.m2408c(f2202a, "checkUpgradeBks, execute check task");
            new AsyncTaskC1300c().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, ContextUtil.getInstance());
        }
    }

    /* renamed from: b */
    private static boolean m2388b() {
        if (f2205d) {
            return false;
        }
        Context contextUtil = ContextUtil.getInstance();
        if (contextUtil == null) {
            C1302e.m2410e(f2202a, "checkUpgradeBks, context is null");
            return false;
        }
        f2205d = true;
        long m2414a = C1304g.m2414a(f2204c, 0L, contextUtil);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - m2414a > f2203b) {
            C1304g.m2420b(f2204c, currentTimeMillis, contextUtil);
            return true;
        }
        C1302e.m2408c(f2202a, "checkUpgradeBks, ignore");
        return false;
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        C1302e.m2405a(f2202a, "onPreExecute");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Boolean doInBackground(Context... contextArr) {
        InputStream inputStream;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            inputStream = BksUtil.getBksFromTss(contextArr[0]);
        } catch (Exception e) {
            C1302e.m2407b(f2202a, "doInBackground: exception : " + e.getMessage());
            inputStream = null;
        }
        C1302e.m2405a(f2202a, "doInBackground: get bks from hms tss cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
        if (inputStream != null) {
            AbstractC1301d.m2398a(inputStream);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Boolean bool) {
        if (bool.booleanValue()) {
            C1302e.m2408c(f2202a, "onPostExecute: upate done");
        } else {
            C1302e.m2407b(f2202a, "onPostExecute: upate failed");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onProgressUpdate(Integer... numArr) {
        C1302e.m2408c(f2202a, "onProgressUpdate");
    }
}
