module.exports = {
  devServer: {
    proxy: 'http://localhost:9000'
  },
  publicPath: '/public/',
  outputDir: '../backend/public',
  assetsDir: '.',
  indexPath: 'index.html'
}
// const webpack = require('webpack')
// const httpPath = process.env.VUE_APP_HTTP_PATH
// const development = process.env.NODE_ENV === 'development'

// module.exports = {
//   outputDir: '../backend/public/app',
//   indexPath: './index.html',
//   baseUrl: development ? '/' : httpPath + '/app',
//   runtimeCompiler: true,
//   // configure webpack-dev-server behavior

//   devServer: {
//     open: process.platform === 'darwin',
//     host: '0.0.0.0',
//     port: 8080,
//     https: false,
//     hotOnly: false,
//     proxy: {
//       [httpPath]: {
//         target: 'http://localhost:9000/',
//         changeOrigin: false
//       }
//     }
//   },

//   configureWebpack: {
//     plugins: [
//       new webpack.ProvidePlugin({
//         '$': 'jquery',
//         jQuery: 'jquery',
//         Popper: ['popper.js', 'default'],
//         '_': 'lodash'
//       })
//     ]
//   }
// }
