package com.bytedance.vcloud.impl;

import com.bytedance.vcloud.uniplayer.IAudioBitrate;
import com.bytedance.vcloud.uniplayer.IAudioBitrateMeta;
import com.bytedance.vcloud.uniplayer.IBitrate;
import com.bytedance.vcloud.uniplayer.IPlayRequest;
import com.bytedance.vcloud.uniplayer.IPlayUrlModel;
import com.bytedance.vcloud.uniplayer.IThumbInfoModel;
import com.bytedance.vcloud.uniplayer.IUrlModel;
import com.bytedance.webx.seclink.util.ReportUtil;
import com.lynx.tasm.animation.AnimationConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.StringFormat;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;

/* compiled from: PlayRequestJsonBuilder.kt */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\bÀ\u0002\u0018\u00002\u00020\u0001:\u000f./0123456789:;<B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0018\u0010\u0014\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u001a\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001c\u001a\u00020\u0004H\u0002J\u0010\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0004H\u0002J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u001a\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\"2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002J\u001a\u0010#\u001a\u00020\u00182\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002J\u0017\u0010$\u001a\u00020\u00042\b\u0010%\u001a\u0004\u0018\u00010&H\u0002¢\u0006\u0002\u0010'J*\u0010(\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010*\u0012\u0006\u0012\u0004\u0018\u00010+\u0012\u0006\u0012\u0004\u0018\u00010,0)2\b\u0010-\u001a\u0004\u0018\u00010\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder;", "", "()V", "DYNAMIC_TYPE_SEGMENT_BASE", "", "FILE_TYPE_AUDIO", "FILE_TYPE_VIDEO", "FORMAT_DASH", "FORMAT_MP3", "FORMAT_MP4", "json", "Lkotlinx/serialization/json/Json;", "build", "playRequest", "Lcom/bytedance/vcloud/uniplayer/IPlayRequest;", "buildAudioItemFromBitrate", "Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$VideoDetailItem;", "audioBitrate", "Lcom/bytedance/vcloud/uniplayer/IAudioBitrate;", "buildFallbackVideoItem", "buildVideoItemFromBitrate", "bitrate", "Lcom/bytedance/vcloud/uniplayer/IBitrate;", "extractAudioMeta", "Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$Meta;", "meta", "Lcom/bytedance/vcloud/uniplayer/IAudioBitrateMeta;", "extractBitrate", "url", "extractResolution", "extractUniAudioInfoExt", "Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$UniVideoInfoExt;", "extractUniVideoInfoExt", "playAddr", "Lcom/bytedance/vcloud/uniplayer/IPlayUrlModel;", "extractVideoMeta", "getCodecType", "isByteVc1", "", "(Ljava/lang/Integer;)Ljava/lang/String;", "parseSubInfo", "Lkotlin/Triple;", "Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$RangeInfo;", "Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$CheckInfo;", "Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$EncryptInfo;", "subInfoStr", "CheckInfo", "DynamicVideo", "EncryptInfo", "Meta", "RangeInfo", "SubCheckInfo", "SubEncryptInfo", "SubInfoEntity", "SubRangeInfo", "ThumbInfo", "UniVideoInfoExt", "UniVideoModelV3", "UniVmExt", "VideoDetailItem", "Volume", "uniplayer_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class PlayRequestJsonBuilder {
    private static final String DYNAMIC_TYPE_SEGMENT_BASE = "segment_base";
    private static final String FILE_TYPE_AUDIO = "audio";
    private static final String FILE_TYPE_VIDEO = "video";
    private static final String FORMAT_DASH = "dash";
    private static final String FORMAT_MP3 = "mp3";
    private static final String FORMAT_MP4 = "mp4";
    public static final PlayRequestJsonBuilder INSTANCE = new PlayRequestJsonBuilder();
    private static final Json json = JsonKt.Json$default((Json) null, new Function1<JsonBuilder, Unit>() { // from class: com.bytedance.vcloud.impl.PlayRequestJsonBuilder$json$1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((JsonBuilder) obj);
            return Unit.INSTANCE;
        }

        public final void invoke(JsonBuilder jsonBuilder) {
            Intrinsics.checkNotNullParameter(jsonBuilder, "$this$Json");
            jsonBuilder.setEncodeDefaults(false);
            jsonBuilder.setIgnoreUnknownKeys(true);
        }
    }, 1, (Object) null);

    private PlayRequestJsonBuilder() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PlayRequestJsonBuilder.kt */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0083\b\u0018\u0000 (2\u00020\u0001:\u0002'(B=\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fB%\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\rJ\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J1\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001J&\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%HÁ\u0001¢\u0006\u0002\b&R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006)"}, d2 = {"Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$UniVmExt;", "", "seen1", "", "source_id", "", "log_label", "url_expired_ts", "", "source_type", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;JILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;JI)V", "getLog_label", "()Ljava/lang/String;", "getSource_id", "getSource_type", "()I", "getUrl_expired_ts", "()J", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$uniplayer_release", "$serializer", "Companion", "uniplayer_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
    @Serializable
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final /* data */ class UniVmExt {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String log_label;
        private final String source_id;
        private final int source_type;
        private final long url_expired_ts;

        public static /* synthetic */ UniVmExt copy$default(UniVmExt uniVmExt, String str, String str2, long j, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = uniVmExt.source_id;
            }
            if ((i2 & 2) != 0) {
                str2 = uniVmExt.log_label;
            }
            String str3 = str2;
            if ((i2 & 4) != 0) {
                j = uniVmExt.url_expired_ts;
            }
            long j2 = j;
            if ((i2 & 8) != 0) {
                i = uniVmExt.source_type;
            }
            return uniVmExt.copy(str, str3, j2, i);
        }

        /* renamed from: component1, reason: from getter */
        public final String getSource_id() {
            return this.source_id;
        }

        /* renamed from: component2, reason: from getter */
        public final String getLog_label() {
            return this.log_label;
        }

        /* renamed from: component3, reason: from getter */
        public final long getUrl_expired_ts() {
            return this.url_expired_ts;
        }

        /* renamed from: component4, reason: from getter */
        public final int getSource_type() {
            return this.source_type;
        }

        public final UniVmExt copy(String source_id, String log_label, long url_expired_ts, int source_type) {
            Intrinsics.checkNotNullParameter(source_id, "source_id");
            Intrinsics.checkNotNullParameter(log_label, "log_label");
            return new UniVmExt(source_id, log_label, url_expired_ts, source_type);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UniVmExt)) {
                return false;
            }
            UniVmExt uniVmExt = (UniVmExt) other;
            return Intrinsics.areEqual(this.source_id, uniVmExt.source_id) && Intrinsics.areEqual(this.log_label, uniVmExt.log_label) && this.url_expired_ts == uniVmExt.url_expired_ts && this.source_type == uniVmExt.source_type;
        }

        public int hashCode() {
            return (((((this.source_id.hashCode() * 31) + this.log_label.hashCode()) * 31) + Long.hashCode(this.url_expired_ts)) * 31) + Integer.hashCode(this.source_type);
        }

        public String toString() {
            return "UniVmExt(source_id=" + this.source_id + ", log_label=" + this.log_label + ", url_expired_ts=" + this.url_expired_ts + ", source_type=" + this.source_type + ')';
        }

        /* compiled from: PlayRequestJsonBuilder.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$UniVmExt$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$UniVmExt;", "uniplayer_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<UniVmExt> serializer() {
                return PlayRequestJsonBuilder$UniVmExt$$serializer.INSTANCE;
            }
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ UniVmExt(int i, String str, String str2, long j, int i2, SerializationConstructorMarker serializationConstructorMarker) {
            if (15 != (i & 15)) {
                PluginExceptionsKt.throwMissingFieldException(i, 15, PlayRequestJsonBuilder$UniVmExt$$serializer.INSTANCE.getDescriptor());
            }
            this.source_id = str;
            this.log_label = str2;
            this.url_expired_ts = j;
            this.source_type = i2;
        }

        public UniVmExt(String str, String str2, long j, int i) {
            Intrinsics.checkNotNullParameter(str, "source_id");
            Intrinsics.checkNotNullParameter(str2, "log_label");
            this.source_id = str;
            this.log_label = str2;
            this.url_expired_ts = j;
            this.source_type = i;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$uniplayer_release(UniVmExt self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeStringElement(serialDesc, 0, self.source_id);
            output.encodeStringElement(serialDesc, 1, self.log_label);
            output.encodeLongElement(serialDesc, 2, self.url_expired_ts);
            output.encodeIntElement(serialDesc, 3, self.source_type);
        }

        public final String getSource_id() {
            return this.source_id;
        }

        public final String getLog_label() {
            return this.log_label;
        }

        public final long getUrl_expired_ts() {
            return this.url_expired_ts;
        }

        public final int getSource_type() {
            return this.source_type;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PlayRequestJsonBuilder.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0083\b\u0018\u0000  2\u00020\u0001:\u0002\u001f B)\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tB\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\nJ\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J&\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dHÁ\u0001¢\u0006\u0002\b\u001eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006!"}, d2 = {"Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$Volume;", "", "seen1", "", "loudness", "", "peak", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IDDLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(DD)V", "getLoudness", "()D", "getPeak", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$uniplayer_release", "$serializer", "Companion", "uniplayer_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
    @Serializable
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final /* data */ class Volume {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final double loudness;
        private final double peak;

        public static /* synthetic */ Volume copy$default(Volume volume, double d, double d2, int i, Object obj) {
            if ((i & 1) != 0) {
                d = volume.loudness;
            }
            if ((i & 2) != 0) {
                d2 = volume.peak;
            }
            return volume.copy(d, d2);
        }

        /* renamed from: component1, reason: from getter */
        public final double getLoudness() {
            return this.loudness;
        }

        /* renamed from: component2, reason: from getter */
        public final double getPeak() {
            return this.peak;
        }

        public final Volume copy(double loudness, double peak) {
            return new Volume(loudness, peak);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Volume)) {
                return false;
            }
            Volume volume = (Volume) other;
            return Double.compare(this.loudness, volume.loudness) == 0 && Double.compare(this.peak, volume.peak) == 0;
        }

        public int hashCode() {
            return (Double.hashCode(this.loudness) * 31) + Double.hashCode(this.peak);
        }

        public String toString() {
            return "Volume(loudness=" + this.loudness + ", peak=" + this.peak + ')';
        }

        /* compiled from: PlayRequestJsonBuilder.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$Volume$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$Volume;", "uniplayer_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<Volume> serializer() {
                return PlayRequestJsonBuilder$Volume$$serializer.INSTANCE;
            }
        }

        public Volume(double d, double d2) {
            this.loudness = d;
            this.peak = d2;
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ Volume(int i, double d, double d2, SerializationConstructorMarker serializationConstructorMarker) {
            if (3 != (i & 3)) {
                PluginExceptionsKt.throwMissingFieldException(i, 3, PlayRequestJsonBuilder$Volume$$serializer.INSTANCE.getDescriptor());
            }
            this.loudness = d;
            this.peak = d2;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$uniplayer_release(Volume self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeDoubleElement(serialDesc, 0, self.loudness);
            output.encodeDoubleElement(serialDesc, 1, self.peak);
        }

        public final double getLoudness() {
            return this.loudness;
        }

        public final double getPeak() {
            return this.peak;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PlayRequestJsonBuilder.kt */
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0083\b\u0018\u0000 ?2\u00020\u0001:\u0002>?B\u007f\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006\u0012\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010\u0014Bc\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0006\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u0011¢\u0006\u0002\u0010\u0015J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0006HÆ\u0003J\u000f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00060\u0011HÆ\u0003J\t\u0010(\u001a\u00020\u0006HÆ\u0003J\t\u0010)\u001a\u00020\u0006HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\rHÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J}\u00100\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00062\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u0011HÆ\u0001J\u0013\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00104\u001a\u00020\u0003HÖ\u0001J\t\u00105\u001a\u00020\u0006HÖ\u0001J&\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u00002\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<HÁ\u0001¢\u0006\u0002\b=R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u000f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001bR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001bR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001bR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001bR\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001b¨\u0006@"}, d2 = {"Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$ThumbInfo;", "", "seen1", "", "img_num", "img_uri", "", "img_url", "img_x_size", "img_y_size", "img_x_len", "img_y_len", ReportUtil.Params.DURATION, "", "interval", "fext", "img_urls", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILjava/lang/String;Ljava/lang/String;IIIIDILjava/lang/String;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(ILjava/lang/String;Ljava/lang/String;IIIIDILjava/lang/String;Ljava/util/List;)V", "getDuration", "()D", "getFext", "()Ljava/lang/String;", "getImg_num", "()I", "getImg_uri", "getImg_url", "getImg_urls", "()Ljava/util/List;", "getImg_x_len", "getImg_x_size", "getImg_y_len", "getImg_y_size", "getInterval", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$uniplayer_release", "$serializer", "Companion", "uniplayer_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
    @Serializable
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final /* data */ class ThumbInfo {
        private final double duration;
        private final String fext;
        private final int img_num;
        private final String img_uri;
        private final String img_url;
        private final List<String> img_urls;
        private final int img_x_len;
        private final int img_x_size;
        private final int img_y_len;
        private final int img_y_size;
        private final int interval;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final KSerializer<Object>[] $childSerializers = {null, null, null, null, null, null, null, null, null, null, new ArrayListSerializer(StringSerializer.INSTANCE)};

        /* renamed from: component1, reason: from getter */
        public final int getImg_num() {
            return this.img_num;
        }

        /* renamed from: component10, reason: from getter */
        public final String getFext() {
            return this.fext;
        }

        public final List<String> component11() {
            return this.img_urls;
        }

        /* renamed from: component2, reason: from getter */
        public final String getImg_uri() {
            return this.img_uri;
        }

        /* renamed from: component3, reason: from getter */
        public final String getImg_url() {
            return this.img_url;
        }

        /* renamed from: component4, reason: from getter */
        public final int getImg_x_size() {
            return this.img_x_size;
        }

        /* renamed from: component5, reason: from getter */
        public final int getImg_y_size() {
            return this.img_y_size;
        }

        /* renamed from: component6, reason: from getter */
        public final int getImg_x_len() {
            return this.img_x_len;
        }

        /* renamed from: component7, reason: from getter */
        public final int getImg_y_len() {
            return this.img_y_len;
        }

        /* renamed from: component8, reason: from getter */
        public final double getDuration() {
            return this.duration;
        }

        /* renamed from: component9, reason: from getter */
        public final int getInterval() {
            return this.interval;
        }

        public final ThumbInfo copy(int img_num, String img_uri, String img_url, int img_x_size, int img_y_size, int img_x_len, int img_y_len, double duration, int interval, String fext, List<String> img_urls) {
            Intrinsics.checkNotNullParameter(img_uri, "img_uri");
            Intrinsics.checkNotNullParameter(img_url, "img_url");
            Intrinsics.checkNotNullParameter(fext, "fext");
            Intrinsics.checkNotNullParameter(img_urls, "img_urls");
            return new ThumbInfo(img_num, img_uri, img_url, img_x_size, img_y_size, img_x_len, img_y_len, duration, interval, fext, img_urls);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ThumbInfo)) {
                return false;
            }
            ThumbInfo thumbInfo = (ThumbInfo) other;
            return this.img_num == thumbInfo.img_num && Intrinsics.areEqual(this.img_uri, thumbInfo.img_uri) && Intrinsics.areEqual(this.img_url, thumbInfo.img_url) && this.img_x_size == thumbInfo.img_x_size && this.img_y_size == thumbInfo.img_y_size && this.img_x_len == thumbInfo.img_x_len && this.img_y_len == thumbInfo.img_y_len && Double.compare(this.duration, thumbInfo.duration) == 0 && this.interval == thumbInfo.interval && Intrinsics.areEqual(this.fext, thumbInfo.fext) && Intrinsics.areEqual(this.img_urls, thumbInfo.img_urls);
        }

        public int hashCode() {
            return (((((((((((((((((((Integer.hashCode(this.img_num) * 31) + this.img_uri.hashCode()) * 31) + this.img_url.hashCode()) * 31) + Integer.hashCode(this.img_x_size)) * 31) + Integer.hashCode(this.img_y_size)) * 31) + Integer.hashCode(this.img_x_len)) * 31) + Integer.hashCode(this.img_y_len)) * 31) + Double.hashCode(this.duration)) * 31) + Integer.hashCode(this.interval)) * 31) + this.fext.hashCode()) * 31) + this.img_urls.hashCode();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("ThumbInfo(img_num=");
            sb.append(this.img_num).append(", img_uri=").append(this.img_uri).append(", img_url=").append(this.img_url).append(", img_x_size=").append(this.img_x_size).append(", img_y_size=").append(this.img_y_size).append(", img_x_len=").append(this.img_x_len).append(", img_y_len=").append(this.img_y_len).append(", duration=").append(this.duration).append(", interval=").append(this.interval).append(", fext=").append(this.fext).append(", img_urls=").append(this.img_urls).append(')');
            return sb.toString();
        }

        /* compiled from: PlayRequestJsonBuilder.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$ThumbInfo$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$ThumbInfo;", "uniplayer_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<ThumbInfo> serializer() {
                return PlayRequestJsonBuilder$ThumbInfo$$serializer.INSTANCE;
            }
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ ThumbInfo(int i, int i2, String str, String str2, int i3, int i4, int i5, int i6, double d, int i7, String str3, List list, SerializationConstructorMarker serializationConstructorMarker) {
            if (2047 != (i & 2047)) {
                PluginExceptionsKt.throwMissingFieldException(i, 2047, PlayRequestJsonBuilder$ThumbInfo$$serializer.INSTANCE.getDescriptor());
            }
            this.img_num = i2;
            this.img_uri = str;
            this.img_url = str2;
            this.img_x_size = i3;
            this.img_y_size = i4;
            this.img_x_len = i5;
            this.img_y_len = i6;
            this.duration = d;
            this.interval = i7;
            this.fext = str3;
            this.img_urls = list;
        }

        public ThumbInfo(int i, String str, String str2, int i2, int i3, int i4, int i5, double d, int i6, String str3, List<String> list) {
            Intrinsics.checkNotNullParameter(str, "img_uri");
            Intrinsics.checkNotNullParameter(str2, "img_url");
            Intrinsics.checkNotNullParameter(str3, "fext");
            Intrinsics.checkNotNullParameter(list, "img_urls");
            this.img_num = i;
            this.img_uri = str;
            this.img_url = str2;
            this.img_x_size = i2;
            this.img_y_size = i3;
            this.img_x_len = i4;
            this.img_y_len = i5;
            this.duration = d;
            this.interval = i6;
            this.fext = str3;
            this.img_urls = list;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$uniplayer_release(ThumbInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
            SerializationStrategy[] serializationStrategyArr = $childSerializers;
            output.encodeIntElement(serialDesc, 0, self.img_num);
            output.encodeStringElement(serialDesc, 1, self.img_uri);
            output.encodeStringElement(serialDesc, 2, self.img_url);
            output.encodeIntElement(serialDesc, 3, self.img_x_size);
            output.encodeIntElement(serialDesc, 4, self.img_y_size);
            output.encodeIntElement(serialDesc, 5, self.img_x_len);
            output.encodeIntElement(serialDesc, 6, self.img_y_len);
            output.encodeDoubleElement(serialDesc, 7, self.duration);
            output.encodeIntElement(serialDesc, 8, self.interval);
            output.encodeStringElement(serialDesc, 9, self.fext);
            output.encodeSerializableElement(serialDesc, 10, serializationStrategyArr[10], self.img_urls);
        }

        public final int getImg_num() {
            return this.img_num;
        }

        public final String getImg_uri() {
            return this.img_uri;
        }

        public final String getImg_url() {
            return this.img_url;
        }

        public final int getImg_x_size() {
            return this.img_x_size;
        }

        public final int getImg_y_size() {
            return this.img_y_size;
        }

        public final int getImg_x_len() {
            return this.img_x_len;
        }

        public final int getImg_y_len() {
            return this.img_y_len;
        }

        public final double getDuration() {
            return this.duration;
        }

        public final int getInterval() {
            return this.interval;
        }

        public final String getFext() {
            return this.fext;
        }

        public final List<String> getImg_urls() {
            return this.img_urls;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PlayRequestJsonBuilder.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0083\b\u0018\u0000 \"2\u00020\u0001:\u0002!\"B7\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\u000bJ\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J&\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fHÁ\u0001¢\u0006\u0002\b R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006#"}, d2 = {"Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$RangeInfo;", "", "seen1", "", "init_range", "", "index_range", "first_moof_range", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getFirst_moof_range", "()Ljava/lang/String;", "getIndex_range", "getInit_range", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$uniplayer_release", "$serializer", "Companion", "uniplayer_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
    @Serializable
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final /* data */ class RangeInfo {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String first_moof_range;
        private final String index_range;
        private final String init_range;

        public static /* synthetic */ RangeInfo copy$default(RangeInfo rangeInfo, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = rangeInfo.init_range;
            }
            if ((i & 2) != 0) {
                str2 = rangeInfo.index_range;
            }
            if ((i & 4) != 0) {
                str3 = rangeInfo.first_moof_range;
            }
            return rangeInfo.copy(str, str2, str3);
        }

        /* renamed from: component1, reason: from getter */
        public final String getInit_range() {
            return this.init_range;
        }

        /* renamed from: component2, reason: from getter */
        public final String getIndex_range() {
            return this.index_range;
        }

        /* renamed from: component3, reason: from getter */
        public final String getFirst_moof_range() {
            return this.first_moof_range;
        }

        public final RangeInfo copy(String init_range, String index_range, String first_moof_range) {
            Intrinsics.checkNotNullParameter(init_range, "init_range");
            Intrinsics.checkNotNullParameter(index_range, "index_range");
            Intrinsics.checkNotNullParameter(first_moof_range, "first_moof_range");
            return new RangeInfo(init_range, index_range, first_moof_range);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RangeInfo)) {
                return false;
            }
            RangeInfo rangeInfo = (RangeInfo) other;
            return Intrinsics.areEqual(this.init_range, rangeInfo.init_range) && Intrinsics.areEqual(this.index_range, rangeInfo.index_range) && Intrinsics.areEqual(this.first_moof_range, rangeInfo.first_moof_range);
        }

        public int hashCode() {
            return (((this.init_range.hashCode() * 31) + this.index_range.hashCode()) * 31) + this.first_moof_range.hashCode();
        }

        public String toString() {
            return "RangeInfo(init_range=" + this.init_range + ", index_range=" + this.index_range + ", first_moof_range=" + this.first_moof_range + ')';
        }

        /* compiled from: PlayRequestJsonBuilder.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$RangeInfo$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$RangeInfo;", "uniplayer_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<RangeInfo> serializer() {
                return PlayRequestJsonBuilder$RangeInfo$$serializer.INSTANCE;
            }
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ RangeInfo(int i, String str, String str2, String str3, SerializationConstructorMarker serializationConstructorMarker) {
            if (7 != (i & 7)) {
                PluginExceptionsKt.throwMissingFieldException(i, 7, PlayRequestJsonBuilder$RangeInfo$$serializer.INSTANCE.getDescriptor());
            }
            this.init_range = str;
            this.index_range = str2;
            this.first_moof_range = str3;
        }

        public RangeInfo(String str, String str2, String str3) {
            Intrinsics.checkNotNullParameter(str, "init_range");
            Intrinsics.checkNotNullParameter(str2, "index_range");
            Intrinsics.checkNotNullParameter(str3, "first_moof_range");
            this.init_range = str;
            this.index_range = str2;
            this.first_moof_range = str3;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$uniplayer_release(RangeInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeStringElement(serialDesc, 0, self.init_range);
            output.encodeStringElement(serialDesc, 1, self.index_range);
            output.encodeStringElement(serialDesc, 2, self.first_moof_range);
        }

        public final String getInit_range() {
            return this.init_range;
        }

        public final String getIndex_range() {
            return this.index_range;
        }

        public final String getFirst_moof_range() {
            return this.first_moof_range;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PlayRequestJsonBuilder.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0083\b\u0018\u0000 \u001c2\u00020\u0001:\u0002\u001b\u001cB#\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u0013\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J&\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019HÁ\u0001¢\u0006\u0002\b\u001aR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$CheckInfo;", "", "seen1", "", "check_info", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;)V", "getCheck_info", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$uniplayer_release", "$serializer", "Companion", "uniplayer_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
    @Serializable
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final /* data */ class CheckInfo {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String check_info;

        public static /* synthetic */ CheckInfo copy$default(CheckInfo checkInfo, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = checkInfo.check_info;
            }
            return checkInfo.copy(str);
        }

        /* renamed from: component1, reason: from getter */
        public final String getCheck_info() {
            return this.check_info;
        }

        public final CheckInfo copy(String check_info) {
            Intrinsics.checkNotNullParameter(check_info, "check_info");
            return new CheckInfo(check_info);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof CheckInfo) && Intrinsics.areEqual(this.check_info, ((CheckInfo) other).check_info);
        }

        public int hashCode() {
            return this.check_info.hashCode();
        }

        public String toString() {
            return "CheckInfo(check_info=" + this.check_info + ')';
        }

        /* compiled from: PlayRequestJsonBuilder.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$CheckInfo$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$CheckInfo;", "uniplayer_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<CheckInfo> serializer() {
                return PlayRequestJsonBuilder$CheckInfo$$serializer.INSTANCE;
            }
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ CheckInfo(int i, String str, SerializationConstructorMarker serializationConstructorMarker) {
            if (1 != (i & 1)) {
                PluginExceptionsKt.throwMissingFieldException(i, 1, PlayRequestJsonBuilder$CheckInfo$$serializer.INSTANCE.getDescriptor());
            }
            this.check_info = str;
        }

        public CheckInfo(String str) {
            Intrinsics.checkNotNullParameter(str, "check_info");
            this.check_info = str;
        }

        public final String getCheck_info() {
            return this.check_info;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PlayRequestJsonBuilder.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0083\b\u0018\u0000 \u001f2\u00020\u0001:\u0002\u001e\u001fB-\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tB\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\nJ\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J&\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cHÁ\u0001¢\u0006\u0002\b\u001dR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006 "}, d2 = {"Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$EncryptInfo;", "", "seen1", "", "kid", "", "spade_a", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;)V", "getKid", "()Ljava/lang/String;", "getSpade_a", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$uniplayer_release", "$serializer", "Companion", "uniplayer_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
    @Serializable
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final /* data */ class EncryptInfo {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String kid;
        private final String spade_a;

        public static /* synthetic */ EncryptInfo copy$default(EncryptInfo encryptInfo, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = encryptInfo.kid;
            }
            if ((i & 2) != 0) {
                str2 = encryptInfo.spade_a;
            }
            return encryptInfo.copy(str, str2);
        }

        /* renamed from: component1, reason: from getter */
        public final String getKid() {
            return this.kid;
        }

        /* renamed from: component2, reason: from getter */
        public final String getSpade_a() {
            return this.spade_a;
        }

        public final EncryptInfo copy(String kid, String spade_a) {
            Intrinsics.checkNotNullParameter(kid, "kid");
            Intrinsics.checkNotNullParameter(spade_a, "spade_a");
            return new EncryptInfo(kid, spade_a);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof EncryptInfo)) {
                return false;
            }
            EncryptInfo encryptInfo = (EncryptInfo) other;
            return Intrinsics.areEqual(this.kid, encryptInfo.kid) && Intrinsics.areEqual(this.spade_a, encryptInfo.spade_a);
        }

        public int hashCode() {
            return (this.kid.hashCode() * 31) + this.spade_a.hashCode();
        }

        public String toString() {
            return "EncryptInfo(kid=" + this.kid + ", spade_a=" + this.spade_a + ')';
        }

        /* compiled from: PlayRequestJsonBuilder.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$EncryptInfo$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$EncryptInfo;", "uniplayer_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<EncryptInfo> serializer() {
                return PlayRequestJsonBuilder$EncryptInfo$$serializer.INSTANCE;
            }
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ EncryptInfo(int i, String str, String str2, SerializationConstructorMarker serializationConstructorMarker) {
            if (3 != (i & 3)) {
                PluginExceptionsKt.throwMissingFieldException(i, 3, PlayRequestJsonBuilder$EncryptInfo$$serializer.INSTANCE.getDescriptor());
            }
            this.kid = str;
            this.spade_a = str2;
        }

        public EncryptInfo(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "kid");
            Intrinsics.checkNotNullParameter(str2, "spade_a");
            this.kid = str;
            this.spade_a = str2;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$uniplayer_release(EncryptInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeStringElement(serialDesc, 0, self.kid);
            output.encodeStringElement(serialDesc, 1, self.spade_a);
        }

        public final String getKid() {
            return this.kid;
        }

        public final String getSpade_a() {
            return this.spade_a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PlayRequestJsonBuilder.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0083\b\u0018\u0000 22\u00020\u0001:\u000212B]\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fBM\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0010J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÆ\u0003J\t\u0010 \u001a\u00020\u0007HÆ\u0003J\t\u0010!\u001a\u00020\u0007HÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012JV\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010$J\u0013\u0010%\u001a\u00020\u00052\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020\u0003HÖ\u0001J\t\u0010(\u001a\u00020\u0007HÖ\u0001J&\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00002\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/HÁ\u0001¢\u0006\u0002\b0R\u0015\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u000b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015¨\u00063"}, d2 = {"Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$UniVideoInfoExt;", "", "seen1", "", "need_set_token", "", "decryption_key", "", "decryption_key_not_encoded", "url_key", "gear_name", "related_audio_file_id", "audio_quality_type", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getAudio_quality_type", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDecryption_key", "()Ljava/lang/String;", "getDecryption_key_not_encoded", "getGear_name", "getNeed_set_token", "()Z", "getRelated_audio_file_id", "getUrl_key", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$UniVideoInfoExt;", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$uniplayer_release", "$serializer", "Companion", "uniplayer_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
    @Serializable
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final /* data */ class UniVideoInfoExt {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Integer audio_quality_type;
        private final String decryption_key;
        private final String decryption_key_not_encoded;
        private final String gear_name;
        private final boolean need_set_token;
        private final String related_audio_file_id;
        private final String url_key;

        public UniVideoInfoExt() {
            this(false, (String) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, 127, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ UniVideoInfoExt copy$default(UniVideoInfoExt uniVideoInfoExt, boolean z, String str, String str2, String str3, String str4, String str5, Integer num, int i, Object obj) {
            if ((i & 1) != 0) {
                z = uniVideoInfoExt.need_set_token;
            }
            if ((i & 2) != 0) {
                str = uniVideoInfoExt.decryption_key;
            }
            String str6 = str;
            if ((i & 4) != 0) {
                str2 = uniVideoInfoExt.decryption_key_not_encoded;
            }
            String str7 = str2;
            if ((i & 8) != 0) {
                str3 = uniVideoInfoExt.url_key;
            }
            String str8 = str3;
            if ((i & 16) != 0) {
                str4 = uniVideoInfoExt.gear_name;
            }
            String str9 = str4;
            if ((i & 32) != 0) {
                str5 = uniVideoInfoExt.related_audio_file_id;
            }
            String str10 = str5;
            if ((i & 64) != 0) {
                num = uniVideoInfoExt.audio_quality_type;
            }
            return uniVideoInfoExt.copy(z, str6, str7, str8, str9, str10, num);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getNeed_set_token() {
            return this.need_set_token;
        }

        /* renamed from: component2, reason: from getter */
        public final String getDecryption_key() {
            return this.decryption_key;
        }

        /* renamed from: component3, reason: from getter */
        public final String getDecryption_key_not_encoded() {
            return this.decryption_key_not_encoded;
        }

        /* renamed from: component4, reason: from getter */
        public final String getUrl_key() {
            return this.url_key;
        }

        /* renamed from: component5, reason: from getter */
        public final String getGear_name() {
            return this.gear_name;
        }

        /* renamed from: component6, reason: from getter */
        public final String getRelated_audio_file_id() {
            return this.related_audio_file_id;
        }

        /* renamed from: component7, reason: from getter */
        public final Integer getAudio_quality_type() {
            return this.audio_quality_type;
        }

        public final UniVideoInfoExt copy(boolean need_set_token, String decryption_key, String decryption_key_not_encoded, String url_key, String gear_name, String related_audio_file_id, Integer audio_quality_type) {
            Intrinsics.checkNotNullParameter(decryption_key, "decryption_key");
            Intrinsics.checkNotNullParameter(decryption_key_not_encoded, "decryption_key_not_encoded");
            Intrinsics.checkNotNullParameter(url_key, "url_key");
            Intrinsics.checkNotNullParameter(gear_name, "gear_name");
            Intrinsics.checkNotNullParameter(related_audio_file_id, "related_audio_file_id");
            return new UniVideoInfoExt(need_set_token, decryption_key, decryption_key_not_encoded, url_key, gear_name, related_audio_file_id, audio_quality_type);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UniVideoInfoExt)) {
                return false;
            }
            UniVideoInfoExt uniVideoInfoExt = (UniVideoInfoExt) other;
            return this.need_set_token == uniVideoInfoExt.need_set_token && Intrinsics.areEqual(this.decryption_key, uniVideoInfoExt.decryption_key) && Intrinsics.areEqual(this.decryption_key_not_encoded, uniVideoInfoExt.decryption_key_not_encoded) && Intrinsics.areEqual(this.url_key, uniVideoInfoExt.url_key) && Intrinsics.areEqual(this.gear_name, uniVideoInfoExt.gear_name) && Intrinsics.areEqual(this.related_audio_file_id, uniVideoInfoExt.related_audio_file_id) && Intrinsics.areEqual(this.audio_quality_type, uniVideoInfoExt.audio_quality_type);
        }

        public int hashCode() {
            int hashCode = ((((((((((Boolean.hashCode(this.need_set_token) * 31) + this.decryption_key.hashCode()) * 31) + this.decryption_key_not_encoded.hashCode()) * 31) + this.url_key.hashCode()) * 31) + this.gear_name.hashCode()) * 31) + this.related_audio_file_id.hashCode()) * 31;
            Integer num = this.audio_quality_type;
            return hashCode + (num == null ? 0 : num.hashCode());
        }

        public String toString() {
            return "UniVideoInfoExt(need_set_token=" + this.need_set_token + ", decryption_key=" + this.decryption_key + ", decryption_key_not_encoded=" + this.decryption_key_not_encoded + ", url_key=" + this.url_key + ", gear_name=" + this.gear_name + ", related_audio_file_id=" + this.related_audio_file_id + ", audio_quality_type=" + this.audio_quality_type + ')';
        }

        /* compiled from: PlayRequestJsonBuilder.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$UniVideoInfoExt$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$UniVideoInfoExt;", "uniplayer_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<UniVideoInfoExt> serializer() {
                return PlayRequestJsonBuilder$UniVideoInfoExt$$serializer.INSTANCE;
            }
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ UniVideoInfoExt(int i, boolean z, String str, String str2, String str3, String str4, String str5, Integer num, SerializationConstructorMarker serializationConstructorMarker) {
            if ((i & 0) != 0) {
                PluginExceptionsKt.throwMissingFieldException(i, 0, PlayRequestJsonBuilder$UniVideoInfoExt$$serializer.INSTANCE.getDescriptor());
            }
            if ((i & 1) == 0) {
                this.need_set_token = false;
            } else {
                this.need_set_token = z;
            }
            if ((i & 2) == 0) {
                this.decryption_key = "";
            } else {
                this.decryption_key = str;
            }
            if ((i & 4) == 0) {
                this.decryption_key_not_encoded = "";
            } else {
                this.decryption_key_not_encoded = str2;
            }
            if ((i & 8) == 0) {
                this.url_key = "";
            } else {
                this.url_key = str3;
            }
            if ((i & 16) == 0) {
                this.gear_name = "";
            } else {
                this.gear_name = str4;
            }
            if ((i & 32) == 0) {
                this.related_audio_file_id = "";
            } else {
                this.related_audio_file_id = str5;
            }
            if ((i & 64) == 0) {
                this.audio_quality_type = null;
            } else {
                this.audio_quality_type = num;
            }
        }

        public UniVideoInfoExt(boolean z, String str, String str2, String str3, String str4, String str5, Integer num) {
            Intrinsics.checkNotNullParameter(str, "decryption_key");
            Intrinsics.checkNotNullParameter(str2, "decryption_key_not_encoded");
            Intrinsics.checkNotNullParameter(str3, "url_key");
            Intrinsics.checkNotNullParameter(str4, "gear_name");
            Intrinsics.checkNotNullParameter(str5, "related_audio_file_id");
            this.need_set_token = z;
            this.decryption_key = str;
            this.decryption_key_not_encoded = str2;
            this.url_key = str3;
            this.gear_name = str4;
            this.related_audio_file_id = str5;
            this.audio_quality_type = num;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$uniplayer_release(UniVideoInfoExt self, CompositeEncoder output, SerialDescriptor serialDesc) {
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.need_set_token) {
                output.encodeBooleanElement(serialDesc, 0, self.need_set_token);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.decryption_key, "")) {
                output.encodeStringElement(serialDesc, 1, self.decryption_key);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || !Intrinsics.areEqual(self.decryption_key_not_encoded, "")) {
                output.encodeStringElement(serialDesc, 2, self.decryption_key_not_encoded);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 3) || !Intrinsics.areEqual(self.url_key, "")) {
                output.encodeStringElement(serialDesc, 3, self.url_key);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 4) || !Intrinsics.areEqual(self.gear_name, "")) {
                output.encodeStringElement(serialDesc, 4, self.gear_name);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 5) || !Intrinsics.areEqual(self.related_audio_file_id, "")) {
                output.encodeStringElement(serialDesc, 5, self.related_audio_file_id);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 6) || self.audio_quality_type != null) {
                output.encodeNullableSerializableElement(serialDesc, 6, IntSerializer.INSTANCE, self.audio_quality_type);
            }
        }

        public /* synthetic */ UniVideoInfoExt(boolean z, String str, String str2, String str3, String str4, String str5, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? false : z, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? "" : str2, (i & 8) != 0 ? "" : str3, (i & 16) != 0 ? "" : str4, (i & 32) == 0 ? str5 : "", (i & 64) != 0 ? null : num);
        }

        public final boolean getNeed_set_token() {
            return this.need_set_token;
        }

        public final String getDecryption_key() {
            return this.decryption_key;
        }

        public final String getDecryption_key_not_encoded() {
            return this.decryption_key_not_encoded;
        }

        public final String getUrl_key() {
            return this.url_key;
        }

        public final String getGear_name() {
            return this.gear_name;
        }

        public final String getRelated_audio_file_id() {
            return this.related_audio_file_id;
        }

        public final Integer getAudio_quality_type() {
            return this.audio_quality_type;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PlayRequestJsonBuilder.kt */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0083\b\u0018\u0000 C2\u00020\u0001:\u0002BCB\u008f\u0001\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0002\u0010\u0015B\u0087\u0001\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003¢\u0006\u0002\u0010\u0016J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\t\u0010(\u001a\u00020\u0005HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0005HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0005HÆ\u0003J\t\u0010-\u001a\u00020\u0005HÆ\u0003J\t\u0010.\u001a\u00020\u0005HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0005HÆ\u0003J\t\u00103\u001a\u00020\u000eHÆ\u0003J\u008b\u0001\u00104\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u0003HÆ\u0001J\u0013\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00108\u001a\u00020\u0003HÖ\u0001J\t\u00109\u001a\u00020\u0005HÖ\u0001J&\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\u00002\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@HÁ\u0001¢\u0006\u0002\bAR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0011\u0010\u0011\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0018R\u0011\u0010\u000f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001aR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0018R\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001aR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001aR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0018R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001a¨\u0006D"}, d2 = {"Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$Meta;", "", "seen1", "", "definition", "", "quality", "vtype", "atype", "vwidth", "vheight", "bitrate", "codec_type", "size", "", "file_id", "fps", "file_hash", "real_bitrate", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;JLjava/lang/String;ILjava/lang/String;ILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;JLjava/lang/String;ILjava/lang/String;I)V", "getAtype", "()Ljava/lang/String;", "getBitrate", "()I", "getCodec_type", "getDefinition", "getFile_hash", "getFile_id", "getFps", "getQuality", "getReal_bitrate", "getSize", "()J", "getVheight", "getVtype", "getVwidth", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$uniplayer_release", "$serializer", "Companion", "uniplayer_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
    @Serializable
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final /* data */ class Meta {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String atype;
        private final int bitrate;
        private final String codec_type;
        private final String definition;
        private final String file_hash;
        private final String file_id;
        private final int fps;
        private final String quality;
        private final int real_bitrate;
        private final long size;
        private final int vheight;
        private final String vtype;
        private final int vwidth;

        public Meta() {
            this((String) null, (String) null, (String) null, (String) null, 0, 0, 0, (String) null, 0L, (String) null, 0, (String) null, 0, 8191, (DefaultConstructorMarker) null);
        }

        /* renamed from: component1, reason: from getter */
        public final String getDefinition() {
            return this.definition;
        }

        /* renamed from: component10, reason: from getter */
        public final String getFile_id() {
            return this.file_id;
        }

        /* renamed from: component11, reason: from getter */
        public final int getFps() {
            return this.fps;
        }

        /* renamed from: component12, reason: from getter */
        public final String getFile_hash() {
            return this.file_hash;
        }

        /* renamed from: component13, reason: from getter */
        public final int getReal_bitrate() {
            return this.real_bitrate;
        }

        /* renamed from: component2, reason: from getter */
        public final String getQuality() {
            return this.quality;
        }

        /* renamed from: component3, reason: from getter */
        public final String getVtype() {
            return this.vtype;
        }

        /* renamed from: component4, reason: from getter */
        public final String getAtype() {
            return this.atype;
        }

        /* renamed from: component5, reason: from getter */
        public final int getVwidth() {
            return this.vwidth;
        }

        /* renamed from: component6, reason: from getter */
        public final int getVheight() {
            return this.vheight;
        }

        /* renamed from: component7, reason: from getter */
        public final int getBitrate() {
            return this.bitrate;
        }

        /* renamed from: component8, reason: from getter */
        public final String getCodec_type() {
            return this.codec_type;
        }

        /* renamed from: component9, reason: from getter */
        public final long getSize() {
            return this.size;
        }

        public final Meta copy(String definition, String quality, String vtype, String atype, int vwidth, int vheight, int bitrate, String codec_type, long size, String file_id, int fps, String file_hash, int real_bitrate) {
            Intrinsics.checkNotNullParameter(definition, "definition");
            Intrinsics.checkNotNullParameter(quality, "quality");
            Intrinsics.checkNotNullParameter(vtype, "vtype");
            Intrinsics.checkNotNullParameter(atype, "atype");
            Intrinsics.checkNotNullParameter(codec_type, "codec_type");
            Intrinsics.checkNotNullParameter(file_id, "file_id");
            Intrinsics.checkNotNullParameter(file_hash, "file_hash");
            return new Meta(definition, quality, vtype, atype, vwidth, vheight, bitrate, codec_type, size, file_id, fps, file_hash, real_bitrate);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Meta)) {
                return false;
            }
            Meta meta = (Meta) other;
            return Intrinsics.areEqual(this.definition, meta.definition) && Intrinsics.areEqual(this.quality, meta.quality) && Intrinsics.areEqual(this.vtype, meta.vtype) && Intrinsics.areEqual(this.atype, meta.atype) && this.vwidth == meta.vwidth && this.vheight == meta.vheight && this.bitrate == meta.bitrate && Intrinsics.areEqual(this.codec_type, meta.codec_type) && this.size == meta.size && Intrinsics.areEqual(this.file_id, meta.file_id) && this.fps == meta.fps && Intrinsics.areEqual(this.file_hash, meta.file_hash) && this.real_bitrate == meta.real_bitrate;
        }

        public int hashCode() {
            return (((((((((((((((((((((((this.definition.hashCode() * 31) + this.quality.hashCode()) * 31) + this.vtype.hashCode()) * 31) + this.atype.hashCode()) * 31) + Integer.hashCode(this.vwidth)) * 31) + Integer.hashCode(this.vheight)) * 31) + Integer.hashCode(this.bitrate)) * 31) + this.codec_type.hashCode()) * 31) + Long.hashCode(this.size)) * 31) + this.file_id.hashCode()) * 31) + Integer.hashCode(this.fps)) * 31) + this.file_hash.hashCode()) * 31) + Integer.hashCode(this.real_bitrate);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("Meta(definition=");
            sb.append(this.definition).append(", quality=").append(this.quality).append(", vtype=").append(this.vtype).append(", atype=").append(this.atype).append(", vwidth=").append(this.vwidth).append(", vheight=").append(this.vheight).append(", bitrate=").append(this.bitrate).append(", codec_type=").append(this.codec_type).append(", size=").append(this.size).append(", file_id=").append(this.file_id).append(", fps=").append(this.fps).append(", file_hash=");
            sb.append(this.file_hash).append(", real_bitrate=").append(this.real_bitrate).append(')');
            return sb.toString();
        }

        /* compiled from: PlayRequestJsonBuilder.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$Meta$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$Meta;", "uniplayer_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<Meta> serializer() {
                return PlayRequestJsonBuilder$Meta$$serializer.INSTANCE;
            }
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ Meta(int i, String str, String str2, String str3, String str4, int i2, int i3, int i4, String str5, long j, String str6, int i5, String str7, int i6, SerializationConstructorMarker serializationConstructorMarker) {
            if ((i & 0) != 0) {
                PluginExceptionsKt.throwMissingFieldException(i, 0, PlayRequestJsonBuilder$Meta$$serializer.INSTANCE.getDescriptor());
            }
            if ((i & 1) == 0) {
                this.definition = "";
            } else {
                this.definition = str;
            }
            if ((i & 2) == 0) {
                this.quality = "";
            } else {
                this.quality = str2;
            }
            if ((i & 4) == 0) {
                this.vtype = "";
            } else {
                this.vtype = str3;
            }
            if ((i & 8) == 0) {
                this.atype = "";
            } else {
                this.atype = str4;
            }
            if ((i & 16) == 0) {
                this.vwidth = 0;
            } else {
                this.vwidth = i2;
            }
            if ((i & 32) == 0) {
                this.vheight = 0;
            } else {
                this.vheight = i3;
            }
            if ((i & 64) == 0) {
                this.bitrate = 0;
            } else {
                this.bitrate = i4;
            }
            if ((i & 128) == 0) {
                this.codec_type = "";
            } else {
                this.codec_type = str5;
            }
            this.size = (i & 256) == 0 ? 0L : j;
            if ((i & 512) == 0) {
                this.file_id = "";
            } else {
                this.file_id = str6;
            }
            if ((i & 1024) == 0) {
                this.fps = 0;
            } else {
                this.fps = i5;
            }
            if ((i & AnimationConstant.PROP_BOTTOM) == 0) {
                this.file_hash = "";
            } else {
                this.file_hash = str7;
            }
            if ((i & 4096) == 0) {
                this.real_bitrate = 0;
            } else {
                this.real_bitrate = i6;
            }
        }

        public Meta(String str, String str2, String str3, String str4, int i, int i2, int i3, String str5, long j, String str6, int i4, String str7, int i5) {
            Intrinsics.checkNotNullParameter(str, "definition");
            Intrinsics.checkNotNullParameter(str2, "quality");
            Intrinsics.checkNotNullParameter(str3, "vtype");
            Intrinsics.checkNotNullParameter(str4, "atype");
            Intrinsics.checkNotNullParameter(str5, "codec_type");
            Intrinsics.checkNotNullParameter(str6, "file_id");
            Intrinsics.checkNotNullParameter(str7, "file_hash");
            this.definition = str;
            this.quality = str2;
            this.vtype = str3;
            this.atype = str4;
            this.vwidth = i;
            this.vheight = i2;
            this.bitrate = i3;
            this.codec_type = str5;
            this.size = j;
            this.file_id = str6;
            this.fps = i4;
            this.file_hash = str7;
            this.real_bitrate = i5;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$uniplayer_release(Meta self, CompositeEncoder output, SerialDescriptor serialDesc) {
            if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.definition, "")) {
                output.encodeStringElement(serialDesc, 0, self.definition);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.quality, "")) {
                output.encodeStringElement(serialDesc, 1, self.quality);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || !Intrinsics.areEqual(self.vtype, "")) {
                output.encodeStringElement(serialDesc, 2, self.vtype);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 3) || !Intrinsics.areEqual(self.atype, "")) {
                output.encodeStringElement(serialDesc, 3, self.atype);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 4) || self.vwidth != 0) {
                output.encodeIntElement(serialDesc, 4, self.vwidth);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 5) || self.vheight != 0) {
                output.encodeIntElement(serialDesc, 5, self.vheight);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 6) || self.bitrate != 0) {
                output.encodeIntElement(serialDesc, 6, self.bitrate);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 7) || !Intrinsics.areEqual(self.codec_type, "")) {
                output.encodeStringElement(serialDesc, 7, self.codec_type);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 8) || self.size != 0) {
                output.encodeLongElement(serialDesc, 8, self.size);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 9) || !Intrinsics.areEqual(self.file_id, "")) {
                output.encodeStringElement(serialDesc, 9, self.file_id);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 10) || self.fps != 0) {
                output.encodeIntElement(serialDesc, 10, self.fps);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 11) || !Intrinsics.areEqual(self.file_hash, "")) {
                output.encodeStringElement(serialDesc, 11, self.file_hash);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 12) || self.real_bitrate != 0) {
                output.encodeIntElement(serialDesc, 12, self.real_bitrate);
            }
        }

        public /* synthetic */ Meta(String str, String str2, String str3, String str4, int i, int i2, int i3, String str5, long j, String str6, int i4, String str7, int i5, int i6, DefaultConstructorMarker defaultConstructorMarker) {
            this((i6 & 1) != 0 ? "" : str, (i6 & 2) != 0 ? "" : str2, (i6 & 4) != 0 ? "" : str3, (i6 & 8) != 0 ? "" : str4, (i6 & 16) != 0 ? 0 : i, (i6 & 32) != 0 ? 0 : i2, (i6 & 64) != 0 ? 0 : i3, (i6 & 128) != 0 ? "" : str5, (i6 & 256) != 0 ? 0L : j, (i6 & 512) != 0 ? "" : str6, (i6 & 1024) != 0 ? 0 : i4, (i6 & AnimationConstant.PROP_BOTTOM) == 0 ? str7 : "", (i6 & 4096) == 0 ? i5 : 0);
        }

        public final String getDefinition() {
            return this.definition;
        }

        public final String getQuality() {
            return this.quality;
        }

        public final String getVtype() {
            return this.vtype;
        }

        public final String getAtype() {
            return this.atype;
        }

        public final int getVwidth() {
            return this.vwidth;
        }

        public final int getVheight() {
            return this.vheight;
        }

        public final int getBitrate() {
            return this.bitrate;
        }

        public final String getCodec_type() {
            return this.codec_type;
        }

        public final long getSize() {
            return this.size;
        }

        public final String getFile_id() {
            return this.file_id;
        }

        public final int getFps() {
            return this.fps;
        }

        public final String getFile_hash() {
            return this.file_hash;
        }

        public final int getReal_bitrate() {
            return this.real_bitrate;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PlayRequestJsonBuilder.kt */
    @Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0083\b\u0018\u0000 C2\u00020\u0001:\u0002BCBy\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0002\u0010\u0016Bs\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010\u0017J\u000f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010#J\u000b\u0010-\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0013HÆ\u0003J~\u00103\u001a\u00020\u00002\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÆ\u0001¢\u0006\u0002\u00104J\u0013\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00108\u001a\u00020\u0003HÖ\u0001J\t\u00109\u001a\u00020\u0006HÖ\u0001J&\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\u00002\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@HÁ\u0001¢\u0006\u0002\bAR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010$\u001a\u0004\b\"\u0010#R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0019¨\u0006D"}, d2 = {"Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$VideoDetailItem;", "", "seen1", "", "url_list", "", "", "fallback_url", "quality_type", "video_meta", "Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$Meta;", "audio_meta", "base_range_info", "Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$RangeInfo;", "check_info", "Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$CheckInfo;", "encrypt_info", "Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$EncryptInfo;", "uni_video_info_ext", "Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$UniVideoInfoExt;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Ljava/lang/String;Ljava/lang/Integer;Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$Meta;Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$Meta;Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$RangeInfo;Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$CheckInfo;Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$EncryptInfo;Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$UniVideoInfoExt;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$Meta;Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$Meta;Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$RangeInfo;Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$CheckInfo;Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$EncryptInfo;Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$UniVideoInfoExt;)V", "getAudio_meta", "()Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$Meta;", "getBase_range_info", "()Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$RangeInfo;", "getCheck_info", "()Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$CheckInfo;", "getEncrypt_info", "()Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$EncryptInfo;", "getFallback_url", "()Ljava/lang/String;", "getQuality_type", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getUni_video_info_ext", "()Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$UniVideoInfoExt;", "getUrl_list", "()Ljava/util/List;", "getVideo_meta", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$Meta;Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$Meta;Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$RangeInfo;Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$CheckInfo;Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$EncryptInfo;Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$UniVideoInfoExt;)Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$VideoDetailItem;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$uniplayer_release", "$serializer", "Companion", "uniplayer_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
    @Serializable
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final /* data */ class VideoDetailItem {
        private final Meta audio_meta;
        private final RangeInfo base_range_info;
        private final CheckInfo check_info;
        private final EncryptInfo encrypt_info;
        private final String fallback_url;
        private final Integer quality_type;
        private final UniVideoInfoExt uni_video_info_ext;
        private final List<String> url_list;
        private final Meta video_meta;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final KSerializer<Object>[] $childSerializers = {new ArrayListSerializer(StringSerializer.INSTANCE), null, null, null, null, null, null, null, null};

        public final List<String> component1() {
            return this.url_list;
        }

        /* renamed from: component2, reason: from getter */
        public final String getFallback_url() {
            return this.fallback_url;
        }

        /* renamed from: component3, reason: from getter */
        public final Integer getQuality_type() {
            return this.quality_type;
        }

        /* renamed from: component4, reason: from getter */
        public final Meta getVideo_meta() {
            return this.video_meta;
        }

        /* renamed from: component5, reason: from getter */
        public final Meta getAudio_meta() {
            return this.audio_meta;
        }

        /* renamed from: component6, reason: from getter */
        public final RangeInfo getBase_range_info() {
            return this.base_range_info;
        }

        /* renamed from: component7, reason: from getter */
        public final CheckInfo getCheck_info() {
            return this.check_info;
        }

        /* renamed from: component8, reason: from getter */
        public final EncryptInfo getEncrypt_info() {
            return this.encrypt_info;
        }

        /* renamed from: component9, reason: from getter */
        public final UniVideoInfoExt getUni_video_info_ext() {
            return this.uni_video_info_ext;
        }

        public final VideoDetailItem copy(List<String> url_list, String fallback_url, Integer quality_type, Meta video_meta, Meta audio_meta, RangeInfo base_range_info, CheckInfo check_info, EncryptInfo encrypt_info, UniVideoInfoExt uni_video_info_ext) {
            Intrinsics.checkNotNullParameter(url_list, "url_list");
            return new VideoDetailItem(url_list, fallback_url, quality_type, video_meta, audio_meta, base_range_info, check_info, encrypt_info, uni_video_info_ext);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof VideoDetailItem)) {
                return false;
            }
            VideoDetailItem videoDetailItem = (VideoDetailItem) other;
            return Intrinsics.areEqual(this.url_list, videoDetailItem.url_list) && Intrinsics.areEqual(this.fallback_url, videoDetailItem.fallback_url) && Intrinsics.areEqual(this.quality_type, videoDetailItem.quality_type) && Intrinsics.areEqual(this.video_meta, videoDetailItem.video_meta) && Intrinsics.areEqual(this.audio_meta, videoDetailItem.audio_meta) && Intrinsics.areEqual(this.base_range_info, videoDetailItem.base_range_info) && Intrinsics.areEqual(this.check_info, videoDetailItem.check_info) && Intrinsics.areEqual(this.encrypt_info, videoDetailItem.encrypt_info) && Intrinsics.areEqual(this.uni_video_info_ext, videoDetailItem.uni_video_info_ext);
        }

        public int hashCode() {
            int hashCode = this.url_list.hashCode() * 31;
            String str = this.fallback_url;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            Integer num = this.quality_type;
            int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
            Meta meta = this.video_meta;
            int hashCode4 = (hashCode3 + (meta == null ? 0 : meta.hashCode())) * 31;
            Meta meta2 = this.audio_meta;
            int hashCode5 = (hashCode4 + (meta2 == null ? 0 : meta2.hashCode())) * 31;
            RangeInfo rangeInfo = this.base_range_info;
            int hashCode6 = (hashCode5 + (rangeInfo == null ? 0 : rangeInfo.hashCode())) * 31;
            CheckInfo checkInfo = this.check_info;
            int hashCode7 = (hashCode6 + (checkInfo == null ? 0 : checkInfo.hashCode())) * 31;
            EncryptInfo encryptInfo = this.encrypt_info;
            int hashCode8 = (hashCode7 + (encryptInfo == null ? 0 : encryptInfo.hashCode())) * 31;
            UniVideoInfoExt uniVideoInfoExt = this.uni_video_info_ext;
            return hashCode8 + (uniVideoInfoExt != null ? uniVideoInfoExt.hashCode() : 0);
        }

        public String toString() {
            return "VideoDetailItem(url_list=" + this.url_list + ", fallback_url=" + this.fallback_url + ", quality_type=" + this.quality_type + ", video_meta=" + this.video_meta + ", audio_meta=" + this.audio_meta + ", base_range_info=" + this.base_range_info + ", check_info=" + this.check_info + ", encrypt_info=" + this.encrypt_info + ", uni_video_info_ext=" + this.uni_video_info_ext + ')';
        }

        /* compiled from: PlayRequestJsonBuilder.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$VideoDetailItem$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$VideoDetailItem;", "uniplayer_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<VideoDetailItem> serializer() {
                return PlayRequestJsonBuilder$VideoDetailItem$$serializer.INSTANCE;
            }
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ VideoDetailItem(int i, List list, String str, Integer num, Meta meta, Meta meta2, RangeInfo rangeInfo, CheckInfo checkInfo, EncryptInfo encryptInfo, UniVideoInfoExt uniVideoInfoExt, SerializationConstructorMarker serializationConstructorMarker) {
            if (1 != (i & 1)) {
                PluginExceptionsKt.throwMissingFieldException(i, 1, PlayRequestJsonBuilder$VideoDetailItem$$serializer.INSTANCE.getDescriptor());
            }
            this.url_list = list;
            if ((i & 2) == 0) {
                this.fallback_url = null;
            } else {
                this.fallback_url = str;
            }
            if ((i & 4) == 0) {
                this.quality_type = null;
            } else {
                this.quality_type = num;
            }
            if ((i & 8) == 0) {
                this.video_meta = null;
            } else {
                this.video_meta = meta;
            }
            if ((i & 16) == 0) {
                this.audio_meta = null;
            } else {
                this.audio_meta = meta2;
            }
            if ((i & 32) == 0) {
                this.base_range_info = null;
            } else {
                this.base_range_info = rangeInfo;
            }
            if ((i & 64) == 0) {
                this.check_info = null;
            } else {
                this.check_info = checkInfo;
            }
            if ((i & 128) == 0) {
                this.encrypt_info = null;
            } else {
                this.encrypt_info = encryptInfo;
            }
            if ((i & 256) == 0) {
                this.uni_video_info_ext = null;
            } else {
                this.uni_video_info_ext = uniVideoInfoExt;
            }
        }

        public VideoDetailItem(List<String> list, String str, Integer num, Meta meta, Meta meta2, RangeInfo rangeInfo, CheckInfo checkInfo, EncryptInfo encryptInfo, UniVideoInfoExt uniVideoInfoExt) {
            Intrinsics.checkNotNullParameter(list, "url_list");
            this.url_list = list;
            this.fallback_url = str;
            this.quality_type = num;
            this.video_meta = meta;
            this.audio_meta = meta2;
            this.base_range_info = rangeInfo;
            this.check_info = checkInfo;
            this.encrypt_info = encryptInfo;
            this.uni_video_info_ext = uniVideoInfoExt;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$uniplayer_release(VideoDetailItem self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeSerializableElement(serialDesc, 0, $childSerializers[0], self.url_list);
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.fallback_url != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.fallback_url);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.quality_type != null) {
                output.encodeNullableSerializableElement(serialDesc, 2, IntSerializer.INSTANCE, self.quality_type);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 3) || self.video_meta != null) {
                output.encodeNullableSerializableElement(serialDesc, 3, PlayRequestJsonBuilder$Meta$$serializer.INSTANCE, self.video_meta);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 4) || self.audio_meta != null) {
                output.encodeNullableSerializableElement(serialDesc, 4, PlayRequestJsonBuilder$Meta$$serializer.INSTANCE, self.audio_meta);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 5) || self.base_range_info != null) {
                output.encodeNullableSerializableElement(serialDesc, 5, PlayRequestJsonBuilder$RangeInfo$$serializer.INSTANCE, self.base_range_info);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 6) || self.check_info != null) {
                output.encodeNullableSerializableElement(serialDesc, 6, PlayRequestJsonBuilder$CheckInfo$$serializer.INSTANCE, self.check_info);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 7) || self.encrypt_info != null) {
                output.encodeNullableSerializableElement(serialDesc, 7, PlayRequestJsonBuilder$EncryptInfo$$serializer.INSTANCE, self.encrypt_info);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 8) || self.uni_video_info_ext != null) {
                output.encodeNullableSerializableElement(serialDesc, 8, PlayRequestJsonBuilder$UniVideoInfoExt$$serializer.INSTANCE, self.uni_video_info_ext);
            }
        }

        public /* synthetic */ VideoDetailItem(List list, String str, Integer num, Meta meta, Meta meta2, RangeInfo rangeInfo, CheckInfo checkInfo, EncryptInfo encryptInfo, UniVideoInfoExt uniVideoInfoExt, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(list, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : meta, (i & 16) != 0 ? null : meta2, (i & 32) != 0 ? null : rangeInfo, (i & 64) != 0 ? null : checkInfo, (i & 128) != 0 ? null : encryptInfo, (i & 256) == 0 ? uniVideoInfoExt : null);
        }

        public final List<String> getUrl_list() {
            return this.url_list;
        }

        public final String getFallback_url() {
            return this.fallback_url;
        }

        public final Integer getQuality_type() {
            return this.quality_type;
        }

        public final Meta getVideo_meta() {
            return this.video_meta;
        }

        public final Meta getAudio_meta() {
            return this.audio_meta;
        }

        public final RangeInfo getBase_range_info() {
            return this.base_range_info;
        }

        public final CheckInfo getCheck_info() {
            return this.check_info;
        }

        public final EncryptInfo getEncrypt_info() {
            return this.encrypt_info;
        }

        public final UniVideoInfoExt getUni_video_info_ext() {
            return this.uni_video_info_ext;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PlayRequestJsonBuilder.kt */
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0083\b\u0018\u0000 %2\u00020\u0001:\u0002$%BC\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fB)\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\rJ\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J3\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001J&\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"HÁ\u0001¢\u0006\u0002\b#R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000f¨\u0006&"}, d2 = {"Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$DynamicVideo;", "", "seen1", "", "dynamic_type", "", "dynamic_video_list", "", "Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$VideoDetailItem;", "dynamic_audio_list", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/util/List;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "getDynamic_audio_list", "()Ljava/util/List;", "getDynamic_type", "()Ljava/lang/String;", "getDynamic_video_list", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$uniplayer_release", "$serializer", "Companion", "uniplayer_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
    @Serializable
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final /* data */ class DynamicVideo {
        private final List<VideoDetailItem> dynamic_audio_list;
        private final String dynamic_type;
        private final List<VideoDetailItem> dynamic_video_list;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final KSerializer<Object>[] $childSerializers = {null, new ArrayListSerializer(PlayRequestJsonBuilder$VideoDetailItem$$serializer.INSTANCE), new ArrayListSerializer(PlayRequestJsonBuilder$VideoDetailItem$$serializer.INSTANCE)};

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ DynamicVideo copy$default(DynamicVideo dynamicVideo, String str, List list, List list2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = dynamicVideo.dynamic_type;
            }
            if ((i & 2) != 0) {
                list = dynamicVideo.dynamic_video_list;
            }
            if ((i & 4) != 0) {
                list2 = dynamicVideo.dynamic_audio_list;
            }
            return dynamicVideo.copy(str, list, list2);
        }

        /* renamed from: component1, reason: from getter */
        public final String getDynamic_type() {
            return this.dynamic_type;
        }

        public final List<VideoDetailItem> component2() {
            return this.dynamic_video_list;
        }

        public final List<VideoDetailItem> component3() {
            return this.dynamic_audio_list;
        }

        public final DynamicVideo copy(String dynamic_type, List<VideoDetailItem> dynamic_video_list, List<VideoDetailItem> dynamic_audio_list) {
            Intrinsics.checkNotNullParameter(dynamic_type, "dynamic_type");
            Intrinsics.checkNotNullParameter(dynamic_video_list, "dynamic_video_list");
            Intrinsics.checkNotNullParameter(dynamic_audio_list, "dynamic_audio_list");
            return new DynamicVideo(dynamic_type, dynamic_video_list, dynamic_audio_list);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DynamicVideo)) {
                return false;
            }
            DynamicVideo dynamicVideo = (DynamicVideo) other;
            return Intrinsics.areEqual(this.dynamic_type, dynamicVideo.dynamic_type) && Intrinsics.areEqual(this.dynamic_video_list, dynamicVideo.dynamic_video_list) && Intrinsics.areEqual(this.dynamic_audio_list, dynamicVideo.dynamic_audio_list);
        }

        public int hashCode() {
            return (((this.dynamic_type.hashCode() * 31) + this.dynamic_video_list.hashCode()) * 31) + this.dynamic_audio_list.hashCode();
        }

        public String toString() {
            return "DynamicVideo(dynamic_type=" + this.dynamic_type + ", dynamic_video_list=" + this.dynamic_video_list + ", dynamic_audio_list=" + this.dynamic_audio_list + ')';
        }

        /* compiled from: PlayRequestJsonBuilder.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$DynamicVideo$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$DynamicVideo;", "uniplayer_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<DynamicVideo> serializer() {
                return PlayRequestJsonBuilder$DynamicVideo$$serializer.INSTANCE;
            }
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ DynamicVideo(int i, String str, List list, List list2, SerializationConstructorMarker serializationConstructorMarker) {
            if (7 != (i & 7)) {
                PluginExceptionsKt.throwMissingFieldException(i, 7, PlayRequestJsonBuilder$DynamicVideo$$serializer.INSTANCE.getDescriptor());
            }
            this.dynamic_type = str;
            this.dynamic_video_list = list;
            this.dynamic_audio_list = list2;
        }

        public DynamicVideo(String str, List<VideoDetailItem> list, List<VideoDetailItem> list2) {
            Intrinsics.checkNotNullParameter(str, "dynamic_type");
            Intrinsics.checkNotNullParameter(list, "dynamic_video_list");
            Intrinsics.checkNotNullParameter(list2, "dynamic_audio_list");
            this.dynamic_type = str;
            this.dynamic_video_list = list;
            this.dynamic_audio_list = list2;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$uniplayer_release(DynamicVideo self, CompositeEncoder output, SerialDescriptor serialDesc) {
            SerializationStrategy[] serializationStrategyArr = $childSerializers;
            output.encodeStringElement(serialDesc, 0, self.dynamic_type);
            output.encodeSerializableElement(serialDesc, 1, serializationStrategyArr[1], self.dynamic_video_list);
            output.encodeSerializableElement(serialDesc, 2, serializationStrategyArr[2], self.dynamic_audio_list);
        }

        public final String getDynamic_type() {
            return this.dynamic_type;
        }

        public final List<VideoDetailItem> getDynamic_video_list() {
            return this.dynamic_video_list;
        }

        public final List<VideoDetailItem> getDynamic_audio_list() {
            return this.dynamic_audio_list;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PlayRequestJsonBuilder.kt */
    @Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0083\b\u0018\u0000 >2\u00020\u0001:\u0002=>Bm\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0002\u0010\u0016BW\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012¢\u0006\u0002\u0010\u0017J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\t\u0010(\u001a\u00020\u0007HÆ\u0003J\t\u0010)\u001a\u00020\u0005HÆ\u0003J\t\u0010*\u001a\u00020\nHÆ\u0003J\t\u0010+\u001a\u00020\fHÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u0011\u0010.\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012HÆ\u0003Je\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012HÆ\u0001J\u0013\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00103\u001a\u00020\u0003HÖ\u0001J\t\u00104\u001a\u00020\u0005HÖ\u0001J&\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u00002\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;HÁ\u0001¢\u0006\u0002\b<R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001dR\u0019\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&¨\u0006?"}, d2 = {"Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$UniVideoModelV3;", "", "seen1", "", "video_id", "", "video_duration", "", "media_type", "uni_vm_ext", "Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$UniVmExt;", "volume", "Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$Volume;", "big_thumbs", "Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$ThumbInfo;", "dynamic_video", "Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$DynamicVideo;", "video_list", "", "Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$VideoDetailItem;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;DLjava/lang/String;Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$UniVmExt;Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$Volume;Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$ThumbInfo;Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$DynamicVideo;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;DLjava/lang/String;Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$UniVmExt;Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$Volume;Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$ThumbInfo;Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$DynamicVideo;Ljava/util/List;)V", "getBig_thumbs", "()Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$ThumbInfo;", "getDynamic_video", "()Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$DynamicVideo;", "getMedia_type", "()Ljava/lang/String;", "getUni_vm_ext", "()Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$UniVmExt;", "getVideo_duration", "()D", "getVideo_id", "getVideo_list", "()Ljava/util/List;", "getVolume", "()Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$Volume;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$uniplayer_release", "$serializer", "Companion", "uniplayer_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
    @Serializable
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final /* data */ class UniVideoModelV3 {
        private final ThumbInfo big_thumbs;
        private final DynamicVideo dynamic_video;
        private final String media_type;
        private final UniVmExt uni_vm_ext;
        private final double video_duration;
        private final String video_id;
        private final List<VideoDetailItem> video_list;
        private final Volume volume;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final KSerializer<Object>[] $childSerializers = {null, null, null, null, null, null, null, new ArrayListSerializer(PlayRequestJsonBuilder$VideoDetailItem$$serializer.INSTANCE)};

        /* renamed from: component1, reason: from getter */
        public final String getVideo_id() {
            return this.video_id;
        }

        /* renamed from: component2, reason: from getter */
        public final double getVideo_duration() {
            return this.video_duration;
        }

        /* renamed from: component3, reason: from getter */
        public final String getMedia_type() {
            return this.media_type;
        }

        /* renamed from: component4, reason: from getter */
        public final UniVmExt getUni_vm_ext() {
            return this.uni_vm_ext;
        }

        /* renamed from: component5, reason: from getter */
        public final Volume getVolume() {
            return this.volume;
        }

        /* renamed from: component6, reason: from getter */
        public final ThumbInfo getBig_thumbs() {
            return this.big_thumbs;
        }

        /* renamed from: component7, reason: from getter */
        public final DynamicVideo getDynamic_video() {
            return this.dynamic_video;
        }

        public final List<VideoDetailItem> component8() {
            return this.video_list;
        }

        public final UniVideoModelV3 copy(String video_id, double video_duration, String media_type, UniVmExt uni_vm_ext, Volume volume, ThumbInfo big_thumbs, DynamicVideo dynamic_video, List<VideoDetailItem> video_list) {
            Intrinsics.checkNotNullParameter(video_id, "video_id");
            Intrinsics.checkNotNullParameter(media_type, "media_type");
            Intrinsics.checkNotNullParameter(uni_vm_ext, "uni_vm_ext");
            Intrinsics.checkNotNullParameter(volume, "volume");
            return new UniVideoModelV3(video_id, video_duration, media_type, uni_vm_ext, volume, big_thumbs, dynamic_video, video_list);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UniVideoModelV3)) {
                return false;
            }
            UniVideoModelV3 uniVideoModelV3 = (UniVideoModelV3) other;
            return Intrinsics.areEqual(this.video_id, uniVideoModelV3.video_id) && Double.compare(this.video_duration, uniVideoModelV3.video_duration) == 0 && Intrinsics.areEqual(this.media_type, uniVideoModelV3.media_type) && Intrinsics.areEqual(this.uni_vm_ext, uniVideoModelV3.uni_vm_ext) && Intrinsics.areEqual(this.volume, uniVideoModelV3.volume) && Intrinsics.areEqual(this.big_thumbs, uniVideoModelV3.big_thumbs) && Intrinsics.areEqual(this.dynamic_video, uniVideoModelV3.dynamic_video) && Intrinsics.areEqual(this.video_list, uniVideoModelV3.video_list);
        }

        public int hashCode() {
            int hashCode = ((((((((this.video_id.hashCode() * 31) + Double.hashCode(this.video_duration)) * 31) + this.media_type.hashCode()) * 31) + this.uni_vm_ext.hashCode()) * 31) + this.volume.hashCode()) * 31;
            ThumbInfo thumbInfo = this.big_thumbs;
            int hashCode2 = (hashCode + (thumbInfo == null ? 0 : thumbInfo.hashCode())) * 31;
            DynamicVideo dynamicVideo = this.dynamic_video;
            int hashCode3 = (hashCode2 + (dynamicVideo == null ? 0 : dynamicVideo.hashCode())) * 31;
            List<VideoDetailItem> list = this.video_list;
            return hashCode3 + (list != null ? list.hashCode() : 0);
        }

        public String toString() {
            return "UniVideoModelV3(video_id=" + this.video_id + ", video_duration=" + this.video_duration + ", media_type=" + this.media_type + ", uni_vm_ext=" + this.uni_vm_ext + ", volume=" + this.volume + ", big_thumbs=" + this.big_thumbs + ", dynamic_video=" + this.dynamic_video + ", video_list=" + this.video_list + ')';
        }

        /* compiled from: PlayRequestJsonBuilder.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$UniVideoModelV3$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$UniVideoModelV3;", "uniplayer_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<UniVideoModelV3> serializer() {
                return PlayRequestJsonBuilder$UniVideoModelV3$$serializer.INSTANCE;
            }
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ UniVideoModelV3(int i, String str, double d, String str2, UniVmExt uniVmExt, Volume volume, ThumbInfo thumbInfo, DynamicVideo dynamicVideo, List list, SerializationConstructorMarker serializationConstructorMarker) {
            if (31 != (i & 31)) {
                PluginExceptionsKt.throwMissingFieldException(i, 31, PlayRequestJsonBuilder$UniVideoModelV3$$serializer.INSTANCE.getDescriptor());
            }
            this.video_id = str;
            this.video_duration = d;
            this.media_type = str2;
            this.uni_vm_ext = uniVmExt;
            this.volume = volume;
            if ((i & 32) == 0) {
                this.big_thumbs = null;
            } else {
                this.big_thumbs = thumbInfo;
            }
            if ((i & 64) == 0) {
                this.dynamic_video = null;
            } else {
                this.dynamic_video = dynamicVideo;
            }
            if ((i & 128) == 0) {
                this.video_list = null;
            } else {
                this.video_list = list;
            }
        }

        public UniVideoModelV3(String str, double d, String str2, UniVmExt uniVmExt, Volume volume, ThumbInfo thumbInfo, DynamicVideo dynamicVideo, List<VideoDetailItem> list) {
            Intrinsics.checkNotNullParameter(str, "video_id");
            Intrinsics.checkNotNullParameter(str2, "media_type");
            Intrinsics.checkNotNullParameter(uniVmExt, "uni_vm_ext");
            Intrinsics.checkNotNullParameter(volume, "volume");
            this.video_id = str;
            this.video_duration = d;
            this.media_type = str2;
            this.uni_vm_ext = uniVmExt;
            this.volume = volume;
            this.big_thumbs = thumbInfo;
            this.dynamic_video = dynamicVideo;
            this.video_list = list;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$uniplayer_release(UniVideoModelV3 self, CompositeEncoder output, SerialDescriptor serialDesc) {
            SerializationStrategy[] serializationStrategyArr = $childSerializers;
            output.encodeStringElement(serialDesc, 0, self.video_id);
            output.encodeDoubleElement(serialDesc, 1, self.video_duration);
            output.encodeStringElement(serialDesc, 2, self.media_type);
            output.encodeSerializableElement(serialDesc, 3, PlayRequestJsonBuilder$UniVmExt$$serializer.INSTANCE, self.uni_vm_ext);
            output.encodeSerializableElement(serialDesc, 4, PlayRequestJsonBuilder$Volume$$serializer.INSTANCE, self.volume);
            if (output.shouldEncodeElementDefault(serialDesc, 5) || self.big_thumbs != null) {
                output.encodeNullableSerializableElement(serialDesc, 5, PlayRequestJsonBuilder$ThumbInfo$$serializer.INSTANCE, self.big_thumbs);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 6) || self.dynamic_video != null) {
                output.encodeNullableSerializableElement(serialDesc, 6, PlayRequestJsonBuilder$DynamicVideo$$serializer.INSTANCE, self.dynamic_video);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 7) || self.video_list != null) {
                output.encodeNullableSerializableElement(serialDesc, 7, serializationStrategyArr[7], self.video_list);
            }
        }

        public /* synthetic */ UniVideoModelV3(String str, double d, String str2, UniVmExt uniVmExt, Volume volume, ThumbInfo thumbInfo, DynamicVideo dynamicVideo, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, d, str2, uniVmExt, volume, (i & 32) != 0 ? null : thumbInfo, (i & 64) != 0 ? null : dynamicVideo, (i & 128) != 0 ? null : list);
        }

        public final String getVideo_id() {
            return this.video_id;
        }

        public final double getVideo_duration() {
            return this.video_duration;
        }

        public final String getMedia_type() {
            return this.media_type;
        }

        public final UniVmExt getUni_vm_ext() {
            return this.uni_vm_ext;
        }

        public final Volume getVolume() {
            return this.volume;
        }

        public final ThumbInfo getBig_thumbs() {
            return this.big_thumbs;
        }

        public final DynamicVideo getDynamic_video() {
            return this.dynamic_video;
        }

        public final List<VideoDetailItem> getVideo_list() {
            return this.video_list;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PlayRequestJsonBuilder.kt */
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0083\b\u0018\u0000 '2\u00020\u0001:\u0002&'B7\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fB)\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\rJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\tHÆ\u0003J-\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J&\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$HÁ\u0001¢\u0006\u0002\b%R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006("}, d2 = {"Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$SubInfoEntity;", "", "seen1", "", "base_range_info", "Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$SubRangeInfo;", "check_info", "Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$SubCheckInfo;", "encrypt_info", "Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$SubEncryptInfo;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$SubRangeInfo;Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$SubCheckInfo;Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$SubEncryptInfo;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$SubRangeInfo;Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$SubCheckInfo;Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$SubEncryptInfo;)V", "getBase_range_info", "()Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$SubRangeInfo;", "getCheck_info", "()Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$SubCheckInfo;", "getEncrypt_info", "()Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$SubEncryptInfo;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$uniplayer_release", "$serializer", "Companion", "uniplayer_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
    @Serializable
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final /* data */ class SubInfoEntity {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final SubRangeInfo base_range_info;
        private final SubCheckInfo check_info;
        private final SubEncryptInfo encrypt_info;

        public SubInfoEntity() {
            this((SubRangeInfo) null, (SubCheckInfo) null, (SubEncryptInfo) null, 7, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ SubInfoEntity copy$default(SubInfoEntity subInfoEntity, SubRangeInfo subRangeInfo, SubCheckInfo subCheckInfo, SubEncryptInfo subEncryptInfo, int i, Object obj) {
            if ((i & 1) != 0) {
                subRangeInfo = subInfoEntity.base_range_info;
            }
            if ((i & 2) != 0) {
                subCheckInfo = subInfoEntity.check_info;
            }
            if ((i & 4) != 0) {
                subEncryptInfo = subInfoEntity.encrypt_info;
            }
            return subInfoEntity.copy(subRangeInfo, subCheckInfo, subEncryptInfo);
        }

        /* renamed from: component1, reason: from getter */
        public final SubRangeInfo getBase_range_info() {
            return this.base_range_info;
        }

        /* renamed from: component2, reason: from getter */
        public final SubCheckInfo getCheck_info() {
            return this.check_info;
        }

        /* renamed from: component3, reason: from getter */
        public final SubEncryptInfo getEncrypt_info() {
            return this.encrypt_info;
        }

        public final SubInfoEntity copy(SubRangeInfo base_range_info, SubCheckInfo check_info, SubEncryptInfo encrypt_info) {
            return new SubInfoEntity(base_range_info, check_info, encrypt_info);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SubInfoEntity)) {
                return false;
            }
            SubInfoEntity subInfoEntity = (SubInfoEntity) other;
            return Intrinsics.areEqual(this.base_range_info, subInfoEntity.base_range_info) && Intrinsics.areEqual(this.check_info, subInfoEntity.check_info) && Intrinsics.areEqual(this.encrypt_info, subInfoEntity.encrypt_info);
        }

        public int hashCode() {
            SubRangeInfo subRangeInfo = this.base_range_info;
            int hashCode = (subRangeInfo == null ? 0 : subRangeInfo.hashCode()) * 31;
            SubCheckInfo subCheckInfo = this.check_info;
            int hashCode2 = (hashCode + (subCheckInfo == null ? 0 : subCheckInfo.hashCode())) * 31;
            SubEncryptInfo subEncryptInfo = this.encrypt_info;
            return hashCode2 + (subEncryptInfo != null ? subEncryptInfo.hashCode() : 0);
        }

        public String toString() {
            return "SubInfoEntity(base_range_info=" + this.base_range_info + ", check_info=" + this.check_info + ", encrypt_info=" + this.encrypt_info + ')';
        }

        /* compiled from: PlayRequestJsonBuilder.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$SubInfoEntity$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$SubInfoEntity;", "uniplayer_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<SubInfoEntity> serializer() {
                return PlayRequestJsonBuilder$SubInfoEntity$$serializer.INSTANCE;
            }
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ SubInfoEntity(int i, SubRangeInfo subRangeInfo, SubCheckInfo subCheckInfo, SubEncryptInfo subEncryptInfo, SerializationConstructorMarker serializationConstructorMarker) {
            if ((i & 0) != 0) {
                PluginExceptionsKt.throwMissingFieldException(i, 0, PlayRequestJsonBuilder$SubInfoEntity$$serializer.INSTANCE.getDescriptor());
            }
            if ((i & 1) == 0) {
                this.base_range_info = null;
            } else {
                this.base_range_info = subRangeInfo;
            }
            if ((i & 2) == 0) {
                this.check_info = null;
            } else {
                this.check_info = subCheckInfo;
            }
            if ((i & 4) == 0) {
                this.encrypt_info = null;
            } else {
                this.encrypt_info = subEncryptInfo;
            }
        }

        public SubInfoEntity(SubRangeInfo subRangeInfo, SubCheckInfo subCheckInfo, SubEncryptInfo subEncryptInfo) {
            this.base_range_info = subRangeInfo;
            this.check_info = subCheckInfo;
            this.encrypt_info = subEncryptInfo;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$uniplayer_release(SubInfoEntity self, CompositeEncoder output, SerialDescriptor serialDesc) {
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.base_range_info != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, PlayRequestJsonBuilder$SubRangeInfo$$serializer.INSTANCE, self.base_range_info);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.check_info != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, PlayRequestJsonBuilder$SubCheckInfo$$serializer.INSTANCE, self.check_info);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.encrypt_info != null) {
                output.encodeNullableSerializableElement(serialDesc, 2, PlayRequestJsonBuilder$SubEncryptInfo$$serializer.INSTANCE, self.encrypt_info);
            }
        }

        public /* synthetic */ SubInfoEntity(SubRangeInfo subRangeInfo, SubCheckInfo subCheckInfo, SubEncryptInfo subEncryptInfo, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : subRangeInfo, (i & 2) != 0 ? null : subCheckInfo, (i & 4) != 0 ? null : subEncryptInfo);
        }

        public final SubRangeInfo getBase_range_info() {
            return this.base_range_info;
        }

        public final SubCheckInfo getCheck_info() {
            return this.check_info;
        }

        public final SubEncryptInfo getEncrypt_info() {
            return this.encrypt_info;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PlayRequestJsonBuilder.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0083\b\u0018\u0000 \"2\u00020\u0001:\u0002!\"B7\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB)\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J&\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fHÁ\u0001¢\u0006\u0002\b R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006#"}, d2 = {"Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$SubRangeInfo;", "", "seen1", "", "init_range", "", "index_range", "first_moof_range", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getFirst_moof_range", "()Ljava/lang/String;", "getIndex_range", "getInit_range", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$uniplayer_release", "$serializer", "Companion", "uniplayer_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
    @Serializable
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final /* data */ class SubRangeInfo {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String first_moof_range;
        private final String index_range;
        private final String init_range;

        public SubRangeInfo() {
            this((String) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ SubRangeInfo copy$default(SubRangeInfo subRangeInfo, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = subRangeInfo.init_range;
            }
            if ((i & 2) != 0) {
                str2 = subRangeInfo.index_range;
            }
            if ((i & 4) != 0) {
                str3 = subRangeInfo.first_moof_range;
            }
            return subRangeInfo.copy(str, str2, str3);
        }

        /* renamed from: component1, reason: from getter */
        public final String getInit_range() {
            return this.init_range;
        }

        /* renamed from: component2, reason: from getter */
        public final String getIndex_range() {
            return this.index_range;
        }

        /* renamed from: component3, reason: from getter */
        public final String getFirst_moof_range() {
            return this.first_moof_range;
        }

        public final SubRangeInfo copy(String init_range, String index_range, String first_moof_range) {
            return new SubRangeInfo(init_range, index_range, first_moof_range);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SubRangeInfo)) {
                return false;
            }
            SubRangeInfo subRangeInfo = (SubRangeInfo) other;
            return Intrinsics.areEqual(this.init_range, subRangeInfo.init_range) && Intrinsics.areEqual(this.index_range, subRangeInfo.index_range) && Intrinsics.areEqual(this.first_moof_range, subRangeInfo.first_moof_range);
        }

        public int hashCode() {
            String str = this.init_range;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.index_range;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.first_moof_range;
            return hashCode2 + (str3 != null ? str3.hashCode() : 0);
        }

        public String toString() {
            return "SubRangeInfo(init_range=" + this.init_range + ", index_range=" + this.index_range + ", first_moof_range=" + this.first_moof_range + ')';
        }

        /* compiled from: PlayRequestJsonBuilder.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$SubRangeInfo$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$SubRangeInfo;", "uniplayer_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<SubRangeInfo> serializer() {
                return PlayRequestJsonBuilder$SubRangeInfo$$serializer.INSTANCE;
            }
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ SubRangeInfo(int i, String str, String str2, String str3, SerializationConstructorMarker serializationConstructorMarker) {
            if ((i & 0) != 0) {
                PluginExceptionsKt.throwMissingFieldException(i, 0, PlayRequestJsonBuilder$SubRangeInfo$$serializer.INSTANCE.getDescriptor());
            }
            if ((i & 1) == 0) {
                this.init_range = null;
            } else {
                this.init_range = str;
            }
            if ((i & 2) == 0) {
                this.index_range = null;
            } else {
                this.index_range = str2;
            }
            if ((i & 4) == 0) {
                this.first_moof_range = null;
            } else {
                this.first_moof_range = str3;
            }
        }

        public SubRangeInfo(String str, String str2, String str3) {
            this.init_range = str;
            this.index_range = str2;
            this.first_moof_range = str3;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$uniplayer_release(SubRangeInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.init_range != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.init_range);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.index_range != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.index_range);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.first_moof_range != null) {
                output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.first_moof_range);
            }
        }

        public /* synthetic */ SubRangeInfo(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
        }

        public final String getInit_range() {
            return this.init_range;
        }

        public final String getIndex_range() {
            return this.index_range;
        }

        public final String getFirst_moof_range() {
            return this.first_moof_range;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PlayRequestJsonBuilder.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0083\b\u0018\u0000 \u001c2\u00020\u0001:\u0002\u001b\u001cB#\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB\u0011\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\tJ\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0015\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J&\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019HÁ\u0001¢\u0006\u0002\b\u001aR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$SubCheckInfo;", "", "seen1", "", "check_info", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;)V", "getCheck_info", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$uniplayer_release", "$serializer", "Companion", "uniplayer_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
    @Serializable
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final /* data */ class SubCheckInfo {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String check_info;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public SubCheckInfo() {
            this(r0, 1, (DefaultConstructorMarker) r0);
            String str = null;
        }

        public static /* synthetic */ SubCheckInfo copy$default(SubCheckInfo subCheckInfo, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = subCheckInfo.check_info;
            }
            return subCheckInfo.copy(str);
        }

        /* renamed from: component1, reason: from getter */
        public final String getCheck_info() {
            return this.check_info;
        }

        public final SubCheckInfo copy(String check_info) {
            return new SubCheckInfo(check_info);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof SubCheckInfo) && Intrinsics.areEqual(this.check_info, ((SubCheckInfo) other).check_info);
        }

        public int hashCode() {
            String str = this.check_info;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            return "SubCheckInfo(check_info=" + this.check_info + ')';
        }

        /* compiled from: PlayRequestJsonBuilder.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$SubCheckInfo$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$SubCheckInfo;", "uniplayer_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<SubCheckInfo> serializer() {
                return PlayRequestJsonBuilder$SubCheckInfo$$serializer.INSTANCE;
            }
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ SubCheckInfo(int i, String str, SerializationConstructorMarker serializationConstructorMarker) {
            if ((i & 0) != 0) {
                PluginExceptionsKt.throwMissingFieldException(i, 0, PlayRequestJsonBuilder$SubCheckInfo$$serializer.INSTANCE.getDescriptor());
            }
            if ((i & 1) == 0) {
                this.check_info = null;
            } else {
                this.check_info = str;
            }
        }

        public SubCheckInfo(String str) {
            this.check_info = str;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$uniplayer_release(SubCheckInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
            boolean z = true;
            if (!output.shouldEncodeElementDefault(serialDesc, 0) && self.check_info == null) {
                z = false;
            }
            if (z) {
                output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.check_info);
            }
        }

        public /* synthetic */ SubCheckInfo(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str);
        }

        public final String getCheck_info() {
            return this.check_info;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PlayRequestJsonBuilder.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0083\b\u0018\u0000 \u001f2\u00020\u0001:\u0002\u001e\u001fB-\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tB\u001d\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\nJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J&\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cHÁ\u0001¢\u0006\u0002\b\u001dR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006 "}, d2 = {"Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$SubEncryptInfo;", "", "seen1", "", "kid", "", "spade_a", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;)V", "getKid", "()Ljava/lang/String;", "getSpade_a", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$uniplayer_release", "$serializer", "Companion", "uniplayer_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
    @Serializable
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final /* data */ class SubEncryptInfo {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String kid;
        private final String spade_a;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public SubEncryptInfo() {
            this(r0, r0, 3, (DefaultConstructorMarker) r0);
            String str = null;
        }

        public static /* synthetic */ SubEncryptInfo copy$default(SubEncryptInfo subEncryptInfo, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = subEncryptInfo.kid;
            }
            if ((i & 2) != 0) {
                str2 = subEncryptInfo.spade_a;
            }
            return subEncryptInfo.copy(str, str2);
        }

        /* renamed from: component1, reason: from getter */
        public final String getKid() {
            return this.kid;
        }

        /* renamed from: component2, reason: from getter */
        public final String getSpade_a() {
            return this.spade_a;
        }

        public final SubEncryptInfo copy(String kid, String spade_a) {
            return new SubEncryptInfo(kid, spade_a);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SubEncryptInfo)) {
                return false;
            }
            SubEncryptInfo subEncryptInfo = (SubEncryptInfo) other;
            return Intrinsics.areEqual(this.kid, subEncryptInfo.kid) && Intrinsics.areEqual(this.spade_a, subEncryptInfo.spade_a);
        }

        public int hashCode() {
            String str = this.kid;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.spade_a;
            return hashCode + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "SubEncryptInfo(kid=" + this.kid + ", spade_a=" + this.spade_a + ')';
        }

        /* compiled from: PlayRequestJsonBuilder.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$SubEncryptInfo$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$SubEncryptInfo;", "uniplayer_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<SubEncryptInfo> serializer() {
                return PlayRequestJsonBuilder$SubEncryptInfo$$serializer.INSTANCE;
            }
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ SubEncryptInfo(int i, String str, String str2, SerializationConstructorMarker serializationConstructorMarker) {
            if ((i & 0) != 0) {
                PluginExceptionsKt.throwMissingFieldException(i, 0, PlayRequestJsonBuilder$SubEncryptInfo$$serializer.INSTANCE.getDescriptor());
            }
            if ((i & 1) == 0) {
                this.kid = null;
            } else {
                this.kid = str;
            }
            if ((i & 2) == 0) {
                this.spade_a = null;
            } else {
                this.spade_a = str2;
            }
        }

        public SubEncryptInfo(String str, String str2) {
            this.kid = str;
            this.spade_a = str2;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$uniplayer_release(SubEncryptInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.kid != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.kid);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.spade_a != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.spade_a);
            }
        }

        public /* synthetic */ SubEncryptInfo(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
        }

        public final String getKid() {
            return this.kid;
        }

        public final String getSpade_a() {
            return this.spade_a;
        }
    }

    public final String build(IPlayRequest playRequest) {
        ThumbInfo thumbInfo;
        List listOf;
        UniVideoModelV3 uniVideoModelV3;
        Intrinsics.checkNotNullParameter(playRequest, "playRequest");
        try {
            IPlayUrlModel playAddr = playRequest.getPlayAddr();
            String videoId = playAddr.getVideoId();
            if (videoId == null) {
                videoId = "";
            }
            if (!(videoId.length() > 0)) {
                videoId = playRequest.getSourceID();
            }
            String str = videoId;
            double mediaDuration = playAddr.getMediaDuration() / 1000.0d;
            String format = playAddr.getFormat();
            if (format == null) {
                format = FORMAT_MP4;
            }
            String str2 = Intrinsics.areEqual(format, FORMAT_MP3) ? "audio" : "video";
            UniVmExt uniVmExt = new UniVmExt(playRequest.getSourceID(), playRequest.getLogLabel(), playAddr.getCdnUrlExpiredTS(), playRequest.getSourceTye().getValue());
            Volume volume = new Volume(playAddr.getAELoudness(), playAddr.getAEPeak());
            IThumbInfoModel thumbInfo2 = playRequest.getThumbInfo();
            if (thumbInfo2 != null) {
                int imgNum = thumbInfo2.getImgNum();
                String uri = thumbInfo2.getUri();
                String imgUrl = thumbInfo2.getImgUrl();
                int imgXSize = thumbInfo2.getImgXSize();
                int imgYSize = thumbInfo2.getImgYSize();
                int imgXLen = thumbInfo2.getImgXLen();
                int imgYLen = thumbInfo2.getImgYLen();
                double duration = thumbInfo2.getDuration();
                int interval = thumbInfo2.getInterval();
                String fext = thumbInfo2.getFext();
                thumbInfo = new ThumbInfo(imgNum, uri, imgUrl, imgXSize, imgYSize, imgXLen, imgYLen, duration, interval, fext == null ? "" : fext, thumbInfo2.getImgUrls());
            } else {
                thumbInfo = null;
            }
            List<IBitrate> bitrates = playAddr.getBitrates();
            if (bitrates == null) {
                bitrates = CollectionsKt.emptyList();
            }
            if (Intrinsics.areEqual(format, FORMAT_DASH) && (!bitrates.isEmpty())) {
                List<IBitrate> list = bitrates;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(INSTANCE.buildVideoItemFromBitrate(playRequest, (IBitrate) it.next()));
                }
                ArrayList arrayList2 = arrayList;
                List<IAudioBitrate> audioBitrates = playAddr.getAudioBitrates();
                if (audioBitrates == null) {
                    audioBitrates = CollectionsKt.emptyList();
                }
                List<IAudioBitrate> list2 = audioBitrates;
                ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                Iterator<T> it2 = list2.iterator();
                while (it2.hasNext()) {
                    arrayList3.add(INSTANCE.buildAudioItemFromBitrate((IAudioBitrate) it2.next()));
                }
                uniVideoModelV3 = new UniVideoModelV3(str, mediaDuration, str2, uniVmExt, volume, thumbInfo, new DynamicVideo(DYNAMIC_TYPE_SEGMENT_BASE, arrayList2, arrayList3), null);
            } else {
                if (!bitrates.isEmpty()) {
                    List<IBitrate> list3 = bitrates;
                    ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
                    Iterator<T> it3 = list3.iterator();
                    while (it3.hasNext()) {
                        arrayList4.add(INSTANCE.buildVideoItemFromBitrate(playRequest, (IBitrate) it3.next()));
                    }
                    listOf = arrayList4;
                } else {
                    listOf = CollectionsKt.listOf(buildFallbackVideoItem(playRequest));
                }
                uniVideoModelV3 = new UniVideoModelV3(str, mediaDuration, str2, uniVmExt, volume, thumbInfo, null, listOf);
            }
            StringFormat stringFormat = json;
            stringFormat.getSerializersModule();
            return stringFormat.encodeToString(UniVideoModelV3.INSTANCE.serializer(), uniVideoModelV3);
        } catch (Exception unused) {
            return "";
        }
    }

    private final VideoDetailItem buildVideoItemFromBitrate(IPlayRequest playRequest, IBitrate bitrate) {
        IPlayUrlModel playAddr = playRequest.getPlayAddr();
        IUrlModel playAddr2 = bitrate.getPlayAddr();
        List<String> urlList = playAddr2 != null ? playAddr2.getUrlList() : null;
        if (urlList == null) {
            urlList = CollectionsKt.emptyList();
        }
        List<String> list = urlList;
        Triple<RangeInfo, CheckInfo, EncryptInfo> parseSubInfo = parseSubInfo(bitrate.getSubInfo());
        return new VideoDetailItem(list, (String) null, Integer.valueOf(bitrate.getQualityType()), extractVideoMeta(playRequest, bitrate), (Meta) null, (RangeInfo) parseSubInfo.component1(), (CheckInfo) parseSubInfo.component2(), (EncryptInfo) parseSubInfo.component3(), extractUniVideoInfoExt(playAddr, bitrate), 18, (DefaultConstructorMarker) null);
    }

    private final VideoDetailItem buildFallbackVideoItem(IPlayRequest playRequest) {
        IPlayUrlModel playAddr = playRequest.getPlayAddr();
        return new VideoDetailItem(playAddr.getUrlList(), (String) null, (Integer) null, extractVideoMeta(playRequest, null), (Meta) null, (RangeInfo) null, (CheckInfo) null, (EncryptInfo) null, extractUniVideoInfoExt(playAddr, null), 246, (DefaultConstructorMarker) null);
    }

    private final VideoDetailItem buildAudioItemFromBitrate(IAudioBitrate audioBitrate) {
        IAudioBitrateMeta audioBitrateMeta = audioBitrate.getAudioBitrateMeta();
        List<String> urlList = audioBitrateMeta != null ? audioBitrateMeta.getUrlList() : null;
        if (urlList == null) {
            urlList = CollectionsKt.emptyList();
        }
        List<String> list = urlList;
        Triple<RangeInfo, CheckInfo, EncryptInfo> parseSubInfo = parseSubInfo(audioBitrateMeta != null ? audioBitrateMeta.getSubInfo() : null);
        return new VideoDetailItem(list, (String) null, (Integer) null, (Meta) null, extractAudioMeta(audioBitrate, audioBitrateMeta), (RangeInfo) parseSubInfo.component1(), (CheckInfo) parseSubInfo.component2(), (EncryptInfo) parseSubInfo.component3(), extractUniAudioInfoExt(audioBitrate), 14, (DefaultConstructorMarker) null);
    }

    private final Meta extractVideoMeta(IPlayRequest playRequest, IBitrate bitrate) {
        Integer intOrNull;
        String fileHash;
        IPlayUrlModel playAddr = playRequest.getPlayAddr();
        if (bitrate != null) {
            IUrlModel playAddr2 = bitrate.getPlayAddr();
            String definition = bitrate.getDefinition();
            String str = definition == null ? "" : definition;
            String quality = bitrate.getQuality();
            String str2 = quality == null ? "" : quality;
            String bitrateFormat = bitrate.getBitrateFormat();
            int width = playAddr2 != null ? playAddr2.getWidth() : 0;
            int height = playAddr2 != null ? playAddr2.getHeight() : 0;
            int bitrate2 = bitrate.getBitrate();
            String codecType = getCodecType(bitrate.isByteVC1());
            long dataSize = playAddr2 != null ? playAddr2.getDataSize() : 0L;
            String fileId = bitrate.getFileId();
            String str3 = fileId == null ? "" : fileId;
            if (playAddr2 != null) {
                playAddr2.getWidth();
            }
            return new Meta(str, str2, bitrateFormat, "", width, height, bitrate2, codecType, dataSize, str3, bitrate.getFps(), (playAddr2 == null || (fileHash = playAddr2.getFileHash()) == null) ? "" : fileHash, bitrate.getRealBitrate());
        }
        String urlKey = playAddr.getUrlKey();
        if (urlKey == null) {
            urlKey = "";
        }
        String format = playAddr.getFormat();
        if (format == null) {
            format = FORMAT_MP4;
        }
        String str4 = Intrinsics.areEqual(format, FORMAT_MP3) ? FORMAT_MP3 : FORMAT_MP4;
        String extractBitrate = extractBitrate(urlKey);
        if (extractBitrate != null && (intOrNull = StringsKt.toIntOrNull(extractBitrate)) != null) {
            r2 = intOrNull.intValue();
        }
        int i = r2;
        String extractResolution = extractResolution(urlKey);
        int width2 = playAddr.getWidth();
        int height2 = playAddr.getHeight();
        String codecType2 = getCodecType(playAddr.getCodecType());
        long dataSize2 = playAddr.getDataSize();
        String fileHash2 = playAddr.getFileHash();
        return new Meta(extractResolution, "", str4, "", width2, height2, i, codecType2, dataSize2, "", 0, fileHash2 == null ? "" : fileHash2, 0);
    }

    private final Meta extractAudioMeta(IAudioBitrate audioBitrate, IAudioBitrateMeta meta) {
        String str;
        String str2;
        String str3;
        if (meta == null || (str = meta.getQuality()) == null) {
            str = "";
        }
        String bitrateFormat = audioBitrate.getBitrateFormat();
        String bitrateFormat2 = audioBitrate.getBitrateFormat();
        int bitrate = audioBitrate.getBitrate();
        if (meta == null || (str2 = meta.getCodecType()) == null) {
            str2 = "";
        }
        long dataSize = meta != null ? meta.getDataSize() : 0L;
        String fileId = audioBitrate.getFileId();
        if (fileId == null) {
            fileId = "";
        }
        int fps = meta != null ? meta.getFps() : 0;
        if (meta == null || (str3 = meta.getFileHash()) == null) {
            str3 = "";
        }
        return new Meta("", str, bitrateFormat, bitrateFormat2, 0, 0, bitrate, str2, dataSize, fileId, fps, str3, audioBitrate.getRealBitrate());
    }

    private final UniVideoInfoExt extractUniVideoInfoExt(IPlayUrlModel playAddr, IBitrate bitrate) {
        UniVideoInfoExt uniVideoInfoExt;
        String urlKey;
        String decryptionKeyNotEncoded;
        String decryptionKey;
        if (bitrate != null) {
            IUrlModel playAddr2 = bitrate.getPlayAddr();
            boolean needSetToken = playAddr.getNeedSetToken();
            String str = (playAddr2 == null || (decryptionKey = playAddr2.getDecryptionKey()) == null) ? "" : decryptionKey;
            String str2 = (playAddr2 == null || (decryptionKeyNotEncoded = playAddr2.getDecryptionKeyNotEncoded()) == null) ? "" : decryptionKeyNotEncoded;
            String str3 = (playAddr2 == null || (urlKey = playAddr2.getUrlKey()) == null) ? "" : urlKey;
            String gearName = bitrate.getGearName();
            String str4 = gearName == null ? "" : gearName;
            String relatedAudioFileId = bitrate.getRelatedAudioFileId();
            uniVideoInfoExt = new UniVideoInfoExt(needSetToken, str, str2, str3, str4, relatedAudioFileId == null ? "" : relatedAudioFileId, (Integer) null, 64, (DefaultConstructorMarker) null);
        } else {
            boolean needSetToken2 = playAddr.getNeedSetToken();
            String decryptionKey2 = playAddr.getDecryptionKey();
            String str5 = decryptionKey2 == null ? "" : decryptionKey2;
            String decryptionKeyNotEncoded2 = playAddr.getDecryptionKeyNotEncoded();
            String str6 = decryptionKeyNotEncoded2 == null ? "" : decryptionKeyNotEncoded2;
            String urlKey2 = playAddr.getUrlKey();
            uniVideoInfoExt = new UniVideoInfoExt(needSetToken2, str5, str6, urlKey2 == null ? "" : urlKey2, (String) null, (String) null, (Integer) null, 112, (DefaultConstructorMarker) null);
        }
        return uniVideoInfoExt;
    }

    private final UniVideoInfoExt extractUniAudioInfoExt(IAudioBitrate audioBitrate) {
        return new UniVideoInfoExt(false, (String) null, (String) null, (String) null, (String) null, (String) null, Integer.valueOf(audioBitrate.getAudioQuality() != 0 ? audioBitrate.getAudioQuality() : audioBitrate.getQualityType()), 63, (DefaultConstructorMarker) null);
    }

    private final String getCodecType(Integer isByteVc1) {
        return (isByteVc1 != null && isByteVc1.intValue() == 0) ? "h264" : (isByteVc1 != null && isByteVc1.intValue() == 1) ? "bytevc1" : (isByteVc1 != null && isByteVc1.intValue() == 2) ? "bytevc2" : "h264";
    }

    private final String extractResolution(String url) {
        String str = "";
        for (String str2 : StringsKt.split$default(url, new char[]{'_'}, false, 0, 6, (Object) null)) {
            if (new Regex("\\d+p").matches(str2)) {
                str = str2;
            }
        }
        return str;
    }

    private final String extractBitrate(String url) {
        List split$default = StringsKt.split$default(url, new char[]{'_'}, false, 0, 6, (Object) null);
        if (split$default.size() <= 1) {
            return null;
        }
        String str = (String) CollectionsKt.last(split$default);
        if (StringsKt.toIntOrNull(str) != null) {
            return str;
        }
        return null;
    }

    private final Triple<RangeInfo, CheckInfo, EncryptInfo> parseSubInfo(String subInfoStr) {
        RangeInfo rangeInfo;
        CheckInfo checkInfo;
        EncryptInfo encryptInfo;
        String str = subInfoStr;
        if (str == null || StringsKt.isBlank(str)) {
            return new Triple<>((Object) null, (Object) null, (Object) null);
        }
        try {
            Json json2 = json;
            json2.getSerializersModule();
            SubInfoEntity subInfoEntity = (SubInfoEntity) json2.decodeFromString(SubInfoEntity.INSTANCE.serializer(), subInfoStr);
            SubRangeInfo base_range_info = subInfoEntity.getBase_range_info();
            String str2 = "";
            if (base_range_info != null) {
                String init_range = base_range_info.getInit_range();
                if (init_range == null) {
                    init_range = "";
                }
                String index_range = base_range_info.getIndex_range();
                if (index_range == null) {
                    index_range = "";
                }
                String first_moof_range = base_range_info.getFirst_moof_range();
                if (first_moof_range == null) {
                    first_moof_range = "";
                }
                rangeInfo = new RangeInfo(init_range, index_range, first_moof_range);
            } else {
                rangeInfo = null;
            }
            SubCheckInfo check_info = subInfoEntity.getCheck_info();
            if (check_info != null) {
                String check_info2 = check_info.getCheck_info();
                if (check_info2 == null) {
                    check_info2 = "";
                }
                checkInfo = new CheckInfo(check_info2);
            } else {
                checkInfo = null;
            }
            SubEncryptInfo encrypt_info = subInfoEntity.getEncrypt_info();
            if (encrypt_info != null) {
                String kid = encrypt_info.getKid();
                if (kid == null) {
                    kid = "";
                }
                String spade_a = encrypt_info.getSpade_a();
                if (spade_a != null) {
                    str2 = spade_a;
                }
                encryptInfo = new EncryptInfo(kid, str2);
            } else {
                encryptInfo = null;
            }
            return new Triple<>(rangeInfo, checkInfo, encryptInfo);
        } catch (Exception unused) {
            return new Triple<>((Object) null, (Object) null, (Object) null);
        }
    }
}
