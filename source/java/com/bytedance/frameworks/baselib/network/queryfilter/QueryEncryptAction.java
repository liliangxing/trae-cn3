package com.bytedance.frameworks.baselib.network.queryfilter;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import com.bytedance.frameworks.encryptor.EncryptorUtil;
import com.bytedance.retrofit2.client.Request;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
class QueryEncryptAction extends QueryFilterAction {
    protected static final String ENCRYPT_QUERY_KEY = "x-tt-encrypt-queries";
    private static final String NAME_VALUE_SEPARATOR = "=";
    private static final String PARAMETER_SEPARATOR = "&";
    private static final String TAG = "QueryEncryptAction";
    private boolean mEncryptBodyEnabled;
    private List<String> mEncryptQueryList;
    private boolean mIsInvalid;

    public QueryEncryptAction(int i) {
        super(i);
        this.mEncryptQueryList = new ArrayList();
        this.mIsInvalid = false;
        this.mEncryptBodyEnabled = false;
    }

    @Override // com.bytedance.frameworks.baselib.network.queryfilter.QueryFilterAction
    protected void loadActionParam(JSONObject jSONObject) {
        loadMatchRules(jSONObject);
        QueryFilterEngine.parseArrayListConfig(jSONObject.optJSONArray("encrypt_query_list"), this.mEncryptQueryList);
        this.mEncryptBodyEnabled = jSONObject.optInt("encrypt_body_enabled", 0) > 0;
        if (!this.mEncryptQueryList.isEmpty() || this.mEncryptBodyEnabled) {
            return;
        }
        this.mIsInvalid = true;
    }

    @Override // com.bytedance.frameworks.baselib.network.queryfilter.QueryFilterAction
    protected boolean dispatch(Request request, Map<String, List<String>> map) {
        byte[] bArr;
        byte[] encrypt;
        boolean z = false;
        if (!this.mIsInvalid && isMatchUrlRules(request)) {
            if (this.mEncryptBodyEnabled) {
                request.setBodyEncryptEnabled(true);
                z = true;
            }
            if (map.isEmpty()) {
                return z;
            }
            if (!this.mEncryptQueryList.isEmpty() && !map.containsKey(ENCRYPT_QUERY_KEY)) {
                LinkedList linkedList = new LinkedList();
                for (String str : this.mEncryptQueryList) {
                    if (map.containsKey(str)) {
                        linkedList.add(new Pair(str, map.get(str)));
                    }
                }
                if (linkedList.isEmpty()) {
                    return z;
                }
                String format = format(linkedList);
                if (TextUtils.isEmpty(format)) {
                    return z;
                }
                try {
                    bArr = format.getBytes(UrlUtils.UTF_8);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                    bArr = null;
                }
                if (bArr == null || (encrypt = EncryptorUtil.encrypt(bArr, bArr.length)) == null) {
                    return z;
                }
                String encodeToString = Base64.encodeToString(encrypt, 2);
                if (Logger.debug()) {
                    Logger.d(TAG, "encryptBytes:" + encrypt + " , encryptString:" + encodeToString);
                }
                LinkedList linkedList2 = new LinkedList();
                linkedList2.add(encodeToString);
                request.setQueryEncryptEnabled(true);
                map.put(ENCRYPT_QUERY_KEY, linkedList2);
                Iterator<String> it = this.mEncryptQueryList.iterator();
                while (it.hasNext()) {
                    map.remove(it.next());
                }
                return true;
            }
        }
        return z;
    }

    private static String format(List<Pair<String, List<String>>> list) {
        StringBuilder sb = new StringBuilder();
        for (Pair<String, List<String>> pair : list) {
            String str = (String) pair.first;
            List<String> list2 = (List) pair.second;
            if (list2 != null && list2.size() > 0) {
                for (String str2 : list2) {
                    if (sb.length() > 0) {
                        sb.append(PARAMETER_SEPARATOR);
                    }
                    sb.append(str);
                    sb.append(NAME_VALUE_SEPARATOR);
                    sb.append(str2);
                }
            }
        }
        return sb.toString();
    }
}
