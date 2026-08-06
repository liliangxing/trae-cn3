package com.bytedance.trae.kmp.artifacts.artifact;

import kotlin.Metadata;
import kotlin.ULong;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlin.text.UStringsKt;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;

/* compiled from: ArtifactModels.kt */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a4\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0004\u001a\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b\u001a\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004H\u0000\u001a\f\u0010\u000e\u001a\u00020\u0004*\u00020\u000bH\u0002\u001a\u000e\u0010\u000f\u001a\u0004\u0018\u00010\u0010*\u00020\u0011H\u0002\u001a\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0011H\u0002\u001a\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u0010*\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0004H\u0002\u001a\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u000b*\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0004H\u0002¢\u0006\u0002\u0010\u0018\u001a\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u0004*\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0004H\u0002¨\u0006\u001a"}, d2 = {"toOpenRequest", "Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;", "Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactDescriptor;", "conversationId", "", "messageId", "cliConversationId", "cliType", "turnId", "formatVideoDuration", "seconds", "", "stableHash", "value", "twoDigits", "objectOrNull", "Lkotlinx/serialization/json/JsonObject;", "Lkotlinx/serialization/json/JsonElement;", "arrayOrNull", "Lkotlinx/serialization/json/JsonArray;", "element", "objectValue", "key", "int", "(Lkotlinx/serialization/json/JsonObject;Ljava/lang/String;)Ljava/lang/Integer;", "string", "artifacts_mainlandRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ArtifactModelsKt {
    public static final ArtifactOpenRequest toOpenRequest(VideoArtifactDescriptor videoArtifactDescriptor, String str, String str2, String str3, String str4, String str5) {
        Intrinsics.checkNotNullParameter(videoArtifactDescriptor, "<this>");
        Intrinsics.checkNotNullParameter(str, "conversationId");
        Intrinsics.checkNotNullParameter(str2, "messageId");
        Intrinsics.checkNotNullParameter(str3, "cliConversationId");
        Intrinsics.checkNotNullParameter(str4, "cliType");
        return new ArtifactOpenRequest(videoArtifactDescriptor.getArtifactId(), ArtifactKind.Video, videoArtifactDescriptor.getFilePath(), videoArtifactDescriptor.getLastFrameUri(), videoArtifactDescriptor.getDurationSeconds(), videoArtifactDescriptor.getFileAction(), str, str2, str3, str4, str5);
    }

    public static final String formatVideoDuration(int i) {
        int coerceAtLeast = RangesKt.coerceAtLeast(i, 0);
        int i2 = coerceAtLeast / 3600;
        int i3 = (coerceAtLeast % 3600) / 60;
        int i4 = coerceAtLeast % 60;
        if (i2 > 0) {
            return i2 + ':' + twoDigits(i3) + ':' + twoDigits(i4);
        }
        return twoDigits(i3) + ':' + twoDigits(i4);
    }

    public static final String stableHash(String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        long j = -3750763034638185243L;
        for (int i = 0; i < StringsKt.encodeToByteArray(str).length; i++) {
            j = (j ^ (r8[i] & 255)) * 1099511628211L;
        }
        return StringsKt.padStart(UStringsKt.toString-JSWoG40(ULong.constructor-impl(j), 16), 16, '0');
    }

    private static final String twoDigits(int i) {
        return StringsKt.padStart(String.valueOf(i), 2, '0');
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final JsonObject objectOrNull(JsonElement jsonElement) {
        if (jsonElement instanceof JsonObject) {
            return (JsonObject) jsonElement;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final JsonArray arrayOrNull(JsonElement jsonElement) {
        if (jsonElement instanceof JsonArray) {
            return (JsonArray) jsonElement;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final JsonObject objectValue(JsonObject jsonObject, String str) {
        JsonElement jsonElement = (JsonElement) jsonObject.get(str);
        if (jsonElement != null) {
            return objectOrNull(jsonElement);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: int, reason: not valid java name */
    public static final Integer m845int(JsonObject jsonObject, String str) {
        Object obj = jsonObject.get(str);
        JsonPrimitive jsonPrimitive = obj instanceof JsonPrimitive ? (JsonPrimitive) obj : null;
        if (jsonPrimitive != null) {
            return JsonElementKt.getIntOrNull(jsonPrimitive);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String string(JsonObject jsonObject, String str) {
        Object obj = jsonObject.get(str);
        JsonPrimitive jsonPrimitive = obj instanceof JsonPrimitive ? (JsonPrimitive) obj : null;
        if (jsonPrimitive != null) {
            return JsonElementKt.getContentOrNull(jsonPrimitive);
        }
        return null;
    }
}
