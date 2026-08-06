package com.hihonor.push.sdk;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* renamed from: com.hihonor.push.sdk.p0 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class CallableC0947p0 implements Callable<List<HonorPushDataMsg>> {

    /* renamed from: a */
    public final Context f751a;

    public CallableC0947p0(Context context) {
        this.f751a = context;
    }

    @Override // java.util.concurrent.Callable
    public List<HonorPushDataMsg> call() throws Exception {
        ArrayList<ContentValues> parcelableArrayList;
        Bundle bundle = new Bundle();
        bundle.putString("pkg_name", this.f751a.getPackageName());
        Bundle call = this.f751a.getContentResolver().call(Uri.parse("content://com.hihonor.android.pushagent.provider.MessageBoxProvider/"), "query_unread_msg", "", bundle);
        ArrayList arrayList = new ArrayList();
        if (call != null && (parcelableArrayList = call.getParcelableArrayList("messages")) != null) {
            for (ContentValues contentValues : parcelableArrayList) {
                JSONObject jSONObject = new JSONObject();
                for (String str : contentValues.keySet()) {
                    jSONObject.put(str, contentValues.get(str));
                }
                HonorPushDataMsg honorPushDataMsg = new HonorPushDataMsg();
                honorPushDataMsg.setData(jSONObject.toString());
                honorPushDataMsg.setType(1);
                arrayList.add(honorPushDataMsg);
            }
        }
        return arrayList;
    }
}
