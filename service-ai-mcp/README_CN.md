# Spring AI MCP Server 架构与选型

## 1. MCP Server 是什么？解决什么问题？

MCP（Model Context Protocol）Server 是一种**标准化的“工具能力服务”**，用于向 AI 应用暴露可调用的能力，例如：

- 外部系统：Gmail、Jira、GitLab
- 内部系统：订单、用户、权限
- 计算 / 查询 / 自动化能力

Spring AI 提供 MCP Server Boot Starter，用于在 Spring Boot 中快速构建 MCP Server，具备：

- 自动配置
- 注解式工具注册
- 多协议、多传输方式
- 同步 / 异步两种执行模型

---

## 2. 微服务整体架构
### ✅ 正确分工

```text
service-ai        →  对话、Agent、Prompt、推理决策
service-ai-mcp    →  工具执行（Gmail / Jira / 内部系统）
```

核心原则：

- service-ai 是“大脑”
- service-ai-mcp 是“手和脚”，不参与对话、不保存上下文

---

## 3. MCP Server 支持的协议类型

Spring AI MCP Server 支持以下协议：

### 3.1 STDIO（进程内）
特点
- 通过标准输入/输出通信
- MCP Server 与宿主程序同进程

适合
- 本地 Agent
- IDE 插件
- CLI 工具

不适合
- 微服务
- Web / 云部署

---

### 3.2 SSE（Server-Sent Events）

特点
- 长连接
- 服务端可持续推送消息

适合
- 实时进度展示
- 长任务日志推送

缺点
- 连接成本高
- 不利于大规模扩展

---

### 3.3 Streamable-HTTP（官方推荐）

特点
- 标准 HTTP GET / POST
- 可选流式（SSE）
- 支持多客户端
- 替代 SSE

适合
- 独立 MCP Server
- 企业级工具平台
- K8s / Gateway / 负载均衡

---

### 3.4 Stateless（微服务首选）

官方定义

> Stateless MCP servers do not maintain session state between requests and are ideal for microservices and cloud-native deployments

特点
- 不保存会话状态
- 每次请求自包含
- 易扩展、易重启

适合
- 工具型微服务
- OAuth Token 透传
- Serverless / K8s

---

## 4. Stateless 到底解决的是什么问题？

### ✅ 什么时候**必须用 Stateless**

只要满足以下任一条件：
1. MCP Server 是**工具微服务**
2. 部署在 Docker / K8s
3. 不需要保存 session
4. 每次调用都是“一次性执行”
5. 上游（service-ai）负责所有状态

典型例子

- Gmail 工具
- Jira 工单
- 内部系统查询

---

### ❌ 什么时候**不该用 Stateless**

1. MCP Server 需要维护会话
2. 需要长连接或连接级状态
3. 本地 Agent / IDE 插件
4. 强依赖内存上下文

---

### 判断法

> 如果 MCP Server 重启，不影响业务正确性 → Stateless

> 如果会影响 → 不要 Stateless

---

## 5. 同步（SYNC） vs 异步（ASYNC）

Spring AI MCP Server 支持两种执行模型：

### 5.1 SYNC（同步）

特点
- 简单
- 阻塞式
- 只注册同步方法

适合
- 低并发
- 纯计算
- 本地工具

---

### 5.2 ASYNC（异步，推荐）

特点

- 基于 Reactor
- 非阻塞
- 只注册异步方法

适合
- IO 密集
- HTTP / DB / 外部 API
- 高并发

✅ 访问 Gmail / 外部系统，必须用 ASYNC

---

## 6. 基于当前场景的标准答案

### ✅ 推荐组合

```text

STATELESS + ASYNC + WebFlux

```

```yaml

spring:
  ai:
    mcp:
      server:
        protocol: STATELESS
        type: ASYNC

```

原因

- 工具型微服务
- 无会话
- 易扩展
- 官方明确推荐给微服务 / 云原生

---

## 7. MCP Tool 设计最佳实践
### ✅ 一个 Tool = 一个清晰意图

❌ 不推荐

```text
gmail(action, params)
```

✅ 推荐

```text
gmail_list_inbox
gmail_read_mail
gmail_search_mail
gmail_send_mail
```

### ✅ 示例

```java
@Component
public class GmailTools {
    @McpTool(
        name = "gmail_list_inbox",
        description = "List recent emails from Gmail inbox"
    )

    public Mono<List<MailDto>> listInbox(
            @McpToolParam(description = "Max results", required = false)
            Integer maxResults,
            McpTransportContext context
    ) {
        return gmailService.listInbox(maxResults);
    }
}
```

---

## 8. 安全与认证设计原则
- MCP Server 不做 OAuth 页面流程
- 只接收：
    - userId
    - accessToken
- Token 存储：
    - Redis / DB（加密）
- 多租户信息通过 McpTransportContext 获取

✅ Stateless 天然适合这种模式

---

## 9. 什么时候要拆多个 MCP Server？

| 情况 | 建议 |
|----|----|
| 工具 < 10 个 | 一个 MCP Server |
| 外部系统很多 | 按业务域拆 |
| 安全级别不同 | 必须拆 |
| 访问频率差异大 | 拆 |

---

## 10. 一页速查表

| 场景 | 推荐方案 |
|----|----|
| 本地 Agent / IDE | STDIO + SYNC |
| 实时进度推送 | SSE + ASYNC |
| 通用工具平台 | Streamable-HTTP + ASYNC |
| 微服务 / 云原生 | STATELESS + ASYNC ✅ |

---

## 11. 总结

> **MCP Server 只要是“工具微服务”，就应该是 Stateless；

> 所有状态，永远属于 service-ai。**

这是 Spring AI MCP Server 的**官方设计初衷**

