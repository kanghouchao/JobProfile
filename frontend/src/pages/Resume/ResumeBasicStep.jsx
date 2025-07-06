import React from 'react';

const ResumeBasicStep = ({ form, onChange }) => (
  <table className="w-full border-collapse border border-gray-300 mb-6">
    <tbody>
      <tr>
        <td className="border border-gray-300 p-2 bg-gray-100 w-1/4"><label htmlFor="name">氏名</label></td>
        <td className="border border-gray-300 p-2">
          <input
            type="text"
            id="name"
            name="name"
            value={form.name || ''}
            onChange={onChange}
            placeholder="氏名を入力"
            className="w-full border rounded-md p-2 focus:outline-none focus:ring focus:ring-blue-300"
          />
        </td>
        <td className="border border-gray-300 p-2 bg-gray-100 w-1/4"><label htmlFor="furigana">ふりがな</label></td>
        <td className="border border-gray-300 p-2">
          <input
            type="text"
            id="furigana"
            name="furigana"
            value={form.furigana || ''}
            onChange={onChange}
            placeholder="ふりがなを入力"
            className="w-full border rounded-md p-2 focus:outline-none focus:ring focus:ring-blue-300"
          />
        </td>
      </tr>
      <tr>
        <td className="border border-gray-300 p-2 bg-gray-100"><label htmlFor="birthday">生年月日</label></td>
        <td className="border border-gray-300 p-2">
          <input
            type="date"
            id="birthday"
            name="birthday"
            value={form.birthday || ''}
            onChange={onChange}
            className="w-full border rounded-md p-2 focus:outline-none focus:ring focus:ring-blue-300"
          />
        </td>
        <td className="border border-gray-300 p-2 bg-gray-100"><label htmlFor="gender">性別</label></td>
        <td className="border border-gray-300 p-2">
          <select
            id="gender"
            name="gender"
            value={form.gender || ''}
            onChange={onChange}
            className="w-full border rounded-md p-2 focus:outline-none focus:ring focus:ring-blue-300"
          >
            <option value="">選択してください</option>
            <option value="male">男性</option>
            <option value="female">女性</option>
          </select>
        </td>
      </tr>
      <tr>
        <td className="border border-gray-300 p-2 bg-gray-100"><label htmlFor="address">住所</label></td>
        <td colSpan="3" className="border border-gray-300 p-2">
          <input
            type="text"
            id="address"
            name="address"
            value={form.address || ''}
            onChange={onChange}
            placeholder="住所を入力"
            className="w-full border rounded-md p-2 focus:outline-none focus:ring focus:ring-blue-300"
          />
        </td>
      </tr>
      <tr>
        <td className="border border-gray-300 p-2 bg-gray-100"><label htmlFor="phone">電話番号</label></td>
        <td className="border border-gray-300 p-2">
          <input
            type="tel"
            id="phone"
            name="phone"
            value={form.phone || ''}
            onChange={onChange}
            placeholder="電話番号を入力"
            className="w-full border rounded-md p-2 focus:outline-none focus:ring focus:ring-blue-300"
          />
        </td>
        <td className="border border-gray-300 p-2 bg-gray-100"><label htmlFor="email">メールアドレス</label></td>
        <td className="border border-gray-300 p-2">
          <input
            type="email"
            id="email"
            name="email"
            value={form.email || ''}
            onChange={onChange}
            placeholder="メールアドレスを入力"
            className="w-full border rounded-md p-2 focus:outline-none focus:ring focus:ring-blue-300"
          />
        </td>
      </tr>
    </tbody>
  </table>
);

export default ResumeBasicStep;
