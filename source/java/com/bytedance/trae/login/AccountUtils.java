package com.bytedance.trae.login;

import com.bytedance.trae.login.api.LoginPlatform;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* compiled from: AccountUtils.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u000fB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005J\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nJ\u0016\u0010\f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/bytedance/trae/login/AccountUtils;", "", "<init>", "()V", "accountPhoneOneKeyInfo", "Lcom/bytedance/trae/login/PhoneOneKeyInfo;", "getPreLoadOneKeyInfo", "preLoadAccountPhoneOneKeyInfo", "", "purePhoneNumber", "", "input", "formatPhoneNumber", "totalLength", "Lcom/bytedance/trae/login/AccountUtils$MobileTotalLength;", "MobileTotalLength", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class AccountUtils {
    public static final AccountUtils INSTANCE = new AccountUtils();
    private static PhoneOneKeyInfo accountPhoneOneKeyInfo;

    /* compiled from: AccountUtils.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MobileTotalLength.values().length];
            try {
                iArr[MobileTotalLength.TEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MobileTotalLength.ELEVEN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private AccountUtils() {
    }

    public final PhoneOneKeyInfo getPreLoadOneKeyInfo() {
        return accountPhoneOneKeyInfo;
    }

    public final void preLoadAccountPhoneOneKeyInfo() {
        PhoneOneKeyInit.INSTANCE.init();
        new PhoneLogin().getPhoneInfo(LoginPlatform.PHONE, new IPhoneOneKeyCallback() { // from class: com.bytedance.trae.login.AccountUtils$preLoadAccountPhoneOneKeyInfo$1
            @Override // com.bytedance.trae.login.IPhoneOneKeyCallback
            public void onGetPhoneOneKeyInfoFailure(int errorType, String errorCode, String errorMessage) {
            }

            @Override // com.bytedance.trae.login.IPhoneOneKeyCallback
            public void onGetPhoneOneKeyInfoSuccess(PhoneOneKeyInfo phoneOneKeyInfo) {
                AccountUtils accountUtils = AccountUtils.INSTANCE;
                AccountUtils.accountPhoneOneKeyInfo = phoneOneKeyInfo;
            }
        });
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: AccountUtils.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/login/AccountUtils$MobileTotalLength;", "", "<init>", "(Ljava/lang/String;I)V", "TEN", "ELEVEN", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class MobileTotalLength {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ MobileTotalLength[] $VALUES;
        public static final MobileTotalLength TEN = new MobileTotalLength("TEN", 0);
        public static final MobileTotalLength ELEVEN = new MobileTotalLength("ELEVEN", 1);

        private static final /* synthetic */ MobileTotalLength[] $values() {
            return new MobileTotalLength[]{TEN, ELEVEN};
        }

        public static EnumEntries<MobileTotalLength> getEntries() {
            return $ENTRIES;
        }

        private MobileTotalLength(String str, int i) {
        }

        static {
            MobileTotalLength[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        public static MobileTotalLength valueOf(String str) {
            return (MobileTotalLength) Enum.valueOf(MobileTotalLength.class, str);
        }

        public static MobileTotalLength[] values() {
            return (MobileTotalLength[]) $VALUES.clone();
        }
    }

    public final String purePhoneNumber(String input) {
        Intrinsics.checkNotNullParameter(input, "input");
        return new Regex("[^0-9]").replace(input, "");
    }

    public final String formatPhoneNumber(String input, MobileTotalLength totalLength) {
        int i;
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(totalLength, "totalLength");
        String purePhoneNumber = purePhoneNumber(input);
        int i2 = WhenMappings.$EnumSwitchMapping$0[totalLength.ordinal()];
        if (i2 == 1) {
            i = 6;
        } else {
            if (i2 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            i = 7;
        }
        if (purePhoneNumber.length() <= 3) {
            return purePhoneNumber;
        }
        if (purePhoneNumber.length() <= i) {
            return StringsKt.take(purePhoneNumber, 3) + ' ' + StringsKt.drop(purePhoneNumber, 3);
        }
        String take = StringsKt.take(purePhoneNumber, 3);
        String substring = purePhoneNumber.substring(3, i);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        return take + ' ' + substring + ' ' + StringsKt.drop(purePhoneNumber, i);
    }
}
