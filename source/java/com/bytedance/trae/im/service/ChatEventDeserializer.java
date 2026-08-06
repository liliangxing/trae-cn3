package com.bytedance.trae.im.service;

import android.util.Log;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.bytedance.sdk.account.save.database.DBData;
import com.bytedance.trae.im.service.ChatEventPayload;
import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IMEvent.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/bytedance/trae/im/service/ChatEventDeserializer;", "Lcom/google/gson/JsonDeserializer;", "Lcom/bytedance/trae/im/service/ChatEvent;", "<init>", "()V", "gson", "Lcom/google/gson/Gson;", "deserialize", "json", "Lcom/google/gson/JsonElement;", "typeOfT", "Ljava/lang/reflect/Type;", "context", "Lcom/google/gson/JsonDeserializationContext;", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ChatEventDeserializer implements JsonDeserializer<ChatEvent> {
    private final Gson gson = new Gson();

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x03d0  */
    /* renamed from: deserialize, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ChatEvent m2585deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) {
        String str;
        JsonElement jsonElement;
        Integer num;
        JsonElement jsonElement2;
        Boolean bool;
        JsonElement jsonElement3;
        Boolean bool2;
        JsonElement jsonElement4;
        Boolean bool3;
        JsonElement jsonElement5;
        Boolean bool4;
        JsonElement jsonElement6;
        JsonElement parseString;
        ChatEventPayload unknown;
        ChatEventPayload chatEventPayload;
        ChatEventPayload timingEvents;
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(typeOfT, "typeOfT");
        Intrinsics.checkNotNullParameter(context, "context");
        JsonObject asJsonObject = json.getAsJsonObject();
        JsonElement jsonElement7 = asJsonObject.get(DBData.FIELD_TYPE);
        if (jsonElement7 != null) {
            if (!(!jsonElement7.isJsonNull())) {
                jsonElement7 = null;
            }
            if (jsonElement7 != null) {
                str = jsonElement7.getAsString();
                jsonElement = asJsonObject.get(OnekeyLoginConstants.CU_KEY_SEQ);
                if (jsonElement != null) {
                    if (!(!jsonElement.isJsonNull())) {
                        jsonElement = null;
                    }
                    if (jsonElement != null) {
                        num = Integer.valueOf(jsonElement.getAsInt());
                        jsonElement2 = asJsonObject.get("new_tool_call");
                        if (jsonElement2 != null) {
                            if (!(!jsonElement2.isJsonNull() && jsonElement2.isJsonPrimitive())) {
                                jsonElement2 = null;
                            }
                            if (jsonElement2 != null) {
                                bool = Boolean.valueOf(jsonElement2.getAsBoolean());
                                jsonElement3 = asJsonObject.get("clean_thought");
                                if (jsonElement3 != null) {
                                    if (!(!jsonElement3.isJsonNull() && jsonElement3.isJsonPrimitive())) {
                                        jsonElement3 = null;
                                    }
                                    if (jsonElement3 != null) {
                                        bool2 = Boolean.valueOf(jsonElement3.getAsBoolean());
                                        jsonElement4 = asJsonObject.get("thought_first_data");
                                        if (jsonElement4 != null) {
                                            if (!(!jsonElement4.isJsonNull() && jsonElement4.isJsonPrimitive())) {
                                                jsonElement4 = null;
                                            }
                                            if (jsonElement4 != null) {
                                                bool3 = Boolean.valueOf(jsonElement4.getAsBoolean());
                                                jsonElement5 = asJsonObject.get("toolcall_first_data");
                                                if (jsonElement5 != null) {
                                                    if (!(!jsonElement5.isJsonNull() && jsonElement5.isJsonPrimitive())) {
                                                        jsonElement5 = null;
                                                    }
                                                    if (jsonElement5 != null) {
                                                        bool4 = Boolean.valueOf(jsonElement5.getAsBoolean());
                                                        JsonElement jsonElement8 = asJsonObject.get("data");
                                                        jsonElement6 = (jsonElement8 == null && (true ^ jsonElement8.isJsonNull())) ? jsonElement8 : null;
                                                        if (jsonElement6 != null) {
                                                            if (jsonElement6.isJsonPrimitive()) {
                                                                try {
                                                                    parseString = JsonParser.parseString(jsonElement6.getAsString());
                                                                } catch (Exception e) {
                                                                    Log.e("ImService", "ChatEventDeserializer parse error: type=" + str + ", e=" + e);
                                                                }
                                                            } else {
                                                                parseString = jsonElement6;
                                                            }
                                                            if (parseString == null) {
                                                                Log.e("ImService", "ChatEventDeserializer dataElement is null: type=" + str + ", dataRaw=" + jsonElement6);
                                                            }
                                                            if (str != null) {
                                                                switch (str.hashCode()) {
                                                                    case -1814390893:
                                                                        if (str.equals("user_message")) {
                                                                            ChatEventPayload chatEventPayload2 = (ChatEventPayload.UserMessage) this.gson.fromJson(parseString, ChatEventPayload.UserMessage.class);
                                                                            if (chatEventPayload2 == null) {
                                                                                chatEventPayload2 = new ChatEventPayload.UserMessage(null, null, null, null, null, null, null, null, null, null, 1023, null);
                                                                            }
                                                                            chatEventPayload = chatEventPayload2;
                                                                            unknown = chatEventPayload;
                                                                            break;
                                                                        }
                                                                        break;
                                                                    case -1472993618:
                                                                        if (str.equals("timing_events")) {
                                                                            try {
                                                                                timingEvents = (ChatEventPayload.TimingEvents) this.gson.fromJson(parseString, ChatEventPayload.TimingEvents.class);
                                                                                if (timingEvents == null) {
                                                                                    timingEvents = new ChatEventPayload.TimingEvents(null, null, null, null, null, null, null, null, null, 511, null);
                                                                                }
                                                                            } catch (Throwable unused) {
                                                                                timingEvents = new ChatEventPayload.TimingEvents(null, null, null, null, null, null, null, null, null, 511, null);
                                                                            }
                                                                            chatEventPayload = timingEvents;
                                                                            unknown = chatEventPayload;
                                                                            break;
                                                                        }
                                                                        break;
                                                                    case -1147503653:
                                                                        if (str.equals("token_usage")) {
                                                                            ChatEventPayload chatEventPayload3 = (ChatEventPayload.TokenUsage) this.gson.fromJson(parseString, ChatEventPayload.TokenUsage.class);
                                                                            if (chatEventPayload3 == null) {
                                                                                chatEventPayload3 = new ChatEventPayload.TokenUsage(null, null, null, null, null, null, null, null, null, 511, null);
                                                                            }
                                                                            chatEventPayload = chatEventPayload3;
                                                                            unknown = chatEventPayload;
                                                                            break;
                                                                        }
                                                                        break;
                                                                    case -450004177:
                                                                        if (str.equals("metadata")) {
                                                                            ChatEventPayload chatEventPayload4 = (ChatEventPayload.Metadata) this.gson.fromJson(parseString, ChatEventPayload.Metadata.class);
                                                                            if (chatEventPayload4 == null) {
                                                                                chatEventPayload4 = new ChatEventPayload.Metadata(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, 1, null);
                                                                            }
                                                                            chatEventPayload = chatEventPayload4;
                                                                            unknown = chatEventPayload;
                                                                            break;
                                                                        }
                                                                        break;
                                                                    case 3089282:
                                                                        if (str.equals("done")) {
                                                                            ChatEventPayload chatEventPayload5 = (ChatEventPayload.Done) this.gson.fromJson(parseString, ChatEventPayload.Done.class);
                                                                            if (chatEventPayload5 == null) {
                                                                                chatEventPayload5 = new ChatEventPayload.Done(null, null, null, null, 15, null);
                                                                            }
                                                                            chatEventPayload = chatEventPayload5;
                                                                            unknown = chatEventPayload;
                                                                            break;
                                                                        }
                                                                        break;
                                                                    case 96784904:
                                                                        if (str.equals("error")) {
                                                                            ChatEventPayload chatEventPayload6 = (ChatEventPayload.Error) this.gson.fromJson(parseString, ChatEventPayload.Error.class);
                                                                            if (chatEventPayload6 == null) {
                                                                                chatEventPayload6 = new ChatEventPayload.Error(null, null, null, null, 15, null);
                                                                            }
                                                                            chatEventPayload = chatEventPayload6;
                                                                            unknown = chatEventPayload;
                                                                            break;
                                                                        }
                                                                        break;
                                                                    case 343279415:
                                                                        if (str.equals("session_title_message")) {
                                                                            ChatEventPayload chatEventPayload7 = (ChatEventPayload.SessionTitle) this.gson.fromJson(parseString, ChatEventPayload.SessionTitle.class);
                                                                            if (chatEventPayload7 == null) {
                                                                                chatEventPayload7 = new ChatEventPayload.SessionTitle(null, null, 3, null);
                                                                            }
                                                                            chatEventPayload = chatEventPayload7;
                                                                            unknown = chatEventPayload;
                                                                            break;
                                                                        }
                                                                        break;
                                                                    case 595233003:
                                                                        if (str.equals("notification")) {
                                                                            ChatEventPayload chatEventPayload8 = (ChatEventPayload.Notification) this.gson.fromJson(parseString, ChatEventPayload.Notification.class);
                                                                            if (chatEventPayload8 == null) {
                                                                                chatEventPayload8 = new ChatEventPayload.Notification(null, null, null, null, null, null, null, null, null, 511, null);
                                                                            }
                                                                            chatEventPayload = chatEventPayload8;
                                                                            unknown = chatEventPayload;
                                                                            break;
                                                                        }
                                                                        break;
                                                                    case 655177102:
                                                                        if (str.equals("queuing")) {
                                                                            ChatEventPayload chatEventPayload9 = (ChatEventPayload.Queuing) this.gson.fromJson(parseString, ChatEventPayload.Queuing.class);
                                                                            if (chatEventPayload9 == null) {
                                                                                chatEventPayload9 = new ChatEventPayload.Queuing(null, null, null, null, null, null, null, 127, null);
                                                                            }
                                                                            chatEventPayload = chatEventPayload9;
                                                                            unknown = chatEventPayload;
                                                                            break;
                                                                        }
                                                                        break;
                                                                    case 1515617574:
                                                                        if (str.equals("fast_request_savings")) {
                                                                            ChatEventPayload chatEventPayload10 = (ChatEventPayload.FastRequestSavings) this.gson.fromJson(parseString, ChatEventPayload.FastRequestSavings.class);
                                                                            if (chatEventPayload10 == null) {
                                                                                chatEventPayload10 = new ChatEventPayload.FastRequestSavings(null, null, null, 7, null);
                                                                            }
                                                                            chatEventPayload = chatEventPayload10;
                                                                            unknown = chatEventPayload;
                                                                            break;
                                                                        }
                                                                        break;
                                                                    case 2102213225:
                                                                        if (str.equals("plan_item")) {
                                                                            ChatEventPayload chatEventPayload11 = (ChatEventPayload.PlanItem) this.gson.fromJson(parseString, ChatEventPayload.PlanItem.class);
                                                                            if (chatEventPayload11 == null) {
                                                                                chatEventPayload11 = new ChatEventPayload.PlanItem(null, null, null, null, null, null, null, null, null, null, null, null, null, 8191, null);
                                                                            }
                                                                            chatEventPayload = chatEventPayload11;
                                                                            unknown = chatEventPayload;
                                                                            break;
                                                                        }
                                                                        break;
                                                                }
                                                                return new ChatEvent(str, num != null ? num.intValue() : 0, unknown, bool, bool2, bool3, bool4);
                                                            }
                                                            unknown = new ChatEventPayload.Unknown(parseString);
                                                            return new ChatEvent(str, num != null ? num.intValue() : 0, unknown, bool, bool2, bool3, bool4);
                                                        }
                                                        parseString = null;
                                                        if (parseString == null) {
                                                        }
                                                        if (str != null) {
                                                        }
                                                        unknown = new ChatEventPayload.Unknown(parseString);
                                                        return new ChatEvent(str, num != null ? num.intValue() : 0, unknown, bool, bool2, bool3, bool4);
                                                    }
                                                }
                                                bool4 = null;
                                                JsonElement jsonElement82 = asJsonObject.get("data");
                                                if (jsonElement82 == null) {
                                                }
                                                if (jsonElement6 != null) {
                                                }
                                                parseString = null;
                                                if (parseString == null) {
                                                }
                                                if (str != null) {
                                                }
                                                unknown = new ChatEventPayload.Unknown(parseString);
                                                return new ChatEvent(str, num != null ? num.intValue() : 0, unknown, bool, bool2, bool3, bool4);
                                            }
                                        }
                                        bool3 = null;
                                        jsonElement5 = asJsonObject.get("toolcall_first_data");
                                        if (jsonElement5 != null) {
                                        }
                                        bool4 = null;
                                        JsonElement jsonElement822 = asJsonObject.get("data");
                                        if (jsonElement822 == null) {
                                        }
                                        if (jsonElement6 != null) {
                                        }
                                        parseString = null;
                                        if (parseString == null) {
                                        }
                                        if (str != null) {
                                        }
                                        unknown = new ChatEventPayload.Unknown(parseString);
                                        return new ChatEvent(str, num != null ? num.intValue() : 0, unknown, bool, bool2, bool3, bool4);
                                    }
                                }
                                bool2 = null;
                                jsonElement4 = asJsonObject.get("thought_first_data");
                                if (jsonElement4 != null) {
                                }
                                bool3 = null;
                                jsonElement5 = asJsonObject.get("toolcall_first_data");
                                if (jsonElement5 != null) {
                                }
                                bool4 = null;
                                JsonElement jsonElement8222 = asJsonObject.get("data");
                                if (jsonElement8222 == null) {
                                }
                                if (jsonElement6 != null) {
                                }
                                parseString = null;
                                if (parseString == null) {
                                }
                                if (str != null) {
                                }
                                unknown = new ChatEventPayload.Unknown(parseString);
                                return new ChatEvent(str, num != null ? num.intValue() : 0, unknown, bool, bool2, bool3, bool4);
                            }
                        }
                        bool = null;
                        jsonElement3 = asJsonObject.get("clean_thought");
                        if (jsonElement3 != null) {
                        }
                        bool2 = null;
                        jsonElement4 = asJsonObject.get("thought_first_data");
                        if (jsonElement4 != null) {
                        }
                        bool3 = null;
                        jsonElement5 = asJsonObject.get("toolcall_first_data");
                        if (jsonElement5 != null) {
                        }
                        bool4 = null;
                        JsonElement jsonElement82222 = asJsonObject.get("data");
                        if (jsonElement82222 == null) {
                        }
                        if (jsonElement6 != null) {
                        }
                        parseString = null;
                        if (parseString == null) {
                        }
                        if (str != null) {
                        }
                        unknown = new ChatEventPayload.Unknown(parseString);
                        return new ChatEvent(str, num != null ? num.intValue() : 0, unknown, bool, bool2, bool3, bool4);
                    }
                }
                num = null;
                jsonElement2 = asJsonObject.get("new_tool_call");
                if (jsonElement2 != null) {
                }
                bool = null;
                jsonElement3 = asJsonObject.get("clean_thought");
                if (jsonElement3 != null) {
                }
                bool2 = null;
                jsonElement4 = asJsonObject.get("thought_first_data");
                if (jsonElement4 != null) {
                }
                bool3 = null;
                jsonElement5 = asJsonObject.get("toolcall_first_data");
                if (jsonElement5 != null) {
                }
                bool4 = null;
                JsonElement jsonElement822222 = asJsonObject.get("data");
                if (jsonElement822222 == null) {
                }
                if (jsonElement6 != null) {
                }
                parseString = null;
                if (parseString == null) {
                }
                if (str != null) {
                }
                unknown = new ChatEventPayload.Unknown(parseString);
                return new ChatEvent(str, num != null ? num.intValue() : 0, unknown, bool, bool2, bool3, bool4);
            }
        }
        str = null;
        jsonElement = asJsonObject.get(OnekeyLoginConstants.CU_KEY_SEQ);
        if (jsonElement != null) {
        }
        num = null;
        jsonElement2 = asJsonObject.get("new_tool_call");
        if (jsonElement2 != null) {
        }
        bool = null;
        jsonElement3 = asJsonObject.get("clean_thought");
        if (jsonElement3 != null) {
        }
        bool2 = null;
        jsonElement4 = asJsonObject.get("thought_first_data");
        if (jsonElement4 != null) {
        }
        bool3 = null;
        jsonElement5 = asJsonObject.get("toolcall_first_data");
        if (jsonElement5 != null) {
        }
        bool4 = null;
        JsonElement jsonElement8222222 = asJsonObject.get("data");
        if (jsonElement8222222 == null) {
        }
        if (jsonElement6 != null) {
        }
        parseString = null;
        if (parseString == null) {
        }
        if (str != null) {
        }
        unknown = new ChatEventPayload.Unknown(parseString);
        return new ChatEvent(str, num != null ? num.intValue() : 0, unknown, bool, bool2, bool3, bool4);
    }
}
