package com.bytedance.trae.conversation.brainstorm.widget;

import com.bytedance.sdk.account.monitor.AccountMonitorConstants;
import com.bytedance.sdk.account.save.database.DBData;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.bytedance.trae.conversation.brainstorm.widget.UserHistoryPart;
import com.bytedance.trae.im.model.MessagePart;
import com.bytedance.trae.utils.logger.FLogger;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: VoiceHistoryContentParser.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0002J#\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00110\u0010\"\u00020\u0011H\u0002¢\u0006\u0002\u0010\u0012J\u0014\u0010\u0013\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u0005H\u0002J\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceHistoryContentParser;", "", "<init>", "()V", "TAG", "", "parseUserContent", "", "Lcom/bytedance/trae/conversation/brainstorm/widget/UserHistoryPart;", AccountMonitorConstants.CommonParameter.RAW, "fallbackFilenameFromUri", "uri", "REMOTE_RESOURCE_PREFIX", "CHAT_SESSION_ID_KEYS", "extractChatSessionId", "sources", "", "Lcom/google/gson/JsonObject;", "([Lcom/google/gson/JsonObject;)Ljava/lang/String;", "normalizeRemoteResourceUri", "normalizeImageUri", "IMAGE_EXT", "", "isImageByFilename", "", "filename", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class VoiceHistoryContentParser {
    private static final String REMOTE_RESOURCE_PREFIX = "trae-res://remote_resource/";
    private static final String TAG = "VoiceHistoryParser";
    public static final VoiceHistoryContentParser INSTANCE = new VoiceHistoryContentParser();
    private static final List<String> CHAT_SESSION_ID_KEYS = CollectionsKt.listOf(new String[]{"chat_session_id", "chatSessionId", "cli_conversation_id", "cliConversationId", "parent_chat_session_id", "parentChatSessionId", "voice_conversation_id", "voiceConversationId", "session_id", "sessionId", "session"});
    private static final Set<String> IMAGE_EXT = SetsKt.setOf(new String[]{"jpg", "jpeg", "png", "gif", "webp", "bmp", "heic", "heif"});

    private VoiceHistoryContentParser() {
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0291 A[Catch: all -> 0x02ea, TryCatch #0 {all -> 0x02ea, blocks: (B:53:0x00c1, B:161:0x00dd, B:164:0x00e4, B:166:0x00ec, B:170:0x00f6, B:173:0x0103, B:175:0x0109, B:179:0x0113, B:182:0x011c, B:184:0x0122, B:188:0x012c, B:191:0x0135, B:193:0x013b, B:197:0x0145, B:198:0x014e, B:220:0x015d, B:223:0x0169, B:203:0x018b, B:208:0x0199, B:210:0x01a8, B:211:0x01ae, B:213:0x01b6, B:214:0x01bf, B:136:0x01d7, B:139:0x01e0, B:141:0x01e8, B:145:0x01f2, B:148:0x01fb, B:151:0x0205, B:59:0x0212, B:62:0x021c, B:64:0x0222, B:68:0x022c, B:71:0x0235, B:73:0x023b, B:77:0x0245, B:80:0x024e, B:82:0x0254, B:86:0x025e, B:87:0x0267, B:89:0x0270, B:93:0x027a, B:96:0x0283, B:100:0x0291, B:105:0x029f, B:107:0x02a7, B:110:0x02b3, B:111:0x02b9, B:113:0x02cc, B:114:0x02d0), top: B:52:0x00c1 }] */
    /* JADX WARN: Removed duplicated region for block: B:107:0x02a7 A[Catch: all -> 0x02ea, TryCatch #0 {all -> 0x02ea, blocks: (B:53:0x00c1, B:161:0x00dd, B:164:0x00e4, B:166:0x00ec, B:170:0x00f6, B:173:0x0103, B:175:0x0109, B:179:0x0113, B:182:0x011c, B:184:0x0122, B:188:0x012c, B:191:0x0135, B:193:0x013b, B:197:0x0145, B:198:0x014e, B:220:0x015d, B:223:0x0169, B:203:0x018b, B:208:0x0199, B:210:0x01a8, B:211:0x01ae, B:213:0x01b6, B:214:0x01bf, B:136:0x01d7, B:139:0x01e0, B:141:0x01e8, B:145:0x01f2, B:148:0x01fb, B:151:0x0205, B:59:0x0212, B:62:0x021c, B:64:0x0222, B:68:0x022c, B:71:0x0235, B:73:0x023b, B:77:0x0245, B:80:0x024e, B:82:0x0254, B:86:0x025e, B:87:0x0267, B:89:0x0270, B:93:0x027a, B:96:0x0283, B:100:0x0291, B:105:0x029f, B:107:0x02a7, B:110:0x02b3, B:111:0x02b9, B:113:0x02cc, B:114:0x02d0), top: B:52:0x00c1 }] */
    /* JADX WARN: Removed duplicated region for block: B:113:0x02cc A[Catch: all -> 0x02ea, TryCatch #0 {all -> 0x02ea, blocks: (B:53:0x00c1, B:161:0x00dd, B:164:0x00e4, B:166:0x00ec, B:170:0x00f6, B:173:0x0103, B:175:0x0109, B:179:0x0113, B:182:0x011c, B:184:0x0122, B:188:0x012c, B:191:0x0135, B:193:0x013b, B:197:0x0145, B:198:0x014e, B:220:0x015d, B:223:0x0169, B:203:0x018b, B:208:0x0199, B:210:0x01a8, B:211:0x01ae, B:213:0x01b6, B:214:0x01bf, B:136:0x01d7, B:139:0x01e0, B:141:0x01e8, B:145:0x01f2, B:148:0x01fb, B:151:0x0205, B:59:0x0212, B:62:0x021c, B:64:0x0222, B:68:0x022c, B:71:0x0235, B:73:0x023b, B:77:0x0245, B:80:0x024e, B:82:0x0254, B:86:0x025e, B:87:0x0267, B:89:0x0270, B:93:0x027a, B:96:0x0283, B:100:0x0291, B:105:0x029f, B:107:0x02a7, B:110:0x02b3, B:111:0x02b9, B:113:0x02cc, B:114:0x02d0), top: B:52:0x00c1 }] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x029f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:120:0x028e  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0205 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0076 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:172:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0109 A[Catch: all -> 0x02ea, TryCatch #0 {all -> 0x02ea, blocks: (B:53:0x00c1, B:161:0x00dd, B:164:0x00e4, B:166:0x00ec, B:170:0x00f6, B:173:0x0103, B:175:0x0109, B:179:0x0113, B:182:0x011c, B:184:0x0122, B:188:0x012c, B:191:0x0135, B:193:0x013b, B:197:0x0145, B:198:0x014e, B:220:0x015d, B:223:0x0169, B:203:0x018b, B:208:0x0199, B:210:0x01a8, B:211:0x01ae, B:213:0x01b6, B:214:0x01bf, B:136:0x01d7, B:139:0x01e0, B:141:0x01e8, B:145:0x01f2, B:148:0x01fb, B:151:0x0205, B:59:0x0212, B:62:0x021c, B:64:0x0222, B:68:0x022c, B:71:0x0235, B:73:0x023b, B:77:0x0245, B:80:0x024e, B:82:0x0254, B:86:0x025e, B:87:0x0267, B:89:0x0270, B:93:0x027a, B:96:0x0283, B:100:0x0291, B:105:0x029f, B:107:0x02a7, B:110:0x02b3, B:111:0x02b9, B:113:0x02cc, B:114:0x02d0), top: B:52:0x00c1 }] */
    /* JADX WARN: Removed duplicated region for block: B:181:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0122 A[Catch: all -> 0x02ea, TryCatch #0 {all -> 0x02ea, blocks: (B:53:0x00c1, B:161:0x00dd, B:164:0x00e4, B:166:0x00ec, B:170:0x00f6, B:173:0x0103, B:175:0x0109, B:179:0x0113, B:182:0x011c, B:184:0x0122, B:188:0x012c, B:191:0x0135, B:193:0x013b, B:197:0x0145, B:198:0x014e, B:220:0x015d, B:223:0x0169, B:203:0x018b, B:208:0x0199, B:210:0x01a8, B:211:0x01ae, B:213:0x01b6, B:214:0x01bf, B:136:0x01d7, B:139:0x01e0, B:141:0x01e8, B:145:0x01f2, B:148:0x01fb, B:151:0x0205, B:59:0x0212, B:62:0x021c, B:64:0x0222, B:68:0x022c, B:71:0x0235, B:73:0x023b, B:77:0x0245, B:80:0x024e, B:82:0x0254, B:86:0x025e, B:87:0x0267, B:89:0x0270, B:93:0x027a, B:96:0x0283, B:100:0x0291, B:105:0x029f, B:107:0x02a7, B:110:0x02b3, B:111:0x02b9, B:113:0x02cc, B:114:0x02d0), top: B:52:0x00c1 }] */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x013b A[Catch: all -> 0x02ea, TryCatch #0 {all -> 0x02ea, blocks: (B:53:0x00c1, B:161:0x00dd, B:164:0x00e4, B:166:0x00ec, B:170:0x00f6, B:173:0x0103, B:175:0x0109, B:179:0x0113, B:182:0x011c, B:184:0x0122, B:188:0x012c, B:191:0x0135, B:193:0x013b, B:197:0x0145, B:198:0x014e, B:220:0x015d, B:223:0x0169, B:203:0x018b, B:208:0x0199, B:210:0x01a8, B:211:0x01ae, B:213:0x01b6, B:214:0x01bf, B:136:0x01d7, B:139:0x01e0, B:141:0x01e8, B:145:0x01f2, B:148:0x01fb, B:151:0x0205, B:59:0x0212, B:62:0x021c, B:64:0x0222, B:68:0x022c, B:71:0x0235, B:73:0x023b, B:77:0x0245, B:80:0x024e, B:82:0x0254, B:86:0x025e, B:87:0x0267, B:89:0x0270, B:93:0x027a, B:96:0x0283, B:100:0x0291, B:105:0x029f, B:107:0x02a7, B:110:0x02b3, B:111:0x02b9, B:113:0x02cc, B:114:0x02d0), top: B:52:0x00c1 }] */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x018b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:219:0x015d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:225:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x0076 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00b0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x023b A[Catch: all -> 0x02ea, TryCatch #0 {all -> 0x02ea, blocks: (B:53:0x00c1, B:161:0x00dd, B:164:0x00e4, B:166:0x00ec, B:170:0x00f6, B:173:0x0103, B:175:0x0109, B:179:0x0113, B:182:0x011c, B:184:0x0122, B:188:0x012c, B:191:0x0135, B:193:0x013b, B:197:0x0145, B:198:0x014e, B:220:0x015d, B:223:0x0169, B:203:0x018b, B:208:0x0199, B:210:0x01a8, B:211:0x01ae, B:213:0x01b6, B:214:0x01bf, B:136:0x01d7, B:139:0x01e0, B:141:0x01e8, B:145:0x01f2, B:148:0x01fb, B:151:0x0205, B:59:0x0212, B:62:0x021c, B:64:0x0222, B:68:0x022c, B:71:0x0235, B:73:0x023b, B:77:0x0245, B:80:0x024e, B:82:0x0254, B:86:0x025e, B:87:0x0267, B:89:0x0270, B:93:0x027a, B:96:0x0283, B:100:0x0291, B:105:0x029f, B:107:0x02a7, B:110:0x02b3, B:111:0x02b9, B:113:0x02cc, B:114:0x02d0), top: B:52:0x00c1 }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0254 A[Catch: all -> 0x02ea, TryCatch #0 {all -> 0x02ea, blocks: (B:53:0x00c1, B:161:0x00dd, B:164:0x00e4, B:166:0x00ec, B:170:0x00f6, B:173:0x0103, B:175:0x0109, B:179:0x0113, B:182:0x011c, B:184:0x0122, B:188:0x012c, B:191:0x0135, B:193:0x013b, B:197:0x0145, B:198:0x014e, B:220:0x015d, B:223:0x0169, B:203:0x018b, B:208:0x0199, B:210:0x01a8, B:211:0x01ae, B:213:0x01b6, B:214:0x01bf, B:136:0x01d7, B:139:0x01e0, B:141:0x01e8, B:145:0x01f2, B:148:0x01fb, B:151:0x0205, B:59:0x0212, B:62:0x021c, B:64:0x0222, B:68:0x022c, B:71:0x0235, B:73:0x023b, B:77:0x0245, B:80:0x024e, B:82:0x0254, B:86:0x025e, B:87:0x0267, B:89:0x0270, B:93:0x027a, B:96:0x0283, B:100:0x0291, B:105:0x029f, B:107:0x02a7, B:110:0x02b3, B:111:0x02b9, B:113:0x02cc, B:114:0x02d0), top: B:52:0x00c1 }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0270 A[Catch: all -> 0x02ea, TryCatch #0 {all -> 0x02ea, blocks: (B:53:0x00c1, B:161:0x00dd, B:164:0x00e4, B:166:0x00ec, B:170:0x00f6, B:173:0x0103, B:175:0x0109, B:179:0x0113, B:182:0x011c, B:184:0x0122, B:188:0x012c, B:191:0x0135, B:193:0x013b, B:197:0x0145, B:198:0x014e, B:220:0x015d, B:223:0x0169, B:203:0x018b, B:208:0x0199, B:210:0x01a8, B:211:0x01ae, B:213:0x01b6, B:214:0x01bf, B:136:0x01d7, B:139:0x01e0, B:141:0x01e8, B:145:0x01f2, B:148:0x01fb, B:151:0x0205, B:59:0x0212, B:62:0x021c, B:64:0x0222, B:68:0x022c, B:71:0x0235, B:73:0x023b, B:77:0x0245, B:80:0x024e, B:82:0x0254, B:86:0x025e, B:87:0x0267, B:89:0x0270, B:93:0x027a, B:96:0x0283, B:100:0x0291, B:105:0x029f, B:107:0x02a7, B:110:0x02b3, B:111:0x02b9, B:113:0x02cc, B:114:0x02d0), top: B:52:0x00c1 }] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0282  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x028c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<UserHistoryPart> parseUserContent(String raw) {
        Object obj;
        JsonArray asJsonArray;
        String str;
        JsonElement jsonElement;
        JsonObject asJsonObject;
        String str2;
        String str3;
        JsonElement jsonElement2;
        String str4;
        JsonElement jsonElement3;
        String str5;
        JsonElement jsonElement4;
        long j;
        String str6;
        String str7;
        JsonElement jsonElement5;
        String str8;
        JsonElement jsonElement6;
        long j2;
        JsonElement jsonElement7;
        String str9;
        String str10;
        String normalizeRemoteResourceUri;
        String obj2 = raw != null ? StringsKt.trim(raw).toString() : null;
        String str11 = obj2 == null ? "" : obj2;
        if (str11.length() == 0) {
            return CollectionsKt.emptyList();
        }
        try {
            Result.Companion companion = Result.Companion;
            VoiceHistoryContentParser voiceHistoryContentParser = this;
            obj = Result.constructor-impl(JsonParser.parseString(str11));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        JsonElement jsonElement8 = (JsonElement) obj;
        if (jsonElement8 != null) {
            if (!jsonElement8.isJsonArray()) {
                jsonElement8 = null;
            }
            if (jsonElement8 != null && (asJsonArray = jsonElement8.getAsJsonArray()) != null) {
                ArrayList arrayList = new ArrayList(asJsonArray.size());
                Iterator it = asJsonArray.iterator();
                Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                while (it.hasNext()) {
                    JsonElement jsonElement9 = (JsonElement) it.next();
                    if (jsonElement9.isJsonObject()) {
                        JsonObject asJsonObject2 = jsonElement9.getAsJsonObject();
                        JsonElement jsonElement10 = asJsonObject2.get(DBData.FIELD_TYPE);
                        if (jsonElement10 != null) {
                            if (!jsonElement10.isJsonPrimitive()) {
                                jsonElement10 = null;
                            }
                            if (jsonElement10 != null) {
                                str = jsonElement10.getAsString();
                                if (str == null) {
                                    str = "";
                                }
                                jsonElement = asJsonObject2.get("data");
                                if (jsonElement != null) {
                                    if (!jsonElement.isJsonObject()) {
                                        jsonElement = null;
                                    }
                                    if (jsonElement != null && (asJsonObject = jsonElement.getAsJsonObject()) != null) {
                                        try {
                                            int hashCode = str.hashCode();
                                            if (hashCode != -1963501277) {
                                                if (hashCode != 3556653) {
                                                    if (hashCode == 100313435 && str.equals("image")) {
                                                        JsonElement jsonElement11 = asJsonObject.get("image_id");
                                                        if (jsonElement11 != null) {
                                                            if (!jsonElement11.isJsonPrimitive()) {
                                                                jsonElement11 = null;
                                                            }
                                                            if (jsonElement11 != null) {
                                                                str2 = jsonElement11.getAsString();
                                                                str3 = str2 != null ? "" : str2;
                                                                jsonElement2 = asJsonObject.get("uri");
                                                                if (jsonElement2 != null) {
                                                                    if (!jsonElement2.isJsonPrimitive()) {
                                                                        jsonElement2 = null;
                                                                    }
                                                                    if (jsonElement2 != null) {
                                                                        str4 = jsonElement2.getAsString();
                                                                        if (str4 == null) {
                                                                            str4 = "";
                                                                        }
                                                                        jsonElement3 = asJsonObject.get("filename");
                                                                        if (jsonElement3 != null) {
                                                                            if (!jsonElement3.isJsonPrimitive()) {
                                                                                jsonElement3 = null;
                                                                            }
                                                                            if (jsonElement3 != null) {
                                                                                str5 = jsonElement3.getAsString();
                                                                                if (str5 == null) {
                                                                                    str5 = "";
                                                                                }
                                                                                jsonElement4 = asJsonObject.get("file_size");
                                                                                if (jsonElement4 != null) {
                                                                                    if (!jsonElement4.isJsonPrimitive()) {
                                                                                        jsonElement4 = null;
                                                                                    }
                                                                                    if (jsonElement4 != null) {
                                                                                        j = jsonElement4.getAsLong();
                                                                                        if (str3.length() > 0) {
                                                                                            ArrayList arrayList2 = arrayList;
                                                                                            String str12 = str5;
                                                                                            if (StringsKt.isBlank(str12)) {
                                                                                                str12 = "image";
                                                                                            }
                                                                                            arrayList2.add(new UserHistoryPart.Attachment(str3, str12, true, j, str3, null, extractChatSessionId(asJsonObject, asJsonObject2)));
                                                                                        } else {
                                                                                            if (str4.length() > 0) {
                                                                                                String normalizeImageUri = normalizeImageUri(str4);
                                                                                                ArrayList arrayList3 = arrayList;
                                                                                                String str13 = str5;
                                                                                                if (StringsKt.isBlank(str13)) {
                                                                                                    str13 = INSTANCE.fallbackFilenameFromUri(str4);
                                                                                                }
                                                                                                arrayList3.add(new UserHistoryPart.Attachment(str4, str13, true, j, normalizeImageUri, normalizeImageUri == null ? normalizeRemoteResourceUri(str4) : null, extractChatSessionId(asJsonObject, asJsonObject2)));
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                                j = 0;
                                                                                if (str3.length() > 0) {
                                                                                }
                                                                            }
                                                                        }
                                                                        str5 = null;
                                                                        if (str5 == null) {
                                                                        }
                                                                        jsonElement4 = asJsonObject.get("file_size");
                                                                        if (jsonElement4 != null) {
                                                                        }
                                                                        j = 0;
                                                                        if (str3.length() > 0) {
                                                                        }
                                                                    }
                                                                }
                                                                str4 = null;
                                                                if (str4 == null) {
                                                                }
                                                                jsonElement3 = asJsonObject.get("filename");
                                                                if (jsonElement3 != null) {
                                                                }
                                                                str5 = null;
                                                                if (str5 == null) {
                                                                }
                                                                jsonElement4 = asJsonObject.get("file_size");
                                                                if (jsonElement4 != null) {
                                                                }
                                                                j = 0;
                                                                if (str3.length() > 0) {
                                                                }
                                                            }
                                                        }
                                                        str2 = null;
                                                        if (str2 != null) {
                                                        }
                                                        jsonElement2 = asJsonObject.get("uri");
                                                        if (jsonElement2 != null) {
                                                        }
                                                        str4 = null;
                                                        if (str4 == null) {
                                                        }
                                                        jsonElement3 = asJsonObject.get("filename");
                                                        if (jsonElement3 != null) {
                                                        }
                                                        str5 = null;
                                                        if (str5 == null) {
                                                        }
                                                        jsonElement4 = asJsonObject.get("file_size");
                                                        if (jsonElement4 != null) {
                                                        }
                                                        j = 0;
                                                        if (str3.length() > 0) {
                                                        }
                                                    }
                                                } else if (str.equals("text")) {
                                                    JsonElement jsonElement12 = asJsonObject.get(ReportConstant.COMMON_CONTENT);
                                                    if (jsonElement12 != null) {
                                                        if (!jsonElement12.isJsonPrimitive()) {
                                                            jsonElement12 = null;
                                                        }
                                                        if (jsonElement12 != null) {
                                                            str6 = jsonElement12.getAsString();
                                                            if (str6 == null) {
                                                                str6 = "";
                                                            }
                                                            if (!(!StringsKt.isBlank(str6))) {
                                                                arrayList.add(new UserHistoryPart.Text(str6, true));
                                                            }
                                                        }
                                                    }
                                                    str6 = null;
                                                    if (str6 == null) {
                                                    }
                                                    if (!(!StringsKt.isBlank(str6))) {
                                                    }
                                                }
                                            } else if (str.equals("attachment")) {
                                                JsonElement jsonElement13 = asJsonObject.get("uri");
                                                if (jsonElement13 != null) {
                                                    if (!jsonElement13.isJsonPrimitive()) {
                                                        jsonElement13 = null;
                                                    }
                                                    if (jsonElement13 != null) {
                                                        str7 = jsonElement13.getAsString();
                                                        if (str7 == null) {
                                                            str7 = "";
                                                        }
                                                        jsonElement5 = asJsonObject.get("filename");
                                                        if (jsonElement5 != null) {
                                                            if (!jsonElement5.isJsonPrimitive()) {
                                                                jsonElement5 = null;
                                                            }
                                                            if (jsonElement5 != null) {
                                                                str8 = jsonElement5.getAsString();
                                                                if (str8 == null) {
                                                                    str8 = "";
                                                                }
                                                                jsonElement6 = asJsonObject.get("file_size");
                                                                if (jsonElement6 != null) {
                                                                    if (!jsonElement6.isJsonPrimitive()) {
                                                                        jsonElement6 = null;
                                                                    }
                                                                    if (jsonElement6 != null) {
                                                                        j2 = jsonElement6.getAsLong();
                                                                        jsonElement7 = asJsonObject.get("tos_oid");
                                                                        if (jsonElement7 != null) {
                                                                            if (!jsonElement7.isJsonPrimitive()) {
                                                                                jsonElement7 = null;
                                                                            }
                                                                            if (jsonElement7 != null) {
                                                                                str9 = jsonElement7.getAsString();
                                                                                if (str9 == null) {
                                                                                    str9 = "";
                                                                                }
                                                                                if (!(str7.length() > 0)) {
                                                                                    if (str9.length() > 0) {
                                                                                    }
                                                                                }
                                                                                str10 = str8;
                                                                                if (StringsKt.isBlank(str10)) {
                                                                                    VoiceHistoryContentParser voiceHistoryContentParser2 = INSTANCE;
                                                                                    String str14 = str7;
                                                                                    if (StringsKt.isBlank(str14)) {
                                                                                        str14 = str9;
                                                                                    }
                                                                                    str10 = voiceHistoryContentParser2.fallbackFilenameFromUri(str14);
                                                                                }
                                                                                String str15 = str10;
                                                                                boolean isImageByFilename = isImageByFilename(str15);
                                                                                ArrayList arrayList4 = arrayList;
                                                                                normalizeRemoteResourceUri = normalizeRemoteResourceUri(str9);
                                                                                if (normalizeRemoteResourceUri == null) {
                                                                                    normalizeRemoteResourceUri = normalizeRemoteResourceUri(str7);
                                                                                }
                                                                                arrayList4.add(new UserHistoryPart.Attachment(str7, str15, isImageByFilename, j2, null, normalizeRemoteResourceUri, extractChatSessionId(asJsonObject, asJsonObject2)));
                                                                            }
                                                                        }
                                                                        str9 = null;
                                                                        if (str9 == null) {
                                                                        }
                                                                        if (!(str7.length() > 0)) {
                                                                        }
                                                                        str10 = str8;
                                                                        if (StringsKt.isBlank(str10)) {
                                                                        }
                                                                        String str152 = str10;
                                                                        boolean isImageByFilename2 = isImageByFilename(str152);
                                                                        ArrayList arrayList42 = arrayList;
                                                                        normalizeRemoteResourceUri = normalizeRemoteResourceUri(str9);
                                                                        if (normalizeRemoteResourceUri == null) {
                                                                        }
                                                                        arrayList42.add(new UserHistoryPart.Attachment(str7, str152, isImageByFilename2, j2, null, normalizeRemoteResourceUri, extractChatSessionId(asJsonObject, asJsonObject2)));
                                                                    }
                                                                }
                                                                j2 = 0;
                                                                jsonElement7 = asJsonObject.get("tos_oid");
                                                                if (jsonElement7 != null) {
                                                                }
                                                                str9 = null;
                                                                if (str9 == null) {
                                                                }
                                                                if (!(str7.length() > 0)) {
                                                                }
                                                                str10 = str8;
                                                                if (StringsKt.isBlank(str10)) {
                                                                }
                                                                String str1522 = str10;
                                                                boolean isImageByFilename22 = isImageByFilename(str1522);
                                                                ArrayList arrayList422 = arrayList;
                                                                normalizeRemoteResourceUri = normalizeRemoteResourceUri(str9);
                                                                if (normalizeRemoteResourceUri == null) {
                                                                }
                                                                arrayList422.add(new UserHistoryPart.Attachment(str7, str1522, isImageByFilename22, j2, null, normalizeRemoteResourceUri, extractChatSessionId(asJsonObject, asJsonObject2)));
                                                            }
                                                        }
                                                        str8 = null;
                                                        if (str8 == null) {
                                                        }
                                                        jsonElement6 = asJsonObject.get("file_size");
                                                        if (jsonElement6 != null) {
                                                        }
                                                        j2 = 0;
                                                        jsonElement7 = asJsonObject.get("tos_oid");
                                                        if (jsonElement7 != null) {
                                                        }
                                                        str9 = null;
                                                        if (str9 == null) {
                                                        }
                                                        if (!(str7.length() > 0)) {
                                                        }
                                                        str10 = str8;
                                                        if (StringsKt.isBlank(str10)) {
                                                        }
                                                        String str15222 = str10;
                                                        boolean isImageByFilename222 = isImageByFilename(str15222);
                                                        ArrayList arrayList4222 = arrayList;
                                                        normalizeRemoteResourceUri = normalizeRemoteResourceUri(str9);
                                                        if (normalizeRemoteResourceUri == null) {
                                                        }
                                                        arrayList4222.add(new UserHistoryPart.Attachment(str7, str15222, isImageByFilename222, j2, null, normalizeRemoteResourceUri, extractChatSessionId(asJsonObject, asJsonObject2)));
                                                    }
                                                }
                                                str7 = null;
                                                if (str7 == null) {
                                                }
                                                jsonElement5 = asJsonObject.get("filename");
                                                if (jsonElement5 != null) {
                                                }
                                                str8 = null;
                                                if (str8 == null) {
                                                }
                                                jsonElement6 = asJsonObject.get("file_size");
                                                if (jsonElement6 != null) {
                                                }
                                                j2 = 0;
                                                jsonElement7 = asJsonObject.get("tos_oid");
                                                if (jsonElement7 != null) {
                                                }
                                                str9 = null;
                                                if (str9 == null) {
                                                }
                                                if (!(str7.length() > 0)) {
                                                }
                                                str10 = str8;
                                                if (StringsKt.isBlank(str10)) {
                                                }
                                                String str152222 = str10;
                                                boolean isImageByFilename2222 = isImageByFilename(str152222);
                                                ArrayList arrayList42222 = arrayList;
                                                normalizeRemoteResourceUri = normalizeRemoteResourceUri(str9);
                                                if (normalizeRemoteResourceUri == null) {
                                                }
                                                arrayList42222.add(new UserHistoryPart.Attachment(str7, str152222, isImageByFilename2222, j2, null, normalizeRemoteResourceUri, extractChatSessionId(asJsonObject, asJsonObject2)));
                                            }
                                        } catch (Throwable th2) {
                                            FLogger.INSTANCE.w(TAG, "skip malformed part: type=" + str, th2);
                                        }
                                    }
                                }
                            }
                        }
                        str = null;
                        if (str == null) {
                        }
                        jsonElement = asJsonObject2.get("data");
                        if (jsonElement != null) {
                        }
                    }
                }
                return arrayList;
            }
        }
        return CollectionsKt.listOf(new UserHistoryPart.Text(str11, false));
    }

    private final String fallbackFilenameFromUri(String uri) {
        String substringAfterLast = StringsKt.substringAfterLast(uri, '/', "");
        if (StringsKt.isBlank(substringAfterLast)) {
            substringAfterLast = MessagePart.TYPE_FILE;
        }
        return substringAfterLast;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[LOOP:1: B:5:0x000d->B:22:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String extractChatSessionId(JsonObject... sources) {
        String str;
        for (JsonObject jsonObject : sources) {
            Iterator<String> it = CHAT_SESSION_ID_KEYS.iterator();
            while (it.hasNext()) {
                JsonElement jsonElement = jsonObject.get(it.next());
                if (jsonElement != null) {
                    if (!jsonElement.isJsonPrimitive()) {
                        jsonElement = null;
                    }
                    if (jsonElement != null && (str = jsonElement.getAsString()) != null && (!StringsKt.isBlank(str))) {
                        if (str == null) {
                            return str;
                        }
                    }
                }
                str = null;
                if (str == null) {
                }
            }
        }
        return null;
    }

    private final String normalizeRemoteResourceUri(String raw) {
        String obj = raw != null ? StringsKt.trim(raw).toString() : null;
        if (obj == null) {
            obj = "";
        }
        if (StringsKt.isBlank(obj)) {
            return null;
        }
        if (StringsKt.startsWith$default(obj, REMOTE_RESOURCE_PREFIX, false, 2, (Object) null)) {
            return obj;
        }
        if (StringsKt.startsWith$default(obj, "tos-", false, 2, (Object) null)) {
            return REMOTE_RESOURCE_PREFIX + obj;
        }
        return null;
    }

    private final String normalizeImageUri(String raw) {
        String obj = raw != null ? StringsKt.trim(raw).toString() : null;
        if (obj == null) {
            obj = "";
        }
        if (StringsKt.isBlank(obj)) {
            return null;
        }
        String removePrefix = StringsKt.removePrefix(obj, REMOTE_RESOURCE_PREFIX);
        if (StringsKt.startsWith$default(removePrefix, "tos-", false, 2, (Object) null)) {
            return removePrefix;
        }
        return null;
    }

    private final boolean isImageByFilename(String filename) {
        String lowerCase = StringsKt.substringAfterLast(filename, '.', "").toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return IMAGE_EXT.contains(lowerCase);
    }
}
