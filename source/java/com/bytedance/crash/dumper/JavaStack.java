package com.bytedance.crash.dumper;

import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.crash.dumper.tools.JsonDumper;
import com.bytedance.crash.util.FileSystemUtils;
import com.bytedance.crash.util.JSONUtils;
import com.bytedance.librarian.LibrarianImpl;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class JavaStack {
    private static final String ABORT_MESSAGE_FILE_NAME = "abort.txt";
    public static final String ALL_THREAD_STACKS = "all_thread_stacks";
    private static final String MAIN_STACK_FILE_NAME = "main_stack.txt";
    private static final String STACK_AT_NATIVE_FILE_NAME = "jstack.txt";
    private static final String TTWEBVIEW_END_TAG = " ttwebview:";
    private static final String TTWEBVIEW_MIDDLE_TAG = "Please include Java exception stack in crash report";
    private static final String TTWEBVIEW_START_TAG = "[FATAL:";

    public static StackResult dumpMainStack(File file) {
        StackResult stackResult = new StackResult(Looper.getMainLooper().getThread().getStackTrace());
        FileSystemUtils.writeFile(file, MAIN_STACK_FILE_NAME, stackResult.getStack());
        return stackResult;
    }

    public static String getMainStack() {
        return new StackResult(Looper.getMainLooper().getThread().getStackTrace()).getStack();
    }

    public static String getMainStack(File file) {
        return FileSystemUtils.readUtf8File(new File(file, MAIN_STACK_FILE_NAME));
    }

    public static boolean isStackFromTrace(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("{\"mainStackFromTrace\":\"\\\"main\\\"");
    }

    public static void pushStackCapturedAtNative(JSONObject jSONObject, File file) {
        String readUtf8File;
        File file2 = new File(file, STACK_AT_NATIVE_FILE_NAME);
        File file3 = new File(file, ABORT_MESSAGE_FILE_NAME);
        String readUtf8File2 = file2.exists() ? FileSystemUtils.readUtf8File(file2) : null;
        if (file3.exists() && (readUtf8File = FileSystemUtils.readUtf8File(file3)) != null && readUtf8File.startsWith(TTWEBVIEW_START_TAG) && readUtf8File.contains("Please include Java exception stack in crash report ttwebview:")) {
            StringBuilder sb = new StringBuilder();
            sb.append(readUtf8File2);
            int indexOf = readUtf8File.indexOf(TTWEBVIEW_END_TAG);
            sb.append("Caused by: Please include Java exception stack in crash report\n");
            sb.append(readUtf8File.substring(indexOf + 11));
            readUtf8File2 = sb.toString();
        }
        if (TextUtils.isEmpty(readUtf8File2)) {
            return;
        }
        JSONUtils.put(jSONObject, "java_data", readUtf8File2);
    }

    public static void dumpAllStack(File file) {
        Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
        if (allStackTraces.isEmpty()) {
            return;
        }
        JsonDumper jsonDumper = new JsonDumper(file.getAbsolutePath() + "/all_thread_stacks.json");
        jsonDumper.objectBegin();
        jsonDumper.key(ALL_THREAD_STACKS);
        jsonDumper.objectBegin();
        jsonDumper.key("thread_all_count").value(allStackTraces.size()).next();
        jsonDumper.key("thread_stacks");
        jsonDumper.arrayBegin();
        boolean z = true;
        for (Map.Entry<Thread, StackTraceElement[]> entry : allStackTraces.entrySet()) {
            StackTraceElement[] value = entry.getValue();
            if (z) {
                z = false;
            } else {
                jsonDumper.next();
            }
            jsonDumper.objectBegin();
            Thread key = entry.getKey();
            jsonDumper.key(CrashHianalyticsData.THREAD_NAME).append('\"').append(key.getName()).append('(').append(key.getId()).append(')').append('\"');
            jsonDumper.next();
            jsonDumper.key("thread_stack");
            jsonDumper.arrayBegin();
            if (value.length > 0) {
                for (int i = 0; i < value.length; i++) {
                    StackTraceElement stackTraceElement = value[i];
                    jsonDumper.append('\"').append(stackTraceElement.getClassName()).append('.').append(stackTraceElement.getMethodName()).append('(').append(stackTraceElement.getFileName()).append(AbstractJsonLexerKt.COLON).append(stackTraceElement.getLineNumber()).append(')').append('\"');
                    if (i != value.length - 1) {
                        jsonDumper.next();
                    }
                }
            } else {
                jsonDumper.append("\"(Native Method)\"");
            }
            jsonDumper.arrayEnd();
            jsonDumper.objectEnd();
        }
        jsonDumper.arrayEnd();
        jsonDumper.objectEnd();
        jsonDumper.objectEnd();
        jsonDumper.release();
    }

    public static void pushAllStackTo(JSONObject jSONObject, File file) {
        String readUtf8File = FileSystemUtils.readUtf8File(new File(file, "all_thread_stacks.json"));
        if (readUtf8File != null) {
            try {
                JSONUtils.combineJson(jSONObject, new JSONObject(readUtf8File));
            } catch (Throwable unused) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class StackResult {
        private final String mStack;
        private final StackTraceElement[] mStackTraceElement;
        private final long mTime = System.currentTimeMillis();

        public StackResult(StackTraceElement[] stackTraceElementArr) {
            this.mStackTraceElement = stackTraceElementArr;
            this.mStack = formatStackTraceElements(stackTraceElementArr);
        }

        private String formatStackTraceElements(StackTraceElement[] stackTraceElementArr) {
            StringBuilder sb = new StringBuilder();
            for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                sb.append("  at ").append(stackTraceElement.getClassName()).append(LibrarianImpl.Constants.DOT).append(stackTraceElement.getMethodName()).append("(").append(stackTraceElement.getFileName()).append(Constants.COLON_SEPARATOR).append(stackTraceElement.getLineNumber()).append(")\n");
            }
            return sb.toString();
        }

        public StackTraceElement[] getStackTraceElements() {
            return this.mStackTraceElement;
        }

        public String getStack() {
            return this.mStack;
        }

        public long getTime() {
            return this.mTime;
        }
    }
}
