package com.bytedance.frameworks.baselib.network.queryfilter;

import coil3.disk.DiskLruCache;
import com.bytedance.retrofit2.client.Request;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
class QueryRemoveAction extends QueryFilterAction {
    private static final String KEY_ADD_BACKGROUND_RM_MARK = "add_background_rm_mark";
    private static final String KEY_BACKGROUND_MARK_PARAM = "bgrm";
    private static final String KEY_BACKGROUND_PROTECT = "protect_background_request";
    private static final String TAG = "QueryRemoveAction";
    private boolean mIsInvalid;
    private List<String> mKeepQueryList;
    private boolean mNeedBackgroundRmMark;
    private List<String> mRemoveQueryList;

    public QueryRemoveAction(int i) {
        super(i);
        this.mKeepQueryList = new ArrayList();
        this.mRemoveQueryList = new ArrayList();
        this.mIsInvalid = false;
        this.mNeedBackgroundRmMark = false;
    }

    @Override // com.bytedance.frameworks.baselib.network.queryfilter.QueryFilterAction
    protected void loadActionParam(JSONObject jSONObject) {
        loadMatchRules(jSONObject);
        QueryFilterEngine.parseArrayListConfig(jSONObject.optJSONArray("keep_list"), this.mKeepQueryList);
        QueryFilterEngine.parseArrayListConfig(jSONObject.optJSONArray("remove_list"), this.mRemoveQueryList);
        this.mNeedBackgroundProtect = jSONObject.optInt(KEY_BACKGROUND_PROTECT, 0) > 0;
        this.mNeedBackgroundRmMark = jSONObject.optInt(KEY_ADD_BACKGROUND_RM_MARK, 0) > 0;
        if (this.mKeepQueryList.isEmpty() || this.mRemoveQueryList.isEmpty()) {
            return;
        }
        this.mIsInvalid = true;
    }

    @Override // com.bytedance.frameworks.baselib.network.queryfilter.QueryFilterAction
    protected boolean dispatch(Request request, Map<String, List<String>> map) {
        if (this.mIsInvalid || !isMatchUrlRules(request) || map.isEmpty()) {
            return false;
        }
        if (!this.mKeepQueryList.isEmpty()) {
            Map<? extends String, ? extends List<String>> linkedHashMap = new LinkedHashMap<>();
            if (map.containsKey("x-tt-encrypt-queries")) {
                linkedHashMap.put("x-tt-encrypt-queries", map.get("x-tt-encrypt-queries"));
            }
            for (String str : this.mKeepQueryList) {
                if (map.containsKey(str)) {
                    linkedHashMap.put(str, map.get(str));
                }
            }
            map.clear();
            map.putAll(linkedHashMap);
            return true;
        }
        if (this.mRemoveQueryList.isEmpty()) {
            return true;
        }
        Iterator<String> it = this.mRemoveQueryList.iterator();
        while (it.hasNext()) {
            map.remove(it.next());
        }
        String url = request.getUrl() != null ? request.getUrl() : "";
        if (!this.mNeedBackgroundRmMark || url.contains(KEY_BACKGROUND_MARK_PARAM)) {
            return true;
        }
        Iterator<String> it2 = this.mRemoveQueryList.iterator();
        while (it2.hasNext()) {
            if (url.contains(it2.next())) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(DiskLruCache.VERSION);
                map.put(KEY_BACKGROUND_MARK_PARAM, arrayList);
                return true;
            }
        }
        return true;
    }
}
