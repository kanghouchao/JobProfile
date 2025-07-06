import React from 'react';

const ResumeHistoryStep = ({ form, onChange }) => {
  const history = form.history || [];

  const handleInputChange = (index, field, value) => {
    const updatedHistory = [...history];
    updatedHistory[index] = { ...updatedHistory[index], [field]: value };
    onChange({ target: { name: 'history', value: updatedHistory } });
  };

  return (
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
          {history.map((row, index) => (
            <tr key={index}>
              <td className="border border-gray-300 p-2">
                <input
                  type="text"
                  value={row.period || ''}
                  onChange={(e) => handleInputChange(index, 'period', e.target.value)}
                  placeholder="例: 2020年4月 - 2024年3月"
                  className="w-full border rounded-md p-2 focus:outline-none focus:ring focus:ring-blue-300"
                />
              </td>
              <td className="border border-gray-300 p-2">
                <input
                  type="text"
                  value={row.content || ''}
                  onChange={(e) => handleInputChange(index, 'content', e.target.value)}
                  placeholder="例: ○○大学 ○○学部卒業"
                  className="w-full border rounded-md p-2 focus:outline-none focus:ring focus:ring-blue-300"
                />
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </section>
  );
};

export default ResumeHistoryStep;
