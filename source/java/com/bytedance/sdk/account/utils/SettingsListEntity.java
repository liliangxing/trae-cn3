package com.bytedance.sdk.account.utils;

import android.text.TextUtils;
import android.util.Log;
import java.util.Collection;
import java.util.HashSet;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONArray;

/* loaded from: classes5.dex */
public class SettingsListEntity {
    private static final String TAG = "SettingsListEntity";
    private final Collection<String> defaultSettings;
    private final Collection<String> local;
    private final Collection<String> settings;
    private final Collection<String> total;
    private final boolean useHashSet;

    public SettingsListEntity(Collection<String> collection, boolean z) {
        this.useHashSet = z;
        collection = collection == null ? new HashSet<>() : collection;
        this.defaultSettings = collection;
        if (z) {
            this.local = new HashSet();
            this.settings = new HashSet();
            this.total = new HashSet();
        } else {
            this.local = new CopyOnWriteArraySet();
            this.settings = new CopyOnWriteArraySet();
            this.total = new CopyOnWriteArraySet();
        }
        if (collection.isEmpty()) {
            return;
        }
        this.settings.addAll(collection);
        this.total.addAll(this.settings);
    }

    public void addLocal(Collection<String> collection) {
        if (this.useHashSet) {
            synchronized (this) {
                realAddLocal(collection);
            }
        } else {
            realAddLocal(collection);
        }
    }

    private void realAddLocal(Collection<String> collection) {
        this.local.addAll(collection);
        refreshTotal();
    }

    public void clearLocal() {
        if (this.useHashSet) {
            synchronized (this) {
                realClearLocal();
            }
        } else {
            realClearLocal();
        }
    }

    private void realClearLocal() {
        this.local.clear();
        refreshTotal();
    }

    public void updateSettings(JSONArray jSONArray) {
        if (this.useHashSet) {
            synchronized (this) {
                realUpdateSettings(jSONArray);
            }
        } else {
            realUpdateSettings(jSONArray);
        }
    }

    private void realUpdateSettings(JSONArray jSONArray) {
        this.settings.clear();
        HashSet<String> jsonArrayToHashSet = jsonArrayToHashSet(jSONArray);
        if (jsonArrayToHashSet == null) {
            this.settings.addAll(this.defaultSettings);
        } else {
            this.settings.addAll(jsonArrayToHashSet);
        }
        refreshTotal();
    }

    public Collection<String> getTotal() {
        return this.total;
    }

    private void refreshTotal() {
        if (this.useHashSet) {
            synchronized (this) {
                realRefreshTotal();
            }
        } else {
            realRefreshTotal();
        }
    }

    private void realRefreshTotal() {
        Log.d(TAG, "realRefreshTotal");
        this.total.clear();
        this.total.addAll(this.local);
        this.total.addAll(this.settings);
    }

    private static HashSet<String> jsonArrayToHashSet(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        HashSet<String> hashSet = new HashSet<>();
        for (int i = 0; i < jSONArray.length(); i++) {
            String optString = jSONArray.optString(i, "");
            if (!TextUtils.isEmpty(optString)) {
                hashSet.add(optString);
            }
        }
        return hashSet;
    }
}
