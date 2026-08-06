package com.bytedance.android.sdk.bdticketguard;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TicketGuardApi.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0013B!\u0012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005¢\u0006\u0002\u0010\u0006J\u001d\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005HÆ\u0003J'\u0010\n\u001a\u00020\u00002\u001c\b\u0002\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R*\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/sdk/bdticketguard/ServerDataV2;", "Lcom/bytedance/android/sdk/bdticketguard/ServerData;", "itemArray", "Ljava/util/ArrayList;", "Lcom/bytedance/android/sdk/bdticketguard/ServerDataV2$ServerDataItem;", "Lkotlin/collections/ArrayList;", "(Ljava/util/ArrayList;)V", "getItemArray", "()Ljava/util/ArrayList;", "component1", "copy", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "", "toString", "", "ServerDataItem", "bd_ticket_guard_api_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes3.dex */
public final /* data */ class ServerDataV2 implements ServerData {

    @SerializedName(TicketGuardApiKt.SERVER_DATA_TICKETS)
    private final ArrayList<ServerDataItem> itemArray;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ServerDataV2 copy$default(ServerDataV2 serverDataV2, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            arrayList = serverDataV2.itemArray;
        }
        return serverDataV2.copy(arrayList);
    }

    public final ArrayList<ServerDataItem> component1() {
        return this.itemArray;
    }

    public final ServerDataV2 copy(ArrayList<ServerDataItem> itemArray) {
        return new ServerDataV2(itemArray);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof ServerDataV2) && Intrinsics.areEqual(this.itemArray, ((ServerDataV2) other).itemArray);
        }
        return true;
    }

    public int hashCode() {
        ArrayList<ServerDataItem> arrayList = this.itemArray;
        if (arrayList != null) {
            return arrayList.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "ServerDataV2(itemArray=" + this.itemArray + ")";
    }

    public ServerDataV2(ArrayList<ServerDataItem> arrayList) {
        this.itemArray = arrayList;
    }

    public final ArrayList<ServerDataItem> getItemArray() {
        return this.itemArray;
    }

    /* compiled from: TicketGuardApi.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J+\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/sdk/bdticketguard/ServerDataV2$ServerDataItem;", "", "ticket", "", "tsSign", "tsSignRee", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getTicket", "()Ljava/lang/String;", "getTsSign", "getTsSignRee", "component1", "component2", "component3", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "bd_ticket_guard_api_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: classes3.dex */
    public static final /* data */ class ServerDataItem {

        @SerializedName("ticket")
        private final String ticket;

        @SerializedName("ts_sign")
        private final String tsSign;

        @SerializedName("ts_sign_ree")
        private final String tsSignRee;

        public static /* synthetic */ ServerDataItem copy$default(ServerDataItem serverDataItem, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = serverDataItem.ticket;
            }
            if ((i & 2) != 0) {
                str2 = serverDataItem.tsSign;
            }
            if ((i & 4) != 0) {
                str3 = serverDataItem.tsSignRee;
            }
            return serverDataItem.copy(str, str2, str3);
        }

        /* renamed from: component1, reason: from getter */
        public final String getTicket() {
            return this.ticket;
        }

        /* renamed from: component2, reason: from getter */
        public final String getTsSign() {
            return this.tsSign;
        }

        /* renamed from: component3, reason: from getter */
        public final String getTsSignRee() {
            return this.tsSignRee;
        }

        public final ServerDataItem copy(String ticket, String tsSign, String tsSignRee) {
            Intrinsics.checkParameterIsNotNull(ticket, "ticket");
            return new ServerDataItem(ticket, tsSign, tsSignRee);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ServerDataItem)) {
                return false;
            }
            ServerDataItem serverDataItem = (ServerDataItem) other;
            return Intrinsics.areEqual(this.ticket, serverDataItem.ticket) && Intrinsics.areEqual(this.tsSign, serverDataItem.tsSign) && Intrinsics.areEqual(this.tsSignRee, serverDataItem.tsSignRee);
        }

        public int hashCode() {
            String str = this.ticket;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.tsSign;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.tsSignRee;
            return hashCode2 + (str3 != null ? str3.hashCode() : 0);
        }

        public String toString() {
            return "ServerDataItem(ticket=" + this.ticket + ", tsSign=" + this.tsSign + ", tsSignRee=" + this.tsSignRee + ")";
        }

        public ServerDataItem(String ticket, String str, String str2) {
            Intrinsics.checkParameterIsNotNull(ticket, "ticket");
            this.ticket = ticket;
            this.tsSign = str;
            this.tsSignRee = str2;
        }

        public final String getTicket() {
            return this.ticket;
        }

        public final String getTsSign() {
            return this.tsSign;
        }

        public final String getTsSignRee() {
            return this.tsSignRee;
        }
    }
}
