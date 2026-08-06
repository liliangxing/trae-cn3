package com.ss.android.token;

import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes7.dex */
public class TokenObject {
    public static String TOKEN_NAME = "token";
    public static String TS_SIGN_NAME = "ts_sign";
    public final String token;
    public final String tsSign;

    public TokenObject(String str, String str2) {
        this.token = str;
        this.tsSign = str2;
    }

    public Map<String, String> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put(TOKEN_NAME, this.token);
        hashMap.put(TS_SIGN_NAME, this.tsSign);
        return hashMap;
    }

    public Cursor buildCursor() {
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{TOKEN_NAME, TS_SIGN_NAME});
        matrixCursor.newRow().add(this.token).add(this.tsSign);
        return matrixCursor;
    }

    public static TokenObject parseFromUri(Uri uri) {
        String str;
        String str2;
        if (uri != null) {
            str = uri.getQueryParameter(TOKEN_NAME);
            str2 = uri.getQueryParameter(TS_SIGN_NAME);
        } else {
            str = null;
            str2 = null;
        }
        return new TokenObject(str, str2);
    }

    public static TokenObject parseFromCursor(Cursor cursor) {
        String str;
        String str2;
        if (cursor == null || !cursor.moveToFirst()) {
            str = null;
            str2 = null;
        } else {
            str = cursor.getString(cursor.getColumnIndexOrThrow(TOKEN_NAME));
            str2 = cursor.getString(cursor.getColumnIndexOrThrow(TS_SIGN_NAME));
        }
        return new TokenObject(str, str2);
    }

    public String toString() {
        return "TokenObject{token='" + this.token + "', tsSign='" + this.tsSign + "'}";
    }

    public String getLoggableString() {
        return "TokenObject{token='" + TokenFactory.getMixVal(this.token) + "', tsSign='" + TokenFactory.getMixVal(this.tsSign) + "'}";
    }
}
