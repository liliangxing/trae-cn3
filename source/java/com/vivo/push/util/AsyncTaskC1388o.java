package com.vivo.push.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.vivo.push.C1357t;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.model.NotifyArriveCallbackByUser;
import com.vivo.push.p017h.C1295u;
import com.vivo.push.p017h.C1297w;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ImageDownTask.java */
/* renamed from: com.vivo.push.util.o */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class AsyncTaskC1388o extends AsyncTask<String, Void, List<Bitmap>> {

    /* renamed from: a */
    private Context f711a;

    /* renamed from: b */
    private InsideNotificationItem f712b;

    /* renamed from: c */
    private long f713c;

    /* renamed from: d */
    private boolean f714d;

    /* renamed from: e */
    private int f715e = 0;

    /* renamed from: f */
    private NotifyArriveCallbackByUser f716f;

    /* renamed from: g */
    private C1295u.a f717g;

    @Override // android.os.AsyncTask
    protected final /* synthetic */ void onPostExecute(List<Bitmap> list) {
        List<Bitmap> list2 = list;
        super.onPostExecute(list2);
        C1393t.m1046c("ImageDownTask", "onPostExecute");
        C1357t.m917b(new RunnableC1389p(this, list2));
    }

    public AsyncTaskC1388o(Context context, InsideNotificationItem insideNotificationItem, long j, boolean z, C1297w c1297w, NotifyArriveCallbackByUser notifyArriveCallbackByUser) {
        this.f711a = context;
        this.f712b = insideNotificationItem;
        this.f713c = j;
        this.f714d = z;
        this.f717g = c1297w;
        this.f716f = notifyArriveCallbackByUser;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0097, code lost:
    
        if (r5 == null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x009a, code lost:
    
        r6 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x008d, code lost:
    
        r5.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x008b, code lost:
    
        if (r5 == null) goto L31;
     */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<Bitmap> doInBackground(String... strArr) {
        InputStream inputStream;
        Bitmap bitmap;
        this.f715e = this.f712b.getNotifyDisplayStatus();
        InputStream inputStream2 = null;
        if (!this.f714d) {
            C1393t.m1048d("ImageDownTask", "bitmap is not display by forbid net");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 2; i++) {
            String str = strArr[i];
            C1393t.m1048d("ImageDownTask", "imgUrl=" + str + " i=" + i);
            if (!TextUtils.isEmpty(str)) {
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                    httpURLConnection.setConnectTimeout(30000);
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.connect();
                    int responseCode = httpURLConnection.getResponseCode();
                    C1393t.m1046c("ImageDownTask", "code=".concat(String.valueOf(responseCode)));
                    if (responseCode == 200) {
                        inputStream = httpURLConnection.getInputStream();
                        try {
                            try {
                                bitmap = BitmapFactory.decodeStream(inputStream);
                            } catch (Throwable th) {
                                th = th;
                                inputStream2 = inputStream;
                                if (inputStream2 != null) {
                                    try {
                                        inputStream2.close();
                                    } catch (Exception unused) {
                                    }
                                }
                                throw th;
                            }
                        } catch (MalformedURLException unused2) {
                            C1393t.m1034a("ImageDownTask", "MalformedURLException");
                        } catch (IOException unused3) {
                            C1393t.m1034a("ImageDownTask", "IOException");
                        }
                    } else {
                        inputStream = null;
                        bitmap = null;
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception unused4) {
                        }
                    }
                } catch (MalformedURLException unused5) {
                    inputStream = null;
                } catch (IOException unused6) {
                    inputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                }
                arrayList.add(bitmap);
            } else if (i == 0) {
                arrayList.add(null);
            }
        }
        return arrayList;
    }
}
