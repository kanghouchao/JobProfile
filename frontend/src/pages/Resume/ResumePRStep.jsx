import React from 'react';

const ResumePRStep = ({ form, onChange }) => (
  <section className="mb-6">
    <h2 className="text-xl font-semibold text-gray-700 mb-4">自己PR</h2>
    <textarea
      name="pr"
      value={form.pr || ''}
      onChange={onChange}
      placeholder="例: 私の強みは..."
      rows="4"
      className="w-full border rounded-md p-2 focus:outline-none focus:ring focus:ring-blue-300"
    ></textarea>
  </section>
);

export default ResumePRStep;
