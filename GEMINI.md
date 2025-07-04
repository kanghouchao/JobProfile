# GEMINI.md - 职位档案系统

本文档概述了职位档案系统、其架构以及如何使用代码库。

## 1. 项目概览

该项目是一个名为“职位档案”的 Web 应用程序，旨在解决创建日式简历时遇到的困扰，并通过集成 AI 来简化繁琐的信息录入过程。其核心功能之一是利用 AI 将用户的自然语言描述（如个人经历）转换为符合前端数据结构的标准化 JSON 格式简历数据，从而实现简历的自动生成与填充。它由两部分组成：

* **`backend`**：一个基于 Java 的 API，使用 Spring Boot 构建。
* **`frontend`**：一个基于 React 的单页应用程序。

该系统旨在使用 Docker 运行，并使用 `docker-compose` 进行编排。它还包括使用 GitHub Actions 的 CI/CD 流水线。

## 2. 技术栈

### 后端

* **框架**：Spring Boot
* **语言**：Java 17
* **构建工具**：Maven
* **数据库**：MySQL，使用 Liquibase 进行模式迁移
* **API**：RESTful API，可能使用 Spring Web MVC
* **安全**：Spring Security, JWT
* **其他**：Spring Data JPA, Spring AI, Lombok, Vavr, 遵循领域驱动设计（DDD）原则

### 前端

* **框架**：React
* **构建工具**：Create React App，使用 `craco` 进行配置覆盖
* **样式**：Tailwind CSS
* **路由**：`react-router-dom`
* **国际化 (i18n)**：`i18next`
* **状态管理**：React Context（由目录结构暗示）
* **HTTP 客户端**：Axios

### DevOps 与基础设施

* **容器化**：Docker
* **编排**：Docker Compose
* **CI/CD**：GitHub Actions
* **反向代理**：Traefik

## 3. 项目结构

该项目是一个 monorepo，结构如下：

``` plaintext
/
├── backend/         # Spring Boot 应用程序
│   ├── src/
│   ├── pom.xml      # Maven 配置
│   └── Dockerfile
├── frontend/        # React 应用程序
│   ├── src/
│   ├── public/
│   ├── package.json # NPM 配置
│   └── Dockerfile
├── .github/         # GitHub Actions 工作流
├── docker-compose.yaml # Docker Compose 配置
└── Makefile         # 主项目 Makefile
```

## 4. 入门

### 先决条件

* Docker
* Docker Compose
* `make`

### 运行应用程序

运行应用程序最简单的方法是使用主 `Makefile`。

1. **启动应用程序**：

    ```bash
    make start
    ```

    此命令将：
    * 构建后端和前端的 Docker 镜像。
    * 启动 `docker-compose.yaml` 中定义的所有服务。
    * 显示正在运行服务的日志。

2. **访问应用程序**：

    * 前端应可在 `<http://www.job-profile.com>` 访问（您可能需要将此添加到您的 `/etc/hosts` 文件中，指向 `127.0.0.1`）。
    * 后端 API 可在 `<http://www.job-profile.com/api>` 访问。
    * Traefik 仪表板位于 `<http://localhost:8080>`。

3. **停止应用程序**：

    ```bash
    make shutdown
    ```

### 开发工作流

`Makefile` 提供了几个有用的开发命令：

* `make test-all`：运行后端和前端的所有测试。
* `make build-all`：构建所有服务的 Docker 镜像。
* `make restart`：重启应用程序。

您还可以运行单个服务的命令：

* `make test-backend`
* `make build-frontend`

有关更多详细信息，请参阅根目录中的 `Makefile`，以及 `backend` 和 `frontend` 目录中的 `Makefile`。

## 5. CI/CD

该项目使用 GitHub Actions 进行持续集成。

* **后端工作流**：(`backend.yaml`)
  * 在影响 `backend/` 目录的 `main` 分支推送时触发。
  * 运行测试并构建后端应用程序。
* **前端工作流**：(`frontend.yml`)
  * 在影响 `frontend/` 目录的 `main` 分支推送时触发。
  * 运行测试并构建前端应用程序。

## 6. 编码风格

* **后端**：后端使用 `maven-checkstyle-plugin` 来强制执行编码标准。配置可在 `pom.xml` 中找到。
* **前端**：前端使用 `prettier` 进行代码格式化。您可以通过在 `frontend` 目录中运行 `npm run format` 来格式化代码。