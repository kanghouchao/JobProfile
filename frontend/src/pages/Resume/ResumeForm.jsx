import React from 'react';

const ResumeForm = () => {
  return (
    <div className="max-w-4xl mx-auto p-6 bg-white shadow-md rounded-md overflow-y-auto">
      <h1 className="text-2xl font-bold text-gray-800 mb-6">履歴書</h1>

      {/* 基本情報セクション */}
      <table className="w-full border-collapse border border-gray-300 mb-6">
        <tbody>
          <tr>
            <td className="border border-gray-300 p-2 bg-gray-100 w-1/4">氏名</td>
            <td className="border border-gray-300 p-2">
              <input
                type="text"
                placeholder="氏名を入力"
                className="w-full border rounded-md p-2 focus:outline-none focus:ring focus:ring-blue-300"
              />
            </td>
            <td className="border border-gray-300 p-2 bg-gray-100 w-1/4">ふりがな</td>
            <td className="border border-gray-300 p-2">
              <input
                type="text"
                placeholder="ふりがなを入力"
                className="w-full border rounded-md p-2 focus:outline-none focus:ring focus:ring-blue-300"
              />
            </td>
          </tr>
          <tr>
            <td className="border border-gray-300 p-2 bg-gray-100">生年月日</td>
            <td className="border border-gray-300 p-2">
              <input
                type="date"
                className="w-full border rounded-md p-2 focus:outline-none focus:ring focus:ring-blue-300"
              />
            </td>
            <td className="border border-gray-300 p-2 bg-gray-100">性別</td>
            <td className="border border-gray-300 p-2">
              <select className="w-full border rounded-md p-2 focus:outline-none focus:ring focus:ring-blue-300">
                <option value="">選択してください</option>
                <option value="male">男性</option>
                <option value="female">女性</option>
              </select>
            </td>
          </tr>
          <tr>
            <td className="border border-gray-300 p-2 bg-gray-100">住所</td>
            <td colSpan="3" className="border border-gray-300 p-2">
              <input
                type="text"
                placeholder="住所を入力"
                className="w-full border rounded-md p-2 focus:outline-none focus:ring focus:ring-blue-300"
              />
            </td>
          </tr>
          <tr>
            <td className="border border-gray-300 p-2 bg-gray-100">電話番号</td>
            <td className="border border-gray-300 p-2">
              <input
                type="tel"
                placeholder="電話番号を入力"
                className="w-full border rounded-md p-2 focus:outline-none focus:ring focus:ring-blue-300"
              />
            </td>
            <td className="border border-gray-300 p-2 bg-gray-100">メールアドレス</td>
            <td className="border border-gray-300 p-2">
              <input
                type="email"
                placeholder="メールアドレスを入力"
                className="w-full border rounded-md p-2 focus:outline-none focus:ring focus:ring-blue-300"
              />
            </td>
          </tr>
        </tbody>
      </table>

      {/* 学歴・職歴セクション */}
      <section className="mb-6">
        <h2 className="text-xl font-semibold text-gray-700 mb-4">学歴・職歴</h2>
        <table className="w-full border-collapse border border-gray-300">
          <thead>
            <tr>
              <th className="border border-gray-300 p-2 bg-gray-100">期間</th>
              <th className="border border-gray-300 p-2 bg-gray-100">内容</th>
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
                  placeholder="例: ○○大学 ○○学部卒業"
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
                  placeholder="例: ○○株式会社 ○○部勤務"
                  className="w-full border rounded-md p-2 focus:outline-none focus:ring focus:ring-blue-300"
                />
              </td>
            </tr>
          </tbody>
        </table>
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
  );
};

export default ResumeForm;