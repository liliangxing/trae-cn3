package com.bytedance.tobshadow.bdtracker;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.tobshadow.applog.profile.UserProfileCallback;
import com.bytedance.trae.conversation.voice.VoiceChatApiPaths;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.bytedance.tobshadow.bdtracker.h4 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class RunnableC0437h4 implements Runnable {

    /* renamed from: g */
    public static final Handler f650g = new Handler(Looper.getMainLooper());

    /* renamed from: a */
    public final String f651a;

    /* renamed from: b */
    public final String f652b;

    /* renamed from: c */
    public final JSONObject f653c;

    /* renamed from: d */
    public final UserProfileCallback f654d;

    /* renamed from: e */
    public final Context f655e;

    /* renamed from: f */
    public final C0467m f656f;

    public RunnableC0437h4(C0467m c0467m, String str, String str2, JSONObject jSONObject, UserProfileCallback userProfileCallback, Context context) {
        this.f656f = c0467m;
        this.f651a = str;
        this.f652b = str2;
        this.f653c = jSONObject;
        this.f654d = userProfileCallback;
        this.f655e = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (!C0501q5.m624b(this.f655e)) {
                f650g.post(new RunnableC0423f4(this, 0));
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", VoiceChatApiPaths.HeaderValue.CONTENT_TYPE_JSON);
            hashMap.put("X-APIKEY", this.f652b);
            this.f656f.getNetClient().execute((byte) 1, this.f651a, this.f653c, hashMap, (byte) 0, false, 60000);
            f650g.post(new RunnableC0430g4(this));
        } catch (Throwable th) {
            this.f656f.f764D.error(9, "Report profile failed", th, new Object[0]);
            f650g.post(new RunnableC0423f4(this, 1));
        }
    }
}
