package com.bytedance.pia.core.misc;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.pia.core.utils.UrlUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class UrlMatcher {
    public static final String DELIMITER = "/";
    public static final String EXTRACTOR = "^";
    private static final String OUT_PREFIX = "pia_page";
    private static final String SCHEME = "https://";
    public static final String WILDCARD = "*";
    private final Trie<String, UrlInfo> trie = new Trie<>(WILDCARD);
    private final LRUCache<Uri, String> cache = new LRUCache<>(16);

    public boolean addRule(String str) {
        UrlInfo createInfo;
        if (TextUtils.isEmpty(str) || (createInfo = UrlInfo.createInfo(Uri.parse(SCHEME + str))) == null) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        for (String str2 : createInfo.words) {
            if (str2.startsWith(EXTRACTOR)) {
                arrayList.add(str2.substring(1));
            } else {
                arrayList.add(str2);
            }
        }
        this.trie.insert(arrayList, createInfo);
        this.cache.clear();
        return true;
    }

    public String match(Uri uri) {
        UrlInfo search;
        String str = this.cache.get(uri);
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        UrlInfo createInfo = UrlInfo.createInfo(uri);
        if (createInfo == null || (search = this.trie.search(createInfo.words)) == null) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder(OUT_PREFIX);
            for (int i = 0; i < createInfo.words.size(); i++) {
                if (search.words.get(i).startsWith(EXTRACTOR)) {
                    sb.append("/");
                    sb.append(createInfo.words.get(i));
                }
            }
            if (search.queries != null) {
                Iterator<String> it = search.queries.iterator();
                while (it.hasNext()) {
                    String queryParameter = uri.getQueryParameter(it.next());
                    if (!TextUtils.isEmpty(queryParameter)) {
                        sb.append("/");
                        sb.append(queryParameter);
                    }
                }
            }
            String sb2 = sb.toString();
            if (sb2.equals(OUT_PREFIX)) {
                return null;
            }
            this.cache.put(uri, sb2);
            return sb2;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    private static class UrlInfo {
        final List<String> queries;
        final List<String> words;

        UrlInfo(List<String> list, List<String> list2) {
            this.words = list;
            this.queries = list2;
        }

        static UrlInfo createInfo(Uri uri) {
            List<String> hostSegments = UrlUtils.getHostSegments(uri);
            if (hostSegments.isEmpty()) {
                return null;
            }
            hostSegments.add("/");
            hostSegments.addAll(UrlUtils.getPathFullSegments(uri));
            Set<String> queryParameterNames = uri.getQueryParameterNames();
            if (queryParameterNames.isEmpty()) {
                return new UrlInfo(hostSegments, null);
            }
            return new UrlInfo(hostSegments, new ArrayList(queryParameterNames));
        }
    }
}
