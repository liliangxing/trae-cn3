package com.bytedance.pia.snapshot.storage;

import android.net.Uri;
import com.bytedance.keva.Keva;
import com.bytedance.pia.core.cache.IPiaCacheProvider;
import com.bytedance.pia.core.utils.Logger;
import com.bytedance.pia.core.utils.UrlUtils;
import com.bytedance.pia.snapshot.storage.ISnapshotStore;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: SnapshotStore.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0004H\u0002J&\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u001cH\u0002J(\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0018\u001a\u00020\u00042\u0016\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\u00040 j\b\u0012\u0004\u0012\u00020\u0004`!H\u0002J\u0010\u0010\"\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\u0012\u0010#\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J \u0010$\u001a\u0012\u0012\u0004\u0012\u00020\u00040 j\b\u0012\u0004\u0012\u00020\u0004`!2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0012\u0010\u0019\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020'H\u0016J \u0010(\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020*H\u0016J\u0010\u0010+\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J0\u0010,\u001a\u00020\u001e2\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u001a2\u0016\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u00040 j\b\u0012\u0004\u0012\u00020\u0004`!H\u0002J\b\u0010-\u001a\u00020\u0013H\u0016JJ\u0010.\u001a\u00020\u001e2\u0006\u0010\u0015\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u00042\u0006\u0010/\u001a\u0002002\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020*2\u0006\u00101\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u00042\u0006\u00102\u001a\u00020\u001eH\u0016JZ\u00103\u001a\u00020\u001e2\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u001a2\u0016\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u00040 j\b\u0012\u0004\u0012\u00020\u0004`!2\u0006\u0010\u0015\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u00042\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u00042\u0006\u0010)\u001a\u00020*H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/bytedance/pia/snapshot/storage/SnapshotStore;", "Lcom/bytedance/pia/snapshot/storage/ISnapshotStore;", "()V", "CONFLICT_ERROR_MESSAGE", "", "NAME_CONTENT", "NAME_CONTENT_UUID", "NAME_EXPIRE_TIME", "NAME_HEAD", "NAME_PROTOCOL_VERSION", "NAME_SNAPSHOT_VERSION", "SNAPSHOT_CONTENT_REPO", "SNAPSHOT_DETAIL_PREFIX", "SNAPSHOT_GLOBAL_INDEX_REPO", "contentRepo", "Lcom/bytedance/keva/Keva;", "kotlin.jvm.PlatformType", "indexRepo", "addToContentRepo", "", "contentID", SnapshotStore.NAME_CONTENT, SnapshotStore.NAME_HEAD, "addUrlWithSortedQuery", "path", "query", "Lorg/json/JSONObject;", "sortQueryKeys", "", "checkConflict", "", "sortNewKeys", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "clearIndexRepo", "getDetailRepo", "getSortQueryList", "Lcom/bytedance/pia/snapshot/storage/SnapshotEntity;", "url", "Landroid/net/Uri;", "remove", "sdk", "", "removeAllEntityForPath", "removeEntityForPath", "removeExpires", "save", "expires", "", IPiaCacheProvider.CacheConfig.FIELD_VERSION, "enforce", "saveSnapShotForPath", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class SnapshotStore implements ISnapshotStore {
    private static final String CONFLICT_ERROR_MESSAGE = "fail to save the snapshot for some conflicts.";
    private static final String NAME_CONTENT = "content";
    private static final String NAME_CONTENT_UUID = "content_UUID";
    private static final String NAME_EXPIRE_TIME = "expire_time";
    private static final String NAME_HEAD = "head";
    private static final String NAME_PROTOCOL_VERSION = "protocol_version";
    private static final String NAME_SNAPSHOT_VERSION = "snapshot_version";
    private static final String SNAPSHOT_DETAIL_PREFIX = "_detail_id";
    public static final SnapshotStore INSTANCE = new SnapshotStore();
    private static final String SNAPSHOT_GLOBAL_INDEX_REPO = "pia-snapshot-index-repo";
    private static final Keva indexRepo = Keva.getRepo(SNAPSHOT_GLOBAL_INDEX_REPO);
    private static final String SNAPSHOT_CONTENT_REPO = "pia-snapshot-content-repo";
    private static final Keva contentRepo = Keva.getRepo(SNAPSHOT_CONTENT_REPO);

    private SnapshotStore() {
    }

    private final Keva getDetailRepo(String path) {
        String str = path + SNAPSHOT_DETAIL_PREFIX;
        Keva keva = indexRepo;
        if (!keva.contains(path) || !keva.contains(str)) {
            return null;
        }
        String string = keva.getString(str, "");
        Intrinsics.checkNotNullExpressionValue(string, "uuid");
        if (string.length() > 0) {
            return Keva.getRepo(string);
        }
        return null;
    }

    @Override // com.bytedance.pia.snapshot.storage.ISnapshotStore
    public void removeExpires() {
        Object obj;
        Map<String, ?> all = indexRepo.getAll();
        Intrinsics.checkNotNullExpressionValue(all, "indexRepo.all");
        long currentTimeMillis = System.currentTimeMillis();
        for (Map.Entry<String, ?> entry : all.entrySet()) {
            String key = entry.getKey();
            Intrinsics.checkNotNullExpressionValue(key, "entity.key");
            Unit unit = null;
            if (!StringsKt.endsWith$default(key, SNAPSHOT_DETAIL_PREFIX, false, 2, (Object) null)) {
                String key2 = entry.getKey();
                Intrinsics.checkNotNullExpressionValue(key2, "path");
                Keva detailRepo = getDetailRepo(key2);
                if (detailRepo != null) {
                    Map<String, ?> all2 = detailRepo.getAll();
                    Intrinsics.checkNotNullExpressionValue(all2, "detailRepo.all");
                    for (Map.Entry<String, ?> entry2 : all2.entrySet()) {
                        try {
                            Result.Companion companion = Result.Companion;
                            Object value = entry2.getValue();
                            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.String");
                            obj = Result.constructor-impl(new JSONObject((String) value));
                        } catch (Throwable th) {
                            Result.Companion companion2 = Result.Companion;
                            obj = Result.constructor-impl(ResultKt.createFailure(th));
                        }
                        if (Result.exceptionOrNull-impl(obj) != null) {
                            detailRepo.erase(entry2.getKey());
                        }
                        if (Result.isSuccess-impl(obj)) {
                            JSONObject jSONObject = (JSONObject) obj;
                            if (jSONObject.getLong(NAME_EXPIRE_TIME) <= currentTimeMillis) {
                                contentRepo.erase(jSONObject.getString(NAME_CONTENT_UUID));
                                detailRepo.erase(entry2.getKey());
                            }
                        }
                    }
                    if (detailRepo.count() == 0) {
                        INSTANCE.clearIndexRepo(key2);
                    }
                    unit = Unit.INSTANCE;
                }
                if (unit == null) {
                    clearIndexRepo(key2);
                }
            }
        }
    }

    private final void clearIndexRepo(String path) {
        Keva keva = indexRepo;
        keva.erase(path);
        keva.erase(path + SNAPSHOT_DETAIL_PREFIX);
    }

    @Override // com.bytedance.pia.snapshot.storage.ISnapshotStore
    public boolean save(String content, String head, long expires, JSONObject query, int sdk, String version, String url, boolean enforce) {
        Intrinsics.checkNotNullParameter(content, NAME_CONTENT);
        Intrinsics.checkNotNullParameter(query, "query");
        Intrinsics.checkNotNullParameter(version, IPiaCacheProvider.CacheConfig.FIELD_VERSION);
        Intrinsics.checkNotNullParameter(url, "url");
        if (indexRepo == null) {
            return false;
        }
        String fullPath = UrlUtils.getFullPath(Uri.parse(url));
        ArrayList<String> sortQueryList = getSortQueryList(query);
        if (!checkConflict(fullPath, sortQueryList)) {
            boolean removeEntityForPath = removeEntityForPath(fullPath, query, sortQueryList);
            if (saveSnapShotForPath(fullPath, query, sortQueryList, content, head, expires, version, sdk)) {
                return removeEntityForPath;
            }
            return false;
        }
        if (!enforce) {
            Logger.w$default("[SnapShot] snapshot conflict exception (URL: " + url + ", Query: " + query + "), Enforce: " + enforce, null, null, 6, null);
            throw new ISnapshotStore.SnapshotConflictException(CONFLICT_ERROR_MESSAGE);
        }
        removeAllEntityForPath(fullPath);
        return saveSnapShotForPath(fullPath, query, sortQueryList, content, head, expires, version, sdk);
    }

    @Override // com.bytedance.pia.snapshot.storage.ISnapshotStore
    public boolean remove(String url, JSONObject query, int sdk) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(query, "query");
        return removeEntityForPath(UrlUtils.getFullPath(Uri.parse(url)), query, getSortQueryList(query));
    }

    @Override // com.bytedance.pia.snapshot.storage.ISnapshotStore
    public SnapshotEntity query(Uri url) {
        Object obj;
        Object obj2;
        Intrinsics.checkNotNullParameter(url, "url");
        String fullPath = UrlUtils.getFullPath(url);
        Keva keva = indexRepo;
        if (!keva.contains(fullPath)) {
            return null;
        }
        String[] stringArray = keva.getStringArray(fullPath, null);
        if (stringArray == null) {
            removeAllEntityForPath(fullPath);
            return null;
        }
        String str = (stringArray.length == 0) ^ true ? fullPath + '?' : fullPath;
        int length = stringArray.length;
        for (int i = 0; i < length; i++) {
            String str2 = stringArray[i];
            if (url.getQueryParameter(str2) == null) {
                return null;
            }
            str = str + str2 + '=' + url.getQueryParameter(str2);
            if (i < stringArray.length - 1) {
                str = str + '&';
            }
        }
        Keva detailRepo = getDetailRepo(fullPath);
        if (detailRepo != null && detailRepo.contains(str)) {
            try {
                Result.Companion companion = Result.Companion;
                obj = Result.constructor-impl(new JSONObject(detailRepo.getString(str, "")));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            if (Result.exceptionOrNull-impl(obj) != null) {
                detailRepo.erase(str);
            } else {
                JSONObject jSONObject = (JSONObject) obj;
                String string = jSONObject.getString(NAME_CONTENT_UUID);
                long j = jSONObject.getLong(NAME_EXPIRE_TIME);
                String string2 = jSONObject.getString(NAME_SNAPSHOT_VERSION);
                int i2 = jSONObject.getInt(NAME_PROTOCOL_VERSION);
                String string3 = contentRepo.getString(string, "");
                try {
                    Result.Companion companion3 = Result.Companion;
                    obj2 = Result.constructor-impl(new JSONObject(string3));
                } catch (Throwable th2) {
                    Result.Companion companion4 = Result.Companion;
                    obj2 = Result.constructor-impl(ResultKt.createFailure(th2));
                }
                if (Result.exceptionOrNull-impl(obj2) != null) {
                    contentRepo.erase(string);
                    detailRepo.erase(str);
                    return null;
                }
                JSONObject jSONObject2 = (JSONObject) obj2;
                String optString = jSONObject2.optString(NAME_CONTENT);
                Intrinsics.checkNotNullExpressionValue(optString, "contentJson.optString(NAME_CONTENT)");
                String optString2 = jSONObject2.optString(NAME_HEAD);
                Intrinsics.checkNotNullExpressionValue(optString2, "contentJson.optString(NAME_HEAD)");
                Intrinsics.checkNotNullExpressionValue(string2, IPiaCacheProvider.CacheConfig.FIELD_VERSION);
                return new SnapshotEntity(str, stringArray, optString, optString2, string2, i2, j);
            }
        }
        return null;
    }

    private final ArrayList<String> getSortQueryList(JSONObject query) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (query.length() > 0) {
            Iterator<String> keys = query.keys();
            while (keys.hasNext()) {
                arrayList.add(keys.next());
            }
        }
        CollectionsKt.sort(arrayList);
        return arrayList;
    }

    private final void addToContentRepo(String contentID, String content, String head) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(NAME_CONTENT, content);
        if (head != null) {
            jSONObject.put(NAME_HEAD, head);
        }
        contentRepo.storeString(contentID, jSONObject.toString());
    }

    private final void removeAllEntityForPath(String path) {
        Logger.d$default("[SnapShot] remove all snapshots (Path = " + path + ')', null, null, 6, null);
        Keva detailRepo = getDetailRepo(path);
        if (detailRepo != null) {
            Map<String, ?> all = detailRepo.getAll();
            Intrinsics.checkNotNull(all, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
            Iterator<Map.Entry<String, ?>> it = all.entrySet().iterator();
            while (it.hasNext()) {
                contentRepo.erase(new JSONObject((String) it.next().getValue()).getString(NAME_CONTENT_UUID));
            }
            detailRepo.clear();
        }
        clearIndexRepo(path);
    }

    private final boolean removeEntityForPath(String path, JSONObject query, ArrayList<String> sortQueryKeys) {
        Object obj;
        Keva detailRepo = getDetailRepo(path);
        if (detailRepo != null) {
            String addUrlWithSortedQuery = INSTANCE.addUrlWithSortedQuery(path, query, sortQueryKeys);
            if (detailRepo.contains(addUrlWithSortedQuery)) {
                try {
                    Result.Companion companion = Result.Companion;
                    obj = Result.constructor-impl(new JSONObject(detailRepo.getString(addUrlWithSortedQuery, "")));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                }
                if (Result.exceptionOrNull-impl(obj) == null) {
                    String optString = ((JSONObject) obj).optString(NAME_CONTENT_UUID);
                    Keva keva = contentRepo;
                    if (keva.contains(optString)) {
                        keva.erase(optString);
                        detailRepo.erase(addUrlWithSortedQuery);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private final boolean saveSnapShotForPath(String path, JSONObject query, ArrayList<String> sortQueryKeys, String content, String head, long expires, String version, int sdk) {
        Object obj;
        Unit unit;
        try {
            Result.Companion companion = Result.Companion;
            Keva keva = indexRepo;
            if (!keva.contains(path)) {
                String[] strArr = new String[0];
                if (!sortQueryKeys.isEmpty()) {
                    Object[] array = sortQueryKeys.toArray(strArr);
                    Intrinsics.checkNotNullExpressionValue(array, "sortQueryKeys.toArray(array)");
                    strArr = (String[]) array;
                }
                keva.storeStringArray(path, strArr);
                keva.storeString(path + SNAPSHOT_DETAIL_PREFIX, UUID.randomUUID().toString());
            }
            SnapshotStore snapshotStore = INSTANCE;
            Keva detailRepo = snapshotStore.getDetailRepo(path);
            if (detailRepo != null) {
                String addUrlWithSortedQuery = snapshotStore.addUrlWithSortedQuery(path, query, sortQueryKeys);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(NAME_EXPIRE_TIME, expires);
                jSONObject.put(NAME_SNAPSHOT_VERSION, version);
                jSONObject.put(NAME_PROTOCOL_VERSION, sdk);
                jSONObject.put(NAME_CONTENT_UUID, UUID.randomUUID().toString());
                String optString = jSONObject.optString(NAME_CONTENT_UUID);
                Intrinsics.checkNotNullExpressionValue(optString, "detailValue.optString(NAME_CONTENT_UUID)");
                snapshotStore.addToContentRepo(optString, content, head);
                detailRepo.storeString(addUrlWithSortedQuery, jSONObject.toString());
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            obj = Result.constructor-impl(unit);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable th2 = Result.exceptionOrNull-impl(obj);
        if (th2 != null) {
            Logger.w$default("[SnapShot] save snapshot failed. (Reason: " + th2.getMessage() + ')', null, null, 6, null);
            return false;
        }
        Logger.d$default("[SnapShot] save snapshot success", null, null, 6, null);
        return true;
    }

    private final String addUrlWithSortedQuery(String path, JSONObject query, List<String> sortQueryKeys) {
        if (query.length() == 0) {
            return path;
        }
        String str = path + '?';
        int size = sortQueryKeys.size();
        for (int i = 0; i < size; i++) {
            str = str + sortQueryKeys.get(i) + '=' + query.opt(sortQueryKeys.get(i));
            if (i < sortQueryKeys.size() - 1) {
                str = str + '&';
            }
        }
        return str;
    }

    private final boolean checkConflict(String path, ArrayList<String> sortNewKeys) {
        Keva keva = indexRepo;
        if (!keva.contains(path)) {
            return false;
        }
        String[] stringArray = keva.getStringArray(path, null);
        if (stringArray == null) {
            removeAllEntityForPath(path);
            return false;
        }
        if ((stringArray.length == 0) && sortNewKeys.isEmpty()) {
            return false;
        }
        if (stringArray.length != sortNewKeys.size()) {
            return true;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : stringArray) {
            arrayList.add(str);
        }
        CollectionsKt.sort(arrayList);
        return !Intrinsics.areEqual(sortNewKeys, arrayList);
    }
}
