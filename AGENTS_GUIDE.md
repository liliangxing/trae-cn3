# AI Agent 操作指引（必读）

> **如果你是 AI Agent，请在做任何修改之前完整阅读本文件。**
> 本文件解决了"Agent 找不到代码"、"漏文件"、"打包闪退"等常见问题。

---

## 1. 仓库里有什么、在哪里

### 1.1 两套代码：Smali 和 Java

本仓库同时包含 **Smali 代码**和 **Java 代码**，它们的关系是：

```
Smali（实际打包用的）    Java（给人读的，不参与打包）
    ↓                        ↓
source/smali/             source/java/
    ↓                        ↓
直接复制到 apktool        jadx 反编译结果
解包目录参与编译           仅供理解逻辑
```

> **关键理解：** 你改 Smali，APK 就变。你改 Java，APK 不会变（除非你把 Java 重新编译成 Smali）。

### 1.2 自定义代码的位置

我们新增/修改的代码全部在 `com.bytedance.trae.conversation.extract` 包下：

| 文件 | Smali 路径 | Java 路径 | 说明 |
|------|-----------|----------|------|
| ExtractHelper | `source/smali/com/bytedance/trae/conversation/extract/ExtractHelper.smali` | `source/java/com/bytedance/trae/conversation/extract/ExtractHelper.java` | 主入口 |
| ApiMessageFetcher | `source/smali/com/bytedance/trae/conversation/extract/ApiMessageFetcher.smali` | `source/java/com/bytedance/trae/conversation/extract/ApiMessageFetcher.java` | API 拉消息 |
| ApiMessageFetcher$1 | `source/smali/com/bytedance/trae/conversation/extract/ApiMessageFetcher$1.smali` | （在 ApiMessageFetcher.java 内部） | SSL TrustManager |
| FileLogger | `source/smali/com/bytedance/trae/conversation/extract/FileLogger.smali` | `source/java/com/bytedance/trae/conversation/extract/FileLogger.java` | 日志 |
| GitHubPusher | `source/smali/com/bytedance/trae/conversation/extract/GitHubPusher.smali` | `source/java/com/bytedance/trae/conversation/extract/GitHubPusher.java` | 推送 GitHub |

> **重要：** Smali 和 Java 两套文件必须同步修改。如果你只改了 Java 没改 Smali，打包出来的 APK 不会有你的改动。

### 1.3 其他修改过的文件

除了 extract 包，还修改了以下文件（在 `source/smali/` 中）：

| 文件 | 改动 |
|------|------|
| `com/bytedance/trae/conversation/widget/MenuPopupWindow.smali` | 添加"提取对话"菜单项点击处理 |
| `com/bytedance/trae/conversation/widget/MenuPopupWindow$OnMenuClickListener.smali` | 添加 `onExtractClick()` 抽象方法 |
| `com/bytedance/trae/conversation/widget/MenuPopupWindow$$ExternalSyntheticLambda5.smali` | 新增：提取按钮点击监听器 |
| `com/bytedance/trae/conversation/TaskFragment.smali` | 任务列表右键菜单接入提取功能 |
| `com/bytedance/trae/conversation/ConversationActivity$initTitleBar$3$1.smali` | 对话页面标题栏接入提取功能 |
| `source/res/layout/conversation_popup_menu.xml` | 添加"提取对话"菜单项布局 |

---

## 2. 如何修改代码

### 方式一：直接改 Smali（推荐小改动）

1. 修改 `source/smali/` 中对应的 `.smali` 文件
2. 把修改后的文件复制到 apktool 解包目录的 `smali_classes9/` 下
3. 重新打包（见第 3 节）

### 方式二：改 Java 再编译成 Smali（推荐大改动）

1. 修改 `source/java/` 中对应的 `.java` 文件
2. 编译 Java → .class → .dex → .smali：
   ```bash
   javac -source 8 -target 8 -cp android.jar -d out/ ExtractHelper.java
   d8 --output out.dex out/com/bytedance/trae/conversation/extract/*.class
   java -jar baksmali.jar d out.dex -o new_smali/
   ```
3. 把生成的 `.smali` 复制到 `source/smali/` 和 apktool 解包目录
4. 重新打包（见第 3 节）

> **注意：** 编译 Java 需要 stub 类来满足依赖（Android 框架类、Trae 内部类等）。
> 详见 `BUILD_SCRIPT/BUILD.md`。

### 方式三：同时改 Smali 和 Java（推荐）

改 Smali 保证 APK 生效，同时改 Java 保证可读性。两套文件保持同步。

---

## 3. 如何重新打包 APK

### 3.1 前提条件

需要一个 apktool 解包的 APK 项目目录。如果环境里没有，需要先解包：

```bash
apktool d original.apk -o decoded_project/
```

### 3.2 同步自定义代码到解包目录

```bash
# 复制 Smali 文件到解包目录的 smali_classes9
cp source/smali/com/bytedance/trae/conversation/extract/*.smali \
   decoded_project/smali_classes9/com/bytedance/trae/conversation/extract/

# 复制修改过的 widget 文件
cp source/smali/com/bytedance/trae/conversation/widget/MenuPopupWindow*.smali \
   decoded_project/smali_classes9/com/bytedance/trae/conversation/widget/

# 复制修改过的资源文件
cp source/res/layout/conversation_popup_menu.xml \
   decoded_project/res/layout/
```

### 3.3 打包

```bash
# 删除缓存（重要！不删可能用旧代码）
rm -rf decoded_project/build

# 打包
apktool b decoded_project/ -o output_unsigned.apk
```

### 3.4 签名（关键！）

```bash
java -jar uber-apk-signer.jar \
  -a output_unsigned.apk \
  --out /workspace \
  --ks trae3.keystore \
  --ksAlias trae3 \
  --ksPass trae123 \
  --ksKeyPass trae123 \
  --allowResign
```

> **绝对不能用 jarsigner！** 它只生成 v1 签名，Android 7.0+ 安装后会闪退（package info is null）。
> **必须看到 `signature verified [v2, v3]` 才算成功。**

### 3.5 验证

```bash
# 验证签名
java -jar uber-apk-signer.jar -a output.apk -y

# 验证完整性
unzip -t output.apk
```

---

## 4. 常见错误与避坑

### 4.1 "package info is null" 闪退

**原因：** APK 只签了 v1 签名（用了 jarsigner 而不是 uber-apk-signer）
**解决：** 用 uber-apk-signer 重新签名，确保输出 `[v2, v3]`

### 4.2 VerifyError 闪退

**原因：** Smali 代码中寄存器类型冲突
**解决：** 为日志等临时操作使用专用寄存器，不要复用已有寄存器

### 4.3 打包出来的 APK 代码没变

**原因：** apktool 用了 `build/` 目录下的缓存
**解决：** 打包前 `rm -rf decoded_project/build`

### 4.4 Smali 文件冲突

**原因：** 同一个类在多个 `smali_classes*` 目录下都有
**解决：** 自定义类只放在 `smali_classes9/`，用 `find` 检查残留：
```bash
find decoded_project -path "*/conversation/extract/*.smali" -not -path "*/smali_classes9/*"
```

### 4.5 API 返回 400

**原因：** `before_limit` 参数值不对
**解决：** 必须用 `before_limit=10`（200 和 50 都会被拒绝）

### 4.6 GitHubPusher 推送失败

**原因：** BuildConfig 中的 GitHub Token 已失效
**解决：** 生成新 Token，更新到 BuildConfig.smali 中的 `GITHUB_TOKEN` 字段

---

## 5. 你需要哪些工具

| 工具 | 用途 | 下载方式 |
|------|------|---------|
| apktool | APK 解包/打包 | `apt install apktool` 或从 [ibotpeaches.github.io](https://ibotpeaches.github.io/Apktool/) 下载 |
| baksmali | dex→smali 反汇编 | `wget https://bitbucket.org/JesusFreke/smali/downloads/baksmali-2.5.2.jar` |
| uber-apk-signer | APK 签名（v2/v3） | 从 [GitHub](https://github.com/patrickfav/uber-apk-signer) 下载 |
| jadx | dex→Java 反编译 | 从 [GitHub](https://github.com/skylot/jadx/releases) 下载 |
| Java JDK | 运行上述工具 | 系统自带或 `apt install default-jdk` |

> **不需要任何特殊 skill、MCP 工具或浏览器自动化。** 只需要基本的文件读写和 bash 执行能力。

---

## 6. 完整搭建文档

如果需要从头开始（从原始 APK 到修改到打包到反编译），请阅读：

**`liliangxing/docs` 仓库 → `闪退专题/trae_cn3-APK逆向修改与Smali转Java完整指南.md`**

这份文档包含每一步的真实命令和输出，可以直接复制执行。

---

## 7. 文件完整性检查清单

修改或打包前，确认以下文件都在：

- [ ] `source/smali/com/bytedance/trae/conversation/extract/ExtractHelper.smali`
- [ ] `source/smali/com/bytedance/trae/conversation/extract/ApiMessageFetcher.smali`
- [ ] `source/smali/com/bytedance/trae/conversation/extract/ApiMessageFetcher$1.smali`
- [ ] `source/smali/com/bytedance/trae/conversation/extract/FileLogger.smali`
- [ ] `source/smali/com/bytedance/trae/conversation/extract/GitHubPusher.smali`
- [ ] `source/java/com/bytedance/trae/conversation/extract/ExtractHelper.java`
- [ ] `source/java/com/bytedance/trae/conversation/extract/ApiMessageFetcher.java`
- [ ] `source/java/com/bytedance/trae/conversation/extract/FileLogger.java`
- [ ] `source/java/com/bytedance/trae/conversation/extract/GitHubPusher.java`
- [ ] `BUILD_SCRIPT/APK_BUILD_SPEC.md`
- [ ] `source/res/layout/conversation_popup_menu.xml`

一键检查命令：
```bash
for f in \
  source/smali/com/bytedance/trae/conversation/extract/ExtractHelper.smali \
  source/smali/com/bytedance/trae/conversation/extract/ApiMessageFetcher.smali \
  "source/smali/com/bytedance/trae/conversation/extract/ApiMessageFetcher\$1.smali" \
  source/smali/com/bytedance/trae/conversation/extract/FileLogger.smali \
  source/smali/com/bytedance/trae/conversation/extract/GitHubPusher.smali \
  source/java/com/bytedance/trae/conversation/extract/ExtractHelper.java \
  source/java/com/bytedance/trae/conversation/extract/ApiMessageFetcher.java \
  source/java/com/bytedance/trae/conversation/extract/FileLogger.java \
  source/java/com/bytedance/trae/conversation/extract/GitHubPusher.java \
  BUILD_SCRIPT/APK_BUILD_SPEC.md \
  source/res/layout/conversation_popup_menu.xml; do
  if [ -f "$f" ]; then echo "  OK  $f"; else echo "  缺失 $f"; fi
done
```
