package com.bytedance.push.utils;

import android.net.Uri;
import java.util.ArrayList;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes4.dex */
public class Component {
    public String authorities;
    public List<IntentFilter> intentFilter = new ArrayList();
    public String name;
    public String permission;
    public String processName;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Component)) {
            return false;
        }
        Component component = (Component) obj;
        List<IntentFilter> list = this.intentFilter;
        if (list == null ? component.intentFilter != null : !list.equals(component.intentFilter)) {
            return false;
        }
        String str = this.name;
        if (str == null ? component.name != null : !str.equals(component.name)) {
            return false;
        }
        String str2 = this.processName;
        if (str2 == null ? component.processName != null : !str2.equals(component.processName)) {
            return false;
        }
        String str3 = this.permission;
        if (str3 == null ? component.permission != null : !str3.equals(component.permission)) {
            return false;
        }
        String str4 = this.authorities;
        String str5 = component.authorities;
        return str4 == null ? str5 == null : str4.equals(str5);
    }

    public int hashCode() {
        List<IntentFilter> list = this.intentFilter;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        String str = this.name;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.processName;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.permission;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.authorities;
        return hashCode4 + (str4 != null ? str4.hashCode() : 0);
    }

    public Component(String str) {
        this.name = str;
    }

    public String toString() {
        return "Component{name='" + this.name + "', intentFilter=" + this.intentFilter + ", processName='" + this.processName + "', permission='" + this.permission + "', authorities='" + this.authorities + "'}";
    }

    /* loaded from: classes4.dex */
    public static class IntentFilter {
        List<String> actions;
        List<String> categories;
        Uri data;
        String mimeType;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof IntentFilter)) {
                return false;
            }
            IntentFilter intentFilter = (IntentFilter) obj;
            List<String> list = this.actions;
            if (list == null ? intentFilter.actions != null : !list.equals(intentFilter.actions)) {
                return false;
            }
            List<String> list2 = this.categories;
            if (list2 == null ? intentFilter.categories != null : !list2.equals(intentFilter.categories)) {
                return false;
            }
            String str = this.mimeType;
            if (str == null ? intentFilter.mimeType != null : !str.equals(intentFilter.mimeType)) {
                return false;
            }
            Uri uri = this.data;
            Uri uri2 = intentFilter.data;
            return uri != null ? uri.equals(uri2) : uri2 == null;
        }

        public String toString() {
            return "IntentFilter{actions=" + this.actions + ", categories=" + this.categories + ", data=" + this.data + ", mimetype=" + this.mimeType + AbstractJsonLexerKt.END_OBJ;
        }

        public int hashCode() {
            List<String> list = this.actions;
            int hashCode = (list != null ? list.hashCode() : 0) * 31;
            List<String> list2 = this.categories;
            int hashCode2 = (hashCode + (list2 != null ? list2.hashCode() : 0)) * 31;
            String str = this.mimeType;
            int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 31;
            Uri uri = this.data;
            return hashCode3 + (uri != null ? uri.hashCode() : 0);
        }

        public IntentFilter(List<String> list, List<String> list2, String str) {
            this.actions = list;
            this.categories = list2;
            this.mimeType = str;
        }

        public IntentFilter(List<String> list, List<String> list2, Uri uri) {
            this.actions = list;
            this.categories = list2;
            this.data = uri;
        }

        public IntentFilter(List<String> list, List<String> list2) {
            this.actions = list;
            this.categories = list2;
        }

        public IntentFilter(List<String> list) {
            this(list, null);
        }
    }

    private static boolean equalsInternal(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    /* loaded from: classes4.dex */
    public static class Builder {
        private Component component;

        public Builder(String str) {
            this.component = new Component(str);
        }

        public Builder setProcess(String str) {
            this.component.processName = str;
            return this;
        }

        public Builder setPermission(String str) {
            this.component.permission = str;
            return this;
        }

        public Builder addIntentFilter(IntentFilter intentFilter) {
            if (intentFilter == null) {
                return this;
            }
            this.component.intentFilter.add(intentFilter);
            return this;
        }

        public Builder setAuthorities(String str) {
            this.component.authorities = str;
            return this;
        }

        public Component build() {
            return this.component;
        }

        public static Builder create(String str) {
            return new Builder(str);
        }
    }
}
