import React from 'react';

const JobHistoryForm = () => {
  return (
    <div className="max-w-4xl mx-auto p-6 bg-white shadow-md rounded-md overflow-y-auto">
      <h1 className="text-2xl font-bold text-gray-800 mb-6">職務履歴書</h1>

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
        </div>
      </section>

      {/* 職務履歴セクション */}
      <section className="mb-6">
        <h2 className="text-xl font-semibold text-gray-700 mb-4">職務履歴</h2>
        <table className="w-full border-collapse border border-gray-300">
          <thead>
            <tr>
              <th className="border border-gray-300 p-2 bg-gray-100">期間</th>
              <th className="border border-gray-300 p-2 bg-gray-100">会社名</th>
              <th className="border border-gray-300 p-2 bg-gray-100">役職・業務内容</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td className="border border-gray-300 p-2">
                <input
                  type="text"
                  placeholder="例: 2020年4月 - 2024年3月"
                  className="w-full border rounded-md p-2 focus:outline-none focus:ring focus:ring-blue-300"
                />
              </td>
              <td className="border border-gray-300 p-2">
                <input
                  type="text"
                  placeholder="例: ○○株式会社"
                  className="w-full border rounded-md p-2 focus:outline-none focus:ring focus:ring-blue-300"
                />
              </td>
              <td className="border border-gray-300 p-2">
                <input
                  type="text"
                  placeholder="例: 営業部 部長"
                  className="w-full border rounded-md p-2 focus:outline-none focus:ring focus:ring-blue-300"
                />
              </td>
            </tr>
            <tr>
              <td className="border border-gray-300 p-2">
                <input
                  type="text"
                  placeholder="例: 2024年4月 - 現在"
                  className="w-full border rounded-md p-2 focus:outline-none focus:ring focus:ring-blue-300"
                />
              </td>
              <td className="border border-gray-300 p-2">
                <input
                  type="text"
                  placeholder="例: △△株式会社"
                  className="w-full border rounded-md p-2 focus:outline-none focus:ring focus:ring-blue-300"
                />
              </td>
              <td className="border border-gray-300 p-2">
                <input
                  type="text"
                  placeholder="例: 開発部 エンジニア"
                  className="w-full border rounded-md p-2 focus:outline-none focus:ring focus:ring-blue-300"
                />
              </td>
            </tr>
          </tbody>
        </table>
      </section>

      {/* 自己PRセクション */}
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
  );
};

export default JobHistoryForm;