import axios from "axios";

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

export { joinUser };
