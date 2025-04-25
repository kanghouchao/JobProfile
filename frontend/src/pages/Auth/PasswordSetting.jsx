import React, { useState } from "react";
import { useNavigate, useLocation } from "react-router-dom";
import { useTranslation } from "react-i18next";
import authService from "@/services/auth";
import { toast } from "react-toastify";

const PasswordSetting = () => {
  const { t } = useTranslation("auth");
  const navigate = useNavigate();
  const location = useLocation();
  const searchParams = new URLSearchParams(location.search);
  const email = searchParams.get("email");
  const token = searchParams.get("token");

  const [password, setPassword] = useState("");
  const [confirmPassword, setConfirmPassword] = useState("");
  const [isLoading, setIsLoading] = useState(false);

  // パスワード設定フォームの送信処理
  const handleSubmit = async (e) => {
    e.preventDefault();

    if (!password || !confirmPassword) {
      toast.error(t("passwordSetting.allFieldsRequired"));
      return;
    }

    if (password !== confirmPassword) {
      toast.error(t("passwordSetting.passwordsMismatch"));
      return;
    }

    if (password.length < 8) {
      toast.error(t("passwordSetting.passwordTooShort"));
      return;
    }

    setIsLoading(true);
    try {
      await authService.completeRegistration(email, token, password);
      toast.success(t("passwordSetting.success"));
      navigate("/login");
    } catch (error) {
      toast.error(error.response?.data?.message || t("passwordSetting.error"));
    } finally {
      setIsLoading(false);
    }
  };

  // トークンまたはメールアドレスが無効な場合のエラー表示
  if (!email || !token) {
    return (
      <div className="flex h-screen items-center justify-center">
        <div className="text-center">
          <h2 className="text-2xl font-semibold text-red-600 mb-4">
            {t("passwordSetting.invalidLink")}
          </h2>
          <p className="text-gray-600">
            {t("passwordSetting.invalidLinkDesc")}
          </p>
        </div>
      </div>
    );
  }

  return (
    <div className="flex h-screen">
      {/* 左側：背景画像 */}
      <div
        className="hidden md:flex flex-1 bg-cover bg-center"
        style={{ backgroundImage: "url('/images/auth-bg.png')" }}
      ></div>

      {/* 右側：パスワード設定フォーム */}
      <div className="w-full md:w-1/2 flex flex-col justify-center items-center p-6 md:p-12">
        <h2 className="text-3xl font-semibold mb-6">
          {t("passwordSetting.title")}
        </h2>
        <p className="text-gray-500 mb-8">{t("passwordSetting.subtitle")}</p>

        <form onSubmit={handleSubmit} className="w-full max-w-sm space-y-4">
          <div>
            <label className="block text-sm font-medium text-gray-700 mb-1">
              {t("passwordSetting.password")}
            </label>
            <input
              type="password"
              name="password"
              required
              autoComplete="new-password"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
              disabled={isLoading}
              className="w-full p-3 border border-gray-300 rounded-lg focus:ring-2 focus:ring-blue-500 focus:outline-none disabled:bg-gray-100"
              placeholder={t("passwordSetting.passwordPlaceholder")}
            />
          </div>

          <div>
            <label className="block text-sm font-medium text-gray-700 mb-1">
              {t("passwordSetting.confirmPassword")}
            </label>
            <input
              type="password"
              name="confirmPassword"
              required
              autoComplete="new-password"
              value={confirmPassword}
              onChange={(e) => setConfirmPassword(e.target.value)}
              disabled={isLoading}
              className="w-full p-3 border border-gray-300 rounded-lg focus:ring-2 focus:ring-blue-500 focus:outline-none disabled:bg-gray-100"
              placeholder={t("passwordSetting.confirmPasswordPlaceholder")}
            />
          </div>

          <button
            type="submit"
            disabled={isLoading}
            className="w-full bg-blue-600 text-white p-3 rounded-lg hover:bg-blue-700 transition disabled:bg-blue-400"
          >
            {isLoading
              ? t("passwordSetting.submitting")
              : t("passwordSetting.submit")}
          </button>
        </form>
      </div>
    </div>
  );
};

export default PasswordSetting;
