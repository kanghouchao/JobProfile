const path = require('path');

module.exports = {
    webpack: {
        alias: {
            '@': path.resolve(__dirname, 'src'),
        },
    },
    eslint: {
        enable: true,
        mode: 'extends',
        configure: {
            extends: ['react-app', 'react-app/jest'],
        },
    },
    babel: {
        presets: [
            ['@babel/preset-env', { targets: { node: 'current' } }],
            ['@babel/preset-react', { runtime: 'automatic' }],
        ],
        plugins: ['@babel/plugin-transform-runtime'],
    },
    style: {
        postcss: {
            plugins: {
                tailwindcss: {},
                autoprefixer: {},
            },
        },
    },
    jest: {
        configure: {
            moduleNameMapper: {
                '^@/(.*)$': '<rootDir>/src/$1',
            },
            transform: {
                '^.+\\.(js|jsx)$': 'babel-jest',
            },
            testEnvironment: 'jsdom',
        },
    },
};
