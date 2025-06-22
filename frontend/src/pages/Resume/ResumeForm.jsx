import React, { useState, useCallback } from 'react';
import { useNavigate, useLocation, Link } from 'react-router-dom';
import ResumeBasicStep from './ResumeBasicStep';
import ResumeHistoryStep from './ResumeHistoryStep';
import ResumeLicenseStep from './ResumeLicenseStep';
import ResumePRStep from './ResumePRStep';

const steps = [
  { label: '基本情報', key: 'basic' },
  { label: '学歴・職歴', key: 'history' },
  { label: '免許・資格', key: 'license' },
  { label: '自己PR', key: 'pr' },
];

const stepKeyToIndex = steps.reduce((acc, s, i) => { acc[s.key] = i; return acc; }, {});

const ResumeForm = () => {
  const navigate = useNavigate();
  const location = useLocation();
  const currentStepKey = location.pathname.split('/').pop();
  const validStepKeys = new Set(steps.map((s) => s.key));
  const [form, setForm] = useState({});
  const step = validStepKeys.has(currentStepKey) ? stepKeyToIndex[currentStepKey] : 0;

  const onChange = useCallback((e) => {
    const { name, value } = e.target;
    setForm((prev) => ({ ...prev, [name]: value }));
  }, []);

  const goStep = (idx) => navigate(`/resume/${steps[idx].key}`);
  const nextStep = () => goStep(Math.min(step + 1, steps.length - 1));
  const prevStep = () => goStep(Math.max(step - 1, 0));

  const handleCancel = () => {
    // 清空表单数据并返回首页
    setForm({});
    navigate('/');
  };

  const handleSave = () => {
    // 保存表单数据的逻辑
    console.log('保存履歴書データ:', form);
    // TODO: 实际保存到后端API
    alert('履歴書が保存されました！');
  };

  // AI对话相关
  const [aiInput, setAiInput] = useState('');
  const [aiMessages, setAiMessages] = useState([
    { role: 'ai', text: 'こんにちは！履歴書作成をお手伝いします。ご質問やご要望をどうぞ。' }
  ]);
  const handleAiSend = () => {
    if (!aiInput.trim()) return;
    setAiMessages((msgs) => [
      ...msgs,
      { role: 'user', text: aiInput }
    ]);
    setTimeout(() => {
      setAiMessages((msgs) => [
        ...msgs,
        { role: 'ai', text: '（AIのサンプル応答）: ' + aiInput }
      ]);
    }, 600);
    setAiInput('');
  };

  return (
    <div className="w-full h-full bg-white flex">
      {/* 左：AI对话 */}
      <div className="w-[30%] border-r border-gray-200 p-4 flex flex-col">
        <h2 className="text-xl font-bold text-blue-600 mb-2">AIアシスタント</h2>
        <div className="flex-1 overflow-y-auto bg-gray-50 rounded p-2 mb-2 space-y-2">
          {aiMessages.map((msg, i) => (
            <div key={i} className={`flex ${msg.role === 'user' ? 'justify-end' : 'justify-start'}`}>
              <div className={`px-3 py-2 rounded-lg text-sm max-w-[80%] ${msg.role === 'user' ? 'bg-blue-100 text-blue-900' : 'bg-gray-200 text-gray-700'}`}>
                {msg.text}
              </div>
            </div>
          ))}
        </div>
        <div className="flex gap-2">
          <input
            className="flex-1 border rounded-md p-2 focus:outline-none focus:ring focus:ring-blue-300"
            value={aiInput}
            onChange={e => setAiInput(e.target.value)}
            onKeyDown={e => { if (e.key === 'Enter' && !e.shiftKey) { e.preventDefault(); handleAiSend(); } }}
            placeholder="AIに質問・依頼..."
          />
          <button
            className="bg-blue-500 text-white px-4 py-2 rounded-md hover:bg-blue-600"
            onClick={handleAiSend}
          >送信</button>
        </div>
      </div>
      {/* 右：履歴書フォーム */}
      <div className="w-[70%] p-4 flex flex-col">
        <h1 className="text-2xl font-bold text-gray-800 mb-6">履歴書</h1>
        {/* ステップインジケーター */}
        <div className="flex items-center mb-8">
          {steps.map((s, idx) => (
            <React.Fragment key={s.key}>
              <Link
                to={`/resume/${s.key}`}
                className={`flex items-center cursor-pointer ${idx === step ? 'text-blue-600 font-bold underline' : 'text-gray-400 hover:text-blue-400'}`}
              >
                {s.label}
              </Link>
              {idx < steps.length - 1 && (
                <div className="flex-1 h-0.5 bg-gray-200 mx-2" />
              )}
            </React.Fragment>
          ))}
        </div>
        <div className="flex-1 overflow-y-auto">
          {step === 0 && <ResumeBasicStep form={form} onChange={onChange} />}
          {step === 1 && <ResumeHistoryStep form={form} onChange={onChange} />}
          {step === 2 && <ResumeLicenseStep form={form} onChange={onChange} />}
          {step === 3 && <ResumePRStep form={form} onChange={onChange} />}
        </div>
        <div className="flex justify-between gap-4 mt-8">
          <button
            className="bg-gray-300 text-gray-700 px-4 py-2 rounded-md hover:bg-gray-400"
            onClick={prevStep}
            disabled={step === 0}
          >
            戻る
          </button>
          <div className="flex gap-4">
            <button
              className="bg-gray-300 text-gray-700 px-4 py-2 rounded-md hover:bg-gray-400"
              onClick={handleCancel}
            >
              キャンセル
            </button>
            {step < steps.length - 1 ? (
              <button
                className="bg-blue-500 text-white px-4 py-2 rounded-md hover:bg-blue-600"
                onClick={nextStep}
              >
                次へ
              </button>
            ) : (
              <button
                className="bg-blue-500 text-white px-4 py-2 rounded-md hover:bg-blue-600"
                onClick={handleSave}
              >
                保存
              </button>
            )}
          </div>
        </div>
      </div>
    </div>
  );
};

export default ResumeForm;
