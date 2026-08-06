package com.bytedance.trae.conversation.chat.block.renderer;

import android.util.Log;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.bytedance.tracing.log.Fields;
import com.bytedance.trae.applog.api.IApplog;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.im.model.MessagePart;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: ArtifactTrack.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005H\u0002J\u0018\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005H\u0002J\u0018\u0010\u000f\u001a\u00020\u00102\b\u0010\f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\u0005J\u0016\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005J\u0018\u0010\u0013\u001a\u00020\u00102\b\u0010\f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\u0005J\u0016\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005J\u0018\u0010\u0015\u001a\u00020\u00102\b\u0010\f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\u0005J \u0010\u0016\u001a\u00020\u00102\b\u0010\f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0018J\u0018\u0010\u0019\u001a\u00020\u00102\b\u0010\f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\u0005J*\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u00052\u0017\u0010\u001c\u001a\u0013\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00100\u001d¢\u0006\u0002\b\u001fH\u0082\bJ\u0010\u0010 \u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005H\u0002J\u0012\u0010!\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u0005H\u0002J\u0012\u0010\"\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactTrack;", "", "<init>", "()V", "TAG", "", "EVENT_ARTIFACT_SHOW", "EVENT_ARTIFACT_CLICK", "EVENT_ARTIFACT_OPEN", "EVENT_ARTIFACT_OPEN_LOCAL", "EVENT_ARTIFACT_CLOSE", "normalizeArtifactPath", "filePath", "buildArtifactId", "messageId", "trackArtifactShow", "", "trackArtifactWithArtifactType", "artifactType", "trackArtifactClick", "trackArtifactClickWithArtifactType", "trackArtifactOpen", "trackArtifactClose", ReportConstant.COMMON_INIT_DURATION, "", "trackArtifactOpenLocal", "report", Fields.EVENT, "buildParams", "Lkotlin/Function1;", "Lorg/json/JSONObject;", "Lkotlin/ExtensionFunctionType;", "getArtifactType", "extractFileExtension", "extractFileName", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ArtifactTrack {
    private static final String EVENT_ARTIFACT_CLICK = "icube_artifact_click";
    private static final String EVENT_ARTIFACT_CLOSE = "icube_artifact_close";
    private static final String EVENT_ARTIFACT_OPEN = "icube_artifact_open";
    private static final String EVENT_ARTIFACT_OPEN_LOCAL = "icube_artifact_open_local";
    private static final String EVENT_ARTIFACT_SHOW = "icube_artifact_show";
    public static final ArtifactTrack INSTANCE = new ArtifactTrack();
    private static final String TAG = "ArtifactTrack";

    private ArtifactTrack() {
    }

    private final String normalizeArtifactPath(String filePath) {
        String substringBefore$default = StringsKt.substringBefore$default(StringsKt.substringBefore$default(filePath, '?', (String) null, 2, (Object) null), '#', (String) null, 2, (Object) null);
        if (StringsKt.startsWith$default(substringBefore$default, "files/", false, 2, (Object) null)) {
            substringBefore$default = StringsKt.removePrefix(substringBefore$default, "files/");
        } else if (StringsKt.startsWith$default(substringBefore$default, "files", false, 2, (Object) null)) {
            substringBefore$default = StringsKt.removePrefix(StringsKt.removePrefix(substringBefore$default, "files"), "/");
        }
        return StringsKt.removePrefix(substringBefore$default, "/");
    }

    private final String buildArtifactId(String messageId, String filePath) {
        return messageId + '_' + normalizeArtifactPath(filePath);
    }

    private final void report(String event, Function1<? super JSONObject, Unit> buildParams) {
        try {
            JSONObject jSONObject = new JSONObject();
            buildParams.invoke(jSONObject);
            if (AppHost.INSTANCE.isDebug()) {
                Log.d(TAG, "reportEvent: " + event + ", params: " + jSONObject);
            }
            IApplog.INSTANCE.reportEvent(event, jSONObject);
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:12:0x003c. Please report as an issue. */
    private final String getArtifactType(String filePath) {
        try {
            String normalizeArtifactPath = normalizeArtifactPath(filePath);
            if (!StringsKt.startsWith$default(normalizeArtifactPath, "http://", false, 2, (Object) null) && !StringsKt.startsWith$default(normalizeArtifactPath, "https://", false, 2, (Object) null)) {
                String lowerCase = extractFileExtension(normalizeArtifactPath).toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                switch (lowerCase.hashCode()) {
                    case 3479:
                        if (!lowerCase.equals("md")) {
                        }
                        return "md";
                    case 97669:
                        if (!lowerCase.equals("bmp")) {
                        }
                        return "image";
                    case 98822:
                        return !lowerCase.equals("csv") ? "others" : "csv";
                    case 99640:
                        if (!lowerCase.equals(MessagePart.TYPE_DOC)) {
                        }
                        return "docs";
                    case 102340:
                        if (!lowerCase.equals("gif")) {
                        }
                        return "image";
                    case 103649:
                        if (!lowerCase.equals("htm")) {
                        }
                        return "html";
                    case 105441:
                        if (!lowerCase.equals("jpg")) {
                        }
                        return "image";
                    case 110834:
                        if (lowerCase.equals("pdf")) {
                            return "pdf";
                        }
                    case 111145:
                        if (!lowerCase.equals("png")) {
                        }
                        return "image";
                    case 111220:
                        if (!lowerCase.equals("ppt")) {
                        }
                        return "pptx";
                    case 114276:
                        if (lowerCase.equals("svg")) {
                            return "svg";
                        }
                    case 118783:
                        if (!lowerCase.equals("xls")) {
                        }
                        return "excel";
                    case 3083269:
                        if (lowerCase.equals("diff")) {
                            return "diff";
                        }
                    case 3088960:
                        if (!lowerCase.equals("docx")) {
                        }
                        return "docs";
                    case 3213227:
                        if (!lowerCase.equals("html")) {
                        }
                        return "html";
                    case 3268712:
                        if (!lowerCase.equals("jpeg")) {
                        }
                        return "image";
                    case 3447940:
                        if (!lowerCase.equals("pptx")) {
                        }
                        return "pptx";
                    case 3559925:
                        if (!lowerCase.equals("tiff")) {
                        }
                        return "image";
                    case 3645340:
                        if (!lowerCase.equals("webp")) {
                        }
                        return "image";
                    case 3682393:
                        if (!lowerCase.equals("xlsx")) {
                        }
                        return "excel";
                    case 114035747:
                        if (!lowerCase.equals("xhtml")) {
                        }
                        return "html";
                    case 246938863:
                        if (!lowerCase.equals("markdown")) {
                        }
                        return "md";
                    default:
                }
            }
            return "http_url";
        } catch (Throwable unused) {
            return "";
        }
    }

    private final String extractFileExtension(String filePath) {
        String str = filePath;
        if (str == null || str.length() == 0) {
            return "";
        }
        String extractFileName = extractFileName(filePath);
        int lastIndexOf$default = StringsKt.lastIndexOf$default(extractFileName, '.', 0, false, 6, (Object) null);
        if (lastIndexOf$default <= 0) {
            return "";
        }
        String substring = extractFileName.substring(lastIndexOf$default + 1);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        return substring;
    }

    private final String extractFileName(String filePath) {
        String str = filePath;
        if (str == null || str.length() == 0) {
            return "";
        }
        return StringsKt.substringAfterLast$default(filePath, StringsKt.contains$default(str, '\\', false, 2, (Object) null) ? '\\' : '/', (String) null, 2, (Object) null);
    }

    public final void trackArtifactShow(String filePath, String messageId) {
        Intrinsics.checkNotNullParameter(messageId, "messageId");
        if (filePath == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            ArtifactTrack artifactTrack = INSTANCE;
            jSONObject.put("artifact_id", artifactTrack.buildArtifactId(messageId, filePath));
            jSONObject.put("artifact_type", artifactTrack.getArtifactType(filePath));
            if (AppHost.INSTANCE.isDebug()) {
                Log.d(TAG, "reportEvent: icube_artifact_show, params: " + jSONObject);
            }
            IApplog.INSTANCE.reportEvent(EVENT_ARTIFACT_SHOW, jSONObject);
        } catch (Throwable unused) {
        }
    }

    public final void trackArtifactWithArtifactType(String artifactType, String messageId) {
        Intrinsics.checkNotNullParameter(artifactType, "artifactType");
        Intrinsics.checkNotNullParameter(messageId, "messageId");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("artifact_id", messageId + '_' + artifactType);
            jSONObject.put("artifact_type", artifactType);
            if (AppHost.INSTANCE.isDebug()) {
                Log.d(TAG, "reportEvent: icube_artifact_show, params: " + jSONObject);
            }
            IApplog.INSTANCE.reportEvent(EVENT_ARTIFACT_SHOW, jSONObject);
        } catch (Throwable unused) {
        }
    }

    public final void trackArtifactClick(String filePath, String messageId) {
        Intrinsics.checkNotNullParameter(messageId, "messageId");
        if (filePath == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            ArtifactTrack artifactTrack = INSTANCE;
            jSONObject.put("artifact_id", artifactTrack.buildArtifactId(messageId, filePath));
            jSONObject.put("artifact_type", artifactTrack.getArtifactType(filePath));
            if (AppHost.INSTANCE.isDebug()) {
                Log.d(TAG, "reportEvent: icube_artifact_click, params: " + jSONObject);
            }
            IApplog.INSTANCE.reportEvent(EVENT_ARTIFACT_CLICK, jSONObject);
        } catch (Throwable unused) {
        }
    }

    public final void trackArtifactClickWithArtifactType(String artifactType, String messageId) {
        Intrinsics.checkNotNullParameter(artifactType, "artifactType");
        Intrinsics.checkNotNullParameter(messageId, "messageId");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("artifact_id", messageId + '_' + artifactType);
            jSONObject.put("artifact_type", artifactType);
            if (AppHost.INSTANCE.isDebug()) {
                Log.d(TAG, "reportEvent: icube_artifact_click, params: " + jSONObject);
            }
            IApplog.INSTANCE.reportEvent(EVENT_ARTIFACT_CLICK, jSONObject);
        } catch (Throwable unused) {
        }
    }

    public final void trackArtifactOpen(String filePath, String messageId) {
        Intrinsics.checkNotNullParameter(messageId, "messageId");
        if (filePath == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            ArtifactTrack artifactTrack = INSTANCE;
            jSONObject.put("artifact_id", artifactTrack.buildArtifactId(messageId, filePath));
            jSONObject.put("artifact_type", artifactTrack.getArtifactType(filePath));
            if (AppHost.INSTANCE.isDebug()) {
                Log.d(TAG, "reportEvent: icube_artifact_open, params: " + jSONObject);
            }
            IApplog.INSTANCE.reportEvent(EVENT_ARTIFACT_OPEN, jSONObject);
        } catch (Throwable unused) {
        }
    }

    public final void trackArtifactClose(String filePath, String messageId, long duration) {
        Intrinsics.checkNotNullParameter(messageId, "messageId");
        if (filePath == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            ArtifactTrack artifactTrack = INSTANCE;
            jSONObject.put("artifact_id", artifactTrack.buildArtifactId(messageId, filePath));
            jSONObject.put("artifact_type", artifactTrack.getArtifactType(filePath));
            jSONObject.put("stay_time", duration);
            if (AppHost.INSTANCE.isDebug()) {
                Log.d(TAG, "reportEvent: icube_artifact_close, params: " + jSONObject);
            }
            IApplog.INSTANCE.reportEvent(EVENT_ARTIFACT_CLOSE, jSONObject);
        } catch (Throwable unused) {
        }
    }

    public final void trackArtifactOpenLocal(String filePath, String messageId) {
        Intrinsics.checkNotNullParameter(messageId, "messageId");
        if (filePath == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            ArtifactTrack artifactTrack = INSTANCE;
            jSONObject.put("artifact_id", artifactTrack.buildArtifactId(messageId, filePath));
            jSONObject.put("artifact_type", artifactTrack.getArtifactType(filePath));
            if (AppHost.INSTANCE.isDebug()) {
                Log.d(TAG, "reportEvent: icube_artifact_open_local, params: " + jSONObject);
            }
            IApplog.INSTANCE.reportEvent(EVENT_ARTIFACT_OPEN_LOCAL, jSONObject);
        } catch (Throwable unused) {
        }
    }
}
