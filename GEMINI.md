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
* **构建工具**：Create React App
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

## 7. Project Repository

*   **Owner**: `kanghouchao`
*   **Repository**: `JobProfile`
*   **URL**: `https://github.com/kanghouchao/JobProfile`

## 8. 前端模块化与路径管理

### 8.1 历史背景与别名移除

项目早期曾尝试引入 `craco` (`@craco/craco`) 以支持 `@` 路径别名，旨在简化模块导入。然而，`craco` 的引入导致了前端单元测试（Jest）的严重兼容性问题，且该项目长期缺乏维护。

为了确保项目健康和测试环境的稳定性，我们决定**彻底移除前端单元测试**，并**放弃使用 `@` 路径别名**。所有代码库中原先使用 `@` 别名的路径均已重构为相对路径，以确保模块导入的明确性和兼容性。

### 8.2 单元测试移除详情

为了精简项目并解决兼容性问题，我们已执行以下操作，彻底移除了前端单元测试相关内容：

*   删除了 `frontend/jest.config.js`。
*   删除了 `frontend/src/__mocks__` 目录及其内容。
*   删除了 `frontend/src/pages/Auth/__tests__` 目录及其内容。
*   删除了 `frontend/src/setupTests.js`。
*   删除了 `frontend/babel.config.js`。
*   更新了 `frontend/package.json`，移除了所有与测试相关的 `scripts` 和 `devDependencies`（包括 `@testing-library`、`jest`、`babel-jest`、`@babel/preset-env`、`@babel/preset-react` 等）。
*   移除了 `frontend/node_modules` 和 `frontend/package-lock.json`，以确保依赖的完全清理。

### 8.3 路径别名重构详情

所有在 `frontend/src` 目录下使用 `@` 别名的模块导入路径均已成功重构为相对路径。受影响的主要文件包括：

*   `src/App.js`
*   `src/config/i18n.js`
*   `src/index.js`
*   `src/layout.js`
*   `src/pages/Auth/Login.jsx`
*   `src/pages/Auth/PasswordSetting.jsx`
*   `src/pages/Auth/Register.jsx`
*   `src/pages/Auth/index.js`
*   `src/pages/Home/Home.jsx`
*   `src/pages/Home/index.js`
*   `src/pages/Pay/index.js`
*   `src/pages/Resume/index.js`
*   `src/router.js`
*   `src/services/ai/index.js`

通过这些更改，项目现在拥有一个更简洁、更稳定的前端环境，专注于核心业务逻辑的开发.

## 9. 前端架构与当前任务

### 9.1 布局 (layout.js)
在用户登录或注册后，所有页面都由 `frontend/src/layout.js` 文件进行统一布局管理。该布局将页面划分为三个主要部分：
1.  **页眉 (Header)**：位于顶部，用于显示当前页面的标题和一个最新消息按钮（该按钮功能尚未完全实现）。
2.  **侧边菜单栏 (Sidebar)**：位于左侧，提供不同页面模块之间的导航。
3.  **内容区 (Outlet)**：位于右下角，用于渲染当前路由匹配的页面组件。

### 9.2 当前核心任务 (PR #3)
当前的核心开发任务是**“前端简历录入页面改版：分步录入与AI对话集成”**。

**主要目标**：将原有的单页简历填写形式，改造为一个多步骤的向导式（Wizard）表单，并集成一个AI对话界面以辅助用户填写。

**关键实现点**：
*   **分步式表单**：将简历录入拆分为四个步骤：基本信息、学历/工作经历、证书/资格、自我介绍。每一步都是一个独立的组件，并拥有独立的URL（例如 `/resume/basic`）。
*   **AI 对话集成**：在简历填写页面采用左右分栏布局，左侧为AI对话区域，右侧为表单填写区域，允许用户在填写的任何阶段与AI进行交互。
*   **UI/UX 改进**：实现响应式布局，并确保在不同步骤之间切换时，已填写的表单数据能够被完整保留。