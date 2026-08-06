package com.bytedance.frameworks.baselib.network.requestaudit;

import android.text.TextUtils;
import com.bytedance.common.utility.collection.CollectionUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class TTRequestAuditLog {
    private final List<AuditDetail> callbackDetail = new ArrayList();

    /* loaded from: classes2.dex */
    static class AuditDetail {
        private final String callbackIdentify;
        public Set<String> headerRmKeys;
        public Set<String> queryAddKeys;
        public Set<String> queryRmKeys;

        /* JADX INFO: Access modifiers changed from: package-private */
        public AuditDetail(String str) {
            this.callbackIdentify = str;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean isEmpty() {
            return CollectionUtils.isEmpty(this.headerRmKeys) && CollectionUtils.isEmpty(this.queryRmKeys) && CollectionUtils.isEmpty(this.queryAddKeys);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addDetail(AuditDetail auditDetail) {
        if (auditDetail != null) {
            this.callbackDetail.add(auditDetail);
        }
    }

    public JSONObject toJson() {
        if (CollectionUtils.isEmpty(this.callbackDetail)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            for (AuditDetail auditDetail : this.callbackDetail) {
                if (auditDetail != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    if (!CollectionUtils.isEmpty(auditDetail.headerRmKeys)) {
                        JSONArray jSONArray = new JSONArray();
                        Iterator<String> it = auditDetail.headerRmKeys.iterator();
                        while (it.hasNext()) {
                            jSONArray.put(it.next());
                        }
                        jSONObject2.put("rm_header", jSONArray);
                    }
                    if (!CollectionUtils.isEmpty(auditDetail.queryRmKeys)) {
                        JSONArray jSONArray2 = new JSONArray();
                        Iterator<String> it2 = auditDetail.queryRmKeys.iterator();
                        while (it2.hasNext()) {
                            jSONArray2.put(it2.next());
                        }
                        jSONObject2.put("rm_query", jSONArray2);
                    }
                    if (!CollectionUtils.isEmpty(auditDetail.queryAddKeys)) {
                        JSONArray jSONArray3 = new JSONArray();
                        Iterator<String> it3 = auditDetail.queryAddKeys.iterator();
                        while (it3.hasNext()) {
                            jSONArray3.put(it3.next());
                        }
                        jSONObject2.put("add_query", jSONArray3);
                    }
                    jSONObject.put(TextUtils.isEmpty(auditDetail.callbackIdentify) ? "null" : auditDetail.callbackIdentify, jSONObject2);
                }
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }
}
