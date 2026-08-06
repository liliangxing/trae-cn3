package com.bytedance.p009dr;

import android.content.Context;
import com.bytedance.tobshadow.bdtracker.a;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public interface OaidApi {

    /* renamed from: com.bytedance.dr.OaidApi$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static class C1053a {

        /* renamed from: a */
        public String f153a;

        /* renamed from: b */
        public boolean f154b;

        public String toString() {
            return a.a("Result{oaid='").append(this.f153a).append('\'').append(", isTrackLimit=").append(this.f154b).append('}').toString();
        }
    }

    String getName();

    C1053a getOaid(Context context);

    boolean support(Context context);
}
