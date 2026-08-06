package com.hihonor.push.sdk;

import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.vmsdk.inspector_new.server.websocket.Utf8Charset;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import org.json.JSONObject;

/* renamed from: com.hihonor.push.sdk.q0 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class CallableC0949q0 implements Callable<HonorPushDataMsg> {

    /* renamed from: a */
    public final Intent f753a;

    public CallableC0949q0(Intent intent) {
        this.f753a = intent;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    @Override // java.util.concurrent.Callable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public HonorPushDataMsg call() throws Exception {
        byte[] bArr;
        String str;
        Intent intent = this.f753a;
        if (intent == null) {
            return null;
        }
        long j = 0;
        try {
            j = intent.getLongExtra("msg_id", 0L);
        } catch (Exception e) {
            C0912c.m757a("PassByMsgIntentParser", "parserMsgId", e);
        }
        try {
            bArr = this.f753a.getByteArrayExtra("msg_content");
        } catch (Exception e2) {
            C0912c.m757a("PassByMsgIntentParser", "parseMsgContent", e2);
            bArr = null;
        }
        if (bArr != null && bArr.length != 0) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            InflaterInputStream inflaterInputStream = new InflaterInputStream(byteArrayInputStream, new Inflater());
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byte[] bArr2 = new byte[256];
                while (true) {
                    int read = inflaterInputStream.read(bArr2);
                    if (read <= 0) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr2, 0, read);
                }
                str = byteArrayOutputStream.toString(Utf8Charset.NAME);
            } catch (IOException e3) {
                C0912c.m757a("DeflateUtil", "unZipString", e3);
            } finally {
                C0909b.m747a(byteArrayInputStream);
                C0909b.m747a(inflaterInputStream);
                C0909b.m747a(byteArrayOutputStream);
            }
            if (str != null) {
                return null;
            }
            String optString = new JSONObject(str).optString("data");
            if (TextUtils.isEmpty(optString)) {
                return null;
            }
            HonorPushDataMsg honorPushDataMsg = new HonorPushDataMsg();
            honorPushDataMsg.setMsgId(j);
            honorPushDataMsg.setData(optString);
            return honorPushDataMsg;
        }
        Log.w("DeflateUtil", "un zip data is empty");
        str = null;
        if (str != null) {
        }
    }
}
