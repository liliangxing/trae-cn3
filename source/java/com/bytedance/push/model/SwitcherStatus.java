package com.bytedance.push.model;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class SwitcherStatus {
    private Map<String, Object> extra;
    private List<ChildSwitcher> switchers;

    public List<ChildSwitcher> getSwitchers() {
        return this.switchers;
    }

    public void setSwitchers(List<ChildSwitcher> list) {
        this.switchers = list;
    }

    public void setExtra(Map<String, Object> map) {
        this.extra = map;
    }

    public void setExtra(String str, Object obj) {
        if (this.extra == null) {
            this.extra = new HashMap();
        }
        this.extra.put(str, obj);
    }

    public Map<String, Object> getExtra() {
        return this.extra;
    }

    public void addSwitcher(ChildSwitcher childSwitcher) {
        if (childSwitcher == null) {
            this.switchers = null;
            return;
        }
        if (this.switchers == null) {
            this.switchers = new ArrayList();
        }
        this.switchers.add(childSwitcher);
    }

    public String extraToJson() {
        if (this.extra == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, Object> entry : this.extra.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public String switcherToJson() {
        ArrayList<ChildSwitcher> arrayList = this.switchers == null ? null : new ArrayList(this.switchers);
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (ChildSwitcher childSwitcher : arrayList) {
            if (childSwitcher != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("is_close", childSwitcher.isOpen ? 0 : 1);
                    jSONObject.put("name", childSwitcher.tag);
                    JSONObject jSONObject2 = new JSONObject();
                    if (childSwitcher.extra != null) {
                        for (Map.Entry entry : childSwitcher.extra.entrySet()) {
                            jSONObject2.put((String) entry.getKey(), entry.getValue());
                        }
                    }
                    jSONObject.put("extra", jSONObject2);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                jSONArray.put(jSONObject);
            }
        }
        return jSONArray.toString();
    }

    public void checkValid() throws IllegalArgumentException {
        ArrayList<ChildSwitcher> arrayList = this.switchers == null ? null : new ArrayList(this.switchers);
        if (arrayList != null) {
            for (ChildSwitcher childSwitcher : arrayList) {
                if (childSwitcher == null || TextUtils.isEmpty(childSwitcher.tag)) {
                    throw new IllegalArgumentException("wrong config : " + childSwitcher);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class ChildSwitcher {
        private Map<String, Object> extra;
        private boolean isOpen;
        private String tag;

        public ChildSwitcher(String str, boolean z, Map<String, Object> map) {
            this.tag = str;
            this.isOpen = z;
            this.extra = map;
        }

        public String getTag() {
            return this.tag;
        }

        public void setTag(String str) {
            this.tag = str;
        }

        public boolean isOpen() {
            return this.isOpen;
        }

        public void setOpen(boolean z) {
            this.isOpen = z;
        }

        public Map<String, Object> getExtra() {
            return this.extra;
        }

        public void setExtra(Map<String, Object> map) {
            this.extra = map;
        }

        public void setExtra(String str, Object obj) {
            if (this.extra == null) {
                this.extra = new HashMap();
            }
            this.extra.put(str, obj);
        }

        public String toString() {
            return "ChildSwitcher{tag='" + this.tag + "', isOpen=" + this.isOpen + ", extra=" + this.extra + AbstractJsonLexerKt.END_OBJ;
        }
    }

    /* loaded from: classes4.dex */
    public static class TimeStamp {
        private int hour;
        private int minute;

        public TimeStamp(int i, int i2) {
            this.hour = i;
            this.minute = i2;
        }

        public int getHour() {
            return this.hour;
        }

        public void setHour(int i) {
            this.hour = i;
        }

        public int getMinute() {
            return this.minute;
        }

        public void setMinute(int i) {
            this.minute = i;
        }

        String format() {
            return String.format(Locale.getDefault(), "%02d:%02d", Integer.valueOf(this.hour), Integer.valueOf(this.minute));
        }

        public String toString() {
            return format();
        }
    }
}
