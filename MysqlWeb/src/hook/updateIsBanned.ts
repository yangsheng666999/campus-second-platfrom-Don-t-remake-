import { UpdateIsBanned,type updateUserBanned } from "@/api";
import { ElMessage } from "element-plus";

async function updateIsBanned(message: updateUserBanned) {
  try {
    const response = await UpdateIsBanned(message)
    if (response.status === 200) {
      if(response.data.data === 1) {
        ElMessage.success('封禁成功')
      }else if(response.data.data === 0){
        ElMessage.success('解封成功')
      }
      else {

        ElMessage.error('封禁失败')
      }
    }
  } catch {
    ElMessage.error('系统错误')
  }
}

export { updateIsBanned}
