import React from 'react';

const PayPage = () => {
  return (
    <div className="max-w-md mx-auto p-6 bg-white shadow-md rounded-md">
      <h1 className="text-2xl font-bold text-gray-800 mb-6">クレジットカードでのお支払い</h1>

      <form>
        {/* カード番号 */}
        <div className="mb-4">
          <label className="block text-gray-600 mb-2">カード番号</label>
          <input
            type="text"
            placeholder="1234 5678 9012 3456"
            maxLength="19"
            className="w-full border rounded-md p-2 focus:outline-none focus:ring focus:ring-blue-300"
          />
        </div>

        {/* 有効期限 */}
        <div className="mb-4">
          <label className="block text-gray-600 mb-2">有効期限</label>
          <div className="flex gap-2">
            <input
              type="text"
              placeholder="MM"
              maxLength="2"
              className="w-1/2 border rounded-md p-2 focus:outline-none focus:ring focus:ring-blue-300"
            />
            <input
              type="text"
              placeholder="YY"
              maxLength="2"
              className="w-1/2 border rounded-md p-2 focus:outline-none focus:ring focus:ring-blue-300"
            />
          </div>
        </div>

        {/* セキュリティコード */}
        <div className="mb-4">
          <label className="block text-gray-600 mb-2">セキュリティコード (CVV)</label>
          <input
            type="text"
            placeholder="123"
            maxLength="3"
            className="w-full border rounded-md p-2 focus:outline-none focus:ring focus:ring-blue-300"
          />
        </div>

        {/* カード名義人 */}
        <div className="mb-4">
          <label className="block text-gray-600 mb-2">カード名義人</label>
          <input
            type="text"
            placeholder="例: TARO YAMADA"
            className="w-full border rounded-md p-2 focus:outline-none focus:ring focus:ring-blue-300"
          />
        </div>

        {/* 支払いボタン */}
        <div className="flex justify-end">
          <button
            type="submit"
            className="bg-blue-500 text-white px-4 py-2 rounded-md hover:bg-blue-600"
          >
            支払う
          </button>
        </div>
      </form>
    </div>
  );
};

export default PayPage;
