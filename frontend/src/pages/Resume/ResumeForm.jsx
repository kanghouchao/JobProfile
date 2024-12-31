import React from 'react';
import Layout from '../../components/Layout';

const ResumeForm = () => {
  return (
    <Layout>
        <div className="max-w-full mx-auto p-6 bg-white shadow-md rounded-md overflow-y-auto">
        <h1 className="text-2xl font-bold text-gray-800 mb-6">履歴書の作成</h1>

        {/* 基本情報セクション */}
        <section className="mb-6">
            <h2 className="text-xl font-semibold text-gray-700 mb-4">基本情報</h2>
            <div className="grid grid-cols-1 md:grid-cols-2 gap-4">
            <div>
                <label className="block text-gray-600">氏名</label>
                <input
                type="text"
                placeholder="氏名を入力"
                className="w-full border rounded-md p-2 focus:outline-none focus:ring focus:ring-blue-300"
                />
            </div>
            <div>
                <label className="block text-gray-600">ふりがな</label>
                <input
                type="text"
                placeholder="ふりがなを入力"
                className="w-full border rounded-md p-2 focus:outline-none focus:ring focus:ring-blue-300"
                />
            </div>
            <div>
                <label className="block text-gray-600">性別</label>
                <select className="w-full border rounded-md p-2 focus:outline-none focus:ring focus:ring-blue-300">
                <option value="">選択してください</option>
                <option value="male">男性</option>
                <option value="female">女性</option>
                </select>
            </div>
            <div>
                <label className="block text-gray-600">生年月日</label>
                <input
                type="date"
                className="w-full border rounded-md p-2 focus:outline-none focus:ring focus:ring-blue-300"
                />
            </div>
            </div>
        </section>

        {/* 写真セクション */}
        <section className="mb-6">
            <h2 className="text-xl font-semibold text-gray-700 mb-4">写真</h2>
            <div className="border border-dashed border-gray-300 p-4 rounded-md text-center">
            <p className="text-gray-500 mb-2">ここに写真をアップロードしてください</p>
            <input type="file" className="w-full text-sm text-gray-500" />
            </div>
        </section>

        {/* 学歴・職歴セクション */}
        <section className="mb-6">
            <h2 className="text-xl font-semibold text-gray-700 mb-4">学歴・職歴</h2>
            <textarea
            placeholder="例: 2020年4月 - 2024年3月 ○○大学 ○○学部卒業"
            rows="4"
            className="w-full border rounded-md p-2 focus:outline-none focus:ring focus:ring-blue-300"
            ></textarea>
        </section>

        {/* 免許・資格セクション */}
        <section className="mb-6">
            <h2 className="text-xl font-semibold text-gray-700 mb-4">免許・資格</h2>
            <textarea
            placeholder="例: 2023年7月 普通自動車免許取得"
            rows="3"
            className="w-full border rounded-md p-2 focus:outline-none focus:ring focus:ring-blue-300"
            ></textarea>
        </section>

        {/* 本人希望記入欄 */}
        <section className="mb-6">
            <h2 className="text-xl font-semibold text-gray-700 mb-4">本人希望記入欄</h2>
            <textarea
            placeholder="例: 希望勤務地: 東京都内"
            rows="3"
            className="w-full border rounded-md p-2 focus:outline-none focus:ring focus:ring-blue-300"
            ></textarea>
        </section>

        {/* 自己PR */}
        <section className="mb-6">
            <h2 className="text-xl font-semibold text-gray-700 mb-4">自己PR</h2>
            <textarea
            placeholder="例: 私の強みは..."
            rows="4"
            className="w-full border rounded-md p-2 focus:outline-none focus:ring focus:ring-blue-300"
            ></textarea>
        </section>

        {/* ボタン */}
        <div className="flex justify-end gap-4">
            <button className="bg-gray-300 text-gray-700 px-4 py-2 rounded-md hover:bg-gray-400">
            キャンセル
            </button>
            <button className="bg-blue-500 text-white px-4 py-2 rounded-md hover:bg-blue-600">
            保存
            </button>
        </div>
        </div>
    </Layout>
  );
};

export default ResumeForm;