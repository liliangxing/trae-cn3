package com.ss.android.token;

import android.content.ComponentName;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;

/* loaded from: classes7.dex */
public class TokenObjectProvider extends ContentProvider {
    private static final int CODE_GET_TOKEN_OBJECT = 1;
    private static final int CODE_SET_TOKEN_OBJECT = 2;
    public static final String PATH_GET_TOKEN_OBJECT = "get_token_object";
    public static final String PATH_SET_TOKEN_OBJECT = "set_token_object";
    private static final String TAG = "TokenObjectProvider";
    private String authority;
    private volatile boolean hasInit = false;
    private UriMatcher uriMatcher;

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public void attachInfo(Context context, ProviderInfo providerInfo) {
        if (providerInfo != null) {
            TTTokenManager.log(TAG, "set authority at attachInfo");
            this.authority = providerInfo.authority;
        }
        super.attachInfo(context, providerInfo);
    }

    private void init(Context context) {
        if (this.hasInit) {
            return;
        }
        synchronized (this) {
            if (this.hasInit) {
                return;
            }
            if (TextUtils.isEmpty(this.authority)) {
                this.authority = getAuthority(context);
            }
            if (TextUtils.isEmpty(this.authority)) {
                return;
            }
            TTTokenManager.log(TAG, "authority=" + this.authority);
            UriMatcher uriMatcher = new UriMatcher(-1);
            this.uriMatcher = uriMatcher;
            uriMatcher.addURI(this.authority, PATH_GET_TOKEN_OBJECT, 1);
            this.uriMatcher.addURI(this.authority, PATH_SET_TOKEN_OBJECT, 2);
            this.hasInit = true;
        }
    }

    public static String getAuthority(Context context) {
        if (context == null) {
            return null;
        }
        try {
            ProviderInfo providerInfo = context.getPackageManager().getProviderInfo(new ComponentName(context.getPackageName(), TokenObjectProvider.class.getName()), 128);
            if (providerInfo != null) {
                String str = providerInfo.authority;
                if (!TextUtils.isEmpty(str)) {
                    TTTokenManager.log(TAG, "set authority at getting ProviderInfo");
                    return str;
                }
            }
        } catch (Exception e) {
            TTTokenMonitor.monitorError(e);
        }
        TTTokenManager.log(TAG, "set authority at making");
        return context.getPackageName() + ".TokenObjectProvider";
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        init(getContext());
        int match = this.uriMatcher.match(uri);
        TTTokenManager.log(TAG, "query, code=" + match);
        if (match == 1) {
            return TokenFactory.getInstance().getTokenObject().buildCursor();
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        init(getContext());
        return "vnd.android.cursor.item/vnd." + this.authority + ".item";
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        init(getContext());
        return null;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        init(getContext());
        return 0;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        init(getContext());
        int match = this.uriMatcher.match(uri);
        TTTokenManager.log(TAG, "update, code=" + match);
        if (match != 2) {
            return 0;
        }
        TokenFactory.getInstance().setTokenObject(TokenObject.parseFromUri(uri));
        return 0;
    }
}
