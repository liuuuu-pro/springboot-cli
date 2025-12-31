# SpringBoot-CLI

[简体中文](README_CN.md)

An enterprise-grade **Spring Boot + Spring Cloud + Spring AI** microservices scaffold, integrating modern middleware and best practices to help developers quickly build production-ready microservice systems.

---

## 🚀 Project Overview

**SpringBoot-CLI** is a cutting-edge microservices starter template designed for enterprise applications.  
The project takes **AI as a first-class citizen** and is built on the latest-generation Java and Spring ecosystem.

It provides a clean, extensible, and production-oriented architecture, covering common infrastructure concerns such as service discovery, configuration management, authentication, rate limiting, and observability.

This project is **fully open-source**, **community-oriented**, and intended **only for learning, research, and technical exchange**.

Repository:  
https://github.com/liuuuu-pro/springboot-cli [1]

---

## ✨ Key Features

- ✅ Based on **JDK 25**
- ✅ Core AI capability powered by **Spring AI 2.0.0**
- ✅ Built with **Spring Boot 4.0.0** and **Spring Cloud 2025.1.0**
- ✅ Modular microservice architecture
- ✅ Integrated **MySQL** and **Redis**
- ✅ API Gateway and service isolation
- ✅ Docker Compose support for local development
- ✅ Designed following real-world enterprise best practices

---

## 🧱 Technology Stack

### Core Frameworks
- **Spring Boot** 4.0.0
- **Spring Cloud** 2025.1.0
- **Spring Cloud Alibaba** 2025.1.0.x (official adaptation pending)

### AI
- **Spring AI** 2.0.0


---

## 📁 Project Structure

```
springboot-cli
├── common/                     # Shared modules
│   ├── common-core             # Utilities, DTOs, exception handling
│   └── common-redis            # Redis abstraction
├── gateway/                    # API Gateway (port: 9080)
├── service-ai/                 # AI service (port: 9000)
├── service-ai-mcp/             # MCP Server (port: 9003)
├── service-order/              # Order service (port: 9001)
├── service-user/               # User service (port: 9002)
├── docker/                     # Docker Compose configurations
└── docs/                       # Technical documents and design notes
```

---

## 🛠️ Environment Requirements

| Component | Version | Notes |
|---------|--------|------|
| JDK | 25+ | OpenJDK recommended |
| Maven | 3.9+ | Build tool |

---

## 📦 Service Registration (Nacos – Windows Example)

1. Download `nacos-server-3.1.1.tar.gz`
2. Extract and navigate to `nacos/bin`
3. Start standalone mode:
   ```bash
   startup.cmd -m standalone
   ```
4. Generate token secret key using PowerShell:
   ```powershell
   [Convert]::ToBase64String((1..32 | ForEach-Object {Get-Random -Maximum 256}))
   ```
5. Access Nacos Console:  
   http://localhost:8080

---

## 🤝 Contributing

Contributions of any kind are welcome and appreciated.

### Contribution Workflow

1. Fork this repository
2. Create a feature branch: `feature/xxx`
3. Commit changes using semantic commit messages:
   - `feat`: new feature
   - `fix`: bug fix
   - `docs`: documentation update
   - `refactor`: code refactoring
   - `test`: tests
4. Submit a Pull Request

This project is **actively maintained** and open to long-term community contributions.

---

## 📄 License

This project is licensed under the **Apache License 2.0**.  
See the [LICENSE](./LICENSE) file for details.

---

## 💡 JetBrains Open Source Support

This project complies with the **JetBrains Open Source License Support** requirements:

- ✅ Public and fully accessible source code
- ✅ Licensed under Apache License 2.0
- ✅ Non-commercial, community-driven usage
- ✅ Actively maintained open-source project

Special thanks to **JetBrains** for providing excellent development tools to support open-source communities ❤️

---

## 📬 Contact & Community

- **Project Homepage**: https://github.com/liuuuu-pro/springboot-cli [1]
- **Author Email**: liujiazhong0618@gmail.com
- **Issue Tracker**: GitHub Issues (recommended)

