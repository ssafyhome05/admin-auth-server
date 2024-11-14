import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'

// https://vite.dev/config/
export default defineConfig({
  transpileDependencies: true,
  devServer: {
    proxy: 'http://localhost:9000'
  },
  plugins: [vue()],
  build: {
    outDir: '../resources/static',
    emptyOutDir: true
  }
})