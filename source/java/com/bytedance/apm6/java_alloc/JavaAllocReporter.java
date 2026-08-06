package com.bytedance.apm6.java_alloc;

import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.util.log.Logger;
import com.bytedance.services.apm.api.EnsureManager;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class JavaAllocReporter {
    private static final Charset US_ASCII = StandardCharsets.US_ASCII;
    private final ReportInfoReader reportInfoReader = new ReportInfoReader();

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static class ReportInfoReader implements IRecordReader {
        private JavaAllocConfig currentConfig;
        private long endTime;
        private String scene;
        private long startTime;
        private final ReportTraceReader traceReader = new ReportTraceReader();

        @Override // com.bytedance.apm6.java_alloc.IRecordReader
        public void onHeadInfo(String str, long j, long j2, int i, JavaAllocConfig javaAllocConfig, long j3, long j4) {
            this.currentConfig = javaAllocConfig;
            this.startTime = j3;
            this.endTime = j4;
            this.scene = str;
            if (ApmContext.isDebugMode()) {
                Logger.m119d("JavaAllocReporter", "report totalObjectsCount: " + j + ", totalBytes: " + j2 + ", recordCount: " + i);
            }
        }

        @Override // com.bytedance.apm6.java_alloc.IRecordReader
        public boolean onItem(String str, int i, int i2, Trace trace, int i3) {
            trace.onTrace(this.traceReader);
            if (this.traceReader.elements.size() > 0) {
                reportCustom(str, i, i2, this.traceReader.elements, i3);
            }
            this.traceReader.clear();
            return true;
        }

        void reportCustom(String str, int i, int i2, List<StackTraceElement> list, int i3) {
            AllocThrowable allocThrowable = new AllocThrowable("java_alloc(" + (i3 == 1 ? "HighFrequency" : "LargeObject") + ") class: " + str, (StackTraceElement[]) list.toArray(new StackTraceElement[0]));
            if (ApmContext.isDebugMode()) {
                Logger.m119d("JavaAllocReporter", "report class: " + str + ", java_alloc count: " + i + ", bytes: " + i2 + ", trace: " + this.traceReader.result.toString());
            }
            HashMap hashMap = new HashMap();
            hashMap.put("java_alloc_count", String.valueOf(i));
            hashMap.put("java_alloc_size", String.valueOf(i2));
            hashMap.put("java_alloc_sample", String.valueOf(this.currentConfig.collect_per_thousand_alloc));
            hashMap.put("java_alloc_count_threshold", String.valueOf(this.currentConfig.threshold_alloc_frequency));
            hashMap.put("java_alloc_size_threshold", String.valueOf(this.currentConfig.threshold_alloc_size));
            hashMap.put("java_alloc_duration", String.valueOf(this.endTime - this.startTime));
            hashMap.put("java_alloc_scene", this.scene);
            EnsureManager.ensureNotReachHere(allocThrowable, "java_alloc", hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static final class AllocThrowable extends Throwable {
        private final StackTraceElement[] elements;
        private final String msg;

        public AllocThrowable(String str, StackTraceElement[] stackTraceElementArr) {
            this.msg = str;
            this.elements = stackTraceElementArr;
        }

        @Override // java.lang.Throwable
        public synchronized Throwable fillInStackTrace() {
            return this;
        }

        @Override // java.lang.Throwable
        public StackTraceElement[] getStackTrace() {
            return this.elements;
        }

        @Override // java.lang.Throwable
        public String toString() {
            return this.msg;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static class ReportTraceReader implements ITraceReader {
        private final char[] charArrayBuffer;
        private final List<StackTraceElement> elements;
        private final StringBuilder result;

        private ReportTraceReader() {
            this.elements = new ArrayList();
            this.result = new StringBuilder();
            this.charArrayBuffer = new char[4096];
        }

        @Override // com.bytedance.apm6.java_alloc.ITraceReader
        public boolean onItem(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
            if (ApmContext.isDebugMode()) {
                this.result.append("  at ").append(JavaAllocReporter.convertAscii(bArr, this.charArrayBuffer, i), 0, i).append('(').append(JavaAllocReporter.convertAscii(bArr2, this.charArrayBuffer, i2), 0, i2).append(':').append(i3).append(")\n");
            }
            String valueOf = String.valueOf(JavaAllocReporter.convertAscii(bArr, this.charArrayBuffer, i), 0, i);
            String valueOf2 = String.valueOf(JavaAllocReporter.convertAscii(bArr2, this.charArrayBuffer, i2), 0, i2);
            int lastIndexOf = valueOf.lastIndexOf(46);
            this.elements.add(new StackTraceElement(valueOf.substring(0, lastIndexOf), valueOf.substring(lastIndexOf + 1, i), valueOf2, i3));
            return true;
        }

        public void clear() {
            this.elements.clear();
            this.result.setLength(0);
        }
    }

    static char[] convertAscii(byte[] bArr, char[] cArr, int i) {
        int i2 = 0;
        if (i > cArr.length) {
            int length = i - cArr.length;
            while (i2 < cArr.length) {
                cArr[i2] = (char) (bArr[i2 + length] & 255);
                i2++;
            }
        } else {
            while (i2 < i) {
                cArr[i2] = (char) (bArr[i2] & 255);
                i2++;
            }
        }
        return cArr;
    }

    public void report() {
        JavaAllocCollector.getInstance().getReportInfo(this.reportInfoReader);
    }
}
