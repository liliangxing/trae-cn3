package com.bytedance.trae.kmp.artifacts.artifact;

import com.bytedance.ies.bullet.kit.resourceloader.monitor.RLMonitorReporter;
import com.bytedance.lynx.service.reporter.performance.LynxTimingPerformanceReportProcessor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonKt;
import kotlinx.serialization.json.JsonObject;

/* compiled from: ArtifactModels.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bJ\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\n\u001a\u00020\bJ\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0005J\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0005H\u0002J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u000fH\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u000fH\u0002J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0011\u001a\u00020\u0013H\u0002J,\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\bH\u0002R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\b0\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactParser;", "", "<init>", "()V", RLMonitorReporter.PARSE, "", "Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactDescriptor;", "rawAssistantContent", "", "parsePlanItemsJson", "planItemsJson", "parseInputs", "planItems", "Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactPlanItemInput;", "parseJsonPlanItems", "Lkotlinx/serialization/json/JsonObject;", "planItemInput", "item", "fileInput", "Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactFileInput;", "descriptor", "stableArtifactId", "filePath", "lastFrameUri", LynxTimingPerformanceReportProcessor.KEY_DURATION, "", "fileAction", "finishTools", "", "json", "Lkotlinx/serialization/json/Json;", "artifacts_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class VideoArtifactParser {
    public static final VideoArtifactParser INSTANCE = new VideoArtifactParser();
    private static final Set<String> finishTools = SetsKt.setOf(new String[]{"finish", "Finish", "agent_finish", "response_to_user", "ResponseToUser", "Task"});
    private static final Json json = JsonKt.Json$default((Json) null, new Function1() { // from class: com.bytedance.trae.kmp.artifacts.artifact.VideoArtifactParser$$ExternalSyntheticLambda4
        public final Object invoke(Object obj) {
            Unit json$lambda$16;
            json$lambda$16 = VideoArtifactParser.json$lambda$16((JsonBuilder) obj);
            return json$lambda$16;
        }
    }, 1, (Object) null);
    public static final int $stable = 8;

    private VideoArtifactParser() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0040, code lost:
    
        r5 = com.bytedance.trae.kmp.artifacts.artifact.ArtifactModelsKt.arrayOrNull(r5);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<VideoArtifactDescriptor> parse(String rawAssistantContent) {
        Object obj;
        Iterable arrayOrNull;
        JsonObject objectOrNull;
        JsonElement jsonElement;
        Intrinsics.checkNotNullParameter(rawAssistantContent, "rawAssistantContent");
        try {
            Result.Companion companion = Result.Companion;
            VideoArtifactParser videoArtifactParser = this;
            obj = Result.constructor-impl(JsonElementKt.getJsonObject(json.parseToJsonElement(rawAssistantContent)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        ArrayList arrayList = null;
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        JsonObject jsonObject = (JsonObject) obj;
        if (jsonObject == null) {
            return CollectionsKt.emptyList();
        }
        JsonElement jsonElement2 = (JsonElement) jsonObject.get("messages");
        if (jsonElement2 != null && arrayOrNull != null) {
            ArrayList arrayList2 = new ArrayList();
            Iterator it = arrayOrNull.iterator();
            while (it.hasNext()) {
                objectOrNull = ArtifactModelsKt.objectOrNull((JsonElement) it.next());
                JsonObject objectOrNull2 = (objectOrNull == null || (jsonElement = (JsonElement) objectOrNull.get("plan_item")) == null) ? null : ArtifactModelsKt.objectOrNull(jsonElement);
                if (objectOrNull2 != null) {
                    arrayList2.add(objectOrNull2);
                }
            }
            arrayList = arrayList2;
        }
        if (arrayList == null) {
            arrayList = CollectionsKt.emptyList();
        }
        return parseJsonPlanItems(arrayList);
    }

    public final List<VideoArtifactDescriptor> parsePlanItemsJson(String planItemsJson) {
        Object obj;
        JsonObject objectOrNull;
        Intrinsics.checkNotNullParameter(planItemsJson, "planItemsJson");
        try {
            Result.Companion companion = Result.Companion;
            VideoArtifactParser videoArtifactParser = this;
            Iterable jsonArray = JsonElementKt.getJsonArray(json.parseToJsonElement(planItemsJson));
            ArrayList arrayList = new ArrayList();
            Iterator it = jsonArray.iterator();
            while (it.hasNext()) {
                objectOrNull = ArtifactModelsKt.objectOrNull((JsonElement) it.next());
                if (objectOrNull != null) {
                    arrayList.add(objectOrNull);
                }
            }
            obj = Result.constructor-impl(arrayList);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        List<JsonObject> list = (List) obj;
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        return parseJsonPlanItems(list);
    }

    public final List<VideoArtifactDescriptor> parseInputs(List<VideoArtifactPlanItemInput> planItems) {
        final String str;
        Intrinsics.checkNotNullParameter(planItems, "planItems");
        if (planItems.isEmpty()) {
            return CollectionsKt.emptyList();
        }
        List<VideoArtifactPlanItemInput> list = planItems;
        Iterator<T> it = list.iterator();
        do {
            str = null;
            if (!it.hasNext()) {
                break;
            }
            String agentRunId = ((VideoArtifactPlanItemInput) it.next()).getAgentRunId();
            if (agentRunId != null && (!StringsKt.isBlank(agentRunId))) {
                str = agentRunId;
            }
        } while (str == null);
        return SequencesKt.toList(SequencesKt.mapNotNull(SequencesKt.flatMap(SequencesKt.filter(SequencesKt.filter(SequencesKt.filter(CollectionsKt.asSequence(list), new Function1() { // from class: com.bytedance.trae.kmp.artifacts.artifact.VideoArtifactParser$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                boolean parseInputs$lambda$6;
                parseInputs$lambda$6 = VideoArtifactParser.parseInputs$lambda$6(str, (VideoArtifactPlanItemInput) obj);
                return Boolean.valueOf(parseInputs$lambda$6);
            }
        }), new Function1() { // from class: com.bytedance.trae.kmp.artifacts.artifact.VideoArtifactParser$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                boolean parseInputs$lambda$7;
                parseInputs$lambda$7 = VideoArtifactParser.parseInputs$lambda$7((VideoArtifactPlanItemInput) obj);
                return Boolean.valueOf(parseInputs$lambda$7);
            }
        }), new Function1() { // from class: com.bytedance.trae.kmp.artifacts.artifact.VideoArtifactParser$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                boolean parseInputs$lambda$8;
                parseInputs$lambda$8 = VideoArtifactParser.parseInputs$lambda$8((VideoArtifactPlanItemInput) obj);
                return Boolean.valueOf(parseInputs$lambda$8);
            }
        }), new Function1() { // from class: com.bytedance.trae.kmp.artifacts.artifact.VideoArtifactParser$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                Sequence parseInputs$lambda$9;
                parseInputs$lambda$9 = VideoArtifactParser.parseInputs$lambda$9((VideoArtifactPlanItemInput) obj);
                return parseInputs$lambda$9;
            }
        }), new VideoArtifactParser$parseInputs$5(this)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean parseInputs$lambda$6(String str, VideoArtifactPlanItemInput videoArtifactPlanItemInput) {
        Intrinsics.checkNotNullParameter(videoArtifactPlanItemInput, "item");
        String agentRunId = videoArtifactPlanItemInput.getAgentRunId();
        if (str == null) {
            return true;
        }
        String str2 = agentRunId;
        return (str2 == null || StringsKt.isBlank(str2)) || Intrinsics.areEqual(agentRunId, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean parseInputs$lambda$7(VideoArtifactPlanItemInput videoArtifactPlanItemInput) {
        Intrinsics.checkNotNullParameter(videoArtifactPlanItemInput, "item");
        return CollectionsKt.contains(finishTools, videoArtifactPlanItemInput.getToolName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean parseInputs$lambda$8(VideoArtifactPlanItemInput videoArtifactPlanItemInput) {
        Intrinsics.checkNotNullParameter(videoArtifactPlanItemInput, "item");
        String resultStatus = videoArtifactPlanItemInput.getResultStatus();
        return (resultStatus == null || StringsKt.isBlank(resultStatus)) || Intrinsics.areEqual(videoArtifactPlanItemInput.getResultStatus(), "success");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Sequence parseInputs$lambda$9(VideoArtifactPlanItemInput videoArtifactPlanItemInput) {
        Intrinsics.checkNotNullParameter(videoArtifactPlanItemInput, "item");
        return CollectionsKt.asSequence(videoArtifactPlanItemInput.getFiles());
    }

    private final List<VideoArtifactDescriptor> parseJsonPlanItems(List<JsonObject> planItems) {
        List<JsonObject> list = planItems;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(planItemInput((JsonObject) it.next()));
        }
        return parseInputs(arrayList);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0038, code lost:
    
        r3 = com.bytedance.trae.kmp.artifacts.artifact.ArtifactModelsKt.arrayOrNull(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0015, code lost:
    
        r3 = com.bytedance.trae.kmp.artifacts.artifact.ArtifactModelsKt.objectValue(r2, "data");
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x001d, code lost:
    
        r3 = com.bytedance.trae.kmp.artifacts.artifact.ArtifactModelsKt.objectValue(r3, "products");
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0026, code lost:
    
        r3 = com.bytedance.trae.kmp.artifacts.artifact.ArtifactModelsKt.objectValue(r3, "changed_videos");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final VideoArtifactPlanItemInput planItemInput(JsonObject item) {
        JsonObject objectValue;
        ArrayList arrayList;
        String string;
        JsonObject objectValue2;
        JsonObject objectValue3;
        JsonObject objectValue4;
        Iterable arrayOrNull;
        JsonObject objectOrNull;
        objectValue = ArtifactModelsKt.objectValue(item, "tool_call_info");
        JsonObject objectValue5 = objectValue != null ? ArtifactModelsKt.objectValue(objectValue, "result") : null;
        if (objectValue5 == null || objectValue2 == null || objectValue3 == null || objectValue4 == null || (r3 = (JsonElement) objectValue4.get("file_diff_infos")) == null || arrayOrNull == null) {
            arrayList = null;
        } else {
            ArrayList arrayList2 = new ArrayList();
            Iterator it = arrayOrNull.iterator();
            while (it.hasNext()) {
                objectOrNull = ArtifactModelsKt.objectOrNull((JsonElement) it.next());
                VideoArtifactFileInput fileInput = objectOrNull != null ? INSTANCE.fileInput(objectOrNull) : null;
                if (fileInput != null) {
                    arrayList2.add(fileInput);
                }
            }
            arrayList = arrayList2;
        }
        if (arrayList == null) {
            arrayList = CollectionsKt.emptyList();
        }
        string = ArtifactModelsKt.string(item, "agent_run_id");
        return new VideoArtifactPlanItemInput(string, objectValue != null ? ArtifactModelsKt.string(objectValue, "name") : null, objectValue5 != null ? ArtifactModelsKt.string(objectValue5, "status") : null, arrayList);
    }

    private final VideoArtifactFileInput fileInput(JsonObject item) {
        JsonObject objectValue;
        String string;
        String string2;
        VideoArtifactInfoInput videoArtifactInfoInput;
        String string3;
        Integer m845int;
        objectValue = ArtifactModelsKt.objectValue(item, "video_info");
        string = ArtifactModelsKt.string(item, "file_path");
        string2 = ArtifactModelsKt.string(item, "file_action");
        if (objectValue != null) {
            string3 = ArtifactModelsKt.string(objectValue, "last_frame_uri");
            m845int = ArtifactModelsKt.m845int(objectValue, LynxTimingPerformanceReportProcessor.KEY_DURATION);
            videoArtifactInfoInput = new VideoArtifactInfoInput(string3, m845int);
        } else {
            videoArtifactInfoInput = null;
        }
        return new VideoArtifactFileInput(string, string2, videoArtifactInfoInput);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final VideoArtifactDescriptor descriptor(VideoArtifactFileInput item) {
        Integer durationSeconds;
        String lastFrameUri;
        String obj;
        String filePath = item.getFilePath();
        String obj2 = filePath != null ? StringsKt.trim(filePath).toString() : null;
        if (obj2 == null) {
            obj2 = "";
        }
        String str = obj2;
        String fileAction = item.getFileAction();
        if (StringsKt.isBlank(str) || StringsKt.equals(fileAction, "deleted", true)) {
            return null;
        }
        VideoArtifactInfoInput videoInfo = item.getVideoInfo();
        String str2 = (videoInfo == null || (lastFrameUri = videoInfo.getLastFrameUri()) == null || (obj = StringsKt.trim(lastFrameUri).toString()) == null || !(true ^ StringsKt.isBlank(obj))) ? null : obj;
        VideoArtifactInfoInput videoInfo2 = item.getVideoInfo();
        int intValue = (videoInfo2 == null || (durationSeconds = videoInfo2.getDurationSeconds()) == null) ? 0 : durationSeconds.intValue();
        return new VideoArtifactDescriptor(stableArtifactId(str, str2, intValue, fileAction), str, str2, RangesKt.coerceAtLeast(intValue, 0), fileAction);
    }

    private final String stableArtifactId(String filePath, String lastFrameUri, int duration, String fileAction) {
        StringBuilder append = new StringBuilder().append(filePath).append('|');
        if (lastFrameUri == null) {
            lastFrameUri = "";
        }
        StringBuilder append2 = append.append(lastFrameUri).append('|').append(duration).append('|');
        if (fileAction == null) {
            fileAction = "";
        }
        return ArtifactModelsKt.stableHash(append2.append(fileAction).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit json$lambda$16(JsonBuilder jsonBuilder) {
        Intrinsics.checkNotNullParameter(jsonBuilder, "$this$Json");
        jsonBuilder.setIgnoreUnknownKeys(true);
        return Unit.INSTANCE;
    }
}
