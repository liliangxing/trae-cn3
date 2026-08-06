package com.ss.mediakit.image;

import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public final class LoaderConfig {
    static final String TAG = "Image.Loader.Config";
    AtomicBoolean parsed = new AtomicBoolean(false);
    AtomicBoolean enable = new AtomicBoolean(false);
    boolean enableWhiteList = true;
    boolean enableBlockList = false;
    Map<String, ItemConfig> configs = new LinkedHashMap();
    private volatile ArrayList<Integer> mDefaultMDLConnectTimeOut = new ArrayList<>(Arrays.asList(3000, 5000, 15000));
    private volatile ArrayList<Integer> mDefaultMDLReadTimeOut = new ArrayList<>(Arrays.asList(3000, 5000, 15000));
    private volatile int mDefaultMDLDelayMs = 500;
    private volatile ArrayList<Integer> mConnectTimeOut = null;
    private volatile ArrayList<Integer> mReadTimeOut = null;
    private volatile int mBaseDelayMs = 0;

    public boolean check(String str, String str2, String str3) {
        if (!this.enable.get()) {
            Log.i(TAG, "check enable: " + str + ", " + str2 + ", " + str3 + ", " + this.enable.get());
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            Log.i(TAG, "check biz: " + str + ", " + str2 + ", " + str3 + ", " + this.enable.get());
            return !this.enableWhiteList;
        }
        ItemConfig itemConfig = this.configs.get(str);
        if (this.enableWhiteList) {
            if (itemConfig == null) {
                return false;
            }
            boolean z = !itemConfig.enableScene;
            boolean z2 = !itemConfig.enableSource;
            if (itemConfig.enableScene) {
                z = !TextUtils.isEmpty(str2) && itemConfig.scenes.contains(str2);
            }
            if (itemConfig.enableSource) {
                z2 = !TextUtils.isEmpty(str3) && itemConfig.sources.contains(str3);
            }
            Log.i(TAG, "check white: " + str + ", " + str2 + ", " + str3 + ", " + this.enable.get() + ", " + z + ", " + z2);
            return z && z2;
        }
        if (!this.enableBlockList) {
            return this.enable.get();
        }
        if (itemConfig == null) {
            return true;
        }
        boolean z3 = !itemConfig.enableScene;
        boolean z4 = !itemConfig.enableSource;
        if (itemConfig.enableScene) {
            z3 = !TextUtils.isEmpty(str2) && itemConfig.scenes.contains(str2);
        }
        if (itemConfig.enableSource) {
            z4 = !TextUtils.isEmpty(str3) && itemConfig.sources.contains(str3);
        }
        Log.i(TAG, "check block: " + str + ", " + str2 + ", " + str3 + ", " + this.enable.get() + ", " + z3 + ", " + z4);
        return (z3 || z4) ? false : true;
    }

    public void initTimeOut(String str) {
        ItemConfig itemConfig = this.configs.get(str);
        if (itemConfig == null) {
            return;
        }
        this.mConnectTimeOut = itemConfig.connectTimeOut;
        this.mReadTimeOut = itemConfig.readTimeOut;
        this.mBaseDelayMs = itemConfig.baseDelayMs;
    }

    public int getConnectTimeOut(int i) {
        if (this.mConnectTimeOut == null || this.mConnectTimeOut.isEmpty()) {
            ArrayList<Integer> arrayList = this.mDefaultMDLConnectTimeOut;
            if (i >= this.mDefaultMDLConnectTimeOut.size()) {
                i = this.mDefaultMDLConnectTimeOut.size() - 1;
            }
            return arrayList.get(i).intValue();
        }
        ArrayList<Integer> arrayList2 = this.mConnectTimeOut;
        if (i >= this.mConnectTimeOut.size()) {
            i = this.mConnectTimeOut.size() - 1;
        }
        return arrayList2.get(i).intValue();
    }

    public int getReadTimeOut(int i) {
        if (this.mReadTimeOut == null || this.mReadTimeOut.isEmpty()) {
            ArrayList<Integer> arrayList = this.mDefaultMDLReadTimeOut;
            if (i >= this.mDefaultMDLReadTimeOut.size()) {
                i = this.mDefaultMDLReadTimeOut.size() - 1;
            }
            return arrayList.get(i).intValue();
        }
        ArrayList<Integer> arrayList2 = this.mReadTimeOut;
        if (i >= this.mReadTimeOut.size()) {
            i = this.mReadTimeOut.size() - 1;
        }
        return arrayList2.get(i).intValue();
    }

    public int getBaseDelayMs() {
        if (this.mBaseDelayMs == 0) {
            return this.mDefaultMDLDelayMs;
        }
        return this.mBaseDelayMs;
    }

    public void parse(String str) {
        Log.i(TAG, "configString: " + str);
        boolean z = true;
        if (this.parsed.getAndSet(true)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.enableWhiteList = jSONObject.optBoolean("enable_white_list");
            this.enableBlockList = jSONObject.optBoolean("enable_block_list");
            Log.i(TAG, "enableWhiteList: " + this.enableWhiteList + ", enableBlockList: " + this.enableBlockList);
            AtomicBoolean atomicBoolean = this.enable;
            if (!this.enableWhiteList && !this.enableBlockList) {
                z = false;
            }
            atomicBoolean.set(z);
            JSONObject optJSONObject = jSONObject.optJSONObject("config");
            if (optJSONObject != null) {
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject(next);
                    if (optJSONObject2 != null) {
                        ItemConfig itemConfig = new ItemConfig();
                        itemConfig.enableSource = optJSONObject2.optBoolean("enable_source");
                        itemConfig.enableScene = optJSONObject2.optBoolean("enable_scene");
                        itemConfig.baseDelayMs = optJSONObject2.optInt("base_delay_ms", 500);
                        Log.i(TAG, "enableSource: " + itemConfig.enableSource + ", enableScene: " + itemConfig.enableScene + ", baseDelayMs: " + itemConfig.baseDelayMs);
                        JSONArray optJSONArray = optJSONObject2.optJSONArray("sources");
                        if (optJSONArray != null && optJSONArray.length() > 0) {
                            for (int i = 0; i < optJSONArray.length(); i++) {
                                String optString = optJSONArray.optString(i);
                                if (!TextUtils.isEmpty(optString)) {
                                    itemConfig.sources.add(optString);
                                }
                            }
                        }
                        JSONArray optJSONArray2 = optJSONObject2.optJSONArray("scenes");
                        if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                                String optString2 = optJSONArray2.optString(i2);
                                if (!TextUtils.isEmpty(optString2)) {
                                    itemConfig.scenes.add(optString2);
                                }
                            }
                        }
                        JSONArray optJSONArray3 = optJSONObject2.optJSONArray("readtimeout");
                        if (optJSONArray3 != null && optJSONArray3.length() > 0) {
                            for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                                int optInt = optJSONArray3.optInt(i3);
                                if (optInt > 0) {
                                    itemConfig.readTimeOut.add(Integer.valueOf(optInt));
                                    Log.i(TAG, "add readTimeOut: " + optInt);
                                }
                            }
                        }
                        JSONArray optJSONArray4 = optJSONObject2.optJSONArray("connectTimeOut");
                        if (optJSONArray4 != null && optJSONArray4.length() > 0) {
                            for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                                int optInt2 = optJSONArray4.optInt(i4);
                                if (optInt2 > 0) {
                                    itemConfig.connectTimeOut.add(Integer.valueOf(optInt2));
                                    Log.i(TAG, "add connectTimeOut: " + optInt2);
                                }
                            }
                        }
                        this.configs.put(next, itemConfig);
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* loaded from: classes7.dex */
    static class ItemConfig {
        boolean enableScene = false;
        boolean enableSource = false;
        int baseDelayMs = 500;
        List<String> scenes = new LinkedList();
        List<String> sources = new LinkedList();
        ArrayList<Integer> connectTimeOut = new ArrayList<>();
        ArrayList<Integer> readTimeOut = new ArrayList<>();

        ItemConfig() {
        }
    }
}
