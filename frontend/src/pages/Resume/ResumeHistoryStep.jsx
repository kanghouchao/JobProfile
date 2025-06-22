import React from 'react';

const ResumeHistoryStep = ({ form, onChange }) => (
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
              name="history1_period"
              value={form.history1_period || ''}
              onChange={onChange}
              placeholder="例: 2020年4月 - 2024年3月"
              className="w-full border rounded-md p-2 focus:outline-none focus:ring focus:ring-blue-300"
            />
          </td>
          <td className="border border-gray-300 p-2">
            <input
              type="text"
              name="history1_content"
              value={form.history1_content || ''}
              onChange={onChange}
              placeholder="例: ○○大学 ○○学部卒業"
              className="w-full border rounded-md p-2 focus:outline-none focus:ring focus:ring-blue-300"
            />
          </td>
        </tr>
        <tr>
          <td className="border border-gray-300 p-2">
            <input
              type="text"
              name="history2_period"
              value={form.history2_period || ''}
              onChange={onChange}
              placeholder="例: 2024年4月 - 現在"
              className="w-full border rounded-md p-2 focus:outline-none focus:ring focus:ring-blue-300"
            />
          </td>
          <td className="border border-gray-300 p-2">
            <input
              type="text"
              name="history2_content"
              value={form.history2_content || ''}
              onChange={onChange}
              placeholder="例: ○○株式会社 ○○部勤務"
              className="w-full border rounded-md p-2 focus:outline-none focus:ring focus:ring-blue-300"
            />
          </td>
        </tr>
      </tbody>
    </table>
  </section>
);

export default ResumeHistoryStep;
