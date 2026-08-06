package com.vivo.push.p013e;

import com.vivo.push.restructure.request.IPushRequestCallback;
import java.util.List;

/* compiled from: ISyncProfileInfo.java */
/* renamed from: com.vivo.push.e.a */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public interface InterfaceC1244a {
    void addProfileId(String str, IPushRequestCallback<Integer> iPushRequestCallback);

    void deleteAllProfileId(IPushRequestCallback<Integer> iPushRequestCallback);

    void deleteProfileId(String str, IPushRequestCallback<Integer> iPushRequestCallback);

    void queryProfileIds(IPushRequestCallback<List<String>> iPushRequestCallback);
}
