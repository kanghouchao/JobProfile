import i18n from 'i18next';
import { initReactI18next } from 'react-i18next';
import LanguageDetector from 'i18next-browser-languagedetector';

const resources = {
    en: {
        components: require('@/locales/en/Components.json'),
        pages: require('@/locales/en/Pages.json'),
        auth: require('@/locales/en/Auth.json'),
    },
    zh: {
        components: require('@/locales/zh/Components.json'),
        pages: require('@/locales/zh/Pages.json'),
        auth: require('@/locales/zh/Auth.json'),
    },
    ja: {
        components: require('@/locales/ja/Components.json'),
        pages: require('@/locales/ja/Pages.json'),
        auth: require('@/locales/ja/Auth.json'),
    },
};

i18n.use(LanguageDetector)
    .use(initReactI18next)
    .init({
        resources,
        backend: {
            loadPath: '@/locales/{{lng}}/{{ns}}.json',
        },
        preload: ['ja'],
        fallbackLng: 'ja',
        debug: false,
        interpolation: { escapeValue: false },
        detection: {
            order: ['localStorage', 'navigator'],
            caches: ['localStorage'],
        },
        ns: ['components', 'pages', 'auth'],
        defaultNS: 'auth',
    });

export default i18n;
