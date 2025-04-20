import { useState, useRef } from "react";
import { useNavigate } from "react-router-dom";
import { useTranslation } from "react-i18next";

export default function ChatGPTInterface() {
  const [input, setInput] = useState("");
  const [loading, setLoading] = useState(false);
  const navigate = useNavigate();
  const { t } = useTranslation("pages");
  const textareaRef = useRef(null);

  const handleSendMessage = async () => {
    if (!input.trim()) return;

    setLoading(true);

    setTimeout(() => {
      const aiResponse = {
        name: "山田 太郎",
        age: 30,
        skills: ["JavaScript", "React", "Node.js"],
        experience: "5年のソフトウェア开发经验",
      };

      navigate("/result", { state: { data: aiResponse } });
      setLoading(false);
    }, 1500);
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
    </div>
  );
}
