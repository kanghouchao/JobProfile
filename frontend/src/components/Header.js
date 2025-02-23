import React from 'react';
import { useTranslation } from "react-i18next";

const Header = () => {
  const { t } = useTranslation("components");
  return (
    <header className="bg-white shadow p-4 flex items-center justify-between">
      <h2 className="text-xl font-bold">{t("welcome")}</h2>
      <button className="bg-blue-500 text-white px-4 py-2 rounded hover:bg-blue-600">
        {t("message")}
      </button>
    </header>
  );
};

export default Header;