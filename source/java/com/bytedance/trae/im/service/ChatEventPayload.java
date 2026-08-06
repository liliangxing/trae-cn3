package com.bytedance.trae.im.service;

import com.bytedance.sdk.account.monitor.AccountMonitorConstants;
import com.bytedance.sdk.xbridge.cn.media.utils.FConstants;
import com.bytedance.sdk.xbridge.cn.p003ui.utils.StatusBarUtils;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.bytedance.timonbase.scene.PageDataManager;
import com.bytedance.trae.conversation.tracker.NewTaskTracker;
import com.bytedance.trae.im.model.NullSafeJsonObjectAdapter;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IMEvent.kt */
@kotlin.Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\f\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000fB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b¨\u0006\u001c"}, d2 = {"Lcom/bytedance/trae/im/service/ChatEventPayload;", "", "<init>", "()V", "Metadata", "Done", "SessionTitle", "PlanItem", "UserMessage", "Error", "Unknown", "Queuing", "Notification", "TimingEvents", "TokenUsage", "FastRequestSavings", "Lcom/bytedance/trae/im/service/ChatEventPayload$Done;", "Lcom/bytedance/trae/im/service/ChatEventPayload$Error;", "Lcom/bytedance/trae/im/service/ChatEventPayload$FastRequestSavings;", "Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;", "Lcom/bytedance/trae/im/service/ChatEventPayload$Notification;", "Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;", "Lcom/bytedance/trae/im/service/ChatEventPayload$Queuing;", "Lcom/bytedance/trae/im/service/ChatEventPayload$SessionTitle;", "Lcom/bytedance/trae/im/service/ChatEventPayload$TimingEvents;", "Lcom/bytedance/trae/im/service/ChatEventPayload$TokenUsage;", "Lcom/bytedance/trae/im/service/ChatEventPayload$Unknown;", "Lcom/bytedance/trae/im/service/ChatEventPayload$UserMessage;", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public abstract class ChatEventPayload {
    public /* synthetic */ ChatEventPayload(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private ChatEventPayload() {
    }

    /* compiled from: IMEvent.kt */
    @kotlin.Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b[\b\u0086\b\u0018\u00002\u00020\u0001B\u0099\u0003\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010&\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b,\u0010-J\u000b\u0010Z\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010[\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010^\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u00104J\u000b\u0010_\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010`\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010c\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eHÆ\u0003J\u000b\u0010d\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u0010e\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u0010f\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u000b\u0010g\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010h\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010i\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010j\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010k\u001a\u0004\u0018\u00010\u0019HÆ\u0003J\u000b\u0010l\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010m\u001a\u0004\u0018\u00010\u001cHÆ\u0003¢\u0006\u0002\u0010IJ\u000b\u0010n\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u0010o\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u0010p\u001a\u0004\u0018\u00010 HÆ\u0003J\u000b\u0010q\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010s\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u0010t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010u\u001a\u0004\u0018\u00010&HÆ\u0003¢\u0006\u0002\u0010TJ\u0010\u0010v\u001a\u0004\u0018\u00010&HÆ\u0003¢\u0006\u0002\u0010TJ\u0010\u0010w\u001a\u0004\u0018\u00010\u001cHÆ\u0003¢\u0006\u0002\u0010IJ\u0010\u0010x\u001a\u0004\u0018\u00010\u001cHÆ\u0003¢\u0006\u0002\u0010IJ\u000b\u0010y\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010z\u001a\u0004\u0018\u00010\u0003HÆ\u0003J \u0003\u0010{\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010&2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010|J\u0013\u0010}\u001a\u00020&2\b\u0010~\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u007f\u001a\u00020\bHÖ\u0001J\n\u0010\u0080\u0001\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010/R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010/R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010/R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00105\u001a\u0004\b3\u00104R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u0010/R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u0010/R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u0010/R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010/R\u001e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010=R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bA\u0010/R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bB\u0010/R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bC\u0010/R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bD\u0010/R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00198\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bE\u0010FR\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bG\u0010/R\u001a\u0010\u001b\u001a\u0004\u0018\u00010\u001c8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010J\u001a\u0004\bH\u0010IR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bK\u0010=R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bL\u0010=R\u0018\u0010\u001f\u001a\u0004\u0018\u00010 8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bM\u0010NR\u0018\u0010!\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bO\u0010/R\u0018\u0010\"\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bP\u0010/R\u0018\u0010#\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010=R\u0018\u0010$\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bR\u0010/R\u001a\u0010%\u001a\u0004\u0018\u00010&8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010U\u001a\u0004\bS\u0010TR\u001a\u0010'\u001a\u0004\u0018\u00010&8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010U\u001a\u0004\b'\u0010TR\u001a\u0010(\u001a\u0004\u0018\u00010\u001c8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010J\u001a\u0004\bV\u0010IR\u001a\u0010)\u001a\u0004\u0018\u00010\u001c8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010J\u001a\u0004\bW\u0010IR\u0018\u0010*\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bX\u0010/R\u0018\u0010+\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bY\u0010/¨\u0006\u0081\u0001"}, d2 = {"Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;", "Lcom/bytedance/trae/im/service/ChatEventPayload;", "messageId", "", "turnId", "sessionId", "messageType", "messageIndex", "", PageDataManager.EXTRA_STATUS, "chatProcessVersion", "agentProcessSupport", "replyToMessageId", "references", "", "", "contextMetadata", "searchReferenceData", "docReferences", "Lcom/bytedance/trae/im/service/DocReferences;", "agentType", "agentId", "agentName", "agentAvatarId", "userMessageContext", "Lcom/bytedance/trae/im/service/UserMessageContext;", "traceId", "createdAt", "", "feeUsage", "maxFeeUsage", "modelSmartSelectionMeta", "Lcom/google/gson/JsonObject;", "shallowMementoType", "requestClient", "ttnetAbtest", "agentTaskServiceStrategy", "fromAppend", "", "isWorktree", "chatStartTime", "versionCode", "metadataStatus", "thought", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Object;Ljava/lang/Object;Lcom/bytedance/trae/im/service/DocReferences;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/trae/im/service/UserMessageContext;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Object;Ljava/lang/Object;Lcom/google/gson/JsonObject;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)V", "getMessageId", "()Ljava/lang/String;", "getTurnId", "getSessionId", "getMessageType", "getMessageIndex", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getStatus", "getChatProcessVersion", "getAgentProcessSupport", "getReplyToMessageId", "getReferences", "()Ljava/util/List;", "getContextMetadata", "()Ljava/lang/Object;", "getSearchReferenceData", "getDocReferences", "()Lcom/bytedance/trae/im/service/DocReferences;", "getAgentType", "getAgentId", "getAgentName", "getAgentAvatarId", "getUserMessageContext", "()Lcom/bytedance/trae/im/service/UserMessageContext;", "getTraceId", "getCreatedAt", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getFeeUsage", "getMaxFeeUsage", "getModelSmartSelectionMeta", "()Lcom/google/gson/JsonObject;", "getShallowMementoType", "getRequestClient", "getTtnetAbtest", "getAgentTaskServiceStrategy", "getFromAppend", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getChatStartTime", "getVersionCode", "getMetadataStatus", "getThought", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Object;Ljava/lang/Object;Lcom/bytedance/trae/im/service/DocReferences;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/trae/im/service/UserMessageContext;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Object;Ljava/lang/Object;Lcom/google/gson/JsonObject;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;", "equals", "other", "hashCode", "toString", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class Metadata extends ChatEventPayload {

        @SerializedName("agent_avatar_id")
        private final String agentAvatarId;

        @SerializedName("agent_id")
        private final String agentId;

        @SerializedName("agent_name")
        private final String agentName;

        @SerializedName("agent_process_support")
        private final String agentProcessSupport;

        @SerializedName("agent_task_service_strategy")
        private final String agentTaskServiceStrategy;

        @SerializedName("agent_type")
        private final String agentType;

        @SerializedName("chat_process_version")
        private final String chatProcessVersion;

        @SerializedName("chat_start_time")
        private final Long chatStartTime;

        @SerializedName("context_metadata")
        private final Object contextMetadata;

        @SerializedName("created_at")
        private final Long createdAt;

        @SerializedName("doc_references")
        private final DocReferences docReferences;

        @SerializedName("fee_usage")
        private final Object feeUsage;

        @SerializedName(alternate = {"from_append_msg"}, value = "fromAppend")
        private final Boolean fromAppend;

        @SerializedName("is_worktree")
        private final Boolean isWorktree;

        @SerializedName("max_fee_usage")
        private final Object maxFeeUsage;

        @SerializedName("message_id")
        private final String messageId;

        @SerializedName("message_index")
        private final Integer messageIndex;

        @SerializedName("message_type")
        private final String messageType;

        @SerializedName("metadata_status")
        private final String metadataStatus;

        @SerializedName("model_smart_selection_meta")
        @JsonAdapter(NullSafeJsonObjectAdapter.class)
        private final JsonObject modelSmartSelectionMeta;

        @SerializedName("references")
        private final List<Object> references;

        @SerializedName("reply_to_message_id")
        private final String replyToMessageId;

        @SerializedName("request_client")
        private final String requestClient;

        @SerializedName("search_reference_data")
        private final Object searchReferenceData;

        @SerializedName("session_id")
        private final String sessionId;

        @SerializedName("shallow_memento_type")
        private final String shallowMementoType;

        @SerializedName(PageDataManager.EXTRA_STATUS)
        private final String status;

        @SerializedName("thought")
        private final String thought;

        @SerializedName("trace_id")
        private final String traceId;

        @SerializedName("ttnet_abtest")
        private final Object ttnetAbtest;

        @SerializedName("turn_id")
        private final String turnId;

        @SerializedName("user_message_context")
        private final UserMessageContext userMessageContext;

        @SerializedName("version_code")
        private final Long versionCode;

        public Metadata() {
            this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, 1, null);
        }

        /* renamed from: component1, reason: from getter */
        public final String getMessageId() {
            return this.messageId;
        }

        public final List<Object> component10() {
            return this.references;
        }

        /* renamed from: component11, reason: from getter */
        public final Object getContextMetadata() {
            return this.contextMetadata;
        }

        /* renamed from: component12, reason: from getter */
        public final Object getSearchReferenceData() {
            return this.searchReferenceData;
        }

        /* renamed from: component13, reason: from getter */
        public final DocReferences getDocReferences() {
            return this.docReferences;
        }

        /* renamed from: component14, reason: from getter */
        public final String getAgentType() {
            return this.agentType;
        }

        /* renamed from: component15, reason: from getter */
        public final String getAgentId() {
            return this.agentId;
        }

        /* renamed from: component16, reason: from getter */
        public final String getAgentName() {
            return this.agentName;
        }

        /* renamed from: component17, reason: from getter */
        public final String getAgentAvatarId() {
            return this.agentAvatarId;
        }

        /* renamed from: component18, reason: from getter */
        public final UserMessageContext getUserMessageContext() {
            return this.userMessageContext;
        }

        /* renamed from: component19, reason: from getter */
        public final String getTraceId() {
            return this.traceId;
        }

        /* renamed from: component2, reason: from getter */
        public final String getTurnId() {
            return this.turnId;
        }

        /* renamed from: component20, reason: from getter */
        public final Long getCreatedAt() {
            return this.createdAt;
        }

        /* renamed from: component21, reason: from getter */
        public final Object getFeeUsage() {
            return this.feeUsage;
        }

        /* renamed from: component22, reason: from getter */
        public final Object getMaxFeeUsage() {
            return this.maxFeeUsage;
        }

        /* renamed from: component23, reason: from getter */
        public final JsonObject getModelSmartSelectionMeta() {
            return this.modelSmartSelectionMeta;
        }

        /* renamed from: component24, reason: from getter */
        public final String getShallowMementoType() {
            return this.shallowMementoType;
        }

        /* renamed from: component25, reason: from getter */
        public final String getRequestClient() {
            return this.requestClient;
        }

        /* renamed from: component26, reason: from getter */
        public final Object getTtnetAbtest() {
            return this.ttnetAbtest;
        }

        /* renamed from: component27, reason: from getter */
        public final String getAgentTaskServiceStrategy() {
            return this.agentTaskServiceStrategy;
        }

        /* renamed from: component28, reason: from getter */
        public final Boolean getFromAppend() {
            return this.fromAppend;
        }

        /* renamed from: component29, reason: from getter */
        public final Boolean getIsWorktree() {
            return this.isWorktree;
        }

        /* renamed from: component3, reason: from getter */
        public final String getSessionId() {
            return this.sessionId;
        }

        /* renamed from: component30, reason: from getter */
        public final Long getChatStartTime() {
            return this.chatStartTime;
        }

        /* renamed from: component31, reason: from getter */
        public final Long getVersionCode() {
            return this.versionCode;
        }

        /* renamed from: component32, reason: from getter */
        public final String getMetadataStatus() {
            return this.metadataStatus;
        }

        /* renamed from: component33, reason: from getter */
        public final String getThought() {
            return this.thought;
        }

        /* renamed from: component4, reason: from getter */
        public final String getMessageType() {
            return this.messageType;
        }

        /* renamed from: component5, reason: from getter */
        public final Integer getMessageIndex() {
            return this.messageIndex;
        }

        /* renamed from: component6, reason: from getter */
        public final String getStatus() {
            return this.status;
        }

        /* renamed from: component7, reason: from getter */
        public final String getChatProcessVersion() {
            return this.chatProcessVersion;
        }

        /* renamed from: component8, reason: from getter */
        public final String getAgentProcessSupport() {
            return this.agentProcessSupport;
        }

        /* renamed from: component9, reason: from getter */
        public final String getReplyToMessageId() {
            return this.replyToMessageId;
        }

        public final Metadata copy(String messageId, String turnId, String sessionId, String messageType, Integer messageIndex, String status, String chatProcessVersion, String agentProcessSupport, String replyToMessageId, List<? extends Object> references, Object contextMetadata, Object searchReferenceData, DocReferences docReferences, String agentType, String agentId, String agentName, String agentAvatarId, UserMessageContext userMessageContext, String traceId, Long createdAt, Object feeUsage, Object maxFeeUsage, JsonObject modelSmartSelectionMeta, String shallowMementoType, String requestClient, Object ttnetAbtest, String agentTaskServiceStrategy, Boolean fromAppend, Boolean isWorktree, Long chatStartTime, Long versionCode, String metadataStatus, String thought) {
            return new Metadata(messageId, turnId, sessionId, messageType, messageIndex, status, chatProcessVersion, agentProcessSupport, replyToMessageId, references, contextMetadata, searchReferenceData, docReferences, agentType, agentId, agentName, agentAvatarId, userMessageContext, traceId, createdAt, feeUsage, maxFeeUsage, modelSmartSelectionMeta, shallowMementoType, requestClient, ttnetAbtest, agentTaskServiceStrategy, fromAppend, isWorktree, chatStartTime, versionCode, metadataStatus, thought);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Metadata)) {
                return false;
            }
            Metadata metadata = (Metadata) other;
            return Intrinsics.areEqual(this.messageId, metadata.messageId) && Intrinsics.areEqual(this.turnId, metadata.turnId) && Intrinsics.areEqual(this.sessionId, metadata.sessionId) && Intrinsics.areEqual(this.messageType, metadata.messageType) && Intrinsics.areEqual(this.messageIndex, metadata.messageIndex) && Intrinsics.areEqual(this.status, metadata.status) && Intrinsics.areEqual(this.chatProcessVersion, metadata.chatProcessVersion) && Intrinsics.areEqual(this.agentProcessSupport, metadata.agentProcessSupport) && Intrinsics.areEqual(this.replyToMessageId, metadata.replyToMessageId) && Intrinsics.areEqual(this.references, metadata.references) && Intrinsics.areEqual(this.contextMetadata, metadata.contextMetadata) && Intrinsics.areEqual(this.searchReferenceData, metadata.searchReferenceData) && Intrinsics.areEqual(this.docReferences, metadata.docReferences) && Intrinsics.areEqual(this.agentType, metadata.agentType) && Intrinsics.areEqual(this.agentId, metadata.agentId) && Intrinsics.areEqual(this.agentName, metadata.agentName) && Intrinsics.areEqual(this.agentAvatarId, metadata.agentAvatarId) && Intrinsics.areEqual(this.userMessageContext, metadata.userMessageContext) && Intrinsics.areEqual(this.traceId, metadata.traceId) && Intrinsics.areEqual(this.createdAt, metadata.createdAt) && Intrinsics.areEqual(this.feeUsage, metadata.feeUsage) && Intrinsics.areEqual(this.maxFeeUsage, metadata.maxFeeUsage) && Intrinsics.areEqual(this.modelSmartSelectionMeta, metadata.modelSmartSelectionMeta) && Intrinsics.areEqual(this.shallowMementoType, metadata.shallowMementoType) && Intrinsics.areEqual(this.requestClient, metadata.requestClient) && Intrinsics.areEqual(this.ttnetAbtest, metadata.ttnetAbtest) && Intrinsics.areEqual(this.agentTaskServiceStrategy, metadata.agentTaskServiceStrategy) && Intrinsics.areEqual(this.fromAppend, metadata.fromAppend) && Intrinsics.areEqual(this.isWorktree, metadata.isWorktree) && Intrinsics.areEqual(this.chatStartTime, metadata.chatStartTime) && Intrinsics.areEqual(this.versionCode, metadata.versionCode) && Intrinsics.areEqual(this.metadataStatus, metadata.metadataStatus) && Intrinsics.areEqual(this.thought, metadata.thought);
        }

        public int hashCode() {
            String str = this.messageId;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.turnId;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.sessionId;
            int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.messageType;
            int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
            Integer num = this.messageIndex;
            int hashCode5 = (hashCode4 + (num == null ? 0 : num.hashCode())) * 31;
            String str5 = this.status;
            int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.chatProcessVersion;
            int hashCode7 = (hashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
            String str7 = this.agentProcessSupport;
            int hashCode8 = (hashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31;
            String str8 = this.replyToMessageId;
            int hashCode9 = (hashCode8 + (str8 == null ? 0 : str8.hashCode())) * 31;
            List<Object> list = this.references;
            int hashCode10 = (hashCode9 + (list == null ? 0 : list.hashCode())) * 31;
            Object obj = this.contextMetadata;
            int hashCode11 = (hashCode10 + (obj == null ? 0 : obj.hashCode())) * 31;
            Object obj2 = this.searchReferenceData;
            int hashCode12 = (hashCode11 + (obj2 == null ? 0 : obj2.hashCode())) * 31;
            DocReferences docReferences = this.docReferences;
            int hashCode13 = (hashCode12 + (docReferences == null ? 0 : docReferences.hashCode())) * 31;
            String str9 = this.agentType;
            int hashCode14 = (hashCode13 + (str9 == null ? 0 : str9.hashCode())) * 31;
            String str10 = this.agentId;
            int hashCode15 = (hashCode14 + (str10 == null ? 0 : str10.hashCode())) * 31;
            String str11 = this.agentName;
            int hashCode16 = (hashCode15 + (str11 == null ? 0 : str11.hashCode())) * 31;
            String str12 = this.agentAvatarId;
            int hashCode17 = (hashCode16 + (str12 == null ? 0 : str12.hashCode())) * 31;
            UserMessageContext userMessageContext = this.userMessageContext;
            int hashCode18 = (hashCode17 + (userMessageContext == null ? 0 : userMessageContext.hashCode())) * 31;
            String str13 = this.traceId;
            int hashCode19 = (hashCode18 + (str13 == null ? 0 : str13.hashCode())) * 31;
            Long l = this.createdAt;
            int hashCode20 = (hashCode19 + (l == null ? 0 : l.hashCode())) * 31;
            Object obj3 = this.feeUsage;
            int hashCode21 = (hashCode20 + (obj3 == null ? 0 : obj3.hashCode())) * 31;
            Object obj4 = this.maxFeeUsage;
            int hashCode22 = (hashCode21 + (obj4 == null ? 0 : obj4.hashCode())) * 31;
            JsonObject jsonObject = this.modelSmartSelectionMeta;
            int hashCode23 = (hashCode22 + (jsonObject == null ? 0 : jsonObject.hashCode())) * 31;
            String str14 = this.shallowMementoType;
            int hashCode24 = (hashCode23 + (str14 == null ? 0 : str14.hashCode())) * 31;
            String str15 = this.requestClient;
            int hashCode25 = (hashCode24 + (str15 == null ? 0 : str15.hashCode())) * 31;
            Object obj5 = this.ttnetAbtest;
            int hashCode26 = (hashCode25 + (obj5 == null ? 0 : obj5.hashCode())) * 31;
            String str16 = this.agentTaskServiceStrategy;
            int hashCode27 = (hashCode26 + (str16 == null ? 0 : str16.hashCode())) * 31;
            Boolean bool = this.fromAppend;
            int hashCode28 = (hashCode27 + (bool == null ? 0 : bool.hashCode())) * 31;
            Boolean bool2 = this.isWorktree;
            int hashCode29 = (hashCode28 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
            Long l2 = this.chatStartTime;
            int hashCode30 = (hashCode29 + (l2 == null ? 0 : l2.hashCode())) * 31;
            Long l3 = this.versionCode;
            int hashCode31 = (hashCode30 + (l3 == null ? 0 : l3.hashCode())) * 31;
            String str17 = this.metadataStatus;
            int hashCode32 = (hashCode31 + (str17 == null ? 0 : str17.hashCode())) * 31;
            String str18 = this.thought;
            return hashCode32 + (str18 != null ? str18.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("Metadata(messageId=");
            sb.append(this.messageId).append(", turnId=").append(this.turnId).append(", sessionId=").append(this.sessionId).append(", messageType=").append(this.messageType).append(", messageIndex=").append(this.messageIndex).append(", status=").append(this.status).append(", chatProcessVersion=").append(this.chatProcessVersion).append(", agentProcessSupport=").append(this.agentProcessSupport).append(", replyToMessageId=").append(this.replyToMessageId).append(", references=").append(this.references).append(", contextMetadata=").append(this.contextMetadata).append(", searchReferenceData=");
            sb.append(this.searchReferenceData).append(", docReferences=").append(this.docReferences).append(", agentType=").append(this.agentType).append(", agentId=").append(this.agentId).append(", agentName=").append(this.agentName).append(", agentAvatarId=").append(this.agentAvatarId).append(", userMessageContext=").append(this.userMessageContext).append(", traceId=").append(this.traceId).append(", createdAt=").append(this.createdAt).append(", feeUsage=").append(this.feeUsage).append(", maxFeeUsage=").append(this.maxFeeUsage).append(", modelSmartSelectionMeta=").append(this.modelSmartSelectionMeta);
            sb.append(", shallowMementoType=").append(this.shallowMementoType).append(", requestClient=").append(this.requestClient).append(", ttnetAbtest=").append(this.ttnetAbtest).append(", agentTaskServiceStrategy=").append(this.agentTaskServiceStrategy).append(", fromAppend=").append(this.fromAppend).append(", isWorktree=").append(this.isWorktree).append(", chatStartTime=").append(this.chatStartTime).append(", versionCode=").append(this.versionCode).append(", metadataStatus=").append(this.metadataStatus).append(", thought=").append(this.thought).append(')');
            return sb.toString();
        }

        public /* synthetic */ Metadata(String str, String str2, String str3, String str4, Integer num, String str5, String str6, String str7, String str8, List list, Object obj, Object obj2, DocReferences docReferences, String str9, String str10, String str11, String str12, UserMessageContext userMessageContext, String str13, Long l, Object obj3, Object obj4, JsonObject jsonObject, String str14, String str15, Object obj5, String str16, Boolean bool, Boolean bool2, Long l2, Long l3, String str17, String str18, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : num, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : str6, (i & 128) != 0 ? null : str7, (i & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? null : str8, (i & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? null : list, (i & 1024) != 0 ? null : obj, (i & 2048) != 0 ? null : obj2, (i & 4096) != 0 ? null : docReferences, (i & FConstants.DOWNLOAD_BUFFER_SIZE) != 0 ? null : str9, (i & 16384) != 0 ? null : str10, (i & 32768) != 0 ? null : str11, (i & 65536) != 0 ? null : str12, (i & 131072) != 0 ? null : userMessageContext, (i & 262144) != 0 ? null : str13, (i & FConstants.SLICE_SIZE) != 0 ? null : l, (i & 1048576) != 0 ? null : obj3, (i & 2097152) != 0 ? null : obj4, (i & 4194304) != 0 ? null : jsonObject, (i & 8388608) != 0 ? null : str14, (i & 16777216) != 0 ? null : str15, (i & 33554432) != 0 ? null : obj5, (i & 67108864) != 0 ? null : str16, (i & 134217728) != 0 ? null : bool, (i & 268435456) != 0 ? null : bool2, (i & 536870912) != 0 ? null : l2, (i & 1073741824) != 0 ? null : l3, (i & Integer.MIN_VALUE) != 0 ? null : str17, (i2 & 1) != 0 ? null : str18);
        }

        public final String getMessageId() {
            return this.messageId;
        }

        public final String getTurnId() {
            return this.turnId;
        }

        public final String getSessionId() {
            return this.sessionId;
        }

        public final String getMessageType() {
            return this.messageType;
        }

        public final Integer getMessageIndex() {
            return this.messageIndex;
        }

        public final String getStatus() {
            return this.status;
        }

        public final String getChatProcessVersion() {
            return this.chatProcessVersion;
        }

        public final String getAgentProcessSupport() {
            return this.agentProcessSupport;
        }

        public final String getReplyToMessageId() {
            return this.replyToMessageId;
        }

        public final List<Object> getReferences() {
            return this.references;
        }

        public final Object getContextMetadata() {
            return this.contextMetadata;
        }

        public final Object getSearchReferenceData() {
            return this.searchReferenceData;
        }

        public final DocReferences getDocReferences() {
            return this.docReferences;
        }

        public final String getAgentType() {
            return this.agentType;
        }

        public final String getAgentId() {
            return this.agentId;
        }

        public final String getAgentName() {
            return this.agentName;
        }

        public final String getAgentAvatarId() {
            return this.agentAvatarId;
        }

        public final UserMessageContext getUserMessageContext() {
            return this.userMessageContext;
        }

        public final String getTraceId() {
            return this.traceId;
        }

        public final Long getCreatedAt() {
            return this.createdAt;
        }

        public final Object getFeeUsage() {
            return this.feeUsage;
        }

        public final Object getMaxFeeUsage() {
            return this.maxFeeUsage;
        }

        public final JsonObject getModelSmartSelectionMeta() {
            return this.modelSmartSelectionMeta;
        }

        public final String getShallowMementoType() {
            return this.shallowMementoType;
        }

        public final String getRequestClient() {
            return this.requestClient;
        }

        public final Object getTtnetAbtest() {
            return this.ttnetAbtest;
        }

        public final String getAgentTaskServiceStrategy() {
            return this.agentTaskServiceStrategy;
        }

        public final Boolean getFromAppend() {
            return this.fromAppend;
        }

        public final Boolean isWorktree() {
            return this.isWorktree;
        }

        public final Long getChatStartTime() {
            return this.chatStartTime;
        }

        public final Long getVersionCode() {
            return this.versionCode;
        }

        public final String getMetadataStatus() {
            return this.metadataStatus;
        }

        public final String getThought() {
            return this.thought;
        }

        public Metadata(String str, String str2, String str3, String str4, Integer num, String str5, String str6, String str7, String str8, List<? extends Object> list, Object obj, Object obj2, DocReferences docReferences, String str9, String str10, String str11, String str12, UserMessageContext userMessageContext, String str13, Long l, Object obj3, Object obj4, JsonObject jsonObject, String str14, String str15, Object obj5, String str16, Boolean bool, Boolean bool2, Long l2, Long l3, String str17, String str18) {
            super(null);
            this.messageId = str;
            this.turnId = str2;
            this.sessionId = str3;
            this.messageType = str4;
            this.messageIndex = num;
            this.status = str5;
            this.chatProcessVersion = str6;
            this.agentProcessSupport = str7;
            this.replyToMessageId = str8;
            this.references = list;
            this.contextMetadata = obj;
            this.searchReferenceData = obj2;
            this.docReferences = docReferences;
            this.agentType = str9;
            this.agentId = str10;
            this.agentName = str11;
            this.agentAvatarId = str12;
            this.userMessageContext = userMessageContext;
            this.traceId = str13;
            this.createdAt = l;
            this.feeUsage = obj3;
            this.maxFeeUsage = obj4;
            this.modelSmartSelectionMeta = jsonObject;
            this.shallowMementoType = str14;
            this.requestClient = str15;
            this.ttnetAbtest = obj5;
            this.agentTaskServiceStrategy = str16;
            this.fromAppend = bool;
            this.isWorktree = bool2;
            this.chatStartTime = l2;
            this.versionCode = l3;
            this.metadataStatus = str17;
            this.thought = str18;
        }
    }

    /* compiled from: IMEvent.kt */
    @kotlin.Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J>\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u000f\u0010\rR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001e"}, d2 = {"Lcom/bytedance/trae/im/service/ChatEventPayload$Done;", "Lcom/bytedance/trae/im/service/ChatEventPayload;", PageDataManager.EXTRA_STATUS, "", "chatStartTime", "", "chatEndTime", "replyToMessageId", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;)V", "getStatus", "()Ljava/lang/String;", "getChatStartTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getChatEndTime", "getReplyToMessageId", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;)Lcom/bytedance/trae/im/service/ChatEventPayload$Done;", "equals", "", "other", "", "hashCode", "", "toString", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class Done extends ChatEventPayload {

        @SerializedName("chat_end_time")
        private final Long chatEndTime;

        @SerializedName("chat_start_time")
        private final Long chatStartTime;

        @SerializedName("reply_to_message_id")
        private final String replyToMessageId;

        @SerializedName(PageDataManager.EXTRA_STATUS)
        private final String status;

        public Done() {
            this(null, null, null, null, 15, null);
        }

        public static /* synthetic */ Done copy$default(Done done, String str, Long l, Long l2, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = done.status;
            }
            if ((i & 2) != 0) {
                l = done.chatStartTime;
            }
            if ((i & 4) != 0) {
                l2 = done.chatEndTime;
            }
            if ((i & 8) != 0) {
                str2 = done.replyToMessageId;
            }
            return done.copy(str, l, l2, str2);
        }

        /* renamed from: component1, reason: from getter */
        public final String getStatus() {
            return this.status;
        }

        /* renamed from: component2, reason: from getter */
        public final Long getChatStartTime() {
            return this.chatStartTime;
        }

        /* renamed from: component3, reason: from getter */
        public final Long getChatEndTime() {
            return this.chatEndTime;
        }

        /* renamed from: component4, reason: from getter */
        public final String getReplyToMessageId() {
            return this.replyToMessageId;
        }

        public final Done copy(String status, Long chatStartTime, Long chatEndTime, String replyToMessageId) {
            return new Done(status, chatStartTime, chatEndTime, replyToMessageId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Done)) {
                return false;
            }
            Done done = (Done) other;
            return Intrinsics.areEqual(this.status, done.status) && Intrinsics.areEqual(this.chatStartTime, done.chatStartTime) && Intrinsics.areEqual(this.chatEndTime, done.chatEndTime) && Intrinsics.areEqual(this.replyToMessageId, done.replyToMessageId);
        }

        public int hashCode() {
            String str = this.status;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            Long l = this.chatStartTime;
            int hashCode2 = (hashCode + (l == null ? 0 : l.hashCode())) * 31;
            Long l2 = this.chatEndTime;
            int hashCode3 = (hashCode2 + (l2 == null ? 0 : l2.hashCode())) * 31;
            String str2 = this.replyToMessageId;
            return hashCode3 + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "Done(status=" + this.status + ", chatStartTime=" + this.chatStartTime + ", chatEndTime=" + this.chatEndTime + ", replyToMessageId=" + this.replyToMessageId + ')';
        }

        public /* synthetic */ Done(String str, Long l, Long l2, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : l, (i & 4) != 0 ? null : l2, (i & 8) != 0 ? null : str2);
        }

        public final String getStatus() {
            return this.status;
        }

        public final Long getChatStartTime() {
            return this.chatStartTime;
        }

        public final Long getChatEndTime() {
            return this.chatEndTime;
        }

        public final String getReplyToMessageId() {
            return this.replyToMessageId;
        }

        public Done(String str, Long l, Long l2, String str2) {
            super(null);
            this.status = str;
            this.chatStartTime = l;
            this.chatEndTime = l2;
            this.replyToMessageId = str2;
        }
    }

    /* compiled from: IMEvent.kt */
    @kotlin.Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/trae/im/service/ChatEventPayload$SessionTitle;", "Lcom/bytedance/trae/im/service/ChatEventPayload;", "sessionId", "", "sessionTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getSessionId", "()Ljava/lang/String;", "getSessionTitle", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class SessionTitle extends ChatEventPayload {

        @SerializedName("session_id")
        private final String sessionId;

        @SerializedName("session_title")
        private final String sessionTitle;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public SessionTitle() {
            this(r0, r0, 3, r0);
            String str = null;
        }

        public static /* synthetic */ SessionTitle copy$default(SessionTitle sessionTitle, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = sessionTitle.sessionId;
            }
            if ((i & 2) != 0) {
                str2 = sessionTitle.sessionTitle;
            }
            return sessionTitle.copy(str, str2);
        }

        /* renamed from: component1, reason: from getter */
        public final String getSessionId() {
            return this.sessionId;
        }

        /* renamed from: component2, reason: from getter */
        public final String getSessionTitle() {
            return this.sessionTitle;
        }

        public final SessionTitle copy(String sessionId, String sessionTitle) {
            return new SessionTitle(sessionId, sessionTitle);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SessionTitle)) {
                return false;
            }
            SessionTitle sessionTitle = (SessionTitle) other;
            return Intrinsics.areEqual(this.sessionId, sessionTitle.sessionId) && Intrinsics.areEqual(this.sessionTitle, sessionTitle.sessionTitle);
        }

        public int hashCode() {
            String str = this.sessionId;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.sessionTitle;
            return hashCode + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "SessionTitle(sessionId=" + this.sessionId + ", sessionTitle=" + this.sessionTitle + ')';
        }

        public /* synthetic */ SessionTitle(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
        }

        public final String getSessionId() {
            return this.sessionId;
        }

        public final String getSessionTitle() {
            return this.sessionTitle;
        }

        public SessionTitle(String str, String str2) {
            super(null);
            this.sessionId = str;
            this.sessionTitle = str2;
        }
    }

    /* compiled from: IMEvent.kt */
    @kotlin.Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b&\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B£\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00102\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010$J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jª\u0001\u00104\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u00105J\u0013\u00106\u001a\u00020\u00112\b\u00107\u001a\u0004\u0018\u000108HÖ\u0003J\t\u00109\u001a\u00020:HÖ\u0001J\t\u0010;\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0016R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0016R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0016R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0016R\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010%\u001a\u0004\b#\u0010$R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0016¨\u0006<"}, d2 = {"Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;", "Lcom/bytedance/trae/im/service/ChatEventPayload;", "id", "", "taskId", "thought", "reasoningContent", "toolCallInfo", "Lcom/bytedance/trae/im/service/ToolCallInfo;", "confirmInfo", "Lcom/google/gson/JsonObject;", "agentId", "agentDisplayName", "agentRunId", "subAgentCallDescription", "planType", "hide", "", "replyToMessageId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/trae/im/service/ToolCallInfo;Lcom/google/gson/JsonObject;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getTaskId", "getThought", "getReasoningContent", "getToolCallInfo", "()Lcom/bytedance/trae/im/service/ToolCallInfo;", "getConfirmInfo", "()Lcom/google/gson/JsonObject;", "getAgentId", "getAgentDisplayName", "getAgentRunId", "getSubAgentCallDescription", "getPlanType", "getHide", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getReplyToMessageId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/trae/im/service/ToolCallInfo;Lcom/google/gson/JsonObject;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;", "equals", "other", "", "hashCode", "", "toString", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class PlanItem extends ChatEventPayload {

        @SerializedName("agent_display_name")
        private final String agentDisplayName;

        @SerializedName("agent_id")
        private final String agentId;

        @SerializedName("agent_run_id")
        private final String agentRunId;

        @SerializedName("confirm_info")
        private final JsonObject confirmInfo;

        @SerializedName("hide")
        private final Boolean hide;

        @SerializedName("id")
        private final String id;

        @SerializedName("plan_type")
        private final String planType;

        @SerializedName("reasoning_content")
        private final String reasoningContent;

        @SerializedName("reply_to_message_id")
        private final String replyToMessageId;

        @SerializedName("sub_agent_call_description")
        private final String subAgentCallDescription;

        @SerializedName(NewTaskTracker.Param.TASK_ID)
        private final String taskId;

        @SerializedName("thought")
        private final String thought;

        @SerializedName("tool_call_info")
        private final ToolCallInfo toolCallInfo;

        public PlanItem() {
            this(null, null, null, null, null, null, null, null, null, null, null, null, null, 8191, null);
        }

        /* renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* renamed from: component10, reason: from getter */
        public final String getSubAgentCallDescription() {
            return this.subAgentCallDescription;
        }

        /* renamed from: component11, reason: from getter */
        public final String getPlanType() {
            return this.planType;
        }

        /* renamed from: component12, reason: from getter */
        public final Boolean getHide() {
            return this.hide;
        }

        /* renamed from: component13, reason: from getter */
        public final String getReplyToMessageId() {
            return this.replyToMessageId;
        }

        /* renamed from: component2, reason: from getter */
        public final String getTaskId() {
            return this.taskId;
        }

        /* renamed from: component3, reason: from getter */
        public final String getThought() {
            return this.thought;
        }

        /* renamed from: component4, reason: from getter */
        public final String getReasoningContent() {
            return this.reasoningContent;
        }

        /* renamed from: component5, reason: from getter */
        public final ToolCallInfo getToolCallInfo() {
            return this.toolCallInfo;
        }

        /* renamed from: component6, reason: from getter */
        public final JsonObject getConfirmInfo() {
            return this.confirmInfo;
        }

        /* renamed from: component7, reason: from getter */
        public final String getAgentId() {
            return this.agentId;
        }

        /* renamed from: component8, reason: from getter */
        public final String getAgentDisplayName() {
            return this.agentDisplayName;
        }

        /* renamed from: component9, reason: from getter */
        public final String getAgentRunId() {
            return this.agentRunId;
        }

        public final PlanItem copy(String id, String taskId, String thought, String reasoningContent, ToolCallInfo toolCallInfo, JsonObject confirmInfo, String agentId, String agentDisplayName, String agentRunId, String subAgentCallDescription, String planType, Boolean hide, String replyToMessageId) {
            return new PlanItem(id, taskId, thought, reasoningContent, toolCallInfo, confirmInfo, agentId, agentDisplayName, agentRunId, subAgentCallDescription, planType, hide, replyToMessageId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PlanItem)) {
                return false;
            }
            PlanItem planItem = (PlanItem) other;
            return Intrinsics.areEqual(this.id, planItem.id) && Intrinsics.areEqual(this.taskId, planItem.taskId) && Intrinsics.areEqual(this.thought, planItem.thought) && Intrinsics.areEqual(this.reasoningContent, planItem.reasoningContent) && Intrinsics.areEqual(this.toolCallInfo, planItem.toolCallInfo) && Intrinsics.areEqual(this.confirmInfo, planItem.confirmInfo) && Intrinsics.areEqual(this.agentId, planItem.agentId) && Intrinsics.areEqual(this.agentDisplayName, planItem.agentDisplayName) && Intrinsics.areEqual(this.agentRunId, planItem.agentRunId) && Intrinsics.areEqual(this.subAgentCallDescription, planItem.subAgentCallDescription) && Intrinsics.areEqual(this.planType, planItem.planType) && Intrinsics.areEqual(this.hide, planItem.hide) && Intrinsics.areEqual(this.replyToMessageId, planItem.replyToMessageId);
        }

        public int hashCode() {
            String str = this.id;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.taskId;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.thought;
            int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.reasoningContent;
            int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
            ToolCallInfo toolCallInfo = this.toolCallInfo;
            int hashCode5 = (hashCode4 + (toolCallInfo == null ? 0 : toolCallInfo.hashCode())) * 31;
            JsonObject jsonObject = this.confirmInfo;
            int hashCode6 = (hashCode5 + (jsonObject == null ? 0 : jsonObject.hashCode())) * 31;
            String str5 = this.agentId;
            int hashCode7 = (hashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.agentDisplayName;
            int hashCode8 = (hashCode7 + (str6 == null ? 0 : str6.hashCode())) * 31;
            String str7 = this.agentRunId;
            int hashCode9 = (hashCode8 + (str7 == null ? 0 : str7.hashCode())) * 31;
            String str8 = this.subAgentCallDescription;
            int hashCode10 = (hashCode9 + (str8 == null ? 0 : str8.hashCode())) * 31;
            String str9 = this.planType;
            int hashCode11 = (hashCode10 + (str9 == null ? 0 : str9.hashCode())) * 31;
            Boolean bool = this.hide;
            int hashCode12 = (hashCode11 + (bool == null ? 0 : bool.hashCode())) * 31;
            String str10 = this.replyToMessageId;
            return hashCode12 + (str10 != null ? str10.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("PlanItem(id=");
            sb.append(this.id).append(", taskId=").append(this.taskId).append(", thought=").append(this.thought).append(", reasoningContent=").append(this.reasoningContent).append(", toolCallInfo=").append(this.toolCallInfo).append(", confirmInfo=").append(this.confirmInfo).append(", agentId=").append(this.agentId).append(", agentDisplayName=").append(this.agentDisplayName).append(", agentRunId=").append(this.agentRunId).append(", subAgentCallDescription=").append(this.subAgentCallDescription).append(", planType=").append(this.planType).append(", hide=");
            sb.append(this.hide).append(", replyToMessageId=").append(this.replyToMessageId).append(')');
            return sb.toString();
        }

        public /* synthetic */ PlanItem(String str, String str2, String str3, String str4, ToolCallInfo toolCallInfo, JsonObject jsonObject, String str5, String str6, String str7, String str8, String str9, Boolean bool, String str10, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : toolCallInfo, (i & 32) != 0 ? null : jsonObject, (i & 64) != 0 ? null : str5, (i & 128) != 0 ? null : str6, (i & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? null : str7, (i & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? null : str8, (i & 1024) != 0 ? null : str9, (i & 2048) != 0 ? null : bool, (i & 4096) == 0 ? str10 : null);
        }

        public final String getId() {
            return this.id;
        }

        public final String getTaskId() {
            return this.taskId;
        }

        public final String getThought() {
            return this.thought;
        }

        public final String getReasoningContent() {
            return this.reasoningContent;
        }

        public final ToolCallInfo getToolCallInfo() {
            return this.toolCallInfo;
        }

        public final JsonObject getConfirmInfo() {
            return this.confirmInfo;
        }

        public final String getAgentId() {
            return this.agentId;
        }

        public final String getAgentDisplayName() {
            return this.agentDisplayName;
        }

        public final String getAgentRunId() {
            return this.agentRunId;
        }

        public final String getSubAgentCallDescription() {
            return this.subAgentCallDescription;
        }

        public final String getPlanType() {
            return this.planType;
        }

        public final Boolean getHide() {
            return this.hide;
        }

        public final String getReplyToMessageId() {
            return this.replyToMessageId;
        }

        public PlanItem(String str, String str2, String str3, String str4, ToolCallInfo toolCallInfo, JsonObject jsonObject, String str5, String str6, String str7, String str8, String str9, Boolean bool, String str10) {
            super(null);
            this.id = str;
            this.taskId = str2;
            this.thought = str3;
            this.reasoningContent = str4;
            this.toolCallInfo = toolCallInfo;
            this.confirmInfo = jsonObject;
            this.agentId = str5;
            this.agentDisplayName = str6;
            this.agentRunId = str7;
            this.subAgentCallDescription = str8;
            this.planType = str9;
            this.hide = bool;
            this.replyToMessageId = str10;
        }
    }

    /* compiled from: IMEvent.kt */
    @kotlin.Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u007f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010)\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u0010*\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010,\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010 J\u000b\u0010-\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u0086\u0001\u0010.\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÆ\u0001¢\u0006\u0002\u0010/J\u0013\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u000103HÖ\u0003J\t\u00104\u001a\u00020\tHÖ\u0001J\t\u00105\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0014R\u001a\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#¨\u00066"}, d2 = {"Lcom/bytedance/trae/im/service/ChatEventPayload$UserMessage;", "Lcom/bytedance/trae/im/service/ChatEventPayload;", "sessionId", "", "messageId", "turnId", PageDataManager.EXTRA_STATUS, "messageType", "messageIndex", "", ReportConstant.COMMON_CONTENT, "Lcom/google/gson/JsonElement;", "replyToMessageId", "createdAt", "", "userMessageContext", "Lcom/bytedance/trae/im/service/UserMessageContext;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/google/gson/JsonElement;Ljava/lang/String;Ljava/lang/Long;Lcom/bytedance/trae/im/service/UserMessageContext;)V", "getSessionId", "()Ljava/lang/String;", "getMessageId", "getTurnId", "getStatus", "getMessageType", "getMessageIndex", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getContent", "()Lcom/google/gson/JsonElement;", "getReplyToMessageId", "getCreatedAt", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getUserMessageContext", "()Lcom/bytedance/trae/im/service/UserMessageContext;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/google/gson/JsonElement;Ljava/lang/String;Ljava/lang/Long;Lcom/bytedance/trae/im/service/UserMessageContext;)Lcom/bytedance/trae/im/service/ChatEventPayload$UserMessage;", "equals", "", "other", "", "hashCode", "toString", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class UserMessage extends ChatEventPayload {

        @SerializedName(ReportConstant.COMMON_CONTENT)
        private final JsonElement content;

        @SerializedName("created_at")
        private final Long createdAt;

        @SerializedName("message_id")
        private final String messageId;

        @SerializedName("message_index")
        private final Integer messageIndex;

        @SerializedName("message_type")
        private final String messageType;

        @SerializedName("reply_to_message_id")
        private final String replyToMessageId;

        @SerializedName("session_id")
        private final String sessionId;

        @SerializedName(PageDataManager.EXTRA_STATUS)
        private final String status;

        @SerializedName("turn_id")
        private final String turnId;

        @SerializedName("user_message_context")
        private final UserMessageContext userMessageContext;

        public UserMessage() {
            this(null, null, null, null, null, null, null, null, null, null, 1023, null);
        }

        /* renamed from: component1, reason: from getter */
        public final String getSessionId() {
            return this.sessionId;
        }

        /* renamed from: component10, reason: from getter */
        public final UserMessageContext getUserMessageContext() {
            return this.userMessageContext;
        }

        /* renamed from: component2, reason: from getter */
        public final String getMessageId() {
            return this.messageId;
        }

        /* renamed from: component3, reason: from getter */
        public final String getTurnId() {
            return this.turnId;
        }

        /* renamed from: component4, reason: from getter */
        public final String getStatus() {
            return this.status;
        }

        /* renamed from: component5, reason: from getter */
        public final String getMessageType() {
            return this.messageType;
        }

        /* renamed from: component6, reason: from getter */
        public final Integer getMessageIndex() {
            return this.messageIndex;
        }

        /* renamed from: component7, reason: from getter */
        public final JsonElement getContent() {
            return this.content;
        }

        /* renamed from: component8, reason: from getter */
        public final String getReplyToMessageId() {
            return this.replyToMessageId;
        }

        /* renamed from: component9, reason: from getter */
        public final Long getCreatedAt() {
            return this.createdAt;
        }

        public final UserMessage copy(String sessionId, String messageId, String turnId, String status, String messageType, Integer messageIndex, JsonElement content, String replyToMessageId, Long createdAt, UserMessageContext userMessageContext) {
            return new UserMessage(sessionId, messageId, turnId, status, messageType, messageIndex, content, replyToMessageId, createdAt, userMessageContext);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UserMessage)) {
                return false;
            }
            UserMessage userMessage = (UserMessage) other;
            return Intrinsics.areEqual(this.sessionId, userMessage.sessionId) && Intrinsics.areEqual(this.messageId, userMessage.messageId) && Intrinsics.areEqual(this.turnId, userMessage.turnId) && Intrinsics.areEqual(this.status, userMessage.status) && Intrinsics.areEqual(this.messageType, userMessage.messageType) && Intrinsics.areEqual(this.messageIndex, userMessage.messageIndex) && Intrinsics.areEqual(this.content, userMessage.content) && Intrinsics.areEqual(this.replyToMessageId, userMessage.replyToMessageId) && Intrinsics.areEqual(this.createdAt, userMessage.createdAt) && Intrinsics.areEqual(this.userMessageContext, userMessage.userMessageContext);
        }

        public int hashCode() {
            String str = this.sessionId;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.messageId;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.turnId;
            int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.status;
            int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.messageType;
            int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
            Integer num = this.messageIndex;
            int hashCode6 = (hashCode5 + (num == null ? 0 : num.hashCode())) * 31;
            JsonElement jsonElement = this.content;
            int hashCode7 = (hashCode6 + (jsonElement == null ? 0 : jsonElement.hashCode())) * 31;
            String str6 = this.replyToMessageId;
            int hashCode8 = (hashCode7 + (str6 == null ? 0 : str6.hashCode())) * 31;
            Long l = this.createdAt;
            int hashCode9 = (hashCode8 + (l == null ? 0 : l.hashCode())) * 31;
            UserMessageContext userMessageContext = this.userMessageContext;
            return hashCode9 + (userMessageContext != null ? userMessageContext.hashCode() : 0);
        }

        public String toString() {
            return "UserMessage(sessionId=" + this.sessionId + ", messageId=" + this.messageId + ", turnId=" + this.turnId + ", status=" + this.status + ", messageType=" + this.messageType + ", messageIndex=" + this.messageIndex + ", content=" + this.content + ", replyToMessageId=" + this.replyToMessageId + ", createdAt=" + this.createdAt + ", userMessageContext=" + this.userMessageContext + ')';
        }

        public /* synthetic */ UserMessage(String str, String str2, String str3, String str4, String str5, Integer num, JsonElement jsonElement, String str6, Long l, UserMessageContext userMessageContext, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : num, (i & 64) != 0 ? null : jsonElement, (i & 128) != 0 ? null : str6, (i & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? null : l, (i & StatusBarUtils.FLAG_NOTCH_PORTRAIT) == 0 ? userMessageContext : null);
        }

        public final String getSessionId() {
            return this.sessionId;
        }

        public final String getMessageId() {
            return this.messageId;
        }

        public final String getTurnId() {
            return this.turnId;
        }

        public final String getStatus() {
            return this.status;
        }

        public final String getMessageType() {
            return this.messageType;
        }

        public final Integer getMessageIndex() {
            return this.messageIndex;
        }

        public final JsonElement getContent() {
            return this.content;
        }

        public final String getReplyToMessageId() {
            return this.replyToMessageId;
        }

        public final Long getCreatedAt() {
            return this.createdAt;
        }

        public final UserMessageContext getUserMessageContext() {
            return this.userMessageContext;
        }

        public UserMessage(String str, String str2, String str3, String str4, String str5, Integer num, JsonElement jsonElement, String str6, Long l, UserMessageContext userMessageContext) {
            super(null);
            this.sessionId = str;
            this.messageId = str2;
            this.turnId = str3;
            this.status = str4;
            this.messageType = str5;
            this.messageIndex = num;
            this.content = jsonElement;
            this.replyToMessageId = str6;
            this.createdAt = l;
            this.userMessageContext = userMessageContext;
        }
    }

    /* compiled from: IMEvent.kt */
    @kotlin.Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J>\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000f¨\u0006\u001f"}, d2 = {"Lcom/bytedance/trae/im/service/ChatEventPayload$Error;", "Lcom/bytedance/trae/im/service/ChatEventPayload;", "code", "", "message", "", "data", "Lcom/google/gson/JsonObject;", "replyToMessageId", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/google/gson/JsonObject;Ljava/lang/String;)V", "getCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMessage", "()Ljava/lang/String;", "getData", "()Lcom/google/gson/JsonObject;", "getReplyToMessageId", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/google/gson/JsonObject;Ljava/lang/String;)Lcom/bytedance/trae/im/service/ChatEventPayload$Error;", "equals", "", "other", "", "hashCode", "toString", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class Error extends ChatEventPayload {

        @SerializedName("code")
        private final Integer code;

        @SerializedName("data")
        @JsonAdapter(NullSafeJsonObjectAdapter.class)
        private final JsonObject data;

        @SerializedName("message")
        private final String message;

        @SerializedName("reply_to_message_id")
        private final String replyToMessageId;

        public Error() {
            this(null, null, null, null, 15, null);
        }

        public static /* synthetic */ Error copy$default(Error error, Integer num, String str, JsonObject jsonObject, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                num = error.code;
            }
            if ((i & 2) != 0) {
                str = error.message;
            }
            if ((i & 4) != 0) {
                jsonObject = error.data;
            }
            if ((i & 8) != 0) {
                str2 = error.replyToMessageId;
            }
            return error.copy(num, str, jsonObject, str2);
        }

        /* renamed from: component1, reason: from getter */
        public final Integer getCode() {
            return this.code;
        }

        /* renamed from: component2, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        /* renamed from: component3, reason: from getter */
        public final JsonObject getData() {
            return this.data;
        }

        /* renamed from: component4, reason: from getter */
        public final String getReplyToMessageId() {
            return this.replyToMessageId;
        }

        public final Error copy(Integer code, String message, JsonObject data, String replyToMessageId) {
            return new Error(code, message, data, replyToMessageId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Error)) {
                return false;
            }
            Error error = (Error) other;
            return Intrinsics.areEqual(this.code, error.code) && Intrinsics.areEqual(this.message, error.message) && Intrinsics.areEqual(this.data, error.data) && Intrinsics.areEqual(this.replyToMessageId, error.replyToMessageId);
        }

        public int hashCode() {
            Integer num = this.code;
            int hashCode = (num == null ? 0 : num.hashCode()) * 31;
            String str = this.message;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            JsonObject jsonObject = this.data;
            int hashCode3 = (hashCode2 + (jsonObject == null ? 0 : jsonObject.hashCode())) * 31;
            String str2 = this.replyToMessageId;
            return hashCode3 + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "Error(code=" + this.code + ", message=" + this.message + ", data=" + this.data + ", replyToMessageId=" + this.replyToMessageId + ')';
        }

        public /* synthetic */ Error(Integer num, String str, JsonObject jsonObject, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : jsonObject, (i & 8) != 0 ? null : str2);
        }

        public final Integer getCode() {
            return this.code;
        }

        public final String getMessage() {
            return this.message;
        }

        public final JsonObject getData() {
            return this.data;
        }

        public final String getReplyToMessageId() {
            return this.replyToMessageId;
        }

        public Error(Integer num, String str, JsonObject jsonObject, String str2) {
            super(null);
            this.code = num;
            this.message = str;
            this.data = jsonObject;
            this.replyToMessageId = str2;
        }
    }

    /* compiled from: IMEvent.kt */
    @kotlin.Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/bytedance/trae/im/service/ChatEventPayload$Unknown;", "Lcom/bytedance/trae/im/service/ChatEventPayload;", AccountMonitorConstants.CommonParameter.RAW, "Lcom/google/gson/JsonElement;", "<init>", "(Lcom/google/gson/JsonElement;)V", "getRaw", "()Lcom/google/gson/JsonElement;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class Unknown extends ChatEventPayload {
        private final JsonElement raw;

        public static /* synthetic */ Unknown copy$default(Unknown unknown, JsonElement jsonElement, int i, Object obj) {
            if ((i & 1) != 0) {
                jsonElement = unknown.raw;
            }
            return unknown.copy(jsonElement);
        }

        /* renamed from: component1, reason: from getter */
        public final JsonElement getRaw() {
            return this.raw;
        }

        public final Unknown copy(JsonElement raw) {
            return new Unknown(raw);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Unknown) && Intrinsics.areEqual(this.raw, ((Unknown) other).raw);
        }

        public int hashCode() {
            JsonElement jsonElement = this.raw;
            if (jsonElement == null) {
                return 0;
            }
            return jsonElement.hashCode();
        }

        public String toString() {
            return "Unknown(raw=" + this.raw + ')';
        }

        public Unknown(JsonElement jsonElement) {
            super(null);
            this.raw = jsonElement;
        }

        public final JsonElement getRaw() {
            return this.raw;
        }
    }

    /* compiled from: IMEvent.kt */
    @kotlin.Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B[\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u000bHÆ\u0003Jb\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010!J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020\u0003HÖ\u0001J\t\u0010'\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0011\u0010\u000fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006("}, d2 = {"Lcom/bytedance/trae/im/service/ChatEventPayload$Queuing;", "Lcom/bytedance/trae/im/service/ChatEventPayload;", NewTaskTracker.Param.POSITION, "", "queuePosition", "message", "", "queueStatus", "queueId", "requestUUId", "fastRequestEvent", "Lcom/bytedance/trae/im/service/FastRequestEvent;", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/trae/im/service/FastRequestEvent;)V", "getPosition", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getQueuePosition", "getMessage", "()Ljava/lang/String;", "getQueueStatus", "getQueueId", "getRequestUUId", "getFastRequestEvent", "()Lcom/bytedance/trae/im/service/FastRequestEvent;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/trae/im/service/FastRequestEvent;)Lcom/bytedance/trae/im/service/ChatEventPayload$Queuing;", "equals", "", "other", "", "hashCode", "toString", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class Queuing extends ChatEventPayload {

        @SerializedName("fast_request_event")
        private final FastRequestEvent fastRequestEvent;

        @SerializedName("message")
        private final String message;

        @SerializedName(NewTaskTracker.Param.POSITION)
        private final Integer position;

        @SerializedName("queue_id")
        private final String queueId;

        @SerializedName("queue_position")
        private final Integer queuePosition;

        @SerializedName("queue_status")
        private final String queueStatus;

        @SerializedName("request_uuid")
        private final String requestUUId;

        public Queuing() {
            this(null, null, null, null, null, null, null, 127, null);
        }

        public static /* synthetic */ Queuing copy$default(Queuing queuing, Integer num, Integer num2, String str, String str2, String str3, String str4, FastRequestEvent fastRequestEvent, int i, Object obj) {
            if ((i & 1) != 0) {
                num = queuing.position;
            }
            if ((i & 2) != 0) {
                num2 = queuing.queuePosition;
            }
            Integer num3 = num2;
            if ((i & 4) != 0) {
                str = queuing.message;
            }
            String str5 = str;
            if ((i & 8) != 0) {
                str2 = queuing.queueStatus;
            }
            String str6 = str2;
            if ((i & 16) != 0) {
                str3 = queuing.queueId;
            }
            String str7 = str3;
            if ((i & 32) != 0) {
                str4 = queuing.requestUUId;
            }
            String str8 = str4;
            if ((i & 64) != 0) {
                fastRequestEvent = queuing.fastRequestEvent;
            }
            return queuing.copy(num, num3, str5, str6, str7, str8, fastRequestEvent);
        }

        /* renamed from: component1, reason: from getter */
        public final Integer getPosition() {
            return this.position;
        }

        /* renamed from: component2, reason: from getter */
        public final Integer getQueuePosition() {
            return this.queuePosition;
        }

        /* renamed from: component3, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        /* renamed from: component4, reason: from getter */
        public final String getQueueStatus() {
            return this.queueStatus;
        }

        /* renamed from: component5, reason: from getter */
        public final String getQueueId() {
            return this.queueId;
        }

        /* renamed from: component6, reason: from getter */
        public final String getRequestUUId() {
            return this.requestUUId;
        }

        /* renamed from: component7, reason: from getter */
        public final FastRequestEvent getFastRequestEvent() {
            return this.fastRequestEvent;
        }

        public final Queuing copy(Integer position, Integer queuePosition, String message, String queueStatus, String queueId, String requestUUId, FastRequestEvent fastRequestEvent) {
            return new Queuing(position, queuePosition, message, queueStatus, queueId, requestUUId, fastRequestEvent);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Queuing)) {
                return false;
            }
            Queuing queuing = (Queuing) other;
            return Intrinsics.areEqual(this.position, queuing.position) && Intrinsics.areEqual(this.queuePosition, queuing.queuePosition) && Intrinsics.areEqual(this.message, queuing.message) && Intrinsics.areEqual(this.queueStatus, queuing.queueStatus) && Intrinsics.areEqual(this.queueId, queuing.queueId) && Intrinsics.areEqual(this.requestUUId, queuing.requestUUId) && Intrinsics.areEqual(this.fastRequestEvent, queuing.fastRequestEvent);
        }

        public int hashCode() {
            Integer num = this.position;
            int hashCode = (num == null ? 0 : num.hashCode()) * 31;
            Integer num2 = this.queuePosition;
            int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
            String str = this.message;
            int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.queueStatus;
            int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.queueId;
            int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.requestUUId;
            int hashCode6 = (hashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
            FastRequestEvent fastRequestEvent = this.fastRequestEvent;
            return hashCode6 + (fastRequestEvent != null ? fastRequestEvent.hashCode() : 0);
        }

        public String toString() {
            return "Queuing(position=" + this.position + ", queuePosition=" + this.queuePosition + ", message=" + this.message + ", queueStatus=" + this.queueStatus + ", queueId=" + this.queueId + ", requestUUId=" + this.requestUUId + ", fastRequestEvent=" + this.fastRequestEvent + ')';
        }

        public /* synthetic */ Queuing(Integer num, Integer num2, String str, String str2, String str3, String str4, FastRequestEvent fastRequestEvent, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? null : fastRequestEvent);
        }

        public final Integer getPosition() {
            return this.position;
        }

        public final Integer getQueuePosition() {
            return this.queuePosition;
        }

        public final String getMessage() {
            return this.message;
        }

        public final String getQueueStatus() {
            return this.queueStatus;
        }

        public final String getQueueId() {
            return this.queueId;
        }

        public final String getRequestUUId() {
            return this.requestUUId;
        }

        public final FastRequestEvent getFastRequestEvent() {
            return this.fastRequestEvent;
        }

        public Queuing(Integer num, Integer num2, String str, String str2, String str3, String str4, FastRequestEvent fastRequestEvent) {
            super(null);
            this.position = num;
            this.queuePosition = num2;
            this.message = str;
            this.queueStatus = str2;
            this.queueId = str3;
            this.requestUUId = str4;
            this.fastRequestEvent = fastRequestEvent;
        }
    }

    /* compiled from: IMEvent.kt */
    @kotlin.Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000 .2\u00020\u0001:\u0001.Bs\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010$\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jz\u0010&\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010'J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+HÖ\u0003J\t\u0010,\u001a\u00020\u0005HÖ\u0001J\t\u0010-\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u001a\u0010\u0013R\u001a\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u001b\u0010\u0013R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0011¨\u0006/"}, d2 = {"Lcom/bytedance/trae/im/service/ChatEventPayload$Notification;", "Lcom/bytedance/trae/im/service/ChatEventPayload;", "notificationType", "", NewTaskTracker.Param.POSITION, "", "fastRequestEvent", "Lcom/bytedance/trae/im/service/FastRequestEvent;", "requestUUId", "hitRuleId", "hitRuleName", ReportConstant.COMMON_ACTION_TYPE, "executePoint", "message", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Lcom/bytedance/trae/im/service/FastRequestEvent;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V", "getNotificationType", "()Ljava/lang/String;", "getPosition", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getFastRequestEvent", "()Lcom/bytedance/trae/im/service/FastRequestEvent;", "getRequestUUId", "getHitRuleId", "getHitRuleName", "getActionType", "getExecutePoint", "getMessage", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Lcom/bytedance/trae/im/service/FastRequestEvent;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)Lcom/bytedance/trae/im/service/ChatEventPayload$Notification;", "equals", "", "other", "", "hashCode", "toString", "Companion", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class Notification extends ChatEventPayload {
        public static final int ACTION_TYPE_BLOCK = 1;
        public static final int ACTION_TYPE_DESENSITIZE = 2;
        public static final int EXECUTE_POINT_POST = 2;
        public static final int EXECUTE_POINT_PRE = 1;
        public static final String TYPE_CONTENT_FILTER_WARNING = "content_filter_warning";
        public static final String TYPE_QUEUE = "queue";

        @SerializedName("action_type")
        private final Integer actionType;

        @SerializedName(alternate = {"execution_point"}, value = "execute_point")
        private final Integer executePoint;

        @SerializedName("fast_request_event")
        private final FastRequestEvent fastRequestEvent;

        @SerializedName("hit_rule_id")
        private final String hitRuleId;

        @SerializedName("hit_rule_name")
        private final String hitRuleName;

        @SerializedName("message")
        private final String message;

        @SerializedName("notification_type")
        private final String notificationType;

        @SerializedName(NewTaskTracker.Param.POSITION)
        private final Integer position;

        @SerializedName("request_uuid")
        private final String requestUUId;

        public Notification() {
            this(null, null, null, null, null, null, null, null, null, 511, null);
        }

        /* renamed from: component1, reason: from getter */
        public final String getNotificationType() {
            return this.notificationType;
        }

        /* renamed from: component2, reason: from getter */
        public final Integer getPosition() {
            return this.position;
        }

        /* renamed from: component3, reason: from getter */
        public final FastRequestEvent getFastRequestEvent() {
            return this.fastRequestEvent;
        }

        /* renamed from: component4, reason: from getter */
        public final String getRequestUUId() {
            return this.requestUUId;
        }

        /* renamed from: component5, reason: from getter */
        public final String getHitRuleId() {
            return this.hitRuleId;
        }

        /* renamed from: component6, reason: from getter */
        public final String getHitRuleName() {
            return this.hitRuleName;
        }

        /* renamed from: component7, reason: from getter */
        public final Integer getActionType() {
            return this.actionType;
        }

        /* renamed from: component8, reason: from getter */
        public final Integer getExecutePoint() {
            return this.executePoint;
        }

        /* renamed from: component9, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final Notification copy(String notificationType, Integer position, FastRequestEvent fastRequestEvent, String requestUUId, String hitRuleId, String hitRuleName, Integer actionType, Integer executePoint, String message) {
            return new Notification(notificationType, position, fastRequestEvent, requestUUId, hitRuleId, hitRuleName, actionType, executePoint, message);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Notification)) {
                return false;
            }
            Notification notification = (Notification) other;
            return Intrinsics.areEqual(this.notificationType, notification.notificationType) && Intrinsics.areEqual(this.position, notification.position) && Intrinsics.areEqual(this.fastRequestEvent, notification.fastRequestEvent) && Intrinsics.areEqual(this.requestUUId, notification.requestUUId) && Intrinsics.areEqual(this.hitRuleId, notification.hitRuleId) && Intrinsics.areEqual(this.hitRuleName, notification.hitRuleName) && Intrinsics.areEqual(this.actionType, notification.actionType) && Intrinsics.areEqual(this.executePoint, notification.executePoint) && Intrinsics.areEqual(this.message, notification.message);
        }

        public int hashCode() {
            String str = this.notificationType;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            Integer num = this.position;
            int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
            FastRequestEvent fastRequestEvent = this.fastRequestEvent;
            int hashCode3 = (hashCode2 + (fastRequestEvent == null ? 0 : fastRequestEvent.hashCode())) * 31;
            String str2 = this.requestUUId;
            int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.hitRuleId;
            int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.hitRuleName;
            int hashCode6 = (hashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
            Integer num2 = this.actionType;
            int hashCode7 = (hashCode6 + (num2 == null ? 0 : num2.hashCode())) * 31;
            Integer num3 = this.executePoint;
            int hashCode8 = (hashCode7 + (num3 == null ? 0 : num3.hashCode())) * 31;
            String str5 = this.message;
            return hashCode8 + (str5 != null ? str5.hashCode() : 0);
        }

        public String toString() {
            return "Notification(notificationType=" + this.notificationType + ", position=" + this.position + ", fastRequestEvent=" + this.fastRequestEvent + ", requestUUId=" + this.requestUUId + ", hitRuleId=" + this.hitRuleId + ", hitRuleName=" + this.hitRuleName + ", actionType=" + this.actionType + ", executePoint=" + this.executePoint + ", message=" + this.message + ')';
        }

        public /* synthetic */ Notification(String str, Integer num, FastRequestEvent fastRequestEvent, String str2, String str3, String str4, Integer num2, Integer num3, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : fastRequestEvent, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? null : num2, (i & 128) != 0 ? null : num3, (i & StatusBarUtils.FLAG_NOTCH_SUPPORT) == 0 ? str5 : null);
        }

        public final String getNotificationType() {
            return this.notificationType;
        }

        public final Integer getPosition() {
            return this.position;
        }

        public final FastRequestEvent getFastRequestEvent() {
            return this.fastRequestEvent;
        }

        public final String getRequestUUId() {
            return this.requestUUId;
        }

        public final String getHitRuleId() {
            return this.hitRuleId;
        }

        public final String getHitRuleName() {
            return this.hitRuleName;
        }

        public final Integer getActionType() {
            return this.actionType;
        }

        public final Integer getExecutePoint() {
            return this.executePoint;
        }

        public final String getMessage() {
            return this.message;
        }

        public Notification(String str, Integer num, FastRequestEvent fastRequestEvent, String str2, String str3, String str4, Integer num2, Integer num3, String str5) {
            super(null);
            this.notificationType = str;
            this.position = num;
            this.fastRequestEvent = fastRequestEvent;
            this.requestUUId = str2;
            this.hitRuleId = str3;
            this.hitRuleName = str4;
            this.actionType = num2;
            this.executePoint = num3;
            this.message = str5;
        }
    }

    /* compiled from: IMEvent.kt */
    @kotlin.Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u001c\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u007f\u0012\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010$\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010%\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0086\u0001\u0010&\u001a\u00020\u00002\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0002\u0010'J\u0013\u0010(\u001a\u00020\r2\b\u0010)\u001a\u0004\u0018\u00010*HÖ\u0003J\t\u0010+\u001a\u00020,HÖ\u0001J\t\u0010-\u001a\u00020\u0004HÖ\u0001R$\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u001a\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\f\u0010\u001aR\u001a\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u001c\u0010\u001a¨\u0006."}, d2 = {"Lcom/bytedance/trae/im/service/ChatEventPayload$TimingEvents;", "Lcom/bytedance/trae/im/service/ChatEventPayload;", "data", "", "", "", "serverTimingInfo", "modelName", AccountMonitorConstants.CommonParameter.LOGID, "modelAccountName", "modelAccountType", "modelProviderName", "isServerRetried", "", "enableDbOpt", "<init>", "(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getData", "()Ljava/util/Map;", "getServerTimingInfo", "()Ljava/lang/String;", "getModelName", "getLogid", "getModelAccountName", "getModelAccountType", "getModelProviderName", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getEnableDbOpt", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/bytedance/trae/im/service/ChatEventPayload$TimingEvents;", "equals", "other", "", "hashCode", "", "toString", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class TimingEvents extends ChatEventPayload {

        @SerializedName("data")
        private final Map<String, Double> data;

        @SerializedName("enable_db_opt")
        private final Boolean enableDbOpt;

        @SerializedName("is_server_retried")
        private final Boolean isServerRetried;

        @SerializedName(AccountMonitorConstants.CommonParameter.LOGID)
        private final String logid;

        @SerializedName("model_account_name")
        private final String modelAccountName;

        @SerializedName("model_account_type")
        private final String modelAccountType;

        @SerializedName("model_name")
        private final String modelName;

        @SerializedName("model_provider_name")
        private final String modelProviderName;

        @SerializedName("server_timing_info")
        private final String serverTimingInfo;

        public TimingEvents() {
            this(null, null, null, null, null, null, null, null, null, 511, null);
        }

        public final Map<String, Double> component1() {
            return this.data;
        }

        /* renamed from: component2, reason: from getter */
        public final String getServerTimingInfo() {
            return this.serverTimingInfo;
        }

        /* renamed from: component3, reason: from getter */
        public final String getModelName() {
            return this.modelName;
        }

        /* renamed from: component4, reason: from getter */
        public final String getLogid() {
            return this.logid;
        }

        /* renamed from: component5, reason: from getter */
        public final String getModelAccountName() {
            return this.modelAccountName;
        }

        /* renamed from: component6, reason: from getter */
        public final String getModelAccountType() {
            return this.modelAccountType;
        }

        /* renamed from: component7, reason: from getter */
        public final String getModelProviderName() {
            return this.modelProviderName;
        }

        /* renamed from: component8, reason: from getter */
        public final Boolean getIsServerRetried() {
            return this.isServerRetried;
        }

        /* renamed from: component9, reason: from getter */
        public final Boolean getEnableDbOpt() {
            return this.enableDbOpt;
        }

        public final TimingEvents copy(Map<String, Double> data, String serverTimingInfo, String modelName, String logid, String modelAccountName, String modelAccountType, String modelProviderName, Boolean isServerRetried, Boolean enableDbOpt) {
            return new TimingEvents(data, serverTimingInfo, modelName, logid, modelAccountName, modelAccountType, modelProviderName, isServerRetried, enableDbOpt);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TimingEvents)) {
                return false;
            }
            TimingEvents timingEvents = (TimingEvents) other;
            return Intrinsics.areEqual(this.data, timingEvents.data) && Intrinsics.areEqual(this.serverTimingInfo, timingEvents.serverTimingInfo) && Intrinsics.areEqual(this.modelName, timingEvents.modelName) && Intrinsics.areEqual(this.logid, timingEvents.logid) && Intrinsics.areEqual(this.modelAccountName, timingEvents.modelAccountName) && Intrinsics.areEqual(this.modelAccountType, timingEvents.modelAccountType) && Intrinsics.areEqual(this.modelProviderName, timingEvents.modelProviderName) && Intrinsics.areEqual(this.isServerRetried, timingEvents.isServerRetried) && Intrinsics.areEqual(this.enableDbOpt, timingEvents.enableDbOpt);
        }

        public int hashCode() {
            Map<String, Double> map = this.data;
            int hashCode = (map == null ? 0 : map.hashCode()) * 31;
            String str = this.serverTimingInfo;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.modelName;
            int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.logid;
            int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.modelAccountName;
            int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.modelAccountType;
            int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.modelProviderName;
            int hashCode7 = (hashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
            Boolean bool = this.isServerRetried;
            int hashCode8 = (hashCode7 + (bool == null ? 0 : bool.hashCode())) * 31;
            Boolean bool2 = this.enableDbOpt;
            return hashCode8 + (bool2 != null ? bool2.hashCode() : 0);
        }

        public String toString() {
            return "TimingEvents(data=" + this.data + ", serverTimingInfo=" + this.serverTimingInfo + ", modelName=" + this.modelName + ", logid=" + this.logid + ", modelAccountName=" + this.modelAccountName + ", modelAccountType=" + this.modelAccountType + ", modelProviderName=" + this.modelProviderName + ", isServerRetried=" + this.isServerRetried + ", enableDbOpt=" + this.enableDbOpt + ')';
        }

        public /* synthetic */ TimingEvents(Map map, String str, String str2, String str3, String str4, String str5, String str6, Boolean bool, Boolean bool2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : map, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : str6, (i & 128) != 0 ? null : bool, (i & StatusBarUtils.FLAG_NOTCH_SUPPORT) == 0 ? bool2 : null);
        }

        public final Map<String, Double> getData() {
            return this.data;
        }

        public final String getServerTimingInfo() {
            return this.serverTimingInfo;
        }

        public final String getModelName() {
            return this.modelName;
        }

        public final String getLogid() {
            return this.logid;
        }

        public final String getModelAccountName() {
            return this.modelAccountName;
        }

        public final String getModelAccountType() {
            return this.modelAccountType;
        }

        public final String getModelProviderName() {
            return this.modelProviderName;
        }

        public final Boolean isServerRetried() {
            return this.isServerRetried;
        }

        public final Boolean getEnableDbOpt() {
            return this.enableDbOpt;
        }

        public TimingEvents(Map<String, Double> map, String str, String str2, String str3, String str4, String str5, String str6, Boolean bool, Boolean bool2) {
            super(null);
            this.data = map;
            this.serverTimingInfo = str;
            this.modelName = str2;
            this.logid = str3;
            this.modelAccountName = str4;
            this.modelAccountType = str5;
            this.modelProviderName = str6;
            this.isServerRetried = bool;
            this.enableDbOpt = bool2;
        }
    }

    /* compiled from: IMEvent.kt */
    @kotlin.Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b!\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001Bs\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJz\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010#J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'HÖ\u0003J\t\u0010(\u001a\u00020\u0003HÖ\u0001J\t\u0010)\u001a\u00020*HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0011\u0010\u000fR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0012\u0010\u000fR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0013\u0010\u000fR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0014\u0010\u000fR\u001a\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0015\u0010\u000fR\u001a\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0016\u0010\u000fR\u001a\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0017\u0010\u000fR\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0018\u0010\u000f¨\u0006+"}, d2 = {"Lcom/bytedance/trae/im/service/ChatEventPayload$TokenUsage;", "Lcom/bytedance/trae/im/service/ChatEventPayload;", "completionTokens", "", "promptTokens", "reasoningTokens", "totalTokens", "cacheCreationInputTokens", "cacheReadInputTokens", "promptTokensTotal", "completionTokensTotal", "lastTurnTotalTokens", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getCompletionTokens", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPromptTokens", "getReasoningTokens", "getTotalTokens", "getCacheCreationInputTokens", "getCacheReadInputTokens", "getPromptTokensTotal", "getCompletionTokensTotal", "getLastTurnTotalTokens", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/bytedance/trae/im/service/ChatEventPayload$TokenUsage;", "equals", "", "other", "", "hashCode", "toString", "", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class TokenUsage extends ChatEventPayload {

        @SerializedName("cache_creation_input_tokens")
        private final Integer cacheCreationInputTokens;

        @SerializedName("cache_read_input_tokens")
        private final Integer cacheReadInputTokens;

        @SerializedName("completion_tokens")
        private final Integer completionTokens;

        @SerializedName("completion_tokens_total")
        private final Integer completionTokensTotal;

        @SerializedName("last_turn_total_tokens")
        private final Integer lastTurnTotalTokens;

        @SerializedName("prompt_tokens")
        private final Integer promptTokens;

        @SerializedName("prompt_tokens_total")
        private final Integer promptTokensTotal;

        @SerializedName("reasoning_tokens")
        private final Integer reasoningTokens;

        @SerializedName("total_tokens")
        private final Integer totalTokens;

        public TokenUsage() {
            this(null, null, null, null, null, null, null, null, null, 511, null);
        }

        /* renamed from: component1, reason: from getter */
        public final Integer getCompletionTokens() {
            return this.completionTokens;
        }

        /* renamed from: component2, reason: from getter */
        public final Integer getPromptTokens() {
            return this.promptTokens;
        }

        /* renamed from: component3, reason: from getter */
        public final Integer getReasoningTokens() {
            return this.reasoningTokens;
        }

        /* renamed from: component4, reason: from getter */
        public final Integer getTotalTokens() {
            return this.totalTokens;
        }

        /* renamed from: component5, reason: from getter */
        public final Integer getCacheCreationInputTokens() {
            return this.cacheCreationInputTokens;
        }

        /* renamed from: component6, reason: from getter */
        public final Integer getCacheReadInputTokens() {
            return this.cacheReadInputTokens;
        }

        /* renamed from: component7, reason: from getter */
        public final Integer getPromptTokensTotal() {
            return this.promptTokensTotal;
        }

        /* renamed from: component8, reason: from getter */
        public final Integer getCompletionTokensTotal() {
            return this.completionTokensTotal;
        }

        /* renamed from: component9, reason: from getter */
        public final Integer getLastTurnTotalTokens() {
            return this.lastTurnTotalTokens;
        }

        public final TokenUsage copy(Integer completionTokens, Integer promptTokens, Integer reasoningTokens, Integer totalTokens, Integer cacheCreationInputTokens, Integer cacheReadInputTokens, Integer promptTokensTotal, Integer completionTokensTotal, Integer lastTurnTotalTokens) {
            return new TokenUsage(completionTokens, promptTokens, reasoningTokens, totalTokens, cacheCreationInputTokens, cacheReadInputTokens, promptTokensTotal, completionTokensTotal, lastTurnTotalTokens);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TokenUsage)) {
                return false;
            }
            TokenUsage tokenUsage = (TokenUsage) other;
            return Intrinsics.areEqual(this.completionTokens, tokenUsage.completionTokens) && Intrinsics.areEqual(this.promptTokens, tokenUsage.promptTokens) && Intrinsics.areEqual(this.reasoningTokens, tokenUsage.reasoningTokens) && Intrinsics.areEqual(this.totalTokens, tokenUsage.totalTokens) && Intrinsics.areEqual(this.cacheCreationInputTokens, tokenUsage.cacheCreationInputTokens) && Intrinsics.areEqual(this.cacheReadInputTokens, tokenUsage.cacheReadInputTokens) && Intrinsics.areEqual(this.promptTokensTotal, tokenUsage.promptTokensTotal) && Intrinsics.areEqual(this.completionTokensTotal, tokenUsage.completionTokensTotal) && Intrinsics.areEqual(this.lastTurnTotalTokens, tokenUsage.lastTurnTotalTokens);
        }

        public int hashCode() {
            Integer num = this.completionTokens;
            int hashCode = (num == null ? 0 : num.hashCode()) * 31;
            Integer num2 = this.promptTokens;
            int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
            Integer num3 = this.reasoningTokens;
            int hashCode3 = (hashCode2 + (num3 == null ? 0 : num3.hashCode())) * 31;
            Integer num4 = this.totalTokens;
            int hashCode4 = (hashCode3 + (num4 == null ? 0 : num4.hashCode())) * 31;
            Integer num5 = this.cacheCreationInputTokens;
            int hashCode5 = (hashCode4 + (num5 == null ? 0 : num5.hashCode())) * 31;
            Integer num6 = this.cacheReadInputTokens;
            int hashCode6 = (hashCode5 + (num6 == null ? 0 : num6.hashCode())) * 31;
            Integer num7 = this.promptTokensTotal;
            int hashCode7 = (hashCode6 + (num7 == null ? 0 : num7.hashCode())) * 31;
            Integer num8 = this.completionTokensTotal;
            int hashCode8 = (hashCode7 + (num8 == null ? 0 : num8.hashCode())) * 31;
            Integer num9 = this.lastTurnTotalTokens;
            return hashCode8 + (num9 != null ? num9.hashCode() : 0);
        }

        public String toString() {
            return "TokenUsage(completionTokens=" + this.completionTokens + ", promptTokens=" + this.promptTokens + ", reasoningTokens=" + this.reasoningTokens + ", totalTokens=" + this.totalTokens + ", cacheCreationInputTokens=" + this.cacheCreationInputTokens + ", cacheReadInputTokens=" + this.cacheReadInputTokens + ", promptTokensTotal=" + this.promptTokensTotal + ", completionTokensTotal=" + this.completionTokensTotal + ", lastTurnTotalTokens=" + this.lastTurnTotalTokens + ')';
        }

        public /* synthetic */ TokenUsage(Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, Integer num8, Integer num9, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : num3, (i & 8) != 0 ? null : num4, (i & 16) != 0 ? null : num5, (i & 32) != 0 ? null : num6, (i & 64) != 0 ? null : num7, (i & 128) != 0 ? null : num8, (i & StatusBarUtils.FLAG_NOTCH_SUPPORT) == 0 ? num9 : null);
        }

        public final Integer getCompletionTokens() {
            return this.completionTokens;
        }

        public final Integer getPromptTokens() {
            return this.promptTokens;
        }

        public final Integer getReasoningTokens() {
            return this.reasoningTokens;
        }

        public final Integer getTotalTokens() {
            return this.totalTokens;
        }

        public final Integer getCacheCreationInputTokens() {
            return this.cacheCreationInputTokens;
        }

        public final Integer getCacheReadInputTokens() {
            return this.cacheReadInputTokens;
        }

        public final Integer getPromptTokensTotal() {
            return this.promptTokensTotal;
        }

        public final Integer getCompletionTokensTotal() {
            return this.completionTokensTotal;
        }

        public final Integer getLastTurnTotalTokens() {
            return this.lastTurnTotalTokens;
        }

        public TokenUsage(Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, Integer num8, Integer num9) {
            super(null);
            this.completionTokens = num;
            this.promptTokens = num2;
            this.reasoningTokens = num3;
            this.totalTokens = num4;
            this.cacheCreationInputTokens = num5;
            this.cacheReadInputTokens = num6;
            this.promptTokensTotal = num7;
            this.completionTokensTotal = num8;
            this.lastTurnTotalTokens = num9;
        }
    }

    /* compiled from: IMEvent.kt */
    @kotlin.Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ2\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u000b\u0010\tR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\f\u0010\t¨\u0006\u001a"}, d2 = {"Lcom/bytedance/trae/im/service/ChatEventPayload$FastRequestSavings;", "Lcom/bytedance/trae/im/service/ChatEventPayload;", "savedTimeSec", "", "savePositions", "totalSaved", "<init>", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)V", "getSavedTimeSec", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getSavePositions", "getTotalSaved", "component1", "component2", "component3", "copy", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)Lcom/bytedance/trae/im/service/ChatEventPayload$FastRequestSavings;", "equals", "", "other", "", "hashCode", "", "toString", "", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class FastRequestSavings extends ChatEventPayload {

        @SerializedName("saved_positions")
        private final Long savePositions;

        @SerializedName("saved_time_sec")
        private final Long savedTimeSec;

        @SerializedName("total_saved")
        private final Long totalSaved;

        public FastRequestSavings() {
            this(null, null, null, 7, null);
        }

        public static /* synthetic */ FastRequestSavings copy$default(FastRequestSavings fastRequestSavings, Long l, Long l2, Long l3, int i, Object obj) {
            if ((i & 1) != 0) {
                l = fastRequestSavings.savedTimeSec;
            }
            if ((i & 2) != 0) {
                l2 = fastRequestSavings.savePositions;
            }
            if ((i & 4) != 0) {
                l3 = fastRequestSavings.totalSaved;
            }
            return fastRequestSavings.copy(l, l2, l3);
        }

        /* renamed from: component1, reason: from getter */
        public final Long getSavedTimeSec() {
            return this.savedTimeSec;
        }

        /* renamed from: component2, reason: from getter */
        public final Long getSavePositions() {
            return this.savePositions;
        }

        /* renamed from: component3, reason: from getter */
        public final Long getTotalSaved() {
            return this.totalSaved;
        }

        public final FastRequestSavings copy(Long savedTimeSec, Long savePositions, Long totalSaved) {
            return new FastRequestSavings(savedTimeSec, savePositions, totalSaved);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FastRequestSavings)) {
                return false;
            }
            FastRequestSavings fastRequestSavings = (FastRequestSavings) other;
            return Intrinsics.areEqual(this.savedTimeSec, fastRequestSavings.savedTimeSec) && Intrinsics.areEqual(this.savePositions, fastRequestSavings.savePositions) && Intrinsics.areEqual(this.totalSaved, fastRequestSavings.totalSaved);
        }

        public int hashCode() {
            Long l = this.savedTimeSec;
            int hashCode = (l == null ? 0 : l.hashCode()) * 31;
            Long l2 = this.savePositions;
            int hashCode2 = (hashCode + (l2 == null ? 0 : l2.hashCode())) * 31;
            Long l3 = this.totalSaved;
            return hashCode2 + (l3 != null ? l3.hashCode() : 0);
        }

        public String toString() {
            return "FastRequestSavings(savedTimeSec=" + this.savedTimeSec + ", savePositions=" + this.savePositions + ", totalSaved=" + this.totalSaved + ')';
        }

        public /* synthetic */ FastRequestSavings(Long l, Long l2, Long l3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : l, (i & 2) != 0 ? null : l2, (i & 4) != 0 ? null : l3);
        }

        public final Long getSavedTimeSec() {
            return this.savedTimeSec;
        }

        public final Long getSavePositions() {
            return this.savePositions;
        }

        public final Long getTotalSaved() {
            return this.totalSaved;
        }

        public FastRequestSavings(Long l, Long l2, Long l3) {
            super(null);
            this.savedTimeSec = l;
            this.savePositions = l2;
            this.totalSaved = l3;
        }
    }
}
