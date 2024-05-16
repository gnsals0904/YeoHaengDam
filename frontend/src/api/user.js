import axios from "axios";
import { localAxios } from "@/util/http-commons";

const local = localAxios();

// 회원 가입
async function joinUser(user) {
  try {
    console.log(user);
    const response = await axios.post(
      "http://localhost:8080/api/users/join",
      user
    );
    return response.data;
  } catch (error) {
    console.error("회원가입 에러:", error);
    if (error.response) {
      return error.response.data;
    }
    return { error: "회원가입 요청 중 문제가 발생했습니다." };
  }
}
/** jwt section */
/** jwt login */
async function userConfirm(param, success, fail) {
  console.log(param);
  await local.post(`/api/auth/login`, param).then(success).catch(fail);
}

/** user email 로 user info 를 모두 가져온다 */
async function findByEmail(email, success, fail) {
  local.defaults.headers["Authorization"] =
    sessionStorage.getItem("accessToken");
  await local.get(`/api/users/myInfo/`, email).then(success).catch(fail);
}

async function tokenRegeneration(user, success, fail) {
  local.defaults.headers["refreshToken"] =
    sessionStorage.getItem("refreshToken"); //axios header에 refresh-token 셋팅
  await local.post(`/api/auth/refresh`, user).then(success).catch(fail);
}

async function logout(userid, success, fail) {
  await local.get(`/user/logout/${userid}`).then(success).catch(fail);
}

export { joinUser, userConfirm, findByEmail, tokenRegeneration, logout };
