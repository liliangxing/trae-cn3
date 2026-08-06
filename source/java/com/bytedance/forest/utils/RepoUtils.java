package com.bytedance.forest.utils;

import com.bytedance.applog.server.Api;
import com.bytedance.forest.Forest;
import com.bytedance.forest.pollyfill.CDNFetchDepender;
import com.bytedance.keva.Keva;
import com.bytedance.keva.KevaConstants;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: RepoUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bJ\u001a\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u0004J\u0016\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000bJ\u0016\u0010\u0011\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004J\u0006\u0010\u0012\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/bytedance/forest/utils/RepoUtils;", "", "()V", "REPO_NAME", "", "repo", "Lcom/bytedance/keva/Keva;", "delete", "", Api.KEY_ENCRYPT_RESP_KEY, "getBoolean", "", "fallback", "getStringJustDisk", "has", "storeBoolean", "value", "storeStringJustDisk", "trim", "forest_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class RepoUtils {
    public static final RepoUtils INSTANCE = new RepoUtils();
    private static final String REPO_NAME = "forest_cdn";
    private static final Keva repo = Keva.getRepo(REPO_NAME, 1);

    private RepoUtils() {
    }

    public final void delete(String key) {
        Intrinsics.checkParameterIsNotNull(key, Api.KEY_ENCRYPT_RESP_KEY);
        Keva keva = repo;
        if (keva != null) {
            keva.erase(key);
        }
    }

    public final boolean has(String key) {
        Intrinsics.checkParameterIsNotNull(key, Api.KEY_ENCRYPT_RESP_KEY);
        Keva keva = repo;
        if (keva != null) {
            return keva.contains(key);
        }
        return false;
    }

    public final String getStringJustDisk(String key, String fallback) {
        Intrinsics.checkParameterIsNotNull(key, Api.KEY_ENCRYPT_RESP_KEY);
        Keva keva = repo;
        if (keva != null) {
            return keva.getStringJustDisk(key, fallback);
        }
        return null;
    }

    public final boolean getBoolean(String key, boolean fallback) {
        Intrinsics.checkParameterIsNotNull(key, Api.KEY_ENCRYPT_RESP_KEY);
        Keva keva = repo;
        if (keva != null) {
            return keva.getBoolean(key, fallback);
        }
        return false;
    }

    public final void storeBoolean(String key, boolean value) {
        Intrinsics.checkParameterIsNotNull(key, Api.KEY_ENCRYPT_RESP_KEY);
        Keva keva = repo;
        if (keva != null) {
            keva.storeBoolean(key, value);
        }
    }

    public final void storeStringJustDisk(String key, String value) {
        Intrinsics.checkParameterIsNotNull(key, Api.KEY_ENCRYPT_RESP_KEY);
        Intrinsics.checkParameterIsNotNull(value, "value");
        Keva keva = repo;
        if (keva != null) {
            keva.storeStringJustDisk(key, value);
        }
    }

    public final void trim() {
        Map all;
        if (Forest.INSTANCE.getEnableKEVAOpt$forest_release()) {
            Keva keva = repo;
            if (keva == null) {
                return;
            }
            keva.count();
            all = keva.buildNewMap(KevaConstants.FLAG_CURRENT_KEY_MAP);
            if (all == null) {
                return;
            }
        } else {
            Keva keva2 = repo;
            if (keva2 == null || (all = keva2.getAll()) == null) {
                return;
            }
        }
        for (String str : all.keySet()) {
            String str2 = str;
            if (!(str2 == null || str2.length() == 0) && !OfflineUtil.INSTANCE.isCacheKey(str)) {
                Keva keva3 = repo;
                String stringJustDisk = keva3.getStringJustDisk(str, "");
                if (stringJustDisk == null || stringJustDisk.length() == 0) {
                    keva3.erase(str);
                } else {
                    Iterator it = StringsKt.split$default(stringJustDisk, new String[]{","}, false, 0, 6, (Object) null).iterator();
                    boolean z = false;
                    while (it.hasNext()) {
                        z = z || new File(CDNFetchDepender.INSTANCE.getDirectory(), (String) it.next()).exists();
                        if (z) {
                            break;
                        }
                    }
                    if (!z) {
                        repo.erase(str);
                    }
                }
            }
        }
    }
}
