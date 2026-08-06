package com.bytedance.tobshadow.bdtracker;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.tobshadow.applog.profile.UserProfileCallback;
import com.bytedance.trae.conversation.voice.VoiceChatApiPaths;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class h4 implements Runnable {
    public static final Handler g = new Handler(Looper.getMainLooper());
    public final String a;
    public final String b;
    public final JSONObject c;
    public final UserProfileCallback d;
    public final Context e;
    public final m f;

    public h4(m mVar, String str, String str2, JSONObject jSONObject, UserProfileCallback userProfileCallback, Context context) {
        this.f = mVar;
        this.a = str;
        this.b = str2;
        this.c = jSONObject;
        this.d = userProfileCallback;
        this.e = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (!q5.b(this.e)) {
                g.post(new f4(this, 0));
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", VoiceChatApiPaths.HeaderValue.CONTENT_TYPE_JSON);
            hashMap.put("X-APIKEY", this.b);
            this.f.getNetClient().execute((byte) 1, this.a, this.c, hashMap, (byte) 0, false, 60000);
            g.post(new g4(this));
        } catch (Throwable th) {
            this.f.D.error(9, "Report profile failed", th, new Object[0]);
            g.post(new f4(this, 1));
        }
    }
}
