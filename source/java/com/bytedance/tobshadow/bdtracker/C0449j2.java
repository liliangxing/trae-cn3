package com.bytedance.tobshadow.bdtracker;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.tobshadow.applog.log.LoggerImpl;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;
import org.json.JSONObject;

/* renamed from: com.bytedance.tobshadow.bdtracker.j2 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class C0449j2 extends AbstractC0553y1 {

    /* renamed from: e */
    public final Context f699e;

    /* renamed from: f */
    public final C0407d2 f700f;

    public C0449j2(Context context, C0407d2 c0407d2) {
        super(false, false);
        this.f699e = context;
        this.f700f = c0407d2;
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0553y1
    /* renamed from: a */
    public String mo253a() {
        return "Gaid";
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0553y1
    /* renamed from: a */
    public boolean mo255a(JSONObject jSONObject) {
        if (!this.f700f.f502c.isGaidEnabled()) {
            return true;
        }
        String googleAid = this.f700f.f502c.getGoogleAid();
        if (TextUtils.isEmpty(googleAid)) {
            try {
                googleAid = C0487o5.m606a(this.f699e, this.f700f);
            } catch (InterruptedException | ExecutionException | Exception unused) {
            } catch (TimeoutException e) {
                LoggerImpl.global().error("Query Gaid Timeout", e, new Object[0]);
            }
        }
        C0421f2.m398a(jSONObject, "google_aid", googleAid);
        return true;
    }
}
