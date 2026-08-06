package com.bytedance.webx.addr;

import android.net.Uri;
import com.bytedance.webx.WebXEnv;
import com.bytedance.webx.base.logger.WLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class AddressParam {
    public static final String BDWK_CREATE = "bdwk_create";
    public static final String BDWK_EXTENSION = "bdwk_extension";
    public static final int FROM_CHANGE_PAGE_URL = 1;
    public static final int FROM_CREATE_CONTAINER = 0;
    public static final String SETTING_BDWK_EXTENSION = "bdwk_extension";
    public static final String SETTING_BDWK_EXTENSION_CONTENT = "content";
    public static final String SETTING_BDWK_EXTENSION_PATTERN = "pattern";
    private static final String TAG = "AddressParam";
    public static final String TYPE_APPROVE = "1";
    public static final String TYPE_DISAPPROVE = "0";
    private Map<String, BdwkParamItem> mBdwkParamItems = new HashMap();

    /* loaded from: classes6.dex */
    public static class BdwkParamItem {
        public String name;
        public String type;

        public BdwkParamItem(String str, String str2) {
            this.name = str;
            this.type = str2;
        }
    }

    /* loaded from: classes6.dex */
    public static class UriMatcher implements WebXEnv.Builder.IUrlMatcherConfig {
        private volatile List<UrlMatchConfigItem> mUrlMatchConfigItem;
        private WebXEnv.Builder.IUrlMatcherConfig mUrlMatcherConfigDelegate;

        /* loaded from: classes6.dex */
        public static class UrlMatchConfigItem {
            public String bdwkExtension;
            public String pattern;
            private Pattern patternObj;

            public UrlMatchConfigItem(String str, String str2) {
                this.pattern = str;
                this.bdwkExtension = str2;
            }

            public Matcher matcher(Uri uri) {
                if (this.patternObj == null) {
                    this.patternObj = Pattern.compile(this.pattern);
                }
                return this.patternObj.matcher(uri.toString());
            }
        }

        public UriMatcher(WebXEnv.Builder.IUrlMatcherConfig iUrlMatcherConfig) {
            this.mUrlMatcherConfigDelegate = iUrlMatcherConfig;
        }

        @Override // com.bytedance.webx.WebXEnv.Builder.IUrlMatcherConfig
        public String getConfig() {
            return this.mUrlMatcherConfigDelegate.getConfig();
        }

        public void initUrlMatcher() {
            if (this.mUrlMatchConfigItem == null) {
                synchronized (this) {
                    if (this.mUrlMatchConfigItem == null) {
                        this.mUrlMatchConfigItem = new ArrayList();
                        String config = getConfig();
                        if (config == null) {
                            return;
                        }
                        try {
                            JSONArray optJSONArray = new JSONObject(config).optJSONArray("bdwk_extension");
                            for (int i = 0; i < optJSONArray.length(); i++) {
                                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                                this.mUrlMatchConfigItem.add(new UrlMatchConfigItem(optJSONObject.optString(AddressParam.SETTING_BDWK_EXTENSION_PATTERN), optJSONObject.optString("content")));
                            }
                        } catch (Exception e) {
                            WLog.e(AddressParam.TAG, "", e);
                        }
                    }
                }
            }
        }

        public String match(Uri uri) {
            initUrlMatcher();
            Iterator<UrlMatchConfigItem> it = this.mUrlMatchConfigItem.iterator();
            while (true) {
                try {
                } catch (Exception e) {
                    WLog.e(AddressParam.TAG, e.toString());
                }
                if (it.hasNext()) {
                    UrlMatchConfigItem next = it.next();
                    Matcher matcher = next.matcher(uri);
                    while (matcher.find()) {
                        WLog.d(AddressParam.TAG, "match str = " + matcher.group() + " matcher.start() " + matcher.start());
                        if (matcher.start() == 0) {
                            return next.bdwkExtension;
                        }
                    }
                } else if (!it.hasNext()) {
                    return null;
                }
            }
        }
    }

    public static String parseUriMatch(HashSet<UriMatcher> hashSet, Uri uri) {
        if (hashSet == null) {
            return null;
        }
        try {
            Iterator<UriMatcher> it = hashSet.iterator();
            while (it.hasNext()) {
                String match = it.next().match(uri);
                if (match != null) {
                    return match;
                }
            }
        } catch (Exception e) {
            WLog.e(TAG, "", e);
        }
        return null;
    }

    public static List<BdwkParamItem> parseParam(int i, String str) {
        ArrayList arrayList = new ArrayList();
        if (str == null) {
            return arrayList;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (i == 0) {
                JSONObject optJSONObject = jSONObject.optJSONObject(BDWK_CREATE);
                if (optJSONObject != null) {
                    Iterator<String> keys = optJSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        arrayList.add(new BdwkParamItem(next, optJSONObject.optString(next)));
                    }
                }
            } else if (i == 1) {
                Iterator<String> keys2 = jSONObject.keys();
                while (keys2.hasNext()) {
                    String next2 = keys2.next();
                    if (!next2.equals(BDWK_CREATE)) {
                        arrayList.add(new BdwkParamItem(next2, jSONObject.optString(next2)));
                    }
                }
            }
        } catch (Exception e) {
            WLog.e(TAG, "", e);
        }
        return arrayList;
    }

    public void pickMerge(AddressParam addressParam) {
        for (Map.Entry<String, BdwkParamItem> entry : addressParam.mBdwkParamItems.entrySet()) {
            if (!this.mBdwkParamItems.containsKey(entry.getKey())) {
                this.mBdwkParamItems.put(entry.getKey(), entry.getValue());
            }
        }
    }

    public void add(BdwkParamItem bdwkParamItem) {
        this.mBdwkParamItems.put(bdwkParamItem.name, bdwkParamItem);
    }

    public void clear() {
        this.mBdwkParamItems.clear();
    }

    public boolean isEmpty() {
        return this.mBdwkParamItems.isEmpty();
    }

    public Boolean getApprove(String str) {
        BdwkParamItem bdwkParamItem = this.mBdwkParamItems.get(str);
        if (bdwkParamItem == null || bdwkParamItem.type == null) {
            return null;
        }
        String str2 = bdwkParamItem.type;
        str2.hashCode();
        if (!str2.equals("0") && str2.equals("1")) {
            return true;
        }
        return false;
    }
}
