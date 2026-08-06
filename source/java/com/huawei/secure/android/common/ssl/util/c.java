package com.huawei.secure.android.common.ssl.util;

import android.content.Context;
import android.os.AsyncTask;
import java.io.InputStream;

/* loaded from: classes6.dex */
public class c extends AsyncTask<Context, Integer, Boolean> {
    private static final String a = "c";
    private static final long b = 432000000;
    private static final String c = "lastCheckTime";
    private static volatile boolean d;

    public static void a() {
        if (b()) {
            e.c(a, "checkUpgradeBks, execute check task");
            new c().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, ContextUtil.getInstance());
        }
    }

    private static boolean b() {
        if (d) {
            return false;
        }
        Context contextUtil = ContextUtil.getInstance();
        if (contextUtil == null) {
            e.e(a, "checkUpgradeBks, context is null");
            return false;
        }
        d = true;
        long a2 = g.a(c, 0L, contextUtil);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - a2 > b) {
            g.b(c, currentTimeMillis, contextUtil);
            return true;
        }
        e.c(a, "checkUpgradeBks, ignore");
        return false;
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        e.a(a, "onPreExecute");
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
            e.b(a, "doInBackground: exception : " + e.getMessage());
            inputStream = null;
        }
        e.a(a, "doInBackground: get bks from hms tss cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
        if (inputStream != null) {
            d.a(inputStream);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Boolean bool) {
        if (bool.booleanValue()) {
            e.c(a, "onPostExecute: upate done");
        } else {
            e.b(a, "onPostExecute: upate failed");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onProgressUpdate(Integer... numArr) {
        e.c(a, "onProgressUpdate");
    }
}
