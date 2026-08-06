package com.bytedance.tobshadow.bdtracker;

import com.bytedance.tobshadow.applog.util.HardwareUtils;
import java.util.Collections;
import org.json.JSONObject;

/* renamed from: com.bytedance.tobshadow.bdtracker.o0 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class C0482o0 {

    /* renamed from: a */
    public final C0475n0 f890a;

    public C0482o0(C0475n0 c0475n0) {
        this.f890a = c0475n0;
    }

    /* renamed from: a */
    public void m587a(AbstractC0479n4 abstractC0479n4) {
        JSONObject jSONObject;
        try {
            if (abstractC0479n4.f884o != null) {
                jSONObject = abstractC0479n4.f884o;
            } else {
                jSONObject = new JSONObject();
            }
            if (this.f890a.f835e.f502c.isScreenOrientationEnabled()) {
                jSONObject.put("$screen_orientation", HardwareUtils.getScreenOrientation(this.f890a.f834d.f785n) == 2 ? "landscape" : "portrait");
            }
            C0381a0 c0381a0 = this.f890a.f834d.f762B;
            if (c0381a0 != null) {
                jSONObject.put("$longitude", c0381a0.f430a);
                jSONObject.put("$latitude", c0381a0.f431b);
                jSONObject.put("$geo_coordinate_system", c0381a0.f432c);
            }
            if (jSONObject.length() > 0) {
                abstractC0479n4.f884o = jSONObject;
            }
        } catch (Throwable th) {
            this.f890a.f834d.f764D.error(4, Collections.singletonList("LifeHook"), "Do beforeEventSave failed", th, new Object[0]);
        }
    }
}
