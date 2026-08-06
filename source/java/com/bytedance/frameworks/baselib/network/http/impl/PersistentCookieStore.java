package com.bytedance.frameworks.baselib.network.http.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.common.utility.concurrent.ThreadPlus;
import com.bytedance.common.utility.persistent.SharedPrefsEditorCompat;
import com.bytedance.librarian.LibrarianImpl;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public class PersistentCookieStore implements CookieStore {
    private static final String SP_COOKIE_STORE = "cookieStore";
    private static final String SP_KEY_DELIMITER = "|";
    private static final String SP_KEY_DELIMITER_REGEX = "\\|";
    private static final String TAG = "PersistentCookieStore";
    private static final Map<String, String> memoryStore = new LinkedHashMap();
    private static String sCustomizedCookieStoreName;
    private final Map<URI, Set<SerializableHttpCookie>> allCookies = new LinkedHashMap();
    private final SharedPreferences cookieStore;

    public static void useCustomizedCookieStoreName() {
        sCustomizedCookieStoreName = "ttnetCookieStore";
    }

    public PersistentCookieStore(Context context) {
        String str = sCustomizedCookieStoreName;
        SharedPreferences sharedPreferences = context.getSharedPreferences(str == null ? SP_COOKIE_STORE : str, 4);
        this.cookieStore = sharedPreferences;
        loadAllFromPersistence(sharedPreferences.getAll(), true);
        loadAllFromPersistence(memoryStore, false);
    }

    private synchronized void loadAllFromPersistence(Map<String, ?> map, boolean z) {
        if (map != null) {
            if (!map.isEmpty()) {
                try {
                    for (Map.Entry<String, ?> entry : map.entrySet()) {
                        try {
                            URI uri = new URI(entry.getKey().split(SP_KEY_DELIMITER_REGEX, 2)[0]);
                            SerializableHttpCookie decode = SerializableHttpCookie.decode((String) entry.getValue());
                            Set<SerializableHttpCookie> set = this.allCookies.get(uri);
                            if (set == null) {
                                set = new HashSet<>();
                                this.allCookies.put(uri, set);
                            }
                            if (decode != null) {
                                set.add(decode);
                            }
                        } catch (URISyntaxException e) {
                            e.printStackTrace();
                        }
                    }
                    if (z) {
                        ThreadPlus.submitRunnable(new Runnable() { // from class: com.bytedance.frameworks.baselib.network.http.impl.PersistentCookieStore.1
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    PersistentCookieStore.this.tryMvHttpsCookies2HttpCookie();
                                } catch (Throwable th) {
                                    th.printStackTrace();
                                }
                            }
                        });
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void tryMvHttpsCookies2HttpCookie() {
        Map<URI, Set<SerializableHttpCookie>> map;
        Map<URI, Set<SerializableHttpCookie>> map2 = this.allCookies;
        if (map2 != null && !map2.isEmpty()) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<URI, Set<SerializableHttpCookie>> entry : this.allCookies.entrySet()) {
                if (entry != null) {
                    URI key = entry.getKey();
                    if (key.getScheme() != null && key.getScheme().equals("https")) {
                        linkedHashMap.put(entry.getKey(), entry.getValue());
                    }
                }
            }
            if (linkedHashMap.isEmpty()) {
                return;
            }
            for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                if (entry2 != null) {
                    URI uri = (URI) entry2.getKey();
                    Set<SerializableHttpCookie> set = (Set) entry2.getValue();
                    try {
                        URI uri2 = new URI(uri.toString().replace("https:", "http:"));
                        Set<SerializableHttpCookie> set2 = this.allCookies.get(uri2);
                        if (set2 != null && !set2.isEmpty()) {
                            LinkedHashSet linkedHashSet = new LinkedHashSet();
                            for (SerializableHttpCookie serializableHttpCookie : set2) {
                                boolean z = false;
                                for (SerializableHttpCookie serializableHttpCookie2 : set) {
                                    if (serializableHttpCookie != null && serializableHttpCookie2 != null && serializableHttpCookie.getHttpCookie().equals(serializableHttpCookie2.getHttpCookie()) && serializableHttpCookie2.getWhenCreated().longValue() >= serializableHttpCookie.getWhenCreated().longValue()) {
                                        linkedHashSet.add(serializableHttpCookie2);
                                        z = true;
                                    }
                                }
                                if (!z) {
                                    linkedHashSet.add(serializableHttpCookie);
                                }
                            }
                            for (SerializableHttpCookie serializableHttpCookie3 : set) {
                                if (!linkedHashSet.contains(serializableHttpCookie3)) {
                                    linkedHashSet.add(serializableHttpCookie3);
                                }
                            }
                            this.allCookies.remove(uri);
                            this.allCookies.put(uri2, linkedHashSet);
                        }
                        this.allCookies.remove(uri);
                        this.allCookies.put(uri2, set);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }
            try {
                map = this.allCookies;
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
            if (map != null && !map.isEmpty()) {
                SharedPreferences.Editor edit = this.cookieStore.edit();
                edit.clear();
                for (Map.Entry<URI, Set<SerializableHttpCookie>> entry3 : this.allCookies.entrySet()) {
                    URI key2 = entry3.getKey();
                    for (SerializableHttpCookie serializableHttpCookie4 : entry3.getValue()) {
                        String str = key2.toString() + "|" + serializableHttpCookie4.getHttpCookie().getName();
                        String encode = serializableHttpCookie4.encode();
                        if (serializableHttpCookie4.getHttpCookie().getMaxAge() > 0) {
                            edit.putString(str, encode);
                        } else {
                            memoryStore.put(str, encode);
                        }
                    }
                }
                SharedPrefsEditorCompat.apply(edit);
            }
        }
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.CookieStore
    public synchronized void add(URI uri, HttpCookie httpCookie) {
        URI cookieUri = cookieUri(uri, httpCookie);
        Set<SerializableHttpCookie> set = this.allCookies.get(cookieUri);
        SerializableHttpCookie serializableHttpCookie = new SerializableHttpCookie(httpCookie);
        if (set == null) {
            set = new HashSet<>();
            this.allCookies.put(cookieUri, set);
        } else {
            set.remove(serializableHttpCookie);
        }
        set.add(serializableHttpCookie);
        saveToPersistence(cookieUri, serializableHttpCookie);
    }

    private static URI cookieUri(URI uri, HttpCookie httpCookie) {
        if (httpCookie.getDomain() == null) {
            return uri;
        }
        String domain = httpCookie.getDomain();
        if (domain.charAt(0) == '.') {
            domain = domain.substring(1);
        }
        try {
            return new URI("http", domain, httpCookie.getPath() == null ? "/" : httpCookie.getPath(), null);
        } catch (URISyntaxException e) {
            Log.w(TAG, e);
            return uri;
        }
    }

    private void saveToPersistence(URI uri, SerializableHttpCookie serializableHttpCookie) {
        String str = uri.toString() + "|" + serializableHttpCookie.getHttpCookie().getName();
        String encode = serializableHttpCookie.encode();
        if (serializableHttpCookie.getHttpCookie().getMaxAge() > 0) {
            SharedPreferences.Editor edit = this.cookieStore.edit();
            edit.putString(str, encode);
            edit.apply();
            return;
        }
        memoryStore.put(str, encode);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.CookieStore
    public synchronized List<HttpCookie> get(URI uri) {
        return getValidCookies(uri);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.CookieStore
    public synchronized List<HttpCookie> getCookies() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator<URI> it = this.allCookies.keySet().iterator();
        while (it.hasNext()) {
            arrayList.addAll(getValidCookies(it.next()));
        }
        return arrayList;
    }

    private List<HttpCookie> getValidCookies(URI uri) {
        ArrayList<SerializableHttpCookie> arrayList = new ArrayList();
        for (URI uri2 : this.allCookies.keySet()) {
            if (checkDomainsMatch(uri2.getHost(), uri.getHost())) {
                String path = uri.getPath();
                if (TextUtils.isEmpty(path)) {
                    path = "/";
                }
                if (checkPathsMatch(uri2.getPath(), path)) {
                    arrayList.addAll(this.allCookies.get(uri2));
                }
            }
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (SerializableHttpCookie serializableHttpCookie : arrayList) {
            if (serializableHttpCookie.hasExpired()) {
                arrayList3.add(serializableHttpCookie);
            } else {
                arrayList2.add(serializableHttpCookie.getHttpCookie());
            }
        }
        if (!arrayList3.isEmpty()) {
            removeFromPersistence(uri, arrayList3);
        }
        return arrayList2;
    }

    private boolean checkDomainsMatch(String str, String str2) {
        if (str == null || str2 == null) {
            return false;
        }
        if (str2.length() < str.length()) {
            return str.equalsIgnoreCase(LibrarianImpl.Constants.DOT + str2);
        }
        return str2.equalsIgnoreCase(str) || str2.toLowerCase().endsWith(new StringBuilder(LibrarianImpl.Constants.DOT).append(str.toLowerCase()).toString());
    }

    private boolean checkPathsMatch(String str, String str2) {
        if (str2.equals(str)) {
            return true;
        }
        if (str2.startsWith(str) && str.charAt(str.length() - 1) == '/') {
            return true;
        }
        return str2.startsWith(str) && str2.substring(str.length()).charAt(0) == '/';
    }

    private void removeFromPersistence(URI uri, List<SerializableHttpCookie> list) {
        SharedPreferences.Editor edit = this.cookieStore.edit();
        Iterator<SerializableHttpCookie> it = list.iterator();
        while (it.hasNext()) {
            String str = uri.toString() + "|" + it.next().getHttpCookie().getName();
            edit.remove(str);
            memoryStore.remove(str);
        }
        edit.apply();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.CookieStore
    public synchronized List<URI> getURIs() {
        return new ArrayList(this.allCookies.keySet());
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.CookieStore
    public synchronized boolean remove(URI uri, HttpCookie httpCookie) {
        boolean remove;
        Set<SerializableHttpCookie> set = this.allCookies.get(uri);
        SerializableHttpCookie serializableHttpCookie = new SerializableHttpCookie(httpCookie);
        remove = set != null ? set.remove(serializableHttpCookie) : false;
        if (remove) {
            removeFromPersistence(uri, serializableHttpCookie);
        }
        return remove;
    }

    private void removeFromPersistence(URI uri, SerializableHttpCookie serializableHttpCookie) {
        SharedPreferences.Editor edit = this.cookieStore.edit();
        String str = uri.toString() + "|" + serializableHttpCookie.getHttpCookie().getName();
        edit.remove(str);
        edit.apply();
        memoryStore.remove(str);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.CookieStore
    public synchronized boolean removeAll() {
        this.allCookies.clear();
        removeAllFromPersistence();
        return true;
    }

    private void removeAllFromPersistence() {
        this.cookieStore.edit().clear().apply();
        memoryStore.clear();
    }
}
