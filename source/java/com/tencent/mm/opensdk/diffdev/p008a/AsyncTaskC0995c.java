package com.tencent.mm.opensdk.diffdev.p008a;

import android.os.AsyncTask;
import com.ss.mediakit.net.AVMDLMultiNetwork;
import com.tencent.mm.opensdk.channel.p007a.C0992a;
import com.tencent.mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.mm.opensdk.diffdev.OAuthListener;
import com.tencent.mm.opensdk.utils.Log;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.opensdk.diffdev.a.c */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
class AsyncTaskC0995c extends AsyncTask<Void, Void, a> {

    /* renamed from: a */
    private String f189a;

    /* renamed from: b */
    private String f190b;

    /* renamed from: c */
    private OAuthListener f191c;

    /* renamed from: d */
    private int f192d;

    /* renamed from: com.tencent.mm.opensdk.diffdev.a.c$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    static class a {

        /* renamed from: a */
        public OAuthErrCode f193a;

        /* renamed from: b */
        public String f194b;

        /* renamed from: c */
        public int f195c;

        a() {
        }
    }

    public AsyncTaskC0995c(String str, OAuthListener oAuthListener) {
        this.f189a = str;
        this.f191c = oAuthListener;
        this.f190b = String.format("https://long.open.weixin.qq.com/connect/l/qrconnect?f=json&uuid=%s", str);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:24:0x00b6. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x016a A[SYNTHETIC] */
    @Override // android.os.AsyncTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected a doInBackground(Void[] voidArr) {
        a aVar;
        OAuthErrCode oAuthErrCode;
        OAuthErrCode oAuthErrCode2;
        OAuthErrCode oAuthErrCode3;
        String format;
        JSONObject jSONObject;
        int i;
        OAuthErrCode oAuthErrCode4;
        Thread.currentThread().setName("OpenSdkNoopingTask");
        String str = this.f189a;
        if (str != null && str.length() != 0) {
            Log.m271i("MicroMsg.SDK.NoopingTask", "doInBackground start " + isCancelled());
            while (!isCancelled()) {
                String str2 = this.f190b + (this.f192d == 0 ? "" : "&last=" + this.f192d);
                long currentTimeMillis = System.currentTimeMillis();
                byte[] m256a = C0992a.m256a(str2, AVMDLMultiNetwork.mLoopIpRefreshInterval);
                long currentTimeMillis2 = System.currentTimeMillis();
                aVar = new a();
                Log.m269d("MicroMsg.SDK.NoopingResult", "star parse NoopingResult");
                if (m256a != null && m256a.length != 0) {
                    try {
                        try {
                            jSONObject = new JSONObject(new String(m256a, "utf-8"));
                            int i2 = jSONObject.getInt("wx_errcode");
                            aVar.f195c = i2;
                            Log.m269d("MicroMsg.SDK.NoopingResult", String.format("nooping uuidStatusCode = %d", Integer.valueOf(i2)));
                            i = aVar.f195c;
                        } catch (Exception e) {
                            format = String.format("parse json fail, ex = %s", e.getMessage());
                            Log.m270e("MicroMsg.SDK.NoopingResult", format);
                            oAuthErrCode2 = OAuthErrCode.WechatAuth_Err_NormalErr;
                            aVar.f193a = oAuthErrCode2;
                            Log.m269d("MicroMsg.SDK.NoopingTask", String.format("nooping, url = %s, errCode = %s, uuidStatusCode = %d, time consumed = %d(ms)", str2, aVar.f193a.toString(), Integer.valueOf(aVar.f195c), Long.valueOf(currentTimeMillis2 - currentTimeMillis)));
                            oAuthErrCode3 = aVar.f193a;
                            if (oAuthErrCode3 == OAuthErrCode.WechatAuth_Err_OK) {
                            }
                            return aVar;
                        }
                    } catch (Exception e2) {
                        format = String.format("parse fail, build String fail, ex = %s", e2.getMessage());
                    }
                    if (i != 408) {
                        if (i != 500) {
                            switch (i) {
                                case 402:
                                    oAuthErrCode4 = OAuthErrCode.WechatAuth_Err_Timeout;
                                    aVar.f193a = oAuthErrCode4;
                                    break;
                                case 403:
                                    oAuthErrCode4 = OAuthErrCode.WechatAuth_Err_Cancel;
                                    aVar.f193a = oAuthErrCode4;
                                    break;
                                case 405:
                                    aVar.f193a = OAuthErrCode.WechatAuth_Err_OK;
                                    aVar.f194b = jSONObject.getString("wx_code");
                                    break;
                            }
                            Log.m269d("MicroMsg.SDK.NoopingTask", String.format("nooping, url = %s, errCode = %s, uuidStatusCode = %d, time consumed = %d(ms)", str2, aVar.f193a.toString(), Integer.valueOf(aVar.f195c), Long.valueOf(currentTimeMillis2 - currentTimeMillis)));
                            oAuthErrCode3 = aVar.f193a;
                            if (oAuthErrCode3 == OAuthErrCode.WechatAuth_Err_OK) {
                                int i3 = aVar.f195c;
                                this.f192d = i3;
                                if (i3 == EnumC0996d.UUID_SCANED.m263a()) {
                                    this.f191c.onQrcodeScanned();
                                } else if (aVar.f195c != EnumC0996d.UUID_KEEP_CONNECT.m263a() && aVar.f195c == EnumC0996d.UUID_CONFIRM.m263a()) {
                                    String str3 = aVar.f194b;
                                    if (str3 == null || str3.length() == 0) {
                                        Log.m270e("MicroMsg.SDK.NoopingTask", "nooping fail, confirm with an empty code!!!");
                                    }
                                }
                            } else {
                                Log.m270e("MicroMsg.SDK.NoopingTask", String.format("nooping fail, errCode = %s, uuidStatusCode = %d", oAuthErrCode3.toString(), Integer.valueOf(aVar.f195c)));
                            }
                            return aVar;
                        }
                        oAuthErrCode4 = OAuthErrCode.WechatAuth_Err_NormalErr;
                        aVar.f193a = oAuthErrCode4;
                        Log.m269d("MicroMsg.SDK.NoopingTask", String.format("nooping, url = %s, errCode = %s, uuidStatusCode = %d, time consumed = %d(ms)", str2, aVar.f193a.toString(), Integer.valueOf(aVar.f195c), Long.valueOf(currentTimeMillis2 - currentTimeMillis)));
                        oAuthErrCode3 = aVar.f193a;
                        if (oAuthErrCode3 == OAuthErrCode.WechatAuth_Err_OK) {
                        }
                        return aVar;
                    }
                    oAuthErrCode4 = OAuthErrCode.WechatAuth_Err_OK;
                    aVar.f193a = oAuthErrCode4;
                    Log.m269d("MicroMsg.SDK.NoopingTask", String.format("nooping, url = %s, errCode = %s, uuidStatusCode = %d, time consumed = %d(ms)", str2, aVar.f193a.toString(), Integer.valueOf(aVar.f195c), Long.valueOf(currentTimeMillis2 - currentTimeMillis)));
                    oAuthErrCode3 = aVar.f193a;
                    if (oAuthErrCode3 == OAuthErrCode.WechatAuth_Err_OK) {
                    }
                    return aVar;
                }
                Log.m270e("MicroMsg.SDK.NoopingResult", "parse fail, buf is null");
                oAuthErrCode2 = OAuthErrCode.WechatAuth_Err_NetworkErr;
                aVar.f193a = oAuthErrCode2;
                Log.m269d("MicroMsg.SDK.NoopingTask", String.format("nooping, url = %s, errCode = %s, uuidStatusCode = %d, time consumed = %d(ms)", str2, aVar.f193a.toString(), Integer.valueOf(aVar.f195c), Long.valueOf(currentTimeMillis2 - currentTimeMillis)));
                oAuthErrCode3 = aVar.f193a;
                if (oAuthErrCode3 == OAuthErrCode.WechatAuth_Err_OK) {
                }
                return aVar;
            }
            Log.m271i("MicroMsg.SDK.NoopingTask", "IDiffDevOAuth.stopAuth / detach invoked");
            aVar = new a();
            oAuthErrCode = OAuthErrCode.WechatAuth_Err_Auth_Stopped;
            aVar.f193a = oAuthErrCode;
            return aVar;
        }
        Log.m270e("MicroMsg.SDK.NoopingTask", "run fail, uuid is null");
        aVar = new a();
        oAuthErrCode = OAuthErrCode.WechatAuth_Err_NormalErr;
        aVar.f193a = oAuthErrCode;
        return aVar;
    }

    @Override // android.os.AsyncTask
    protected void onPostExecute(a aVar) {
        a aVar2 = aVar;
        this.f191c.onAuthFinish(aVar2.f193a, aVar2.f194b);
    }
}
