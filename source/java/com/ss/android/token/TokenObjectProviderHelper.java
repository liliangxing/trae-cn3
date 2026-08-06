package com.ss.android.token;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import java.util.Map;

/* loaded from: classes7.dex */
public class TokenObjectProviderHelper {
    private static final String TAG = "TokenObjectProviderHelper";
    private final Context applicationContext;
    private Uri baseUri;

    public TokenObjectProviderHelper(Context context) {
        this.applicationContext = context.getApplicationContext();
    }

    private void tryInit() {
        if (this.baseUri == null) {
            this.baseUri = Uri.parse("content://" + TokenObjectProvider.getAuthority(this.applicationContext));
        }
    }

    private Cursor query(Uri uri) {
        return this.applicationContext.getContentResolver().query(uri, null, null, null, null);
    }

    private void update(Uri uri) {
        this.applicationContext.getContentResolver().update(uri, new ContentValues(), null, null);
    }

    private Uri getUri(String str) {
        return getUri(str, null);
    }

    private Uri getUri(String str, Map<String, String> map) {
        tryInit();
        Uri.Builder appendPath = this.baseUri.buildUpon().appendPath(str);
        if (map != null && !map.isEmpty()) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                appendPath.appendQueryParameter(entry.getKey(), entry.getValue());
            }
        }
        return appendPath.build();
    }

    public void setTokenObject(TokenObject tokenObject) {
        update(getUri(TokenObjectProvider.PATH_SET_TOKEN_OBJECT, tokenObject.toMap()));
    }

    public TokenObject getTokenObject() {
        return TokenObject.parseFromCursor(query(getUri(TokenObjectProvider.PATH_GET_TOKEN_OBJECT)));
    }
}
