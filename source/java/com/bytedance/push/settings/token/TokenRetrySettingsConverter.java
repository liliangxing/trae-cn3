package com.bytedance.push.settings.token;

import com.bytedance.push.settings.IDefaultValueProvider;
import com.bytedance.push.settings.ITypeConverter;
import com.bytedance.push.utils.GsonUtils;

/* loaded from: classes4.dex */
public class TokenRetrySettingsConverter implements ITypeConverter<TokenRetrySettingsMode>, IDefaultValueProvider<TokenRetrySettingsMode> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.push.settings.IDefaultValueProvider
    public TokenRetrySettingsMode create() {
        return new TokenRetrySettingsMode();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.push.settings.ITypeConverter
    public TokenRetrySettingsMode to(String str) {
        TokenRetrySettingsMode tokenRetrySettingsMode = (TokenRetrySettingsMode) GsonUtils.from(str, TokenRetrySettingsMode.class);
        return tokenRetrySettingsMode == null ? create() : tokenRetrySettingsMode;
    }

    @Override // com.bytedance.push.settings.ITypeConverter
    public String from(TokenRetrySettingsMode tokenRetrySettingsMode) {
        return GsonUtils.toJson(tokenRetrySettingsMode);
    }
}
