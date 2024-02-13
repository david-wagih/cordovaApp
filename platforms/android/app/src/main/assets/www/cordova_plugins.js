cordova.define('cordova/plugin_list', function(require, exports, module) {
  module.exports = [
    {
      "id": "mf-ni-wrapper.plugin",
      "file": "plugins/mf-ni-wrapper/www/plugin.js",
      "pluginId": "mf-ni-wrapper",
      "clobbers": [
        "MfNiWrapperPlugin"
      ],
      "runs": true
    }
  ];
  module.exports.metadata = {
    "mf-ni-wrapper": "1.0.0"
  };
});