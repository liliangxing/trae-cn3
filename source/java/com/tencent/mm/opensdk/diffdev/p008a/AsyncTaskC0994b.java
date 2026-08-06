package com.tencent.mm.opensdk.diffdev.p008a;

import android.os.AsyncTask;
import android.util.Base64;
import com.ss.mediakit.net.AVMDLMultiNetwork;
import com.tencent.mm.opensdk.channel.p007a.C0992a;
import com.tencent.mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.mm.opensdk.diffdev.OAuthListener;
import com.tencent.mm.opensdk.utils.Log;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.opensdk.diffdev.a.b */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class AsyncTaskC0994b extends AsyncTask<Void, Void, a> {

    /* renamed from: a */
    private String f177a;

    /* renamed from: b */
    private String f178b;

    /* renamed from: c */
    private String f179c;

    /* renamed from: d */
    private String f180d;

    /* renamed from: e */
    private String f181e;

    /* renamed from: f */
    private OAuthListener f182f;

    /* renamed from: g */
    private AsyncTaskC0995c f183g;

    /* renamed from: com.tencent.mm.opensdk.diffdev.a.b$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    static class a {

        /* renamed from: a */
        public OAuthErrCode f184a;

        /* renamed from: b */
        public String f185b;

        /* renamed from: c */
        public String f186c;

        /* renamed from: d */
        public String f187d;

        /* renamed from: e */
        public byte[] f188e;

        private a() {
        }

        /* renamed from: a */
        public static a m262a(byte[] bArr) {
            OAuthErrCode oAuthErrCode;
            String format;
            a aVar = new a();
            if (bArr != null && bArr.length != 0) {
                try {
                } catch (Exception e) {
                    format = String.format("parse fail, build String fail, ex = %s", e.getMessage());
                }
                try {
                    JSONObject jSONObject = new JSONObject(new String(bArr, "utf-8"));
                    int i = jSONObject.getInt("errcode");
                    if (i != 0) {
                        Log.m270e("MicroMsg.SDK.GetQRCodeResult", String.format("resp errcode = %d", Integer.valueOf(i)));
                        aVar.f184a = OAuthErrCode.WechatAuth_Err_NormalErr;
                        jSONObject.optString("errmsg");
                        return aVar;
                    }
                    String string = jSONObject.getJSONObject("qrcode").getString("qrcodebase64");
                    if (string != null && string.length() != 0) {
                        byte[] decode = Base64.decode(string, 0);
                        if (decode != null && decode.length != 0) {
                            aVar.f184a = OAuthErrCode.WechatAuth_Err_OK;
                            aVar.f188e = decode;
                            aVar.f185b = jSONObject.getString("uuid");
                            String string2 = jSONObject.getString("appname");
                            aVar.f186c = string2;
                            Log.m269d("MicroMsg.SDK.GetQRCodeResult", String.format("parse succ, save in memory, uuid = %s, appname = %s, imgBufLength = %d", aVar.f185b, string2, Integer.valueOf(aVar.f188e.length)));
                            return aVar;
                        }
                        Log.m270e("MicroMsg.SDK.GetQRCodeResult", "parse fail, qrcodeBuf is null");
                        aVar.f184a = OAuthErrCode.WechatAuth_Err_JsonDecodeErr;
                        return aVar;
                    }
                    Log.m270e("MicroMsg.SDK.GetQRCodeResult", "parse fail, qrcodeBase64 is null");
                    aVar.f184a = OAuthErrCode.WechatAuth_Err_JsonDecodeErr;
                    return aVar;
                } catch (Exception e2) {
                    format = String.format("parse json fail, ex = %s", e2.getMessage());
                    Log.m270e("MicroMsg.SDK.GetQRCodeResult", format);
                    oAuthErrCode = OAuthErrCode.WechatAuth_Err_NormalErr;
                    aVar.f184a = oAuthErrCode;
                    return aVar;
                }
            }
            Log.m270e("MicroMsg.SDK.GetQRCodeResult", "parse fail, buf is null");
            oAuthErrCode = OAuthErrCode.WechatAuth_Err_NetworkErr;
            aVar.f184a = oAuthErrCode;
            return aVar;
        }
    }

    public AsyncTaskC0994b(String str, String str2, String str3, String str4, String str5, OAuthListener oAuthListener) {
        this.f177a = str;
        this.f178b = str2;
        this.f179c = str3;
        this.f180d = str4;
        this.f181e = str5;
        this.f182f = oAuthListener;
    }

    /* renamed from: a */
    public boolean m261a() {
        Log.m271i("MicroMsg.SDK.GetQRCodeTask", "cancelTask");
        AsyncTaskC0995c asyncTaskC0995c = this.f183g;
        return asyncTaskC0995c == null ? cancel(true) : asyncTaskC0995c.cancel(true);
    }

    @Override // android.os.AsyncTask
    protected a doInBackground(Void[] voidArr) {
        Thread.currentThread().setName("OpenSdkGetQRCodeTask");
        Log.m271i("MicroMsg.SDK.GetQRCodeTask", "doInBackground");
        String format = String.format("https://open.weixin.qq.com/connect/sdk/qrconnect?appid=%s&noncestr=%s&timestamp=%s&scope=%s&signature=%s", this.f177a, this.f179c, this.f180d, this.f178b, this.f181e);
        long currentTimeMillis = System.currentTimeMillis();
        byte[] m256a = C0992a.m256a(format, AVMDLMultiNetwork.mLoopIpRefreshInterval);
        Log.m269d("MicroMsg.SDK.GetQRCodeTask", String.format("doInBackground, url = %s, time consumed = %d(ms)", format, Long.valueOf(System.currentTimeMillis() - currentTimeMillis)));
        return a.m262a(m256a);
    }

    @Override // android.os.AsyncTask
    protected void onPostExecute(a aVar) {
        a aVar2 = aVar;
        OAuthErrCode oAuthErrCode = aVar2.f184a;
        if (oAuthErrCode == OAuthErrCode.WechatAuth_Err_OK) {
            Log.m269d("MicroMsg.SDK.GetQRCodeTask", "onPostExecute, get qrcode success imgBufSize = " + aVar2.f188e.length);
            this.f182f.onAuthGotQrcode(aVar2.f187d, aVar2.f188e);
            AsyncTaskC0995c asyncTaskC0995c = new AsyncTaskC0995c(aVar2.f185b, this.f182f);
            this.f183g = asyncTaskC0995c;
            asyncTaskC0995c.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return;
        }
        Log.m270e("MicroMsg.SDK.GetQRCodeTask", String.format("onPostExecute, get qrcode fail, OAuthErrCode = %s", oAuthErrCode));
        this.f182f.onAuthFinish(aVar2.f184a, null);
    }
}
