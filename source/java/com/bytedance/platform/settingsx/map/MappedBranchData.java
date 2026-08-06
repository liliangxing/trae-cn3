package com.bytedance.platform.settingsx.map;

import com.bytedance.platform.settingsx.api.map.MappedData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;

/* loaded from: classes4.dex */
public class MappedBranchData extends MappedData {
    private List<Integer> childrenHashPtr;
    private String value;

    public List<Integer> getChildrenHashPtr() {
        return this.childrenHashPtr;
    }

    public String getValue() {
        return this.value;
    }

    public MappedBranchData(int i, String str, String str2, List<Integer> list) {
        super(i, str);
        this.childrenHashPtr = list;
        this.value = str2;
    }

    public static MappedBranchData getInstance(int i, String str, String str2, Set<String> set, String str3, String str4) {
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf((str3 + str4 + it.next()).hashCode()));
        }
        return new MappedBranchData(i, str, str2, arrayList);
    }

    public static MappedBranchData getInstance(int i, String str, String str2, JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            arrayList.add(Integer.valueOf(jSONArray.optInt(i2)));
        }
        return new MappedBranchData(i, str, str2, arrayList);
    }

    public static MappedBranchData getInstance(int i, String str, String str2, List<Integer> list) {
        return new MappedBranchData(i, str, str2, list);
    }

    public static JSONArray getChildrenJson(MappedBranchData mappedBranchData) {
        List<Integer> list = mappedBranchData.childrenHashPtr;
        if (list == null || list.size() == 0) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<Integer> it = mappedBranchData.childrenHashPtr.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().intValue());
        }
        return jSONArray;
    }
}
