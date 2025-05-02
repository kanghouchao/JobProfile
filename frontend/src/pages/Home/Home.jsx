import { useState, useRef } from 'react';
import { useNavigate } from 'react-router-dom';
import { useTranslation } from 'react-i18next';
import { FaMicrophone, FaFileImport, FaTrash } from 'react-icons/fa';
import createAiService from '@/services/ai';

export default function ChatGPTInterface() {
  const [input, setInput] = useState('');
  const [loading, setLoading] = useState(false);
  const navigate = useNavigate();
  const { t } = useTranslation('pages');
  const textareaRef = useRef(null);

  const handleSendMessage = async () => {
    if (!input.trim()) return;

    setLoading(true);
    try {
      const aiService = createAiService();
      const response = await aiService.generate(input);
      const jsonData = response.data;
      navigate('/resume', { state: { data: jsonData } });
    } catch (error) {
      console.error('Error generating data:', error);
    } finally {
      setLoading(false);
    }
  };

  const handleInputChange = e => {
    setInput(e.target.value);
    const textarea = textareaRef.current;
    textarea.style.height = 'auto';
    textarea.style.height = `${Math.min(textarea.scrollHeight, 300)}px`;
  };

  const handleClearInput = () => {
    setInput('');
    if (textareaRef.current) {
      textareaRef.current.style.height = 'auto';
    }
  };

  return (
    <div className="min-h-screen bg-gray-50 py-8">
      <div className="max-w-4xl mx-auto px-4">
        {/* ステップインジケーター */}
        <div className="flex items-center justify-center mb-12">
          <div className="flex items-center">
            <div className="bg-purple-600 rounded-full h-10 w-10 flex items-center justify-center text-white font-semibold">
              1
            </div>
            <div className="ml-3 text-gray-900 font-medium">
              {t('ai.steps.personalInfo')}
              <div className="text-sm text-gray-500">{t('ai.steps.basicInfo')}</div>
            </div>
          </div>
          <div className="h-1 w-16 bg-gray-200 mx-4" />
          <div className="flex items-center opacity-50">
            <div className="bg-gray-200 rounded-full h-10 w-10 flex items-center justify-center text-gray-600 font-semibold">
              2
            </div>
            <div className="ml-3 text-gray-400 font-medium">{t('ai.steps.finalResume')}</div>
          </div>
        </div>

        {/* メインコンテンツ */}
        <div className="bg-white rounded-2xl shadow-sm border border-gray-200 p-8">
          <h1 className="text-2xl font-semibold text-gray-900 mb-4">{t('ai.chat.title')}</h1>
          <p className="text-gray-600 mb-6">{t('ai.chat.instruction')}</p>

          <div className="relative">
            <textarea
              ref={textareaRef}
              className="w-full min-h-[200px] p-4 border border-gray-200 rounded-xl
                       text-gray-800 resize-none focus:ring-2 focus:ring-purple-500
                       focus:border-transparent outline-none"
              placeholder={t('ai.chat.placeholder')}
              value={input}
              onChange={handleInputChange}
              rows={1}
            />
            <div className="flex items-center space-x-3 absolute bottom-4 left-4">
              <button
                title={t('ai.chat.voice')}
                className="p-2 text-gray-500 hover:text-purple-600 transition-colors"
              >
                <FaMicrophone size={20} />
              </button>
              <button
                title={t('ai.chat.import')}
                className="p-2 text-gray-500 hover:text-purple-600 transition-colors"
              >
                <FaFileImport size={20} />
              </button>
              <button
                title={t('ai.chat.clear')}
                onClick={handleClearInput}
                className="p-2 text-gray-500 hover:text-purple-600 transition-colors"
              >
                <FaTrash size={20} />
              </button>
            </div>
          </div>

          <div className="flex justify-between mt-6">
            <button
              onClick={() => {}}
              className="px-6 py-2 border border-gray-200 rounded-lg
                       text-gray-600 hover:bg-gray-50 transition-colors"
            >
              {t('ai.chat.save')}
            </button>
            <button
              onClick={handleSendMessage}
              disabled={loading}
              className={`px-6 py-2 rounded-lg text-white font-medium
                        transition-all transform hover:scale-105
                        ${
                          loading
                            ? 'bg-gray-400 cursor-not-allowed'
                            : 'bg-purple-600 hover:bg-purple-700 active:scale-95'
                        }`}
            >
              {loading ? t('ai.chat.generating') : t('ai.chat.continue')}
            </button>
          </div>
        </div>
      </div>
    </div>
  );
}
