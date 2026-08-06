package com.bytedance.trae.home.solo.setting.data;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: DeviceManagementRepository.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0083\b\u0018\u0000 !2\u00020\u0001:\u0002 !B\u0017\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006B+\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0005\u0010\u000bJ\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\u0011\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÇ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u0015\u001a\u00020\bH×\u0001J\t\u0010\u0016\u001a\u00020\u0017H×\u0001J%\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0001¢\u0006\u0002\b\u001fR\"\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\""}, d2 = {"Lcom/bytedance/trae/home/solo/setting/data/ListClisResponseData;", "", "clis", "", "Lcom/bytedance/trae/home/solo/setting/data/CliDto;", "<init>", "(Ljava/util/List;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getClis$annotations", "()V", "getClis", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$impl_mainlandRelease", "$serializer", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
@Serializable
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
final /* data */ class ListClisResponseData {
    private final List<CliDto> clis;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {new ArrayListSerializer(CliDto$$serializer.INSTANCE)};

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ListClisResponseData() {
        this(r0, 1, (DefaultConstructorMarker) r0);
        List list = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ListClisResponseData copy$default(ListClisResponseData listClisResponseData, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = listClisResponseData.clis;
        }
        return listClisResponseData.copy(list);
    }

    @SerialName("clis")
    public static /* synthetic */ void getClis$annotations() {
    }

    public final List<CliDto> component1() {
        return this.clis;
    }

    public final ListClisResponseData copy(List<CliDto> clis) {
        Intrinsics.checkNotNullParameter(clis, "clis");
        return new ListClisResponseData(clis);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ListClisResponseData) && Intrinsics.areEqual(this.clis, ((ListClisResponseData) other).clis);
    }

    public int hashCode() {
        return this.clis.hashCode();
    }

    public String toString() {
        return "ListClisResponseData(clis=" + this.clis + ')';
    }

    /* compiled from: DeviceManagementRepository.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0007¨\u0006\u0007"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/data/ListClisResponseData$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/bytedance/trae/home/solo/setting/data/ListClisResponseData;", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<ListClisResponseData> serializer() {
            return ListClisResponseData$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ ListClisResponseData(int i, List list, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 0) != 0) {
            PluginExceptionsKt.throwMissingFieldException(i, 0, ListClisResponseData$$serializer.INSTANCE.getDescriptor());
        }
        if ((i & 1) == 0) {
            this.clis = CollectionsKt.emptyList();
        } else {
            this.clis = list;
        }
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$impl_mainlandRelease(ListClisResponseData self, CompositeEncoder output, SerialDescriptor serialDesc) {
        SerializationStrategy[] serializationStrategyArr = $childSerializers;
        boolean z = true;
        if (!output.shouldEncodeElementDefault(serialDesc, 0) && Intrinsics.areEqual(self.clis, CollectionsKt.emptyList())) {
            z = false;
        }
        if (z) {
            output.encodeSerializableElement(serialDesc, 0, serializationStrategyArr[0], self.clis);
        }
    }

    public ListClisResponseData(List<CliDto> list) {
        Intrinsics.checkNotNullParameter(list, "clis");
        this.clis = list;
    }

    public /* synthetic */ ListClisResponseData(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final List<CliDto> getClis() {
        return this.clis;
    }
}
