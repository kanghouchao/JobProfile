import { useState, useRef } from "react";
import { useNavigate } from "react-router-dom";
import { useTranslation } from "react-i18next";
import aiService from "@/services/ai";

export default function ChatGPTInterface() {
  const [input, setInput] = useState("");
  const [loading, setLoading] = useState(false);
  const navigate = useNavigate();
  const { t } = useTranslation("pages");
  const textareaRef = useRef(null);

  const handleSendMessage = async () => {
    if (!input.trim()) return;

    setLoading(true);
    try {
      const response = await aiService.generate(input);
      const jsonData = response.data;

      navigate("/resume", { state: { data: jsonData } });
    } catch (error) {
      console.error("Error generating data:", error);
    } finally {
      setLoading(false);
    }
  };

  const handleInputChange = (e) => {
    setInput(e.target.value);

    const textarea = textareaRef.current;
    textarea.style.height = "auto";
    textarea.style.height = `${Math.min(textarea.scrollHeight, 160)}px`;
  };

  return (
    <div className="h-screen bg-white flex flex-col items-center justify-center">
      <h1 className="text-2xl font-bold text-gray-800 mb-6">
        {t("chat.enterMessage")}
      </h1>

      <div className="w-[130%] max-w-lg bg-white p-6 rounded-3xl shadow-lg border border-gray-300">
        <textarea
          ref={textareaRef}
          className="w-full p-4 rounded-3xl bg-white outline-none resize-none overflow-y-auto"
          placeholder={t("chat.placeholder")}
          value={input}
          onChange={handleInputChange}
          onKeyDown={(e) => {
            if (e.key === "Enter" && !loading && !e.shiftKey) {
              e.preventDefault();
              handleSendMessage();
            }
          }}
          rows={1}
          style={{ maxHeight: "10rem" }}
        />
      </div>

      <button
        onClick={handleSendMessage}
        disabled={loading}
        className={`mt-4 px-6 py-3 rounded-lg text-white ${
          loading ? "bg-gray-400" : "bg-blue-600 hover:bg-blue-700"
        }`}
      >
        {loading ? t("chat.loading") : t("chat.submit")}
      </button>
    </div>
  );
}
