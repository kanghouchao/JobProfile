# JobProfile

## 概要

本プロジェクトは、前後分離のアーキテクチャを採用した履歴書作成プラットフォームです。フロントエンドは React、バックエンドは Java（Spring Boot）を使用しており、コンテナ化された環境で簡単に実行できます。このプラットフォームを通じて、ユーザーは迅速に履歴書を作成・カスタマイズし、PDF形式でエクスポートできます。

## 技術スタック

- **フロントエンド**: React
- **バックエンド**: Java (Spring Boot)
- **コンテナ化**: Docker Compose
- **ビルドツール**: Makefile
- **データベース**: MySQL
- **認証**: JWT

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

`.env` ファイルをプロジェクトのルートディレクトリに作成してください。プロジェクトに含まれる `env.example` ファイルを参考に、以下のような必要な設定を記述してください：

```
MYSQL_DATABASE=JOB_PROFILE
MYSQL_USER=user
MYSQL_PASSWORD=password
SPRING_MAIL_USERNAME=your_email@gmail.com
SPRING_MAIL_PASSWORD=your_app_password
JOB_PROFILE_SITE_DOMAIN=http://localhost
```

必要に応じて、ご自身の環境に合わせて値を変更してください。

### 3. プロジェクトの起動

以下のコマンドでプロジェクトを起動します：

```bash
make up
```

ブラウザで http://localhost にアクセスしてアプリケーションを使用できます。

### 4. プロジェクトの停止

プロジェクトを停止するには、以下を実行してください：

```bash
make down
```

### 5. その他のMakeコマンド

```bash
make build      # イメージを再ビルド
make restart    # コンテナを再起動
make logs       # コンテナのログを表示
```

## よくある質問

### 1. 起動に失敗した場合

以下を確認してください：

- **Docker** と **Docker Compose** が正しくインストールされているか。
- **Make** がシステムにインストールされているか。
- `.env` ファイルの設定が正しいか。
- 使用中のポート（例: 80）が競合していないか。

### 2. メール送信機能について

メール送信にはGmailアカウントを使用する場合、Googleの「安全性の低いアプリのアクセス」を有効にするか、
アプリパスワードを生成する必要があります。詳細は [Googleのサポートページ](https://support.google.com/mail/answer/185833?hl=ja) を参照してください。

### 3. OpenAI APIの設定について

AI履歴書生成機能を使用するには、OpenAI APIキーが必要です。以下の手順で取得してください：

1. [OpenAIのウェブサイト](https://platform.openai.com/)にアクセスしてアカウントを作成
2. APIキーを生成（[APIキー管理ページ](https://platform.openai.com/account/api-keys)）
3. `.env`ファイルに以下の形式で追加：
   ```
   OPENAI_API_KEY=your_api_key_here
   ```

APIキーの利用には料金が発生する可能性があります。詳細は[OpenAIの料金ページ](https://openai.com/pricing)を確認してください。

---

これでプロジェクトのセットアップと基本的な利用が可能になります。問題や疑問がある場合は、Issueを作成してお知らせください！

