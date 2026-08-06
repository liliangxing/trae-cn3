package com.bytedance.android.sdk.bdticketguard;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TicketGuardApi.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u001dB3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003JA\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\u0006\u0010\u001b\u001a\u00020\u001cR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/sdk/bdticketguard/TicketDataBean;", "", "type", "", "ticket", "ts_sign", "ts_sign_ree", "cert", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCert", "()Ljava/lang/String;", "getTicket", "getTs_sign", "getTs_sign_ree", "getType", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "toTicketData", "Lcom/bytedance/android/sdk/bdticketguard/TicketData;", "CombineTsSign", "bd_ticket_guard_api_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final /* data */ class TicketDataBean {

    @SerializedName("cert")
    private final String cert;

    @SerializedName("ticket")
    private final String ticket;

    @SerializedName("ts_sign")
    private final String ts_sign;

    @SerializedName("ts_sign_ree")
    private final String ts_sign_ree;

    @SerializedName("type")
    private final String type;

    public static /* synthetic */ TicketDataBean copy$default(TicketDataBean ticketDataBean, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = ticketDataBean.type;
        }
        if ((i & 2) != 0) {
            str2 = ticketDataBean.ticket;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = ticketDataBean.ts_sign;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = ticketDataBean.ts_sign_ree;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            str5 = ticketDataBean.cert;
        }
        return ticketDataBean.copy(str, str6, str7, str8, str5);
    }

    /* renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTicket() {
        return this.ticket;
    }

    /* renamed from: component3, reason: from getter */
    public final String getTs_sign() {
        return this.ts_sign;
    }

    /* renamed from: component4, reason: from getter */
    public final String getTs_sign_ree() {
        return this.ts_sign_ree;
    }

    /* renamed from: component5, reason: from getter */
    public final String getCert() {
        return this.cert;
    }

    public final TicketDataBean copy(String type, String ticket, String ts_sign, String ts_sign_ree, String cert) {
        Intrinsics.checkParameterIsNotNull(type, "type");
        Intrinsics.checkParameterIsNotNull(ticket, "ticket");
        return new TicketDataBean(type, ticket, ts_sign, ts_sign_ree, cert);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TicketDataBean)) {
            return false;
        }
        TicketDataBean ticketDataBean = (TicketDataBean) other;
        return Intrinsics.areEqual(this.type, ticketDataBean.type) && Intrinsics.areEqual(this.ticket, ticketDataBean.ticket) && Intrinsics.areEqual(this.ts_sign, ticketDataBean.ts_sign) && Intrinsics.areEqual(this.ts_sign_ree, ticketDataBean.ts_sign_ree) && Intrinsics.areEqual(this.cert, ticketDataBean.cert);
    }

    public int hashCode() {
        String str = this.type;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.ticket;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.ts_sign;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.ts_sign_ree;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.cert;
        return hashCode4 + (str5 != null ? str5.hashCode() : 0);
    }

    public String toString() {
        return "TicketDataBean(type=" + this.type + ", ticket=" + this.ticket + ", ts_sign=" + this.ts_sign + ", ts_sign_ree=" + this.ts_sign_ree + ", cert=" + this.cert + ")";
    }

    public TicketDataBean(String str, String str2, String str3, String str4, String str5) {
        Intrinsics.checkParameterIsNotNull(str, "type");
        Intrinsics.checkParameterIsNotNull(str2, "ticket");
        this.type = str;
        this.ticket = str2;
        this.ts_sign = str3;
        this.ts_sign_ree = str4;
        this.cert = str5;
    }

    public final String getType() {
        return this.type;
    }

    public final String getTicket() {
        return this.ticket;
    }

    public final String getTs_sign() {
        return this.ts_sign;
    }

    public final String getTs_sign_ree() {
        return this.ts_sign_ree;
    }

    public final String getCert() {
        return this.cert;
    }

    /* compiled from: TicketGuardApi.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/sdk/bdticketguard/TicketDataBean$CombineTsSign;", "", "ts_sign", "", "ts_sign_ree", "(Ljava/lang/String;Ljava/lang/String;)V", "getTs_sign", "()Ljava/lang/String;", "getTs_sign_ree", "component1", "component2", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "bd_ticket_guard_api_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static final /* data */ class CombineTsSign {

        @SerializedName("ts_sign")
        private final String ts_sign;

        @SerializedName("ts_sign_ree")
        private final String ts_sign_ree;

        public static /* synthetic */ CombineTsSign copy$default(CombineTsSign combineTsSign, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = combineTsSign.ts_sign;
            }
            if ((i & 2) != 0) {
                str2 = combineTsSign.ts_sign_ree;
            }
            return combineTsSign.copy(str, str2);
        }

        /* renamed from: component1, reason: from getter */
        public final String getTs_sign() {
            return this.ts_sign;
        }

        /* renamed from: component2, reason: from getter */
        public final String getTs_sign_ree() {
            return this.ts_sign_ree;
        }

        public final CombineTsSign copy(String ts_sign, String ts_sign_ree) {
            return new CombineTsSign(ts_sign, ts_sign_ree);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CombineTsSign)) {
                return false;
            }
            CombineTsSign combineTsSign = (CombineTsSign) other;
            return Intrinsics.areEqual(this.ts_sign, combineTsSign.ts_sign) && Intrinsics.areEqual(this.ts_sign_ree, combineTsSign.ts_sign_ree);
        }

        public int hashCode() {
            String str = this.ts_sign;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.ts_sign_ree;
            return hashCode + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "CombineTsSign(ts_sign=" + this.ts_sign + ", ts_sign_ree=" + this.ts_sign_ree + ")";
        }

        public CombineTsSign(String str, String str2) {
            this.ts_sign = str;
            this.ts_sign_ree = str2;
        }

        public final String getTs_sign() {
            return this.ts_sign;
        }

        public final String getTs_sign_ree() {
            return this.ts_sign_ree;
        }
    }

    public final TicketData toTicketData() {
        return new TicketData(this.type, this.ticket, TicketGuardApiKt.getGson().toJson(new CombineTsSign(this.ts_sign, this.ts_sign_ree)), this.cert);
    }
}
