package com.tencent.mm.opensdk.diffdev.a;

import android.os.AsyncTask;
import com.bytedance.platform.godzilla.common.Constant;
import com.tencent.mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.mm.opensdk.diffdev.OAuthListener;
import com.tencent.mm.opensdk.utils.Log;
import org.json.JSONObject;

/* loaded from: classes7.dex */
class c extends AsyncTask<Void, Void, a> {
    private String a;
    private String b;
    private OAuthListener c;
    private int d;

    /* loaded from: classes7.dex */
    static class a {
        public OAuthErrCode a;
        public String b;
        public int c;

        a() {
        }
    }

    public c(String str, OAuthListener oAuthListener) {
        this.a = str;
        this.c = oAuthListener;
        this.b = String.format("https://long.open.weixin.qq.com/connect/l/qrconnect?f=json&uuid=%s", str);
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
        String str = this.a;
        if (str != null && str.length() != 0) {
            Log.i("MicroMsg.SDK.NoopingTask", "doInBackground start " + isCancelled());
            while (!isCancelled()) {
                String str2 = this.b + (this.d == 0 ? "" : "&last=" + this.d);
                long currentTimeMillis = System.currentTimeMillis();
                byte[] a2 = com.tencent.mm.opensdk.channel.a.a.a(str2, 60000);
                long currentTimeMillis2 = System.currentTimeMillis();
                aVar = new a();
                Log.d("MicroMsg.SDK.NoopingResult", "star parse NoopingResult");
                if (a2 != null && a2.length != 0) {
                    try {
                        try {
                            jSONObject = new JSONObject(new String(a2, Constant.CHARSET_UTF_8));
                            int i2 = jSONObject.getInt("wx_errcode");
                            aVar.c = i2;
                            Log.d("MicroMsg.SDK.NoopingResult", String.format("nooping uuidStatusCode = %d", Integer.valueOf(i2)));
                            i = aVar.c;
                        } catch (Exception e) {
                            format = String.format("parse json fail, ex = %s", e.getMessage());
                            Log.e("MicroMsg.SDK.NoopingResult", format);
                            oAuthErrCode2 = OAuthErrCode.WechatAuth_Err_NormalErr;
                            aVar.a = oAuthErrCode2;
                            Log.d("MicroMsg.SDK.NoopingTask", String.format("nooping, url = %s, errCode = %s, uuidStatusCode = %d, time consumed = %d(ms)", str2, aVar.a.toString(), Integer.valueOf(aVar.c), Long.valueOf(currentTimeMillis2 - currentTimeMillis)));
                            oAuthErrCode3 = aVar.a;
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
                                    aVar.a = oAuthErrCode4;
                                    break;
                                case 403:
                                    oAuthErrCode4 = OAuthErrCode.WechatAuth_Err_Cancel;
                                    aVar.a = oAuthErrCode4;
                                    break;
                                case 405:
                                    aVar.a = OAuthErrCode.WechatAuth_Err_OK;
                                    aVar.b = jSONObject.getString("wx_code");
                                    break;
                            }
                            Log.d("MicroMsg.SDK.NoopingTask", String.format("nooping, url = %s, errCode = %s, uuidStatusCode = %d, time consumed = %d(ms)", str2, aVar.a.toString(), Integer.valueOf(aVar.c), Long.valueOf(currentTimeMillis2 - currentTimeMillis)));
                            oAuthErrCode3 = aVar.a;
                            if (oAuthErrCode3 == OAuthErrCode.WechatAuth_Err_OK) {
                                int i3 = aVar.c;
                                this.d = i3;
                                if (i3 == d.UUID_SCANED.a()) {
                                    this.c.onQrcodeScanned();
                                } else if (aVar.c != d.UUID_KEEP_CONNECT.a() && aVar.c == d.UUID_CONFIRM.a()) {
                                    String str3 = aVar.b;
                                    if (str3 == null || str3.length() == 0) {
                                        Log.e("MicroMsg.SDK.NoopingTask", "nooping fail, confirm with an empty code!!!");
                                    }
                                }
                            } else {
                                Log.e("MicroMsg.SDK.NoopingTask", String.format("nooping fail, errCode = %s, uuidStatusCode = %d", oAuthErrCode3.toString(), Integer.valueOf(aVar.c)));
                            }
                            return aVar;
                        }
                        oAuthErrCode4 = OAuthErrCode.WechatAuth_Err_NormalErr;
                        aVar.a = oAuthErrCode4;
                        Log.d("MicroMsg.SDK.NoopingTask", String.format("nooping, url = %s, errCode = %s, uuidStatusCode = %d, time consumed = %d(ms)", str2, aVar.a.toString(), Integer.valueOf(aVar.c), Long.valueOf(currentTimeMillis2 - currentTimeMillis)));
                        oAuthErrCode3 = aVar.a;
                        if (oAuthErrCode3 == OAuthErrCode.WechatAuth_Err_OK) {
                        }
                        return aVar;
                    }
                    oAuthErrCode4 = OAuthErrCode.WechatAuth_Err_OK;
                    aVar.a = oAuthErrCode4;
                    Log.d("MicroMsg.SDK.NoopingTask", String.format("nooping, url = %s, errCode = %s, uuidStatusCode = %d, time consumed = %d(ms)", str2, aVar.a.toString(), Integer.valueOf(aVar.c), Long.valueOf(currentTimeMillis2 - currentTimeMillis)));
                    oAuthErrCode3 = aVar.a;
                    if (oAuthErrCode3 == OAuthErrCode.WechatAuth_Err_OK) {
                    }
                    return aVar;
                }
                Log.e("MicroMsg.SDK.NoopingResult", "parse fail, buf is null");
                oAuthErrCode2 = OAuthErrCode.WechatAuth_Err_NetworkErr;
                aVar.a = oAuthErrCode2;
                Log.d("MicroMsg.SDK.NoopingTask", String.format("nooping, url = %s, errCode = %s, uuidStatusCode = %d, time consumed = %d(ms)", str2, aVar.a.toString(), Integer.valueOf(aVar.c), Long.valueOf(currentTimeMillis2 - currentTimeMillis)));
                oAuthErrCode3 = aVar.a;
                if (oAuthErrCode3 == OAuthErrCode.WechatAuth_Err_OK) {
                }
                return aVar;
            }
            Log.i("MicroMsg.SDK.NoopingTask", "IDiffDevOAuth.stopAuth / detach invoked");
            aVar = new a();
            oAuthErrCode = OAuthErrCode.WechatAuth_Err_Auth_Stopped;
            aVar.a = oAuthErrCode;
            return aVar;
        }
        Log.e("MicroMsg.SDK.NoopingTask", "run fail, uuid is null");
        aVar = new a();
        oAuthErrCode = OAuthErrCode.WechatAuth_Err_NormalErr;
        aVar.a = oAuthErrCode;
        return aVar;
    }

    @Override // android.os.AsyncTask
    protected void onPostExecute(a aVar) {
        a aVar2 = aVar;
        this.c.onAuthFinish(aVar2.a, aVar2.b);
    }
}
