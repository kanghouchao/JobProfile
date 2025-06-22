import React from 'react';

const ResumeLicenseStep = ({ form, onChange }) => (
  <section className="mb-6">
    <h2 className="text-xl font-semibold text-gray-700 mb-4">免許・資格</h2>
    <textarea
      name="license"
      value={form.license || ''}
      onChange={onChange}
      placeholder="例: 2023年7月 普通自動車免許取得"
      rows="3"
      className="w-full border rounded-md p-2 focus:outline-none focus:ring focus:ring-blue-300"
    ></textarea>
  </section>
);

export default ResumeLicenseStep;
