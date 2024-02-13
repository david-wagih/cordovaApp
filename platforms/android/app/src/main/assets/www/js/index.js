document.addEventListener("deviceready", onDeviceReady, false);

function onDeviceReady() {
  console.log("Running cordova-" + cordova.platformId + "@" + cordova.version);
  document.getElementById("deviceready").classList.add("ready");
}

function initSDK(fetchedToken) {
  const rootUrl = "https://api-uat.egy.network.global/sdk/v2";
  const cardIdentifierId = "FB1ABA5C-B58D-15BC-E054-00144FFA433E";
  const cardIdentifierType = "cardGUID";
  const bankCode = "MF3";

  const successCallback = function () {
    console.log("SDK initialized successfully");
  };

  const errorCallback = function (error) {
    console.error("Error initializing SDK: " + error);
  };

  MfNiWrapperPlugin.sdkInit(
    rootUrl,
    cardIdentifierId,
    cardIdentifierType,
    bankCode,
    fetchedToken,
    successCallback,
    errorCallback
  );
}

function setPinForm() {
  const successCallback = function (result) {
    console.log("Pin set successfully");
    console.log(result);
  };

  const errorCallback = function (error) {
    console.error("Error setting pin: " + error);
  };

  MfNiWrapperPlugin.setPinForm(successCallback, errorCallback);
}

// window.initSDK(
//   "eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICItNzBNYURtTkxYYW1OR294SGFLWjliM0V3TmdvQ1JOOW5HenlSSFZJN3ZjIn0.eyJleHAiOjE3MDU0MTM1ODksImlhdCI6MTcwNTQxMTc4OSwianRpIjoiYzNmMGZkMDQtMmFiNi00YWU5LTg5YWEtYWE1ODVmYWYwZjlhIiwiaXNzIjoiaHR0cHM6Ly9pZGVudGl0eS1ub25wcm9kLm5ldHdvcmsuZ2xvYmFsL2F1dGgvcmVhbG1zL05JLU5vblByb2QiLCJzdWIiOiI3M2Q5NDNhZi1mNjhjLTRjZTItOTM3OS02MjdjOTkzNDFhNzAiLCJ0eXAiOiJCZWFyZXIiLCJhenAiOiJjYmJiZmM2My01YzRmLTQ2ODgtOWFlNS03N2Y2YzExZDFkMjcxMDgzMTYiLCJzY29wZSI6InByb2ZpbGUgZW1haWwiLCJlbWFpbF92ZXJpZmllZCI6ZmFsc2UsImNsaWVudElkIjoiY2JiYmZjNjMtNWM0Zi00Njg4LTlhZTUtNzdmNmMxMWQxZDI3MTA4MzE2Iiwib3JnX2lkIjoiTUYzIiwicHJlZmVycmVkX3VzZXJuYW1lIjoic2VydmljZS1hY2NvdW50LWNiYmJmYzYzLTVjNGYtNDY4OC05YWU1LTc3ZjZjMTFkMWQyNzEwODMxNiJ9.oAeKtZAATi9hdu-fx3jNjFMVEOGSWDTHdKSxdYaVY_4ligvuX5eFnZDS1qanY1IbU6fYJ29Om7N4__qV98K2cyz_KVfoOgQSddRuoCekxzul3ssOr0s2I73i_qS6Nnew9w_whmiC2Ms2p3kyR80hqs1CD_5cPlOZhisP2TsgiqgX1YFwVhjqUDL_Z4J1ikOsQuXJfgtq80CMyzBccvS-_ngA5lVp9f9qKgL8E0PL7e0q7tLFIRcbgubq7yoKDBInwjjIuV9ouL8WPpZqReZ7j13jBI7-WY8FQWlNb6iH2KMeE_9e85XJP8Pps0H9S0bRhDiOL63cx9UwpSQh4MqxvQ"
// );
