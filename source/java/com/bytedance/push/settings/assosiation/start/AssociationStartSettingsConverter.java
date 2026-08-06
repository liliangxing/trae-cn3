package com.bytedance.push.settings.assosiation.start;

import android.text.TextUtils;
import com.bytedance.push.settings.IDefaultValueProvider;
import com.bytedance.push.settings.ITypeConverter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class AssociationStartSettingsConverter implements ITypeConverter<AssociationStartSettingsModel>, IDefaultValueProvider<AssociationStartSettingsModel> {
    private final String ENABLE_ASSOCIATION_HOOK = "enable_association_hook";
    private final String ENABLE_ASSOCIATION_START_MONITOR = "enable_association_start_monitor";
    private final String ENABLE_ASSOCIATION_START_INTERCEPT = "enable_association_start_intercept";
    private final String INTERCEPT_COMPONENT_WHITE_LIST = "intercept_component_white_list";
    private final String INTERCEPT_COMPONENT_BLACK_LIST = "intercept_component_black_list";
    private final String ISOLATION_INTERCEPT_COMPONENT_BLACK_LIST = "isolation_intercept_component_black_list";
    private final String MONITOR_COMPONENT_BLACK_LIST = "monitor_component_black_list";
    private final String ISOLATION_REDIRECT_COMPONENT_MAP = "isolation_redirect_component_map";

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.push.settings.ITypeConverter
    public AssociationStartSettingsModel to(String str) {
        AssociationStartSettingsModel create = create();
        try {
            JSONObject jSONObject = new JSONObject(str);
            create.enableAssociationHook = jSONObject.optBoolean("enable_association_hook");
            create.enableAssociationStartMonitor = jSONObject.optBoolean("enable_association_start_monitor");
            create.enableAssociationStartIntercept = jSONObject.optBoolean("enable_association_start_intercept");
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("monitor_component_black_list");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    arrayList.add((String) optJSONArray.get(i));
                }
            }
            create.monitorComponentBlackList = arrayList;
            ArrayList arrayList2 = new ArrayList();
            JSONArray optJSONArray2 = jSONObject.optJSONArray("intercept_component_white_list");
            if (optJSONArray2 != null) {
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    arrayList2.add((String) optJSONArray2.get(i2));
                }
            }
            create.interceptComponentWhiteList = arrayList2;
            ArrayList arrayList3 = new ArrayList();
            JSONArray optJSONArray3 = jSONObject.optJSONArray("intercept_component_black_list");
            if (optJSONArray3 != null) {
                for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                    arrayList3.add((String) optJSONArray3.get(i3));
                }
            }
            create.interceptComponentBlackList = arrayList3;
            ArrayList arrayList4 = new ArrayList();
            JSONArray optJSONArray4 = jSONObject.optJSONArray("isolation_intercept_component_black_list");
            if (optJSONArray4 != null) {
                for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                    arrayList4.add((String) optJSONArray4.get(i4));
                }
            }
            create.isolationInterceptComponentBlackList = arrayList4;
            HashMap hashMap = new HashMap();
            JSONObject optJSONObject = jSONObject.optJSONObject("isolation_redirect_component_map");
            if (optJSONObject != null) {
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    String optString = optJSONObject.optString(next);
                    if (!TextUtils.isEmpty(optString)) {
                        hashMap.put(next, optString);
                    }
                }
            }
            create.isolationRedirectMap = hashMap;
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return create;
    }

    @Override // com.bytedance.push.settings.ITypeConverter
    public String from(AssociationStartSettingsModel associationStartSettingsModel) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("enable_association_hook", associationStartSettingsModel.enableAssociationHook);
            jSONObject.put("enable_association_start_monitor", associationStartSettingsModel.enableAssociationStartMonitor);
            jSONObject.put("enable_association_start_intercept", associationStartSettingsModel.enableAssociationStartIntercept);
            JSONArray jSONArray = new JSONArray();
            if (associationStartSettingsModel.monitorComponentBlackList != null) {
                Iterator<String> it = associationStartSettingsModel.monitorComponentBlackList.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next());
                }
            }
            jSONObject.put("monitor_component_black_list", jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            if (associationStartSettingsModel.interceptComponentWhiteList != null) {
                Iterator<String> it2 = associationStartSettingsModel.interceptComponentWhiteList.iterator();
                while (it2.hasNext()) {
                    jSONArray2.put(it2.next());
                }
            }
            jSONObject.put("intercept_component_white_list", jSONArray2);
            JSONArray jSONArray3 = new JSONArray();
            if (associationStartSettingsModel.interceptComponentBlackList != null) {
                Iterator<String> it3 = associationStartSettingsModel.interceptComponentBlackList.iterator();
                while (it3.hasNext()) {
                    jSONArray3.put(it3.next());
                }
            }
            jSONObject.put("intercept_component_black_list", jSONArray3);
            JSONArray jSONArray4 = new JSONArray();
            if (associationStartSettingsModel.isolationInterceptComponentBlackList != null) {
                Iterator<String> it4 = associationStartSettingsModel.isolationInterceptComponentBlackList.iterator();
                while (it4.hasNext()) {
                    jSONArray4.put(it4.next());
                }
            }
            jSONObject.put("isolation_intercept_component_black_list", jSONArray4);
            JSONObject jSONObject2 = new JSONObject();
            for (Map.Entry<String, String> entry : associationStartSettingsModel.isolationRedirectMap.entrySet()) {
                jSONObject2.put(entry.getKey(), entry.getValue());
            }
            jSONObject.put("isolation_redirect_component_map", jSONObject2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject.toString();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.push.settings.IDefaultValueProvider
    public AssociationStartSettingsModel create() {
        return new AssociationStartSettingsModel();
    }
}
