# APK 打包签名规范

> **所有 agent 重新打包 APK 时必须严格遵守本规范，否则将导致 "package info is null" 安装失败。**

## 一、问题根源

Android 7.0+ (API 24+) 的 `PackageManager` 要求 APK 必须包含 **v2 或 v3 签名方案**。仅使用 `jarsigner`（v1 签名）的 APK 在 Android 14 上会导致 `getPackageInfo()` 返回 null，表现为安装后提示 "package info is null" 或应用无法启动。

## 二、正确的签名流程

### 2.1 禁止使用 jarsigner

```bash
# ❌ 错误 - 只生成 v1 签名，Android 14 无法识别
jarsigner -keystore xxx.keystore app.apk alias
```

### 2.2 必须使用 uber-apk-signer 或 apksigner

```bash
# ✅ 正确 - 生成 v2+v3 签名 + zipalign 对齐

# 方式一：uber-apk-signer（推荐，自带 zipalign）
java -jar uber-apk-signer.jar \
  -a input_unsigned.apk \
  --out /workspace \
  --ks trae3.keystore \
  --ksAlias trae3 \
  --ksPass trae123 \
  --ksKeyPass trae123 \
  --allowResign

# 方式二：apksigner（需要单独 zipalign）
zipalign -v 4 input_unsigned.apk input_aligned.apk
apksigner sign \
  --ks trae3.keystore \
  --ks-key-alias trae3 \
  --ks-pass pass:trae123 \
  --key-pass pass:trae123 \
  --v1-signing-enabled true \
  --v2-signing-enabled true \
  --v3-signing-enabled true \
  input_aligned.apk
```

### 2.3 签名验证

每次签名后必须验证：

```bash
# 使用 uber-apk-signer 验证
java -jar uber-apk-signer.jar -a output.apk -y --verbose

# 期望输出必须包含：
# - zipalign verified
# - signature verified [v2, v3]
```

## 三、Keystore 信息

| 属性 | 值 |
|------|-----|
| 文件路径 | `/data/user/work/trae3.keystore` |
| 别名 | `trae3` |
| 密码 | `trae123` |
| Key 密码 | `trae123` |
| 证书主体 | `CN=TRAE3, OU=Dev, O=ByteDance, L=Beijing, ST=Beijing, C=CN` |
| 算法 | RSA 2048, SHA256withRSA |
| 有效期 | 10000 天 |

### 创建新 Keystore（仅在 keystore 丢失时）

```bash
keytool -genkey -v \
  -keystore /data/user/work/trae3.keystore \
  -storepass trae123 \
  -alias trae3 \
  -keypass trae123 \
  -keyalg RSA -keysize 2048 \
  -validity 10000 \
  -dname "CN=TRAE3, OU=Dev, O=ByteDance, L=Beijing, ST=Beijing, C=CN"
```

> **注意**：重新生成 keystore 后证书指纹会变化，用户必须先卸载旧版本才能安装。

## 四、完整构建流程

```bash
# 1. 构建 APK
apktool b trae_cn3_decoded -o trae_cn3_vXX_unsigned.apk

# 2. 签名（v2+v3 + zipalign）
java -jar /data/user/work/uber-apk-signer.jar \
  -a trae_cn3_vXX_unsigned.apk \
  --out /workspace \
  --ks /data/user/work/trae3.keystore \
  --ksAlias trae3 \
  --ksPass trae123 \
  --ksKeyPass trae123 \
  --allowResign

# 3. 重命名
mv /workspace/trae_cn3_vXX_unsigned-aligned-signed.apk /workspace/trae_cn3_vXX.apk

# 4. 验证
java -jar /data/user/work/uber-apk-signer.jar -a /workspace/trae_cn3_vXX.apk -y
```

## 五、Smali 代码编写规范

### 5.1 寄存器管理

在修改 smali 代码时，必须遵守以下寄存器规则，否则会导致 `VerifyError`：

1. **专用日志寄存器**：使用固定的两个寄存器（如 v12, v13）专门用于 `FileLogger.log()` 调用，这两个寄存器**永远只持有 String 类型**，绝不能用于数据流。

2. **禁止跨类型复用**：在分支合并点（如循环回跳 `:goto_1`、条件跳转 `:cond_X`），所有寄存器必须在所有到达路径上类型一致。

3. **寄存器上限**：`invoke-` 指令（非 range）只能访问 v0-v15。如果 `.locals` 较大导致参数寄存器超过 v15，必须在方法开头用 `move-object/from16` 将参数复制到低寄存器。

4. **catch 块寄存器**：`move-exception` 不应覆盖 v0（Activity 引用），应使用其他寄存器（如 v3）。

### 5.2 错误处理

- 所有 `performExtract` 逻辑必须包裹在 `:try_start_0 ... :try_end_0` 中
- catch 必须捕获 `Throwable`（不是 `Exception`），以防止 `VerifyError` 等运行时错误导致静默崩溃
- 每个关键步骤都必须有 `FileLogger.log()` 调用，以便通过日志文件追踪执行流程

### 5.3 常见 VerifyError 原因

| 错误信息 | 原因 | 修复 |
|---------|------|------|
| `register vX has type Reference: A but expected Reference: B` | 同一寄存器在分支合并点有不同类型 | 使用专用寄存器，不跨类型复用 |
| `invoke-super/virtual can't be used on private method` | 用 `invoke-virtual` 调用 private 方法 | 改用 `invoke-direct` |
| `Invalid register: v16+` | `.locals` 过大导致参数寄存器超限 | 减少 `.locals` 或用 `move-object/from16` 复制参数 |

## 六、工具位置

| 工具 | 路径 |
|------|------|
| apktool | `/usr/local/bin/apktool` |
| uber-apk-signer | `/data/user/work/uber-apk-signer.jar` |
| keystore | `/data/user/work/trae3.keystore` |
| 解包项目 | `/data/user/work/trae_cn3_decoded/` |
| Java | OpenJDK 11 (`/usr/bin/java`) |

## 七、检查清单

打包前确认：

- [ ] smali 代码中没有跨类型寄存器复用
- [ ] 所有 catch 块捕获 `Throwable`
- [ ] `apktool b` 构建成功无错误
- [ ] 使用 `uber-apk-signer` 签名（不是 `jarsigner`）
- [ ] 签名验证输出包含 `signature verified [v2, v3]`
- [ ] 签名验证输出包含 `zipalign verified`
- [ ] APK 证书主体为 `CN=TRAE3, OU=Dev, O=ByteDance`
