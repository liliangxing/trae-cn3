package com.vivo.push.e;

import com.vivo.push.restructure.request.IPushRequestCallback;
import java.util.List;

/* compiled from: ISyncProfileInfo.java */
/* loaded from: classes7.dex */
public interface a {
    void addProfileId(String str, IPushRequestCallback<Integer> iPushRequestCallback);

    void deleteAllProfileId(IPushRequestCallback<Integer> iPushRequestCallback);

    void deleteProfileId(String str, IPushRequestCallback<Integer> iPushRequestCallback);

    void queryProfileIds(IPushRequestCallback<List<String>> iPushRequestCallback);
}
