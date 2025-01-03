# JobProfile

## 概要

本プロジェクトは、前後分離のアーキテクチャを採用した履歴書作成プラットフォームです。フロントエンドは React、バックエンドは Java（Spring Boot）を使用しており、コンテナ化された環境で簡単に実行できます。このプラットフォームを通じて、ユーザーは迅速に履歴書を作成・カスタマイズし、PDF形式でエクスポートできます。

## 技術スタック

- **フロントエンド**: React
- **バックエンド**: Java (Spring Boot)
- **コンテナ化**: Docker Compose
- **ビルドツール**: Makefile

## 主な機能

1. **ユーザー登録とログイン**: アカウント作成と認証機能を提供。
2. **履歴書テンプレートの選択**: 複数のデザインテンプレートから選択可能。
3. **履歴書内容の編集とプレビュー**: ユーザーフレンドリーな編集画面とリアルタイムプレビュー。
4. **PDFエクスポート機能**: ワンクリックで履歴書をPDF形式に変換。

## 必要な環境

- **Docker** と **Docker Compose**
- **Make**

## クイックスタート

### 1. リポジトリのクローン

以下のコマンドでプロジェクトをクローンします：

```bash
git clone https://github.com/kanghouchao/JobProfile.git
cd JobProfile
```

### 2. 環境変数の設定

`.env` ファイルをプロジェクトのルートディレクトリに作成し、以下のように必要な設定を記述してください：

```
MYSQL_DATABASE=JOB_PROFILE
MYSQL_USER=user
MYSQL_PASSWORD=password
SPRING_MAIL_USERNAME=mail@account.com //see also: https://support.google.com/mail/answer/185833?hl=en#
SPRING_MAIL_PASSWORD=some password
JOB_PROFILE_SITE_DOMAIN=http://www.job-profile.com
```

### 3. プロジェクトの起動

以下のコマンドでプロジェクトを起動します：

```bash
make start
```

### 4. プロジェクトの停止

プロジェクトを停止するには、以下を実行してください：

```bash
make shutown
```

## よくある質問

### 1. 起動に失敗した場合

以下を確認してください：

- **Docker** と **Docker Compose** が正しくインストールされているか。
- **Make** がシステムにインストールされているか。
- `.env` ファイルの設定が正しいか。
- 使用中のポート（例: 80）が競合していないか。

### 2. 環境変数の再設定

環境変数を変更した場合、プロジェクトを再起動する必要があります。

```bash
make down
make up
```

---

これでプロジェクトのセットアップと基本的な利用が可能になります。問題や疑問がある場合は、ぜひお知らせください！

