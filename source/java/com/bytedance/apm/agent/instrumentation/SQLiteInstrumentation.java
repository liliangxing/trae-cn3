package com.bytedance.apm.agent.instrumentation;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.CancellationSignal;
import com.bytedance.apm.agent.tracing.TraceMachine;
import com.bytedance.apm.constant.AgentConstants;
import java.util.Arrays;

/* loaded from: classes3.dex */
public class SQLiteInstrumentation {
    public static final String SQLITE = "sqlite";

    public static Cursor rawQuery(SQLiteDatabase sQLiteDatabase, String str, String[] strArr) {
        TraceMachine.enterMethod(SQLITE, "rawQuery", AgentConstants.TRACE_TYPE_DB);
        Cursor rawQuery = sQLiteDatabase.rawQuery(str, strArr);
        TraceMachine.exitMethod(str);
        return rawQuery;
    }

    public static Cursor rawQuery(SQLiteDatabase sQLiteDatabase, String str, String[] strArr, CancellationSignal cancellationSignal) {
        TraceMachine.enterMethod(SQLITE, "rawQuery", AgentConstants.TRACE_TYPE_DB);
        Cursor rawQuery = sQLiteDatabase.rawQuery(str, strArr);
        TraceMachine.exitMethod(str);
        return rawQuery;
    }

    private static String combineQuery(boolean z, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
        return "distinct: " + z + " table: " + str + " columns: " + Arrays.toString(strArr) + " selection: " + str2 + " selectionArgs: " + Arrays.toString(strArr2);
    }

    public static Cursor query(SQLiteDatabase sQLiteDatabase, boolean z, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
        TraceMachine.enterMethod(SQLITE, "query", AgentConstants.TRACE_TYPE_DB);
        Cursor query = sQLiteDatabase.query(z, str, strArr, str2, strArr2, str3, str4, str5, str6);
        TraceMachine.exitMethod(combineQuery(z, str, strArr, str2, strArr2, str3, str4, str5, str6));
        return query;
    }

    public static Cursor query(SQLiteDatabase sQLiteDatabase, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
        TraceMachine.enterMethod(SQLITE, "query", AgentConstants.TRACE_TYPE_DB);
        Cursor query = sQLiteDatabase.query(str, strArr, str2, strArr2, str3, str4, str5);
        TraceMachine.exitMethod(combineQuery(false, str, strArr, str2, strArr2, str3, str4, str5, null));
        return query;
    }

    public static Cursor query(SQLiteDatabase sQLiteDatabase, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
        TraceMachine.enterMethod(SQLITE, "query", AgentConstants.TRACE_TYPE_DB);
        Cursor query = sQLiteDatabase.query(str, strArr, str2, strArr2, str3, str4, str5, str6);
        TraceMachine.exitMethod(combineQuery(false, str, strArr, str2, strArr2, str3, str4, str5, str6));
        return query;
    }

    public static Cursor queryWithFactory(SQLiteDatabase sQLiteDatabase, SQLiteDatabase.CursorFactory cursorFactory, boolean z, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6, CancellationSignal cancellationSignal) {
        TraceMachine.enterMethod(SQLITE, "queryWithFactory", AgentConstants.TRACE_TYPE_DB);
        Cursor queryWithFactory = sQLiteDatabase.queryWithFactory(cursorFactory, z, str, strArr, str2, strArr2, str3, str4, str5, str6, cancellationSignal);
        TraceMachine.exitMethod(combineQuery(false, str, strArr, str2, strArr2, str3, str4, str5, str6));
        return queryWithFactory;
    }

    public static Cursor rawQueryWithFactory(SQLiteDatabase sQLiteDatabase, SQLiteDatabase.CursorFactory cursorFactory, String str, String[] strArr, String str2) {
        TraceMachine.enterMethod(SQLITE, "rawQueryWithFactory", AgentConstants.TRACE_TYPE_DB);
        Cursor rawQueryWithFactory = sQLiteDatabase.rawQueryWithFactory(cursorFactory, str, strArr, str2);
        TraceMachine.exitMethod(str + Arrays.toString(strArr));
        return rawQueryWithFactory;
    }

    public static Cursor rawQueryWithFactory(SQLiteDatabase sQLiteDatabase, SQLiteDatabase.CursorFactory cursorFactory, String str, String[] strArr, String str2, CancellationSignal cancellationSignal) {
        TraceMachine.enterMethod(SQLITE, "rawQueryWithFactory", AgentConstants.TRACE_TYPE_DB);
        Cursor rawQueryWithFactory = sQLiteDatabase.rawQueryWithFactory(cursorFactory, str, strArr, str2, cancellationSignal);
        TraceMachine.exitMethod(str + Arrays.toString(strArr));
        return rawQueryWithFactory;
    }
}
