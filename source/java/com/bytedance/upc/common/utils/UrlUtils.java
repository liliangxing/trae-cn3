package com.bytedance.upc.common.utils;

import android.util.Pair;
import com.bytedance.common.utility.NetworkUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public class UrlUtils {
    public static String addUrlParam(String str, Map<String, String> map) {
        ArrayList arrayList = new ArrayList();
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                arrayList.add(new Pair(entry.getKey(), entry.getValue()));
            }
        }
        return addUrlParam(str, arrayList);
    }

    public static String addUrlParam(String str, List<Pair<String, String>> list) {
        StringBuilder sb = new StringBuilder(str);
        if (str.indexOf(63) < 0) {
            sb.append("?");
        } else {
            sb.append(ContainerUtils.FIELD_DELIMITER);
        }
        sb.append(NetworkUtils.format(list, "UTF-8"));
        return sb.toString();
    }
}
