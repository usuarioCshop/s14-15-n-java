/** @type {import('tailwindcss').Config} */
const { nextui } = require('@nextui-org/react');
module.exports = {
  content: [
    './src/pages/**/*.{js,ts,jsx,tsx,mdx}',
    './src/components/**/*.{js,ts,jsx,tsx,mdx}',
    './src/app/**/*.{js,ts,jsx,tsx,mdx}',
    './node_modules/@nextui-org/theme/dist/**/*.{js,ts,jsx,tsx}',
  ],
  theme: {
    extend: {
      backgroundImage: {
        'gradient-radial': 'radial-gradient(var(--tw-gradient-stops))',
        'gradient-conic':
          'conic-gradient(from 180deg at 50% 50%, var(--tw-gradient-stops))',
      },
      blur: {
        '4xl': '72px',
        '5xl': '84px',
      },
      colors: {
        "default": {
          "900": "#18181b",
          "800": "#27272a",
          "700": "#3f3f46",
          "600": "#52525b",
          "500": "#71717a",
          "400": "#a1a1aa",
          "300": "#d4d4d8",
          "200": "#e4e4e7",
          "100": "#f4f4f5",
          "50": "#fafafa",
        },
        "secondary": {
          "900": "#180828",
          "800": "#301050",
          "700": "#481878",
          "600": "#6020a0",
          "500": "#7828c8",
          "400": "#9353d3",
          "300": "#ae7ede",
          "200": "#c9a9e9",
          "100": "#e4d4f4",
          "50": "#f2eafa",
        }
      }
    },
  },
  darkMode: 'class',
  plugins: [],
  plugins: [nextui()],
};
