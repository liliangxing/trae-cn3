package com.bytedance.ttnet.cronet;

import com.bytedance.common.utility.Logger;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

/* loaded from: classes4.dex */
public class CronetDataStorageAccess extends Observable {
    public static final String LOGID = "logid";
    public static final String REGION_LEGACY_USER = "region_legacy_user";
    public static final String REGION_SOURCE = "region_source";
    public static final String SEC_UID = "sec_uid";
    public static final String STORE_IDC = "store_idc";
    public static final String STORE_REGION = "store_region";
    private static final String TAG = "CronetDataStorageAccess";
    private static volatile CronetDataStorageAccess sInstance = null;
    private static volatile String sRegionLegacyUser = "";
    private static volatile String sRegionSource = "";
    private static volatile String sSecUid = "";
    private static volatile String sUserIdc = "";
    private static volatile String sUserRegion = "";

    public static CronetDataStorageAccess inst() {
        if (sInstance == null) {
            synchronized (CronetDataStorageAccess.class) {
                if (sInstance == null) {
                    sInstance = new CronetDataStorageAccess();
                }
            }
        }
        return sInstance;
    }

    public void onStoreIdcChanged(String str, String str2, String str3, String str4, String str5, String str6) {
        if (Logger.debug()) {
            Logger.d(TAG, "onStoreIdcChanged idc: " + str + " region: " + str2 + " source: " + str3 + " sec_uid:" + str5 + " logid:" + str6);
        }
        sUserIdc = str;
        sUserRegion = str2;
        sRegionSource = str3;
        sRegionLegacyUser = str4;
        sSecUid = str5;
        HashMap hashMap = new HashMap();
        hashMap.put(STORE_IDC, str);
        hashMap.put(STORE_REGION, str2);
        hashMap.put(REGION_SOURCE, str3);
        hashMap.put(REGION_LEGACY_USER, str4);
        hashMap.put("sec_uid", str5);
        hashMap.put("logid", str6);
        notifyCronetDataObservers(hashMap);
    }

    private void notifyCronetDataObservers(Map<String, Object> map) {
        setChanged();
        notifyObservers(map);
    }

    public static String getUserIdc() {
        return sUserIdc;
    }

    public static String getUserRegion() {
        return sUserRegion;
    }

    public static String getRegionSource() {
        return sRegionSource;
    }

    public static String getRegionLegacyUser() {
        return sRegionLegacyUser;
    }

    public static String getSecUid() {
        return sSecUid;
    }
}
