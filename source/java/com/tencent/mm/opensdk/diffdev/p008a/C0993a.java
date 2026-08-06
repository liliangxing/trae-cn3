package com.tencent.mm.opensdk.diffdev.p008a;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import com.lynx.tasm.event.LynxImpressionEvent;
import com.tencent.mm.opensdk.diffdev.IDiffDevOAuth;
import com.tencent.mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.mm.opensdk.diffdev.OAuthListener;
import com.tencent.mm.opensdk.utils.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.tencent.mm.opensdk.diffdev.a.a */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C0993a implements IDiffDevOAuth {

    /* renamed from: c */
    private AsyncTaskC0994b f173c;

    /* renamed from: a */
    private Handler f171a = null;

    /* renamed from: b */
    private List<OAuthListener> f172b = new ArrayList();

    /* renamed from: d */
    private OAuthListener f174d = new a();

    /* renamed from: com.tencent.mm.opensdk.diffdev.a.a$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    class a implements OAuthListener {

        /* renamed from: com.tencent.mm.opensdk.diffdev.a.a$a$a, reason: collision with other inner class name */
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
        class RunnableC1851a implements Runnable {
            RunnableC1851a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(C0993a.this.f172b);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((OAuthListener) it.next()).onQrcodeScanned();
                }
            }
        }

        a() {
        }

        @Override // com.tencent.mm.opensdk.diffdev.OAuthListener
        public void onAuthFinish(OAuthErrCode oAuthErrCode, String str) {
            Log.m269d("MicroMsg.SDK.ListenerWrapper", String.format("onAuthFinish, errCode = %s, authCode = %s", oAuthErrCode.toString(), str));
            C0993a.this.f173c = null;
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(C0993a.this.f172b);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((OAuthListener) it.next()).onAuthFinish(oAuthErrCode, str);
            }
        }

        @Override // com.tencent.mm.opensdk.diffdev.OAuthListener
        public void onAuthGotQrcode(String str, byte[] bArr) {
            Log.m269d("MicroMsg.SDK.ListenerWrapper", "onAuthGotQrcode, qrcodeImgPath = " + str);
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(C0993a.this.f172b);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((OAuthListener) it.next()).onAuthGotQrcode(str, bArr);
            }
        }

        @Override // com.tencent.mm.opensdk.diffdev.OAuthListener
        public void onQrcodeScanned() {
            Log.m269d("MicroMsg.SDK.ListenerWrapper", "onQrcodeScanned");
            if (C0993a.this.f171a != null) {
                C0993a.this.f171a.post(new RunnableC1851a());
            }
        }
    }

    @Override // com.tencent.mm.opensdk.diffdev.IDiffDevOAuth
    public void addListener(OAuthListener oAuthListener) {
        if (this.f172b.contains(oAuthListener)) {
            return;
        }
        this.f172b.add(oAuthListener);
    }

    @Override // com.tencent.mm.opensdk.diffdev.IDiffDevOAuth
    public boolean auth(String str, String str2, String str3, String str4, String str5, OAuthListener oAuthListener) {
        Log.m271i("MicroMsg.SDK.DiffDevOAuth", "start auth, appId = " + str);
        if (str != null && str.length() > 0 && str2 != null && str2.length() > 0) {
            if (this.f171a == null) {
                this.f171a = new Handler(Looper.getMainLooper());
            }
            if (!this.f172b.contains(oAuthListener)) {
                this.f172b.add(oAuthListener);
            }
            if (this.f173c != null) {
                Log.m269d("MicroMsg.SDK.DiffDevOAuth", "auth, already running, no need to start auth again");
                return true;
            }
            AsyncTaskC0994b asyncTaskC0994b = new AsyncTaskC0994b(str, str2, str3, str4, str5, this.f174d);
            this.f173c = asyncTaskC0994b;
            asyncTaskC0994b.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return true;
        }
        Log.m269d("MicroMsg.SDK.DiffDevOAuth", String.format("auth fail, invalid argument, appId = %s, scope = %s", str, str2));
        return false;
    }

    @Override // com.tencent.mm.opensdk.diffdev.IDiffDevOAuth
    public void detach() {
        Log.m271i("MicroMsg.SDK.DiffDevOAuth", LynxImpressionEvent.EVENT_DETACH);
        this.f172b.clear();
        stopAuth();
    }

    @Override // com.tencent.mm.opensdk.diffdev.IDiffDevOAuth
    public void removeAllListeners() {
        this.f172b.clear();
    }

    @Override // com.tencent.mm.opensdk.diffdev.IDiffDevOAuth
    public void removeListener(OAuthListener oAuthListener) {
        this.f172b.remove(oAuthListener);
    }

    @Override // com.tencent.mm.opensdk.diffdev.IDiffDevOAuth
    public boolean stopAuth() {
        boolean z;
        Log.m271i("MicroMsg.SDK.DiffDevOAuth", "stopAuth");
        try {
            AsyncTaskC0994b asyncTaskC0994b = this.f173c;
            z = asyncTaskC0994b == null ? true : asyncTaskC0994b.m261a();
        } catch (Exception e) {
            Log.m273w("MicroMsg.SDK.DiffDevOAuth", "stopAuth fail, ex = " + e.getMessage());
            z = false;
        }
        this.f173c = null;
        return z;
    }
}
