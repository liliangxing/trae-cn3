package com.vivo.push.p017h;

import android.text.TextUtils;
import com.vivo.push.AbstractC1400v;
import com.vivo.push.C1306m;
import com.vivo.push.C1357t;
import com.vivo.push.p010b.C1224u;
import com.vivo.push.restructure.C1313a;
import com.vivo.push.util.C1393t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: OnSetTagsReceiveTask.java */
/* renamed from: com.vivo.push.h.ac */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
final class C1267ac extends AbstractC1266ab {
    /* JADX INFO: Access modifiers changed from: package-private */
    public C1267ac(AbstractC1400v abstractC1400v) {
        super(abstractC1400v);
    }

    @Override // com.vivo.push.AbstractRunnableC1352s
    /* renamed from: a */
    protected final void mo702a(AbstractC1400v abstractC1400v) {
        JSONObject jSONObject;
        C1224u c1224u = (C1224u) abstractC1400v;
        ArrayList<String> m628e = c1224u.m628e();
        List<String> m629f = c1224u.m629f();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        int m627j = c1224u.m627j();
        C1393t.m1046c("OnSetTagsTask", "doTask,删除成功的标签 = " + m628e + " 删除失败的= " + m629f + " 错误码= " + m627j);
        String m626i = c1224u.m626i();
        if (m628e != null) {
            for (String str : m628e) {
                if (str.startsWith("ali/")) {
                    arrayList2.add(str.replace("ali/", ""));
                } else if (str.startsWith("tag/")) {
                    arrayList.add(str.replace("tag/", ""));
                }
            }
        }
        if (m629f != null) {
            for (String str2 : m629f) {
                if (str2.startsWith("ali/")) {
                    arrayList4.add(str2.replace("ali/", ""));
                } else if (str2.startsWith("tag/")) {
                    arrayList3.add(str2.replace("tag/", ""));
                }
            }
        }
        if (arrayList.size() > 0 || arrayList3.size() > 0) {
            C1393t.m1046c("OnSetTagsTask", "doTask1,订阅成功的标签 = " + arrayList + " 订阅失败的标签= " + arrayList3 + " 错误码= " + m627j);
            if (arrayList.size() > 0) {
                C1306m.m762a();
                try {
                    if (arrayList.size() > 0) {
                        String mo867g = C1313a.m810a().m815e().mo867g();
                        if (TextUtils.isEmpty(mo867g)) {
                            jSONObject = new JSONObject();
                        } else {
                            jSONObject = new JSONObject(mo867g);
                        }
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            jSONObject.put((String) it.next(), System.currentTimeMillis());
                        }
                        String jSONObject2 = jSONObject.toString();
                        if (TextUtils.isEmpty(jSONObject2)) {
                            C1313a.m810a().m815e().mo868h();
                        } else {
                            C1313a.m810a().m815e().mo863d(jSONObject2);
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    C1313a.m810a().m815e().mo868h();
                }
            }
            C1306m.m762a().m778a(c1224u.m626i(), m627j);
            C1357t.m916a(new RunnableC1268ad(this, m627j, arrayList, arrayList3, m626i));
        }
        if (arrayList2.size() > 0 || arrayList4.size() > 0) {
            C1393t.m1046c("OnSetTagsTask", "doTask1,订阅成功的别名 = " + arrayList + " 订阅失败的别名= " + arrayList3 + " 错误码= " + m627j);
            if (arrayList2.size() > 0) {
                C1306m.m762a().m777a((String) arrayList2.get(0));
            }
            C1306m.m762a().m778a(c1224u.m626i(), m627j);
            C1357t.m916a(new RunnableC1269ae(this, m627j, arrayList2, arrayList4, m626i));
        }
    }
}
