package com.lynx.animax.setting;

import com.lynx.animax.service.IAnimaXSettingService;
import com.lynx.animax.util.AnimaXLog;
import com.lynx.tasm.service.ILynxTrailService;
import com.lynx.tasm.service.LynxServiceCenter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class LynxAnimaXSettingService implements IAnimaXSettingService {
    private static final String TAG = "LynxAnimaXSettingService";
    private final ConcurrentHashMap<String, AnimaXSettingValue> mCache = new ConcurrentHashMap<>();

    public void clearCache() {
        this.mCache.clear();
    }

    @Override // com.lynx.animax.service.IAnimaXSettingService
    public AnimaXSettingValue getValueByKey(String str) {
        if (str == null) {
            return AnimaXSettingValue.empty();
        }
        AnimaXSettingValue animaXSettingValue = this.mCache.get(str);
        if (animaXSettingValue != null) {
            return animaXSettingValue;
        }
        AnimaXSettingValue retrieveValueFromService = retrieveValueFromService(str);
        AnimaXSettingValue putIfAbsent = this.mCache.putIfAbsent(str, retrieveValueFromService);
        return putIfAbsent != null ? putIfAbsent : retrieveValueFromService;
    }

    private AnimaXSettingValue retrieveValueFromService(String str) {
        Object objectValueForTrailKey;
        ILynxTrailService service = LynxServiceCenter.inst().getService(ILynxTrailService.class);
        if (service == null) {
            AnimaXLog.m2543w(TAG, "Trail service not available");
            return AnimaXSettingValue.empty();
        }
        try {
            objectValueForTrailKey = service.objectValueForTrailKey(str);
        } catch (Throwable th) {
            AnimaXLog.m2540e(TAG, "Failed to get value for key: " + str + ", message: " + th.getMessage());
        }
        if (objectValueForTrailKey == null) {
            return AnimaXSettingValue.empty();
        }
        if (objectValueForTrailKey instanceof String) {
            return AnimaXSettingValue.fromString((String) objectValueForTrailKey);
        }
        if (objectValueForTrailKey instanceof Collection) {
            return convertToStringCollection((Collection) objectValueForTrailKey);
        }
        AnimaXLog.m2543w(TAG, "Unsupported value type: " + objectValueForTrailKey.getClass().getName());
        return AnimaXSettingValue.empty();
    }

    private AnimaXSettingValue convertToStringCollection(Collection<?> collection) {
        if (collection.isEmpty()) {
            return AnimaXSettingValue.fromCollection(Collections.emptyList());
        }
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (next instanceof String) {
                arrayList.add((String) next);
            } else {
                AnimaXLog.m2543w(TAG, "Collection contains non-string element: " + (next != null ? next.getClass().getName() : "null"));
                return AnimaXSettingValue.fromCollection(Collections.emptyList());
            }
        }
        return AnimaXSettingValue.fromCollection(arrayList);
    }
}
